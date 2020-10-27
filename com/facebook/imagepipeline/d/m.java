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
/* loaded from: classes18.dex */
public class m {
    private final ContentResolver mContentResolver;
    private final at oLL;
    private final l oMH;
    private final boolean oMO;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oMP;
    aj<com.facebook.imagepipeline.g.e> oMQ;
    aj<com.facebook.imagepipeline.g.e> oMR;
    aj<Void> oMS;
    aj<Void> oMT;
    private aj<com.facebook.imagepipeline.g.e> oMU;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oMV;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oMW;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oMX;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oMY;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oMZ;
    private final af oMa;
    private final boolean oMe;
    private final boolean oMi;
    private final boolean oMo;
    private final boolean oMt;
    private final boolean oMx;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oNa;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oNb;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> oNc = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> oNd = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> oNe = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.oMH = lVar;
        this.oMa = afVar;
        this.oMe = z;
        this.oMo = z2;
        this.oLL = atVar;
        this.oMO = z3;
        this.oMt = z4;
        this.oMx = z5;
        this.oMi = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.enY()) {
            case 0:
                return elD();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + X(imageRequest.enX()));
            case 2:
            case 3:
                return elF();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.enh().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.eog() != null) {
            f = v(f);
        }
        if (this.oMt) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.oMt) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri enX = imageRequest.enX();
        com.facebook.common.internal.g.checkNotNull(enX, "Uri is null.");
        switch (imageRequest.enY()) {
            case 0:
                return elB();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + X(enX));
            case 2:
                return elI();
            case 3:
                return elH();
            case 4:
                if (com.facebook.common.d.a.Xv(this.mContentResolver.getType(enX))) {
                    return elI();
                }
                return elJ();
            case 5:
                return elM();
            case 6:
                return elL();
            case 7:
                return elN();
            case 8:
                return elK();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> elB() {
        if (this.oMP == null) {
            this.oMP = r(elE());
        }
        return this.oMP;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> elC() {
        if (this.oMR == null) {
            this.oMR = this.oMH.a(elE(), this.oLL);
        }
        return this.oMR;
    }

    private synchronized aj<Void> elD() {
        if (this.oMT == null) {
            this.oMT = l.m(elC());
        }
        return this.oMT;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> elE() {
        if (this.oMU == null) {
            this.oMU = l.a(s(this.oMH.b(this.oMa)));
            this.oMU = this.oMH.a(this.oMU, this.oMe, this.oMO);
        }
        return this.oMU;
    }

    private synchronized aj<Void> elF() {
        if (this.oMS == null) {
            this.oMS = l.m(elG());
        }
        return this.oMS;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> elG() {
        if (this.oMQ == null) {
            this.oMQ = this.oMH.a(s(this.oMH.elx()), this.oLL);
        }
        return this.oMQ;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> elH() {
        if (this.oMV == null) {
            this.oMV = q(this.oMH.elx());
        }
        return this.oMV;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> elI() {
        if (this.oMW == null) {
            this.oMW = u(this.oMH.elA());
        }
        return this.oMW;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> elJ() {
        if (this.oMX == null) {
            this.oMX = a(this.oMH.elu(), new aw[]{this.oMH.elv(), this.oMH.elw()});
        }
        return this.oMX;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> elK() {
        if (this.oNb == null) {
            this.oNb = q(this.oMH.ely());
        }
        return this.oNb;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> elL() {
        if (this.oMY == null) {
            this.oMY = q(this.oMH.elz());
        }
        return this.oMY;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> elM() {
        if (this.oMZ == null) {
            this.oMZ = q(this.oMH.elt());
        }
        return this.oMZ;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> elN() {
        if (this.oNa == null) {
            aj<com.facebook.imagepipeline.g.e> els = this.oMH.els();
            if (com.facebook.common.g.c.oCB && (!this.oMo || com.facebook.common.g.c.oCE == null)) {
                els = this.oMH.o(els);
            }
            l lVar = this.oMH;
            this.oNa = r(this.oMH.a(l.a(els), true, this.oMO));
        }
        return this.oNa;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.oMH.elw()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.oMH.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.oCB && (!this.oMo || com.facebook.common.g.c.oCE == null)) {
            ajVar = this.oMH.o(ajVar);
        }
        if (this.oMi) {
            ajVar = t(ajVar);
        }
        return this.oMH.i(this.oMH.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.oMx) {
            g = this.oMH.g(this.oMH.h(ajVar));
        } else {
            g = this.oMH.g(ajVar);
        }
        return this.oMH.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.oMH.b(this.oMH.a(this.oMH.c(this.oMH.d(ajVar)), this.oLL));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.oMH.n(this.oMH.a(l.a(ajVar), true, this.oMO));
        l lVar = this.oMH;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.oMH.a(this.oMH.a(awVarArr), true, this.oMO);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.oNc.containsKey(ajVar)) {
            this.oNc.put(ajVar, this.oMH.k(this.oMH.l(ajVar)));
        }
        return this.oNc.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.oNd.containsKey(ajVar)) {
            l lVar = this.oMH;
            this.oNd.put(ajVar, l.m(ajVar));
        }
        return this.oNd.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.oNe.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.oMH.p(ajVar);
            this.oNe.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String X(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
