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
/* loaded from: classes10.dex */
public class m {
    private final af lRC;
    private final boolean lRG;
    private final boolean lRK;
    private final boolean lRQ;
    private final boolean lRV;
    private final boolean lRZ;
    private final at lRn;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSA;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSB;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSC;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSD;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSE;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSF;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lSG = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> lSH = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lSI = new HashMap();
    private final l lSj;
    private final boolean lSs;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSt;
    aj<com.facebook.imagepipeline.g.e> lSu;
    aj<com.facebook.imagepipeline.g.e> lSv;
    aj<Void> lSw;
    aj<Void> lSx;
    private aj<com.facebook.imagepipeline.g.e> lSy;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lSz;
    private final ContentResolver mContentResolver;

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.lSj = lVar;
        this.lRC = afVar;
        this.lRG = z;
        this.lRQ = z2;
        this.lRn = atVar;
        this.lSs = z3;
        this.lRV = z4;
        this.lRZ = z5;
        this.lRK = z6;
    }

    public aj<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.drb()) {
            case 0:
                return doF();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + R(imageRequest.dra()));
            case 2:
            case 3:
                return doH();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.dqj().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g = g(imageRequest);
        if (imageRequest.drj() != null) {
            g = v(g);
        }
        if (this.lRV) {
            return x(g);
        }
        return g;
    }

    public aj<Void> f(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g = g(imageRequest);
        if (this.lRV) {
            g = x(g);
        }
        return w(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri dra = imageRequest.dra();
        com.facebook.common.internal.g.checkNotNull(dra, "Uri is null.");
        switch (imageRequest.drb()) {
            case 0:
                return doD();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + R(dra));
            case 2:
                return doK();
            case 3:
                return doJ();
            case 4:
                if (com.facebook.common.d.a.OD(this.mContentResolver.getType(dra))) {
                    return doK();
                }
                return doL();
            case 5:
                return doO();
            case 6:
                return doN();
            case 7:
                return doP();
            case 8:
                return doM();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doD() {
        if (this.lSt == null) {
            this.lSt = r(doG());
        }
        return this.lSt;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> doE() {
        if (this.lSv == null) {
            this.lSv = this.lSj.a(doG(), this.lRn);
        }
        return this.lSv;
    }

    private synchronized aj<Void> doF() {
        if (this.lSx == null) {
            this.lSx = l.m(doE());
        }
        return this.lSx;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> doG() {
        if (this.lSy == null) {
            this.lSy = l.a(s(this.lSj.b(this.lRC)));
            this.lSy = this.lSj.a(this.lSy, this.lRG, this.lSs);
        }
        return this.lSy;
    }

    private synchronized aj<Void> doH() {
        if (this.lSw == null) {
            this.lSw = l.m(doI());
        }
        return this.lSw;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> doI() {
        if (this.lSu == null) {
            this.lSu = this.lSj.a(s(this.lSj.doz()), this.lRn);
        }
        return this.lSu;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doJ() {
        if (this.lSz == null) {
            this.lSz = q(this.lSj.doz());
        }
        return this.lSz;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doK() {
        if (this.lSA == null) {
            this.lSA = u(this.lSj.doC());
        }
        return this.lSA;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doL() {
        if (this.lSB == null) {
            this.lSB = a(this.lSj.dow(), new aw[]{this.lSj.dox(), this.lSj.doy()});
        }
        return this.lSB;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doM() {
        if (this.lSF == null) {
            this.lSF = q(this.lSj.doA());
        }
        return this.lSF;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doN() {
        if (this.lSC == null) {
            this.lSC = q(this.lSj.doB());
        }
        return this.lSC;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doO() {
        if (this.lSD == null) {
            this.lSD = q(this.lSj.dov());
        }
        return this.lSD;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> doP() {
        if (this.lSE == null) {
            aj<com.facebook.imagepipeline.g.e> dou = this.lSj.dou();
            if (com.facebook.common.g.c.lIq && (!this.lRQ || com.facebook.common.g.c.lIs == null)) {
                dou = this.lSj.o(dou);
            }
            l lVar = this.lSj;
            this.lSE = r(this.lSj.a(l.a(dou), true, this.lSs));
        }
        return this.lSE;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.lSj.doy()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.lSj.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.lIq && (!this.lRQ || com.facebook.common.g.c.lIs == null)) {
            ajVar = this.lSj.o(ajVar);
        }
        if (this.lRK) {
            ajVar = t(ajVar);
        }
        return this.lSj.i(this.lSj.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.lRZ) {
            g = this.lSj.g(this.lSj.h(ajVar));
        } else {
            g = this.lSj.g(ajVar);
        }
        return this.lSj.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.lSj.b(this.lSj.a(this.lSj.c(this.lSj.d(ajVar)), this.lRn));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.lSj.n(this.lSj.a(l.a(ajVar), true, this.lSs));
        l lVar = this.lSj;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.lSj.a(this.lSj.a(awVarArr), true, this.lSs);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.lSG.containsKey(ajVar)) {
            this.lSG.put(ajVar, this.lSj.k(this.lSj.l(ajVar)));
        }
        return this.lSG.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.lSH.containsKey(ajVar)) {
            l lVar = this.lSj;
            this.lSH.put(ajVar, l.m(ajVar));
        }
        return this.lSH.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.lSI.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.lSj.p(ajVar);
            this.lSI.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String R(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
