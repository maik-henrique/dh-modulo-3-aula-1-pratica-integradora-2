package br.com.meli.codigomorse.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/codigo-morse")
public class CodigoMorseController {

    private final static Map<String, String> mapCodigoToCaractere;

    static {
        mapCodigoToCaractere = new HashMap<>();
        mapCodigoToCaractere.put(".-", "A");
        mapCodigoToCaractere.put("-...", "B");
        mapCodigoToCaractere.put("-.-.", "C");
        mapCodigoToCaractere.put("-..", "D");
        mapCodigoToCaractere.put(".", "E");
        mapCodigoToCaractere.put("..-.", "F");
        mapCodigoToCaractere.put("--.", "G");
        mapCodigoToCaractere.put("....", "H");
        mapCodigoToCaractere.put("..", "I");
        mapCodigoToCaractere.put(".---", "J");
        mapCodigoToCaractere.put("-.-", "K");
        mapCodigoToCaractere.put(".-..", "L");
        mapCodigoToCaractere.put("--", "M");
        mapCodigoToCaractere.put("-.", "N");
        mapCodigoToCaractere.put("---", "O");
        mapCodigoToCaractere.put(".--.", "P");
        mapCodigoToCaractere.put("--.-", "Q");
        mapCodigoToCaractere.put(".-.", "R");
        mapCodigoToCaractere.put("...", "S");
        mapCodigoToCaractere.put("-", "T");
        mapCodigoToCaractere.put("..-", "U");
        mapCodigoToCaractere.put("...-", "V");
        mapCodigoToCaractere.put(".--", "W");
        mapCodigoToCaractere.put("-..-", "X");
        mapCodigoToCaractere.put("-.--", "Y");
        mapCodigoToCaractere.put("--..", "Z");
        mapCodigoToCaractere.put(".----", "1");
        mapCodigoToCaractere.put("..---", "2");
        mapCodigoToCaractere.put("...--", "3");
        mapCodigoToCaractere.put("....-", "4");
        mapCodigoToCaractere.put(".....", "5");
        mapCodigoToCaractere.put("-....", "6");
        mapCodigoToCaractere.put("--...", "7");
        mapCodigoToCaractere.put("---..", "8");
        mapCodigoToCaractere.put("----.", "9");
        mapCodigoToCaractere.put("-----", "0");

        mapCodigoToCaractere.put("..--..", "?");
        mapCodigoToCaractere.put("-.-.--", "!");
        mapCodigoToCaractere.put(".-.-.", ".");
        mapCodigoToCaractere.put("--..--", ".");

    }

    @GetMapping
    public ResponseEntity<?> getParalavra(@RequestParam String codigoMorse) {
        StringBuilder resultado = new StringBuilder();
        StringBuilder caractereBuilder = new StringBuilder();
        final int wordSeparatorLength = 3;

        int spaceCounter = 0;

        for (char caractere : codigoMorse.toCharArray()) {
            System.out.println(spaceCounter);

            if (caractere != ' ') {
                if (spaceCounter != 0) {
                    String letra = mapCodigoToCaractere.get(caractereBuilder.toString());
                    resultado.append(letra);

                    if (spaceCounter == wordSeparatorLength) {
                        resultado.append(" ");
                    }

                    spaceCounter = 0;
                    caractereBuilder.setLength(0);

                }
                caractereBuilder.append(caractere);
            }

            if (caractere == ' ') {
                spaceCounter++;
            }

        }

        if (caractereBuilder.length() != 0) {
            String letra = mapCodigoToCaractere.get(caractereBuilder.toString());
            resultado.append(letra);
        }

        return ResponseEntity.ok(resultado.toString());
    }
}
