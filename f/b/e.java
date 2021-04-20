package f.b;

import io.reactivex.internal.subscribers.StrictSubscriber;
/* loaded from: classes7.dex */
public abstract class e<T> implements g.d.b<T> {

    /* renamed from: e  reason: collision with root package name */
    public static final int f68462e = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int a() {
        return f68462e;
    }

    public final void b(g<? super T> gVar) {
        f.b.x.b.a.b(gVar, "s is null");
        try {
            g.d.c<? super T> l = f.b.a0.a.l(this, gVar);
            f.b.x.b.a.b(l, "Plugin returned null Subscriber");
            c(l);
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

    public abstract void c(g.d.c<? super T> cVar);

    @Override // g.d.b
    public final void subscribe(g.d.c<? super T> cVar) {
        if (cVar instanceof g) {
            b((g) cVar);
            return;
        }
        f.b.x.b.a.b(cVar, "s is null");
        b(new StrictSubscriber(cVar));
    }
}
