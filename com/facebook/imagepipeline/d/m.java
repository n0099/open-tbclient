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
    private final af jZF;
    private final boolean jZK;
    private final boolean jZS;
    private final ar jZr;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaA;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaB;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaC;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> kaD = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> kaE = new HashMap();
    private final l kai;
    private final boolean kaq;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kar;
    ai<com.facebook.imagepipeline.f.d> kas;
    ai<com.facebook.imagepipeline.f.d> kat;
    ai<Void> kau;
    ai<Void> kav;
    private ai<com.facebook.imagepipeline.f.d> kaw;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kax;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kay;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaz;

    public m(l lVar, af afVar, boolean z, boolean z2, ar arVar, boolean z3) {
        this.kai = lVar;
        this.jZF = afVar;
        this.jZK = z;
        this.jZS = z2;
        this.jZr = arVar;
        this.kaq = z3;
    }

    public ai<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.cIm()) {
            case 0:
                return cGi();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + O(imageRequest.cIl()));
            case 2:
            case 3:
                return cGk();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.cHA().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g = g(imageRequest);
        if (imageRequest.cIv() != null) {
            return u(g);
        }
        return g;
    }

    public ai<Void> f(ImageRequest imageRequest) {
        return v(g(imageRequest));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri cIl = imageRequest.cIl();
        com.facebook.common.internal.g.checkNotNull(cIl, "Uri is null.");
        switch (imageRequest.cIm()) {
            case 0:
                return cGg();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + O(cIl));
            case 2:
                return cGn();
            case 3:
                return cGm();
            case 4:
                return cGo();
            case 5:
                return cGq();
            case 6:
                return cGp();
            case 7:
                return cGr();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGg() {
        if (this.kar == null) {
            this.kar = q(cGj());
        }
        return this.kar;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cGh() {
        if (this.kat == null) {
            this.kat = this.kai.a(cGj(), this.jZr);
        }
        return this.kat;
    }

    private synchronized ai<Void> cGi() {
        if (this.kav == null) {
            this.kav = l.m(cGh());
        }
        return this.kav;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cGj() {
        if (this.kaw == null) {
            this.kaw = l.a(r(this.kai.a(this.jZF)));
            this.kaw = this.kai.a(this.kaw, this.jZK, this.kaq);
        }
        return this.kaw;
    }

    private synchronized ai<Void> cGk() {
        if (this.kau == null) {
            this.kau = l.m(cGl());
        }
        return this.kau;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cGl() {
        if (this.kas == null) {
            this.kas = this.kai.a(r(this.kai.cGd()), this.jZr);
        }
        return this.kas;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGm() {
        if (this.kax == null) {
            this.kax = p(this.kai.cGd());
        }
        return this.kax;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGn() {
        if (this.kay == null) {
            this.kay = t(this.kai.cGf());
        }
        return this.kay;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGo() {
        if (this.kaz == null) {
            this.kaz = a(this.kai.cGa(), new au[]{this.kai.cGb(), this.kai.cGc()});
        }
        return this.kaz;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGp() {
        if (this.kaA == null) {
            this.kaA = p(this.kai.cGe());
        }
        return this.kaA;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGq() {
        if (this.kaB == null) {
            this.kaB = p(this.kai.cFZ());
        }
        return this.kaB;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGr() {
        if (this.kaC == null) {
            ai<com.facebook.imagepipeline.f.d> cFY = this.kai.cFY();
            if (com.facebook.common.g.c.jTa && (!this.jZS || com.facebook.common.g.c.jTd == null)) {
                cFY = this.kai.o(cFY);
            }
            l lVar = this.kai;
            this.kaC = q(this.kai.a(l.a(cFY), true, this.kaq));
        }
        return this.kaC;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new au[]{this.kai.cGc()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return q(b(r(aiVar), auVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return t(this.kai.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.jTa && (!this.jZS || com.facebook.common.g.c.jTd == null)) {
            aiVar = this.kai.o(aiVar);
        }
        return this.kai.i(this.kai.j(s(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> s(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.kai.f(this.kai.h(this.kai.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.kai.b(this.kai.a(this.kai.c(this.kai.d(aiVar)), this.jZr));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        as n = this.kai.n(this.kai.a(l.a(aiVar), true, this.kaq));
        l lVar = this.kai;
        return l.a(b(auVarArr), n);
    }

    private ai<com.facebook.imagepipeline.f.d> b(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return this.kai.a(this.kai.a(auVarArr), true, this.kaq);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> u(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.kaD.containsKey(aiVar)) {
            this.kaD.put(aiVar, this.kai.k(this.kai.l(aiVar)));
        }
        return this.kaD.get(aiVar);
    }

    private synchronized ai<Void> v(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.kaE.containsKey(aiVar)) {
            l lVar = this.kai;
            this.kaE.put(aiVar, l.m(aiVar));
        }
        return this.kaE.get(aiVar);
    }

    private static String O(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
