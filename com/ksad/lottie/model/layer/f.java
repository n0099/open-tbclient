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
    public final RectF f32129e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f32130f;

    /* renamed from: g  reason: collision with root package name */
    public final float[] f32131g;

    /* renamed from: h  reason: collision with root package name */
    public final Path f32132h;

    /* renamed from: i  reason: collision with root package name */
    public final Layer f32133i;
    @Nullable
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> j;

    public f(com.ksad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.f32129e = new RectF();
        this.f32130f = new Paint();
        this.f32131g = new float[8];
        this.f32132h = new Path();
        this.f32133i = layer;
        this.f32130f.setAlpha(0);
        this.f32130f.setStyle(Paint.Style.FILL);
        this.f32130f.setColor(layer.p());
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.f32129e.set(0.0f, 0.0f, this.f32133i.r(), this.f32133i.q());
        this.f32106a.mapRect(this.f32129e);
        rectF.set(this.f32129e);
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(Canvas canvas, Matrix matrix, int i2) {
        int alpha = Color.alpha(this.f32133i.p());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i2 / 255.0f) * (((alpha / 255.0f) * this.f32109d.a().e().intValue()) / 100.0f) * 255.0f);
        this.f32130f.setAlpha(intValue);
        com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.j;
        if (aVar != null) {
            this.f32130f.setColorFilter(aVar.e());
        }
        if (intValue > 0) {
            float[] fArr = this.f32131g;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.f32133i.r();
            float[] fArr2 = this.f32131g;
            fArr2[3] = 0.0f;
            fArr2[4] = this.f32133i.r();
            this.f32131g[5] = this.f32133i.q();
            float[] fArr3 = this.f32131g;
            fArr3[6] = 0.0f;
            fArr3[7] = this.f32133i.q();
            matrix.mapPoints(this.f32131g);
            this.f32132h.reset();
            Path path = this.f32132h;
            float[] fArr4 = this.f32131g;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.f32132h;
            float[] fArr5 = this.f32131g;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.f32132h;
            float[] fArr6 = this.f32131g;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.f32132h;
            float[] fArr7 = this.f32131g;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.f32132h;
            float[] fArr8 = this.f32131g;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.f32132h.close();
            canvas.drawPath(this.f32132h, this.f32130f);
        }
    }
}
