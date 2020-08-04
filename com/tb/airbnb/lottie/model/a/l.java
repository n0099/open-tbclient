package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes5.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e nPk;
    private final m<PointF, PointF> nPl;
    private final g nPm;
    private final b nPn;
    private final d nPo;
    @Nullable
    private final b nPp;
    @Nullable
    private final b nPq;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.nPk = eVar;
        this.nPl = mVar;
        this.nPm = gVar;
        this.nPn = bVar;
        this.nPo = dVar;
        this.nPp = bVar2;
        this.nPq = bVar3;
    }

    public e dRf() {
        return this.nPk;
    }

    public m<PointF, PointF> dRg() {
        return this.nPl;
    }

    public g dRh() {
        return this.nPm;
    }

    public b dRi() {
        return this.nPn;
    }

    public d dRj() {
        return this.nPo;
    }

    @Nullable
    public b dRk() {
        return this.nPp;
    }

    @Nullable
    public b dRl() {
        return this.nPq;
    }

    public o dRm() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
