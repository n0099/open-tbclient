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
    private final af plL;
    private final boolean plP;
    private final boolean plT;
    private final boolean plZ;
    private final at plw;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmA;
    aj<com.facebook.imagepipeline.f.e> pmB;
    aj<com.facebook.imagepipeline.f.e> pmC;
    aj<Void> pmD;
    aj<Void> pmE;
    private aj<com.facebook.imagepipeline.f.e> pmF;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmG;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmH;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmI;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmJ;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmK;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmL;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pmM;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pmN = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<Void>> pmO = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pmP = new HashMap();
    private final boolean pme;
    private final boolean pmi;
    private final l pms;
    private final boolean pmz;

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.pms = lVar;
        this.plL = afVar;
        this.plP = z;
        this.plZ = z2;
        this.plw = atVar;
        this.pmz = z3;
        this.pme = z4;
        this.pmi = z5;
        this.plT = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.exm()) {
            case 0:
                return euX();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + Z(imageRequest.exl()));
            case 2:
            case 3:
                return euZ();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.ewx().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (imageRequest.ext() != null) {
            f = v(f);
        }
        if (this.pme) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (this.pme) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri exl = imageRequest.exl();
        com.facebook.common.internal.g.checkNotNull(exl, "Uri is null.");
        switch (imageRequest.exm()) {
            case 0:
                return euV();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + Z(exl));
            case 2:
                return evc();
            case 3:
                return evb();
            case 4:
                if (com.facebook.common.d.a.Zf(this.mContentResolver.getType(exl))) {
                    return evc();
                }
                return evd();
            case 5:
                return evg();
            case 6:
                return evf();
            case 7:
                return evh();
            case 8:
                return eve();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> euV() {
        if (this.pmA == null) {
            this.pmA = r(euY());
        }
        return this.pmA;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> euW() {
        if (this.pmC == null) {
            this.pmC = this.pms.a(euY(), this.plw);
        }
        return this.pmC;
    }

    private synchronized aj<Void> euX() {
        if (this.pmE == null) {
            this.pmE = l.m(euW());
        }
        return this.pmE;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> euY() {
        if (this.pmF == null) {
            this.pmF = l.a(s(this.pms.a(this.plL)));
            this.pmF = this.pms.a(this.pmF, this.plP, this.pmz);
        }
        return this.pmF;
    }

    private synchronized aj<Void> euZ() {
        if (this.pmD == null) {
            this.pmD = l.m(eva());
        }
        return this.pmD;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> eva() {
        if (this.pmB == null) {
            this.pmB = this.pms.a(s(this.pms.euR()), this.plw);
        }
        return this.pmB;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evb() {
        if (this.pmG == null) {
            this.pmG = q(this.pms.euR());
        }
        return this.pmG;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evc() {
        if (this.pmH == null) {
            this.pmH = u(this.pms.euU());
        }
        return this.pmH;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evd() {
        if (this.pmI == null) {
            this.pmI = a(this.pms.euO(), new aw[]{this.pms.euP(), this.pms.euQ()});
        }
        return this.pmI;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eve() {
        if (this.pmM == null) {
            this.pmM = q(this.pms.euS());
        }
        return this.pmM;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evf() {
        if (this.pmJ == null) {
            this.pmJ = q(this.pms.euT());
        }
        return this.pmJ;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evg() {
        if (this.pmK == null) {
            this.pmK = q(this.pms.euN());
        }
        return this.pmK;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evh() {
        if (this.pmL == null) {
            aj<com.facebook.imagepipeline.f.e> euM = this.pms.euM();
            if (com.facebook.common.g.c.pcG && (!this.plZ || com.facebook.common.g.c.pcJ == null)) {
                euM = this.pms.o(euM);
            }
            l lVar = this.pms;
            this.pmL = r(this.pms.a(l.a(euM), true, this.pmz));
        }
        return this.pmL;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> q(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return a(ajVar, new aw[]{this.pms.euQ()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> r(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return u(this.pms.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> s(aj<com.facebook.imagepipeline.f.e> ajVar) {
        if (com.facebook.common.g.c.pcG && (!this.plZ || com.facebook.common.g.c.pcJ == null)) {
            ajVar = this.pms.o(ajVar);
        }
        if (this.plT) {
            ajVar = t(ajVar);
        }
        return this.pms.i(this.pms.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> t(aj<com.facebook.imagepipeline.f.e> ajVar) {
        p g;
        if (this.pmi) {
            g = this.pms.g(this.pms.h(ajVar));
        } else {
            g = this.pms.g(ajVar);
        }
        return this.pms.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return this.pms.b(this.pms.a(this.pms.c(this.pms.d(ajVar)), this.plw));
    }

    private aj<com.facebook.imagepipeline.f.e> b(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        au n = this.pms.n(this.pms.a(l.a(ajVar), true, this.pmz));
        l lVar = this.pms;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.f.e> b(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return this.pms.a(this.pms.a(awVarArr), true, this.pmz);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pmN.containsKey(ajVar)) {
            this.pmN.put(ajVar, this.pms.k(this.pms.l(ajVar)));
        }
        return this.pmN.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pmO.containsKey(ajVar)) {
            l lVar = this.pms;
            this.pmO.put(ajVar, l.m(ajVar));
        }
        return this.pmO.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar2;
        ajVar2 = this.pmP.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.pms.p(ajVar);
            this.pmP.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String Z(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
