package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {
    public final int bufferSize;
    public final BiPredicate<? super T, ? super T> comparer;
    public final ObservableSource<? extends T> first;
    public final ObservableSource<? extends T> second;

    /* loaded from: classes7.dex */
    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        public static final long serialVersionUID = -6178010334400373240L;
        public final SingleObserver<? super Boolean> actual;
        public volatile boolean cancelled;
        public final BiPredicate<? super T, ? super T> comparer;
        public final ObservableSource<? extends T> first;
        public final EqualObserver<T>[] observers;
        public final ArrayCompositeDisposable resources;
        public final ObservableSource<? extends T> second;
        public T v1;
        public T v2;

        public EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i2, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.actual = singleObserver;
            this.first = observableSource;
            this.second = observableSource2;
            this.comparer = biPredicate;
            this.observers = r3;
            EqualObserver<T>[] equalObserverArr = {new EqualObserver<>(this, 0, i2), new EqualObserver<>(this, 1, i2)};
            this.resources = new ArrayCompositeDisposable(2);
        }

        public void cancel(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.cancelled = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.resources.dispose();
            if (getAndIncrement() == 0) {
                EqualObserver<T>[] equalObserverArr = this.observers;
                equalObserverArr[0].queue.clear();
                equalObserverArr[1].queue.clear();
            }
        }

        /* JADX DEBUG: Type inference failed for r11v0. Raw type applied. Possible types: T, ? super T */
        /* JADX DEBUG: Type inference failed for r8v1. Raw type applied. Possible types: T, ? super T */
        public void drain() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            EqualObserver<T>[] equalObserverArr = this.observers;
            EqualObserver<T> equalObserver = equalObserverArr[0];
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.queue;
            EqualObserver<T> equalObserver2 = equalObserverArr[1];
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.queue;
            int i2 = 1;
            while (!this.cancelled) {
                boolean z = equalObserver.done;
                if (z && (th2 = equalObserver.error) != null) {
                    cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.actual.onError(th2);
                    return;
                }
                boolean z2 = equalObserver2.done;
                if (z2 && (th = equalObserver2.error) != null) {
                    cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.actual.onError(th);
                    return;
                }
                if (this.v1 == null) {
                    this.v1 = spscLinkedArrayQueue.poll();
                }
                boolean z3 = this.v1 == null;
                if (this.v2 == null) {
                    this.v2 = spscLinkedArrayQueue2.poll();
                }
                boolean z4 = this.v2 == null;
                if (z && z2 && z3 && z4) {
                    this.actual.onSuccess(Boolean.TRUE);
                    return;
                } else if (z && z2 && z3 != z4) {
                    cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.actual.onSuccess(Boolean.FALSE);
                    return;
                } else {
                    if (!z3 && !z4) {
                        try {
                            if (!this.comparer.test((T) this.v1, (T) this.v2)) {
                                cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.actual.onSuccess(Boolean.FALSE);
                                return;
                            }
                            this.v1 = null;
                            this.v2 = null;
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            cancel(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.actual.onError(th3);
                            return;
                        }
                    }
                    if (z3 || z4) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                }
            }
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        public boolean setDisposable(Disposable disposable, int i2) {
            return this.resources.setResource(i2, disposable);
        }

        public void subscribe() {
            EqualObserver<T>[] equalObserverArr = this.observers;
            this.first.subscribe(equalObserverArr[0]);
            this.second.subscribe(equalObserverArr[1]);
        }
    }

    /* loaded from: classes7.dex */
    public static final class EqualObserver<T> implements Observer<T> {
        public volatile boolean done;
        public Throwable error;
        public final int index;
        public final EqualCoordinator<T> parent;
        public final SpscLinkedArrayQueue<T> queue;

        public EqualObserver(EqualCoordinator<T> equalCoordinator, int i2, int i3) {
            this.parent = equalCoordinator;
            this.index = i2;
            this.queue = new SpscLinkedArrayQueue<>(i3);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.queue.offer(t);
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.parent.setDisposable(disposable, this.index);
        }
    }

    public ObservableSequenceEqualSingle(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i2) {
        this.first = observableSource;
        this.second = observableSource2;
        this.comparer = biPredicate;
        this.bufferSize = i2;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableSequenceEqual(this.first, this.second, this.comparer, this.bufferSize));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.bufferSize, this.first, this.second, this.comparer);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe();
    }
}
