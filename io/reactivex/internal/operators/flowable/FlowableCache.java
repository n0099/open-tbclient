package io.reactivex.internal.operators.flowable;

import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.f;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes5.dex */
public final class FlowableCache<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final AtomicBoolean once;
    final a<T> state;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(cVar, this.state);
        this.state.a(replaySubscription);
        cVar.onSubscribe(replaySubscription);
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            this.state.connect();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T> extends f implements j<T> {
        static final ReplaySubscription[] qob = new ReplaySubscription[0];
        static final ReplaySubscription[] qoc = new ReplaySubscription[0];
        volatile boolean isConnected;
        final g<T> qnW;
        final AtomicReference<d> qoa;
        boolean qod;
        final AtomicReference<ReplaySubscription<T>[]> subscribers;

        public void a(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription<T>[] replaySubscriptionArr2;
            do {
                replaySubscriptionArr = this.subscribers.get();
                if (replaySubscriptionArr != qoc) {
                    int length = replaySubscriptionArr.length;
                    replaySubscriptionArr2 = new ReplaySubscription[length + 1];
                    System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
                    replaySubscriptionArr2[length] = replaySubscription;
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        }

        public void b(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription<T>[] replaySubscriptionArr2;
            do {
                replaySubscriptionArr = this.subscribers.get();
                int length = replaySubscriptionArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (replaySubscriptionArr[i2].equals(replaySubscription)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            replaySubscriptionArr2 = qob;
                        } else {
                            replaySubscriptionArr2 = new ReplaySubscription[length - 1];
                            System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, i);
                            System.arraycopy(replaySubscriptionArr, i + 1, replaySubscriptionArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this.qoa, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void connect() {
            this.qnW.a((j) this);
            this.isConnected = true;
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.qod) {
                add(NotificationLite.next(t));
                for (ReplaySubscription<T> replaySubscription : this.subscribers.get()) {
                    replaySubscription.replay();
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (!this.qod) {
                this.qod = true;
                add(NotificationLite.error(th));
                SubscriptionHelper.cancel(this.qoa);
                for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(qoc)) {
                    replaySubscription.replay();
                }
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.qod) {
                this.qod = true;
                add(NotificationLite.complete());
                SubscriptionHelper.cancel(this.qoa);
                for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(qoc)) {
                    replaySubscription.replay();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements d {
        private static final long serialVersionUID = -2557562030197141021L;
        final org.a.c<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        int index;
        final AtomicLong requested = new AtomicLong();
        final a<T> state;

        ReplaySubscription(org.a.c<? super T> cVar, a<T> aVar) {
            this.child = cVar;
            this.state = aVar;
        }

        @Override // org.a.d
        public void request(long j) {
            long j2;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = this.requested.get();
                    if (j2 != -1) {
                    } else {
                        return;
                    }
                } while (!this.requested.compareAndSet(j2, io.reactivex.internal.util.b.X(j2, j)));
                replay();
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (this.requested.getAndSet(-1L) != -1) {
                this.state.b(this);
            }
        }

        public void replay() {
            if (getAndIncrement() == 0) {
                int i = 1;
                org.a.c<? super T> cVar = this.child;
                AtomicLong atomicLong = this.requested;
                while (true) {
                    int i2 = i;
                    long j = atomicLong.get();
                    if (j >= 0) {
                        int size = this.state.size();
                        if (size != 0) {
                            Object[] objArr = this.currentBuffer;
                            if (objArr == null) {
                                objArr = this.state.eKE();
                                this.currentBuffer = objArr;
                            }
                            int length = objArr.length - 1;
                            int i3 = this.index;
                            int i4 = this.currentIndexInBuffer;
                            int i5 = 0;
                            while (i3 < size && j > 0) {
                                if (atomicLong.get() != -1) {
                                    if (i4 == length) {
                                        objArr = (Object[]) objArr[length];
                                        i4 = 0;
                                    }
                                    if (!NotificationLite.accept(objArr[i4], cVar)) {
                                        i4++;
                                        i3++;
                                        j--;
                                        i5++;
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (atomicLong.get() != -1) {
                                if (j == 0) {
                                    Object obj = objArr[i4];
                                    if (NotificationLite.isComplete(obj)) {
                                        cVar.onComplete();
                                        return;
                                    } else if (NotificationLite.isError(obj)) {
                                        cVar.onError(NotificationLite.getError(obj));
                                        return;
                                    }
                                }
                                if (i5 != 0) {
                                    io.reactivex.internal.util.b.d(atomicLong, i5);
                                }
                                this.index = i3;
                                this.currentIndexInBuffer = i4;
                                this.currentBuffer = objArr;
                            } else {
                                return;
                            }
                        }
                        i = addAndGet(-i2);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
