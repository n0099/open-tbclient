package d.o.a.e.b.o.b;

import com.baidu.searchbox.bddownload.core.Util;
import d.o.a.e.b.o.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class c implements i {
    public static final ArrayList<String> j;

    /* renamed from: a  reason: collision with root package name */
    public final String f68209a;

    /* renamed from: b  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f68210b;

    /* renamed from: d  reason: collision with root package name */
    public int f68212d;

    /* renamed from: e  reason: collision with root package name */
    public long f68213e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68215g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68216h;
    public i i;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f68211c = null;

    /* renamed from: f  reason: collision with root package name */
    public final Object f68214f = new Object();

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
        this.f68209a = str;
        this.f68210b = list;
    }

    @Override // d.o.a.e.b.o.i
    public String a(String str) {
        Map<String, String> map = this.f68211c;
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
        return this.f68212d;
    }

    @Override // d.o.a.e.b.o.i
    public void c() {
        i iVar = this.i;
        if (iVar != null) {
            iVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.f68214f) {
            if (this.f68216h && this.f68211c == null) {
                this.f68214f.wait();
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void e() throws Exception {
        if (this.f68211c != null) {
            return;
        }
        try {
            this.f68216h = true;
            this.i = d.o.a.e.b.g.d.t(this.f68209a, this.f68210b);
            synchronized (this.f68214f) {
                if (this.i != null) {
                    HashMap hashMap = new HashMap();
                    this.f68211c = hashMap;
                    f(this.i, hashMap);
                    this.f68212d = this.i.b();
                    this.f68213e = System.currentTimeMillis();
                    this.f68215g = g(this.f68212d);
                }
                this.f68216h = false;
                this.f68214f.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f68214f) {
                if (this.i != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f68211c = hashMap2;
                    f(this.i, hashMap2);
                    this.f68212d = this.i.b();
                    this.f68213e = System.currentTimeMillis();
                    this.f68215g = g(this.f68212d);
                }
                this.f68216h = false;
                this.f68214f.notifyAll();
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
        return this.f68215g;
    }

    public boolean i() {
        return System.currentTimeMillis() - this.f68213e < b.f68206d;
    }

    public boolean j() {
        return this.f68216h;
    }

    public List<com.ss.android.socialbase.downloader.model.c> k() {
        return this.f68210b;
    }

    public Map<String, String> l() {
        return this.f68211c;
    }
}
