package com.kwad.components.ad.interstitial.a;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
@KsJson
/* loaded from: classes8.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public static SimpleDateFormat em = new SimpleDateFormat("yyyy-MM-dd");
    public long en = -1;
    public int fS = 0;

    public static void I(Context context) {
        String zz = w.zz();
        a aVar = new a();
        if (TextUtils.isEmpty(zz)) {
            aVar.fS = 1;
            aVar.en = System.currentTimeMillis();
            w.G(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(zz));
            if (a(aVar.en, System.currentTimeMillis())) {
                aVar.fS++;
            } else {
                aVar.fS = 1;
                aVar.en = System.currentTimeMillis();
            }
            w.G(context, aVar.toJson().toString());
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

    public static int cp() {
        String zz = w.zz();
        if (TextUtils.isEmpty(zz)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(zz));
            if (a(aVar.en, System.currentTimeMillis())) {
                return aVar.fS;
            }
            return 0;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return 0;
        }
    }
}
