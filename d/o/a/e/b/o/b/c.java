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
    public final String f66732a;

    /* renamed from: b  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f66733b;

    /* renamed from: d  reason: collision with root package name */
    public int f66735d;

    /* renamed from: e  reason: collision with root package name */
    public long f66736e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66738g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66739h;

    /* renamed from: i  reason: collision with root package name */
    public i f66740i;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f66734c = null;

    /* renamed from: f  reason: collision with root package name */
    public final Object f66737f = new Object();

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
        this.f66732a = str;
        this.f66733b = list;
    }

    @Override // d.o.a.e.b.o.i
    public String a(String str) {
        Map<String, String> map = this.f66734c;
        if (map != null) {
            return map.get(str);
        }
        i iVar = this.f66740i;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }

    @Override // d.o.a.e.b.o.i
    public int b() throws IOException {
        return this.f66735d;
    }

    @Override // d.o.a.e.b.o.i
    public void c() {
        i iVar = this.f66740i;
        if (iVar != null) {
            iVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.f66737f) {
            if (this.f66739h && this.f66734c == null) {
                this.f66737f.wait();
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void e() throws Exception {
        if (this.f66734c != null) {
            return;
        }
        try {
            this.f66739h = true;
            this.f66740i = d.o.a.e.b.g.d.t(this.f66732a, this.f66733b);
            synchronized (this.f66737f) {
                if (this.f66740i != null) {
                    HashMap hashMap = new HashMap();
                    this.f66734c = hashMap;
                    f(this.f66740i, hashMap);
                    this.f66735d = this.f66740i.b();
                    this.f66736e = System.currentTimeMillis();
                    this.f66738g = g(this.f66735d);
                }
                this.f66739h = false;
                this.f66737f.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f66737f) {
                if (this.f66740i != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f66734c = hashMap2;
                    f(this.f66740i, hashMap2);
                    this.f66735d = this.f66740i.b();
                    this.f66736e = System.currentTimeMillis();
                    this.f66738g = g(this.f66735d);
                }
                this.f66739h = false;
                this.f66737f.notifyAll();
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
        return this.f66738g;
    }

    public boolean i() {
        return System.currentTimeMillis() - this.f66736e < b.f66729d;
    }

    public boolean j() {
        return this.f66739h;
    }

    public List<com.ss.android.socialbase.downloader.model.c> k() {
        return this.f66733b;
    }

    public Map<String, String> l() {
        return this.f66734c;
    }
}
