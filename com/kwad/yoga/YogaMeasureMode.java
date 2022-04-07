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
public final class YogaMeasureMode {
    public static final /* synthetic */ YogaMeasureMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final YogaMeasureMode AT_MOST;
    public static final YogaMeasureMode EXACTLY;
    public static final YogaMeasureMode UNDEFINED;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-723396157, "Lcom/kwad/yoga/YogaMeasureMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-723396157, "Lcom/kwad/yoga/YogaMeasureMode;");
                return;
            }
        }
        UNDEFINED = new YogaMeasureMode("UNDEFINED", 0, 0);
        EXACTLY = new YogaMeasureMode("EXACTLY", 1, 1);
        YogaMeasureMode yogaMeasureMode = new YogaMeasureMode("AT_MOST", 2, 2);
        AT_MOST = yogaMeasureMode;
        $VALUES = new YogaMeasureMode[]{UNDEFINED, EXACTLY, yogaMeasureMode};
    }

    public YogaMeasureMode(String str, int i, int i2) {
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

    public static YogaMeasureMode fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return AT_MOST;
                    }
                    throw new IllegalArgumentException("Unknown enum value: " + i);
                }
                return EXACTLY;
            }
            return UNDEFINED;
        }
        return (YogaMeasureMode) invokeI.objValue;
    }

    public static YogaMeasureMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (YogaMeasureMode) Enum.valueOf(YogaMeasureMode.class, str) : (YogaMeasureMode) invokeL.objValue;
    }

    public static YogaMeasureMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (YogaMeasureMode[]) $VALUES.clone() : (YogaMeasureMode[]) invokeV.objValue;
    }

    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIntValue : invokeV.intValue;
    }
}
