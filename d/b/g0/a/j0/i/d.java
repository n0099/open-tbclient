package d.b.g0.a.j0.i;

import d.b.g0.a.k;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f44837a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a<Boolean>> f44838b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, a<b>> f44839c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public a<Exception> f44840d = new a<>();

    /* loaded from: classes2.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public Set<d.b.g0.a.i2.u0.b<T>> f44841a = new HashSet();

        public void a(T t) {
            for (d.b.g0.a.i2.u0.b<T> bVar : this.f44841a) {
                bVar.onCallback(t);
            }
        }

        public void b() {
            this.f44841a.clear();
        }

        public void c(d.b.g0.a.i2.u0.b<T> bVar) {
            if (bVar != null) {
                this.f44841a.add(bVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f44842a;

        /* renamed from: b  reason: collision with root package name */
        public final long f44843b;

        public b(long j, long j2) {
            this.f44842a = j;
            this.f44843b = j2;
            int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        }

        public boolean a() {
            return this.f44843b > 0;
        }
    }

    static {
        boolean z = k.f45051a;
    }

    public static <T> a<T> i(Map<String, a<T>> map, String str) {
        a<T> aVar = map.get(str);
        if (aVar == null) {
            a<T> aVar2 = new a<>();
            map.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public HashSet<String> a() {
        return new HashSet<>(this.f44837a);
    }

    public void b(Exception exc) {
        this.f44840d.a(exc);
        this.f44840d.b();
    }

    public void c(String str, boolean z) {
        a i = i(this.f44838b, str);
        i.a(Boolean.valueOf(z));
        i.b();
    }

    public void d(String str, b bVar) {
        if (bVar == null || bVar.a()) {
            i(this.f44839c, str).a(bVar);
        }
    }

    public d e(d.b.g0.a.i2.u0.b<Exception> bVar) {
        this.f44840d.c(bVar);
        return this;
    }

    public d f(String... strArr) {
        this.f44837a.addAll(Arrays.asList(strArr));
        return this;
    }

    public final <T> d g(Map<String, a<T>> map, String str, d.b.g0.a.i2.u0.b<T> bVar) {
        f(str);
        i(map, str).c(bVar);
        return this;
    }

    public d h(String str, d.b.g0.a.i2.u0.b<Boolean> bVar) {
        g(this.f44838b, str, bVar);
        return this;
    }
}
