package com.tb.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class f extends a {
    private final Layer ktT;
    private final Paint paint;
    private final RectF rect;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.rect = new RectF();
        this.paint = new Paint();
        this.ktT = layer;
        this.paint.setAlpha(0);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(layer.getSolidColor());
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    public void b(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.ktT.getSolidColor());
        if (alpha != 0) {
            int intValue = (int) (((this.ksA.cLi().getValue().intValue() * (alpha / 255.0f)) / 100.0f) * (i / 255.0f) * 255.0f);
            this.paint.setAlpha(intValue);
            if (intValue > 0) {
                b(matrix);
                canvas.drawRect(this.rect, this.paint);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        b(this.hl);
        rectF.set(this.rect);
    }

    private void b(Matrix matrix) {
        this.rect.set(0.0f, 0.0f, this.ktT.dm(), this.ktT.dl());
        matrix.mapRect(this.rect);
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
