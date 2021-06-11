package h;
/* loaded from: classes8.dex */
public abstract class i<T> implements k {

    /* renamed from: e  reason: collision with root package name */
    public final h.o.d.h f71686e = new h.o.d.h();

    public final void a(k kVar) {
        this.f71686e.a(kVar);
    }

    public abstract void b(Throwable th);

    public abstract void c(T t);

    @Override // h.k
    public final boolean isUnsubscribed() {
        return this.f71686e.isUnsubscribed();
    }

    @Override // h.k
    public final void unsubscribe() {
        this.f71686e.unsubscribe();
    }
}
