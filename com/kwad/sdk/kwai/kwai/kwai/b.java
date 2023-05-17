package com.kwad.sdk.kwai.kwai.kwai;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.w;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    public static int NL = 0;
    public static long oT = -1;

    public static void I(Context context) {
        a aVar = new a();
        if (e(System.currentTimeMillis())) {
            NL++;
        } else {
            NL = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        oT = currentTimeMillis;
        aVar.NL = NL;
        aVar.en = currentTimeMillis;
        w.Q(context, aVar.toJson().toString());
    }

    public static int cp() {
        if (!e(System.currentTimeMillis())) {
            NL = 0;
        }
        return NL;
    }

    public static boolean e(long j) {
        return gw() > 0 && j > 0 && gw() / 2460601000L == j / 2460601000L;
    }

    public static long gw() {
        long j = oT;
        if (j == -1) {
            String zG = w.zG();
            if (TextUtils.isEmpty(zG)) {
                return 0L;
            }
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(zG));
                oT = aVar.en;
                NL = aVar.NL;
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
            return oT;
        }
        return j;
    }
}
