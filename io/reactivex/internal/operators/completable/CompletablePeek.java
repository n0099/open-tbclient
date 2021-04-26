package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
/* loaded from: classes7.dex */
public final class CompletablePeek extends Completable {
    public final Action onAfterTerminate;
    public final Action onComplete;
    public final Action onDispose;
    public final Consumer<? super Throwable> onError;
    public final Consumer<? super Disposable> onSubscribe;
    public final Action onTerminate;
    public final CompletableSource source;

    /* loaded from: classes7.dex */
    public final class CompletableObserverImplementation implements CompletableObserver, Disposable {
        public final CompletableObserver actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f68240d;

        public CompletableObserverImplementation(CompletableObserver completableObserver) {
            this.actual = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            try {
                CompletablePeek.this.onDispose.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.f68240d.dispose();
        }

        public void doAfter() {
            try {
                CompletablePeek.this.onAfterTerminate.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f68240d.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.f68240d == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                CompletablePeek.this.onComplete.run();
                CompletablePeek.this.onTerminate.run();
                this.actual.onComplete();
                doAfter();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (this.f68240d == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th);
                return;
            }
            try {
                CompletablePeek.this.onError.accept(th);
                CompletablePeek.this.onTerminate.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.actual.onError(th);
            doAfter();
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            try {
                CompletablePeek.this.onSubscribe.accept(disposable);
                if (DisposableHelper.validate(this.f68240d, disposable)) {
                    this.f68240d = disposable;
                    this.actual.onSubscribe(this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                disposable.dispose();
                this.f68240d = DisposableHelper.DISPOSED;
                EmptyDisposable.error(th, this.actual);
            }
        }
    }

    public CompletablePeek(CompletableSource completableSource, Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        this.source = completableSource;
        this.onSubscribe = consumer;
        this.onError = consumer2;
        this.onComplete = action;
        this.onTerminate = action2;
        this.onAfterTerminate = action3;
        this.onDispose = action4;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new CompletableObserverImplementation(completableObserver));
    }
}
