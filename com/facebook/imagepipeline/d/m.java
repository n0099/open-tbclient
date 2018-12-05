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
    private final aq imY;
    private final boolean inA;
    private final l inQ;
    private final boolean inZ;
    private final af inm;
    private final boolean inr;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ioa;
    private ai<com.facebook.imagepipeline.f.d> iob;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ioc;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> iod;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ioe;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> iof;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> iog;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ioh;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> ioi = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> ioj = new HashMap();

    public m(l lVar, af afVar, boolean z, boolean z2, aq aqVar, boolean z3) {
        this.inQ = lVar;
        this.inm = afVar;
        this.inr = z;
        this.inA = z2;
        this.imY = aqVar;
        this.inZ = z3;
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> c(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d = d(imageRequest);
        if (imageRequest.bZO() != null) {
            return t(d);
        }
        return d;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri bZE = imageRequest.bZE();
        com.facebook.common.internal.g.checkNotNull(bZE, "Uri is null.");
        switch (imageRequest.bZF()) {
            case 0:
                return bXD();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + A(bZE));
            case 2:
                return bXG();
            case 3:
                return bXF();
            case 4:
                return bXH();
            case 5:
                return bXJ();
            case 6:
                return bXI();
            case 7:
                return bXK();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bXD() {
        if (this.ioa == null) {
            this.ioa = p(bXE());
        }
        return this.ioa;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> bXE() {
        if (this.iob == null) {
            this.iob = l.a(q(this.inQ.a(this.inm)));
            this.iob = this.inQ.a(this.iob, this.inr, this.inZ);
        }
        return this.iob;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bXF() {
        if (this.ioc == null) {
            this.ioc = o(this.inQ.bXA());
        }
        return this.ioc;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bXG() {
        if (this.iod == null) {
            this.iod = s(this.inQ.bXC());
        }
        return this.iod;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bXH() {
        if (this.ioe == null) {
            this.ioe = a(this.inQ.bXx(), new at[]{this.inQ.bXy(), this.inQ.bXz()});
        }
        return this.ioe;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bXI() {
        if (this.iof == null) {
            this.iof = o(this.inQ.bXB());
        }
        return this.iof;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bXJ() {
        if (this.iog == null) {
            this.iog = o(this.inQ.bXw());
        }
        return this.iog;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bXK() {
        if (this.ioh == null) {
            ai<com.facebook.imagepipeline.f.d> bXv = this.inQ.bXv();
            if (com.facebook.common.g.c.igK && (!this.inA || com.facebook.common.g.c.igN == null)) {
                bXv = this.inQ.n(bXv);
            }
            l lVar = this.inQ;
            this.ioh = p(this.inQ.a(l.a(bXv), true, this.inZ));
        }
        return this.ioh;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new at[]{this.inQ.bXz()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return p(b(q(aiVar), atVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return s(this.inQ.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.igK && (!this.inA || com.facebook.common.g.c.igN == null)) {
            aiVar = this.inQ.n(aiVar);
        }
        return this.inQ.i(this.inQ.j(r(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.inQ.f(this.inQ.h(this.inQ.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> s(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.inQ.b(this.inQ.a(this.inQ.c(this.inQ.d(aiVar)), this.imY));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        ar m = this.inQ.m(this.inQ.a(l.a(aiVar), true, this.inZ));
        l lVar = this.inQ;
        return l.a(b(atVarArr), m);
    }

    private ai<com.facebook.imagepipeline.f.d> b(at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return this.inQ.a(this.inQ.a(atVarArr), true, this.inZ);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.ioi.containsKey(aiVar)) {
            this.ioi.put(aiVar, this.inQ.k(this.inQ.l(aiVar)));
        }
        return this.ioi.get(aiVar);
    }

    private static String A(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
