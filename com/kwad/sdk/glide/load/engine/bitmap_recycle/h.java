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
    private final a<K, V> f10194a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f10195b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f10196a;

        /* renamed from: b  reason: collision with root package name */
        a<K, V> f10197b;
        a<K, V> c;
        private List<V> d;

        a() {
            this(null);
        }

        a(K k) {
            this.c = this;
            this.f10197b = this;
            this.f10196a = k;
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
        aVar.c = this.f10194a;
        aVar.f10197b = this.f10194a.f10197b;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        aVar.c = this.f10194a.c;
        aVar.f10197b = this.f10194a;
        c(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        aVar.f10197b.c = aVar;
        aVar.c.f10197b = aVar;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.c.f10197b = aVar.f10197b;
        aVar.f10197b.c = aVar.c;
    }

    @Nullable
    public V a() {
        a aVar = this.f10194a.c;
        while (true) {
            a aVar2 = aVar;
            if (aVar2.equals(this.f10194a)) {
                return null;
            }
            V v = (V) aVar2.a();
            if (v != null) {
                return v;
            }
            d(aVar2);
            this.f10195b.remove(aVar2.f10196a);
            ((m) aVar2.f10196a).a();
            aVar = aVar2.c;
        }
    }

    @Nullable
    public V a(K k) {
        a<K, V> aVar = this.f10195b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f10195b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.f10195b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.f10195b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f10194a.f10197b; !aVar.equals(this.f10194a); aVar = aVar.f10197b) {
            z = true;
            sb.append('{').append(aVar.f10196a).append(':').append(aVar.b()).append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.append(" )").toString();
    }
}
