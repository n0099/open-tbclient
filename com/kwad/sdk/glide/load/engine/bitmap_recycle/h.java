package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class h<K extends m, V> {

    /* renamed from: a  reason: collision with root package name */
    public final a<K, V> f36263a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    public final Map<K, a<K, V>> f36264b = new HashMap();

    /* loaded from: classes7.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final K f36265a;

        /* renamed from: b  reason: collision with root package name */
        public a<K, V> f36266b;

        /* renamed from: c  reason: collision with root package name */
        public a<K, V> f36267c;

        /* renamed from: d  reason: collision with root package name */
        public List<V> f36268d;

        public a() {
            this(null);
        }

        public a(K k) {
            this.f36267c = this;
            this.f36266b = this;
            this.f36265a = k;
        }

        @Nullable
        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f36268d.remove(b2 - 1);
            }
            return null;
        }

        public void a(V v) {
            if (this.f36268d == null) {
                this.f36268d = new ArrayList();
            }
            this.f36268d.add(v);
        }

        public int b() {
            List<V> list = this.f36268d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        a<K, V> aVar2 = this.f36263a;
        aVar.f36267c = aVar2;
        aVar.f36266b = aVar2.f36266b;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        a<K, V> aVar2 = this.f36263a;
        aVar.f36267c = aVar2.f36267c;
        aVar.f36266b = aVar2;
        c(aVar);
    }

    public static <K, V> void c(a<K, V> aVar) {
        aVar.f36266b.f36267c = aVar;
        aVar.f36267c.f36266b = aVar;
    }

    public static <K, V> void d(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f36267c;
        aVar2.f36266b = aVar.f36266b;
        aVar.f36266b.f36267c = aVar2;
    }

    @Nullable
    public V a() {
        a aVar = this.f36263a;
        while (true) {
            aVar = aVar.f36267c;
            if (aVar.equals(this.f36263a)) {
                return null;
            }
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            d(aVar);
            this.f36264b.remove(aVar.f36265a);
            ((m) aVar.f36265a).a();
        }
    }

    @Nullable
    public V a(K k) {
        a<K, V> aVar = this.f36264b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f36264b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.f36264b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.f36264b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f36263a.f36266b; !aVar.equals(this.f36263a); aVar = aVar.f36266b) {
            z = true;
            sb.append('{');
            sb.append(aVar.f36265a);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
