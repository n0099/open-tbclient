package com.kwad.components.ad.splashscreen.local;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.utils.as;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            a b = b(context);
            long currentTimeMillis = System.currentTimeMillis();
            if (b == null) {
                b = new a(currentTimeMillis, 1);
            } else if (b.a(currentTimeMillis)) {
                b.b++;
            } else {
                b.a = currentTimeMillis;
                b.b = 1;
            }
            a(context, b);
        }
    }

    public static void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, aVar) == null) {
            if (context == null || aVar == null) {
                com.kwad.sdk.core.d.b.a("SplashLocalHelper", "saveSplashLocalInfo illegal arguments.");
                return;
            }
            context.getSharedPreferences("ksadsdk_splash_local_ad_force_active", 0).edit().putString("key_local_info", aVar.toJson().toString()).apply();
        }
    }

    @Nullable
    public static a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(context.getSharedPreferences("ksadsdk_splash_local_ad_force_active", 0).getString("key_local_info", null));
                a aVar = new a();
                aVar.parseJson(jSONObject);
                return aVar;
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.b(e);
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            a d = d(context);
            long currentTimeMillis = System.currentTimeMillis();
            if (d == null) {
                d = new a(currentTimeMillis, 1);
            } else if (d.a(currentTimeMillis)) {
                d.b++;
            } else {
                d.a = currentTimeMillis;
                d.b = 1;
            }
            if (context == null || d == null) {
                return;
            }
            as.n(context, d.toJson().toString());
        }
    }

    @Nullable
    public static a d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                String g = as.g(context);
                if (TextUtils.isEmpty(g)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(g);
                a aVar = new a();
                aVar.parseJson(jSONObject);
                return aVar;
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.b(e);
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    @Nullable
    public static a e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                String h = as.h(context);
                if (TextUtils.isEmpty(h)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(h);
                a aVar = new a();
                aVar.parseJson(jSONObject);
                return aVar;
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.b(e);
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public static void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            a e = e(context);
            long currentTimeMillis = System.currentTimeMillis();
            if (e == null) {
                e = new a(currentTimeMillis, 1);
            } else if (e.a(currentTimeMillis)) {
                e.b++;
            } else {
                e.a = currentTimeMillis;
                e.b = 1;
            }
            if (context == null || e == null) {
                return;
            }
            as.o(context, e.toJson().toString());
        }
    }
}
