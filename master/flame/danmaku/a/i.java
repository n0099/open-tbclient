package master.flame.danmaku.a;
/* loaded from: classes4.dex */
public class i extends Thread {
    volatile boolean nEu;

    public i(String str) {
        super(str);
    }

    public void quit() {
        this.nEu = true;
    }

    public boolean dKk() {
        return this.nEu;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.nEu) {
        }
    }
}
