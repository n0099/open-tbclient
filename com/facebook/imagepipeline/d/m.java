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
    private final ar jGX;
    private final l jHO;
    private final boolean jHW;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jHX;
    ai<com.facebook.imagepipeline.f.d> jHY;
    ai<com.facebook.imagepipeline.f.d> jHZ;
    private final af jHl;
    private final boolean jHq;
    private final boolean jHy;
    ai<Void> jIa;
    ai<Void> jIb;
    private ai<com.facebook.imagepipeline.f.d> jIc;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jId;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIe;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIf;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIg;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIh;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIi;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> jIj = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> jIk = new HashMap();

    public m(l lVar, af afVar, boolean z, boolean z2, ar arVar, boolean z3) {
        this.jHO = lVar;
        this.jHl = afVar;
        this.jHq = z;
        this.jHy = z2;
        this.jGX = arVar;
        this.jHW = z3;
    }

    public ai<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.cAi()) {
            case 0:
                return cye();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + I(imageRequest.cAh()));
            case 2:
            case 3:
                return cyg();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.czw().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g = g(imageRequest);
        if (imageRequest.cAr() != null) {
            return u(g);
        }
        return g;
    }

    public ai<Void> f(ImageRequest imageRequest) {
        return v(g(imageRequest));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri cAh = imageRequest.cAh();
        com.facebook.common.internal.g.checkNotNull(cAh, "Uri is null.");
        switch (imageRequest.cAi()) {
            case 0:
                return cyc();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + I(cAh));
            case 2:
                return cyj();
            case 3:
                return cyi();
            case 4:
                return cyk();
            case 5:
                return cym();
            case 6:
                return cyl();
            case 7:
                return cyn();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyc() {
        if (this.jHX == null) {
            this.jHX = q(cyf());
        }
        return this.jHX;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cyd() {
        if (this.jHZ == null) {
            this.jHZ = this.jHO.a(cyf(), this.jGX);
        }
        return this.jHZ;
    }

    private synchronized ai<Void> cye() {
        if (this.jIb == null) {
            this.jIb = l.m(cyd());
        }
        return this.jIb;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cyf() {
        if (this.jIc == null) {
            this.jIc = l.a(r(this.jHO.a(this.jHl)));
            this.jIc = this.jHO.a(this.jIc, this.jHq, this.jHW);
        }
        return this.jIc;
    }

    private synchronized ai<Void> cyg() {
        if (this.jIa == null) {
            this.jIa = l.m(cyh());
        }
        return this.jIa;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cyh() {
        if (this.jHY == null) {
            this.jHY = this.jHO.a(r(this.jHO.cxZ()), this.jGX);
        }
        return this.jHY;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyi() {
        if (this.jId == null) {
            this.jId = p(this.jHO.cxZ());
        }
        return this.jId;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyj() {
        if (this.jIe == null) {
            this.jIe = t(this.jHO.cyb());
        }
        return this.jIe;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyk() {
        if (this.jIf == null) {
            this.jIf = a(this.jHO.cxW(), new au[]{this.jHO.cxX(), this.jHO.cxY()});
        }
        return this.jIf;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyl() {
        if (this.jIg == null) {
            this.jIg = p(this.jHO.cya());
        }
        return this.jIg;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cym() {
        if (this.jIh == null) {
            this.jIh = p(this.jHO.cxV());
        }
        return this.jIh;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyn() {
        if (this.jIi == null) {
            ai<com.facebook.imagepipeline.f.d> cxU = this.jHO.cxU();
            if (com.facebook.common.g.c.jAE && (!this.jHy || com.facebook.common.g.c.jAH == null)) {
                cxU = this.jHO.o(cxU);
            }
            l lVar = this.jHO;
            this.jIi = q(this.jHO.a(l.a(cxU), true, this.jHW));
        }
        return this.jIi;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new au[]{this.jHO.cxY()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return q(b(r(aiVar), auVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return t(this.jHO.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.jAE && (!this.jHy || com.facebook.common.g.c.jAH == null)) {
            aiVar = this.jHO.o(aiVar);
        }
        return this.jHO.i(this.jHO.j(s(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> s(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.jHO.f(this.jHO.h(this.jHO.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.jHO.b(this.jHO.a(this.jHO.c(this.jHO.d(aiVar)), this.jGX));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        as n = this.jHO.n(this.jHO.a(l.a(aiVar), true, this.jHW));
        l lVar = this.jHO;
        return l.a(b(auVarArr), n);
    }

    private ai<com.facebook.imagepipeline.f.d> b(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return this.jHO.a(this.jHO.a(auVarArr), true, this.jHW);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> u(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.jIj.containsKey(aiVar)) {
            this.jIj.put(aiVar, this.jHO.k(this.jHO.l(aiVar)));
        }
        return this.jIj.get(aiVar);
    }

    private synchronized ai<Void> v(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.jIk.containsKey(aiVar)) {
            l lVar = this.jHO;
            this.jIk.put(aiVar, l.m(aiVar));
        }
        return this.jIk.get(aiVar);
    }

    private static String I(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
