package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            String urlDecode = li.getUrlDecode(str);
            if (urlDecode == null) {
                return urlDecode;
            }
            int lastIndexOf = urlDecode.lastIndexOf("/");
            if (lastIndexOf == -1 || (indexOf = urlDecode.indexOf(".", lastIndexOf)) == -1) {
                return null;
            }
            return urlDecode.substring(lastIndexOf + 1, indexOf);
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            String urlDecode = li.getUrlDecode(str);
            return !StringUtils.isNull(urlDecode) && urlDecode.contains("?t=");
        }
        return invokeL.booleanValue;
    }
}
