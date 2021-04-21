package com.ksad.lottie.model.a;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.ksad.lottie.model.content.b {

    /* renamed from: a  reason: collision with root package name */
    public final e f31843a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f31844b;

    /* renamed from: c  reason: collision with root package name */
    public final g f31845c;

    /* renamed from: d  reason: collision with root package name */
    public final b f31846d;

    /* renamed from: e  reason: collision with root package name */
    public final d f31847e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final b f31848f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final b f31849g;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.f31843a = eVar;
        this.f31844b = mVar;
        this.f31845c = gVar;
        this.f31846d = bVar;
        this.f31847e = dVar;
        this.f31848f = bVar2;
        this.f31849g = bVar3;
    }

    @Override // com.ksad.lottie.model.content.b
    @Nullable
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return null;
    }

    public e a() {
        return this.f31843a;
    }

    public m<PointF, PointF> b() {
        return this.f31844b;
    }

    public g c() {
        return this.f31845c;
    }

    public b d() {
        return this.f31846d;
    }

    public d e() {
        return this.f31847e;
    }

    @Nullable
    public b f() {
        return this.f31848f;
    }

    @Nullable
    public b g() {
        return this.f31849g;
    }

    public o h() {
        return new o(this);
    }
}
