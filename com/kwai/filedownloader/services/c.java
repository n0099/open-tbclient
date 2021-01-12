package com.kwai.filedownloader.services;

import com.kwai.filedownloader.a.c;
import com.kwai.filedownloader.e.b;
import com.kwai.filedownloader.f.c;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f10983a;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        c.InterfaceC1155c f10984a;

        /* renamed from: b  reason: collision with root package name */
        Integer f10985b;
        c.e c;
        c.b d;
        c.a e;
        c.d f;

        public a a(int i) {
            if (i > 0) {
                this.f10985b = Integer.valueOf(i);
            }
            return this;
        }

        public a a(c.b bVar) {
            this.d = bVar;
            return this;
        }

        public String toString() {
            return com.kwai.filedownloader.f.f.a("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.f10984a, this.f10985b, this.c, this.d, this.e);
        }
    }

    public c() {
        this.f10983a = null;
    }

    public c(a aVar) {
        this.f10983a = aVar;
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
        if (this.f10983a != null && (num = this.f10983a.f10985b) != null) {
            if (com.kwai.filedownloader.f.d.f10928a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwai.filedownloader.f.e.a(num.intValue());
        }
        return h();
    }

    public com.kwai.filedownloader.b.a b() {
        if (this.f10983a == null || this.f10983a.f10984a == null) {
            return i();
        }
        com.kwai.filedownloader.b.a a2 = this.f10983a.f10984a.a();
        if (a2 != null) {
            if (com.kwai.filedownloader.f.d.f10928a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize database: %s", a2);
                return a2;
            }
            return a2;
        }
        return i();
    }

    public c.e c() {
        c.e eVar;
        if (this.f10983a != null && (eVar = this.f10983a.c) != null) {
            if (com.kwai.filedownloader.f.d.f10928a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
                return eVar;
            }
            return eVar;
        }
        return j();
    }

    public c.b d() {
        c.b bVar;
        if (this.f10983a != null && (bVar = this.f10983a.d) != null) {
            if (com.kwai.filedownloader.f.d.f10928a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection creator: %s", bVar);
                return bVar;
            }
            return bVar;
        }
        return k();
    }

    public c.a e() {
        c.a aVar;
        if (this.f10983a != null && (aVar = this.f10983a.e) != null) {
            if (com.kwai.filedownloader.f.d.f10928a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
                return aVar;
            }
            return aVar;
        }
        return l();
    }

    public c.d f() {
        c.d dVar;
        if (this.f10983a != null && (dVar = this.f10983a.f) != null) {
            if (com.kwai.filedownloader.f.d.f10928a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
                return dVar;
            }
            return dVar;
        }
        return g();
    }
}
