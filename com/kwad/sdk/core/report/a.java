package com.kwad.sdk.core.report;

import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.z;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static ExecutorService a = com.kwad.sdk.core.i.b.g();

    /* renamed from: com.kwad.sdk.core.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0314a extends com.kwad.sdk.core.response.kwai.a {
        public int a;
        public String b;

        public C0314a(int i, String str) {
            this.a = i;
            this.b = str;
        }
    }

    public static void a(AdTemplate adTemplate) {
        g(adTemplate, 4);
    }

    public static void a(@Nullable AdTemplate adTemplate, int i) {
        p.a aVar = new p.a();
        aVar.i = i;
        a(adTemplate, (int) MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, int i2) {
        p.a aVar = new p.a();
        aVar.d = 69;
        aVar.r = i;
        aVar.s = i2;
        a(adTemplate, 501, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, int i2, int i3) {
        p.a aVar = new p.a();
        aVar.d = i;
        aVar.r = i2;
        aVar.s = i3;
        a(adTemplate, (int) Cea708Decoder.COMMAND_DLY, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, long j, int i2, @Nullable JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.x = j;
        aVar.y = i2;
        aVar.c = i;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, AdExposureFailedReason adExposureFailedReason) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
            p.a aVar = new p.a();
            aVar.e = i;
            if (adExposureFailedReason != null) {
                aVar.f = adExposureFailedReason.winEcpm;
            }
            a(adTemplate, 809, aVar, (JSONObject) null);
        }
    }

    public static void a(@Nullable final AdTemplate adTemplate, final int i, @Nullable final p.a aVar, @Nullable final JSONObject jSONObject) {
        if (adTemplate == null || !q(adTemplate)) {
            return;
        }
        if (aVar == null) {
            aVar = new p.a();
        }
        aVar.v = com.kwad.sdk.core.response.a.a.H(com.kwad.sdk.core.response.a.d.j(adTemplate));
        com.kwad.sdk.core.d.a.a("AdReportManager", i + "");
        new o() { // from class: com.kwad.sdk.core.report.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public p b() {
                return new p(AdTemplate.this, i, aVar, jSONObject);
            }
        }.d();
    }

    public static void a(AdTemplate adTemplate, int i, @Nullable z.a aVar) {
        p.a aVar2 = new p.a();
        aVar2.b = i;
        if (aVar != null) {
            aVar2.g = aVar;
        }
        a(adTemplate, 2, aVar2, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, z.a aVar, @Nullable JSONObject jSONObject) {
        p.a aVar2 = new p.a();
        aVar2.b = i;
        aVar2.g = aVar;
        a(adTemplate, 2, aVar2, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.c = i;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject, String str) {
        p.a aVar = new p.a();
        aVar.h = str;
        a(adTemplate, i, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, C0314a c0314a) {
        p.a aVar = new p.a();
        if (c0314a != null) {
            aVar.m = c0314a.toJson().toString();
        }
        a(adTemplate, 40, aVar, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, p.a aVar) {
        a(adTemplate, 50, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, p.a aVar, @Nullable JSONObject jSONObject) {
        a(adTemplate, 2, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, z.a aVar) {
        p.a aVar2 = new p.a();
        aVar2.g = aVar;
        a(adTemplate, 2, aVar2, (JSONObject) null);
    }

    public static void a(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        a(adTemplate, jSONObject, (p.a) null);
    }

    public static void a(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable p.a aVar) {
        if (adTemplate.mPvReported) {
            return;
        }
        adTemplate.mPvReported = true;
        a(adTemplate, 1, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable p.a aVar, z.a aVar2, String str) {
        if (aVar == null) {
            aVar = new p.a();
        }
        aVar.g = aVar2;
        aVar.h = str;
        a(adTemplate, 2, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable p.a aVar, String str) {
        if (aVar == null) {
            aVar = new p.a();
        }
        aVar.h = str;
        a(adTemplate, 2, aVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate) {
        p.a aVar = new p.a();
        aVar.j = adTemplate.downloadSource;
        a(adTemplate, 30, aVar, (JSONObject) null);
    }

    public static void b(@Nullable AdTemplate adTemplate, int i) {
        p.a aVar = new p.a();
        aVar.i = i;
        a(adTemplate, 321, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.a = i;
        a(adTemplate, 402, aVar, jSONObject);
    }

    public static void b(@Nullable AdTemplate adTemplate, p.a aVar) {
        a(adTemplate, 51, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, JSONObject jSONObject) {
        e(adTemplate, 601, jSONObject);
    }

    public static void c(final AdTemplate adTemplate) {
        a.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.2
            @Override // java.lang.Runnable
            public void run() {
                AdInfo j = com.kwad.sdk.core.response.a.d.j(AdTemplate.this);
                int b = ag.b(j.downloadId, com.kwad.sdk.core.response.a.a.v(j));
                p.a aVar = new p.a();
                AdTemplate adTemplate2 = AdTemplate.this;
                aVar.j = adTemplate2.downloadSource;
                aVar.k = b;
                aVar.l = adTemplate2.installFrom;
                a.a(adTemplate2, 32, aVar, (JSONObject) null);
            }
        });
    }

    public static void c(@Nullable AdTemplate adTemplate, int i) {
        p.a aVar = new p.a();
        aVar.i = i;
        a(adTemplate, 803, aVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.d = i;
        a(adTemplate, (int) Cea708Decoder.COMMAND_DLW, aVar, jSONObject);
    }

    public static void c(@Nullable AdTemplate adTemplate, p.a aVar) {
        a(adTemplate, 52, aVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.j = adTemplate.downloadSource;
        a(adTemplate, 33, aVar, jSONObject);
    }

    public static void d(AdTemplate adTemplate) {
        g(adTemplate, 36);
    }

    public static void d(AdTemplate adTemplate, int i) {
        if (adTemplate == null) {
            return;
        }
        p.a aVar = new p.a();
        aVar.p = com.kwad.sdk.core.response.a.a.v(com.kwad.sdk.core.response.a.d.j(adTemplate));
        a(adTemplate, i, aVar, new JSONObject());
    }

    public static void d(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.p = com.kwad.sdk.core.response.a.a.v(com.kwad.sdk.core.response.a.d.j(adTemplate));
        aVar.d = i;
        a(adTemplate, (int) Cea708Decoder.COMMAND_DLW, aVar, jSONObject);
    }

    public static void d(@Nullable AdTemplate adTemplate, p.a aVar) {
        a(adTemplate, 59, aVar, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.j = adTemplate.downloadSource;
        a(adTemplate, 34, aVar, jSONObject);
    }

    public static void e(AdTemplate adTemplate) {
        g(adTemplate, 38);
    }

    public static void e(AdTemplate adTemplate, int i) {
        a(adTemplate, i, new p.a(), new JSONObject());
    }

    public static void e(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        a(adTemplate, i, (p.a) null, jSONObject);
    }

    public static void e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        a.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.1
            @Override // java.lang.Runnable
            public void run() {
                p.a aVar = new p.a();
                AdTemplate adTemplate2 = AdTemplate.this;
                aVar.j = adTemplate2.downloadSource;
                a.f(adTemplate2, aVar);
                a.a(AdTemplate.this, 31, aVar, jSONObject);
                AdInfo j = com.kwad.sdk.core.response.a.d.j(AdTemplate.this);
                ag.a(j.downloadFilePath, j.downloadId);
            }
        });
    }

    public static void f(AdTemplate adTemplate) {
        g(adTemplate, 41);
    }

    public static void f(AdTemplate adTemplate, int i) {
        p.a aVar = new p.a();
        aVar.d = i;
        a(adTemplate, (int) Cea708Decoder.COMMAND_DLY, aVar, (JSONObject) null);
    }

    public static void f(AdTemplate adTemplate, p.a aVar) {
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        String str = j.downloadFilePath;
        if (str == null) {
            return;
        }
        String v = com.kwad.sdk.core.response.a.a.v(j);
        String a2 = ag.a(str);
        if (a2 == null || TextUtils.isEmpty(a2) || a2.equals(v)) {
            return;
        }
        aVar.q = a2;
        aVar.p = v;
        j.adBaseInfo.appPackageName = a2;
    }

    public static void f(AdTemplate adTemplate, JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.j = adTemplate.downloadSource;
        a(adTemplate, 35, aVar, jSONObject);
    }

    public static void g(AdTemplate adTemplate) {
        p.a aVar = new p.a();
        aVar.p = com.kwad.sdk.core.response.a.a.v(com.kwad.sdk.core.response.a.d.j(adTemplate));
        a(adTemplate, 768, aVar, new JSONObject());
    }

    public static void g(AdTemplate adTemplate, int i) {
        a(adTemplate, i, (p.a) null, new JSONObject());
    }

    public static void g(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 399, jSONObject);
    }

    public static void h(AdTemplate adTemplate) {
        g(adTemplate, 37);
    }

    public static void h(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 400, jSONObject);
    }

    public static void i(@Nullable AdTemplate adTemplate) {
        g(adTemplate, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 501, jSONObject);
    }

    public static void j(@Nullable AdTemplate adTemplate) {
        h(adTemplate, null);
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 450, jSONObject);
    }

    public static void k(@Nullable AdTemplate adTemplate) {
        g(adTemplate, 323);
    }

    public static void k(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 451, jSONObject);
    }

    public static void l(@Nullable AdTemplate adTemplate) {
        g(adTemplate, 58);
    }

    public static void m(AdTemplate adTemplate) {
        a(adTemplate, 600, (p.a) null, (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate) {
        p.a aVar = new p.a();
        aVar.u = com.kwad.sdk.core.response.a.a.ag(com.kwad.sdk.core.response.a.d.j(adTemplate));
        com.kwad.sdk.core.d.a.a("AdReportManager", "reportDownloadCardClose downloadStatus=" + aVar.u);
        a(adTemplate, 713, aVar, (JSONObject) null);
    }

    public static void o(AdTemplate adTemplate) {
        g(adTemplate, 722);
    }

    public static void p(AdTemplate adTemplate) {
        g(adTemplate, 721);
    }

    public static boolean q(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.c(adTemplate) || com.kwad.sdk.core.response.a.d.a(adTemplate);
    }
}
