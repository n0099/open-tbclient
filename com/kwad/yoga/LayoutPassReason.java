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
/* loaded from: classes4.dex */
public final class LayoutPassReason {
    public static final /* synthetic */ LayoutPassReason[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LayoutPassReason ABS_LAYOUT;
    public static final LayoutPassReason ABS_MEASURE;
    public static final LayoutPassReason FLEX_LAYOUT;
    public static final LayoutPassReason FLEX_MEASURE;
    public static final LayoutPassReason INITIAL;
    public static final LayoutPassReason MEASURE;
    public static final LayoutPassReason MULTILINE_STRETCH;
    public static final LayoutPassReason STRETCH;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(642597827, "Lcom/kwad/yoga/LayoutPassReason;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(642597827, "Lcom/kwad/yoga/LayoutPassReason;");
                return;
            }
        }
        INITIAL = new LayoutPassReason("INITIAL", 0, 0);
        ABS_LAYOUT = new LayoutPassReason("ABS_LAYOUT", 1, 1);
        STRETCH = new LayoutPassReason("STRETCH", 2, 2);
        MULTILINE_STRETCH = new LayoutPassReason("MULTILINE_STRETCH", 3, 3);
        FLEX_LAYOUT = new LayoutPassReason("FLEX_LAYOUT", 4, 4);
        MEASURE = new LayoutPassReason("MEASURE", 5, 5);
        ABS_MEASURE = new LayoutPassReason("ABS_MEASURE", 6, 6);
        LayoutPassReason layoutPassReason = new LayoutPassReason("FLEX_MEASURE", 7, 7);
        FLEX_MEASURE = layoutPassReason;
        $VALUES = new LayoutPassReason[]{INITIAL, ABS_LAYOUT, STRETCH, MULTILINE_STRETCH, FLEX_LAYOUT, MEASURE, ABS_MEASURE, layoutPassReason};
    }

    public LayoutPassReason(String str, int i2, int i3) {
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

    public static LayoutPassReason fromInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            switch (i2) {
                case 0:
                    return INITIAL;
                case 1:
                    return ABS_LAYOUT;
                case 2:
                    return STRETCH;
                case 3:
                    return MULTILINE_STRETCH;
                case 4:
                    return FLEX_LAYOUT;
                case 5:
                    return MEASURE;
                case 6:
                    return ABS_MEASURE;
                case 7:
                    return FLEX_MEASURE;
                default:
                    throw new IllegalArgumentException("Unknown enum value: " + i2);
            }
        }
        return (LayoutPassReason) invokeI.objValue;
    }

    public static LayoutPassReason valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (LayoutPassReason) Enum.valueOf(LayoutPassReason.class, str) : (LayoutPassReason) invokeL.objValue;
    }

    public static LayoutPassReason[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (LayoutPassReason[]) $VALUES.clone() : (LayoutPassReason[]) invokeV.objValue;
    }

    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIntValue : invokeV.intValue;
    }
}
