package rx.c;
/* loaded from: classes5.dex */
public abstract class b {
    @Deprecated
    public void E(Throwable th) {
    }

    public final String cl(Object obj) {
        try {
            return cm(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.I(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String cm(Object obj) throws InterruptedException {
        return null;
    }
}
