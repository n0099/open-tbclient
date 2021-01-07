package com.ksad.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class c extends a {
    private final Paint e;
    private final Rect f;
    private final Rect g;
    @Nullable
    private com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.ksad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.e = new Paint(3);
        this.f = new Rect();
        this.g = new Rect();
    }

    @Nullable
    private Bitmap e() {
        return this.f8394b.b(this.c.g());
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        Bitmap e = e();
        if (e != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, e.getWidth()), Math.min(rectF.bottom, e.getHeight()));
            this.f8393a.mapRect(rectF);
        }
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap e = e();
        if (e == null || e.isRecycled()) {
            return;
        }
        float a2 = com.ksad.lottie.d.f.a();
        this.e.setAlpha(i);
        if (this.h != null) {
            this.e.setColorFilter(this.h.e());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f.set(0, 0, e.getWidth(), e.getHeight());
        this.g.set(0, 0, (int) (e.getWidth() * a2), (int) (a2 * e.getHeight()));
        canvas.drawBitmap(e, this.f, this.g, this.e);
        canvas.restore();
    }
}
