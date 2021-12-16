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
/* loaded from: classes3.dex */
public final class YogaWrap {
    public static final /* synthetic */ YogaWrap[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final YogaWrap NO_WRAP;
    public static final YogaWrap WRAP;
    public static final YogaWrap WRAP_REVERSE;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1324623816, "Lcom/kwad/yoga/YogaWrap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1324623816, "Lcom/kwad/yoga/YogaWrap;");
                return;
            }
        }
        NO_WRAP = new YogaWrap("NO_WRAP", 0, 0);
        WRAP = new YogaWrap("WRAP", 1, 1);
        YogaWrap yogaWrap = new YogaWrap("WRAP_REVERSE", 2, 2);
        WRAP_REVERSE = yogaWrap;
        $VALUES = new YogaWrap[]{NO_WRAP, WRAP, yogaWrap};
    }

    public YogaWrap(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIntValue = i3;
    }

    public static YogaWrap fromInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return WRAP_REVERSE;
                    }
                    throw new IllegalArgumentException("Unknown enum value: " + i2);
                }
                return WRAP;
            }
            return NO_WRAP;
        }
        return (YogaWrap) invokeI.objValue;
    }

    public static YogaWrap valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (YogaWrap) Enum.valueOf(YogaWrap.class, str) : (YogaWrap) invokeL.objValue;
    }

    public static YogaWrap[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (YogaWrap[]) $VALUES.clone() : (YogaWrap[]) invokeV.objValue;
    }

    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIntValue : invokeV.intValue;
    }
}
