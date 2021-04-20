package com.kwai.filedownloader.services;

import com.kwai.filedownloader.a.c;
import com.kwai.filedownloader.e.b;
import com.kwai.filedownloader.f.c;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final a f37392a;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c.InterfaceC0460c f37393a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f37394b;

        /* renamed from: c  reason: collision with root package name */
        public c.e f37395c;

        /* renamed from: d  reason: collision with root package name */
        public c.b f37396d;

        /* renamed from: e  reason: collision with root package name */
        public c.a f37397e;

        /* renamed from: f  reason: collision with root package name */
        public c.d f37398f;

        public a a(int i) {
            if (i > 0) {
                this.f37394b = Integer.valueOf(i);
            }
            return this;
        }

        public a a(c.b bVar) {
            this.f37396d = bVar;
            return this;
        }

        public String toString() {
            return com.kwai.filedownloader.f.f.a("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.f37393a, this.f37394b, this.f37395c, this.f37396d, this.f37397e);
        }
    }

    public c() {
        this.f37392a = null;
    }

    public c(a aVar) {
        this.f37392a = aVar;
    }

    private c.d g() {
        return new b();
    }

    private int h() {
        return com.kwai.filedownloader.f.e.a().f37306e;
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
        a aVar = this.f37392a;
        if (aVar != null && (num = aVar.f37394b) != null) {
            if (com.kwai.filedownloader.f.d.f37301a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwai.filedownloader.f.e.a(num.intValue());
        }
        return h();
    }

    public com.kwai.filedownloader.b.a b() {
        c.InterfaceC0460c interfaceC0460c;
        a aVar = this.f37392a;
        if (aVar == null || (interfaceC0460c = aVar.f37393a) == null) {
            return i();
        }
        com.kwai.filedownloader.b.a a2 = interfaceC0460c.a();
        if (a2 != null) {
            if (com.kwai.filedownloader.f.d.f37301a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize database: %s", a2);
            }
            return a2;
        }
        return i();
    }

    public c.e c() {
        c.e eVar;
        a aVar = this.f37392a;
        if (aVar != null && (eVar = aVar.f37395c) != null) {
            if (com.kwai.filedownloader.f.d.f37301a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
            }
            return eVar;
        }
        return j();
    }

    public c.b d() {
        c.b bVar;
        a aVar = this.f37392a;
        if (aVar != null && (bVar = aVar.f37396d) != null) {
            if (com.kwai.filedownloader.f.d.f37301a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection creator: %s", bVar);
            }
            return bVar;
        }
        return k();
    }

    public c.a e() {
        c.a aVar;
        a aVar2 = this.f37392a;
        if (aVar2 != null && (aVar = aVar2.f37397e) != null) {
            if (com.kwai.filedownloader.f.d.f37301a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
            }
            return aVar;
        }
        return l();
    }

    public c.d f() {
        c.d dVar;
        a aVar = this.f37392a;
        if (aVar != null && (dVar = aVar.f37398f) != null) {
            if (com.kwai.filedownloader.f.d.f37301a) {
                com.kwai.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
            }
            return dVar;
        }
        return g();
    }
}
