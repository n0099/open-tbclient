package rx.c;
/* loaded from: classes6.dex */
public abstract class b {
    @Deprecated
    public void D(Throwable th) {
    }

    public final String cm(Object obj) {
        try {
            return cn(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.H(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String cn(Object obj) throws InterruptedException {
        return null;
    }
}
