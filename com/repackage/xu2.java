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
public class xu2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755159172, "Lcom/repackage/xu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755159172, "Lcom/repackage/xu2;");
                return;
            }
        }
        a = cg1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, swanAppConfigData) == null) || swanAppConfigData == null) {
            return;
        }
        List<mv2> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (ha2.k()) {
                boolean z = false;
                for (mv2 mv2Var : e) {
                    String h = ha2.h(mv2Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        mv2Var.e = h;
                        c(jSONObject, jSONObject2, mv2Var);
                        z = true;
                        sw1.i("Module-Plugin", "use debug dependencies，name=" + mv2Var.a + " path=" + mv2Var.e);
                    } else {
                        sw1.o("Module-Plugin", "debug dependencies not exist，name=" + mv2Var.a + " path=" + mv2Var.e);
                    }
                }
                if (!z) {
                    kz2.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    sw1.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            qv2.c("dependenciesPath", jSONObject3);
            qv2.c("dependenciesConfig", jSONObject4);
            return;
        }
        qv2.c("dependenciesPath", null);
        qv2.c("dependenciesConfig", null);
        if (a) {
            kv2.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<mv2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) == null) || list.isEmpty()) {
            return;
        }
        for (mv2 mv2Var : list) {
            if (mv2Var != null) {
                if (mv2Var.g) {
                    c(jSONObject, jSONObject2, mv2Var);
                } else {
                    r84 q = n74.i().q(mv2Var.a, mv2Var.h, mv2Var.i);
                    if (q == null) {
                        kv2.a(Log.getStackTraceString(new Throwable(mv2Var.a + " query db fail")));
                    } else {
                        File t = oi2.t(mv2Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            mv2Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, mv2Var);
                        } else {
                            kv2.a(Log.getStackTraceString(new Throwable(mv2Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull mv2 mv2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, mv2Var) == null) {
            String str = mv2Var.e;
            String str2 = mv2Var.f;
            if (a) {
                kv2.b("apply dep path, name = " + mv2Var.a + "; inline = " + mv2Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                kv2.b(Log.getStackTraceString(new Throwable(mv2Var.a + " path is empty")));
                return;
            }
            sc3.f(jSONObject, mv2Var.a, str);
            if (TextUtils.isEmpty(mv2Var.f)) {
                return;
            }
            File file = new File(str, str2);
            if (file.exists() && file.isFile()) {
                sc3.f(jSONObject2, mv2Var.a, sc3.d(uf4.E(file)));
            }
        }
    }
}
