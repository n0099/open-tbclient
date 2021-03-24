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
/* loaded from: classes6.dex */
public class c extends a {

    /* renamed from: e  reason: collision with root package name */
    public final Paint f31584e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f31585f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f31586g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> f31587h;

    public c(com.ksad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.f31584e = new Paint(3);
        this.f31585f = new Rect();
        this.f31586g = new Rect();
    }

    @Nullable
    private Bitmap e() {
        return this.f31568b.b(this.f31569c.g());
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        Bitmap e2 = e();
        if (e2 != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, e2.getWidth()), Math.min(rectF.bottom, e2.getHeight()));
            this.f31567a.mapRect(rectF);
        }
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap e2 = e();
        if (e2 == null || e2.isRecycled()) {
            return;
        }
        float a2 = com.ksad.lottie.d.f.a();
        this.f31584e.setAlpha(i);
        com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.f31587h;
        if (aVar != null) {
            this.f31584e.setColorFilter(aVar.e());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f31585f.set(0, 0, e2.getWidth(), e2.getHeight());
        this.f31586g.set(0, 0, (int) (e2.getWidth() * a2), (int) (e2.getHeight() * a2));
        canvas.drawBitmap(e2, this.f31585f, this.f31586g, this.f31584e);
        canvas.restore();
    }
}
