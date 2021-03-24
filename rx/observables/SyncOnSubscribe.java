package rx.observables;

import h.d;
import h.e;
import h.f;
import h.j;
import h.k;
import h.m.a;
import h.r.c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public abstract class SyncOnSubscribe<S, T> implements d.a<T> {

    /* loaded from: classes7.dex */
    public static final class SubscriptionProducer<S, T> extends AtomicLong implements f, k, e<T> {
        public static final long serialVersionUID = -3736864024352728072L;
        public final j<? super T> actualSubscriber;
        public boolean hasTerminated;
        public boolean onNextCalled;
        public final SyncOnSubscribe<S, T> parent;
        public S state;

        public SubscriptionProducer(j<? super T> jVar, SyncOnSubscribe<S, T> syncOnSubscribe, S s) {
            this.actualSubscriber = jVar;
            this.parent = syncOnSubscribe;
            this.state = s;
        }

        public final void a() {
            try {
                this.parent.b(this.state);
            } catch (Throwable th) {
                a.e(th);
                c.j(th);
            }
        }

        public final void b() {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            j<? super T> jVar = this.actualSubscriber;
            do {
                try {
                    this.onNextCalled = false;
                    d(syncOnSubscribe);
                } catch (Throwable th) {
                    c(jVar, th);
                    return;
                }
            } while (!f());
        }

        public final void c(j<? super T> jVar, Throwable th) {
            if (this.hasTerminated) {
                c.j(th);
                return;
            }
            this.hasTerminated = true;
            jVar.onError(th);
            unsubscribe();
        }

        public final void d(SyncOnSubscribe<S, T> syncOnSubscribe) {
            this.state = syncOnSubscribe.a(this.state, this);
        }

        public final void e(long j) {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            j<? super T> jVar = this.actualSubscriber;
            do {
                long j2 = j;
                do {
                    try {
                        this.onNextCalled = false;
                        d(syncOnSubscribe);
                        if (f()) {
                            return;
                        }
                        if (this.onNextCalled) {
                            j2--;
                        }
                    } catch (Throwable th) {
                        c(jVar, th);
                        return;
                    }
                } while (j2 != 0);
                j = addAndGet(-j);
            } while (j > 0);
            f();
        }

        public final boolean f() {
            if (this.hasTerminated || get() < -1) {
                set(-1L);
                a();
                return true;
            }
            return false;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return get() < 0;
        }

        @Override // h.e
        public void onCompleted() {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                if (this.actualSubscriber.isUnsubscribed()) {
                    return;
                }
                this.actualSubscriber.onCompleted();
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                if (this.actualSubscriber.isUnsubscribed()) {
                    return;
                }
                this.actualSubscriber.onError(th);
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // h.e
        public void onNext(T t) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                this.actualSubscriber.onNext(t);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        @Override // h.f
        public void request(long j) {
            if (j <= 0 || h.o.a.a.b(this, j) != 0) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                b();
            } else {
                e(j);
            }
        }

        @Override // h.k
        public void unsubscribe() {
            long j;
            do {
                j = get();
                if (compareAndSet(0L, -1L)) {
                    a();
                    return;
                }
            } while (!compareAndSet(j, -2L));
        }
    }

    public abstract S a(S s, e<? super T> eVar);

    public abstract void b(S s);
}
