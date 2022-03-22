package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    public static boolean a;

    public static void a() {
        f.a(new ReportAction(10101L));
    }

    public static void a(int i) {
        ReportAction reportAction = new ReportAction(10104L);
        reportAction.aI = i;
        f.a(reportAction);
    }

    public static void a(long j, long j2) {
        ReportAction reportAction = new ReportAction(j);
        if (j2 > 0) {
            reportAction.aO = j2;
        }
        f.a(reportAction);
    }

    public static void a(Context context) {
        if (a) {
            return;
        }
        a = true;
        ReportAction reportAction = new ReportAction(8L);
        reportAction.bs = com.kwad.sdk.collector.f.a(context);
        f.a(reportAction);
    }

    public static void a(KsScene ksScene, boolean z, String str) {
        ReportAction reportAction = new ReportAction(10216L);
        reportAction.aW = z;
        reportAction.aX = str;
        if (ksScene instanceof SceneImpl) {
            reportAction.f39690b = (SceneImpl) ksScene;
        }
        f.a(reportAction);
    }

    public static void a(@NonNull AdTemplate adTemplate) {
        f.a(new ReportAction(10007L, adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i) {
        ReportAction reportAction = new ReportAction(10108L, adTemplate);
        reportAction.aJ = i;
        f.a(reportAction);
    }

    public static void a(@NonNull AdTemplate adTemplate, int i, int i2) {
        ReportAction reportAction = new ReportAction(12006L, adTemplate);
        reportAction.aA = i;
        reportAction.J = i2;
        f.a(reportAction);
    }

    public static void a(AdTemplate adTemplate, int i, String str) {
        ReportAction reportAction = new ReportAction(10109L, adTemplate);
        reportAction.aJ = i;
        reportAction.aK = str;
        f.a(reportAction);
    }

    public static void a(@NonNull AdTemplate adTemplate, long j) {
        ReportAction reportAction = new ReportAction(10202L, adTemplate);
        reportAction.aU = j;
        f.a(reportAction);
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, int i) {
        ReportAction reportAction = new ReportAction(104L, adTemplate);
        reportAction.bc = com.kwad.sdk.utils.m.d(adTemplate);
        reportAction.bd = j;
        reportAction.be = i;
        f.a(reportAction);
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, long j2, int i) {
        ReportAction reportAction = new ReportAction(10203L, adTemplate);
        reportAction.u = j;
        reportAction.y = j2;
        reportAction.C = i;
        f.a(reportAction);
    }

    public static void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        ReportAction reportAction = new ReportAction(10001L, adTemplate);
        reportAction.aC = str;
        reportAction.aD = str2;
        f.a(reportAction);
    }

    public static void a(@NonNull AdTemplate adTemplate, List<String> list) {
        if (adTemplate.mTrackUrlReported || list == null || list.isEmpty()) {
            return;
        }
        adTemplate.mTrackUrlReported = true;
        ReportAction reportAction = new ReportAction(10217L, adTemplate);
        reportAction.bo = t.a(list);
        f.a(reportAction);
    }

    public static void a(com.kwad.sdk.h.a.b bVar) {
        ReportAction reportAction = new ReportAction(10215L);
        reportAction.bl = bVar.a;
        reportAction.bp = bVar.f40555b;
        reportAction.bm = bVar.f40556c;
        reportAction.bn = bVar.f40557d;
        f.a(reportAction);
    }

    public static void a(SceneImpl sceneImpl, com.kwad.sdk.core.network.a.a aVar) {
        ReportAction reportAction = new ReportAction(10214L);
        reportAction.f39690b = sceneImpl;
        reportAction.bf = aVar.f39568g;
        reportAction.bg = aVar.a;
        reportAction.bh = aVar.f39564c;
        reportAction.bi = aVar.f39565d;
        reportAction.bj = aVar.f39566e;
        reportAction.bk = aVar.f39567f;
        f.a(reportAction);
    }

    public static void a(String str, String str2) {
        ReportAction reportAction = new ReportAction(10006L);
        reportAction.aC = str;
        reportAction.aD = str2;
        f.a(reportAction);
    }

    public static void a(String str, String str2, boolean z) {
        if (com.kwad.sdk.core.config.b.aq()) {
            ReportAction reportAction = new ReportAction(12200L);
            reportAction.bL = str;
            reportAction.bM = str2;
            if (z) {
                f.b(reportAction);
            } else {
                f.a(reportAction);
            }
        }
    }

    public static void a(@NonNull JSONArray jSONArray) {
        ReportAction reportAction = new ReportAction(10200L);
        reportAction.aN = jSONArray;
        f.a(reportAction);
    }

    public static void a(@NonNull JSONObject jSONObject, int i) {
        ReportAction reportAction = new ReportAction(10201L);
        t.a(jSONObject, "appChangeType", i);
        reportAction.aM = jSONObject;
        f.a(reportAction);
    }

    public static void a(boolean z, List<Integer> list) {
        ReportAction reportAction = new ReportAction(10204L);
        reportAction.aW = z;
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (Integer num : list) {
                jSONArray.put(num);
            }
            reportAction.aV = jSONArray;
        }
        f.a(reportAction);
    }

    public static void b() {
        f.a(new ReportAction(10106L));
    }

    public static void b(int i) {
        ReportAction reportAction = new ReportAction(10107L);
        reportAction.aJ = i;
        f.a(reportAction);
    }

    public static void b(Context context) {
        ReportAction reportAction = new ReportAction(11L);
        JSONArray[] a2 = InstalledAppInfoManager.a(context, com.kwad.sdk.core.config.b.f());
        reportAction.X = a2[0];
        reportAction.Y = a2[1];
        f.a(reportAction);
    }

    public static void b(@NonNull AdTemplate adTemplate) {
        f.a(new ReportAction(10208L, adTemplate));
    }

    public static void b(@NonNull AdTemplate adTemplate, int i, int i2) {
        ReportAction reportAction = new ReportAction(10002L, adTemplate);
        reportAction.c();
        reportAction.aC = com.kwad.sdk.core.response.a.d.c(adTemplate) ? com.kwad.sdk.core.response.a.a.a(com.kwad.sdk.core.response.a.d.j(adTemplate)) : com.kwad.sdk.core.response.a.d.m(adTemplate);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i);
            jSONObject.put("extra", i2);
            reportAction.aD = jSONObject.toString();
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        f.a(reportAction);
    }

    public static void b(@NonNull AdTemplate adTemplate, int i, String str) {
        ReportAction reportAction = new ReportAction(107L, adTemplate);
        reportAction.aE = i;
        reportAction.aD = str;
        f.a(reportAction);
    }

    public static void b(AdTemplate adTemplate, long j) {
        ReportAction reportAction = new ReportAction(10206L, adTemplate);
        reportAction.bq = j;
        f.a(reportAction);
    }

    public static void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        ReportAction reportAction = new ReportAction(10003L, adTemplate);
        reportAction.aC = str;
        reportAction.aD = str2;
        f.a(reportAction);
    }

    public static void c(int i) {
        ReportAction reportAction = new ReportAction(10212L);
        reportAction.aZ = i;
        f.a(reportAction);
    }

    public static void c(@NonNull AdTemplate adTemplate) {
        f.a(new ReportAction(10209L, adTemplate));
    }

    public static void c(AdTemplate adTemplate, long j) {
        ReportAction reportAction = new ReportAction(10207L, adTemplate);
        reportAction.br = j;
        f.a(reportAction);
    }

    public static void c(@NonNull AdTemplate adTemplate, String str, String str2) {
        ReportAction reportAction = new ReportAction(10005L, adTemplate);
        reportAction.aC = com.kwad.sdk.core.response.a.d.c(adTemplate) ? com.kwad.sdk.core.response.a.a.a(com.kwad.sdk.core.response.a.d.j(adTemplate)) : com.kwad.sdk.core.response.a.d.m(adTemplate);
        reportAction.aC = str;
        reportAction.aD = str2;
        f.a(reportAction);
    }
}
