package com.facebook.imagepipeline.d;

import android.net.Uri;
import com.baidu.live.tbadk.core.util.StringHelper;
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
    private final af khM;
    private final boolean khR;
    private final boolean khZ;
    private final ar khy;
    ai<com.facebook.imagepipeline.f.d> kiA;
    ai<com.facebook.imagepipeline.f.d> kiB;
    ai<Void> kiC;
    ai<Void> kiD;
    private ai<com.facebook.imagepipeline.f.d> kiE;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kiF;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kiG;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kiH;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kiI;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kiJ;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kiK;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> kiL = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> kiM = new HashMap();
    private final l kiq;
    private final boolean kiy;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kiz;

    public m(l lVar, af afVar, boolean z, boolean z2, ar arVar, boolean z3) {
        this.kiq = lVar;
        this.khM = afVar;
        this.khR = z;
        this.khZ = z2;
        this.khy = arVar;
        this.kiy = z3;
    }

    public ai<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.cJt()) {
            case 0:
                return cHo();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + L(imageRequest.cJs()));
            case 2:
            case 3:
                return cHq();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.cIH().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g = g(imageRequest);
        if (imageRequest.cJC() != null) {
            return u(g);
        }
        return g;
    }

    public ai<Void> f(ImageRequest imageRequest) {
        return v(g(imageRequest));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri cJs = imageRequest.cJs();
        com.facebook.common.internal.g.checkNotNull(cJs, "Uri is null.");
        switch (imageRequest.cJt()) {
            case 0:
                return cHm();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + L(cJs));
            case 2:
                return cHt();
            case 3:
                return cHs();
            case 4:
                return cHu();
            case 5:
                return cHw();
            case 6:
                return cHv();
            case 7:
                return cHx();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHm() {
        if (this.kiz == null) {
            this.kiz = q(cHp());
        }
        return this.kiz;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cHn() {
        if (this.kiB == null) {
            this.kiB = this.kiq.a(cHp(), this.khy);
        }
        return this.kiB;
    }

    private synchronized ai<Void> cHo() {
        if (this.kiD == null) {
            this.kiD = l.m(cHn());
        }
        return this.kiD;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cHp() {
        if (this.kiE == null) {
            this.kiE = l.a(r(this.kiq.a(this.khM)));
            this.kiE = this.kiq.a(this.kiE, this.khR, this.kiy);
        }
        return this.kiE;
    }

    private synchronized ai<Void> cHq() {
        if (this.kiC == null) {
            this.kiC = l.m(cHr());
        }
        return this.kiC;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cHr() {
        if (this.kiA == null) {
            this.kiA = this.kiq.a(r(this.kiq.cHj()), this.khy);
        }
        return this.kiA;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHs() {
        if (this.kiF == null) {
            this.kiF = p(this.kiq.cHj());
        }
        return this.kiF;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHt() {
        if (this.kiG == null) {
            this.kiG = t(this.kiq.cHl());
        }
        return this.kiG;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHu() {
        if (this.kiH == null) {
            this.kiH = a(this.kiq.cHg(), new au[]{this.kiq.cHh(), this.kiq.cHi()});
        }
        return this.kiH;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHv() {
        if (this.kiI == null) {
            this.kiI = p(this.kiq.cHk());
        }
        return this.kiI;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHw() {
        if (this.kiJ == null) {
            this.kiJ = p(this.kiq.cHf());
        }
        return this.kiJ;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHx() {
        if (this.kiK == null) {
            ai<com.facebook.imagepipeline.f.d> cHe = this.kiq.cHe();
            if (com.facebook.common.g.c.kbc && (!this.khZ || com.facebook.common.g.c.kbf == null)) {
                cHe = this.kiq.o(cHe);
            }
            l lVar = this.kiq;
            this.kiK = q(this.kiq.a(l.a(cHe), true, this.kiy));
        }
        return this.kiK;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new au[]{this.kiq.cHi()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return q(b(r(aiVar), auVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return t(this.kiq.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.kbc && (!this.khZ || com.facebook.common.g.c.kbf == null)) {
            aiVar = this.kiq.o(aiVar);
        }
        return this.kiq.i(this.kiq.j(s(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> s(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.kiq.f(this.kiq.h(this.kiq.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.kiq.b(this.kiq.a(this.kiq.c(this.kiq.d(aiVar)), this.khy));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        as n = this.kiq.n(this.kiq.a(l.a(aiVar), true, this.kiy));
        l lVar = this.kiq;
        return l.a(b(auVarArr), n);
    }

    private ai<com.facebook.imagepipeline.f.d> b(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return this.kiq.a(this.kiq.a(auVarArr), true, this.kiy);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> u(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.kiL.containsKey(aiVar)) {
            this.kiL.put(aiVar, this.kiq.k(this.kiq.l(aiVar)));
        }
        return this.kiL.get(aiVar);
    }

    private synchronized ai<Void> v(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.kiM.containsKey(aiVar)) {
            l lVar = this.kiq;
            this.kiM.put(aiVar, l.m(aiVar));
        }
        return this.kiM.get(aiVar);
    }

    private static String L(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
