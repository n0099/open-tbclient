package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
import com.ksad.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31810a;

    /* renamed from: b  reason: collision with root package name */
    public final GradientType f31811b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.c f31812c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31813d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31814e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31815f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31816g;

    /* renamed from: h  reason: collision with root package name */
    public final ShapeStroke.LineCapType f31817h;
    public final ShapeStroke.LineJoinType i;
    public final float j;
    public final List<com.ksad.lottie.model.a.b> k;
    @Nullable
    public final com.ksad.lottie.model.a.b l;

    public e(String str, GradientType gradientType, com.ksad.lottie.model.a.c cVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.f fVar2, com.ksad.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f2, List<com.ksad.lottie.model.a.b> list, @Nullable com.ksad.lottie.model.a.b bVar2) {
        this.f31810a = str;
        this.f31811b = gradientType;
        this.f31812c = cVar;
        this.f31813d = dVar;
        this.f31814e = fVar;
        this.f31815f = fVar2;
        this.f31816g = bVar;
        this.f31817h = lineCapType;
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
        return this.f31810a;
    }

    public GradientType b() {
        return this.f31811b;
    }

    public com.ksad.lottie.model.a.c c() {
        return this.f31812c;
    }

    public com.ksad.lottie.model.a.d d() {
        return this.f31813d;
    }

    public com.ksad.lottie.model.a.f e() {
        return this.f31814e;
    }

    public com.ksad.lottie.model.a.f f() {
        return this.f31815f;
    }

    public com.ksad.lottie.model.a.b g() {
        return this.f31816g;
    }

    public ShapeStroke.LineCapType h() {
        return this.f31817h;
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
