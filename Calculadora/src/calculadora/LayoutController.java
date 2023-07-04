/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package calculadora;

import java.io.*;
import java.net.URL;
import java.text.*;
import java.util.*;
import java.util.function.Function;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.geometry.*;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;




/**
 * FXML Controller class
 *
 * @author Luís Sá
 */
public class LayoutController implements Initializable{
 
    @FXML private LineChart eixoxy;
    @FXML private Button num0;
    @FXML private Button num1;
    @FXML private Button num2;
    @FXML private Button num3;
    @FXML private Button num4;
    @FXML private Button num5;
    @FXML private Button num6;
    @FXML private Button num7;
    @FXML private Button num8;
    @FXML private Button num9;
    @FXML private Button soma;
    @FXML private Button sub;
    @FXML private Button mul;
    @FXML private Button div;
    @FXML private Button e;
    @FXML private Button pi;
    @FXML private Button ponto;
    @FXML private Button esq;
    @FXML private Button esqigual;
    @FXML private Button dirigual;
    @FXML private Button dir;
    @FXML private Button pardir;
    @FXML private Button paresq;
    @FXML private Button exp;
    @FXML private Button x;
    @FXML private Button raiz;
    @FXML private Button igual;
    @FXML private TextField conta;
    @FXML private TextField funcao;
    @FXML private TableView calculos;
    @FXML private TableColumn operacao;
    @FXML private TableColumn resultado;
    @FXML private BorderPane stage;
    @FXML private MenuItem gravar;
    public File file;

   @FXML
   public void gravacomo(ActionEvent event){
       
    DirectoryChooser chooser = new DirectoryChooser();
    chooser.setTitle("Escolha a localização do ficheiro onde pretende guardar os seus cálculos.");
    File selectedDirectory = null;
    while(selectedDirectory == null){
       selectedDirectory = chooser.showDialog(null);
    }

    file = new File(selectedDirectory + "/" + "Operacões.txt");
    PrintWriter outFile = null;
    try {
            outFile = new PrintWriter(file);
    } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    }
    
    for(int i = 0; i<calculos.getItems().size(); i++){        
            outFile.println("OPERAÇÃO" + "          " + "RESULTADO");
            Calculadora c =  (Calculadora) calculos.getItems().get(i);
            outFile.println(c.getConta() + "               " + c.getResultado());
            outFile.println();
    }
        outFile.close();  
        
