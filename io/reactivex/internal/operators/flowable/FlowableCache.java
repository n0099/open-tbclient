package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableCache<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final AtomicBoolean once;
    final a<T> state;

    @Override // io.reactivex.g
    protected void a(org.b.c<? super T> cVar) {
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(cVar, this.state);
        this.state.a(replaySubscription);
        cVar.onSubscribe(replaySubscription);
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            this.state.connect();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a<T> extends io.reactivex.internal.util.f implements j<T> {
        static final ReplaySubscription[] omY = new ReplaySubscription[0];
        static final ReplaySubscription[] omZ = new ReplaySubscription[0];
        final io.reactivex.g<T> omT;
        final AtomicReference<org.b.d> omX;
        volatile boolean ona;
        boolean onb;
        final AtomicReference<ReplaySubscription<T>[]> subscribers;

        public void a(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription<T>[] replaySubscriptionArr2;
            do {
                replaySubscriptionArr = this.subscribers.get();
                if (replaySubscriptionArr != omZ) {
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
                            replaySubscriptionArr2 = omY;
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

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            if (SubscriptionHelper.setOnce(this.omX, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        public void connect() {
            this.omT.a((j) this);
            this.ona = true;
        }

        @Override // org.b.c
        public void onNext(T t) {
            if (!this.onb) {
                add(NotificationLite.next(t));
                for (ReplaySubscription<T> replaySubscription : this.subscribers.get()) {
                    replaySubscription.replay();
                }
            }
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            if (!this.onb) {
                this.onb = true;
                add(NotificationLite.error(th));
                SubscriptionHelper.cancel(this.omX);
                for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(omZ)) {
                    replaySubscription.replay();
                }
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.b.c
        public void onComplete() {
            if (!this.onb) {
                this.onb = true;
                add(NotificationLite.complete());
                SubscriptionHelper.cancel(this.omX);
                for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(omZ)) {
                    replaySubscription.replay();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements org.b.d {
        private static final long serialVersionUID = -2557562030197141021L;
        final org.b.c<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        int index;
        final AtomicLong requested = new AtomicLong();
        final a<T> state;

        ReplaySubscription(org.b.c<? super T> cVar, a<T> aVar) {
            this.child = cVar;
            this.state = aVar;
        }

        @Override // org.b.d
        public void request(long j) {
            long j2;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = this.requested.get();
                    if (j2 != -1) {
                    } else {
                        return;
                    }
                } while (!this.requested.compareAndSet(j2, io.reactivex.internal.util.b.P(j2, j)));
                replay();
            }
        }

        @Override // org.b.d
        public void cancel() {
            if (this.requested.getAndSet(-1L) != -1) {
                this.state.b(this);
            }
        }

        public void replay() {
            if (getAndIncrement() == 0) {
                int i = 1;
                org.b.c<? super T> cVar = this.child;
                AtomicLong atomicLong = this.requested;
                while (true) {
                    int i2 = i;
                    long j = atomicLong.get();
                    if (j >= 0) {
                        int size = this.state.size();
                        if (size != 0) {
                            Object[] objArr = this.currentBuffer;
                            if (objArr == null) {
                                objArr = this.state.efC();
                                this.currentBuffer = objArr;
                            }
                            int length = objArr.length - 1;
                            int i3 = this.index;
                            int i4 = 0;
                            Object[] objArr2 = objArr;
                            int i5 = this.currentIndexInBuffer;
                            while (i3 < size && j > 0) {
                                if (atomicLong.get() != -1) {
                                    if (i5 == length) {
                                        objArr2 = (Object[]) objArr2[length];
                                        i5 = 0;
                                    }
                                    if (!NotificationLite.accept(objArr2[i5], cVar)) {
                                        i3++;
                                        j--;
                                        i4++;
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
                                    Object obj = objArr2[i5];
                                    if (NotificationLite.isComplete(obj)) {
                                        cVar.onComplete();
                                        return;
                                    } else if (NotificationLite.isError(obj)) {
                                        cVar.onError(NotificationLite.getError(obj));
                                        return;
                                    }
                                }
                                if (i4 != 0) {
                                    io.reactivex.internal.util.b.d(atomicLong, i4);
                                }
                                this.index = i3;
                                this.currentIndexInBuffer = i5;
                                this.currentBuffer = objArr2;
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
