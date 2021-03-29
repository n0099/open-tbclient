package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.model.a.m;
/* loaded from: classes6.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31507a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f31508b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31509c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f31510d;

    public a(String str, m<PointF, PointF> mVar, com.ksad.lottie.model.a.f fVar, boolean z) {
        this.f31507a = str;
        this.f31508b = mVar;
        this.f31509c = fVar;
        this.f31510d = z;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.e(fVar, aVar, this);
    }

    public String a() {
        return this.f31507a;
    }

    public m<PointF, PointF> b() {
        return this.f31508b;
    }

    public com.ksad.lottie.model.a.f c() {
        return this.f31509c;
    }

    public boolean d() {
        return this.f31510d;
    }
}
