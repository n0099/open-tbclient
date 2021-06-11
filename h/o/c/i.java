package h.o.c;

import h.g;
/* loaded from: classes8.dex */
public class i implements h.n.a {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.a f71903e;

    /* renamed from: f  reason: collision with root package name */
    public final g.a f71904f;

    /* renamed from: g  reason: collision with root package name */
    public final long f71905g;

    public i(h.n.a aVar, g.a aVar2, long j) {
        this.f71903e = aVar;
        this.f71904f = aVar2;
        this.f71905g = j;
    }

    @Override // h.n.a
    public void call() {
        if (this.f71904f.isUnsubscribed()) {
            return;
        }
        long a2 = this.f71905g - this.f71904f.a();
        if (a2 > 0) {
            try {
                Thread.sleep(a2);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                h.m.a.c(e2);
                throw null;
            }
        }
        if (this.f71904f.isUnsubscribed()) {
            return;
        }
        this.f71903e.call();
    }
}
