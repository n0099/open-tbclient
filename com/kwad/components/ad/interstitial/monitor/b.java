package com.kwad.components.ad.interstitial.monitor;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.k;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public final class b {
    public double fV;
    public double fW;
    public double fX;
    public double fY;
    public double fZ;
    public double ga;

    /* loaded from: classes9.dex */
    public static class a {
        public static final b gb = new b((byte) 0);
    }

    public b() {
        init();
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b cr() {
        return a.gb;
    }

    private void init() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        double bh = d.bh(context);
        this.fV = bh;
        if (bh > 0.0d) {
            this.fW = 1.0d / bh;
        }
        double bi = d.bi(context);
        this.fX = bi;
        if (bi > 0.0d) {
            this.fY = 1.0d / bi;
        }
        double bj = d.bj(context);
        this.fZ = bj;
        if (bj > 0.0d) {
            this.ga = 1.0d / bj;
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = adTemplate.adShowStartTimeStamp;
        long j2 = elapsedRealtime - j;
        if (j > 0) {
            long j3 = adTemplate.loadDataTime;
            if (j3 <= 0 || j3 >= 60000 || j2 <= 0 || j2 >= 5000) {
                return;
            }
            k.i(this.fV, new InterstitialMonitorInfo().setRatioCount(this.fW).setStatus(4).setType(adTemplate.notNetworkRequest ? 2 : 1).setMaterialType(com.kwad.sdk.core.response.a.a.aD(com.kwad.sdk.core.response.a.d.bQ(adTemplate))).setRenderDuration(j2).setRenderType(i).toJson());
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, int i, String str) {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        k.k(this.fZ, new InterstitialMonitorInfo().setRatioCount(this.ga).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setVideoUrl(com.kwad.sdk.core.response.a.a.A(bQ)).setDownloadType(adTemplate.mDownloadType).setDownloadSize(adTemplate.mDownloadSize).setVideoDuration(com.kwad.sdk.core.response.a.a.B(bQ) * 1000).setErrorMsg(str).setErrorCode(i).toJson());
    }

    public final void a(@NonNull AdTemplate adTemplate, long j, boolean z) {
        if (j <= 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        adTemplate.loadDataTime = elapsedRealtime;
        if (elapsedRealtime <= 0 || elapsedRealtime >= 60000) {
            return;
        }
        k.i(this.fV, new InterstitialMonitorInfo().setRatioCount(this.fW).setStatus(2).setType(z ? 2 : 1).setLoadDataTime(adTemplate.loadDataTime).toJson());
    }

    public final void a(@NonNull AdTemplate adTemplate, String str) {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        k.j(this.fX, new InterstitialMonitorInfo().setRatioCount(this.fY).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setVideoUrl(com.kwad.sdk.core.response.a.a.A(bQ)).setDownloadSize(adTemplate.mDownloadSize).setDownloadType(adTemplate.mDownloadType).setVideoDuration(com.kwad.sdk.core.response.a.a.B(bQ) * 1000).setErrorMsg(str).toJson());
    }

    public final void b(@NonNull AdTemplate adTemplate, long j, boolean z) {
        if (j > 0 && com.kwad.sdk.core.response.a.a.aE(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - j;
            adTemplate.downloadDuration = elapsedRealtime;
            if (elapsedRealtime <= 0 || elapsedRealtime >= 60000) {
                return;
            }
            adTemplate.notNetworkRequest = z;
            k.i(this.fV, new InterstitialMonitorInfo().setRatioCount(this.fW).setStatus(3).setType(adTemplate.notNetworkRequest ? 2 : 1).setDownloadDuration(adTemplate.downloadDuration).setDownloadSize(adTemplate.mDownloadSize).setDownloadType(adTemplate.mDownloadType).toJson());
        }
    }

    public final void cs() {
        k.i(this.fV, new InterstitialMonitorInfo().setRatioCount(this.fW).setStatus(1).toJson());
    }

    public final void ct() {
        k.i(this.fV, new InterstitialMonitorInfo().setRatioCount(this.fW).setStatus(6).toJson());
    }

    public final void d(int i, String str) {
        k.i(this.fV, new InterstitialMonitorInfo().setRatioCount(this.fW).setStatus(5).setErrorCode(i).setErrorMsg(str).toJson());
    }
}
