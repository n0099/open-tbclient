package rx.observables;

import com.baidu.tieba.cpc;
import com.baidu.tieba.doc;
import com.baidu.tieba.eoc;
import com.baidu.tieba.foc;
import com.baidu.tieba.joc;
import com.baidu.tieba.koc;
import com.baidu.tieba.poc;
import com.baidu.tieba.tsc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public abstract class SyncOnSubscribe<S, T> implements doc.a<T> {
    public abstract S a(S s, eoc<? super T> eocVar);

    public abstract void b(S s);

    /* loaded from: classes2.dex */
    public static final class SubscriptionProducer<S, T> extends AtomicLong implements foc, koc, eoc<T> {
        public static final long serialVersionUID = -3736864024352728072L;
        public final joc<? super T> actualSubscriber;
        public boolean hasTerminated;
        public boolean onNextCalled;
        public final SyncOnSubscribe<S, T> parent;
        public S state;

        public SubscriptionProducer(joc<? super T> jocVar, SyncOnSubscribe<S, T> syncOnSubscribe, S s) {
            this.actualSubscriber = jocVar;
            this.parent = syncOnSubscribe;
            this.state = s;
        }

        private void doUnsubscribe() {
            try {
                this.parent.b(this.state);
            } catch (Throwable th) {
                poc.e(th);
                tsc.j(th);
            }
        }

        private void fastPath() {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            joc<? super T> jocVar = this.actualSubscriber;
            do {
                try {
                    this.onNextCalled = false;
                    nextIteration(syncOnSubscribe);
                } catch (Throwable th) {
                    handleThrownError(jocVar, th);
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

        @Override // com.baidu.tieba.koc
        public boolean isUnsubscribed() {
            if (get() < 0) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.eoc
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

        @Override // com.baidu.tieba.koc
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

        private void handleThrownError(joc<? super T> jocVar, Throwable th) {
            if (this.hasTerminated) {
                tsc.j(th);
                return;
            }
            this.hasTerminated = true;
            jocVar.onError(th);
            unsubscribe();
        }

        private void nextIteration(SyncOnSubscribe<S, T> syncOnSubscribe) {
            this.state = syncOnSubscribe.a(this.state, this);
        }

        private void slowPath(long j) {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            joc<? super T> jocVar = this.actualSubscriber;
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
                        handleThrownError(jocVar, th);
                        return;
                    }
                } while (j2 != 0);
                j = addAndGet(-j);
            } while (j > 0);
            tryUnsubscribe();
        }

        @Override // com.baidu.tieba.eoc
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

        @Override // com.baidu.tieba.eoc
        public void onNext(T t) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                this.actualSubscriber.onNext(t);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        @Override // com.baidu.tieba.foc
        public void request(long j) {
            if (j > 0 && cpc.b(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }
    }
}
