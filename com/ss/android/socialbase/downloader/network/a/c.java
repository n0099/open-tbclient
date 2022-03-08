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

    /* renamed from: e  reason: collision with root package name */
    public static final ArrayList<String> f58803e;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final long f58804b;

    /* renamed from: c  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f58805c;

    /* renamed from: g  reason: collision with root package name */
    public int f58808g;

    /* renamed from: h  reason: collision with root package name */
    public long f58809h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58810i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f58811j;
    public g k;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f58807f = null;

    /* renamed from: d  reason: collision with root package name */
    public final Object f58806d = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        f58803e = arrayList;
        arrayList.add("Content-Length");
        f58803e.add("Content-Range");
        f58803e.add("Transfer-Encoding");
        f58803e.add(Util.ACCEPT_RANGES);
        f58803e.add(Util.ETAG);
        f58803e.add("Content-Disposition");
    }

    public c(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) {
        this.a = str;
        this.f58805c = list;
        this.f58804b = j2;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void a() throws Exception {
        if (this.f58807f != null) {
            return;
        }
        try {
            this.f58811j = true;
            this.k = com.ss.android.socialbase.downloader.downloader.c.a(this.a, this.f58805c);
            synchronized (this.f58806d) {
                if (this.k != null) {
                    HashMap hashMap = new HashMap();
                    this.f58807f = hashMap;
                    a(this.k, hashMap);
                    this.f58808g = this.k.b();
                    this.f58809h = System.currentTimeMillis();
                    this.f58810i = a(this.f58808g);
                }
                this.f58811j = false;
                this.f58806d.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f58806d) {
                if (this.k != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f58807f = hashMap2;
                    a(this.k, hashMap2);
                    this.f58808g = this.k.b();
                    this.f58809h = System.currentTimeMillis();
                    this.f58810i = a(this.f58808g);
                }
                this.f58811j = false;
                this.f58806d.notifyAll();
                throw th;
            }
        }
    }

    public boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        return this.f58808g;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        g gVar = this.k;
        if (gVar != null) {
            gVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.f58806d) {
            if (this.f58811j && this.f58807f == null) {
                this.f58806d.wait();
            }
        }
    }

    public boolean e() {
        return this.f58810i;
    }

    public boolean f() {
        return System.currentTimeMillis() - this.f58809h < b.f58799b;
    }

    public boolean g() {
        return this.f58811j;
    }

    public List<com.ss.android.socialbase.downloader.model.c> h() {
        return this.f58805c;
    }

    public Map<String, String> i() {
        return this.f58807f;
    }

    private void a(g gVar, Map<String, String> map) {
        if (gVar == null || map == null) {
            return;
        }
        Iterator<String> it = f58803e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, gVar.a(next));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        Map<String, String> map = this.f58807f;
        if (map != null) {
            return map.get(str);
        }
        g gVar = this.k;
        if (gVar != null) {
            return gVar.a(str);
        }
        return null;
    }
}
