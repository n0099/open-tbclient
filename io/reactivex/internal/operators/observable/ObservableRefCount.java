package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public final class ObservableRefCount<T> extends AbstractObservableWithUpstream<T, T> {
    public volatile CompositeDisposable baseDisposable;
    public final ReentrantLock lock;
    public final ConnectableObservable<? extends T> source;
    public final AtomicInteger subscriptionCount;

    /* loaded from: classes7.dex */
    public final class ConnectionObserver extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        public static final long serialVersionUID = 3813126992133394324L;
        public final CompositeDisposable currentBase;
        public final Disposable resource;
        public final Observer<? super T> subscriber;

        public ConnectionObserver(Observer<? super T> observer, CompositeDisposable compositeDisposable, Disposable disposable) {
            this.subscriber = observer;
            this.currentBase = compositeDisposable;
            this.resource = disposable;
        }

        public void cleanup() {
            ObservableRefCount.this.lock.lock();
            try {
                if (ObservableRefCount.this.baseDisposable == this.currentBase) {
                    if (ObservableRefCount.this.source instanceof Disposable) {
                        ((Disposable) ObservableRefCount.this.source).dispose();
                    }
                    ObservableRefCount.this.baseDisposable.dispose();
                    ObservableRefCount.this.baseDisposable = new CompositeDisposable();
                    ObservableRefCount.this.subscriptionCount.set(0);
                }
            } finally {
                ObservableRefCount.this.lock.unlock();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            this.resource.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    /* loaded from: classes7.dex */
    public final class DisposeConsumer implements Consumer<Disposable> {
        public final Observer<? super T> observer;
        public final AtomicBoolean writeLocked;

        public DisposeConsumer(Observer<? super T> observer, AtomicBoolean atomicBoolean) {
            this.observer = observer;
            this.writeLocked = atomicBoolean;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            try {
                ObservableRefCount.this.baseDisposable.add(disposable);
                ObservableRefCount.this.doSubscribe(this.observer, ObservableRefCount.this.baseDisposable);
            } finally {
                ObservableRefCount.this.lock.unlock();
                this.writeLocked.set(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class DisposeTask implements Runnable {
        public final CompositeDisposable current;

        public DisposeTask(CompositeDisposable compositeDisposable) {
            this.current = compositeDisposable;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableRefCount.this.lock.lock();
            try {
                if (ObservableRefCount.this.baseDisposable == this.current && ObservableRefCount.this.subscriptionCount.decrementAndGet() == 0) {
                    if (ObservableRefCount.this.source instanceof Disposable) {
                        ((Disposable) ObservableRefCount.this.source).dispose();
                    }
                    ObservableRefCount.this.baseDisposable.dispose();
                    ObservableRefCount.this.baseDisposable = new CompositeDisposable();
                }
            } finally {
                ObservableRefCount.this.lock.unlock();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.observables.ConnectableObservable<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        super(connectableObservable);
        this.baseDisposable = new CompositeDisposable();
        this.subscriptionCount = new AtomicInteger();
        this.lock = new ReentrantLock();
        this.source = connectableObservable;
    }

    private Disposable disconnect(CompositeDisposable compositeDisposable) {
        return Disposables.fromRunnable(new DisposeTask(compositeDisposable));
    }

    private Consumer<Disposable> onSubscribe(Observer<? super T> observer, AtomicBoolean atomicBoolean) {
        return new DisposeConsumer(observer, atomicBoolean);
    }

    public void doSubscribe(Observer<? super T> observer, CompositeDisposable compositeDisposable) {
        ConnectionObserver connectionObserver = new ConnectionObserver(observer, compositeDisposable, disconnect(compositeDisposable));
        observer.onSubscribe(connectionObserver);
        this.source.subscribe(connectionObserver);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        boolean z;
        this.lock.lock();
        if (this.subscriptionCount.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.source.connect(onSubscribe(observer, atomicBoolean));
                if (z) {
                    return;
                }
                return;
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
        try {
            doSubscribe(observer, this.baseDisposable);
        } finally {
            this.lock.unlock();
        }
    }
}
