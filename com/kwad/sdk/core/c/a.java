package com.kwad.sdk.core.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.kwad.sdk.core.d.b;
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
/* loaded from: classes5.dex */
public class a {
    public static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");
    public static volatile a b;

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public static String a(String str) {
        Context a2 = ((d) ServiceProvider.a(d.class)).a();
        if (a2 == null) {
            return null;
        }
        return a2.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
    }

    @NonNull
    public static List<f> a(int i) {
        ArrayList arrayList = new ArrayList();
        List<f> b2 = b();
        if (b2 != null && b2.size() != 0) {
            for (f fVar : b2) {
                if (15 == fVar.a) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static void a(int i, long j) {
        Context a2 = ((d) ServiceProvider.a(d.class)).a();
        if (a2 == null) {
            return;
        }
        a2.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i).putLong("reward_aggregation_min_interval", j).apply();
    }

    public static void a(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            b.a("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            b(adTemplate);
        }
    }

    public static void a(String str, String str2) {
        Context a2 = ((d) ServiceProvider.a(d.class)).a();
        if (a2 == null) {
            return;
        }
        a2.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    public static boolean a(@NonNull f fVar) {
        long j = fVar.d;
        if (j <= 0) {
            return false;
        }
        return a.format(new Date(j)).equals(a.format(new Date()));
    }

    public static List<f> b() {
        if (((d) ServiceProvider.a(d.class)).a() == null) {
            return null;
        }
        String a2 = a("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(a2);
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

    public static void b(AdTemplate adTemplate) {
        f fVar;
        int r = com.kwad.sdk.core.response.a.d.r(adTemplate);
        int c = com.kwad.sdk.core.response.a.d.c(adTemplate);
        List b2 = b();
        if (b2 != null && b2.size() != 0) {
            boolean z = false;
            Iterator it = b2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f fVar2 = (f) it.next();
                if (fVar2.a == c && fVar2.b == r) {
                    fVar2.c++;
                    if (!a(fVar2)) {
                        fVar2.c = 1;
                        fVar2.a(System.currentTimeMillis());
                    }
                    z = true;
                }
            }
            if (!z) {
                fVar = new f(c, r, 1, System.currentTimeMillis());
            }
            a("ksadsdk_local_ad_task_info_adstyle_data", r.b(b2).toString());
            adTemplate.watched = true;
        }
        b2 = new ArrayList();
        fVar = new f(c, r, 1, System.currentTimeMillis());
        b2.add(fVar);
        a("ksadsdk_local_ad_task_info_adstyle_data", r.b(b2).toString());
        adTemplate.watched = true;
    }

    public static int c() {
        Context a2 = ((d) ServiceProvider.a(d.class)).a();
        if (a2 == null) {
            return 30;
        }
        return a2.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    public static long d() {
        Context a2 = ((d) ServiceProvider.a(d.class)).a();
        return a2 == null ? IMLikeRequest.TIME_INTERVAL : a2.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", IMLikeRequest.TIME_INTERVAL);
    }
}
