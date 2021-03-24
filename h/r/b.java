package h.r;
/* loaded from: classes7.dex */
public abstract class b {
    @Deprecated
    public void a(Throwable th) {
    }

    public final String b(Object obj) {
        try {
            return c(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            h.m.a.e(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    public String c(Object obj) throws InterruptedException {
        return null;
    }
}
