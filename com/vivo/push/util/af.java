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
/* loaded from: classes8.dex */
public final class af implements e {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, Integer> a;
    public static final HashMap<String, Long> b;
    public static final HashMap<String, String> c;
    public static af d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context e;
    public e f;
    public boolean g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1594687221, "Lcom/vivo/push/util/af;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1594687221, "Lcom/vivo/push/util/af;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
        c = new HashMap<>();
    }

    public af(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = false;
        this.e = context;
        this.g = a(context);
        u.d("SystemCache", "init status is " + this.g + ";  curCache is " + this.f);
    }

    public static synchronized af b(Context context) {
        InterceptResult invokeL;
        af afVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (af.class) {
                if (d == null) {
                    d = new af(context.getApplicationContext());
                }
                afVar = d;
            }
            return afVar;
        }
        return (af) invokeL.objValue;
    }

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            ac acVar = new ac();
            this.f = acVar;
            boolean a2 = acVar.a(context);
            if (!a2) {
                ae aeVar = new ae();
                this.f = aeVar;
                a2 = aeVar.a(context);
            }
            if (!a2) {
                this.f = null;
            }
            return a2;
        }
        return invokeL.booleanValue;
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        InterceptResult invokeLL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String str3 = c.get(str);
            if (str3 == null && (eVar = this.f) != null) {
                return eVar.a(str, str2);
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.vivo.push.util.e
    public final void b(String str, String str2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            c.put(str, str2);
            if (this.g && (eVar = this.f) != null) {
                eVar.b(str, str2);
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ae aeVar = new ae();
            if (!aeVar.a(this.e)) {
                return;
            }
            aeVar.a();
            u.d("SystemCache", "sp cache is cleared");
        }
    }
}
