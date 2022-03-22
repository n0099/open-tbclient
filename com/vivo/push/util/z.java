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
/* loaded from: classes7.dex */
public final class z implements d {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Long> f43972b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f43973c;

    /* renamed from: d  reason: collision with root package name */
    public static z f43974d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f43975e;

    /* renamed from: f  reason: collision with root package name */
    public d f43976f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43977g;

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
        f43972b = new HashMap<>();
        f43973c = new HashMap<>();
    }

    public z(Context context) {
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
        this.f43977g = false;
        this.f43975e = context;
        this.f43977g = a(context);
        p.d("SystemCache", "init status is " + this.f43977g + ";  curCache is " + this.f43976f);
    }

    public static synchronized z b(Context context) {
        InterceptResult invokeL;
        z zVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (z.class) {
                if (f43974d == null) {
                    f43974d = new z(context.getApplicationContext());
                }
                zVar = f43974d;
            }
            return zVar;
        }
        return (z) invokeL.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            y yVar = new y();
            if (yVar.a(this.f43975e)) {
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
            f43973c.put(str, str2);
            if (!this.f43977g || (dVar = this.f43976f) == null) {
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
            this.f43976f = wVar;
            boolean a2 = wVar.a(context);
            if (!a2) {
                v vVar = new v();
                this.f43976f = vVar;
                a2 = vVar.a(context);
            }
            if (!a2) {
                y yVar = new y();
                this.f43976f = yVar;
                a2 = yVar.a(context);
            }
            if (!a2) {
                this.f43976f = null;
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
            String str3 = f43973c.get(str);
            return (str3 != null || (dVar = this.f43976f) == null) ? str3 : dVar.a(str, str2);
        }
        return (String) invokeLL.objValue;
    }
}
