package com.kwad.sdk.core.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.d;
import com.kwad.sdk.utils.r;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static SimpleDateFormat EB = new SimpleDateFormat("yyyy-MM-dd");
    public static volatile a XK;

    public static void a(int i, long j) {
        Context context = ((d) ServiceProvider.get(d.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i).putLong("reward_aggregation_min_interval", j).apply();
    }

    public static boolean a(@NonNull f fVar) {
        long j = fVar.acW;
        if (j <= 0) {
            return false;
        }
        return EB.format(new Date(j)).equals(EB.format(new Date()));
    }

    @NonNull
    public static List<f> aA(int i) {
        ArrayList arrayList = new ArrayList();
        List<f> ts = ts();
        if (ts != null && ts.size() != 0) {
            for (f fVar : ts) {
                if (15 == fVar.adStyle) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static void an(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            b.d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            ao(adTemplate);
        }
    }

    public static void ao(AdTemplate adTemplate) {
        f fVar;
        int bY = com.kwad.sdk.core.response.a.d.bY(adTemplate);
        int bK = com.kwad.sdk.core.response.a.d.bK(adTemplate);
        List ts = ts();
        if (ts != null && ts.size() != 0) {
            boolean z = false;
            Iterator it = ts.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f fVar2 = (f) it.next();
                if (fVar2.adStyle == bK && fVar2.taskType == bY) {
                    fVar2.count++;
                    if (!a(fVar2)) {
                        fVar2.count = 1;
                        fVar2.G(System.currentTimeMillis());
                    }
                    z = true;
                }
            }
            if (!z) {
                fVar = new f(bK, bY, 1, System.currentTimeMillis());
            }
            y("ksadsdk_local_ad_task_info_adstyle_data", r.B(ts).toString());
            adTemplate.watched = true;
        }
        ts = new ArrayList();
        fVar = new f(bK, bY, 1, System.currentTimeMillis());
        ts.add(fVar);
        y("ksadsdk_local_ad_task_info_adstyle_data", r.B(ts).toString());
        adTemplate.watched = true;
    }

    public static String getString(String str) {
        Context context = ((d) ServiceProvider.get(d.class)).getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
    }

    public static a tr() {
        if (XK == null) {
            synchronized (a.class) {
                if (XK == null) {
                    XK = new a();
                }
            }
        }
        return XK;
    }

    public static List<f> ts() {
        if (((d) ServiceProvider.get(d.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                f fVar = new f();
                fVar.parseJson(jSONObject);
                arrayList.add(fVar);
            }
        } catch (Exception unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (f fVar2 : arrayList) {
            if (a(fVar2)) {
                arrayList2.add(fVar2);
            }
        }
        return arrayList2;
    }

    public static int tt() {
        Context context = ((d) ServiceProvider.get(d.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    public static long tu() {
        Context context = ((d) ServiceProvider.get(d.class)).getContext();
        return context == null ? IMLikeRequest.TIME_INTERVAL : context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", IMLikeRequest.TIME_INTERVAL);
    }

    public static void y(String str, String str2) {
        Context context = ((d) ServiceProvider.get(d.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }
}
