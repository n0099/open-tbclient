package master.flame.danmaku.a;
/* loaded from: classes5.dex */
public class i extends Thread {
    volatile boolean naU;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.naU = true;
    }

    public boolean dEZ() {
        return this.naU;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.naU) {
        }
    }
}
