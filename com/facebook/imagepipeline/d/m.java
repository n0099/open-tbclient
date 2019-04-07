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
    private final ar jGC;
    private final af jGQ;
    private final boolean jGV;
    private final boolean jHB;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHC;
    ai<com.facebook.imagepipeline.f.d> jHD;
    ai<com.facebook.imagepipeline.f.d> jHE;
    ai<Void> jHF;
    ai<Void> jHG;
    private ai<com.facebook.imagepipeline.f.d> jHH;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHI;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHJ;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHK;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHL;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHM;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHN;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> jHO = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> jHP = new HashMap();
    private final boolean jHd;
    private final l jHt;

    public m(l lVar, af afVar, boolean z, boolean z2, ar arVar, boolean z3) {
        this.jHt = lVar;
        this.jGQ = afVar;
        this.jGV = z;
        this.jHd = z2;
        this.jGC = arVar;
        this.jHB = z3;
    }

    public ai<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.cAo()) {
            case 0:
                return cyk();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + I(imageRequest.cAn()));
            case 2:
            case 3:
                return cym();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.czC().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g = g(imageRequest);
        if (imageRequest.cAx() != null) {
            return u(g);
        }
        return g;
    }

    public ai<Void> f(ImageRequest imageRequest) {
        return v(g(imageRequest));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri cAn = imageRequest.cAn();
        com.facebook.common.internal.g.checkNotNull(cAn, "Uri is null.");
        switch (imageRequest.cAo()) {
            case 0:
                return cyi();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + I(cAn));
            case 2:
                return cyp();
            case 3:
                return cyo();
            case 4:
                return cyq();
            case 5:
                return cys();
            case 6:
                return cyr();
            case 7:
                return cyt();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyi() {
        if (this.jHC == null) {
            this.jHC = q(cyl());
        }
        return this.jHC;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cyj() {
        if (this.jHE == null) {
            this.jHE = this.jHt.a(cyl(), this.jGC);
        }
        return this.jHE;
    }

    private synchronized ai<Void> cyk() {
        if (this.jHG == null) {
            this.jHG = l.m(cyj());
        }
        return this.jHG;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cyl() {
        if (this.jHH == null) {
            this.jHH = l.a(r(this.jHt.a(this.jGQ)));
            this.jHH = this.jHt.a(this.jHH, this.jGV, this.jHB);
        }
        return this.jHH;
    }

    private synchronized ai<Void> cym() {
        if (this.jHF == null) {
            this.jHF = l.m(cyn());
        }
        return this.jHF;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cyn() {
        if (this.jHD == null) {
            this.jHD = this.jHt.a(r(this.jHt.cyf()), this.jGC);
        }
        return this.jHD;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyo() {
        if (this.jHI == null) {
            this.jHI = p(this.jHt.cyf());
        }
        return this.jHI;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyp() {
        if (this.jHJ == null) {
            this.jHJ = t(this.jHt.cyh());
        }
        return this.jHJ;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyq() {
        if (this.jHK == null) {
            this.jHK = a(this.jHt.cyc(), new au[]{this.jHt.cyd(), this.jHt.cye()});
        }
        return this.jHK;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyr() {
        if (this.jHL == null) {
            this.jHL = p(this.jHt.cyg());
        }
        return this.jHL;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cys() {
        if (this.jHM == null) {
            this.jHM = p(this.jHt.cyb());
        }
        return this.jHM;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyt() {
        if (this.jHN == null) {
            ai<com.facebook.imagepipeline.f.d> cya = this.jHt.cya();
            if (com.facebook.common.g.c.jAj && (!this.jHd || com.facebook.common.g.c.jAm == null)) {
                cya = this.jHt.o(cya);
            }
            l lVar = this.jHt;
            this.jHN = q(this.jHt.a(l.a(cya), true, this.jHB));
        }
        return this.jHN;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new au[]{this.jHt.cye()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return q(b(r(aiVar), auVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return t(this.jHt.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.jAj && (!this.jHd || com.facebook.common.g.c.jAm == null)) {
            aiVar = this.jHt.o(aiVar);
        }
        return this.jHt.i(this.jHt.j(s(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> s(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.jHt.f(this.jHt.h(this.jHt.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.jHt.b(this.jHt.a(this.jHt.c(this.jHt.d(aiVar)), this.jGC));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        as n = this.jHt.n(this.jHt.a(l.a(aiVar), true, this.jHB));
        l lVar = this.jHt;
        return l.a(b(auVarArr), n);
    }

    private ai<com.facebook.imagepipeline.f.d> b(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return this.jHt.a(this.jHt.a(auVarArr), true, this.jHB);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> u(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.jHO.containsKey(aiVar)) {
            this.jHO.put(aiVar, this.jHt.k(this.jHt.l(aiVar)));
        }
        return this.jHO.get(aiVar);
    }

    private synchronized ai<Void> v(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.jHP.containsKey(aiVar)) {
            l lVar = this.jHt;
            this.jHP.put(aiVar, l.m(aiVar));
        }
        return this.jHP.get(aiVar);
    }

    private static String I(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
