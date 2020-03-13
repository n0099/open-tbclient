package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e nqU;
    private final m<PointF, PointF> nqV;
    private final g nqW;
    private final b nqX;
    private final d nqY;
    @Nullable
    private final b nqZ;
    @Nullable
    private final b nra;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.nqU = eVar;
        this.nqV = mVar;
        this.nqW = gVar;
        this.nqX = bVar;
        this.nqY = dVar;
        this.nqZ = bVar2;
        this.nra = bVar3;
    }

    public e dGS() {
        return this.nqU;
    }

    public m<PointF, PointF> dGT() {
        return this.nqV;
    }

    public g dGU() {
        return this.nqW;
    }

    public b dGV() {
        return this.nqX;
    }

    public d dGW() {
        return this.nqY;
    }

    @Nullable
    public b dGX() {
        return this.nqZ;
    }

    @Nullable
    public b dGY() {
        return this.nra;
    }

    public o dGZ() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
