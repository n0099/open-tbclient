package com.kwad.components.core.j;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.i.kwai.b;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.r;
import com.tencent.connect.common.Constants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    public static boolean HG;

    /* renamed from: com.kwad.components.core.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C0635a {
        public static final a HH = new a();
    }

    public static m a(long j, AdTemplate adTemplate, String str) {
        return new m(j, adTemplate, str);
    }

    public static m b(long j, AdTemplate adTemplate) {
        return new m(j, adTemplate);
    }

    public static m o(long j) {
        return new m(j);
    }

    public static a og() {
        return C0635a.HH;
    }

    public final void O(@NonNull AdTemplate adTemplate) {
        e.a2(b(10007L, adTemplate));
    }

    public final void P(@NonNull AdTemplate adTemplate) {
        e.a2(b(10208L, adTemplate));
    }

    public final void Q(@NonNull AdTemplate adTemplate) {
        e.a2(b(10209L, adTemplate));
    }

    public final void a(int i, @NonNull AdTemplate adTemplate, String str) {
        e.a2(a(i, adTemplate, str));
    }

    public final void a(long j, int i) {
        if (d.su()) {
            m o = o(20000L);
            o.timestamp = System.currentTimeMillis();
            o.abm = i;
            o.posId = j;
            o.abn = BuildConfig.VERSION_CODE;
            e.a2(o);
        }
    }

    public final void a(b bVar) {
        m o = o(10215L);
        o.Hx = bVar.Hx;
        o.HD = bVar.HD;
        o.HE = bVar.HE;
        o.HF = bVar.HF;
        e.a2(o);
    }

    public final void a(KsScene ksScene, boolean z, String str) {
        m o = o(10216L);
        o.aaN = z;
        o.aaO = str;
        if (ksScene instanceof SceneImpl) {
            o.HS = (SceneImpl) ksScene;
        }
        e.a2(o);
    }

    public final void a(@NonNull AdTemplate adTemplate, int i, int i2) {
        m b = b(12006L, adTemplate);
        b.Mo = i;
        b.aat = i2;
        e.a2(b);
    }

    public final void a(@NonNull AdTemplate adTemplate, long j, int i) {
        m b = b(104L, adTemplate);
        b.clickTime = k.ck(adTemplate);
        b.aaR = j;
        b.aaS = i;
        e.a2(b);
    }

    public final void a(@NonNull AdTemplate adTemplate, long j, long j2, int i) {
        m b = b(10203L, adTemplate);
        b.aao = j;
        b.blockDuration = j2;
        b.aas = i;
        e.a2(b);
    }

    public final void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        m b = b(10001L, adTemplate);
        b.failUrl = str;
        b.errorMsg = str2;
        e.a2(b);
    }

    public final void a(boolean z, List<Integer> list) {
        m o = o(10204L);
        o.aaN = z;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (Integer num : list) {
                jSONArray.put(num);
            }
            o.aaM = jSONArray;
        }
        e.a2(o);
    }

    public final void am(int i) {
        m o = o(10104L);
        o.aaD = i;
        e.a2(o);
    }

    public final void an(int i) {
        m o = o(10107L);
        o.aaE = i;
        e.a2(o);
    }

    public final void ap(Context context) {
        if (HG) {
            return;
        }
        HG = true;
        m o = o(8L);
        o.abd = f.aL(context);
        e.a2(o);
    }

    public final void aq(Context context) {
        m o = o(11L);
        JSONArray[] c = InstalledAppInfoManager.c(context, d.lD());
        o.aaw = c[0];
        o.aax = c[1];
        e.a2(o);
    }

    public final void b(@NonNull AdTemplate adTemplate, int i, int i2) {
        m b = b(10002L, adTemplate);
        b.uA();
        b.failUrl = com.kwad.sdk.core.response.a.d.bI(adTemplate) ? com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : com.kwad.sdk.core.response.a.d.bS(adTemplate);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i);
            jSONObject.put("extra", i2);
            b.errorMsg = jSONObject.toString();
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
        e.a2(b);
    }

    public final void b(AdTemplate adTemplate, int i, String str) {
        m b = b(adTemplate.isPlayAgainData ? 12300 : Constants.REQUEST_EDIT_EMOTION, adTemplate);
        b.aaE = 1;
        b.aaF = str;
        e.a2(b);
    }

    public final void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        m b = b(10003L, adTemplate);
        b.failUrl = str;
        b.errorMsg = str2;
        e.a2(b);
    }

    public final void c(@NonNull AdTemplate adTemplate, int i, String str) {
        m b = b(107L, adTemplate);
        b.errorCode = i;
        b.errorMsg = str;
        e.a2(b);
    }

    public final void c(@NonNull AdTemplate adTemplate, long j) {
        m b = b(10202L, adTemplate);
        b.aaL = j;
        e.a2(b);
    }

    public final void c(@NonNull AdTemplate adTemplate, String str, String str2) {
        m b = b(10005L, adTemplate);
        b.failUrl = com.kwad.sdk.core.response.a.d.bI(adTemplate) ? com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : com.kwad.sdk.core.response.a.d.bS(adTemplate);
        b.failUrl = str;
        b.errorMsg = str2;
        e.a2(b);
    }

    public final void c(@NonNull JSONArray jSONArray) {
        m o = o(10200L);
        o.aaH = jSONArray;
        e.a2(o);
    }

    public final void d(AdTemplate adTemplate, int i) {
        m b = b(10108L, adTemplate);
        b.aaE = i;
        e.a2(b);
    }

    public final void d(AdTemplate adTemplate, long j) {
        m b = b(10206L, adTemplate);
        b.abb = j;
        e.a2(b);
    }

    public final void e(@NonNull AdTemplate adTemplate, int i) {
        if (d.su()) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            m o = o(20000L);
            o.timestamp = System.currentTimeMillis();
            o.abm = i;
            o.trace = bQ.trace;
            o.abn = BuildConfig.VERSION_CODE;
            o.posId = com.kwad.sdk.core.response.a.d.bJ(adTemplate);
            e.a2(o);
        }
    }

    public final void e(AdTemplate adTemplate, long j) {
        m b = b(10207L, adTemplate);
        b.abc = j;
        e.a2(b);
    }

    public final void e(String str, String str2, boolean z) {
        m o = o(12200L);
        o.abk = str;
        o.abl = str2;
        e.a(o, z);
    }

    public final void e(@NonNull JSONObject jSONObject, int i) {
        m o = o(10201L);
        r.putValue(jSONObject, "appChangeType", i);
        o.aaG = jSONObject;
        e.a2(o);
    }

    public final void oh() {
        e.a2(o(10101L));
    }

    public final void oi() {
        e.a2(o(10106L));
    }
}
