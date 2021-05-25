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
    public final String f67461a;

    /* renamed from: b  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f67462b;

    /* renamed from: d  reason: collision with root package name */
    public int f67464d;

    /* renamed from: e  reason: collision with root package name */
    public long f67465e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67467g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67468h;

    /* renamed from: i  reason: collision with root package name */
    public i f67469i;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f67463c = null;

    /* renamed from: f  reason: collision with root package name */
    public final Object f67466f = new Object();

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
        this.f67461a = str;
        this.f67462b = list;
    }

    @Override // d.o.a.e.b.o.i
    public String a(String str) {
        Map<String, String> map = this.f67463c;
        if (map != null) {
            return map.get(str);
        }
        i iVar = this.f67469i;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }

    @Override // d.o.a.e.b.o.i
    public int b() throws IOException {
        return this.f67464d;
    }

    @Override // d.o.a.e.b.o.i
    public void c() {
        i iVar = this.f67469i;
        if (iVar != null) {
            iVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.f67466f) {
            if (this.f67468h && this.f67463c == null) {
                this.f67466f.wait();
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void e() throws Exception {
        if (this.f67463c != null) {
            return;
        }
        try {
            this.f67468h = true;
            this.f67469i = d.o.a.e.b.g.d.t(this.f67461a, this.f67462b);
            synchronized (this.f67466f) {
                if (this.f67469i != null) {
                    HashMap hashMap = new HashMap();
                    this.f67463c = hashMap;
                    f(this.f67469i, hashMap);
                    this.f67464d = this.f67469i.b();
                    this.f67465e = System.currentTimeMillis();
                    this.f67467g = g(this.f67464d);
                }
                this.f67468h = false;
                this.f67466f.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f67466f) {
                if (this.f67469i != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f67463c = hashMap2;
                    f(this.f67469i, hashMap2);
                    this.f67464d = this.f67469i.b();
                    this.f67465e = System.currentTimeMillis();
                    this.f67467g = g(this.f67464d);
                }
                this.f67468h = false;
                this.f67466f.notifyAll();
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
        return this.f67467g;
    }

    public boolean i() {
        return System.currentTimeMillis() - this.f67465e < b.f67458d;
    }

    public boolean j() {
        return this.f67468h;
    }

    public List<com.ss.android.socialbase.downloader.model.c> k() {
        return this.f67462b;
    }

    public Map<String, String> l() {
        return this.f67463c;
    }
}
