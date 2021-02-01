package rx.c;
/* loaded from: classes5.dex */
public abstract class b {
    @Deprecated
    public void D(Throwable th) {
    }

    public final String ci(Object obj) {
        try {
            return cj(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.N(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String cj(Object obj) throws InterruptedException {
        return null;
    }
}
