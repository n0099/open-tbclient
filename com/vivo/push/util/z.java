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
    public static final HashMap<String, Long> f60824b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f60825c;

    /* renamed from: d  reason: collision with root package name */
    public static z f60826d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f60827e;

    /* renamed from: f  reason: collision with root package name */
    public d f60828f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60829g;

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
        f60824b = new HashMap<>();
        f60825c = new HashMap<>();
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
        this.f60829g = false;
        this.f60827e = context;
        this.f60829g = a(context);
        p.d("SystemCache", "init status is " + this.f60829g + ";  curCache is " + this.f60828f);
    }

    public static synchronized z b(Context context) {
        InterceptResult invokeL;
        z zVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (z.class) {
                if (f60826d == null) {
                    f60826d = new z(context.getApplicationContext());
                }
                zVar = f60826d;
            }
            return zVar;
        }
        return (z) invokeL.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            y yVar = new y();
            if (yVar.a(this.f60827e)) {
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
            f60825c.put(str, str2);
            if (!this.f60829g || (dVar = this.f60828f) == null) {
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
            this.f60828f = wVar;
            boolean a2 = wVar.a(context);
            if (!a2) {
                v vVar = new v();
                this.f60828f = vVar;
                a2 = vVar.a(context);
            }
            if (!a2) {
                y yVar = new y();
                this.f60828f = yVar;
                a2 = yVar.a(context);
            }
            if (!a2) {
                this.f60828f = null;
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
            String str3 = f60825c.get(str);
            return (str3 != null || (dVar = this.f60828f) == null) ? str3 : dVar.a(str, str2);
        }
        return (String) invokeLL.objValue;
    }
}
