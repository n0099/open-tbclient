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
/* loaded from: classes7.dex */
public class zv2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755098629, "Lcom/repackage/zv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755098629, "Lcom/repackage/zv2;");
                return;
            }
        }
        a = eh1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, swanAppConfigData) == null) || swanAppConfigData == null) {
            return;
        }
        List<ow2> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (jb2.k()) {
                boolean z = false;
                for (ow2 ow2Var : e) {
                    String h = jb2.h(ow2Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        ow2Var.e = h;
                        c(jSONObject, jSONObject2, ow2Var);
                        z = true;
                        ux1.i("Module-Plugin", "use debug dependencies，name=" + ow2Var.a + " path=" + ow2Var.e);
                    } else {
                        ux1.o("Module-Plugin", "debug dependencies not exist，name=" + ow2Var.a + " path=" + ow2Var.e);
                    }
                }
                if (!z) {
                    m03.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    ux1.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            sw2.c("dependenciesPath", jSONObject3);
            sw2.c("dependenciesConfig", jSONObject4);
            return;
        }
        sw2.c("dependenciesPath", null);
        sw2.c("dependenciesConfig", null);
        if (a) {
            mw2.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<ow2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) == null) || list.isEmpty()) {
            return;
        }
        for (ow2 ow2Var : list) {
            if (ow2Var != null) {
                if (ow2Var.g) {
                    c(jSONObject, jSONObject2, ow2Var);
                } else {
                    t94 q = p84.i().q(ow2Var.a, ow2Var.h, ow2Var.i);
                    if (q == null) {
                        mw2.a(Log.getStackTraceString(new Throwable(ow2Var.a + " query db fail")));
                    } else {
                        File t = qj2.t(ow2Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            ow2Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, ow2Var);
                        } else {
                            mw2.a(Log.getStackTraceString(new Throwable(ow2Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull ow2 ow2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, ow2Var) == null) {
            String str = ow2Var.e;
            String str2 = ow2Var.f;
            if (a) {
                mw2.b("apply dep path, name = " + ow2Var.a + "; inline = " + ow2Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                mw2.b(Log.getStackTraceString(new Throwable(ow2Var.a + " path is empty")));
                return;
            }
            ud3.f(jSONObject, ow2Var.a, str);
            if (TextUtils.isEmpty(ow2Var.f)) {
                return;
            }
            File file = new File(str, str2);
            if (file.exists() && file.isFile()) {
                ud3.f(jSONObject2, ow2Var.a, ud3.d(xg4.E(file)));
            }
        }
    }
}
