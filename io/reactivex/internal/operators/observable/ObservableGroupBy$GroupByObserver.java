package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import f.a.w.h;
import f.a.x.b.a;
import f.a.x.e.c.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableGroupBy$GroupByObserver<T, K, V> extends AtomicInteger implements o<T>, b {
    public static final Object NULL_KEY = new Object();
    public static final long serialVersionUID = -3688291656102519502L;
    public final o<? super f.a.y.b<K, V>> actual;
    public final int bufferSize;
    public final boolean delayError;
    public final h<? super T, ? extends K> keySelector;
    public b s;
    public final h<? super T, ? extends V> valueSelector;
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final Map<Object, e<K, V>> groups = new ConcurrentHashMap();

    public ObservableGroupBy$GroupByObserver(o<? super f.a.y.b<K, V>> oVar, h<? super T, ? extends K> hVar, h<? super T, ? extends V> hVar2, int i, boolean z) {
        this.actual = oVar;
        this.keySelector = hVar;
        this.valueSelector = hVar2;
        this.bufferSize = i;
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

    @Override // f.a.t.b
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
            this.s.dispose();
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.cancelled.get();
    }

    @Override // f.a.o
    public void onComplete() {
        ArrayList<e> arrayList = new ArrayList(this.groups.values());
        this.groups.clear();
        for (e eVar : arrayList) {
            eVar.onComplete();
        }
        this.actual.onComplete();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        ArrayList<e> arrayList = new ArrayList(this.groups.values());
        this.groups.clear();
        for (e eVar : arrayList) {
            eVar.onError(th);
        }
        this.actual.onError(th);
    }

    @Override // f.a.o
    public void onNext(T t) {
        try {
            K apply = this.keySelector.apply(t);
            Object obj = apply != null ? apply : NULL_KEY;
            e eVar = this.groups.get(obj);
            if (eVar == null) {
                if (this.cancelled.get()) {
                    return;
                }
                eVar = e.c(apply, this.bufferSize, this, this.delayError);
                this.groups.put(obj, eVar);
                getAndIncrement();
                this.actual.onNext(eVar);
            }
            try {
                V apply2 = this.valueSelector.apply(t);
                a.b(apply2, "The value supplied is null");
                eVar.onNext(apply2);
            } catch (Throwable th) {
                f.a.u.a.a(th);
                this.s.dispose();
                onError(th);
            }
        } catch (Throwable th2) {
            f.a.u.a.a(th2);
            this.s.dispose();
            onError(th2);
        }
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
