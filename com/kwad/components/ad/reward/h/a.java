package com.kwad.components.ad.reward.h;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static long rL = -1;
    public static int rM;

    public static void H(Context context) {
        b bVar = new b();
        if (f(System.currentTimeMillis())) {
            rM++;
        } else {
            rM = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        rL = currentTimeMillis;
        bVar.rN = rM;
        bVar.gM = currentTimeMillis;
        y.ab(context, bVar.toJson().toString());
    }

    public static boolean f(long j) {
        if (gT() <= 0 || j <= 0 || gT() / 2460601000L != j / 2460601000L) {
            return false;
        }
        return true;
    }

    public static int cM() {
        if (!f(System.currentTimeMillis())) {
            rM = 0;
        }
        return rM;
    }

    public static long gT() {
        long j = rL;
        if (j == -1) {
            String Ke = y.Ke();
            if (TextUtils.isEmpty(Ke)) {
                return 0L;
            }
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(Ke));
                rL = bVar.gM;
                rM = bVar.rN;
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
            return rL;
        }
        return j;
    }
}
