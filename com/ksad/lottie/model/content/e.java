package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
import com.ksad.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31520a;

    /* renamed from: b  reason: collision with root package name */
    public final GradientType f31521b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.c f31522c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31523d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31524e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31525f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31526g;

    /* renamed from: h  reason: collision with root package name */
    public final ShapeStroke.LineCapType f31527h;
    public final ShapeStroke.LineJoinType i;
    public final float j;
    public final List<com.ksad.lottie.model.a.b> k;
    @Nullable
    public final com.ksad.lottie.model.a.b l;

    public e(String str, GradientType gradientType, com.ksad.lottie.model.a.c cVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.f fVar2, com.ksad.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f2, List<com.ksad.lottie.model.a.b> list, @Nullable com.ksad.lottie.model.a.b bVar2) {
        this.f31520a = str;
        this.f31521b = gradientType;
        this.f31522c = cVar;
        this.f31523d = dVar;
        this.f31524e = fVar;
        this.f31525f = fVar2;
        this.f31526g = bVar;
        this.f31527h = lineCapType;
        this.i = lineJoinType;
        this.j = f2;
        this.k = list;
        this.l = bVar2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.h(fVar, aVar, this);
    }

    public String a() {
        return this.f31520a;
    }

    public GradientType b() {
        return this.f31521b;
    }

    public com.ksad.lottie.model.a.c c() {
        return this.f31522c;
    }

    public com.ksad.lottie.model.a.d d() {
        return this.f31523d;
    }

    public com.ksad.lottie.model.a.f e() {
        return this.f31524e;
    }

    public com.ksad.lottie.model.a.f f() {
        return this.f31525f;
    }

    public com.ksad.lottie.model.a.b g() {
        return this.f31526g;
    }

    public ShapeStroke.LineCapType h() {
        return this.f31527h;
    }

    public ShapeStroke.LineJoinType i() {
        return this.i;
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
