package f.b;
/* loaded from: classes7.dex */
public abstract class a implements c {
    public static NullPointerException c(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @Override // f.b.c
    public final void a(b bVar) {
        f.b.x.b.a.b(bVar, "s is null");
        try {
            b(f.b.a0.a.h(this, bVar));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            f.b.u.a.a(th);
            f.b.a0.a.f(th);
            throw c(th);
        }
    }

    public abstract void b(b bVar);
}
