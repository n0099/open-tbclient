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
/* loaded from: classes6.dex */
public class qh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final qh0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-70979686, "Lcom/repackage/qh0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-70979686, "Lcom/repackage/qh0$b;");
                    return;
                }
            }
            a = new qh0(null);
        }
    }

    public /* synthetic */ qh0(a aVar) {
        this();
    }

    public static qh0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (qh0) invokeV.objValue;
    }

    public void b(ei0 ei0Var) {
        hi0 hi0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ei0Var) == null) || ei0Var == null || (hi0Var = ei0Var.p) == null || ei0Var.q == null || TextUtils.isEmpty(hi0Var.a)) {
            return;
        }
        fi0 fi0Var = ei0Var.q;
        long j = fi0Var.o;
        if (j < 0) {
            return;
        }
        String str = ei0Var.d;
        fi0Var.n = yz0.b(j, System.currentTimeMillis());
        ClogBuilder l = new ClogBuilder().w(ClogBuilder.LogType.DOWNLOAD_KEEP).n(ei0Var.p.a).i(str).l(String.valueOf(ei0Var.q.n));
        JSONObject jSONObject = new JSONObject();
        try {
            PackageInfo packageInfo = xg0.b().getPackageManager().getPackageInfo(str, 0);
            l.j(packageInfo.versionName).k(String.valueOf(packageInfo.versionCode));
            hx0.d(jSONObject, "installed", 1);
        } catch (PackageManager.NameNotFoundException unused) {
            hx0.d(jSONObject, "installed", 0);
            ei0Var.q.o = -2L;
        } catch (Throwable unused2) {
            return;
        }
        l.m(jSONObject.toString());
        rx0.c(l);
        uh0.a().c(ei0Var);
    }

    public qh0() {
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
