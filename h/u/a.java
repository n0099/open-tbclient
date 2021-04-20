package h.u;

import h.k;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a implements k {

    /* renamed from: f  reason: collision with root package name */
    public static final h.n.a f69023f = new C1922a();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<h.n.a> f69024e;

    /* renamed from: h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1922a implements h.n.a {
        @Override // h.n.a
        public void call() {
        }
    }

    public a() {
        this.f69024e = new AtomicReference<>();
    }

    public static a a() {
        return new a();
    }

    public static a b(h.n.a aVar) {
        return new a(aVar);
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f69024e.get() == f69023f;
    }

    @Override // h.k
    public void unsubscribe() {
        h.n.a andSet;
        h.n.a aVar = this.f69024e.get();
        h.n.a aVar2 = f69023f;
        if (aVar == aVar2 || (andSet = this.f69024e.getAndSet(aVar2)) == null || andSet == f69023f) {
            return;
        }
        andSet.call();
    }

    public a(h.n.a aVar) {
        this.f69024e = new AtomicReference<>(aVar);
    }
}
