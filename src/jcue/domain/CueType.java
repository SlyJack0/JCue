/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcue.domain;

/**
 *
 * @author Jaakko
 */
public enum CueType {

    AUDIO("Audio"),
    EVENT("Event"),
    CHANGE("Change"),
    NOTE("Note");
    
    private String displayName;

    private CueType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
