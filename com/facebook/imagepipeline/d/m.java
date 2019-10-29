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
    private final af kiE;
    private final boolean kiJ;
    private final boolean kiR;
    private final ar kiq;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kjA;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kjB;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> kjC = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> kjD = new HashMap();
    private final l kjh;
    private final boolean kjp;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kjq;
    ai<com.facebook.imagepipeline.f.d> kjr;
    ai<com.facebook.imagepipeline.f.d> kjs;
    ai<Void> kjt;
    ai<Void> kju;
    private ai<com.facebook.imagepipeline.f.d> kjv;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kjw;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kjx;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kjy;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kjz;

    public m(l lVar, af afVar, boolean z, boolean z2, ar arVar, boolean z3) {
        this.kjh = lVar;
        this.kiE = afVar;
        this.kiJ = z;
        this.kiR = z2;
        this.kiq = arVar;
        this.kjp = z3;
    }

    public ai<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.cJv()) {
            case 0:
                return cHq();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + L(imageRequest.cJu()));
            case 2:
            case 3:
                return cHs();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.cIJ().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g = g(imageRequest);
        if (imageRequest.cJE() != null) {
            return u(g);
        }
        return g;
    }

    public ai<Void> f(ImageRequest imageRequest) {
        return v(g(imageRequest));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri cJu = imageRequest.cJu();
        com.facebook.common.internal.g.checkNotNull(cJu, "Uri is null.");
        switch (imageRequest.cJv()) {
            case 0:
                return cHo();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + L(cJu));
            case 2:
                return cHv();
            case 3:
                return cHu();
            case 4:
                return cHw();
            case 5:
                return cHy();
            case 6:
                return cHx();
            case 7:
                return cHz();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHo() {
        if (this.kjq == null) {
            this.kjq = q(cHr());
        }
        return this.kjq;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cHp() {
        if (this.kjs == null) {
            this.kjs = this.kjh.a(cHr(), this.kiq);
        }
        return this.kjs;
    }

    private synchronized ai<Void> cHq() {
        if (this.kju == null) {
            this.kju = l.m(cHp());
        }
        return this.kju;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cHr() {
        if (this.kjv == null) {
            this.kjv = l.a(r(this.kjh.a(this.kiE)));
            this.kjv = this.kjh.a(this.kjv, this.kiJ, this.kjp);
        }
        return this.kjv;
    }

    private synchronized ai<Void> cHs() {
        if (this.kjt == null) {
            this.kjt = l.m(cHt());
        }
        return this.kjt;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cHt() {
        if (this.kjr == null) {
            this.kjr = this.kjh.a(r(this.kjh.cHl()), this.kiq);
        }
        return this.kjr;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHu() {
        if (this.kjw == null) {
            this.kjw = p(this.kjh.cHl());
        }
        return this.kjw;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHv() {
        if (this.kjx == null) {
            this.kjx = t(this.kjh.cHn());
        }
        return this.kjx;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHw() {
        if (this.kjy == null) {
            this.kjy = a(this.kjh.cHi(), new au[]{this.kjh.cHj(), this.kjh.cHk()});
        }
        return this.kjy;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHx() {
        if (this.kjz == null) {
            this.kjz = p(this.kjh.cHm());
        }
        return this.kjz;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHy() {
        if (this.kjA == null) {
            this.kjA = p(this.kjh.cHh());
        }
        return this.kjA;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHz() {
        if (this.kjB == null) {
            ai<com.facebook.imagepipeline.f.d> cHg = this.kjh.cHg();
            if (com.facebook.common.g.c.kbT && (!this.kiR || com.facebook.common.g.c.kbW == null)) {
                cHg = this.kjh.o(cHg);
            }
            l lVar = this.kjh;
            this.kjB = q(this.kjh.a(l.a(cHg), true, this.kjp));
        }
        return this.kjB;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new au[]{this.kjh.cHk()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return q(b(r(aiVar), auVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return t(this.kjh.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.kbT && (!this.kiR || com.facebook.common.g.c.kbW == null)) {
            aiVar = this.kjh.o(aiVar);
        }
        return this.kjh.i(this.kjh.j(s(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> s(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.kjh.f(this.kjh.h(this.kjh.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.kjh.b(this.kjh.a(this.kjh.c(this.kjh.d(aiVar)), this.kiq));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        as n = this.kjh.n(this.kjh.a(l.a(aiVar), true, this.kjp));
        l lVar = this.kjh;
        return l.a(b(auVarArr), n);
    }

    private ai<com.facebook.imagepipeline.f.d> b(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return this.kjh.a(this.kjh.a(auVarArr), true, this.kjp);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> u(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.kjC.containsKey(aiVar)) {
            this.kjC.put(aiVar, this.kjh.k(this.kjh.l(aiVar)));
        }
        return this.kjC.get(aiVar);
    }

    private synchronized ai<Void> v(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.kjD.containsKey(aiVar)) {
            l lVar = this.kjh;
            this.kjD.put(aiVar, l.m(aiVar));
        }
        return this.kjD.get(aiVar);
    }

    private static String L(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
