package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.model.a.m;
/* loaded from: classes6.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f32042a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f32043b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f32044c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f32045d;

    public a(String str, m<PointF, PointF> mVar, com.ksad.lottie.model.a.f fVar, boolean z) {
        this.f32042a = str;
        this.f32043b = mVar;
        this.f32044c = fVar;
        this.f32045d = z;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.e(fVar, aVar, this);
    }

    public String a() {
        return this.f32042a;
    }

    public m<PointF, PointF> b() {
        return this.f32043b;
    }

    public com.ksad.lottie.model.a.f c() {
        return this.f32044c;
    }

    public boolean d() {
        return this.f32045d;
    }
}
