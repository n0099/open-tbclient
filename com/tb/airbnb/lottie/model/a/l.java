package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes16.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final d oIA;
    @Nullable
    private final b oIB;
    @Nullable
    private final b oIC;
    private final e oIw;
    private final m<PointF, PointF> oIx;
    private final g oIy;
    private final b oIz;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.oIw = eVar;
        this.oIx = mVar;
        this.oIy = gVar;
        this.oIz = bVar;
        this.oIA = dVar;
        this.oIB = bVar2;
        this.oIC = bVar3;
    }

    public e ekY() {
        return this.oIw;
    }

    public m<PointF, PointF> ekZ() {
        return this.oIx;
    }

    public g ela() {
        return this.oIy;
    }

    public b elb() {
        return this.oIz;
    }

    public d elc() {
        return this.oIA;
    }

    @Nullable
    public b eld() {
        return this.oIB;
    }

    @Nullable
    public b ele() {
        return this.oIC;
    }

    public o elf() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
