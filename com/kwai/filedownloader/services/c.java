package com.kwai.filedownloader.services;

import com.kwai.filedownloader.a.c;
import com.kwai.filedownloader.e.b;
import com.kwai.filedownloader.f.c;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final a f37102a;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c.InterfaceC0445c f37103a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f37104b;

        /* renamed from: c  reason: collision with root package name */
        public c.e f37105c;

        /* renamed from: d  reason: collision with root package name */
        public c.b f37106d;

        /* renamed from: e  reason: collision with root package name */
        public c.a f37107e;

        /* renamed from: f  reason: collision with root package name */
        public c.d f37108f;

        public a a(int i) {
            if (i > 0) {
                this.f37104b = Integer.valueOf(i);
            }
            return this;
        }

        public a a(c.b bVar) {
            this.f37106d = bVar;
            return this;
        }

        public String toString() {
            return com.kwai.filedownloader.f.f.a("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.f37103a, this.f37104b, this.f37105c, this.f37106d, this.f37107e);
        }
    }

    public c() {
        this.f37102a = null;
    }

    public c(a aVar) {
        this.f37102a = aVar;
    }

    private c.d g() {
        return new b();
    }

    private int h() {
        return com.kwai.filedownloader.f.e.a().f37016e;
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
        a aVar = this.f37102a;
        if (aVar != null && (num = aVar.f37104b) != null) {
            if (com.kwai.filedownloader.f.d.f37011a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwai.filedownloader.f.e.a(num.intValue());
        }
        return h();
    }

    public com.kwai.filedownloader.b.a b() {
        c.InterfaceC0445c interfaceC0445c;
        a aVar = this.f37102a;
        if (aVar == null || (interfaceC0445c = aVar.f37103a) == null) {
            return i();
        }
        com.kwai.filedownloader.b.a a2 = interfaceC0445c.a();
        if (a2 != null) {
            if (com.kwai.filedownloader.f.d.f37011a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize database: %s", a2);
            }
            return a2;
        }
        return i();
    }

    public c.e c() {
        c.e eVar;
        a aVar = this.f37102a;
        if (aVar != null && (eVar = aVar.f37105c) != null) {
            if (com.kwai.filedownloader.f.d.f37011a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
            }
            return eVar;
        }
        return j();
    }

    public c.b d() {
        c.b bVar;
        a aVar = this.f37102a;
        if (aVar != null && (bVar = aVar.f37106d) != null) {
            if (com.kwai.filedownloader.f.d.f37011a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection creator: %s", bVar);
            }
            return bVar;
        }
        return k();
    }

    public c.a e() {
        c.a aVar;
        a aVar2 = this.f37102a;
        if (aVar2 != null && (aVar = aVar2.f37107e) != null) {
            if (com.kwai.filedownloader.f.d.f37011a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
            }
            return aVar;
        }
        return l();
    }

    public c.d f() {
        c.d dVar;
        a aVar = this.f37102a;
        if (aVar != null && (dVar = aVar.f37108f) != null) {
            if (com.kwai.filedownloader.f.d.f37011a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
            }
            return dVar;
        }
        return g();
    }
}
