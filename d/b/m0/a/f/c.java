package d.b.m0.a.f;
/* loaded from: classes5.dex */
public abstract class c implements Runnable {
    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Exception e2) {
            i.e(e2);
            if (e2.getMessage() != null) {
                a.b(e2.getMessage());
            }
        }
    }
}
