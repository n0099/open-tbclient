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
public class zh0 {
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
        public static final zh0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(186682673, "Lcom/repackage/zh0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(186682673, "Lcom/repackage/zh0$b;");
                    return;
                }
            }
            a = new zh0(null);
        }
    }

    public /* synthetic */ zh0(a aVar) {
        this();
    }

    public static zh0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (zh0) invokeV.objValue;
    }

    public void b(oi0 oi0Var) {
        si0 si0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oi0Var) == null) || oi0Var == null || (si0Var = oi0Var.p) == null || oi0Var.q == null || TextUtils.isEmpty(si0Var.a)) {
            return;
        }
        pi0 pi0Var = oi0Var.q;
        long j = pi0Var.p;
        if (j < 0) {
            return;
        }
        String str = oi0Var.d;
        pi0Var.o = o01.c(j, System.currentTimeMillis());
        ClogBuilder n = new ClogBuilder().y(ClogBuilder.LogType.DOWNLOAD_KEEP).p(oi0Var.p.a).k(str).n(String.valueOf(oi0Var.q.o));
        JSONObject jSONObject = new JSONObject();
        try {
            PackageInfo packageInfo = dh0.b().getPackageManager().getPackageInfo(str, 0);
            n.l(packageInfo.versionName).m(String.valueOf(packageInfo.versionCode));
            xx0.d(jSONObject, "installed", 1);
        } catch (PackageManager.NameNotFoundException unused) {
            xx0.d(jSONObject, "installed", 0);
            oi0Var.q.p = -2L;
        } catch (Throwable unused2) {
            return;
        }
        n.o(jSONObject.toString());
        hy0.b(n);
        ei0.a().c(oi0Var);
    }

    public zh0() {
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
