package d.a.h0.a.j0.i;

import d.a.h0.a.k;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f42879a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a<Boolean>> f42880b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, a<b>> f42881c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public a<Exception> f42882d = new a<>();

    /* loaded from: classes2.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public Set<d.a.h0.a.i2.u0.b<T>> f42883a = new HashSet();

        public void a(T t) {
            for (d.a.h0.a.i2.u0.b<T> bVar : this.f42883a) {
                bVar.onCallback(t);
            }
        }

        public void b() {
            this.f42883a.clear();
        }

        public void c(d.a.h0.a.i2.u0.b<T> bVar) {
            if (bVar != null) {
                this.f42883a.add(bVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f42884a;

        /* renamed from: b  reason: collision with root package name */
        public final long f42885b;

        public b(long j, long j2) {
            this.f42884a = j;
            this.f42885b = j2;
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        }

        public boolean a() {
            return this.f42885b > 0;
        }
    }

    static {
        boolean z = k.f43101a;
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
        return new HashSet<>(this.f42879a);
    }

    public void b(Exception exc) {
        this.f42882d.a(exc);
        this.f42882d.b();
    }

    public void c(String str, boolean z) {
        a i2 = i(this.f42880b, str);
        i2.a(Boolean.valueOf(z));
        i2.b();
    }

    public void d(String str, b bVar) {
        if (bVar == null || bVar.a()) {
            i(this.f42881c, str).a(bVar);
        }
    }

    public d e(d.a.h0.a.i2.u0.b<Exception> bVar) {
        this.f42882d.c(bVar);
        return this;
    }

    public d f(String... strArr) {
        this.f42879a.addAll(Arrays.asList(strArr));
        return this;
    }

    public final <T> d g(Map<String, a<T>> map, String str, d.a.h0.a.i2.u0.b<T> bVar) {
        f(str);
        i(map, str).c(bVar);
        return this;
    }

    public d h(String str, d.a.h0.a.i2.u0.b<Boolean> bVar) {
        g(this.f42880b, str, bVar);
        return this;
    }
}
