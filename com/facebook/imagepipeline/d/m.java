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
    private final af irE;
    private final boolean irJ;
    private final boolean irR;
    private final aq irq;
    private final l ish;
    private final boolean isq;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isr;
    private ai<com.facebook.imagepipeline.f.d> iss;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ist;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isu;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isv;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isw;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isx;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isy;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> isz = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> isA = new HashMap();

    public m(l lVar, af afVar, boolean z, boolean z2, aq aqVar, boolean z3) {
        this.ish = lVar;
        this.irE = afVar;
        this.irJ = z;
        this.irR = z2;
        this.irq = aqVar;
        this.isq = z3;
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> c(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d = d(imageRequest);
        if (imageRequest.cbm() != null) {
            return t(d);
        }
        return d;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri cbc = imageRequest.cbc();
        com.facebook.common.internal.g.checkNotNull(cbc, "Uri is null.");
        switch (imageRequest.cbd()) {
            case 0:
                return bZb();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + A(cbc));
            case 2:
                return bZe();
            case 3:
                return bZd();
            case 4:
                return bZf();
            case 5:
                return bZh();
            case 6:
                return bZg();
            case 7:
                return bZi();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZb() {
        if (this.isr == null) {
            this.isr = p(bZc());
        }
        return this.isr;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> bZc() {
        if (this.iss == null) {
            this.iss = l.a(q(this.ish.a(this.irE)));
            this.iss = this.ish.a(this.iss, this.irJ, this.isq);
        }
        return this.iss;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZd() {
        if (this.ist == null) {
            this.ist = o(this.ish.bYY());
        }
        return this.ist;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZe() {
        if (this.isu == null) {
            this.isu = s(this.ish.bZa());
        }
        return this.isu;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZf() {
        if (this.isv == null) {
            this.isv = a(this.ish.bYV(), new at[]{this.ish.bYW(), this.ish.bYX()});
        }
        return this.isv;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZg() {
        if (this.isw == null) {
            this.isw = o(this.ish.bYZ());
        }
        return this.isw;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZh() {
        if (this.isx == null) {
            this.isx = o(this.ish.bYU());
        }
        return this.isx;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZi() {
        if (this.isy == null) {
            ai<com.facebook.imagepipeline.f.d> bYT = this.ish.bYT();
            if (com.facebook.common.g.c.ilb && (!this.irR || com.facebook.common.g.c.ile == null)) {
                bYT = this.ish.n(bYT);
            }
            l lVar = this.ish;
            this.isy = p(this.ish.a(l.a(bYT), true, this.isq));
        }
        return this.isy;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new at[]{this.ish.bYX()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return p(b(q(aiVar), atVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return s(this.ish.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.ilb && (!this.irR || com.facebook.common.g.c.ile == null)) {
            aiVar = this.ish.n(aiVar);
        }
        return this.ish.i(this.ish.j(r(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.ish.f(this.ish.h(this.ish.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> s(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.ish.b(this.ish.a(this.ish.c(this.ish.d(aiVar)), this.irq));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        ar m = this.ish.m(this.ish.a(l.a(aiVar), true, this.isq));
        l lVar = this.ish;
        return l.a(b(atVarArr), m);
    }

    private ai<com.facebook.imagepipeline.f.d> b(at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return this.ish.a(this.ish.a(atVarArr), true, this.isq);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.isz.containsKey(aiVar)) {
            this.isz.put(aiVar, this.ish.k(this.ish.l(aiVar)));
        }
        return this.isz.get(aiVar);
    }

    private static String A(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
