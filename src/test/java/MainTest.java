import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    JSONArray jsonData;

    @BeforeEach
    public void setup() {
        String json = """
            {
              "edificios": [
                {
                  "nombre": "Pabellon E",
                  "ubicacion": [5.0, 10.0],
                  "salas": [
                    {"nombre": "E-101", "piso": 1},
                    {"nombre": "E-102", "piso": 1},
                    {"nombre": "E-201", "piso": 2}
                  ]
                },
                {
                  "nombre": "Pabellon D",
                  "ubicacion": [2.0, 6.0],
                  "salas": [
                    {"nombre": "D-101", "piso": 1},
                    {"nombre": "D-102", "piso": 1},
                    {"nombre": "D-201", "piso": 2}
                  ]
                }
              ]
            }
        """;
        JSONObject obj = new JSONObject(json);
        jsonData = obj.getJSONArray("edificios");

        getPrivateStatic("edificios").clear();
        getPrivateStatic("listadeSalas").clear();

        try {
            Method cargarData = Main.class.getDeclaredMethod("cargarData", JSONArray.class);
            cargarData.setAccessible(true);
            cargarData.invoke(null, jsonData);
        } catch (Exception e) {
            fail("Error al invocar cargarData: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private ArrayList<String[]> getPrivateStatic(String fieldName) {
        try {
            var field = Main.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (ArrayList<String[]>) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // --- Tests unitarios con una sola aserción cada uno ---

    @Test
    public void testCantidadDeEdificiosEsDos() {
        assertEquals(2, getPrivateStatic("edificios").size());
    }

    @Test
    public void testPrimerNombreDeEdificioEsPabellonE() {
        assertEquals("Pabellon E", getPrivateStatic("edificios").getFirst()[0]);
    }

    @Test
    public void testCantidadTotalDeSalasEsSeis() {
        assertEquals(6, getPrivateStatic("listadeSalas").size());
    }

    @Test
    public void testNombrePrimeraSalaEsE101() {
        assertEquals("E-101", getPrivateStatic("listadeSalas").getFirst()[0]);
    }

    @Test
    public void testSalaPerteneceAPabellonE() {
        assertEquals("Pabellon E", getPrivateStatic("listadeSalas").getFirst()[2]);
    }

    @Test
    public void testUbicacionPabellonDDevuelveUno() {
        int index = Main.ubicacionenArray(getPrivateStatic("edificios"), "Pabellon D");
        assertEquals(1, index);
    }

    @Test
    public void testUbicacionInexistenteDevuelveMenosUno() {
        int index = Main.ubicacionenArray(getPrivateStatic("edificios"), "NoExiste");
        assertEquals(-1, index);
    }

    @Test
    public void testAngulo45Grados() {
        double[] eje = {1.0, 1.0};
        assertEquals(45.0, Main.anguloEntrePuntos(eje), 0.01);
    }

    @Test
    public void testDistanciaEs5() {
        double[] eje = {9.0, 16.0};  // √(9+16) = √25 = 5
        assertEquals(5.0, Main.distanciaEntreDosPuntos(eje), 0.01);
    }

    @Test
    public void testUbicacionSalaE201() {
        int index = Main.ubicacionenArray(getPrivateStatic("listadeSalas"), "E-201");
        assertTrue(index >= 0);
    }

}
