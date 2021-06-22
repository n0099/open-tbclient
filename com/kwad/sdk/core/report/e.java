package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f34773a = false;

    public static void a() {
        if (f34773a) {
            return;
        }
        f34773a = true;
        g.a(new a(8L));
    }

    public static void a(int i2) {
        a aVar = new a(10104L);
        aVar.P = i2;
        g.a(aVar);
    }

    public static void a(long j, long j2) {
        a aVar = new a(j);
        if (j2 > 0) {
            aVar.R = j2;
        }
        g.a(aVar);
    }

    public static void a(Context context) {
        a aVar = new a(11L);
        JSONArray[] a2 = InstalledAppInfoManager.a(context, com.kwad.sdk.core.config.c.n());
        aVar.t = a2[0];
        aVar.u = a2[1];
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate) {
        if (adTemplate.mContentPvReported) {
            return;
        }
        adTemplate.mContentPvReported = true;
        g.a(new a(20L, adTemplate));
    }

    public static void a(@NonNull AdTemplate adTemplate, int i2) {
        a aVar = new a(1L, adTemplate);
        aVar.o = i2;
        g.c(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, int i2, int i3) {
        a aVar = new a(3L, adTemplate);
        aVar.q = i2;
        aVar.r = i3;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, int i2, int i3, int i4) {
        a aVar = new a(30L, adTemplate);
        com.kwad.sdk.core.d.a.a("BatchReportManager", "reportProfileClick guideTimes=" + i4);
        aVar.o = i2;
        aVar.G = i3;
        aVar.T = i4;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, int i2, String str) {
        a aVar = new a(21L, adTemplate);
        aVar.A = i2;
        aVar.N = str;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, int i2, String str, String str2) {
        a aVar = new a(21L, adTemplate);
        aVar.A = i2;
        aVar.N = str;
        aVar.O = str2;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, long j) {
        a aVar = new a(2L, adTemplate);
        aVar.f34730f = j;
        aVar.b();
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, long j2) {
        a aVar = new a(18L, adTemplate);
        com.kwad.sdk.core.d.a.a("BatchReportManager", "stayDuration=" + j2 + " seenCount=" + j);
        aVar.z = j;
        aVar.f34731g = j2;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, long j2, int i2) {
        a aVar = new a(10203L, adTemplate);
        aVar.f34729e = j;
        aVar.f34733i = j2;
        aVar.j = i2;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, String str) {
        a aVar = new a(7L, adTemplate);
        aVar.v = str;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, String str, int i2) {
        a aVar = new a(21L, adTemplate);
        aVar.w = str;
        aVar.A = i2;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        a aVar = new a(34L, adTemplate);
        aVar.N = str;
        aVar.O = str2;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, boolean z) {
        a aVar = new a(10L, adTemplate);
        aVar.s = z ? 1 : 2;
        g.a(aVar);
    }

    public static void a(@NonNull com.kwad.sdk.core.response.model.a aVar) {
        a aVar2 = new a(19L);
        aVar2.w = aVar.f34803e;
        List<AdTemplate> list = aVar.k;
        if (list != null && list.size() > 0) {
            aVar2.f34726b = aVar.k.get(0).mAdScene;
        }
        g.a(aVar2);
    }

    public static void a(@NonNull SceneImpl sceneImpl) {
        a aVar = new a(43L);
        aVar.f34726b = sceneImpl;
        g.a(aVar);
    }

    public static void a(@NonNull SceneImpl sceneImpl, int i2) {
        a aVar = new a(46L);
        aVar.f34726b = sceneImpl;
        aVar.F = i2;
        g.a(aVar);
    }

    public static void a(@NonNull SceneImpl sceneImpl, long j) {
        a aVar = new a(28L);
        aVar.f34726b = sceneImpl;
        aVar.f34732h = j;
        g.a(aVar);
    }

    public static void a(@NonNull SceneImpl sceneImpl, long j, String str) {
        a aVar = new a(41L);
        aVar.f34726b = sceneImpl;
        aVar.C = j;
        aVar.D = str;
        g.a(aVar);
    }

    public static void a(SceneImpl sceneImpl, @NonNull AdTemplate adTemplate, long j) {
        a aVar = new a(5L, adTemplate);
        aVar.b();
        aVar.f34726b = sceneImpl;
        aVar.f34728d = j;
        g.a(aVar);
    }

    public static void a(SceneImpl sceneImpl, @NonNull AdTemplate adTemplate, long j, int i2, long j2, long j3, int i3) {
        a aVar = new a(4L, adTemplate);
        aVar.b();
        aVar.f34726b = sceneImpl;
        aVar.f34729e = j;
        aVar.p = i2;
        aVar.f34731g = j2;
        aVar.f34733i = j3;
        aVar.j = i3;
        g.c(aVar);
    }

    public static void a(@NonNull SceneImpl sceneImpl, String str) {
        a aVar = new a(36L);
        aVar.f34726b = sceneImpl;
        aVar.B = str;
        g.a(aVar);
    }

    public static void a(String str) {
        a aVar = new a(26L);
        aVar.x = str;
        g.a(aVar);
    }

    public static void a(String str, String str2) {
        a aVar = new a(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
        aVar.H = str;
        aVar.I = str2;
        g.a(aVar);
    }

    public static void a(@NonNull List<AdTemplate> list) {
        a aVar = new a(55L);
        aVar.J = b(list);
        g.a(aVar);
    }

    public static void a(@NonNull JSONArray jSONArray) {
        a aVar = new a(10200L);
        aVar.K = jSONArray;
        g.a(aVar);
    }

    public static void a(@NonNull JSONObject jSONObject, int i2) {
        a aVar = new a(10201L);
        com.kwad.sdk.utils.o.a(jSONObject, "appChangeType", i2);
        aVar.L = jSONObject;
        g.a(aVar);
    }

    public static JSONArray b(@NonNull List<AdTemplate> list) {
        JSONArray jSONArray = new JSONArray();
        for (AdTemplate adTemplate : list) {
            if (adTemplate != null) {
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.utils.o.a(jSONObject, "photoId", com.kwad.sdk.core.response.b.c.z(adTemplate));
                com.kwad.sdk.utils.o.a(jSONObject, "posId", adTemplate.posId);
                com.kwad.sdk.utils.o.a(jSONArray, jSONObject);
            }
        }
        return jSONArray;
    }

    public static void b() {
        g.a(new a(10101L));
    }

    public static void b(int i2) {
        a aVar = new a(10107L);
        aVar.Q = i2;
        g.a(aVar);
    }

    public static void b(@NonNull AdTemplate adTemplate) {
        a aVar = new a(6L, adTemplate);
        aVar.b();
        g.a(aVar);
    }

    public static void b(@NonNull AdTemplate adTemplate, int i2) {
        a aVar = new a(21L, adTemplate);
        aVar.A = i2;
        g.a(aVar);
    }

    public static void b(@NonNull AdTemplate adTemplate, int i2, int i3) {
        a aVar = new a(LightappBusinessClient.SVC_ID_H5_BALANCE, adTemplate);
        aVar.b();
        aVar.H = com.kwad.sdk.core.response.b.c.c(adTemplate) ? com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.j(adTemplate)) : com.kwad.sdk.core.response.b.c.l(adTemplate);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i2);
            jSONObject.put("extra", i3);
            aVar.I = jSONObject.toString();
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        g.a(aVar);
    }

    public static void b(AdTemplate adTemplate, int i2, String str) {
        a aVar = new a(10109L);
        aVar.f34725a = adTemplate;
        aVar.Q = i2;
        aVar.S = str;
        g.a(aVar);
    }

    public static void b(@NonNull AdTemplate adTemplate, long j) {
        a aVar = new a(14L, adTemplate);
        aVar.y = j;
        g.a(aVar);
    }

    public static void b(@NonNull AdTemplate adTemplate, String str) {
        if (adTemplate.mContentPvReported) {
            return;
        }
        adTemplate.mContentPvReported = true;
        a aVar = new a(20L, adTemplate);
        aVar.w = str;
        g.a(aVar);
    }

    public static void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        a aVar = new a(33L, adTemplate);
        aVar.N = str;
        aVar.O = str2;
        g.a(aVar);
    }

    public static void b(@NonNull SceneImpl sceneImpl) {
        com.kwad.sdk.core.scene.a.a().a(sceneImpl);
        a aVar = new a(27L);
        aVar.f34726b = sceneImpl;
        g.a(aVar);
    }

    public static void b(@NonNull SceneImpl sceneImpl, int i2) {
        a aVar = new a(52L);
        aVar.f34726b = sceneImpl;
        aVar.M = i2;
        g.a(aVar);
    }

    public static void b(@NonNull SceneImpl sceneImpl, long j, String str) {
        a aVar = new a(42L);
        aVar.f34726b = sceneImpl;
        aVar.C = j;
        aVar.D = str;
        g.a(aVar);
    }

    public static void c() {
        g.a(new a(10106L));
    }

    public static void c(@NonNull AdTemplate adTemplate) {
        g.a(new a(98L, adTemplate));
    }

    public static void c(@NonNull AdTemplate adTemplate, int i2) {
        a aVar = new a(25L, adTemplate);
        TrendInfo trendInfo = adTemplate.photoInfo.trendInfo;
        aVar.D = trendInfo.name;
        aVar.C = trendInfo.trendId;
        aVar.E = i2;
        g.a(aVar);
    }

    public static void c(@NonNull AdTemplate adTemplate, long j) {
        a aVar = new a(15L, adTemplate);
        aVar.y = j;
        g.a(aVar);
    }

    public static void c(@NonNull AdTemplate adTemplate, String str) {
        if (adTemplate.mContentPvReported) {
            return;
        }
        adTemplate.mContentPvReported = true;
        a aVar = new a(20L, adTemplate);
        aVar.N = str;
        g.a(aVar);
    }

    public static void c(@NonNull AdTemplate adTemplate, String str, String str2) {
        a aVar = new a(LightappBusinessClient.SVC_ID_H5_HOMEPAGE, adTemplate);
        aVar.H = str;
        aVar.I = str2;
        g.a(aVar);
    }

    public static void c(@NonNull SceneImpl sceneImpl) {
        com.kwad.sdk.core.scene.a.a().a(sceneImpl);
        a aVar = new a(29L);
        aVar.f34726b = sceneImpl;
        g.a(aVar);
    }

    public static void c(@NonNull SceneImpl sceneImpl, long j, String str) {
        a aVar = new a(44L);
        aVar.f34726b = sceneImpl;
        aVar.C = j;
        aVar.D = str;
        g.a(aVar);
    }

    public static void d(@NonNull AdTemplate adTemplate) {
        g.a(new a(99L, adTemplate));
    }

    public static void d(AdTemplate adTemplate, int i2) {
        a aVar = new a(10108L);
        aVar.Q = i2;
        aVar.f34725a = adTemplate;
        g.a(aVar);
    }

    public static void d(@NonNull AdTemplate adTemplate, long j) {
        a aVar = new a(10202L, adTemplate);
        aVar.k = j;
        g.a(aVar);
    }

    public static void d(@NonNull AdTemplate adTemplate, String str, String str2) {
        a aVar = new a(LightappBusinessClient.SVC_ID_H5_TRANSERECORD, adTemplate);
        aVar.H = str;
        aVar.I = str2;
        g.a(aVar);
    }

    public static void d(@NonNull SceneImpl sceneImpl) {
        a aVar = new a(35L);
        aVar.f34726b = sceneImpl;
        g.a(aVar);
    }

    public static void d(@NonNull SceneImpl sceneImpl, long j, String str) {
        a aVar = new a(45L);
        aVar.f34726b = sceneImpl;
        aVar.C = j;
        aVar.D = str;
        g.a(aVar);
    }

    public static void e(@NonNull AdTemplate adTemplate) {
        g.a(new a(9L, adTemplate));
    }

    public static void e(@NonNull AdTemplate adTemplate, int i2) {
        com.kwad.sdk.core.d.a.a("BatchReportManager", "reportProfileGuideImpression guideTimes=" + i2);
        a aVar = new a(56L, adTemplate);
        aVar.T = i2;
        g.a(aVar);
    }

    public static void e(@NonNull AdTemplate adTemplate, String str, String str2) {
        a aVar = new a(LightappBusinessClient.SVC_ID_H5_MYBANKCARD, adTemplate);
        aVar.H = com.kwad.sdk.core.response.b.c.c(adTemplate) ? com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.j(adTemplate)) : com.kwad.sdk.core.response.b.c.l(adTemplate);
        aVar.H = str;
        aVar.I = str2;
        g.a(aVar);
    }

    public static void e(@NonNull SceneImpl sceneImpl) {
        a aVar = new a(37L);
        aVar.f34726b = sceneImpl;
        g.a(aVar);
    }

    public static void f(@NonNull AdTemplate adTemplate) {
        g.a(new a(12L, adTemplate));
    }

    public static void f(@NonNull AdTemplate adTemplate, int i2) {
        com.kwad.sdk.core.d.a.a("BatchReportManager", "reportProfileGuideClick guideTimes=" + i2);
        a aVar = new a(57L, adTemplate);
        aVar.T = i2;
        g.a(aVar);
    }

    public static void f(@NonNull SceneImpl sceneImpl) {
        a aVar = new a(38L);
        aVar.f34726b = sceneImpl;
        g.a(aVar);
    }

    public static void g(@NonNull AdTemplate adTemplate) {
        g.a(new a(13L, adTemplate));
    }

    public static void h(@NonNull AdTemplate adTemplate) {
        g.a(new a(22L, adTemplate));
    }

    public static void i(@NonNull AdTemplate adTemplate) {
        g.a(new a(23L, adTemplate));
    }

    public static void j(@NonNull AdTemplate adTemplate) {
        a aVar = new a(24L, adTemplate);
        TrendInfo trendInfo = adTemplate.photoInfo.trendInfo;
        aVar.D = trendInfo.name;
        aVar.C = trendInfo.trendId;
        g.a(aVar);
    }

    public static void k(@NonNull AdTemplate adTemplate) {
        g.a(new a(31L, adTemplate));
    }

    public static void l(@NonNull AdTemplate adTemplate) {
        g.a(new a(32L, adTemplate));
    }

    public static void m(@NonNull AdTemplate adTemplate) {
        g.a(new a(LightappBusinessClient.SVC_ID_H5_CASHBACK, adTemplate));
    }

    public static void n(@NonNull AdTemplate adTemplate) {
        g.a(new a(49L, adTemplate));
    }

    public static void o(@NonNull AdTemplate adTemplate) {
        g.a(new a(50L, adTemplate));
    }

    public static void p(@NonNull AdTemplate adTemplate) {
        g.a(new a(53L, adTemplate));
    }

    public static void q(@NonNull AdTemplate adTemplate) {
        g.a(new a(54L, adTemplate));
    }

    public static void r(@NonNull AdTemplate adTemplate) {
        g.a(new a(72L, adTemplate));
    }

    public static void s(@NonNull AdTemplate adTemplate) {
        g.a(new a(73L, adTemplate));
    }
}
