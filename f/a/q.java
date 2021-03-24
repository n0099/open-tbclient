package f.a;
/* loaded from: classes7.dex */
public abstract class q<T> implements s<T> {
    @Override // f.a.s
    public final void a(r<? super T> rVar) {
        f.a.x.b.a.b(rVar, "subscriber is null");
        r<? super T> k = f.a.a0.a.k(this, rVar);
        f.a.x.b.a.b(k, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            b(k);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            f.a.u.a.a(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void b(r<? super T> rVar);
}
