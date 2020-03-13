package master.flame.danmaku.a;
/* loaded from: classes5.dex */
public class i extends Thread {
    volatile boolean nFE;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.nFE = true;
    }

    public boolean dLC() {
        return this.nFE;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.nFE) {
        }
    }
}
