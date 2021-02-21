package rx.observables;

import java.util.concurrent.atomic.AtomicLong;
import rx.c.c;
import rx.d;
import rx.e;
import rx.f;
import rx.j;
import rx.k;
/* loaded from: classes5.dex */
public abstract class SyncOnSubscribe<S, T> implements d.a<T> {
    protected abstract S a(S s, e<? super T> eVar);

    protected abstract S eNJ();

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public final void call(j<? super T> jVar) {
        try {
            SubscriptionProducer subscriptionProducer = new SubscriptionProducer(jVar, this, eNJ());
            jVar.add(subscriptionProducer);
            jVar.setProducer(subscriptionProducer);
        } catch (Throwable th) {
            rx.exceptions.a.N(th);
            jVar.onError(th);
        }
    }

    protected void ch(S s) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class SubscriptionProducer<S, T> extends AtomicLong implements e<T>, f, k {
        private static final long serialVersionUID = -3736864024352728072L;
        private final j<? super T> actualSubscriber;
        private boolean hasTerminated;
        private boolean onNextCalled;
        private final SyncOnSubscribe<S, T> parent;
        private S state;

        SubscriptionProducer(j<? super T> jVar, SyncOnSubscribe<S, T> syncOnSubscribe, S s) {
            this.actualSubscriber = jVar;
            this.parent = syncOnSubscribe;
            this.state = s;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() < 0;
        }

        @Override // rx.k
        public void unsubscribe() {
            long j;
            do {
                j = get();
                if (compareAndSet(0L, -1L)) {
                    eNL();
                    return;
                }
            } while (!compareAndSet(j, -2L));
        }

        private boolean eNK() {
            if (this.hasTerminated || get() < -1) {
                set(-1L);
                eNL();
                return true;
            }
            return false;
        }

        private void eNL() {
            try {
                this.parent.ch(this.state);
            } catch (Throwable th) {
                rx.exceptions.a.N(th);
                c.onError(th);
            }
        }

        @Override // rx.f
        public void request(long j) {
            if (j > 0 && rx.internal.operators.a.e(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        private void fastPath() {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            j<? super T> jVar = this.actualSubscriber;
            do {
                try {
                    this.onNextCalled = false;
                    a(syncOnSubscribe);
                } catch (Throwable th) {
                    a(jVar, th);
                    return;
                }
            } while (!eNK());
        }

        private void a(j<? super T> jVar, Throwable th) {
            if (this.hasTerminated) {
                c.onError(th);
                return;
            }
            this.hasTerminated = true;
            jVar.onError(th);
            unsubscribe();
        }

        private void slowPath(long j) {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            j<? super T> jVar = this.actualSubscriber;
            do {
                long j2 = j;
                do {
                    try {
                        this.onNextCalled = false;
                        a(syncOnSubscribe);
                        if (!eNK()) {
                            if (this.onNextCalled) {
                                j2--;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        a(jVar, th);
                        return;
                    }
                } while (j2 != 0);
                j = addAndGet(-j);
            } while (j > 0);
            eNK();
        }

        private void a(SyncOnSubscribe<S, T> syncOnSubscribe) {
            this.state = syncOnSubscribe.a(this.state, this);
        }

        @Override // rx.e
        public void onCompleted() {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            if (!this.actualSubscriber.isUnsubscribed()) {
                this.actualSubscriber.onCompleted();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            if (!this.actualSubscriber.isUnsubscribed()) {
                this.actualSubscriber.onError(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (this.onNextCalled) {
                throw new IllegalStateException("onNext called multiple times!");
            }
            this.onNextCalled = true;
            this.actualSubscriber.onNext(t);
        }
    }
}
