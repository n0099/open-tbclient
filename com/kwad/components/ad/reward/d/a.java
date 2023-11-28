package com.kwad.components.ad.reward.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static void N(@NonNull Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String ce = y.ce(context);
        int i = 0;
        if (!TextUtils.isEmpty(ce)) {
            try {
                bVar.parseJson(new JSONObject(ce));
                if (c(bVar.gM, currentTimeMillis)) {
                    i = bVar.rs;
                }
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        bVar.gM = currentTimeMillis;
        bVar.rs = i + 1;
        y.aa(context, bVar.toJson().toString());
    }

    public static boolean b(@NonNull Context context, AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.aG(adInfo)) {
            return false;
        }
        int max = Math.max(com.kwad.sdk.core.response.b.a.aH(adInfo) + 1, 1);
        boolean d = d(context, max);
        c(context, max);
        boolean e = e(context, com.kwad.sdk.core.response.b.a.aI(adInfo));
        if (!d || !e) {
            return false;
        }
        return true;
    }

    public static void c(@NonNull Context context, int i) {
        int cd = y.cd(context);
        if (cd % i == 0) {
            y.l(context, 1);
        } else {
            y.l(context, cd + 1);
        }
    }

    public static boolean d(@NonNull Context context, int i) {
        int cd = y.cd(context);
        if (i != 0 && cd % i == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean e(@NonNull Context context, int i) {
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String ce = y.ce(context);
        if (!TextUtils.isEmpty(ce)) {
            try {
                bVar.parseJson(new JSONObject(ce));
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
            if (c(bVar.gM, currentTimeMillis)) {
                i2 = bVar.rs;
                if (i2 < i) {
                    return false;
                }
                return true;
            }
        }
        i2 = 0;
        if (i2 < i) {
        }
    }

    public static boolean c(long j, long j2) {
        if (j <= 0 || j2 <= 0 || j / 2460601000L != j2 / 2460601000L) {
            return false;
        }
        return true;
    }
}
