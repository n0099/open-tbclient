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
    private final boolean lSE;
    private final boolean lSJ;
    private final boolean lSN;
    private final l lSX;
    private final at lSb;
    private final af lSq;
    private final boolean lSu;
    private final boolean lSy;
    private final boolean lTg;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTh;
    aj<com.facebook.imagepipeline.g.e> lTi;
    aj<com.facebook.imagepipeline.g.e> lTj;
    aj<Void> lTk;
    aj<Void> lTl;
    private aj<com.facebook.imagepipeline.g.e> lTm;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTn;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTo;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTp;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTq;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTr;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTs;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lTt;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lTu = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> lTv = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lTw = new HashMap();
    private final ContentResolver mContentResolver;

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.lSX = lVar;
        this.lSq = afVar;
        this.lSu = z;
        this.lSE = z2;
        this.lSb = atVar;
        this.lTg = z3;
        this.lSJ = z4;
        this.lSN = z5;
        this.lSy = z6;
    }

    public aj<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.dsr()) {
            case 0:
                return dpV();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + S(imageRequest.dsq()));
            case 2:
            case 3:
                return dpX();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.drz().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g = g(imageRequest);
        if (imageRequest.dsz() != null) {
            g = v(g);
        }
        if (this.lSJ) {
            return x(g);
        }
        return g;
    }

    public aj<Void> f(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g = g(imageRequest);
        if (this.lSJ) {
            g = x(g);
        }
        return w(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri dsq = imageRequest.dsq();
        com.facebook.common.internal.g.checkNotNull(dsq, "Uri is null.");
        switch (imageRequest.dsr()) {
            case 0:
                return dpT();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + S(dsq));
            case 2:
                return dqa();
            case 3:
                return dpZ();
            case 4:
                if (com.facebook.common.d.a.OQ(this.mContentResolver.getType(dsq))) {
                    return dqa();
                }
                return dqb();
            case 5:
                return dqe();
            case 6:
                return dqd();
            case 7:
                return dqf();
            case 8:
                return dqc();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dpT() {
        if (this.lTh == null) {
            this.lTh = r(dpW());
        }
        return this.lTh;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dpU() {
        if (this.lTj == null) {
            this.lTj = this.lSX.a(dpW(), this.lSb);
        }
        return this.lTj;
    }

    private synchronized aj<Void> dpV() {
        if (this.lTl == null) {
            this.lTl = l.m(dpU());
        }
        return this.lTl;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dpW() {
        if (this.lTm == null) {
            this.lTm = l.a(s(this.lSX.b(this.lSq)));
            this.lTm = this.lSX.a(this.lTm, this.lSu, this.lTg);
        }
        return this.lTm;
    }

    private synchronized aj<Void> dpX() {
        if (this.lTk == null) {
            this.lTk = l.m(dpY());
        }
        return this.lTk;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dpY() {
        if (this.lTi == null) {
            this.lTi = this.lSX.a(s(this.lSX.dpP()), this.lSb);
        }
        return this.lTi;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dpZ() {
        if (this.lTn == null) {
            this.lTn = q(this.lSX.dpP());
        }
        return this.lTn;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqa() {
        if (this.lTo == null) {
            this.lTo = u(this.lSX.dpS());
        }
        return this.lTo;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqb() {
        if (this.lTp == null) {
            this.lTp = a(this.lSX.dpM(), new aw[]{this.lSX.dpN(), this.lSX.dpO()});
        }
        return this.lTp;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqc() {
        if (this.lTt == null) {
            this.lTt = q(this.lSX.dpQ());
        }
        return this.lTt;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqd() {
        if (this.lTq == null) {
            this.lTq = q(this.lSX.dpR());
        }
        return this.lTq;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqe() {
        if (this.lTr == null) {
            this.lTr = q(this.lSX.dpL());
        }
        return this.lTr;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqf() {
        if (this.lTs == null) {
            aj<com.facebook.imagepipeline.g.e> dpK = this.lSX.dpK();
            if (com.facebook.common.g.c.lJe && (!this.lSE || com.facebook.common.g.c.lJg == null)) {
                dpK = this.lSX.o(dpK);
            }
            l lVar = this.lSX;
            this.lTs = r(this.lSX.a(l.a(dpK), true, this.lTg));
        }
        return this.lTs;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.lSX.dpO()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.lSX.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.lJe && (!this.lSE || com.facebook.common.g.c.lJg == null)) {
            ajVar = this.lSX.o(ajVar);
        }
        if (this.lSy) {
            ajVar = t(ajVar);
        }
        return this.lSX.i(this.lSX.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.lSN) {
            g = this.lSX.g(this.lSX.h(ajVar));
        } else {
            g = this.lSX.g(ajVar);
        }
        return this.lSX.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.lSX.b(this.lSX.a(this.lSX.c(this.lSX.d(ajVar)), this.lSb));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.lSX.n(this.lSX.a(l.a(ajVar), true, this.lTg));
        l lVar = this.lSX;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.lSX.a(this.lSX.a(awVarArr), true, this.lTg);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.lTu.containsKey(ajVar)) {
            this.lTu.put(ajVar, this.lSX.k(this.lSX.l(ajVar)));
        }
        return this.lTu.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.lTv.containsKey(ajVar)) {
            l lVar = this.lSX;
            this.lTv.put(ajVar, l.m(ajVar));
        }
        return this.lTv.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.lTw.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.lSX.p(ajVar);
            this.lTw.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String S(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
