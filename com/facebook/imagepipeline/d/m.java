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
    private final at mbJ;
    private final af mbY;
    private final l mcF;
    private final boolean mcM;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcN;
    aj<com.facebook.imagepipeline.g.e> mcO;
    aj<com.facebook.imagepipeline.g.e> mcP;
    aj<Void> mcQ;
    aj<Void> mcR;
    private aj<com.facebook.imagepipeline.g.e> mcS;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcT;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcU;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcV;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcW;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcX;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcY;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mcZ;
    private final boolean mcc;
    private final boolean mcg;
    private final boolean mcm;
    private final boolean mcr;
    private final boolean mcv;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> mda = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> mdb = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> mdc = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.mcF = lVar;
        this.mbY = afVar;
        this.mcc = z;
        this.mcm = z2;
        this.mbJ = atVar;
        this.mcM = z3;
        this.mcr = z4;
        this.mcv = z5;
        this.mcg = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.duK()) {
            case 0:
                return dsp();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + T(imageRequest.duJ()));
            case 2:
            case 3:
                return dsr();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.dtT().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.duR() != null) {
            f = v(f);
        }
        if (this.mcr) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.mcr) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri duJ = imageRequest.duJ();
        com.facebook.common.internal.g.checkNotNull(duJ, "Uri is null.");
        switch (imageRequest.duK()) {
            case 0:
                return dsn();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + T(duJ));
            case 2:
                return dsu();
            case 3:
                return dst();
            case 4:
                if (com.facebook.common.d.a.Ob(this.mContentResolver.getType(duJ))) {
                    return dsu();
                }
                return dsv();
            case 5:
                return dsy();
            case 6:
                return dsx();
            case 7:
                return dsz();
            case 8:
                return dsw();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsn() {
        if (this.mcN == null) {
            this.mcN = r(dsq());
        }
        return this.mcN;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dso() {
        if (this.mcP == null) {
            this.mcP = this.mcF.a(dsq(), this.mbJ);
        }
        return this.mcP;
    }

    private synchronized aj<Void> dsp() {
        if (this.mcR == null) {
            this.mcR = l.m(dso());
        }
        return this.mcR;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dsq() {
        if (this.mcS == null) {
            this.mcS = l.a(s(this.mcF.b(this.mbY)));
            this.mcS = this.mcF.a(this.mcS, this.mcc, this.mcM);
        }
        return this.mcS;
    }

    private synchronized aj<Void> dsr() {
        if (this.mcQ == null) {
            this.mcQ = l.m(dss());
        }
        return this.mcQ;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dss() {
        if (this.mcO == null) {
            this.mcO = this.mcF.a(s(this.mcF.dsj()), this.mbJ);
        }
        return this.mcO;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dst() {
        if (this.mcT == null) {
            this.mcT = q(this.mcF.dsj());
        }
        return this.mcT;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsu() {
        if (this.mcU == null) {
            this.mcU = u(this.mcF.dsm());
        }
        return this.mcU;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsv() {
        if (this.mcV == null) {
            this.mcV = a(this.mcF.dsg(), new aw[]{this.mcF.dsh(), this.mcF.dsi()});
        }
        return this.mcV;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsw() {
        if (this.mcZ == null) {
            this.mcZ = q(this.mcF.dsk());
        }
        return this.mcZ;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsx() {
        if (this.mcW == null) {
            this.mcW = q(this.mcF.dsl());
        }
        return this.mcW;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsy() {
        if (this.mcX == null) {
            this.mcX = q(this.mcF.dsf());
        }
        return this.mcX;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsz() {
        if (this.mcY == null) {
            aj<com.facebook.imagepipeline.g.e> dse = this.mcF.dse();
            if (com.facebook.common.g.c.lSt && (!this.mcm || com.facebook.common.g.c.lSw == null)) {
                dse = this.mcF.o(dse);
            }
            l lVar = this.mcF;
            this.mcY = r(this.mcF.a(l.a(dse), true, this.mcM));
        }
        return this.mcY;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.mcF.dsi()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.mcF.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.lSt && (!this.mcm || com.facebook.common.g.c.lSw == null)) {
            ajVar = this.mcF.o(ajVar);
        }
        if (this.mcg) {
            ajVar = t(ajVar);
        }
        return this.mcF.i(this.mcF.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.mcv) {
            g = this.mcF.g(this.mcF.h(ajVar));
        } else {
            g = this.mcF.g(ajVar);
        }
        return this.mcF.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.mcF.b(this.mcF.a(this.mcF.c(this.mcF.d(ajVar)), this.mbJ));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.mcF.n(this.mcF.a(l.a(ajVar), true, this.mcM));
        l lVar = this.mcF;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.mcF.a(this.mcF.a(awVarArr), true, this.mcM);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.mda.containsKey(ajVar)) {
            this.mda.put(ajVar, this.mcF.k(this.mcF.l(ajVar)));
        }
        return this.mda.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.mdb.containsKey(ajVar)) {
            l lVar = this.mcF;
            this.mdb.put(ajVar, l.m(ajVar));
        }
        return this.mdb.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.mdc.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.mcF.p(ajVar);
            this.mdc.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String T(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
