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
    public static final HashMap<String, Integer> f76534a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Long> f76535b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f76536c;

    /* renamed from: d  reason: collision with root package name */
    public static y f76537d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f76538e;

    /* renamed from: f  reason: collision with root package name */
    public c f76539f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f76540g;

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
        f76534a = new HashMap<>();
        f76535b = new HashMap<>();
        f76536c = new HashMap<>();
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
        this.f76540g = false;
        this.f76538e = context;
        this.f76540g = a(context);
        p.d("SystemCache", "init status is " + this.f76540g + ";  curCache is " + this.f76539f);
    }

    public static synchronized y b(Context context) {
        InterceptResult invokeL;
        y yVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (y.class) {
                if (f76537d == null) {
                    f76537d = new y(context.getApplicationContext());
                }
                yVar = f76537d;
            }
            return yVar;
        }
        return (y) invokeL.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            x xVar = new x();
            if (xVar.a(this.f76538e)) {
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
            f76536c.put(str, str2);
            if (!this.f76540g || (cVar = this.f76539f) == null) {
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
            this.f76539f = vVar;
            boolean a2 = vVar.a(context);
            if (!a2) {
                u uVar = new u();
                this.f76539f = uVar;
                a2 = uVar.a(context);
            }
            if (!a2) {
                x xVar = new x();
                this.f76539f = xVar;
                a2 = xVar.a(context);
            }
            if (!a2) {
                this.f76539f = null;
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
            String str3 = f76536c.get(str);
            return (str3 != null || (cVar = this.f76539f) == null) ? str3 : cVar.a(str, str2);
        }
        return (String) invokeLL.objValue;
    }
}
