package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
class h<K extends m, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f6743a = new a<>();
    private final Map<K, a<K, V>> b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f6744a;
        a<K, V> b;
        a<K, V> c;
        private List<V> d;

        a() {
            this(null);
        }

        a(K k) {
            this.c = this;
            this.b = this;
            this.f6744a = k;
        }

        @Nullable
        public V a() {
            int b = b();
            if (b > 0) {
                return this.d.remove(b - 1);
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
        aVar.c = this.f6743a;
        aVar.b = this.f6743a.b;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        aVar.c = this.f6743a.c;
        aVar.b = this.f6743a;
        c(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        aVar.b.c = aVar;
        aVar.c.b = aVar;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.c.b = aVar.b;
        aVar.b.c = aVar.c;
    }

    @Nullable
    public V a() {
        a aVar = this.f6743a.c;
        while (true) {
            a aVar2 = aVar;
            if (aVar2.equals(this.f6743a)) {
                return null;
            }
            V v = (V) aVar2.a();
            if (v != null) {
                return v;
            }
            d(aVar2);
            this.b.remove(aVar2.f6744a);
            ((m) aVar2.f6744a).a();
            aVar = aVar2.c;
        }
    }

    @Nullable
    public V a(K k) {
        a<K, V> aVar = this.b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f6743a.b; !aVar.equals(this.f6743a); aVar = aVar.b) {
            z = true;
            sb.append('{').append(aVar.f6744a).append(':').append(aVar.b()).append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.append(" )").toString();
    }
}
