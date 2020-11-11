package master.flame.danmaku.a;
/* loaded from: classes6.dex */
public class i extends Thread {
    volatile boolean pVJ;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.pVJ = true;
    }

    public boolean eCW() {
        return this.pVJ;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.pVJ) {
        }
    }
}
