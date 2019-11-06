/* 
 * Copyright 2019 Oscar G.4 - oscargimenez4@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Oscar G.4 - oscargimenez4@gmail.com
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {
        //Constantes
        final int MAX_DIAS = 7;
        final int MIN_PESO = 0;
        final int MAX_PESO = 250;
        //Variables
        int dia = 1;
        double pedirPeso;
        double media;
        double sumarPeso = 0;
        boolean testOk = true;
        //Bucle
        do {
            try {
                System.out.printf("%nDía %d%n", dia);
                System.out.printf("Introduzca el peso del dia..: ");
                pedirPeso = SCN.nextDouble();

                if (pedirPeso <= MAX_PESO && pedirPeso >= MIN_PESO) {
                    testOk = false;
                    dia++;
                    sumarPeso += pedirPeso;

                } else {
                    System.out.printf("ERROR: Peso introducido incorrecto. %n");
                }
            } catch (Exception e) {
                System.out.printf("%nERROR: Dato incorrecto%n");
            } finally {
                SCN.nextLine();
            }

        } while (testOk || (dia <= MAX_DIAS));
        // Calculo de la media de toda la semana
        media = sumarPeso / MAX_DIAS;
        //Mensaje
        System.out.printf(Locale.ENGLISH, "%nEl peso medio es de...: %.2f Kg.%n", media);
    }
}
