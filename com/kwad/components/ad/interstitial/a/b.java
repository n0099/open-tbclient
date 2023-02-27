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
public class b extends com.kwad.sdk.core.response.kwai.a {
    public static SimpleDateFormat em = new SimpleDateFormat("yyyy-MM-dd");
    public long en = -1;
    public int fT = 0;
    public int fU = 0;

    public static void I(Context context) {
        String zy = w.zy();
        b bVar = new b();
        if (TextUtils.isEmpty(zy)) {
            bVar.fT = 1;
            bVar.en = System.currentTimeMillis();
            w.F(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(zy));
            if (a(bVar.en, System.currentTimeMillis())) {
                bVar.fT++;
            } else {
                bVar.fT = 1;
                bVar.fU = 0;
                bVar.en = System.currentTimeMillis();
            }
            w.F(context, bVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
    }

    public static void J(Context context) {
        String zy = w.zy();
        b bVar = new b();
        if (TextUtils.isEmpty(zy)) {
            bVar.fU = 1;
            bVar.en = System.currentTimeMillis();
            w.F(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(zy));
            if (a(bVar.en, System.currentTimeMillis())) {
                bVar.fU++;
            } else {
                bVar.fU = 1;
                bVar.fT = 0;
                bVar.en = System.currentTimeMillis();
            }
            w.F(context, bVar.toJson().toString());
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
        String zy = w.zy();
        if (TextUtils.isEmpty(zy)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(zy));
            return bVar.fT;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return 0;
        }
    }

    public static int cq() {
        String zy = w.zy();
        if (TextUtils.isEmpty(zy)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(zy));
            return bVar.fU;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return 0;
        }
    }
}
