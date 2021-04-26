package d.a.g;

import android.util.LruCache;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f40728a;

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, a> f40729b = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 16);

    /* renamed from: c  reason: collision with root package name */
    public boolean f40730c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f40731a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f40732b;

        /* renamed from: c  reason: collision with root package name */
        public long f40733c;

        /* renamed from: d  reason: collision with root package name */
        public long f40734d;

        public void a(long j) {
            this.f40733c = j;
        }

        public void b(ArrayList<String> arrayList) {
            this.f40731a = arrayList;
        }

        public boolean c() {
            return i() + this.f40733c < System.currentTimeMillis() / 1000;
        }

        public ArrayList<String> d() {
            return this.f40731a;
        }

        public void e(long j) {
            this.f40734d = j;
        }

        public void f(ArrayList<String> arrayList) {
            this.f40732b = arrayList;
        }

        public ArrayList<String> g() {
            return this.f40732b;
        }

        public long h() {
            return this.f40733c;
        }

        public long i() {
            return this.f40734d;
        }
    }

    public h(String str, boolean z) {
        this.f40730c = false;
        this.f40728a = str;
        this.f40730c = z;
    }

    public a a(String str) {
        a aVar = this.f40729b.get(str);
        if (aVar != null && aVar.c() && this.f40730c) {
            this.f40729b.remove(str);
            k.a("Remove expired entry from %s cache while reading, host(%s)", this.f40728a, str);
            return null;
        }
        return aVar;
    }

    public void b() {
        this.f40729b.evictAll();
        k.a("Clear %s cache", this.f40728a);
    }

    public void c(String str, a aVar) {
        ArrayList<String> d2 = aVar.d();
        ArrayList<String> g2 = aVar.g();
        if ((d2 == null || d2.isEmpty()) && (g2 == null || g2.isEmpty())) {
            return;
        }
        this.f40729b.put(str, aVar);
        Object[] objArr = new Object[5];
        objArr[0] = this.f40728a;
        objArr[1] = str;
        objArr[2] = d2 != null ? d2.toString() : null;
        objArr[3] = g2 != null ? g2.toString() : null;
        objArr[4] = Long.valueOf(aVar.h());
        k.a("Set entry to %s cache, host(%s), ipv4List(%s), ipv6List(%s), ttl(%d)", objArr);
    }

    public void d(boolean z) {
        this.f40730c = z;
    }

    public ArrayList<String> e() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.f40729b.snapshot().keySet()) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public void f(String str) {
        a a2 = a(str);
        if (a2 == null || !a2.c()) {
            return;
        }
        this.f40729b.remove(str);
        k.a("Remove expired entry from %s cache, host(%s)", this.f40728a, str);
    }
}
