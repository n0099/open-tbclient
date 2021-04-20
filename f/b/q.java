package f.b;
/* loaded from: classes7.dex */
public abstract class q<T> implements s<T> {
    @Override // f.b.s
    public final void a(r<? super T> rVar) {
        f.b.x.b.a.b(rVar, "subscriber is null");
        r<? super T> k = f.b.a0.a.k(this, rVar);
        f.b.x.b.a.b(k, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            b(k);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            f.b.u.a.a(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void b(r<? super T> rVar);
}
