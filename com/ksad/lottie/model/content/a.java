package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.model.a.m;
/* loaded from: classes6.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31891a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f31892b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31893c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f31894d;

    public a(String str, m<PointF, PointF> mVar, com.ksad.lottie.model.a.f fVar, boolean z) {
        this.f31891a = str;
        this.f31892b = mVar;
        this.f31893c = fVar;
        this.f31894d = z;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.e(fVar, aVar, this);
    }

    public String a() {
        return this.f31891a;
    }

    public m<PointF, PointF> b() {
        return this.f31892b;
    }

    public com.ksad.lottie.model.a.f c() {
        return this.f31893c;
    }

    public boolean d() {
        return this.f31894d;
    }
}
