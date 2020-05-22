package io.reactivex.internal.operators.observable;

import io.reactivex.c;
import io.reactivex.c.h;
import io.reactivex.e;
import io.reactivex.internal.a.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableConcatMapCompletable<T> extends io.reactivex.a {
    final int bufferSize;
    final h<? super T, ? extends e> mapper;
    final t<T> source;

    @Override // io.reactivex.a
    public void b(c cVar) {
        this.source.subscribe(new SourceObserver(cVar, this.mapper, this.bufferSize));
    }

    /* loaded from: classes7.dex */
    static final class SourceObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = 6893587405571511048L;
        volatile boolean active;
        final c actual;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final InnerObserver inner;
        final h<? super T, ? extends e> mapper;
        g<T> queue;
        io.reactivex.disposables.b s;
        int sourceMode;

        SourceObserver(c cVar, h<? super T, ? extends e> hVar, int i) {
            this.actual = cVar;
            this.mapper = hVar;
            this.bufferSize = i;
            this.inner = new InnerObserver(cVar, this);
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
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
                this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode == 0) {
                    this.queue.offer(t);
                }
                drain();
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            dispose();
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.inner.dispose();
            this.s.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                while (!this.disposed) {
                    if (!this.active) {
                        boolean z = this.done;
                        try {
                            T poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.disposed = true;
                                this.actual.onComplete();
                                return;
                            } else if (!z2) {
                                try {
                                    e eVar = (e) io.reactivex.internal.functions.a.k(this.mapper.apply(poll), "The mapper returned a null CompletableSource");
                                    this.active = true;
                                    eVar.a(this.inner);
                                } catch (Throwable th) {
                                    io.reactivex.exceptions.a.L(th);
                                    dispose();
                                    this.queue.clear();
                                    this.actual.onError(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.L(th2);
                            dispose();
                            this.queue.clear();
                            this.actual.onError(th2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.queue.clear();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public static final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements c {
            private static final long serialVersionUID = -5987419458390772447L;
            final c actual;
            final SourceObserver<?> parent;

            InnerObserver(c cVar, SourceObserver<?> sourceObserver) {
                this.actual = cVar;
                this.parent = sourceObserver;
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.set(this, bVar);
            }

            @Override // io.reactivex.c
            public void onError(Throwable th) {
                this.parent.dispose();
                this.actual.onError(th);
            }

            @Override // io.reactivex.c
            public void onComplete() {
                this.parent.innerComplete();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
