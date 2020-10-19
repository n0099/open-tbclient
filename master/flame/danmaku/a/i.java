package master.flame.danmaku.a;
/* loaded from: classes6.dex */
public class i extends Thread {
    volatile boolean oUT;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.oUT = true;
    }

    public boolean epj() {
        return this.oUT;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.oUT) {
        }
    }
}
