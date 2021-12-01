package org.webrtc;

import android.graphics.Matrix;
import android.graphics.Point;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class RendererCommon {
    public static /* synthetic */ Interceptable $ic = null;
    public static float BALANCED_VISIBLE_FRACTION = 0.5625f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: org.webrtc.RendererCommon$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$webrtc$RendererCommon$ScalingType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(718999029, "Lorg/webrtc/RendererCommon$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(718999029, "Lorg/webrtc/RendererCommon$1;");
                    return;
                }
            }
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

    /* loaded from: classes3.dex */
    public interface GlDrawer {
        void drawOes(int i2, float[] fArr, int i3, int i4, int i5, int i6, int i7, int i8);

        void drawRgb(int i2, float[] fArr, int i3, int i4, int i5, int i6, int i7, int i8);

        void drawYuv(int[] iArr, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7);

        void release();
    }

    /* loaded from: classes3.dex */
    public interface RendererEvents {
        void onFirstFrameRendered();

        void onFrameResolutionChanged(int i2, int i3, int i4);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ScalingType {
        public static final /* synthetic */ ScalingType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ScalingType SCALE_ASPECT_BALANCED;
        public static final ScalingType SCALE_ASPECT_FILL;
        public static final ScalingType SCALE_ASPECT_FIT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(569959205, "Lorg/webrtc/RendererCommon$ScalingType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(569959205, "Lorg/webrtc/RendererCommon$ScalingType;");
                    return;
                }
            }
            SCALE_ASPECT_FIT = new ScalingType("SCALE_ASPECT_FIT", 0);
            SCALE_ASPECT_FILL = new ScalingType("SCALE_ASPECT_FILL", 1);
            ScalingType scalingType = new ScalingType("SCALE_ASPECT_BALANCED", 2);
            SCALE_ASPECT_BALANCED = scalingType;
            $VALUES = new ScalingType[]{SCALE_ASPECT_FIT, SCALE_ASPECT_FILL, scalingType};
        }

        public ScalingType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ScalingType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ScalingType) Enum.valueOf(ScalingType.class, str) : (ScalingType) invokeL.objValue;
        }

        public static ScalingType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ScalingType[]) $VALUES.clone() : (ScalingType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1761640098, "Lorg/webrtc/RendererCommon;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1761640098, "Lorg/webrtc/RendererCommon;");
        }
    }

    public RendererCommon() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void adjustOrigin(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fArr) == null) {
            fArr[12] = fArr[12] - ((fArr[0] + fArr[4]) * 0.5f);
            fArr[13] = fArr[13] - ((fArr[1] + fArr[5]) * 0.5f);
            fArr[12] = fArr[12] + 0.5f;
            fArr[13] = fArr[13] + 0.5f;
        }
    }

    public static float[] convertMatrixFromAndroidGraphicsMatrix(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, matrix)) == null) {
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            return new float[]{fArr[0], fArr[3], 0.0f, fArr[6], fArr[1], fArr[4], 0.0f, fArr[7], 0.0f, 0.0f, 1.0f, 0.0f, fArr[2], fArr[5], 0.0f, fArr[8]};
        }
        return (float[]) invokeL.objValue;
    }

    public static Matrix convertMatrixToAndroidGraphicsMatrix(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fArr)) == null) {
            float[] fArr2 = {fArr[0], fArr[4], fArr[12], fArr[1], fArr[5], fArr[13], fArr[3], fArr[7], fArr[15]};
            Matrix matrix = new Matrix();
            matrix.setValues(fArr2);
            return matrix;
        }
        return (Matrix) invokeL.objValue;
    }

    public static float convertScalingTypeToVisibleFraction(ScalingType scalingType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, scalingType)) == null) {
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
        return invokeL.floatValue;
    }

    public static Point getDisplaySize(ScalingType scalingType, float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{scalingType, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? getDisplaySize(convertScalingTypeToVisibleFraction(scalingType), f2, i2, i3) : (Point) invokeCommon.objValue;
    }

    public static float[] getLayoutMatrix(boolean z, float f2, float f3) {
        InterceptResult invokeCommon;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
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
        return (float[]) invokeCommon.objValue;
    }

    /* loaded from: classes3.dex */
    public static class VideoLayoutMeasure {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ScalingType scalingTypeMatchOrientation;
        public ScalingType scalingTypeMismatchOrientation;

        public VideoLayoutMeasure() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ScalingType scalingType = ScalingType.SCALE_ASPECT_BALANCED;
            this.scalingTypeMatchOrientation = scalingType;
            this.scalingTypeMismatchOrientation = scalingType;
        }

        public Point measure(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i2, i3, i4, i5)) == null) {
                int defaultSize = View.getDefaultSize(Integer.MAX_VALUE, i2);
                int defaultSize2 = View.getDefaultSize(Integer.MAX_VALUE, i3);
                if (i4 != 0 && i5 != 0 && defaultSize != 0 && defaultSize2 != 0) {
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
                return new Point(defaultSize, defaultSize2);
            }
            return (Point) invokeIIII.objValue;
        }

        public void setScalingType(ScalingType scalingType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, scalingType) == null) {
                this.scalingTypeMatchOrientation = scalingType;
                this.scalingTypeMismatchOrientation = scalingType;
            }
        }

        public void setScalingType(ScalingType scalingType, ScalingType scalingType2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, scalingType, scalingType2) == null) {
                this.scalingTypeMatchOrientation = scalingType;
                this.scalingTypeMismatchOrientation = scalingType2;
            }
        }
    }

    public static Point getDisplaySize(float f2, float f3, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (f2 != 0.0f && f3 != 0.0f) {
                return new Point(Math.min(i2, Math.round((i3 / f2) * f3)), Math.min(i3, Math.round((i2 / f2) / f3)));
            }
            return new Point(i2, i3);
        }
        return (Point) invokeCommon.objValue;
    }
}
