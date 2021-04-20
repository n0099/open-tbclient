package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class h<K extends m, V> {

    /* renamed from: a  reason: collision with root package name */
    public final a<K, V> f35768a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    public final Map<K, a<K, V>> f35769b = new HashMap();

    /* loaded from: classes6.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final K f35770a;

        /* renamed from: b  reason: collision with root package name */
        public a<K, V> f35771b;

        /* renamed from: c  reason: collision with root package name */
        public a<K, V> f35772c;

        /* renamed from: d  reason: collision with root package name */
        public List<V> f35773d;

        public a() {
            this(null);
        }

        public a(K k) {
            this.f35772c = this;
            this.f35771b = this;
            this.f35770a = k;
        }

        @Nullable
        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f35773d.remove(b2 - 1);
            }
            return null;
        }

        public void a(V v) {
            if (this.f35773d == null) {
                this.f35773d = new ArrayList();
            }
            this.f35773d.add(v);
        }

        public int b() {
            List<V> list = this.f35773d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        a<K, V> aVar2 = this.f35768a;
        aVar.f35772c = aVar2;
        aVar.f35771b = aVar2.f35771b;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        a<K, V> aVar2 = this.f35768a;
        aVar.f35772c = aVar2.f35772c;
        aVar.f35771b = aVar2;
        c(aVar);
    }

    public static <K, V> void c(a<K, V> aVar) {
        aVar.f35771b.f35772c = aVar;
        aVar.f35772c.f35771b = aVar;
    }

    public static <K, V> void d(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f35772c;
        aVar2.f35771b = aVar.f35771b;
        aVar.f35771b.f35772c = aVar2;
    }

    @Nullable
    public V a() {
        a aVar = this.f35768a;
        while (true) {
            aVar = aVar.f35772c;
            if (aVar.equals(this.f35768a)) {
                return null;
            }
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            d(aVar);
            this.f35769b.remove(aVar.f35770a);
            ((m) aVar.f35770a).a();
        }
    }

    @Nullable
    public V a(K k) {
        a<K, V> aVar = this.f35769b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f35769b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.f35769b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.f35769b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f35768a.f35771b; !aVar.equals(this.f35768a); aVar = aVar.f35771b) {
            z = true;
            sb.append('{');
            sb.append(aVar.f35770a);
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
