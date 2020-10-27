package rx.c;
/* loaded from: classes16.dex */
public abstract class b {
    @Deprecated
    public void F(Throwable th) {
    }

    public final String co(Object obj) {
        try {
            return cp(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String cp(Object obj) throws InterruptedException {
        return null;
    }
}
