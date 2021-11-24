package Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {

    public static String ReadFile(String path) {
        String conteudo = "";

        try {
            FileReader arquivo = new FileReader(path);
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linha = "";

            try {
                linha = lerArquivo.readLine();
                while (linha != null) {
                    conteudo += linha;
                    linha = lerArquivo.readLine();
                }
                arquivo.close();
                return conteudo;
            } catch (IOException exception) {
                System.out.println("Erro: Não foi possível ler o arquivo");
                return "";
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Erro: Arquivo não encontrado");
            return "";
        }
    }
}
