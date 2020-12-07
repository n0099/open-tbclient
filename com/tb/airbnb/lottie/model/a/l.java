package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes20.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e pBU;
    private final m<PointF, PointF> pBV;
    private final g pBW;
    private final b pBX;
    private final d pBY;
    @Nullable
    private final b pBZ;
    @Nullable
    private final b pCa;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.pBU = eVar;
        this.pBV = mVar;
        this.pBW = gVar;
        this.pBX = bVar;
        this.pBY = dVar;
        this.pBZ = bVar2;
        this.pCa = bVar3;
    }

    public e eBk() {
        return this.pBU;
    }

    public m<PointF, PointF> eBl() {
        return this.pBV;
    }

    public g eBm() {
        return this.pBW;
    }

    public b eBn() {
        return this.pBX;
    }

    public d eBo() {
        return this.pBY;
    }

    @Nullable
    public b eBp() {
        return this.pBZ;
    }

    @Nullable
    public b eBq() {
        return this.pCa;
    }

    public o eBr() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
