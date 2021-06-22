package h.o.c;

import h.g;
/* loaded from: classes8.dex */
public class i implements h.n.a {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.a f72007e;

    /* renamed from: f  reason: collision with root package name */
    public final g.a f72008f;

    /* renamed from: g  reason: collision with root package name */
    public final long f72009g;

    public i(h.n.a aVar, g.a aVar2, long j) {
        this.f72007e = aVar;
        this.f72008f = aVar2;
        this.f72009g = j;
    }

    @Override // h.n.a
    public void call() {
        if (this.f72008f.isUnsubscribed()) {
            return;
        }
        long a2 = this.f72009g - this.f72008f.a();
        if (a2 > 0) {
            try {
                Thread.sleep(a2);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                h.m.a.c(e2);
                throw null;
            }
        }
        if (this.f72008f.isUnsubscribed()) {
            return;
        }
        this.f72007e.call();
    }
}
