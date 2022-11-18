package data;

import java.util.ArrayList;

public class testeABC {
    public static void main(String[] args) {
        String[] abc = {"A", "B"};
        String[] vertices;
        ArrayList<String[]> verticesString = new ArrayList<String[]>();
        verticesString.add(abc);
        vertices = verticesString.get(0);
        System.out.println(vertices[0]);
        System.out.println(vertices[1]);
    }
}
