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
    public final String f67211a;

    /* renamed from: b  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f67212b;

    /* renamed from: d  reason: collision with root package name */
    public int f67214d;

    /* renamed from: e  reason: collision with root package name */
    public long f67215e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67217g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67218h;
    public i i;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f67213c = null;

    /* renamed from: f  reason: collision with root package name */
    public final Object f67216f = new Object();

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
        this.f67211a = str;
        this.f67212b = list;
    }

    @Override // d.o.a.e.b.o.i
    public String a(String str) {
        Map<String, String> map = this.f67213c;
        if (map != null) {
            return map.get(str);
        }
        i iVar = this.i;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }

    @Override // d.o.a.e.b.o.i
    public int b() throws IOException {
        return this.f67214d;
    }

    @Override // d.o.a.e.b.o.i
    public void c() {
        i iVar = this.i;
        if (iVar != null) {
            iVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.f67216f) {
            if (this.f67218h && this.f67213c == null) {
                this.f67216f.wait();
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void e() throws Exception {
        if (this.f67213c != null) {
            return;
        }
        try {
            this.f67218h = true;
            this.i = d.o.a.e.b.g.d.t(this.f67211a, this.f67212b);
            synchronized (this.f67216f) {
                if (this.i != null) {
                    HashMap hashMap = new HashMap();
                    this.f67213c = hashMap;
                    f(this.i, hashMap);
                    this.f67214d = this.i.b();
                    this.f67215e = System.currentTimeMillis();
                    this.f67217g = g(this.f67214d);
                }
                this.f67218h = false;
                this.f67216f.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f67216f) {
                if (this.i != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f67213c = hashMap2;
                    f(this.i, hashMap2);
                    this.f67214d = this.i.b();
                    this.f67215e = System.currentTimeMillis();
                    this.f67217g = g(this.f67214d);
                }
                this.f67218h = false;
                this.f67216f.notifyAll();
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

    public boolean g(int i) {
        return i >= 200 && i < 300;
    }

    public boolean h() {
        return this.f67217g;
    }

    public boolean i() {
        return System.currentTimeMillis() - this.f67215e < b.f67208d;
    }

    public boolean j() {
        return this.f67218h;
    }

    public List<com.ss.android.socialbase.downloader.model.c> k() {
        return this.f67212b;
    }

    public Map<String, String> l() {
        return this.f67213c;
    }
}
