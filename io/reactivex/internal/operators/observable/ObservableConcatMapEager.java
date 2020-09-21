package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.internal.a.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.c;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.t;
import io.reactivex.u;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes25.dex */
public final class ObservableConcatMapEager<T, R> extends a<T, R> {
    final ErrorMode errorMode;
    final h<? super T, ? extends t<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    @Override // io.reactivex.q
    protected void a(u<? super R> uVar) {
        this.source.subscribe(new ConcatMapEagerMainObserver(uVar, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }

    /* loaded from: classes25.dex */
    static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements io.reactivex.disposables.b, c<R>, u<T> {
        private static final long serialVersionUID = 8080567949447303262L;
        int activeCount;
        final u<? super R> actual;
        volatile boolean cancelled;
        InnerQueuedObserver<R> current;
        io.reactivex.disposables.b d;
        volatile boolean done;
        final ErrorMode errorMode;
        final h<? super T, ? extends t<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        g<T> queue;
        int sourceMode;
        final AtomicThrowable error = new AtomicThrowable();
        final ArrayDeque<InnerQueuedObserver<R>> observers = new ArrayDeque<>();

        ConcatMapEagerMainObserver(u<? super R> uVar, h<? super T, ? extends t<? extends R>> hVar, int i, int i2, ErrorMode errorMode) {
            this.actual = uVar;
            this.mapper = hVar;
            this.maxConcurrency = i;
            this.prefetch = i2;
            this.errorMode = errorMode;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                if (bVar instanceof io.reactivex.internal.a.b) {
                    io.reactivex.internal.a.b bVar2 = (io.reactivex.internal.a.b) bVar;
                    int requestFusion = bVar2.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar2;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar2;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.prefetch);
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.error.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                this.queue.clear();
                disposeAll();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        void disposeAll() {
            InnerQueuedObserver<R> innerQueuedObserver = this.current;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver<R> poll = this.observers.poll();
                if (poll == null) {
                    return;
                }
                poll.dispose();
            }
        }

        @Override // io.reactivex.internal.observers.c
        public void innerNext(InnerQueuedObserver<R> innerQueuedObserver, R r) {
            innerQueuedObserver.queue().offer(r);
            drain();
        }

        @Override // io.reactivex.internal.observers.c
        public void innerError(InnerQueuedObserver<R> innerQueuedObserver, Throwable th) {
            if (this.error.addThrowable(th)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.d.dispose();
                }
                innerQueuedObserver.setDone();
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.internal.observers.c
        public void innerComplete(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.setDone();
            drain();
        }

        /* JADX WARN: Code restructure failed: missing block: B:101:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
            r13.activeCount = r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
            if (r13.cancelled == false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
            r5.clear();
            disposeAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
            if (r8 != io.reactivex.internal.util.ErrorMode.IMMEDIATE) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a1, code lost:
            if (r13.error.get() == null) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a3, code lost:
            r5.clear();
            disposeAll();
            r7.onError(r13.error.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00b4, code lost:
            r0 = r13.current;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00b6, code lost:
            if (r0 != null) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00ba, code lost:
            if (r8 != io.reactivex.internal.util.ErrorMode.BOUNDARY) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00c4, code lost:
            if (r13.error.get() == null) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00c6, code lost:
            r5.clear();
            disposeAll();
            r7.onError(r13.error.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
            r9 = r13.done;
            r0 = r6.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00df, code lost:
            if (r0 != null) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00e1, code lost:
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00e2, code lost:
            if (r9 == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00e4, code lost:
            if (r3 == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00ee, code lost:
            if (r13.error.get() == null) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00f0, code lost:
            r5.clear();
            disposeAll();
            r7.onError(r13.error.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0101, code lost:
            r3 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0103, code lost:
            r7.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0108, code lost:
            if (r3 != false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x010a, code lost:
            r13.current = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x010c, code lost:
            r3 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x010d, code lost:
            if (r3 == null) goto L96;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x010f, code lost:
            r9 = r3.queue();
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0115, code lost:
            if (r13.cancelled == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0117, code lost:
            r5.clear();
            disposeAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x011f, code lost:
            r10 = r3.isDone();
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0125, code lost:
            if (r8 != io.reactivex.internal.util.ErrorMode.IMMEDIATE) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x012f, code lost:
            if (r13.error.get() == null) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0131, code lost:
            r5.clear();
            disposeAll();
            r7.onError(r13.error.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0142, code lost:
            r11 = r9.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0146, code lost:
            if (r11 != null) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0148, code lost:
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0149, code lost:
            if (r10 == false) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x014b, code lost:
            if (r0 == false) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x014d, code lost:
            r13.current = null;
            r13.activeCount--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0157, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0158, code lost:
            io.reactivex.exceptions.a.J(r0);
            r13.error.addThrowable(r0);
            r13.current = null;
            r13.activeCount--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x016a, code lost:
            r0 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x016c, code lost:
            if (r0 == false) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x016e, code lost:
            r0 = addAndGet(-r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0173, code lost:
            if (r0 == 0) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0175, code lost:
            r1 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0178, code lost:
            r7.onNext(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:?, code lost:
            return;
         */
        @Override // io.reactivex.internal.observers.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            if (getAndIncrement() == 0) {
                g<T> gVar = this.queue;
                ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.observers;
                u<? super R> uVar = this.actual;
                ErrorMode errorMode = this.errorMode;
                int i = 1;
                while (true) {
                    int i2 = this.activeCount;
                    while (true) {
                        int i3 = i2;
                        if (i3 == this.maxConcurrency) {
                            break;
                        } else if (this.cancelled) {
                            gVar.clear();
                            disposeAll();
                            return;
                        } else if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                            gVar.clear();
                            disposeAll();
                            uVar.onError(this.error.terminate());
                            return;
                        } else {
                            try {
                                T poll = gVar.poll();
                                if (poll == null) {
                                    break;
                                }
                                t tVar = (t) io.reactivex.internal.functions.a.k(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                InnerQueuedObserver<R> innerQueuedObserver = new InnerQueuedObserver<>(this, this.prefetch);
                                arrayDeque.offer(innerQueuedObserver);
                                tVar.subscribe(innerQueuedObserver);
                                i2 = i3 + 1;
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.J(th);
                                this.d.dispose();
                                gVar.clear();
                                disposeAll();
                                this.error.addThrowable(th);
                                uVar.onError(this.error.terminate());
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
