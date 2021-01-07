package io.reactivex;
/* loaded from: classes5.dex */
public abstract class a implements e {
    protected abstract void b(c cVar);

    private static NullPointerException M(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @Override // io.reactivex.e
    public final void a(c cVar) {
        io.reactivex.internal.functions.a.m(cVar, "s is null");
        try {
            b(io.reactivex.d.a.a(this, cVar));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.O(th);
            io.reactivex.d.a.onError(th);
            throw M(th);
        }
    }
}
