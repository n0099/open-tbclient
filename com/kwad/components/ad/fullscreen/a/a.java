package com.kwad.components.ad.fullscreen.a;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    public static void G(Context context) {
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

    @Nullable
    public static b H(Context context) {
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

    public static void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            com.kwad.sdk.core.e.b.d("FullScreenLocalHelper", "saveFullScreenLocalInfo illegal arguments.");
            return;
        }
        context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).edit().putString("key_local_info", bVar.toJson().toString()).apply();
    }

    public static boolean a(Context context, AdTemplate adTemplate) {
        b H = H(context);
        return (H == null || !H.w(com.kwad.components.ad.fullscreen.kwai.b.bE())) && com.kwad.sdk.core.response.a.b.bB(adTemplate);
    }
}
