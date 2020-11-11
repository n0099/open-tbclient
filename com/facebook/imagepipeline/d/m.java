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
    private final boolean oVB;
    private final boolean oVH;
    private final boolean oVM;
    private final boolean oVQ;
    private final at oVe;
    private final af oVt;
    private final boolean oVx;
    private final l oWa;
    private final boolean oWh;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oWi;
    aj<com.facebook.imagepipeline.g.e> oWj;
    aj<com.facebook.imagepipeline.g.e> oWk;
    aj<Void> oWl;
    aj<Void> oWm;
    private aj<com.facebook.imagepipeline.g.e> oWn;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oWo;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oWp;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oWq;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oWr;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oWs;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oWt;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oWu;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> oWv = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> oWw = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> oWx = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.oWa = lVar;
        this.oVt = afVar;
        this.oVx = z;
        this.oVH = z2;
        this.oVe = atVar;
        this.oWh = z3;
        this.oVM = z4;
        this.oVQ = z5;
        this.oVB = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.erO()) {
            case 0:
                return epu();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + X(imageRequest.erN()));
            case 2:
            case 3:
                return epw();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.eqX().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.erV() != null) {
            f = v(f);
        }
        if (this.oVM) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.oVM) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri erN = imageRequest.erN();
        com.facebook.common.internal.g.checkNotNull(erN, "Uri is null.");
        switch (imageRequest.erO()) {
            case 0:
                return eps();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + X(erN));
            case 2:
                return epz();
            case 3:
                return epy();
            case 4:
                if (com.facebook.common.d.a.XZ(this.mContentResolver.getType(erN))) {
                    return epz();
                }
                return epA();
            case 5:
                return epD();
            case 6:
                return epC();
            case 7:
                return epE();
            case 8:
                return epB();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> eps() {
        if (this.oWi == null) {
            this.oWi = r(epv());
        }
        return this.oWi;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> ept() {
        if (this.oWk == null) {
            this.oWk = this.oWa.a(epv(), this.oVe);
        }
        return this.oWk;
    }

    private synchronized aj<Void> epu() {
        if (this.oWm == null) {
            this.oWm = l.m(ept());
        }
        return this.oWm;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> epv() {
        if (this.oWn == null) {
            this.oWn = l.a(s(this.oWa.b(this.oVt)));
            this.oWn = this.oWa.a(this.oWn, this.oVx, this.oWh);
        }
        return this.oWn;
    }

    private synchronized aj<Void> epw() {
        if (this.oWl == null) {
            this.oWl = l.m(epx());
        }
        return this.oWl;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> epx() {
        if (this.oWj == null) {
            this.oWj = this.oWa.a(s(this.oWa.epo()), this.oVe);
        }
        return this.oWj;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epy() {
        if (this.oWo == null) {
            this.oWo = q(this.oWa.epo());
        }
        return this.oWo;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epz() {
        if (this.oWp == null) {
            this.oWp = u(this.oWa.epr());
        }
        return this.oWp;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epA() {
        if (this.oWq == null) {
            this.oWq = a(this.oWa.epl(), new aw[]{this.oWa.epm(), this.oWa.epn()});
        }
        return this.oWq;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epB() {
        if (this.oWu == null) {
            this.oWu = q(this.oWa.epp());
        }
        return this.oWu;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epC() {
        if (this.oWr == null) {
            this.oWr = q(this.oWa.epq());
        }
        return this.oWr;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epD() {
        if (this.oWs == null) {
            this.oWs = q(this.oWa.epk());
        }
        return this.oWs;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> epE() {
        if (this.oWt == null) {
            aj<com.facebook.imagepipeline.g.e> epj = this.oWa.epj();
            if (com.facebook.common.g.c.oLU && (!this.oVH || com.facebook.common.g.c.oLX == null)) {
                epj = this.oWa.o(epj);
            }
            l lVar = this.oWa;
            this.oWt = r(this.oWa.a(l.a(epj), true, this.oWh));
        }
        return this.oWt;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.oWa.epn()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.oWa.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.oLU && (!this.oVH || com.facebook.common.g.c.oLX == null)) {
            ajVar = this.oWa.o(ajVar);
        }
        if (this.oVB) {
            ajVar = t(ajVar);
        }
        return this.oWa.i(this.oWa.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.oVQ) {
            g = this.oWa.g(this.oWa.h(ajVar));
        } else {
            g = this.oWa.g(ajVar);
        }
        return this.oWa.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.oWa.b(this.oWa.a(this.oWa.c(this.oWa.d(ajVar)), this.oVe));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.oWa.n(this.oWa.a(l.a(ajVar), true, this.oWh));
        l lVar = this.oWa;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.oWa.a(this.oWa.a(awVarArr), true, this.oWh);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.oWv.containsKey(ajVar)) {
            this.oWv.put(ajVar, this.oWa.k(this.oWa.l(ajVar)));
        }
        return this.oWv.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.oWw.containsKey(ajVar)) {
            l lVar = this.oWa;
            this.oWw.put(ajVar, l.m(ajVar));
        }
        return this.oWw.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.oWx.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.oWa.p(ajVar);
            this.oWx.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String X(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
