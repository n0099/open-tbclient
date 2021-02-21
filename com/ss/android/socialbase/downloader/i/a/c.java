package com.ss.android.socialbase.downloader.i.a;

import com.baidubce.http.Headers;
import com.ss.android.socialbase.downloader.i.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class c implements e {
    private static final ArrayList<String> e = new ArrayList<>(6);

    /* renamed from: a  reason: collision with root package name */
    protected final String f13169a;

    /* renamed from: b  reason: collision with root package name */
    protected final long f13170b;
    protected List<com.ss.android.socialbase.downloader.g.e> c;
    private int g;
    private long h;
    private boolean i;
    private boolean j;
    private e qgK;
    private Map<String, String> f = null;
    protected final Object d = new Object();

    static {
        e.add("Content-Length");
        e.add(Headers.CONTENT_RANGE);
        e.add("Transfer-Encoding");
        e.add("Accept-Ranges");
        e.add("Etag");
        e.add("Content-Disposition");
    }

    public c(String str, List<com.ss.android.socialbase.downloader.g.e> list, long j) {
        this.f13169a = str;
        this.c = list;
        this.f13170b = j;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void a() throws Exception {
        if (this.f == null) {
            try {
                this.j = true;
                this.qgK = com.ss.android.socialbase.downloader.downloader.b.v(this.f13169a, this.c);
                synchronized (this.d) {
                    if (this.qgK != null) {
                        this.f = new HashMap();
                        a(this.qgK, this.f);
                        this.g = this.qgK.b();
                        this.h = System.currentTimeMillis();
                        this.i = a(this.g);
                    }
                    this.j = false;
                    this.d.notifyAll();
                }
            } catch (Throwable th) {
                synchronized (this.d) {
                    if (this.qgK != null) {
                        this.f = new HashMap();
                        a(this.qgK, this.f);
                        this.g = this.qgK.b();
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

    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    private void a(e eVar, Map<String, String> map) {
        if (eVar != null && map != null) {
            Iterator<String> it = e.iterator();
            while (it.hasNext()) {
                String next = it.next();
                map.put(next, eVar.a(next));
            }
        }
    }

    public void d() throws InterruptedException {
        synchronized (this.d) {
            if (this.j && this.f == null) {
                this.d.wait();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.i.e
    public String a(String str) {
        if (this.f != null) {
            return this.f.get(str);
        }
        if (this.qgK != null) {
            return this.qgK.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.i.e
    public int b() throws IOException {
        return this.g;
    }

    @Override // com.ss.android.socialbase.downloader.i.e
    public void c() {
        if (this.qgK != null) {
            this.qgK.c();
        }
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return System.currentTimeMillis() - this.h < b.f13167b;
    }

    public boolean g() {
        return this.j;
    }

    public List<com.ss.android.socialbase.downloader.g.e> h() {
        return this.c;
    }

    public Map<String, String> i() {
        return this.f;
    }
}
