package com.ksad.lottie.model.a;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.o;
/* loaded from: classes3.dex */
public class l implements com.ksad.lottie.model.content.b {

    /* renamed from: a  reason: collision with root package name */
    private final e f5376a;
    private final m<PointF, PointF> b;
    private final g c;
    private final b d;
    private final d e;
    @Nullable
    private final b f;
    @Nullable
    private final b g;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.f5376a = eVar;
        this.b = mVar;
        this.c = gVar;
        this.d = bVar;
        this.e = dVar;
        this.f = bVar2;
        this.g = bVar3;
    }

    @Override // com.ksad.lottie.model.content.b
    @Nullable
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return null;
    }

    public e a() {
        return this.f5376a;
    }

    public m<PointF, PointF> b() {
        return this.b;
    }

    public g c() {
        return this.c;
    }

    public b d() {
        return this.d;
    }

    public d e() {
        return this.e;
    }

    @Nullable
    public b f() {
        return this.f;
    }

    @Nullable
    public b g() {
        return this.g;
    }

    public o h() {
        return new o(this);
    }
}
