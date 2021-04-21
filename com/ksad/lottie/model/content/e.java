package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
import com.ksad.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31905a;

    /* renamed from: b  reason: collision with root package name */
    public final GradientType f31906b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.c f31907c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31908d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31909e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31910f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31911g;

    /* renamed from: h  reason: collision with root package name */
    public final ShapeStroke.LineCapType f31912h;
    public final ShapeStroke.LineJoinType i;
    public final float j;
    public final List<com.ksad.lottie.model.a.b> k;
    @Nullable
    public final com.ksad.lottie.model.a.b l;

    public e(String str, GradientType gradientType, com.ksad.lottie.model.a.c cVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.f fVar2, com.ksad.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f2, List<com.ksad.lottie.model.a.b> list, @Nullable com.ksad.lottie.model.a.b bVar2) {
        this.f31905a = str;
        this.f31906b = gradientType;
        this.f31907c = cVar;
        this.f31908d = dVar;
        this.f31909e = fVar;
        this.f31910f = fVar2;
        this.f31911g = bVar;
        this.f31912h = lineCapType;
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
        return this.f31905a;
    }

    public GradientType b() {
        return this.f31906b;
    }

    public com.ksad.lottie.model.a.c c() {
        return this.f31907c;
    }

    public com.ksad.lottie.model.a.d d() {
        return this.f31908d;
    }

    public com.ksad.lottie.model.a.f e() {
        return this.f31909e;
    }

    public com.ksad.lottie.model.a.f f() {
        return this.f31910f;
    }

    public com.ksad.lottie.model.a.b g() {
        return this.f31911g;
    }

    public ShapeStroke.LineCapType h() {
        return this.f31912h;
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
