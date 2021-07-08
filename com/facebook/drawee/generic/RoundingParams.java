package com.facebook.drawee.generic;

import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes5.dex */
public class RoundingParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBorderColor;
    public float mBorderWidth;
    public float[] mCornersRadii;
    public int mOverlayColor;
    public float mPadding;
    public boolean mPaintFilterBitmap;
    public boolean mRoundAsCircle;
    public RoundingMethod mRoundingMethod;
    public boolean mScaleDownInsideBorders;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class RoundingMethod {
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

        public RoundingMethod(String str, int i2) {
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

        public static RoundingMethod valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RoundingMethod) Enum.valueOf(RoundingMethod.class, str) : (RoundingMethod) invokeL.objValue;
        }

        public static RoundingMethod[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RoundingMethod[]) $VALUES.clone() : (RoundingMethod[]) invokeV.objValue;
        }
    }

    public RoundingParams() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new RoundingParams().setRoundAsCircle(true) : (RoundingParams) invokeV.objValue;
    }

    public static RoundingParams fromCornersRadii(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? new RoundingParams().setCornersRadii(f2, f3, f4, f5) : (RoundingParams) invokeCommon.objValue;
    }

    public static RoundingParams fromCornersRadius(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, null, f2)) == null) ? new RoundingParams().setCornersRadius(f2) : (RoundingParams) invokeF.objValue;
    }

    private float[] getOrCreateRoundedCornersRadii() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (this.mCornersRadii == null) {
                this.mCornersRadii = new float[8];
            }
            return this.mCornersRadii;
        }
        return (float[]) invokeV.objValue;
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
            if (this.mRoundAsCircle == roundingParams.mRoundAsCircle && this.mOverlayColor == roundingParams.mOverlayColor && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.mRoundingMethod == roundingParams.mRoundingMethod && this.mScaleDownInsideBorders == roundingParams.mScaleDownInsideBorders && this.mPaintFilterBitmap == roundingParams.mPaintFilterBitmap) {
                return Arrays.equals(this.mCornersRadii, roundingParams.mCornersRadii);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int getBorderColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBorderColor : invokeV.intValue;
    }

    public float getBorderWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBorderWidth : invokeV.floatValue;
    }

    public float[] getCornersRadii() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCornersRadii : (float[]) invokeV.objValue;
    }

    public int getOverlayColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mOverlayColor : invokeV.intValue;
    }

    public float getPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPadding : invokeV.floatValue;
    }

    public boolean getPaintFilterBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPaintFilterBitmap : invokeV.booleanValue;
    }

    public boolean getRoundAsCircle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mRoundAsCircle : invokeV.booleanValue;
    }

    public RoundingMethod getRoundingMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mRoundingMethod : (RoundingMethod) invokeV.objValue;
    }

    public boolean getScaleDownInsideBorders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mScaleDownInsideBorders : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RoundingMethod roundingMethod = this.mRoundingMethod;
            int hashCode = (((roundingMethod != null ? roundingMethod.hashCode() : 0) * 31) + (this.mRoundAsCircle ? 1 : 0)) * 31;
            float[] fArr = this.mCornersRadii;
            int hashCode2 = (((hashCode + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31) + this.mOverlayColor) * 31;
            float f2 = this.mBorderWidth;
            int floatToIntBits = (((hashCode2 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + this.mBorderColor) * 31;
            float f3 = this.mPadding;
            return ((((floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31) + (this.mScaleDownInsideBorders ? 1 : 0)) * 31) + (this.mPaintFilterBitmap ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public RoundingParams setBorder(@ColorInt int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            Preconditions.checkArgument(f2 >= 0.0f, "the border width cannot be < 0");
            this.mBorderWidth = f2;
            this.mBorderColor = i2;
            return this;
        }
        return (RoundingParams) invokeCommon.objValue;
    }

    public RoundingParams setBorderColor(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.mBorderColor = i2;
            return this;
        }
        return (RoundingParams) invokeI.objValue;
    }

    public RoundingParams setBorderWidth(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048589, this, f2)) == null) {
            Preconditions.checkArgument(f2 >= 0.0f, "the border width cannot be < 0");
            this.mBorderWidth = f2;
            return this;
        }
        return (RoundingParams) invokeF.objValue;
    }

    public RoundingParams setCornersRadii(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float[] orCreateRoundedCornersRadii = getOrCreateRoundedCornersRadii();
            orCreateRoundedCornersRadii[1] = f2;
            orCreateRoundedCornersRadii[0] = f2;
            orCreateRoundedCornersRadii[3] = f3;
            orCreateRoundedCornersRadii[2] = f3;
            orCreateRoundedCornersRadii[5] = f4;
            orCreateRoundedCornersRadii[4] = f4;
            orCreateRoundedCornersRadii[7] = f5;
            orCreateRoundedCornersRadii[6] = f5;
            return this;
        }
        return (RoundingParams) invokeCommon.objValue;
    }

    public RoundingParams setCornersRadius(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048592, this, f2)) == null) {
            Arrays.fill(getOrCreateRoundedCornersRadii(), f2);
            return this;
        }
        return (RoundingParams) invokeF.objValue;
    }

    public RoundingParams setOverlayColor(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            this.mOverlayColor = i2;
            this.mRoundingMethod = RoundingMethod.OVERLAY_COLOR;
            return this;
        }
        return (RoundingParams) invokeI.objValue;
    }

    public RoundingParams setPadding(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048594, this, f2)) == null) {
            Preconditions.checkArgument(f2 >= 0.0f, "the padding cannot be < 0");
            this.mPadding = f2;
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

    public static RoundingParams fromCornersRadii(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fArr)) == null) ? new RoundingParams().setCornersRadii(fArr) : (RoundingParams) invokeL.objValue;
    }

    public RoundingParams setCornersRadii(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, fArr)) == null) {
            Preconditions.checkNotNull(fArr);
            Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, getOrCreateRoundedCornersRadii(), 0, 8);
            return this;
        }
        return (RoundingParams) invokeL.objValue;
    }
}
