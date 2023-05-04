package rx.observables;

import com.baidu.tieba.e6b;
import com.baidu.tieba.j5b;
import com.baidu.tieba.k5b;
import com.baidu.tieba.l5b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.q5b;
import com.baidu.tieba.s9b;
import com.baidu.tieba.v5b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public abstract class SyncOnSubscribe<S, T> implements j5b.a<T> {
    public abstract S a();

    public abstract S b(S s, k5b<? super T> k5bVar);

    public void c(S s) {
    }

    /* loaded from: classes9.dex */
    public static final class SubscriptionProducer<S, T> extends AtomicLong implements l5b, q5b, k5b<T> {
        public static final long serialVersionUID = -3736864024352728072L;
        public final p5b<? super T> actualSubscriber;
        public boolean hasTerminated;
        public boolean onNextCalled;
        public final SyncOnSubscribe<S, T> parent;
        public S state;

        public SubscriptionProducer(p5b<? super T> p5bVar, SyncOnSubscribe<S, T> syncOnSubscribe, S s) {
            this.actualSubscriber = p5bVar;
            this.parent = syncOnSubscribe;
            this.state = s;
        }

        private void doUnsubscribe() {
            try {
                this.parent.c(this.state);
            } catch (Throwable th) {
                v5b.e(th);
                s9b.j(th);
            }
        }

        private void fastPath() {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            p5b<? super T> p5bVar = this.actualSubscriber;
            do {
                try {
                    this.onNextCalled = false;
                    nextIteration(syncOnSubscribe);
                } catch (Throwable th) {
                    handleThrownError(p5bVar, th);
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

        @Override // com.baidu.tieba.q5b
        public boolean isUnsubscribed() {
            if (get() < 0) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.k5b
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

        @Override // com.baidu.tieba.q5b
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

        private void handleThrownError(p5b<? super T> p5bVar, Throwable th) {
            if (this.hasTerminated) {
                s9b.j(th);
                return;
            }
            this.hasTerminated = true;
            p5bVar.onError(th);
            unsubscribe();
        }

        private void nextIteration(SyncOnSubscribe<S, T> syncOnSubscribe) {
            this.state = syncOnSubscribe.b(this.state, this);
        }

        private void slowPath(long j) {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            p5b<? super T> p5bVar = this.actualSubscriber;
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
                        handleThrownError(p5bVar, th);
                        return;
                    }
                } while (j2 != 0);
                j = addAndGet(-j);
            } while (j > 0);
            tryUnsubscribe();
        }

        @Override // com.baidu.tieba.k5b
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

        @Override // com.baidu.tieba.k5b
        public void onNext(T t) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                this.actualSubscriber.onNext(t);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        @Override // com.baidu.tieba.l5b
        public void request(long j) {
            if (j > 0 && e6b.b(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }
    }

    public final void call(p5b<? super T> p5bVar) {
        try {
            SubscriptionProducer subscriptionProducer = new SubscriptionProducer(p5bVar, this, a());
            p5bVar.b(subscriptionProducer);
            p5bVar.f(subscriptionProducer);
        } catch (Throwable th) {
            v5b.e(th);
            p5bVar.onError(th);
        }
    }

    @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((p5b) ((p5b) obj));
    }
}
