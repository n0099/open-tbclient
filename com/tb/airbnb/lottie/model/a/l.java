package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e nkI;
    private final m<PointF, PointF> nkJ;
    private final g nkK;
    private final b nkL;
    private final d nkM;
    @Nullable
    private final b nkN;
    @Nullable
    private final b nkO;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.nkI = eVar;
        this.nkJ = mVar;
        this.nkK = gVar;
        this.nkL = bVar;
        this.nkM = dVar;
        this.nkN = bVar2;
        this.nkO = bVar3;
    }

    public e dIY() {
        return this.nkI;
    }

    public m<PointF, PointF> dIZ() {
        return this.nkJ;
    }

    public g dJa() {
        return this.nkK;
    }

    public b dJb() {
        return this.nkL;
    }

    public d dJc() {
        return this.nkM;
    }

    @Nullable
    public b dJd() {
        return this.nkN;
    }

    @Nullable
    public b dJe() {
        return this.nkO;
    }

    public o dJf() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
