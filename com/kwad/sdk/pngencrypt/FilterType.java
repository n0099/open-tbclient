package com.kwad.sdk.pngencrypt;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class FilterType {
    public static final /* synthetic */ FilterType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final FilterType FILTER_ADAPTIVE_FAST;
    public static final FilterType FILTER_ADAPTIVE_FULL;
    public static final FilterType FILTER_ADAPTIVE_MEDIUM;
    public static final FilterType FILTER_AGGRESSIVE;
    public static final FilterType FILTER_AVERAGE;
    public static final FilterType FILTER_CYCLIC;
    public static final FilterType FILTER_DEFAULT;
    public static final FilterType FILTER_NONE;
    public static final FilterType FILTER_PAETH;
    public static final FilterType FILTER_PRESERVE;
    public static final FilterType FILTER_SUB;
    public static final FilterType FILTER_SUPER_ADAPTIVE;
    public static final FilterType FILTER_UNKNOWN;
    public static final FilterType FILTER_UP;
    public static final FilterType FILTER_VERYAGGRESSIVE;
    public static HashMap<Integer, FilterType> byVal;
    public transient /* synthetic */ FieldHolder $fh;
    public final int val;

    static {
        InterceptResult invokeClinit;
        FilterType[] values;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1055445327, "Lcom/kwad/sdk/pngencrypt/FilterType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1055445327, "Lcom/kwad/sdk/pngencrypt/FilterType;");
                return;
            }
        }
        FILTER_NONE = new FilterType("FILTER_NONE", 0, 0);
        FILTER_SUB = new FilterType("FILTER_SUB", 1, 1);
        FILTER_UP = new FilterType("FILTER_UP", 2, 2);
        FILTER_AVERAGE = new FilterType("FILTER_AVERAGE", 3, 3);
        FILTER_PAETH = new FilterType("FILTER_PAETH", 4, 4);
        FILTER_DEFAULT = new FilterType("FILTER_DEFAULT", 5, -1);
        FILTER_AGGRESSIVE = new FilterType("FILTER_AGGRESSIVE", 6, -2);
        FILTER_VERYAGGRESSIVE = new FilterType("FILTER_VERYAGGRESSIVE", 7, -4);
        FILTER_ADAPTIVE_FULL = new FilterType("FILTER_ADAPTIVE_FULL", 8, -4);
        FILTER_ADAPTIVE_MEDIUM = new FilterType("FILTER_ADAPTIVE_MEDIUM", 9, -3);
        FILTER_ADAPTIVE_FAST = new FilterType("FILTER_ADAPTIVE_FAST", 10, -2);
        FILTER_SUPER_ADAPTIVE = new FilterType("FILTER_SUPER_ADAPTIVE", 11, -10);
        FILTER_PRESERVE = new FilterType("FILTER_PRESERVE", 12, -40);
        FILTER_CYCLIC = new FilterType("FILTER_CYCLIC", 13, -50);
        FilterType filterType = new FilterType("FILTER_UNKNOWN", 14, -100);
        FILTER_UNKNOWN = filterType;
        $VALUES = new FilterType[]{FILTER_NONE, FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH, FILTER_DEFAULT, FILTER_AGGRESSIVE, FILTER_VERYAGGRESSIVE, FILTER_ADAPTIVE_FULL, FILTER_ADAPTIVE_MEDIUM, FILTER_ADAPTIVE_FAST, FILTER_SUPER_ADAPTIVE, FILTER_PRESERVE, FILTER_CYCLIC, filterType};
        byVal = new HashMap<>();
        for (FilterType filterType2 : values()) {
            byVal.put(Integer.valueOf(filterType2.val), filterType2);
        }
    }

    public FilterType(String str, int i2, int i3) {
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
        this.val = i3;
    }

    public static FilterType[] getAllStandard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new FilterType[]{FILTER_NONE, FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH} : (FilterType[]) invokeV.objValue;
    }

    public static FilterType[] getAllStandardExceptNone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new FilterType[]{FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH} : (FilterType[]) invokeV.objValue;
    }

    public static FilterType[] getAllStandardForFirstRow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new FilterType[]{FILTER_SUB, FILTER_NONE} : (FilterType[]) invokeV.objValue;
    }

    public static FilterType[] getAllStandardNoneLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? new FilterType[]{FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH, FILTER_NONE} : (FilterType[]) invokeV.objValue;
    }

    public static FilterType getByVal(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? byVal.get(Integer.valueOf(i2)) : (FilterType) invokeI.objValue;
    }

    public static boolean isAdaptive(FilterType filterType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, filterType)) == null) {
            int i2 = filterType.val;
            return i2 <= -2 && i2 >= -4;
        }
        return invokeL.booleanValue;
    }

    public static boolean isValidStandard(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? i2 >= 0 && i2 <= 4 : invokeI.booleanValue;
    }

    public static boolean isValidStandard(FilterType filterType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, filterType)) == null) ? filterType != null && isValidStandard(filterType.val) : invokeL.booleanValue;
    }

    public static FilterType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? (FilterType) Enum.valueOf(FilterType.class, str) : (FilterType) invokeL.objValue;
    }

    public static FilterType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? (FilterType[]) $VALUES.clone() : (FilterType[]) invokeV.objValue;
    }
}
