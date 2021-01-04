package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
class h<K extends m, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f10491a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f10492b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f10493a;

        /* renamed from: b  reason: collision with root package name */
        a<K, V> f10494b;
        a<K, V> c;
        private List<V> d;

        a() {
            this(null);
        }

        a(K k) {
            this.c = this;
            this.f10494b = this;
            this.f10493a = k;
        }

        @Nullable
        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.d.remove(b2 - 1);
            }
            return null;
        }

        public void a(V v) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(v);
        }

        public int b() {
            if (this.d != null) {
                return this.d.size();
            }
            return 0;
        }
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        aVar.c = this.f10491a;
        aVar.f10494b = this.f10491a.f10494b;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        aVar.c = this.f10491a.c;
        aVar.f10494b = this.f10491a;
        c(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        aVar.f10494b.c = aVar;
        aVar.c.f10494b = aVar;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.c.f10494b = aVar.f10494b;
        aVar.f10494b.c = aVar.c;
    }

    @Nullable
    public V a() {
        a aVar = this.f10491a.c;
        while (true) {
            a aVar2 = aVar;
            if (aVar2.equals(this.f10491a)) {
                return null;
            }
            V v = (V) aVar2.a();
            if (v != null) {
                return v;
            }
            d(aVar2);
            this.f10492b.remove(aVar2.f10493a);
            ((m) aVar2.f10493a).a();
            aVar = aVar2.c;
        }
    }

    @Nullable
    public V a(K k) {
        a<K, V> aVar = this.f10492b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f10492b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.f10492b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.f10492b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f10491a.f10494b; !aVar.equals(this.f10491a); aVar = aVar.f10494b) {
            z = true;
            sb.append('{').append(aVar.f10493a).append(':').append(aVar.b()).append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.append(" )").toString();
    }
}
