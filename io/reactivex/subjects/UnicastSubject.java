package io.reactivex.subjects;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class UnicastSubject<T> extends Subject<T> {
    public final AtomicReference<Observer<? super T>> actual;
    public final boolean delayError;
    public volatile boolean disposed;
    public volatile boolean done;
    public boolean enableOperatorFusion;
    public Throwable error;
    public final AtomicReference<Runnable> onTerminate;
    public final AtomicBoolean once;
    public final SpscLinkedArrayQueue<T> queue;
    public final BasicIntQueueDisposable<T> wip;

    /* loaded from: classes7.dex */
    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        public static final long serialVersionUID = 7926949470189395511L;

        public UnicastQueueDisposable() {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastSubject.this.queue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (UnicastSubject.this.disposed) {
                return;
            }
            UnicastSubject.this.disposed = true;
            UnicastSubject.this.doTerminate();
            UnicastSubject.this.actual.lazySet(null);
            if (UnicastSubject.this.wip.getAndIncrement() == 0) {
                UnicastSubject.this.actual.lazySet(null);
                UnicastSubject.this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return UnicastSubject.this.disposed;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastSubject.this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            return UnicastSubject.this.queue.poll();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            if ((i2 & 2) != 0) {
                UnicastSubject.this.enableOperatorFusion = true;
                return 2;
            }
            return 0;
        }
    }

    public UnicastSubject(int i2, boolean z) {
        this.queue = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i2, "capacityHint"));
        this.onTerminate = new AtomicReference<>();
        this.delayError = z;
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueDisposable();
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create() {
        return new UnicastSubject<>(Observable.bufferSize(), true);
    }

    public void doTerminate() {
        Runnable runnable = this.onTerminate.get();
        if (runnable == null || !this.onTerminate.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    public void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        Observer<? super T> observer = this.actual.get();
        int i2 = 1;
        while (observer == null) {
            i2 = this.wip.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
            observer = this.actual.get();
        }
        if (this.enableOperatorFusion) {
            drainFused(observer);
        } else {
            drainNormal(observer);
        }
    }

    public void drainFused(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        int i2 = 1;
        boolean z = !this.delayError;
        while (!this.disposed) {
            boolean z2 = this.done;
            if (z && z2 && failedFast(spscLinkedArrayQueue, observer)) {
                return;
            }
            observer.onNext(null);
            if (z2) {
                errorOrComplete(observer);
                return;
            }
            i2 = this.wip.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
        }
        this.actual.lazySet(null);
        spscLinkedArrayQueue.clear();
    }

    public void drainNormal(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        boolean z = !this.delayError;
        boolean z2 = true;
        int i2 = 1;
        while (!this.disposed) {
            boolean z3 = this.done;
            Object obj = (T) this.queue.poll();
            boolean z4 = obj == null;
            if (z3) {
                if (z && z2) {
                    if (failedFast(spscLinkedArrayQueue, observer)) {
                        return;
                    }
                    z2 = false;
                }
                if (z4) {
                    errorOrComplete(observer);
                    return;
                }
            }
            if (z4) {
                i2 = this.wip.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                observer.onNext(obj);
            }
        }
        this.actual.lazySet(null);
        spscLinkedArrayQueue.clear();
    }

    public void errorOrComplete(Observer<? super T> observer) {
        this.actual.lazySet(null);
        Throwable th = this.error;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    public boolean failedFast(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th = this.error;
        if (th != null) {
            this.actual.lazySet(null);
            simpleQueue.clear();
            observer.onError(th);
            return true;
        }
        return false;
    }

    @Override // io.reactivex.subjects.Subject
    @Nullable
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.actual.get() != null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return this.done && this.error != null;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done || this.disposed) {
            return;
        }
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.done && !this.disposed) {
            this.error = th;
            this.done = true;
            doTerminate();
            drain();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done || this.disposed) {
            return;
        }
        this.queue.offer(t);
        drain();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.done || this.disposed) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            observer.onSubscribe(this.wip);
            this.actual.lazySet(observer);
            if (this.disposed) {
                this.actual.lazySet(null);
                return;
            } else {
                drain();
                return;
            }
        }
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), observer);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int i2) {
        return new UnicastSubject<>(i2, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int i2, Runnable runnable) {
        return new UnicastSubject<>(i2, runnable, true);
    }

    @CheckReturnValue
    @Experimental
    public static <T> UnicastSubject<T> create(int i2, Runnable runnable, boolean z) {
        return new UnicastSubject<>(i2, runnable, z);
    }

    @CheckReturnValue
    @Experimental
    public static <T> UnicastSubject<T> create(boolean z) {
        return new UnicastSubject<>(Observable.bufferSize(), z);
    }

    public UnicastSubject(int i2, Runnable runnable) {
        this(i2, runnable, true);
    }

    public UnicastSubject(int i2, Runnable runnable, boolean z) {
        this.queue = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i2, "capacityHint"));
        this.onTerminate = new AtomicReference<>(ObjectHelper.requireNonNull(runnable, "onTerminate"));
        this.delayError = z;
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueDisposable();
    }
}
