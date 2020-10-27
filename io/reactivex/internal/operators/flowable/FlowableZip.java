package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class FlowableZip<T, R> extends io.reactivex.g<R> {
    final int bufferSize;
    final boolean delayError;
    final Iterable<? extends org.a.b<? extends T>> pDr;
    final org.a.b<? extends T>[] sources;
    final h<? super Object[], ? extends R> zipper;

    @Override // io.reactivex.g
    public void a(org.a.c<? super R> cVar) {
        int length;
        org.a.b<? extends T>[] bVarArr;
        org.a.b<? extends T>[] bVarArr2;
        org.a.b<? extends T>[] bVarArr3 = this.sources;
        if (bVarArr3 == null) {
            int i = 0;
            org.a.b<? extends T>[] bVarArr4 = new org.a.b[8];
            for (org.a.b<? extends T> bVar : this.pDr) {
                if (i == bVarArr4.length) {
                    bVarArr2 = new org.a.b[(i >> 2) + i];
                    System.arraycopy(bVarArr4, 0, bVarArr2, 0, i);
                } else {
                    bVarArr2 = bVarArr4;
                }
                bVarArr2[i] = bVar;
                i++;
                bVarArr4 = bVarArr2;
            }
            bVarArr = bVarArr4;
            length = i;
        } else {
            length = bVarArr3.length;
            bVarArr = bVarArr3;
        }
        if (length == 0) {
            EmptySubscription.complete(cVar);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(cVar, this.zipper, length, this.bufferSize, this.delayError);
        cVar.onSubscribe(zipCoordinator);
        zipCoordinator.subscribe(bVarArr, length);
    }

    /* loaded from: classes17.dex */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements org.a.d {
        private static final long serialVersionUID = -2434867452883857743L;
        final org.a.c<? super R> actual;
        volatile boolean cancelled;
        final Object[] current;
        final boolean delayErrors;
        final AtomicThrowable errors;
        final AtomicLong requested;
        final ZipSubscriber<T, R>[] subscribers;
        final h<? super Object[], ? extends R> zipper;

        ZipCoordinator(org.a.c<? super R> cVar, h<? super Object[], ? extends R> hVar, int i, int i2, boolean z) {
            this.actual = cVar;
            this.zipper = hVar;
            this.delayErrors = z;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                zipSubscriberArr[i3] = new ZipSubscriber<>(this, i2);
            }
            this.current = new Object[i];
            this.subscribers = zipSubscriberArr;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        void subscribe(org.a.b<? extends T>[] bVarArr, int i) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < i && !this.cancelled; i2++) {
                if (this.delayErrors || this.errors.get() == null) {
                    bVarArr[i2].subscribe(zipSubscriberArr[i2]);
                } else {
                    return;
                }
            }
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
            }
        }

        void error(ZipSubscriber<T, R> zipSubscriber, Throwable th) {
            if (this.errors.addThrowable(th)) {
                zipSubscriber.done = true;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        void cancelAll() {
            for (ZipSubscriber<T, R> zipSubscriber : this.subscribers) {
                zipSubscriber.cancel();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:122:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00a4, code lost:
            if (r12 != r6) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a8, code lost:
            if (r14.cancelled != false) goto L110;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00ac, code lost:
            if (r14.delayErrors != false) goto L75;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00b4, code lost:
            if (r14.errors.get() == null) goto L75;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00b6, code lost:
            cancelAll();
            r5.onError(r14.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00f9, code lost:
            r3 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00fb, code lost:
            if (r3 >= r9) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00fd, code lost:
            r0 = r8[r3];
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0101, code lost:
            if (r10[r3] != null) goto L108;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0103, code lost:
            r4 = r0.done;
            r0 = r0.queue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0107, code lost:
            if (r0 == null) goto L100;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0109, code lost:
            r2 = r0.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x010e, code lost:
            if (r2 != null) goto L99;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0110, code lost:
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0111, code lost:
            if (r4 == false) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0113, code lost:
            if (r0 == false) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0115, code lost:
            cancelAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x0120, code lost:
            if (r14.errors.get() == null) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0122, code lost:
            r5.onError(r14.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x012d, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x012e, code lost:
            io.reactivex.exceptions.a.J(r0);
            r14.errors.addThrowable(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0138, code lost:
            if (r14.delayErrors == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x013a, code lost:
            cancelAll();
            r5.onError(r14.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0148, code lost:
            r2 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x014b, code lost:
            r0 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x014d, code lost:
            r5.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0152, code lost:
            if (r0 != false) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0154, code lost:
            r10[r3] = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0156, code lost:
            r3 = r3 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x015e, code lost:
            if (r6 == 0) goto L121;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0160, code lost:
            r2 = r8.length;
            r0 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0162, code lost:
            if (r0 >= r2) goto L117;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0164, code lost:
            r8[r0].request(r6);
            r0 = r0 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0173, code lost:
            if (r12 == Long.MAX_VALUE) goto L121;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0175, code lost:
            r14.requested.addAndGet(-r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x017b, code lost:
            r0 = addAndGet(-r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0180, code lost:
            if (r0 == 0) goto L124;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            if (getAndIncrement() == 0) {
                org.a.c<? super R> cVar = this.actual;
                ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
                int length = zipSubscriberArr.length;
                Object[] objArr = this.current;
                int i = 1;
                while (true) {
                    int i2 = i;
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        long j3 = j2;
                        if (j == j3) {
                            break;
                        } else if (!this.cancelled) {
                            if (!this.delayErrors && this.errors.get() != null) {
                                cancelAll();
                                cVar.onError(this.errors.terminate());
                                return;
                            }
                            boolean z = false;
                            for (int i3 = 0; i3 < length; i3++) {
                                ZipSubscriber<T, R> zipSubscriber = zipSubscriberArr[i3];
                                if (objArr[i3] == null) {
                                    try {
                                        boolean z2 = zipSubscriber.done;
                                        io.reactivex.internal.a.g<T> gVar = zipSubscriber.queue;
                                        T poll = gVar != null ? gVar.poll() : null;
                                        boolean z3 = poll == null;
                                        if (z2 && z3) {
                                            cancelAll();
                                            if (this.errors.get() != null) {
                                                cVar.onError(this.errors.terminate());
                                                return;
                                            } else {
                                                cVar.onComplete();
                                                return;
                                            }
                                        } else if (!z3) {
                                            objArr[i3] = poll;
                                        } else {
                                            z = true;
                                        }
                                    } catch (Throwable th) {
                                        io.reactivex.exceptions.a.J(th);
                                        this.errors.addThrowable(th);
                                        if (!this.delayErrors) {
                                            cancelAll();
                                            cVar.onError(this.errors.terminate());
                                            return;
                                        }
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                break;
                            }
                            try {
                                cVar.onNext((Object) io.reactivex.internal.functions.a.l(this.zipper.apply(objArr.clone()), "The zipper returned a null value"));
                                j2 = 1 + j3;
                                Arrays.fill(objArr, (Object) null);
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.J(th2);
                                cancelAll();
                                this.errors.addThrowable(th2);
                                cVar.onError(this.errors.terminate());
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class ZipSubscriber<T, R> extends AtomicReference<org.a.d> implements j<T>, org.a.d {
        private static final long serialVersionUID = -4627193790118206028L;
        volatile boolean done;
        final int limit;
        final ZipCoordinator<T, R> parent;
        final int prefetch;
        long produced;
        io.reactivex.internal.a.g<T> queue;
        int sourceMode;

        ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.parent = zipCoordinator;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                if (dVar instanceof io.reactivex.internal.a.d) {
                    io.reactivex.internal.a.d dVar2 = (io.reactivex.internal.a.d) dVar;
                    int requestFusion = dVar2.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = dVar2;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = dVar2;
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                dVar.request(this.prefetch);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            this.parent.drain();
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.a.d
        public void request(long j) {
            if (this.sourceMode != 1) {
                long j2 = this.produced + j;
                if (j2 >= this.limit) {
                    this.produced = 0L;
                    get().request(j2);
                    return;
                }
                this.produced = j2;
            }
        }
    }
}
