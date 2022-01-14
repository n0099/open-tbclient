package com.kwad.sdk.core.c;

import android.content.Context;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.request.model.TaskStat;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static volatile a a;

    /* renamed from: b  reason: collision with root package name */
    public static SimpleDateFormat f55617b = new SimpleDateFormat("yyyy-MM-dd");

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public static String a(String str) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
    }

    public static void a(String str, String str2) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    public static List<TaskStat> b() {
        if (KsAdSDKImpl.get().getContext() == null) {
            return null;
        }
        d();
        String a2 = a("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(a2);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                TaskStat taskStat = new TaskStat();
                taskStat.parseJson(jSONObject);
                arrayList.add(taskStat);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static void b(AdTemplate adTemplate) {
        TaskStat taskStat;
        int w = d.w(adTemplate);
        int t = d.t(adTemplate);
        List b2 = b();
        if (b2 != null && b2.size() != 0) {
            boolean z = false;
            Iterator it = b2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TaskStat taskStat2 = (TaskStat) it.next();
                if (taskStat2.adStyle == t && taskStat2.taskType == w) {
                    taskStat2.count++;
                    z = true;
                    break;
                }
            }
            if (!z) {
                taskStat = new TaskStat(t, w, 1);
            }
            a("ksadsdk_local_ad_task_info_adstyle_data", t.b(b2).toString());
        }
        b2 = new ArrayList();
        taskStat = new TaskStat(t, w, 1);
        b2.add(taskStat);
        a("ksadsdk_local_ad_task_info_adstyle_data", t.b(b2).toString());
    }

    public static void c() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().clear().apply();
    }

    public static void d() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        long j2 = context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("ksadsdk_local_ad_task_info_date", -1L);
        if (j2 > 0 && !f55617b.format(new Date(j2)).equals(f55617b.format(new Date()))) {
            c();
        }
    }

    public void a(AdTemplate adTemplate) {
        d();
        b(adTemplate);
    }
}
