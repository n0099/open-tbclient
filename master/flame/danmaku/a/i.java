package master.flame.danmaku.a;
/* loaded from: classes4.dex */
public class i extends Thread {
    volatile boolean nEz;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.nEz = true;
    }

    public boolean dKm() {
        return this.nEz;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.nEz) {
        }
    }
}
