package master.flame.danmaku.a;
/* loaded from: classes6.dex */
public class i extends Thread {
    volatile boolean pXm;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.pXm = true;
    }

    public boolean eCX() {
        return this.pXm;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.pXm) {
        }
    }
}
