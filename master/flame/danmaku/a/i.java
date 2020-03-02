package master.flame.danmaku.a;
/* loaded from: classes5.dex */
public class i extends Thread {
    volatile boolean nFt;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.nFt = true;
    }

    public boolean dLB() {
        return this.nFt;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.nFt) {
        }
    }
}
