package master.flame.danmaku.a;
/* loaded from: classes5.dex */
public class i extends Thread {
    volatile boolean nvX;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.nvX = true;
    }

    public boolean dMT() {
        return this.nvX;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.nvX) {
        }
    }
}
