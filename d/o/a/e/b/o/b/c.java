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
    public final String f67418a;

    /* renamed from: b  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f67419b;

    /* renamed from: d  reason: collision with root package name */
    public int f67421d;

    /* renamed from: e  reason: collision with root package name */
    public long f67422e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67424g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67425h;

    /* renamed from: i  reason: collision with root package name */
    public i f67426i;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f67420c = null;

    /* renamed from: f  reason: collision with root package name */
    public final Object f67423f = new Object();

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
        this.f67418a = str;
        this.f67419b = list;
    }

    @Override // d.o.a.e.b.o.i
    public String a(String str) {
        Map<String, String> map = this.f67420c;
        if (map != null) {
            return map.get(str);
        }
        i iVar = this.f67426i;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }

    @Override // d.o.a.e.b.o.i
    public int b() throws IOException {
        return this.f67421d;
    }

    @Override // d.o.a.e.b.o.i
    public void c() {
        i iVar = this.f67426i;
        if (iVar != null) {
            iVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.f67423f) {
            if (this.f67425h && this.f67420c == null) {
                this.f67423f.wait();
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void e() throws Exception {
        if (this.f67420c != null) {
            return;
        }
        try {
            this.f67425h = true;
            this.f67426i = d.o.a.e.b.g.d.t(this.f67418a, this.f67419b);
            synchronized (this.f67423f) {
                if (this.f67426i != null) {
                    HashMap hashMap = new HashMap();
                    this.f67420c = hashMap;
                    f(this.f67426i, hashMap);
                    this.f67421d = this.f67426i.b();
                    this.f67422e = System.currentTimeMillis();
                    this.f67424g = g(this.f67421d);
                }
                this.f67425h = false;
                this.f67423f.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f67423f) {
                if (this.f67426i != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f67420c = hashMap2;
                    f(this.f67426i, hashMap2);
                    this.f67421d = this.f67426i.b();
                    this.f67422e = System.currentTimeMillis();
                    this.f67424g = g(this.f67421d);
                }
                this.f67425h = false;
                this.f67423f.notifyAll();
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
        return this.f67424g;
    }

    public boolean i() {
        return System.currentTimeMillis() - this.f67422e < b.f67415d;
    }

    public boolean j() {
        return this.f67425h;
    }

    public List<com.ss.android.socialbase.downloader.model.c> k() {
        return this.f67419b;
    }

    public Map<String, String> l() {
        return this.f67420c;
    }
}
