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
public final class YogaAlign {
    public static final /* synthetic */ YogaAlign[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final YogaAlign AUTO;
    public static final YogaAlign BASELINE;
    public static final YogaAlign CENTER;
    public static final YogaAlign FLEX_END;
    public static final YogaAlign FLEX_START;
    public static final YogaAlign SPACE_AROUND;
    public static final YogaAlign SPACE_BETWEEN;
    public static final YogaAlign STRETCH;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1773481503, "Lcom/kwad/yoga/YogaAlign;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1773481503, "Lcom/kwad/yoga/YogaAlign;");
                return;
            }
        }
        AUTO = new YogaAlign("AUTO", 0, 0);
        FLEX_START = new YogaAlign("FLEX_START", 1, 1);
        CENTER = new YogaAlign("CENTER", 2, 2);
        FLEX_END = new YogaAlign("FLEX_END", 3, 3);
        STRETCH = new YogaAlign("STRETCH", 4, 4);
        BASELINE = new YogaAlign("BASELINE", 5, 5);
        SPACE_BETWEEN = new YogaAlign("SPACE_BETWEEN", 6, 6);
        YogaAlign yogaAlign = new YogaAlign("SPACE_AROUND", 7, 7);
        SPACE_AROUND = yogaAlign;
        $VALUES = new YogaAlign[]{AUTO, FLEX_START, CENTER, FLEX_END, STRETCH, BASELINE, SPACE_BETWEEN, yogaAlign};
    }

    public YogaAlign(String str, int i, int i2) {
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

    public static YogaAlign fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            switch (i) {
                case 0:
                    return AUTO;
                case 1:
                    return FLEX_START;
                case 2:
                    return CENTER;
                case 3:
                    return FLEX_END;
                case 4:
                    return STRETCH;
                case 5:
                    return BASELINE;
                case 6:
                    return SPACE_BETWEEN;
                case 7:
                    return SPACE_AROUND;
                default:
                    throw new IllegalArgumentException("Unknown enum value: " + i);
            }
        }
        return (YogaAlign) invokeI.objValue;
    }

    public static YogaAlign valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (YogaAlign) Enum.valueOf(YogaAlign.class, str) : (YogaAlign) invokeL.objValue;
    }

    public static YogaAlign[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (YogaAlign[]) $VALUES.clone() : (YogaAlign[]) invokeV.objValue;
    }

    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIntValue : invokeV.intValue;
    }
}
