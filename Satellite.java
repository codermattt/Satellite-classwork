package org.example;


import java.io.*;
import java.util.*;

public class Satellite {

    static int[][] oldImage;
    static int[][] newImage;
    static int noOfRows, noOfCols;

    public static void main(String[] args) {
        try {
            // {read from input.txt}
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Mathew.DESKTOP-1SJQ6P4\\IdeaProjects\\satellite\\src\\main\\java\\org\\example\\input.txt"));
            noOfRows = Integer.parseInt(reader.readLine().trim());
            noOfCols = Integer.parseInt(reader.readLine().trim());

            oldImage = new int[noOfRows][noOfCols];
            newImage = new int[noOfRows][noOfCols];


            // read old image
            readImage(reader, oldImage);
            // read new image
            readImage(reader, newImage);

            reader.close();

            // {determine upper corner}
            int x1 = 0;
            while (x1 < noOfRows && compareLine(x1, true)) x1++;

            int y1 = 0;
            while (y1 < noOfCols && compareLine(y1, false)) y1++;

            // determine lower corner
            int x2 = noOfRows - 1;
            while (x2 >= 0 && compareLine(x2, true)) x2--;

            int y2 = noOfCols - 1;
            while (y2 >= 0 && compareLine(y2, false)) y2--;

            // {output}
            if (x1 > x2 || y1 > y2) {
                System.out.println("The two images are the same");
            } else {
                x1++;
                x2++;
                y1++;
                y2++;
                System.out.println(x1 + " " + y1 + " " + (x2) + " " + (y2));
            }

        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }

    public static void readImage(BufferedReader reader, int img[][]) throws IOException {
        for (int row = 0; row < noOfRows; row++) {
            String[] parts = reader.readLine().trim().split("\\s+");
            for (int col = 0; col < noOfCols; col++) {
                img[row][col] = Integer.parseInt(parts[col]);
            }
        }

    }



    public static boolean compareLine(int index, boolean isRow) {
        if (isRow) {
            for (int col = 0; col < noOfCols; col++) {
                if (oldImage[index][col] != newImage[index][col])
                    return false;
            }
        } else {
            for (int row = 0; row < noOfRows; row++) {
                if (oldImage[row][index] != newImage[row][index])
                    return false;
            }
        }
        return true;
    }


}
