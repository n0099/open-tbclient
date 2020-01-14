package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes5.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e nqf;
    private final m<PointF, PointF> nqg;
    private final g nqh;
    private final b nqi;
    private final d nqj;
    @Nullable
    private final b nqk;
    @Nullable
    private final b nql;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.nqf = eVar;
        this.nqg = mVar;
        this.nqh = gVar;
        this.nqi = bVar;
        this.nqj = dVar;
        this.nqk = bVar2;
        this.nql = bVar3;
    }

    public e dFI() {
        return this.nqf;
    }

    public m<PointF, PointF> dFJ() {
        return this.nqg;
    }

    public g dFK() {
        return this.nqh;
    }

    public b dFL() {
        return this.nqi;
    }

    public d dFM() {
        return this.nqj;
    }

    @Nullable
    public b dFN() {
        return this.nqk;
    }

    @Nullable
    public b dFO() {
        return this.nql;
    }

    public o dFP() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
