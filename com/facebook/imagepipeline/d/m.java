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
    private final at mSL;
    private final boolean mTA;
    private final l mTK;
    private final boolean mTT;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mTU;
    aj<com.facebook.imagepipeline.g.e> mTV;
    aj<com.facebook.imagepipeline.g.e> mTW;
    aj<Void> mTX;
    aj<Void> mTY;
    private aj<com.facebook.imagepipeline.g.e> mTZ;
    private final af mTb;
    private final boolean mTf;
    private final boolean mTk;
    private final boolean mTr;
    private final boolean mTw;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mUa;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mUb;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mUc;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mUd;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mUe;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mUf;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mUg;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> mUh = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> mUi = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> mUj = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.mTK = lVar;
        this.mTb = afVar;
        this.mTf = z;
        this.mTr = z2;
        this.mSL = atVar;
        this.mTT = z3;
        this.mTw = z4;
        this.mTA = z5;
        this.mTk = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.dGR()) {
            case 0:
                return dEx();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + W(imageRequest.dGQ()));
            case 2:
            case 3:
                return dEz();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.dGa().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.dGY() != null) {
            f = v(f);
        }
        if (this.mTw) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.mTw) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri dGQ = imageRequest.dGQ();
        com.facebook.common.internal.g.checkNotNull(dGQ, "Uri is null.");
        switch (imageRequest.dGR()) {
            case 0:
                return dEv();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + W(dGQ));
            case 2:
                return dEC();
            case 3:
                return dEB();
            case 4:
                if (com.facebook.common.d.a.QC(this.mContentResolver.getType(dGQ))) {
                    return dEC();
                }
                return dED();
            case 5:
                return dEG();
            case 6:
                return dEF();
            case 7:
                return dEH();
            case 8:
                return dEE();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEv() {
        if (this.mTU == null) {
            this.mTU = r(dEy());
        }
        return this.mTU;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dEw() {
        if (this.mTW == null) {
            this.mTW = this.mTK.a(dEy(), this.mSL);
        }
        return this.mTW;
    }

    private synchronized aj<Void> dEx() {
        if (this.mTY == null) {
            this.mTY = l.m(dEw());
        }
        return this.mTY;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dEy() {
        if (this.mTZ == null) {
            this.mTZ = l.a(s(this.mTK.b(this.mTb)));
            this.mTZ = this.mTK.a(this.mTZ, this.mTf, this.mTT);
        }
        return this.mTZ;
    }

    private synchronized aj<Void> dEz() {
        if (this.mTX == null) {
            this.mTX = l.m(dEA());
        }
        return this.mTX;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dEA() {
        if (this.mTV == null) {
            this.mTV = this.mTK.a(s(this.mTK.dEr()), this.mSL);
        }
        return this.mTV;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEB() {
        if (this.mUa == null) {
            this.mUa = q(this.mTK.dEr());
        }
        return this.mUa;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEC() {
        if (this.mUb == null) {
            this.mUb = u(this.mTK.dEu());
        }
        return this.mUb;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dED() {
        if (this.mUc == null) {
            this.mUc = a(this.mTK.dEo(), new aw[]{this.mTK.dEp(), this.mTK.dEq()});
        }
        return this.mUc;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEE() {
        if (this.mUg == null) {
            this.mUg = q(this.mTK.dEs());
        }
        return this.mUg;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEF() {
        if (this.mUd == null) {
            this.mUd = q(this.mTK.dEt());
        }
        return this.mUd;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEG() {
        if (this.mUe == null) {
            this.mUe = q(this.mTK.dEn());
        }
        return this.mUe;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dEH() {
        if (this.mUf == null) {
            aj<com.facebook.imagepipeline.g.e> dEm = this.mTK.dEm();
            if (com.facebook.common.g.c.mJv && (!this.mTr || com.facebook.common.g.c.mJy == null)) {
                dEm = this.mTK.o(dEm);
            }
            l lVar = this.mTK;
            this.mUf = r(this.mTK.a(l.a(dEm), true, this.mTT));
        }
        return this.mUf;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.mTK.dEq()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.mTK.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.mJv && (!this.mTr || com.facebook.common.g.c.mJy == null)) {
            ajVar = this.mTK.o(ajVar);
        }
        if (this.mTk) {
            ajVar = t(ajVar);
        }
        return this.mTK.i(this.mTK.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.mTA) {
            g = this.mTK.g(this.mTK.h(ajVar));
        } else {
            g = this.mTK.g(ajVar);
        }
        return this.mTK.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.mTK.b(this.mTK.a(this.mTK.c(this.mTK.d(ajVar)), this.mSL));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.mTK.n(this.mTK.a(l.a(ajVar), true, this.mTT));
        l lVar = this.mTK;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.mTK.a(this.mTK.a(awVarArr), true, this.mTT);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.mUh.containsKey(ajVar)) {
            this.mUh.put(ajVar, this.mTK.k(this.mTK.l(ajVar)));
        }
        return this.mUh.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.mUi.containsKey(ajVar)) {
            l lVar = this.mTK;
            this.mUi.put(ajVar, l.m(ajVar));
        }
        return this.mUi.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.mUj.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.mTK.p(ajVar);
            this.mUj.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String W(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
