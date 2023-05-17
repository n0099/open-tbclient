package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ScalingUtils;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class ScaleTypeDrawable extends ForwardingDrawable {
    @VisibleForTesting
    public Matrix mDrawMatrix;
    @VisibleForTesting
    @Nullable
    public PointF mFocusPoint;
    @VisibleForTesting
    public ScalingUtils.ScaleType mScaleType;
    @VisibleForTesting
    public Object mScaleTypeState;
    public Matrix mTempMatrix;
    @VisibleForTesting
    public int mUnderlyingHeight;
    @VisibleForTesting
    public int mUnderlyingWidth;

    public ScaleTypeDrawable(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        this.mFocusPoint = null;
        this.mUnderlyingWidth = 0;
        this.mUnderlyingHeight = 0;
        this.mTempMatrix = new Matrix();
        this.mScaleType = scaleType;
    }

    public ScaleTypeDrawable(Drawable drawable, ScalingUtils.ScaleType scaleType, @Nullable PointF pointF) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        this.mFocusPoint = null;
        this.mUnderlyingWidth = 0;
        this.mUnderlyingHeight = 0;
        this.mTempMatrix = new Matrix();
        this.mScaleType = scaleType;
        this.mFocusPoint = pointF;
    }

    private void configureBoundsIfUnderlyingChanged() {
        boolean z;
        ScalingUtils.ScaleType scaleType = this.mScaleType;
        boolean z2 = true;
        if (scaleType instanceof ScalingUtils.StatefulScaleType) {
            Object state = ((ScalingUtils.StatefulScaleType) scaleType).getState();
            if (state != null && state.equals(this.mScaleTypeState)) {
                z = false;
            } else {
                z = true;
            }
            this.mScaleTypeState = state;
        } else {
            z = false;
        }
        if (this.mUnderlyingWidth == getCurrent().getIntrinsicWidth() && this.mUnderlyingHeight == getCurrent().getIntrinsicHeight()) {
            z2 = false;
        }
        if (z2 || z) {
            configureBounds();
        }
    }

    @VisibleForTesting
    public void configureBounds() {
        float f;
        float f2;
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.mUnderlyingWidth = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.mUnderlyingHeight = intrinsicHeight;
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            if (intrinsicWidth == width && intrinsicHeight == height) {
                current.setBounds(bounds);
                this.mDrawMatrix = null;
                return;
            } else if (this.mScaleType == ScalingUtils.ScaleType.FIT_XY) {
                current.setBounds(bounds);
                this.mDrawMatrix = null;
                return;
            } else {
                current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                ScalingUtils.ScaleType scaleType = this.mScaleType;
                Matrix matrix = this.mTempMatrix;
                PointF pointF = this.mFocusPoint;
                if (pointF != null) {
                    f = pointF.x;
                } else {
                    f = 0.5f;
                }
                PointF pointF2 = this.mFocusPoint;
                if (pointF2 != null) {
                    f2 = pointF2.y;
                } else {
                    f2 = 0.5f;
                }
                scaleType.getTransform(matrix, bounds, intrinsicWidth, intrinsicHeight, f, f2);
                this.mDrawMatrix = this.mTempMatrix;
                return;
            }
        }
        current.setBounds(bounds);
        this.mDrawMatrix = null;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        configureBoundsIfUnderlyingChanged();
        if (this.mDrawMatrix != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.mDrawMatrix);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        configureBoundsIfUnderlyingChanged();
        Matrix matrix2 = this.mDrawMatrix;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        configureBounds();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public void setFocusPoint(@Nullable PointF pointF) {
        if (Objects.equal(this.mFocusPoint, pointF)) {
            return;
        }
        if (pointF == null) {
            this.mFocusPoint = null;
        } else {
            if (this.mFocusPoint == null) {
                this.mFocusPoint = new PointF();
            }
            this.mFocusPoint.set(pointF);
        }
        configureBounds();
        invalidateSelf();
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        if (Objects.equal(this.mScaleType, scaleType)) {
            return;
        }
        this.mScaleType = scaleType;
        this.mScaleTypeState = null;
        configureBounds();
        invalidateSelf();
    }

    @Nullable
    public PointF getFocusPoint() {
        return this.mFocusPoint;
    }

    public ScalingUtils.ScaleType getScaleType() {
        return this.mScaleType;
    }
}
