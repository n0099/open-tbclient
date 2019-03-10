package com.facebook.imagepipeline.d;

import android.net.Uri;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.ai;
import com.facebook.imagepipeline.producers.ar;
import com.facebook.imagepipeline.producers.as;
import com.facebook.imagepipeline.producers.au;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class m {
    private final af jHE;
    private final boolean jHJ;
    private final boolean jHR;
    private final ar jHq;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIA;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIB;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> jIC = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> jID = new HashMap();
    private final l jIh;
    private final boolean jIp;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIq;
    ai<com.facebook.imagepipeline.f.d> jIr;
    ai<com.facebook.imagepipeline.f.d> jIs;
    ai<Void> jIt;
    ai<Void> jIu;
    private ai<com.facebook.imagepipeline.f.d> jIv;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIw;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIx;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIy;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIz;

    public m(l lVar, af afVar, boolean z, boolean z2, ar arVar, boolean z3) {
        this.jIh = lVar;
        this.jHE = afVar;
        this.jHJ = z;
        this.jHR = z2;
        this.jHq = arVar;
        this.jIp = z3;
    }

    public ai<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.cAs()) {
            case 0:
                return cyo();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + I(imageRequest.cAr()));
            case 2:
            case 3:
                return cyq();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.czG().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g = g(imageRequest);
        if (imageRequest.cAB() != null) {
            return u(g);
        }
        return g;
    }

    public ai<Void> f(ImageRequest imageRequest) {
        return v(g(imageRequest));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri cAr = imageRequest.cAr();
        com.facebook.common.internal.g.checkNotNull(cAr, "Uri is null.");
        switch (imageRequest.cAs()) {
            case 0:
                return cym();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + I(cAr));
            case 2:
                return cyt();
            case 3:
                return cys();
            case 4:
                return cyu();
            case 5:
                return cyw();
            case 6:
                return cyv();
            case 7:
                return cyx();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cym() {
        if (this.jIq == null) {
            this.jIq = q(cyp());
        }
        return this.jIq;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cyn() {
        if (this.jIs == null) {
            this.jIs = this.jIh.a(cyp(), this.jHq);
        }
        return this.jIs;
    }

    private synchronized ai<Void> cyo() {
        if (this.jIu == null) {
            this.jIu = l.m(cyn());
        }
        return this.jIu;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cyp() {
        if (this.jIv == null) {
            this.jIv = l.a(r(this.jIh.a(this.jHE)));
            this.jIv = this.jIh.a(this.jIv, this.jHJ, this.jIp);
        }
        return this.jIv;
    }

    private synchronized ai<Void> cyq() {
        if (this.jIt == null) {
            this.jIt = l.m(cyr());
        }
        return this.jIt;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cyr() {
        if (this.jIr == null) {
            this.jIr = this.jIh.a(r(this.jIh.cyj()), this.jHq);
        }
        return this.jIr;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cys() {
        if (this.jIw == null) {
            this.jIw = p(this.jIh.cyj());
        }
        return this.jIw;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyt() {
        if (this.jIx == null) {
            this.jIx = t(this.jIh.cyl());
        }
        return this.jIx;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyu() {
        if (this.jIy == null) {
            this.jIy = a(this.jIh.cyg(), new au[]{this.jIh.cyh(), this.jIh.cyi()});
        }
        return this.jIy;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyv() {
        if (this.jIz == null) {
            this.jIz = p(this.jIh.cyk());
        }
        return this.jIz;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyw() {
        if (this.jIA == null) {
            this.jIA = p(this.jIh.cyf());
        }
        return this.jIA;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyx() {
        if (this.jIB == null) {
            ai<com.facebook.imagepipeline.f.d> cye = this.jIh.cye();
            if (com.facebook.common.g.c.jAX && (!this.jHR || com.facebook.common.g.c.jBa == null)) {
                cye = this.jIh.o(cye);
            }
            l lVar = this.jIh;
            this.jIB = q(this.jIh.a(l.a(cye), true, this.jIp));
        }
        return this.jIB;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new au[]{this.jIh.cyi()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return q(b(r(aiVar), auVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return t(this.jIh.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.jAX && (!this.jHR || com.facebook.common.g.c.jBa == null)) {
            aiVar = this.jIh.o(aiVar);
        }
        return this.jIh.i(this.jIh.j(s(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> s(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.jIh.f(this.jIh.h(this.jIh.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.jIh.b(this.jIh.a(this.jIh.c(this.jIh.d(aiVar)), this.jHq));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        as n = this.jIh.n(this.jIh.a(l.a(aiVar), true, this.jIp));
        l lVar = this.jIh;
        return l.a(b(auVarArr), n);
    }

    private ai<com.facebook.imagepipeline.f.d> b(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return this.jIh.a(this.jIh.a(auVarArr), true, this.jIp);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> u(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.jIC.containsKey(aiVar)) {
            this.jIC.put(aiVar, this.jIh.k(this.jIh.l(aiVar)));
        }
        return this.jIC.get(aiVar);
    }

    private synchronized ai<Void> v(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.jID.containsKey(aiVar)) {
            l lVar = this.jIh;
            this.jID.put(aiVar, l.m(aiVar));
        }
        return this.jID.get(aiVar);
    }

    private static String I(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
