package com.fun.openid.sdk;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes11.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f62906a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f62907b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f62908c;
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
            f62907b = cls;
            f62906a = cls.newInstance();
            f62907b.getMethod("getUDID", Context.class);
            f62908c = f62907b.getMethod("getOAID", Context.class);
            f62907b.getMethod("getVAID", Context.class);
            f62907b.getMethod("getAAID", Context.class);
        } catch (Exception unused) {
        }
    }
}
