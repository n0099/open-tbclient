package rx.observables;

import com.baidu.tieba.g7c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.i6c;
import com.baidu.tieba.j6c;
import com.baidu.tieba.n6c;
import com.baidu.tieba.o6c;
import com.baidu.tieba.t6c;
import com.baidu.tieba.xac;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public abstract class SyncOnSubscribe<S, T> implements h6c.a<T> {
    public abstract S a(S s, i6c<? super T> i6cVar);

    public abstract void b(S s);

    /* loaded from: classes2.dex */
    public static final class SubscriptionProducer<S, T> extends AtomicLong implements j6c, o6c, i6c<T> {
        public static final long serialVersionUID = -3736864024352728072L;
        public final n6c<? super T> actualSubscriber;
        public boolean hasTerminated;
        public boolean onNextCalled;
        public final SyncOnSubscribe<S, T> parent;
        public S state;

        public SubscriptionProducer(n6c<? super T> n6cVar, SyncOnSubscribe<S, T> syncOnSubscribe, S s) {
            this.actualSubscriber = n6cVar;
            this.parent = syncOnSubscribe;
            this.state = s;
        }

        private void doUnsubscribe() {
            try {
                this.parent.b(this.state);
            } catch (Throwable th) {
                t6c.e(th);
                xac.j(th);
            }
        }

        private void fastPath() {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            n6c<? super T> n6cVar = this.actualSubscriber;
            do {
                try {
                    this.onNextCalled = false;
                    nextIteration(syncOnSubscribe);
                } catch (Throwable th) {
                    handleThrownError(n6cVar, th);
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

        @Override // com.baidu.tieba.o6c
        public boolean isUnsubscribed() {
            if (get() < 0) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.i6c
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

        @Override // com.baidu.tieba.o6c
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

        private void handleThrownError(n6c<? super T> n6cVar, Throwable th) {
            if (this.hasTerminated) {
                xac.j(th);
                return;
            }
            this.hasTerminated = true;
            n6cVar.onError(th);
            unsubscribe();
        }

        private void nextIteration(SyncOnSubscribe<S, T> syncOnSubscribe) {
            this.state = syncOnSubscribe.a(this.state, this);
        }

        private void slowPath(long j) {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            n6c<? super T> n6cVar = this.actualSubscriber;
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
                        handleThrownError(n6cVar, th);
                        return;
                    }
                } while (j2 != 0);
                j = addAndGet(-j);
            } while (j > 0);
            tryUnsubscribe();
        }

        @Override // com.baidu.tieba.i6c
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

        @Override // com.baidu.tieba.i6c
        public void onNext(T t) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                this.actualSubscriber.onNext(t);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        @Override // com.baidu.tieba.j6c
        public void request(long j) {
            if (j > 0 && g7c.b(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }
    }
}
