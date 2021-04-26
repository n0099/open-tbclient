package h.u;

import h.k;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a implements k {

    /* renamed from: f  reason: collision with root package name */
    public static final h.n.a f68034f = new C1873a();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<h.n.a> f68035e;

    /* renamed from: h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1873a implements h.n.a {
        @Override // h.n.a
        public void call() {
        }
    }

    public a() {
        this.f68035e = new AtomicReference<>();
    }

    public static a a() {
        return new a();
    }

    public static a b(h.n.a aVar) {
        return new a(aVar);
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f68035e.get() == f68034f;
    }

    @Override // h.k
    public void unsubscribe() {
        h.n.a andSet;
        h.n.a aVar = this.f68035e.get();
        h.n.a aVar2 = f68034f;
        if (aVar == aVar2 || (andSet = this.f68035e.getAndSet(aVar2)) == null || andSet == f68034f) {
            return;
        }
        andSet.call();
    }

    public a(h.n.a aVar) {
        this.f68035e = new AtomicReference<>(aVar);
    }
}
