package com.kwad.components.core.o;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.proxy.a.b;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.q;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static boolean Ra;

    /* renamed from: com.kwad.components.core.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0654a {
        public static final a Rc = new a();
    }

    public static a pX() {
        return C0654a.Rc;
    }

    public final void pY() {
        if (Ra) {
            return;
        }
        Ra = true;
        g.execute(new ay() { // from class: com.kwad.components.core.o.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                q C = a.C(8L);
                C.awB = f.zD();
                i.a2(C);
            }
        });
    }

    public final void pZ() {
        i.a2(C(10101L));
    }

    public final void qa() {
        i.a2(C(10106L));
    }

    public static q C(long j) {
        return new q(j);
    }

    public final void a(b bVar) {
        q C = C(10215L);
        C.QQ = bVar.QQ;
        C.QX = bVar.QX;
        C.QY = bVar.QY;
        C.QZ = bVar.QZ;
        i.a2(C);
    }

    public final void aA(int i) {
        q C = C(10107L);
        C.awc = i;
        i.a2(C);
    }

    public final void ae(Context context) {
        q C = C(11L);
        JSONArray[] c = InstalledAppInfoManager.c(context, d.yq());
        C.avT = c[0];
        C.avU = c[1];
        i.a2(C);
    }

    public final void au(@NonNull AdTemplate adTemplate) {
        i.a2(b(10007L, adTemplate));
    }

    public final void av(@NonNull AdTemplate adTemplate) {
        i.a2(b(10208L, adTemplate));
    }

    public final void aw(@NonNull AdTemplate adTemplate) {
        i.a2(b(10209L, adTemplate));
    }

    public final void az(int i) {
        q C = C(10104L);
        C.awb = i;
        i.a2(C);
    }

    public final void c(@NonNull JSONArray jSONArray) {
        q C = C(10200L);
        C.awf = jSONArray;
        i.a2(C);
    }

    public static q a(long j, AdTemplate adTemplate, String str) {
        return new q(j, adTemplate, str);
    }

    public final void b(@NonNull AdTemplate adTemplate, int i, int i2) {
        q b = b(12006L, adTemplate);
        b.Xe = i;
        b.avQ = i2;
        i.a2(b);
    }

    public final void e(String str, String str2, boolean z) {
        q C = C(12200L);
        C.awI = str;
        C.awJ = str2;
        i.a(C, z);
    }

    public final void f(AdTemplate adTemplate, int i, String str) {
        q b = b(10109L, adTemplate);
        b.awc = 1;
        b.awd = str;
        i.a2(b);
    }

    public final void g(@NonNull AdTemplate adTemplate, int i, String str) {
        q b = b(107L, adTemplate);
        b.errorCode = i;
        b.errorMsg = str;
        i.a2(b);
    }

    public static q b(long j, AdTemplate adTemplate) {
        return new q(j, adTemplate);
    }

    public final void a(long j, int i) {
        if (!d.Bm()) {
            return;
        }
        q C = C(20000L);
        C.timestamp = System.currentTimeMillis();
        C.awK = i;
        C.posId = j;
        C.awL = BuildConfig.VERSION_CODE;
        i.a2(C);
    }

    public final void e(AdTemplate adTemplate, int i) {
        q b = b(10108L, adTemplate);
        b.awc = i;
        i.a2(b);
    }

    public final void f(@NonNull AdTemplate adTemplate, int i) {
        if (!d.Bm()) {
            return;
        }
        AdInfo dP = e.dP(adTemplate);
        q C = C(20000L);
        C.timestamp = System.currentTimeMillis();
        C.awK = i;
        C.trace = dP.trace;
        C.awL = BuildConfig.VERSION_CODE;
        C.posId = e.dI(adTemplate);
        i.a2(C);
    }

    public final void g(@NonNull AdTemplate adTemplate, long j) {
        q b = b(10202L, adTemplate);
        b.awj = j;
        i.a2(b);
    }

    public final void h(AdTemplate adTemplate, long j) {
        q b = b(10206L, adTemplate);
        b.awz = j;
        i.a2(b);
    }

    public final void i(AdTemplate adTemplate, long j) {
        q b = b(10207L, adTemplate);
        b.awA = j;
        i.a2(b);
    }

    public final void a(int i, @NonNull AdTemplate adTemplate, String str) {
        i.a2(a(i, adTemplate, str));
    }

    public final void b(@NonNull AdTemplate adTemplate, long j, int i) {
        q b = b(104L, adTemplate);
        b.clickTime = l.el(adTemplate);
        b.awp = j;
        b.awq = i;
        i.a2(b);
    }

    public final void a(@NonNull AdTemplate adTemplate, long j, long j2, int i) {
        q b = b(10203L, adTemplate);
        b.aaf = j;
        b.blockDuration = j2;
        b.avP = i;
        i.a2(b);
    }

    public final void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        q b = b(10003L, adTemplate);
        b.awa = str;
        b.errorMsg = str2;
        i.a2(b);
    }

    public final void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        q b = b(10005L, adTemplate);
        if (e.dH(adTemplate)) {
            b.awa = com.kwad.sdk.core.response.b.a.K(e.dP(adTemplate));
        } else {
            b.awa = e.dR(adTemplate);
        }
        b.awa = str;
        b.errorMsg = str2;
        i.a2(b);
    }

    public final void a(SceneImpl sceneImpl, boolean z, String str) {
        q C = C(10216L);
        C.awl = z;
        C.awm = str;
        C.adScene = sceneImpl;
        i.a2(C);
    }

    public final void a(boolean z, List<Integer> list) {
        q C = C(10204L);
        C.awl = z;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (Integer num : list) {
                jSONArray.put(num);
            }
            C.awk = jSONArray;
        }
        i.a2(C);
    }

    public final void e(@NonNull JSONObject jSONObject, int i) {
        q C = C(10201L);
        t.putValue(jSONObject, "appChangeType", i);
        C.awe = jSONObject;
        i.a2(C);
    }

    public final void c(@NonNull AdTemplate adTemplate, int i, int i2) {
        q b = b(10002L, adTemplate);
        b.DD();
        if (e.dH(adTemplate)) {
            b.awa = com.kwad.sdk.core.response.b.a.K(e.dP(adTemplate));
        } else {
            b.awa = e.dR(adTemplate);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i);
            jSONObject.put("extra", i2);
            b.errorMsg = jSONObject.toString();
        } catch (JSONException e) {
            c.printStackTraceOnly(e);
        }
        i.a2(b);
    }
}
