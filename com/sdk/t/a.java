package com.sdk.t;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sdk.f.f;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes8.dex */
public class a extends com.sdk.i.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.t.a";
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1592750268, "Lcom/sdk/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1592750268, "Lcom/sdk/t/a;");
                return;
            }
        }
        b = f.a;
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
                stringBuffer.append(RFC1522Codec.SEP);
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
                return com.sdk.r.f.a().b.a(stringBuffer.toString());
            } catch (Exception e) {
                com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }
}
