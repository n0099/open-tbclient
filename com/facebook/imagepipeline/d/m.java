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
/* loaded from: classes4.dex */
public class m {
    private final ContentResolver mContentResolver;
    private final at naV;
    private final boolean nbD;
    private final boolean nbH;
    private final l nbR;
    private final af nbk;
    private final boolean nbo;
    private final boolean nbs;
    private final boolean nby;
    private final boolean nca;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ncb;
    aj<com.facebook.imagepipeline.g.e> ncc;
    aj<com.facebook.imagepipeline.g.e> ncd;
    aj<Void> nce;
    aj<Void> ncf;
    private aj<com.facebook.imagepipeline.g.e> ncg;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nch;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nci;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ncj;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nck;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ncl;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ncm;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ncn;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> nco = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> ncp = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> ncq = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.nbR = lVar;
        this.nbk = afVar;
        this.nbo = z;
        this.nby = z2;
        this.naV = atVar;
        this.nca = z3;
        this.nbD = z4;
        this.nbH = z5;
        this.nbs = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.dKi()) {
            case 0:
                return dHO();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + V(imageRequest.dKh()));
            case 2:
            case 3:
                return dHQ();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.dJr().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.dKp() != null) {
            f = v(f);
        }
        if (this.nbD) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.nbD) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri dKh = imageRequest.dKh();
        com.facebook.common.internal.g.checkNotNull(dKh, "Uri is null.");
        switch (imageRequest.dKi()) {
            case 0:
                return dHM();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + V(dKh));
            case 2:
                return dHT();
            case 3:
                return dHS();
            case 4:
                if (com.facebook.common.d.a.Ro(this.mContentResolver.getType(dKh))) {
                    return dHT();
                }
                return dHU();
            case 5:
                return dHX();
            case 6:
                return dHW();
            case 7:
                return dHY();
            case 8:
                return dHV();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHM() {
        if (this.ncb == null) {
            this.ncb = r(dHP());
        }
        return this.ncb;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dHN() {
        if (this.ncd == null) {
            this.ncd = this.nbR.a(dHP(), this.naV);
        }
        return this.ncd;
    }

    private synchronized aj<Void> dHO() {
        if (this.ncf == null) {
            this.ncf = l.m(dHN());
        }
        return this.ncf;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dHP() {
        if (this.ncg == null) {
            this.ncg = l.a(s(this.nbR.b(this.nbk)));
            this.ncg = this.nbR.a(this.ncg, this.nbo, this.nca);
        }
        return this.ncg;
    }

    private synchronized aj<Void> dHQ() {
        if (this.nce == null) {
            this.nce = l.m(dHR());
        }
        return this.nce;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dHR() {
        if (this.ncc == null) {
            this.ncc = this.nbR.a(s(this.nbR.dHI()), this.naV);
        }
        return this.ncc;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHS() {
        if (this.nch == null) {
            this.nch = q(this.nbR.dHI());
        }
        return this.nch;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHT() {
        if (this.nci == null) {
            this.nci = u(this.nbR.dHL());
        }
        return this.nci;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHU() {
        if (this.ncj == null) {
            this.ncj = a(this.nbR.dHF(), new aw[]{this.nbR.dHG(), this.nbR.dHH()});
        }
        return this.ncj;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHV() {
        if (this.ncn == null) {
            this.ncn = q(this.nbR.dHJ());
        }
        return this.ncn;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHW() {
        if (this.nck == null) {
            this.nck = q(this.nbR.dHK());
        }
        return this.nck;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHX() {
        if (this.ncl == null) {
            this.ncl = q(this.nbR.dHE());
        }
        return this.ncl;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHY() {
        if (this.ncm == null) {
            aj<com.facebook.imagepipeline.g.e> dHD = this.nbR.dHD();
            if (com.facebook.common.g.c.mRD && (!this.nby || com.facebook.common.g.c.mRG == null)) {
                dHD = this.nbR.o(dHD);
            }
            l lVar = this.nbR;
            this.ncm = r(this.nbR.a(l.a(dHD), true, this.nca));
        }
        return this.ncm;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.nbR.dHH()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.nbR.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.mRD && (!this.nby || com.facebook.common.g.c.mRG == null)) {
            ajVar = this.nbR.o(ajVar);
        }
        if (this.nbs) {
            ajVar = t(ajVar);
        }
        return this.nbR.i(this.nbR.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.nbH) {
            g = this.nbR.g(this.nbR.h(ajVar));
        } else {
            g = this.nbR.g(ajVar);
        }
        return this.nbR.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.nbR.b(this.nbR.a(this.nbR.c(this.nbR.d(ajVar)), this.naV));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.nbR.n(this.nbR.a(l.a(ajVar), true, this.nca));
        l lVar = this.nbR;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.nbR.a(this.nbR.a(awVarArr), true, this.nca);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.nco.containsKey(ajVar)) {
            this.nco.put(ajVar, this.nbR.k(this.nbR.l(ajVar)));
        }
        return this.nco.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.ncp.containsKey(ajVar)) {
            l lVar = this.nbR;
            this.ncp.put(ajVar, l.m(ajVar));
        }
        return this.ncp.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.ncq.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.nbR.p(ajVar);
            this.ncq.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String V(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
