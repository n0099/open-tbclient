package rx.c;
/* loaded from: classes2.dex */
public abstract class b {
    @Deprecated
    public void B(Throwable th) {
    }

    public final String bz(Object obj) {
        try {
            return bA(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String bA(Object obj) throws InterruptedException {
        return null;
    }
}
