package rx.c;
/* loaded from: classes2.dex */
public abstract class b {
    @Deprecated
    public void C(Throwable th) {
    }

    public final String br(Object obj) {
        try {
            return bs(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String bs(Object obj) throws InterruptedException {
        return null;
    }
}
