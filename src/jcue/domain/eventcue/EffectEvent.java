package jcue.domain.eventcue;

/**
 *
 * @author Jaakko
 */
public class EffectEvent extends AbstractEvent {

    public static final int EFFECT_ON = 1;
    public static final int EFFECT_OFF = 2;
    
    private int mode;
    //private SoundEffect targetEffect;

    public EffectEvent(int mode) {
        super(AbstractEvent.TYPE_EFFECT);
        
        this.mode = mode;
    }

    public EffectEvent() {
        this(EFFECT_OFF);
    }

    @Override
    public void perform() {
        if (this.mode == EFFECT_ON) {
            //this.targetEffect.setActive(true);
        } else {
            //this.targetEffect.setActive(false);
        }
    }

    @Override
    public String toString() {
        return "Effect event";
    }
    
    
}
