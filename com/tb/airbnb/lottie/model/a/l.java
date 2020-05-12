package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    @Nullable
    private final b mPA;
    @Nullable
    private final b mPB;
    private final e mPv;
    private final m<PointF, PointF> mPw;
    private final g mPx;
    private final b mPy;
    private final d mPz;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.mPv = eVar;
        this.mPw = mVar;
        this.mPx = gVar;
        this.mPy = bVar;
        this.mPz = dVar;
        this.mPA = bVar2;
        this.mPB = bVar3;
    }

    public e dBr() {
        return this.mPv;
    }

    public m<PointF, PointF> dBs() {
        return this.mPw;
    }

    public g dBt() {
        return this.mPx;
    }

    public b dBu() {
        return this.mPy;
    }

    public d dBv() {
        return this.mPz;
    }

    @Nullable
    public b dBw() {
        return this.mPA;
    }

    @Nullable
    public b dBx() {
        return this.mPB;
    }

    public o dBy() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
