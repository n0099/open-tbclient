package d.a.g;

import android.util.LruCache;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f39886a;

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, a> f39887b = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 16);

    /* renamed from: c  reason: collision with root package name */
    public boolean f39888c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f39889a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f39890b;

        /* renamed from: c  reason: collision with root package name */
        public long f39891c;

        /* renamed from: d  reason: collision with root package name */
        public long f39892d;

        public void a(long j) {
            this.f39891c = j;
        }

        public void b(ArrayList<String> arrayList) {
            this.f39889a = arrayList;
        }

        public boolean c() {
            return i() + this.f39891c < System.currentTimeMillis() / 1000;
        }

        public ArrayList<String> d() {
            return this.f39889a;
        }

        public void e(long j) {
            this.f39892d = j;
        }

        public void f(ArrayList<String> arrayList) {
            this.f39890b = arrayList;
        }

        public ArrayList<String> g() {
            return this.f39890b;
        }

        public long h() {
            return this.f39891c;
        }

        public long i() {
            return this.f39892d;
        }
    }

    public h(String str, boolean z) {
        this.f39888c = false;
        this.f39886a = str;
        this.f39888c = z;
    }

    public a a(String str) {
        a aVar = this.f39887b.get(str);
        if (aVar != null && aVar.c() && this.f39888c) {
            this.f39887b.remove(str);
            k.a("Remove expired entry from %s cache while reading, host(%s)", this.f39886a, str);
            return null;
        }
        return aVar;
    }

    public void b() {
        this.f39887b.evictAll();
        k.a("Clear %s cache", this.f39886a);
    }

    public void c(String str, a aVar) {
        ArrayList<String> d2 = aVar.d();
        ArrayList<String> g2 = aVar.g();
        if ((d2 == null || d2.isEmpty()) && (g2 == null || g2.isEmpty())) {
            return;
        }
        this.f39887b.put(str, aVar);
        Object[] objArr = new Object[5];
        objArr[0] = this.f39886a;
        objArr[1] = str;
        objArr[2] = d2 != null ? d2.toString() : null;
        objArr[3] = g2 != null ? g2.toString() : null;
        objArr[4] = Long.valueOf(aVar.h());
        k.a("Set entry to %s cache, host(%s), ipv4List(%s), ipv6List(%s), ttl(%d)", objArr);
    }

    public void d(boolean z) {
        this.f39888c = z;
    }

    public ArrayList<String> e() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.f39887b.snapshot().keySet()) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public void f(String str) {
        a a2 = a(str);
        if (a2 == null || !a2.c()) {
            return;
        }
        this.f39887b.remove(str);
        k.a("Remove expired entry from %s cache, host(%s)", this.f39886a, str);
    }
}
