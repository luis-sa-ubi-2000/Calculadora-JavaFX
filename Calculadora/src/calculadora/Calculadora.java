/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Luís Sá
 */
public class Calculadora extends Application{

   private SimpleStringProperty _conta = null;
    private SimpleDoubleProperty _resultado = null;
    
    public Calculadora(){
    }
    
    Calculadora(String conta, Double resultado) {
        this._conta = new SimpleStringProperty(conta);
        this._resultado = new SimpleDoubleProperty(resultado);
    }

    public String getConta() {
        return _conta.get();
    }

    public void setConta(String conta) {
        _conta.set(conta);
    }

    public Double getResultado() {
        return _resultado.get();
    }

    public void setResultado(Double resultado) {
        _resultado.set(resultado);
    }
    
    
   
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Layout.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.getIcons().add(new Image("file:calculator.png"));
        stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
