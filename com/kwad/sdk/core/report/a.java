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
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ai;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public static ExecutorService ZC = com.kwad.sdk.core.threads.b.vm();

    @KsJson
    /* renamed from: com.kwad.sdk.core.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0390a extends com.kwad.sdk.core.response.kwai.a {
        public String Qd;
        public int code;

        public C0390a(int i, String str) {
            this.code = i;
            this.Qd = str;
        }
    }

    public static void a(AdTemplate adTemplate, int i, int i2, int i3) {
        u.b bVar = new u.b();
        bVar.abE = 114;
        bVar.abP = i2;
        bVar.abQ = i3;
        b(adTemplate, Cea708Decoder.COMMAND_DLY, bVar, null);
    }

    public static void a(AdTemplate adTemplate, int i, long j, int i2, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.ss = j;
        bVar.abX = i2;
        bVar.abD = i;
        b(adTemplate, 3, bVar, null);
    }

    public static void a(AdTemplate adTemplate, int i, AdExposureFailedReason adExposureFailedReason) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
            u.b bVar = new u.b();
            bVar.abF = i;
            if (adExposureFailedReason != null) {
                bVar.winEcpm = adExposureFailedReason.winEcpm;
            }
            b(adTemplate, 809, bVar, null);
        }
    }

    public static void a(@Nullable AdTemplate adTemplate, int i, u.b bVar) {
        if (bVar == null) {
            bVar = new u.b();
        }
        bVar.abI = i;
        b(adTemplate, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, bVar, null);
    }

    public static void a(AdTemplate adTemplate, int i, @NonNull u.b bVar, @Nullable JSONObject jSONObject) {
        bVar.abE = i;
        b(adTemplate, Cea708Decoder.COMMAND_DLW, bVar, null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, @Nullable aa.a aVar) {
        u.b bVar = new u.b();
        bVar.gJ = i;
        if (aVar != null) {
            bVar.gL = aVar;
        }
        a(adTemplate, bVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, aa.a aVar, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.gJ = i;
        bVar.gL = aVar;
        a(adTemplate, bVar, jSONObject);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.abD = i;
        b(adTemplate, 3, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject, String str) {
        u.b bVar = new u.b();
        bVar.Mn = str;
        b(adTemplate, i, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, C0390a c0390a) {
        u.b bVar = new u.b();
        bVar.abL = c0390a.toJson().toString();
        b(adTemplate, 40, bVar, null);
    }

    public static void a(AdTemplate adTemplate, @Nullable f fVar) {
        b(adTemplate, Cea708Decoder.COMMAND_DLY, fVar != null ? fVar.uw() : null, null);
    }

    public static void a(AdTemplate adTemplate, f fVar, JSONObject jSONObject) {
        a(adTemplate, fVar != null ? fVar.uw() : null, jSONObject);
    }

    public static void a(AdTemplate adTemplate, u.b bVar) {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        String str = bQ.downloadFilePath;
        if (str == null) {
            return;
        }
        String ag = com.kwad.sdk.core.response.a.a.ag(bQ);
        String dO = ai.dO(str);
        if (dO == null || TextUtils.isEmpty(dO) || dO.equals(ag)) {
            return;
        }
        bVar.abO = dO;
        bVar.abN = ag;
        bQ.adBaseInfo.appPackageName = dO;
    }

    public static void a(AdTemplate adTemplate, u.b bVar, @Nullable JSONObject jSONObject) {
        if (bVar != null && adTemplate.fromCache) {
            bVar.a(g.aH(adTemplate));
        }
        b(adTemplate, 2, bVar, jSONObject);
    }

    public static void aA(AdTemplate adTemplate) {
        b(adTemplate, 600, null, null);
    }

    public static void aB(AdTemplate adTemplate) {
        u.b bVar = new u.b();
        bVar.lf = com.kwad.sdk.core.response.a.a.aR(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
        com.kwad.sdk.core.e.b.d("AdReportManager", "reportDownloadCardClose downloadStatus=" + bVar.lf);
        b(adTemplate, 713, bVar, null);
    }

    public static void aC(AdTemplate adTemplate) {
        s(adTemplate, 722);
    }

    public static void aD(AdTemplate adTemplate) {
        s(adTemplate, 721);
    }

    public static void aE(AdTemplate adTemplate) {
        f fVar = new f();
        u.a aVar = new u.a();
        aVar.abA = 1;
        fVar.a(aVar);
        b(adTemplate, 804, fVar.uw(), null);
    }

    public static void aF(AdTemplate adTemplate) {
        f fVar = new f();
        u.a aVar = new u.a();
        aVar.abA = 2;
        fVar.a(aVar);
        b(adTemplate, 804, fVar.uw(), null);
    }

    public static boolean aG(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.a.d.bI(adTemplate)) {
            return true;
        }
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class);
        return dVar != null && dVar.G(adTemplate);
    }

    public static void ap(AdTemplate adTemplate) {
        s(adTemplate, 4);
    }

    public static void aq(AdTemplate adTemplate) {
        u.b bVar = new u.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 30, bVar, null);
    }

    public static void ar(final AdTemplate adTemplate) {
        ZC.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.2
            @Override // java.lang.Runnable
            public final void run() {
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(AdTemplate.this);
                int S = ai.S(bQ.downloadId, com.kwad.sdk.core.response.a.a.ag(bQ));
                u.b bVar = new u.b();
                AdTemplate adTemplate2 = AdTemplate.this;
                bVar.downloadSource = adTemplate2.downloadSource;
                bVar.abJ = S;
                bVar.abK = adTemplate2.installFrom;
                a.b(adTemplate2, 32, bVar, null);
            }
        });
    }

    public static void as(AdTemplate adTemplate) {
        s(adTemplate, 36);
    }

    public static void at(AdTemplate adTemplate) {
        s(adTemplate, 38);
    }

    public static void au(AdTemplate adTemplate) {
        s(adTemplate, 41);
    }

    public static void av(AdTemplate adTemplate) {
        u.b bVar = new u.b();
        bVar.abN = com.kwad.sdk.core.response.a.a.ag(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
        b(adTemplate, 768, bVar, new JSONObject());
    }

    public static void aw(@Nullable AdTemplate adTemplate) {
        h(adTemplate, (JSONObject) null);
    }

    public static void ax(@Nullable AdTemplate adTemplate) {
        i(adTemplate, (JSONObject) null);
    }

    public static void ay(@Nullable AdTemplate adTemplate) {
        s(adTemplate, 58);
    }

    public static void az(AdTemplate adTemplate) {
        s(adTemplate, 914);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v0 int)] */
    public static void b(@Nullable final AdTemplate adTemplate, final int i, @Nullable final u.b bVar, @Nullable final JSONObject jSONObject) {
        if (adTemplate == null || !aG(adTemplate)) {
            return;
        }
        if (bVar == null) {
            bVar = new u.b();
        }
        bVar.abV = com.kwad.sdk.core.response.a.a.as(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        com.kwad.sdk.core.e.b.d("AdReportManager", sb.toString());
        bVar.adxResult = adTemplate.adxResult;
        new t() { // from class: com.kwad.sdk.core.report.a.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: um */
            public u createRequest() {
                return new u(AdTemplate.this, i, bVar, jSONObject);
            }
        }.fetch();
    }

    public static void b(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.abB = i;
        b(adTemplate, 402, bVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate, f fVar, @Nullable JSONObject jSONObject) {
        b(adTemplate, 3, fVar != null ? fVar.uw() : null, null);
    }

    public static void b(@Nullable AdTemplate adTemplate, u.b bVar) {
        b(adTemplate, 50, bVar, null);
    }

    public static void b(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable f fVar) {
        if (adTemplate.mPvReported) {
            return;
        }
        adTemplate.mPvReported = true;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if (fVar == null) {
            fVar = new f();
        }
        u.b uw = fVar.uw();
        if (adTemplate.fromCache) {
            uw.a(g.aH(adTemplate));
        }
        uw.abU = y(bQ) ? 1 : 0;
        b(adTemplate, 1, uw, jSONObject);
    }

    public static void c(@Nullable AdTemplate adTemplate, int i, int i2) {
        u.b bVar = new u.b();
        bVar.abT = i;
        bVar.acg = i2;
        b(adTemplate, 323, bVar, null);
    }

    public static void c(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.abE = i;
        b(adTemplate, Cea708Decoder.COMMAND_DLW, bVar, jSONObject);
    }

    public static void c(@Nullable AdTemplate adTemplate, u.b bVar) {
        b(adTemplate, 51, bVar, null);
    }

    public static void c(AdTemplate adTemplate, JSONObject jSONObject) {
        e(adTemplate, 601, jSONObject);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject, f fVar) {
        b(adTemplate, 451, fVar != null ? fVar.uw() : null, null);
    }

    public static void d(AdTemplate adTemplate, int i, int i2) {
        u.b bVar = new u.b();
        bVar.abE = 69;
        bVar.abP = i;
        bVar.abQ = i2;
        b(adTemplate, 501, bVar, null);
    }

    public static void d(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.abN = com.kwad.sdk.core.response.a.a.ag(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
        bVar.abE = 93;
        b(adTemplate, Cea708Decoder.COMMAND_DLW, bVar, null);
    }

    public static void d(@Nullable AdTemplate adTemplate, u.b bVar) {
        b(adTemplate, 52, bVar, null);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 33, bVar, jSONObject);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject, f fVar) {
        b(adTemplate, Cea708Decoder.COMMAND_DLW, fVar != null ? fVar.uw() : null, jSONObject);
    }

    public static void e(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        b(adTemplate, i, null, jSONObject);
    }

    public static void e(@Nullable AdTemplate adTemplate, u.b bVar) {
        b(adTemplate, 59, bVar, null);
    }

    public static void e(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 34, bVar, jSONObject);
    }

    public static void f(final AdTemplate adTemplate, final JSONObject jSONObject) {
        ZC.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.1
            @Override // java.lang.Runnable
            public final void run() {
                u.b bVar = new u.b();
                AdTemplate adTemplate2 = AdTemplate.this;
                bVar.downloadSource = adTemplate2.downloadSource;
                a.a(adTemplate2, bVar);
                a.b(AdTemplate.this, 31, bVar, jSONObject);
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(AdTemplate.this);
                ai.R(bQ.downloadFilePath, bQ.downloadId);
            }
        });
    }

    public static void g(AdTemplate adTemplate, int i) {
        u.b bVar = new u.b();
        bVar.acg = 8;
        b(adTemplate, 2, bVar, null);
    }

    public static void g(AdTemplate adTemplate, long j) {
        u.b bVar = new u.b();
        bVar.abS = j;
        b(adTemplate, 401, bVar, null);
    }

    public static void g(AdTemplate adTemplate, JSONObject jSONObject) {
        u.b bVar = new u.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 35, bVar, jSONObject);
    }

    public static void h(AdTemplate adTemplate, int i) {
        u.b bVar = new u.b();
        bVar.acc = i;
        b(adTemplate, 37, bVar, null);
    }

    public static void h(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 399, jSONObject);
    }

    public static void i(AdTemplate adTemplate, int i) {
        u.b bVar = new u.b();
        bVar.abH = i;
        b(adTemplate, 923, bVar, null);
    }

    public static void i(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 400, jSONObject);
    }

    public static void j(@Nullable AdTemplate adTemplate, int i) {
        a(adTemplate, 2, (u.b) null);
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 501, jSONObject);
    }

    public static void k(@Nullable AdTemplate adTemplate, int i) {
        u.b bVar = new u.b();
        bVar.abI = i;
        b(adTemplate, 321, bVar, null);
    }

    public static void k(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 450, jSONObject);
    }

    public static void l(@Nullable AdTemplate adTemplate, int i) {
        u.b bVar = new u.b();
        bVar.abI = i;
        b(adTemplate, 803, bVar, null);
    }

    public static void l(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 451, jSONObject);
    }

    public static void m(@Nullable AdTemplate adTemplate, int i) {
        c(adTemplate, i, 0);
    }

    public static void n(AdTemplate adTemplate, int i) {
        u.b bVar = new u.b();
        bVar.abC = i;
        b(adTemplate, 759, bVar, null);
    }

    public static void o(AdTemplate adTemplate, int i) {
        u.b bVar = new u.b();
        bVar.abB = i;
        b(adTemplate, 28, bVar, null);
    }

    public static void p(AdTemplate adTemplate, int i) {
        if (adTemplate == null) {
            return;
        }
        u.b bVar = new u.b();
        bVar.abN = com.kwad.sdk.core.response.a.a.ag(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
        b(adTemplate, i, bVar, new JSONObject());
    }

    public static void q(AdTemplate adTemplate, int i) {
        b(adTemplate, i, new u.b(), new JSONObject());
    }

    @Deprecated
    public static void r(AdTemplate adTemplate, int i) {
        a(adTemplate, new f().aK(i));
    }

    public static void s(AdTemplate adTemplate, int i) {
        b(adTemplate, i, null, new JSONObject());
    }

    public static boolean y(AdInfo adInfo) {
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class);
        if (dVar == null) {
            return false;
        }
        String ag = com.kwad.sdk.core.response.a.a.ag(adInfo);
        if (TextUtils.isEmpty(ag)) {
            return false;
        }
        return ai.U(dVar.getContext(), ag);
    }
}
