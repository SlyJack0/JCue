package jcue.domain.audiocue.effect;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import jouvieje.bass.Bass;
import jouvieje.bass.structures.HFX;
import jouvieje.bass.utils.Pointer;

/**
 *
 * @author Jaakko
 */
public abstract class AbstractEffect {
    
    private String name;
    
    private ArrayList<HFX> handles;
    private Pointer effectStruct;
    
    private boolean active;
    
    protected int type;
    
    protected LinkedHashMap<String, EffectParameter> params;

    public AbstractEffect(int type, String name) {
        this.type = type;
        this.params = new LinkedHashMap<String, EffectParameter>();
        this.name = name;
        this.active = true;
        
        this.handles = new ArrayList<HFX>();
    }
    
    public ArrayList<HFX> getHandles() {
        return handles;
    }

    public void setHandles(ArrayList<HFX> handles) {
        this.handles = handles;
    }
    
    public Pointer getEffectStruct() {
        return effectStruct;
    }

    public void setEffectStruct(Pointer effectStruct) {
        this.effectStruct = effectStruct;
    }

    public int getType() {
        return type;
    }
    
    protected void updateEffect() {
        if (this.effectStruct != null && this.handles.size() > 0) {
            for (HFX hfx : this.handles) {
                Bass.BASS_FXSetParameters(hfx, this.effectStruct);
            }
        }
    }
    
    public ArrayList<EffectParameter> getParameters() {
        return new ArrayList<EffectParameter>(this.params.values());
    }
    
    public ArrayList<String> getParameterKeys() {
        return new ArrayList<String>(this.params.keySet());
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (EffectParameter ep : this.params.values()) {
            sb.append(ep);
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    
    
    public EffectParameter getParameter(String param) {
        String lowParam = param.toLowerCase();
        
        if (this.params.containsKey(lowParam)) {
            return this.params.get(lowParam);
        }

        return null;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract void setParameter(String param, double value);
    public abstract void updateParameters();
}
