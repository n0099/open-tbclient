package io.reactivex;
/* loaded from: classes7.dex */
public abstract class a implements e {
    protected abstract void b(c cVar);

    private static NullPointerException J(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @Override // io.reactivex.e
    public final void a(c cVar) {
        io.reactivex.internal.functions.a.k(cVar, "s is null");
        try {
            b(io.reactivex.e.a.a(this, cVar));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.L(th);
            io.reactivex.e.a.onError(th);
            throw J(th);
        }
    }
}
