package master.flame.danmaku.a;
/* loaded from: classes6.dex */
public class i extends Thread {
    volatile boolean obG;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.obG = true;
    }

    public boolean dVn() {
        return this.obG;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.obG) {
        }
    }
}
