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
    private final boolean pyB;
    private final boolean pyF;
    private final boolean pyL;
    private final boolean pyQ;
    private final boolean pyU;
    private final at pyi;
    private final af pyx;
    private final l pze;
    private final boolean pzl;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzm;
    aj<com.facebook.imagepipeline.f.e> pzn;
    aj<com.facebook.imagepipeline.f.e> pzo;
    aj<Void> pzp;
    aj<Void> pzq;
    private aj<com.facebook.imagepipeline.f.e> pzr;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzs;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzt;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzu;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzv;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzw;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzx;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pzy;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pzz = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<Void>> pzA = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>> pzB = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.pze = lVar;
        this.pyx = afVar;
        this.pyB = z;
        this.pyL = z2;
        this.pyi = atVar;
        this.pzl = z3;
        this.pyQ = z4;
        this.pyU = z5;
        this.pyF = z6;
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
        if (this.pyQ) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> f = f(imageRequest);
        if (this.pyQ) {
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
                if (com.facebook.common.d.a.Yi(this.mContentResolver.getType(exF))) {
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
        if (this.pzm == null) {
            this.pzm = r(evs());
        }
        return this.pzm;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> evq() {
        if (this.pzo == null) {
            this.pzo = this.pze.a(evs(), this.pyi);
        }
        return this.pzo;
    }

    private synchronized aj<Void> evr() {
        if (this.pzq == null) {
            this.pzq = l.m(evq());
        }
        return this.pzq;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> evs() {
        if (this.pzr == null) {
            this.pzr = l.a(s(this.pze.a(this.pyx)));
            this.pzr = this.pze.a(this.pzr, this.pyB, this.pzl);
        }
        return this.pzr;
    }

    private synchronized aj<Void> evt() {
        if (this.pzp == null) {
            this.pzp = l.m(evu());
        }
        return this.pzp;
    }

    private synchronized aj<com.facebook.imagepipeline.f.e> evu() {
        if (this.pzn == null) {
            this.pzn = this.pze.a(s(this.pze.evl()), this.pyi);
        }
        return this.pzn;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evv() {
        if (this.pzs == null) {
            this.pzs = q(this.pze.evl());
        }
        return this.pzs;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evw() {
        if (this.pzt == null) {
            this.pzt = u(this.pze.evo());
        }
        return this.pzt;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evx() {
        if (this.pzu == null) {
            this.pzu = a(this.pze.evi(), new aw[]{this.pze.evj(), this.pze.evk()});
        }
        return this.pzu;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evy() {
        if (this.pzy == null) {
            this.pzy = q(this.pze.evm());
        }
        return this.pzy;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evz() {
        if (this.pzv == null) {
            this.pzv = q(this.pze.evn());
        }
        return this.pzv;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evA() {
        if (this.pzw == null) {
            this.pzw = q(this.pze.evh());
        }
        return this.pzw;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> evB() {
        if (this.pzx == null) {
            aj<com.facebook.imagepipeline.f.e> evg = this.pze.evg();
            if (com.facebook.common.g.c.ppu && (!this.pyL || com.facebook.common.g.c.ppx == null)) {
                evg = this.pze.o(evg);
            }
            l lVar = this.pze;
            this.pzx = r(this.pze.a(l.a(evg), true, this.pzl));
        }
        return this.pzx;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> q(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return a(ajVar, new aw[]{this.pze.evk()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> r(aj<com.facebook.imagepipeline.f.e> ajVar) {
        return u(this.pze.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> s(aj<com.facebook.imagepipeline.f.e> ajVar) {
        if (com.facebook.common.g.c.ppu && (!this.pyL || com.facebook.common.g.c.ppx == null)) {
            ajVar = this.pze.o(ajVar);
        }
        if (this.pyF) {
            ajVar = t(ajVar);
        }
        return this.pze.i(this.pze.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.f.e> t(aj<com.facebook.imagepipeline.f.e> ajVar) {
        p g;
        if (this.pyU) {
            g = this.pze.g(this.pze.h(ajVar));
        } else {
            g = this.pze.g(ajVar);
        }
        return this.pze.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        return this.pze.b(this.pze.a(this.pze.c(this.pze.d(ajVar)), this.pyi));
    }

    private aj<com.facebook.imagepipeline.f.e> b(aj<com.facebook.imagepipeline.f.e> ajVar, aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        au n = this.pze.n(this.pze.a(l.a(ajVar), true, this.pzl));
        l lVar = this.pze;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.f.e> b(aw<com.facebook.imagepipeline.f.e>[] awVarArr) {
        return this.pze.a(this.pze.a(awVarArr), true, this.pzl);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pzz.containsKey(ajVar)) {
            this.pzz.put(ajVar, this.pze.k(this.pze.l(ajVar)));
        }
        return this.pzz.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        if (!this.pzA.containsKey(ajVar)) {
            l lVar = this.pze;
            this.pzA.put(ajVar, l.m(ajVar));
        }
        return this.pzA.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar2;
        ajVar2 = this.pzB.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.pze.p(ajVar);
            this.pzB.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String aa(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
