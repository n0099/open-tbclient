package rx.c;
/* loaded from: classes2.dex */
public abstract class b {
    @Deprecated
    public void C(Throwable th) {
    }

    public final String bE(Object obj) {
        try {
            return bF(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.K(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String bF(Object obj) throws InterruptedException {
        return null;
    }
}
