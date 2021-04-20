package f.b;
/* loaded from: classes7.dex */
public abstract class h<T> implements j<T> {
    @Override // f.b.j
    public final void a(i<? super T> iVar) {
        f.b.x.b.a.b(iVar, "observer is null");
        i<? super T> i = f.b.a0.a.i(this, iVar);
        f.b.x.b.a.b(i, "observer returned by the RxJavaPlugins hook is null");
        try {
            b(i);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            f.b.u.a.a(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void b(i<? super T> iVar);
}
