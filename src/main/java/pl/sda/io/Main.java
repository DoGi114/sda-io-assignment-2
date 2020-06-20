package pl.sda.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*
        1. Znajdz w folderze my-files pliki, które zawierają słowo "coś" i wypisz nazwy tych plikow na konsole
        1*. Używając wyrażenia regularnego poza nazwa pliku wypisz też słowo występujące po "coś" (wystarczy po pierwszym wystąpieniu)
        2. Poza wypisaniem nazw plików wypisz też ilość wystąpień tego słowa w danym pliku w formacie <nazwa>:<ilość wystąpień>
        3. Zamiast wypisywać na konsolę zapis rezultat do pliku
         */
        findGiveWordInFiles("coś");
    }

    private static void findGiveWordInFiles(String givenWord){
        try {
            List<Path> filePaths = Files.list(Paths.get("my-files")).collect(Collectors.toList());
            for(Path path : filePaths){
                BufferedReader bufferedReader = Files.newBufferedReader(path);
                String content;
                while( ( content = bufferedReader.readLine() ) != null){
                    if(content.contains(givenWord)){
                        System.out.println(path);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
