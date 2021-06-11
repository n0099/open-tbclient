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
    public final a<K, V> f36165a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    public final Map<K, a<K, V>> f36166b = new HashMap();

    /* loaded from: classes7.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final K f36167a;

        /* renamed from: b  reason: collision with root package name */
        public a<K, V> f36168b;

        /* renamed from: c  reason: collision with root package name */
        public a<K, V> f36169c;

        /* renamed from: d  reason: collision with root package name */
        public List<V> f36170d;

        public a() {
            this(null);
        }

        public a(K k) {
            this.f36169c = this;
            this.f36168b = this;
            this.f36167a = k;
        }

        @Nullable
        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f36170d.remove(b2 - 1);
            }
            return null;
        }

        public void a(V v) {
            if (this.f36170d == null) {
                this.f36170d = new ArrayList();
            }
            this.f36170d.add(v);
        }

        public int b() {
            List<V> list = this.f36170d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        a<K, V> aVar2 = this.f36165a;
        aVar.f36169c = aVar2;
        aVar.f36168b = aVar2.f36168b;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        a<K, V> aVar2 = this.f36165a;
        aVar.f36169c = aVar2.f36169c;
        aVar.f36168b = aVar2;
        c(aVar);
    }

    public static <K, V> void c(a<K, V> aVar) {
        aVar.f36168b.f36169c = aVar;
        aVar.f36169c.f36168b = aVar;
    }

    public static <K, V> void d(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f36169c;
        aVar2.f36168b = aVar.f36168b;
        aVar.f36168b.f36169c = aVar2;
    }

    @Nullable
    public V a() {
        a aVar = this.f36165a;
        while (true) {
            aVar = aVar.f36169c;
            if (aVar.equals(this.f36165a)) {
                return null;
            }
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            d(aVar);
            this.f36166b.remove(aVar.f36167a);
            ((m) aVar.f36167a).a();
        }
    }

    @Nullable
    public V a(K k) {
        a<K, V> aVar = this.f36166b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f36166b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.f36166b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.f36166b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f36165a.f36168b; !aVar.equals(this.f36165a); aVar = aVar.f36168b) {
            z = true;
            sb.append('{');
            sb.append(aVar.f36167a);
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
