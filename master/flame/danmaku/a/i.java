package master.flame.danmaku.a;
/* loaded from: classes5.dex */
public class i extends Thread {
    volatile boolean naR;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.naR = true;
    }

    public boolean dFc() {
        return this.naR;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.naR) {
        }
    }
}
