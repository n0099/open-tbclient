package master.flame.danmaku.a;
/* loaded from: classes6.dex */
public class i extends Thread {
    volatile boolean ovG;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.ovG = true;
    }

    public boolean ehq() {
        return this.ovG;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.ovG) {
        }
    }
}
