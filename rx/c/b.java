package rx.c;
/* loaded from: classes2.dex */
public abstract class b {
    @Deprecated
    public void D(Throwable th) {
    }

    public final String bC(Object obj) {
        try {
            return bD(obj);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.L(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String bD(Object obj) throws InterruptedException {
        return null;
    }
}
