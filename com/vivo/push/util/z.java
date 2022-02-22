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
/* loaded from: classes4.dex */
public final class z implements d {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Long> f60991b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f60992c;

    /* renamed from: d  reason: collision with root package name */
    public static z f60993d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f60994e;

    /* renamed from: f  reason: collision with root package name */
    public d f60995f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60996g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(744178914, "Lcom/vivo/push/util/z;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(744178914, "Lcom/vivo/push/util/z;");
                return;
            }
        }
        a = new HashMap<>();
        f60991b = new HashMap<>();
        f60992c = new HashMap<>();
    }

    public z(Context context) {
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
        this.f60996g = false;
        this.f60994e = context;
        this.f60996g = a(context);
        p.d("SystemCache", "init status is " + this.f60996g + ";  curCache is " + this.f60995f);
    }

    public static synchronized z b(Context context) {
        InterceptResult invokeL;
        z zVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (z.class) {
                if (f60993d == null) {
                    f60993d = new z(context.getApplicationContext());
                }
                zVar = f60993d;
            }
            return zVar;
        }
        return (z) invokeL.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            y yVar = new y();
            if (yVar.a(this.f60994e)) {
                yVar.a();
                p.d("SystemCache", "sp cache is cleared");
            }
        }
    }

    @Override // com.vivo.push.util.d
    public final void b(String str, String str2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            f60992c.put(str, str2);
            if (!this.f60996g || (dVar = this.f60995f) == null) {
                return;
            }
            dVar.b(str, str2);
        }
    }

    @Override // com.vivo.push.util.d
    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            w wVar = new w();
            this.f60995f = wVar;
            boolean a2 = wVar.a(context);
            if (!a2) {
                v vVar = new v();
                this.f60995f = vVar;
                a2 = vVar.a(context);
            }
            if (!a2) {
                y yVar = new y();
                this.f60995f = yVar;
                a2 = yVar.a(context);
            }
            if (!a2) {
                this.f60995f = null;
            }
            return a2;
        }
        return invokeL.booleanValue;
    }

    @Override // com.vivo.push.util.d
    public final String a(String str, String str2) {
        InterceptResult invokeLL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String str3 = f60992c.get(str);
            return (str3 != null || (dVar = this.f60995f) == null) ? str3 : dVar.a(str, str2);
        }
        return (String) invokeLL.objValue;
    }
}
