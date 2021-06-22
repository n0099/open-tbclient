package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
import com.ksad.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f32155a;

    /* renamed from: b  reason: collision with root package name */
    public final GradientType f32156b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.c f32157c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f32158d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f32159e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f32160f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32161g;

    /* renamed from: h  reason: collision with root package name */
    public final ShapeStroke.LineCapType f32162h;

    /* renamed from: i  reason: collision with root package name */
    public final ShapeStroke.LineJoinType f32163i;
    public final float j;
    public final List<com.ksad.lottie.model.a.b> k;
    @Nullable
    public final com.ksad.lottie.model.a.b l;

    public e(String str, GradientType gradientType, com.ksad.lottie.model.a.c cVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.f fVar2, com.ksad.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f2, List<com.ksad.lottie.model.a.b> list, @Nullable com.ksad.lottie.model.a.b bVar2) {
        this.f32155a = str;
        this.f32156b = gradientType;
        this.f32157c = cVar;
        this.f32158d = dVar;
        this.f32159e = fVar;
        this.f32160f = fVar2;
        this.f32161g = bVar;
        this.f32162h = lineCapType;
        this.f32163i = lineJoinType;
        this.j = f2;
        this.k = list;
        this.l = bVar2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.h(fVar, aVar, this);
    }

    public String a() {
        return this.f32155a;
    }

    public GradientType b() {
        return this.f32156b;
    }

    public com.ksad.lottie.model.a.c c() {
        return this.f32157c;
    }

    public com.ksad.lottie.model.a.d d() {
        return this.f32158d;
    }

    public com.ksad.lottie.model.a.f e() {
        return this.f32159e;
    }

    public com.ksad.lottie.model.a.f f() {
        return this.f32160f;
    }

    public com.ksad.lottie.model.a.b g() {
        return this.f32161g;
    }

    public ShapeStroke.LineCapType h() {
        return this.f32162h;
    }

    public ShapeStroke.LineJoinType i() {
        return this.f32163i;
    }

    public List<com.ksad.lottie.model.a.b> j() {
        return this.k;
    }

    @Nullable
    public com.ksad.lottie.model.a.b k() {
        return this.l;
    }

    public float l() {
        return this.j;
    }
}
