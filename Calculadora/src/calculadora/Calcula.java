package calculadora;

import static java.lang.Math.pow;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javax.xml.transform.OutputKeys;

/**
 *
 * @author Luís Sá
 */
public class Calcula {
    
    Alert alert = new Alert(Alert.AlertType.ERROR);
    
    public void verificaInt(char c) { // Verifica se o caracter é um número inteiro
       if (Character.isDigit(c)) {

       }

    }
       
    
    public ArrayList<String> separaValores(String text) {
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
                            }
                        }
                    }
                }
            } else {
                if (text.charAt(i) == '.' || text.charAt(i) == ',') {
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
                }
            }
        }
        printArray(arrayDeDados);
        return arrayDeDados;
    }
       
    public ArrayList<String> Operacao(String text) {
        String operacao = "";
        ArrayList<String> arrayDeOp = new ArrayList<String>();
        
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i)) && text.charAt(i) != '.' && text.charAt(i) != '(' && text.charAt(i) != ')') { // Vai buscar o número que está na posição i do ciclo for
                operacao += text.charAt(i);          // Adiciona o número ao array numero  
                arrayDeOp.add(operacao);    
            }
        }
        printOperacao(arrayDeOp);
        return arrayDeOp;
    }
       
    public ArrayList printArray(ArrayList<String> arrayDeDados){    
      for(int i = 0; i < arrayDeDados.size(); i++){
          //System.out.println(arrayDeDados.get(i));
  
          
      }
      return arrayDeDados;
    }
    
    public ArrayList printOperacao(ArrayList<String> arrayDeOp){
      for(int j = 0; j < arrayDeOp.size(); j++){
          System.out.println(arrayDeOp.get(j));
          
      }
      return arrayDeOp;
    }
   

    public double calculaFuncao(ArrayList<String> arrayDeDados, ArrayList<String> Operacao, double resultado){
        
        double primeiro = 0.0;
        double segundo = 0.0;
        double valores = 0.0;
        String oper = "";

        
        for (int j = 0; j < Operacao.size(); j++){
            oper = Operacao.get(j);
        } 
        
        for (int i = 0; i < arrayDeDados.size(); i++){ 
            
            if (i == 0)
                primeiro = Double.parseDouble(arrayDeDados.get(0));
            
            else if (i == 1)
                segundo = Double.parseDouble(arrayDeDados.get(1));
                        
            else
                valores = Double.parseDouble(arrayDeDados.get(i));

        }            
            switch(oper){
                case "+" -> resultado = primeiro + segundo;               

                case "-" -> resultado = primeiro - segundo;
                case "x" -> resultado = primeiro * segundo;
                case "/" -> resultado = primeiro / segundo;
                case "^" -> resultado = pow(primeiro,segundo);
                case "√" -> resultado = Math.sqrt(primeiro);                
                case "++" -> resultado =  primeiro + segundo + valores;
                case "+-" -> resultado = primeiro + segundo - valores;
                case "-+" -> resultado = primeiro - segundo + valores;
                case "+x" -> resultado = primeiro + (segundo * valores);
                case "+/" -> resultado = primeiro + (segundo / valores);
                case "-x" -> resultado = primeiro - (segundo * valores);
                case "-/" -> resultado = primeiro - (segundo / valores);
                case "x+" -> resultado = (primeiro * segundo) + valores;
                case "x-" -> resultado = (primeiro * segundo) - valores; 
                case "log" -> resultado = Math.log(primeiro);
                case "sen" -> resultado = Math.sin(primeiro);
                case "cos" -> resultado = Math.cos(primeiro);
                case "tan" -> resultado = Math.tan(primeiro);
                case "arcsen" -> resultado = Math.asin(primeiro);
                case "arccos" -> resultado = Math.acos(primeiro);
                case "arctan" -> resultado = Math.atan(primeiro);
                default -> { alert.setTitle(""); alert.setHeaderText("ERRO!"); alert.setContentText("Escolha uma operação válida."); alert.show();}
                }           
        
       return resultado;
    }
   
}
