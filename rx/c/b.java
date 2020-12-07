package rx.c;
/* loaded from: classes12.dex */
public abstract class b {
    @Deprecated
    public void F(Throwable th) {
    }

    public final String cf(Object obj) {
        try {
            return cg(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String cg(Object obj) throws InterruptedException {
        return null;
    }
}
