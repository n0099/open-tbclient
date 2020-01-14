package io.reactivex.internal.operators.mixed;

import io.reactivex.aa;
import io.reactivex.c.h;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.q;
import io.reactivex.u;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class ObservableSwitchMapSingle<T, R> extends q<R> {
    final boolean delayErrors;
    final h<? super T, ? extends aa<? extends R>> mapper;
    final q<T> nxi;

    @Override // io.reactivex.q
    protected void a(u<? super R> uVar) {
        if (!a.b(this.nxi, this.mapper, uVar)) {
            this.nxi.subscribe(new SwitchMapSingleMainObserver(uVar, this.mapper, this.delayErrors));
        }
    }

    /* loaded from: classes5.dex */
    static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements b, u<T> {
        static final SwitchMapSingleObserver<Object> INNER_DISPOSED = new SwitchMapSingleObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final u<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicReference<SwitchMapSingleObserver<R>> inner = new AtomicReference<>();
        final h<? super T, ? extends aa<? extends R>> mapper;
        b upstream;

        SwitchMapSingleMainObserver(u<? super R> uVar, h<? super T, ? extends aa<? extends R>> hVar, boolean z) {
            this.downstream = uVar;
            this.mapper = hVar;
            this.delayErrors = z;
        }

        @Override // io.reactivex.u
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.u
        public void onNext(T t) {
            SwitchMapSingleObserver<R> switchMapSingleObserver;
            SwitchMapSingleObserver<R> switchMapSingleObserver2 = this.inner.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.dispose();
            }
            try {
                aa aaVar = (aa) io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver<R> switchMapSingleObserver3 = new SwitchMapSingleObserver<>(this);
                do {
                    switchMapSingleObserver = this.inner.get();
                    if (switchMapSingleObserver == INNER_DISPOSED) {
                        return;
                    }
                } while (!this.inner.compareAndSet(switchMapSingleObserver, switchMapSingleObserver3));
                aaVar.a(switchMapSingleObserver3);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
                this.upstream.dispose();
                this.inner.getAndSet(INNER_DISPOSED);
                onError(th);
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    disposeInner();
                }
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

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        void disposeInner() {
            SwitchMapSingleObserver<Object> switchMapSingleObserver = (SwitchMapSingleObserver) this.inner.getAndSet(INNER_DISPOSED);
            if (switchMapSingleObserver != null && switchMapSingleObserver != INNER_DISPOSED) {
                switchMapSingleObserver.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        void innerError(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th) {
            if (this.inner.compareAndSet(switchMapSingleObserver, null) && this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    this.upstream.dispose();
                    disposeInner();
                }
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        /* JADX DEBUG: Type inference failed for r0v7. Raw type applied. Possible types: R, ? super R */
        void drain() {
            if (getAndIncrement() == 0) {
                u<? super R> uVar = this.downstream;
                AtomicThrowable atomicThrowable = this.errors;
                AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
                int i = 1;
                while (!this.cancelled) {
                    if (atomicThrowable.get() != null && !this.delayErrors) {
                        uVar.onError(atomicThrowable.terminate());
                        return;
                    }
                    boolean z = this.done;
                    SwitchMapSingleObserver<R> switchMapSingleObserver = atomicReference.get();
                    boolean z2 = switchMapSingleObserver == null;
                    if (z && z2) {
                        Throwable terminate = atomicThrowable.terminate();
                        if (terminate != null) {
                            uVar.onError(terminate);
                            return;
                        } else {
                            uVar.onComplete();
                            return;
                        }
                    } else if (!z2 && switchMapSingleObserver.item != null) {
                        atomicReference.compareAndSet(switchMapSingleObserver, null);
                        uVar.onNext((R) switchMapSingleObserver.item);
                    } else {
                        int addAndGet = addAndGet(-i);
                        if (addAndGet == 0) {
                            return;
                        }
                        i = addAndGet;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SwitchMapSingleObserver<R> extends AtomicReference<b> implements y<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final SwitchMapSingleMainObserver<?, R> parent;

            SwitchMapSingleObserver(SwitchMapSingleMainObserver<?, R> switchMapSingleMainObserver) {
                this.parent = switchMapSingleMainObserver;
            }

            @Override // io.reactivex.y
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.y
            public void onSuccess(R r) {
                this.item = r;
                this.parent.drain();
            }

            @Override // io.reactivex.y
            public void onError(Throwable th) {
                this.parent.innerError(this, th);
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
