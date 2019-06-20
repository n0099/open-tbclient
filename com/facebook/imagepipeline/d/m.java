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
    private final af jZI;
    private final boolean jZN;
    private final boolean jZV;
    private final ar jZu;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaA;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaB;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaC;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaD;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaE;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaF;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> kaG = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> kaH = new HashMap();
    private final l kal;
    private final boolean kat;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kau;
    ai<com.facebook.imagepipeline.f.d> kav;
    ai<com.facebook.imagepipeline.f.d> kaw;
    ai<Void> kax;
    ai<Void> kay;
    private ai<com.facebook.imagepipeline.f.d> kaz;

    public m(l lVar, af afVar, boolean z, boolean z2, ar arVar, boolean z3) {
        this.kal = lVar;
        this.jZI = afVar;
        this.jZN = z;
        this.jZV = z2;
        this.jZu = arVar;
        this.kat = z3;
    }

    public ai<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.cIl()) {
            case 0:
                return cGh();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + O(imageRequest.cIk()));
            case 2:
            case 3:
                return cGj();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.cHz().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g = g(imageRequest);
        if (imageRequest.cIu() != null) {
            return u(g);
        }
        return g;
    }

    public ai<Void> f(ImageRequest imageRequest) {
        return v(g(imageRequest));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri cIk = imageRequest.cIk();
        com.facebook.common.internal.g.checkNotNull(cIk, "Uri is null.");
        switch (imageRequest.cIl()) {
            case 0:
                return cGf();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + O(cIk));
            case 2:
                return cGm();
            case 3:
                return cGl();
            case 4:
                return cGn();
            case 5:
                return cGp();
            case 6:
                return cGo();
            case 7:
                return cGq();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGf() {
        if (this.kau == null) {
            this.kau = q(cGi());
        }
        return this.kau;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cGg() {
        if (this.kaw == null) {
            this.kaw = this.kal.a(cGi(), this.jZu);
        }
        return this.kaw;
    }

    private synchronized ai<Void> cGh() {
        if (this.kay == null) {
            this.kay = l.m(cGg());
        }
        return this.kay;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cGi() {
        if (this.kaz == null) {
            this.kaz = l.a(r(this.kal.a(this.jZI)));
            this.kaz = this.kal.a(this.kaz, this.jZN, this.kat);
        }
        return this.kaz;
    }

    private synchronized ai<Void> cGj() {
        if (this.kax == null) {
            this.kax = l.m(cGk());
        }
        return this.kax;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cGk() {
        if (this.kav == null) {
            this.kav = this.kal.a(r(this.kal.cGc()), this.jZu);
        }
        return this.kav;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGl() {
        if (this.kaA == null) {
            this.kaA = p(this.kal.cGc());
        }
        return this.kaA;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGm() {
        if (this.kaB == null) {
            this.kaB = t(this.kal.cGe());
        }
        return this.kaB;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGn() {
        if (this.kaC == null) {
            this.kaC = a(this.kal.cFZ(), new au[]{this.kal.cGa(), this.kal.cGb()});
        }
        return this.kaC;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGo() {
        if (this.kaD == null) {
            this.kaD = p(this.kal.cGd());
        }
        return this.kaD;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGp() {
        if (this.kaE == null) {
            this.kaE = p(this.kal.cFY());
        }
        return this.kaE;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGq() {
        if (this.kaF == null) {
            ai<com.facebook.imagepipeline.f.d> cFX = this.kal.cFX();
            if (com.facebook.common.g.c.jTd && (!this.jZV || com.facebook.common.g.c.jTg == null)) {
                cFX = this.kal.o(cFX);
            }
            l lVar = this.kal;
            this.kaF = q(this.kal.a(l.a(cFX), true, this.kat));
        }
        return this.kaF;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new au[]{this.kal.cGb()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return q(b(r(aiVar), auVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return t(this.kal.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.jTd && (!this.jZV || com.facebook.common.g.c.jTg == null)) {
            aiVar = this.kal.o(aiVar);
        }
        return this.kal.i(this.kal.j(s(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> s(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.kal.f(this.kal.h(this.kal.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.kal.b(this.kal.a(this.kal.c(this.kal.d(aiVar)), this.jZu));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        as n = this.kal.n(this.kal.a(l.a(aiVar), true, this.kat));
        l lVar = this.kal;
        return l.a(b(auVarArr), n);
    }

    private ai<com.facebook.imagepipeline.f.d> b(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return this.kal.a(this.kal.a(auVarArr), true, this.kat);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> u(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.kaG.containsKey(aiVar)) {
            this.kaG.put(aiVar, this.kal.k(this.kal.l(aiVar)));
        }
        return this.kaG.get(aiVar);
    }

    private synchronized ai<Void> v(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.kaH.containsKey(aiVar)) {
            l lVar = this.kal;
            this.kaH.put(aiVar, l.m(aiVar));
        }
        return this.kaH.get(aiVar);
    }

    private static String O(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
