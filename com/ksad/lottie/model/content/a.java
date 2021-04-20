package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.model.a.m;
/* loaded from: classes6.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31796a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f31797b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31798c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f31799d;

    public a(String str, m<PointF, PointF> mVar, com.ksad.lottie.model.a.f fVar, boolean z) {
        this.f31796a = str;
        this.f31797b = mVar;
        this.f31798c = fVar;
        this.f31799d = z;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.e(fVar, aVar, this);
    }

    public String a() {
        return this.f31796a;
    }

    public m<PointF, PointF> b() {
        return this.f31797b;
    }

    public com.ksad.lottie.model.a.f c() {
        return this.f31798c;
    }

    public boolean d() {
        return this.f31799d;
    }
}
