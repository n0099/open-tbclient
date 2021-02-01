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
    private final af pIF;
    private final boolean pIJ;
    private final boolean pIN;
    private final boolean pIT;
    private final boolean pIY;
    private final at pIq;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pJA;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pJB;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pJC;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pJD;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pJE;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pJF;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pJG;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pJH = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<Void>> pJI = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pJJ = new HashMap();
    private final boolean pJc;
    private final l pJm;
    private final boolean pJt;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pJu;
    aj<com.facebook.imagepipeline.f.e> pJv;
    aj<com.facebook.imagepipeline.f.e> pJw;
    aj<Void> pJx;
    aj<Void> pJy;
    private aj<com.facebook.imagepipeline.f.e> pJz;

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.pJm = lVar;
        this.pIF = afVar;
        this.pIJ = z;
        this.pIT = z2;
        this.pIq = atVar;
        this.pJt = z3;
        this.pIY = z4;
        this.pJc = z5;
        this.pIN = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.ezY()) {
            case 0:
                return exK();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + aa(imageRequest.ezX()));
            case 2:
            case 3:
                return exM();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.ezj().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (imageRequest.eAf() != null) {
            f = v(f);
        }
        if (this.pIY) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (this.pIY) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri ezX = imageRequest.ezX();
        com.facebook.common.internal.g.checkNotNull(ezX, "Uri is null.");
        switch (imageRequest.ezY()) {
            case 0:
                return exI();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + aa(ezX));
            case 2:
                return exP();
            case 3:
                return exO();
            case 4:
                if (com.facebook.common.d.a.Zj(this.mContentResolver.getType(ezX))) {
                    return exP();
                }
                return exQ();
            case 5:
                return exT();
            case 6:
                return exS();
            case 7:
                return exU();
            case 8:
                return exR();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exI() {
        if (this.pJu == null) {
            this.pJu = r(exL());
        }
        return this.pJu;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> exJ() {
        if (this.pJw == null) {
            this.pJw = this.pJm.a(exL(), this.pIq);
        }
        return this.pJw;
    }

    private synchronized aj<Void> exK() {
        if (this.pJy == null) {
            this.pJy = l.m(exJ());
        }
        return this.pJy;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> exL() {
        if (this.pJz == null) {
            this.pJz = l.a(s(this.pJm.a(this.pIF)));
            this.pJz = this.pJm.a(this.pJz, this.pIJ, this.pJt);
        }
        return this.pJz;
    }

    private synchronized aj<Void> exM() {
        if (this.pJx == null) {
            this.pJx = l.m(exN());
        }
        return this.pJx;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> exN() {
        if (this.pJv == null) {
            this.pJv = this.pJm.a(s(this.pJm.exE()), this.pIq);
        }
        return this.pJv;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exO() {
        if (this.pJA == null) {
            this.pJA = q(this.pJm.exE());
        }
        return this.pJA;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exP() {
        if (this.pJB == null) {
            this.pJB = u(this.pJm.exH());
        }
        return this.pJB;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exQ() {
        if (this.pJC == null) {
            this.pJC = a(this.pJm.exB(), new aw[]{this.pJm.exC(), this.pJm.exD()});
        }
        return this.pJC;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exR() {
        if (this.pJG == null) {
            this.pJG = q(this.pJm.exF());
        }
        return this.pJG;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exS() {
        if (this.pJD == null) {
            this.pJD = q(this.pJm.exG());
        }
        return this.pJD;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exT() {
        if (this.pJE == null) {
            this.pJE = q(this.pJm.exA());
        }
        return this.pJE;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exU() {
        if (this.pJF == null) {
            aj<com.facebook.imagepipeline.f.e> exz = this.pJm.exz();
            if (com.facebook.common.g.c.pzD && (!this.pIT || com.facebook.common.g.c.pzG == null)) {
                exz = this.pJm.o(exz);
            }
            l lVar = this.pJm;
            this.pJF = r(this.pJm.a(l.a(exz), true, this.pJt));
        }
        return this.pJF;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> q(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return a(ajVar, new aw[]{this.pJm.exD()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> r(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return u(this.pJm.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> s(aj<com.facebook.imagepipeline.f.e> ajVar) {
        if (com.facebook.common.g.c.pzD && (!this.pIT || com.facebook.common.g.c.pzG == null)) {
            ajVar = this.pJm.o(ajVar);
        }
        if (this.pIN) {
            ajVar = t(ajVar);
        }
        return this.pJm.i(this.pJm.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> t(aj<com.facebook.imagepipeline.f.e> ajVar) {
        p g;
        if (this.pJc) {
            g = this.pJm.g(this.pJm.h(ajVar));
        } else {
            g = this.pJm.g(ajVar);
        }
        return this.pJm.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return this.pJm.b(this.pJm.a(this.pJm.c(this.pJm.d(ajVar)), this.pIq));
    }

    private aj<com.facebook.imagepipeline.f.e> b(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        au n = this.pJm.n(this.pJm.a(l.a(ajVar), true, this.pJt));
        l lVar = this.pJm;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.f.e> b(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return this.pJm.a(this.pJm.a(awVarArr), true, this.pJt);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pJH.containsKey(ajVar)) {
            this.pJH.put(ajVar, this.pJm.k(this.pJm.l(ajVar)));
        }
        return this.pJH.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pJI.containsKey(ajVar)) {
            l lVar = this.pJm;
            this.pJI.put(ajVar, l.m(ajVar));
        }
        return this.pJI.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar2;
        ajVar2 = this.pJJ.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.pJm.p(ajVar);
            this.pJJ.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String aa(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
