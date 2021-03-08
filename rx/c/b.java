package rx.c;
/* loaded from: classes4.dex */
public abstract class b {
    @Deprecated
    public void D(Throwable th) {
    }

    public final String cj(Object obj) {
        try {
            return ck(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.N(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String ck(Object obj) throws InterruptedException {
        return null;
    }
}
