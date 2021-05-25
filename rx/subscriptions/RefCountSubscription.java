package rx.subscriptions;

import h.k;
import h.u.e;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class RefCountSubscription implements k {

    /* renamed from: g  reason: collision with root package name */
    public static final a f69224g = new a(false, 0);

    /* renamed from: e  reason: collision with root package name */
    public final k f69225e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<a> f69226f = new AtomicReference<>(f69224g);

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f69227a;

        /* renamed from: b  reason: collision with root package name */
        public final int f69228b;

        public a(boolean z, int i2) {
            this.f69227a = z;
            this.f69228b = i2;
        }

        public a a() {
            return new a(this.f69227a, this.f69228b + 1);
        }

        public a b() {
            return new a(this.f69227a, this.f69228b - 1);
        }

        public a c() {
            return new a(true, this.f69228b);
        }
    }

    public RefCountSubscription(k kVar) {
        if (kVar != null) {
            this.f69225e = kVar;
            return;
        }
        throw new IllegalArgumentException("s");
    }

    public k a() {
        a aVar;
        AtomicReference<a> atomicReference = this.f69226f;
        do {
            aVar = atomicReference.get();
            if (aVar.f69227a) {
                return e.c();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.a()));
        return new InnerSubscription(this);
    }

    public void b() {
        a aVar;
        a b2;
        AtomicReference<a> atomicReference = this.f69226f;
        do {
            aVar = atomicReference.get();
            b2 = aVar.b();
        } while (!atomicReference.compareAndSet(aVar, b2));
        c(b2);
    }

    public final void c(a aVar) {
        if (aVar.f69227a && aVar.f69228b == 0) {
            this.f69225e.unsubscribe();
        }
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f69226f.get().f69227a;
    }

    @Override // h.k
    public void unsubscribe() {
        a aVar;
        a c2;
        AtomicReference<a> atomicReference = this.f69226f;
        do {
            aVar = atomicReference.get();
            if (aVar.f69227a) {
                return;
            }
            c2 = aVar.c();
        } while (!atomicReference.compareAndSet(aVar, c2));
        c(c2);
    }
}
