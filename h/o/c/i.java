package h.o.c;

import h.g;
/* loaded from: classes7.dex */
public class i implements h.n.a {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.a f69065e;

    /* renamed from: f  reason: collision with root package name */
    public final g.a f69066f;

    /* renamed from: g  reason: collision with root package name */
    public final long f69067g;

    public i(h.n.a aVar, g.a aVar2, long j) {
        this.f69065e = aVar;
        this.f69066f = aVar2;
        this.f69067g = j;
    }

    @Override // h.n.a
    public void call() {
        if (this.f69066f.isUnsubscribed()) {
            return;
        }
        long a2 = this.f69067g - this.f69066f.a();
        if (a2 > 0) {
            try {
                Thread.sleep(a2);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                h.m.a.c(e2);
                throw null;
            }
        }
        if (this.f69066f.isUnsubscribed()) {
            return;
        }
        this.f69065e.call();
    }
}
