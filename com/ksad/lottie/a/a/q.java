package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.ksad.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class q extends a {

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f31567b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31568c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Integer, Integer> f31569d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> f31570e;

    public q(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.g().toPaintCap(), shapeStroke.h().toPaintJoin(), shapeStroke.i(), shapeStroke.c(), shapeStroke.d(), shapeStroke.e(), shapeStroke.f());
        this.f31567b = aVar;
        this.f31568c = shapeStroke.a();
        com.ksad.lottie.a.b.a<Integer, Integer> a2 = shapeStroke.b().a();
        this.f31569d = a2;
        a2.a(this);
        aVar.a(this.f31569d);
    }

    @Override // com.ksad.lottie.a.a.a, com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f31480a.setColor(this.f31569d.e().intValue());
        com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.f31570e;
        if (aVar != null) {
            this.f31480a.setColorFilter(aVar.e());
        }
        super.a(canvas, matrix, i);
    }
}
