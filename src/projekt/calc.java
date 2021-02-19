package projekt;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collection;

public class calc {
    @FXML
    private TextField vrija,vrijb,vrijc;
    @FXML
    private Label rez;
    @FXML
    private Label rezoplosje;
    @FXML
    private Pane calc, fizika;
    @FXML
    private ChoiceBox<String> izbor=new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> izbor1=new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> izbor2=new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> izbormass=new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> izbormass1=new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> kutniizbor=new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> kapacitet=new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> napon=new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> indukcija=new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> ohm=new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> ohm1=new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> ohm2=new ChoiceBox<>();
    private ObservableList<String> convert = FXCollections.observableArrayList("m/s","km/h");
    private ObservableList<String> convert1 = FXCollections.observableArrayList("m/s^2","km/h^2","km/s^2");
    private ObservableList<String> convert2 = FXCollections.observableArrayList("m","km");
    private ObservableList<String> convert3 = FXCollections.observableArrayList("g","kg");
    private ObservableList<String> convert4 = FXCollections.observableArrayList("Hz","KHz","MHz");
    private ObservableList<String> convert5 = FXCollections.observableArrayList("µF","nF");
    private ObservableList<String> convert6 = FXCollections.observableArrayList("mV","V");
    private ObservableList<String> convert7 = FXCollections.observableArrayList("µH","mH");
    private ObservableList<String> convert8 = FXCollections.observableArrayList("Ω","KΩ");

