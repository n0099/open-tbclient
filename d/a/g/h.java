package d.a.g;

import android.util.LruCache;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f43561a;

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, a> f43562b = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 16);

    /* renamed from: c  reason: collision with root package name */
    public boolean f43563c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f43564a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f43565b;

        /* renamed from: c  reason: collision with root package name */
        public long f43566c;

        /* renamed from: d  reason: collision with root package name */
        public long f43567d;

        public void a(long j) {
            this.f43566c = j;
        }

        public void b(ArrayList<String> arrayList) {
            this.f43564a = arrayList;
        }

        public boolean c() {
            return i() + this.f43566c < System.currentTimeMillis() / 1000;
        }

        public ArrayList<String> d() {
            return this.f43564a;
        }

        public void e(long j) {
            this.f43567d = j;
        }

        public void f(ArrayList<String> arrayList) {
            this.f43565b = arrayList;
        }

        public ArrayList<String> g() {
            return this.f43565b;
        }

        public long h() {
            return this.f43566c;
        }

        public long i() {
            return this.f43567d;
        }
    }

    public h(String str, boolean z) {
        this.f43563c = false;
        this.f43561a = str;
        this.f43563c = z;
    }

    public a a(String str) {
        a aVar = this.f43562b.get(str);
        if (aVar != null && aVar.c() && this.f43563c) {
            this.f43562b.remove(str);
            k.a("Remove expired entry from %s cache while reading, host(%s)", this.f43561a, str);
            return null;
        }
        return aVar;
    }

    public void b() {
        this.f43562b.evictAll();
        k.a("Clear %s cache", this.f43561a);
    }

    public void c(String str, a aVar) {
        ArrayList<String> d2 = aVar.d();
        ArrayList<String> g2 = aVar.g();
        if ((d2 == null || d2.isEmpty()) && (g2 == null || g2.isEmpty())) {
            return;
        }
        this.f43562b.put(str, aVar);
        Object[] objArr = new Object[5];
        objArr[0] = this.f43561a;
        objArr[1] = str;
        objArr[2] = d2 != null ? d2.toString() : null;
        objArr[3] = g2 != null ? g2.toString() : null;
        objArr[4] = Long.valueOf(aVar.h());
        k.a("Set entry to %s cache, host(%s), ipv4List(%s), ipv6List(%s), ttl(%d)", objArr);
    }

    public void d(boolean z) {
        this.f43563c = z;
    }

    public ArrayList<String> e() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.f43562b.snapshot().keySet()) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public void f(String str) {
        a a2 = a(str);
        if (a2 == null || !a2.c()) {
            return;
        }
        this.f43562b.remove(str);
        k.a("Remove expired entry from %s cache, host(%s)", this.f43561a, str);
    }
}
