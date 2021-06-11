package h.u;

import h.k;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class a implements k {

    /* renamed from: f  reason: collision with root package name */
    public static final h.n.a f72013f = new C1989a();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<h.n.a> f72014e;

    /* renamed from: h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1989a implements h.n.a {
        @Override // h.n.a
        public void call() {
        }
    }

    public a() {
        this.f72014e = new AtomicReference<>();
    }

    public static a a() {
        return new a();
    }

    public static a b(h.n.a aVar) {
        return new a(aVar);
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f72014e.get() == f72013f;
    }

    @Override // h.k
    public void unsubscribe() {
        h.n.a andSet;
        h.n.a aVar = this.f72014e.get();
        h.n.a aVar2 = f72013f;
        if (aVar == aVar2 || (andSet = this.f72014e.getAndSet(aVar2)) == null || andSet == f72013f) {
            return;
        }
        andSet.call();
    }

    public a(h.n.a aVar) {
        this.f72014e = new AtomicReference<>(aVar);
    }
}
