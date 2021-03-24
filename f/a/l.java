package f.a;
/* loaded from: classes7.dex */
public abstract class l<T> implements n<T> {
    public static int a() {
        return e.a();
    }

    public abstract void b(o<? super T> oVar);

    @Override // f.a.n
    public final void subscribe(o<? super T> oVar) {
        f.a.x.b.a.b(oVar, "observer is null");
        try {
            o<? super T> j = f.a.a0.a.j(this, oVar);
            f.a.x.b.a.b(j, "Plugin returned null Observer");
            b(j);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            f.a.u.a.a(th);
            f.a.a0.a.f(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
