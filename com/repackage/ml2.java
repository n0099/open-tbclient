package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nl2;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes6.dex */
public final class ml2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static final Map<String, ml2> e;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> a;
    public final nl2 b;
    public final String c;

    /* loaded from: classes6.dex */
    public class a implements af3<nl2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ml2 a;

        public a(ml2 ml2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ml2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ml2Var;
        }

        public final void b(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && ml2.d) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: c */
        public void a(nl2 nl2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nl2Var) == null) && ml2.d) {
                d();
            }
        }

        public final synchronized void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    b("SwanLaunch", "\n\n\n");
                    b("SwanLaunch", ">>>>>> SWAN Launch Log For " + this.a.c);
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : this.a.a.entrySet()) {
                        sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                    }
                    for (nl2.b bVar : this.a.b.i()) {
                        StringBuilder sb2 = new StringBuilder();
                        for (String str : bVar.b) {
                            sb2.append(str);
                            sb2.append(" ");
                        }
                        for (String str2 : bVar.a) {
                            String h = this.a.b.h();
                            b(TextUtils.isEmpty(bVar.c) ? h : bVar.c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h, sb, sb2, str2));
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755495522, "Lcom/repackage/ml2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755495522, "Lcom/repackage/ml2;");
                return;
            }
        }
        d = rg1.a;
        e = new HashMap();
    }

    public ml2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        nl2 nl2Var = new nl2();
        nl2Var.g("SwanLaunch");
        nl2Var.l(c());
        this.b = nl2Var;
        this.c = str;
    }

    public static ml2 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            ml2 ml2Var = e.get(str);
            if (ml2Var == null) {
                ml2 ml2Var2 = new ml2(str);
                e.put(str, ml2Var2);
                return ml2Var2;
            }
            return ml2Var;
        }
        return (ml2) invokeL.objValue;
    }

    public final af3<nl2> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (af3) invokeV.objValue;
    }

    public nl2.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b.d() : (nl2.b) invokeV.objValue;
    }

    public nl2.b f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.b.e(str) : (nl2.b) invokeL.objValue;
    }

    public nl2.b g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? this.b.f(str, str2) : (nl2.b) invokeLL.objValue;
    }

    public synchronized ml2 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                this.b.j();
            }
            return this;
        }
        return (ml2) invokeV.objValue;
    }
}
