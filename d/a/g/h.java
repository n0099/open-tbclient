package d.a.g;

import android.util.LruCache;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f43567a;

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, a> f43568b = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 16);

    /* renamed from: c  reason: collision with root package name */
    public boolean f43569c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f43570a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f43571b;

        /* renamed from: c  reason: collision with root package name */
        public long f43572c;

        /* renamed from: d  reason: collision with root package name */
        public long f43573d;

        public void a(long j) {
            this.f43572c = j;
        }

        public void b(ArrayList<String> arrayList) {
            this.f43570a = arrayList;
        }

        public boolean c() {
            return i() + this.f43572c < System.currentTimeMillis() / 1000;
        }

        public ArrayList<String> d() {
            return this.f43570a;
        }

        public void e(long j) {
            this.f43573d = j;
        }

        public void f(ArrayList<String> arrayList) {
            this.f43571b = arrayList;
        }

        public ArrayList<String> g() {
            return this.f43571b;
        }

        public long h() {
            return this.f43572c;
        }

        public long i() {
            return this.f43573d;
        }
    }

    public h(String str, boolean z) {
        this.f43569c = false;
        this.f43567a = str;
        this.f43569c = z;
    }

    public a a(String str) {
        a aVar = this.f43568b.get(str);
        if (aVar != null && aVar.c() && this.f43569c) {
            this.f43568b.remove(str);
            k.a("Remove expired entry from %s cache while reading, host(%s)", this.f43567a, str);
            return null;
        }
        return aVar;
    }

    public void b() {
        this.f43568b.evictAll();
        k.a("Clear %s cache", this.f43567a);
    }

    public void c(String str, a aVar) {
        ArrayList<String> d2 = aVar.d();
        ArrayList<String> g2 = aVar.g();
        if ((d2 == null || d2.isEmpty()) && (g2 == null || g2.isEmpty())) {
            return;
        }
        this.f43568b.put(str, aVar);
        Object[] objArr = new Object[5];
        objArr[0] = this.f43567a;
        objArr[1] = str;
        objArr[2] = d2 != null ? d2.toString() : null;
        objArr[3] = g2 != null ? g2.toString() : null;
        objArr[4] = Long.valueOf(aVar.h());
        k.a("Set entry to %s cache, host(%s), ipv4List(%s), ipv6List(%s), ttl(%d)", objArr);
    }

    public void d(boolean z) {
        this.f43569c = z;
    }

    public ArrayList<String> e() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.f43568b.snapshot().keySet()) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public void f(String str) {
        a a2 = a(str);
        if (a2 == null || !a2.c()) {
            return;
        }
        this.f43568b.remove(str);
        k.a("Remove expired entry from %s cache, host(%s)", this.f43567a, str);
    }
}
