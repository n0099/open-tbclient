package rx.c;
/* loaded from: classes4.dex */
public abstract class b {
    @Deprecated
    public void E(Throwable th) {
    }

    public final String cd(Object obj) {
        try {
            return ce(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.I(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String ce(Object obj) throws InterruptedException {
        return null;
    }
}
