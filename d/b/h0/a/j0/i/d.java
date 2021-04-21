package d.b.h0.a.j0.i;

import d.b.h0.a.k;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f45558a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a<Boolean>> f45559b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, a<b>> f45560c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public a<Exception> f45561d = new a<>();

    /* loaded from: classes2.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public Set<d.b.h0.a.i2.u0.b<T>> f45562a = new HashSet();

        public void a(T t) {
            for (d.b.h0.a.i2.u0.b<T> bVar : this.f45562a) {
                bVar.onCallback(t);
            }
        }

        public void b() {
            this.f45562a.clear();
        }

        public void c(d.b.h0.a.i2.u0.b<T> bVar) {
            if (bVar != null) {
                this.f45562a.add(bVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f45563a;

        /* renamed from: b  reason: collision with root package name */
        public final long f45564b;

        public b(long j, long j2) {
            this.f45563a = j;
            this.f45564b = j2;
            int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        }

        public boolean a() {
            return this.f45564b > 0;
        }
    }

    static {
        boolean z = k.f45772a;
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
        return new HashSet<>(this.f45558a);
    }

    public void b(Exception exc) {
        this.f45561d.a(exc);
        this.f45561d.b();
    }

    public void c(String str, boolean z) {
        a i = i(this.f45559b, str);
        i.a(Boolean.valueOf(z));
        i.b();
    }

    public void d(String str, b bVar) {
        if (bVar == null || bVar.a()) {
            i(this.f45560c, str).a(bVar);
        }
    }

    public d e(d.b.h0.a.i2.u0.b<Exception> bVar) {
        this.f45561d.c(bVar);
        return this;
    }

    public d f(String... strArr) {
        this.f45558a.addAll(Arrays.asList(strArr));
        return this;
    }

    public final <T> d g(Map<String, a<T>> map, String str, d.b.h0.a.i2.u0.b<T> bVar) {
        f(str);
        i(map, str).c(bVar);
        return this;
    }

    public d h(String str, d.b.h0.a.i2.u0.b<Boolean> bVar) {
        g(this.f45559b, str, bVar);
        return this;
    }
}
