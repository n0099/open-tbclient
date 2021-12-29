package com.tachikoma.core.utility;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class TKSpacing {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALL = 8;
    public static final int BOTTOM = 3;
    public static final int END = 5;
    public static final int HORIZONTAL = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    public static final int START = 4;
    public static final int TOP = 1;
    public static float UNDEFINED = 0.0f;
    public static final int VERTICAL = 7;
    public static final int[] sFlagsMap;
    public transient /* synthetic */ FieldHolder $fh;
    public final float mDefaultValue;
    public boolean mHasAliasesSet;
    public final float[] mSpacing;
    public int mValueFlags;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-631576952, "Lcom/tachikoma/core/utility/TKSpacing;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-631576952, "Lcom/tachikoma/core/utility/TKSpacing;");
                return;
            }
        }
        sFlagsMap = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256};
        UNDEFINED = 1.0E21f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TKSpacing() {
        this(0.0f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Float) newInitContext.callArgs[0]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public TKSpacing(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mValueFlags = 0;
        this.mDefaultValue = f2;
        this.mSpacing = newFullSpacingArray();
    }

    public TKSpacing(TKSpacing tKSpacing) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tKSpacing};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mValueFlags = 0;
        this.mDefaultValue = tKSpacing.mDefaultValue;
        float[] fArr = tKSpacing.mSpacing;
        this.mSpacing = Arrays.copyOf(fArr, fArr.length);
        this.mValueFlags = tKSpacing.mValueFlags;
        this.mHasAliasesSet = tKSpacing.mHasAliasesSet;
    }

    public static boolean isUndefined(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, null, f2)) == null) ? Float.compare(f2, UNDEFINED) == 0 : invokeF.booleanValue;
    }

    public static float[] newFullSpacingArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            float f2 = UNDEFINED;
            return new float[]{f2, f2, f2, f2, f2, f2, f2, f2, f2};
        }
        return (float[]) invokeV.objValue;
    }

    public float get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            float f2 = (i2 == 4 || i2 == 5) ? UNDEFINED : this.mDefaultValue;
            int i3 = this.mValueFlags;
            if (i3 == 0) {
                return f2;
            }
            if ((i3 & sFlagsMap[i2]) != 0) {
                return this.mSpacing[i2];
            }
            if (this.mHasAliasesSet) {
                char c2 = (i2 == 1 || i2 == 3) ? (char) 7 : (char) 6;
                int i4 = this.mValueFlags;
                int[] iArr = sFlagsMap;
                if ((iArr[c2] & i4) != 0) {
                    return this.mSpacing[c2];
                }
                if ((i4 & iArr[8]) != 0) {
                    return this.mSpacing[8];
                }
            }
            return f2;
        }
        return invokeI.floatValue;
    }

    public float getRaw(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.mSpacing[i2] : invokeI.floatValue;
    }

    public float getWithFallback(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) ? (this.mValueFlags & sFlagsMap[i2]) != 0 ? this.mSpacing[i2] : get(i3) : invokeII.floatValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Arrays.fill(this.mSpacing, UNDEFINED);
            this.mHasAliasesSet = false;
            this.mValueFlags = 0;
        }
    }

    public boolean set(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            boolean z = false;
            if (TKFloatUtil.floatsEqual(this.mSpacing[i2], f2)) {
                return false;
            }
            this.mSpacing[i2] = f2;
            this.mValueFlags = isUndefined(f2) ? (~sFlagsMap[i2]) & this.mValueFlags : sFlagsMap[i2] | this.mValueFlags;
            int i3 = this.mValueFlags;
            int[] iArr = sFlagsMap;
            this.mHasAliasesSet = ((iArr[8] & i3) == 0 && (iArr[7] & i3) == 0 && (i3 & iArr[6]) == 0) ? true : true;
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
