package com.ss.android.socialbase.downloader.network.a;

import com.baidu.searchbox.bddownload.core.Util;
import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class c implements g {

    /* renamed from: e  reason: collision with root package name */
    public static final ArrayList<String> f62603e;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final long f62604b;

    /* renamed from: c  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f62605c;

    /* renamed from: g  reason: collision with root package name */
    public int f62608g;

    /* renamed from: h  reason: collision with root package name */
    public long f62609h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62610i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f62611j;

    /* renamed from: k  reason: collision with root package name */
    public g f62612k;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f62607f = null;

    /* renamed from: d  reason: collision with root package name */
    public final Object f62606d = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        f62603e = arrayList;
        arrayList.add("Content-Length");
        f62603e.add("Content-Range");
        f62603e.add("Transfer-Encoding");
        f62603e.add(Util.ACCEPT_RANGES);
        f62603e.add(Util.ETAG);
        f62603e.add("Content-Disposition");
    }

    public c(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) {
        this.a = str;
        this.f62605c = list;
        this.f62604b = j2;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void a() throws Exception {
        if (this.f62607f != null) {
            return;
        }
        try {
            this.f62611j = true;
            this.f62612k = com.ss.android.socialbase.downloader.downloader.c.a(this.a, this.f62605c);
            synchronized (this.f62606d) {
                if (this.f62612k != null) {
                    HashMap hashMap = new HashMap();
                    this.f62607f = hashMap;
                    a(this.f62612k, hashMap);
                    this.f62608g = this.f62612k.b();
                    this.f62609h = System.currentTimeMillis();
                    this.f62610i = a(this.f62608g);
                }
                this.f62611j = false;
                this.f62606d.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f62606d) {
                if (this.f62612k != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f62607f = hashMap2;
                    a(this.f62612k, hashMap2);
                    this.f62608g = this.f62612k.b();
                    this.f62609h = System.currentTimeMillis();
                    this.f62610i = a(this.f62608g);
                }
                this.f62611j = false;
                this.f62606d.notifyAll();
                throw th;
            }
        }
    }

    public boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        return this.f62608g;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        g gVar = this.f62612k;
        if (gVar != null) {
            gVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.f62606d) {
            if (this.f62611j && this.f62607f == null) {
                this.f62606d.wait();
            }
        }
    }

    public boolean e() {
        return this.f62610i;
    }

    public boolean f() {
        return System.currentTimeMillis() - this.f62609h < b.f62599b;
    }

    public boolean g() {
        return this.f62611j;
    }

    public List<com.ss.android.socialbase.downloader.model.c> h() {
        return this.f62605c;
    }

    public Map<String, String> i() {
        return this.f62607f;
    }

    private void a(g gVar, Map<String, String> map) {
        if (gVar == null || map == null) {
            return;
        }
        Iterator<String> it = f62603e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, gVar.a(next));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        Map<String, String> map = this.f62607f;
        if (map != null) {
            return map.get(str);
        }
        g gVar = this.f62612k;
        if (gVar != null) {
            return gVar.a(str);
        }
        return null;
    }
}
