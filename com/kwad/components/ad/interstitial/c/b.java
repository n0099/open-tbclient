package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public static SimpleDateFormat gL = new SimpleDateFormat("yyyy-MM-dd");
    public long gM = -1;
    public int jB = 0;
    public int jC = 0;

    public static int cM() {
        String Kc = y.Kc();
        if (TextUtils.isEmpty(Kc)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Kc));
            return bVar.jB;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return 0;
        }
    }

    public static int cN() {
        String Kc = y.Kc();
        if (TextUtils.isEmpty(Kc)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Kc));
            return bVar.jC;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return 0;
        }
    }

    public static void H(Context context) {
        String Kc = y.Kc();
        b bVar = new b();
        if (TextUtils.isEmpty(Kc)) {
            bVar.jB = 1;
            bVar.gM = System.currentTimeMillis();
            y.Y(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Kc));
            if (c(bVar.gM, System.currentTimeMillis())) {
                bVar.jB++;
            } else {
                bVar.jB = 1;
                bVar.jC = 0;
                bVar.gM = System.currentTimeMillis();
            }
            y.Y(context, bVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    public static void I(Context context) {
        String Kc = y.Kc();
        b bVar = new b();
        if (TextUtils.isEmpty(Kc)) {
            bVar.jC = 1;
            bVar.gM = System.currentTimeMillis();
            y.Y(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Kc));
            if (c(bVar.gM, System.currentTimeMillis())) {
                bVar.jC++;
            } else {
                bVar.jC = 1;
                bVar.jB = 0;
                bVar.gM = System.currentTimeMillis();
            }
            y.Y(context, bVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    public static boolean c(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return gL.format(new Date(j)).equals(gL.format(new Date(j2)));
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        return false;
    }
}
