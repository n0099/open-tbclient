package rx.observables;

import com.baidu.tieba.ebc;
import com.baidu.tieba.gfc;
import com.baidu.tieba.pbc;
import com.baidu.tieba.sac;
import com.baidu.tieba.tac;
import com.baidu.tieba.uac;
import com.baidu.tieba.yac;
import com.baidu.tieba.zac;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public abstract class SyncOnSubscribe<S, T> implements sac.a<T> {
    public abstract S a();

    public abstract S b(S s, tac<? super T> tacVar);

    public void c(S s) {
    }

    /* loaded from: classes2.dex */
    public static final class SubscriptionProducer<S, T> extends AtomicLong implements uac, zac, tac<T> {
        public static final long serialVersionUID = -3736864024352728072L;
        public final yac<? super T> actualSubscriber;
        public boolean hasTerminated;
        public boolean onNextCalled;
        public final SyncOnSubscribe<S, T> parent;
        public S state;

        public SubscriptionProducer(yac<? super T> yacVar, SyncOnSubscribe<S, T> syncOnSubscribe, S s) {
            this.actualSubscriber = yacVar;
            this.parent = syncOnSubscribe;
            this.state = s;
        }

        private void doUnsubscribe() {
            try {
                this.parent.c(this.state);
            } catch (Throwable th) {
                ebc.e(th);
                gfc.j(th);
            }
        }

        private void fastPath() {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            yac<? super T> yacVar = this.actualSubscriber;
            do {
                try {
                    this.onNextCalled = false;
                    nextIteration(syncOnSubscribe);
                } catch (Throwable th) {
                    handleThrownError(yacVar, th);
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

        @Override // com.baidu.tieba.zac
        public boolean isUnsubscribed() {
            if (get() < 0) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.tac
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

        @Override // com.baidu.tieba.zac
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

        private void handleThrownError(yac<? super T> yacVar, Throwable th) {
            if (this.hasTerminated) {
                gfc.j(th);
                return;
            }
            this.hasTerminated = true;
            yacVar.onError(th);
            unsubscribe();
        }

        private void nextIteration(SyncOnSubscribe<S, T> syncOnSubscribe) {
            this.state = syncOnSubscribe.b(this.state, this);
        }

        private void slowPath(long j) {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            yac<? super T> yacVar = this.actualSubscriber;
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
                        handleThrownError(yacVar, th);
                        return;
                    }
                } while (j2 != 0);
                j = addAndGet(-j);
            } while (j > 0);
            tryUnsubscribe();
        }

        @Override // com.baidu.tieba.tac
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

        @Override // com.baidu.tieba.tac
        public void onNext(T t) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                this.actualSubscriber.onNext(t);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        @Override // com.baidu.tieba.uac
        public void request(long j) {
            if (j > 0 && pbc.b(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }
    }

    public final void call(yac<? super T> yacVar) {
        try {
            SubscriptionProducer subscriptionProducer = new SubscriptionProducer(yacVar, this, a());
            yacVar.b(subscriptionProducer);
            yacVar.f(subscriptionProducer);
        } catch (Throwable th) {
            ebc.e(th);
            yacVar.onError(th);
        }
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
    }
}
