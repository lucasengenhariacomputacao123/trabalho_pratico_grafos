import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LerDoArquivo {

	public static List<Vertice> lerGrafo(String nomeArquivo) {

		Grafo g = new Grafo();
		Vertice v;
		File f = new File(nomeArquivo);
		String vertices[];
		String line;
		ArrayList<String[]> verticesString = new ArrayList<String[]>();

		/*
		 * try {
		 * BufferedReader reader = new BufferedReader(new
		 * FileReader("src/data/data.txt"));
		 * int lines = 0;
		 * while (reader.readLine() != null) {
		 * lines++;
		 * }
		 * reader.reset();
		 * 
		 * S
		 * 3
		 * Aa
		 * Bb
		 * Cc
		 * Aa, Bb, 3
		 * Aa, Cc, 5
		 */
		/*
		 * String line = reader.readLine();
		 * String isDirected = line;
		 * line = reader.readLine();
		 * 
		 * int numberOfVertex = Integer.parseInt(line);
		 * line = reader.readLine();
		 * List<Vertice> vertices = new ArrayList<Vertice>();
		 * List<Aresta> arestas = new ArrayList<Aresta>();
		 * for (int i = 0; i < numberOfVertex; i++) {
		 * Vertice vertice = new Vertice(line);
		 * vertices.add(vertice);
		 * line = reader.readLine();
		 * }
		 * 
		 * for (int j = numberOfVertex + 2; j < lines; j++) {
		 * if (line.contains(",")) {
		 * String verticeXSplit = line.trim().split(",")[0];
		 * Vertice verticeX = new Vertice(verticeXSplit);
		 * List<Vertice> vizinhos = new ArrayList<Vertice>();
		 * 
		 * for(Vertice _vertice : vertices){
		 * if(_vertice.getNomeVertice() == verticeXSplit){
		 * verticeX = _vertice;
		 * }
		 * }
		 * 
		 * String verticeYSplit = line.trim().split(",")[1];
		 * Vertice verticeY = new Vertice(verticeYSplit);
		 * for(Vertice _vertice : vertices){
		 * if(_vertice.getNomeVertice() == verticeYSplit){
		 * verticeY = _vertice;
		 * 
		 * vizinhos.add(verticeY);
		 * verticeX.setVizinhos(vizinhos);
		 * }
		 * }
		 * 
		 * Aresta aresta = new Aresta(verticeX, verticeY);
		 * aresta.setPeso(Integer.parseInt(line.trim().split(",")[2]));
		 * }
		 * }
		 * 
		 * reader.close();
		 * 
		 * //---//
		 * 
		 * List<Vertice> vizinhosAtual = new ArrayList<Vertice>();
		 * List<Aresta> arestasAtual = new ArrayList<Aresta>();
		 * 
		 * } catch (IOException e) {
		 * e.printStackTrace();
		 * }
		 */

		// Do mano

		/*
		 * v1,v4,v3,v5,v2/7,4,5,1
		 * v2,v4/10
		 * v3,v5/2
		 * v4
		 * v5,v4/1
		 */
		/*
		 * S
		 * 3
		 * Aa
		 * Bb
		 * Cc
		 * Aa, Bb, 3
		 * Aa, Cc, 5
		 */

		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));

			Map<String, Vertice> mapa = new HashMap<String, Vertice>();
			String isDirecionada = reader.readLine();
			String qtdVertices = reader.readLine();

			List<Vertice> listaVertices = new ArrayList<Vertice>();
			line = reader.readLine();
			while (!line.contains(",")) {
				Vertice vertice = new Vertice();
				vertice.setNomeVertice(line);
				listaVertices.add(vertice);

				line = reader.readLine();
			}

			String tempVertice = "";
			while (line != null) {

				// arestas
				if (line.contains(",")) {
					String vert1 = line.split(",")[0].trim();
					String vert2 = line.split(",")[1].trim();
					String[] _vertices = {vert1, vert2};

					tempVertice = vert1;
					verticesString.add(_vertices);

					vertices = _vertices;

					v = (Vertice) mapa.get(vertices[0]);
					if (v == null)
						v = new Vertice();

					List<Vertice> vizinhosAtual = new ArrayList<Vertice>();
					List<Aresta> arestasAtual = new ArrayList<Aresta>();
					v.setNomeVertice(vertices[0]);
					mapa.put(vertices[0], v);

					// peso

					String pesoArestas[] = {line.split(",")[2].trim()};

					Vertice vit;
					vit = mapa.get(vertices[1]);	
					if (vit == null)
							vit = new Vertice();

					vit.setNomeVertice(vertices[1]);
					vizinhosAtual.add(vit);
					System.out.println("ZZZZZZZZZ " + vertices[1]);
					mapa.put(vertices[1], vit);

					Aresta ait = new Aresta(v, vit);
					System.out.println("Peso " + pesoArestas[0]);
					ait.setPeso(Integer.parseInt(pesoArestas[0]));
					arestasAtual.add(ait);

					v.setVizinhos(vizinhosAtual);
					v.setArestas(arestasAtual);

					/*
					for (int i = 1; i <= vertices.length; i++) {
						Vertice vit;
						// vit = g.encontrarVertice(vertices[i]);
						vit = mapa.get(vertices[i]);
						if (vit == null)
							vit = new Vertice();
						vit.setNomeVertice(vertices[i]);
						vizinhosAtual.add(vit);
						mapa.put(vertices[i], vit);

						Aresta ait = new Aresta(v, vit);
						ait.setPeso(Integer.parseInt(pesoArestas[i]));
						arestasAtual.add(ait);

					}
					v.setVizinhos(vizinhosAtual);
					v.setArestas(arestasAtual);
					*/
				}

				// Vertices finais
				else {

					// v = g.encontrarVertice(linha);
					v = (Vertice) mapa.get(line);
					if (v == null)
						v = new Vertice();
					v.setNomeVertice(line);
					mapa.put(line, v);

				}

				line = reader.readLine();
				g.adicionarVertice(v);
				verticesString.clear();
			}
			reader.close();

			// catch do BufferedReader
		} catch (FileNotFoundException e) {
			System.out.println("Nao encontrou o arquivo");
			e.printStackTrace();
		}
		// catch do readLine
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Retornando os vertices
		return g.getVertices();
	}

	public static void main(String args[]) {

		Grafo teste = new Grafo();

		teste.setVertices(lerGrafo(args[0]));
		Vertice i1 = new Vertice();
		Vertice i2 = new Vertice();
		i1 = teste.encontrarVertice(args[1]);
		i2 = teste.encontrarVertice(args[2]);

		List<Vertice> resultado = new ArrayList<Vertice>();
		Dijkstra algoritmo = new Dijkstra();
		resultado = algoritmo.encontrarMenorCaminhoDijkstra(teste, i1, i2);

		System.out.println("O menor caminho é:"
				+ resultado);
	}

}