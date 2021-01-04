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
    private final boolean pBE;
    private final boolean pBJ;
    private final boolean pBN;
    private final l pBX;
    private final at pBb;
    private final af pBq;
    private final boolean pBu;
    private final boolean pBy;
    private final boolean pCe;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pCf;
    aj<com.facebook.imagepipeline.f.e> pCg;
    aj<com.facebook.imagepipeline.f.e> pCh;
    aj<Void> pCi;
    aj<Void> pCj;
    private aj<com.facebook.imagepipeline.f.e> pCk;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pCl;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pCm;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pCn;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pCo;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pCp;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pCq;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pCr;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pCs = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<Void>> pCt = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pCu = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.pBX = lVar;
        this.pBq = afVar;
        this.pBu = z;
        this.pBE = z2;
        this.pBb = atVar;
        this.pCe = z3;
        this.pBJ = z4;
        this.pBN = z5;
        this.pBy = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.eAU()) {
            case 0:
                return eyH();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + ad(imageRequest.eAT()));
            case 2:
            case 3:
                return eyJ();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.eAf().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (imageRequest.eBb() != null) {
            f = v(f);
        }
        if (this.pBJ) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (this.pBJ) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri eAT = imageRequest.eAT();
        com.facebook.common.internal.g.checkNotNull(eAT, "Uri is null.");
        switch (imageRequest.eAU()) {
            case 0:
                return eyF();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + ad(eAT));
            case 2:
                return eyM();
            case 3:
                return eyL();
            case 4:
                if (com.facebook.common.d.a.Zq(this.mContentResolver.getType(eAT))) {
                    return eyM();
                }
                return eyN();
            case 5:
                return eyQ();
            case 6:
                return eyP();
            case 7:
                return eyR();
            case 8:
                return eyO();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyF() {
        if (this.pCf == null) {
            this.pCf = r(eyI());
        }
        return this.pCf;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> eyG() {
        if (this.pCh == null) {
            this.pCh = this.pBX.a(eyI(), this.pBb);
        }
        return this.pCh;
    }

    private synchronized aj<Void> eyH() {
        if (this.pCj == null) {
            this.pCj = l.m(eyG());
        }
        return this.pCj;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> eyI() {
        if (this.pCk == null) {
            this.pCk = l.a(s(this.pBX.a(this.pBq)));
            this.pCk = this.pBX.a(this.pCk, this.pBu, this.pCe);
        }
        return this.pCk;
    }

    private synchronized aj<Void> eyJ() {
        if (this.pCi == null) {
            this.pCi = l.m(eyK());
        }
        return this.pCi;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> eyK() {
        if (this.pCg == null) {
            this.pCg = this.pBX.a(s(this.pBX.eyB()), this.pBb);
        }
        return this.pCg;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyL() {
        if (this.pCl == null) {
            this.pCl = q(this.pBX.eyB());
        }
        return this.pCl;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyM() {
        if (this.pCm == null) {
            this.pCm = u(this.pBX.eyE());
        }
        return this.pCm;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyN() {
        if (this.pCn == null) {
            this.pCn = a(this.pBX.eyy(), new aw[]{this.pBX.eyz(), this.pBX.eyA()});
        }
        return this.pCn;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyO() {
        if (this.pCr == null) {
            this.pCr = q(this.pBX.eyC());
        }
        return this.pCr;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyP() {
        if (this.pCo == null) {
            this.pCo = q(this.pBX.eyD());
        }
        return this.pCo;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyQ() {
        if (this.pCp == null) {
            this.pCp = q(this.pBX.eyx());
        }
        return this.pCp;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eyR() {
        if (this.pCq == null) {
            aj<com.facebook.imagepipeline.f.e> eyw = this.pBX.eyw();
            if (com.facebook.common.g.c.ptO && (!this.pBE || com.facebook.common.g.c.ptR == null)) {
                eyw = this.pBX.o(eyw);
            }
            l lVar = this.pBX;
            this.pCq = r(this.pBX.a(l.a(eyw), true, this.pCe));
        }
        return this.pCq;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> q(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return a(ajVar, new aw[]{this.pBX.eyA()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> r(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return u(this.pBX.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> s(aj<com.facebook.imagepipeline.f.e> ajVar) {
        if (com.facebook.common.g.c.ptO && (!this.pBE || com.facebook.common.g.c.ptR == null)) {
            ajVar = this.pBX.o(ajVar);
        }
        if (this.pBy) {
            ajVar = t(ajVar);
        }
        return this.pBX.i(this.pBX.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> t(aj<com.facebook.imagepipeline.f.e> ajVar) {
        p g;
        if (this.pBN) {
            g = this.pBX.g(this.pBX.h(ajVar));
        } else {
            g = this.pBX.g(ajVar);
        }
        return this.pBX.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return this.pBX.b(this.pBX.a(this.pBX.c(this.pBX.d(ajVar)), this.pBb));
    }

    private aj<com.facebook.imagepipeline.f.e> b(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        au n = this.pBX.n(this.pBX.a(l.a(ajVar), true, this.pCe));
        l lVar = this.pBX;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.f.e> b(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return this.pBX.a(this.pBX.a(awVarArr), true, this.pCe);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pCs.containsKey(ajVar)) {
            this.pCs.put(ajVar, this.pBX.k(this.pBX.l(ajVar)));
        }
        return this.pCs.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pCt.containsKey(ajVar)) {
            l lVar = this.pBX;
            this.pCt.put(ajVar, l.m(ajVar));
        }
        return this.pCt.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar2;
        ajVar2 = this.pCu.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.pBX.p(ajVar);
            this.pCu.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String ad(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
