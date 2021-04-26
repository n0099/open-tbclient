package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;
/* loaded from: classes7.dex */
public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {
    public final BiPredicate<? super K, ? super K> comparer;
    public final Function<? super T, K> keySelector;

    /* loaded from: classes7.dex */
    public static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {
        public final BiPredicate<? super K, ? super K> comparer;
        public boolean hasValue;
        public final Function<? super T, K> keySelector;
        public K last;

        public DistinctUntilChangedObserver(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.keySelector = function;
            this.comparer = biPredicate;
        }

        /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: K, ? super K */
        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0) {
                this.actual.onNext(t);
                return;
            }
            try {
                K apply = this.keySelector.apply(t);
                if (this.hasValue) {
                    boolean test = this.comparer.test((K) this.last, apply);
                    this.last = apply;
                    if (test) {
                        return;
                    }
                } else {
                    this.hasValue = true;
                    this.last = apply;
                }
                this.actual.onNext(t);
            } catch (Throwable th) {
                fail(th);
            }
        }

        /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: K, ? super K */
        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            while (true) {
                T poll = this.qs.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.keySelector.apply(poll);
                if (!this.hasValue) {
                    this.hasValue = true;
                    this.last = apply;
                    return poll;
                } else if (!this.comparer.test((K) this.last, apply)) {
                    this.last = apply;
                    return poll;
                } else {
                    this.last = apply;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            return transitiveBoundaryFusion(i2);
        }
    }

    public ObservableDistinctUntilChanged(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.keySelector = function;
        this.comparer = biPredicate;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DistinctUntilChangedObserver(observer, this.keySelector, this.comparer));
    }
}
