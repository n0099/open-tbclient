package com.fun.openid.sdk;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public static Object a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f54210b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f54211c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1740631678, "Lcom/fun/openid/sdk/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1740631678, "Lcom/fun/openid/sdk/n;");
                return;
            }
        }
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f54210b = cls;
            a = cls.newInstance();
            f54210b.getMethod("getUDID", Context.class);
            f54211c = f54210b.getMethod("getOAID", Context.class);
            f54210b.getMethod("getVAID", Context.class);
            f54210b.getMethod("getAAID", Context.class);
        } catch (Exception unused) {
        }
    }
}
