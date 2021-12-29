package com.sdk.base.framework.f.j;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.f.i.e;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;
/* loaded from: classes3.dex */
public class a extends com.sdk.base.framework.f.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.base.framework.f.j.a";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f61602b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1065982088, "Lcom/sdk/base/framework/f/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1065982088, "Lcom/sdk/base/framework/f/j/a;");
                return;
            }
        }
        f61602b = f.f61569b;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x0035: INVOKE  (r3v0 java.lang.Object A[REMOVE]) = (r5v4 java.util.Map$Entry<java.lang.String, java.lang.Object>) type: INTERFACE call: java.util.Map.Entry.getValue():java.lang.Object)] */
    public static String a(String str, String str2, TreeMap<String, Object> treeMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, treeMap)) == null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append(str2);
                stringBuffer.append('?');
                for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
                    String key = entry.getKey();
                    StringBuilder sb = new StringBuilder();
                    sb.append(entry.getValue());
                    String sb2 = sb.toString();
                    if (entry.getValue() != null && sb2.length() > 0 && !StringUtil.NULL_STRING.equals(sb2) && !"sign".equals(key) && !key.startsWith("_") && !"file".equals(key)) {
                        stringBuffer.append(key);
                        stringBuffer.append(com.alipay.sdk.encrypt.a.f31864h);
                        stringBuffer.append(entry.getValue());
                        stringBuffer.append(Typography.amp);
                    }
                }
                if (stringBuffer.charAt(stringBuffer.length() - 1) == '&') {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                return e.a(stringBuffer.toString());
            } catch (Exception e2) {
                c.b(a, e2.getMessage(), Boolean.valueOf(f61602b));
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }
}
