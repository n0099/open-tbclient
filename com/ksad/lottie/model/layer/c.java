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
    public final Paint f32222e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f32223f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f32224g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> f32225h;

    public c(com.ksad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.f32222e = new Paint(3);
        this.f32223f = new Rect();
        this.f32224g = new Rect();
    }

    @Nullable
    private Bitmap e() {
        return this.f32205b.b(this.f32206c.g());
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        Bitmap e2 = e();
        if (e2 != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, e2.getWidth()), Math.min(rectF.bottom, e2.getHeight()));
            this.f32204a.mapRect(rectF);
        }
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(@NonNull Canvas canvas, Matrix matrix, int i2) {
        Bitmap e2 = e();
        if (e2 == null || e2.isRecycled()) {
            return;
        }
        float a2 = com.ksad.lottie.d.f.a();
        this.f32222e.setAlpha(i2);
        com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.f32225h;
        if (aVar != null) {
            this.f32222e.setColorFilter(aVar.e());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f32223f.set(0, 0, e2.getWidth(), e2.getHeight());
        this.f32224g.set(0, 0, (int) (e2.getWidth() * a2), (int) (e2.getHeight() * a2));
        canvas.drawBitmap(e2, this.f32223f, this.f32224g, this.f32222e);
        canvas.restore();
    }
}
