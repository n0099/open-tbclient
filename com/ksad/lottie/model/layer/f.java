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
    public final RectF f32227e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f32228f;

    /* renamed from: g  reason: collision with root package name */
    public final float[] f32229g;

    /* renamed from: h  reason: collision with root package name */
    public final Path f32230h;

    /* renamed from: i  reason: collision with root package name */
    public final Layer f32231i;
    @Nullable
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> j;

    public f(com.ksad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.f32227e = new RectF();
        this.f32228f = new Paint();
        this.f32229g = new float[8];
        this.f32230h = new Path();
        this.f32231i = layer;
        this.f32228f.setAlpha(0);
        this.f32228f.setStyle(Paint.Style.FILL);
        this.f32228f.setColor(layer.p());
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.f32227e.set(0.0f, 0.0f, this.f32231i.r(), this.f32231i.q());
        this.f32204a.mapRect(this.f32227e);
        rectF.set(this.f32227e);
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(Canvas canvas, Matrix matrix, int i2) {
        int alpha = Color.alpha(this.f32231i.p());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i2 / 255.0f) * (((alpha / 255.0f) * this.f32207d.a().e().intValue()) / 100.0f) * 255.0f);
        this.f32228f.setAlpha(intValue);
        com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.j;
        if (aVar != null) {
            this.f32228f.setColorFilter(aVar.e());
        }
        if (intValue > 0) {
            float[] fArr = this.f32229g;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.f32231i.r();
            float[] fArr2 = this.f32229g;
            fArr2[3] = 0.0f;
            fArr2[4] = this.f32231i.r();
            this.f32229g[5] = this.f32231i.q();
            float[] fArr3 = this.f32229g;
            fArr3[6] = 0.0f;
            fArr3[7] = this.f32231i.q();
            matrix.mapPoints(this.f32229g);
            this.f32230h.reset();
            Path path = this.f32230h;
            float[] fArr4 = this.f32229g;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.f32230h;
            float[] fArr5 = this.f32229g;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.f32230h;
            float[] fArr6 = this.f32229g;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.f32230h;
            float[] fArr7 = this.f32229g;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.f32230h;
            float[] fArr8 = this.f32229g;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.f32230h.close();
            canvas.drawPath(this.f32230h, this.f32228f);
        }
    }
}
