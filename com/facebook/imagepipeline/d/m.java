package com.facebook.imagepipeline.d;

import android.net.Uri;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.ai;
import com.facebook.imagepipeline.producers.aq;
import com.facebook.imagepipeline.producers.ar;
import com.facebook.imagepipeline.producers.at;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class m {
    private final aq ifN;
    private final l igE;
    private final boolean igN;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> igO;
    private ai<com.facebook.imagepipeline.f.d> igP;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> igQ;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> igR;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> igS;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> igT;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> igU;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> igV;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> igW = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> igX = new HashMap();
    private final af igb;
    private final boolean igg;
    private final boolean igo;

    public m(l lVar, af afVar, boolean z, boolean z2, aq aqVar, boolean z3) {
        this.igE = lVar;
        this.igb = afVar;
        this.igg = z;
        this.igo = z2;
        this.ifN = aqVar;
        this.igN = z3;
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> c(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d = d(imageRequest);
        if (imageRequest.bXI() != null) {
            return t(d);
        }
        return d;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri bXy = imageRequest.bXy();
        com.facebook.common.internal.g.checkNotNull(bXy, "Uri is null.");
        switch (imageRequest.bXz()) {
            case 0:
                return bVx();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + z(bXy));
            case 2:
                return bVA();
            case 3:
                return bVz();
            case 4:
                return bVB();
            case 5:
                return bVD();
            case 6:
                return bVC();
            case 7:
                return bVE();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVx() {
        if (this.igO == null) {
            this.igO = p(bVy());
        }
        return this.igO;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> bVy() {
        if (this.igP == null) {
            this.igP = l.a(q(this.igE.a(this.igb)));
            this.igP = this.igE.a(this.igP, this.igg, this.igN);
        }
        return this.igP;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVz() {
        if (this.igQ == null) {
            this.igQ = o(this.igE.bVu());
        }
        return this.igQ;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVA() {
        if (this.igR == null) {
            this.igR = s(this.igE.bVw());
        }
        return this.igR;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVB() {
        if (this.igS == null) {
            this.igS = a(this.igE.bVr(), new at[]{this.igE.bVs(), this.igE.bVt()});
        }
        return this.igS;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVC() {
        if (this.igT == null) {
            this.igT = o(this.igE.bVv());
        }
        return this.igT;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVD() {
        if (this.igU == null) {
            this.igU = o(this.igE.bVq());
        }
        return this.igU;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVE() {
        if (this.igV == null) {
            ai<com.facebook.imagepipeline.f.d> bVp = this.igE.bVp();
            if (com.facebook.common.g.c.hZx && (!this.igo || com.facebook.common.g.c.hZA == null)) {
                bVp = this.igE.n(bVp);
            }
            l lVar = this.igE;
            this.igV = p(this.igE.a(l.a(bVp), true, this.igN));
        }
        return this.igV;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new at[]{this.igE.bVt()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return p(b(q(aiVar), atVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return s(this.igE.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.hZx && (!this.igo || com.facebook.common.g.c.hZA == null)) {
            aiVar = this.igE.n(aiVar);
        }
        return this.igE.i(this.igE.j(r(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.igE.f(this.igE.h(this.igE.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> s(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.igE.b(this.igE.a(this.igE.c(this.igE.d(aiVar)), this.ifN));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        ar m = this.igE.m(this.igE.a(l.a(aiVar), true, this.igN));
        l lVar = this.igE;
        return l.a(b(atVarArr), m);
    }

    private ai<com.facebook.imagepipeline.f.d> b(at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return this.igE.a(this.igE.a(atVarArr), true, this.igN);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.igW.containsKey(aiVar)) {
            this.igW.put(aiVar, this.igE.k(this.igE.l(aiVar)));
        }
        return this.igW.get(aiVar);
    }

    private static String z(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
