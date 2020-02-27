package io.reactivex.internal.operators.mixed;

import io.reactivex.c.h;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableSwitchMapMaybe<T, R> extends q<R> {
    final boolean delayErrors;
    final h<? super T, ? extends o<? extends R>> mapper;
    final q<T> nxK;

    @Override // io.reactivex.q
    protected void a(u<? super R> uVar) {
        if (!a.a(this.nxK, this.mapper, uVar)) {
            this.nxK.subscribe(new SwitchMapMaybeMainObserver(uVar, this.mapper, this.delayErrors));
        }
    }

    /* loaded from: classes7.dex */
    static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements b, u<T> {
        static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = new SwitchMapMaybeObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final u<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicReference<SwitchMapMaybeObserver<R>> inner = new AtomicReference<>();
        final h<? super T, ? extends o<? extends R>> mapper;
        b upstream;

        SwitchMapMaybeMainObserver(u<? super R> uVar, h<? super T, ? extends o<? extends R>> hVar, boolean z) {
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

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver$SwitchMapMaybeObserver<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.u
        public void onNext(T t) {
            SwitchMapMaybeObserver<R> switchMapMaybeObserver;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver2 = this.inner.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.dispose();
            }
            try {
                o oVar = (o) io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver<R> switchMapMaybeObserver3 = new SwitchMapMaybeObserver<>(this);
                do {
                    switchMapMaybeObserver = this.inner.get();
                    if (switchMapMaybeObserver == INNER_DISPOSED) {
                        return;
                    }
                } while (!this.inner.compareAndSet(switchMapMaybeObserver, switchMapMaybeObserver3));
                oVar.a(switchMapMaybeObserver3);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
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

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver$SwitchMapMaybeObserver<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        void disposeInner() {
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = (SwitchMapMaybeObserver) this.inner.getAndSet(INNER_DISPOSED);
            if (switchMapMaybeObserver != null && switchMapMaybeObserver != INNER_DISPOSED) {
                switchMapMaybeObserver.dispose();
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

        void innerError(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th) {
            if (this.inner.compareAndSet(switchMapMaybeObserver, null) && this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    this.upstream.dispose();
                    disposeInner();
                }
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        void innerComplete(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (this.inner.compareAndSet(switchMapMaybeObserver, null)) {
                drain();
            }
        }

        /* JADX DEBUG: Type inference failed for r0v7. Raw type applied. Possible types: R, ? super R */
        void drain() {
            if (getAndIncrement() == 0) {
                u<? super R> uVar = this.downstream;
                AtomicThrowable atomicThrowable = this.errors;
                AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
                int i = 1;
                while (!this.cancelled) {
                    if (atomicThrowable.get() != null && !this.delayErrors) {
                        uVar.onError(atomicThrowable.terminate());
                        return;
                    }
                    boolean z = this.done;
                    SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
                    boolean z2 = switchMapMaybeObserver == null;
                    if (z && z2) {
                        Throwable terminate = atomicThrowable.terminate();
                        if (terminate != null) {
                            uVar.onError(terminate);
                            return;
                        } else {
                            uVar.onComplete();
                            return;
                        }
                    } else if (!z2 && switchMapMaybeObserver.item != null) {
                        atomicReference.compareAndSet(switchMapMaybeObserver, null);
                        uVar.onNext((R) switchMapMaybeObserver.item);
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
        /* loaded from: classes7.dex */
        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<b> implements m<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final SwitchMapMaybeMainObserver<?, R> parent;

            SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
                this.parent = switchMapMaybeMainObserver;
            }

            @Override // io.reactivex.m
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.m
            public void onSuccess(R r) {
                this.item = r;
                this.parent.drain();
            }

            @Override // io.reactivex.m
            public void onError(Throwable th) {
                this.parent.innerError(this, th);
            }

            @Override // io.reactivex.m
            public void onComplete() {
                this.parent.innerComplete(this);
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
