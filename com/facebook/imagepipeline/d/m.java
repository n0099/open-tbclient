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
    private final at naT;
    private final boolean nbB;
    private final boolean nbF;
    private final l nbP;
    private final boolean nbY;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nbZ;
    private final af nbi;
    private final boolean nbm;
    private final boolean nbq;
    private final boolean nbw;
    aj<com.facebook.imagepipeline.g.e> nca;
    aj<com.facebook.imagepipeline.g.e> ncb;
    aj<Void> ncc;
    aj<Void> ncd;
    private aj<com.facebook.imagepipeline.g.e> nce;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ncf;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ncg;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nch;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nci;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ncj;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nck;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ncl;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> ncm = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> ncn = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> nco = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.nbP = lVar;
        this.nbi = afVar;
        this.nbm = z;
        this.nbw = z2;
        this.naT = atVar;
        this.nbY = z3;
        this.nbB = z4;
        this.nbF = z5;
        this.nbq = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.dKh()) {
            case 0:
                return dHN();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + V(imageRequest.dKg()));
            case 2:
            case 3:
                return dHP();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.dJq().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.dKo() != null) {
            f = v(f);
        }
        if (this.nbB) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.nbB) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri dKg = imageRequest.dKg();
        com.facebook.common.internal.g.checkNotNull(dKg, "Uri is null.");
        switch (imageRequest.dKh()) {
            case 0:
                return dHL();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + V(dKg));
            case 2:
                return dHS();
            case 3:
                return dHR();
            case 4:
                if (com.facebook.common.d.a.Ro(this.mContentResolver.getType(dKg))) {
                    return dHS();
                }
                return dHT();
            case 5:
                return dHW();
            case 6:
                return dHV();
            case 7:
                return dHX();
            case 8:
                return dHU();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHL() {
        if (this.nbZ == null) {
            this.nbZ = r(dHO());
        }
        return this.nbZ;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dHM() {
        if (this.ncb == null) {
            this.ncb = this.nbP.a(dHO(), this.naT);
        }
        return this.ncb;
    }

    private synchronized aj<Void> dHN() {
        if (this.ncd == null) {
            this.ncd = l.m(dHM());
        }
        return this.ncd;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dHO() {
        if (this.nce == null) {
            this.nce = l.a(s(this.nbP.b(this.nbi)));
            this.nce = this.nbP.a(this.nce, this.nbm, this.nbY);
        }
        return this.nce;
    }

    private synchronized aj<Void> dHP() {
        if (this.ncc == null) {
            this.ncc = l.m(dHQ());
        }
        return this.ncc;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dHQ() {
        if (this.nca == null) {
            this.nca = this.nbP.a(s(this.nbP.dHH()), this.naT);
        }
        return this.nca;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHR() {
        if (this.ncf == null) {
            this.ncf = q(this.nbP.dHH());
        }
        return this.ncf;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHS() {
        if (this.ncg == null) {
            this.ncg = u(this.nbP.dHK());
        }
        return this.ncg;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHT() {
        if (this.nch == null) {
            this.nch = a(this.nbP.dHE(), new aw[]{this.nbP.dHF(), this.nbP.dHG()});
        }
        return this.nch;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHU() {
        if (this.ncl == null) {
            this.ncl = q(this.nbP.dHI());
        }
        return this.ncl;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHV() {
        if (this.nci == null) {
            this.nci = q(this.nbP.dHJ());
        }
        return this.nci;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHW() {
        if (this.ncj == null) {
            this.ncj = q(this.nbP.dHD());
        }
        return this.ncj;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dHX() {
        if (this.nck == null) {
            aj<com.facebook.imagepipeline.g.e> dHC = this.nbP.dHC();
            if (com.facebook.common.g.c.mRB && (!this.nbw || com.facebook.common.g.c.mRE == null)) {
                dHC = this.nbP.o(dHC);
            }
            l lVar = this.nbP;
            this.nck = r(this.nbP.a(l.a(dHC), true, this.nbY));
        }
        return this.nck;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.nbP.dHG()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.nbP.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.mRB && (!this.nbw || com.facebook.common.g.c.mRE == null)) {
            ajVar = this.nbP.o(ajVar);
        }
        if (this.nbq) {
            ajVar = t(ajVar);
        }
        return this.nbP.i(this.nbP.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.nbF) {
            g = this.nbP.g(this.nbP.h(ajVar));
        } else {
            g = this.nbP.g(ajVar);
        }
        return this.nbP.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.nbP.b(this.nbP.a(this.nbP.c(this.nbP.d(ajVar)), this.naT));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.nbP.n(this.nbP.a(l.a(ajVar), true, this.nbY));
        l lVar = this.nbP;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.nbP.a(this.nbP.a(awVarArr), true, this.nbY);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.ncm.containsKey(ajVar)) {
            this.ncm.put(ajVar, this.nbP.k(this.nbP.l(ajVar)));
        }
        return this.ncm.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.ncn.containsKey(ajVar)) {
            l lVar = this.nbP;
            this.ncn.put(ajVar, l.m(ajVar));
        }
        return this.ncn.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.nco.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.nbP.p(ajVar);
            this.nco.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String V(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
