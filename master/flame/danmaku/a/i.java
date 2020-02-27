package master.flame.danmaku.a;
/* loaded from: classes5.dex */
public class i extends Thread {
    volatile boolean nFr;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.nFr = true;
    }

    public boolean dLz() {
        return this.nFr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.nFr) {
        }
    }
}
