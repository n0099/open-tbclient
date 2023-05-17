package com.kwad.components.ad.splashscreen.local;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.w;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    public static void G(Context context) {
        a Q = Q(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (Q == null) {
            Q = new a(currentTimeMillis, 1);
        } else if (Q.e(currentTimeMillis)) {
            Q.eo++;
        } else {
            Q.en = currentTimeMillis;
            Q.eo = 1;
        }
        a(context, Q);
    }

    @Nullable
    public static a Q(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String zF = w.zF();
            if (TextUtils.isEmpty(zF)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(zF);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            return aVar;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return null;
        }
    }

    public static void R(Context context) {
        a S = S(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (S == null) {
            S = new a(currentTimeMillis, 1);
        } else if (S.e(currentTimeMillis)) {
            S.eo++;
        } else {
            S.en = currentTimeMillis;
            S.eo = 1;
        }
        if (context == null || S == null) {
            return;
        }
        w.O(context, S.toJson().toString());
    }

    @Nullable
    public static a S(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String cs = w.cs(context);
            if (TextUtils.isEmpty(cs)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(cs);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            return aVar;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return null;
        }
    }

    @Nullable
    public static a T(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String ct = w.ct(context);
            if (TextUtils.isEmpty(ct)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(ct);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            return aVar;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return null;
        }
    }

    public static void U(Context context) {
        a T = T(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (T == null) {
            T = new a(currentTimeMillis, 1);
        } else if (T.e(currentTimeMillis)) {
            T.eo++;
        } else {
            T.en = currentTimeMillis;
            T.eo = 1;
        }
        if (context == null || T == null) {
            return;
        }
        w.P(context, T.toJson().toString());
    }

    public static void a(Context context, a aVar) {
        if (context == null || aVar == null) {
            com.kwad.sdk.core.e.b.d("SplashLocalHelper", "saveSplashLocalInfo illegal arguments.");
        } else {
            w.dH(aVar.toJson().toString());
        }
    }
}
