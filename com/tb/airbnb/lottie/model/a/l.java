package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e nqJ;
    private final m<PointF, PointF> nqK;
    private final g nqL;
    private final b nqM;
    private final d nqN;
    @Nullable
    private final b nqO;
    @Nullable
    private final b nqP;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.nqJ = eVar;
        this.nqK = mVar;
        this.nqL = gVar;
        this.nqM = bVar;
        this.nqN = dVar;
        this.nqO = bVar2;
        this.nqP = bVar3;
    }

    public e dGR() {
        return this.nqJ;
    }

    public m<PointF, PointF> dGS() {
        return this.nqK;
    }

    public g dGT() {
        return this.nqL;
    }

    public b dGU() {
        return this.nqM;
    }

    public d dGV() {
        return this.nqN;
    }

    @Nullable
    public b dGW() {
        return this.nqO;
    }

    @Nullable
    public b dGX() {
        return this.nqP;
    }

    public o dGY() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
