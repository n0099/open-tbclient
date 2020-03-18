package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e nsH;
    private final m<PointF, PointF> nsI;
    private final g nsJ;
    private final b nsK;
    private final d nsL;
    @Nullable
    private final b nsM;
    @Nullable
    private final b nsN;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.nsH = eVar;
        this.nsI = mVar;
        this.nsJ = gVar;
        this.nsK = bVar;
        this.nsL = dVar;
        this.nsM = bVar2;
        this.nsN = bVar3;
    }

    public e dHs() {
        return this.nsH;
    }

    public m<PointF, PointF> dHt() {
        return this.nsI;
    }

    public g dHu() {
        return this.nsJ;
    }

    public b dHv() {
        return this.nsK;
    }

    public d dHw() {
        return this.nsL;
    }

    @Nullable
    public b dHx() {
        return this.nsM;
    }

    @Nullable
    public b dHy() {
        return this.nsN;
    }

    public o dHz() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
