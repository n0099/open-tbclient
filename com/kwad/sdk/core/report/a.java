package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ak;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static ExecutorService ave = GlobalThreadPools.Ex();
    public static JSONObject avf;
    public static boolean avg;

    @KsJson
    /* renamed from: com.kwad.sdk.core.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0711a extends com.kwad.sdk.core.response.a.a {
        public int code;
        public String msg;

        public C0711a(int i, String str) {
            this.code = i;
            this.msg = str;
        }
    }

    public static int Dl() {
        if (ai.isOrientationPortrait()) {
            return 2;
        }
        return 1;
    }

    public static boolean I(AdInfo adInfo) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return false;
        }
        String ay = com.kwad.sdk.core.response.b.a.ay(adInfo);
        if (TextUtils.isEmpty(ay)) {
            return false;
        }
        return ak.an(fVar.getContext(), ay);
    }

    public static void bH(AdTemplate adTemplate) {
        t(adTemplate, 4);
    }

    public static void bI(AdTemplate adTemplate) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        a(adTemplate, 30, bVar, (JSONObject) null);
    }

    public static void bJ(AdTemplate adTemplate) {
        t(adTemplate, 36);
    }

    public static void bK(AdTemplate adTemplate) {
        t(adTemplate, 38);
    }

    public static void bL(AdTemplate adTemplate) {
        t(adTemplate, 41);
    }

    public static void bM(AdTemplate adTemplate) {
        y.b bVar = new y.b();
        bVar.axB = com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        a(adTemplate, 768, bVar, new JSONObject());
    }

    public static void bN(@Nullable AdTemplate adTemplate) {
        h(adTemplate, (JSONObject) null);
    }

    public static void bO(@Nullable AdTemplate adTemplate) {
        i(adTemplate, null);
    }

    public static void bP(@Nullable AdTemplate adTemplate) {
        t(adTemplate, 58);
    }

    public static void bQ(AdTemplate adTemplate) {
        t(adTemplate, 914);
    }

    public static void bR(AdTemplate adTemplate) {
        y.b bVar = new y.b();
        bVar.downloadStatus = com.kwad.sdk.core.response.b.a.bx(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        com.kwad.sdk.core.e.c.d("AdReportManager", "reportDownloadCardClose downloadStatus=" + bVar.downloadStatus);
        a(adTemplate, 713, bVar, (JSONObject) null);
    }

    public static void bS(AdTemplate adTemplate) {
        t(adTemplate, 722);
    }

    public static void bT(AdTemplate adTemplate) {
        t(adTemplate, 721);
    }

    public static boolean bU(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.b.e.dH(adTemplate)) {
            return true;
        }
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar != null && fVar.aF(adTemplate)) {
            return true;
        }
        return false;
    }

    public static void a(AdTemplate adTemplate, int i, long j, int i2, long j2, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.vy = j;
        bVar.axL = i2;
        bVar.axm = i;
        y.a aVar = new y.a();
        aVar.duration = j2;
        bVar.axK = aVar;
        a(adTemplate, 3, bVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, long j, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.axm = i;
        y.a aVar = new y.a();
        aVar.duration = j;
        bVar.axK = aVar;
        a(adTemplate, 3, bVar, jSONObject);
    }

    public static void b(@Nullable AdTemplate adTemplate, String str, int i, y.b bVar) {
        if (bVar == null) {
            bVar = new y.b();
        }
        bVar.axu = i;
        if (!str.equals("")) {
            bVar.axv = str;
        }
        a(adTemplate, 321, bVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, AdExposureFailedReason adExposureFailedReason) {
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4) {
            return;
        }
        y.b bVar = new y.b();
        bVar.axq = i;
        if (adExposureFailedReason != null && i == 2) {
            bVar.axr = adExposureFailedReason.winEcpm;
            try {
                bVar.adnType = adExposureFailedReason.adnType;
                if (adExposureFailedReason.adnType == 2) {
                    bVar.adnName = adExposureFailedReason.adnName;
                }
            } catch (Throwable unused) {
            }
        }
        a(adTemplate, 809, bVar, (JSONObject) null);
    }

    @Deprecated
    public static void b(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        d(adTemplate, jSONObject, new j().cC(i));
    }

    public static void c(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.axB = com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        bVar.axn = 93;
        a(adTemplate, (int) Cea708Decoder.COMMAND_DLW, bVar, (JSONObject) null);
    }

    public static void d(@Nullable AdTemplate adTemplate, int i, int i2) {
        y.b bVar = new y.b();
        bVar.axH = i;
        bVar.axT = i2;
        a(adTemplate, 323, bVar, (JSONObject) null);
    }

    public static void e(AdTemplate adTemplate, int i, int i2) {
        y.b bVar = new y.b();
        bVar.axn = 69;
        bVar.axD = i;
        bVar.axE = i2;
        a(adTemplate, 501, bVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, @Nullable ac.a aVar) {
        y.b bVar = new y.b();
        bVar.kk = i;
        if (aVar != null) {
            bVar.km = aVar;
        }
        a(adTemplate, bVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, j jVar, @Nullable JSONObject jSONObject) {
        y.b bVar;
        if (jVar != null) {
            bVar = jVar.Dz();
        } else {
            bVar = null;
        }
        a(adTemplate, 3, bVar, jSONObject);
    }

    public static void c(@Nullable AdTemplate adTemplate, String str, int i) {
        y.b bVar = new y.b();
        bVar.axu = i;
        if (!str.equals("")) {
            bVar.axv = str;
        }
        a(adTemplate, 803, bVar, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        a(adTemplate, i, (y.b) null, jSONObject);
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject, @Nullable j jVar) {
        if (jVar == null) {
            jVar = new j();
        }
        y.b Dz = jVar.Dz();
        Dz.f(adTemplate, null, null);
        a(adTemplate, 141, Dz, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.axk = i;
        a(adTemplate, 402, bVar, jSONObject);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject, j jVar) {
        y.b bVar;
        if (jVar != null) {
            bVar = jVar.Dz();
        } else {
            bVar = null;
        }
        a(adTemplate, 451, bVar, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject, j jVar) {
        if (jVar == null) {
            jVar = new j();
        }
        y.b Dz = jVar.Dz();
        Dz.f(adTemplate, null, null);
        a(adTemplate, (int) Cea708Decoder.COMMAND_DLW, Dz, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject, String str) {
        y.b bVar = new y.b();
        bVar.Xd = str;
        a(adTemplate, i, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, long j, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        y.a aVar = new y.a();
        if (j != -1) {
            aVar.duration = j;
            bVar.axK = aVar;
        }
        a(adTemplate, 934, bVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, C0711a c0711a) {
        y.b bVar = new y.b();
        bVar.axz = c0711a.toJson().toString();
        a(adTemplate, 40, bVar, (JSONObject) null);
    }

    public static void c(@Nullable AdTemplate adTemplate, y.b bVar) {
        a(adTemplate, 52, bVar, (JSONObject) null);
    }

    public static void d(@Nullable AdTemplate adTemplate, y.b bVar) {
        a(adTemplate, 59, bVar, (JSONObject) null);
    }

    public static void e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        ave.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.1
            @Override // java.lang.Runnable
            public final void run() {
                j cD = new j().cD(AdTemplate.this.downloadSource);
                a.a(AdTemplate.this, cD);
                a.a(AdTemplate.this, 31, cD.Dz(), jSONObject);
                AdInfo dP = com.kwad.sdk.core.response.b.e.dP(AdTemplate.this);
                ak.at(dP.downloadFilePath, dP.downloadId);
            }
        });
    }

    public static void f(AdTemplate adTemplate, JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        a(adTemplate, 35, bVar, jSONObject);
    }

    public static void g(final AdTemplate adTemplate, final JSONObject jSONObject) {
        ave.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.2
            @Override // java.lang.Runnable
            public final void run() {
                AdInfo dP = com.kwad.sdk.core.response.b.e.dP(AdTemplate.this);
                int au = ak.au(dP.downloadId, com.kwad.sdk.core.response.b.a.ay(dP));
                y.b bVar = new y.b();
                AdTemplate adTemplate2 = AdTemplate.this;
                bVar.downloadSource = adTemplate2.downloadSource;
                bVar.axx = au;
                bVar.axy = adTemplate2.installFrom;
                a.a(adTemplate2, 32, bVar, jSONObject);
            }
        });
    }

    public static void h(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 399, jSONObject);
    }

    public static void i(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 400, jSONObject);
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 501, jSONObject);
    }

    public static void k(AdTemplate adTemplate, int i) {
        boolean z = true;
        adTemplate.mInstallApkFromSDK = true;
        if (i != 1) {
            z = false;
        }
        adTemplate.mInstallApkFormUser = z;
        y.b bVar = new y.b();
        bVar.axP = i;
        a(adTemplate, 37, bVar, (JSONObject) null);
    }

    public static void l(AdTemplate adTemplate, int i) {
        y.b bVar = new y.b();
        bVar.axt = i;
        a(adTemplate, 923, bVar, (JSONObject) null);
    }

    public static void m(@Nullable AdTemplate adTemplate, int i) {
        y.b bVar = new y.b();
        bVar.axw = i;
        b(adTemplate, "wxsmallapp", 1, bVar);
    }

    public static void n(@Nullable AdTemplate adTemplate, int i) {
        d(adTemplate, i, 0);
    }

    public static void o(AdTemplate adTemplate, int i) {
        y.b bVar = new y.b();
        bVar.axl = i;
        a(adTemplate, 759, bVar, (JSONObject) null);
    }

    public static void p(AdTemplate adTemplate, int i) {
        y.b bVar = new y.b();
        bVar.axk = i;
        a(adTemplate, 28, bVar, (JSONObject) null);
    }

    public static void q(AdTemplate adTemplate, int i) {
        if (adTemplate == null) {
            return;
        }
        y.b bVar = new y.b();
        bVar.axB = com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        a(adTemplate, i, bVar, new JSONObject());
    }

    public static void r(AdTemplate adTemplate, int i) {
        a(adTemplate, i, new y.b(), new JSONObject());
    }

    @Deprecated
    public static void s(AdTemplate adTemplate, int i) {
        e(adTemplate, (JSONObject) null, new j().cC(i));
    }

    public static void t(AdTemplate adTemplate, int i) {
        a(adTemplate, i, (y.b) null, new JSONObject());
    }

    public static void a(AdTemplate adTemplate, j jVar) {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        String str = dP.downloadFilePath;
        if (str == null) {
            return;
        }
        String ay = com.kwad.sdk.core.response.b.a.ay(dP);
        String fX = ak.fX(str);
        if (fX != null && !TextUtils.isEmpty(fX) && !fX.equals(ay)) {
            jVar.dQ(fX);
            jVar.dP(ay);
            dP.adBaseInfo.appPackageName = fX;
        }
    }

    public static void b(@Nullable AdTemplate adTemplate, y.b bVar) {
        a(adTemplate, 51, bVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        a(adTemplate, 33, bVar, jSONObject);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        a(adTemplate, 34, bVar, jSONObject);
    }

    public static void g(AdTemplate adTemplate, boolean z) {
        j jVar = new j();
        y.a aVar = new y.a();
        aVar.axd = 1;
        jVar.a(aVar);
        if (z) {
            jVar.cJ(33);
        }
        a(adTemplate, (int) CyberPlayerManager.MEDIA_ERROR_UNDEFINE_AUDIO_NOT_PLAY, jVar.Dz(), (JSONObject) null);
    }

    public static void h(AdTemplate adTemplate, boolean z) {
        j jVar = new j();
        y.a aVar = new y.a();
        aVar.axd = 2;
        jVar.a(aVar);
        if (z) {
            jVar.cJ(33);
        }
        a(adTemplate, (int) CyberPlayerManager.MEDIA_ERROR_UNDEFINE_AUDIO_NOT_PLAY, jVar.Dz(), (JSONObject) null);
    }

    public static void k(AdTemplate adTemplate, long j) {
        y.b bVar = new y.b();
        bVar.axp = j;
        a(adTemplate, 600, bVar, (JSONObject) null);
    }

    public static void l(AdTemplate adTemplate, long j) {
        y.b bVar = new y.b();
        bVar.axG = j;
        a(adTemplate, 401, bVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, j jVar, JSONObject jSONObject) {
        y.b bVar;
        if (jVar != null) {
            bVar = jVar.Dz();
        } else {
            bVar = null;
        }
        a(adTemplate, bVar, jSONObject);
    }

    public static void a(@Nullable AdTemplate adTemplate, y.b bVar) {
        a(adTemplate, 50, bVar, (JSONObject) null);
    }

    public static void k(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 450, jSONObject);
    }

    public static void l(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 451, jSONObject);
    }

    public static void a(AdTemplate adTemplate, y.b bVar, @Nullable JSONObject jSONObject) {
        if (bVar != null) {
            if (adTemplate.fromCache) {
                bVar.a(k.bV(adTemplate));
            }
            bVar.f(adTemplate, null, null);
        }
        a(adTemplate, 2, bVar, jSONObject);
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, int i, y.b bVar) {
        if (bVar == null) {
            bVar = new y.b();
        }
        bVar.axu = i;
        if (!str.equals("")) {
            bVar.axv = str;
        }
        a(adTemplate, 320, bVar, (JSONObject) null);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v0 int)] */
    public static boolean a(@Nullable final AdTemplate adTemplate, final int i, @Nullable final y.b bVar, @Nullable final JSONObject jSONObject) {
        if (adTemplate != null && bU(adTemplate)) {
            if (bVar == null) {
                bVar = new y.b();
            }
            bVar.axJ = com.kwad.sdk.core.response.b.a.aT(com.kwad.sdk.core.response.b.e.dP(adTemplate));
            bVar.adxResult = adTemplate.adxResult;
            if (i == 2 && avg) {
                if (bVar.axK == null) {
                    bVar.axK = new y.a();
                }
                bVar.axK.axg = avf;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            com.kwad.sdk.core.e.c.d("AdReportManager", sb.toString());
            new x() { // from class: com.kwad.sdk.core.report.a.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: Dm */
                public y createRequest() {
                    return new y(AdTemplate.this, i, bVar, jSONObject);
                }

                @Override // com.kwad.sdk.core.report.x
                public final void Dn() {
                    try {
                        b.a(AdTemplate.this, i, bVar);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.printStackTrace(th);
                        ServiceProvider.b(th);
                    }
                }
            }.DN();
            return true;
        }
        return false;
    }

    public static boolean b(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable j jVar) {
        if (adTemplate.mPvReported) {
            return false;
        }
        adTemplate.mPvReported = true;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        if (jVar == null) {
            jVar = new j();
        }
        jVar.cO(Dl());
        y.b Dz = jVar.Dz();
        if (adTemplate.fromCache) {
            Dz.a(k.bV(adTemplate));
        }
        Dz.axI = I(dP) ? 1 : 0;
        return a(adTemplate, 1, Dz, jSONObject);
    }
}
