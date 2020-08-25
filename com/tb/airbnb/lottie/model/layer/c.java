package com.tb.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.p;
import com.tb.airbnb.lottie.j;
/* loaded from: classes7.dex */
public class c extends a {
    private final Rect dst;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> oic;
    private final Paint paint;
    private final Rect src;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.paint = new Paint(3);
        this.src = new Rect();
        this.dst = new Rect();
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    public void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmap = getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            float kZ = com.tb.airbnb.lottie.d.f.kZ();
            this.paint.setAlpha(i);
            if (this.oic != null) {
                this.paint.setColorFilter(this.oic.getValue());
            }
            canvas.save();
            canvas.concat(matrix);
            this.src.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.dst.set(0, 0, (int) (bitmap.getWidth() * kZ), (int) (kZ * bitmap.getHeight()));
            canvas.drawBitmap(bitmap, this.src, this.dst, this.paint);
            canvas.restore();
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, bitmap.getWidth()), Math.min(rectF.bottom, bitmap.getHeight()));
            this.FD.mapRect(rectF);
        }
    }

    @Nullable
    private Bitmap getBitmap() {
        return this.lottieDrawable.bf(this.ojL.getRefId());
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((c) t, (com.tb.airbnb.lottie.e.c<c>) cVar);
        if (t == j.Cb) {
            if (cVar == null) {
                this.oic = null;
            } else {
                this.oic = new p(cVar);
            }
        }
    }
}
