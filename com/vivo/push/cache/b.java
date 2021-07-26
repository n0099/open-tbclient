package com.vivo.push.cache;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.p;
import com.vivo.push.util.z;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f39376a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f39377b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public e f39378c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(432263058, "Lcom/vivo/push/cache/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(432263058, "Lcom/vivo/push/cache/b;");
                return;
            }
        }
        f39376a = new Object();
    }

    public b() {
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

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f39377b == null) {
                synchronized (f39376a) {
                    if (f39377b == null) {
                        f39377b = new b();
                    }
                }
            }
            return f39377b;
        }
        return (b) invokeV.objValue;
    }

    public final e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            e eVar = this.f39378c;
            if (eVar != null) {
                return eVar;
            }
            try {
                String str = z.a(context) ? "com.vivo.push.cache.ServerConfigManagerImpl" : "com.vivo.push.cache.ClientConfigManagerImpl";
                Method method = Class.forName(str).getMethod("getInstance", Context.class);
                p.d("ConfigManagerFactory", "createConfig success is " + str);
                e eVar2 = (e) method.invoke(null, context);
                this.f39378c = eVar2;
                return eVar2;
            } catch (Exception e2) {
                e2.printStackTrace();
                p.b("ConfigManagerFactory", "createConfig error", e2);
                return null;
            }
        }
        return (e) invokeL.objValue;
    }
}
