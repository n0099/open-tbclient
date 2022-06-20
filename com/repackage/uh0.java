package com.repackage;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class uh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final uh0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(43536918, "Lcom/repackage/uh0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(43536918, "Lcom/repackage/uh0$b;");
                    return;
                }
            }
            a = new uh0(null);
        }
    }

    public /* synthetic */ uh0(a aVar) {
        this();
    }

    public static uh0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (uh0) invokeV.objValue;
    }

    public void b(ii0 ii0Var) {
        li0 li0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ii0Var) == null) || ii0Var == null || (li0Var = ii0Var.p) == null || ii0Var.q == null || TextUtils.isEmpty(li0Var.a)) {
            return;
        }
        ji0 ji0Var = ii0Var.q;
        long j = ji0Var.o;
        if (j < 0) {
            return;
        }
        String str = ii0Var.d;
        ji0Var.n = c01.b(j, System.currentTimeMillis());
        ClogBuilder l = new ClogBuilder().w(ClogBuilder.LogType.DOWNLOAD_KEEP).n(ii0Var.p.a).i(str).l(String.valueOf(ii0Var.q.n));
        JSONObject jSONObject = new JSONObject();
        try {
            PackageInfo packageInfo = bh0.b().getPackageManager().getPackageInfo(str, 0);
            l.j(packageInfo.versionName).k(String.valueOf(packageInfo.versionCode));
            lx0.d(jSONObject, "installed", 1);
        } catch (PackageManager.NameNotFoundException unused) {
            lx0.d(jSONObject, "installed", 0);
            ii0Var.q.o = -2L;
        } catch (Throwable unused2) {
            return;
        }
        l.m(jSONObject.toString());
        vx0.c(l);
        yh0.a().c(ii0Var);
    }

    public uh0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
