package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final b nGA;
    private final d nGB;
    @Nullable
    private final b nGC;
    @Nullable
    private final b nGD;
    private final e nGx;
    private final m<PointF, PointF> nGy;
    private final g nGz;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.nGx = eVar;
        this.nGy = mVar;
        this.nGz = gVar;
        this.nGA = bVar;
        this.nGB = dVar;
        this.nGC = bVar2;
        this.nGD = bVar3;
    }

    public e dNE() {
        return this.nGx;
    }

    public m<PointF, PointF> dNF() {
        return this.nGy;
    }

    public g dNG() {
        return this.nGz;
    }

    public b dNH() {
        return this.nGA;
    }

    public d dNI() {
        return this.nGB;
    }

    @Nullable
    public b dNJ() {
        return this.nGC;
    }

    @Nullable
    public b dNK() {
        return this.nGD;
    }

    public o dNL() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
