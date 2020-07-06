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
    private final at mSO;
    private final boolean mTD;
    private final l mTN;
    private final boolean mTW;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mTX;
    aj<com.facebook.imagepipeline.g.e> mTY;
    aj<com.facebook.imagepipeline.g.e> mTZ;
    private final af mTe;
    private final boolean mTi;
    private final boolean mTn;
    private final boolean mTu;
    private final boolean mTz;
    aj<Void> mUa;
    aj<Void> mUb;
    private aj<com.facebook.imagepipeline.g.e> mUc;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mUd;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mUe;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mUf;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mUg;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mUh;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mUi;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mUj;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> mUl = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> mUm = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> mUn = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.mTN = lVar;
        this.mTe = afVar;
        this.mTi = z;
        this.mTu = z2;
        this.mSO = atVar;
        this.mTW = z3;
        this.mTz = z4;
        this.mTD = z5;
        this.mTn = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.dGV()) {
            case 0:
                return dEB();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + W(imageRequest.dGU()));
            case 2:
            case 3:
                return dED();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.dGe().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.dHc() != null) {
            f = v(f);
        }
        if (this.mTz) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.mTz) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri dGU = imageRequest.dGU();
        com.facebook.common.internal.g.checkNotNull(dGU, "Uri is null.");
        switch (imageRequest.dGV()) {
            case 0:
                return dEz();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + W(dGU));
            case 2:
                return dEG();
            case 3:
                return dEF();
            case 4:
                if (com.facebook.common.d.a.QD(this.mContentResolver.getType(dGU))) {
                    return dEG();
                }
                return dEH();
            case 5:
                return dEK();
            case 6:
                return dEJ();
            case 7:
                return dEL();
            case 8:
                return dEI();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEz() {
        if (this.mTX == null) {
            this.mTX = r(dEC());
        }
        return this.mTX;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dEA() {
        if (this.mTZ == null) {
            this.mTZ = this.mTN.a(dEC(), this.mSO);
        }
        return this.mTZ;
    }

    private synchronized aj<Void> dEB() {
        if (this.mUb == null) {
            this.mUb = l.m(dEA());
        }
        return this.mUb;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dEC() {
        if (this.mUc == null) {
            this.mUc = l.a(s(this.mTN.b(this.mTe)));
            this.mUc = this.mTN.a(this.mUc, this.mTi, this.mTW);
        }
        return this.mUc;
    }

    private synchronized aj<Void> dED() {
        if (this.mUa == null) {
            this.mUa = l.m(dEE());
        }
        return this.mUa;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dEE() {
        if (this.mTY == null) {
            this.mTY = this.mTN.a(s(this.mTN.dEv()), this.mSO);
        }
        return this.mTY;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEF() {
        if (this.mUd == null) {
            this.mUd = q(this.mTN.dEv());
        }
        return this.mUd;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEG() {
        if (this.mUe == null) {
            this.mUe = u(this.mTN.dEy());
        }
        return this.mUe;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEH() {
        if (this.mUf == null) {
            this.mUf = a(this.mTN.dEs(), new aw[]{this.mTN.dEt(), this.mTN.dEu()});
        }
        return this.mUf;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEI() {
        if (this.mUj == null) {
            this.mUj = q(this.mTN.dEw());
        }
        return this.mUj;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEJ() {
        if (this.mUg == null) {
            this.mUg = q(this.mTN.dEx());
        }
        return this.mUg;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEK() {
        if (this.mUh == null) {
            this.mUh = q(this.mTN.dEr());
        }
        return this.mUh;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEL() {
        if (this.mUi == null) {
            aj<com.facebook.imagepipeline.g.e> dEq = this.mTN.dEq();
            if (com.facebook.common.g.c.mJy && (!this.mTu || com.facebook.common.g.c.mJB == null)) {
                dEq = this.mTN.o(dEq);
            }
            l lVar = this.mTN;
            this.mUi = r(this.mTN.a(l.a(dEq), true, this.mTW));
        }
        return this.mUi;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.mTN.dEu()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.mTN.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.mJy && (!this.mTu || com.facebook.common.g.c.mJB == null)) {
            ajVar = this.mTN.o(ajVar);
        }
        if (this.mTn) {
            ajVar = t(ajVar);
        }
        return this.mTN.i(this.mTN.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.mTD) {
            g = this.mTN.g(this.mTN.h(ajVar));
        } else {
            g = this.mTN.g(ajVar);
        }
        return this.mTN.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.mTN.b(this.mTN.a(this.mTN.c(this.mTN.d(ajVar)), this.mSO));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.mTN.n(this.mTN.a(l.a(ajVar), true, this.mTW));
        l lVar = this.mTN;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.mTN.a(this.mTN.a(awVarArr), true, this.mTW);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.mUl.containsKey(ajVar)) {
            this.mUl.put(ajVar, this.mTN.k(this.mTN.l(ajVar)));
        }
        return this.mUl.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.mUm.containsKey(ajVar)) {
            l lVar = this.mTN;
            this.mUm.put(ajVar, l.m(ajVar));
        }
        return this.mUm.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.mUn.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.mTN.p(ajVar);
            this.mUn.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String W(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
