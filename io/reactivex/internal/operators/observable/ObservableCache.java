package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> {
    public final AtomicBoolean once;
    public final CacheState<T> state;

    /* loaded from: classes7.dex */
    public static final class CacheState<T> extends LinkedArrayList implements Observer<T> {
        public static final ReplayDisposable[] EMPTY = new ReplayDisposable[0];
        public static final ReplayDisposable[] TERMINATED = new ReplayDisposable[0];
        public final SequentialDisposable connection;
        public volatile boolean isConnected;
        public final AtomicReference<ReplayDisposable<T>[]> observers;
        public final Observable<? extends T> source;
        public boolean sourceDone;

        public CacheState(Observable<? extends T> observable, int i2) {
            super(i2);
            this.source = observable;
            this.observers = new AtomicReference<>(EMPTY);
            this.connection = new SequentialDisposable();
        }

        public boolean addChild(ReplayDisposable<T> replayDisposable) {
            ReplayDisposable<T>[] replayDisposableArr;
            ReplayDisposable<T>[] replayDisposableArr2;
            do {
                replayDisposableArr = this.observers.get();
                if (replayDisposableArr == TERMINATED) {
                    return false;
                }
                int length = replayDisposableArr.length;
                replayDisposableArr2 = new ReplayDisposable[length + 1];
                System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
                replayDisposableArr2[length] = replayDisposable;
            } while (!this.observers.compareAndSet(replayDisposableArr, replayDisposableArr2));
            return true;
        }

        public void connect() {
            this.source.subscribe(this);
            this.isConnected = true;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.sourceDone) {
                return;
            }
            this.sourceDone = true;
            add(NotificationLite.complete());
            this.connection.dispose();
            for (ReplayDisposable<T> replayDisposable : this.observers.getAndSet(TERMINATED)) {
                replayDisposable.replay();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.sourceDone) {
                return;
            }
            this.sourceDone = true;
            add(NotificationLite.error(th));
            this.connection.dispose();
            for (ReplayDisposable<T> replayDisposable : this.observers.getAndSet(TERMINATED)) {
                replayDisposable.replay();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.sourceDone) {
                return;
            }
            add(NotificationLite.next(t));
            for (ReplayDisposable<T> replayDisposable : this.observers.get()) {
                replayDisposable.replay();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.connection.update(disposable);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableCache$ReplayDisposable<T>[]> */
        /* JADX WARN: Multi-variable type inference failed */
        public void removeChild(ReplayDisposable<T> replayDisposable) {
            ReplayDisposable<T>[] replayDisposableArr;
            ReplayDisposable[] replayDisposableArr2;
            do {
                replayDisposableArr = this.observers.get();
                int length = replayDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (replayDisposableArr[i3].equals(replayDisposable)) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    replayDisposableArr2 = EMPTY;
                } else {
                    ReplayDisposable[] replayDisposableArr3 = new ReplayDisposable[length - 1];
                    System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i2);
                    System.arraycopy(replayDisposableArr, i2 + 1, replayDisposableArr3, i2, (length - i2) - 1);
                    replayDisposableArr2 = replayDisposableArr3;
                }
            } while (!this.observers.compareAndSet(replayDisposableArr, replayDisposableArr2));
        }
    }

    /* loaded from: classes7.dex */
    public static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        public static final long serialVersionUID = 7058506693698832024L;
        public volatile boolean cancelled;
        public final Observer<? super T> child;
        public Object[] currentBuffer;
        public int currentIndexInBuffer;
        public int index;
        public final CacheState<T> state;

        public ReplayDisposable(Observer<? super T> observer, CacheState<T> cacheState) {
            this.child = observer;
            this.state = cacheState;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.removeChild(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void replay() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super T> observer = this.child;
            int i2 = 1;
            while (!this.cancelled) {
                int size = this.state.size();
                if (size != 0) {
                    Object[] objArr = this.currentBuffer;
                    if (objArr == null) {
                        objArr = this.state.head();
                        this.currentBuffer = objArr;
                    }
                    int length = objArr.length - 1;
                    int i3 = this.index;
                    int i4 = this.currentIndexInBuffer;
                    while (i3 < size) {
                        if (this.cancelled) {
                            return;
                        }
                        if (i4 == length) {
                            objArr = (Object[]) objArr[length];
                            i4 = 0;
                        }
                        if (NotificationLite.accept(objArr[i4], observer)) {
                            return;
                        }
                        i4++;
                        i3++;
                    }
                    if (this.cancelled) {
                        return;
                    }
                    this.index = i3;
                    this.currentIndexInBuffer = i4;
                    this.currentBuffer = objArr;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }
    }

    public ObservableCache(Observable<T> observable, CacheState<T> cacheState) {
        super(observable);
        this.state = cacheState;
        this.once = new AtomicBoolean();
    }

    public static <T> Observable<T> from(Observable<T> observable) {
        return from(observable, 16);
    }

    public int cachedEventCount() {
        return this.state.size();
    }

    public boolean hasObservers() {
        return this.state.observers.get().length != 0;
    }

    public boolean isConnected() {
        return this.state.isConnected;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        ReplayDisposable<T> replayDisposable = new ReplayDisposable<>(observer, this.state);
        observer.onSubscribe(replayDisposable);
        this.state.addChild(replayDisposable);
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            this.state.connect();
        }
        replayDisposable.replay();
    }

    public static <T> Observable<T> from(Observable<T> observable, int i2) {
        ObjectHelper.verifyPositive(i2, "capacityHint");
        return RxJavaPlugins.onAssembly(new ObservableCache(observable, new CacheState(observable, i2)));
    }
}
