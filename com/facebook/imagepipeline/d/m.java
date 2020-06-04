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
/* loaded from: classes12.dex */
public class m {
    private final ContentResolver mContentResolver;
    private final at mwK;
    private final af mwZ;
    private final l mxG;
    private final boolean mxN;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mxO;
    aj<com.facebook.imagepipeline.g.e> mxP;
    aj<com.facebook.imagepipeline.g.e> mxQ;
    aj<Void> mxR;
    aj<Void> mxS;
    private aj<com.facebook.imagepipeline.g.e> mxT;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mxU;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mxV;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mxW;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mxX;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mxY;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mxZ;
    private final boolean mxd;
    private final boolean mxh;
    private final boolean mxn;
    private final boolean mxs;
    private final boolean mxw;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mya;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> myb = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> myc = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> myd = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.mxG = lVar;
        this.mwZ = afVar;
        this.mxd = z;
        this.mxn = z2;
        this.mwK = atVar;
        this.mxN = z3;
        this.mxs = z4;
        this.mxw = z5;
        this.mxh = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.dCp()) {
            case 0:
                return dzV();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + V(imageRequest.dCo()));
            case 2:
            case 3:
                return dzX();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.dBy().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.dCw() != null) {
            f = v(f);
        }
        if (this.mxs) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.mxs) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri dCo = imageRequest.dCo();
        com.facebook.common.internal.g.checkNotNull(dCo, "Uri is null.");
        switch (imageRequest.dCp()) {
            case 0:
                return dzT();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + V(dCo));
            case 2:
                return dAa();
            case 3:
                return dzZ();
            case 4:
                if (com.facebook.common.d.a.PQ(this.mContentResolver.getType(dCo))) {
                    return dAa();
                }
                return dAb();
            case 5:
                return dAe();
            case 6:
                return dAd();
            case 7:
                return dAf();
            case 8:
                return dAc();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dzT() {
        if (this.mxO == null) {
            this.mxO = r(dzW());
        }
        return this.mxO;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dzU() {
        if (this.mxQ == null) {
            this.mxQ = this.mxG.a(dzW(), this.mwK);
        }
        return this.mxQ;
    }

    private synchronized aj<Void> dzV() {
        if (this.mxS == null) {
            this.mxS = l.m(dzU());
        }
        return this.mxS;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dzW() {
        if (this.mxT == null) {
            this.mxT = l.a(s(this.mxG.b(this.mwZ)));
            this.mxT = this.mxG.a(this.mxT, this.mxd, this.mxN);
        }
        return this.mxT;
    }

    private synchronized aj<Void> dzX() {
        if (this.mxR == null) {
            this.mxR = l.m(dzY());
        }
        return this.mxR;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dzY() {
        if (this.mxP == null) {
            this.mxP = this.mxG.a(s(this.mxG.dzP()), this.mwK);
        }
        return this.mxP;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dzZ() {
        if (this.mxU == null) {
            this.mxU = q(this.mxG.dzP());
        }
        return this.mxU;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dAa() {
        if (this.mxV == null) {
            this.mxV = u(this.mxG.dzS());
        }
        return this.mxV;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dAb() {
        if (this.mxW == null) {
            this.mxW = a(this.mxG.dzM(), new aw[]{this.mxG.dzN(), this.mxG.dzO()});
        }
        return this.mxW;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dAc() {
        if (this.mya == null) {
            this.mya = q(this.mxG.dzQ());
        }
        return this.mya;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dAd() {
        if (this.mxX == null) {
            this.mxX = q(this.mxG.dzR());
        }
        return this.mxX;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dAe() {
        if (this.mxY == null) {
            this.mxY = q(this.mxG.dzL());
        }
        return this.mxY;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dAf() {
        if (this.mxZ == null) {
            aj<com.facebook.imagepipeline.g.e> dzK = this.mxG.dzK();
            if (com.facebook.common.g.c.mnv && (!this.mxn || com.facebook.common.g.c.mny == null)) {
                dzK = this.mxG.o(dzK);
            }
            l lVar = this.mxG;
            this.mxZ = r(this.mxG.a(l.a(dzK), true, this.mxN));
        }
        return this.mxZ;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.mxG.dzO()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.mxG.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.mnv && (!this.mxn || com.facebook.common.g.c.mny == null)) {
            ajVar = this.mxG.o(ajVar);
        }
        if (this.mxh) {
            ajVar = t(ajVar);
        }
        return this.mxG.i(this.mxG.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.mxw) {
            g = this.mxG.g(this.mxG.h(ajVar));
        } else {
            g = this.mxG.g(ajVar);
        }
        return this.mxG.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.mxG.b(this.mxG.a(this.mxG.c(this.mxG.d(ajVar)), this.mwK));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.mxG.n(this.mxG.a(l.a(ajVar), true, this.mxN));
        l lVar = this.mxG;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.mxG.a(this.mxG.a(awVarArr), true, this.mxN);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.myb.containsKey(ajVar)) {
            this.myb.put(ajVar, this.mxG.k(this.mxG.l(ajVar)));
        }
        return this.myb.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.myc.containsKey(ajVar)) {
            l lVar = this.mxG;
            this.myc.put(ajVar, l.m(ajVar));
        }
        return this.myc.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.myd.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.mxG.p(ajVar);
            this.myd.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String V(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
