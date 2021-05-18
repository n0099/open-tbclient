package h.o.c;

import h.g;
/* loaded from: classes7.dex */
public class i implements h.n.a {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.a f68604e;

    /* renamed from: f  reason: collision with root package name */
    public final g.a f68605f;

    /* renamed from: g  reason: collision with root package name */
    public final long f68606g;

    public i(h.n.a aVar, g.a aVar2, long j) {
        this.f68604e = aVar;
        this.f68605f = aVar2;
        this.f68606g = j;
    }

    @Override // h.n.a
    public void call() {
        if (this.f68605f.isUnsubscribed()) {
            return;
        }
        long a2 = this.f68606g - this.f68605f.a();
        if (a2 > 0) {
            try {
                Thread.sleep(a2);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                h.m.a.c(e2);
                throw null;
            }
        }
        if (this.f68605f.isUnsubscribed()) {
            return;
        }
        this.f68604e.call();
    }
}
