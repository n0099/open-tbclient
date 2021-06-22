package com.ksad.lottie.model.a;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.ksad.lottie.model.content.b {

    /* renamed from: a  reason: collision with root package name */
    public final e f32089a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f32090b;

    /* renamed from: c  reason: collision with root package name */
    public final g f32091c;

    /* renamed from: d  reason: collision with root package name */
    public final b f32092d;

    /* renamed from: e  reason: collision with root package name */
    public final d f32093e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final b f32094f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final b f32095g;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.f32089a = eVar;
        this.f32090b = mVar;
        this.f32091c = gVar;
        this.f32092d = bVar;
        this.f32093e = dVar;
        this.f32094f = bVar2;
        this.f32095g = bVar3;
    }

    @Override // com.ksad.lottie.model.content.b
    @Nullable
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return null;
    }

    public e a() {
        return this.f32089a;
    }

    public m<PointF, PointF> b() {
        return this.f32090b;
    }

    public g c() {
        return this.f32091c;
    }

    public b d() {
        return this.f32092d;
    }

    public d e() {
        return this.f32093e;
    }

    @Nullable
    public b f() {
        return this.f32094f;
    }

    @Nullable
    public b g() {
        return this.f32095g;
    }

    public o h() {
        return new o(this);
    }
}
