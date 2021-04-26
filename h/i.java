package h;
/* loaded from: classes7.dex */
public abstract class i<T> implements k {

    /* renamed from: e  reason: collision with root package name */
    public final h.o.d.h f67707e = new h.o.d.h();

    public final void a(k kVar) {
        this.f67707e.a(kVar);
    }

    public abstract void b(Throwable th);

    public abstract void c(T t);

    @Override // h.k
    public final boolean isUnsubscribed() {
        return this.f67707e.isUnsubscribed();
    }

    @Override // h.k
    public final void unsubscribe() {
        this.f67707e.unsubscribe();
    }
}
