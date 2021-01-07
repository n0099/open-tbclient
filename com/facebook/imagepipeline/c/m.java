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
/* loaded from: classes3.dex */
public class m {
    private final ContentResolver mContentResolver;
    private final at pCI;
    private final af pCX;
    private final l pDE;
    private final boolean pDL;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pDM;
    aj<com.facebook.imagepipeline.f.e> pDN;
    aj<com.facebook.imagepipeline.f.e> pDO;
    aj<Void> pDP;
    aj<Void> pDQ;
    private aj<com.facebook.imagepipeline.f.e> pDR;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pDS;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pDT;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pDU;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pDV;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pDW;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pDX;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pDY;
    private final boolean pDb;
    private final boolean pDf;
    private final boolean pDl;
    private final boolean pDq;
    private final boolean pDu;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pDZ = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<Void>> pEa = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pEb = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.pDE = lVar;
        this.pCX = afVar;
        this.pDb = z;
        this.pDl = z2;
        this.pCI = atVar;
        this.pDL = z3;
        this.pDq = z4;
        this.pDu = z5;
        this.pDf = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.eBy()) {
            case 0:
                return ezj();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + ad(imageRequest.eBx()));
            case 2:
            case 3:
                return ezl();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.eAJ().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (imageRequest.eBF() != null) {
            f = v(f);
        }
        if (this.pDq) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (this.pDq) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri eBx = imageRequest.eBx();
        com.facebook.common.internal.g.checkNotNull(eBx, "Uri is null.");
        switch (imageRequest.eBy()) {
            case 0:
                return ezh();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + ad(eBx));
            case 2:
                return ezo();
            case 3:
                return ezn();
            case 4:
                if (com.facebook.common.d.a.Zp(this.mContentResolver.getType(eBx))) {
                    return ezo();
                }
                return ezp();
            case 5:
                return ezs();
            case 6:
                return ezr();
            case 7:
                return ezt();
            case 8:
                return ezq();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ezh() {
        if (this.pDM == null) {
            this.pDM = r(ezk());
        }
        return this.pDM;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> ezi() {
        if (this.pDO == null) {
            this.pDO = this.pDE.a(ezk(), this.pCI);
        }
        return this.pDO;
    }

    private synchronized aj<Void> ezj() {
        if (this.pDQ == null) {
            this.pDQ = l.m(ezi());
        }
        return this.pDQ;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> ezk() {
        if (this.pDR == null) {
            this.pDR = l.a(s(this.pDE.a(this.pCX)));
            this.pDR = this.pDE.a(this.pDR, this.pDb, this.pDL);
        }
        return this.pDR;
    }

    private synchronized aj<Void> ezl() {
        if (this.pDP == null) {
            this.pDP = l.m(ezm());
        }
        return this.pDP;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> ezm() {
        if (this.pDN == null) {
            this.pDN = this.pDE.a(s(this.pDE.ezd()), this.pCI);
        }
        return this.pDN;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ezn() {
        if (this.pDS == null) {
            this.pDS = q(this.pDE.ezd());
        }
        return this.pDS;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ezo() {
        if (this.pDT == null) {
            this.pDT = u(this.pDE.ezg());
        }
        return this.pDT;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ezp() {
        if (this.pDU == null) {
            this.pDU = a(this.pDE.eza(), new aw[]{this.pDE.ezb(), this.pDE.ezc()});
        }
        return this.pDU;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ezq() {
        if (this.pDY == null) {
            this.pDY = q(this.pDE.eze());
        }
        return this.pDY;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ezr() {
        if (this.pDV == null) {
            this.pDV = q(this.pDE.ezf());
        }
        return this.pDV;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ezs() {
        if (this.pDW == null) {
            this.pDW = q(this.pDE.eyZ());
        }
        return this.pDW;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ezt() {
        if (this.pDX == null) {
            aj<com.facebook.imagepipeline.f.e> eyY = this.pDE.eyY();
            if (com.facebook.common.g.c.ptV && (!this.pDl || com.facebook.common.g.c.ptY == null)) {
                eyY = this.pDE.o(eyY);
            }
            l lVar = this.pDE;
            this.pDX = r(this.pDE.a(l.a(eyY), true, this.pDL));
        }
        return this.pDX;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> q(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return a(ajVar, new aw[]{this.pDE.ezc()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> r(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return u(this.pDE.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> s(aj<com.facebook.imagepipeline.f.e> ajVar) {
        if (com.facebook.common.g.c.ptV && (!this.pDl || com.facebook.common.g.c.ptY == null)) {
            ajVar = this.pDE.o(ajVar);
        }
        if (this.pDf) {
            ajVar = t(ajVar);
        }
        return this.pDE.i(this.pDE.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> t(aj<com.facebook.imagepipeline.f.e> ajVar) {
        p g;
        if (this.pDu) {
            g = this.pDE.g(this.pDE.h(ajVar));
        } else {
            g = this.pDE.g(ajVar);
        }
        return this.pDE.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return this.pDE.b(this.pDE.a(this.pDE.c(this.pDE.d(ajVar)), this.pCI));
    }

    private aj<com.facebook.imagepipeline.f.e> b(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        au n = this.pDE.n(this.pDE.a(l.a(ajVar), true, this.pDL));
        l lVar = this.pDE;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.f.e> b(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return this.pDE.a(this.pDE.a(awVarArr), true, this.pDL);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pDZ.containsKey(ajVar)) {
            this.pDZ.put(ajVar, this.pDE.k(this.pDE.l(ajVar)));
        }
        return this.pDZ.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pEa.containsKey(ajVar)) {
            l lVar = this.pDE;
            this.pEa.put(ajVar, l.m(ajVar));
        }
        return this.pEa.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar2;
        ajVar2 = this.pEb.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.pDE.p(ajVar);
            this.pEb.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String ad(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
