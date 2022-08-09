package com.sdk.s;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sdk.f.g;
import com.sdk.q.f;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class a extends com.sdk.i.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "com.sdk.s.a";
    public static boolean isDebug;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1592780059, "Lcom/sdk/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1592780059, "Lcom/sdk/s/a;");
                return;
            }
        }
        isDebug = g.b;
    }

    public static String a(String str, String str2, TreeMap<String, Object> treeMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, treeMap)) == null) {
            if (treeMap == null) {
                return null;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append(str2);
                stringBuffer.append('?');
                for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
                    String key = entry.getKey();
                    StringBuilder sb = new StringBuilder();
                    sb.append(entry.getValue());
                    sb.append("");
                    String sb2 = sb.toString();
                    if (entry.getValue() != null && sb2.length() > 0 && !StringUtil.NULL_STRING.equals(sb2) && !"sign".equals(key) && !key.startsWith("_") && !"file".equals(key)) {
                        stringBuffer.append(key);
                        stringBuffer.append('=');
                        stringBuffer.append(entry.getValue());
                        stringBuffer.append('&');
                    }
                }
                if (stringBuffer.charAt(stringBuffer.length() - 1) == '&') {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                return f.a().b.a(stringBuffer.toString());
            } catch (Exception e) {
                com.sdk.n.a.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }
}
