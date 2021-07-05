package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes7.dex */
public final class aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(@NonNull String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, map)) == null) {
            if (map == null || map.size() <= 0) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : map.keySet()) {
                if (map.get(str2) != null) {
                    sb.append(str2);
                    sb.append("=");
                    sb.append(map.get(str2));
                    sb.append("&");
                }
            }
            String sb2 = sb.toString();
            String substring = sb2.substring(0, sb2.length() - 1);
            if (str.contains("?")) {
                return str + "&" + substring;
            }
            return str + "?" + substring;
        }
        return (String) invokeLL.objValue;
    }
}
