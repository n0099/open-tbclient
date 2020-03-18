package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class j {
    public int nHY = 0;
    public int nHZ = 0;
    public int nIa = 0;
    public int nIb = 0;
    public int nIc = 0;
    public int nId = 0;

    public void resetAll() {
        this.nHZ = 0;
        this.nHY = 0;
        this.nIa = 0;
        this.nIb = 0;
        this.nIc = 0;
        this.nId = 0;
    }

    public void dMv() {
        this.nHZ++;
    }

    public void dMw() {
        this.nHY++;
    }

    public void dMx() {
        this.nIa++;
    }

    public void dMy() {
        this.nIb++;
    }

    public void dMz() {
        this.nIc++;
    }

    public void dMA() {
        this.nId++;
    }
}
