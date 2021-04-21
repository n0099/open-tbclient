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
    public final a<K, V> f35863a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    public final Map<K, a<K, V>> f35864b = new HashMap();

    /* loaded from: classes6.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final K f35865a;

        /* renamed from: b  reason: collision with root package name */
        public a<K, V> f35866b;

        /* renamed from: c  reason: collision with root package name */
        public a<K, V> f35867c;

        /* renamed from: d  reason: collision with root package name */
        public List<V> f35868d;

        public a() {
            this(null);
        }

        public a(K k) {
            this.f35867c = this;
            this.f35866b = this;
            this.f35865a = k;
        }

        @Nullable
        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f35868d.remove(b2 - 1);
            }
            return null;
        }

        public void a(V v) {
            if (this.f35868d == null) {
                this.f35868d = new ArrayList();
            }
            this.f35868d.add(v);
        }

        public int b() {
            List<V> list = this.f35868d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        a<K, V> aVar2 = this.f35863a;
        aVar.f35867c = aVar2;
        aVar.f35866b = aVar2.f35866b;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        a<K, V> aVar2 = this.f35863a;
        aVar.f35867c = aVar2.f35867c;
        aVar.f35866b = aVar2;
        c(aVar);
    }

    public static <K, V> void c(a<K, V> aVar) {
        aVar.f35866b.f35867c = aVar;
        aVar.f35867c.f35866b = aVar;
    }

    public static <K, V> void d(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f35867c;
        aVar2.f35866b = aVar.f35866b;
        aVar.f35866b.f35867c = aVar2;
    }

    @Nullable
    public V a() {
        a aVar = this.f35863a;
        while (true) {
            aVar = aVar.f35867c;
            if (aVar.equals(this.f35863a)) {
                return null;
            }
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            d(aVar);
            this.f35864b.remove(aVar.f35865a);
            ((m) aVar.f35865a).a();
        }
    }

    @Nullable
    public V a(K k) {
        a<K, V> aVar = this.f35864b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f35864b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.f35864b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.f35864b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f35863a.f35866b; !aVar.equals(this.f35863a); aVar = aVar.f35866b) {
            z = true;
            sb.append('{');
            sb.append(aVar.f35865a);
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
