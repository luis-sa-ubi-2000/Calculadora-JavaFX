package calculadora;

import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

import static javafx.application.Application.launch;

public class DesenhaGrafico {

    DesenhaGrafico() {

    }


    public static void main(String args[]) {
        launch(args);
    }

    public void verificaInt(char c) { // Verifica se o caracter é um número inteiro
        if (Character.isDigit(c)) {

        }

    }


    public ArrayList<String> separaValores(String text) {
        System.out.println("iniciar");
        String numero = "";
        ArrayList<String> arrayDeDados = new ArrayList<String>();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) { // Vai buscar o número que está na posição i do ciclo for
                numero += text.charAt(i);            // Adiciona o número ao  array numero
                if (i + 1 == text.length()) {
                    arrayDeDados.add(numero);
                } else {
                    if (!Character.isDigit(text.charAt(i + 1))) {
                        if (text.charAt(i + 1) != '.' && text.charAt(i + 1) != ',') {
                            arrayDeDados.add(numero);
                            numero = "";
                        } else {
                            if (numero.contains(".")) {
                                Alert a = new Alert(Alert.AlertType.ERROR, "Não pode haver mais de um ponto");
                                a.show();
                                return null;
                            }
                        }
                        //Integer.parseInt(numero);
                    }
                }
            } else {
                switch (text.charAt(i)) {
                    case '.':
                    case ',':
                        if (i + 1 == text.length() || !Character.isDigit(text.charAt(i + 1))) {
                            numero += ".0";
                            arrayDeDados.add(numero);
                        }
                        else if(numero == ""){
                            numero += "0.";
                        }
                        else {
                            numero += '.';
                        }
                        break;
                    case 'x':
                        arrayDeDados.add("x");
                        break;
                    case '+':           //Switch case para os operadores, em qualquer um deles só é possível efetuar a conta se a string n estiver vazia e se antes estiver um número ou um x
                    case '/':              // No caso do - apenas é apreciso que a string n esteja vazia já que para meter números negativos podemos n ter nada antes
                    case '*':
                    case '^':
                        if (!arrayDeDados.isEmpty() && (Objects.equals(arrayDeDados.get(arrayDeDados.size() - 1), "x") || verificaDouble(arrayDeDados.get(arrayDeDados.size() - 1)))){
                            arrayDeDados.add("" +text.charAt(i)); //coloca entre parentisis o operador que está no respetivo case, passa-o de char para string
                        }
                        else {
                            Alert a = new Alert(Alert.AlertType.ERROR, "Expressão inválida.");
                            a.show();
                            return null;
                        }
                        break;
                    case '-':
                        arrayDeDados.add("-");
                        break;
                    case '(':
                        arrayDeDados.add("(");
                        break;
                    case ')':
                        arrayDeDados.add(")");
                        break;
                    case 's':
                       case'S':
                        if (text.length() > i+3 && (text.charAt(i + 1) == ('e') || text.charAt(i + 1) == ('E')) && (text.charAt(i + 2) == ('n') || text.charAt(i + 2) == ('N'))&& (text.charAt(i + 3) == ('('))) {
                        arrayDeDados.add("sen");
                        arrayDeDados.add("(");
                            i = i + 3; //Lê como se fosse tudo junto
                        }
                        else {
                            Alert a = new Alert(Alert.AlertType.ERROR, "Expressão inválida.");
                            a.show();
                            return null;
                        }
                        break;
                    case 'c':
                       case'C':
                        if (text.length() > i+3 && (text.charAt(i + 1) == ('o') || text.charAt(i + 1) == ('O')) && (text.charAt(i + 2) == ('s') || text.charAt(i + 2) == ('S'))&& (text.charAt(i + 3) == ('('))) {
                            arrayDeDados.add("cos");
                            arrayDeDados.add("(");
                            i = i + 3;
                        }
                        else {
                            Alert a = new Alert(Alert.AlertType.ERROR, "Expressão inválida.");
                            a.show();
                            return null;
                        }
                        break;
                    case 't':
                       case'T':
                        if (text.length() > i+3 && (text.charAt(i + 1) == ('a') || text.charAt(i + 1) == ('A')) && (text.charAt(i + 2) == ('n') || text.charAt(i + 2) == ('N')) && (text.charAt(i + 3) == ('('))) {
                            arrayDeDados.add("tan");
                            arrayDeDados.add("(");
                            i = i + 3;
                        }
                        else {
                            Alert a = new Alert(Alert.AlertType.ERROR, "Expressão inválida.");
                            a.show();
                            return null;
                        }
                        break;
                        
                    case 'a':
                       case 'A':
                        if (text.length() > i+5 && (text.charAt(i + 1) == ('r') || text.charAt(i + 1) == ('R')) && (text.charAt(i + 2) == ('c') || text.charAt(i + 2) == ('C')) && text.charAt(i + 3) == ('s') || text.charAt(i + 3) == ('S') && text.charAt(i + 4) == ('e') || text.charAt(i + 4) == ('E') && text.charAt(i + 5) == ('n') || text.charAt(i + 5) == ('N') && (text.charAt(i + 6) == ('('))) {
                            arrayDeDados.add("arcsen");
                            arrayDeDados.add("(");
                            i = i + 5;
                        }
                        else if (text.length() > i+5 && (text.charAt(i + 1) == ('r') || text.charAt(i + 1) == ('R')) && (text.charAt(i + 2) == ('c') || text.charAt(i + 2) == ('C')) && (text.charAt(i + 3) == ('c') || text.charAt(i + 3) == ('C')) &&  text.charAt(i + 4) == ('o') || text.charAt(i + 4) == ('O') && text.charAt(i + 5) == ('s') || text.charAt(i + 5) == ('S') && (text.charAt(i + 6) == ('('))){
                            arrayDeDados.add("arccos");
                            arrayDeDados.add("(");
                            i = i + 5;
                        }
                        else if (text.length() > i+5 && (text.charAt(i + 1) == ('r') || text.charAt(i + 1) == ('R')) && (text.charAt(i + 2) == ('c') || text.charAt(i + 2) == ('C')) && text.charAt(i + 3) == ('t') || text.charAt(i + 3) == ('T') && text.charAt(i + 4) == ('a') || text.charAt(i + 4) == ('A') &&  text.charAt(i + 5) == ('n') || text.charAt(i + 5) == ('N') && (text.charAt(i + 6) == ('('))){
                            arrayDeDados.add("arctan");
                            arrayDeDados.add("(");
                            i = i + 5;
                        }
                        else {
                            Alert a = new Alert(Alert.AlertType.ERROR, "Expressão inválida.");
                            a.show();
                            return null;
                        }
                        break;
                       case 'l':
                        case 'L':
                         if (text.length() > i+3 && (text.charAt(i + 1) == ('o') || text.charAt(i + 1) == ('O')) && (text.charAt(i + 2) == ('g') || text.charAt(i + 2) == ('G')) && (text.charAt(i + 3) == ('('))) {
                            arrayDeDados.add("log");
                            arrayDeDados.add("(");
                            i = i + 3;
                         }
                         else {
                            Alert a = new Alert(Alert.AlertType.ERROR, "Expressão inválida.");
                            a.show();
                            return null;
                         }
                        break;

                }
            }
        }
        printArray(arrayDeDados);
        return arrayDeDados;
    }

    public void printArray(ArrayList<String> arrayDeDados){
        for(int i = 0; i < arrayDeDados.size(); i++){
            System.out.println(arrayDeDados.get(i));
        }
    }

    public void criaFuncao (ArrayList<String> arrayDeDados, XYChart<Double, Double> grafico, int range){
        double valorTemp = 0;
        double valorDouble = 0;
        String operador = "";
        final XYChart.Series<Double, Double> series = new XYChart.Series<Double, Double>();
        for (double x = -range; x <= range; x = x + 0.01) {
            valorDouble = 0;
            valorTemp = 0;
            operador = "";
            for (int i = 0; i < arrayDeDados.size(); i++) {
                try {
                    valorTemp = Double.parseDouble(arrayDeDados.get(i));
                    switch (operador) {
                        case "+":
                            valorDouble += valorTemp;
                            break;
                        case "-":
                            valorDouble -= valorTemp;
                            break;
                        case "*":
                            valorDouble *= valorTemp;
                            break;
                        case "/":
                            valorDouble /= valorTemp;
                            break;
                        case "^":
                            valorDouble = Math.pow(valorDouble, valorTemp);                        
                        case "√":
                            valorTemp = Math.sqrt(valorTemp);
                            break;
                        case "x":
                            valorTemp = x;
                            break;
                        default:
                            valorDouble += valorTemp;
                            break;

                    }
                }
                catch (Exception e) {
                    switch (arrayDeDados.get(i)) {
                        case "x":
                            System.out.println("valorTemp: " + valorTemp);
                            valorDouble += x;
                            break;
                        case "(":
                            break;
                        case ")":
                            break;
                        case "sen":
                            valorTemp = x;
                            if (!arrayDeDados.get(i+2).equals("x")) {
                                valorTemp = Double.parseDouble(arrayDeDados.get(i + 2));
                            }
                            valorDouble += Math.sin(valorTemp);
                            System.out.println(valorDouble);
                            System.out.println("sen(" + x + ")=" + Math.sin(x));
                            i = i+2; //impede o programa de repetir o valor de x;
                            break;
                        case "cos":
                            valorTemp = x;
                            if (!arrayDeDados.get(i+2).equals("x")) {
                                valorTemp = Double.parseDouble(arrayDeDados.get(i + 2));
                            }
                            valorDouble += Math.cos(valorTemp);
                            System.out.println(valorDouble);
                            System.out.println("cos(" + x + ")=" + Math.cos(x));
                            i = i+2; //impede o programa de repetir o valor de x;
                            break;
                        case "tan":
                            valorTemp = x;
                            if (!arrayDeDados.get(i+2).equals("x")) {
                                valorTemp = Double.parseDouble(arrayDeDados.get(i + 2));
                            }
                            if (valorTemp < -0.99) {
                                valorTemp = -0.99;
                            }
                            else if (valorTemp > 0.99) {
                                valorTemp = 0.99;
                            }
                            valorDouble += Math.tan(valorTemp);
                            System.out.println(valorDouble);
                            System.out.println("tan(" + x + ")=" + Math.tan(x));
                            i = i+2; //impede o programa de repetir o valor de x;
                            break;
                        case "arcsen":
                            valorTemp = x;
                            System.out.print(i);
                            if (!arrayDeDados.get(i+2).equals("x")) {
                                valorTemp = Double.parseDouble(arrayDeDados.get(i + 5));
                            }
                            valorDouble += Math.asin(valorTemp);
                            System.out.println(valorDouble);
                            System.out.println("arcsen(" + x + ")=" + Math.asin(x));
                            i = i+2; //impede o programa de repetir o valor de x;
                            break;
                        case "arccos":
                            valorTemp = x;
                            System.out.print(i);
                            if (!arrayDeDados.get(i+2).equals("x")) {
                                valorTemp = Double.parseDouble(arrayDeDados.get(i + 5));
                            }
                            valorDouble += Math.acos(valorTemp);
                            System.out.println(valorDouble);
                            System.out.println("arccos(" + x + ")=" + Math.acos(x));
                            i = i+2; //impede o programa de repetir o valor de x;
                            break;
                        case "arctan":
                            valorTemp = x;
                            System.out.print(i);
                            if (!arrayDeDados.get(i+2).equals("x")) {
                                valorTemp = Double.parseDouble(arrayDeDados.get(i + 5));
                            }
                            valorDouble += Math.atan(valorTemp);
                            System.out.println(valorDouble);
                            System.out.println("arctan(" + x + ")=" + Math.atan(x));
                            i = i+2; //impede o programa de repetir o valor de x;
                            break;
                        case "log":
                            valorTemp = x;
                            if (!arrayDeDados.get(i+2).equals("x")) {
                                valorTemp = Double.parseDouble(arrayDeDados.get(i + 2));
                            }
                            valorDouble += Math.log(valorTemp);
                            System.out.println(valorDouble);
                            System.out.println("log(" + x + ")=" + Math.log(x));
                            i = i+2; //impede o programa de repetir o valor de x;
                            break;
                        default:
                            operador = arrayDeDados.get(i);
                            break;
                    }
                }
            }
            System.out.println(valorDouble);
            series.getData().add(new XYChart.Data<Double, Double>(x, valorDouble));
        }
        grafico.getData().add(series);
    }
    public void desenhaFuncao(XYChart<Double, Double> grafico, int range, double valorDouble){
        final XYChart.Series<Double, Double> series = new XYChart.Series<Double, Double>();
        for (double x = -range; x <= range; x = x + 0.01) {
            series.getData().add(new XYChart.Data<Double, Double>(x,valorDouble));
        }
        grafico.getData().add(series);
    }

    public boolean verificaDouble(String isDouble){ //Verifica se o valor é um double
        try {
            Double.parseDouble(isDouble);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}