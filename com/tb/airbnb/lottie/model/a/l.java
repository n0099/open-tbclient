package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e mPs;
    private final m<PointF, PointF> mPt;
    private final g mPu;
    private final b mPv;
    private final d mPw;
    @Nullable
    private final b mPx;
    @Nullable
    private final b mPy;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.mPs = eVar;
        this.mPt = mVar;
        this.mPu = gVar;
        this.mPv = bVar;
        this.mPw = dVar;
        this.mPx = bVar2;
        this.mPy = bVar3;
    }

    public e dBu() {
        return this.mPs;
    }

    public m<PointF, PointF> dBv() {
        return this.mPt;
    }

    public g dBw() {
        return this.mPu;
    }

    public b dBx() {
        return this.mPv;
    }

    public d dBy() {
        return this.mPw;
    }

    @Nullable
    public b dBz() {
        return this.mPx;
    }

    @Nullable
    public b dBA() {
        return this.mPy;
    }

    public o dBB() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
