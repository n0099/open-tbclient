package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.c.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableSwitchMap<T, R> extends a<T, R> {
    final int bufferSize;
    final boolean delayErrors;
    final h<? super T, ? extends org.a.b<? extends R>> mapper;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super R> cVar) {
        if (!g.a(this.nyr, cVar, this.mapper)) {
            this.nyr.a((j) new SwitchMapSubscriber(cVar, this.mapper, this.bufferSize, this.delayErrors));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements j<T>, org.a.d {
        static final SwitchMapInnerSubscriber<Object, Object> CANCELLED = new SwitchMapInnerSubscriber<>(null, -1, 1);
        private static final long serialVersionUID = -3491074160481096299L;
        final org.a.c<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final h<? super T, ? extends org.a.b<? extends R>> mapper;
        org.a.d s;
        volatile long unique;
        final AtomicReference<SwitchMapInnerSubscriber<T, R>> active = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final AtomicThrowable error = new AtomicThrowable();

        static {
            CANCELLED.cancel();
        }

        SwitchMapSubscriber(org.a.c<? super R> cVar, h<? super T, ? extends org.a.b<? extends R>> hVar, int i, boolean z) {
            this.actual = cVar;
            this.mapper = hVar;
            this.bufferSize = i;
            this.delayErrors = z;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber;
            if (!this.done) {
                long j = 1 + this.unique;
                this.unique = j;
                SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber2 = this.active.get();
                if (switchMapInnerSubscriber2 != null) {
                    switchMapInnerSubscriber2.cancel();
                }
                try {
                    org.a.b bVar = (org.a.b) io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The publisher returned is null");
                    SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber3 = new SwitchMapInnerSubscriber<>(this, j, this.bufferSize);
                    do {
                        switchMapInnerSubscriber = this.active.get();
                        if (switchMapInnerSubscriber == CANCELLED) {
                            return;
                        }
                    } while (!this.active.compareAndSet(switchMapInnerSubscriber, switchMapInnerSubscriber3));
                    bVar.subscribe(switchMapInnerSubscriber3);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.H(th);
                    this.s.cancel();
                    onError(th);
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (!this.done && this.error.addThrowable(th)) {
                if (!this.delayErrors) {
                    disposeInner();
                }
                this.done = true;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                if (this.unique == 0) {
                    this.s.request(Format.OFFSET_SAMPLE_RELATIVE);
                } else {
                    drain();
                }
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                disposeInner();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> */
        /* JADX WARN: Multi-variable type inference failed */
        void disposeInner() {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber;
            if (this.active.get() != CANCELLED && (switchMapInnerSubscriber = (SwitchMapInnerSubscriber) this.active.getAndSet(CANCELLED)) != CANCELLED && switchMapInnerSubscriber != null) {
                switchMapInnerSubscriber.cancel();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:106:0x000b, code lost:
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00da, code lost:
            if (r8 == 0) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00de, code lost:
            if (r14.cancelled != false) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00e7, code lost:
            if (r12 == com.google.android.exoplayer2.Format.OFFSET_SAMPLE_RELATIVE) goto L75;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00e9, code lost:
            r14.requested.addAndGet(-r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00ef, code lost:
            r0.get().request(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00f8, code lost:
            if (r1 != false) goto L84;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            boolean z;
            Object obj;
            boolean z2;
            if (getAndIncrement() == 0) {
                org.a.c<? super R> cVar = this.actual;
                int i = 1;
                while (!this.cancelled) {
                    if (this.done) {
                        if (this.delayErrors) {
                            if (this.active.get() == null) {
                                if (this.error.get() != null) {
                                    cVar.onError(this.error.terminate());
                                    return;
                                } else {
                                    cVar.onComplete();
                                    return;
                                }
                            }
                        } else if (this.error.get() != null) {
                            disposeInner();
                            cVar.onError(this.error.terminate());
                            return;
                        } else if (this.active.get() == null) {
                            cVar.onComplete();
                            return;
                        }
                    }
                    SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber = this.active.get();
                    io.reactivex.internal.a.g<R> gVar = switchMapInnerSubscriber != null ? switchMapInnerSubscriber.queue : null;
                    if (gVar != null) {
                        if (switchMapInnerSubscriber.done) {
                            if (!this.delayErrors) {
                                if (this.error.get() != null) {
                                    disposeInner();
                                    cVar.onError(this.error.terminate());
                                    return;
                                } else if (gVar.isEmpty()) {
                                    this.active.compareAndSet(switchMapInnerSubscriber, null);
                                }
                            } else if (gVar.isEmpty()) {
                                this.active.compareAndSet(switchMapInnerSubscriber, null);
                            }
                        }
                        long j = this.requested.get();
                        long j2 = 0;
                        while (true) {
                            long j3 = j2;
                            if (j3 == j) {
                                z = false;
                                break;
                            } else if (!this.cancelled) {
                                boolean z3 = switchMapInnerSubscriber.done;
                                try {
                                    obj = gVar.poll();
                                    z2 = z3;
                                } catch (Throwable th) {
                                    io.reactivex.exceptions.a.H(th);
                                    switchMapInnerSubscriber.cancel();
                                    this.error.addThrowable(th);
                                    obj = null;
                                    z2 = true;
                                }
                                boolean z4 = obj == null;
                                if (switchMapInnerSubscriber != this.active.get()) {
                                    z = true;
                                    break;
                                }
                                if (z2) {
                                    if (!this.delayErrors) {
                                        if (this.error.get() != null) {
                                            cVar.onError(this.error.terminate());
                                            return;
                                        } else if (z4) {
                                            this.active.compareAndSet(switchMapInnerSubscriber, null);
                                            z = true;
                                            break;
                                        }
                                    } else if (z4) {
                                        this.active.compareAndSet(switchMapInnerSubscriber, null);
                                        z = true;
                                        break;
                                    }
                                }
                                if (z4) {
                                    z = false;
                                    break;
                                } else {
                                    cVar.onNext(obj);
                                    j2 = 1 + j3;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    int addAndGet = addAndGet(-i);
                    if (addAndGet == 0) {
                        return;
                    }
                    i = addAndGet;
                }
                this.active.lazySet(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<org.a.d> implements j<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long index;
        final SwitchMapSubscriber<T, R> parent;
        volatile io.reactivex.internal.a.g<R> queue;

        SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> switchMapSubscriber, long j, int i) {
            this.parent = switchMapSubscriber;
            this.index = j;
            this.bufferSize = i;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                if (dVar instanceof io.reactivex.internal.a.d) {
                    io.reactivex.internal.a.d dVar2 = (io.reactivex.internal.a.d) dVar;
                    int requestFusion = dVar2.requestFusion(7);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = dVar2;
                        this.done = true;
                        this.parent.drain();
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
        public void onNext(R r) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique) {
                if (this.fusionMode == 0 && !this.queue.offer(r)) {
                    onError(new MissingBackpressureException("Queue full?!"));
                } else {
                    switchMapSubscriber.drain();
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique && switchMapSubscriber.error.addThrowable(th)) {
                if (!switchMapSubscriber.delayErrors) {
                    switchMapSubscriber.s.cancel();
                }
                this.done = true;
                switchMapSubscriber.drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique) {
                this.done = true;
                switchMapSubscriber.drain();
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }
}
