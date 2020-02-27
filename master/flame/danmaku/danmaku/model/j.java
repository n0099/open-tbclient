package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class j {
    public int nFY = 0;
    public int nFZ = 0;
    public int nGa = 0;
    public int nGb = 0;
    public int nGc = 0;
    public int nGd = 0;

    public void resetAll() {
        this.nFZ = 0;
        this.nFY = 0;
        this.nGa = 0;
        this.nGb = 0;
        this.nGc = 0;
        this.nGd = 0;
    }

    public void dLS() {
        this.nFZ++;
    }

    public void dLT() {
        this.nFY++;
    }

    public void dLU() {
        this.nGa++;
    }

    public void dLV() {
        this.nGb++;
    }

    public void dLW() {
        this.nGc++;
    }

    public void dLX() {
        this.nGd++;
    }
}
