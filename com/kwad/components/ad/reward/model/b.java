package com.kwad.components.ad.reward.model;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public static SimpleDateFormat gL = new SimpleDateFormat("yyyy-MM-dd");
    public long jD = -1;
    public int jE = 0;

    public static int cO() {
        String Kg = y.Kg();
        if (TextUtils.isEmpty(Kg)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(Kg));
            if (!c(bVar.jD, System.currentTimeMillis())) {
                return 0;
            }
            return bVar.jE;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            return 0;
        }
    }

    public static void J(Context context) {
        String Kg = y.Kg();
        b bVar = new b();
        if (TextUtils.isEmpty(Kg)) {
            bVar.jE = 1;
            bVar.jD = System.currentTimeMillis();
            y.ad(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(Kg));
            if (c(bVar.jD, System.currentTimeMillis())) {
                bVar.jE++;
            } else {
                bVar.jE = 1;
                bVar.jD = System.currentTimeMillis();
            }
            y.ad(context, bVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    public static boolean c(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return gL.format(new Date(j)).equals(gL.format(new Date(j2)));
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        return false;
    }
}
