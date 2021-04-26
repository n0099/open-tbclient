package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class ScalingUtils {

    /* loaded from: classes6.dex */
    public static abstract class AbstractScaleType implements ScaleType {
        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3) {
            getTransformImpl(matrix, rect, i2, i3, f2, f3, rect.width() / i2, rect.height() / i3);
            return matrix;
        }

        public abstract void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5);
    }

    /* loaded from: classes6.dex */
    public interface ScaleType {
        public static final ScaleType FIT_XY = ScaleTypeFitXY.INSTANCE;
        public static final ScaleType FIT_START = ScaleTypeFitStart.INSTANCE;
        public static final ScaleType FIT_CENTER = ScaleTypeFitCenter.INSTANCE;
        public static final ScaleType FIT_END = ScaleTypeFitEnd.INSTANCE;
        public static final ScaleType CENTER = ScaleTypeCenter.INSTANCE;
        public static final ScaleType CENTER_INSIDE = ScaleTypeCenterInside.INSTANCE;
        public static final ScaleType CENTER_CROP = ScaleTypeCenterCrop.INSTANCE;
        public static final ScaleType FOCUS_CROP = ScaleTypeFocusCrop.INSTANCE;
        public static final ScaleType FIT_BOTTOM_START = ScaleTypeFitBottomStart.INSTANCE;

        Matrix getTransform(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3);
    }

    /* loaded from: classes6.dex */
    public static class ScaleTypeCenter extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeCenter();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            matrix.setTranslate((int) (rect.left + ((rect.width() - i2) * 0.5f) + 0.5f), (int) (rect.top + ((rect.height() - i3) * 0.5f) + 0.5f));
        }

        public String toString() {
            return "center";
        }
    }

    /* loaded from: classes6.dex */
    public static class ScaleTypeCenterCrop extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeCenterCrop();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float height;
            float f6;
            if (f5 > f4) {
                f6 = rect.left + ((rect.width() - (i2 * f5)) * 0.5f);
                height = rect.top;
                f4 = f5;
            } else {
                height = ((rect.height() - (i3 * f4)) * 0.5f) + rect.top;
                f6 = rect.left;
            }
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (f6 + 0.5f), (int) (height + 0.5f));
        }

        public String toString() {
            return "center_crop";
        }
    }

    /* loaded from: classes6.dex */
    public static class ScaleTypeCenterInside extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeCenterInside();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(Math.min(f4, f5), 1.0f);
            float width = rect.left + ((rect.width() - (i2 * min)) * 0.5f);
            float height = rect.top + ((rect.height() - (i3 * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (width + 0.5f), (int) (height + 0.5f));
        }

        public String toString() {
            return "center_inside";
        }
    }

    /* loaded from: classes6.dex */
    public static class ScaleTypeFitBottomStart extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitBottomStart();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + (rect.height() - (i3 * min)) + 0.5f));
        }

        public String toString() {
            return "fit_bottom_start";
        }
    }

    /* loaded from: classes6.dex */
    public static class ScaleTypeFitCenter extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitCenter();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            float width = rect.left + ((rect.width() - (i2 * min)) * 0.5f);
            float height = rect.top + ((rect.height() - (i3 * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (width + 0.5f), (int) (height + 0.5f));
        }

        public String toString() {
            return "fit_center";
        }
    }

    /* loaded from: classes6.dex */
    public static class ScaleTypeFitEnd extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitEnd();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (rect.left + (rect.width() - (i2 * min)) + 0.5f), (int) (rect.top + (rect.height() - (i3 * min)) + 0.5f));
        }

        public String toString() {
            return "fit_end";
        }
    }

    /* loaded from: classes6.dex */
    public static class ScaleTypeFitStart extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitStart();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
        }

        public String toString() {
            return "fit_start";
        }
    }

    /* loaded from: classes6.dex */
    public static class ScaleTypeFitXY extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitXY();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            matrix.setScale(f4, f5);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
        }

        public String toString() {
            return "fit_xy";
        }
    }

    /* loaded from: classes6.dex */
    public static class ScaleTypeFocusCrop extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFocusCrop();

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float f6;
            float max;
            if (f5 > f4) {
                float f7 = i2 * f5;
                f6 = rect.left + Math.max(Math.min((rect.width() * 0.5f) - (f2 * f7), 0.0f), rect.width() - f7);
                max = rect.top;
                f4 = f5;
            } else {
                f6 = rect.left;
                float f8 = i3 * f4;
                max = Math.max(Math.min((rect.height() * 0.5f) - (f3 * f8), 0.0f), rect.height() - f8) + rect.top;
            }
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (f6 + 0.5f), (int) (max + 0.5f));
        }

        public String toString() {
            return "focus_crop";
        }
    }

    /* loaded from: classes6.dex */
    public interface StatefulScaleType {
        Object getState();
    }

    @Nullable
    public static ScaleTypeDrawable getActiveScaleTypeDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawable;
        }
        if (drawable instanceof DrawableParent) {
            return getActiveScaleTypeDrawable(((DrawableParent) drawable).getDrawable());
        }
        if (drawable instanceof ArrayDrawable) {
            ArrayDrawable arrayDrawable = (ArrayDrawable) drawable;
            int numberOfLayers = arrayDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                ScaleTypeDrawable activeScaleTypeDrawable = getActiveScaleTypeDrawable(arrayDrawable.getDrawable(i2));
                if (activeScaleTypeDrawable != null) {
                    return activeScaleTypeDrawable;
                }
            }
        }
        return null;
    }

    /* loaded from: classes6.dex */
    public static class InterpolatingScaleType implements ScaleType, StatefulScaleType {
        @Nullable
        public final Rect mBoundsFrom;
        @Nullable
        public final Rect mBoundsTo;
        @Nullable
        public final PointF mFocusPointFrom;
        @Nullable
        public final PointF mFocusPointTo;
        public float mInterpolatingValue;
        public final float[] mMatrixValuesFrom;
        public final float[] mMatrixValuesInterpolated;
        public final float[] mMatrixValuesTo;
        public final ScaleType mScaleTypeFrom;
        public final ScaleType mScaleTypeTo;

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2, @Nullable Rect rect, @Nullable Rect rect2, @Nullable PointF pointF, @Nullable PointF pointF2) {
            this.mMatrixValuesFrom = new float[9];
            this.mMatrixValuesTo = new float[9];
            this.mMatrixValuesInterpolated = new float[9];
            this.mScaleTypeFrom = scaleType;
            this.mScaleTypeTo = scaleType2;
            this.mBoundsFrom = rect;
            this.mBoundsTo = rect2;
            this.mFocusPointFrom = pointF;
            this.mFocusPointTo = pointF2;
        }

        @Nullable
        public Rect getBoundsFrom() {
            return this.mBoundsFrom;
        }

        @Nullable
        public Rect getBoundsTo() {
            return this.mBoundsTo;
        }

        @Nullable
        public PointF getFocusPointFrom() {
            return this.mFocusPointFrom;
        }

        @Nullable
        public PointF getFocusPointTo() {
            return this.mFocusPointTo;
        }

        public ScaleType getScaleTypeFrom() {
            return this.mScaleTypeFrom;
        }

        public ScaleType getScaleTypeTo() {
            return this.mScaleTypeTo;
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.StatefulScaleType
        public Object getState() {
            return Float.valueOf(this.mInterpolatingValue);
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3) {
            Rect rect2 = this.mBoundsFrom;
            Rect rect3 = rect2 != null ? rect2 : rect;
            Rect rect4 = this.mBoundsTo;
            Rect rect5 = rect4 != null ? rect4 : rect;
            ScaleType scaleType = this.mScaleTypeFrom;
            PointF pointF = this.mFocusPointFrom;
            float f4 = pointF == null ? f2 : pointF.x;
            PointF pointF2 = this.mFocusPointFrom;
            scaleType.getTransform(matrix, rect3, i2, i3, f4, pointF2 == null ? f3 : pointF2.y);
            matrix.getValues(this.mMatrixValuesFrom);
            ScaleType scaleType2 = this.mScaleTypeTo;
            PointF pointF3 = this.mFocusPointTo;
            float f5 = pointF3 == null ? f2 : pointF3.x;
            PointF pointF4 = this.mFocusPointTo;
            scaleType2.getTransform(matrix, rect5, i2, i3, f5, pointF4 == null ? f3 : pointF4.y);
            matrix.getValues(this.mMatrixValuesTo);
            for (int i4 = 0; i4 < 9; i4++) {
                float[] fArr = this.mMatrixValuesInterpolated;
                float f6 = this.mMatrixValuesFrom[i4];
                float f7 = this.mInterpolatingValue;
                fArr[i4] = (f6 * (1.0f - f7)) + (this.mMatrixValuesTo[i4] * f7);
            }
            matrix.setValues(this.mMatrixValuesInterpolated);
            return matrix;
        }

        public float getValue() {
            return this.mInterpolatingValue;
        }

        public void setValue(float f2) {
            this.mInterpolatingValue = f2;
        }

        public String toString() {
            return String.format("InterpolatingScaleType(%s (%s) -> %s (%s))", String.valueOf(this.mScaleTypeFrom), String.valueOf(this.mFocusPointFrom), String.valueOf(this.mScaleTypeTo), String.valueOf(this.mFocusPointTo));
        }

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2, @Nullable Rect rect, @Nullable Rect rect2) {
            this(scaleType, scaleType2, rect, rect2, null, null);
        }

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2) {
            this(scaleType, scaleType2, null, null);
        }
    }
}
