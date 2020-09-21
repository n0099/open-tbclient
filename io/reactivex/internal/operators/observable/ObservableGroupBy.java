package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.t;
import io.reactivex.u;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes25.dex */
public final class ObservableGroupBy<T, K, V> extends io.reactivex.internal.operators.observable.a<T, io.reactivex.d.b<K, V>> {
    final int bufferSize;
    final boolean delayError;
    final h<? super T, ? extends K> keySelector;
    final h<? super T, ? extends V> valueSelector;

    @Override // io.reactivex.q
    public void a(u<? super io.reactivex.d.b<K, V>> uVar) {
        this.source.subscribe(new GroupByObserver(uVar, this.keySelector, this.valueSelector, this.bufferSize, this.delayError));
    }

    /* loaded from: classes25.dex */
    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements io.reactivex.disposables.b, u<T> {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final u<? super io.reactivex.d.b<K, V>> actual;
        final int bufferSize;
        final boolean delayError;
        final h<? super T, ? extends K> keySelector;
        io.reactivex.disposables.b s;
        final h<? super T, ? extends V> valueSelector;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final Map<Object, a<K, V>> groups = new ConcurrentHashMap();

        public GroupByObserver(u<? super io.reactivex.d.b<K, V>> uVar, h<? super T, ? extends K> hVar, h<? super T, ? extends V> hVar2, int i, boolean z) {
            this.actual = uVar;
            this.keySelector = hVar;
            this.valueSelector = hVar2;
            this.bufferSize = i;
            this.delayError = z;
            lazySet(1);
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: io.reactivex.internal.operators.observable.ObservableGroupBy$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.u
        public void onNext(T t) {
            try {
                Object apply = this.keySelector.apply(t);
                Object obj = apply != null ? apply : NULL_KEY;
                a<K, V> aVar = this.groups.get(obj);
                if (aVar == null) {
                    if (!this.cancelled.get()) {
                        aVar = a.a(apply, this.bufferSize, (GroupByObserver<?, Object, T>) this, this.delayError);
                        this.groups.put(obj, aVar);
                        getAndIncrement();
                        this.actual.onNext(aVar);
                    } else {
                        return;
                    }
                }
                try {
                    aVar.onNext(io.reactivex.internal.functions.a.k(this.valueSelector.apply(t), "The value supplied is null"));
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.J(th);
                    this.s.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.J(th2);
                this.s.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            ArrayList<a> arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            for (a aVar : arrayList) {
                aVar.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            ArrayList<a> arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            for (a aVar : arrayList) {
                aVar.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.s.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled.get();
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static final class a<K, T> extends io.reactivex.d.b<K, T> {
        final State<T, K> oyh;

        public static <T, K> a<K, T> a(K k, int i, GroupByObserver<?, K, T> groupByObserver, boolean z) {
            return new a<>(k, new State(i, groupByObserver, k, z));
        }

        protected a(K k, State<T, K> state) {
            super(k);
            this.oyh = state;
        }

        @Override // io.reactivex.q
        protected void a(u<? super T> uVar) {
            this.oyh.subscribe(uVar);
        }

        public void onNext(T t) {
            this.oyh.onNext(t);
        }

        public void onError(Throwable th) {
            this.oyh.onError(th);
        }

        public void onComplete() {
            this.oyh.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static final class State<T, K> extends AtomicInteger implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final GroupByObserver<?, K, T> parent;
        final io.reactivex.internal.queue.a<T> queue;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicBoolean once = new AtomicBoolean();
        final AtomicReference<u<? super T>> actual = new AtomicReference<>();

        State(int i, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.parent = groupByObserver;
            this.key = k;
            this.delayError = z;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.cancel(this.key);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // io.reactivex.t
        public void subscribe(u<? super T> uVar) {
            if (this.once.compareAndSet(false, true)) {
                uVar.onSubscribe(this);
                this.actual.lazySet(uVar);
                if (this.cancelled.get()) {
                    this.actual.lazySet(null);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), uVar);
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                io.reactivex.internal.queue.a<T> aVar = this.queue;
                boolean z = this.delayError;
                u<? super T> uVar = this.actual.get();
                int i = 1;
                while (true) {
                    if (uVar != null) {
                        while (true) {
                            boolean z2 = this.done;
                            Object obj = (T) aVar.poll();
                            boolean z3 = obj == null;
                            if (!checkTerminated(z2, z3, uVar, z)) {
                                if (z3) {
                                    break;
                                }
                                uVar.onNext(obj);
                            } else {
                                return;
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i != 0) {
                        if (uVar == null) {
                            uVar = this.actual.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, u<? super T> uVar, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                this.actual.lazySet(null);
                return true;
            }
            if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error;
                        this.actual.lazySet(null);
                        if (th != null) {
                            uVar.onError(th);
                            return true;
                        }
                        uVar.onComplete();
                        return true;
                    }
                } else {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.queue.clear();
                        this.actual.lazySet(null);
                        uVar.onError(th2);
                        return true;
                    } else if (z2) {
                        this.actual.lazySet(null);
                        uVar.onComplete();
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
