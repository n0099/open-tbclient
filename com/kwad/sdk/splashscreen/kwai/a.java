package com.kwad.sdk.splashscreen.kwai;

import android.content.Context;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static void a(Context context) {
        b b2 = b(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (b2 == null) {
            b2 = new b(currentTimeMillis, 1);
        } else if (b2.a(currentTimeMillis)) {
            b2.f58099b++;
        } else {
            b2.a = currentTimeMillis;
            b2.f58099b = 1;
        }
        a(context, b2);
    }

    public static void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            com.kwad.sdk.core.d.a.a("SplashLocalHelper", "saveSplashLocalInfo illegal arguments.");
            return;
        }
        context.getSharedPreferences("ksadsdk_splash_local_ad_force_active", 0).edit().putString("key_local_info", bVar.toJson().toString()).apply();
    }

    @Nullable
    public static b b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(context.getSharedPreferences("ksadsdk_splash_local_ad_force_active", 0).getString("key_local_info", null));
            b bVar = new b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
            return null;
        }
    }
}
