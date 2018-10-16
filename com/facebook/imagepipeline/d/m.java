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
    private final boolean ieD;
    private final l ieT;
    private final aq iec;
    private final af ieq;
    private final boolean iev;
    private final boolean ifc;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ifd;
    private ai<com.facebook.imagepipeline.f.d> ife;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> iff;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ifg;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ifh;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ifi;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ifj;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ifk;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> ifl = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> ifm = new HashMap();

    public m(l lVar, af afVar, boolean z, boolean z2, aq aqVar, boolean z3) {
        this.ieT = lVar;
        this.ieq = afVar;
        this.iev = z;
        this.ieD = z2;
        this.iec = aqVar;
        this.ifc = z3;
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> c(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d = d(imageRequest);
        if (imageRequest.bYn() != null) {
            return t(d);
        }
        return d;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri bYd = imageRequest.bYd();
        com.facebook.common.internal.g.checkNotNull(bYd, "Uri is null.");
        switch (imageRequest.bYe()) {
            case 0:
                return bWc();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + z(bYd));
            case 2:
                return bWf();
            case 3:
                return bWe();
            case 4:
                return bWg();
            case 5:
                return bWi();
            case 6:
                return bWh();
            case 7:
                return bWj();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWc() {
        if (this.ifd == null) {
            this.ifd = p(bWd());
        }
        return this.ifd;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> bWd() {
        if (this.ife == null) {
            this.ife = l.a(q(this.ieT.a(this.ieq)));
            this.ife = this.ieT.a(this.ife, this.iev, this.ifc);
        }
        return this.ife;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWe() {
        if (this.iff == null) {
            this.iff = o(this.ieT.bVZ());
        }
        return this.iff;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWf() {
        if (this.ifg == null) {
            this.ifg = s(this.ieT.bWb());
        }
        return this.ifg;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWg() {
        if (this.ifh == null) {
            this.ifh = a(this.ieT.bVW(), new at[]{this.ieT.bVX(), this.ieT.bVY()});
        }
        return this.ifh;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWh() {
        if (this.ifi == null) {
            this.ifi = o(this.ieT.bWa());
        }
        return this.ifi;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWi() {
        if (this.ifj == null) {
            this.ifj = o(this.ieT.bVV());
        }
        return this.ifj;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWj() {
        if (this.ifk == null) {
            ai<com.facebook.imagepipeline.f.d> bVU = this.ieT.bVU();
            if (com.facebook.common.g.c.hXM && (!this.ieD || com.facebook.common.g.c.hXP == null)) {
                bVU = this.ieT.n(bVU);
            }
            l lVar = this.ieT;
            this.ifk = p(this.ieT.a(l.a(bVU), true, this.ifc));
        }
        return this.ifk;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new at[]{this.ieT.bVY()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return p(b(q(aiVar), atVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return s(this.ieT.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.hXM && (!this.ieD || com.facebook.common.g.c.hXP == null)) {
            aiVar = this.ieT.n(aiVar);
        }
        return this.ieT.i(this.ieT.j(r(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.ieT.f(this.ieT.h(this.ieT.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> s(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.ieT.b(this.ieT.a(this.ieT.c(this.ieT.d(aiVar)), this.iec));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        ar m = this.ieT.m(this.ieT.a(l.a(aiVar), true, this.ifc));
        l lVar = this.ieT;
        return l.a(b(atVarArr), m);
    }

    private ai<com.facebook.imagepipeline.f.d> b(at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return this.ieT.a(this.ieT.a(atVarArr), true, this.ifc);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.ifl.containsKey(aiVar)) {
            this.ifl.put(aiVar, this.ieT.k(this.ieT.l(aiVar)));
        }
        return this.ifl.get(aiVar);
    }

    private static String z(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
