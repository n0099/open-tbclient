package com.yy.gslbsdk.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class IPTools {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IPTools() {
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

    public static String hosts2String(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, strArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(strArr[i2]);
                if (i2 < length - 1) {
                    sb.append('|');
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean isHost(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null || str.length() < 1 || str.contains(":")) {
                return false;
            }
            if (7 <= str.length() && str.length() <= 15) {
                int i2 = 0;
                while (true) {
                    if (i2 >= str.length()) {
                        z = true;
                        break;
                    } else if (str.charAt(i2) != '.' && !Character.isDigit(str.charAt(i2))) {
                        z = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isValidIP(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? str.matches("((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)") : invokeL.booleanValue;
    }
}
