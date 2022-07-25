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

    public static void G(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            b H = H(context);
            long currentTimeMillis = System.currentTimeMillis();
            if (H == null) {
                H = new b(currentTimeMillis, 1);
            } else if (H.e(currentTimeMillis)) {
                H.eo++;
            } else {
                H.en = currentTimeMillis;
                H.eo = 1;
            }
            a(context, H);
        }
    }

    @Nullable
    public static b H(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).getString("key_local_info", null));
                b bVar = new b();
                bVar.parseJson(jSONObject);
                return bVar;
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                return null;
            }
        }
        return (b) invokeL.objValue;
    }

    public static void a(Context context, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, bVar) == null) {
            if (context == null || bVar == null) {
                com.kwad.sdk.core.e.b.d("FullScreenLocalHelper", "saveFullScreenLocalInfo illegal arguments.");
                return;
            }
            context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).edit().putString("key_local_info", bVar.toJson().toString()).apply();
        }
    }

    public static boolean a(Context context, AdTemplate adTemplate) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, adTemplate)) == null) {
            b H = H(context);
            return (H == null || !H.w(com.kwad.components.ad.fullscreen.kwai.b.bE())) && com.kwad.sdk.core.response.a.b.bB(adTemplate);
        }
        return invokeLL.booleanValue;
    }
}
