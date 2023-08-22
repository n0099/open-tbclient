package rx.observables;

import com.baidu.tieba.bcc;
import com.baidu.tieba.k8c;
import com.baidu.tieba.n7c;
import com.baidu.tieba.o7c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.t7c;
import com.baidu.tieba.u7c;
import com.baidu.tieba.z7c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public abstract class SyncOnSubscribe<S, T> implements n7c.a<T> {
    public abstract S a();

    public abstract S b(S s, o7c<? super T> o7cVar);

    public void c(S s) {
    }

    /* loaded from: classes2.dex */
    public static final class SubscriptionProducer<S, T> extends AtomicLong implements p7c, u7c, o7c<T> {
        public static final long serialVersionUID = -3736864024352728072L;
        public final t7c<? super T> actualSubscriber;
        public boolean hasTerminated;
        public boolean onNextCalled;
        public final SyncOnSubscribe<S, T> parent;
        public S state;

        public SubscriptionProducer(t7c<? super T> t7cVar, SyncOnSubscribe<S, T> syncOnSubscribe, S s) {
            this.actualSubscriber = t7cVar;
            this.parent = syncOnSubscribe;
            this.state = s;
        }

        private void doUnsubscribe() {
            try {
                this.parent.c(this.state);
            } catch (Throwable th) {
                z7c.e(th);
                bcc.j(th);
            }
        }

        private void fastPath() {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            t7c<? super T> t7cVar = this.actualSubscriber;
            do {
                try {
                    this.onNextCalled = false;
                    nextIteration(syncOnSubscribe);
                } catch (Throwable th) {
                    handleThrownError(t7cVar, th);
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

        @Override // com.baidu.tieba.u7c
        public boolean isUnsubscribed() {
            if (get() < 0) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.o7c
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

        @Override // com.baidu.tieba.u7c
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

        private void handleThrownError(t7c<? super T> t7cVar, Throwable th) {
            if (this.hasTerminated) {
                bcc.j(th);
                return;
            }
            this.hasTerminated = true;
            t7cVar.onError(th);
            unsubscribe();
        }

        private void nextIteration(SyncOnSubscribe<S, T> syncOnSubscribe) {
            this.state = syncOnSubscribe.b(this.state, this);
        }

        private void slowPath(long j) {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            t7c<? super T> t7cVar = this.actualSubscriber;
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
                        handleThrownError(t7cVar, th);
                        return;
                    }
                } while (j2 != 0);
                j = addAndGet(-j);
            } while (j > 0);
            tryUnsubscribe();
        }

        @Override // com.baidu.tieba.o7c
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

        @Override // com.baidu.tieba.o7c
        public void onNext(T t) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                this.actualSubscriber.onNext(t);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        @Override // com.baidu.tieba.p7c
        public void request(long j) {
            if (j > 0 && k8c.b(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }
    }

    public final void call(t7c<? super T> t7cVar) {
        try {
            SubscriptionProducer subscriptionProducer = new SubscriptionProducer(t7cVar, this, a());
            t7cVar.b(subscriptionProducer);
            t7cVar.f(subscriptionProducer);
        } catch (Throwable th) {
            z7c.e(th);
            t7cVar.onError(th);
        }
    }

    @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t7c) ((t7c) obj));
    }
}
