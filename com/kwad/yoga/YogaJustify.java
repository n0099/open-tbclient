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
/* loaded from: classes8.dex */
public final class YogaJustify {
    public static final /* synthetic */ YogaJustify[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final YogaJustify CENTER;
    public static final YogaJustify FLEX_END;
    public static final YogaJustify FLEX_START;
    public static final YogaJustify SPACE_AROUND;
    public static final YogaJustify SPACE_BETWEEN;
    public static final YogaJustify SPACE_EVENLY;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1709890996, "Lcom/kwad/yoga/YogaJustify;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1709890996, "Lcom/kwad/yoga/YogaJustify;");
                return;
            }
        }
        FLEX_START = new YogaJustify("FLEX_START", 0, 0);
        CENTER = new YogaJustify("CENTER", 1, 1);
        FLEX_END = new YogaJustify("FLEX_END", 2, 2);
        SPACE_BETWEEN = new YogaJustify("SPACE_BETWEEN", 3, 3);
        SPACE_AROUND = new YogaJustify("SPACE_AROUND", 4, 4);
        YogaJustify yogaJustify = new YogaJustify("SPACE_EVENLY", 5, 5);
        SPACE_EVENLY = yogaJustify;
        $VALUES = new YogaJustify[]{FLEX_START, CENTER, FLEX_END, SPACE_BETWEEN, SPACE_AROUND, yogaJustify};
    }

    public YogaJustify(String str, int i2, int i3) {
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

    public static YogaJustify fromInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 == 5) {
                                    return SPACE_EVENLY;
                                }
                                throw new IllegalArgumentException("Unknown enum value: " + i2);
                            }
                            return SPACE_AROUND;
                        }
                        return SPACE_BETWEEN;
                    }
                    return FLEX_END;
                }
                return CENTER;
            }
            return FLEX_START;
        }
        return (YogaJustify) invokeI.objValue;
    }

    public static YogaJustify valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (YogaJustify) Enum.valueOf(YogaJustify.class, str) : (YogaJustify) invokeL.objValue;
    }

    public static YogaJustify[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (YogaJustify[]) $VALUES.clone() : (YogaJustify[]) invokeV.objValue;
    }

    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIntValue : invokeV.intValue;
    }
}
