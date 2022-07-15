package com.kwad.components.ad.fullscreen.a;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            b b = b(context);
            long currentTimeMillis = System.currentTimeMillis();
            if (b == null) {
                b = new b(currentTimeMillis, 1);
            } else if (b.a(currentTimeMillis)) {
                b.b++;
            } else {
                b.a = currentTimeMillis;
                b.b = 1;
            }
            a(context, b);
        }
    }

    public static void a(Context context, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, bVar) == null) {
            if (context == null || bVar == null) {
                com.kwad.sdk.core.d.b.a("FullScreenLocalHelper", "saveFullScreenLocalInfo illegal arguments.");
                return;
            }
            context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).edit().putString("key_local_info", bVar.toJson().toString()).apply();
        }
    }

    public static boolean a(Context context, AdTemplate adTemplate) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, adTemplate)) == null) {
            b b = b(context);
            return (b == null || !b.a(com.kwad.components.ad.fullscreen.kwai.b.c())) && com.kwad.sdk.core.response.a.b.D(adTemplate);
        }
        return invokeLL.booleanValue;
    }

    @Nullable
    public static b b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).getString("key_local_info", null));
                b bVar = new b();
                bVar.parseJson(jSONObject);
                return bVar;
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.b(e);
                return null;
            }
        }
        return (b) invokeL.objValue;
    }
}
