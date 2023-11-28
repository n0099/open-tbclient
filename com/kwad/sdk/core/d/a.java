package com.kwad.sdk.core.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static SimpleDateFormat Mj = new SimpleDateFormat("yyyy-MM-dd");
    public static volatile a atc;

    public static a Cv() {
        if (atc == null) {
            synchronized (a.class) {
                if (atc == null) {
                    atc = new a();
                }
            }
        }
        return atc;
    }

    public static int Cy() {
        Context context = ((f) ServiceProvider.get(f.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    public static long Cz() {
        Context context = ((f) ServiceProvider.get(f.class)).getContext();
        if (context == null) {
            return IMLikeRequest.TIME_INTERVAL;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", IMLikeRequest.TIME_INTERVAL);
    }

    public static boolean Cw() {
        List<com.kwad.sdk.core.request.model.f> cr = cr(15);
        if (cr.size() == 0) {
            return true;
        }
        long j = -1;
        int i = 0;
        for (com.kwad.sdk.core.request.model.f fVar : cr) {
            i += fVar.count;
            long j2 = fVar.ayM;
            if (j2 > j) {
                j = j2;
            }
        }
        c.d("AdCounter", "onBind localCountCheck: allCount: " + i + ", lastShowTime: " + j);
        if (i > Cy()) {
            return false;
        }
        if (j + (Cz() * 1000) <= System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public static List<com.kwad.sdk.core.request.model.f> Cx() {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<com.kwad.sdk.core.request.model.f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                com.kwad.sdk.core.request.model.f fVar = new com.kwad.sdk.core.request.model.f();
                fVar.parseJson(jSONObject);
                arrayList.add(fVar);
            }
        } catch (Exception unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (com.kwad.sdk.core.request.model.f fVar2 : arrayList) {
            if (a(fVar2)) {
                arrayList2.add(fVar2);
            }
        }
        return arrayList2;
    }

    public static void O(String str, String str2) {
        Context context = ((f) ServiceProvider.get(f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    public static void f(int i, long j) {
        Context context = ((f) ServiceProvider.get(f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i).putLong("reward_aggregation_min_interval", j).apply();
    }

    public static boolean a(@NonNull com.kwad.sdk.core.request.model.f fVar) {
        long j = fVar.ayM;
        if (j <= 0) {
            return false;
        }
        return Mj.format(new Date(j)).equals(Mj.format(new Date()));
    }

    public static void bF(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            c.d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            bG(adTemplate);
        }
    }

    @NonNull
    public static List<com.kwad.sdk.core.request.model.f> cr(int i) {
        ArrayList arrayList = new ArrayList();
        List<com.kwad.sdk.core.request.model.f> Cx = Cx();
        if (Cx != null && Cx.size() != 0) {
            for (com.kwad.sdk.core.request.model.f fVar : Cx) {
                if (15 == fVar.adStyle) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static String getString(String str) {
        Context context = ((f) ServiceProvider.get(f.class)).getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
    }

    public static void bG(AdTemplate adTemplate) {
        int dX = e.dX(adTemplate);
        int dJ = e.dJ(adTemplate);
        List Cx = Cx();
        if (Cx != null && Cx.size() != 0) {
            boolean z = false;
            Iterator it = Cx.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.kwad.sdk.core.request.model.f fVar = (com.kwad.sdk.core.request.model.f) it.next();
                if (fVar.adStyle == dJ && fVar.taskType == dX) {
                    fVar.count++;
                    if (!a(fVar)) {
                        fVar.count = 1;
                        fVar.aj(System.currentTimeMillis());
                    }
                    z = true;
                }
            }
            if (!z) {
                Cx.add(new com.kwad.sdk.core.request.model.f(dJ, dX, 1, System.currentTimeMillis()));
            }
        } else {
            Cx = new ArrayList();
            Cx.add(new com.kwad.sdk.core.request.model.f(dJ, dX, 1, System.currentTimeMillis()));
        }
        O("ksadsdk_local_ad_task_info_adstyle_data", t.K(Cx).toString());
        adTemplate.watched = true;
    }
}
