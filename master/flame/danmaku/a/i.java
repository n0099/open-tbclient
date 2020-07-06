package master.flame.danmaku.a;
/* loaded from: classes5.dex */
public class i extends Thread {
    volatile boolean nSW;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.nSW = true;
    }

    public boolean dRR() {
        return this.nSW;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.nSW) {
        }
    }
}
