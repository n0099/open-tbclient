package io.reactivex.internal.operators.mixed;

import com.google.android.exoplayer2.Format;
import io.reactivex.c;
import io.reactivex.c.h;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes7.dex */
public final class FlowableSwitchMapCompletable<T> extends io.reactivex.a {
    final boolean delayErrors;
    final h<? super T, ? extends e> mapper;
    final g<T> nwt;

    @Override // io.reactivex.a
    protected void b(c cVar) {
        this.nwt.a((j) new SwitchMapCompletableObserver(cVar, this.mapper, this.delayErrors));
    }

    /* loaded from: classes7.dex */
    static final class SwitchMapCompletableObserver<T> implements b, j<T> {
        static final SwitchMapInnerObserver nxL = new SwitchMapInnerObserver(null);
        final boolean delayErrors;
        volatile boolean done;
        final c downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicReference<SwitchMapInnerObserver> inner = new AtomicReference<>();
        final h<? super T, ? extends e> mapper;
        d upstream;

        SwitchMapCompletableObserver(c cVar, h<? super T, ? extends e> hVar, boolean z) {
            this.downstream = cVar;
            this.mapper = hVar;
            this.delayErrors = z;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                dVar.request(Format.OFFSET_SAMPLE_RELATIVE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                e eVar = (e) io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.inner.get();
                    if (switchMapInnerObserver == nxL) {
                        return;
                    }
                } while (!this.inner.compareAndSet(switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.dispose();
                }
                eVar.a(switchMapInnerObserver2);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        @Override // org.a.c
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
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
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
            SwitchMapInnerObserver andSet = this.inner.getAndSet(nxL);
            if (andSet != null && andSet != nxL) {
                andSet.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.cancel();
            disposeInner();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.inner.get() == nxL;
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
            io.reactivex.e.a.onError(th);
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
        /* loaded from: classes7.dex */
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
