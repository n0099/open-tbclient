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
/* loaded from: classes15.dex */
public class m {
    private final ContentResolver mContentResolver;
    private final at oWH;
    private final af oWW;
    private final l oXD;
    private final boolean oXK;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oXL;
    aj<com.facebook.imagepipeline.g.e> oXM;
    aj<com.facebook.imagepipeline.g.e> oXN;
    aj<Void> oXO;
    aj<Void> oXP;
    private aj<com.facebook.imagepipeline.g.e> oXQ;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oXR;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oXS;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oXT;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oXU;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oXV;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oXW;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oXX;
    private final boolean oXa;
    private final boolean oXe;
    private final boolean oXk;
    private final boolean oXp;
    private final boolean oXt;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> oXY = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> oXZ = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> oYa = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.oXD = lVar;
        this.oWW = afVar;
        this.oXa = z;
        this.oXk = z2;
        this.oWH = atVar;
        this.oXK = z3;
        this.oXp = z4;
        this.oXt = z5;
        this.oXe = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.erM()) {
            case 0:
                return eps();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + Y(imageRequest.erL()));
            case 2:
            case 3:
                return epu();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.eqV().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.erT() != null) {
            f = v(f);
        }
        if (this.oXp) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.oXp) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri erL = imageRequest.erL();
        com.facebook.common.internal.g.checkNotNull(erL, "Uri is null.");
        switch (imageRequest.erM()) {
            case 0:
                return epq();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + Y(erL));
            case 2:
                return epx();
            case 3:
                return epw();
            case 4:
                if (com.facebook.common.d.a.XK(this.mContentResolver.getType(erL))) {
                    return epx();
                }
                return epy();
            case 5:
                return epB();
            case 6:
                return epA();
            case 7:
                return epC();
            case 8:
                return epz();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epq() {
        if (this.oXL == null) {
            this.oXL = r(ept());
        }
        return this.oXL;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> epr() {
        if (this.oXN == null) {
            this.oXN = this.oXD.a(ept(), this.oWH);
        }
        return this.oXN;
    }

    private synchronized aj<Void> eps() {
        if (this.oXP == null) {
            this.oXP = l.m(epr());
        }
        return this.oXP;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> ept() {
        if (this.oXQ == null) {
            this.oXQ = l.a(s(this.oXD.b(this.oWW)));
            this.oXQ = this.oXD.a(this.oXQ, this.oXa, this.oXK);
        }
        return this.oXQ;
    }

    private synchronized aj<Void> epu() {
        if (this.oXO == null) {
            this.oXO = l.m(epv());
        }
        return this.oXO;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> epv() {
        if (this.oXM == null) {
            this.oXM = this.oXD.a(s(this.oXD.epm()), this.oWH);
        }
        return this.oXM;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epw() {
        if (this.oXR == null) {
            this.oXR = q(this.oXD.epm());
        }
        return this.oXR;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epx() {
        if (this.oXS == null) {
            this.oXS = u(this.oXD.epp());
        }
        return this.oXS;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epy() {
        if (this.oXT == null) {
            this.oXT = a(this.oXD.epj(), new aw[]{this.oXD.epk(), this.oXD.epl()});
        }
        return this.oXT;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epz() {
        if (this.oXX == null) {
            this.oXX = q(this.oXD.epn());
        }
        return this.oXX;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epA() {
        if (this.oXU == null) {
            this.oXU = q(this.oXD.epo());
        }
        return this.oXU;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epB() {
        if (this.oXV == null) {
            this.oXV = q(this.oXD.epi());
        }
        return this.oXV;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epC() {
        if (this.oXW == null) {
            aj<com.facebook.imagepipeline.g.e> eph = this.oXD.eph();
            if (com.facebook.common.g.c.oNy && (!this.oXk || com.facebook.common.g.c.oNB == null)) {
                eph = this.oXD.o(eph);
            }
            l lVar = this.oXD;
            this.oXW = r(this.oXD.a(l.a(eph), true, this.oXK));
        }
        return this.oXW;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.oXD.epl()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.oXD.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.oNy && (!this.oXk || com.facebook.common.g.c.oNB == null)) {
            ajVar = this.oXD.o(ajVar);
        }
        if (this.oXe) {
            ajVar = t(ajVar);
        }
        return this.oXD.i(this.oXD.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.oXt) {
            g = this.oXD.g(this.oXD.h(ajVar));
        } else {
            g = this.oXD.g(ajVar);
        }
        return this.oXD.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.oXD.b(this.oXD.a(this.oXD.c(this.oXD.d(ajVar)), this.oWH));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.oXD.n(this.oXD.a(l.a(ajVar), true, this.oXK));
        l lVar = this.oXD;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.oXD.a(this.oXD.a(awVarArr), true, this.oXK);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.oXY.containsKey(ajVar)) {
            this.oXY.put(ajVar, this.oXD.k(this.oXD.l(ajVar)));
        }
        return this.oXY.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.oXZ.containsKey(ajVar)) {
            l lVar = this.oXD;
            this.oXZ.put(ajVar, l.m(ajVar));
        }
        return this.oXZ.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.oYa.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.oXD.p(ajVar);
            this.oYa.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String Y(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
