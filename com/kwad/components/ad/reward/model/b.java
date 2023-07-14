package com.kwad.components.ad.reward.model;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public static SimpleDateFormat em = new SimpleDateFormat("yyyy-MM-dd");
    public long pg = -1;
    public int ph = 0;

    public static void P(Context context) {
        String zC = w.zC();
        b bVar = new b();
        if (TextUtils.isEmpty(zC)) {
            bVar.ph = 1;
            bVar.pg = System.currentTimeMillis();
            w.J(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(zC));
            if (a(bVar.pg, System.currentTimeMillis())) {
                bVar.ph++;
            } else {
                bVar.ph = 1;
                bVar.pg = System.currentTimeMillis();
            }
            w.J(context, bVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    public static boolean a(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return em.format(new Date(j)).equals(em.format(new Date(j2)));
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }
        return false;
    }

    public static int gK() {
        String zC = w.zC();
        if (TextUtils.isEmpty(zC)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(zC));
            if (a(bVar.pg, System.currentTimeMillis())) {
                return bVar.ph;
            }
            return 0;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            return 0;
        }
    }
}
