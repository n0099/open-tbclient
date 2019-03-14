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
    private final boolean jHB;
    private final boolean jHJ;
    private final l jHZ;
    private final ar jHi;
    private final af jHw;
    private final boolean jIh;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIi;
    ai<com.facebook.imagepipeline.f.d> jIj;
    ai<com.facebook.imagepipeline.f.d> jIk;
    ai<Void> jIl;
    ai<Void> jIm;
    private ai<com.facebook.imagepipeline.f.d> jIn;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIo;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIp;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIq;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIr;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIs;
    ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jIt;
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> jIu = new HashMap();
    Map<ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>, ai<Void>> jIv = new HashMap();

    public m(l lVar, af afVar, boolean z, boolean z2, ar arVar, boolean z3) {
        this.jHZ = lVar;
        this.jHw = afVar;
        this.jHB = z;
        this.jHJ = z2;
        this.jHi = arVar;
        this.jIh = z3;
    }

    public ai<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.cAv()) {
            case 0:
                return cyr();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + I(imageRequest.cAu()));
            case 2:
            case 3:
                return cyt();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.czJ().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e(ImageRequest imageRequest) {
        ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g = g(imageRequest);
        if (imageRequest.cAE() != null) {
            return u(g);
        }
        return g;
    }

    public ai<Void> f(ImageRequest imageRequest) {
        return v(g(imageRequest));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri cAu = imageRequest.cAu();
        com.facebook.common.internal.g.checkNotNull(cAu, "Uri is null.");
        switch (imageRequest.cAv()) {
            case 0:
                return cyp();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + I(cAu));
            case 2:
                return cyw();
            case 3:
                return cyv();
            case 4:
                return cyx();
            case 5:
                return cyz();
            case 6:
                return cyy();
            case 7:
                return cyA();
        }
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyp() {
        if (this.jIi == null) {
            this.jIi = q(cys());
        }
        return this.jIi;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cyq() {
        if (this.jIk == null) {
            this.jIk = this.jHZ.a(cys(), this.jHi);
        }
        return this.jIk;
    }

    private synchronized ai<Void> cyr() {
        if (this.jIm == null) {
            this.jIm = l.m(cyq());
        }
        return this.jIm;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cys() {
        if (this.jIn == null) {
            this.jIn = l.a(r(this.jHZ.a(this.jHw)));
            this.jIn = this.jHZ.a(this.jIn, this.jHB, this.jIh);
        }
        return this.jIn;
    }

    private synchronized ai<Void> cyt() {
        if (this.jIl == null) {
            this.jIl = l.m(cyu());
        }
        return this.jIl;
    }

    private synchronized ai<com.facebook.imagepipeline.f.d> cyu() {
        if (this.jIj == null) {
            this.jIj = this.jHZ.a(r(this.jHZ.cym()), this.jHi);
        }
        return this.jIj;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyv() {
        if (this.jIo == null) {
            this.jIo = p(this.jHZ.cym());
        }
        return this.jIo;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyw() {
        if (this.jIp == null) {
            this.jIp = t(this.jHZ.cyo());
        }
        return this.jIp;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyx() {
        if (this.jIq == null) {
            this.jIq = a(this.jHZ.cyj(), new au[]{this.jHZ.cyk(), this.jHZ.cyl()});
        }
        return this.jIq;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyy() {
        if (this.jIr == null) {
            this.jIr = p(this.jHZ.cyn());
        }
        return this.jIr;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyz() {
        if (this.jIs == null) {
            this.jIs = p(this.jHZ.cyi());
        }
        return this.jIs;
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cyA() {
        if (this.jIt == null) {
            ai<com.facebook.imagepipeline.f.d> cyh = this.jHZ.cyh();
            if (com.facebook.common.g.c.jAP && (!this.jHJ || com.facebook.common.g.c.jAS == null)) {
                cyh = this.jHZ.o(cyh);
            }
            l lVar = this.jHZ;
            this.jIt = q(this.jHZ.a(l.a(cyh), true, this.jIh));
        }
        return this.jIt;
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> p(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return a(aiVar, new au[]{this.jHZ.cyl()});
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return q(b(r(aiVar), auVarArr));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> q(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return t(this.jHZ.e(aiVar));
    }

    private ai<com.facebook.imagepipeline.f.d> r(ai<com.facebook.imagepipeline.f.d> aiVar) {
        if (com.facebook.common.g.c.jAP && (!this.jHJ || com.facebook.common.g.c.jAS == null)) {
            aiVar = this.jHZ.o(aiVar);
        }
        return this.jHZ.i(this.jHZ.j(s(aiVar)));
    }

    private ai<com.facebook.imagepipeline.f.d> s(ai<com.facebook.imagepipeline.f.d> aiVar) {
        return this.jHZ.f(this.jHZ.h(this.jHZ.g(aiVar)));
    }

    private ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> t(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        return this.jHZ.b(this.jHZ.a(this.jHZ.c(this.jHZ.d(aiVar)), this.jHi));
    }

    private ai<com.facebook.imagepipeline.f.d> b(ai<com.facebook.imagepipeline.f.d> aiVar, au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        as n = this.jHZ.n(this.jHZ.a(l.a(aiVar), true, this.jIh));
        l lVar = this.jHZ;
        return l.a(b(auVarArr), n);
    }

    private ai<com.facebook.imagepipeline.f.d> b(au<com.facebook.imagepipeline.f.d>[] auVarArr) {
        return this.jHZ.a(this.jHZ.a(auVarArr), true, this.jIh);
    }

    private synchronized ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> u(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.jIu.containsKey(aiVar)) {
            this.jIu.put(aiVar, this.jHZ.k(this.jHZ.l(aiVar)));
        }
        return this.jIu.get(aiVar);
    }

    private synchronized ai<Void> v(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        if (!this.jIv.containsKey(aiVar)) {
            l lVar = this.jHZ;
            this.jIv.put(aiVar, l.m(aiVar));
        }
        return this.jIv.get(aiVar);
    }

    private static String I(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
