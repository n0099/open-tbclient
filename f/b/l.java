package f.b;
/* loaded from: classes7.dex */
public abstract class l<T> implements n<T> {
    public static int a() {
        return e.a();
    }

    public abstract void b(o<? super T> oVar);

    @Override // f.b.n
    public final void subscribe(o<? super T> oVar) {
        f.b.x.b.a.b(oVar, "observer is null");
        try {
            o<? super T> j = f.b.a0.a.j(this, oVar);
            f.b.x.b.a.b(j, "Plugin returned null Observer");
            b(j);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            f.b.u.a.a(th);
            f.b.a0.a.f(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
