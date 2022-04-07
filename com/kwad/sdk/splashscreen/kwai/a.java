package com.kwad.sdk.splashscreen.kwai;

import android.content.Context;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static void a(Context context) {
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
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
            return null;
        }
    }
}
