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
    private final at pKV;
    private final boolean pLD;
    private final boolean pLH;
    private final l pLR;
    private final boolean pLY;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pLZ;
    private final af pLk;
    private final boolean pLo;
    private final boolean pLs;
    private final boolean pLy;
    aj<com.facebook.imagepipeline.f.e> pMa;
    aj<com.facebook.imagepipeline.f.e> pMb;
    aj<Void> pMc;
    aj<Void> pMd;
    private aj<com.facebook.imagepipeline.f.e> pMe;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pMf;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pMg;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pMh;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pMi;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pMj;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pMk;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pMl;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pMm = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<Void>> pMn = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pMo = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.pLR = lVar;
        this.pLk = afVar;
        this.pLo = z;
        this.pLy = z2;
        this.pKV = atVar;
        this.pLY = z3;
        this.pLD = z4;
        this.pLH = z5;
        this.pLs = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.eAp()) {
            case 0:
                return eyb();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + aa(imageRequest.eAo()));
            case 2:
            case 3:
                return eyd();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.ezA().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (imageRequest.eAw() != null) {
            f = v(f);
        }
        if (this.pLD) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (this.pLD) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri eAo = imageRequest.eAo();
        com.facebook.common.internal.g.checkNotNull(eAo, "Uri is null.");
        switch (imageRequest.eAp()) {
            case 0:
                return exZ();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + aa(eAo));
            case 2:
                return eyg();
            case 3:
                return eyf();
            case 4:
                if (com.facebook.common.d.a.ZB(this.mContentResolver.getType(eAo))) {
                    return eyg();
                }
                return eyh();
            case 5:
                return eyk();
            case 6:
                return eyj();
            case 7:
                return eyl();
            case 8:
                return eyi();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exZ() {
        if (this.pLZ == null) {
            this.pLZ = r(eyc());
        }
        return this.pLZ;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> eya() {
        if (this.pMb == null) {
            this.pMb = this.pLR.a(eyc(), this.pKV);
        }
        return this.pMb;
    }

    private synchronized aj<Void> eyb() {
        if (this.pMd == null) {
            this.pMd = l.m(eya());
        }
        return this.pMd;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> eyc() {
        if (this.pMe == null) {
            this.pMe = l.a(s(this.pLR.a(this.pLk)));
            this.pMe = this.pLR.a(this.pMe, this.pLo, this.pLY);
        }
        return this.pMe;
    }

    private synchronized aj<Void> eyd() {
        if (this.pMc == null) {
            this.pMc = l.m(eye());
        }
        return this.pMc;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> eye() {
        if (this.pMa == null) {
            this.pMa = this.pLR.a(s(this.pLR.exV()), this.pKV);
        }
        return this.pMa;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyf() {
        if (this.pMf == null) {
            this.pMf = q(this.pLR.exV());
        }
        return this.pMf;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyg() {
        if (this.pMg == null) {
            this.pMg = u(this.pLR.exY());
        }
        return this.pMg;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyh() {
        if (this.pMh == null) {
            this.pMh = a(this.pLR.exS(), new aw[]{this.pLR.exT(), this.pLR.exU()});
        }
        return this.pMh;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyi() {
        if (this.pMl == null) {
            this.pMl = q(this.pLR.exW());
        }
        return this.pMl;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyj() {
        if (this.pMi == null) {
            this.pMi = q(this.pLR.exX());
        }
        return this.pMi;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyk() {
        if (this.pMj == null) {
            this.pMj = q(this.pLR.exR());
        }
        return this.pMj;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyl() {
        if (this.pMk == null) {
            aj<com.facebook.imagepipeline.f.e> exQ = this.pLR.exQ();
            if (com.facebook.common.g.c.pCi && (!this.pLy || com.facebook.common.g.c.pCl == null)) {
                exQ = this.pLR.o(exQ);
            }
            l lVar = this.pLR;
            this.pMk = r(this.pLR.a(l.a(exQ), true, this.pLY));
        }
        return this.pMk;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> q(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return a(ajVar, new aw[]{this.pLR.exU()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> r(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return u(this.pLR.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> s(aj<com.facebook.imagepipeline.f.e> ajVar) {
        if (com.facebook.common.g.c.pCi && (!this.pLy || com.facebook.common.g.c.pCl == null)) {
            ajVar = this.pLR.o(ajVar);
        }
        if (this.pLs) {
            ajVar = t(ajVar);
        }
        return this.pLR.i(this.pLR.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> t(aj<com.facebook.imagepipeline.f.e> ajVar) {
        p g;
        if (this.pLH) {
            g = this.pLR.g(this.pLR.h(ajVar));
        } else {
            g = this.pLR.g(ajVar);
        }
        return this.pLR.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return this.pLR.b(this.pLR.a(this.pLR.c(this.pLR.d(ajVar)), this.pKV));
    }

    private aj<com.facebook.imagepipeline.f.e> b(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        au n = this.pLR.n(this.pLR.a(l.a(ajVar), true, this.pLY));
        l lVar = this.pLR;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.f.e> b(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return this.pLR.a(this.pLR.a(awVarArr), true, this.pLY);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pMm.containsKey(ajVar)) {
            this.pMm.put(ajVar, this.pLR.k(this.pLR.l(ajVar)));
        }
        return this.pMm.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pMn.containsKey(ajVar)) {
            l lVar = this.pLR;
            this.pMn.put(ajVar, l.m(ajVar));
        }
        return this.pMn.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar2;
        ajVar2 = this.pMo.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.pLR.p(ajVar);
            this.pMo.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String aa(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
