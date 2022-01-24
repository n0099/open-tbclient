package com.ss.android.socialbase.downloader.network.a;

import com.baidu.searchbox.bddownload.core.Util;
import com.ss.android.socialbase.downloader.network.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class c implements g {

    /* renamed from: e  reason: collision with root package name */
    public static final ArrayList<String> f60286e;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final long f60287b;

    /* renamed from: c  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f60288c;

    /* renamed from: g  reason: collision with root package name */
    public int f60291g;

    /* renamed from: h  reason: collision with root package name */
    public long f60292h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60293i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f60294j;
    public g k;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f60290f = null;

    /* renamed from: d  reason: collision with root package name */
    public final Object f60289d = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        f60286e = arrayList;
        arrayList.add("Content-Length");
        f60286e.add("Content-Range");
        f60286e.add("Transfer-Encoding");
        f60286e.add(Util.ACCEPT_RANGES);
        f60286e.add(Util.ETAG);
        f60286e.add("Content-Disposition");
    }

    public c(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) {
        this.a = str;
        this.f60288c = list;
        this.f60287b = j2;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void a() throws Exception {
        if (this.f60290f != null) {
            return;
        }
        try {
            this.f60294j = true;
            this.k = com.ss.android.socialbase.downloader.downloader.c.a(this.a, this.f60288c);
            synchronized (this.f60289d) {
                if (this.k != null) {
                    HashMap hashMap = new HashMap();
                    this.f60290f = hashMap;
                    a(this.k, hashMap);
                    this.f60291g = this.k.b();
                    this.f60292h = System.currentTimeMillis();
                    this.f60293i = a(this.f60291g);
                }
                this.f60294j = false;
                this.f60289d.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f60289d) {
                if (this.k != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f60290f = hashMap2;
                    a(this.k, hashMap2);
                    this.f60291g = this.k.b();
                    this.f60292h = System.currentTimeMillis();
                    this.f60293i = a(this.f60291g);
                }
                this.f60294j = false;
                this.f60289d.notifyAll();
                throw th;
            }
        }
    }

    public boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        return this.f60291g;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        g gVar = this.k;
        if (gVar != null) {
            gVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.f60289d) {
            if (this.f60294j && this.f60290f == null) {
                this.f60289d.wait();
            }
        }
    }

    public boolean e() {
        return this.f60293i;
    }

    public boolean f() {
        return System.currentTimeMillis() - this.f60292h < b.f60282b;
    }

    public boolean g() {
        return this.f60294j;
    }

    public List<com.ss.android.socialbase.downloader.model.c> h() {
        return this.f60288c;
    }

    public Map<String, String> i() {
        return this.f60290f;
    }

    private void a(g gVar, Map<String, String> map) {
        if (gVar == null || map == null) {
            return;
        }
        Iterator<String> it = f60286e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, gVar.a(next));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        Map<String, String> map = this.f60290f;
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
