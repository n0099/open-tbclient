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
    private final at mbF;
    private final af mbU;
    private final boolean mbY;
    private final l mcB;
    private final boolean mcI;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcJ;
    aj<com.facebook.imagepipeline.g.e> mcK;
    aj<com.facebook.imagepipeline.g.e> mcL;
    aj<Void> mcM;
    aj<Void> mcN;
    private aj<com.facebook.imagepipeline.g.e> mcO;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcP;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcQ;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcR;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcS;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcT;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcU;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcV;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> mcW = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> mcX = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> mcY = new HashMap();
    private final boolean mcc;
    private final boolean mci;
    private final boolean mcn;
    private final boolean mcr;

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.mcB = lVar;
        this.mbU = afVar;
        this.mbY = z;
        this.mci = z2;
        this.mbF = atVar;
        this.mcI = z3;
        this.mcn = z4;
        this.mcr = z5;
        this.mcc = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.duM()) {
            case 0:
                return dsr();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + T(imageRequest.duL()));
            case 2:
            case 3:
                return dst();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.dtV().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.duT() != null) {
            f = v(f);
        }
        if (this.mcn) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.mcn) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri duL = imageRequest.duL();
        com.facebook.common.internal.g.checkNotNull(duL, "Uri is null.");
        switch (imageRequest.duM()) {
            case 0:
                return dsp();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + T(duL));
            case 2:
                return dsw();
            case 3:
                return dsv();
            case 4:
                if (com.facebook.common.d.a.NY(this.mContentResolver.getType(duL))) {
                    return dsw();
                }
                return dsx();
            case 5:
                return dsA();
            case 6:
                return dsz();
            case 7:
                return dsB();
            case 8:
                return dsy();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsp() {
        if (this.mcJ == null) {
            this.mcJ = r(dss());
        }
        return this.mcJ;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dsq() {
        if (this.mcL == null) {
            this.mcL = this.mcB.a(dss(), this.mbF);
        }
        return this.mcL;
    }

    private synchronized aj<Void> dsr() {
        if (this.mcN == null) {
            this.mcN = l.m(dsq());
        }
        return this.mcN;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dss() {
        if (this.mcO == null) {
            this.mcO = l.a(s(this.mcB.b(this.mbU)));
            this.mcO = this.mcB.a(this.mcO, this.mbY, this.mcI);
        }
        return this.mcO;
    }

    private synchronized aj<Void> dst() {
        if (this.mcM == null) {
            this.mcM = l.m(dsu());
        }
        return this.mcM;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dsu() {
        if (this.mcK == null) {
            this.mcK = this.mcB.a(s(this.mcB.dsl()), this.mbF);
        }
        return this.mcK;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsv() {
        if (this.mcP == null) {
            this.mcP = q(this.mcB.dsl());
        }
        return this.mcP;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsw() {
        if (this.mcQ == null) {
            this.mcQ = u(this.mcB.dso());
        }
        return this.mcQ;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsx() {
        if (this.mcR == null) {
            this.mcR = a(this.mcB.dsi(), new aw[]{this.mcB.dsj(), this.mcB.dsk()});
        }
        return this.mcR;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsy() {
        if (this.mcV == null) {
            this.mcV = q(this.mcB.dsm());
        }
        return this.mcV;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsz() {
        if (this.mcS == null) {
            this.mcS = q(this.mcB.dsn());
        }
        return this.mcS;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsA() {
        if (this.mcT == null) {
            this.mcT = q(this.mcB.dsh());
        }
        return this.mcT;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsB() {
        if (this.mcU == null) {
            aj<com.facebook.imagepipeline.g.e> dsg = this.mcB.dsg();
            if (com.facebook.common.g.c.lSp && (!this.mci || com.facebook.common.g.c.lSs == null)) {
                dsg = this.mcB.o(dsg);
            }
            l lVar = this.mcB;
            this.mcU = r(this.mcB.a(l.a(dsg), true, this.mcI));
        }
        return this.mcU;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.mcB.dsk()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.mcB.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.lSp && (!this.mci || com.facebook.common.g.c.lSs == null)) {
            ajVar = this.mcB.o(ajVar);
        }
        if (this.mcc) {
            ajVar = t(ajVar);
        }
        return this.mcB.i(this.mcB.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.mcr) {
            g = this.mcB.g(this.mcB.h(ajVar));
        } else {
            g = this.mcB.g(ajVar);
        }
        return this.mcB.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.mcB.b(this.mcB.a(this.mcB.c(this.mcB.d(ajVar)), this.mbF));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.mcB.n(this.mcB.a(l.a(ajVar), true, this.mcI));
        l lVar = this.mcB;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.mcB.a(this.mcB.a(awVarArr), true, this.mcI);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.mcW.containsKey(ajVar)) {
            this.mcW.put(ajVar, this.mcB.k(this.mcB.l(ajVar)));
        }
        return this.mcW.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.mcX.containsKey(ajVar)) {
            l lVar = this.mcB;
            this.mcX.put(ajVar, l.m(ajVar));
        }
        return this.mcX.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.mcY.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.mcB.p(ajVar);
            this.mcY.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String T(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
