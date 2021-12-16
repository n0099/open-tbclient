package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, com.kwad.sdk.core.config.item.b> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1066607854, "Lcom/kwad/sdk/core/config/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1066607854, "Lcom/kwad/sdk/core/config/a;");
                return;
            }
        }
        a = new ConcurrentHashMap();
    }

    public static void a(SharedPreferences.Editor editor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, editor) == null) || editor == null) {
            return;
        }
        for (String str : a.keySet()) {
            a.get(str).a(editor);
        }
    }

    public static void a(SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, sharedPreferences) == null) || sharedPreferences == null) {
            return;
        }
        for (String str : a.keySet()) {
            try {
                a.get(str).a(sharedPreferences);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
        }
    }

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            a.put(bVar.b(), bVar);
        }
    }

    public static void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        for (String str : a.keySet()) {
            com.kwad.sdk.core.config.item.b bVar = a.get(str);
            if (jSONObject.has(str)) {
                bVar.a(jSONObject);
            }
        }
    }

    @WorkerThread
    public static synchronized boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            synchronized (a.class) {
                if (context != null) {
                    SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_config", 0).edit();
                    a(edit);
                    return edit.commit();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @WorkerThread
    public static synchronized void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (a.class) {
                if (context != null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_config", 0);
                    if (sharedPreferences != null) {
                        a(sharedPreferences);
                    }
                }
            }
        }
    }
}
