package com.facebook.drawee.debug;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.debug.listener.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class DebugControllerOverlayDrawable extends Drawable implements ImageLoadingTimeListener {
    public static final float IMAGE_SIZE_THRESHOLD_NOT_OK = 0.5f;
    public static final float IMAGE_SIZE_THRESHOLD_OK = 0.1f;
    public static final int MAX_LINE_WIDTH_EM = 8;
    public static final int MAX_NUMBER_OF_LINES = 9;
    public static final int MAX_TEXT_SIZE_PX = 40;
    public static final int MIN_TEXT_SIZE_PX = 10;
    public static final String NO_CONTROLLER_ID = "none";
    public static final int OUTLINE_COLOR = -26624;
    public static final int OUTLINE_STROKE_WIDTH_PX = 2;
    @VisibleForTesting
    public static final int OVERLAY_COLOR_IMAGE_ALMOST_OK = 1728026624;
    @VisibleForTesting
    public static final int OVERLAY_COLOR_IMAGE_NOT_OK = 1727284022;
    @VisibleForTesting
    public static final int OVERLAY_COLOR_IMAGE_OK = 1716301648;
    public static final int TEXT_COLOR = -1;
    public static final int TEXT_LINE_SPACING_PX = 8;
    public static final int TEXT_PADDING_PX = 10;
    public String mControllerId;
    public int mCurrentTextXPx;
    public int mCurrentTextYPx;
    public long mFinalImageTimeMs;
    public int mFrameCount;
    public int mHeightPx;
    public String mImageFormat;
    public String mImageId;
    public int mImageSizeBytes;
    public int mLineIncrementPx;
    public int mLoopCount;
    public String mOrigin;
    public ScalingUtils.ScaleType mScaleType;
    public int mStartTextXPx;
    public int mStartTextYPx;
    public int mWidthPx;
    public int mTextGravity = 80;
    public final Paint mPaint = new Paint(1);
    public final Matrix mMatrix = new Matrix();
    public final Rect mRect = new Rect();
    public final RectF mRectF = new RectF();

    public DebugControllerOverlayDrawable() {
        reset();
    }

    private void addDebugText(Canvas canvas, String str, @Nullable Object... objArr) {
        if (objArr == null) {
            canvas.drawText(str, this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
        } else {
            canvas.drawText(String.format(str, objArr), this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
        }
        this.mCurrentTextYPx += this.mLineIncrementPx;
    }

    private void prepareDebugTextParameters(Rect rect, int i2, int i3) {
        int min = Math.min(40, Math.max(10, Math.min(rect.width() / i3, rect.height() / i2)));
        this.mPaint.setTextSize(min);
        int i4 = min + 8;
        this.mLineIncrementPx = i4;
        if (this.mTextGravity == 80) {
            this.mLineIncrementPx = i4 * (-1);
        }
        this.mStartTextXPx = rect.left + 10;
        this.mStartTextYPx = this.mTextGravity == 80 ? rect.bottom - 10 : rect.top + 10 + 10;
    }

    @VisibleForTesting
    public int determineOverlayColor(int i2, int i3, @Nullable ScalingUtils.ScaleType scaleType) {
        int width = getBounds().width();
        int height = getBounds().height();
        if (width > 0 && height > 0 && i2 > 0 && i3 > 0) {
            if (scaleType != null) {
                Rect rect = this.mRect;
                rect.top = 0;
                rect.left = 0;
                rect.right = width;
                rect.bottom = height;
                this.mMatrix.reset();
                scaleType.getTransform(this.mMatrix, this.mRect, i2, i3, 0.0f, 0.0f);
                RectF rectF = this.mRectF;
                rectF.top = 0.0f;
                rectF.left = 0.0f;
                rectF.right = i2;
                rectF.bottom = i3;
                this.mMatrix.mapRect(rectF);
                width = Math.min(width, (int) this.mRectF.width());
                height = Math.min(height, (int) this.mRectF.height());
            }
            float f2 = width;
            float f3 = f2 * 0.1f;
            float f4 = f2 * 0.5f;
            float f5 = height;
            float f6 = 0.1f * f5;
            float f7 = f5 * 0.5f;
            int abs = Math.abs(i2 - width);
            int abs2 = Math.abs(i3 - height);
            float f8 = abs;
            if (f8 < f3 && abs2 < f6) {
                return OVERLAY_COLOR_IMAGE_OK;
            }
            if (f8 < f4 && abs2 < f7) {
                return OVERLAY_COLOR_IMAGE_ALMOST_OK;
            }
        }
        return OVERLAY_COLOR_IMAGE_NOT_OK;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setColor(OUTLINE_COLOR);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(determineOverlayColor(this.mWidthPx, this.mHeightPx, this.mScaleType));
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setColor(-1);
        this.mCurrentTextXPx = this.mStartTextXPx;
        this.mCurrentTextYPx = this.mStartTextYPx;
        String str = this.mImageId;
        if (str != null) {
            addDebugText(canvas, "IDs: %s, %s", this.mControllerId, str);
        } else {
            addDebugText(canvas, "ID: %s", this.mControllerId);
        }
        addDebugText(canvas, "D: %dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height()));
        addDebugText(canvas, "I: %dx%d", Integer.valueOf(this.mWidthPx), Integer.valueOf(this.mHeightPx));
        addDebugText(canvas, "I: %d KiB", Integer.valueOf(this.mImageSizeBytes / 1024));
        String str2 = this.mImageFormat;
        if (str2 != null) {
            addDebugText(canvas, "i format: %s", str2);
        }
        int i2 = this.mFrameCount;
        if (i2 > 0) {
            addDebugText(canvas, "anim: f %d, l %d", Integer.valueOf(i2), Integer.valueOf(this.mLoopCount));
        }
        ScalingUtils.ScaleType scaleType = this.mScaleType;
        if (scaleType != null) {
            addDebugText(canvas, "scale: %s", scaleType);
        }
        long j = this.mFinalImageTimeMs;
        if (j >= 0) {
            addDebugText(canvas, "t: %d ms", Long.valueOf(j));
        }
        String str3 = this.mOrigin;
        if (str3 != null) {
            addDebugText(canvas, "origin: %s", str3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        prepareDebugTextParameters(rect, 9, 8);
    }

    @Override // com.facebook.drawee.debug.listener.ImageLoadingTimeListener
    public void onFinalImageSet(long j) {
        this.mFinalImageTimeMs = j;
        invalidateSelf();
    }

    public void reset() {
        this.mWidthPx = -1;
        this.mHeightPx = -1;
        this.mImageSizeBytes = -1;
        this.mFrameCount = -1;
        this.mLoopCount = -1;
        this.mImageFormat = null;
        setControllerId(null);
        this.mFinalImageTimeMs = -1L;
        this.mOrigin = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    public void setAnimationInfo(int i2, int i3) {
        this.mFrameCount = i2;
        this.mLoopCount = i3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setControllerId(@Nullable String str) {
        if (str == null) {
            str = "none";
        }
        this.mControllerId = str;
        invalidateSelf();
    }

    public void setDimensions(int i2, int i3) {
        this.mWidthPx = i2;
        this.mHeightPx = i3;
        invalidateSelf();
    }

    public void setFinalImageTimeMs(long j) {
        this.mFinalImageTimeMs = j;
    }

    public void setImageFormat(@Nullable String str) {
        this.mImageFormat = str;
    }

    public void setImageId(@Nullable String str) {
        this.mImageId = str;
        invalidateSelf();
    }

    public void setImageSize(int i2) {
        this.mImageSizeBytes = i2;
    }

    public void setOrigin(String str) {
        this.mOrigin = str;
        invalidateSelf();
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    public void setTextGravity(int i2) {
        this.mTextGravity = i2;
        invalidateSelf();
    }
}
