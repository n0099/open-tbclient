package com.kwad.components.ad.splashscreen.local;

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
public class a extends com.kwad.sdk.core.response.a.a {
    public static SimpleDateFormat gL = new SimpleDateFormat("yyyy-MM-dd");
    public long gM = 0;
    public int gN = 0;

    public static void R(Context context) {
        String Kf = y.Kf();
        a aVar = new a();
        if (TextUtils.isEmpty(Kf)) {
            aVar.gN = 1;
            aVar.gM = System.currentTimeMillis();
            y.ac(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(Kf));
            if (c(aVar.gM, System.currentTimeMillis())) {
                aVar.gN++;
            } else {
                aVar.gN = 1;
            }
            aVar.gM = System.currentTimeMillis();
            y.ac(context, aVar.toJson().toString());
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
