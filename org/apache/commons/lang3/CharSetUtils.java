package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class CharSetUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CharSetUtils() {
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

    public static boolean containsAny(String str, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, strArr)) == null) {
            if (!StringUtils.isEmpty(str) && !deepEmpty(strArr)) {
                CharSet charSet = CharSet.getInstance(strArr);
                for (char c2 : str.toCharArray()) {
                    if (charSet.contains(c2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int count(String str, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, strArr)) == null) {
            if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
                return 0;
            }
            CharSet charSet = CharSet.getInstance(strArr);
            int i2 = 0;
            for (char c2 : str.toCharArray()) {
                if (charSet.contains(c2)) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public static boolean deepEmpty(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, strArr)) == null) {
            if (strArr != null) {
                for (String str : strArr) {
                    if (StringUtils.isNotEmpty(str)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String delete(String str, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, strArr)) == null) ? (StringUtils.isEmpty(str) || deepEmpty(strArr)) ? str : modify(str, strArr, false) : (String) invokeLL.objValue;
    }

    public static String keep(String str, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, strArr)) == null) {
            if (str == null) {
                return null;
            }
            return (str.isEmpty() || deepEmpty(strArr)) ? "" : modify(str, strArr, true);
        }
        return (String) invokeLL.objValue;
    }

    public static String modify(String str, String[] strArr, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, str, strArr, z)) == null) {
            CharSet charSet = CharSet.getInstance(strArr);
            StringBuilder sb = new StringBuilder(str.length());
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (charSet.contains(charArray[i2]) == z) {
                    sb.append(charArray[i2]);
                }
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    public static String squeeze(String str, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, strArr)) == null) {
            if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
                return str;
            }
            CharSet charSet = CharSet.getInstance(strArr);
            StringBuilder sb = new StringBuilder(str.length());
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            char c2 = charArray[0];
            sb.append(c2);
            Character ch = null;
            Character ch2 = null;
            for (int i2 = 1; i2 < length; i2++) {
                char c3 = charArray[i2];
                if (c3 == c2) {
                    if (ch == null || c3 != ch.charValue()) {
                        if (ch2 == null || c3 != ch2.charValue()) {
                            if (charSet.contains(c3)) {
                                ch = Character.valueOf(c3);
                            } else {
                                ch2 = Character.valueOf(c3);
                            }
                        }
                    }
                }
                sb.append(c3);
                c2 = c3;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
