package com.repackage;

import android.net.Uri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class a90 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String... strArr) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, strArr)) == null) {
            if (strArr == null) {
                return str;
            }
            HashSet hashSet = new HashSet(Uri.parse(str).getQueryParameterNames());
            for (String str2 : strArr) {
                hashSet.remove(str2);
            }
            StringBuilder sb = new StringBuilder();
            if (str.contains("?")) {
                sb.append(str.substring(0, str.indexOf("?")));
            } else {
                sb.append(str);
            }
            sb.append("?");
            if (hashSet.size() > 0 && (indexOf = str.indexOf("&")) > 0) {
                sb.append(str.substring(indexOf));
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
