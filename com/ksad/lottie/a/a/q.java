package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.ksad.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class q extends a {

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f31277b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31278c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Integer, Integer> f31279d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> f31280e;

    public q(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.g().toPaintCap(), shapeStroke.h().toPaintJoin(), shapeStroke.i(), shapeStroke.c(), shapeStroke.d(), shapeStroke.e(), shapeStroke.f());
        this.f31277b = aVar;
        this.f31278c = shapeStroke.a();
        com.ksad.lottie.a.b.a<Integer, Integer> a2 = shapeStroke.b().a();
        this.f31279d = a2;
        a2.a(this);
        aVar.a(this.f31279d);
    }

    @Override // com.ksad.lottie.a.a.a, com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f31190a.setColor(this.f31279d.e().intValue());
        com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.f31280e;
        if (aVar != null) {
            this.f31190a.setColorFilter(aVar.e());
        }
        super.a(canvas, matrix, i);
    }
}
