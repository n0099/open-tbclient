package d.b.g;

import android.util.LruCache;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f43474a;

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, a> f43475b = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 16);

    /* renamed from: c  reason: collision with root package name */
    public boolean f43476c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f43477a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f43478b;

        /* renamed from: c  reason: collision with root package name */
        public long f43479c;

        /* renamed from: d  reason: collision with root package name */
        public long f43480d;

        public void a(long j) {
            this.f43479c = j;
        }

        public void b(ArrayList<String> arrayList) {
            this.f43477a = arrayList;
        }

        public boolean c() {
            return i() + this.f43479c < System.currentTimeMillis() / 1000;
        }

        public ArrayList<String> d() {
            return this.f43477a;
        }

        public void e(long j) {
            this.f43480d = j;
        }

        public void f(ArrayList<String> arrayList) {
            this.f43478b = arrayList;
        }

        public ArrayList<String> g() {
            return this.f43478b;
        }

        public long h() {
            return this.f43479c;
        }

        public long i() {
            return this.f43480d;
        }
    }

    public h(String str, boolean z) {
        this.f43476c = false;
        this.f43474a = str;
        this.f43476c = z;
    }

    public a a(String str) {
        a aVar = this.f43475b.get(str);
        if (aVar != null && aVar.c() && this.f43476c) {
            this.f43475b.remove(str);
            k.a("Remove expired entry from %s cache while reading, host(%s)", this.f43474a, str);
            return null;
        }
        return aVar;
    }

    public void b() {
        this.f43475b.evictAll();
        k.a("Clear %s cache", this.f43474a);
    }

    public void c(String str, a aVar) {
        ArrayList<String> d2 = aVar.d();
        ArrayList<String> g2 = aVar.g();
        if ((d2 == null || d2.isEmpty()) && (g2 == null || g2.isEmpty())) {
            return;
        }
        this.f43475b.put(str, aVar);
        Object[] objArr = new Object[5];
        objArr[0] = this.f43474a;
        objArr[1] = str;
        objArr[2] = d2 != null ? d2.toString() : null;
        objArr[3] = g2 != null ? g2.toString() : null;
        objArr[4] = Long.valueOf(aVar.h());
        k.a("Set entry to %s cache, host(%s), ipv4List(%s), ipv6List(%s), ttl(%d)", objArr);
    }

    public void d(boolean z) {
        this.f43476c = z;
    }

    public ArrayList<String> e() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.f43475b.snapshot().keySet()) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public void f(String str) {
        a a2 = a(str);
        if (a2 == null || !a2.c()) {
            return;
        }
        this.f43475b.remove(str);
        k.a("Remove expired entry from %s cache, host(%s)", this.f43474a, str);
    }
}
