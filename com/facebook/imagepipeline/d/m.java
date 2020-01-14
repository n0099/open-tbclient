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
/* loaded from: classes10.dex */
public class m {
    private final af lRH;
    private final boolean lRL;
    private final boolean lRP;
    private final boolean lRV;
    private final at lRs;
    aj<com.facebook.imagepipeline.g.e> lSA;
    aj<Void> lSB;
    aj<Void> lSC;
    private aj<com.facebook.imagepipeline.g.e> lSD;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSE;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSF;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSG;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSH;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSI;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSJ;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSK;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lSL = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> lSM = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lSN = new HashMap();
    private final boolean lSa;
    private final boolean lSe;
    private final l lSo;
    private final boolean lSx;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSy;
    aj<com.facebook.imagepipeline.g.e> lSz;
    private final ContentResolver mContentResolver;

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.lSo = lVar;
        this.lRH = afVar;
        this.lRL = z;
        this.lRV = z2;
        this.lRs = atVar;
        this.lSx = z3;
        this.lSa = z4;
        this.lSe = z5;
        this.lRP = z6;
    }

    public aj<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.drd()) {
            case 0:
                return doH();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + R(imageRequest.drc()));
            case 2:
            case 3:
                return doJ();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.dql().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g = g(imageRequest);
        if (imageRequest.drl() != null) {
            g = v(g);
        }
        if (this.lSa) {
            return x(g);
        }
        return g;
    }

    public aj<Void> f(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g = g(imageRequest);
        if (this.lSa) {
            g = x(g);
        }
        return w(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri drc = imageRequest.drc();
        com.facebook.common.internal.g.checkNotNull(drc, "Uri is null.");
        switch (imageRequest.drd()) {
            case 0:
                return doF();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + R(drc));
            case 2:
                return doM();
            case 3:
                return doL();
            case 4:
                if (com.facebook.common.d.a.OD(this.mContentResolver.getType(drc))) {
                    return doM();
                }
                return doN();
            case 5:
                return doQ();
            case 6:
                return doP();
            case 7:
                return doR();
            case 8:
                return doO();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doF() {
        if (this.lSy == null) {
            this.lSy = r(doI());
        }
        return this.lSy;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> doG() {
        if (this.lSA == null) {
            this.lSA = this.lSo.a(doI(), this.lRs);
        }
        return this.lSA;
    }

    private synchronized aj<Void> doH() {
        if (this.lSC == null) {
            this.lSC = l.m(doG());
        }
        return this.lSC;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> doI() {
        if (this.lSD == null) {
            this.lSD = l.a(s(this.lSo.b(this.lRH)));
            this.lSD = this.lSo.a(this.lSD, this.lRL, this.lSx);
        }
        return this.lSD;
    }

    private synchronized aj<Void> doJ() {
        if (this.lSB == null) {
            this.lSB = l.m(doK());
        }
        return this.lSB;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> doK() {
        if (this.lSz == null) {
            this.lSz = this.lSo.a(s(this.lSo.doB()), this.lRs);
        }
        return this.lSz;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doL() {
        if (this.lSE == null) {
            this.lSE = q(this.lSo.doB());
        }
        return this.lSE;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doM() {
        if (this.lSF == null) {
            this.lSF = u(this.lSo.doE());
        }
        return this.lSF;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doN() {
        if (this.lSG == null) {
            this.lSG = a(this.lSo.doy(), new aw[]{this.lSo.doz(), this.lSo.doA()});
        }
        return this.lSG;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doO() {
        if (this.lSK == null) {
            this.lSK = q(this.lSo.doC());
        }
        return this.lSK;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doP() {
        if (this.lSH == null) {
            this.lSH = q(this.lSo.doD());
        }
        return this.lSH;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doQ() {
        if (this.lSI == null) {
            this.lSI = q(this.lSo.dox());
        }
        return this.lSI;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doR() {
        if (this.lSJ == null) {
            aj<com.facebook.imagepipeline.g.e> dow = this.lSo.dow();
            if (com.facebook.common.g.c.lIv && (!this.lRV || com.facebook.common.g.c.lIx == null)) {
                dow = this.lSo.o(dow);
            }
            l lVar = this.lSo;
            this.lSJ = r(this.lSo.a(l.a(dow), true, this.lSx));
        }
        return this.lSJ;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.lSo.doA()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.lSo.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.lIv && (!this.lRV || com.facebook.common.g.c.lIx == null)) {
            ajVar = this.lSo.o(ajVar);
        }
        if (this.lRP) {
            ajVar = t(ajVar);
        }
        return this.lSo.i(this.lSo.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.lSe) {
            g = this.lSo.g(this.lSo.h(ajVar));
        } else {
            g = this.lSo.g(ajVar);
        }
        return this.lSo.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.lSo.b(this.lSo.a(this.lSo.c(this.lSo.d(ajVar)), this.lRs));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.lSo.n(this.lSo.a(l.a(ajVar), true, this.lSx));
        l lVar = this.lSo;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.lSo.a(this.lSo.a(awVarArr), true, this.lSx);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.lSL.containsKey(ajVar)) {
            this.lSL.put(ajVar, this.lSo.k(this.lSo.l(ajVar)));
        }
        return this.lSL.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.lSM.containsKey(ajVar)) {
            l lVar = this.lSo;
            this.lSM.put(ajVar, l.m(ajVar));
        }
        return this.lSM.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.lSN.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.lSo.p(ajVar);
            this.lSN.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String R(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
