package d.p.a.e.b.o.b;

import com.baidu.searchbox.bddownload.core.Util;
import d.p.a.e.b.o.i;
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
    public final String f68356a;

    /* renamed from: b  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f68357b;

    /* renamed from: d  reason: collision with root package name */
    public int f68359d;

    /* renamed from: e  reason: collision with root package name */
    public long f68360e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68362g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68363h;
    public i i;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f68358c = null;

    /* renamed from: f  reason: collision with root package name */
    public final Object f68361f = new Object();

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
        this.f68356a = str;
        this.f68357b = list;
    }

    @Override // d.p.a.e.b.o.i
    public String a(String str) {
        Map<String, String> map = this.f68358c;
        if (map != null) {
            return map.get(str);
        }
        i iVar = this.i;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }

    @Override // d.p.a.e.b.o.i
    public int b() throws IOException {
        return this.f68359d;
    }

    @Override // d.p.a.e.b.o.i
    public void c() {
        i iVar = this.i;
        if (iVar != null) {
            iVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.f68361f) {
            if (this.f68363h && this.f68358c == null) {
                this.f68361f.wait();
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void e() throws Exception {
        if (this.f68358c != null) {
            return;
        }
        try {
            this.f68363h = true;
            this.i = d.p.a.e.b.g.d.t(this.f68356a, this.f68357b);
            synchronized (this.f68361f) {
                if (this.i != null) {
                    HashMap hashMap = new HashMap();
                    this.f68358c = hashMap;
                    f(this.i, hashMap);
                    this.f68359d = this.i.b();
                    this.f68360e = System.currentTimeMillis();
                    this.f68362g = g(this.f68359d);
                }
                this.f68363h = false;
                this.f68361f.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f68361f) {
                if (this.i != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f68358c = hashMap2;
                    f(this.i, hashMap2);
                    this.f68359d = this.i.b();
                    this.f68360e = System.currentTimeMillis();
                    this.f68362g = g(this.f68359d);
                }
                this.f68363h = false;
                this.f68361f.notifyAll();
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
        return this.f68362g;
    }

    public boolean i() {
        return System.currentTimeMillis() - this.f68360e < b.f68353d;
    }

    public boolean j() {
        return this.f68363h;
    }

    public List<com.ss.android.socialbase.downloader.model.c> k() {
        return this.f68357b;
    }

    public Map<String, String> l() {
        return this.f68358c;
    }
}
