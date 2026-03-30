package Game.Arco.Build;

import Game.Arco.ViewPort;

import java.util.ArrayList;
import java.util.List;


public abstract class Element extends GameLoop{

    List<Overlay> overlays = new ArrayList<>();
    ViewPort viewPort;

    public Element() {
    }

    public List<Overlay> getOverlays() {
        return overlays;
    }

    public void addOverlay(Overlay overlay) {
        this.overlays.add(overlay);
    }

    public ViewPort getViewPort() {
        return viewPort;
    }

    public void setViewPort(ViewPort viewPort) {
        this.viewPort = viewPort;
    }
}
