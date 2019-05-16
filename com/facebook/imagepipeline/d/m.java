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
    private final af jZE;
    private final boolean jZJ;
    private final boolean jZR;
    private final ar jZq;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaA;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaB;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> kaC = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> kaD = new HashMap();
    private final l kah;
    private final boolean kap;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaq;
    ai<com.facebook.imagepipeline.f.d> kar;
    ai<com.facebook.imagepipeline.f.d> kas;
    ai<Void> kat;
    ai<Void> kau;
    private ai<com.facebook.imagepipeline.f.d> kav;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaw;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kax;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kay;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kaz;

    public m(l lVar, af afVar, boolean z, boolean z2, ar arVar, boolean z3) {
        this.kah = lVar;
        this.jZE = afVar;
        this.jZJ = z;
        this.jZR = z2;
        this.jZq = arVar;
        this.kap = z3;
    }

    public ai<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.cIk()) {
            case 0:
                return cGg();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + O(imageRequest.cIj()));
            case 2:
            case 3:
                return cGi();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.cHy().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g = g(imageRequest);
        if (imageRequest.cIt() != null) {
            return u(g);
        }
        return g;
    }

    public ai<Void> f(ImageRequest imageRequest) {
        return v(g(imageRequest));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri cIj = imageRequest.cIj();
        com.facebook.common.internal.g.checkNotNull(cIj, "Uri is null.");
        switch (imageRequest.cIk()) {
            case 0:
                return cGe();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + O(cIj));
            case 2:
                return cGl();
            case 3:
                return cGk();
            case 4:
                return cGm();
            case 5:
                return cGo();
            case 6:
                return cGn();
            case 7:
                return cGp();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGe() {
        if (this.kaq == null) {
            this.kaq = q(cGh());
        }
        return this.kaq;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cGf() {
        if (this.kas == null) {
            this.kas = this.kah.a(cGh(), this.jZq);
        }
        return this.kas;
    }

    private synchronized ai<Void> cGg() {
        if (this.kau == null) {
            this.kau = l.m(cGf());
        }
        return this.kau;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cGh() {
        if (this.kav == null) {
            this.kav = l.a(r(this.kah.a(this.jZE)));
            this.kav = this.kah.a(this.kav, this.jZJ, this.kap);
        }
        return this.kav;
    }

    private synchronized ai<Void> cGi() {
        if (this.kat == null) {
            this.kat = l.m(cGj());
        }
        return this.kat;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cGj() {
        if (this.kar == null) {
            this.kar = this.kah.a(r(this.kah.cGb()), this.jZq);
        }
        return this.kar;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGk() {
        if (this.kaw == null) {
            this.kaw = p(this.kah.cGb());
        }
        return this.kaw;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGl() {
        if (this.kax == null) {
            this.kax = t(this.kah.cGd());
        }
        return this.kax;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGm() {
        if (this.kay == null) {
            this.kay = a(this.kah.cFY(), new au[]{this.kah.cFZ(), this.kah.cGa()});
        }
        return this.kay;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGn() {
        if (this.kaz == null) {
            this.kaz = p(this.kah.cGc());
        }
        return this.kaz;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGo() {
        if (this.kaA == null) {
            this.kaA = p(this.kah.cFX());
        }
        return this.kaA;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cGp() {
        if (this.kaB == null) {
            ai<com.facebook.imagepipeline.f.d> cFW = this.kah.cFW();
            if (com.facebook.common.g.c.jSZ && (!this.jZR || com.facebook.common.g.c.jTc == null)) {
                cFW = this.kah.o(cFW);
            }
            l lVar = this.kah;
            this.kaB = q(this.kah.a(l.a(cFW), true, this.kap));
        }
        return this.kaB;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new au[]{this.kah.cGa()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return q(b(r(aiVar), auVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return t(this.kah.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.jSZ && (!this.jZR || com.facebook.common.g.c.jTc == null)) {
            aiVar = this.kah.o(aiVar);
        }
        return this.kah.i(this.kah.j(s(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> s(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.kah.f(this.kah.h(this.kah.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.kah.b(this.kah.a(this.kah.c(this.kah.d(aiVar)), this.jZq));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        as n = this.kah.n(this.kah.a(l.a(aiVar), true, this.kap));
        l lVar = this.kah;
        return l.a(b(auVarArr), n);
    }

    private ai<com.facebook.imagepipeline.f.d> b(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return this.kah.a(this.kah.a(auVarArr), true, this.kap);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> u(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.kaC.containsKey(aiVar)) {
            this.kaC.put(aiVar, this.kah.k(this.kah.l(aiVar)));
        }
        return this.kaC.get(aiVar);
    }

    private synchronized ai<Void> v(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.kaD.containsKey(aiVar)) {
            l lVar = this.kah;
            this.kaD.put(aiVar, l.m(aiVar));
        }
        return this.kaD.get(aiVar);
    }

    private static String O(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
