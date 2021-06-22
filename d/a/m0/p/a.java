package d.a.m0.p;
/* loaded from: classes3.dex */
public class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public int f52099e;

    public a(int i2) {
        this.f52099e = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.f52099e;
        if (i2 < 0) {
            return;
        }
        try {
            Thread.sleep(i2);
        } catch (Throwable unused) {
        }
    }
}
