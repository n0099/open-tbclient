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
    private final at mvA;
    private final af mvP;
    private final boolean mvT;
    private final boolean mvX;
    private final boolean mwD;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mwE;
    aj<com.facebook.imagepipeline.g.e> mwF;
    aj<com.facebook.imagepipeline.g.e> mwG;
    aj<Void> mwH;
    aj<Void> mwI;
    private aj<com.facebook.imagepipeline.g.e> mwJ;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mwK;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mwL;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mwM;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mwN;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mwO;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mwP;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mwQ;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> mwR = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> mwS = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> mwT = new HashMap();
    private final boolean mwd;
    private final boolean mwi;
    private final boolean mwm;
    private final l mww;

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.mww = lVar;
        this.mvP = afVar;
        this.mvT = z;
        this.mwd = z2;
        this.mvA = atVar;
        this.mwD = z3;
        this.mwi = z4;
        this.mwm = z5;
        this.mvX = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.dCb()) {
            case 0:
                return dzH();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + V(imageRequest.dCa()));
            case 2:
            case 3:
                return dzJ();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.dBk().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.dCi() != null) {
            f = v(f);
        }
        if (this.mwi) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.mwi) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri dCa = imageRequest.dCa();
        com.facebook.common.internal.g.checkNotNull(dCa, "Uri is null.");
        switch (imageRequest.dCb()) {
            case 0:
                return dzF();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + V(dCa));
            case 2:
                return dzM();
            case 3:
                return dzL();
            case 4:
                if (com.facebook.common.d.a.PP(this.mContentResolver.getType(dCa))) {
                    return dzM();
                }
                return dzN();
            case 5:
                return dzQ();
            case 6:
                return dzP();
            case 7:
                return dzR();
            case 8:
                return dzO();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dzF() {
        if (this.mwE == null) {
            this.mwE = r(dzI());
        }
        return this.mwE;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dzG() {
        if (this.mwG == null) {
            this.mwG = this.mww.a(dzI(), this.mvA);
        }
        return this.mwG;
    }

    private synchronized aj<Void> dzH() {
        if (this.mwI == null) {
            this.mwI = l.m(dzG());
        }
        return this.mwI;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dzI() {
        if (this.mwJ == null) {
            this.mwJ = l.a(s(this.mww.b(this.mvP)));
            this.mwJ = this.mww.a(this.mwJ, this.mvT, this.mwD);
        }
        return this.mwJ;
    }

    private synchronized aj<Void> dzJ() {
        if (this.mwH == null) {
            this.mwH = l.m(dzK());
        }
        return this.mwH;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dzK() {
        if (this.mwF == null) {
            this.mwF = this.mww.a(s(this.mww.dzB()), this.mvA);
        }
        return this.mwF;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dzL() {
        if (this.mwK == null) {
            this.mwK = q(this.mww.dzB());
        }
        return this.mwK;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dzM() {
        if (this.mwL == null) {
            this.mwL = u(this.mww.dzE());
        }
        return this.mwL;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dzN() {
        if (this.mwM == null) {
            this.mwM = a(this.mww.dzy(), new aw[]{this.mww.dzz(), this.mww.dzA()});
        }
        return this.mwM;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dzO() {
        if (this.mwQ == null) {
            this.mwQ = q(this.mww.dzC());
        }
        return this.mwQ;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dzP() {
        if (this.mwN == null) {
            this.mwN = q(this.mww.dzD());
        }
        return this.mwN;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dzQ() {
        if (this.mwO == null) {
            this.mwO = q(this.mww.dzx());
        }
        return this.mwO;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dzR() {
        if (this.mwP == null) {
            aj<com.facebook.imagepipeline.g.e> dzw = this.mww.dzw();
            if (com.facebook.common.g.c.mml && (!this.mwd || com.facebook.common.g.c.mmo == null)) {
                dzw = this.mww.o(dzw);
            }
            l lVar = this.mww;
            this.mwP = r(this.mww.a(l.a(dzw), true, this.mwD));
        }
        return this.mwP;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.mww.dzA()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.mww.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.mml && (!this.mwd || com.facebook.common.g.c.mmo == null)) {
            ajVar = this.mww.o(ajVar);
        }
        if (this.mvX) {
            ajVar = t(ajVar);
        }
        return this.mww.i(this.mww.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.mwm) {
            g = this.mww.g(this.mww.h(ajVar));
        } else {
            g = this.mww.g(ajVar);
        }
        return this.mww.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.mww.b(this.mww.a(this.mww.c(this.mww.d(ajVar)), this.mvA));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.mww.n(this.mww.a(l.a(ajVar), true, this.mwD));
        l lVar = this.mww;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.mww.a(this.mww.a(awVarArr), true, this.mwD);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.mwR.containsKey(ajVar)) {
            this.mwR.put(ajVar, this.mww.k(this.mww.l(ajVar)));
        }
        return this.mwR.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.mwS.containsKey(ajVar)) {
            l lVar = this.mww;
            this.mwS.put(ajVar, l.m(ajVar));
        }
        return this.mwS.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.mwT.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.mww.p(ajVar);
            this.mwT.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String V(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
