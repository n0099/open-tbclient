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
/* loaded from: classes15.dex */
public class m {
    private final ContentResolver mContentResolver;
    private final af plN;
    private final boolean plR;
    private final boolean plV;
    private final at ply;
    private final boolean pmB;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmC;
    aj<com.facebook.imagepipeline.f.e> pmD;
    aj<com.facebook.imagepipeline.f.e> pmE;
    aj<Void> pmF;
    aj<Void> pmG;
    private aj<com.facebook.imagepipeline.f.e> pmH;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmI;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmJ;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmK;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmL;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmM;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmN;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmO;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pmP = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<Void>> pmQ = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pmR = new HashMap();
    private final boolean pmb;
    private final boolean pmg;
    private final boolean pmk;
    private final l pmu;

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.pmu = lVar;
        this.plN = afVar;
        this.plR = z;
        this.pmb = z2;
        this.ply = atVar;
        this.pmB = z3;
        this.pmg = z4;
        this.pmk = z5;
        this.plV = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.exn()) {
            case 0:
                return euY();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + Z(imageRequest.exm()));
            case 2:
            case 3:
                return eva();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.ewy().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (imageRequest.exu() != null) {
            f = v(f);
        }
        if (this.pmg) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (this.pmg) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri exm = imageRequest.exm();
        com.facebook.common.internal.g.checkNotNull(exm, "Uri is null.");
        switch (imageRequest.exn()) {
            case 0:
                return euW();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + Z(exm));
            case 2:
                return evd();
            case 3:
                return evc();
            case 4:
                if (com.facebook.common.d.a.Zf(this.mContentResolver.getType(exm))) {
                    return evd();
                }
                return eve();
            case 5:
                return evh();
            case 6:
                return evg();
            case 7:
                return evi();
            case 8:
                return evf();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> euW() {
        if (this.pmC == null) {
            this.pmC = r(euZ());
        }
        return this.pmC;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> euX() {
        if (this.pmE == null) {
            this.pmE = this.pmu.a(euZ(), this.ply);
        }
        return this.pmE;
    }

    private synchronized aj<Void> euY() {
        if (this.pmG == null) {
            this.pmG = l.m(euX());
        }
        return this.pmG;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> euZ() {
        if (this.pmH == null) {
            this.pmH = l.a(s(this.pmu.a(this.plN)));
            this.pmH = this.pmu.a(this.pmH, this.plR, this.pmB);
        }
        return this.pmH;
    }

    private synchronized aj<Void> eva() {
        if (this.pmF == null) {
            this.pmF = l.m(evb());
        }
        return this.pmF;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> evb() {
        if (this.pmD == null) {
            this.pmD = this.pmu.a(s(this.pmu.euS()), this.ply);
        }
        return this.pmD;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evc() {
        if (this.pmI == null) {
            this.pmI = q(this.pmu.euS());
        }
        return this.pmI;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evd() {
        if (this.pmJ == null) {
            this.pmJ = u(this.pmu.euV());
        }
        return this.pmJ;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eve() {
        if (this.pmK == null) {
            this.pmK = a(this.pmu.euP(), new aw[]{this.pmu.euQ(), this.pmu.euR()});
        }
        return this.pmK;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evf() {
        if (this.pmO == null) {
            this.pmO = q(this.pmu.euT());
        }
        return this.pmO;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evg() {
        if (this.pmL == null) {
            this.pmL = q(this.pmu.euU());
        }
        return this.pmL;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evh() {
        if (this.pmM == null) {
            this.pmM = q(this.pmu.euO());
        }
        return this.pmM;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evi() {
        if (this.pmN == null) {
            aj<com.facebook.imagepipeline.f.e> euN = this.pmu.euN();
            if (com.facebook.common.g.c.pcI && (!this.pmb || com.facebook.common.g.c.pcL == null)) {
                euN = this.pmu.o(euN);
            }
            l lVar = this.pmu;
            this.pmN = r(this.pmu.a(l.a(euN), true, this.pmB));
        }
        return this.pmN;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> q(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return a(ajVar, new aw[]{this.pmu.euR()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> r(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return u(this.pmu.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> s(aj<com.facebook.imagepipeline.f.e> ajVar) {
        if (com.facebook.common.g.c.pcI && (!this.pmb || com.facebook.common.g.c.pcL == null)) {
            ajVar = this.pmu.o(ajVar);
        }
        if (this.plV) {
            ajVar = t(ajVar);
        }
        return this.pmu.i(this.pmu.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> t(aj<com.facebook.imagepipeline.f.e> ajVar) {
        p g;
        if (this.pmk) {
            g = this.pmu.g(this.pmu.h(ajVar));
        } else {
            g = this.pmu.g(ajVar);
        }
        return this.pmu.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return this.pmu.b(this.pmu.a(this.pmu.c(this.pmu.d(ajVar)), this.ply));
    }

    private aj<com.facebook.imagepipeline.f.e> b(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        au n = this.pmu.n(this.pmu.a(l.a(ajVar), true, this.pmB));
        l lVar = this.pmu;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.f.e> b(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return this.pmu.a(this.pmu.a(awVarArr), true, this.pmB);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pmP.containsKey(ajVar)) {
            this.pmP.put(ajVar, this.pmu.k(this.pmu.l(ajVar)));
        }
        return this.pmP.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pmQ.containsKey(ajVar)) {
            l lVar = this.pmu;
            this.pmQ.put(ajVar, l.m(ajVar));
        }
        return this.pmQ.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar2;
        ajVar2 = this.pmR.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.pmu.p(ajVar);
            this.pmR.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String Z(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
