package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class j {
    public int nGl = 0;
    public int nGm = 0;
    public int nGn = 0;
    public int nGo = 0;
    public int nGp = 0;
    public int nGq = 0;

    public void resetAll() {
        this.nGm = 0;
        this.nGl = 0;
        this.nGn = 0;
        this.nGo = 0;
        this.nGp = 0;
        this.nGq = 0;
    }

    public void dLV() {
        this.nGm++;
    }

    public void dLW() {
        this.nGl++;
    }

    public void dLX() {
        this.nGn++;
    }

    public void dLY() {
        this.nGo++;
    }

    public void dLZ() {
        this.nGp++;
    }

    public void dMa() {
        this.nGq++;
    }
}
