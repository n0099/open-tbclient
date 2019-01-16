package rx.internal.operators;

import java.util.HashMap;
import java.util.Map;
import rx.d;
/* loaded from: classes2.dex */
public final class z<T, K, V> implements d.a<Map<K, V>>, rx.functions.e<Map<K, V>> {
    final rx.d<T> iFW;
    final rx.functions.f<? super T, ? extends K> iIg;
    final rx.functions.f<? super T, ? extends V> iIh;
    final rx.functions.e<? extends Map<K, V>> iIi;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public z(rx.d<T> dVar, rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2) {
        this(dVar, fVar, fVar2, null);
    }

    public z(rx.d<T> dVar, rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2, rx.functions.e<? extends Map<K, V>> eVar) {
        this.iFW = dVar;
        this.iIg = fVar;
        this.iIh = fVar2;
        if (eVar == null) {
            this.iIi = this;
        } else {
            this.iIi = eVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.e, java.util.concurrent.Callable
    /* renamed from: ceI */
    public Map<K, V> call() {
        return new HashMap();
    }

    public void call(rx.j<? super Map<K, V>> jVar) {
        try {
            new a(jVar, this.iIi.call(), this.iIg, this.iIh).c(this.iFW);
        } catch (Throwable th) {
            rx.exceptions.a.a(th, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, K, V> extends c<T, Map<K, V>> {
        final rx.functions.f<? super T, ? extends K> iIg;
        final rx.functions.f<? super T, ? extends V> iIh;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        a(rx.j<? super Map<K, V>> jVar, Map<K, V> map, rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2) {
            super(jVar);
            this.value = map;
            this.hasValue = true;
            this.iIg = fVar;
            this.iIh = fVar2;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.done) {
                try {
                    ((Map) this.value).put(this.iIg.call(t), this.iIh.call(t));
                } catch (Throwable th) {
                    rx.exceptions.a.J(th);
                    unsubscribe();
                    onError(th);
                }
            }
        }
    }
}
