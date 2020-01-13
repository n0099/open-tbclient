package io.reactivex.processors;

import com.google.android.exoplayer2.Format;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.a.g;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;
/* loaded from: classes5.dex */
public final class MulticastProcessor<T> extends a<T> {
    static final MulticastSubscription[] nAf = new MulticastSubscription[0];
    static final MulticastSubscription[] nAg = new MulticastSubscription[0];
    final int bufferSize;
    int consumed;
    volatile boolean done;
    volatile Throwable error;
    int fusionMode;
    final int limit;
    final boolean nAe;
    final AtomicBoolean once;
    volatile g<T> queue;
    final AtomicReference<MulticastSubscription<T>[]> subscribers;
    final AtomicReference<d> upstream;
    final AtomicInteger wip;

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
            if (dVar instanceof io.reactivex.internal.a.d) {
                io.reactivex.internal.a.d dVar2 = (io.reactivex.internal.a.d) dVar;
                int requestFusion = dVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = dVar2;
                    dVar.request(this.bufferSize);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.bufferSize);
            dVar.request(this.bufferSize);
        }
    }

    @Override // org.a.c
    public void onNext(T t) {
        if (!this.once.get()) {
            if (this.fusionMode == 0) {
                io.reactivex.internal.functions.a.h(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                if (!this.queue.offer(t)) {
                    SubscriptionHelper.cancel(this.upstream);
                    onError(new MissingBackpressureException());
                    return;
                }
            }
            drain();
        }
    }

    @Override // org.a.c
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.h(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.once.compareAndSet(false, true)) {
            this.error = th;
            this.done = true;
            drain();
            return;
        }
        io.reactivex.e.a.onError(th);
    }

    @Override // org.a.c
    public void onComplete() {
        if (this.once.compareAndSet(false, true)) {
            this.done = true;
            drain();
        }
    }

    @Override // io.reactivex.g
    protected void a(c<? super T> cVar) {
        Throwable th;
        MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(cVar, this);
        cVar.onSubscribe(multicastSubscription);
        if (a(multicastSubscription)) {
            if (multicastSubscription.get() == Long.MIN_VALUE) {
                b(multicastSubscription);
            } else {
                drain();
            }
        } else if ((this.once.get() || !this.nAe) && (th = this.error) != null) {
            cVar.onError(th);
        } else {
            cVar.onComplete();
        }
    }

    boolean a(MulticastSubscription<T> multicastSubscription) {
        MulticastSubscription<T>[] multicastSubscriptionArr;
        MulticastSubscription<T>[] multicastSubscriptionArr2;
        do {
            multicastSubscriptionArr = this.subscribers.get();
            if (multicastSubscriptionArr == nAg) {
                return false;
            }
            int length = multicastSubscriptionArr.length;
            multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
            multicastSubscriptionArr2[length] = multicastSubscription;
        } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
        return true;
    }

    void b(MulticastSubscription<T> multicastSubscription) {
        while (true) {
            MulticastSubscription<T>[] multicastSubscriptionArr = this.subscribers.get();
            int length = multicastSubscriptionArr.length;
            if (length != 0) {
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (multicastSubscriptionArr[i] == multicastSubscription) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        if (this.nAe) {
                            if (this.subscribers.compareAndSet(multicastSubscriptionArr, nAg)) {
                                SubscriptionHelper.cancel(this.upstream);
                                this.once.set(true);
                                return;
                            }
                        } else if (this.subscribers.compareAndSet(multicastSubscriptionArr, nAf)) {
                            return;
                        }
                    } else {
                        MulticastSubscription<T>[] multicastSubscriptionArr2 = new MulticastSubscription[length - 1];
                        System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, i);
                        System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr2, i, (length - i) - 1);
                        if (this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2)) {
                            return;
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x000a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void drain() {
        int i;
        int addAndGet;
        boolean z;
        T t;
        if (this.wip.getAndIncrement() == 0) {
            AtomicReference<MulticastSubscription<T>[]> atomicReference = this.subscribers;
            int i2 = this.consumed;
            int i3 = this.limit;
            int i4 = this.fusionMode;
            int i5 = 1;
            int i6 = i2;
            while (true) {
                g<T> gVar = this.queue;
                if (gVar != null) {
                    MulticastSubscription<T>[] multicastSubscriptionArr = atomicReference.get();
                    if (multicastSubscriptionArr.length != 0) {
                        long j = -1;
                        for (MulticastSubscription<T> multicastSubscription : multicastSubscriptionArr) {
                            long j2 = multicastSubscription.get();
                            if (j2 >= 0) {
                                if (j == -1) {
                                    j = j2 - multicastSubscription.emitted;
                                } else {
                                    j = Math.min(j, j2 - multicastSubscription.emitted);
                                }
                            }
                        }
                        int i7 = i6;
                        while (j > 0) {
                            MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference.get();
                            if (multicastSubscriptionArr2 == nAg) {
                                gVar.clear();
                                return;
                            } else if (multicastSubscriptionArr != multicastSubscriptionArr2) {
                                i6 = i7;
                                break;
                            } else {
                                try {
                                    z = this.done;
                                    t = gVar.poll();
                                } catch (Throwable th) {
                                    io.reactivex.exceptions.a.I(th);
                                    SubscriptionHelper.cancel(this.upstream);
                                    this.error = th;
                                    this.done = true;
                                    z = true;
                                    t = null;
                                }
                                boolean z2 = t == null;
                                if (z && z2) {
                                    Throwable th2 = this.error;
                                    if (th2 != null) {
                                        for (MulticastSubscription<T> multicastSubscription2 : atomicReference.getAndSet(nAg)) {
                                            multicastSubscription2.onError(th2);
                                        }
                                        return;
                                    }
                                    for (MulticastSubscription<T> multicastSubscription3 : atomicReference.getAndSet(nAg)) {
                                        multicastSubscription3.onComplete();
                                    }
                                    return;
                                } else if (z2) {
                                    break;
                                } else {
                                    for (MulticastSubscription<T> multicastSubscription4 : multicastSubscriptionArr) {
                                        multicastSubscription4.onNext(t);
                                    }
                                    j--;
                                    if (i4 != 1 && (i7 = i7 + 1) == i3) {
                                        i7 = 0;
                                        this.upstream.get().request(i3);
                                    }
                                }
                            }
                        }
                        if (j == 0) {
                            MulticastSubscription<T>[] multicastSubscriptionArr3 = atomicReference.get();
                            if (multicastSubscriptionArr3 == nAg) {
                                gVar.clear();
                                return;
                            } else if (multicastSubscriptionArr != multicastSubscriptionArr3) {
                                i6 = i7;
                            } else if (this.done && gVar.isEmpty()) {
                                Throwable th3 = this.error;
                                if (th3 != null) {
                                    for (MulticastSubscription<T> multicastSubscription5 : atomicReference.getAndSet(nAg)) {
                                        multicastSubscription5.onError(th3);
                                    }
                                    return;
                                }
                                for (MulticastSubscription<T> multicastSubscription6 : atomicReference.getAndSet(nAg)) {
                                    multicastSubscription6.onComplete();
                                }
                                return;
                            }
                        }
                        i = i7;
                        addAndGet = this.wip.addAndGet(-i5);
                        if (addAndGet != 0) {
                            return;
                        }
                        i5 = addAndGet;
                        i6 = i;
                    }
                }
                i = i6;
                addAndGet = this.wip.addAndGet(-i5);
                if (addAndGet != 0) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class MulticastSubscription<T> extends AtomicLong implements d {
        private static final long serialVersionUID = -363282618957264509L;
        final c<? super T> actual;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(c<? super T> cVar, MulticastProcessor<T> multicastProcessor) {
            this.actual = cVar;
            this.parent = multicastProcessor;
        }

        @Override // org.a.d
        public void request(long j) {
            long j2;
            long j3;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE && j2 != Format.OFFSET_SAMPLE_RELATIVE) {
                        j3 = j2 + j;
                        if (j3 < 0) {
                            j3 = Long.MAX_VALUE;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                this.parent.drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.b(this);
            }
        }

        void onNext(T t) {
            if (get() != Long.MIN_VALUE) {
                this.emitted++;
                this.actual.onNext(t);
            }
        }

        void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.actual.onError(th);
            }
        }

        void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.actual.onComplete();
            }
        }
    }
}
