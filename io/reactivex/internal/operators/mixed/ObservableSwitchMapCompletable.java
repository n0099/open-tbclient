package io.reactivex.internal.operators.mixed;

import io.reactivex.b.h;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.q;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class ObservableSwitchMapCompletable<T> extends io.reactivex.a {
    final boolean delayErrors;
    final q<T> mUU;
    final h<? super T, ? extends e> mapper;

    @Override // io.reactivex.a
    protected void b(c cVar) {
        if (!a.a(this.mUU, this.mapper, cVar)) {
            this.mUU.subscribe(new SwitchMapCompletableObserver(cVar, this.mapper, this.delayErrors));
        }
    }

    /* loaded from: classes4.dex */
    static final class SwitchMapCompletableObserver<T> implements b, u<T> {
        static final SwitchMapInnerObserver mUV = new SwitchMapInnerObserver(null);
        final boolean delayErrors;
        volatile boolean done;
        final c downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicReference<SwitchMapInnerObserver> inner = new AtomicReference<>();
        final h<? super T, ? extends e> mapper;
        b upstream;

        SwitchMapCompletableObserver(c cVar, h<? super T, ? extends e> hVar, boolean z) {
            this.downstream = cVar;
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

        @Override // io.reactivex.u
        public void onNext(T t) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                e eVar = (e) io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.inner.get();
                    if (switchMapInnerObserver == mUV) {
                        return;
                    }
                } while (!this.inner.compareAndSet(switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.dispose();
                }
                eVar.a(switchMapInnerObserver2);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.delayErrors) {
                    onComplete();
                    return;
                }
                disposeInner();
                Throwable terminate = this.errors.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.downstream.onError(terminate);
                    return;
                }
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.done = true;
            if (this.inner.get() == null) {
                Throwable terminate = this.errors.terminate();
                if (terminate == null) {
                    this.downstream.onComplete();
                } else {
                    this.downstream.onError(terminate);
                }
            }
        }

        void disposeInner() {
            SwitchMapInnerObserver andSet = this.inner.getAndSet(mUV);
            if (andSet != null && andSet != mUV) {
                andSet.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            disposeInner();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.inner.get() == mUV;
        }

        void a(SwitchMapInnerObserver switchMapInnerObserver, Throwable th) {
            if (this.inner.compareAndSet(switchMapInnerObserver, null) && this.errors.addThrowable(th)) {
                if (this.delayErrors) {
                    if (this.done) {
                        this.downstream.onError(this.errors.terminate());
                        return;
                    }
                    return;
                }
                dispose();
                Throwable terminate = this.errors.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.downstream.onError(terminate);
                    return;
                }
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        void a(SwitchMapInnerObserver switchMapInnerObserver) {
            if (this.inner.compareAndSet(switchMapInnerObserver, null) && this.done) {
                Throwable terminate = this.errors.terminate();
                if (terminate == null) {
                    this.downstream.onComplete();
                } else {
                    this.downstream.onError(terminate);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SwitchMapInnerObserver extends AtomicReference<b> implements c {
            private static final long serialVersionUID = -8003404460084760287L;
            final SwitchMapCompletableObserver<?> parent;

            SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.parent = switchMapCompletableObserver;
            }

            @Override // io.reactivex.c
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.c
            public void onError(Throwable th) {
                this.parent.a(this, th);
            }

            @Override // io.reactivex.c
            public void onComplete() {
                this.parent.a(this);
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
