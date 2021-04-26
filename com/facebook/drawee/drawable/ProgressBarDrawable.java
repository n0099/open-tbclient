package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes6.dex */
public class ProgressBarDrawable extends Drawable implements CloneableDrawable {
    public final Paint mPaint = new Paint(1);
    public final Path mPath = new Path();
    public final RectF mRect = new RectF();
    public int mBackgroundColor = Integer.MIN_VALUE;
    public int mColor = -2147450625;
    public int mPadding = 10;
    public int mBarWidth = 20;
    public int mLevel = 0;
    public int mRadius = 0;
    public boolean mHideWhenZero = false;
    public boolean mIsVertical = false;

    private void drawBar(Canvas canvas, int i2) {
        this.mPaint.setColor(i2);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPath.reset();
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        this.mPath.addRoundRect(this.mRect, Math.min(this.mRadius, this.mBarWidth / 2), Math.min(this.mRadius, this.mBarWidth / 2), Path.Direction.CW);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void drawHorizontalBar(Canvas canvas, int i2, int i3) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int i4 = this.mPadding;
        int i5 = bounds.left + i4;
        int i6 = bounds.bottom - i4;
        int i7 = this.mBarWidth;
        int i8 = i6 - i7;
        this.mRect.set(i5, i8, i5 + (((width - (i4 * 2)) * i2) / 10000), i8 + i7);
        drawBar(canvas, i3);
    }

    private void drawVerticalBar(Canvas canvas, int i2, int i3) {
        Rect bounds = getBounds();
        int height = bounds.height();
        int i4 = this.mPadding;
        int i5 = bounds.left + i4;
        int i6 = bounds.top + i4;
        this.mRect.set(i5, i6, i5 + this.mBarWidth, i6 + (((height - (i4 * 2)) * i2) / 10000));
        drawBar(canvas, i3);
    }

    @Override // com.facebook.drawee.drawable.CloneableDrawable
    public Drawable cloneDrawable() {
        ProgressBarDrawable progressBarDrawable = new ProgressBarDrawable();
        progressBarDrawable.mBackgroundColor = this.mBackgroundColor;
        progressBarDrawable.mColor = this.mColor;
        progressBarDrawable.mPadding = this.mPadding;
        progressBarDrawable.mBarWidth = this.mBarWidth;
        progressBarDrawable.mLevel = this.mLevel;
        progressBarDrawable.mRadius = this.mRadius;
        progressBarDrawable.mHideWhenZero = this.mHideWhenZero;
        progressBarDrawable.mIsVertical = this.mIsVertical;
        return progressBarDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mHideWhenZero && this.mLevel == 0) {
            return;
        }
        if (this.mIsVertical) {
            drawVerticalBar(canvas, 10000, this.mBackgroundColor);
            drawVerticalBar(canvas, this.mLevel, this.mColor);
            return;
        }
        drawHorizontalBar(canvas, 10000, this.mBackgroundColor);
        drawHorizontalBar(canvas, this.mLevel, this.mColor);
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getBarWidth() {
        return this.mBarWidth;
    }

    public int getColor() {
        return this.mColor;
    }

    public boolean getHideWhenZero() {
        return this.mHideWhenZero;
    }

    public boolean getIsVertical() {
        return this.mIsVertical;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return DrawableUtils.getOpacityFromColor(this.mPaint.getColor());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int i2 = this.mPadding;
        rect.set(i2, i2, i2, i2);
        return this.mPadding != 0;
    }

    public int getRadius() {
        return this.mRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        this.mLevel = i2;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.mPaint.setAlpha(i2);
    }

    public void setBackgroundColor(int i2) {
        if (this.mBackgroundColor != i2) {
            this.mBackgroundColor = i2;
            invalidateSelf();
        }
    }

    public void setBarWidth(int i2) {
        if (this.mBarWidth != i2) {
            this.mBarWidth = i2;
            invalidateSelf();
        }
    }

    public void setColor(int i2) {
        if (this.mColor != i2) {
            this.mColor = i2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setHideWhenZero(boolean z) {
        this.mHideWhenZero = z;
    }

    public void setIsVertical(boolean z) {
        if (this.mIsVertical != z) {
            this.mIsVertical = z;
            invalidateSelf();
        }
    }

    public void setPadding(int i2) {
        if (this.mPadding != i2) {
            this.mPadding = i2;
            invalidateSelf();
        }
    }

    public void setRadius(int i2) {
        if (this.mRadius != i2) {
            this.mRadius = i2;
            invalidateSelf();
        }
    }
}
