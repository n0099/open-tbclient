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
    private final af lSB;
    private final boolean lSF;
    private final boolean lSJ;
    private final boolean lSP;
    private final boolean lSU;
    private final boolean lSY;
    private final at lSm;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTA;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTB;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTC;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTD;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTE;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lTF = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> lTG = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lTH = new HashMap();
    private final l lTi;
    private final boolean lTr;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTs;
    aj<com.facebook.imagepipeline.g.e> lTt;
    aj<com.facebook.imagepipeline.g.e> lTu;
    aj<Void> lTv;
    aj<Void> lTw;
    private aj<com.facebook.imagepipeline.g.e> lTx;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTy;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTz;
    private final ContentResolver mContentResolver;

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.lTi = lVar;
        this.lSB = afVar;
        this.lSF = z;
        this.lSP = z2;
        this.lSm = atVar;
        this.lTr = z3;
        this.lSU = z4;
        this.lSY = z5;
        this.lSJ = z6;
    }

    public aj<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.dss()) {
            case 0:
                return dpW();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + S(imageRequest.dsr()));
            case 2:
            case 3:
                return dpY();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.drA().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g = g(imageRequest);
        if (imageRequest.dsA() != null) {
            g = v(g);
        }
        if (this.lSU) {
            return x(g);
        }
        return g;
    }

    public aj<Void> f(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g = g(imageRequest);
        if (this.lSU) {
            g = x(g);
        }
        return w(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri dsr = imageRequest.dsr();
        com.facebook.common.internal.g.checkNotNull(dsr, "Uri is null.");
        switch (imageRequest.dss()) {
            case 0:
                return dpU();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + S(dsr));
            case 2:
                return dqb();
            case 3:
                return dqa();
            case 4:
                if (com.facebook.common.d.a.OR(this.mContentResolver.getType(dsr))) {
                    return dqb();
                }
                return dqc();
            case 5:
                return dqf();
            case 6:
                return dqe();
            case 7:
                return dqg();
            case 8:
                return dqd();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dpU() {
        if (this.lTs == null) {
            this.lTs = r(dpX());
        }
        return this.lTs;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dpV() {
        if (this.lTu == null) {
            this.lTu = this.lTi.a(dpX(), this.lSm);
        }
        return this.lTu;
    }

    private synchronized aj<Void> dpW() {
        if (this.lTw == null) {
            this.lTw = l.m(dpV());
        }
        return this.lTw;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dpX() {
        if (this.lTx == null) {
            this.lTx = l.a(s(this.lTi.b(this.lSB)));
            this.lTx = this.lTi.a(this.lTx, this.lSF, this.lTr);
        }
        return this.lTx;
    }

    private synchronized aj<Void> dpY() {
        if (this.lTv == null) {
            this.lTv = l.m(dpZ());
        }
        return this.lTv;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dpZ() {
        if (this.lTt == null) {
            this.lTt = this.lTi.a(s(this.lTi.dpQ()), this.lSm);
        }
        return this.lTt;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqa() {
        if (this.lTy == null) {
            this.lTy = q(this.lTi.dpQ());
        }
        return this.lTy;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqb() {
        if (this.lTz == null) {
            this.lTz = u(this.lTi.dpT());
        }
        return this.lTz;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqc() {
        if (this.lTA == null) {
            this.lTA = a(this.lTi.dpN(), new aw[]{this.lTi.dpO(), this.lTi.dpP()});
        }
        return this.lTA;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqd() {
        if (this.lTE == null) {
            this.lTE = q(this.lTi.dpR());
        }
        return this.lTE;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqe() {
        if (this.lTB == null) {
            this.lTB = q(this.lTi.dpS());
        }
        return this.lTB;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqf() {
        if (this.lTC == null) {
            this.lTC = q(this.lTi.dpM());
        }
        return this.lTC;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqg() {
        if (this.lTD == null) {
            aj<com.facebook.imagepipeline.g.e> dpL = this.lTi.dpL();
            if (com.facebook.common.g.c.lJp && (!this.lSP || com.facebook.common.g.c.lJr == null)) {
                dpL = this.lTi.o(dpL);
            }
            l lVar = this.lTi;
            this.lTD = r(this.lTi.a(l.a(dpL), true, this.lTr));
        }
        return this.lTD;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.lTi.dpP()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.lTi.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.lJp && (!this.lSP || com.facebook.common.g.c.lJr == null)) {
            ajVar = this.lTi.o(ajVar);
        }
        if (this.lSJ) {
            ajVar = t(ajVar);
        }
        return this.lTi.i(this.lTi.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.lSY) {
            g = this.lTi.g(this.lTi.h(ajVar));
        } else {
            g = this.lTi.g(ajVar);
        }
        return this.lTi.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.lTi.b(this.lTi.a(this.lTi.c(this.lTi.d(ajVar)), this.lSm));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.lTi.n(this.lTi.a(l.a(ajVar), true, this.lTr));
        l lVar = this.lTi;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.lTi.a(this.lTi.a(awVarArr), true, this.lTr);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.lTF.containsKey(ajVar)) {
            this.lTF.put(ajVar, this.lTi.k(this.lTi.l(ajVar)));
        }
        return this.lTF.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.lTG.containsKey(ajVar)) {
            l lVar = this.lTi;
            this.lTG.put(ajVar, l.m(ajVar));
        }
        return this.lTG.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.lTH.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.lTi.p(ajVar);
            this.lTH.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String S(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
