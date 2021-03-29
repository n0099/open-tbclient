package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class f extends a {

    /* renamed from: e  reason: collision with root package name */
    public final RectF f31590e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f31591f;

    /* renamed from: g  reason: collision with root package name */
    public final float[] f31592g;

    /* renamed from: h  reason: collision with root package name */
    public final Path f31593h;
    public final Layer i;
    @Nullable
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> j;

    public f(com.ksad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.f31590e = new RectF();
        this.f31591f = new Paint();
        this.f31592g = new float[8];
        this.f31593h = new Path();
        this.i = layer;
        this.f31591f.setAlpha(0);
        this.f31591f.setStyle(Paint.Style.FILL);
        this.f31591f.setColor(layer.p());
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.f31590e.set(0.0f, 0.0f, this.i.r(), this.i.q());
        this.f31568a.mapRect(this.f31590e);
        rectF.set(this.f31590e);
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.i.p());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i / 255.0f) * (((alpha / 255.0f) * this.f31571d.a().e().intValue()) / 100.0f) * 255.0f);
        this.f31591f.setAlpha(intValue);
        com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.j;
        if (aVar != null) {
            this.f31591f.setColorFilter(aVar.e());
        }
        if (intValue > 0) {
            float[] fArr = this.f31592g;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.i.r();
            float[] fArr2 = this.f31592g;
            fArr2[3] = 0.0f;
            fArr2[4] = this.i.r();
            this.f31592g[5] = this.i.q();
            float[] fArr3 = this.f31592g;
            fArr3[6] = 0.0f;
            fArr3[7] = this.i.q();
            matrix.mapPoints(this.f31592g);
            this.f31593h.reset();
            Path path = this.f31593h;
            float[] fArr4 = this.f31592g;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.f31593h;
            float[] fArr5 = this.f31592g;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.f31593h;
            float[] fArr6 = this.f31592g;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.f31593h;
            float[] fArr7 = this.f31592g;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.f31593h;
            float[] fArr8 = this.f31592g;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.f31593h.close();
            canvas.drawPath(this.f31593h, this.f31591f);
        }
    }
}
