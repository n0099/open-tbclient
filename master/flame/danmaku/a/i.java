package master.flame.danmaku.a;
/* loaded from: classes5.dex */
public class i extends Thread {
    volatile boolean nST;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.nST = true;
    }

    public boolean dRN() {
        return this.nST;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.nST) {
        }
    }
}
