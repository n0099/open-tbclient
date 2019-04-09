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
    private final ar jGD;
    private final af jGR;
    private final boolean jGW;
    private final boolean jHC;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHD;
    ai<com.facebook.imagepipeline.f.d> jHE;
    ai<com.facebook.imagepipeline.f.d> jHF;
    ai<Void> jHG;
    ai<Void> jHH;
    private ai<com.facebook.imagepipeline.f.d> jHI;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHJ;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHK;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHL;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHM;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHN;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHO;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> jHP = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> jHQ = new HashMap();
    private final boolean jHe;
    private final l jHu;

    public m(l lVar, af afVar, boolean z, boolean z2, ar arVar, boolean z3) {
        this.jHu = lVar;
        this.jGR = afVar;
        this.jGW = z;
        this.jHe = z2;
        this.jGD = arVar;
        this.jHC = z3;
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
        if (this.jHD == null) {
            this.jHD = q(cyl());
        }
        return this.jHD;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cyj() {
        if (this.jHF == null) {
            this.jHF = this.jHu.a(cyl(), this.jGD);
        }
        return this.jHF;
    }

    private synchronized ai<Void> cyk() {
        if (this.jHH == null) {
            this.jHH = l.m(cyj());
        }
        return this.jHH;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cyl() {
        if (this.jHI == null) {
            this.jHI = l.a(r(this.jHu.a(this.jGR)));
            this.jHI = this.jHu.a(this.jHI, this.jGW, this.jHC);
        }
        return this.jHI;
    }

    private synchronized ai<Void> cym() {
        if (this.jHG == null) {
            this.jHG = l.m(cyn());
        }
        return this.jHG;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cyn() {
        if (this.jHE == null) {
            this.jHE = this.jHu.a(r(this.jHu.cyf()), this.jGD);
        }
        return this.jHE;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyo() {
        if (this.jHJ == null) {
            this.jHJ = p(this.jHu.cyf());
        }
        return this.jHJ;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyp() {
        if (this.jHK == null) {
            this.jHK = t(this.jHu.cyh());
        }
        return this.jHK;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyq() {
        if (this.jHL == null) {
            this.jHL = a(this.jHu.cyc(), new au[]{this.jHu.cyd(), this.jHu.cye()});
        }
        return this.jHL;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyr() {
        if (this.jHM == null) {
            this.jHM = p(this.jHu.cyg());
        }
        return this.jHM;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cys() {
        if (this.jHN == null) {
            this.jHN = p(this.jHu.cyb());
        }
        return this.jHN;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyt() {
        if (this.jHO == null) {
            ai<com.facebook.imagepipeline.f.d> cya = this.jHu.cya();
            if (com.facebook.common.g.c.jAk && (!this.jHe || com.facebook.common.g.c.jAn == null)) {
                cya = this.jHu.o(cya);
            }
            l lVar = this.jHu;
            this.jHO = q(this.jHu.a(l.a(cya), true, this.jHC));
        }
        return this.jHO;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new au[]{this.jHu.cye()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return q(b(r(aiVar), auVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return t(this.jHu.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.jAk && (!this.jHe || com.facebook.common.g.c.jAn == null)) {
            aiVar = this.jHu.o(aiVar);
        }
        return this.jHu.i(this.jHu.j(s(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> s(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.jHu.f(this.jHu.h(this.jHu.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.jHu.b(this.jHu.a(this.jHu.c(this.jHu.d(aiVar)), this.jGD));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        as n = this.jHu.n(this.jHu.a(l.a(aiVar), true, this.jHC));
        l lVar = this.jHu;
        return l.a(b(auVarArr), n);
    }

    private ai<com.facebook.imagepipeline.f.d> b(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return this.jHu.a(this.jHu.a(auVarArr), true, this.jHC);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> u(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.jHP.containsKey(aiVar)) {
            this.jHP.put(aiVar, this.jHu.k(this.jHu.l(aiVar)));
        }
        return this.jHP.get(aiVar);
    }

    private synchronized ai<Void> v(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.jHQ.containsKey(aiVar)) {
            l lVar = this.jHu;
            this.jHQ.put(aiVar, l.m(aiVar));
        }
        return this.jHQ.get(aiVar);
    }

    private static String I(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
