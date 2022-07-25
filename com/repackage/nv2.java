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
public class nv2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755456121, "Lcom/repackage/nv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755456121, "Lcom/repackage/nv2;");
                return;
            }
        }
        a = sg1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, swanAppConfigData) == null) || swanAppConfigData == null) {
            return;
        }
        List<cw2> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (xa2.k()) {
                boolean z = false;
                for (cw2 cw2Var : e) {
                    String h = xa2.h(cw2Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        cw2Var.e = h;
                        c(jSONObject, jSONObject2, cw2Var);
                        z = true;
                        ix1.i("Module-Plugin", "use debug dependencies，name=" + cw2Var.a + " path=" + cw2Var.e);
                    } else {
                        ix1.o("Module-Plugin", "debug dependencies not exist，name=" + cw2Var.a + " path=" + cw2Var.e);
                    }
                }
                if (!z) {
                    a03.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    ix1.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            gw2.c("dependenciesPath", jSONObject3);
            gw2.c("dependenciesConfig", jSONObject4);
            return;
        }
        gw2.c("dependenciesPath", null);
        gw2.c("dependenciesConfig", null);
        if (a) {
            aw2.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<cw2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) == null) || list.isEmpty()) {
            return;
        }
        for (cw2 cw2Var : list) {
            if (cw2Var != null) {
                if (cw2Var.g) {
                    c(jSONObject, jSONObject2, cw2Var);
                } else {
                    h94 q = d84.i().q(cw2Var.a, cw2Var.h, cw2Var.i);
                    if (q == null) {
                        aw2.a(Log.getStackTraceString(new Throwable(cw2Var.a + " query db fail")));
                    } else {
                        File t = ej2.t(cw2Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            cw2Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, cw2Var);
                        } else {
                            aw2.a(Log.getStackTraceString(new Throwable(cw2Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull cw2 cw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, cw2Var) == null) {
            String str = cw2Var.e;
            String str2 = cw2Var.f;
            if (a) {
                aw2.b("apply dep path, name = " + cw2Var.a + "; inline = " + cw2Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                aw2.b(Log.getStackTraceString(new Throwable(cw2Var.a + " path is empty")));
                return;
            }
            id3.f(jSONObject, cw2Var.a, str);
            if (TextUtils.isEmpty(cw2Var.f)) {
                return;
            }
            File file = new File(str, str2);
            if (file.exists() && file.isFile()) {
                id3.f(jSONObject2, cw2Var.a, id3.d(kg4.E(file)));
            }
        }
    }
}
