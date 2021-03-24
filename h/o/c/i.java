package h.o.c;

import h.g;
/* loaded from: classes7.dex */
public class i implements h.n.a {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.a f67903e;

    /* renamed from: f  reason: collision with root package name */
    public final g.a f67904f;

    /* renamed from: g  reason: collision with root package name */
    public final long f67905g;

    public i(h.n.a aVar, g.a aVar2, long j) {
        this.f67903e = aVar;
        this.f67904f = aVar2;
        this.f67905g = j;
    }

    @Override // h.n.a
    public void call() {
        if (this.f67904f.isUnsubscribed()) {
            return;
        }
        long a2 = this.f67905g - this.f67904f.a();
        if (a2 > 0) {
            try {
                Thread.sleep(a2);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                h.m.a.c(e2);
                throw null;
            }
        }
        if (this.f67904f.isUnsubscribed()) {
            return;
        }
        this.f67903e.call();
    }
}
