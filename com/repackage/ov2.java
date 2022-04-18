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
public class ov2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755426330, "Lcom/repackage/ov2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755426330, "Lcom/repackage/ov2;");
                return;
            }
        }
        a = tg1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, swanAppConfigData) == null) || swanAppConfigData == null) {
            return;
        }
        List<dw2> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (ya2.k()) {
                boolean z = false;
                for (dw2 dw2Var : e) {
                    String h = ya2.h(dw2Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        dw2Var.e = h;
                        c(jSONObject, jSONObject2, dw2Var);
                        z = true;
                        jx1.i("Module-Plugin", "use debug dependencies，name=" + dw2Var.a + " path=" + dw2Var.e);
                    } else {
                        jx1.o("Module-Plugin", "debug dependencies not exist，name=" + dw2Var.a + " path=" + dw2Var.e);
                    }
                }
                if (!z) {
                    b03.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    jx1.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            hw2.c("dependenciesPath", jSONObject3);
            hw2.c("dependenciesConfig", jSONObject4);
            return;
        }
        hw2.c("dependenciesPath", null);
        hw2.c("dependenciesConfig", null);
        if (a) {
            bw2.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<dw2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) == null) || list.isEmpty()) {
            return;
        }
        for (dw2 dw2Var : list) {
            if (dw2Var != null) {
                if (dw2Var.g) {
                    c(jSONObject, jSONObject2, dw2Var);
                } else {
                    i94 q = e84.i().q(dw2Var.a, dw2Var.h, dw2Var.i);
                    if (q == null) {
                        bw2.a(Log.getStackTraceString(new Throwable(dw2Var.a + " query db fail")));
                    } else {
                        File t = fj2.t(dw2Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            dw2Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, dw2Var);
                        } else {
                            bw2.a(Log.getStackTraceString(new Throwable(dw2Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull dw2 dw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, dw2Var) == null) {
            String str = dw2Var.e;
            String str2 = dw2Var.f;
            if (a) {
                bw2.b("apply dep path, name = " + dw2Var.a + "; inline = " + dw2Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                bw2.b(Log.getStackTraceString(new Throwable(dw2Var.a + " path is empty")));
                return;
            }
            jd3.f(jSONObject, dw2Var.a, str);
            if (TextUtils.isEmpty(dw2Var.f)) {
                return;
            }
            File file = new File(str, str2);
            if (file.exists() && file.isFile()) {
                jd3.f(jSONObject2, dw2Var.a, jd3.d(mg4.E(file)));
            }
        }
    }
}
