package com.kwad.sdk.core.report;

import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.z;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static ExecutorService a = com.kwad.sdk.core.i.b.g();

    /* renamed from: com.kwad.sdk.core.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2110a extends com.kwad.sdk.core.response.kwai.a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f56032b;

        public C2110a(int i2, String str) {
            this.a = i2;
            this.f56032b = str;
        }
    }

    public static void a(AdTemplate adTemplate) {
        g(adTemplate, 4);
    }

    public static void a(@Nullable AdTemplate adTemplate, int i2) {
        p.a aVar = new p.a();
        aVar.f56068i = i2;
        a(adTemplate, (int) MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i2, int i3) {
        p.a aVar = new p.a();
        aVar.f56063d = 69;
        aVar.r = i2;
        aVar.s = i3;
        a(adTemplate, 501, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i2, int i3, int i4) {
        p.a aVar = new p.a();
        aVar.f56063d = i2;
        aVar.r = i3;
        aVar.s = i4;
        a(adTemplate, 141, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i2, long j2, int i3, @Nullable JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.x = j2;
        aVar.y = i3;
        aVar.f56062c = i2;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i2, AdExposureFailedReason adExposureFailedReason) {
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            p.a aVar = new p.a();
            aVar.f56064e = i2;
            if (adExposureFailedReason != null) {
                aVar.f56065f = adExposureFailedReason.winEcpm;
            }
            a(adTemplate, 809, aVar, (JSONObject) null);
        }
    }

    public static void a(@Nullable final AdTemplate adTemplate, final int i2, @Nullable final p.a aVar, @Nullable final JSONObject jSONObject) {
        if (adTemplate == null || !q(adTemplate)) {
            return;
        }
        if (aVar == null) {
            aVar = new p.a();
        }
        aVar.v = com.kwad.sdk.core.response.a.a.H(com.kwad.sdk.core.response.a.d.j(adTemplate));
        com.kwad.sdk.core.d.a.a("AdReportManager", i2 + "");
        new o() { // from class: com.kwad.sdk.core.report.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public p b() {
                return new p(AdTemplate.this, i2, aVar, jSONObject);
            }
        }.d();
    }

    public static void a(AdTemplate adTemplate, int i2, @Nullable z.a aVar) {
        p.a aVar2 = new p.a();
        aVar2.f56061b = i2;
        if (aVar != null) {
            aVar2.f56066g = aVar;
        }
        a(adTemplate, 2, aVar2, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i2, z.a aVar, @Nullable JSONObject jSONObject) {
        p.a aVar2 = new p.a();
        aVar2.f56061b = i2;
        aVar2.f56066g = aVar;
        a(adTemplate, 2, aVar2, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.f56062c = i2;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i2, JSONObject jSONObject, String str) {
        p.a aVar = new p.a();
        aVar.f56067h = str;
        a(adTemplate, i2, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, C2110a c2110a) {
        p.a aVar = new p.a();
        if (c2110a != null) {
            aVar.m = c2110a.toJson().toString();
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
        aVar2.f56066g = aVar;
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
        aVar.f56066g = aVar2;
        aVar.f56067h = str;
        a(adTemplate, 2, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable p.a aVar, String str) {
        if (aVar == null) {
            aVar = new p.a();
        }
        aVar.f56067h = str;
        a(adTemplate, 2, aVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate) {
        p.a aVar = new p.a();
        aVar.f56069j = adTemplate.downloadSource;
        a(adTemplate, 30, aVar, (JSONObject) null);
    }

    public static void b(@Nullable AdTemplate adTemplate, int i2) {
        p.a aVar = new p.a();
        aVar.f56068i = i2;
        a(adTemplate, 321, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.a = i2;
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
                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(AdTemplate.this);
                int b2 = ag.b(j2.downloadId, com.kwad.sdk.core.response.a.a.v(j2));
                p.a aVar = new p.a();
                AdTemplate adTemplate2 = AdTemplate.this;
                aVar.f56069j = adTemplate2.downloadSource;
                aVar.k = b2;
                aVar.l = adTemplate2.installFrom;
                a.a(adTemplate2, 32, aVar, (JSONObject) null);
            }
        });
    }

    public static void c(@Nullable AdTemplate adTemplate, int i2) {
        p.a aVar = new p.a();
        aVar.f56068i = i2;
        a(adTemplate, 803, aVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.f56063d = i2;
        a(adTemplate, (int) PbFullScreenEditorActivity.REPLY_MAX_SIZE, aVar, jSONObject);
    }

    public static void c(@Nullable AdTemplate adTemplate, p.a aVar) {
        a(adTemplate, 52, aVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.f56069j = adTemplate.downloadSource;
        a(adTemplate, 33, aVar, jSONObject);
    }

    public static void d(AdTemplate adTemplate) {
        g(adTemplate, 36);
    }

    public static void d(AdTemplate adTemplate, int i2) {
        if (adTemplate == null) {
            return;
        }
        p.a aVar = new p.a();
        aVar.p = com.kwad.sdk.core.response.a.a.v(com.kwad.sdk.core.response.a.d.j(adTemplate));
        a(adTemplate, i2, aVar, new JSONObject());
    }

    public static void d(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.p = com.kwad.sdk.core.response.a.a.v(com.kwad.sdk.core.response.a.d.j(adTemplate));
        aVar.f56063d = i2;
        a(adTemplate, (int) PbFullScreenEditorActivity.REPLY_MAX_SIZE, aVar, jSONObject);
    }

    public static void d(@Nullable AdTemplate adTemplate, p.a aVar) {
        a(adTemplate, 59, aVar, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.f56069j = adTemplate.downloadSource;
        a(adTemplate, 34, aVar, jSONObject);
    }

    public static void e(AdTemplate adTemplate) {
        g(adTemplate, 38);
    }

    public static void e(AdTemplate adTemplate, int i2) {
        a(adTemplate, i2, new p.a(), new JSONObject());
    }

    public static void e(AdTemplate adTemplate, int i2, JSONObject jSONObject) {
        a(adTemplate, i2, (p.a) null, jSONObject);
    }

    public static void e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        a.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.1
            @Override // java.lang.Runnable
            public void run() {
                p.a aVar = new p.a();
                AdTemplate adTemplate2 = AdTemplate.this;
                aVar.f56069j = adTemplate2.downloadSource;
                a.f(adTemplate2, aVar);
                a.a(AdTemplate.this, 31, aVar, jSONObject);
                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(AdTemplate.this);
                ag.a(j2.downloadFilePath, j2.downloadId);
            }
        });
    }

    public static void f(AdTemplate adTemplate) {
        g(adTemplate, 41);
    }

    public static void f(AdTemplate adTemplate, int i2) {
        p.a aVar = new p.a();
        aVar.f56063d = i2;
        a(adTemplate, 141, aVar, (JSONObject) null);
    }

    public static void f(AdTemplate adTemplate, p.a aVar) {
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        String str = j2.downloadFilePath;
        if (str == null) {
            return;
        }
        String v = com.kwad.sdk.core.response.a.a.v(j2);
        String a2 = ag.a(str);
        if (a2 == null || TextUtils.isEmpty(a2) || a2.equals(v)) {
            return;
        }
        aVar.q = a2;
        aVar.p = v;
        j2.adBaseInfo.appPackageName = a2;
    }

    public static void f(AdTemplate adTemplate, JSONObject jSONObject) {
        p.a aVar = new p.a();
        aVar.f56069j = adTemplate.downloadSource;
        a(adTemplate, 35, aVar, jSONObject);
    }

    public static void g(AdTemplate adTemplate) {
        p.a aVar = new p.a();
        aVar.p = com.kwad.sdk.core.response.a.a.v(com.kwad.sdk.core.response.a.d.j(adTemplate));
        a(adTemplate, 768, aVar, new JSONObject());
    }

    public static void g(AdTemplate adTemplate, int i2) {
        a(adTemplate, i2, (p.a) null, new JSONObject());
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
