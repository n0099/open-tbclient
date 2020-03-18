package master.flame.danmaku.a;
/* loaded from: classes5.dex */
public class i extends Thread {
    volatile boolean nHr;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.nHr = true;
    }

    public boolean dMc() {
        return this.nHr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.nHr) {
        }
    }
}
