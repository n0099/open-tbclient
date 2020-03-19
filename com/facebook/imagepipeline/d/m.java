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
    private final at lTS;
    private final boolean lUA;
    private final boolean lUE;
    private final l lUO;
    private final boolean lUX;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lUY;
    aj<com.facebook.imagepipeline.g.e> lUZ;
    private final af lUh;
    private final boolean lUl;
    private final boolean lUp;
    private final boolean lUv;
    aj<com.facebook.imagepipeline.g.e> lVa;
    aj<Void> lVb;
    aj<Void> lVc;
    private aj<com.facebook.imagepipeline.g.e> lVd;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lVe;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lVf;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lVg;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lVh;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lVi;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lVj;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lVk;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lVl = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> lVm = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> lVn = new HashMap();
    private final ContentResolver mContentResolver;

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.lUO = lVar;
        this.lUh = afVar;
        this.lUl = z;
        this.lUv = z2;
        this.lTS = atVar;
        this.lUX = z3;
        this.lUA = z4;
        this.lUE = z5;
        this.lUp = z6;
    }

    public aj<Void> c(ImageRequest imageRequest) {
        d(imageRequest);
        switch (imageRequest.dsP()) {
            case 0:
                return dqt();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + S(imageRequest.dsO()));
            case 2:
            case 3:
                return dqv();
        }
    }

    private static void d(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.drX().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g = g(imageRequest);
        if (imageRequest.dsX() != null) {
            g = v(g);
        }
        if (this.lUA) {
            return x(g);
        }
        return g;
    }

    public aj<Void> f(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g = g(imageRequest);
        if (this.lUA) {
            g = x(g);
        }
        return w(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> g(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri dsO = imageRequest.dsO();
        com.facebook.common.internal.g.checkNotNull(dsO, "Uri is null.");
        switch (imageRequest.dsP()) {
            case 0:
                return dqr();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + S(dsO));
            case 2:
                return dqy();
            case 3:
                return dqx();
            case 4:
                if (com.facebook.common.d.a.OR(this.mContentResolver.getType(dsO))) {
                    return dqy();
                }
                return dqz();
            case 5:
                return dqC();
            case 6:
                return dqB();
            case 7:
                return dqD();
            case 8:
                return dqA();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqr() {
        if (this.lUY == null) {
            this.lUY = r(dqu());
        }
        return this.lUY;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dqs() {
        if (this.lVa == null) {
            this.lVa = this.lUO.a(dqu(), this.lTS);
        }
        return this.lVa;
    }

    private synchronized aj<Void> dqt() {
        if (this.lVc == null) {
            this.lVc = l.m(dqs());
        }
        return this.lVc;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dqu() {
        if (this.lVd == null) {
            this.lVd = l.a(s(this.lUO.b(this.lUh)));
            this.lVd = this.lUO.a(this.lVd, this.lUl, this.lUX);
        }
        return this.lVd;
    }

    private synchronized aj<Void> dqv() {
        if (this.lVb == null) {
            this.lVb = l.m(dqw());
        }
        return this.lVb;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dqw() {
        if (this.lUZ == null) {
            this.lUZ = this.lUO.a(s(this.lUO.dqn()), this.lTS);
        }
        return this.lUZ;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqx() {
        if (this.lVe == null) {
            this.lVe = q(this.lUO.dqn());
        }
        return this.lVe;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqy() {
        if (this.lVf == null) {
            this.lVf = u(this.lUO.dqq());
        }
        return this.lVf;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqz() {
        if (this.lVg == null) {
            this.lVg = a(this.lUO.dqk(), new aw[]{this.lUO.dql(), this.lUO.dqm()});
        }
        return this.lVg;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqA() {
        if (this.lVk == null) {
            this.lVk = q(this.lUO.dqo());
        }
        return this.lVk;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqB() {
        if (this.lVh == null) {
            this.lVh = q(this.lUO.dqp());
        }
        return this.lVh;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqC() {
        if (this.lVi == null) {
            this.lVi = q(this.lUO.dqj());
        }
        return this.lVi;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqD() {
        if (this.lVj == null) {
            aj<com.facebook.imagepipeline.g.e> dqi = this.lUO.dqi();
            if (com.facebook.common.g.c.lKV && (!this.lUv || com.facebook.common.g.c.lKX == null)) {
                dqi = this.lUO.o(dqi);
            }
            l lVar = this.lUO;
            this.lVj = r(this.lUO.a(l.a(dqi), true, this.lUX));
        }
        return this.lVj;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.lUO.dqm()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.lUO.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.lKV && (!this.lUv || com.facebook.common.g.c.lKX == null)) {
            ajVar = this.lUO.o(ajVar);
        }
        if (this.lUp) {
            ajVar = t(ajVar);
        }
        return this.lUO.i(this.lUO.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.lUE) {
            g = this.lUO.g(this.lUO.h(ajVar));
        } else {
            g = this.lUO.g(ajVar);
        }
        return this.lUO.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.lUO.b(this.lUO.a(this.lUO.c(this.lUO.d(ajVar)), this.lTS));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.lUO.n(this.lUO.a(l.a(ajVar), true, this.lUX));
        l lVar = this.lUO;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.lUO.a(this.lUO.a(awVarArr), true, this.lUX);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.lVl.containsKey(ajVar)) {
            this.lVl.put(ajVar, this.lUO.k(this.lUO.l(ajVar)));
        }
        return this.lVl.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.lVm.containsKey(ajVar)) {
            l lVar = this.lUO;
            this.lVm.put(ajVar, l.m(ajVar));
        }
        return this.lVm.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.lVn.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.lUO.p(ajVar);
            this.lVn.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String S(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
