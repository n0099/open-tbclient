package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableSwitchMap<T, R> extends AbstractObservableWithUpstream<T, R> {
    public final int bufferSize;
    public final boolean delayErrors;
    public final Function<? super T, ? extends ObservableSource<? extends R>> mapper;

    /* loaded from: classes7.dex */
    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {
        public static final long serialVersionUID = 3837284832786408377L;
        public final int bufferSize;
        public volatile boolean done;
        public final long index;
        public final SwitchMapObserver<T, R> parent;
        public volatile SimpleQueue<R> queue;

        public SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j, int i2) {
            this.parent = switchMapObserver;
            this.index = j;
            this.bufferSize = i2;
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.parent.innerError(this, th);
        }

        @Override // io.reactivex.Observer
        public void onNext(R r) {
            if (this.index == this.parent.unique) {
                if (r != null) {
                    this.queue.offer(r);
                }
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.queue = queueDisposable;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.queue = queueDisposable;
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.bufferSize);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static final SwitchMapInnerObserver<Object, Object> CANCELLED;
        public static final long serialVersionUID = -3491074160481096299L;
        public final Observer<? super R> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        public Disposable s;
        public volatile long unique;
        public final AtomicReference<SwitchMapInnerObserver<T, R>> active = new AtomicReference<>();
        public final AtomicThrowable errors = new AtomicThrowable();

        static {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = new SwitchMapInnerObserver<>(null, -1L, 1);
            CANCELLED = switchMapInnerObserver;
            switchMapInnerObserver.cancel();
        }

        public SwitchMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z) {
            this.actual = observer;
            this.mapper = function;
            this.bufferSize = i2;
            this.delayErrors = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.dispose();
            disposeInner();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver<T, R>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void disposeInner() {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.active.get();
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver3 = CANCELLED;
            if (switchMapInnerObserver2 == switchMapInnerObserver3 || (switchMapInnerObserver = (SwitchMapInnerObserver) this.active.getAndSet(switchMapInnerObserver3)) == CANCELLED || switchMapInnerObserver == null) {
                return;
            }
            switchMapInnerObserver.cancel();
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x000f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x00e9 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            SimpleQueue<R> simpleQueue;
            R r;
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.actual;
            AtomicReference<SwitchMapInnerObserver<T, R>> atomicReference = this.active;
            boolean z = this.delayErrors;
            int i2 = 1;
            while (!this.cancelled) {
                if (this.done) {
                    boolean z2 = atomicReference.get() == null;
                    if (z) {
                        if (z2) {
                            Throwable th = this.errors.get();
                            if (th != null) {
                                observer.onError(th);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        }
                    } else if (this.errors.get() != null) {
                        observer.onError(this.errors.terminate());
                        return;
                    } else if (z2) {
                        observer.onComplete();
                        return;
                    }
                }
                SwitchMapInnerObserver<T, R> switchMapInnerObserver = atomicReference.get();
                if (switchMapInnerObserver != null && (simpleQueue = switchMapInnerObserver.queue) != null) {
                    if (switchMapInnerObserver.done) {
                        boolean isEmpty = simpleQueue.isEmpty();
                        if (z) {
                            if (isEmpty) {
                                atomicReference.compareAndSet(switchMapInnerObserver, null);
                            }
                        } else if (this.errors.get() != null) {
                            observer.onError(this.errors.terminate());
                            return;
                        } else if (isEmpty) {
                            atomicReference.compareAndSet(switchMapInnerObserver, null);
                        }
                    }
                    boolean z3 = false;
                    while (!this.cancelled) {
                        if (switchMapInnerObserver == atomicReference.get()) {
                            if (!z && this.errors.get() != null) {
                                observer.onError(this.errors.terminate());
                                return;
                            }
                            boolean z4 = switchMapInnerObserver.done;
                            try {
                                r = simpleQueue.poll();
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.errors.addThrowable(th2);
                                atomicReference.compareAndSet(switchMapInnerObserver, null);
                                if (!z) {
                                    disposeInner();
                                    this.s.dispose();
                                    this.done = true;
                                } else {
                                    switchMapInnerObserver.cancel();
                                }
                                r = (Object) null;
                                z3 = true;
                            }
                            boolean z5 = r == null;
                            if (z4 && z5) {
                                atomicReference.compareAndSet(switchMapInnerObserver, null);
                            } else if (!z5) {
                                observer.onNext(r);
                            } else if (!z3) {
                                continue;
                            }
                        }
                        z3 = true;
                        if (!z3) {
                        }
                    }
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        public void innerError(SwitchMapInnerObserver<T, R> switchMapInnerObserver, Throwable th) {
            if (switchMapInnerObserver.index == this.unique && this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    this.s.dispose();
                }
                switchMapInnerObserver.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.done && this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    disposeInner();
                }
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            SwitchMapInnerObserver<T, R> switchMapInnerObserver;
            long j = this.unique + 1;
            this.unique = j;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.active.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.cancel();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The ObservableSource returned is null");
                SwitchMapInnerObserver<T, R> switchMapInnerObserver3 = new SwitchMapInnerObserver<>(this, j, this.bufferSize);
                do {
                    switchMapInnerObserver = this.active.get();
                    if (switchMapInnerObserver == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(switchMapInnerObserver, switchMapInnerObserver3));
                observableSource.subscribe(switchMapInnerObserver3);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.s.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z) {
        super(observableSource);
        this.mapper = function;
        this.bufferSize = i2;
        this.delayErrors = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe(this.source, observer, this.mapper)) {
            return;
        }
        this.source.subscribe(new SwitchMapObserver(observer, this.mapper, this.bufferSize, this.delayErrors));
    }
}
