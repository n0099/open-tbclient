package master.flame.danmaku.a;
/* loaded from: classes6.dex */
public class i extends Thread {
    volatile boolean oFE;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.oFE = true;
    }

    public boolean elw() {
        return this.oFE;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.oFE) {
        }
    }
}
