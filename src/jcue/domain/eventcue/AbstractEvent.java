package jcue.domain.eventcue;

import jcue.domain.audiocue.AudioCue;

/**
 * Represents an event that can be applied to a cue.
 * 
 * @author Jaakko
 */
public abstract class AbstractEvent {
    
    public static final int TYPE_TRANSPORT = 1;
    public static final int TYPE_MUTE = 2;
    public static final int TYPE_LOOP = 3;
    public static final int TYPE_EFFECT = 4;
    
    protected AudioCue targetCue;
    
    private int type;

    public AbstractEvent(int type) {
        this.type = type;
    }
    
    public void setTargetCue(AudioCue targetCue) {
        this.targetCue = targetCue;
    }

    public AudioCue getTargetCue() {
        return targetCue;
    }

    public abstract void perform();
}
