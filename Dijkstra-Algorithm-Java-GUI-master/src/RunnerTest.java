import java.util.ArrayList;
import java.util.List;

public class RunnerTest {
    public static void main(String[] args) {
        String a0 = "src/data/data.txt";
        String a1 = "Aa";
        String a2 = "Bb";

        Grafo teste = new Grafo();
        teste.setVertices(LerDoArquivo.lerGrafo(a0));
        Vertice i1 = new Vertice();
        Vertice i2 = new Vertice();
        i1 = teste.encontrarVertice(a1);
        i2 = teste.encontrarVertice(a2);

        List<Vertice> resultado = new ArrayList<Vertice>();
        Dijkstra algoritmo = new Dijkstra();
        resultado = algoritmo.encontrarMenorCaminhoDijkstra(teste, i1, i2);
        System.out.println("O menor caminho é:" + resultado);
    }
}
