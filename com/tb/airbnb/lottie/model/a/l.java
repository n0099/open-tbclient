package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes20.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e pBW;
    private final m<PointF, PointF> pBX;
    private final g pBY;
    private final b pBZ;
    private final d pCa;
    @Nullable
    private final b pCb;
    @Nullable
    private final b pCc;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.pBW = eVar;
        this.pBX = mVar;
        this.pBY = gVar;
        this.pBZ = bVar;
        this.pCa = dVar;
        this.pCb = bVar2;
        this.pCc = bVar3;
    }

    public e eBl() {
        return this.pBW;
    }

    public m<PointF, PointF> eBm() {
        return this.pBX;
    }

    public g eBn() {
        return this.pBY;
    }

    public b eBo() {
        return this.pBZ;
    }

    public d eBp() {
        return this.pCa;
    }

    @Nullable
    public b eBq() {
        return this.pCb;
    }

    @Nullable
    public b eBr() {
        return this.pCc;
    }

    public o eBs() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
