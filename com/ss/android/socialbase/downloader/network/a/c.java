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
    public static final ArrayList<String> f60241e;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final long f60242b;

    /* renamed from: c  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f60243c;

    /* renamed from: g  reason: collision with root package name */
    public int f60246g;

    /* renamed from: h  reason: collision with root package name */
    public long f60247h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60248i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f60249j;
    public g k;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f60245f = null;

    /* renamed from: d  reason: collision with root package name */
    public final Object f60244d = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        f60241e = arrayList;
        arrayList.add("Content-Length");
        f60241e.add("Content-Range");
        f60241e.add("Transfer-Encoding");
        f60241e.add(Util.ACCEPT_RANGES);
        f60241e.add(Util.ETAG);
        f60241e.add("Content-Disposition");
    }

    public c(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) {
        this.a = str;
        this.f60243c = list;
        this.f60242b = j2;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void a() throws Exception {
        if (this.f60245f != null) {
            return;
        }
        try {
            this.f60249j = true;
            this.k = com.ss.android.socialbase.downloader.downloader.c.a(this.a, this.f60243c);
            synchronized (this.f60244d) {
                if (this.k != null) {
                    HashMap hashMap = new HashMap();
                    this.f60245f = hashMap;
                    a(this.k, hashMap);
                    this.f60246g = this.k.b();
                    this.f60247h = System.currentTimeMillis();
                    this.f60248i = a(this.f60246g);
                }
                this.f60249j = false;
                this.f60244d.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f60244d) {
                if (this.k != null) {
                    HashMap hashMap2 = new HashMap();
                    this.f60245f = hashMap2;
                    a(this.k, hashMap2);
                    this.f60246g = this.k.b();
                    this.f60247h = System.currentTimeMillis();
                    this.f60248i = a(this.f60246g);
                }
                this.f60249j = false;
                this.f60244d.notifyAll();
                throw th;
            }
        }
    }

    public boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        return this.f60246g;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        g gVar = this.k;
        if (gVar != null) {
            gVar.c();
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.f60244d) {
            if (this.f60249j && this.f60245f == null) {
                this.f60244d.wait();
            }
        }
    }

    public boolean e() {
        return this.f60248i;
    }

    public boolean f() {
        return System.currentTimeMillis() - this.f60247h < b.f60237b;
    }

    public boolean g() {
        return this.f60249j;
    }

    public List<com.ss.android.socialbase.downloader.model.c> h() {
        return this.f60243c;
    }

    public Map<String, String> i() {
        return this.f60245f;
    }

    private void a(g gVar, Map<String, String> map) {
        if (gVar == null || map == null) {
            return;
        }
        Iterator<String> it = f60241e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, gVar.a(next));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        Map<String, String> map = this.f60245f;
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
