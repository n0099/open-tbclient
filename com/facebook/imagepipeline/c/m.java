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
    private final boolean pyA;
    private final boolean pyE;
    private final boolean pyK;
    private final boolean pyP;
    private final boolean pyT;
    private final at pyh;
    private final af pyw;
    private final l pzd;
    private final boolean pzk;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzl;
    aj<com.facebook.imagepipeline.f.e> pzm;
    aj<com.facebook.imagepipeline.f.e> pzn;
    aj<Void> pzo;
    aj<Void> pzp;
    private aj<com.facebook.imagepipeline.f.e> pzq;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzr;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzs;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzt;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzu;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzv;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzw;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzx;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pzy = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<Void>> pzz = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pzA = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.pzd = lVar;
        this.pyw = afVar;
        this.pyA = z;
        this.pyK = z2;
        this.pyh = atVar;
        this.pzk = z3;
        this.pyP = z4;
        this.pyT = z5;
        this.pyE = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.exG()) {
            case 0:
                return evr();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + aa(imageRequest.exF()));
            case 2:
            case 3:
                return evt();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.ewR().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (imageRequest.exN() != null) {
            f = v(f);
        }
        if (this.pyP) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (this.pyP) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri exF = imageRequest.exF();
        com.facebook.common.internal.g.checkNotNull(exF, "Uri is null.");
        switch (imageRequest.exG()) {
            case 0:
                return evp();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + aa(exF));
            case 2:
                return evw();
            case 3:
                return evv();
            case 4:
                if (com.facebook.common.d.a.Yh(this.mContentResolver.getType(exF))) {
                    return evw();
                }
                return evx();
            case 5:
                return evA();
            case 6:
                return evz();
            case 7:
                return evB();
            case 8:
                return evy();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evp() {
        if (this.pzl == null) {
            this.pzl = r(evs());
        }
        return this.pzl;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> evq() {
        if (this.pzn == null) {
            this.pzn = this.pzd.a(evs(), this.pyh);
        }
        return this.pzn;
    }

    private synchronized aj<Void> evr() {
        if (this.pzp == null) {
            this.pzp = l.m(evq());
        }
        return this.pzp;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> evs() {
        if (this.pzq == null) {
            this.pzq = l.a(s(this.pzd.a(this.pyw)));
            this.pzq = this.pzd.a(this.pzq, this.pyA, this.pzk);
        }
        return this.pzq;
    }

    private synchronized aj<Void> evt() {
        if (this.pzo == null) {
            this.pzo = l.m(evu());
        }
        return this.pzo;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> evu() {
        if (this.pzm == null) {
            this.pzm = this.pzd.a(s(this.pzd.evl()), this.pyh);
        }
        return this.pzm;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evv() {
        if (this.pzr == null) {
            this.pzr = q(this.pzd.evl());
        }
        return this.pzr;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evw() {
        if (this.pzs == null) {
            this.pzs = u(this.pzd.evo());
        }
        return this.pzs;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evx() {
        if (this.pzt == null) {
            this.pzt = a(this.pzd.evi(), new aw[]{this.pzd.evj(), this.pzd.evk()});
        }
        return this.pzt;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evy() {
        if (this.pzx == null) {
            this.pzx = q(this.pzd.evm());
        }
        return this.pzx;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evz() {
        if (this.pzu == null) {
            this.pzu = q(this.pzd.evn());
        }
        return this.pzu;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evA() {
        if (this.pzv == null) {
            this.pzv = q(this.pzd.evh());
        }
        return this.pzv;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evB() {
        if (this.pzw == null) {
            aj<com.facebook.imagepipeline.f.e> evg = this.pzd.evg();
            if (com.facebook.common.g.c.ppt && (!this.pyK || com.facebook.common.g.c.ppw == null)) {
                evg = this.pzd.o(evg);
            }
            l lVar = this.pzd;
            this.pzw = r(this.pzd.a(l.a(evg), true, this.pzk));
        }
        return this.pzw;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> q(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return a(ajVar, new aw[]{this.pzd.evk()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> r(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return u(this.pzd.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> s(aj<com.facebook.imagepipeline.f.e> ajVar) {
        if (com.facebook.common.g.c.ppt && (!this.pyK || com.facebook.common.g.c.ppw == null)) {
            ajVar = this.pzd.o(ajVar);
        }
        if (this.pyE) {
            ajVar = t(ajVar);
        }
        return this.pzd.i(this.pzd.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> t(aj<com.facebook.imagepipeline.f.e> ajVar) {
        p g;
        if (this.pyT) {
            g = this.pzd.g(this.pzd.h(ajVar));
        } else {
            g = this.pzd.g(ajVar);
        }
        return this.pzd.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return this.pzd.b(this.pzd.a(this.pzd.c(this.pzd.d(ajVar)), this.pyh));
    }

    private aj<com.facebook.imagepipeline.f.e> b(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        au n = this.pzd.n(this.pzd.a(l.a(ajVar), true, this.pzk));
        l lVar = this.pzd;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.f.e> b(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return this.pzd.a(this.pzd.a(awVarArr), true, this.pzk);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pzy.containsKey(ajVar)) {
            this.pzy.put(ajVar, this.pzd.k(this.pzd.l(ajVar)));
        }
        return this.pzy.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pzz.containsKey(ajVar)) {
            l lVar = this.pzd;
            this.pzz.put(ajVar, l.m(ajVar));
        }
        return this.pzz.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar2;
        ajVar2 = this.pzA.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.pzd.p(ajVar);
            this.pzA.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String aa(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
