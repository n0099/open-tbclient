package com.ss.android.socialbase.downloader.network.a;

import com.baidu.searchbox.bddownload.core.Util;
import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class c implements g {

    /* renamed from: e  reason: collision with root package name */
    public static final ArrayList<String> f43496e;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final long f43497b;

    /* renamed from: c  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f43498c;

    /* renamed from: g  reason: collision with root package name */
    public int f43501g;

    /* renamed from: h  reason: collision with root package name */
    public long f43502h;
    public boolean i;
    public boolean j;
    public g k;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f43500f = null;

    /* renamed from: d  reason: collision with root package name */
    public final Object f43499d = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        f43496e = arrayList;
        arrayList.add("Content-Length");
        f43496e.add("Content-Range");
        f43496e.add("Transfer-Encoding");
        f43496e.add(Util.ACCEPT_RANGES);
        f43496e.add(Util.ETAG);
        f43496e.add("Content-Disposition");
    }

    public c(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j) {
        this.a = str;
        this.f43498c = list;
        this.f43497b = j;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void a() throws Exception {
        if (this.f43500f != null) {
            return;
        }
        try {
            this.j = true;
            this.k = com.ss.android.socialbase.downloader.downloader.c.a(this.a, this.f43498c);
            synchronized (this.f43499d) {
                if (this.k != null) {
                    HashMap hashMap = new HashMap();
                    this.f43500f = hashMap;
                    a(this.k, hashMap);
                    this.f43501g = this.k.b();
                    this.f43502h = System.currentTimeMillis();
                    this.i = a(this.f43501g);
                }
                this.j = false;
                this.f43499d.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f43499d) {
                if (this.k != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f43500f = hashMap2;
                    a(this.k, hashMap2);
                    this.f43501g = this.k.b();
                    this.f43502h = System.currentTimeMillis();
                    this.i = a(this.f43501g);
                }
                this.j = false;
                this.f43499d.notifyAll();
                throw th;
            }
        }
    }

    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        return this.f43501g;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        g gVar = this.k;
        if (gVar != null) {
            gVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.f43499d) {
            if (this.j && this.f43500f == null) {
                this.f43499d.wait();
            }
        }
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return System.currentTimeMillis() - this.f43502h < b.f43492b;
    }

    public boolean g() {
        return this.j;
    }

    public List<com.ss.android.socialbase.downloader.model.c> h() {
        return this.f43498c;
    }

    public Map<String, String> i() {
        return this.f43500f;
    }

    private void a(g gVar, Map<String, String> map) {
        if (gVar == null || map == null) {
            return;
        }
        Iterator<String> it = f43496e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, gVar.a(next));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        Map<String, String> map = this.f43500f;
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
