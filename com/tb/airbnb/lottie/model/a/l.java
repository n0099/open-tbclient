package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes16.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e pzT;
    private final m<PointF, PointF> pzU;
    private final g pzV;
    private final b pzW;
    private final d pzX;
    @Nullable
    private final b pzY;
    @Nullable
    private final b pzZ;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.pzT = eVar;
        this.pzU = mVar;
        this.pzV = gVar;
        this.pzW = bVar;
        this.pzX = dVar;
        this.pzY = bVar2;
        this.pzZ = bVar3;
    }

    public e euY() {
        return this.pzT;
    }

    public m<PointF, PointF> euZ() {
        return this.pzU;
    }

    public g eva() {
        return this.pzV;
    }

    public b evb() {
        return this.pzW;
    }

    public d evc() {
        return this.pzX;
    }

    @Nullable
    public b evd() {
        return this.pzY;
    }

    @Nullable
    public b eve() {
        return this.pzZ;
    }

    public o evf() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
