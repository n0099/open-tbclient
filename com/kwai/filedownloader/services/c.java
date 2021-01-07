package com.kwai.filedownloader.services;

import com.kwai.filedownloader.a.c;
import com.kwai.filedownloader.e.b;
import com.kwai.filedownloader.f.c;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f11283a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        c.InterfaceC1172c f11284a;

        /* renamed from: b  reason: collision with root package name */
        Integer f11285b;
        c.e c;
        c.b d;
        c.a e;
        c.d f;

        public a a(int i) {
            if (i > 0) {
                this.f11285b = Integer.valueOf(i);
            }
            return this;
        }

        public a a(c.b bVar) {
            this.d = bVar;
            return this;
        }

        public String toString() {
            return com.kwai.filedownloader.f.f.a("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.f11284a, this.f11285b, this.c, this.d, this.e);
        }
    }

    public c() {
        this.f11283a = null;
    }

    public c(a aVar) {
        this.f11283a = aVar;
    }

    private c.d g() {
        return new b();
    }

    private int h() {
        return com.kwai.filedownloader.f.e.a().e;
    }

    private com.kwai.filedownloader.b.a i() {
        return new com.kwai.filedownloader.b.c();
    }

    private c.e j() {
        return new b.a();
    }

    private c.b k() {
        return new c.b();
    }

    private c.a l() {
        return new com.kwai.filedownloader.a.a();
    }

    public int a() {
        Integer num;
        if (this.f11283a != null && (num = this.f11283a.f11285b) != null) {
            if (com.kwai.filedownloader.f.d.f11228a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwai.filedownloader.f.e.a(num.intValue());
        }
        return h();
    }

    public com.kwai.filedownloader.b.a b() {
        if (this.f11283a == null || this.f11283a.f11284a == null) {
            return i();
        }
        com.kwai.filedownloader.b.a a2 = this.f11283a.f11284a.a();
        if (a2 != null) {
            if (com.kwai.filedownloader.f.d.f11228a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize database: %s", a2);
                return a2;
            }
            return a2;
        }
        return i();
    }

    public c.e c() {
        c.e eVar;
        if (this.f11283a != null && (eVar = this.f11283a.c) != null) {
            if (com.kwai.filedownloader.f.d.f11228a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
                return eVar;
            }
            return eVar;
        }
        return j();
    }

    public c.b d() {
        c.b bVar;
        if (this.f11283a != null && (bVar = this.f11283a.d) != null) {
            if (com.kwai.filedownloader.f.d.f11228a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection creator: %s", bVar);
                return bVar;
            }
            return bVar;
        }
        return k();
    }

    public c.a e() {
        c.a aVar;
        if (this.f11283a != null && (aVar = this.f11283a.e) != null) {
            if (com.kwai.filedownloader.f.d.f11228a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
                return aVar;
            }
            return aVar;
        }
        return l();
    }

    public c.d f() {
        c.d dVar;
        if (this.f11283a != null && (dVar = this.f11283a.f) != null) {
            if (com.kwai.filedownloader.f.d.f11228a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
                return dVar;
            }
            return dVar;
        }
        return g();
    }
}
