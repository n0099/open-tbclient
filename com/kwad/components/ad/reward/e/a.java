package com.kwad.components.ad.reward.e;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.w;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    public static long oT = -1;
    public static int oU;

    public static void I(Context context) {
        b bVar = new b();
        if (e(System.currentTimeMillis())) {
            oU++;
        } else {
            oU = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        oT = currentTimeMillis;
        bVar.oV = oU;
        bVar.en = currentTimeMillis;
        w.H(context, bVar.toJson().toString());
    }

    public static int cp() {
        if (!e(System.currentTimeMillis())) {
            oU = 0;
        }
        return oU;
    }

    public static boolean e(long j) {
        return gw() > 0 && j > 0 && gw() / 2460601000L == j / 2460601000L;
    }

    public static long gw() {
        long j = oT;
        if (j == -1) {
            String zA = w.zA();
            if (TextUtils.isEmpty(zA)) {
                return 0L;
            }
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(zA));
                oT = bVar.en;
                oU = bVar.oV;
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
            return oT;
        }
        return j;
    }
}
