package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes5.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e nPi;
    private final m<PointF, PointF> nPj;
    private final g nPk;
    private final b nPl;
    private final d nPm;
    @Nullable
    private final b nPn;
    @Nullable
    private final b nPo;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.nPi = eVar;
        this.nPj = mVar;
        this.nPk = gVar;
        this.nPl = bVar;
        this.nPm = dVar;
        this.nPn = bVar2;
        this.nPo = bVar3;
    }

    public e dRe() {
        return this.nPi;
    }

    public m<PointF, PointF> dRf() {
        return this.nPj;
    }

    public g dRg() {
        return this.nPk;
    }

    public b dRh() {
        return this.nPl;
    }

    public d dRi() {
        return this.nPm;
    }

    @Nullable
    public b dRj() {
        return this.nPn;
    }

    @Nullable
    public b dRk() {
        return this.nPo;
    }

    public o dRl() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
