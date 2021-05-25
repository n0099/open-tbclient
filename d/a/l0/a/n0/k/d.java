package d.a.l0.a.n0.k;

import d.a.l0.a.k;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f43650a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a<Boolean>> f43651b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, a<b>> f43652c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public a<Exception> f43653d = new a<>();

    /* loaded from: classes2.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public Set<d.a.l0.a.v2.e1.b<T>> f43654a = new HashSet();

        public void a(T t) {
            for (d.a.l0.a.v2.e1.b<T> bVar : this.f43654a) {
                bVar.onCallback(t);
            }
        }

        public void b() {
            this.f43654a.clear();
        }

        public void c(d.a.l0.a.v2.e1.b<T> bVar) {
            if (bVar != null) {
                this.f43654a.add(bVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f43655a;

        /* renamed from: b  reason: collision with root package name */
        public final long f43656b;

        public b(long j, long j2) {
            this.f43655a = j;
            this.f43656b = j2;
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        }

        public boolean a() {
            return this.f43656b > 0;
        }
    }

    static {
        boolean z = k.f43199a;
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
        return new HashSet<>(this.f43650a);
    }

    public void b(Exception exc) {
        this.f43653d.a(exc);
        this.f43653d.b();
    }

    public void c(String str, boolean z) {
        a i2 = i(this.f43651b, str);
        i2.a(Boolean.valueOf(z));
        i2.b();
    }

    public void d(String str, b bVar) {
        if (bVar == null || bVar.a()) {
            i(this.f43652c, str).a(bVar);
        }
    }

    public d e(d.a.l0.a.v2.e1.b<Exception> bVar) {
        this.f43653d.c(bVar);
        return this;
    }

    public d f(String... strArr) {
        this.f43650a.addAll(Arrays.asList(strArr));
        return this;
    }

    public final <T> d g(Map<String, a<T>> map, String str, d.a.l0.a.v2.e1.b<T> bVar) {
        f(str);
        i(map, str).c(bVar);
        return this;
    }

    public d h(String str, d.a.l0.a.v2.e1.b<Boolean> bVar) {
        g(this.f43651b, str, bVar);
        return this;
    }
}
