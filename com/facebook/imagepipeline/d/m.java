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
    private final boolean iqC;
    private final boolean iqK;
    private final aq iqj;
    private final af iqx;
    private final l ira;
    private final boolean irj;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> irk;
    private ai<com.facebook.imagepipeline.f.d> irl;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> irm;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> irn;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> iro;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> irp;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> irq;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> irr;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> irs = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> irt = new HashMap();

    public m(l lVar, af afVar, boolean z, boolean z2, aq aqVar, boolean z3) {
        this.ira = lVar;
        this.iqx = afVar;
        this.iqC = z;
        this.iqK = z2;
        this.iqj = aqVar;
        this.irj = z3;
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> c(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d = d(imageRequest);
        if (imageRequest.caE() != null) {
            return t(d);
        }
        return d;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri cau = imageRequest.cau();
        com.facebook.common.internal.g.checkNotNull(cau, "Uri is null.");
        switch (imageRequest.cav()) {
            case 0:
                return bYt();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + A(cau));
            case 2:
                return bYw();
            case 3:
                return bYv();
            case 4:
                return bYx();
            case 5:
                return bYz();
            case 6:
                return bYy();
            case 7:
                return bYA();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bYt() {
        if (this.irk == null) {
            this.irk = p(bYu());
        }
        return this.irk;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> bYu() {
        if (this.irl == null) {
            this.irl = l.a(q(this.ira.a(this.iqx)));
            this.irl = this.ira.a(this.irl, this.iqC, this.irj);
        }
        return this.irl;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bYv() {
        if (this.irm == null) {
            this.irm = o(this.ira.bYq());
        }
        return this.irm;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bYw() {
        if (this.irn == null) {
            this.irn = s(this.ira.bYs());
        }
        return this.irn;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bYx() {
        if (this.iro == null) {
            this.iro = a(this.ira.bYn(), new at[]{this.ira.bYo(), this.ira.bYp()});
        }
        return this.iro;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bYy() {
        if (this.irp == null) {
            this.irp = o(this.ira.bYr());
        }
        return this.irp;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bYz() {
        if (this.irq == null) {
            this.irq = o(this.ira.bYm());
        }
        return this.irq;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bYA() {
        if (this.irr == null) {
            ai<com.facebook.imagepipeline.f.d> bYl = this.ira.bYl();
            if (com.facebook.common.g.c.ijU && (!this.iqK || com.facebook.common.g.c.ijX == null)) {
                bYl = this.ira.n(bYl);
            }
            l lVar = this.ira;
            this.irr = p(this.ira.a(l.a(bYl), true, this.irj));
        }
        return this.irr;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> o(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new at[]{this.ira.bYp()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return p(b(q(aiVar), atVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return s(this.ira.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.ijU && (!this.iqK || com.facebook.common.g.c.ijX == null)) {
            aiVar = this.ira.n(aiVar);
        }
        return this.ira.i(this.ira.j(r(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.ira.f(this.ira.h(this.ira.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> s(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.ira.b(this.ira.a(this.ira.c(this.ira.d(aiVar)), this.iqj));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        ar m = this.ira.m(this.ira.a(l.a(aiVar), true, this.irj));
        l lVar = this.ira;
        return l.a(b(atVarArr), m);
    }

    private ai<com.facebook.imagepipeline.f.d> b(at<com.facebook.imagepipeline.f.d>[] atVarArr) {
        return this.ira.a(this.ira.a(atVarArr), true, this.irj);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.irs.containsKey(aiVar)) {
            this.irs.put(aiVar, this.ira.k(this.ira.l(aiVar)));
        }
        return this.irs.get(aiVar);
    }

    private static String A(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
