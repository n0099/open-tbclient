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
/* loaded from: classes9.dex */
public class k extends m {
    @Nullable
    private final Bitmap mBitmap;
    private final Paint mBorderPaint;
    private final Paint mPaint;
    private WeakReference<Bitmap> mUP;

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
        if (!dEp()) {
            super.draw(canvas);
            return;
        }
        dEr();
        dEq();
        updatePaint();
        int save = canvas.save();
        canvas.concat(this.mVn);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(e.dv(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.mUT, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    private void updatePaint() {
        if (this.mUP == null || this.mUP.get() != this.mBitmap) {
            this.mUP = new WeakReference<>(this.mBitmap);
            this.mPaint.setShader(new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.mVd = true;
        }
        if (this.mVd) {
            this.mPaint.getShader().setLocalMatrix(this.mTransform);
            this.mVd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.drawee.drawable.m
    public boolean dEp() {
        return super.dEp() && this.mBitmap != null;
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
