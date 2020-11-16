package rx.c;
/* loaded from: classes14.dex */
public abstract class b {
    @Deprecated
    public void F(Throwable th) {
    }

    public final String cp(Object obj) {
        try {
            return cq(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String cq(Object obj) throws InterruptedException {
        return null;
    }
}
