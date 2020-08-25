package rx.c;
/* loaded from: classes5.dex */
public abstract class b {
    @Deprecated
    public void F(Throwable th) {
    }

    public final String ch(Object obj) {
        try {
            return ci(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String ci(Object obj) throws InterruptedException {
        return null;
    }
}
