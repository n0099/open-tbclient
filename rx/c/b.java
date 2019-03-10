package rx.c;
/* loaded from: classes2.dex */
public abstract class b {
    @Deprecated
    public void D(Throwable th) {
    }

    public final String bD(Object obj) {
        try {
            return bE(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.L(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String bE(Object obj) throws InterruptedException {
        return null;
    }
}
