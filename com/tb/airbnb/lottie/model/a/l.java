package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e nGA;
    private final m<PointF, PointF> nGB;
    private final g nGC;
    private final b nGD;
    private final d nGE;
    @Nullable
    private final b nGF;
    @Nullable
    private final b nGG;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.nGA = eVar;
        this.nGB = mVar;
        this.nGC = gVar;
        this.nGD = bVar;
        this.nGE = dVar;
        this.nGF = bVar2;
        this.nGG = bVar3;
    }

    public e dNI() {
        return this.nGA;
    }

    public m<PointF, PointF> dNJ() {
        return this.nGB;
    }

    public g dNK() {
        return this.nGC;
    }

    public b dNL() {
        return this.nGD;
    }

    public d dNM() {
        return this.nGE;
    }

    @Nullable
    public b dNN() {
        return this.nGF;
    }

    @Nullable
    public b dNO() {
        return this.nGG;
    }

    public o dNP() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
