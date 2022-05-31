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
import com.repackage.nk2;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes6.dex */
public final class mk2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static final Map<String, mk2> e;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> a;
    public final nk2 b;
    public final String c;

    /* loaded from: classes6.dex */
    public class a implements ae3<nk2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mk2 a;

        public a(mk2 mk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mk2Var;
        }

        public final void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && mk2.d) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: b */
        public void onCallback(nk2 nk2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nk2Var) == null) && mk2.d) {
                c();
            }
        }

        public final synchronized void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    a("SwanLaunch", "\n\n\n");
                    a("SwanLaunch", ">>>>>> SWAN Launch Log For " + this.a.c);
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : this.a.a.entrySet()) {
                        sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                    }
                    for (nk2.b bVar : this.a.b.i()) {
                        StringBuilder sb2 = new StringBuilder();
                        for (String str : bVar.b) {
                            sb2.append(str);
                            sb2.append(" ");
                        }
                        for (String str2 : bVar.a) {
                            String h = this.a.b.h();
                            a(TextUtils.isEmpty(bVar.c) ? h : bVar.c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h, sb, sb2, str2));
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755496483, "Lcom/repackage/mk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755496483, "Lcom/repackage/mk2;");
                return;
            }
        }
        d = rf1.a;
        e = new HashMap();
    }

    public mk2(String str) {
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
        nk2 nk2Var = new nk2();
        nk2Var.g("SwanLaunch");
        nk2Var.l(c());
        this.b = nk2Var;
        this.c = str;
    }

    public static mk2 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            mk2 mk2Var = e.get(str);
            if (mk2Var == null) {
                mk2 mk2Var2 = new mk2(str);
                e.put(str, mk2Var2);
                return mk2Var2;
            }
            return mk2Var;
        }
        return (mk2) invokeL.objValue;
    }

    public final ae3<nk2> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (ae3) invokeV.objValue;
    }

    public nk2.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b.d() : (nk2.b) invokeV.objValue;
    }

    public nk2.b f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.b.e(str) : (nk2.b) invokeL.objValue;
    }

    public nk2.b g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? this.b.f(str, str2) : (nk2.b) invokeLL.objValue;
    }

    public synchronized mk2 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                this.b.j();
            }
            return this;
        }
        return (mk2) invokeV.objValue;
    }
}
