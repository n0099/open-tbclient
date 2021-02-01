package com.kwai.filedownloader.services;

import com.kwai.filedownloader.a.c;
import com.kwai.filedownloader.e.b;
import com.kwai.filedownloader.f.c;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f10985a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        c.InterfaceC1159c f10986a;

        /* renamed from: b  reason: collision with root package name */
        Integer f10987b;
        c.e c;
        c.b d;
        c.a e;
        c.d f;

        public a a(int i) {
            if (i > 0) {
                this.f10987b = Integer.valueOf(i);
            }
            return this;
        }

        public a a(c.b bVar) {
            this.d = bVar;
            return this;
        }

        public String toString() {
            return com.kwai.filedownloader.f.f.a("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.f10986a, this.f10987b, this.c, this.d, this.e);
        }
    }

    public c() {
        this.f10985a = null;
    }

    public c(a aVar) {
        this.f10985a = aVar;
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
        if (this.f10985a != null && (num = this.f10985a.f10987b) != null) {
            if (com.kwai.filedownloader.f.d.f10930a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwai.filedownloader.f.e.a(num.intValue());
        }
        return h();
    }

    public com.kwai.filedownloader.b.a b() {
        if (this.f10985a == null || this.f10985a.f10986a == null) {
            return i();
        }
        com.kwai.filedownloader.b.a a2 = this.f10985a.f10986a.a();
        if (a2 != null) {
            if (com.kwai.filedownloader.f.d.f10930a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize database: %s", a2);
                return a2;
            }
            return a2;
        }
        return i();
    }

    public c.e c() {
        c.e eVar;
        if (this.f10985a != null && (eVar = this.f10985a.c) != null) {
            if (com.kwai.filedownloader.f.d.f10930a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
                return eVar;
            }
            return eVar;
        }
        return j();
    }

    public c.b d() {
        c.b bVar;
        if (this.f10985a != null && (bVar = this.f10985a.d) != null) {
            if (com.kwai.filedownloader.f.d.f10930a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection creator: %s", bVar);
                return bVar;
            }
            return bVar;
        }
        return k();
    }

    public c.a e() {
        c.a aVar;
        if (this.f10985a != null && (aVar = this.f10985a.e) != null) {
            if (com.kwai.filedownloader.f.d.f10930a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
                return aVar;
            }
            return aVar;
        }
        return l();
    }

    public c.d f() {
        c.d dVar;
        if (this.f10985a != null && (dVar = this.f10985a.f) != null) {
            if (com.kwai.filedownloader.f.d.f10930a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
                return dVar;
            }
            return dVar;
        }
        return g();
    }
}
