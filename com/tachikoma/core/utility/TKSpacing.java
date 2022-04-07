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
/* loaded from: classes8.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Float) newInitContext.callArgs[0]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public TKSpacing(float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mValueFlags = 0;
        this.mDefaultValue = f;
        this.mSpacing = newFullSpacingArray();
    }

    public TKSpacing(TKSpacing tKSpacing) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tKSpacing};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public static boolean isUndefined(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, null, f)) == null) ? Float.compare(f, UNDEFINED) == 0 : invokeF.booleanValue;
    }

    public static float[] newFullSpacingArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            float f = UNDEFINED;
            return new float[]{f, f, f, f, f, f, f, f, f};
        }
        return (float[]) invokeV.objValue;
    }

    public float get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            float f = (i == 4 || i == 5) ? UNDEFINED : this.mDefaultValue;
            int i2 = this.mValueFlags;
            if (i2 == 0) {
                return f;
            }
            if ((i2 & sFlagsMap[i]) != 0) {
                return this.mSpacing[i];
            }
            if (this.mHasAliasesSet) {
                char c = (i == 1 || i == 3) ? (char) 7 : (char) 6;
                int i3 = this.mValueFlags;
                int[] iArr = sFlagsMap;
                if ((iArr[c] & i3) != 0) {
                    return this.mSpacing[c];
                }
                if ((i3 & iArr[8]) != 0) {
                    return this.mSpacing[8];
                }
            }
            return f;
        }
        return invokeI.floatValue;
    }

    public float getRaw(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.mSpacing[i] : invokeI.floatValue;
    }

    public float getWithFallback(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) ? (this.mValueFlags & sFlagsMap[i]) != 0 ? this.mSpacing[i] : get(i2) : invokeII.floatValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Arrays.fill(this.mSpacing, UNDEFINED);
            this.mHasAliasesSet = false;
            this.mValueFlags = 0;
        }
    }

    public boolean set(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            boolean z = false;
            if (TKFloatUtil.floatsEqual(this.mSpacing[i], f)) {
                return false;
            }
            this.mSpacing[i] = f;
            this.mValueFlags = isUndefined(f) ? (~sFlagsMap[i]) & this.mValueFlags : sFlagsMap[i] | this.mValueFlags;
            int i2 = this.mValueFlags;
            int[] iArr = sFlagsMap;
            this.mHasAliasesSet = ((iArr[8] & i2) == 0 && (iArr[7] & i2) == 0 && (i2 & iArr[6]) == 0) ? true : true;
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
