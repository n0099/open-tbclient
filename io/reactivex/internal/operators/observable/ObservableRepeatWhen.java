package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableRepeatWhen<T> extends AbstractObservableWithUpstream<T, T> {
    public final Function<? super Observable<Object>, ? extends ObservableSource<?>> handler;

    /* loaded from: classes7.dex */
    public static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        public static final long serialVersionUID = 802743776666017014L;
        public volatile boolean active;
        public final Observer<? super T> actual;
        public final Subject<Object> signaller;
        public final ObservableSource<T> source;
        public final AtomicInteger wip = new AtomicInteger();
        public final AtomicThrowable error = new AtomicThrowable();
        public final RepeatWhenObserver<T>.InnerRepeatObserver inner = new InnerRepeatObserver();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Disposable> f72424d = new AtomicReference<>();

        /* loaded from: classes7.dex */
        public final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            public static final long serialVersionUID = 3254781284376480842L;

            public InnerRepeatObserver() {
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                RepeatWhenObserver.this.innerComplete();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RepeatWhenObserver.this.innerError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(Object obj) {
                RepeatWhenObserver.this.innerNext();
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public RepeatWhenObserver(Observer<? super T> observer, Subject<Object> subject, ObservableSource<T> observableSource) {
            this.actual = observer;
            this.signaller = subject;
            this.source = observableSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.f72424d);
            DisposableHelper.dispose(this.inner);
        }

        public void innerComplete() {
            DisposableHelper.dispose(this.f72424d);
            HalfSerializer.onComplete(this.actual, this, this.error);
        }

        public void innerError(Throwable th) {
            DisposableHelper.dispose(this.f72424d);
            HalfSerializer.onError(this.actual, th, this, this.error);
        }

        public void innerNext() {
            subscribeNext();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f72424d.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.active = false;
            this.signaller.onNext(0);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.inner);
            HalfSerializer.onError(this.actual, th, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            HalfSerializer.onNext(this.actual, t, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f72424d, disposable);
        }

        public void subscribeNext() {
            if (this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.subscribe(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRepeatWhen(ObservableSource<T> observableSource, Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.handler = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Subject<T> serialized = PublishSubject.create().toSerialized();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.handler.apply(serialized), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, serialized, this.source);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.inner);
            repeatWhenObserver.subscribeNext();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
