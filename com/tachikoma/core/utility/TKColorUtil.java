package com.tachikoma.core.utility;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class TKColorUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TKColorUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int getOpacityFromColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            int i2 = i >>> 24;
            if (i2 == 255) {
                return -1;
            }
            return i2 == 0 ? -2 : -3;
        }
        return invokeI.intValue;
    }

    public static int multiplyColorAlpha(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) ? i2 == 255 ? i : i2 == 0 ? i & 16777215 : (i & 16777215) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24) : invokeII.intValue;
    }

    public static String rgba2argb(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.charAt(0) != '#' && (str.length() == 6 || str.length() == 8)) {
                str = "#" + str;
            }
            if (str.length() == 9) {
                String substring = str.substring(1, 7);
                return "#" + str.substring(7, 9) + substring;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
