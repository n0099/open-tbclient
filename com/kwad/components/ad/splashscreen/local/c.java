package com.kwad.components.ad.splashscreen.local;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
@KsJson
/* loaded from: classes8.dex */
public class c extends com.kwad.sdk.core.response.kwai.a {
    public static SimpleDateFormat em = new SimpleDateFormat("yyyy-MM-dd");
    public long en = 0;
    public int eo = 0;

    public static void V(Context context) {
        String zB = w.zB();
        c cVar = new c();
        if (TextUtils.isEmpty(zB)) {
            cVar.eo = 1;
            cVar.en = System.currentTimeMillis();
            w.I(context, cVar.toJson().toString());
            return;
        }
        try {
            cVar.parseJson(new JSONObject(zB));
            if (a(cVar.en, System.currentTimeMillis())) {
                cVar.eo++;
            } else {
                cVar.eo = 1;
            }
            cVar.en = System.currentTimeMillis();
            w.I(context, cVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
    }

    public static boolean a(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return em.format(new Date(j)).equals(em.format(new Date(j2)));
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }
        return false;
    }
}
