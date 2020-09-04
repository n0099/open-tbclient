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
/* loaded from: classes8.dex */
public class m {
    private final ContentResolver mContentResolver;
    private final boolean nvA;
    private final boolean nvG;
    private final boolean nvL;
    private final boolean nvP;
    private final l nvZ;
    private final at nvd;
    private final af nvs;
    private final boolean nvw;
    private final boolean nwi;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nwj;
    aj<com.facebook.imagepipeline.g.e> nwk;
    aj<com.facebook.imagepipeline.g.e> nwl;
    aj<Void> nwm;
    aj<Void> nwn;
    private aj<com.facebook.imagepipeline.g.e> nwo;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nwp;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nwq;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nwr;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nws;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nwt;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nwu;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nwv;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> nww = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> nwx = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> nwy = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.nvZ = lVar;
        this.nvs = afVar;
        this.nvw = z;
        this.nvG = z2;
        this.nvd = atVar;
        this.nwi = z3;
        this.nvL = z4;
        this.nvP = z5;
        this.nvA = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.dWq()) {
            case 0:
                return dTW();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + V(imageRequest.dWp()));
            case 2:
            case 3:
                return dTY();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.dVz().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.dWx() != null) {
            f = v(f);
        }
        if (this.nvL) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.nvL) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri dWp = imageRequest.dWp();
        com.facebook.common.internal.g.checkNotNull(dWp, "Uri is null.");
        switch (imageRequest.dWq()) {
            case 0:
                return dTU();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + V(dWp));
            case 2:
                return dUb();
            case 3:
                return dUa();
            case 4:
                if (com.facebook.common.d.a.Us(this.mContentResolver.getType(dWp))) {
                    return dUb();
                }
                return dUc();
            case 5:
                return dUf();
            case 6:
                return dUe();
            case 7:
                return dUg();
            case 8:
                return dUd();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dTU() {
        if (this.nwj == null) {
            this.nwj = r(dTX());
        }
        return this.nwj;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dTV() {
        if (this.nwl == null) {
            this.nwl = this.nvZ.a(dTX(), this.nvd);
        }
        return this.nwl;
    }

    private synchronized aj<Void> dTW() {
        if (this.nwn == null) {
            this.nwn = l.m(dTV());
        }
        return this.nwn;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dTX() {
        if (this.nwo == null) {
            this.nwo = l.a(s(this.nvZ.b(this.nvs)));
            this.nwo = this.nvZ.a(this.nwo, this.nvw, this.nwi);
        }
        return this.nwo;
    }

    private synchronized aj<Void> dTY() {
        if (this.nwm == null) {
            this.nwm = l.m(dTZ());
        }
        return this.nwm;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dTZ() {
        if (this.nwk == null) {
            this.nwk = this.nvZ.a(s(this.nvZ.dTQ()), this.nvd);
        }
        return this.nwk;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dUa() {
        if (this.nwp == null) {
            this.nwp = q(this.nvZ.dTQ());
        }
        return this.nwp;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dUb() {
        if (this.nwq == null) {
            this.nwq = u(this.nvZ.dTT());
        }
        return this.nwq;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dUc() {
        if (this.nwr == null) {
            this.nwr = a(this.nvZ.dTN(), new aw[]{this.nvZ.dTO(), this.nvZ.dTP()});
        }
        return this.nwr;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dUd() {
        if (this.nwv == null) {
            this.nwv = q(this.nvZ.dTR());
        }
        return this.nwv;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dUe() {
        if (this.nws == null) {
            this.nws = q(this.nvZ.dTS());
        }
        return this.nws;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dUf() {
        if (this.nwt == null) {
            this.nwt = q(this.nvZ.dTM());
        }
        return this.nwt;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dUg() {
        if (this.nwu == null) {
            aj<com.facebook.imagepipeline.g.e> dTL = this.nvZ.dTL();
            if (com.facebook.common.g.c.nlP && (!this.nvG || com.facebook.common.g.c.nlS == null)) {
                dTL = this.nvZ.o(dTL);
            }
            l lVar = this.nvZ;
            this.nwu = r(this.nvZ.a(l.a(dTL), true, this.nwi));
        }
        return this.nwu;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.nvZ.dTP()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.nvZ.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.nlP && (!this.nvG || com.facebook.common.g.c.nlS == null)) {
            ajVar = this.nvZ.o(ajVar);
        }
        if (this.nvA) {
            ajVar = t(ajVar);
        }
        return this.nvZ.i(this.nvZ.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.nvP) {
            g = this.nvZ.g(this.nvZ.h(ajVar));
        } else {
            g = this.nvZ.g(ajVar);
        }
        return this.nvZ.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.nvZ.b(this.nvZ.a(this.nvZ.c(this.nvZ.d(ajVar)), this.nvd));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.nvZ.n(this.nvZ.a(l.a(ajVar), true, this.nwi));
        l lVar = this.nvZ;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.nvZ.a(this.nvZ.a(awVarArr), true, this.nwi);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.nww.containsKey(ajVar)) {
            this.nww.put(ajVar, this.nvZ.k(this.nvZ.l(ajVar)));
        }
        return this.nww.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.nwx.containsKey(ajVar)) {
            l lVar = this.nvZ;
            this.nwx.put(ajVar, l.m(ajVar));
        }
        return this.nwx.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.nwy.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.nvZ.p(ajVar);
            this.nwy.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String V(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
