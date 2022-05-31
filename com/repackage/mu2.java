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
public class mu2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755486873, "Lcom/repackage/mu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755486873, "Lcom/repackage/mu2;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, swanAppConfigData) == null) || swanAppConfigData == null) {
            return;
        }
        List<bv2> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (w92.k()) {
                boolean z = false;
                for (bv2 bv2Var : e) {
                    String h = w92.h(bv2Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        bv2Var.e = h;
                        c(jSONObject, jSONObject2, bv2Var);
                        z = true;
                        hw1.i("Module-Plugin", "use debug dependencies，name=" + bv2Var.a + " path=" + bv2Var.e);
                    } else {
                        hw1.o("Module-Plugin", "debug dependencies not exist，name=" + bv2Var.a + " path=" + bv2Var.e);
                    }
                }
                if (!z) {
                    zy2.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    hw1.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            fv2.c("dependenciesPath", jSONObject3);
            fv2.c("dependenciesConfig", jSONObject4);
            return;
        }
        fv2.c("dependenciesPath", null);
        fv2.c("dependenciesConfig", null);
        if (a) {
            zu2.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<bv2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) == null) || list.isEmpty()) {
            return;
        }
        for (bv2 bv2Var : list) {
            if (bv2Var != null) {
                if (bv2Var.g) {
                    c(jSONObject, jSONObject2, bv2Var);
                } else {
                    g84 q = c74.i().q(bv2Var.a, bv2Var.h, bv2Var.i);
                    if (q == null) {
                        zu2.a(Log.getStackTraceString(new Throwable(bv2Var.a + " query db fail")));
                    } else {
                        File t = di2.t(bv2Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            bv2Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, bv2Var);
                        } else {
                            zu2.a(Log.getStackTraceString(new Throwable(bv2Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull bv2 bv2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, bv2Var) == null) {
            String str = bv2Var.e;
            String str2 = bv2Var.f;
            if (a) {
                zu2.b("apply dep path, name = " + bv2Var.a + "; inline = " + bv2Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                zu2.b(Log.getStackTraceString(new Throwable(bv2Var.a + " path is empty")));
                return;
            }
            hc3.f(jSONObject, bv2Var.a, str);
            if (TextUtils.isEmpty(bv2Var.f)) {
                return;
            }
            File file = new File(str, str2);
            if (file.exists() && file.isFile()) {
                hc3.f(jSONObject2, bv2Var.a, hc3.d(kf4.E(file)));
            }
        }
    }
}
