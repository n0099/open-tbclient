package com.ss.android.socialbase.downloader.network.a;

import com.baidu.searchbox.bddownload.core.Util;
import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class c implements g {
    public static final ArrayList e;
    public final String a;
    public final long b;
    public List c;
    public int g;
    public long h;
    public boolean i;
    public boolean j;
    public g k;
    public Map f = null;
    public final Object d = new Object();

    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    static {
        ArrayList arrayList = new ArrayList(6);
        e = arrayList;
        arrayList.add("Content-Length");
        e.add("Content-Range");
        e.add("Transfer-Encoding");
        e.add(Util.ACCEPT_RANGES);
        e.add(Util.ETAG);
        e.add("Content-Disposition");
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        return this.g;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        g gVar = this.k;
        if (gVar != null) {
            gVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.d) {
            if (this.j && this.f == null) {
                this.d.wait();
            }
        }
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        if (System.currentTimeMillis() - this.h < b.b) {
            return true;
        }
        return false;
    }

    public boolean g() {
        return this.j;
    }

    public List h() {
        return this.c;
    }

    public Map i() {
        return this.f;
    }

    public c(String str, List list, long j) {
        this.a = str;
        this.c = list;
        this.b = j;
    }

    private void a(g gVar, Map map) {
        if (gVar != null && map != null) {
            Iterator it = e.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                map.put(str, gVar.a(str));
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        Map map = this.f;
        if (map != null) {
            return (String) map.get(str);
        }
        g gVar = this.k;
        if (gVar != null) {
            return gVar.a(str);
        }
        return null;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void a() throws Exception {
        if (this.f != null) {
            return;
        }
        try {
            this.j = true;
            this.k = com.ss.android.socialbase.downloader.downloader.c.a(this.a, this.c);
            synchronized (this.d) {
                if (this.k != null) {
                    HashMap hashMap = new HashMap();
                    this.f = hashMap;
                    a(this.k, hashMap);
                    this.g = this.k.b();
                    this.h = System.currentTimeMillis();
                    this.i = a(this.g);
                }
                this.j = false;
                this.d.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.d) {
                if (this.k != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f = hashMap2;
                    a(this.k, hashMap2);
                    this.g = this.k.b();
                    this.h = System.currentTimeMillis();
                    this.i = a(this.g);
                }
                this.j = false;
                this.d.notifyAll();
                throw th;
            }
        }
    }
}
