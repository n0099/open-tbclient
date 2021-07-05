package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f32670a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f32671b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f32672c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1740631709, "Lcom/fun/openid/sdk/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1740631709, "Lcom/fun/openid/sdk/m;");
                return;
            }
        }
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f32671b = cls;
            f32670a = cls.newInstance();
            f32671b.getMethod("getUDID", Context.class);
            f32672c = f32671b.getMethod("getOAID", Context.class);
            f32671b.getMethod("getVAID", Context.class);
            f32671b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }
}
