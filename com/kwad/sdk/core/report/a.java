package com.kwad.sdk.core.report;

import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.y;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public static ExecutorService a = com.kwad.sdk.core.threads.b.f();

    @KsJson
    /* renamed from: com.kwad.sdk.core.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0544a extends com.kwad.sdk.core.response.kwai.a {
        public int a;
        public String b;

        public C0544a(int i, String str) {
            this.a = i;
            this.b = str;
        }
    }

    public static void a(AdTemplate adTemplate) {
        l(adTemplate, 4);
    }

    public static void a(AdTemplate adTemplate, int i) {
        u.b bVar = new u.b();
        bVar.P = 8;
        b(adTemplate, 2, bVar, null);
    }

    public static void a(@Nullable AdTemplate adTemplate, int i, int i2) {
        u.b bVar = new u.b();
        bVar.x = i;
        bVar.P = i2;
        b(adTemplate, 323, bVar, null);
    }

    public static void a(AdTemplate adTemplate, int i, int i2, int i3) {
        u.b bVar = new u.b();
        bVar.e = 114;
        bVar.t = i2;
        bVar.u = i3;
        b(adTemplate, Cea708Decoder.COMMAND_DLY, bVar, null);
    }

    public static void a(AdTemplate adTemplate, int i, long j, int i2, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.D = j;
        bVar.E = i2;
        bVar.d = i;
        b(adTemplate, 3, bVar, null);
    }

    public static void a(AdTemplate adTemplate, int i, AdExposureFailedReason adExposureFailedReason) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
            u.b bVar = new u.b();
            bVar.f = i;
            if (adExposureFailedReason != null) {
                bVar.g = adExposureFailedReason.winEcpm;
            }
            b(adTemplate, 809, bVar, null);
        }
    }

    public static void a(@Nullable AdTemplate adTemplate, int i, u.b bVar) {
        if (bVar == null) {
            bVar = new u.b();
        }
        bVar.k = i;
        b(adTemplate, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, bVar, null);
    }

    public static void a(AdTemplate adTemplate, int i, @NonNull u.b bVar, @Nullable JSONObject jSONObject) {
        bVar.e = i;
        b(adTemplate, Cea708Decoder.COMMAND_DLW, bVar, null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, @Nullable y.a aVar) {
        u.b bVar = new u.b();
        bVar.c = i;
        if (aVar != null) {
            bVar.i = aVar;
        }
        a(adTemplate, bVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, y.a aVar, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.c = i;
        bVar.i = aVar;
        a(adTemplate, bVar, jSONObject);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.d = i;
        b(adTemplate, 3, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject, String str) {
        u.b bVar = new u.b();
        bVar.j = str;
        b(adTemplate, i, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, C0544a c0544a) {
        u.b bVar = new u.b();
        bVar.o = c0544a.toJson().toString();
        b(adTemplate, 40, bVar, null);
    }

    public static void a(AdTemplate adTemplate, @Nullable f fVar) {
        b(adTemplate, Cea708Decoder.COMMAND_DLY, fVar != null ? fVar.a() : null, null);
    }

    public static void a(AdTemplate adTemplate, f fVar, JSONObject jSONObject) {
        a(adTemplate, fVar != null ? fVar.a() : null, jSONObject);
    }

    public static void a(@Nullable AdTemplate adTemplate, u.b bVar) {
        b(adTemplate, 50, bVar, null);
    }

    public static void a(AdTemplate adTemplate, u.b bVar, @Nullable JSONObject jSONObject) {
        if (bVar != null && adTemplate.fromCache) {
            bVar.a(g.a(adTemplate));
        }
        b(adTemplate, 2, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, JSONObject jSONObject) {
        e(adTemplate, 601, jSONObject);
    }

    public static void a(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable f fVar) {
        if (adTemplate.mPvReported) {
            return;
        }
        adTemplate.mPvReported = true;
        AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
        if (fVar == null) {
            fVar = new f();
        }
        u.b a2 = fVar.a();
        if (adTemplate.fromCache) {
            a2.a(g.a(adTemplate));
        }
        a2.y = a(i) ? 1 : 0;
        b(adTemplate, 1, a2, jSONObject);
    }

    public static boolean a(AdInfo adInfo) {
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class);
        if (dVar == null) {
            return false;
        }
        String C = com.kwad.sdk.core.response.a.a.C(adInfo);
        if (TextUtils.isEmpty(C)) {
            return false;
        }
        return af.a(dVar.a(), C);
    }

    public static void b(AdTemplate adTemplate) {
        u.b bVar = new u.b();
        bVar.l = adTemplate.downloadSource;
        b(adTemplate, 30, bVar, null);
    }

    public static void b(AdTemplate adTemplate, int i) {
        u.b bVar = new u.b();
        bVar.K = i;
        b(adTemplate, 37, bVar, null);
    }

    public static void b(AdTemplate adTemplate, int i, int i2) {
        u.b bVar = new u.b();
        bVar.e = 69;
        bVar.t = i;
        bVar.u = i2;
        b(adTemplate, 501, bVar, null);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v0 int)] */
    public static void b(@Nullable final AdTemplate adTemplate, final int i, @Nullable final u.b bVar, @Nullable final JSONObject jSONObject) {
        if (adTemplate == null || !p(adTemplate)) {
            return;
        }
        if (bVar == null) {
            bVar = new u.b();
        }
        bVar.A = com.kwad.sdk.core.response.a.a.O(com.kwad.sdk.core.response.a.d.i(adTemplate));
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        com.kwad.sdk.core.d.b.a("AdReportManager", sb.toString());
        bVar.M = adTemplate.adxResult;
        new t() { // from class: com.kwad.sdk.core.report.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public u createRequest() {
                return new u(AdTemplate.this, i, bVar, jSONObject);
            }
        }.fetch();
    }

    public static void b(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.a = i;
        b(adTemplate, 402, bVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate, f fVar, @Nullable JSONObject jSONObject) {
        b(adTemplate, 3, fVar != null ? fVar.a() : null, null);
    }

    public static void b(@Nullable AdTemplate adTemplate, u.b bVar) {
        b(adTemplate, 51, bVar, null);
    }

    public static void b(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.l = adTemplate.downloadSource;
        b(adTemplate, 33, bVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate, @Nullable JSONObject jSONObject, f fVar) {
        b(adTemplate, 451, fVar != null ? fVar.a() : null, null);
    }

    public static void c(final AdTemplate adTemplate) {
        a.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.2
            @Override // java.lang.Runnable
            public final void run() {
                AdInfo i = com.kwad.sdk.core.response.a.d.i(AdTemplate.this);
                int b = af.b(i.downloadId, com.kwad.sdk.core.response.a.a.C(i));
                u.b bVar = new u.b();
                AdTemplate adTemplate2 = AdTemplate.this;
                bVar.l = adTemplate2.downloadSource;
                bVar.m = b;
                bVar.n = adTemplate2.installFrom;
                a.b(adTemplate2, 32, bVar, null);
            }
        });
    }

    public static void c(@Nullable AdTemplate adTemplate, int i) {
        a(adTemplate, 2, (u.b) null);
    }

    public static void c(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.e = i;
        b(adTemplate, Cea708Decoder.COMMAND_DLW, bVar, jSONObject);
    }

    public static void c(@Nullable AdTemplate adTemplate, u.b bVar) {
        b(adTemplate, 52, bVar, null);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.l = adTemplate.downloadSource;
        b(adTemplate, 34, bVar, jSONObject);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject, f fVar) {
        b(adTemplate, Cea708Decoder.COMMAND_DLW, fVar != null ? fVar.a() : null, jSONObject);
    }

    public static void d(AdTemplate adTemplate) {
        l(adTemplate, 36);
    }

    public static void d(@Nullable AdTemplate adTemplate, int i) {
        u.b bVar = new u.b();
        bVar.k = i;
        b(adTemplate, 321, bVar, null);
    }

    public static void d(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.r = com.kwad.sdk.core.response.a.a.C(com.kwad.sdk.core.response.a.d.i(adTemplate));
        bVar.e = 93;
        b(adTemplate, Cea708Decoder.COMMAND_DLW, bVar, null);
    }

    public static void d(@Nullable AdTemplate adTemplate, u.b bVar) {
        b(adTemplate, 59, bVar, null);
    }

    public static void d(final AdTemplate adTemplate, final JSONObject jSONObject) {
        a.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.1
            @Override // java.lang.Runnable
            public final void run() {
                u.b bVar = new u.b();
                AdTemplate adTemplate2 = AdTemplate.this;
                bVar.l = adTemplate2.downloadSource;
                a.f(adTemplate2, bVar);
                a.b(AdTemplate.this, 31, bVar, jSONObject);
                AdInfo i = com.kwad.sdk.core.response.a.d.i(AdTemplate.this);
                af.a(i.downloadFilePath, i.downloadId);
            }
        });
    }

    public static void e(AdTemplate adTemplate) {
        l(adTemplate, 38);
    }

    public static void e(@Nullable AdTemplate adTemplate, int i) {
        u.b bVar = new u.b();
        bVar.k = i;
        b(adTemplate, 803, bVar, null);
    }

    public static void e(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        b(adTemplate, i, null, jSONObject);
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.l = adTemplate.downloadSource;
        b(adTemplate, 35, bVar, jSONObject);
    }

    public static void f(AdTemplate adTemplate) {
        l(adTemplate, 41);
    }

    public static void f(@Nullable AdTemplate adTemplate, int i) {
        a(adTemplate, i, 0);
    }

    public static void f(AdTemplate adTemplate, u.b bVar) {
        AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
        String str = i.downloadFilePath;
        if (str == null) {
            return;
        }
        String C = com.kwad.sdk.core.response.a.a.C(i);
        String a2 = af.a(str);
        if (a2 == null || TextUtils.isEmpty(a2) || a2.equals(C)) {
            return;
        }
        bVar.s = a2;
        bVar.r = C;
        i.adBaseInfo.appPackageName = a2;
    }

    public static void f(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 399, jSONObject);
    }

    public static void g(AdTemplate adTemplate) {
        u.b bVar = new u.b();
        bVar.r = com.kwad.sdk.core.response.a.a.C(com.kwad.sdk.core.response.a.d.i(adTemplate));
        b(adTemplate, 768, bVar, new JSONObject());
    }

    public static void g(AdTemplate adTemplate, int i) {
        u.b bVar = new u.b();
        bVar.b = i;
        b(adTemplate, 759, bVar, null);
    }

    public static void g(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 400, jSONObject);
    }

    public static void h(@Nullable AdTemplate adTemplate) {
        f(adTemplate, (JSONObject) null);
    }

    public static void h(AdTemplate adTemplate, int i) {
        u.b bVar = new u.b();
        bVar.a = i;
        b(adTemplate, 28, bVar, null);
    }

    public static void h(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 501, jSONObject);
    }

    public static void i(@Nullable AdTemplate adTemplate) {
        g(adTemplate, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, int i) {
        if (adTemplate == null) {
            return;
        }
        u.b bVar = new u.b();
        bVar.r = com.kwad.sdk.core.response.a.a.C(com.kwad.sdk.core.response.a.d.i(adTemplate));
        b(adTemplate, i, bVar, new JSONObject());
    }

    public static void i(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 450, jSONObject);
    }

    public static void j(@Nullable AdTemplate adTemplate) {
        l(adTemplate, 58);
    }

    public static void j(AdTemplate adTemplate, int i) {
        b(adTemplate, i, new u.b(), new JSONObject());
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 451, jSONObject);
    }

    public static void k(AdTemplate adTemplate) {
        l(adTemplate, 914);
    }

    @Deprecated
    public static void k(AdTemplate adTemplate, int i) {
        a(adTemplate, new f().c(i));
    }

    public static void l(AdTemplate adTemplate) {
        b(adTemplate, 600, null, null);
    }

    public static void l(AdTemplate adTemplate, int i) {
        b(adTemplate, i, null, new JSONObject());
    }

    public static void m(AdTemplate adTemplate) {
        u.b bVar = new u.b();
        bVar.z = com.kwad.sdk.core.response.a.a.ak(com.kwad.sdk.core.response.a.d.i(adTemplate));
        com.kwad.sdk.core.d.b.a("AdReportManager", "reportDownloadCardClose downloadStatus=" + bVar.z);
        b(adTemplate, 713, bVar, null);
    }

    public static void n(AdTemplate adTemplate) {
        l(adTemplate, 722);
    }

    public static void o(AdTemplate adTemplate) {
        l(adTemplate, 721);
    }

    public static boolean p(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.a.d.a(adTemplate)) {
            return true;
        }
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class);
        return dVar != null && dVar.a(adTemplate);
    }
}
