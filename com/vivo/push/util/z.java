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
    public static final HashMap<String, Long> f60779b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f60780c;

    /* renamed from: d  reason: collision with root package name */
    public static z f60781d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f60782e;

    /* renamed from: f  reason: collision with root package name */
    public d f60783f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60784g;

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
        f60779b = new HashMap<>();
        f60780c = new HashMap<>();
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
        this.f60784g = false;
        this.f60782e = context;
        this.f60784g = a(context);
        p.d("SystemCache", "init status is " + this.f60784g + ";  curCache is " + this.f60783f);
    }

    public static synchronized z b(Context context) {
        InterceptResult invokeL;
        z zVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (z.class) {
                if (f60781d == null) {
                    f60781d = new z(context.getApplicationContext());
                }
                zVar = f60781d;
            }
            return zVar;
        }
        return (z) invokeL.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            y yVar = new y();
            if (yVar.a(this.f60782e)) {
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
            f60780c.put(str, str2);
            if (!this.f60784g || (dVar = this.f60783f) == null) {
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
            this.f60783f = wVar;
            boolean a2 = wVar.a(context);
            if (!a2) {
                v vVar = new v();
                this.f60783f = vVar;
                a2 = vVar.a(context);
            }
            if (!a2) {
                y yVar = new y();
                this.f60783f = yVar;
                a2 = yVar.a(context);
            }
            if (!a2) {
                this.f60783f = null;
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
            String str3 = f60780c.get(str);
            return (str3 != null || (dVar = this.f60783f) == null) ? str3 : dVar.a(str, str2);
        }
        return (String) invokeLL.objValue;
    }
}
