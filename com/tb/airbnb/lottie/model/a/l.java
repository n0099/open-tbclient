package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e nqH;
    private final m<PointF, PointF> nqI;
    private final g nqJ;
    private final b nqK;
    private final d nqL;
    @Nullable
    private final b nqM;
    @Nullable
    private final b nqN;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.nqH = eVar;
        this.nqI = mVar;
        this.nqJ = gVar;
        this.nqK = bVar;
        this.nqL = dVar;
        this.nqM = bVar2;
        this.nqN = bVar3;
    }

    public e dGP() {
        return this.nqH;
    }

    public m<PointF, PointF> dGQ() {
        return this.nqI;
    }

    public g dGR() {
        return this.nqJ;
    }

    public b dGS() {
        return this.nqK;
    }

    public d dGT() {
        return this.nqL;
    }

    @Nullable
    public b dGU() {
        return this.nqM;
    }

    @Nullable
    public b dGV() {
        return this.nqN;
    }

    public o dGW() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
