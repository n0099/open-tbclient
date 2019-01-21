package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import rx.d;
/* loaded from: classes2.dex */
public final class aa<T, K, V> implements d.a<Map<K, Collection<V>>>, rx.functions.e<Map<K, Collection<V>>> {
    private final rx.d<T> iFX;
    private final rx.functions.f<? super T, ? extends K> iIh;
    private final rx.functions.f<? super T, ? extends V> iIi;
    private final rx.functions.e<? extends Map<K, Collection<V>>> iIj;
    private final rx.functions.f<? super K, ? extends Collection<V>> iIk;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public aa(rx.d<T> dVar, rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2) {
        this(dVar, fVar, fVar2, null, a.ceJ());
    }

    public aa(rx.d<T> dVar, rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2, rx.functions.e<? extends Map<K, Collection<V>>> eVar) {
        this(dVar, fVar, fVar2, eVar, a.ceJ());
    }

    public aa(rx.d<T> dVar, rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2, rx.functions.e<? extends Map<K, Collection<V>>> eVar, rx.functions.f<? super K, ? extends Collection<V>> fVar3) {
        this.iFX = dVar;
        this.iIh = fVar;
        this.iIi = fVar2;
        if (eVar == null) {
            this.iIj = this;
        } else {
            this.iIj = eVar;
        }
        this.iIk = fVar3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.e, java.util.concurrent.Callable
    /* renamed from: ceI */
    public Map<K, Collection<V>> call() {
        return new HashMap();
    }

    public void call(rx.j<? super Map<K, Collection<V>>> jVar) {
        try {
            new b(jVar, this.iIj.call(), this.iIh, this.iIi, this.iIk).c(this.iFX);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            jVar.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b<T, K, V> extends c<T, Map<K, Collection<V>>> {
        private final rx.functions.f<? super T, ? extends K> iIh;
        private final rx.functions.f<? super T, ? extends V> iIi;
        private final rx.functions.f<? super K, ? extends Collection<V>> iIk;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<K, java.util.Collection<V>> */
        /* JADX WARN: Multi-variable type inference failed */
        b(rx.j<? super Map<K, Collection<V>>> jVar, Map<K, Collection<V>> map, rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2, rx.functions.f<? super K, ? extends Collection<V>> fVar3) {
            super(jVar);
            this.value = map;
            this.hasValue = true;
            this.iIh = fVar;
            this.iIi = fVar2;
            this.iIk = fVar3;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.done) {
                try {
                    K call = this.iIh.call(t);
                    V call2 = this.iIi.call(t);
                    Collection<V> collection = (Collection) ((Map) this.value).get(call);
                    if (collection == null) {
                        collection = this.iIk.call(call);
                        ((Map) this.value).put(call, collection);
                    }
                    collection.add(call2);
                } catch (Throwable th) {
                    rx.exceptions.a.J(th);
                    unsubscribe();
                    onError(th);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class a<K, V> implements rx.functions.f<K, Collection<V>> {
        private static final a<Object, Object> iIl = new a<>();

        private a() {
        }

        static <K, V> a<K, V> ceJ() {
            return (a<K, V>) iIl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.f
        /* renamed from: be */
        public Collection<V> call(K k) {
            return new ArrayList();
        }
    }
}
