package com.facebook.drawee.generic;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class RoundingParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBorderColor;
    public float mBorderWidth;
    @Nullable
    public float[] mCornersRadii;
    public int mOverlayColor;
    public float mPadding;
    public boolean mPaintFilterBitmap;
    public boolean mRoundAsCircle;
    public RoundingMethod mRoundingMethod;
    public boolean mScaleDownInsideBorders;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public final class RoundingMethod {
        public static final /* synthetic */ RoundingMethod[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RoundingMethod BITMAP_ONLY;
        public static final RoundingMethod OVERLAY_COLOR;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1522101328, "Lcom/facebook/drawee/generic/RoundingParams$RoundingMethod;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1522101328, "Lcom/facebook/drawee/generic/RoundingParams$RoundingMethod;");
                    return;
                }
            }
            OVERLAY_COLOR = new RoundingMethod("OVERLAY_COLOR", 0);
            RoundingMethod roundingMethod = new RoundingMethod("BITMAP_ONLY", 1);
            BITMAP_ONLY = roundingMethod;
            $VALUES = new RoundingMethod[]{OVERLAY_COLOR, roundingMethod};
        }

        public RoundingMethod(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RoundingMethod valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (RoundingMethod) Enum.valueOf(RoundingMethod.class, str);
            }
            return (RoundingMethod) invokeL.objValue;
        }

        public static RoundingMethod[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (RoundingMethod[]) $VALUES.clone();
            }
            return (RoundingMethod[]) invokeV.objValue;
        }
    }

    public RoundingParams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRoundingMethod = RoundingMethod.BITMAP_ONLY;
        this.mRoundAsCircle = false;
        this.mCornersRadii = null;
        this.mOverlayColor = 0;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.mPadding = 0.0f;
        this.mScaleDownInsideBorders = false;
        this.mPaintFilterBitmap = false;
    }

    public static RoundingParams asCircle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new RoundingParams().setRoundAsCircle(true);
        }
        return (RoundingParams) invokeV.objValue;
    }

    private float[] getOrCreateRoundedCornersRadii() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.mCornersRadii == null) {
                this.mCornersRadii = new float[8];
            }
            return this.mCornersRadii;
        }
        return (float[]) invokeV.objValue;
    }

    public int getBorderColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBorderColor;
        }
        return invokeV.intValue;
    }

    public float getBorderWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mBorderWidth;
        }
        return invokeV.floatValue;
    }

    @Nullable
    public float[] getCornersRadii() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mCornersRadii;
        }
        return (float[]) invokeV.objValue;
    }

    public int getOverlayColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mOverlayColor;
        }
        return invokeV.intValue;
    }

    public float getPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mPadding;
        }
        return invokeV.floatValue;
    }

    public boolean getPaintFilterBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mPaintFilterBitmap;
        }
        return invokeV.booleanValue;
    }

    public boolean getRoundAsCircle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mRoundAsCircle;
        }
        return invokeV.booleanValue;
    }

    public RoundingMethod getRoundingMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mRoundingMethod;
        }
        return (RoundingMethod) invokeV.objValue;
    }

    public boolean getScaleDownInsideBorders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mScaleDownInsideBorders;
        }
        return invokeV.booleanValue;
    }

    public static RoundingParams fromCornersRadii(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            return new RoundingParams().setCornersRadii(f, f2, f3, f4);
        }
        return (RoundingParams) invokeCommon.objValue;
    }

    public static RoundingParams fromCornersRadii(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fArr)) == null) {
            return new RoundingParams().setCornersRadii(fArr);
        }
        return (RoundingParams) invokeL.objValue;
    }

    public static RoundingParams fromCornersRadius(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, null, f)) == null) {
            return new RoundingParams().setCornersRadius(f);
        }
        return (RoundingParams) invokeF.objValue;
    }

    public RoundingParams setBorderColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            this.mBorderColor = i;
            return this;
        }
        return (RoundingParams) invokeI.objValue;
    }

    public RoundingParams setBorderWidth(float f) {
        InterceptResult invokeF;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048589, this, f)) == null) {
            if (f >= 0.0f) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "the border width cannot be < 0");
            this.mBorderWidth = f;
            return this;
        }
        return (RoundingParams) invokeF.objValue;
    }

    public RoundingParams setCornersRadii(float[] fArr) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, fArr)) == null) {
            Preconditions.checkNotNull(fArr);
            if (fArr.length == 8) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, getOrCreateRoundedCornersRadii(), 0, 8);
            return this;
        }
        return (RoundingParams) invokeL.objValue;
    }

    public RoundingParams setCornersRadius(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048592, this, f)) == null) {
            Arrays.fill(getOrCreateRoundedCornersRadii(), f);
            return this;
        }
        return (RoundingParams) invokeF.objValue;
    }

    public RoundingParams setOverlayColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            this.mOverlayColor = i;
            this.mRoundingMethod = RoundingMethod.OVERLAY_COLOR;
            return this;
        }
        return (RoundingParams) invokeI.objValue;
    }

    public RoundingParams setPadding(float f) {
        InterceptResult invokeF;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048594, this, f)) == null) {
            if (f >= 0.0f) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "the padding cannot be < 0");
            this.mPadding = f;
            return this;
        }
        return (RoundingParams) invokeF.objValue;
    }

    public RoundingParams setPaintFilterBitmap(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            this.mPaintFilterBitmap = z;
            return this;
        }
        return (RoundingParams) invokeZ.objValue;
    }

    public RoundingParams setRoundAsCircle(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            this.mRoundAsCircle = z;
            return this;
        }
        return (RoundingParams) invokeZ.objValue;
    }

    public RoundingParams setRoundingMethod(RoundingMethod roundingMethod) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, roundingMethod)) == null) {
            this.mRoundingMethod = roundingMethod;
            return this;
        }
        return (RoundingParams) invokeL.objValue;
    }

    public RoundingParams setScaleDownInsideBorders(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            this.mScaleDownInsideBorders = z;
            return this;
        }
        return (RoundingParams) invokeZ.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || RoundingParams.class != obj.getClass()) {
                return false;
            }
            RoundingParams roundingParams = (RoundingParams) obj;
            if (this.mRoundAsCircle != roundingParams.mRoundAsCircle || this.mOverlayColor != roundingParams.mOverlayColor || Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) != 0 || this.mBorderColor != roundingParams.mBorderColor || Float.compare(roundingParams.mPadding, this.mPadding) != 0 || this.mRoundingMethod != roundingParams.mRoundingMethod || this.mScaleDownInsideBorders != roundingParams.mScaleDownInsideBorders || this.mPaintFilterBitmap != roundingParams.mPaintFilterBitmap) {
                return false;
            }
            return Arrays.equals(this.mCornersRadii, roundingParams.mCornersRadii);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RoundingMethod roundingMethod = this.mRoundingMethod;
            int i4 = 0;
            if (roundingMethod != null) {
                i = roundingMethod.hashCode();
            } else {
                i = 0;
            }
            int i5 = ((i * 31) + (this.mRoundAsCircle ? 1 : 0)) * 31;
            float[] fArr = this.mCornersRadii;
            if (fArr != null) {
                i2 = Arrays.hashCode(fArr);
            } else {
                i2 = 0;
            }
            int i6 = (((i5 + i2) * 31) + this.mOverlayColor) * 31;
            float f = this.mBorderWidth;
            if (f != 0.0f) {
                i3 = Float.floatToIntBits(f);
            } else {
                i3 = 0;
            }
            int i7 = (((i6 + i3) * 31) + this.mBorderColor) * 31;
            float f2 = this.mPadding;
            if (f2 != 0.0f) {
                i4 = Float.floatToIntBits(f2);
            }
            return ((((i7 + i4) * 31) + (this.mScaleDownInsideBorders ? 1 : 0)) * 31) + (this.mPaintFilterBitmap ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public RoundingParams setBorder(int i, float f) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            if (f >= 0.0f) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "the border width cannot be < 0");
            this.mBorderWidth = f;
            this.mBorderColor = i;
            return this;
        }
        return (RoundingParams) invokeCommon.objValue;
    }

    public RoundingParams setCornersRadii(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float[] orCreateRoundedCornersRadii = getOrCreateRoundedCornersRadii();
            orCreateRoundedCornersRadii[1] = f;
            orCreateRoundedCornersRadii[0] = f;
            orCreateRoundedCornersRadii[3] = f2;
            orCreateRoundedCornersRadii[2] = f2;
            orCreateRoundedCornersRadii[5] = f3;
            orCreateRoundedCornersRadii[4] = f3;
            orCreateRoundedCornersRadii[7] = f4;
            orCreateRoundedCornersRadii[6] = f4;
            return this;
        }
        return (RoundingParams) invokeCommon.objValue;
    }
}
