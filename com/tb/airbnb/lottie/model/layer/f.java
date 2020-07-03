package com.tb.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.p;
import com.tb.airbnb.lottie.j;
/* loaded from: classes6.dex */
public class f extends a {
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> nFv;
    private final Layer nHe;
    private final Paint paint;
    private final Path path;
    private final float[] points;
    private final RectF rect;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.rect = new RectF();
        this.paint = new Paint();
        this.points = new float[8];
        this.path = new Path();
        this.nHe = layer;
        this.paint.setAlpha(0);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(layer.getSolidColor());
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    public void b(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.nHe.getSolidColor());
        if (alpha != 0) {
            int intValue = (int) (((this.nFQ.dNx().getValue().intValue() * (alpha / 255.0f)) / 100.0f) * (i / 255.0f) * 255.0f);
            this.paint.setAlpha(intValue);
            if (this.nFv != null) {
                this.paint.setColorFilter(this.nFv.getValue());
            }
            if (intValue > 0) {
                this.points[0] = 0.0f;
                this.points[1] = 0.0f;
                this.points[2] = this.nHe.jg();
                this.points[3] = 0.0f;
                this.points[4] = this.nHe.jg();
                this.points[5] = this.nHe.jf();
                this.points[6] = 0.0f;
                this.points[7] = this.nHe.jf();
                matrix.mapPoints(this.points);
                this.path.reset();
                this.path.moveTo(this.points[0], this.points[1]);
                this.path.lineTo(this.points[2], this.points[3]);
                this.path.lineTo(this.points[4], this.points[5]);
                this.path.lineTo(this.points[6], this.points[7]);
                this.path.lineTo(this.points[0], this.points[1]);
                this.path.close();
                canvas.drawPath(this.path, this.paint);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, this.nHe.jg(), this.nHe.jf());
        this.EZ.mapRect(this.rect);
        rectF.set(this.rect);
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((f) t, (com.tb.airbnb.lottie.e.c<f>) cVar);
        if (t == j.Bv) {
            if (cVar == null) {
                this.nFv = null;
            } else {
                this.nFv = new p(cVar);
            }
        }
    }
}
