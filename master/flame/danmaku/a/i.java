package master.flame.danmaku.a;
/* loaded from: classes6.dex */
public class i extends Thread {
    volatile boolean pMp;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.pMp = true;
    }

    public boolean ezh() {
        return this.pMp;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.pMp) {
        }
    }
}
