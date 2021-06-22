package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
@Experimental
/* loaded from: classes7.dex */
public final class MaybeDoFinally<T> extends AbstractMaybeWithUpstream<T, T> {
    public final Action onFinally;

    /* loaded from: classes7.dex */
    public static final class DoFinallyObserver<T> extends AtomicInteger implements MaybeObserver<T>, Disposable {
        public static final long serialVersionUID = 4109457741734051389L;
        public final MaybeObserver<? super T> actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f72384d;
        public final Action onFinally;

        public DoFinallyObserver(MaybeObserver<? super T> maybeObserver, Action action) {
            this.actual = maybeObserver;
            this.onFinally = action;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f72384d.dispose();
            runFinally();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f72384d.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f72384d, disposable)) {
                this.f72384d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
            runFinally();
        }

        public void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }

    public MaybeDoFinally(MaybeSource<T> maybeSource, Action action) {
        super(maybeSource);
        this.onFinally = action;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new DoFinallyObserver(maybeObserver, this.onFinally));
    }
}
