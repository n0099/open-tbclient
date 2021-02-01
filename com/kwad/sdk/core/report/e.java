package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f9417a = false;

    public static void a() {
        if (f9417a) {
            return;
        }
        f9417a = true;
        g.a(new a(8L));
    }

    public static void a(int i) {
        a aVar = new a(10104L);
        aVar.P = i;
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

    public static void a(@NonNull AdTemplate adTemplate, int i) {
        a aVar = new a(1L, adTemplate);
        aVar.o = i;
        g.c(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, int i, int i2) {
        a aVar = new a(3L, adTemplate);
        aVar.q = i;
        aVar.r = i2;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, int i, int i2, int i3) {
        a aVar = new a(30L, adTemplate);
        com.kwad.sdk.core.d.a.a("BatchReportManager", "reportProfileClick guideTimes=" + i3);
        aVar.o = i;
        aVar.G = i2;
        aVar.T = i3;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, int i, String str) {
        a aVar = new a(21L, adTemplate);
        aVar.A = i;
        aVar.N = str;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, int i, String str, String str2) {
        a aVar = new a(21L, adTemplate);
        aVar.A = i;
        aVar.N = str;
        aVar.O = str2;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, long j) {
        a aVar = new a(2L, adTemplate);
        aVar.f = j;
        aVar.b();
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, long j2) {
        a aVar = new a(18L, adTemplate);
        com.kwad.sdk.core.d.a.a("BatchReportManager", "stayDuration=" + j2 + " seenCount=" + j);
        aVar.z = j;
        aVar.g = j2;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, long j2, int i) {
        a aVar = new a(10203L, adTemplate);
        aVar.e = j;
        aVar.i = j2;
        aVar.j = i;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, String str) {
        a aVar = new a(7L, adTemplate);
        aVar.v = str;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, String str, int i) {
        a aVar = new a(21L, adTemplate);
        aVar.w = str;
        aVar.A = i;
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
        aVar2.w = aVar.e;
        if (aVar.k != null && aVar.k.size() > 0) {
            aVar2.f9388b = aVar.k.get(0).mAdScene;
        }
        g.a(aVar2);
    }

    public static void a(@NonNull SceneImpl sceneImpl) {
        a aVar = new a(43L);
        aVar.f9388b = sceneImpl;
        g.a(aVar);
    }

    public static void a(@NonNull SceneImpl sceneImpl, int i) {
        a aVar = new a(46L);
        aVar.f9388b = sceneImpl;
        aVar.F = i;
        g.a(aVar);
    }

    public static void a(@NonNull SceneImpl sceneImpl, long j) {
        a aVar = new a(28L);
        aVar.f9388b = sceneImpl;
        aVar.h = j;
        g.a(aVar);
    }

    public static void a(@NonNull SceneImpl sceneImpl, long j, String str) {
        a aVar = new a(41L);
        aVar.f9388b = sceneImpl;
        aVar.C = j;
        aVar.D = str;
        g.a(aVar);
    }

    public static void a(SceneImpl sceneImpl, @NonNull AdTemplate adTemplate, long j) {
        a aVar = new a(5L, adTemplate);
        aVar.b();
        aVar.f9388b = sceneImpl;
        aVar.d = j;
        g.a(aVar);
    }

    public static void a(SceneImpl sceneImpl, @NonNull AdTemplate adTemplate, long j, int i, long j2, long j3, int i2) {
        a aVar = new a(4L, adTemplate);
        aVar.b();
        aVar.f9388b = sceneImpl;
        aVar.e = j;
        aVar.p = i;
        aVar.g = j2;
        aVar.i = j3;
        aVar.j = i2;
        g.c(aVar);
    }

    public static void a(@NonNull SceneImpl sceneImpl, String str) {
        a aVar = new a(36L);
        aVar.f9388b = sceneImpl;
        aVar.B = str;
        g.a(aVar);
    }

    public static void a(String str) {
        a aVar = new a(26L);
        aVar.x = str;
        g.a(aVar);
    }

    public static void a(String str, String str2) {
        a aVar = new a(10006L);
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

    public static void a(@NonNull JSONObject jSONObject, int i) {
        a aVar = new a(10201L);
        com.kwad.sdk.utils.o.a(jSONObject, "appChangeType", i);
        aVar.L = jSONObject;
        g.a(aVar);
    }

    private static JSONArray b(@NonNull List<AdTemplate> list) {
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

    public static void b(int i) {
        a aVar = new a(10107L);
        aVar.Q = i;
        g.a(aVar);
    }

    public static void b(@NonNull AdTemplate adTemplate) {
        a aVar = new a(6L, adTemplate);
        aVar.b();
        g.a(aVar);
    }

    public static void b(@NonNull AdTemplate adTemplate, int i) {
        a aVar = new a(21L, adTemplate);
        aVar.A = i;
        g.a(aVar);
    }

    public static void b(@NonNull AdTemplate adTemplate, int i, int i2) {
        a aVar = new a(10002L, adTemplate);
        aVar.b();
        if (com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            aVar.H = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.j(adTemplate));
        } else {
            aVar.H = com.kwad.sdk.core.response.b.c.l(adTemplate);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i);
            jSONObject.put("extra", i2);
            aVar.I = jSONObject.toString();
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.b(e);
        }
        g.a(aVar);
    }

    public static void b(AdTemplate adTemplate, int i, String str) {
        a aVar = new a(10109L);
        aVar.f9387a = adTemplate;
        aVar.Q = i;
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
        aVar.f9388b = sceneImpl;
        g.a(aVar);
    }

    public static void b(@NonNull SceneImpl sceneImpl, int i) {
        a aVar = new a(52L);
        aVar.f9388b = sceneImpl;
        aVar.M = i;
        g.a(aVar);
    }

    public static void b(@NonNull SceneImpl sceneImpl, long j, String str) {
        a aVar = new a(42L);
        aVar.f9388b = sceneImpl;
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

    public static void c(@NonNull AdTemplate adTemplate, int i) {
        a aVar = new a(25L, adTemplate);
        aVar.D = adTemplate.photoInfo.trendInfo.name;
        aVar.C = adTemplate.photoInfo.trendInfo.trendId;
        aVar.E = i;
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
        a aVar = new a(10001L, adTemplate);
        aVar.H = str;
        aVar.I = str2;
        g.a(aVar);
    }

    public static void c(@NonNull SceneImpl sceneImpl) {
        com.kwad.sdk.core.scene.a.a().a(sceneImpl);
        a aVar = new a(29L);
        aVar.f9388b = sceneImpl;
        g.a(aVar);
    }

    public static void c(@NonNull SceneImpl sceneImpl, long j, String str) {
        a aVar = new a(44L);
        aVar.f9388b = sceneImpl;
        aVar.C = j;
        aVar.D = str;
        g.a(aVar);
    }

    public static void d(@NonNull AdTemplate adTemplate) {
        g.a(new a(99L, adTemplate));
    }

    public static void d(AdTemplate adTemplate, int i) {
        a aVar = new a(10108L);
        aVar.Q = i;
        aVar.f9387a = adTemplate;
        g.a(aVar);
    }

    public static void d(@NonNull AdTemplate adTemplate, long j) {
        a aVar = new a(10202L, adTemplate);
        aVar.k = j;
        g.a(aVar);
    }

    public static void d(@NonNull AdTemplate adTemplate, String str, String str2) {
        a aVar = new a(10003L, adTemplate);
        aVar.H = str;
        aVar.I = str2;
        g.a(aVar);
    }

    public static void d(@NonNull SceneImpl sceneImpl) {
        a aVar = new a(35L);
        aVar.f9388b = sceneImpl;
        g.a(aVar);
    }

    public static void d(@NonNull SceneImpl sceneImpl, long j, String str) {
        a aVar = new a(45L);
        aVar.f9388b = sceneImpl;
        aVar.C = j;
        aVar.D = str;
        g.a(aVar);
    }

    public static void e(@NonNull AdTemplate adTemplate) {
        g.a(new a(9L, adTemplate));
    }

    public static void e(@NonNull AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.d.a.a("BatchReportManager", "reportProfileGuideImpression guideTimes=" + i);
        a aVar = new a(56L, adTemplate);
        aVar.T = i;
        g.a(aVar);
    }

    public static void e(@NonNull AdTemplate adTemplate, String str, String str2) {
        a aVar = new a(10005L, adTemplate);
        if (com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            aVar.H = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.j(adTemplate));
        } else {
            aVar.H = com.kwad.sdk.core.response.b.c.l(adTemplate);
        }
        aVar.H = str;
        aVar.I = str2;
        g.a(aVar);
    }

    public static void e(@NonNull SceneImpl sceneImpl) {
        a aVar = new a(37L);
        aVar.f9388b = sceneImpl;
        g.a(aVar);
    }

    public static void f(@NonNull AdTemplate adTemplate) {
        g.a(new a(12L, adTemplate));
    }

    public static void f(@NonNull AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.d.a.a("BatchReportManager", "reportProfileGuideClick guideTimes=" + i);
        a aVar = new a(57L, adTemplate);
        aVar.T = i;
        g.a(aVar);
    }

    public static void f(@NonNull SceneImpl sceneImpl) {
        a aVar = new a(38L);
        aVar.f9388b = sceneImpl;
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
        aVar.D = adTemplate.photoInfo.trendInfo.name;
        aVar.C = adTemplate.photoInfo.trendInfo.trendId;
        g.a(aVar);
    }

    public static void k(@NonNull AdTemplate adTemplate) {
        g.a(new a(31L, adTemplate));
    }

    public static void l(@NonNull AdTemplate adTemplate) {
        g.a(new a(32L, adTemplate));
    }

    public static void m(@NonNull AdTemplate adTemplate) {
        g.a(new a(10007L, adTemplate));
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
