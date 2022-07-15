package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class mv2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755485912, "Lcom/repackage/mv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755485912, "Lcom/repackage/mv2;");
                return;
            }
        }
        a = rg1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, swanAppConfigData) == null) || swanAppConfigData == null) {
            return;
        }
        List<bw2> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (wa2.k()) {
                boolean z = false;
                for (bw2 bw2Var : e) {
                    String h = wa2.h(bw2Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        bw2Var.e = h;
                        c(jSONObject, jSONObject2, bw2Var);
                        z = true;
                        hx1.i("Module-Plugin", "use debug dependencies，name=" + bw2Var.a + " path=" + bw2Var.e);
                    } else {
                        hx1.o("Module-Plugin", "debug dependencies not exist，name=" + bw2Var.a + " path=" + bw2Var.e);
                    }
                }
                if (!z) {
                    zz2.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    hx1.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            fw2.c("dependenciesPath", jSONObject3);
            fw2.c("dependenciesConfig", jSONObject4);
            return;
        }
        fw2.c("dependenciesPath", null);
        fw2.c("dependenciesConfig", null);
        if (a) {
            zv2.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<bw2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) == null) || list.isEmpty()) {
            return;
        }
        for (bw2 bw2Var : list) {
            if (bw2Var != null) {
                if (bw2Var.g) {
                    c(jSONObject, jSONObject2, bw2Var);
                } else {
                    g94 q = c84.i().q(bw2Var.a, bw2Var.h, bw2Var.i);
                    if (q == null) {
                        zv2.a(Log.getStackTraceString(new Throwable(bw2Var.a + " query db fail")));
                    } else {
                        File t = dj2.t(bw2Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            bw2Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, bw2Var);
                        } else {
                            zv2.a(Log.getStackTraceString(new Throwable(bw2Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull bw2 bw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, bw2Var) == null) {
            String str = bw2Var.e;
            String str2 = bw2Var.f;
            if (a) {
                zv2.b("apply dep path, name = " + bw2Var.a + "; inline = " + bw2Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                zv2.b(Log.getStackTraceString(new Throwable(bw2Var.a + " path is empty")));
                return;
            }
            hd3.f(jSONObject, bw2Var.a, str);
            if (TextUtils.isEmpty(bw2Var.f)) {
                return;
            }
            File file = new File(str, str2);
            if (file.exists() && file.isFile()) {
                hd3.f(jSONObject2, bw2Var.a, hd3.d(jg4.E(file)));
            }
        }
    }
}
