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
    private final at lRZ;
    private final boolean lSC;
    private final boolean lSH;
    private final boolean lSL;
    private final l lSV;
    private final af lSo;
    private final boolean lSs;
    private final boolean lSw;
    private final boolean lTe;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTf;
    aj<com.facebook.imagepipeline.g.e> lTg;
    aj<com.facebook.imagepipeline.g.e> lTh;
    aj<Void> lTi;
    aj<Void> lTj;
    private aj<com.facebook.imagepipeline.g.e> lTk;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTl;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTm;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTn;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTo;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTp;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTq;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTr;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lTs = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> lTt = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lTu = new HashMap();
    private final ContentResolver mContentResolver;

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.lSV = lVar;
        this.lSo = afVar;
        this.lSs = z;
        this.lSC = z2;
        this.lRZ = atVar;
        this.lTe = z3;
        this.lSH = z4;
        this.lSL = z5;
        this.lSw = z6;
    }

    public aj<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.dsp()) {
            case 0:
                return dpT();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + S(imageRequest.dso()));
            case 2:
            case 3:
                return dpV();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.drx().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g = g(imageRequest);
        if (imageRequest.dsx() != null) {
            g = v(g);
        }
        if (this.lSH) {
            return x(g);
        }
        return g;
    }

    public aj<Void> f(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g = g(imageRequest);
        if (this.lSH) {
            g = x(g);
        }
        return w(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri dso = imageRequest.dso();
        com.facebook.common.internal.g.checkNotNull(dso, "Uri is null.");
        switch (imageRequest.dsp()) {
            case 0:
                return dpR();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + S(dso));
            case 2:
                return dpY();
            case 3:
                return dpX();
            case 4:
                if (com.facebook.common.d.a.OQ(this.mContentResolver.getType(dso))) {
                    return dpY();
                }
                return dpZ();
            case 5:
                return dqc();
            case 6:
                return dqb();
            case 7:
                return dqd();
            case 8:
                return dqa();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dpR() {
        if (this.lTf == null) {
            this.lTf = r(dpU());
        }
        return this.lTf;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dpS() {
        if (this.lTh == null) {
            this.lTh = this.lSV.a(dpU(), this.lRZ);
        }
        return this.lTh;
    }

    private synchronized aj<Void> dpT() {
        if (this.lTj == null) {
            this.lTj = l.m(dpS());
        }
        return this.lTj;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dpU() {
        if (this.lTk == null) {
            this.lTk = l.a(s(this.lSV.b(this.lSo)));
            this.lTk = this.lSV.a(this.lTk, this.lSs, this.lTe);
        }
        return this.lTk;
    }

    private synchronized aj<Void> dpV() {
        if (this.lTi == null) {
            this.lTi = l.m(dpW());
        }
        return this.lTi;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dpW() {
        if (this.lTg == null) {
            this.lTg = this.lSV.a(s(this.lSV.dpN()), this.lRZ);
        }
        return this.lTg;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dpX() {
        if (this.lTl == null) {
            this.lTl = q(this.lSV.dpN());
        }
        return this.lTl;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dpY() {
        if (this.lTm == null) {
            this.lTm = u(this.lSV.dpQ());
        }
        return this.lTm;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dpZ() {
        if (this.lTn == null) {
            this.lTn = a(this.lSV.dpK(), new aw[]{this.lSV.dpL(), this.lSV.dpM()});
        }
        return this.lTn;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqa() {
        if (this.lTr == null) {
            this.lTr = q(this.lSV.dpO());
        }
        return this.lTr;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqb() {
        if (this.lTo == null) {
            this.lTo = q(this.lSV.dpP());
        }
        return this.lTo;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqc() {
        if (this.lTp == null) {
            this.lTp = q(this.lSV.dpJ());
        }
        return this.lTp;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqd() {
        if (this.lTq == null) {
            aj<com.facebook.imagepipeline.g.e> dpI = this.lSV.dpI();
            if (com.facebook.common.g.c.lJc && (!this.lSC || com.facebook.common.g.c.lJe == null)) {
                dpI = this.lSV.o(dpI);
            }
            l lVar = this.lSV;
            this.lTq = r(this.lSV.a(l.a(dpI), true, this.lTe));
        }
        return this.lTq;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.lSV.dpM()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.lSV.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.lJc && (!this.lSC || com.facebook.common.g.c.lJe == null)) {
            ajVar = this.lSV.o(ajVar);
        }
        if (this.lSw) {
            ajVar = t(ajVar);
        }
        return this.lSV.i(this.lSV.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.lSL) {
            g = this.lSV.g(this.lSV.h(ajVar));
        } else {
            g = this.lSV.g(ajVar);
        }
        return this.lSV.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.lSV.b(this.lSV.a(this.lSV.c(this.lSV.d(ajVar)), this.lRZ));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.lSV.n(this.lSV.a(l.a(ajVar), true, this.lTe));
        l lVar = this.lSV;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.lSV.a(this.lSV.a(awVarArr), true, this.lTe);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.lTs.containsKey(ajVar)) {
            this.lTs.put(ajVar, this.lSV.k(this.lSV.l(ajVar)));
        }
        return this.lTs.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.lTt.containsKey(ajVar)) {
            l lVar = this.lSV;
            this.lTt.put(ajVar, l.m(ajVar));
        }
        return this.lTt.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.lTu.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.lSV.p(ajVar);
            this.lTu.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String S(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
