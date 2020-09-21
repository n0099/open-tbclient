package com.facebook.imagepipeline.d;

import android.content.ContentResolver;
import android.net.Uri;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.facebook.imagepipeline.producers.af;
import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.at;
import com.facebook.imagepipeline.producers.au;
import com.facebook.imagepipeline.producers.aw;
import com.facebook.imagepipeline.producers.p;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes25.dex */
public class m {
    private final ContentResolver mContentResolver;
    private final boolean nFD;
    private final boolean nFI;
    private final boolean nFM;
    private final l nFW;
    private final at nFa;
    private final af nFp;
    private final boolean nFt;
    private final boolean nFx;
    private final boolean nGf;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nGg;
    aj<com.facebook.imagepipeline.g.e> nGh;
    aj<com.facebook.imagepipeline.g.e> nGi;
    aj<Void> nGj;
    aj<Void> nGk;
    private aj<com.facebook.imagepipeline.g.e> nGl;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nGm;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nGn;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nGo;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nGp;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nGq;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nGr;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nGs;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> nGt = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> nGu = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> nGv = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.nFW = lVar;
        this.nFp = afVar;
        this.nFt = z;
        this.nFD = z2;
        this.nFa = atVar;
        this.nGf = z3;
        this.nFI = z4;
        this.nFM = z5;
        this.nFx = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.eao()) {
            case 0:
                return dXU();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + X(imageRequest.ean()));
            case 2:
            case 3:
                return dXW();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.dZx().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.eav() != null) {
            f = v(f);
        }
        if (this.nFI) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.nFI) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri ean = imageRequest.ean();
        com.facebook.common.internal.g.checkNotNull(ean, "Uri is null.");
        switch (imageRequest.eao()) {
            case 0:
                return dXS();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + X(ean));
            case 2:
                return dXZ();
            case 3:
                return dXY();
            case 4:
                if (com.facebook.common.d.a.UU(this.mContentResolver.getType(ean))) {
                    return dXZ();
                }
                return dYa();
            case 5:
                return dYd();
            case 6:
                return dYc();
            case 7:
                return dYe();
            case 8:
                return dYb();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dXS() {
        if (this.nGg == null) {
            this.nGg = r(dXV());
        }
        return this.nGg;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dXT() {
        if (this.nGi == null) {
            this.nGi = this.nFW.a(dXV(), this.nFa);
        }
        return this.nGi;
    }

    private synchronized aj<Void> dXU() {
        if (this.nGk == null) {
            this.nGk = l.m(dXT());
        }
        return this.nGk;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dXV() {
        if (this.nGl == null) {
            this.nGl = l.a(s(this.nFW.b(this.nFp)));
            this.nGl = this.nFW.a(this.nGl, this.nFt, this.nGf);
        }
        return this.nGl;
    }

    private synchronized aj<Void> dXW() {
        if (this.nGj == null) {
            this.nGj = l.m(dXX());
        }
        return this.nGj;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dXX() {
        if (this.nGh == null) {
            this.nGh = this.nFW.a(s(this.nFW.dXO()), this.nFa);
        }
        return this.nGh;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dXY() {
        if (this.nGm == null) {
            this.nGm = q(this.nFW.dXO());
        }
        return this.nGm;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dXZ() {
        if (this.nGn == null) {
            this.nGn = u(this.nFW.dXR());
        }
        return this.nGn;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dYa() {
        if (this.nGo == null) {
            this.nGo = a(this.nFW.dXL(), new aw[]{this.nFW.dXM(), this.nFW.dXN()});
        }
        return this.nGo;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dYb() {
        if (this.nGs == null) {
            this.nGs = q(this.nFW.dXP());
        }
        return this.nGs;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dYc() {
        if (this.nGp == null) {
            this.nGp = q(this.nFW.dXQ());
        }
        return this.nGp;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dYd() {
        if (this.nGq == null) {
            this.nGq = q(this.nFW.dXK());
        }
        return this.nGq;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dYe() {
        if (this.nGr == null) {
            aj<com.facebook.imagepipeline.g.e> dXJ = this.nFW.dXJ();
            if (com.facebook.common.g.c.nvP && (!this.nFD || com.facebook.common.g.c.nvS == null)) {
                dXJ = this.nFW.o(dXJ);
            }
            l lVar = this.nFW;
            this.nGr = r(this.nFW.a(l.a(dXJ), true, this.nGf));
        }
        return this.nGr;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.nFW.dXN()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.nFW.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.nvP && (!this.nFD || com.facebook.common.g.c.nvS == null)) {
            ajVar = this.nFW.o(ajVar);
        }
        if (this.nFx) {
            ajVar = t(ajVar);
        }
        return this.nFW.i(this.nFW.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.nFM) {
            g = this.nFW.g(this.nFW.h(ajVar));
        } else {
            g = this.nFW.g(ajVar);
        }
        return this.nFW.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.nFW.b(this.nFW.a(this.nFW.c(this.nFW.d(ajVar)), this.nFa));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.nFW.n(this.nFW.a(l.a(ajVar), true, this.nGf));
        l lVar = this.nFW;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.nFW.a(this.nFW.a(awVarArr), true, this.nGf);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.nGt.containsKey(ajVar)) {
            this.nGt.put(ajVar, this.nFW.k(this.nFW.l(ajVar)));
        }
        return this.nGt.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.nGu.containsKey(ajVar)) {
            l lVar = this.nFW;
            this.nGu.put(ajVar, l.m(ajVar));
        }
        return this.nGu.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.nGv.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.nFW.p(ajVar);
            this.nGv.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String X(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
