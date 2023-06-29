package rx.subscriptions;

import com.baidu.tieba.ayb;
import com.baidu.tieba.etb;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class RefCountSubscription implements etb {
    public static final a c = new a(false, 0);
    public final etb a;
    public final AtomicReference<a> b = new AtomicReference<>(c);

    /* loaded from: classes2.dex */
    public static final class InnerSubscription extends AtomicInteger implements etb {
        public static final long serialVersionUID = 7005765588239987643L;
        public final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // com.baidu.tieba.etb
        public boolean isUnsubscribed() {
            if (get() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.etb
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public final boolean a;
        public final int b;

        public a(boolean z, int i) {
            this.a = z;
            this.b = i;
        }

        public a a() {
            return new a(this.a, this.b + 1);
        }

        public a b() {
            return new a(this.a, this.b - 1);
        }

        public a c() {
            return new a(true, this.b);
        }
    }

    public etb a() {
        a aVar;
        AtomicReference<a> atomicReference = this.b;
        do {
            aVar = atomicReference.get();
            if (aVar.a) {
                return ayb.c();
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.a()));
        return new InnerSubscription(this);
    }

    public void b() {
        a aVar;
        a b;
        AtomicReference<a> atomicReference = this.b;
        do {
            aVar = atomicReference.get();
            b = aVar.b();
        } while (!atomicReference.compareAndSet(aVar, b));
        c(b);
    }

    @Override // com.baidu.tieba.etb
    public boolean isUnsubscribed() {
        return this.b.get().a;
    }

    @Override // com.baidu.tieba.etb
    public void unsubscribe() {
        a aVar;
        a c2;
        AtomicReference<a> atomicReference = this.b;
        do {
            aVar = atomicReference.get();
            if (aVar.a) {
                return;
            }
            c2 = aVar.c();
        } while (!atomicReference.compareAndSet(aVar, c2));
        c(c2);
    }

    public RefCountSubscription(etb etbVar) {
        if (etbVar != null) {
            this.a = etbVar;
            return;
        }
        throw new IllegalArgumentException("s");
    }

    public final void c(a aVar) {
        if (aVar.a && aVar.b == 0) {
            this.a.unsubscribe();
        }
    }
}
