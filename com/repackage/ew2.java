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
public class ew2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755723279, "Lcom/repackage/ew2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755723279, "Lcom/repackage/ew2;");
                return;
            }
        }
        a = jh1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, swanAppConfigData) == null) || swanAppConfigData == null) {
            return;
        }
        List<tw2> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (ob2.k()) {
                boolean z = false;
                for (tw2 tw2Var : e) {
                    String h = ob2.h(tw2Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        tw2Var.e = h;
                        c(jSONObject, jSONObject2, tw2Var);
                        z = true;
                        zx1.i("Module-Plugin", "use debug dependencies，name=" + tw2Var.a + " path=" + tw2Var.e);
                    } else {
                        zx1.o("Module-Plugin", "debug dependencies not exist，name=" + tw2Var.a + " path=" + tw2Var.e);
                    }
                }
                if (!z) {
                    r03.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    zx1.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            xw2.c("dependenciesPath", jSONObject3);
            xw2.c("dependenciesConfig", jSONObject4);
            return;
        }
        xw2.c("dependenciesPath", null);
        xw2.c("dependenciesConfig", null);
        if (a) {
            rw2.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<tw2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) == null) || list.isEmpty()) {
            return;
        }
        for (tw2 tw2Var : list) {
            if (tw2Var != null) {
                if (tw2Var.g) {
                    c(jSONObject, jSONObject2, tw2Var);
                } else {
                    y94 q = u84.i().q(tw2Var.a, tw2Var.h, tw2Var.i);
                    if (q == null) {
                        rw2.a(Log.getStackTraceString(new Throwable(tw2Var.a + " query db fail")));
                    } else {
                        File t = vj2.t(tw2Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            tw2Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, tw2Var);
                        } else {
                            rw2.a(Log.getStackTraceString(new Throwable(tw2Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull tw2 tw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, tw2Var) == null) {
            String str = tw2Var.e;
            String str2 = tw2Var.f;
            if (a) {
                rw2.b("apply dep path, name = " + tw2Var.a + "; inline = " + tw2Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                rw2.b(Log.getStackTraceString(new Throwable(tw2Var.a + " path is empty")));
                return;
            }
            zd3.f(jSONObject, tw2Var.a, str);
            if (TextUtils.isEmpty(tw2Var.f)) {
                return;
            }
            File file = new File(str, str2);
            if (file.exists() && file.isFile()) {
                zd3.f(jSONObject2, tw2Var.a, zd3.d(bh4.E(file)));
            }
        }
    }
}
