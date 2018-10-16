package rx.internal.operators;

import java.util.HashMap;
import java.util.Map;
import rx.d;
/* loaded from: classes2.dex */
public final class z<T, K, V> implements d.a<Map<K, V>>, rx.functions.e<Map<K, V>> {
    final rx.d<T> isL;
    final rx.functions.f<? super T, ? extends K> iuV;
    final rx.functions.f<? super T, ? extends V> iuW;
    final rx.functions.e<? extends Map<K, V>> iuX;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public z(rx.d<T> dVar, rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2) {
        this(dVar, fVar, fVar2, null);
    }

    public z(rx.d<T> dVar, rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2, rx.functions.e<? extends Map<K, V>> eVar) {
        this.isL = dVar;
        this.iuV = fVar;
        this.iuW = fVar2;
        if (eVar == null) {
            this.iuX = this;
        } else {
            this.iuX = eVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.e, java.util.concurrent.Callable
    /* renamed from: cbK */
    public Map<K, V> call() {
        return new HashMap();
    }

    public void call(rx.j<? super Map<K, V>> jVar) {
        try {
            new a(jVar, this.iuX.call(), this.iuV, this.iuW).c(this.isL);
        } catch (Throwable th) {
            rx.exceptions.a.a(th, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, K, V> extends c<T, Map<K, V>> {
        final rx.functions.f<? super T, ? extends K> iuV;
        final rx.functions.f<? super T, ? extends V> iuW;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        a(rx.j<? super Map<K, V>> jVar, Map<K, V> map, rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2) {
            super(jVar);
            this.value = map;
            this.hasValue = true;
            this.iuV = fVar;
            this.iuW = fVar2;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.done) {
                try {
                    ((Map) this.value).put(this.iuV.call(t), this.iuW.call(t));
                } catch (Throwable th) {
                    rx.exceptions.a.J(th);
                    unsubscribe();
                    onError(th);
                }
            }
        }
    }
}
