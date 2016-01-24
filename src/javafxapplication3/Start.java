
package javafxapplication3;

import java.net.URL;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 *
 * @author enocuka
 */
public class Start extends Application {
    
    int states = 0;
    String status = "select";
    ArrayList<String> alfabet = new ArrayList<String>();
    //nfa
    ArrayList<Stateauto> totalstates = new ArrayList<Stateauto>();
    //dfa
    ArrayList<Stateauto> totalstates2 = new ArrayList<Stateauto>();
    //epsilon-nfa
    ArrayList<Stateauto> totalstates3 = new ArrayList<Stateauto>();
    //min-dfa
    ArrayList<Stateauto> totalstates4 = new ArrayList<Stateauto>();
    
    //nfa
    ArrayList<Arrow> lines = new ArrayList<Arrow>();
    //dfa
    ArrayList<Arrow> lines2 = new ArrayList<Arrow>();
    //epsilon-nfa
    ArrayList<Arrow> lines3 = new ArrayList<Arrow>();
    //min-dfa
    ArrayList<Arrow> lines4 = new ArrayList<Arrow>();
    
    Stateauto auto1 = new Stateauto("", 0, 0);
    Stateauto auto2 = new Stateauto("", 0, 0);
    Arrow arrow = new Arrow("", auto1, auto1);
    ComboBox <String> alfabetcombobox = new ComboBox<String>() ;
    boolean epsilon = false;
    boolean minizim = false;
    String image = Start.class.getResource("image/note.png").toExternalForm();
    Image imgwrong = new Image(Start.class.getResourceAsStream("image/wrong1.png"));
    Image imgok = new Image(Start.class.getResourceAsStream("image/ok1.png"));
    Tooltip tooltip =  new Tooltip();
    Timeline timeline;
    Button btnremoveall;
    Boolean goalfabet1 ;
    @Override
    public void start(Stage primaryStage) {
        goalfabet1 = true;
        HBox hboxbutton = new HBox(30);
        HBox hbox = new HBox(50);
        ScrollPane sppane = new ScrollPane();
        //final URL resource = getClass().getResource("wav/click.wav");
        //final AudioClip clip = new AudioClip(resource.toString());
        Image imgrestart = new Image(Start.class.getResourceAsStream("image/restart.png"));
        btnremoveall =  new Button("Restart",new ImageView(imgrestart));
        tooltip.setStyle("-fx-font-size:20");
        Label donotdelete = new Label("Copyright © 2016 Eno Çuka");
       donotdelete.setStyle("-fx-font-size:14px");
       donotdelete.setLayoutX(1070);
       donotdelete.setLayoutY(10);
        Pane pane = new Pane();
        
        Pane panetool = new Pane();
        panetool.setPrefSize(70, 310);
        panetool.setLayoutX(0);
        panetool.setLayoutY(200);
        panetool.setStyle("-fx-border-width:1px;"
                    + "-fx-border-color:#D3D3D3;"
                    + "-fx-border-radius:1em;"
                    + "-fx-background-color: lightblue;"
                    + "-fx-background-radius:1em;"
                );
        
        Pane nfaspane = new Pane();
        nfaspane.setPrefSize(920,600);
        nfaspane.setLayoutX(150);
        nfaspane.setLayoutY(150);
       
        nfaspane.setStyle("-fx-border-width:1px;"
                    + "-fx-border-color:#D3D3D3;"
                    + "-fx-border-radius:1em;"
                    + "-fx-background-image: url('" + image + "')"
                );
        
        Pane nfaspanee = new Pane();
        nfaspanee.setPrefSize(920,600);
        nfaspanee.setLayoutX(150);
        nfaspanee.setLayoutY(150);
       
        nfaspanee.setStyle("-fx-border-width:1px;"
                    + "-fx-border-color:#D3D3D3;"
                    + "-fx-border-radius:1em;"
                    + "-fx-background-image: url('" + image + "')"
                );
        Pane dfaspanee = new Pane();
        dfaspanee.setPrefSize(920,600);
        dfaspanee.setLayoutX(150);
        dfaspanee.setLayoutY(800);
       
        dfaspanee.setStyle("-fx-border-width:1px;"
                    + "-fx-border-color:#D3D3D3;"
                    + "-fx-border-radius:1em;"
                    + "-fx-background-image: url('" + image + "')"
                );
        
        Pane faspane = new Pane();
        faspane.setPrefSize(920,600);
        faspane.setLayoutX(150);
        faspane.setLayoutY(800);
        faspane.setStyle("-fx-border-width:1px;"
                    + "-fx-border-color:#D3D3D3;"
                    + "-fx-border-radius:1em;"
                    + "-fx-background-image: url('" + image + "')"
                );
        FlowPane lines2pane = new FlowPane();
        lines2pane.setPrefSize(920, 190);
        lines2pane.setMaxSize(920, 190);
        lines2pane.setLayoutX(150);
        lines2pane.setLayoutY(1450);
        lines2pane.setStyle("-fx-border-width:1px;"
                    + "-fx-border-color:#D3D3D3;"
                    + "-fx-border-radius:1em;"
                    + "-fx-background-image: url('" + image + "')"
                );
        
        FlowPane lines3pane = new FlowPane();
        lines3pane.setPrefSize(920, 190);
        lines3pane.setMaxSize(920, 190);
        lines3pane.setLayoutX(150);
        lines3pane.setLayoutY(1450);
        lines3pane.setStyle("-fx-border-width:1px;"
                    + "-fx-border-color:#D3D3D3;"
                    + "-fx-border-radius:1em;"
                    + "-fx-background-image: url('" + image + "')"
                );
        FlowPane lines4pane = new FlowPane();
        lines4pane.setPrefSize(920, 190);
        lines4pane.setMaxSize(920, 190);
        lines4pane.setLayoutX(150);
        lines4pane.setLayoutY(1450);
        lines4pane.setStyle("-fx-border-width:1px;"
                    + "-fx-border-color:#D3D3D3;"
                    + "-fx-border-radius:1em;"
                    + "-fx-background-image: url('" + image + "')"
                );
        
        Label label1 = new Label("NFA");
        label1.setStyle("-fx-font-size:20px;");
        label1.setLayoutX(150);
        label1.setLayoutY(120);
        //implementimi i panetool
        ToggleGroup grup = new ToggleGroup();
        Image imgbtn1 = new Image(Start.class.getResourceAsStream("image/cursor.png"));
        ToggleButton btn1 = new ToggleButton("", new ImageView(imgbtn1));
        btn1.setToggleGroup(grup);
        btn1.selectedProperty().setValue(Boolean.TRUE);
        btn1.setPrefSize(50, 50);
        btn1.setOnAction(e->{
            status = "select";
            alfabetcombobox.getSelectionModel().select(-1);
        });
       
        Image imgbtn2 = new Image(Start.class.getResourceAsStream("image/move.png"));
        ToggleButton btn2 = new ToggleButton("", new ImageView(imgbtn2));
        btn2.setToggleGroup(grup);
        btn2.setPrefSize(50, 50);
        Tooltip tooltipbtn2 = new Tooltip("Move state");
        tooltipbtn2.setStyle("-fx-font-size:18");
        btn2.setTooltip(tooltipbtn2);
        btn2.setOnAction(e->{
            status = "move";
            alfabetcombobox.getSelectionModel().select(-1);
        });
        
        Image imgbtn3 = new Image(Start.class.getResourceAsStream("image/arrow.png"));
        ToggleButton btn3 = new ToggleButton("", new ImageView(imgbtn3));
        btn3.setToggleGroup(grup);
        btn3.setPrefSize(50, 50);
        Tooltip tooltipbtn3 = new Tooltip("Function");
        tooltipbtn3.setStyle("-fx-font-size:18");
        btn3.setTooltip(tooltipbtn3);
        btn3.setOnAction(e->{
            status = "arrow";
        });
        
        Image imgbtn4 = new Image(Start.class.getResourceAsStream("image/final.png"));
        ToggleButton btn4 = new ToggleButton("", new ImageView(imgbtn4));
        btn4.setToggleGroup(grup);
        btn4.setPrefSize(50, 50);
        Tooltip tooltipbtn4 = new Tooltip("Final state");
        tooltipbtn4.setStyle("-fx-font-size:18");
        btn4.setTooltip(tooltipbtn4);     
        btn4.setOnAction(e->{
            status = "final";
            alfabetcombobox.getSelectionModel().select(-1);
            
        });
        
        Image imgbtn5 = new Image(Start.class.getResourceAsStream("image/nonfinal.png"));
        ToggleButton btn5 = new ToggleButton("", new ImageView(imgbtn5));
        btn5.setToggleGroup(grup);
        btn5.setPrefSize(50, 50);
        Tooltip tooltipbtn5 = new Tooltip("Non final state");
        tooltipbtn5.setStyle("-fx-font-size:18");
        btn5.setTooltip(tooltipbtn5);
        btn5.setOnAction(e->{
            status = "nonfinal";
            alfabetcombobox.getSelectionModel().select(-1);
        });

        VBox vbox = new VBox(10);
        vbox.setLayoutX(10);
        vbox.setLayoutY(10);
        vbox.getChildren().addAll(btn1,btn2,btn3,btn4,btn5);
        panetool.getChildren().addAll(vbox);
       
       
        //implementimi i alfabetit 
        alfabetcombobox.setStyle("-fx-font-size:18px;");
        alfabetcombobox.setPrefHeight(50);
        Tooltip alftooltip = new Tooltip("Alphabet");
        alftooltip.setStyle("-fx-font-size:18");
        alfabetcombobox.setTooltip(alftooltip);
                
        Image sigma = new Image(Start.class.getResourceAsStream("image/sigma1.png"));
        final Label alfabetlabel = new Label(" =",new ImageView(sigma));
        alfabetlabel.setStyle("-fx-font-size: 24px;");
        
        TextField alfabettextfield = new TextField();
        alfabettextfield.setTooltip(alftooltip);
        alfabettextfield.setPrefSize(50, 50);
        alfabettextfield.setStyle("-fx-font-size: 24px;");
        Image imgalf = new Image(Start.class.getResourceAsStream("image/addalf.png"));
        Button addalfabet = new Button("",new ImageView(imgalf));
        addalfabet.setPrefSize(50, 50);
        addalfabet.setOnAction(e->{
           
            if(alfabettextfield.getText().length()==1){
                
                boolean load = true;
                
                    for(int a = 0 ; a < alfabet.size() ; a++){
                        if(alfabettextfield.getText().equalsIgnoreCase(alfabet.get(a)))
                            load = false;
                       
                    }
                    if(load){
                        alfabet.add(alfabettextfield.getText());
                        alfabetcombobox.getItems().add(alfabettextfield.getText());
                        alfabettextfield.setText("");
                    }
                    else{
                        String str = "This character is in the alphabet.";
                        uptooltip(str, false, primaryStage);
                        alfabettextfield.setText("");
                    }
                
                System.out.println(alfabet);
            }
            else{
                String str = "Please assign a character with length = '1'.";
                uptooltip(str, false, primaryStage);
                alfabettextfield.setText("");
            }
       
        });
 
        HBox hboxalfabet = new HBox(10);
        hboxalfabet.getChildren().addAll(alfabetlabel,alfabetcombobox,alfabettextfield,addalfabet);
      
       //Implementimi i gjendjeve
        Image imgstate = new Image(Start.class.getResourceAsStream("image/state.png"));
        final Label statelabel = new Label(" = {}",new ImageView(imgstate));
        statelabel.setStyle("-fx-font-size: 24px;");
        Tooltip statetooltip = new Tooltip("State (not more than 12 states)");
        statetooltip.setStyle("-fx-font-size:18");
        TextField statetextfield = new TextField();
        statetextfield.setPrefSize(70,50);
        statetextfield.setStyle("-fx-font-size: 24px;");
        statetextfield.setTooltip(statetooltip);
       
        Image imgaddstate = new Image(Start.class.getResourceAsStream("image/addstate.png"));
        Button addstate = new Button("",new ImageView(imgaddstate));
        addstate.setPrefSize(50, 50);
        addstate.setOnAction(e->{
            
                try{
                    states = Integer.parseInt(statetextfield.getText());
                    if(states > 1 && states <= 12){
                        statelabel.setText(" = { "+states+" }");
                        statetextfield.setText(null); 
                    }
                    else{
                        states = 0;
                        String str = "The number of states can not be larger than '12' and smaller than '2'.";
                        uptooltip(str, false, primaryStage);
                        statetextfield.setText(null); 
                         
                    }
                     
                }
                catch(Exception e1){
                    String str = "Please determine an integer greater than '1' and less or equal to '12'.";
                    uptooltip(str, false, primaryStage);
                    statetextfield.setText(null);
                }
                
            
            
        });
        
    
        
        HBox hboxstates = new HBox(10);
        hboxstates.getChildren().addAll(statelabel,statetextfield,addstate);
        
       
       
        Image imgconvert = new Image(Start.class.getResourceAsStream("image/convert.png"));
        Button convertbutton = new Button("Convert to DFA",new ImageView(imgconvert));

        Button convertbutton2 = new Button("Convert to NFA",new ImageView(imgconvert));
        
        Button convertbutton3 = new Button("Convert to Minimization of DFA",new ImageView(imgconvert));
       
        Image imgcreate = new Image(Start.class.getResourceAsStream("image/create.png"));
        Button buttondfa = new Button("Create DFA",new ImageView(imgcreate));
        buttondfa.setStyle("-fx-font-size:18px;-fx-base: lightgreen;");
        buttondfa.setPrefHeight(50);
        
        
        Button buttonnfas = new Button("Create NFA",new ImageView(imgcreate));
        buttonnfas.setStyle("-fx-font-size:18px;-fx-base: lightgreen;");
       
        Button buttonnfase = new Button("Create ε-NFA",new ImageView(imgcreate));
        buttonnfase.setStyle("-fx-font-size:18px;-fx-base: lightgreen;");
        buttonnfase.setPrefHeight(50);
            
        
        final VBox vboxdeltetarrow = new VBox(10);
        vboxdeltetarrow.setLayoutX(1100);
        vboxdeltetarrow.setLayoutY(150);
        
        //implementimi i automatit  DFA
        buttondfa.setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent e) {
                System.out.println("alfabeti "+alfabet
                        +"\n gjendjet "+states);
               

                if(states!=0 && !alfabet.isEmpty()){
                    buttondfa.setVisible(false);
                    convertbutton3.setLayoutX(800);
                    convertbutton3.setLayoutY(750);
                    convertbutton3.setStyle("-fx-font-size:18px;-fx-base: lightgreen;");
                    pane.getChildren().add(convertbutton3);
                    double xpanel = 100;
                    double ypanel = 50;
                    for(int i=0;i<states;i++){
                        if(xpanel > 700){
                            xpanel = 100;
                            ypanel +=200;
                        }
                        Stateauto auto = new Stateauto("q"+i, xpanel, ypanel);
                        
                        if(i == 0 ){
                            auto.setEntryarrow(new Entryarrow(auto));
                            faspane.getChildren().addAll(auto.getEntryarrow().getLine1(),auto.getEntryarrow().getLine2());  
                        }
                        totalstates2.add(auto);
                        
                        auto.setOnAction(new EventHandler<ActionEvent>() {
                           
                            public void handle(ActionEvent e1) {
                               
                                if(status.equalsIgnoreCase("final")){
                                    auto.setStatefinal(true);
                                }
                                if(status.equalsIgnoreCase("nonfinal")){
                                    auto.setStatefinal(false);
                                }
                                if(status.equalsIgnoreCase("arrow")){
                                    if(alfabetcombobox.getSelectionModel().getSelectedIndex()>=0){
                                    String alftmp = alfabetcombobox.getSelectionModel().getSelectedItem();
                                    if(!alftmp.isEmpty()){
                                        arrow.setAlfabet(alftmp);
                                   
                                    if(auto1.getLayoutX() == 0 && auto1.getLayoutY() == 0){
                                       
                                       for( int ar = 0 ; ar < auto.getOutarrow().size() ; ar++){
                                           if(auto.getOutarrow().get(ar).getAlfabet().equalsIgnoreCase(arrow.getAlfabet())){
                                               goalfabet1 = false;
                                               break;
                                           }
                                       }
                                       if(goalfabet1 == true){
                                            auto1 = auto;
                                            auto.addoutarrow(arrow);
                                            arrow.setStartstate(auto);
                                       }
                                    }
                                    else if(auto2.getLayoutX()==0 && auto2.getLayoutY()==0){
                                        
                                        auto2 = auto;
                                        auto.addinarrow(arrow);
        
                                        arrow.setEndstate(auto);
                                        arrow.moveline();
                 
                                        lines2.add(arrow);
                                        Boolean go = false;
                                        int i=0;
                                        while(go == false && i < lines2.size()-1 ){
                                            if(arrow.getStartstate().getText().equalsIgnoreCase(lines2.get(i).getStartstate().getText())
                                                && arrow.getEndstate().getText().equalsIgnoreCase(lines2.get(i).getEndstate().getText())){
                                                lines2.get(i).addletterinlabel(arrow.getAlfabet());
                                                lines2.get(i).setinarrow(arrow);
                                                arrow.setArrowover(lines2.get(i));
                                                go = true;
                                            }
                                            i++;
                                        }
                                        if(go == false){
                                            faspane.getChildren().addAll(arrow,arrow.getLine1(),arrow.getLine2(),arrow.getLabel());
                                        }
                                       
                                        Image imgdelete = new Image(Start.class.getResourceAsStream("image/delete.png"));
                                        Button deletarrowbutton = new Button(arrow.toString(),new ImageView(imgdelete));
                                        deletarrowbutton.setStyle("-fx-font-size:20px");
                                        vboxdeltetarrow.getChildren().addAll(deletarrowbutton);
                                        Tooltip tooltipdelete = new Tooltip("Delete");
                                        tooltipdelete.setStyle("-fx-font-size:18");
                                        deletarrowbutton.setTooltip(tooltipdelete);
                                        deletarrowbutton.setOnAction(e->{
                                            for(int j=0;j<lines2.size();j++){
                                                if(deletarrowbutton.getText().equalsIgnoreCase(lines2.get(j).toString())){
                                                    Arrow tmparrow = null;
                                                    if(lines2.get(j).getArrowover() != null){
                                                        tmparrow = lines2.get(j).getArrowover();
                                                        tmparrow.deleteletterinlabel(lines2.get(j).getAlfabet());
                                                        tmparrow.getinarrow().remove(lines2.get(j));
                                                        lines2.get(j).getStartstate().getOutarrow().remove(lines2.get(j));
                                                        lines2.get(j).getEndstate().getInarrow().remove(lines2.get(j));
                                                        lines2.remove(j);
                                                        vboxdeltetarrow.getChildren().remove(deletarrowbutton);
                                                    }
                                                    else{
                                                        for(int a = 0 ; a < lines2.get(j).getinarrow().size() ; a++){
                                                            if(a == 0){
                                                                tmparrow = lines2.get(j).getinarrow().get(a);
                                                                faspane.getChildren().addAll(tmparrow,tmparrow.getLine1(),tmparrow.getLine2(),tmparrow.getLabel());
                                                                tmparrow.setArrowover(null);
                                                                tmparrow.moveline();
                                                            }
                                                            else{
                                                                tmparrow.addletterinlabel(lines2.get(j).getinarrow().get(a).getAlfabet());
                                                                tmparrow.setinarrow(lines2.get(j).getinarrow().get(a));
                                                                lines2.get(j).getinarrow().get(a).setArrowover(tmparrow);
                                                            }
                                                        }
                                                        faspane.getChildren().removeAll(lines2.get(j),lines2.get(j).getLine1(),lines2.get(j).getLine2(),lines2.get(j).getLabel());
                                                        lines2.get(j).getStartstate().getOutarrow().remove(lines2.get(j));
                                                        lines2.get(j).getEndstate().getInarrow().remove(lines2.get(j));
                                                        lines2.remove(j);
                                                        vboxdeltetarrow.getChildren().remove(deletarrowbutton);
                                                    }
                     
                                                    break;
                                                }   
                                            }
                                        });

                                        auto1 = new Stateauto("", 0, 0);
                                        auto2 = new Stateauto("", 0, 0);
                                        arrow = new Arrow("", auto1, auto2);
                                        goalfabet1 = true;
                                    }
                                    if(goalfabet1 == false){
                                        goalfabet1 = true;
                                        String str = "You can not create this transition.";
                                        uptooltip(str, false, primaryStage);
                                    }
                                }
                                }
                                    else{
                                        String str = "Please choice an input from the alphabet.";
                                        uptooltip(str, false, primaryStage);
                                    }
                                   
                            }
                                faspane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        if(status.equalsIgnoreCase("move")){
                                            System.out.println(event.getX());
                                            System.out.println(event.getY());
                                            
                                            auto.setLayoutX(event.getX()-50);
                                            auto.setLayoutY(event.getY()-50);
                                            ArrayList<Arrow> arrowmovein = auto.getInarrow();
                                            for( Arrow a : arrowmovein){
                                                a.moveline();
                                            }
                                            ArrayList<Arrow> arrowmoveout = auto.getOutarrow();
                                            for( Arrow a : arrowmoveout){
                                                a.moveline();
                                            }
                                            if(auto.getEntryarrow() != null)
                                            auto.getEntryarrow().moveline();
                                        }
                                    
                                    }
                                });   
                                
                            }
                               
                        });
                        faspane.getChildren().addAll(auto);
                        xpanel += 200;
                    }
                    
                   String str = "DFA is created, define final states and transition functions.";
                    uptooltip(str, true, primaryStage); 
                   
                }
                else{
                    String str = "Please control alphabet and states.";
                    uptooltip(str, false, primaryStage);
                }
                
            }
        });
        
        
        //implementimi i automatit epsilon NFA
        buttonnfase.setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent e) {
                System.out.println("alfabeti "+alfabet
                        +"\n gjendjet "+states);
               

                if(states!=0 && !alfabet.isEmpty()){
                    buttonnfase.setVisible(false);
                    convertbutton2.setLayoutX(800);
                    convertbutton2.setLayoutY(750);
                    convertbutton2.setStyle("-fx-font-size:18px;-fx-base: lightgreen;");
                    pane.getChildren().add(convertbutton2);
                    double xpanel = 100;
                    double ypanel = 50;
                    for(int i=0;i<states;i++){
                        if(xpanel > 700){
                            xpanel = 100;
                            ypanel +=200;
                        }
                        Stateauto auto = new Stateauto("q"+i, xpanel, ypanel);
                        
                        if(i == 0 ){
                            auto.setEntryarrow(new Entryarrow(auto));
                            nfaspanee.getChildren().addAll(auto.getEntryarrow().getLine1(),auto.getEntryarrow().getLine2());  
                        }
                        totalstates3.add(auto);
                        
                        auto.setOnAction(new EventHandler<ActionEvent>() {
                           
                            public void handle(ActionEvent e1) {
                                
                                if(status.equalsIgnoreCase("final")){
                                    auto.setStatefinal(true);
                                }
                                if(status.equalsIgnoreCase("nonfinal")){
                                    auto.setStatefinal(false);
                                }
                                if(status.equalsIgnoreCase("arrow")){
                                    if(alfabetcombobox.getSelectionModel().getSelectedIndex()>=0){
                                    String alftmp = alfabetcombobox.getSelectionModel().getSelectedItem();
                                    if(!alftmp.isEmpty()){
                                        arrow.setAlfabet(alftmp);
                                      
                                    if(auto1.getLayoutX()== 0 && auto1.getLayoutY() == 0){
                                        auto1 = auto;
                                        auto.addoutarrow(arrow);
                                        
                                        arrow.setStartstate(auto);
                                    }
                                    else if(auto2.getLayoutX()==0 && auto2.getLayoutY()==0){
                                        auto2 = auto;
                                        auto.addinarrow(arrow);
        
                                        arrow.setEndstate(auto);
                                        arrow.moveline();
                                       
                                        Boolean goalfabet = true;
                                        for(int k=0;k<lines3.size();k++){
                                            if(arrow.toString().equalsIgnoreCase(lines3.get(k).toString())){
                                                goalfabet = false;
                                                System.out.println("kjo arrow eshte krijuar njhere");
                                            }
                                        }
                                        if(arrow.getAlfabet().equalsIgnoreCase("ε") 
                                                && arrow.getStartstate().getText().equalsIgnoreCase(arrow.getEndstate().getText()))
                                            goalfabet = false;

                                        if(goalfabet == true){
                                        lines3.add(arrow);
                                        Boolean go = false;
                                        int i=0;
                                        while(go == false && i < lines3.size()-1 ){
                                            if(arrow.getStartstate().getText().equalsIgnoreCase(lines3.get(i).getStartstate().getText())
                                                && arrow.getEndstate().getText().equalsIgnoreCase(lines3.get(i).getEndstate().getText())){
                                                lines3.get(i).addletterinlabel(arrow.getAlfabet());
                                                lines3.get(i).setinarrow(arrow);
                                                arrow.setArrowover(lines3.get(i));
                                                go = true;
                                            }
                                            i++;
                                        }
                                        if(go == false){
                                            nfaspanee.getChildren().addAll(arrow,arrow.getLine1(),arrow.getLine2(),arrow.getLabel());
                                        }
                                       
                                        Image imgdelete = new Image(Start.class.getResourceAsStream("image/delete.png"));
                                        Button deletarrowbutton = new Button(arrow.toString(),new ImageView(imgdelete));
                                        deletarrowbutton.setStyle("-fx-font-size:20px");
                                        vboxdeltetarrow.getChildren().addAll(deletarrowbutton);
                                        Tooltip tooltipdelete = new Tooltip("Delete");
                                        tooltipdelete.setStyle("-fx-font-size:18");
                                        deletarrowbutton.setTooltip(tooltipdelete);
                                        deletarrowbutton.setOnAction(e->{
                                            for(int j=0;j<lines3.size();j++){
                                                if(deletarrowbutton.getText().equalsIgnoreCase(lines3.get(j).toString())){
                                                    Arrow tmparrow = null;
                                                    if(lines3.get(j).getArrowover() != null){
                                                        tmparrow = lines3.get(j).getArrowover();
                                                        tmparrow.deleteletterinlabel(lines3.get(j).getAlfabet());
                                                        tmparrow.getinarrow().remove(lines3.get(j));
                                                        lines3.get(j).getStartstate().getOutarrow().remove(lines3.get(j));
                                                        lines3.get(j).getEndstate().getInarrow().remove(lines3.get(j));
                                                        lines3.remove(j);
                                                        vboxdeltetarrow.getChildren().remove(deletarrowbutton);
                                                    }
                                                    else{
                                                        for(int a = 0 ; a < lines3.get(j).getinarrow().size() ; a++){
                                                            if(a == 0){
                                                                tmparrow = lines3.get(j).getinarrow().get(a);
                                                                nfaspanee.getChildren().addAll(tmparrow,tmparrow.getLine1(),tmparrow.getLine2(),tmparrow.getLabel());
                                                                tmparrow.setArrowover(null);
                                                                tmparrow.moveline();
                                                            }
                                                            else{
                                                                tmparrow.addletterinlabel(lines3.get(j).getinarrow().get(a).getAlfabet());
                                                                tmparrow.setinarrow(lines3.get(j).getinarrow().get(a));
                                                                lines3.get(j).getinarrow().get(a).setArrowover(tmparrow);
                                                            }
                                                        }
                                                        nfaspanee.getChildren().removeAll(lines3.get(j),lines3.get(j).getLine1(),lines3.get(j).getLine2(),lines3.get(j).getLabel());
                                                        lines3.get(j).getStartstate().getOutarrow().remove(lines3.get(j));
                                                        lines3.get(j).getEndstate().getInarrow().remove(lines3.get(j));
                                                        lines3.remove(j);
                                                        vboxdeltetarrow.getChildren().remove(deletarrowbutton);
                                                    }
                     
                                                    break;
                                                }   
                                            }
                                        });

                                        }
                                       
     
                                        auto1 = new Stateauto("", 0, 0);
                                        auto2 = new Stateauto("", 0, 0);
                                        arrow = new Arrow("", auto1, auto2);
                                    }
                                }
                                }
                                    else{
                                        String str = "Please choice an input from the alphabet.";
                                        uptooltip(str, false, primaryStage);
                                    }
                                   
                            }
                                nfaspanee.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        if(status.equalsIgnoreCase("move")){
                                            System.out.println(event.getX());
                                            System.out.println(event.getY());
                                            auto.setLayoutX(event.getX()-50);
                                            auto.setLayoutY(event.getY()-50);
                                            ArrayList<Arrow> arrowmovein = auto.getInarrow();
                                            for( Arrow a : arrowmovein){
                                                a.moveline();
                                            }
                                            ArrayList<Arrow> arrowmoveout = auto.getOutarrow();
                                            for( Arrow a : arrowmoveout){
                                                a.moveline();
                                            }
                                            if(auto.getEntryarrow() != null)
                                            auto.getEntryarrow().moveline();
                                        }
                                    
                                    }
                                });   
                            }
                               
                        });
                        nfaspanee.getChildren().addAll(auto);
                        xpanel += 200;
                    }
                    
                   String str = "ε-NFA is created, define final states and transition functions.";
                    uptooltip(str, true, primaryStage); 
                }
                else{
                    String str = "Please control alphabet and states.";
                    uptooltip(str, false, primaryStage);
                }
                
            }
        });
        //implementimi i automatit NFA
        buttonnfas.setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent e) {
                System.out.println("alfabeti "+alfabet
                        +"\n gjendjet "+states);
               

                if(states!=0 && !alfabet.isEmpty()){
                     buttonnfas.setVisible(false);
                    pane.getChildren().addAll(convertbutton);
                    
                    double xpanel = 100;
                    double ypanel = 50;
                    for(int i=0;i<states;i++){
                        if(xpanel > 700){
                            xpanel = 100;
                            ypanel +=200;
                        }
                        Stateauto auto = new Stateauto("q"+i, xpanel, ypanel);
                        
                        if(i == 0 ){
                            auto.setEntryarrow(new Entryarrow(auto));
                            nfaspane.getChildren().addAll(auto.getEntryarrow().getLine1(),auto.getEntryarrow().getLine2());  
                        }
                        totalstates.add(auto);
                        
                        auto.setOnAction(new EventHandler<ActionEvent>() {
                           
                            public void handle(ActionEvent e1) {
                                if(status.equalsIgnoreCase("final")){
                                    auto.setStatefinal(true);
                                }
                                if(status.equalsIgnoreCase("nonfinal")){
                                    auto.setStatefinal(false);
                                }
                                if(status.equalsIgnoreCase("arrow")){
                                    if(alfabetcombobox.getSelectionModel().getSelectedIndex()>=0){
                                    String alftmp = alfabetcombobox.getSelectionModel().getSelectedItem();
                                    if(!alftmp.isEmpty()){
                                        arrow.setAlfabet(alftmp);
                                      
                                    if(auto1.getLayoutX()==0 && auto1.getLayoutY()==0){
                                        auto1 = auto;
                                        auto.addoutarrow(arrow);
                                        
                                        arrow.setStartstate(auto);
                                    }
                                    else if(auto2.getLayoutX()==0 && auto2.getLayoutY()==0){
                                        auto2 = auto;
                                        auto.addinarrow(arrow);
        
                                        arrow.setEndstate(auto);
                                        arrow.moveline();
                                       
                                        Boolean goalfabet = true;
                                        for(int k=0;k<lines.size();k++){
                                            if(arrow.toString().equalsIgnoreCase(lines.get(k).toString())){
                                                goalfabet = false;
                                                System.out.println("kjo arrow eshte krijuar njhere");
                                            }
                                        }

                                        if(goalfabet == true){
                                        lines.add(arrow);
                                        Boolean go = false;
                                        int i=0;
                                        while(go == false && i < lines.size()-1 ){
                                            if(arrow.getStartstate().getText().equalsIgnoreCase(lines.get(i).getStartstate().getText())
                                                && arrow.getEndstate().getText().equalsIgnoreCase(lines.get(i).getEndstate().getText())){
                                                lines.get(i).addletterinlabel(arrow.getAlfabet());
                                                lines.get(i).setinarrow(arrow);
                                                arrow.setArrowover(lines.get(i));
                                                go = true;
                                            }
                                            i++;
                                        }
                                        if(go == false){
                                            nfaspane.getChildren().addAll(arrow,arrow.getLine1(),arrow.getLine2(),arrow.getLabel());
                                        }
                                       
                                        Image imgdelete = new Image(Start.class.getResourceAsStream("image/delete.png"));
                                        Button deletarrowbutton = new Button(arrow.toString(),new ImageView(imgdelete));
                                        deletarrowbutton.setStyle("-fx-font-size:20px");
                                        vboxdeltetarrow.getChildren().addAll(deletarrowbutton);
                                        Tooltip tooltipdelete = new Tooltip("Delete");
                                        tooltipdelete.setStyle("-fx-font-size:18");
                                        deletarrowbutton.setTooltip(tooltipdelete);
                                        deletarrowbutton.setOnAction(e->{
                                            for(int j=0;j<lines.size();j++){
                                                if(deletarrowbutton.getText().equalsIgnoreCase(lines.get(j).toString())){
                                                    Arrow tmparrow = null;
                                                    if(lines.get(j).getArrowover() != null){
                                                        tmparrow = lines.get(j).getArrowover();
                                                        tmparrow.deleteletterinlabel(lines.get(j).getAlfabet());
                                                        tmparrow.getinarrow().remove(lines.get(j));
                                                        lines.get(j).getStartstate().getOutarrow().remove(lines.get(j));
                                                        lines.get(j).getEndstate().getInarrow().remove(lines.get(j));
                                                        lines.remove(j);
                                                        vboxdeltetarrow.getChildren().remove(deletarrowbutton);
                                                    }
                                                    else{
                                                        for(int a = 0 ; a < lines.get(j).getinarrow().size() ; a++){
                                                            if(a == 0){
                                                                tmparrow = lines.get(j).getinarrow().get(a);
                                                                nfaspanee.getChildren().addAll(tmparrow,tmparrow.getLine1(),tmparrow.getLine2(),tmparrow.getLabel());
                                                                tmparrow.setArrowover(null);
                                                                tmparrow.moveline();
                                                            }
                                                            else{
                                                                tmparrow.addletterinlabel(lines.get(j).getinarrow().get(a).getAlfabet());
                                                                tmparrow.setinarrow(lines.get(j).getinarrow().get(a));
                                                                lines.get(j).getinarrow().get(a).setArrowover(tmparrow);
                                                            }
                                                        }
                                                        nfaspanee.getChildren().removeAll(lines.get(j),lines.get(j).getLine1(),lines.get(j).getLine2(),lines.get(j).getLabel());
                                                        lines.get(j).getStartstate().getOutarrow().remove(lines.get(j));
                                                        lines.get(j).getEndstate().getInarrow().remove(lines.get(j));
                                                        lines.remove(j);
                                                        vboxdeltetarrow.getChildren().remove(deletarrowbutton);
                                                    }
                     
                                                    break;
                                                }   
                                            }
                                        });

                                        }
                                       
     
                                        auto1 = new Stateauto("", 0, 0);
                                        auto2 = new Stateauto("", 0, 0);
                                        arrow = new Arrow("", auto1, auto2);
                                    }
                                }
                                }
                                    else{
                                        String str = "Please choice an input from the alphabet.";
                                        uptooltip(str, false, primaryStage);
                                    }
                                   
                            }
                                nfaspane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        if(status.equalsIgnoreCase("move")){
                                            System.out.println(event.getX()-50);
                                            System.out.println(event.getY()-50);
                                            auto.setLayoutX(event.getX()-50);
                                            auto.setLayoutY(event.getY()-50);
                                            ArrayList<Arrow> arrowmovein = auto.getInarrow();
                                            for( Arrow a : arrowmovein){
                                                a.moveline();
                                            }
                                            ArrayList<Arrow> arrowmoveout = auto.getOutarrow();
                                            for( Arrow a : arrowmoveout){
                                                a.moveline();
                                            }
                                            if(auto.getEntryarrow() != null)auto.getEntryarrow().moveline();
                                        }
                                    
                                    }
                                });   
                            }
                               
                        });
                        nfaspane.getChildren().addAll(auto);
                        xpanel += 200;
                    }
                   String str = "NFA is created, define final states and transition functions.";
                    uptooltip(str, true, primaryStage); 
                }
                else{
                    String str = "Please control alphabet and states.";
                    uptooltip(str, false, primaryStage);
                }
                
            }
        });
       
        //konvertimi epsilon-nfa to nfa
        convertbutton2.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                totalstates.clear();
                lines.clear();
                ArrayList<Boolean> isfinal =  new ArrayList<Boolean>();
                for(int i = 0 ; i < totalstates3.size() ; i++){
                    Arrow arrowepsilon = new Arrow("ε", totalstates3.get(i), totalstates3.get(i));
                    totalstates3.get(i).addinarrow(arrowepsilon);
                    totalstates3.get(i).addoutarrow(arrowepsilon);
                    lines3.add(arrowepsilon);
                    Stateauto newstate =  new Stateauto(totalstates3.get(i).getText(), totalstates3.get(i).getLayoutX(), totalstates3.get(i).getLayoutY());
                    if(i == 0) newstate.setEntryarrow(totalstates3.get(i).getEntryarrow());
                    newstate.setStatefinal(totalstates3.get(i).getStatefinal());
                    totalstates.add(newstate);
                    isfinal.add(false);
                }
                
                
                for(int nrstate = 0 ; nrstate < totalstates3.size() ; nrstate++){
                    for(int nralfabet = 0 ; nralfabet < alfabet.size() ; nralfabet++){
                        ArrayList<Stateauto> epslonmove1 = new ArrayList<Stateauto>();
                        for(int nr = 0 ; nr < totalstates3.get(nrstate).getOutarrow().size() ; nr++){
                            
                            Arrow st = totalstates3.get(nrstate).getOutarrow().get(nr);
                            if(st.getAlfabet().equalsIgnoreCase("ε")){
                                boolean load = true;
                                for(int i = 0 ; i < epslonmove1.size() ; i++){
                                    if(epslonmove1.get(i).getText().equalsIgnoreCase(st.getEndstate().getText())){
                                        load = false;
                                        break;
                                    }
 
                                }
                                if(load){
                                    epslonmove1.add(st.getEndstate());
                                    if(st.getEndstate().getStatefinal())isfinal.set(nrstate, true);
                                }
                            }
                        }
                        for(int nr = 0 ; nr < epslonmove1.size() ; nr++){
                            for(int nr1 = 0 ; nr1 < epslonmove1.get(nr).getOutarrow().size() ; nr1++ ){
                                    Arrow st = epslonmove1.get(nr).getOutarrow().get(nr1);
                                    if(!st.getStartstate().getText().equalsIgnoreCase(st.getEndstate().getText())
                                            && st.getAlfabet().equalsIgnoreCase("ε")){
                                        
                                        
                                         boolean load = true;
                                        for(int i = 0 ; i < epslonmove1.size() ; i++){
                                            if(epslonmove1.get(i).getText().equalsIgnoreCase(st.getEndstate().getText())){
                                                load = false;
                                                break;
                                            }
 
                                        }
                                        if(load){
                                            epslonmove1.add(st.getEndstate());
                                            if(st.getEndstate().getStatefinal())isfinal.set(nrstate, true);
                                        }
                                    }
                            }
                        }
                        
                        
                        
                        ArrayList<Stateauto> alfmove = new ArrayList<Stateauto>();
                        for(int nr = 0 ; nr < epslonmove1.size() ; nr++){
                            for(int nr1 = 0 ; nr1 < lines3.size() ; nr1++){
                                if(epslonmove1.get(nr).getText().equalsIgnoreCase(lines3.get(nr1).getStartstate().getText())
                                        && lines3.get(nr1).getAlfabet().equalsIgnoreCase(alfabet.get(nralfabet))){
                                    
                                    
                                    boolean load = true;
                                    for(int i = 0 ; i < alfmove.size() ; i++){
                                        if(alfmove.get(i).getText().equalsIgnoreCase(lines3.get(nr1).getEndstate().getText())){
                                            load = false;
                                            break;
                                        }
 
                                    }
                                        if(load)
                                            alfmove.add(lines3.get(nr1).getEndstate());
                                           
                                }
                            }
                        }
                        
                        ArrayList<Stateauto> epsilonfinal = new ArrayList<Stateauto>();
                        for(int nr = 0 ; nr < alfmove.size() ; nr++){
                            for(int nr1 = 0 ; nr1 < alfmove.get(nr).getOutarrow().size() ; nr1++){
                                Arrow st = alfmove.get(nr).getOutarrow().get(nr1);
                                if(st.getAlfabet().equalsIgnoreCase("ε")){
                                    boolean load = true;
                                    for(int i = 0 ; i < epsilonfinal.size() ; i++){
                                        if(epsilonfinal.get(i).getText().equalsIgnoreCase(st.getEndstate().getText())){
                                            load = false;
                                            break;
                                        }
 
                                    }
                                    if(load){
                                        epsilonfinal.add(st.getEndstate());
                                        
                                    }
                                }
                            }
                        }
                        for(int nr = 0 ; nr < epsilonfinal.size() ; nr++){
                            for(int nr1 = 0 ; nr1 < epsilonfinal.get(nr).getOutarrow().size() ; nr1++ ){
                                    Arrow st = epsilonfinal.get(nr).getOutarrow().get(nr1);
                                    if(!st.getStartstate().getText().equalsIgnoreCase(st.getEndstate().getText())
                                            && st.getAlfabet().equalsIgnoreCase("ε")){
                                        
                                        
                                         boolean load = true;
                                        for(int i = 0 ; i < epsilonfinal.size() ; i++){
                                            if(epsilonfinal.get(i).getText().equalsIgnoreCase(st.getEndstate().getText())){
                                                load = false;
                                                break;
                                            }
 
                                        }
                                        if(load){
                                            epsilonfinal.add(st.getEndstate());
                                            
                                        }
                                    }
                            }
                        }
                        
                        for(int l = 0 ; l < totalstates.size() ;l++){
                            if(totalstates.get(l).getText().equalsIgnoreCase(totalstates3.get(nrstate).getText())){
                               
                                for(int k = 0 ; k < epsilonfinal.size() ; k++){
                                    for(int p = 0; p < totalstates.size() ; p++){
                                        if(totalstates.get(p).getText().equalsIgnoreCase(epsilonfinal.get(k).getText())){
                                            Arrow newarrow = new Arrow(alfabet.get(nralfabet), totalstates.get(l), totalstates.get(p));
                                            totalstates.get(l).addoutarrow(newarrow);
                                            totalstates.get(p).addinarrow(newarrow);
                                            lines.add(newarrow);
                                        }
                                    }

                                }
                            }
                            totalstates.get(l).setStatefinal(isfinal.get(l));
                        }
                       
                     
                    }
                }
                
               System.out.println("Gjendjet : "+totalstates);
               System.out.println("funksionet : "+lines);
               if(totalstates.size() > 0 && lines.size() > 0){
               boolean hasfinal = false;
               for(int k = 0 ; k < totalstates.size() ; k++){
                   if(totalstates.get(k).getStatefinal() == true) {
                       hasfinal = true;
                       break;
                   }
               }
               if(hasfinal){
               convertbutton2.setVisible(false);
               Label label = new Label("NFA");
               label.setStyle("-fx-font-size:20px;");
               label.setLayoutX(150);
               label.setLayoutY(765);
               nfaspane.setLayoutX(150);
               nfaspane.setLayoutY(800);
               convertbutton.setLayoutX(800);
               convertbutton.setLayoutY(1650);
               pane.getChildren().addAll(convertbutton,label,nfaspane,lines3pane);
               status = "move";
               btn2.setSelected(true);
               for(int i = 0 ; i < totalstates.size() ; i++){
                   nfaspane.getChildren().addAll(totalstates.get(i));
                   if(i == 0){
                       totalstates.get(i).setEntryarrow(new Entryarrow(totalstates.get(i)));
                       nfaspane.getChildren().addAll(totalstates.get(i).getEntryarrow().getLine1(),totalstates.get(i).getEntryarrow().getLine2());
                   }
                   
                   Stateauto sta = totalstates.get(i);
                   sta.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e) {
                   nfaspane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            if(status.equalsIgnoreCase("move")){
                                System.out.println(event.getSceneX());
                                System.out.println(event.getSceneY());
                                sta.setLayoutX(event.getX()-50);
                                sta.setLayoutY(event.getY()-50);
                                ArrayList<Arrow> arrowmovein = sta.getInarrow();
                                for( Arrow a : arrowmovein){
                                    a.moveline();
                                }
                                ArrayList<Arrow> arrowmoveout = sta.getOutarrow();
                                for( Arrow a : arrowmoveout){
                                    a.moveline();
                                }
                                if(sta.getEntryarrow()!= null)sta.getEntryarrow().moveline();
                            }
                                    
                        }
                    });
                    }
                });
                       
               }
                ArrayList<Arrow> loadarrow =  new ArrayList<Arrow>();
                        for(int i = 0 ; i < lines.size(); i++){
                            boolean load =  true;
                            for(int j = 0 ; j < loadarrow.size() ; j++){
                                if(lines.get(i).getStartstate().getText().equalsIgnoreCase(loadarrow.get(j).getStartstate().getText())
                                        && lines.get(i).getEndstate().getText().equalsIgnoreCase(loadarrow.get(j).getEndstate().getText())){
                                    load = false;
                                    loadarrow.get(j).addletterinlabel(lines.get(i).getAlfabet());
                                }
                            }
                            if(load){
                                loadarrow.add(lines.get(i));
                            }
                        }
                        for(int i = 0 ; i < loadarrow.size() ; i++){
                            nfaspane.getChildren().addAll(loadarrow.get(i),loadarrow.get(i).getLine1(),loadarrow.get(i).getLine2(),loadarrow.get(i).getLabel());
                            loadarrow.get(i).moveline();
                        }
                        
                        for(int a = 0 ; a < lines.size() ; a++){
                        
                            Label lines2label =  new Label("     "+lines.get(a).toString());
                            lines2label.setStyle("-fx-font-size:20");
                            lines3pane.getChildren().addAll(lines2label);
                        
                        }
                        
                        String str = "Automata is conververted successfully.";
                        uptooltip(str, true, primaryStage);
               }
               else{
                   String str = "Please define final states.";
                   uptooltip(str, false, primaryStage); 
               }
               }
               else{
                   String str = "First you must create a ε-NFA and then convert it into a NFA.";
                   uptooltip(str, false, primaryStage);
               }
            }
        });
       //implementimi i DFA
       
        
       
       convertbutton.setLayoutX(800);
       convertbutton.setLayoutY(750);
       convertbutton.setStyle("-fx-font-size:18px;-fx-base: lightgreen;");
       
       //konvertimi nfa to dfa
       convertbutton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
              totalstates2.clear();
              lines2.clear();
               ArrayList<Stateauto> finalstatelist = new ArrayList<Stateauto>();
               for(int g = 0 ; g < totalstates.size() ; g++){
                   if(totalstates.get(g).getStatefinal())
                       finalstatelist.add(totalstates.get(g));
               }
               Stateauto firststate = new Stateauto("q0", 0, 0);
               firststate.setStatefinal(totalstates.get(0).getStatefinal());
                //totalstates2.add(totalstates.get(0));
                totalstates2.add(firststate);
                for(int i = 0 ; i < totalstates2.size() ; i++){
                    for(int j = 0 ; j < alfabet.size() ; j++){
                        boolean setfinal = false;
                        ArrayList<Stateauto> liststate = new ArrayList<Stateauto>();
                        if(totalstates2.get(i).getState().size() > 0){
                            ArrayList<Stateauto> tmpstate = totalstates2.get(i).getState();
                            for(int k = 0 ; k < tmpstate.size() ; k++){
                                for(int l = 0 ; l < lines.size() ; l++){
                                    if(tmpstate.get(k).getText().equalsIgnoreCase(lines.get(l).getStartstate().getText())
                                            && alfabet.get(j).equalsIgnoreCase(lines.get(l).getAlfabet())){
                                        boolean loadinliststate = true;
                                        for(int p = 0 ; p < liststate.size() ; p++){
                                            if(lines.get(l).getEndstate().getText().equalsIgnoreCase(liststate.get(p).getText()))
                                                loadinliststate = false;
                                        }
                                        if(loadinliststate){
                                            liststate.add(lines.get(l).getEndstate());
                                        }
                                    }
                                }
                            }
                        }
                        else{
                            for(int l = 0 ; l < lines.size() ; l++){
                                Stateauto tmpstate = totalstates2.get(i);
                                if(tmpstate.getText().equalsIgnoreCase(lines.get(l).getStartstate().getText())
                                        && alfabet.get(j).equalsIgnoreCase(lines.get(l).getAlfabet())){
                                    boolean loadinliststate = true;
                                    for(int p = 0 ; p < liststate.size() ; p++){
                                        if(lines.get(l).getEndstate().getText().equalsIgnoreCase(liststate.get(p).getText()))
                                            loadinliststate = false;
                                    }
                                    if(loadinliststate){
                                        liststate.add(lines.get(l).getEndstate());
                                    }
                                       
                                }
                            }
                        }
                        if(liststate.size() > 0){
                            for(int p = 0 ; p < liststate.size() ; p++){
                                for(int p1 = 0 ; p1 < finalstatelist.size() ; p1++){
                                    if(liststate.get(p).getText().equalsIgnoreCase(finalstatelist.get(p1).getText()))
                                        setfinal = true ;
                                }
                            }
                            
                            String statename = "";
                            for(int p = 0 ; p < liststate.size() ; p++){
                                if(statename == "") statename = liststate.get(p).getText();
                                else statename = statename + "," + liststate.get(p).getText();
                            }
                            ArrayList<Integer> listtmpname = new ArrayList<Integer>();
                            for(int p = 0 ; p < statename.length() ; p++){
                                if(statename.charAt(p) != 'q' && statename.charAt(p) != ','){
                                    listtmpname.add((int)statename.charAt(p));
                                }
                            }
                            int tmp;
                            for(int p = 0 ; p < listtmpname.size()-1 ; p++){
                                for(int p1 = p+1 ; p1 < listtmpname.size() ; p1++){
                                    if(listtmpname.get(p) > listtmpname.get(p1)){
                                        tmp = listtmpname.get(p);
                                        listtmpname.set(p, listtmpname.get(p1));
                                        listtmpname.set(p1, tmp);
                                    }
                                }
                            }
                            statename = "";
                            for(int p = 0 ; p < listtmpname.size() ; p++){
                                int a = listtmpname.get(p);
                                char n = (char)a;
                                if(statename == "") statename = "q" + n;
                                else statename = statename + ",q" + n;
                            }
                            
                            Stateauto statefinal = new Stateauto(statename, 0, 0);
                            statefinal.setState(liststate);
                            statefinal.setStatefinal(setfinal);
                            
                            boolean loadstate = true;
                            int poz = 0;
                            for(int a = 0 ; a < totalstates2.size() ; a++){
                                if(statename.equalsIgnoreCase(totalstates2.get(a).getText())){
                                    loadstate = false;
                                    poz = a ;
                                }
                                    
                            }
                            if(loadstate){
                                
                                Arrow newarrow = new Arrow(alfabet.get(j), totalstates2.get(i), statefinal);
                                totalstates2.get(i).addoutarrow(newarrow);
                                statefinal.addinarrow(newarrow);
                                totalstates2.add(statefinal);
                                lines2.add(newarrow);
                            }
                            else{
                                Arrow newarrow = new Arrow(alfabet.get(j), totalstates2.get(i), totalstates2.get(poz));
                                totalstates2.get(i).addoutarrow(newarrow);
                                totalstates2.get(poz).addinarrow(newarrow);
                                
                                lines2.add(newarrow);
                            }
                                
                            
                            
                        }
                        
                    }
                }
                
                System.out.println("Gjendjet jane : "+totalstates2);
                System.out.println("kalimet : "+lines2);
                
                if(totalstates2.size() > 0 && lines2.size() > 0){
                    boolean hasfinal = false;
                    for(int k = 0 ; k < totalstates2.size() ; k++){
                        if(totalstates2.get(k).getStatefinal() == true) {
                            hasfinal = true;
                            break;
                        }
                    }
                    if(hasfinal){
                        Stateauto errorauto = new Stateauto("ERROR",800, 480);
                        errorauto.setOnAction(new EventHandler<ActionEvent>() {

                            public void handle(ActionEvent e) {
                                faspane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                 public void handle(MouseEvent event) {
                                    if(status.equalsIgnoreCase("move")){
                                    System.out.println(event.getSceneX());
                                    System.out.println(event.getSceneY());
                                    errorauto.setLayoutX(event.getX()-50);
                                    errorauto.setLayoutY(event.getY()-50);
                                    ArrayList<Arrow> arrowmovein = errorauto.getInarrow();
                                        for( Arrow a : arrowmovein){
                                            a.moveline();
                                        }
                                    ArrayList<Arrow> arrowmoveout = errorauto.getOutarrow();
                                    for( Arrow a : arrowmoveout){
                                        a.moveline();
                                    }
                                }
                                    
                            }
                        });
                    }
                });
                faspane.getChildren().add(errorauto);
                    convertbutton.setVisible(false);
                    if(epsilon){
                    Label label = new Label("DFA");
                    label.setStyle("-fx-font-size:20px;");
                    label.setLayoutX(150);
                    label.setLayoutY(1670);
                    faspane.setLayoutY(1700);
                    lines2pane.setLayoutY(2370);
                    pane.getChildren().addAll(faspane,lines2pane,label);
                    }
                    else{
                    Label label = new Label("DFA");
                    label.setStyle("-fx-font-size:20px;");
                    label.setLayoutX(150);
                    label.setLayoutY(765);
                    pane.getChildren().addAll(faspane,lines2pane,label);
                    }
                     
                    
                    status = "move";
                    btn2.setSelected(true);
                    double xpanel = 100;
                    double ypanel = 50;
                    for(int i = 0 ; i < totalstates2.size() ; i++){
                        if(xpanel > 700){
                           xpanel = 100;
                           ypanel +=200;
                        }
                        Stateauto statefas = totalstates2.get(i);
                        statefas.setLayoutX(xpanel);
                        statefas.setLayoutY(ypanel);
                        if(i == 0 ){
                           statefas.setEntryarrow(new Entryarrow(statefas));
                           faspane.getChildren().addAll(statefas.getEntryarrow().getLine1(),statefas.getEntryarrow().getLine2());
                       }
                        statefas.setOnAction(new EventHandler<ActionEvent>() {
                           
                           public void handle(ActionEvent e1) {
                             
                               faspane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                   @Override
                                   public void handle(MouseEvent event) {
                                       if(status.equalsIgnoreCase("move")){
                                       System.out.println(event.getSceneX());
                                       System.out.println(event.getSceneY());
                                       statefas.setLayoutX(event.getX()-50);
                                       statefas.setLayoutY(event.getY()-50);
                                       ArrayList<Arrow> arrowmovein = statefas.getInarrow();
                                       for( Arrow a : arrowmovein){
                                           a.moveline();
                                       }
                                       ArrayList<Arrow> arrowmoveout = statefas.getOutarrow();
                                       for( Arrow a : arrowmoveout){
                                           a.moveline();
                                       }
                                       if(statefas.getEntryarrow() != null)statefas.getEntryarrow().moveline();
                                       }
                                    
                                    }
                                });   
                            }
                               
                       });
                        faspane.getChildren().addAll(totalstates2.get(i));
                        xpanel += 200;
                        
                   } 
                    
                    for(int p = 0 ; p < lines2.size() ; p++){
                        faspane.getChildren().addAll(lines2.get(p),lines2.get(p).getLine1(),lines2.get(p).getLine2(),lines2.get(p).getLabel());
                        lines2.get(p).moveline();
                    }
                    
                    for(int a = 0 ; a < alfabet.size() ; a++){
                        
                        for(int g = 0 ; g< totalstates2.size() ; g++){
                            boolean load = true;
                            for(int f = 0 ; f < lines2.size() ; f++){
                                if(totalstates2.get(g).getText().equalsIgnoreCase(lines2.get(f).getStartstate().getText())
                                        && alfabet.get(a).equalsIgnoreCase(lines2.get(f).getAlfabet())){
                                    load = false;
                                }
                            }
                            if(load){
                                Arrow newarrow = new Arrow(alfabet.get(a), totalstates2.get(g), errorauto);
                                totalstates2.get(g).addoutarrow(newarrow);
                                errorauto.addinarrow(newarrow);
                                lines2.add(newarrow);
                                faspane.getChildren().addAll(newarrow,newarrow.getLine1(),newarrow.getLine2(),newarrow.getLabel());
                            }
                        }
                    }
                    
                    Arrow arrowerror =  new Arrow(alfabet.get(0), errorauto, errorauto);
                    errorauto.addinarrow(arrowerror);
                    errorauto.addoutarrow(arrowerror);
                    faspane.getChildren().addAll(arrowerror,arrowerror.getLine1(),arrowerror.getLine2(),arrowerror.getLabel());
                    for(int a = 1 ; a < alfabet.size() ; a++){
                        
                        arrowerror.addletterinlabel(alfabet.get(a));
                        
                    }
              
                    for(int a = 0 ; a < lines2.size() ; a++){
                        
                        Label lines2label =  new Label("     "+lines2.get(a).toString());
                        lines2label.setStyle("-fx-font-size:20");
                        lines2pane.getChildren().addAll(lines2label);
                    }
                    String str = "Automata is conververted successfully.";
                    uptooltip(str, true, primaryStage);
                    }
                    else{
                        String str = "Please define final states.";
                        uptooltip(str, false, primaryStage); 
                    }
                }
                  
                else{
                    String str = "First you must create a NFA and then convert it into a DFA.";
                    uptooltip(str, false, primaryStage);
                }
            }
            
                
        });
       //konvertimi DFA to min-DFA
      convertbutton3.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
              totalstates4.clear();
              lines3.clear();
              boolean isfinal = false;
              for( int isfin = 0 ; isfin < totalstates2.size() ; isfin++){
                  if(totalstates2.get(isfin).getStatefinal() == true){
                      isfinal = true;
                      break;
                  }
              }
              if(isfinal == true){
                  if(lines2.size()>0){
                      //elemini i gjendjeve te pa kapshme
                      ArrayList<Stateauto> gjendetekapshme =  new ArrayList<Stateauto>();
                      gjendetekapshme.add(totalstates2.get(0));
                      for(int a = 0 ; a < gjendetekapshme.size() ; a++){
                          for(int b = 0 ; b < gjendetekapshme.get(a).getOutarrow().size() ; b++){
                              boolean load = true;
                              for( int c = 0 ; c < gjendetekapshme.size() ; c++){
                                  if(gjendetekapshme.get(c).getText().equalsIgnoreCase(gjendetekapshme.get(a).getOutarrow().get(b).getEndstate().getText())){
                                      load = false;
                                      break;
                                  }
                              }
                              if(load == true)gjendetekapshme.add(gjendetekapshme.get(a).getOutarrow().get(b).getEndstate());
                          }
                      }
                   
                      //renditja e gjendjeve te kapshme
                      Stateauto stauto =  new Stateauto("-1", 0, 0);
                      for(int i = 0 ; i < gjendetekapshme.size()-1 ; i++){
                          for(int j = i+1 ; j < gjendetekapshme.size() ; j++){
                              if(Integer.parseInt(gjendetekapshme.get(i).getText().substring(1))
                                      >Integer.parseInt(gjendetekapshme.get(j).getText().substring(1))){
                                  stauto = gjendetekapshme.get(i);
                                  gjendetekapshme.set(i, gjendetekapshme.get(j)); 
                                  gjendetekapshme.set(j,stauto);
                              }
                          }
                      }
                      System.out.println("gjendje te pakapshme"+gjendetekapshme);
                      //kontrolli per gjendje fundore ne gjendjet e kapshme
                      boolean go = false;
                      for(int i = 0 ; i < gjendetekapshme.size() ; i++){
                          if(gjendetekapshme.get(i).getStatefinal() == true){
                              go = true;
                              break;
                          }
                      }
                      if(go == true){
                          
                          //krijimi i matrices
                          ArrayList<Stateauto>matric = new ArrayList<Stateauto>();
                          for(int i = 0 ; i < gjendetekapshme.size() ; i++){
                            for( int j = 0 ; j < gjendetekapshme.size() ; j++){
                                if(i != j){
                                  Stateauto tmpauto =  new Stateauto(gjendetekapshme.get(i).getText()+","+gjendetekapshme.get(j).getText(), 0, 0);
                                  tmpauto.addState(gjendetekapshme.get(i));
                                  tmpauto.addState(gjendetekapshme.get(j));
                                  matric.add(tmpauto);
                                }
                            }
                        }
                        System.out.println("matrica "+matric);
                        //gjendjet e markuara
                        ArrayList<Stateauto>markedstate =  new ArrayList<Stateauto>();
                        for(int i = 0 ; i < matric.size() ; ){
                            if(matric.get(i).getState().get(0).getStatefinal() == true 
                                    && matric.get(i).getState().get(1).getStatefinal() == false ){
                                markedstate.add(matric.get(i));
                                matric.remove(i);
                            }
                            else i++;
                        }
                        System.out.println("gjendjet e markuara ne fillim:"+markedstate);
                        int pos = 0;
                       while(pos != matric.size()){
                            boolean marked = false;
                            String tmpnamestate1 = "";
                            String tmpnamestate2 = "";
                            for(int a = 0 ; a < alfabet.size() ; a++){
                                for(int b = 0 ; b < matric.get(pos).getState().get(0).getOutarrow().size() ; b++){
                                    if(alfabet.get(a).equalsIgnoreCase(matric.get(pos).getState().get(0).getOutarrow().get(b).getAlfabet())){
                                        tmpnamestate1 = matric.get(pos).getState().get(0).getOutarrow().get(b).getEndstate().getText();
                                        break;
                                    }
                                }
                                for(int c = 0 ; c < matric.get(pos).getState().get(1).getOutarrow().size() ; c++){
                                    if(alfabet.get(a).equalsIgnoreCase(matric.get(pos).getState().get(1).getOutarrow().get(c).getAlfabet())){
                                        tmpnamestate2 = matric.get(pos).getState().get(1).getOutarrow().get(c).getEndstate().getText();
                                        break;
                                    }
                                }
                                if(tmpnamestate1.length() > 0 && tmpnamestate2.length() > 0){
                                    for( int d = 0 ; d < markedstate.size() ; d++){
                                        if(markedstate.get(d).getText().equalsIgnoreCase(tmpnamestate1+","+tmpnamestate2)||
                                                markedstate.get(d).getText().equalsIgnoreCase(tmpnamestate2+","+tmpnamestate1)){
                                            marked = true;
                                            markedstate.add(matric.get(pos));
                                            matric.remove(pos);
                                            break;
                                        }
                                       
                                    }
                                }
                                if(marked == true)break;
                            }
                            if(marked == true)pos = 0;
                            else pos++;
                        }
                        System.out.println("gjendjet e markuara:"+markedstate);
                        System.out.println("gjendjet e pa markuara:"+matric);
                        
                        //krijimi i gjendjeve
                        
                        if(matric.size() > 0 ){
                            totalstates4.add(matric.get(0));
                            matric.remove(0);
                            for( int a = 0 ; a < matric.size() ; a++){
                                for( int b = 0 ; b < totalstates4.size() ; b++){
                                     boolean canload = false;
                                   for( int c = 0 ; c <  totalstates4.get(b).getState().size() ; c++){
                                       for( int d = 0 ; d < matric.get(a).getState().size() ; d++){
                                           if( totalstates4.get(b).getState().get(c).getText()
                                                   .equalsIgnoreCase(matric.get(a).getState().get(d).getText())){
                                               canload = true;
                                               break;
                                           }
                                       }
                                       if(canload == true) break;
                                   }
                                   if(canload == true){
                                       
                                       for( int f = 0 ; f < matric.get(a).getState().size() ; f++){
                                           boolean load = true;
                                            for(int g = 0 ; g <  totalstates4.get(b).getState().size() ; g++ ){
                                                if(totalstates4.get(b).getState().get(g).getText()
                                                   .equalsIgnoreCase(matric.get(a).getState().get(f).getText())){
                                                    load = false;
                                                    break;
                                                }        
                                            }
                                            if(load =true){
                                                totalstates4.get(b).setText(totalstates4.get(b).getText() +","+matric.get(a).getState().get(f).getText() );
                                                totalstates4.get(b).addState(matric.get(a).getState().get(f));
                                            }
                                        }
                                   }
                                   else{
                                       totalstates4.add(matric.get(a));
                                   }
                                }
                            }
                        }
                        System.out.println("gjendjet perfundimtare 1:"+totalstates4);
                        
                        ArrayList<Stateauto> gjeperbera = new ArrayList<Stateauto>();
                        for(int a = 0 ; a < totalstates4.size() ; a++){
                            if(totalstates4.get(a).getState().size() > 0){
                                ArrayList<Stateauto> tmpst =  new ArrayList<Stateauto>();
                                //tmpst.add(totalstates4.get(a).getState().get(0));
                                for( int b = 0 ; b < totalstates4.get(a).getState().size() ; b++){
                                    boolean load = true;
                                    for(int c = 0 ; c < tmpst.size() ; c++){
                                        if(totalstates4.get(a).getState().get(b).getText().equalsIgnoreCase(tmpst.get(c).getText())){
                                            load = false;
                                            break;
                                        }
                                    }
                                    if(load == true){
                                        tmpst.add(totalstates4.get(a).getState().get(b));
                                    }
                                }
                                boolean isfinal1 = false;
                                String stname =  tmpst.get(0).getText();
                                gjeperbera.add(tmpst.get(0));
                                for(int d = 1 ; d < tmpst.size() ; d++){
                                    if(tmpst.get(d).getStatefinal() == true) isfinal1 = true;
                                    gjeperbera.add(tmpst.get(d));
                                    stname = stname + "," + tmpst.get(d).getText();
                                }
                                System.out.println("tmpst"+tmpst.size());
                                totalstates4.get(a).setState(tmpst);
                                totalstates4.get(a).setText(stname);
                                totalstates4.get(a).setStatefinal(isfinal1);
                                totalstates4.get(a).setLayoutX(tmpst.get(0).getLayoutX());
                                totalstates4.get(a).setLayoutY(tmpst.get(0).getLayoutY());
                            }
                        }
                        
                       
                        System.out.println("gjendjet e perbera "+gjeperbera);
                        for(int a = 0 ; a <gjeperbera.size() ; a++){
                            gjendetekapshme.remove(gjeperbera.get(a));
                        }
                        for( int b = 0 ; b <gjendetekapshme.size() ; b++){
                            Stateauto tmp =  new Stateauto("t", 0, 0);
                            tmp.setText(gjendetekapshme.get(b).getText());
                            tmp.setStatefinal(gjendetekapshme.get(b).getStatefinal());
                            tmp.setLayoutX(gjendetekapshme.get(b).getLayoutX());
                            tmp.setLayoutY(gjendetekapshme.get(b).getLayoutY());
                            
                            totalstates4.add(tmp);
                        }
                        ArrayList<Stateauto> stautotmp = new ArrayList<Stateauto>();
                        for(int a = 0 ; a < totalstates4.size(); a++){
                            if(totalstates4.get(a).getState().size() > 0 )
                                stautotmp.add(totalstates4.get(a));
                        }
                        System.out.println("gjendjet perfundimtare 2:"+totalstates4);
                        for(int a = 0 ; a < lines2.size(); a++){
                            Arrow linetmp = new Arrow("0", new Stateauto("0", 0, 0), new Stateauto("0", 0, 0));
                            Stateauto s1 = new Stateauto("0", 0, 0);
                            Stateauto s2 = new Stateauto("0", 0, 0);
                            for(int b = 0 ; b < totalstates4.size() ; b++){
                                if(totalstates4.get(b).getText().equalsIgnoreCase(lines2.get(a).getStartstate().getText())){
                                    linetmp.setStartstate(totalstates4.get(b));
                                    s1 = totalstates4.get(b);
                                    break;
                                }
                            }
                            if(linetmp.getStartstate().getText().equalsIgnoreCase("0")){
                                for(int c = 0 ; c < stautotmp.size() ; c++){
                                    for(int d = 0 ; d < stautotmp.get(c).getState().size() ; d++){
                                        if(stautotmp.get(c).getState().get(d).getText().equalsIgnoreCase(lines2.get(a).getStartstate().getText())){
                                            linetmp.setStartstate(stautotmp.get(c));
                                            s1 = stautotmp.get(c);
                                            break;
                                        }
                                    }
                                    if(!linetmp.getStartstate().getText().equalsIgnoreCase("0")){
                                        break;
                                    }
                                }
                            }
                            if(!linetmp.getStartstate().getText().equalsIgnoreCase("0")){
                                for(int f = 0 ; f < totalstates4.size() ; f++){
                                    if(totalstates4.get(f).getText().equalsIgnoreCase(lines2.get(a).getEndstate().getText())){
                                        linetmp.setEndstate(totalstates4.get(f));
                                        s2 = totalstates4.get(f);
                                        break;
                                    }
                                }
                                if(linetmp.getEndstate().getText().equalsIgnoreCase("0")){
                                    for(int g = 0 ; g < stautotmp.size() ; g++){
                                        for(int h = 0 ; h < stautotmp.get(g).getState().size() ; h++){
                                            if(stautotmp.get(g).getState().get(h).getText().equalsIgnoreCase(lines2.get(a).getEndstate().getText())){
                                                linetmp.setEndstate(stautotmp.get(g));
                                                s2 = stautotmp.get(g);
                                                break;
                                            }
                                        }
                                        if(!linetmp.getStartstate().getText().equalsIgnoreCase("0")){
                                            break;
                                        }
                                    }
                                    
                                }
                            }
                            if(!linetmp.getStartstate().getText().equalsIgnoreCase("0")
                                    && !linetmp.getEndstate().getText().equalsIgnoreCase("0")){
                                linetmp.setAlfabet(lines2.get(a).getAlfabet());
                                boolean loadlines = true;
                                for(int n = 0 ; n < lines4.size() ; n++){
                                    if(lines4.get(n).getStartstate().getText().equalsIgnoreCase(linetmp.getStartstate().getText())
                                            && lines4.get(n).getEndstate().getText().equalsIgnoreCase(linetmp.getEndstate().getText())
                                            && lines4.get(n).getAlfabet().equalsIgnoreCase(linetmp.getAlfabet())){
                                        loadlines = false;
                                        break;
                                    }
                                }
                                if(loadlines == true){
                                    lines4.add(linetmp);
                                    s1.addoutarrow(linetmp);
                                    s2.addinarrow(linetmp);
                                }
                            }
                            
                        }
                        System.out.println("lidhjet jane "+lines4);
                        System.out.println("dalje "+ totalstates4.get(0).getOutarrow());
                        System.out.println("hyrje "+totalstates4.get(0).getInarrow());
                        convertbutton3.setVisible(false);
                        Label label = new Label("Minimization of DFA");
                        label.setStyle("-fx-font-size:20px;");
                        label.setLayoutX(150);
                        label.setLayoutY(765);
                        pane.getChildren().addAll(dfaspanee,lines4pane,label);
                        
                        status = "move";
                        btn2.setSelected(true);
                         for(int i = 0 ; i < totalstates4.size() ; i++){
                            dfaspanee.getChildren().addAll(totalstates4.get(i));
                        if(totalstates4.get(i).getText().equalsIgnoreCase("q0")){
                            totalstates4.get(i).setEntryarrow(new Entryarrow(totalstates4.get(i)));
                            dfaspanee.getChildren().addAll(totalstates4.get(i).getEntryarrow().getLine1(),totalstates4.get(i).getEntryarrow().getLine2());
                        }
                   
                   Stateauto sta = totalstates4.get(i);
                   sta.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e) {
                   dfaspanee.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            if(status.equalsIgnoreCase("move")){
                                System.out.println(event.getSceneX());
                                System.out.println(event.getSceneY());
                                sta.setLayoutX(event.getX()-50);
                                sta.setLayoutY(event.getY()-50);
                                ArrayList<Arrow> arrowmovein = sta.getInarrow();
                                for( Arrow a : arrowmovein){
                                    a.moveline();
                                }
                                ArrayList<Arrow> arrowmoveout = sta.getOutarrow();
                                for( Arrow a : arrowmoveout){
                                    a.moveline();
                                }
                                if(sta.getEntryarrow()!= null)sta.getEntryarrow().moveline();
                            }
                                    
                        }
                    });
                    }
                });
                       
               }
                ArrayList<Arrow> loadarrow =  new ArrayList<Arrow>();
                        for(int i = 0 ; i < lines4.size(); i++){
                            boolean load =  true;
                            for(int j = 0 ; j < loadarrow.size() ; j++){
                                if(lines4.get(i).getStartstate().getText().equalsIgnoreCase(loadarrow.get(j).getStartstate().getText())
                                        && lines4.get(i).getEndstate().getText().equalsIgnoreCase(loadarrow.get(j).getEndstate().getText())){
                                    load = false;
                                    loadarrow.get(j).addletterinlabel(lines4.get(i).getAlfabet());
                                }
                            }
                            if(load){
                                loadarrow.add(lines4.get(i));
                            }
                        }
                        for(int i = 0 ; i < loadarrow.size() ; i++){
                            dfaspanee.getChildren().addAll(loadarrow.get(i),loadarrow.get(i).getLine1(),loadarrow.get(i).getLine2(),loadarrow.get(i).getLabel());
                            loadarrow.get(i).moveline();
                        }
                        
                        for(int a = 0 ; a < lines4.size() ; a++){
                        
                            Label lines2label =  new Label("     "+lines4.get(a).toString());
                            lines2label.setStyle("-fx-font-size:20");
                            lines4pane.getChildren().addAll(lines2label);
                        
                        }
                        
                        String str = "Automata is minimized successfully.";
                        uptooltip(str, true, primaryStage);
                        
                      }
                      else{
                          
                          String str = "This conversion could not be performed.";
                          uptooltip(str, false, primaryStage); 
                      }
                        
                  }
                  else{
                      String str = "Please define transition functions.";
                      uptooltip(str, false, primaryStage); 
                  }
              }
              else{
                   String str = "Please define final states.";
                   uptooltip(str, false, primaryStage); 
              }
           
            }
            
                
        });
       
       
       
       
       
       VBox start =  new VBox(10);
       Button bt1 = new Button("ε-NFA to NFA to (optional) DFA ");
       bt1.setStyle("-fx-font-size:16px;");
       bt1.setPrefWidth(300);
       Button bt2 =  new Button("NFA to DFA ");
       bt2.setStyle("-fx-font-size:16px;");
       bt2.setPrefWidth(300);
       Button bt3 = new Button("Minimization of DFA");
       bt3.setStyle("-fx-font-size:16px;");
       bt3.setPrefWidth(300);
       Image bye = new Image(Start.class.getResourceAsStream("image/bye.png"));
       Button goodbye =  new Button("Goodbye",new ImageView(bye));
       goodbye.setPrefWidth(300);
       goodbye.setStyle("-fx-font-size:16px;");
       goodbye.setOnAction(e->{
           primaryStage.close();
       });
       start.getChildren().addAll(bt1,bt2,bt3,goodbye);
       start.setLayoutX(530);
       start.setLayoutY(200);
       start.setAlignment(Pos.CENTER);
       
       bt1.setOnAction(e->{
       
           alfabetcombobox.getItems().add("ε");
           label1.setText("ε-NFA");
           epsilon = true;
           hboxbutton.getChildren().clear();
           hboxbutton.getChildren().addAll(buttonnfase,btnremoveall);
           pane.getChildren().clear();
           pane.getChildren().addAll(hbox,panetool,nfaspanee,vboxdeltetarrow,donotdelete,label1);
           
                
       });
       bt2.setOnAction(e->{
            pane.getChildren().clear();
            pane.getChildren().addAll(hbox,panetool,nfaspane,vboxdeltetarrow,donotdelete,label1);
            hboxbutton.getChildren().addAll(buttonnfas,btnremoveall);
       
       });
       bt3.setOnAction(e->{
           minizim = true;
           label1.setText("DFA");
           hboxbutton.getChildren().clear();
           hboxbutton.getChildren().addAll(buttondfa,btnremoveall);
           faspane.setLayoutX(150);
           faspane.setLayoutY(150);
           pane.getChildren().clear();
           pane.getChildren().addAll(hbox,panetool,faspane,vboxdeltetarrow,donotdelete,label1);
       });
       
      
       Hyperlink link1 = new Hyperlink("https://youtu.be/4fh7u5Z9HyY");
       Image tutorial = new Image(Start.class.getResourceAsStream("image/tutorial.png"));
       Button link = new Button("Tutorial", new ImageView(tutorial));
       link.setStyle("-fx-font-size:16px;-fx-base:lightblue;");
       link.setLayoutX(20);
       link.setLayoutY(20);
       link.setPrefWidth(200);
       link.setOnAction(e->{
            getHostServices().showDocument(link1.getText());
       });
       String image1 = Start.class.getResource("image/bob.png").toExternalForm();
       String image2 = Start.class.getResource("image/alan.png").toExternalForm();
       Pane panealan =  new Pane();
       panealan.setStyle("-fx-background-image: url('" + image2 + "');"
               + "-fx-background-position: center;"
               + "-fx-background-repeat: no-repeat;"
               + "-fx-background-image-width: 200px;"
               + "-fx-background-image-height: 200px;");
       panealan.setPrefSize(300, 300);
       panealan.setLayoutX(1000);
       panealan.setLayoutY(170);

       HBox infobox =  new HBox();
       Label infolabel = new Label("For lessons and exercises visit: ");
       infolabel.setStyle("-fx-font-size:14px;");
       Hyperlink link3 = new Hyperlink("https://sites.google.com/a/fshn.edu.al/denisi/my-courses/teori-gjuhesh");
       link3.setStyle("-fx-font-size:14px;");
       infobox.setLayoutX(700);
       infobox.setLayoutY(700);
       link3.setOnAction(e->{
           getHostServices().showDocument(link3.getText());
       });
       infobox.getChildren().addAll(infolabel,link3);
       infobox.setAlignment(Pos.CENTER);
       
       HBox infobox1 =  new HBox();
       Label infolabel1 = new Label("For developer: ");
       infolabel1.setStyle("-fx-font-size:14px;");
       Hyperlink link4 = new Hyperlink("https://github.com/enocuka/Finite-Automata");
       link4.setStyle("-fx-font-size:14px;");
       infobox1.setLayoutX(20);
       infobox1.setLayoutY(700);
       link4.setOnAction(e->{
           getHostServices().showDocument(link4.getText());
       });
       infobox1.getChildren().addAll(infolabel1,link4);
       infobox1.setAlignment(Pos.CENTER);
       
       btnremoveall.setStyle("-fx-font-size:18px;-fx-base: lightblue;");                             
       btnremoveall.setOnAction(e->{
        
           totalstates = new ArrayList<Stateauto>();
           totalstates2 = new ArrayList<Stateauto>();
           totalstates3 = new ArrayList<Stateauto>();
           lines = new ArrayList<Arrow>();
           lines2 = new ArrayList<Arrow>();
           lines3 = new ArrayList<Arrow>();
           epsilon = false;
           minizim = false;
           alfabet =  new ArrayList<String>();
           states = 0;
           status = "select";
           btn1.setSelected(true);
           statelabel.setText(" = {}");
           alfabetcombobox.getItems().clear();
           vboxdeltetarrow.getChildren().clear();
           nfaspane.getChildren().clear();
           nfaspanee.getChildren().clear();
           faspane.getChildren().clear();
           dfaspanee.getChildren().clear();
           lines2pane.getChildren().clear();
           lines3pane.getChildren().clear();
           lines4pane.getChildren().clear();
           hboxbutton.getChildren().clear();
           faspane.setVisible(true);
           lines2pane.setVisible(true);
           convertbutton.setVisible(true);
           convertbutton3.setVisible(true);
           convertbutton2.setVisible(true);
           buttonnfas.setVisible(true);
           buttonnfase.setVisible(true);
           buttondfa.setVisible(true);
           label1.setText("NFA");
           convertbutton.setLayoutX(800);
           convertbutton.setLayoutY(750);
           nfaspane.setLayoutX(150);
           nfaspane.setLayoutY(150);
           nfaspanee.setLayoutX(150);
           nfaspanee.setLayoutY(150);
           faspane.setLayoutX(150);
           faspane.setLayoutY(800);
           lines2pane.setLayoutX(150);
           lines2pane.setLayoutY(1450);
           lines3pane.setLayoutX(150);
           lines3pane.setLayoutY(1450);
           label1.setLayoutX(150);
           label1.setLayoutY(120);
           pane.getChildren().clear();
           pane.getChildren().addAll(start,donotdelete,link,panealan,infobox,infobox1);
           //pane.getChildren().addAll(hbox,panetool,nfaspane,vboxdeltetarrow,donotdelete,label1);
          
            
       });
       
       //hboxbutton.getChildren().addAll(buttonnfas,btnremoveall);
       buttonnfas.setPrefHeight(50);
       btnremoveall.setPrefHeight(50);
       
       hbox.getChildren().addAll(hboxalfabet,hboxstates,hboxbutton);
       hbox.setLayoutX(165);
       hbox.setLayoutY(50);
       
       // pane.getChildren().addAll(hbox,panetool,nfaspane,vboxdeltetarrow,donotdelete,checkbox,label1);
        pane.getChildren().addAll(start,donotdelete,link,panealan,infobox,infobox1);
        
        sppane.setContent(pane);
       
        Scene scene = new Scene(sppane, 1270, 720);
        primaryStage.setTitle("Finite Automata - Copyright © 2016 Eno Çuka");
        primaryStage.setScene(scene);
        primaryStage.setFullScreenExitHint("Finite Automata\nPress ESC to exit full-screen mode");
        primaryStage.setFullScreen(true);
        primaryStage.getIcons().add(imgbtn4);
        primaryStage.show();
    }
    void uptooltip(String s,boolean bool,Stage primaryStage){
        if(bool)tooltip.setGraphic(new ImageView(imgok));
        else tooltip.setGraphic(new ImageView(imgwrong));
        tooltip.setText(s);
        tooltip.show(primaryStage);
        timeline = new Timeline(new KeyFrame(
                            
            Duration.millis(3500),
                ae ->{
                    tooltip.hide();
                    timeline.stop();
                    } 
            ));
        timeline.play();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
