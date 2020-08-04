package master.flame.danmaku.a;
/* loaded from: classes6.dex */
public class i extends Thread {
    volatile boolean obI;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.obI = true;
    }

    public boolean dVo() {
        return this.obI;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.obI) {
        }
    }
}
