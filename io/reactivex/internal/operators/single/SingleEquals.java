package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class SingleEquals<T> extends Single<Boolean> {
    public final SingleSource<? extends T> first;
    public final SingleSource<? extends T> second;

    /* loaded from: classes7.dex */
    public static class InnerObserver<T> implements SingleObserver<T> {
        public final AtomicInteger count;
        public final int index;
        public final SingleObserver<? super Boolean> s;
        public final CompositeDisposable set;
        public final Object[] values;

        public InnerObserver(int i2, CompositeDisposable compositeDisposable, Object[] objArr, SingleObserver<? super Boolean> singleObserver, AtomicInteger atomicInteger) {
            this.index = i2;
            this.set = compositeDisposable;
            this.values = objArr;
            this.s = singleObserver;
            this.count = atomicInteger;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            int i2;
            do {
                i2 = this.count.get();
                if (i2 >= 2) {
                    RxJavaPlugins.onError(th);
                    return;
                }
            } while (!this.count.compareAndSet(i2, 2));
            this.set.dispose();
            this.s.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.values[this.index] = t;
            if (this.count.incrementAndGet() == 2) {
                SingleObserver<? super Boolean> singleObserver = this.s;
                Object[] objArr = this.values;
                singleObserver.onSuccess(Boolean.valueOf(ObjectHelper.equals(objArr[0], objArr[1])));
            }
        }
    }

    public SingleEquals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        this.first = singleSource;
        this.second = singleSource2;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.onSubscribe(compositeDisposable);
        this.first.subscribe(new InnerObserver(0, compositeDisposable, objArr, singleObserver, atomicInteger));
        this.second.subscribe(new InnerObserver(1, compositeDisposable, objArr, singleObserver, atomicInteger));
    }
}
