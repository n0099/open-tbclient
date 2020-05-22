package rx.c;
/* loaded from: classes6.dex */
public abstract class b {
    @Deprecated
    public void H(Throwable th) {
    }

    public final String cc(Object obj) {
        try {
            return cd(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.L(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String cd(Object obj) throws InterruptedException {
        return null;
    }
}
