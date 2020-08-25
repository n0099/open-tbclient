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
    private final at nuL;
    private final l nvH;
    private final boolean nvQ;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nvR;
    aj<com.facebook.imagepipeline.g.e> nvS;
    aj<com.facebook.imagepipeline.g.e> nvT;
    aj<Void> nvU;
    aj<Void> nvV;
    private aj<com.facebook.imagepipeline.g.e> nvW;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nvX;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nvY;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nvZ;
    private final af nva;
    private final boolean nve;
    private final boolean nvi;
    private final boolean nvo;
    private final boolean nvt;
    private final boolean nvx;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nwa;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nwb;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nwc;
    aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nwd;
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> nwe = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<Void>> nwf = new HashMap();
    Map<aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>> nwg = new HashMap();

    public m(ContentResolver contentResolver, l lVar, af afVar, boolean z, boolean z2, at atVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mContentResolver = contentResolver;
        this.nvH = lVar;
        this.nva = afVar;
        this.nve = z;
        this.nvo = z2;
        this.nuL = atVar;
        this.nvQ = z3;
        this.nvt = z4;
        this.nvx = z5;
        this.nvi = z6;
    }

    public aj<Void> b(ImageRequest imageRequest) {
        c(imageRequest);
        switch (imageRequest.dWh()) {
            case 0:
                return dTN();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + V(imageRequest.dWg()));
            case 2:
            case 3:
                return dTP();
        }
    }

    private static void c(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        com.facebook.common.internal.g.checkArgument(imageRequest.dVq().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> d(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (imageRequest.dWo() != null) {
            f = v(f);
        }
        if (this.nvt) {
            return x(f);
        }
        return f;
    }

    public aj<Void> e(ImageRequest imageRequest) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f = f(imageRequest);
        if (this.nvt) {
            f = x(f);
        }
        return w(f);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> f(ImageRequest imageRequest) {
        com.facebook.common.internal.g.checkNotNull(imageRequest);
        Uri dWg = imageRequest.dWg();
        com.facebook.common.internal.g.checkNotNull(dWg, "Uri is null.");
        switch (imageRequest.dWh()) {
            case 0:
                return dTL();
            case 1:
            default:
                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + V(dWg));
            case 2:
                return dTS();
            case 3:
                return dTR();
            case 4:
                if (com.facebook.common.d.a.Us(this.mContentResolver.getType(dWg))) {
                    return dTS();
                }
                return dTT();
            case 5:
                return dTW();
            case 6:
                return dTV();
            case 7:
                return dTX();
            case 8:
                return dTU();
        }
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dTL() {
        if (this.nvR == null) {
            this.nvR = r(dTO());
        }
        return this.nvR;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dTM() {
        if (this.nvT == null) {
            this.nvT = this.nvH.a(dTO(), this.nuL);
        }
        return this.nvT;
    }

    private synchronized aj<Void> dTN() {
        if (this.nvV == null) {
            this.nvV = l.m(dTM());
        }
        return this.nvV;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dTO() {
        if (this.nvW == null) {
            this.nvW = l.a(s(this.nvH.b(this.nva)));
            this.nvW = this.nvH.a(this.nvW, this.nve, this.nvQ);
        }
        return this.nvW;
    }

    private synchronized aj<Void> dTP() {
        if (this.nvU == null) {
            this.nvU = l.m(dTQ());
        }
        return this.nvU;
    }

    private synchronized aj<com.facebook.imagepipeline.g.e> dTQ() {
        if (this.nvS == null) {
            this.nvS = this.nvH.a(s(this.nvH.dTH()), this.nuL);
        }
        return this.nvS;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dTR() {
        if (this.nvX == null) {
            this.nvX = q(this.nvH.dTH());
        }
        return this.nvX;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dTS() {
        if (this.nvY == null) {
            this.nvY = u(this.nvH.dTK());
        }
        return this.nvY;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dTT() {
        if (this.nvZ == null) {
            this.nvZ = a(this.nvH.dTE(), new aw[]{this.nvH.dTF(), this.nvH.dTG()});
        }
        return this.nvZ;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dTU() {
        if (this.nwd == null) {
            this.nwd = q(this.nvH.dTI());
        }
        return this.nwd;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dTV() {
        if (this.nwa == null) {
            this.nwa = q(this.nvH.dTJ());
        }
        return this.nwa;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dTW() {
        if (this.nwb == null) {
            this.nwb = q(this.nvH.dTD());
        }
        return this.nwb;
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dTX() {
        if (this.nwc == null) {
            aj<com.facebook.imagepipeline.g.e> dTC = this.nvH.dTC();
            if (com.facebook.common.g.c.nlx && (!this.nvo || com.facebook.common.g.c.nlA == null)) {
                dTC = this.nvH.o(dTC);
            }
            l lVar = this.nvH;
            this.nwc = r(this.nvH.a(l.a(dTC), true, this.nvQ));
        }
        return this.nwc;
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> q(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return a(ajVar, new aw[]{this.nvH.dTG()});
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return r(b(s(ajVar), awVarArr));
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> r(aj<com.facebook.imagepipeline.g.e> ajVar) {
        return u(this.nvH.e(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> s(aj<com.facebook.imagepipeline.g.e> ajVar) {
        if (com.facebook.common.g.c.nlx && (!this.nvo || com.facebook.common.g.c.nlA == null)) {
            ajVar = this.nvH.o(ajVar);
        }
        if (this.nvi) {
            ajVar = t(ajVar);
        }
        return this.nvH.i(this.nvH.j(ajVar));
    }

    private aj<com.facebook.imagepipeline.g.e> t(aj<com.facebook.imagepipeline.g.e> ajVar) {
        p g;
        if (this.nvx) {
            g = this.nvH.g(this.nvH.h(ajVar));
        } else {
            g = this.nvH.g(ajVar);
        }
        return this.nvH.f(g);
    }

    private aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> u(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        return this.nvH.b(this.nvH.a(this.nvH.c(this.nvH.d(ajVar)), this.nuL));
    }

    private aj<com.facebook.imagepipeline.g.e> b(aj<com.facebook.imagepipeline.g.e> ajVar, aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        au n = this.nvH.n(this.nvH.a(l.a(ajVar), true, this.nvQ));
        l lVar = this.nvH;
        return l.a(b(awVarArr), n);
    }

    private aj<com.facebook.imagepipeline.g.e> b(aw<com.facebook.imagepipeline.g.e>[] awVarArr) {
        return this.nvH.a(this.nvH.a(awVarArr), true, this.nvQ);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> v(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.nwe.containsKey(ajVar)) {
            this.nwe.put(ajVar, this.nvH.k(this.nvH.l(ajVar)));
        }
        return this.nwe.get(ajVar);
    }

    private synchronized aj<Void> w(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        if (!this.nwf.containsKey(ajVar)) {
            l lVar = this.nvH;
            this.nwf.put(ajVar, l.m(ajVar));
        }
        return this.nwf.get(ajVar);
    }

    private synchronized aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> x(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar2;
        ajVar2 = this.nwg.get(ajVar);
        if (ajVar2 == null) {
            ajVar2 = this.nvH.p(ajVar);
            this.nwg.put(ajVar, ajVar2);
        }
        return ajVar2;
    }

    private static String V(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + StringHelper.STRING_MORE : valueOf;
    }
}
