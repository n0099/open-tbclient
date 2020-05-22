package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final g njA;
    private final b njB;
    private final d njC;
    @Nullable
    private final b njD;
    @Nullable
    private final b njE;
    private final e njy;
    private final m<PointF, PointF> njz;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.njy = eVar;
        this.njz = mVar;
        this.njA = gVar;
        this.njB = bVar;
        this.njC = dVar;
        this.njD = bVar2;
        this.njE = bVar3;
    }

    public e dIK() {
        return this.njy;
    }

    public m<PointF, PointF> dIL() {
        return this.njz;
    }

    public g dIM() {
        return this.njA;
    }

    public b dIN() {
        return this.njB;
    }

    public d dIO() {
        return this.njC;
    }

    @Nullable
    public b dIP() {
        return this.njD;
    }

    @Nullable
    public b dIQ() {
        return this.njE;
    }

    public o dIR() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
