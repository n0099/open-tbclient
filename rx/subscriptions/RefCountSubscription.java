package rx.subscriptions;

import h.k;
import h.u.e;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class RefCountSubscription implements k {

    /* renamed from: g  reason: collision with root package name */
    public static final a f72637g = new a(false, 0);

    /* renamed from: e  reason: collision with root package name */
    public final k f72638e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<a> f72639f = new AtomicReference<>(f72637g);

    /* loaded from: classes8.dex */
    public static final class InnerSubscription extends AtomicInteger implements k {
        public static final long serialVersionUID = 7005765588239987643L;
        public final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return get() != 0;
        }

        @Override // h.k
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f72640a;

        /* renamed from: b  reason: collision with root package name */
        public final int f72641b;

        public a(boolean z, int i2) {
            this.f72640a = z;
            this.f72641b = i2;
        }

        public a a() {
            return new a(this.f72640a, this.f72641b + 1);
        }

        public a b() {
            return new a(this.f72640a, this.f72641b - 1);
        }

        public a c() {
            return new a(true, this.f72641b);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar != null) {
            this.f72638e = kVar;
            return;
        }
        throw new IllegalArgumentException("s");
    }

    public k a() {
        a aVar;
        AtomicReference<a> atomicReference = this.f72639f;
        do {
            aVar = atomicReference.get();
            if (aVar.f72640a) {
                return e.c();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.a()));
        return new InnerSubscription(this);
    }

    public void b() {
        a aVar;
        a b2;
        AtomicReference<a> atomicReference = this.f72639f;
        do {
            aVar = atomicReference.get();
            b2 = aVar.b();
        } while (!atomicReference.compareAndSet(aVar, b2));
        c(b2);
    }

    public final void c(a aVar) {
        if (aVar.f72640a && aVar.f72641b == 0) {
            this.f72638e.unsubscribe();
        }
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f72639f.get().f72640a;
    }

    @Override // h.k
    public void unsubscribe() {
        a aVar;
        a c2;
        AtomicReference<a> atomicReference = this.f72639f;
        do {
            aVar = atomicReference.get();
            if (aVar.f72640a) {
                return;
            }
            c2 = aVar.c();
        } while (!atomicReference.compareAndSet(aVar, c2));
        c(c2);
    }
}
