package master.flame.danmaku.a;
/* loaded from: classes5.dex */
public class i extends Thread {
    volatile boolean nxh;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.nxh = true;
    }

    public boolean dNh() {
        return this.nxh;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.nxh) {
        }
    }
}
