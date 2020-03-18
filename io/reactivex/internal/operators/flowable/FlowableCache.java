package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
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
    protected void a(org.a.c<? super T> cVar) {
        boolean z;
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(cVar, this.state);
        cVar.onSubscribe(replaySubscription);
        if (this.state.a(replaySubscription) && replaySubscription.requested.get() == Long.MIN_VALUE) {
            this.state.b(replaySubscription);
            z = false;
        } else {
            z = true;
        }
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            this.state.connect();
        }
        if (z) {
            replaySubscription.replay();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a<T> extends io.reactivex.internal.util.f implements j<T> {
        static final ReplaySubscription[] nyw = new ReplaySubscription[0];
        static final ReplaySubscription[] nyx = new ReplaySubscription[0];
        volatile boolean isConnected;
        final io.reactivex.g<T> nyr;
        final AtomicReference<org.a.d> nyv;
        boolean nyy;
        final AtomicReference<ReplaySubscription<T>[]> subscribers;

        public boolean a(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription<T>[] replaySubscriptionArr2;
            do {
                replaySubscriptionArr = this.subscribers.get();
                if (replaySubscriptionArr == nyx) {
                    return false;
                }
                int length = replaySubscriptionArr.length;
                replaySubscriptionArr2 = new ReplaySubscription[length + 1];
                System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
                replaySubscriptionArr2[length] = replaySubscription;
            } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
            return true;
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
                            replaySubscriptionArr2 = nyw;
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
        public void onSubscribe(org.a.d dVar) {
            SubscriptionHelper.setOnce(this.nyv, dVar, Format.OFFSET_SAMPLE_RELATIVE);
        }

        public void connect() {
            this.nyr.a((j) this);
            this.isConnected = true;
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.nyy) {
                add(NotificationLite.next(t));
                for (ReplaySubscription<T> replaySubscription : this.subscribers.get()) {
                    replaySubscription.replay();
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (!this.nyy) {
                this.nyy = true;
                add(NotificationLite.error(th));
                SubscriptionHelper.cancel(this.nyv);
                for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(nyx)) {
                    replaySubscription.replay();
                }
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.nyy) {
                this.nyy = true;
                add(NotificationLite.complete());
                SubscriptionHelper.cancel(this.nyv);
                for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(nyx)) {
                    replaySubscription.replay();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements org.a.d {
        private static final long serialVersionUID = -2557562030197141021L;
        final org.a.c<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        long emitted;
        int index;
        final AtomicLong requested = new AtomicLong();
        final a<T> state;

        ReplaySubscription(org.a.c<? super T> cVar, a<T> aVar) {
            this.child = cVar;
            this.state = aVar;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.b(this.requested, j);
                replay();
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.state.b(this);
            }
        }

        public void replay() {
            if (getAndIncrement() == 0) {
                int i = 1;
                org.a.c<? super T> cVar = this.child;
                AtomicLong atomicLong = this.requested;
                long j = this.emitted;
                do {
                    long j2 = atomicLong.get();
                    if (j2 != Long.MIN_VALUE) {
                        int size = this.state.size();
                        if (size != 0) {
                            Object[] objArr = this.currentBuffer;
                            if (objArr == null) {
                                objArr = this.state.dKg();
                                this.currentBuffer = objArr;
                            }
                            int length = objArr.length - 1;
                            int i2 = this.index;
                            long j3 = j;
                            int i3 = this.currentIndexInBuffer;
                            Object[] objArr2 = objArr;
                            int i4 = i2;
                            while (i4 < size && j3 != j2) {
                                if (atomicLong.get() != Long.MIN_VALUE) {
                                    if (i3 == length) {
                                        objArr2 = (Object[]) objArr2[length];
                                        i3 = 0;
                                    }
                                    if (!NotificationLite.accept(objArr2[i3], cVar)) {
                                        i3++;
                                        i4++;
                                        j3++;
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (atomicLong.get() != Long.MIN_VALUE) {
                                if (j2 == j3) {
                                    Object obj = objArr2[i3];
                                    if (NotificationLite.isComplete(obj)) {
                                        cVar.onComplete();
                                        return;
                                    } else if (NotificationLite.isError(obj)) {
                                        cVar.onError(NotificationLite.getError(obj));
                                        return;
                                    }
                                }
                                this.index = i4;
                                this.currentIndexInBuffer = i3;
                                this.currentBuffer = objArr2;
                                j = j3;
                            } else {
                                return;
                            }
                        }
                        this.emitted = j;
                        i = addAndGet(-i);
                    } else {
                        return;
                    }
                } while (i != 0);
            }
        }
    }
}
