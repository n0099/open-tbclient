package com.kwai.filedownloader.services;

import com.kwai.filedownloader.a.c;
import com.kwai.filedownloader.e.b;
import com.kwai.filedownloader.f.c;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final a f37965a;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c.InterfaceC0449c f37966a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f37967b;

        /* renamed from: c  reason: collision with root package name */
        public c.e f37968c;

        /* renamed from: d  reason: collision with root package name */
        public c.b f37969d;

        /* renamed from: e  reason: collision with root package name */
        public c.a f37970e;

        /* renamed from: f  reason: collision with root package name */
        public c.d f37971f;

        public a a(int i2) {
            if (i2 > 0) {
                this.f37967b = Integer.valueOf(i2);
            }
            return this;
        }

        public a a(c.b bVar) {
            this.f37969d = bVar;
            return this;
        }

        public String toString() {
            return com.kwai.filedownloader.f.f.a("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.f37966a, this.f37967b, this.f37968c, this.f37969d, this.f37970e);
        }
    }

    public c() {
        this.f37965a = null;
    }

    public c(a aVar) {
        this.f37965a = aVar;
    }

    private c.d g() {
        return new b();
    }

    private int h() {
        return com.kwai.filedownloader.f.e.a().f37879e;
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
        a aVar = this.f37965a;
        if (aVar != null && (num = aVar.f37967b) != null) {
            if (com.kwai.filedownloader.f.d.f37874a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwai.filedownloader.f.e.a(num.intValue());
        }
        return h();
    }

    public com.kwai.filedownloader.b.a b() {
        c.InterfaceC0449c interfaceC0449c;
        a aVar = this.f37965a;
        if (aVar == null || (interfaceC0449c = aVar.f37966a) == null) {
            return i();
        }
        com.kwai.filedownloader.b.a a2 = interfaceC0449c.a();
        if (a2 != null) {
            if (com.kwai.filedownloader.f.d.f37874a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize database: %s", a2);
            }
            return a2;
        }
        return i();
    }

    public c.e c() {
        c.e eVar;
        a aVar = this.f37965a;
        if (aVar != null && (eVar = aVar.f37968c) != null) {
            if (com.kwai.filedownloader.f.d.f37874a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
            }
            return eVar;
        }
        return j();
    }

    public c.b d() {
        c.b bVar;
        a aVar = this.f37965a;
        if (aVar != null && (bVar = aVar.f37969d) != null) {
            if (com.kwai.filedownloader.f.d.f37874a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection creator: %s", bVar);
            }
            return bVar;
        }
        return k();
    }

    public c.a e() {
        c.a aVar;
        a aVar2 = this.f37965a;
        if (aVar2 != null && (aVar = aVar2.f37970e) != null) {
            if (com.kwai.filedownloader.f.d.f37874a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
            }
            return aVar;
        }
        return l();
    }

    public c.d f() {
        c.d dVar;
        a aVar = this.f37965a;
        if (aVar != null && (dVar = aVar.f37971f) != null) {
            if (com.kwai.filedownloader.f.d.f37874a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
            }
            return dVar;
        }
        return g();
    }
}
