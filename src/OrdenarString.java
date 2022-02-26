import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class OrdenarString {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura");
        palavras.add("casa do codigo");
        palavras.add("caelum");
        palavras.add("rocketseat");

        Collections.sort(palavras);
        System.out.println(palavras);

        Comparator<String> ordenaPorTamanho = new ComparadorPorTamanho();
        palavras.sort(ordenaPorTamanho);

        System.out.println(palavras);

        //isso
        palavras.sort(Comparator.comparing(s -> s.length()));

        //é igual a isto
        //dado uma string retorne um integer
        Function<String, Integer> funcao = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        Comparator<String> stringComparator = Comparator.comparing(funcao);

        palavras.sort(stringComparator);

        palavras.sort((c1, c2) -> String.CASE_INSENSITIVE_ORDER.compare(c1, c2));

        //e igual a isto
        //method reference que é um lambda
        palavras.sort(Comparator.comparing(String::length));

        //invoca elementos
        palavras.forEach(System.out::println);



    }
}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String string1, String string2) {
        if(string1.length() < string2.length()) {
            return -1;
        }
        if(string1.length() > string2.length()) {
            return 1;
        }
        return 0;
    }
}