package com.ksad.lottie.model.a;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.ksad.lottie.model.content.b {

    /* renamed from: a  reason: collision with root package name */
    public final e f31991a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f31992b;

    /* renamed from: c  reason: collision with root package name */
    public final g f31993c;

    /* renamed from: d  reason: collision with root package name */
    public final b f31994d;

    /* renamed from: e  reason: collision with root package name */
    public final d f31995e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final b f31996f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final b f31997g;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.f31991a = eVar;
        this.f31992b = mVar;
        this.f31993c = gVar;
        this.f31994d = bVar;
        this.f31995e = dVar;
        this.f31996f = bVar2;
        this.f31997g = bVar3;
    }

    @Override // com.ksad.lottie.model.content.b
    @Nullable
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return null;
    }

    public e a() {
        return this.f31991a;
    }

    public m<PointF, PointF> b() {
        return this.f31992b;
    }

    public g c() {
        return this.f31993c;
    }

    public b d() {
        return this.f31994d;
    }

    public d e() {
        return this.f31995e;
    }

    @Nullable
    public b f() {
        return this.f31996f;
    }

    @Nullable
    public b g() {
        return this.f31997g;
    }

    public o h() {
        return new o(this);
    }
}
