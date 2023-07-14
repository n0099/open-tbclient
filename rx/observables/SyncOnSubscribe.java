package rx.observables;

import com.baidu.tieba.a2c;
import com.baidu.tieba.b2c;
import com.baidu.tieba.g2c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.q2c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.v1c;
import com.baidu.tieba.w1c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public abstract class SyncOnSubscribe<S, T> implements u1c.a<T> {
    public abstract S a();

    public abstract S b(S s, v1c<? super T> v1cVar);

    public void c(S s) {
    }

    /* loaded from: classes2.dex */
    public static final class SubscriptionProducer<S, T> extends AtomicLong implements w1c, b2c, v1c<T> {
        public static final long serialVersionUID = -3736864024352728072L;
        public final a2c<? super T> actualSubscriber;
        public boolean hasTerminated;
        public boolean onNextCalled;
        public final SyncOnSubscribe<S, T> parent;
        public S state;

        public SubscriptionProducer(a2c<? super T> a2cVar, SyncOnSubscribe<S, T> syncOnSubscribe, S s) {
            this.actualSubscriber = a2cVar;
            this.parent = syncOnSubscribe;
            this.state = s;
        }

        private void doUnsubscribe() {
            try {
                this.parent.c(this.state);
            } catch (Throwable th) {
                g2c.e(th);
                h6c.j(th);
            }
        }

        private void fastPath() {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            a2c<? super T> a2cVar = this.actualSubscriber;
            do {
                try {
                    this.onNextCalled = false;
                    nextIteration(syncOnSubscribe);
                } catch (Throwable th) {
                    handleThrownError(a2cVar, th);
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

        @Override // com.baidu.tieba.b2c
        public boolean isUnsubscribed() {
            if (get() < 0) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.v1c
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

        @Override // com.baidu.tieba.b2c
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

        private void handleThrownError(a2c<? super T> a2cVar, Throwable th) {
            if (this.hasTerminated) {
                h6c.j(th);
                return;
            }
            this.hasTerminated = true;
            a2cVar.onError(th);
            unsubscribe();
        }

        private void nextIteration(SyncOnSubscribe<S, T> syncOnSubscribe) {
            this.state = syncOnSubscribe.b(this.state, this);
        }

        private void slowPath(long j) {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            a2c<? super T> a2cVar = this.actualSubscriber;
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
                        handleThrownError(a2cVar, th);
                        return;
                    }
                } while (j2 != 0);
                j = addAndGet(-j);
            } while (j > 0);
            tryUnsubscribe();
        }

        @Override // com.baidu.tieba.v1c
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

        @Override // com.baidu.tieba.v1c
        public void onNext(T t) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                this.actualSubscriber.onNext(t);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        @Override // com.baidu.tieba.w1c
        public void request(long j) {
            if (j > 0 && q2c.b(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }
    }

    public final void call(a2c<? super T> a2cVar) {
        try {
            SubscriptionProducer subscriptionProducer = new SubscriptionProducer(a2cVar, this, a());
            a2cVar.b(subscriptionProducer);
            a2cVar.f(subscriptionProducer);
        } catch (Throwable th) {
            g2c.e(th);
            a2cVar.onError(th);
        }
    }

    @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((a2c) ((a2c) obj));
    }
}
