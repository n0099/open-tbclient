package com.tachikoma.core.utility;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TKColorUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TKColorUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int getOpacityFromColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            int i3 = i2 >>> 24;
            if (i3 == 255) {
                return -1;
            }
            return i3 == 0 ? -2 : -3;
        }
        return invokeI.intValue;
    }

    public static int multiplyColorAlpha(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) ? i3 == 255 ? i2 : i3 == 0 ? i2 & 16777215 : (i2 & 16777215) | ((((i2 >>> 24) * (i3 + (i3 >> 7))) >> 8) << 24) : invokeII.intValue;
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
