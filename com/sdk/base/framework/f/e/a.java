package com.sdk.base.framework.f.e;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import com.sdk.base.module.manager.SDKManager;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f75932a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f75933b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1065833133, "Lcom/sdk/base/framework/f/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1065833133, "Lcom/sdk/base/framework/f/e/a;");
                return;
            }
        }
        f75933b = f.f75904b;
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

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (c.a(str2).booleanValue()) {
                return null;
            }
            Properties properties = new Properties();
            try {
                properties.load(SDKManager.getContext().getAssets().open(str));
            } catch (IOException unused) {
                String str3 = f75932a;
                c.b(str3, "域名读取失败！《" + str2 + "+》", Boolean.valueOf(f75933b));
            }
            return properties.getProperty(str2);
        }
        return (String) invokeLL.objValue;
    }
}
