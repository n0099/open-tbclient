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
/* loaded from: classes10.dex */
public final class y implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f76333a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Long> f76334b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f76335c;

    /* renamed from: d  reason: collision with root package name */
    public static y f76336d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f76337e;

    /* renamed from: f  reason: collision with root package name */
    public c f76338f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f76339g;

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
        f76333a = new HashMap<>();
        f76334b = new HashMap<>();
        f76335c = new HashMap<>();
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
        this.f76339g = false;
        this.f76337e = context;
        this.f76339g = a(context);
        p.d("SystemCache", "init status is " + this.f76339g + ";  curCache is " + this.f76338f);
    }

    public static synchronized y b(Context context) {
        InterceptResult invokeL;
        y yVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (y.class) {
                if (f76336d == null) {
                    f76336d = new y(context.getApplicationContext());
                }
                yVar = f76336d;
            }
            return yVar;
        }
        return (y) invokeL.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            x xVar = new x();
            if (xVar.a(this.f76337e)) {
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
            f76335c.put(str, str2);
            if (!this.f76339g || (cVar = this.f76338f) == null) {
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
            this.f76338f = vVar;
            boolean a2 = vVar.a(context);
            if (!a2) {
                u uVar = new u();
                this.f76338f = uVar;
                a2 = uVar.a(context);
            }
            if (!a2) {
                x xVar = new x();
                this.f76338f = xVar;
                a2 = xVar.a(context);
            }
            if (!a2) {
                this.f76338f = null;
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
            String str3 = f76335c.get(str);
            return (str3 != null || (cVar = this.f76338f) == null) ? str3 : cVar.a(str, str2);
        }
        return (String) invokeLL.objValue;
    }
}
