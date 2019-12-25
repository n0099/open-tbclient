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
/* loaded from: classes9.dex */
public class m {
    private final at lNB;
    private final af lNQ;
    private final boolean lNU;
    private final boolean lNY;
    private final boolean lOG;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lOH;
    aj<com.facebook.imagepipeline.g.e> lOI;
    aj<com.facebook.imagepipeline.g.e> lOJ;
    aj<Void> lOK;
    aj<Void> lOL;
    private aj<com.facebook.imagepipeline.g.e> lOM;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lON;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lOO;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lOP;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lOQ;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lOR;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lOS;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lOT;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lOU = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> lOV = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lOW = new HashMap();
    private final boolean lOe;
    private final boolean lOj;
    private final boolean lOn;
    private final l lOx;
    private final ContentResolver mContentResolver;

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.lOx = lVar;
        this.lNQ = afVar;
        this.lNU = z;
        this.lOe = z2;
        this.lNB = atVar;
        this.lOG = z3;
        this.lOj = z4;
        this.lOn = z5;
        this.lNY = z6;
    }

    public aj<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.dpO()) {
            case 0:
                return dnz();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + R(imageRequest.dpN()));
            case 2:
            case 3:
                return dnB();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.doZ().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g = g(imageRequest);
        if (imageRequest.dpW() != null) {
            g = v(g);
        }
        if (this.lOj) {
            return x(g);
        }
        return g;
    }

    public aj<Void> f(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g = g(imageRequest);
        if (this.lOj) {
            g = x(g);
        }
        return w(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri dpN = imageRequest.dpN();
        com.facebook.common.internal.g.checkNotNull(dpN, "Uri is null.");
        switch (imageRequest.dpO()) {
            case 0:
                return dnx();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + R(dpN));
            case 2:
                return dnE();
            case 3:
                return dnD();
            case 4:
                if (com.facebook.common.d.a.Ot(this.mContentResolver.getType(dpN))) {
                    return dnE();
                }
                return dnF();
            case 5:
                return dnI();
            case 6:
                return dnH();
            case 7:
                return dnJ();
            case 8:
                return dnG();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dnx() {
        if (this.lOH == null) {
            this.lOH = r(dnA());
        }
        return this.lOH;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dny() {
        if (this.lOJ == null) {
            this.lOJ = this.lOx.a(dnA(), this.lNB);
        }
        return this.lOJ;
    }

    private synchronized aj<Void> dnz() {
        if (this.lOL == null) {
            this.lOL = l.m(dny());
        }
        return this.lOL;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dnA() {
        if (this.lOM == null) {
            this.lOM = l.a(s(this.lOx.b(this.lNQ)));
            this.lOM = this.lOx.a(this.lOM, this.lNU, this.lOG);
        }
        return this.lOM;
    }

    private synchronized aj<Void> dnB() {
        if (this.lOK == null) {
            this.lOK = l.m(dnC());
        }
        return this.lOK;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dnC() {
        if (this.lOI == null) {
            this.lOI = this.lOx.a(s(this.lOx.dnt()), this.lNB);
        }
        return this.lOI;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dnD() {
        if (this.lON == null) {
            this.lON = q(this.lOx.dnt());
        }
        return this.lON;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dnE() {
        if (this.lOO == null) {
            this.lOO = u(this.lOx.dnw());
        }
        return this.lOO;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dnF() {
        if (this.lOP == null) {
            this.lOP = a(this.lOx.dnp(), new aw[]{this.lOx.dnq(), this.lOx.dnr()});
        }
        return this.lOP;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dnG() {
        if (this.lOT == null) {
            this.lOT = q(this.lOx.dnu());
        }
        return this.lOT;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dnH() {
        if (this.lOQ == null) {
            this.lOQ = q(this.lOx.dnv());
        }
        return this.lOQ;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dnI() {
        if (this.lOR == null) {
            this.lOR = q(this.lOx.dno());
        }
        return this.lOR;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dnJ() {
        if (this.lOS == null) {
            aj<com.facebook.imagepipeline.g.e> dnn = this.lOx.dnn();
            if (com.facebook.common.g.c.lES && (!this.lOe || com.facebook.common.g.c.lEU == null)) {
                dnn = this.lOx.o(dnn);
            }
            l lVar = this.lOx;
            this.lOS = r(this.lOx.a(l.a(dnn), true, this.lOG));
        }
        return this.lOS;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.lOx.dnr()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.lOx.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.lES && (!this.lOe || com.facebook.common.g.c.lEU == null)) {
            ajVar = this.lOx.o(ajVar);
        }
        if (this.lNY) {
            ajVar = t(ajVar);
        }
        return this.lOx.i(this.lOx.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.lOn) {
            g = this.lOx.g(this.lOx.h(ajVar));
        } else {
            g = this.lOx.g(ajVar);
        }
        return this.lOx.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.lOx.b(this.lOx.a(this.lOx.c(this.lOx.d(ajVar)), this.lNB));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.lOx.n(this.lOx.a(l.a(ajVar), true, this.lOG));
        l lVar = this.lOx;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.lOx.a(this.lOx.a(awVarArr), true, this.lOG);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.lOU.containsKey(ajVar)) {
            this.lOU.put(ajVar, this.lOx.k(this.lOx.l(ajVar)));
        }
        return this.lOU.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.lOV.containsKey(ajVar)) {
            l lVar = this.lOx;
            this.lOV.put(ajVar, l.m(ajVar));
        }
        return this.lOV.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.lOW.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.lOx.p(ajVar);
            this.lOW.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String R(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
