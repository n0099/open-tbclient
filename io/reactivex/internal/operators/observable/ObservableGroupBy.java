package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {
    public final int bufferSize;
    public final boolean delayError;
    public final Function<? super T, ? extends K> keySelector;
    public final Function<? super T, ? extends V> valueSelector;

    /* loaded from: classes7.dex */
    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        public static final Object NULL_KEY = new Object();
        public static final long serialVersionUID = -3688291656102519502L;
        public final Observer<? super GroupedObservable<K, V>> actual;
        public final int bufferSize;
        public final boolean delayError;
        public final Function<? super T, ? extends K> keySelector;
        public Disposable s;
        public final Function<? super T, ? extends V> valueSelector;
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final Map<Object, GroupedUnicast<K, V>> groups = new ConcurrentHashMap();

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z) {
            this.actual = observer;
            this.keySelector = function;
            this.valueSelector = function2;
            this.bufferSize = i2;
            this.delayError = z;
            lazySet(1);
        }

        public void cancel(K k) {
            if (k == null) {
                k = (K) NULL_KEY;
            }
            this.groups.remove(k);
            if (decrementAndGet() == 0) {
                this.s.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.s.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayList<GroupedUnicast> arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            for (GroupedUnicast groupedUnicast : arrayList) {
                groupedUnicast.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            ArrayList<GroupedUnicast> arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            for (GroupedUnicast groupedUnicast : arrayList) {
                groupedUnicast.onError(th);
            }
            this.actual.onError(th);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: io.reactivex.internal.operators.observable.ObservableGroupBy$GroupedUnicast */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T t) {
            try {
                K apply = this.keySelector.apply(t);
                Object obj = apply != null ? apply : NULL_KEY;
                GroupedUnicast<K, V> groupedUnicast = this.groups.get(obj);
                if (groupedUnicast == null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    groupedUnicast = GroupedUnicast.createWith(apply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, groupedUnicast);
                    getAndIncrement();
                    this.actual.onNext(groupedUnicast);
                }
                try {
                    groupedUnicast.onNext(ObjectHelper.requireNonNull(this.valueSelector.apply(t), "The value supplied is null"));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.s.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.s.dispose();
                onError(th2);
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

    /* loaded from: classes7.dex */
    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        public final State<T, K> state;

        public GroupedUnicast(K k, State<T, K> state) {
            super(k);
            this.state = state;
        }

        public static <T, K> GroupedUnicast<K, T> createWith(K k, int i2, GroupByObserver<?, K, T> groupByObserver, boolean z) {
            return new GroupedUnicast<>(k, new State(i2, groupByObserver, k, z));
        }

        public void onComplete() {
            this.state.onComplete();
        }

        public void onError(Throwable th) {
            this.state.onError(th);
        }

        public void onNext(T t) {
            this.state.onNext(t);
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super T> observer) {
            this.state.subscribe(observer);
        }
    }

    /* loaded from: classes7.dex */
    public static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        public static final long serialVersionUID = -3852313036005250360L;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final K key;
        public final GroupByObserver<?, K, T> parent;
        public final SpscLinkedArrayQueue<T> queue;
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final AtomicBoolean once = new AtomicBoolean();
        public final AtomicReference<Observer<? super T>> actual = new AtomicReference<>();

        public State(int i2, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.queue = new SpscLinkedArrayQueue<>(i2);
            this.parent = groupByObserver;
            this.key = k;
            this.delayError = z;
        }

        public boolean checkTerminated(boolean z, boolean z2, Observer<? super T> observer, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                this.actual.lazySet(null);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error;
                        this.actual.lazySet(null);
                        if (th != null) {
                            observer.onError(th);
                        } else {
                            observer.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    this.actual.lazySet(null);
                    observer.onError(th2);
                    return true;
                } else if (z2) {
                    this.actual.lazySet(null);
                    observer.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.cancel(this.key);
            }
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            boolean z = this.delayError;
            Observer<? super T> observer = this.actual.get();
            int i2 = 1;
            while (true) {
                if (observer != null) {
                    while (true) {
                        boolean z2 = this.done;
                        Object obj = (T) spscLinkedArrayQueue.poll();
                        boolean z3 = obj == null;
                        if (checkTerminated(z2, z3, observer, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        observer.onNext(obj);
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
                if (observer == null) {
                    observer = this.actual.get();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            if (this.once.compareAndSet(false, true)) {
                observer.onSubscribe(this);
                this.actual.lazySet(observer);
                if (this.cancelled.get()) {
                    this.actual.lazySet(null);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), observer);
        }
    }

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z) {
        super(observableSource);
        this.keySelector = function;
        this.valueSelector = function2;
        this.bufferSize = i2;
        this.delayError = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.source.subscribe(new GroupByObserver(observer, this.keySelector, this.valueSelector, this.bufferSize, this.delayError));
    }
}