        gravar.setDisable(false);
       
   }
   
   @FXML
   public void grava(ActionEvent event){
       
    PrintWriter outFile = null;
    try {
            outFile = new PrintWriter(file);
    } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    }
    
    for(int i = 0; i<calculos.getItems().size(); i++){
            outFile.println("OPERAÇÃO" + "          " + "RESULTADO");
            Calculadora c =  (Calculadora) calculos.getItems().get(i);
            outFile.println(c.getConta() + "               " + c.getResultado());
            outFile.println();
    }
        outFile.close();         
       
    }
   
   @FXML
   public void fecha(ActionEvent event){
       
        stage.getScene().getWindow().hide();
   }
   
   @FXML
   public void botoes(ActionEvent event){
       
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Informação sobre os botões");
    alert.setHeaderText("Botões");
    alert.setContentText("O botão '=' no layout ao lado da calculadora apenas é utilizado para construir funções de uma variável no gráfico cartesiano. Se quiser calcular operações, por favor clique em 'CALCULAR'.");
    alert.showAndWait();
    
   }
   
    @FXML
    public void num0(ActionEvent event){
        
       if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
            conta.clear();
            funcao.clear();
       }
       
      if(conta.getText().equals("log(") || conta.getText().equals("sen(") || conta.getText().equals("cos(") || conta.getText().equals("tan(") || conta.getText().equals("arcsen(") || conta.getText().equals("arccos(") || conta.getText().equals("arctan(")){
          conta.appendText(num0.getText() + ")");
          funcao.appendText(num0.getText() + ")");
      }
      else{
          conta.appendText(num0.getText());
          funcao.appendText(num0.getText());
      }
     
    }
   
    @FXML
    public void num1(ActionEvent event){
        
       if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
            conta.clear();
            funcao.clear();
       }
       
      if(conta.getText().equals("log(") || conta.getText().equals("sen(") || conta.getText().equals("cos(") || conta.getText().equals("tan(") || conta.getText().equals("arcsen(") || conta.getText().equals("arccos(") || conta.getText().equals("arctan(")){
          conta.appendText(num1.getText() + ")");
          funcao.appendText(num1.getText() + ")");
      }
      else{
          conta.appendText(num1.getText());
          funcao.appendText(num1.getText());
      }
     
    }
   
   
    @FXML
    public void num2(ActionEvent event){
       
       if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
            conta.clear();
            funcao.clear();
       }
       
      if(conta.getText().equals("log(") || conta.getText().equals("sen(") || conta.getText().equals("cos(") || conta.getText().equals("tan(") || conta.getText().equals("arcsen(") || conta.getText().equals("arccos(") || conta.getText().equals("arctan(")){
          conta.appendText(num2.getText() + ")");
          funcao.appendText(num2.getText() + ")");
      }
      else{
          conta.appendText(num2.getText());
          funcao.appendText(num2.getText());
      }
      
    }
   
    @FXML 
    public void num3(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
            conta.clear();
            funcao.clear();
      }
       
      if(conta.getText().equals("log(") || conta.getText().equals("sen(") || conta.getText().equals("cos(") || conta.getText().equals("tan(") || conta.getText().equals("arcsen(") || conta.getText().equals("arccos(") || conta.getText().equals("arctan(")){
          conta.appendText(num3.getText() + ")");
          funcao.appendText(num3.getText() + ")");
      }
      else{
          conta.appendText(num3.getText());
          funcao.appendText(num3.getText());
      }
      
    }
    
    @FXML
    public void num4(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
            conta.clear();
            funcao.clear();
      }
       
      if(conta.getText().equals("log(") || conta.getText().equals("sen(") || conta.getText().equals("cos(") || conta.getText().equals("tan(") || conta.getText().equals("arcsen(") || conta.getText().equals("arccos(") || conta.getText().equals("arctan(")){
          conta.appendText(num4.getText() + ")");
          funcao.appendText(num4.getText() + ")");
      }
      else{
          conta.appendText(num4.getText());
          funcao.appendText(num4.getText());
      }
     
    }
    
    @FXML
    public void num5(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
            conta.clear();
            funcao.clear();
      }
       
      if(conta.getText().equals("log(") || conta.getText().equals("sen(") || conta.getText().equals("cos(") || conta.getText().equals("tan(") || conta.getText().equals("arcsen(") || conta.getText().equals("arccos(") || conta.getText().equals("arctan(")){
          conta.appendText(num5.getText() + ")");
          funcao.appendText(num5.getText() + ")");
      }
      else{
          conta.appendText(num5.getText());
          funcao.appendText(num5.getText());
      }
     
    }
    
    
    @FXML
    public void num6(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
            conta.clear();
            funcao.clear();
      }
       
      if(conta.getText().equals("log(") || conta.getText().equals("sen(") || conta.getText().equals("cos(") || conta.getText().equals("tan(") || conta.getText().equals("arcsen(") || conta.getText().equals("arccos(") || conta.getText().equals("arctan(")){
          conta.appendText(num6.getText() + ")");
          funcao.appendText(num6.getText() + ")");
      }
      else{
          conta.appendText(num6.getText());
          funcao.appendText(num6.getText());
      }
     
    }
    
    @FXML
    public void num7(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      if(conta.getText().equals("log(") || conta.getText().equals("sen(") || conta.getText().equals("cos(") || conta.getText().equals("tan(") || conta.getText().equals("arcsen(") || conta.getText().equals("arccos(") || conta.getText().equals("arctan(")){
          conta.appendText(num7.getText() + ")");
          funcao.appendText(num7.getText() + ")");
      }
      else{
          conta.appendText(num7.getText());
          funcao.appendText(num7.getText());
      }
     
    }
    
    @FXML
    public void num8(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
            conta.clear();
            funcao.clear();
      }
       
      if(conta.getText().equals("log(") || conta.getText().equals("sen(") || conta.getText().equals("cos(") || conta.getText().equals("tan(") || conta.getText().equals("arcsen(") || conta.getText().equals("arccos(") || conta.getText().equals("arctan(")){
          conta.appendText(num8.getText() + ")");
          funcao.appendText(num8.getText() + ")");
      }
      else{
          conta.appendText(num8.getText());
          funcao.appendText(num8.getText());
      }
     
    }
    
    @FXML
    public void num9(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }      
      
      if(conta.getText().equals("log(") || conta.getText().equals("sen(") || conta.getText().equals("cos(") || conta.getText().equals("tan(") || conta.getText().equals("arcsen(") || conta.getText().equals("arccos(") || conta.getText().equals("arctan(")){
          conta.appendText(num9.getText() + ")");
          funcao.appendText(num9.getText() + ")");
      }
      else{
          conta.appendText(num9.getText());
          funcao.appendText(num9.getText());
      }

     
    }
    
    @FXML
    public void soma(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.appendText(soma.getText());
      funcao.appendText(soma.getText());
     
    }
    
    @FXML
    public void sub(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.appendText(sub.getText());
      funcao.appendText(sub.getText());
     
    }
    
    @FXML
    public void mul(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.appendText(mul.getText());
      funcao.appendText(mul.getText());
     
    }
    
    @FXML
    public void div(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.appendText(div.getText());
      funcao.appendText(div.getText());
     
    }
    
    @FXML
    public void apagar(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.clear();
      funcao.clear();
        
    }
    
    @FXML
    public void e(ActionEvent event){
        
       if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
            conta.clear();
            funcao.clear();
       }
       
       conta.appendText(e.getText().replace("e", "2.72"));
       funcao.appendText(e.getText().replace("e", "2.72"));

    }
    
    @FXML
    public void pi(ActionEvent event){
        
       if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
            conta.clear();
            funcao.clear();
       }
       
       conta.appendText(pi.getText().replace("π", "3.14"));
       funcao.appendText(pi.getText().replace("π", "3.14"));
   
    }
    
    @FXML
    public void ponto(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.appendText(ponto.getText());
      funcao.appendText(ponto.getText());
     
    }
    
    @FXML
    public void esq(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.appendText(esq.getText());
      funcao.appendText(esq.getText());
     
    }
    
    @FXML
    public void esqigual(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.appendText(esqigual.getText());
      funcao.appendText(esqigual.getText());
     
    }
    
    @FXML
    public void dirigual(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.appendText(dirigual.getText());
      funcao.appendText(dirigual.getText());
     
    }
    
    @FXML
    public void dir(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.appendText(dir.getText());
      funcao.appendText(dir.getText());
     
    }
    
    @FXML
    public void paresq(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.appendText(paresq.getText());
      funcao.appendText(paresq.getText());
     
    }
    
    @FXML
    public void pardir(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.appendText(pardir.getText());
      funcao.appendText(pardir.getText());
     
    }
    
    @FXML
    public void exp(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.appendText(exp.getText());
      funcao.appendText(exp.getText());
     
    }
    
    @FXML
    public void log(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.setText("log(");
      funcao.setText("log(");
     
    }
    
    @FXML
    public void sen(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.setText("sen(");
      funcao.setText("sen(");
     
    }
    
    @FXML
    public void cos(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.setText("cos(");
      funcao.setText("cos(");
     
    }
    
    @FXML
    public void tan(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.setText("tan(");
      funcao.setText("tan(");
     
    }
    
    @FXML
    public void arcsen(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.setText("arcsen(");
      funcao.setText("arcsen(");
     
    }
    
    @FXML
    public void arccos(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.setText("arccos(");
      funcao.setText("arccos(");
     
    }
    
    @FXML
    public void arctan(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.setText("arctan(");
      funcao.setText("arctan(");
     
    }
    
    @FXML
    public void x(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.appendText(x.getText());
      funcao.appendText(x.getText());
     
    }
    
    @FXML
    public void raiz(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.appendText(raiz.getText());
      funcao.appendText(raiz.getText());
     
    }
    
    @FXML
    public void igual(ActionEvent event){
       
      if(conta.getText().equals("0.0") || funcao.getText().equals("Escreva uma função aqui.")){
           conta.clear();
           funcao.clear();
      }
       
      conta.setText("Usado na construção de funções de uma variável no gráfico cartesiano.");
      funcao.appendText(igual.getText());
     
    }
    


    
    @FXML
    public void calculo(ActionEvent event){
              
      Calcula calcula = new Calcula();
      
      ArrayList<String> Numeros = calcula.separaValores(conta.getText());
      ArrayList<String> Operacao = calcula.Operacao(conta.getText());
      double resultado = 0.0;
      Calculadora operacoes = new Calculadora(conta.getText(),calcula.calculaFuncao(Numeros, Operacao, resultado));
      calculos.getItems().add(operacoes);
      conta.clear();
     
    }
    
    
    @FXML
    public void desenha(ActionEvent event){
        
      int range = 10;
        //Calculadora operacoes = new Calculadora(funcao.getText(),"0");
        //calculos.getItems().add(operacoes);
        //System.out.print(funcao.getText());
        DesenhaGrafico desenhaGrafico = new DesenhaGrafico();
        ArrayList<String> arrayDeDados = desenhaGrafico.separaValores(funcao.getText());
        if (arrayDeDados != null){
            desenhaGrafico.criaFuncao(arrayDeDados,eixoxy,range);             
        }
        
         funcao.clear();
   }
    

    final XYChart.Series<Double, Double> series = new XYChart.Series<Double, Double>();


   public class MyGraph {

        private XYChart<Double, Double> graph;
        private double range;

        public MyGraph(final XYChart<Double, Double> graph, final double range) {
            this.graph = graph;
            this.range = range;
        }

        public void plotLine(final Function<Double, Double> function) {
            final XYChart.Series<Double, Double> series = new XYChart.Series<Double, Double>();
            for (double x = -range; x <= range; x = x + 0.01) {
                plotPoint(x, function.apply(x), series);
            }
            graph.getData().add(series);
        }

        private void plotPoint(final double x, final double y,
                final XYChart.Series<Double, Double> series) {
            series.getData().add(new XYChart.Data<Double, Double>(x, y));
        }

        public void clear() {
            graph.getData().clear();
        }

            public void plotLine() {
        final XYChart.Series<Double, Double> series = new XYChart.Series<Double, Double>();
        for (double x = -range; x <= range; x = x + 0.01) {
            series.getData().add(new XYChart.Data<Double, Double>(x,Math.pow(x,3)));
            //System.out.println(x);
        }
        graph.getData().add(series);
    }
    }


 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
           
       calculos.setPlaceholder(new Label("Nenhuns cálculos por apresentar."));
       
        //eixoxy.setStyle("-fx-background-color: rgb(35, 39, 50);");

        //eixoxy.getData().add(new XYChart.Data<>(1.1,2.1));

        /*
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        eixoxy.getData().add(series);
        */
        
       operacao.setCellValueFactory(new PropertyValueFactory<Calculadora, String>("conta"));
       resultado.setCellValueFactory(new PropertyValueFactory<Calculadora, Double>("resultado"));
       gravar.setDisable(true);

        MyGraph mathsGraph = new MyGraph(eixoxy, 10);
        //mathsGraph.plotLine();
        
       if(conta.getText().isEmpty() || funcao.getText().isEmpty())
            conta.setText("0.0");
            funcao.setText("Escreva uma função aqui.");
        
    }


    public class Desenho extends Application {

        public void start(Stage primaryStage) throws Exception {
            
            

        }
    }

}