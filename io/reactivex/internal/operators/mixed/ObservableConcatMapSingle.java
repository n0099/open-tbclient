package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
@Experimental
/* loaded from: classes7.dex */
public final class ObservableConcatMapSingle<T, R> extends Observable<R> {
    public final ErrorMode errorMode;
    public final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    public final int prefetch;
    public final Observable<T> source;

    /* loaded from: classes7.dex */
    public static final class ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static final int STATE_ACTIVE = 1;
        public static final int STATE_INACTIVE = 0;
        public static final int STATE_RESULT_VALUE = 2;
        public static final long serialVersionUID = -9140123220065488293L;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final Observer<? super R> downstream;
        public final ErrorMode errorMode;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final ConcatMapSingleObserver<R> inner = new ConcatMapSingleObserver<>(this);
        public R item;
        public final Function<? super T, ? extends SingleSource<? extends R>> mapper;
        public final SimplePlainQueue<T> queue;
        public volatile int state;
        public Disposable upstream;

        /* loaded from: classes7.dex */
        public static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            public static final long serialVersionUID = -3051469169682093892L;
            public final ConcatMapSingleMainObserver<?, R> parent;

            public ConcatMapSingleObserver(ConcatMapSingleMainObserver<?, R> concatMapSingleMainObserver) {
                this.parent = concatMapSingleMainObserver;
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(R r) {
                this.parent.innerSuccess(r);
            }
        }

        public ConcatMapSingleMainObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, int i2, ErrorMode errorMode) {
            this.downstream = observer;
            this.mapper = function;
            this.errorMode = errorMode;
            this.queue = new SpscArrayQueue(i2);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.inner.dispose();
            if (getAndIncrement() != 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        /* JADX DEBUG: Type inference failed for r6v7. Raw type applied. Possible types: R, ? super R */
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.downstream;
            ErrorMode errorMode = this.errorMode;
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            int i2 = 1;
            while (true) {
                if (this.cancelled) {
                    simplePlainQueue.clear();
                    this.item = null;
                }
                int i3 = this.state;
                if (atomicThrowable.get() == null || (errorMode != ErrorMode.IMMEDIATE && (errorMode != ErrorMode.BOUNDARY || i3 != 0))) {
                    if (i3 == 0) {
                        boolean z = this.done;
                        T poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                observer.onComplete();
                                return;
                            } else {
                                observer.onError(terminate);
                                return;
                            }
                        } else if (!z2) {
                            try {
                                SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null SingleSource");
                                this.state = 1;
                                singleSource.subscribe(this.inner);
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.upstream.dispose();
                                simplePlainQueue.clear();
                                atomicThrowable.addThrowable(th);
                                observer.onError(atomicThrowable.terminate());
                                return;
                            }
                        }
                    } else if (i3 == 2) {
                        this.item = null;
                        observer.onNext((R) this.item);
                        this.state = 0;
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
            simplePlainQueue.clear();
            this.item = null;
            observer.onError(atomicThrowable.terminate());
        }

        public void innerError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.dispose();
                }
                this.state = 0;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void innerSuccess(R r) {
            this.item = r;
            this.state = 2;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.inner.dispose();
                }
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i2) {
        this.source = observable;
        this.mapper = function;
        this.errorMode = errorMode;
        this.prefetch = i2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        if (ScalarXMapZHelper.tryAsSingle(this.source, this.mapper, observer)) {
            return;
        }
        this.source.subscribe(new ConcatMapSingleMainObserver(observer, this.mapper, this.prefetch, this.errorMode));
    }
}
