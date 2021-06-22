package d.a.m0.a.n0.k;

import d.a.m0.a.k;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f47434a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a<Boolean>> f47435b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, a<b>> f47436c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public a<Exception> f47437d = new a<>();

    /* loaded from: classes3.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public Set<d.a.m0.a.v2.e1.b<T>> f47438a = new HashSet();

        public void a(T t) {
            for (d.a.m0.a.v2.e1.b<T> bVar : this.f47438a) {
                bVar.onCallback(t);
            }
        }

        public void b() {
            this.f47438a.clear();
        }

        public void c(d.a.m0.a.v2.e1.b<T> bVar) {
            if (bVar != null) {
                this.f47438a.add(bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f47439a;

        /* renamed from: b  reason: collision with root package name */
        public final long f47440b;

        public b(long j, long j2) {
            this.f47439a = j;
            this.f47440b = j2;
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        }

        public boolean a() {
            return this.f47440b > 0;
        }
    }

    static {
        boolean z = k.f46983a;
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
        return new HashSet<>(this.f47434a);
    }

    public void b(Exception exc) {
        this.f47437d.a(exc);
        this.f47437d.b();
    }

    public void c(String str, boolean z) {
        a i2 = i(this.f47435b, str);
        i2.a(Boolean.valueOf(z));
        i2.b();
    }

    public void d(String str, b bVar) {
        if (bVar == null || bVar.a()) {
            i(this.f47436c, str).a(bVar);
        }
    }

    public d e(d.a.m0.a.v2.e1.b<Exception> bVar) {
        this.f47437d.c(bVar);
        return this;
    }

    public d f(String... strArr) {
        this.f47434a.addAll(Arrays.asList(strArr));
        return this;
    }

    public final <T> d g(Map<String, a<T>> map, String str, d.a.m0.a.v2.e1.b<T> bVar) {
        f(str);
        i(map, str).c(bVar);
        return this;
    }

    public d h(String str, d.a.m0.a.v2.e1.b<Boolean> bVar) {
        g(this.f47435b, str, bVar);
        return this;
    }
}
