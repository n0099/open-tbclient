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
    private final boolean kkF;
    private final l kkV;
    private final ar kke;
    private final af kks;
    private final boolean kkx;
    private final boolean kld;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kle;
    ai<com.facebook.imagepipeline.f.d> klf;
    ai<com.facebook.imagepipeline.f.d> klg;
    ai<Void> klh;
    ai<Void> kli;
    private ai<com.facebook.imagepipeline.f.d> klj;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> klk;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kll;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> klm;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kln;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> klo;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> klp;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> klq = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> klr = new HashMap();

    public m(l lVar, af afVar, boolean z, boolean z2, ar arVar, boolean z3) {
        this.kkV = lVar;
        this.kks = afVar;
        this.kkx = z;
        this.kkF = z2;
        this.kke = arVar;
        this.kld = z3;
    }

    public ai<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.cMy()) {
            case 0:
                return cKt();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + O(imageRequest.cMx()));
            case 2:
            case 3:
                return cKv();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.cLM().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g = g(imageRequest);
        if (imageRequest.cMH() != null) {
            return u(g);
        }
        return g;
    }

    public ai<Void> f(ImageRequest imageRequest) {
        return v(g(imageRequest));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri cMx = imageRequest.cMx();
        com.facebook.common.internal.g.checkNotNull(cMx, "Uri is null.");
        switch (imageRequest.cMy()) {
            case 0:
                return cKr();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + O(cMx));
            case 2:
                return cKy();
            case 3:
                return cKx();
            case 4:
                return cKz();
            case 5:
                return cKB();
            case 6:
                return cKA();
            case 7:
                return cKC();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cKr() {
        if (this.kle == null) {
            this.kle = q(cKu());
        }
        return this.kle;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cKs() {
        if (this.klg == null) {
            this.klg = this.kkV.a(cKu(), this.kke);
        }
        return this.klg;
    }

    private synchronized ai<Void> cKt() {
        if (this.kli == null) {
            this.kli = l.m(cKs());
        }
        return this.kli;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cKu() {
        if (this.klj == null) {
            this.klj = l.a(r(this.kkV.a(this.kks)));
            this.klj = this.kkV.a(this.klj, this.kkx, this.kld);
        }
        return this.klj;
    }

    private synchronized ai<Void> cKv() {
        if (this.klh == null) {
            this.klh = l.m(cKw());
        }
        return this.klh;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cKw() {
        if (this.klf == null) {
            this.klf = this.kkV.a(r(this.kkV.cKo()), this.kke);
        }
        return this.klf;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cKx() {
        if (this.klk == null) {
            this.klk = p(this.kkV.cKo());
        }
        return this.klk;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cKy() {
        if (this.kll == null) {
            this.kll = t(this.kkV.cKq());
        }
        return this.kll;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cKz() {
        if (this.klm == null) {
            this.klm = a(this.kkV.cKl(), new au[]{this.kkV.cKm(), this.kkV.cKn()});
        }
        return this.klm;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cKA() {
        if (this.kln == null) {
            this.kln = p(this.kkV.cKp());
        }
        return this.kln;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cKB() {
        if (this.klo == null) {
            this.klo = p(this.kkV.cKk());
        }
        return this.klo;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cKC() {
        if (this.klp == null) {
            ai<com.facebook.imagepipeline.f.d> cKj = this.kkV.cKj();
            if (com.facebook.common.g.c.kdK && (!this.kkF || com.facebook.common.g.c.kdN == null)) {
                cKj = this.kkV.o(cKj);
            }
            l lVar = this.kkV;
            this.klp = q(this.kkV.a(l.a(cKj), true, this.kld));
        }
        return this.klp;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new au[]{this.kkV.cKn()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return q(b(r(aiVar), auVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return t(this.kkV.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.kdK && (!this.kkF || com.facebook.common.g.c.kdN == null)) {
            aiVar = this.kkV.o(aiVar);
        }
        return this.kkV.i(this.kkV.j(s(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> s(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.kkV.f(this.kkV.h(this.kkV.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.kkV.b(this.kkV.a(this.kkV.c(this.kkV.d(aiVar)), this.kke));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        as n = this.kkV.n(this.kkV.a(l.a(aiVar), true, this.kld));
        l lVar = this.kkV;
        return l.a(b(auVarArr), n);
    }

    private ai<com.facebook.imagepipeline.f.d> b(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return this.kkV.a(this.kkV.a(auVarArr), true, this.kld);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> u(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.klq.containsKey(aiVar)) {
            this.klq.put(aiVar, this.kkV.k(this.kkV.l(aiVar)));
        }
        return this.klq.get(aiVar);
    }

    private synchronized ai<Void> v(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.klr.containsKey(aiVar)) {
            l lVar = this.kkV;
            this.klr.put(aiVar, l.m(aiVar));
        }
        return this.klr.get(aiVar);
    }

    private static String O(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
