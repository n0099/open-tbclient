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
    private final ar kgA;
    private final af kgO;
    private final boolean kgT;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> khA;
    ai<com.facebook.imagepipeline.f.d> khB;
    ai<com.facebook.imagepipeline.f.d> khC;
    ai<Void> khD;
    ai<Void> khE;
    private ai<com.facebook.imagepipeline.f.d> khF;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> khG;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> khH;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> khI;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> khJ;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> khK;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> khL;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> khM = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> khN = new HashMap();
    private final boolean khb;
    private final l khr;
    private final boolean khz;

    public m(l lVar, af afVar, boolean z, boolean z2, ar arVar, boolean z3) {
        this.khr = lVar;
        this.kgO = afVar;
        this.kgT = z;
        this.khb = z2;
        this.kgA = arVar;
        this.khz = z3;
    }

    public ai<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.cLp()) {
            case 0:
                return cJk();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + O(imageRequest.cLo()));
            case 2:
            case 3:
                return cJm();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.cKD().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g = g(imageRequest);
        if (imageRequest.cLy() != null) {
            return u(g);
        }
        return g;
    }

    public ai<Void> f(ImageRequest imageRequest) {
        return v(g(imageRequest));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri cLo = imageRequest.cLo();
        com.facebook.common.internal.g.checkNotNull(cLo, "Uri is null.");
        switch (imageRequest.cLp()) {
            case 0:
                return cJi();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + O(cLo));
            case 2:
                return cJp();
            case 3:
                return cJo();
            case 4:
                return cJq();
            case 5:
                return cJs();
            case 6:
                return cJr();
            case 7:
                return cJt();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cJi() {
        if (this.khA == null) {
            this.khA = q(cJl());
        }
        return this.khA;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cJj() {
        if (this.khC == null) {
            this.khC = this.khr.a(cJl(), this.kgA);
        }
        return this.khC;
    }

    private synchronized ai<Void> cJk() {
        if (this.khE == null) {
            this.khE = l.m(cJj());
        }
        return this.khE;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cJl() {
        if (this.khF == null) {
            this.khF = l.a(r(this.khr.a(this.kgO)));
            this.khF = this.khr.a(this.khF, this.kgT, this.khz);
        }
        return this.khF;
    }

    private synchronized ai<Void> cJm() {
        if (this.khD == null) {
            this.khD = l.m(cJn());
        }
        return this.khD;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cJn() {
        if (this.khB == null) {
            this.khB = this.khr.a(r(this.khr.cJf()), this.kgA);
        }
        return this.khB;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cJo() {
        if (this.khG == null) {
            this.khG = p(this.khr.cJf());
        }
        return this.khG;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cJp() {
        if (this.khH == null) {
            this.khH = t(this.khr.cJh());
        }
        return this.khH;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cJq() {
        if (this.khI == null) {
            this.khI = a(this.khr.cJc(), new au[]{this.khr.cJd(), this.khr.cJe()});
        }
        return this.khI;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cJr() {
        if (this.khJ == null) {
            this.khJ = p(this.khr.cJg());
        }
        return this.khJ;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cJs() {
        if (this.khK == null) {
            this.khK = p(this.khr.cJb());
        }
        return this.khK;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cJt() {
        if (this.khL == null) {
            ai<com.facebook.imagepipeline.f.d> cJa = this.khr.cJa();
            if (com.facebook.common.g.c.kah && (!this.khb || com.facebook.common.g.c.kak == null)) {
                cJa = this.khr.o(cJa);
            }
            l lVar = this.khr;
            this.khL = q(this.khr.a(l.a(cJa), true, this.khz));
        }
        return this.khL;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new au[]{this.khr.cJe()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return q(b(r(aiVar), auVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return t(this.khr.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.kah && (!this.khb || com.facebook.common.g.c.kak == null)) {
            aiVar = this.khr.o(aiVar);
        }
        return this.khr.i(this.khr.j(s(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> s(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.khr.f(this.khr.h(this.khr.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.khr.b(this.khr.a(this.khr.c(this.khr.d(aiVar)), this.kgA));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        as n = this.khr.n(this.khr.a(l.a(aiVar), true, this.khz));
        l lVar = this.khr;
        return l.a(b(auVarArr), n);
    }

    private ai<com.facebook.imagepipeline.f.d> b(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return this.khr.a(this.khr.a(auVarArr), true, this.khz);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> u(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.khM.containsKey(aiVar)) {
            this.khM.put(aiVar, this.khr.k(this.khr.l(aiVar)));
        }
        return this.khM.get(aiVar);
    }

    private synchronized ai<Void> v(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.khN.containsKey(aiVar)) {
            l lVar = this.khr;
            this.khN.put(aiVar, l.m(aiVar));
        }
        return this.khN.get(aiVar);
    }

    private static String O(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
