package d.o.a.e.b.o.b;

import com.baidu.searchbox.bddownload.core.Util;
import d.o.a.e.b.o.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class c implements i {
    public static final ArrayList<String> j;

    /* renamed from: a  reason: collision with root package name */
    public final String f71247a;

    /* renamed from: b  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f71248b;

    /* renamed from: d  reason: collision with root package name */
    public int f71250d;

    /* renamed from: e  reason: collision with root package name */
    public long f71251e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71253g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f71254h;

    /* renamed from: i  reason: collision with root package name */
    public i f71255i;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f71249c = null;

    /* renamed from: f  reason: collision with root package name */
    public final Object f71252f = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        j = arrayList;
        arrayList.add("Content-Length");
        j.add("Content-Range");
        j.add("Transfer-Encoding");
        j.add(Util.ACCEPT_RANGES);
        j.add(Util.ETAG);
        j.add("Content-Disposition");
    }

    public c(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) {
        this.f71247a = str;
        this.f71248b = list;
    }

    @Override // d.o.a.e.b.o.i
    public String a(String str) {
        Map<String, String> map = this.f71249c;
        if (map != null) {
            return map.get(str);
        }
        i iVar = this.f71255i;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }

    @Override // d.o.a.e.b.o.i
    public int b() throws IOException {
        return this.f71250d;
    }

    @Override // d.o.a.e.b.o.i
    public void c() {
        i iVar = this.f71255i;
        if (iVar != null) {
            iVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.f71252f) {
            if (this.f71254h && this.f71249c == null) {
                this.f71252f.wait();
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void e() throws Exception {
        if (this.f71249c != null) {
            return;
        }
        try {
            this.f71254h = true;
            this.f71255i = d.o.a.e.b.g.d.t(this.f71247a, this.f71248b);
            synchronized (this.f71252f) {
                if (this.f71255i != null) {
                    HashMap hashMap = new HashMap();
                    this.f71249c = hashMap;
                    f(this.f71255i, hashMap);
                    this.f71250d = this.f71255i.b();
                    this.f71251e = System.currentTimeMillis();
                    this.f71253g = g(this.f71250d);
                }
                this.f71254h = false;
                this.f71252f.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f71252f) {
                if (this.f71255i != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f71249c = hashMap2;
                    f(this.f71255i, hashMap2);
                    this.f71250d = this.f71255i.b();
                    this.f71251e = System.currentTimeMillis();
                    this.f71253g = g(this.f71250d);
                }
                this.f71254h = false;
                this.f71252f.notifyAll();
                throw th;
            }
        }
    }

    public final void f(i iVar, Map<String, String> map) {
        if (iVar == null || map == null) {
            return;
        }
        Iterator<String> it = j.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, iVar.a(next));
        }
    }

    public boolean g(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    public boolean h() {
        return this.f71253g;
    }

    public boolean i() {
        return System.currentTimeMillis() - this.f71251e < b.f71244d;
    }

    public boolean j() {
        return this.f71254h;
    }

    public List<com.ss.android.socialbase.downloader.model.c> k() {
        return this.f71248b;
    }

    public Map<String, String> l() {
        return this.f71249c;
    }
}