    @FXML
    public void initialize(){
        izbor.setValue("m/s");
        izbor.setItems(convert);
        izbor1.setValue("m/s^2");
        izbor1.setItems(convert1);
        izbor2.setValue("m");
        izbor2.setItems(convert2);
        izbormass.setValue("g");
        izbormass.setItems(convert3);
        izbormass1.setValue("kg");
        izbormass1.setItems(convert3);
        kutniizbor.setValue("Hz");
        kutniizbor.setItems(convert4);
        kapacitet.setValue("µF");
        kapacitet.setItems(convert5);
        napon.setValue("mV");
        napon.setItems(convert6);
        indukcija.setValue("µH");
        indukcija.setItems(convert7);
        ohm.setValue("Ω");
        ohm.setItems(convert8);
        ohm1.setValue("Ω");
        ohm1.setItems(convert8);
        ohm2.setValue("Ω");
        ohm2.setItems(convert8);
    }
    public void cube() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("cube.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void provjeraa(KeyEvent keyEvent) {
        vrija.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    vrija.setText(newValue.replaceAll("[^\\d]", "."));
                }
            }
        });
    }
    public void provjerab(KeyEvent keyEvent) {
        vrijb.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    vrijb.setText(newValue.replaceAll("[^\\d]", "."));
                }
            }
        });
    }
    public void provjerac(KeyEvent keyEvent) {
        vrijc.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    vrijc.setText(newValue.replaceAll("[^\\d]", "."));
                }
            }
        });
    }

    @FXML
    public void kockavrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        float f=Float.parseFloat(a);
        float rez1=f*f*f;
        float rez2=6*f*f;
        String s=Float.toString(rez1);
        String s1=Float.toString(rez2);
        rez.setText(s);
        rezoplosje.setText(s1);
    }
    public void nazad(ActionEvent actionEvent) throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("pocetni.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void nazada(ActionEvent actionEvent) throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("pocetni.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void volumen(ActionEvent actionEvent) throws IOException {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("calc.fxml"));
        Scene scene = new Scene(root, 920, 600);
        stage.setResizable(true);
        stage.setScene(scene);
    }
    public void fizika(ActionEvent actionEvent) throws IOException {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("fizika.fxml"));
        Scene scene = new Scene(root, 920, 600);
        stage.setResizable(true);
        stage.setScene(scene);
    }
    public void gibanjepp() throws IOException {
        Pane a = FXMLLoader.load(getClass().getResource("firtequationofmotion.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void naboj() throws IOException {
        Pane a = FXMLLoader.load(getClass().getResource("naboj.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void rfrekv() throws IOException {
        Pane a = FXMLLoader.load(getClass().getResource("rfrekv.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void gibanjepp1() throws IOException {
        Pane a = FXMLLoader.load(getClass().getResource("secondequationofmotion.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void gibanjepp2() throws IOException {
        Pane a = FXMLLoader.load(getClass().getResource("thirdequationofmotion.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void lcr() throws IOException {
        Pane a = FXMLLoader.load(getClass().getResource("lcr.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void scndnewton() throws IOException {
        Pane a = FXMLLoader.load(getClass().getResource("scndnewton.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void centripetalnaakceleracija() throws IOException {
        Pane a = FXMLLoader.load(getClass().getResource("centripetalnaakceleracija.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void kinenergija() throws IOException {
        Pane a = FXMLLoader.load(getClass().getResource("kinenergija.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void torricelli() throws IOException {
        Pane a = FXMLLoader.load(getClass().getResource("torricelli.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void angularvelocity() throws IOException {
        Pane a = FXMLLoader.load(getClass().getResource("angularvelocity.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void kon() throws IOException {
        Pane a = FXMLLoader.load(getClass().getResource("rkondenzatora.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void zavoj() throws IOException {
        Pane a = FXMLLoader.load(getClass().getResource("rzavojnice.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void sis() throws IOException {
        Pane a = FXMLLoader.load(getClass().getResource("sis.fxml"));
        fizika.setPrefWidth(900);
        fizika.setPrefHeight(600);
        fizika.getChildren().setAll(a);
    }
    public void back(ActionEvent actionEvent) throws IOException {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("calc.fxml"));
        Scene scene = new Scene(root, 920, 600);
        stage.setResizable(true);
        stage.setScene(scene);
    }
    public void back1(ActionEvent actionEvent) throws IOException {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("fizika.fxml"));
        Scene scene = new Scene(root, 920, 600);
        stage.setResizable(true);
        stage.setScene(scene);
    }
    public void jugppvrij(ActionEvent actionEvent){
        String a=vrija.getText();
        String b=vrijb.getText();
        String c=vrijc.getText();
        String d=izbor.getValue();
        String e=izbor1.getValue();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        float f3=Float.parseFloat(c);
        if(d.equals("m/s") && e.equals("m/s^2")){
            float rez1=f1+f2*f3;
            String s=Float.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("m/s") && e.equals("km/h^2")){
            f2*=0.00007716049382716;
            float rez1=f1+f2*f3;
            String s=Float.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("m/s") && e.equals("km/s^2")){
            f2*=1000;
            float rez1=f1+f2*f3;
            String s=Float.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("km/h") && e.equals("m/s^2")){
            f1*=0.27777777777778;
            float rez1=f1+f2*f3;
            String s=Float.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("km/h") && e.equals("km/h^2")){
            f1*=0.27777777777778;
            f2*=0.00007716049382716;
            float rez1=f1+f2*f3;
            String s=Float.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("km/h") && e.equals("km/s^2")){
            f1*=0.27777777777778;
            f2*=1000;
            float rez1=f1+f2*f3;
            String s=Float.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
    }

    public void jugppvrij2(ActionEvent actionEvent){
        String a=vrija.getText();
        String b=vrijb.getText();
        String c=vrijc.getText();
        String d=izbor.getValue();
        String e=izbor1.getValue();
        String g=izbor2.getValue();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        float f3=Float.parseFloat(c);
        if(d.equals("m/s") && e.equals("m/s^2") && g.equals("m")){
            double rez1=Math.sqrt(Math.pow(f1,2)+2*(f2*f3));
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("m/s") && e.equals("m/s^2") && g.equals("km")){
            f3*=1000;
            double rez1=Math.sqrt(Math.pow(f1,2)+2*(f2*f3));
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("m/s") && e.equals("km/h^2") && g.equals("m")){
            f2*=0.00007716049382716;
            double rez1=Math.sqrt(Math.pow(f1,2)+2*(f2*f3));
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("m/s") && e.equals("km/h^2") && g.equals("km")){
            f2*=0.00007716049382716;
            f3*=1000;
            double rez1=Math.sqrt(Math.pow(f1,2)+2*(f2*f3));
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("m/s") && e.equals("km/s^2") && g.equals("m")){
            f2*=1000;
            double rez1=Math.sqrt(Math.pow(f1,2)+2*(f2*f3));
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("m/s") && e.equals("km/s^2") && g.equals("km")){
            f2*=1000;
            f3*=1000;
            double rez1=Math.sqrt(Math.pow(f1,2)+2*(f2*f3));
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("km/h") && e.equals("m/s^2") && g.equals("m")){
            f1*=0.27777777777778;
            double rez1=Math.sqrt(Math.pow(f1,2)+2*(f2*f3));
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("km/h") && e.equals("m/s^2") && g.equals("km")){
            f1*=0.27777777777778;
            f3*=1000;
            double rez1=Math.sqrt(Math.pow(f1,2)+2*(f2*f3));
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("km/h") && e.equals("km/h^2") && g.equals("m")){
            f1*=0.27777777777778;
            f2*=0.00007716049382716;
            double rez1=Math.sqrt(Math.pow(f1,2)+2*(f2*f3));
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("km/h") && e.equals("km/h^2") && g.equals("km")){
            f1*=0.27777777777778;
            f2*=0.00007716049382716;
            f3*=1000;
            double rez1=Math.sqrt(Math.pow(f1,2)+2*(f2*f3));
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("km/h") && e.equals("km/s^2") && g.equals("m")){
            f1*=0.27777777777778;
            f2*=1000;
            double rez1=Math.sqrt(Math.pow(f1,2)+2*(f2*f3));
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(d.equals("km/h") && e.equals("km/s^2") && g.equals("km")){
            f1*=0.27777777777778;
            f2*=1000;
            f3*=1000;
            double rez1=Math.sqrt(Math.pow(f1,2)+2*(f2*f3));
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
    }
    public void jugppvrij3(ActionEvent actionEvent){
        String a=vrija.getText();
        String b=vrijb.getText();
        String c=vrijc.getText();
        String d=izbor.getValue();
        String e=izbor1.getValue();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        float f3=Float.parseFloat(c);
        if(d.equals("m/s") && e.equals("m/s^2")){
            double rez1=(f1*f3)+((f2*Math.pow(f3,2))/2);
            String s=Double.toString(rez1);
            s+=" m";
            rez.setText(s);
        }
        if(d.equals("m/s") && e.equals("km/h^2")){
            f2*=0.00007716049382716;
            double rez1=(f1*f3)+((f2*Math.pow(f3,2))/2);
            String s=Double.toString(rez1);
            s+=" m";
            rez.setText(s);
        }
        if(d.equals("m/s") && e.equals("km/s^2")){
            f2*=1000;
            double rez1=(f1*f3)+((f2*Math.pow(f3,2))/2);
            String s=Double.toString(rez1);
            s+=" m";
            rez.setText(s);
        }
        if(d.equals("km/h") && e.equals("m/s^2")){
            f1*=0.27777777777778;
            double rez1=(f1*f3)+((f2*Math.pow(f3,2))/2);
            String s=Double.toString(rez1);
            s+=" m";
            rez.setText(s);
        }
        if(d.equals("km/h") && e.equals("km/h^2")){
            f1*=0.27777777777778;
            f2*=0.00007716049382716;
            double rez1=(f1*f3)+((f2*Math.pow(f3,2))/2);
            String s=Double.toString(rez1);
            s+=" m";
            rez.setText(s);
        }
        if(d.equals("km/h") && e.equals("km/s^2")){
            f1*=0.27777777777778;
            f2*=1000;
            double rez1=(f1*f3)+((f2*Math.pow(f3,2))/2);
            String s=Double.toString(rez1);
            s+=" m";
            rez.setText(s);
        }
    }
    public void scndnewtonvrij(ActionEvent actionEvent){
        String a=vrija.getText();
        String b=vrijb.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        String e=izbor1.getValue();
        String g=izbormass1.getValue();
        if(g.equals("kg") && e.equals("m/s^2")){
            float rez1=f1*f2;
            String s=Float.toString(rez1);
            s+=" N";
            rez.setText(s);
        }
        if(g.equals("kg") && e.equals("km/h^2")){
            f2*=0.00007716049382716;
            float rez1=f1*f2;
            String s=Float.toString(rez1);
            s+=" N";
            rez.setText(s);
        }
        if(g.equals("kg") && e.equals("km/s^2")){
            f2*=1000;
            float rez1=f1*f2;
            String s=Float.toString(rez1);
            s+=" N";
            rez.setText(s);
        }
        if(g.equals("g") && e.equals("m/s^2")){
            f1*=0.001;
            float rez1=f1*f2;
            String s=Float.toString(rez1);
            s+=" N";
            rez.setText(s);
        }
        if(g.equals("g") && e.equals("km/h^2")){
            f1*=0.001;
            f2*=0.00007716049382716;
            float rez1=f1*f2;
            String s=Float.toString(rez1);
            s+=" N";
            rez.setText(s);
        }
        if(g.equals("g") && e.equals("km/s^2")){
            f1*=0.001;
            f2*=1000;
            float rez1=f1*f2;
            String s=Float.toString(rez1);
            s+=" N";
            rez.setText(s);
        }
    }
    public void centripetalacc(ActionEvent actionEvent){
        String a=vrija.getText();
        String b=vrijb.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        String e=izbor.getValue();
        String g=izbor2.getValue();
        if(e.equals("m/s") && g.equals("m")){
            double rez1=((Math.pow(f1,2))/f2);
            String s=Double.toString(rez1);
            s+=" m/s^2";
            rez.setText(s);
        }
        if(e.equals("m/s") && g.equals("km")){
            f2*=1000;
            double rez1=((Math.pow(f1,2))/f2);
            String s=Double.toString(rez1);
            s+=" m/s^2";
            rez.setText(s);
        }
        if(e.equals("km/h") && g.equals("m")){
            f1*=0.27777777777778;
            double rez1=((Math.pow(f1,2))/f2);
            String s=Double.toString(rez1);
            s+=" m/s^2";
            rez.setText(s);
        }
        if(e.equals("km/h") && g.equals("km")){
            f1*=0.27777777777778;
            f2*=1000;
            double rez1=((Math.pow(f1,2))/f2);
            String s=Double.toString(rez1);
            s+=" m/s^2";
            rez.setText(s);
        }
    }
    public void kinenergijavrij(ActionEvent actionEvent){
        String a=vrija.getText();
        String b=vrijb.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        String e=izbormass1.getValue();
        String g=izbor.getValue();
        if(e.equals("kg") && g.equals("m/s")){
            double rez1=((f1*Math.pow(f2,2)/2));
            String s=Double.toString(rez1);
            s+=" J";
            rez.setText(s);
        }
        if(e.equals("kg") && g.equals("km/h")){
            f2*=0.27777777777778;
            double rez1=((f1*Math.pow(f2,2)/2));
            String s=Double.toString(rez1);
            s+=" J";
            rez.setText(s);
        }
        if(e.equals("g") && g.equals("m/s")){
            f1/=1000;
            double rez1=((f1*Math.pow(f2,2)/2));
            String s=Double.toString(rez1);
            s+=" J";
            rez.setText(s);
        }
        if(e.equals("g") && g.equals("km/h")){
            f1/=1000;
            f2*=0.27777777777778;
            double rez1=((f1*Math.pow(f2,2)/2));
            String s=Double.toString(rez1);
            s+=" J";
            rez.setText(s);
        }
    }
    public void torricellivrij(ActionEvent actionEvent){
        String a=vrija.getText();
        float f1=Float.parseFloat(a);
        String e=izbor2.getValue();
        if(e.equals("m")){
            double rez1=Math.sqrt(2*9.81*f1);
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(e.equals("km")){
            f1*=1000;
            double rez1=Math.sqrt(2*9.81*f1);
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
    }
    public void kutnavrij(ActionEvent actionEvent){
        String a=vrija.getText();
        float f1=Float.parseFloat(a);
        String e=kutniizbor.getValue();
        if(e.equals("Hz")){
            double rez1=2*Math.PI*f1;
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(e.equals("KHz")){
            f1*=1000;
            double rez1=2*Math.PI*f1;
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
        if(e.equals("MHz")){
            f1*=1000000;
            double rez1=2*Math.PI*f1;
            String s=Double.toString(rez1);
            s+=" m/s";
            rez.setText(s);
        }
    }
    public void rkondenzatoravrij(ActionEvent actionEvent){
        String a=vrija.getText();
        String b=vrijb.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        String e=kutniizbor.getValue();
        String g=kapacitet.getValue();
        if(e.equals("Hz") && g.equals("µF")){
            double rez1=((1)/(2*Math.PI*f1*f2*0.000001));
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("KHz") && g.equals("µF")){
            f1*=1000;
            double rez1=((1)/(2*Math.PI*f1*f2*0.000001));
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("MHz") && g.equals("µF")){
            f1*=1000000;
            double rez1=((1)/(2*Math.PI*f1*f2*0.000001));
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("Hz") && g.equals("nF")){
            double rez1=((1)/(2*Math.PI*f1*f2*0.000000001));
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("KHz") && g.equals("nF")){
            f1*=1000;
            double rez1=((1)/(2*Math.PI*f1*f2*0.000000001));
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("MHz") && g.equals("nF")){
            f1*=1000000;
            double rez1=((1)/(2*Math.PI*f1*f2*0.000000001));
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
    }
    public void nabojvrij(ActionEvent actionEvent){
        String a=vrija.getText();
        String b=vrijb.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        String e=napon.getValue();
        String g=kapacitet.getValue();
        if(e.equals("mV") && g.equals("µF")){
            double rez1=f1*0.001*f2*0.000001;
            String s=Double.toString(rez1);
            rez.setText(s);
        }
        if(e.equals("mV") && g.equals("nF")){
            double rez1=f1*0.001*f2*0.000000001;
            String s=Double.toString(rez1);
            rez.setText(s);
        }
        if(e.equals("V") && g.equals("nF")){
            double rez1=f1*f2*0.000000001;
            String s=Double.toString(rez1);
            rez.setText(s);
        }
        if(e.equals("V") && g.equals("µF")){
            double rez1=f1*f2*0.000001;
            String s=Double.toString(rez1);
            rez.setText(s);
        }
    }
    public void rzavojnicevrij(ActionEvent actionEvent){
        String a=vrija.getText();
        String b=vrijb.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        String e=kutniizbor.getValue();
        String g=indukcija.getValue();
        if(e.equals("Hz") && g.equals("µH")){
            double rez1=2*Math.PI*f2*f1*0.000001;
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("Hz") && g.equals("mH")){
            double rez1=2*Math.PI*f2*f1*0.001;
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("KHz") && g.equals("µH")){
            f1*=1000;
            double rez1=2*Math.PI*f2*f1*0.000001;
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("KHz") && g.equals("mH")){
            f1*=1000;
            double rez1=2*Math.PI*f2*f1*0.001;
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("MHz") && g.equals("µH")){
            f1*=1000000;
            double rez1=2*Math.PI*f2*f1*0.000001;
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("MHz") && g.equals("mH")){
            f1*=1000000;
            double rez1=2*Math.PI*f2*f1*0.001;
            String s=String.format("%.15g Ω", rez1);
            rez.setText(s);
        }
    }
    public void lcrvrij(ActionEvent actionEvent){
        String a=vrija.getText();
        String b=vrijb.getText();
        String c=vrijc.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        float f3=Float.parseFloat(c);
        String e=ohm.getValue();
        String g=ohm1.getValue();
        String h=ohm2.getValue();
        if(e.equals("Ω") && g.equals("Ω") && h.equals("Ω")){
            double rez1=Math.sqrt(Math.pow(f1-f2,2)+Math.pow(f3,2));
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("Ω") && g.equals("Ω") && h.equals("KΩ")){
            f3*=1000;
            double rez1=Math.sqrt(Math.pow(f1-f2,2)+Math.pow(f3,2));
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("Ω") && g.equals("KΩ") && h.equals("Ω")){
            f2*=1000;
            double rez1=Math.sqrt(Math.pow(f1-f2,2)+Math.pow(f3,2));
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("Ω") && g.equals("KΩ") && h.equals("KΩ")){
            f2*=1000;
            f3*=1000;
            double rez1=Math.sqrt(Math.pow(f1-f2,2)+Math.pow(f3,2));
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("KΩ") && g.equals("Ω") && h.equals("Ω")){
            f1*=1000;
            double rez1=Math.sqrt(Math.pow(f1-f2,2)+Math.pow(f3,2));
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("KΩ") && g.equals("Ω") && h.equals("KΩ")){
            f1*=1000;
            f3*=1000;
            double rez1=Math.sqrt(Math.pow(f1-f2,2)+Math.pow(f3,2));
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("KΩ") && g.equals("KΩ") && h.equals("Ω")){
            f1*=1000;
            f2*=1000;
            double rez1=Math.sqrt(Math.pow(f1-f2,2)+Math.pow(f3,2));
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
        if(e.equals("KΩ") && g.equals("KΩ") && h.equals("KΩ")){
            f1*=1000;
            f2*=1000;
            f3*=1000;
            double rez1=Math.sqrt(Math.pow(f1-f2,2)+Math.pow(f3,2));
            String s=Double.toString(rez1);
            s+=" Ω";
            rez.setText(s);
        }
    }
    public void rfrekvencijavrij(ActionEvent actionEvent){
        String a=vrija.getText();
        String b=vrijb.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        String e=indukcija.getValue();
        String g=kapacitet.getValue();
        if(e.equals("µH") && g.equals("µF")){
            double rez1=((1)/(2*Math.PI*Math.sqrt(f1*f2*0.000001*0.000001)));
            String s=Double.toString(rez1);
            s+=" Hz";
            rez.setText(s);
        }
        if(e.equals("µH") && g.equals("nF")){
            double rez1=((1)/(2*Math.PI*Math.sqrt(f1*f2*0.000001*0.000000001)));
            String s=Double.toString(rez1);
            s+=" Hz";
            rez.setText(s);
        }
        if(e.equals("mH") && g.equals("µF")){
            double rez1=((1)/(2*Math.PI*Math.sqrt(f1*f2*0.001*0.000001)));
            String s=Double.toString(rez1);
            s+=" Hz";
            rez.setText(s);
        }
        if(e.equals("mH") && g.equals("nF")){
            double rez1=((1)/(2*Math.PI*Math.sqrt(f1*f2*0.001*0.000000001)));
            String s=Double.toString(rez1);
            s+=" Hz";
            rez.setText(s);
        }
    }
    public void sisvrij(ActionEvent actionEvent){
        String a=vrija.getText();
        String b=vrijb.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        double rez1=Math.pow(f1,2)*f2;
        String s=Double.toString(rez1);
        s+=" W";
        rez.setText(s);
    }
    public void cuboid() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("cuboid.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void kvadarvrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        String c=vrijc.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        float f3=Float.parseFloat(c);
        float rez1=f1*f2*f3;
        float kvadaroplosje=2*(f1*f2+f1*f3+f2*f3);
        String s=Float.toString(rez1);
        String s2=Float.toString(kvadaroplosje);
        rez.setText(s);
        rezoplosje.setText(s2);
    }
    public void cone() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("cone.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void stozacvrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        double rez1=(Math.PI*f2*Math.pow(f1,2))/3;
        double rez2=Math.PI*f1*(f1+f2);
        String s=Double.toString(rez1);
        String s2=Double.toString(rez2);
        rez.setText(s);
        rezoplosje.setText(s2);
    }
    public void frustum() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("frustum.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void kstozacvrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        String c=vrijc.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        float f3=Float.parseFloat(c);
        double rez1=((Math.PI*f3)/3*(Math.pow(f1,2)+Math.pow(f2,2)+f1*f2));
        double F=(Math.PI*(f1+f2))*(Math.sqrt((Math.pow((f1-f2),2))+Math.pow(f3,2)));
        double rez2=F+(Math.PI*(Math.pow(f1,2)+Math.pow(f2,2)));
        String s=Double.toString(rez1);
        String s2=Double.toString(rez2);
        rez.setText(s);
        rezoplosje.setText(s2);
    }
    public void frustumpyramid() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("frustumpyramid.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void kpiramidavrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        String c=vrijc.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        float f3=Float.parseFloat(c);
        double rez1=((f3/3)*(f1+Math.sqrt(f1*f2)+f2));
        String s=Double.toString(rez1);
        rez.setText(s);
    }
    public void cylinder() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("cylinder.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void valjakvrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        double rez1=Math.PI*Math.pow(f1,2)*f2;
        double rez2=2*Math.PI*f1*(f1+f2);
        String s=Double.toString(rez1);
        String s2=Double.toString(rez2);
        rez.setText(s);
        rezoplosje.setText(s2);
    }
    public void hollowcylinder() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("hollowcylinder.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void ksvaljakvrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        String c=vrijc.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        float f3=Float.parseFloat(c);
        double rez1=Math.PI*f3*(Math.pow(f1,2)-Math.pow(f2,2));
        double rez2=2*Math.PI*f2*f3+2*Math.PI*f1*f3+(2*(Math.PI*Math.pow(f1,2) - Math.PI*Math.pow(f2,2)));
        String s=Double.toString(rez1);
        String s2=Double.toString(rez2);
        rez.setText(s);
        rezoplosje.setText(s2);
    }
    public void ellipsoid() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("ellipsoid.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void elipsoidvrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        String c=vrijc.getText();
        float vrij1=4;
        float vrij2=3;
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        float f3=Float.parseFloat(c);
        double rez1=vrij1/vrij2*Math.PI*f1*f2*f3;
        String s=Double.toString(rez1);
        rez.setText(s);
    }
    public void barrel() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("barrel.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void bacvavrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        String c=vrijc.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        float f3=Float.parseFloat(c);
        double rez1=(((Math.PI*f1)*(Math.pow(f3,2)+2*Math.pow(f2,2)))/3);
        String s=Double.toString(rez1);
        rez.setText(s);
    }
    public void sphere() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("sphere.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void kuglavrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        float vrij1=4;
        float vrij2=3;
        float f=Float.parseFloat(a);
        double rez1=(vrij1/vrij2)*Math.pow(f,3)*Math.PI;
        double rez2=4*(Math.PI*(Math.pow(f,2)));
        String s=Double.toString(rez1);
        String s2=Double.toString(rez2);
        rez.setText(s);
        rezoplosje.setText(s2);
    }
    public void hollowsphere() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("hollowsphere.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void skuglavrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        double rez1=(((4*Math.PI)/3)*(Math.pow(f2,3)-Math.pow(f1,3)));
        double rez2=(4*Math.PI*(Math.pow(f2,2)))+(4*Math.PI*(Math.pow(f1,2)));
        String s=Double.toString(rez1);
        String s2=Double.toString(rez2);
        rez.setText(s);
        rezoplosje.setText(s2);
    }
    public void prism() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("prism.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void prizmavrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        double cotang=(1/Math.tan(Math.PI/6));
        float vrij1=1;
        float vrij2=4;
        double baza=vrij1/vrij2*6*Math.pow(f1,2)*cotang;
        double rez1=baza*f2;
        double rez2=2*baza+(6*f1*f2);
        String s=Double.toString(rez1);
        String s2=Double.toString(rez2);
        rez.setText(s);
        rezoplosje.setText(s2);
    }
    public void triangularprism() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("triangularprism.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void tprizmavrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        String c=vrijc.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        float f3=Float.parseFloat(c);
        float rez1=(f1*f2*f3)/2;
        String s=Double.toString(rez1);
        rez.setText(s);
    }
    public void spheresector() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("spheresector.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void kugsektorvrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        double rez1=(2*Math.PI*Math.pow(f1,2)*f2)/3;
        String s=Double.toString(rez1);
        rez.setText(s);
    }
    public void torus() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("torus.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void torusvrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        double rez1=2*Math.pow(Math.PI,2)*f2*Math.pow(f1,2);
        String s=Double.toString(rez1);
        rez.setText(s);
    }
    public void slicedcylinder() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("slicedcylinder.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void prevaljakvrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        String c=vrijc.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        float f3=Float.parseFloat(c);
        double rez1=(Math.PI*Math.pow(f1,2)*(f2+f3))/2;
        String s=Double.toString(rez1);
        rez.setText(s);
    }
    public void piramida() throws IOException {
        Pane a= FXMLLoader.load(getClass().getResource("piramida.fxml"));
        calc.setPrefWidth(900);
        calc.setPrefHeight(600);
        calc.getChildren().setAll(a);
    }
    public void piramidavrij(ActionEvent actionEvent) {
        String a=vrija.getText();
        String b=vrijb.getText();
        String c=vrijc.getText();
        float f1=Float.parseFloat(a);
        float f2=Float.parseFloat(b);
        float f3=Float.parseFloat(c);
        double rez1=(f1*f2*f3)/3;
        double rez2=(4*f1*f3);
        String s=Double.toString(rez1);
        String s2=Double.toString(rez2);
        rez.setText(s);
        rezoplosje.setText(s2);
    }
}
