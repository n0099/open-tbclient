package rx.observables;

import com.baidu.tieba.asa;
import com.baidu.tieba.jsa;
import com.baidu.tieba.ora;
import com.baidu.tieba.pra;
import com.baidu.tieba.qra;
import com.baidu.tieba.ura;
import com.baidu.tieba.vra;
import com.baidu.tieba.vva;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public abstract class SyncOnSubscribe<S, T> implements ora.a<T> {
    public abstract S a();

    public abstract S b(S s, pra<? super T> praVar);

    public void c(S s) {
    }

    /* loaded from: classes9.dex */
    public static final class SubscriptionProducer<S, T> extends AtomicLong implements qra, vra, pra<T> {
        public static final long serialVersionUID = -3736864024352728072L;
        public final ura<? super T> actualSubscriber;
        public boolean hasTerminated;
        public boolean onNextCalled;
        public final SyncOnSubscribe<S, T> parent;
        public S state;

        public SubscriptionProducer(ura<? super T> uraVar, SyncOnSubscribe<S, T> syncOnSubscribe, S s) {
            this.actualSubscriber = uraVar;
            this.parent = syncOnSubscribe;
            this.state = s;
        }

        private void doUnsubscribe() {
            try {
                this.parent.c(this.state);
            } catch (Throwable th) {
                asa.e(th);
                vva.j(th);
            }
        }

        private void fastPath() {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            ura<? super T> uraVar = this.actualSubscriber;
            do {
                try {
                    this.onNextCalled = false;
                    nextIteration(syncOnSubscribe);
                } catch (Throwable th) {
                    handleThrownError(uraVar, th);
                    return;
                }
            } while (!tryUnsubscribe());
        }

        private boolean tryUnsubscribe() {
            if (!this.hasTerminated && get() >= -1) {
                return false;
            }
            set(-1L);
            doUnsubscribe();
            return true;
        }

        @Override // com.baidu.tieba.vra
        public boolean isUnsubscribed() {
            if (get() < 0) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.pra
        public void onCompleted() {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                if (!this.actualSubscriber.isUnsubscribed()) {
                    this.actualSubscriber.onCompleted();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // com.baidu.tieba.vra
        public void unsubscribe() {
            long j;
            do {
                j = get();
                if (compareAndSet(0L, -1L)) {
                    doUnsubscribe();
                    return;
                }
            } while (!compareAndSet(j, -2L));
        }

        private void handleThrownError(ura<? super T> uraVar, Throwable th) {
            if (this.hasTerminated) {
                vva.j(th);
                return;
            }
            this.hasTerminated = true;
            uraVar.onError(th);
            unsubscribe();
        }

        private void nextIteration(SyncOnSubscribe<S, T> syncOnSubscribe) {
            this.state = syncOnSubscribe.b(this.state, this);
        }

        private void slowPath(long j) {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            ura<? super T> uraVar = this.actualSubscriber;
            do {
                long j2 = j;
                do {
                    try {
                        this.onNextCalled = false;
                        nextIteration(syncOnSubscribe);
                        if (tryUnsubscribe()) {
                            return;
                        }
                        if (this.onNextCalled) {
                            j2--;
                        }
                    } catch (Throwable th) {
                        handleThrownError(uraVar, th);
                        return;
                    }
                } while (j2 != 0);
                j = addAndGet(-j);
            } while (j > 0);
            tryUnsubscribe();
        }

        @Override // com.baidu.tieba.pra
        public void onError(Throwable th) {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                if (!this.actualSubscriber.isUnsubscribed()) {
                    this.actualSubscriber.onError(th);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // com.baidu.tieba.pra
        public void onNext(T t) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                this.actualSubscriber.onNext(t);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        @Override // com.baidu.tieba.qra
        public void request(long j) {
            if (j > 0 && jsa.b(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }
    }

    public final void call(ura<? super T> uraVar) {
        try {
            SubscriptionProducer subscriptionProducer = new SubscriptionProducer(uraVar, this, a());
            uraVar.b(subscriptionProducer);
            uraVar.f(subscriptionProducer);
        } catch (Throwable th) {
            asa.e(th);
            uraVar.onError(th);
        }
    }

    @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ura) ((ura) obj));
    }
}
