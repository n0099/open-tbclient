package com.kwad.framework.filedownloader.services;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.e.b;
import com.kwad.framework.filedownloader.f.c;
/* loaded from: classes10.dex */
public final class c {
    public final b ahA;

    /* loaded from: classes10.dex */
    public interface a {
        c.b vk();
    }

    /* loaded from: classes10.dex */
    public static class b {
        public c.InterfaceC0683c ahB;
        public Integer ahC;
        public c.e ahD;
        public c.b ahE;
        public a ahF;
        public c.a ahG;
        public c.d ahH;

        public final String toString() {
            return com.kwad.framework.filedownloader.f.f.b("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.ahB, this.ahC, this.ahD, this.ahE, this.ahG);
        }

        public final b a(c.b bVar) {
            this.ahE = bVar;
            return this;
        }

        public final b bC(int i) {
            this.ahC = Integer.MAX_VALUE;
            return this;
        }

        public final b a(a aVar) {
            this.ahF = aVar;
            return this;
        }
    }

    public c() {
        this.ahA = null;
    }

    public static c.d wm() {
        return new com.kwad.framework.filedownloader.services.b();
    }

    public static int wn() {
        return com.kwad.framework.filedownloader.f.e.wD().aib;
    }

    public static c.e wo() {
        return new b.a();
    }

    public static c.b wp() {
        return new c.b();
    }

    public static c.a wq() {
        return new com.kwad.framework.filedownloader.a.a();
    }

    public final int vh() {
        b bVar = this.ahA;
        if (bVar == null) {
            return wn();
        }
        Integer num = bVar.ahC;
        if (num != null) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwad.framework.filedownloader.f.e.bG(num.intValue());
        }
        return wn();
    }

    public final com.kwad.framework.filedownloader.b.a wh() {
        c.InterfaceC0683c interfaceC0683c;
        b bVar = this.ahA;
        if (bVar != null && (interfaceC0683c = bVar.ahB) != null) {
            com.kwad.framework.filedownloader.b.a wC = interfaceC0683c.wC();
            if (wC != null) {
                return wC;
            }
            return new com.kwad.framework.filedownloader.b.c();
        }
        return new com.kwad.framework.filedownloader.b.c();
    }

    public final c.e wi() {
        b bVar = this.ahA;
        if (bVar == null) {
            return wo();
        }
        c.e eVar = bVar.ahD;
        if (eVar != null) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
            }
            return eVar;
        }
        return wo();
    }

    public final c.b wj() {
        c.b vk;
        b bVar = this.ahA;
        if (bVar == null) {
            return wp();
        }
        a aVar = bVar.ahF;
        if (aVar != null && (vk = aVar.vk()) != null) {
            return vk;
        }
        return wp();
    }

    public final c.a wk() {
        b bVar = this.ahA;
        if (bVar == null) {
            return wq();
        }
        c.a aVar = bVar.ahG;
        if (aVar != null) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
            }
            return aVar;
        }
        return wq();
    }

    public final c.d wl() {
        b bVar = this.ahA;
        if (bVar == null) {
            return wm();
        }
        c.d dVar = bVar.ahH;
        if (dVar != null) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
            }
            return dVar;
        }
        return wm();
    }

    public c(b bVar) {
        this.ahA = bVar;
    }
}
