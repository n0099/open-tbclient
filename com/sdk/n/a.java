package com.sdk.n;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.f.f;
import java.util.Properties;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "a";
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1592929014, "Lcom/sdk/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1592929014, "Lcom/sdk/n/a;");
                return;
            }
        }
        b = f.a;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (com.sdk.o.a.a(str2).booleanValue()) {
                return null;
            }
            Properties properties = new Properties();
            try {
                properties.load(SDKManager.mContext.getAssets().open(str));
            } catch (Exception unused) {
                String str3 = a;
                com.sdk.o.a.a(str3, "域名读取失败！《" + str2 + "+》", Boolean.valueOf(b));
            }
            return properties.getProperty(str2);
        }
        return (String) invokeLL.objValue;
    }
}
