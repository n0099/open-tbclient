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
/* loaded from: classes7.dex */
public final class YogaLogLevel {
    public static final /* synthetic */ YogaLogLevel[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final YogaLogLevel DEBUG;
    public static final YogaLogLevel ERROR;
    public static final YogaLogLevel FATAL;
    public static final YogaLogLevel INFO;
    public static final YogaLogLevel VERBOSE;
    public static final YogaLogLevel WARN;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1366600882, "Lcom/kwad/yoga/YogaLogLevel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1366600882, "Lcom/kwad/yoga/YogaLogLevel;");
                return;
            }
        }
        ERROR = new YogaLogLevel("ERROR", 0, 0);
        WARN = new YogaLogLevel("WARN", 1, 1);
        INFO = new YogaLogLevel("INFO", 2, 2);
        DEBUG = new YogaLogLevel("DEBUG", 3, 3);
        VERBOSE = new YogaLogLevel("VERBOSE", 4, 4);
        YogaLogLevel yogaLogLevel = new YogaLogLevel("FATAL", 5, 5);
        FATAL = yogaLogLevel;
        $VALUES = new YogaLogLevel[]{ERROR, WARN, INFO, DEBUG, VERBOSE, yogaLogLevel};
    }

    public YogaLogLevel(String str, int i, int i2) {
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

    public static YogaLogLevel fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i == 5) {
                                    return FATAL;
                                }
                                throw new IllegalArgumentException("Unknown enum value: " + i);
                            }
                            return VERBOSE;
                        }
                        return DEBUG;
                    }
                    return INFO;
                }
                return WARN;
            }
            return ERROR;
        }
        return (YogaLogLevel) invokeI.objValue;
    }

    public static YogaLogLevel valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (YogaLogLevel) Enum.valueOf(YogaLogLevel.class, str) : (YogaLogLevel) invokeL.objValue;
    }

    public static YogaLogLevel[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (YogaLogLevel[]) $VALUES.clone() : (YogaLogLevel[]) invokeV.objValue;
    }

    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIntValue : invokeV.intValue;
    }
}
