package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes17.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e pKQ;
    private final m<PointF, PointF> pKR;
    private final g pKS;
    private final b pKT;
    private final d pKU;
    @Nullable
    private final b pKV;
    @Nullable
    private final b pKW;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.pKQ = eVar;
        this.pKR = mVar;
        this.pKS = gVar;
        this.pKT = bVar;
        this.pKU = dVar;
        this.pKV = bVar2;
        this.pKW = bVar3;
    }

    public e eyO() {
        return this.pKQ;
    }

    public m<PointF, PointF> eyP() {
        return this.pKR;
    }

    public g eyQ() {
        return this.pKS;
    }

    public b eyR() {
        return this.pKT;
    }

    public d eyS() {
        return this.pKU;
    }

    @Nullable
    public b eyT() {
        return this.pKV;
    }

    @Nullable
    public b eyU() {
        return this.pKW;
    }

    public o eyV() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
