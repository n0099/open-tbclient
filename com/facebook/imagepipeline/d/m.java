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
    private final af irF;
    private final boolean irK;
    private final boolean irS;
    private final aq irr;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> isA = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> isB = new HashMap();
    private final l isi;
    private final boolean isr;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> iss;
    private ai<com.facebook.imagepipeline.f.d> ist;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isu;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isv;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isw;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isx;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isy;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isz;

    public m(l lVar, af afVar, boolean z, boolean z2, aq aqVar, boolean z3) {
        this.isi = lVar;
        this.irF = afVar;
        this.irK = z;
        this.irS = z2;
        this.irr = aqVar;
        this.isr = z3;
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
        if (this.iss == null) {
            this.iss = p(bZc());
        }
        return this.iss;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> bZc() {
        if (this.ist == null) {
            this.ist = l.a(q(this.isi.a(this.irF)));
            this.ist = this.isi.a(this.ist, this.irK, this.isr);
        }
        return this.ist;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZd() {
        if (this.isu == null) {
            this.isu = o(this.isi.bYY());
        }
        return this.isu;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZe() {
        if (this.isv == null) {
            this.isv = s(this.isi.bZa());
        }
        return this.isv;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZf() {
        if (this.isw == null) {
            this.isw = a(this.isi.bYV(), new at[]{this.isi.bYW(), this.isi.bYX()});
        }
        return this.isw;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZg() {
        if (this.isx == null) {
            this.isx = o(this.isi.bYZ());
        }
        return this.isx;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZh() {
        if (this.isy == null) {
            this.isy = o(this.isi.bYU());
        }
        return this.isy;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZi() {
        if (this.isz == null) {
            ai<com.facebook.imagepipeline.f.d> bYT = this.isi.bYT();
            if (com.facebook.common.g.c.ilc && (!this.irS || com.facebook.common.g.c.ilf == null)) {
                bYT = this.isi.n(bYT);
            }
            l lVar = this.isi;
            this.isz = p(this.isi.a(l.a(bYT), true, this.isr));
        }
        return this.isz;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new at[]{this.isi.bYX()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return p(b(q(aiVar), atVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return s(this.isi.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.ilc && (!this.irS || com.facebook.common.g.c.ilf == null)) {
            aiVar = this.isi.n(aiVar);
        }
        return this.isi.i(this.isi.j(r(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.isi.f(this.isi.h(this.isi.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> s(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.isi.b(this.isi.a(this.isi.c(this.isi.d(aiVar)), this.irr));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        ar m = this.isi.m(this.isi.a(l.a(aiVar), true, this.isr));
        l lVar = this.isi;
        return l.a(b(atVarArr), m);
    }

    private ai<com.facebook.imagepipeline.f.d> b(at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return this.isi.a(this.isi.a(atVarArr), true, this.isr);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.isA.containsKey(aiVar)) {
            this.isA.put(aiVar, this.isi.k(this.isi.l(aiVar)));
        }
        return this.isA.get(aiVar);
    }

    private static String A(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
