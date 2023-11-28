package com.kwad.components.ad.fullscreen.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static void F(Context context) {
        b G = G(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (G == null) {
            G = new b(currentTimeMillis, 1);
        } else if (!G.f(currentTimeMillis)) {
            G.gM = currentTimeMillis;
            G.gN = 1;
        } else {
            G.gN++;
        }
        a(context, G);
    }

    @Nullable
    public static b G(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).getString("key_local_info", null));
            b bVar = new b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return null;
        }
    }

    public static void a(Context context, b bVar) {
        if (context != null && bVar != null) {
            context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).edit().putString("key_local_info", bVar.toJson().toString()).apply();
            return;
        }
        c.d("FullScreenLocalHelper", "saveFullScreenLocalInfo illegal arguments.");
    }

    public static boolean a(Context context, AdTemplate adTemplate) {
        boolean z;
        b G = G(context);
        if (G != null && G.w(com.kwad.components.ad.fullscreen.a.b.bO())) {
            z = false;
        } else {
            z = true;
        }
        boolean df = com.kwad.sdk.core.response.b.b.df(adTemplate);
        if (!z || !df) {
            return false;
        }
        return true;
    }
}
