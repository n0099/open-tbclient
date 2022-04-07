package com.kwad.yoga;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.proguard.annotations.DoNotStrip;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@DoNotStrip
/* loaded from: classes5.dex */
public final class YogaFlexDirection {
    public static final /* synthetic */ YogaFlexDirection[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final YogaFlexDirection COLUMN;
    public static final YogaFlexDirection COLUMN_REVERSE;
    public static final YogaFlexDirection ROW;
    public static final YogaFlexDirection ROW_REVERSE;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1282577218, "Lcom/kwad/yoga/YogaFlexDirection;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1282577218, "Lcom/kwad/yoga/YogaFlexDirection;");
                return;
            }
        }
        COLUMN = new YogaFlexDirection("COLUMN", 0, 0);
        COLUMN_REVERSE = new YogaFlexDirection("COLUMN_REVERSE", 1, 1);
        ROW = new YogaFlexDirection("ROW", 2, 2);
        YogaFlexDirection yogaFlexDirection = new YogaFlexDirection("ROW_REVERSE", 3, 3);
        ROW_REVERSE = yogaFlexDirection;
        $VALUES = new YogaFlexDirection[]{COLUMN, COLUMN_REVERSE, ROW, yogaFlexDirection};
    }

    public YogaFlexDirection(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIntValue = i2;
    }

    public static YogaFlexDirection fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return ROW_REVERSE;
                        }
                        throw new IllegalArgumentException("Unknown enum value: " + i);
                    }
                    return ROW;
                }
                return COLUMN_REVERSE;
            }
            return COLUMN;
        }
        return (YogaFlexDirection) invokeI.objValue;
    }

    public static YogaFlexDirection valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (YogaFlexDirection) Enum.valueOf(YogaFlexDirection.class, str) : (YogaFlexDirection) invokeL.objValue;
    }

    public static YogaFlexDirection[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (YogaFlexDirection[]) $VALUES.clone() : (YogaFlexDirection[]) invokeV.objValue;
    }

    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIntValue : invokeV.intValue;
    }
}
