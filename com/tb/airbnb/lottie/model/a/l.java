package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes5.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e nqa;
    private final m<PointF, PointF> nqb;
    private final g nqc;
    private final b nqd;
    private final d nqe;
    @Nullable
    private final b nqf;
    @Nullable
    private final b nqg;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.nqa = eVar;
        this.nqb = mVar;
        this.nqc = gVar;
        this.nqd = bVar;
        this.nqe = dVar;
        this.nqf = bVar2;
        this.nqg = bVar3;
    }

    public e dFG() {
        return this.nqa;
    }

    public m<PointF, PointF> dFH() {
        return this.nqb;
    }

    public g dFI() {
        return this.nqc;
    }

    public b dFJ() {
        return this.nqd;
    }

    public d dFK() {
        return this.nqe;
    }

    @Nullable
    public b dFL() {
        return this.nqf;
    }

    @Nullable
    public b dFM() {
        return this.nqg;
    }

    public o dFN() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
