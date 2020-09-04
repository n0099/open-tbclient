package master.flame.danmaku.a;
/* loaded from: classes6.dex */
public class i extends Thread {
    volatile boolean ovY;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.ovY = true;
    }

    public boolean ehz() {
        return this.ovY;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.ovY) {
        }
    }
}
