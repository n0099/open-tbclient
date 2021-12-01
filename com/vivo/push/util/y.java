package com.vivo.push.util;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class y implements c {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Long> f62569b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f62570c;

    /* renamed from: d  reason: collision with root package name */
    public static y f62571d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f62572e;

    /* renamed from: f  reason: collision with root package name */
    public c f62573f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62574g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(744178883, "Lcom/vivo/push/util/y;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(744178883, "Lcom/vivo/push/util/y;");
                return;
            }
        }
        a = new HashMap<>();
        f62569b = new HashMap<>();
        f62570c = new HashMap<>();
    }

    public y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f62574g = false;
        this.f62572e = context;
        this.f62574g = a(context);
        p.d("SystemCache", "init status is " + this.f62574g + ";  curCache is " + this.f62573f);
    }

    public static synchronized y b(Context context) {
        InterceptResult invokeL;
        y yVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (y.class) {
                if (f62571d == null) {
                    f62571d = new y(context.getApplicationContext());
                }
                yVar = f62571d;
            }
            return yVar;
        }
        return (y) invokeL.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            x xVar = new x();
            if (xVar.a(this.f62572e)) {
                xVar.a();
                p.d("SystemCache", "sp cache is cleared");
            }
        }
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            f62570c.put(str, str2);
            if (!this.f62574g || (cVar = this.f62573f) == null) {
                return;
            }
            cVar.b(str, str2);
        }
    }

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            v vVar = new v();
            this.f62573f = vVar;
            boolean a2 = vVar.a(context);
            if (!a2) {
                u uVar = new u();
                this.f62573f = uVar;
                a2 = uVar.a(context);
            }
            if (!a2) {
                x xVar = new x();
                this.f62573f = xVar;
                a2 = xVar.a(context);
            }
            if (!a2) {
                this.f62573f = null;
            }
            return a2;
        }
        return invokeL.booleanValue;
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        InterceptResult invokeLL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String str3 = f62570c.get(str);
            return (str3 != null || (cVar = this.f62573f) == null) ? str3 : cVar.a(str, str2);
        }
        return (String) invokeLL.objValue;
    }
}
