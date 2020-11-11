package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes16.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e pJn;
    private final m<PointF, PointF> pJo;
    private final g pJp;
    private final b pJq;
    private final d pJr;
    @Nullable
    private final b pJs;
    @Nullable
    private final b pJt;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.pJn = eVar;
        this.pJo = mVar;
        this.pJp = gVar;
        this.pJq = bVar;
        this.pJr = dVar;
        this.pJs = bVar2;
        this.pJt = bVar3;
    }

    public e eyN() {
        return this.pJn;
    }

    public m<PointF, PointF> eyO() {
        return this.pJo;
    }

    public g eyP() {
        return this.pJp;
    }

    public b eyQ() {
        return this.pJq;
    }

    public d eyR() {
        return this.pJr;
    }

    @Nullable
    public b eyS() {
        return this.pJs;
    }

    @Nullable
    public b eyT() {
        return this.pJt;
    }

    public o eyU() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
