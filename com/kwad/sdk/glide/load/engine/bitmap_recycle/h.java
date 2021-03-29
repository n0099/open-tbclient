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
    public final a<K, V> f35479a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    public final Map<K, a<K, V>> f35480b = new HashMap();

    /* loaded from: classes6.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final K f35481a;

        /* renamed from: b  reason: collision with root package name */
        public a<K, V> f35482b;

        /* renamed from: c  reason: collision with root package name */
        public a<K, V> f35483c;

        /* renamed from: d  reason: collision with root package name */
        public List<V> f35484d;

        public a() {
            this(null);
        }

        public a(K k) {
            this.f35483c = this;
            this.f35482b = this;
            this.f35481a = k;
        }

        @Nullable
        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f35484d.remove(b2 - 1);
            }
            return null;
        }

        public void a(V v) {
            if (this.f35484d == null) {
                this.f35484d = new ArrayList();
            }
            this.f35484d.add(v);
        }

        public int b() {
            List<V> list = this.f35484d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        a<K, V> aVar2 = this.f35479a;
        aVar.f35483c = aVar2;
        aVar.f35482b = aVar2.f35482b;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        a<K, V> aVar2 = this.f35479a;
        aVar.f35483c = aVar2.f35483c;
        aVar.f35482b = aVar2;
        c(aVar);
    }

    public static <K, V> void c(a<K, V> aVar) {
        aVar.f35482b.f35483c = aVar;
        aVar.f35483c.f35482b = aVar;
    }

    public static <K, V> void d(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f35483c;
        aVar2.f35482b = aVar.f35482b;
        aVar.f35482b.f35483c = aVar2;
    }

    @Nullable
    public V a() {
        a aVar = this.f35479a;
        while (true) {
            aVar = aVar.f35483c;
            if (aVar.equals(this.f35479a)) {
                return null;
            }
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            d(aVar);
            this.f35480b.remove(aVar.f35481a);
            ((m) aVar.f35481a).a();
        }
    }

    @Nullable
    public V a(K k) {
        a<K, V> aVar = this.f35480b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f35480b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.f35480b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.f35480b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f35479a.f35482b; !aVar.equals(this.f35479a); aVar = aVar.f35482b) {
            z = true;
            sb.append('{');
            sb.append(aVar.f35481a);
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
