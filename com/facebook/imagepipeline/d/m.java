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
/* loaded from: classes18.dex */
public class m {
    private final ContentResolver mContentResolver;
    private final af nUI;
    private final boolean nUM;
    private final boolean nUQ;
    private final boolean nUW;
    private final at nUt;
    aj<Void> nVA;
    aj<Void> nVB;
    private aj<com.facebook.imagepipeline.g.e> nVC;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nVD;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nVE;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nVF;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nVG;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nVH;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nVI;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nVJ;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> nVK = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> nVL = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> nVM = new HashMap();
    private final boolean nVb;
    private final boolean nVf;
    private final l nVp;
    private final boolean nVw;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nVx;
    aj<com.facebook.imagepipeline.g.e> nVy;
    aj<com.facebook.imagepipeline.g.e> nVz;

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.nVp = lVar;
        this.nUI = afVar;
        this.nUM = z;
        this.nUW = z2;
        this.nUt = atVar;
        this.nVw = z3;
        this.nVb = z4;
        this.nVf = z5;
        this.nUQ = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.edZ()) {
            case 0:
                return ebF();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + X(imageRequest.edY()));
            case 2:
            case 3:
                return ebH();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.edi().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.eeg() != null) {
            f = v(f);
        }
        if (this.nVb) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.nVb) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri edY = imageRequest.edY();
        com.facebook.common.internal.g.checkNotNull(edY, "Uri is null.");
        switch (imageRequest.edZ()) {
            case 0:
                return ebD();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + X(edY));
            case 2:
                return ebK();
            case 3:
                return ebJ();
            case 4:
                if (com.facebook.common.d.a.VI(this.mContentResolver.getType(edY))) {
                    return ebK();
                }
                return ebL();
            case 5:
                return ebO();
            case 6:
                return ebN();
            case 7:
                return ebP();
            case 8:
                return ebM();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ebD() {
        if (this.nVx == null) {
            this.nVx = r(ebG());
        }
        return this.nVx;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> ebE() {
        if (this.nVz == null) {
            this.nVz = this.nVp.a(ebG(), this.nUt);
        }
        return this.nVz;
    }

    private synchronized aj<Void> ebF() {
        if (this.nVB == null) {
            this.nVB = l.m(ebE());
        }
        return this.nVB;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> ebG() {
        if (this.nVC == null) {
            this.nVC = l.a(s(this.nVp.b(this.nUI)));
            this.nVC = this.nVp.a(this.nVC, this.nUM, this.nVw);
        }
        return this.nVC;
    }

    private synchronized aj<Void> ebH() {
        if (this.nVA == null) {
            this.nVA = l.m(ebI());
        }
        return this.nVA;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> ebI() {
        if (this.nVy == null) {
            this.nVy = this.nVp.a(s(this.nVp.ebz()), this.nUt);
        }
        return this.nVy;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ebJ() {
        if (this.nVD == null) {
            this.nVD = q(this.nVp.ebz());
        }
        return this.nVD;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ebK() {
        if (this.nVE == null) {
            this.nVE = u(this.nVp.ebC());
        }
        return this.nVE;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ebL() {
        if (this.nVF == null) {
            this.nVF = a(this.nVp.ebw(), new aw[]{this.nVp.ebx(), this.nVp.eby()});
        }
        return this.nVF;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ebM() {
        if (this.nVJ == null) {
            this.nVJ = q(this.nVp.ebA());
        }
        return this.nVJ;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ebN() {
        if (this.nVG == null) {
            this.nVG = q(this.nVp.ebB());
        }
        return this.nVG;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ebO() {
        if (this.nVH == null) {
            this.nVH = q(this.nVp.ebv());
        }
        return this.nVH;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ebP() {
        if (this.nVI == null) {
            aj<com.facebook.imagepipeline.g.e> ebu = this.nVp.ebu();
            if (com.facebook.common.g.c.nLi && (!this.nUW || com.facebook.common.g.c.nLl == null)) {
                ebu = this.nVp.o(ebu);
            }
            l lVar = this.nVp;
            this.nVI = r(this.nVp.a(l.a(ebu), true, this.nVw));
        }
        return this.nVI;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.nVp.eby()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.nVp.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.nLi && (!this.nUW || com.facebook.common.g.c.nLl == null)) {
            ajVar = this.nVp.o(ajVar);
        }
        if (this.nUQ) {
            ajVar = t(ajVar);
        }
        return this.nVp.i(this.nVp.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.nVf) {
            g = this.nVp.g(this.nVp.h(ajVar));
        } else {
            g = this.nVp.g(ajVar);
        }
        return this.nVp.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.nVp.b(this.nVp.a(this.nVp.c(this.nVp.d(ajVar)), this.nUt));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.nVp.n(this.nVp.a(l.a(ajVar), true, this.nVw));
        l lVar = this.nVp;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.nVp.a(this.nVp.a(awVarArr), true, this.nVw);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.nVK.containsKey(ajVar)) {
            this.nVK.put(ajVar, this.nVp.k(this.nVp.l(ajVar)));
        }
        return this.nVK.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.nVL.containsKey(ajVar)) {
            l lVar = this.nVp;
            this.nVL.put(ajVar, l.m(ajVar));
        }
        return this.nVL.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.nVM.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.nVp.p(ajVar);
            this.nVM.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String X(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
