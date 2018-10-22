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
    private final boolean ieE;
    private final l ieU;
    private final aq ied;
    private final af ier;
    private final boolean iew;
    private final boolean ifd;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ife;
    private ai<com.facebook.imagepipeline.f.d> iff;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ifg;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ifh;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ifi;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ifj;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ifk;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ifl;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> ifm = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> ifn = new HashMap();

    public m(l lVar, af afVar, boolean z, boolean z2, aq aqVar, boolean z3) {
        this.ieU = lVar;
        this.ier = afVar;
        this.iew = z;
        this.ieE = z2;
        this.ied = aqVar;
        this.ifd = z3;
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
        if (this.ife == null) {
            this.ife = p(bWd());
        }
        return this.ife;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> bWd() {
        if (this.iff == null) {
            this.iff = l.a(q(this.ieU.a(this.ier)));
            this.iff = this.ieU.a(this.iff, this.iew, this.ifd);
        }
        return this.iff;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWe() {
        if (this.ifg == null) {
            this.ifg = o(this.ieU.bVZ());
        }
        return this.ifg;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWf() {
        if (this.ifh == null) {
            this.ifh = s(this.ieU.bWb());
        }
        return this.ifh;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWg() {
        if (this.ifi == null) {
            this.ifi = a(this.ieU.bVW(), new at[]{this.ieU.bVX(), this.ieU.bVY()});
        }
        return this.ifi;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWh() {
        if (this.ifj == null) {
            this.ifj = o(this.ieU.bWa());
        }
        return this.ifj;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWi() {
        if (this.ifk == null) {
            this.ifk = o(this.ieU.bVV());
        }
        return this.ifk;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWj() {
        if (this.ifl == null) {
            ai<com.facebook.imagepipeline.f.d> bVU = this.ieU.bVU();
            if (com.facebook.common.g.c.hXN && (!this.ieE || com.facebook.common.g.c.hXQ == null)) {
                bVU = this.ieU.n(bVU);
            }
            l lVar = this.ieU;
            this.ifl = p(this.ieU.a(l.a(bVU), true, this.ifd));
        }
        return this.ifl;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new at[]{this.ieU.bVY()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return p(b(q(aiVar), atVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return s(this.ieU.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.hXN && (!this.ieE || com.facebook.common.g.c.hXQ == null)) {
            aiVar = this.ieU.n(aiVar);
        }
        return this.ieU.i(this.ieU.j(r(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.ieU.f(this.ieU.h(this.ieU.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> s(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.ieU.b(this.ieU.a(this.ieU.c(this.ieU.d(aiVar)), this.ied));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        ar m = this.ieU.m(this.ieU.a(l.a(aiVar), true, this.ifd));
        l lVar = this.ieU;
        return l.a(b(atVarArr), m);
    }

    private ai<com.facebook.imagepipeline.f.d> b(at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return this.ieU.a(this.ieU.a(atVarArr), true, this.ifd);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.ifm.containsKey(aiVar)) {
            this.ifm.put(aiVar, this.ieU.k(this.ieU.l(aiVar)));
        }
        return this.ifm.get(aiVar);
    }

    private static String z(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
