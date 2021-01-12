package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.ksad.lottie.model.content.ShapeStroke;
/* loaded from: classes4.dex */
public class q extends a {

    /* renamed from: b  reason: collision with root package name */
    private final com.ksad.lottie.model.layer.a f7954b;
    private final String c;
    private final com.ksad.lottie.a.b.a<Integer, Integer> d;
    @Nullable
    private com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> e;

    public q(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.g().toPaintCap(), shapeStroke.h().toPaintJoin(), shapeStroke.i(), shapeStroke.c(), shapeStroke.d(), shapeStroke.e(), shapeStroke.f());
        this.f7954b = aVar;
        this.c = shapeStroke.a();
        this.d = shapeStroke.b().a();
        this.d.a(this);
        aVar.a(this.d);
    }

    @Override // com.ksad.lottie.a.a.a, com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f7929a.setColor(this.d.e().intValue());
        if (this.e != null) {
            this.f7929a.setColorFilter(this.e.e());
        }
        super.a(canvas, matrix, i);
    }
}
