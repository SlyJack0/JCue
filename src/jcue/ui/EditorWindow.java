/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcue.ui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Jaakko
 */
public class EditorWindow extends JFrame {
    
    private JButton audioButton, eventButton, changeButton;
    
    private JList cueList;
    private JButton upButton, downButton, deleteButton;
    
    private JTabbedPane editorTabs;
    private JPanel basicPanel, effectPanel;
    
    public EditorWindow() {
        super("Cue - Editor");
        this.setPreferredSize(new Dimension(960, 720));
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        
        createComponents(this.getContentPane());
        
        this.pack();
    }

    private void createComponents(Container container) {
        //Buttons for adding new cues
        this.audioButton = new JButton("Audio cue");
        this.audioButton.setMargin(new Insets(10, 10, 10, 10));
        
        this.eventButton = new JButton("Event cue");
        this.eventButton.setMargin(new Insets(10, 10, 10, 10));
        
        this.changeButton = new JButton("Level change cue");
        this.changeButton.setMargin(new Insets(10, 10, 10, 10));
        
        this.cueList = new JList();
        this.cueList.setPreferredSize(new Dimension(200, 100));
        //**********
        
        //Buttons for managing cue list
        this.upButton = new JButton("^");
        this.downButton = new JButton("V");
        this.deleteButton = new JButton("X");
        //**********
        
        //Panels for cue controls
        this.basicPanel = new JPanel();
        this.basicPanel.setBackground(Color.WHITE);
        
        this.effectPanel = new JPanel();
        this.effectPanel.setBackground(Color.WHITE);
        //**********
        
        //UI testing shit: REMOVE
        AbstractCueUI ui = new AbstractCueUI();
        ui.showUI(basicPanel);
        AudioCueUI aui = new AudioCueUI();
        aui.showUI(basicPanel);
        //**********
        
        //Tabs for cue controls
        this.editorTabs = new JTabbedPane();
        
        this.editorTabs.addTab("Basic", this.basicPanel);
        this.editorTabs.addTab("Effects", this.effectPanel);
        //**********
        
        //Add buttons to a new panel for layout
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        top.add(this.audioButton);
        top.add(this.eventButton);
        top.add(this.changeButton);
        
        //Add everything to window
        container.add(top, BorderLayout.NORTH);
        container.add(this.cueList, BorderLayout.WEST);
        container.add(this.editorTabs, BorderLayout.CENTER);
    }
}