package com.kwad.sdk.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    public static int ZR = 0;
    public static long rL = -1;

    public static void H(Context context) {
        a aVar = new a();
        if (f(System.currentTimeMillis())) {
            ZR++;
        } else {
            ZR = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        rL = currentTimeMillis;
        aVar.ZR = ZR;
        aVar.gM = currentTimeMillis;
        y.ak(context, aVar.toJson().toString());
    }

    public static boolean f(long j) {
        if (gT() <= 0 || j <= 0 || gT() / 2460601000L != j / 2460601000L) {
            return false;
        }
        return true;
    }

    public static int cM() {
        if (!f(System.currentTimeMillis())) {
            ZR = 0;
        }
        return ZR;
    }

    public static long gT() {
        long j = rL;
        if (j == -1) {
            String Kl = y.Kl();
            if (TextUtils.isEmpty(Kl)) {
                return 0L;
            }
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(Kl));
                rL = aVar.gM;
                ZR = aVar.ZR;
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
            return rL;
        }
        return j;
    }
}
