package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
import com.ksad.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f8073a;

    /* renamed from: b  reason: collision with root package name */
    private final GradientType f8074b;
    private final com.ksad.lottie.model.a.c c;
    private final com.ksad.lottie.model.a.d d;
    private final com.ksad.lottie.model.a.f e;
    private final com.ksad.lottie.model.a.f f;
    private final com.ksad.lottie.model.a.b g;
    private final ShapeStroke.LineCapType h;
    private final ShapeStroke.LineJoinType i;
    private final float j;
    private final List<com.ksad.lottie.model.a.b> k;
    @Nullable
    private final com.ksad.lottie.model.a.b l;

    public e(String str, GradientType gradientType, com.ksad.lottie.model.a.c cVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.f fVar2, com.ksad.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.ksad.lottie.model.a.b> list, @Nullable com.ksad.lottie.model.a.b bVar2) {
        this.f8073a = str;
        this.f8074b = gradientType;
        this.c = cVar;
        this.d = dVar;
        this.e = fVar;
        this.f = fVar2;
        this.g = bVar;
        this.h = lineCapType;
        this.i = lineJoinType;
        this.j = f;
        this.k = list;
        this.l = bVar2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.h(fVar, aVar, this);
    }

    public String a() {
        return this.f8073a;
    }

    public GradientType b() {
        return this.f8074b;
    }

    public com.ksad.lottie.model.a.c c() {
        return this.c;
    }

    public com.ksad.lottie.model.a.d d() {
        return this.d;
    }

    public com.ksad.lottie.model.a.f e() {
        return this.e;
    }

    public com.ksad.lottie.model.a.f f() {
        return this.f;
    }

    public com.ksad.lottie.model.a.b g() {
        return this.g;
    }

    public ShapeStroke.LineCapType h() {
        return this.h;
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
