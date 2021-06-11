package org.webrtc;

import android.graphics.Matrix;
import android.graphics.Point;
import android.view.View;
/* loaded from: classes8.dex */
public class RendererCommon {
    public static float BALANCED_VISIBLE_FRACTION = 0.5625f;

    /* renamed from: org.webrtc.RendererCommon$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$webrtc$RendererCommon$ScalingType;

        static {
            int[] iArr = new int[ScalingType.values().length];
            $SwitchMap$org$webrtc$RendererCommon$ScalingType = iArr;
            try {
                iArr[ScalingType.SCALE_ASPECT_FIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$webrtc$RendererCommon$ScalingType[ScalingType.SCALE_ASPECT_FILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$webrtc$RendererCommon$ScalingType[ScalingType.SCALE_ASPECT_BALANCED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface GlDrawer {
        void drawOes(int i2, float[] fArr, int i3, int i4, int i5, int i6, int i7, int i8);

        void drawRgb(int i2, float[] fArr, int i3, int i4, int i5, int i6, int i7, int i8);

        void drawYuv(int[] iArr, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7);

        void release();
    }

    /* loaded from: classes8.dex */
    public interface RendererEvents {
        void onFirstFrameRendered();

        void onFrameResolutionChanged(int i2, int i3, int i4);
    }

    /* loaded from: classes8.dex */
    public enum ScalingType {
        SCALE_ASPECT_FIT,
        SCALE_ASPECT_FILL,
        SCALE_ASPECT_BALANCED
    }

    /* loaded from: classes8.dex */
    public static class VideoLayoutMeasure {
        public ScalingType scalingTypeMatchOrientation;
        public ScalingType scalingTypeMismatchOrientation;

        public VideoLayoutMeasure() {
            ScalingType scalingType = ScalingType.SCALE_ASPECT_BALANCED;
            this.scalingTypeMatchOrientation = scalingType;
            this.scalingTypeMismatchOrientation = scalingType;
        }

        public Point measure(int i2, int i3, int i4, int i5) {
            int defaultSize = View.getDefaultSize(Integer.MAX_VALUE, i2);
            int defaultSize2 = View.getDefaultSize(Integer.MAX_VALUE, i3);
            if (i4 == 0 || i5 == 0 || defaultSize == 0 || defaultSize2 == 0) {
                return new Point(defaultSize, defaultSize2);
            }
            float f2 = i4 / i5;
            Point displaySize = RendererCommon.getDisplaySize(((f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1)) > 0) == (((float) defaultSize) / ((float) defaultSize2) > 1.0f) ? this.scalingTypeMatchOrientation : this.scalingTypeMismatchOrientation, f2, defaultSize, defaultSize2);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                displaySize.x = defaultSize;
            }
            if (View.MeasureSpec.getMode(i3) == 1073741824) {
                displaySize.y = defaultSize2;
            }
            return displaySize;
        }

        public void setScalingType(ScalingType scalingType) {
            this.scalingTypeMatchOrientation = scalingType;
            this.scalingTypeMismatchOrientation = scalingType;
        }

        public void setScalingType(ScalingType scalingType, ScalingType scalingType2) {
            this.scalingTypeMatchOrientation = scalingType;
            this.scalingTypeMismatchOrientation = scalingType2;
        }
    }

    public static void adjustOrigin(float[] fArr) {
        fArr[12] = fArr[12] - ((fArr[0] + fArr[4]) * 0.5f);
        fArr[13] = fArr[13] - ((fArr[1] + fArr[5]) * 0.5f);
        fArr[12] = fArr[12] + 0.5f;
        fArr[13] = fArr[13] + 0.5f;
    }

    public static float[] convertMatrixFromAndroidGraphicsMatrix(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return new float[]{fArr[0], fArr[3], 0.0f, fArr[6], fArr[1], fArr[4], 0.0f, fArr[7], 0.0f, 0.0f, 1.0f, 0.0f, fArr[2], fArr[5], 0.0f, fArr[8]};
    }

    public static Matrix convertMatrixToAndroidGraphicsMatrix(float[] fArr) {
        float f2 = fArr[0];
        float f3 = fArr[4];
        float f4 = fArr[12];
        float f5 = fArr[1];
        float f6 = fArr[5];
        float f7 = fArr[13];
        float f8 = fArr[3];
        float f9 = fArr[7];
        float f10 = fArr[15];
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{f2, f3, f4, f5, f6, f7, f8, f9, f10});
        return matrix;
    }

    public static float convertScalingTypeToVisibleFraction(ScalingType scalingType) {
        int i2 = AnonymousClass1.$SwitchMap$org$webrtc$RendererCommon$ScalingType[scalingType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return BALANCED_VISIBLE_FRACTION;
                }
                throw new IllegalArgumentException();
            }
            return 0.0f;
        }
        return 1.0f;
    }

    public static Point getDisplaySize(float f2, float f3, int i2, int i3) {
        return (f2 == 0.0f || f3 == 0.0f) ? new Point(i2, i3) : new Point(Math.min(i2, Math.round((i3 / f2) * f3)), Math.min(i3, Math.round((i2 / f2) / f3)));
    }

    public static Point getDisplaySize(ScalingType scalingType, float f2, int i2, int i3) {
        return getDisplaySize(convertScalingTypeToVisibleFraction(scalingType), f2, i2, i3);
    }

    public static float[] getLayoutMatrix(boolean z, float f2, float f3) {
        float f4;
        float f5;
        if (f3 > f2) {
            f5 = f2 / f3;
            f4 = 1.0f;
        } else {
            f4 = f3 / f2;
            f5 = 1.0f;
        }
        if (z) {
            f4 *= -1.0f;
        }
        float[] fArr = new float[16];
        android.opengl.Matrix.setIdentityM(fArr, 0);
        android.opengl.Matrix.scaleM(fArr, 0, f4, f5, 1.0f);
        adjustOrigin(fArr);
        return fArr;
    }
}
