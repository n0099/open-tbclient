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
    private final ar khG;
    private final af khU;
    private final boolean khZ;
    private final boolean kiG;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kiH;
    ai<com.facebook.imagepipeline.f.d> kiI;
    ai<com.facebook.imagepipeline.f.d> kiJ;
    ai<Void> kiK;
    ai<Void> kiL;
    private ai<com.facebook.imagepipeline.f.d> kiM;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kiN;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kiO;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kiP;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kiQ;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kiR;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kiS;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> kiT = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> kiU = new HashMap();
    private final boolean kii;
    private final l kiy;

    public m(l lVar, af afVar, boolean z, boolean z2, ar arVar, boolean z3) {
        this.kiy = lVar;
        this.khU = afVar;
        this.khZ = z;
        this.kii = z2;
        this.khG = arVar;
        this.kiG = z3;
    }

    public ai<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.cLK()) {
            case 0:
                return cJF();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + O(imageRequest.cLJ()));
            case 2:
            case 3:
                return cJH();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.cKY().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g = g(imageRequest);
        if (imageRequest.cLT() != null) {
            return u(g);
        }
        return g;
    }

    public ai<Void> f(ImageRequest imageRequest) {
        return v(g(imageRequest));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri cLJ = imageRequest.cLJ();
        com.facebook.common.internal.g.checkNotNull(cLJ, "Uri is null.");
        switch (imageRequest.cLK()) {
            case 0:
                return cJD();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + O(cLJ));
            case 2:
                return cJK();
            case 3:
                return cJJ();
            case 4:
                return cJL();
            case 5:
                return cJN();
            case 6:
                return cJM();
            case 7:
                return cJO();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cJD() {
        if (this.kiH == null) {
            this.kiH = q(cJG());
        }
        return this.kiH;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cJE() {
        if (this.kiJ == null) {
            this.kiJ = this.kiy.a(cJG(), this.khG);
        }
        return this.kiJ;
    }

    private synchronized ai<Void> cJF() {
        if (this.kiL == null) {
            this.kiL = l.m(cJE());
        }
        return this.kiL;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cJG() {
        if (this.kiM == null) {
            this.kiM = l.a(r(this.kiy.a(this.khU)));
            this.kiM = this.kiy.a(this.kiM, this.khZ, this.kiG);
        }
        return this.kiM;
    }

    private synchronized ai<Void> cJH() {
        if (this.kiK == null) {
            this.kiK = l.m(cJI());
        }
        return this.kiK;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cJI() {
        if (this.kiI == null) {
            this.kiI = this.kiy.a(r(this.kiy.cJA()), this.khG);
        }
        return this.kiI;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cJJ() {
        if (this.kiN == null) {
            this.kiN = p(this.kiy.cJA());
        }
        return this.kiN;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cJK() {
        if (this.kiO == null) {
            this.kiO = t(this.kiy.cJC());
        }
        return this.kiO;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cJL() {
        if (this.kiP == null) {
            this.kiP = a(this.kiy.cJx(), new au[]{this.kiy.cJy(), this.kiy.cJz()});
        }
        return this.kiP;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cJM() {
        if (this.kiQ == null) {
            this.kiQ = p(this.kiy.cJB());
        }
        return this.kiQ;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cJN() {
        if (this.kiR == null) {
            this.kiR = p(this.kiy.cJw());
        }
        return this.kiR;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cJO() {
        if (this.kiS == null) {
            ai<com.facebook.imagepipeline.f.d> cJv = this.kiy.cJv();
            if (com.facebook.common.g.c.kbn && (!this.kii || com.facebook.common.g.c.kbq == null)) {
                cJv = this.kiy.o(cJv);
            }
            l lVar = this.kiy;
            this.kiS = q(this.kiy.a(l.a(cJv), true, this.kiG));
        }
        return this.kiS;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new au[]{this.kiy.cJz()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return q(b(r(aiVar), auVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return t(this.kiy.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.kbn && (!this.kii || com.facebook.common.g.c.kbq == null)) {
            aiVar = this.kiy.o(aiVar);
        }
        return this.kiy.i(this.kiy.j(s(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> s(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.kiy.f(this.kiy.h(this.kiy.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.kiy.b(this.kiy.a(this.kiy.c(this.kiy.d(aiVar)), this.khG));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        as n = this.kiy.n(this.kiy.a(l.a(aiVar), true, this.kiG));
        l lVar = this.kiy;
        return l.a(b(auVarArr), n);
    }

    private ai<com.facebook.imagepipeline.f.d> b(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return this.kiy.a(this.kiy.a(auVarArr), true, this.kiG);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> u(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.kiT.containsKey(aiVar)) {
            this.kiT.put(aiVar, this.kiy.k(this.kiy.l(aiVar)));
        }
        return this.kiT.get(aiVar);
    }

    private synchronized ai<Void> v(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.kiU.containsKey(aiVar)) {
            l lVar = this.kiy;
            this.kiU.put(aiVar, l.m(aiVar));
        }
        return this.kiU.get(aiVar);
    }

    private static String O(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
