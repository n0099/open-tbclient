package com.kwad.yoga;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class YogaLayoutType {
    public static final /* synthetic */ YogaLayoutType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final YogaLayoutType CACHED_LAYOUT;
    public static final YogaLayoutType CACHED_MEASURE;
    public static final YogaLayoutType LAYOUT;
    public static final YogaLayoutType MEASURE;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1436694670, "Lcom/kwad/yoga/YogaLayoutType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1436694670, "Lcom/kwad/yoga/YogaLayoutType;");
                return;
            }
        }
        LAYOUT = new YogaLayoutType("LAYOUT", 0, 0);
        MEASURE = new YogaLayoutType("MEASURE", 1, 1);
        CACHED_LAYOUT = new YogaLayoutType("CACHED_LAYOUT", 2, 2);
        YogaLayoutType yogaLayoutType = new YogaLayoutType("CACHED_MEASURE", 3, 3);
        CACHED_MEASURE = yogaLayoutType;
        $VALUES = new YogaLayoutType[]{LAYOUT, MEASURE, CACHED_LAYOUT, yogaLayoutType};
    }

    public YogaLayoutType(String str, int i, int i2) {
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

    public static YogaLayoutType fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return CACHED_MEASURE;
                        }
                        throw new IllegalArgumentException("Unknown enum value: " + i);
                    }
                    return CACHED_LAYOUT;
                }
                return MEASURE;
            }
            return LAYOUT;
        }
        return (YogaLayoutType) invokeI.objValue;
    }

    public static YogaLayoutType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (YogaLayoutType) Enum.valueOf(YogaLayoutType.class, str) : (YogaLayoutType) invokeL.objValue;
    }

    public static YogaLayoutType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (YogaLayoutType[]) $VALUES.clone() : (YogaLayoutType[]) invokeV.objValue;
    }

    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIntValue : invokeV.intValue;
    }
}
