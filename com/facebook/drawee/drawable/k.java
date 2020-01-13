package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class k extends m {
    private WeakReference<Bitmap> lLx;
    @Nullable
    private final Bitmap mBitmap;
    private final Paint mBorderPaint;
    private final Paint mPaint;

    public k(Resources resources, @Nullable Bitmap bitmap, @Nullable Paint paint) {
        super(new BitmapDrawable(resources, bitmap));
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.mBitmap = bitmap;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.facebook.drawee.drawable.m, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!dlj()) {
            super.draw(canvas);
            return;
        }
        dll();
        dlk();
        updatePaint();
        int save = canvas.save();
        canvas.concat(this.lLU);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.dr(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.caR, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    private void updatePaint() {
        if (this.lLx == null || this.lLx.get() != this.mBitmap) {
            this.lLx = new WeakReference<>(this.mBitmap);
            this.mPaint.setShader(new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.lLK = true;
        }
        if (this.lLK) {
            this.mPaint.getShader().setLocalMatrix(this.mTransform);
            this.lLK = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.drawee.drawable.m
    public boolean dlj() {
        return super.dlj() && this.mBitmap != null;
    }

    @Override // com.facebook.drawee.drawable.m, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        if (i != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i);
            super.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.m, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.mPaint.setColorFilter(colorFilter);
        a(colorFilter);
    }

    public void a(ColorFilter colorFilter) {
        this.mBorderPaint.setColorFilter(colorFilter);
    }
}
