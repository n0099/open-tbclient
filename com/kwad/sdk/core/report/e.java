package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f32584a = false;

    public static void a() {
        g.a(new a(10101L));
    }

    public static void a(int i2) {
        a aVar = new a(10104L);
        aVar.Z = i2;
        g.a(aVar);
    }

    public static void a(long j, long j2) {
        a aVar = new a(j);
        if (j2 > 0) {
            aVar.ab = j2;
        }
        g.a(aVar);
    }

    public static void a(Context context) {
        if (f32584a) {
            return;
        }
        f32584a = true;
        a aVar = new a(8L);
        aVar.ao = com.kwad.sdk.collector.e.a(context);
        g.a(aVar);
    }

    public static void a(KsScene ksScene, boolean z, String str) {
        a aVar = new a(10216L);
        aVar.ai = z;
        aVar.ak = str;
        if (ksScene instanceof SceneImpl) {
            aVar.f32539b = (SceneImpl) ksScene;
        }
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate) {
        g.a(new a(LightappBusinessClient.SVC_ID_H5_CASHBACK, adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i2) {
        a aVar = new a(10108L);
        aVar.aa = i2;
        aVar.f32538a = adTemplate;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, int i2, int i3) {
        a aVar = new a(LightappBusinessClient.SVC_ID_H5_BALANCE, adTemplate);
        aVar.b();
        aVar.Q = com.kwad.sdk.core.response.b.c.a(adTemplate) ? com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.g(adTemplate)) : com.kwad.sdk.core.response.b.c.i(adTemplate);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i2);
            jSONObject.put("extra", i3);
            aVar.R = jSONObject.toString();
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        g.a(aVar);
    }

    public static void a(AdTemplate adTemplate, int i2, String str) {
        a aVar = new a(10109L);
        aVar.f32538a = adTemplate;
        aVar.aa = i2;
        aVar.ac = str;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, long j) {
        a aVar = new a(10202L, adTemplate);
        aVar.k = j;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, long j2, int i2) {
        a aVar = new a(10203L, adTemplate);
        aVar.f32542e = j;
        aVar.f32546i = j2;
        aVar.j = i2;
        g.a(aVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        a aVar = new a(LightappBusinessClient.SVC_ID_H5_HOMEPAGE, adTemplate);
        aVar.Q = str;
        aVar.R = str2;
        g.a(aVar);
    }

    public static void a(String str, String str2) {
        a aVar = new a(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
        aVar.Q = str;
        aVar.R = str2;
        g.a(aVar);
    }

    public static void a(@NonNull JSONArray jSONArray) {
        a aVar = new a(10200L);
        aVar.U = jSONArray;
        g.a(aVar);
    }

    public static void a(@NonNull JSONObject jSONObject, int i2) {
        a aVar = new a(10201L);
        com.kwad.sdk.utils.o.a(jSONObject, "appChangeType", i2);
        aVar.V = jSONObject;
        g.a(aVar);
    }

    public static void a(boolean z, List<Integer> list) {
        a aVar = new a(10204L);
        aVar.ai = z;
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (Integer num : list) {
                jSONArray.put(num);
            }
            aVar.ah = jSONArray;
        }
        g.a(aVar);
    }

    public static void b() {
        g.a(new a(10106L));
    }

    public static void b(int i2) {
        a aVar = new a(10107L);
        aVar.aa = i2;
        g.a(aVar);
    }

    public static void b(Context context) {
        a aVar = new a(11L);
        JSONArray[] a2 = InstalledAppInfoManager.a(context, com.kwad.sdk.core.config.c.e());
        aVar.A = a2[0];
        aVar.B = a2[1];
        g.a(aVar);
    }

    public static void b(@NonNull AdTemplate adTemplate) {
        g.a(new a(10208L, adTemplate));
    }

    public static void b(@NonNull AdTemplate adTemplate, int i2, String str) {
        a aVar = new a(107L, adTemplate);
        aVar.S = i2;
        aVar.R = str;
        g.a(aVar);
    }

    public static void b(AdTemplate adTemplate, long j) {
        a aVar = new a(10206L);
        aVar.f32538a = adTemplate;
        aVar.am = j;
        g.a(aVar);
    }

    public static void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        a aVar = new a(LightappBusinessClient.SVC_ID_H5_TRANSERECORD, adTemplate);
        aVar.Q = str;
        aVar.R = str2;
        g.a(aVar);
    }

    public static void c(int i2) {
        a aVar = new a(10212L);
        aVar.aj = i2;
        g.a(aVar);
    }

    public static void c(@NonNull AdTemplate adTemplate) {
        g.a(new a(10209L, adTemplate));
    }

    public static void c(AdTemplate adTemplate, long j) {
        a aVar = new a(10207L);
        aVar.an = j;
        aVar.f32538a = adTemplate;
        g.a(aVar);
    }

    public static void c(@NonNull AdTemplate adTemplate, String str, String str2) {
        a aVar = new a(LightappBusinessClient.SVC_ID_H5_MYBANKCARD, adTemplate);
        aVar.Q = com.kwad.sdk.core.response.b.c.a(adTemplate) ? com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.g(adTemplate)) : com.kwad.sdk.core.response.b.c.i(adTemplate);
        aVar.Q = str;
        aVar.R = str2;
        g.a(aVar);
    }
}
