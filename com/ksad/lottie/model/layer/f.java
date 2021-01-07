package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class f extends a {
    private final RectF e;
    private final Paint f;
    private final float[] g;
    private final Path h;
    private final Layer i;
    @Nullable
    private com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(com.ksad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.e = new RectF();
        this.f = new Paint();
        this.g = new float[8];
        this.h = new Path();
        this.i = layer;
        this.f.setAlpha(0);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setColor(layer.p());
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.e.set(0.0f, 0.0f, this.i.r(), this.i.q());
        this.f8393a.mapRect(this.e);
        rectF.set(this.e);
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.i.p());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) (((this.d.a().e().intValue() * (alpha / 255.0f)) / 100.0f) * (i / 255.0f) * 255.0f);
        this.f.setAlpha(intValue);
        if (this.j != null) {
            this.f.setColorFilter(this.j.e());
        }
        if (intValue > 0) {
            this.g[0] = 0.0f;
            this.g[1] = 0.0f;
            this.g[2] = this.i.r();
            this.g[3] = 0.0f;
            this.g[4] = this.i.r();
            this.g[5] = this.i.q();
            this.g[6] = 0.0f;
            this.g[7] = this.i.q();
            matrix.mapPoints(this.g);
            this.h.reset();
            this.h.moveTo(this.g[0], this.g[1]);
            this.h.lineTo(this.g[2], this.g[3]);
            this.h.lineTo(this.g[4], this.g[5]);
            this.h.lineTo(this.g[6], this.g[7]);
            this.h.lineTo(this.g[0], this.g[1]);
            this.h.close();
            canvas.drawPath(this.h, this.f);
        }
    }
}
