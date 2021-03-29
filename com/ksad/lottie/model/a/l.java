package com.ksad.lottie.model.a;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.ksad.lottie.model.content.b {

    /* renamed from: a  reason: collision with root package name */
    public final e f31459a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f31460b;

    /* renamed from: c  reason: collision with root package name */
    public final g f31461c;

    /* renamed from: d  reason: collision with root package name */
    public final b f31462d;

    /* renamed from: e  reason: collision with root package name */
    public final d f31463e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final b f31464f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final b f31465g;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.f31459a = eVar;
        this.f31460b = mVar;
        this.f31461c = gVar;
        this.f31462d = bVar;
        this.f31463e = dVar;
        this.f31464f = bVar2;
        this.f31465g = bVar3;
    }

    @Override // com.ksad.lottie.model.content.b
    @Nullable
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return null;
    }

    public e a() {
        return this.f31459a;
    }

    public m<PointF, PointF> b() {
        return this.f31460b;
    }

    public g c() {
        return this.f31461c;
    }

    public b d() {
        return this.f31462d;
    }

    public d e() {
        return this.f31463e;
    }

    @Nullable
    public b f() {
        return this.f31464f;
    }

    @Nullable
    public b g() {
        return this.f31465g;
    }

    public o h() {
        return new o(this);
    }
}
