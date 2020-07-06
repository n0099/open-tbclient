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
/* loaded from: classes13.dex */
public class k extends m {
    @Nullable
    private final Bitmap mBitmap;
    private final Paint mBorderPaint;
    private WeakReference<Bitmap> mMG;
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
        if (!dBd()) {
            super.draw(canvas);
            return;
        }
        dBf();
        dBe();
        updatePaint();
        int save = canvas.save();
        canvas.concat(this.mNe);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.dt(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.mMK, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    private void updatePaint() {
        if (this.mMG == null || this.mMG.get() != this.mBitmap) {
            this.mMG = new WeakReference<>(this.mBitmap);
            this.mPaint.setShader(new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.mMU = true;
        }
        if (this.mMU) {
            this.mPaint.getShader().setLocalMatrix(this.mTransform);
            this.mMU = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.drawee.drawable.m
    public boolean dBd() {
        return super.dBd() && this.mBitmap != null;
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
