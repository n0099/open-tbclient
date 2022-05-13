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
/* loaded from: classes5.dex */
public class dj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final dj0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-441311607, "Lcom/repackage/dj0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-441311607, "Lcom/repackage/dj0$b;");
                    return;
                }
            }
            a = new dj0(null);
        }
    }

    public /* synthetic */ dj0(a aVar) {
        this();
    }

    public static dj0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (dj0) invokeV.objValue;
    }

    public void b(rj0 rj0Var) {
        uj0 uj0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, rj0Var) == null) || rj0Var == null || (uj0Var = rj0Var.p) == null || rj0Var.q == null || TextUtils.isEmpty(uj0Var.a)) {
            return;
        }
        sj0 sj0Var = rj0Var.q;
        long j = sj0Var.o;
        if (j < 0) {
            return;
        }
        String str = rj0Var.d;
        sj0Var.n = l11.b(j, System.currentTimeMillis());
        ClogBuilder l = new ClogBuilder().w(ClogBuilder.LogType.DOWNLOAD_KEEP).n(rj0Var.p.a).i(str).l(String.valueOf(rj0Var.q.n));
        JSONObject jSONObject = new JSONObject();
        try {
            PackageInfo packageInfo = ki0.b().getPackageManager().getPackageInfo(str, 0);
            l.j(packageInfo.versionName).k(String.valueOf(packageInfo.versionCode));
            uy0.d(jSONObject, "installed", 1);
        } catch (PackageManager.NameNotFoundException unused) {
            uy0.d(jSONObject, "installed", 0);
            rj0Var.q.o = -2L;
        } catch (Throwable unused2) {
            return;
        }
        l.m(jSONObject.toString());
        ez0.c(l);
        hj0.a().c(rj0Var);
    }

    public dj0() {
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
