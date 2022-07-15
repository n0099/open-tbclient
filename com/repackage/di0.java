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
public class di0 {
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
        public static final di0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-442235128, "Lcom/repackage/di0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-442235128, "Lcom/repackage/di0$b;");
                    return;
                }
            }
            a = new di0(null);
        }
    }

    public /* synthetic */ di0(a aVar) {
        this();
    }

    public static di0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (di0) invokeV.objValue;
    }

    public void b(si0 si0Var) {
        wi0 wi0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, si0Var) == null) || si0Var == null || (wi0Var = si0Var.p) == null || si0Var.q == null || TextUtils.isEmpty(wi0Var.a)) {
            return;
        }
        ti0 ti0Var = si0Var.q;
        long j = ti0Var.p;
        if (j < 0) {
            return;
        }
        String str = si0Var.d;
        ti0Var.o = p01.c(j, System.currentTimeMillis());
        ClogBuilder n = new ClogBuilder().y(ClogBuilder.LogType.DOWNLOAD_KEEP).p(si0Var.p.a).k(str).n(String.valueOf(si0Var.q.o));
        JSONObject jSONObject = new JSONObject();
        try {
            PackageInfo packageInfo = hh0.b().getPackageManager().getPackageInfo(str, 0);
            n.l(packageInfo.versionName).m(String.valueOf(packageInfo.versionCode));
            yx0.d(jSONObject, "installed", 1);
        } catch (PackageManager.NameNotFoundException unused) {
            yx0.d(jSONObject, "installed", 0);
            si0Var.q.p = -2L;
        } catch (Throwable unused2) {
            return;
        }
        n.o(jSONObject.toString());
        iy0.b(n);
        ii0.a().c(si0Var);
    }

    public di0() {
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
