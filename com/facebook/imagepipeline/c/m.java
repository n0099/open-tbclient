package com.facebook.imagepipeline.c;

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
/* loaded from: classes5.dex */
public class m {
    private final ContentResolver mContentResolver;
    private final at pIQ;
    private final boolean pJC;
    private final l pJM;
    private final boolean pJT;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pJU;
    aj<com.facebook.imagepipeline.f.e> pJV;
    aj<com.facebook.imagepipeline.f.e> pJW;
    aj<Void> pJX;
    aj<Void> pJY;
    private aj<com.facebook.imagepipeline.f.e> pJZ;
    private final af pJf;
    private final boolean pJj;
    private final boolean pJn;
    private final boolean pJt;
    private final boolean pJy;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pKa;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pKb;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pKc;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pKd;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pKe;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pKf;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pKg;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pKh = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<Void>> pKi = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pKj = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.pJM = lVar;
        this.pJf = afVar;
        this.pJj = z;
        this.pJt = z2;
        this.pIQ = atVar;
        this.pJT = z3;
        this.pJy = z4;
        this.pJC = z5;
        this.pJn = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.eAg()) {
            case 0:
                return exS();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + aa(imageRequest.eAf()));
            case 2:
            case 3:
                return exU();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.ezr().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (imageRequest.eAn() != null) {
            f = v(f);
        }
        if (this.pJy) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (this.pJy) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri eAf = imageRequest.eAf();
        com.facebook.common.internal.g.checkNotNull(eAf, "Uri is null.");
        switch (imageRequest.eAg()) {
            case 0:
                return exQ();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + aa(eAf));
            case 2:
                return exX();
            case 3:
                return exW();
            case 4:
                if (com.facebook.common.d.a.Zv(this.mContentResolver.getType(eAf))) {
                    return exX();
                }
                return exY();
            case 5:
                return eyb();
            case 6:
                return eya();
            case 7:
                return eyc();
            case 8:
                return exZ();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exQ() {
        if (this.pJU == null) {
            this.pJU = r(exT());
        }
        return this.pJU;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> exR() {
        if (this.pJW == null) {
            this.pJW = this.pJM.a(exT(), this.pIQ);
        }
        return this.pJW;
    }

    private synchronized aj<Void> exS() {
        if (this.pJY == null) {
            this.pJY = l.m(exR());
        }
        return this.pJY;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> exT() {
        if (this.pJZ == null) {
            this.pJZ = l.a(s(this.pJM.a(this.pJf)));
            this.pJZ = this.pJM.a(this.pJZ, this.pJj, this.pJT);
        }
        return this.pJZ;
    }

    private synchronized aj<Void> exU() {
        if (this.pJX == null) {
            this.pJX = l.m(exV());
        }
        return this.pJX;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> exV() {
        if (this.pJV == null) {
            this.pJV = this.pJM.a(s(this.pJM.exM()), this.pIQ);
        }
        return this.pJV;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exW() {
        if (this.pKa == null) {
            this.pKa = q(this.pJM.exM());
        }
        return this.pKa;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exX() {
        if (this.pKb == null) {
            this.pKb = u(this.pJM.exP());
        }
        return this.pKb;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exY() {
        if (this.pKc == null) {
            this.pKc = a(this.pJM.exJ(), new aw[]{this.pJM.exK(), this.pJM.exL()});
        }
        return this.pKc;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exZ() {
        if (this.pKg == null) {
            this.pKg = q(this.pJM.exN());
        }
        return this.pKg;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eya() {
        if (this.pKd == null) {
            this.pKd = q(this.pJM.exO());
        }
        return this.pKd;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyb() {
        if (this.pKe == null) {
            this.pKe = q(this.pJM.exI());
        }
        return this.pKe;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyc() {
        if (this.pKf == null) {
            aj<com.facebook.imagepipeline.f.e> exH = this.pJM.exH();
            if (com.facebook.common.g.c.pAd && (!this.pJt || com.facebook.common.g.c.pAg == null)) {
                exH = this.pJM.o(exH);
            }
            l lVar = this.pJM;
            this.pKf = r(this.pJM.a(l.a(exH), true, this.pJT));
        }
        return this.pKf;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> q(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return a(ajVar, new aw[]{this.pJM.exL()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> r(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return u(this.pJM.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> s(aj<com.facebook.imagepipeline.f.e> ajVar) {
        if (com.facebook.common.g.c.pAd && (!this.pJt || com.facebook.common.g.c.pAg == null)) {
            ajVar = this.pJM.o(ajVar);
        }
        if (this.pJn) {
            ajVar = t(ajVar);
        }
        return this.pJM.i(this.pJM.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> t(aj<com.facebook.imagepipeline.f.e> ajVar) {
        p g;
        if (this.pJC) {
            g = this.pJM.g(this.pJM.h(ajVar));
        } else {
            g = this.pJM.g(ajVar);
        }
        return this.pJM.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return this.pJM.b(this.pJM.a(this.pJM.c(this.pJM.d(ajVar)), this.pIQ));
    }

    private aj<com.facebook.imagepipeline.f.e> b(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        au n = this.pJM.n(this.pJM.a(l.a(ajVar), true, this.pJT));
        l lVar = this.pJM;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.f.e> b(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return this.pJM.a(this.pJM.a(awVarArr), true, this.pJT);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pKh.containsKey(ajVar)) {
            this.pKh.put(ajVar, this.pJM.k(this.pJM.l(ajVar)));
        }
        return this.pKh.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pKi.containsKey(ajVar)) {
            l lVar = this.pJM;
            this.pKi.put(ajVar, l.m(ajVar));
        }
        return this.pKi.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar2;
        ajVar2 = this.pKj.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.pJM.p(ajVar);
            this.pKj.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String aa(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
