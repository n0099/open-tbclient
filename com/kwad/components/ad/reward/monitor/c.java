package com.kwad.components.ad.reward.monitor;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.s.f;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class c {
    public static boolean k(long j) {
        return j == -1;
    }

    public static void K(AdTemplate adTemplate) {
        int i;
        AdInfo dP = e.dP(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo().setPageStatus(7);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.a.c(true, (com.kwad.sdk.commercial.d.a) pageStatus.setLoadType(i).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setAdTemplate(adTemplate));
    }

    public static void L(AdTemplate adTemplate) {
        int i;
        AdInfo dP = e.dP(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo().setPageStatus(8);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.a.c(true, (com.kwad.sdk.commercial.d.a) pageStatus.setLoadType(i).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i, int i2, boolean z) {
        AdInfo dP = e.dP(adTemplate);
        com.kwad.sdk.commercial.a.g(new RewardMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setRewardType(!z ? 1 : 0).setTaskType(i).setTaskStep(i2).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dP) * 1000).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, boolean z, String str, String str2) {
        String str3;
        RewardWebViewInfo event = new RewardWebViewInfo().setPageType(str).setEvent("webview_load_url");
        if (z) {
            str3 = "ad_reward";
        } else {
            str3 = "ad_fullscreen";
        }
        com.kwad.sdk.commercial.a.f(event.setSceneId(str3).setUrl(str2).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, boolean z, String str, String str2, long j, int i) {
        String str3;
        RewardWebViewInfo event = new RewardWebViewInfo().setPageType(str).setEvent("webview_timeout");
        if (z) {
            str3 = "ad_reward";
        } else {
            str3 = "ad_fullscreen";
        }
        com.kwad.sdk.commercial.a.f(event.setSceneId(str3).setDurationMs(j).setTimeType(i).setUrl(str2).setAdTemplate(adTemplate));
    }

    public static void a(boolean z, int i, String str, long j) {
        com.kwad.sdk.commercial.a.a(z, new RewardMonitorInfo().setLoadStatus(4).setErrorCode(i).setErrorMsg(str).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.aSb);
    }

    public static void a(boolean z, long j) {
        com.kwad.sdk.commercial.a.a(z, new RewardMonitorInfo().setLoadStatus(1).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.aSf);
    }

    public static void b(boolean z, long j) {
        com.kwad.sdk.commercial.a.a(z, new RewardMonitorInfo().setLoadStatus(5).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.aSf);
    }

    public static void c(boolean z, long j) {
        com.kwad.sdk.commercial.a.a(z, new RewardMonitorInfo().setLoadStatus(6).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.aSf);
    }

    public static void g(boolean z, AdTemplate adTemplate) {
        String str;
        RewardWebViewInfo event = new RewardWebViewInfo().setEvent("ad_show");
        if (z) {
            str = "ad_reward";
        } else {
            str = "ad_fullscreen";
        }
        com.kwad.sdk.commercial.a.f(event.setSceneId(str).setAdTemplate(adTemplate));
    }

    public static void a(boolean z, a aVar, AdTemplate adTemplate, @Nullable com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        if (adTemplate == null) {
            return;
        }
        RewardMonitorInfo adTemplate2 = new RewardMonitorInfo().setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dP(adTemplate))).setCallbackType(aVar.getTypeValue()).setAdTemplate(adTemplate);
        if (aVar2 != null) {
            aVar2.accept(adTemplate2);
        }
        com.kwad.sdk.commercial.a.d(z, adTemplate2);
    }

    public static void a(boolean z, @NonNull AdTemplate adTemplate, int i, long j) {
        long j2;
        long j3 = -1;
        if (j > 0 && adTemplate.getLoadDataTime() > 0) {
            j2 = adTemplate.getLoadDataTime() - j;
        } else {
            j2 = -1;
        }
        int i2 = 1;
        if (!a(j2)) {
            j3 = j2;
        }
        AdInfo dP = e.dP(adTemplate);
        RewardMonitorInfo loadStatus = new RewardMonitorInfo().setLoadStatus(2);
        if (adTemplate.isLoadFromCache()) {
            i2 = 2;
        }
        com.kwad.sdk.commercial.a.a(z, loadStatus.setLoadType(i2).setAdCount(i).setLoadDataDuration(j3).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dP) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.aSf);
    }

    public static void b(boolean z, AdTemplate adTemplate, int i, long j) {
        adTemplate.setDownloadFinishTime(SystemClock.elapsedRealtime());
        AdInfo dP = e.dP(adTemplate);
        long loadDataTime = adTemplate.getLoadDataTime() - j;
        long downloadFinishTime = adTemplate.getDownloadFinishTime() - adTemplate.getLoadDataTime();
        long downloadFinishTime2 = adTemplate.getDownloadFinishTime() - j;
        int i2 = 1;
        if (a(loadDataTime, downloadFinishTime, downloadFinishTime2)) {
            loadDataTime = -1;
            downloadFinishTime = -1;
            downloadFinishTime2 = -1;
        }
        RewardMonitorInfo loadStatus = new RewardMonitorInfo().setLoadStatus(3);
        if (adTemplate.isLoadFromCache()) {
            i2 = 2;
        }
        com.kwad.sdk.commercial.a.a(z, loadStatus.setLoadType(i2).setAdCount(i).setLoadDataDuration(loadDataTime).setDownloadDuration(downloadFinishTime).setTotalDuration(downloadFinishTime2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dP) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.aSf);
    }

    public static void a(boolean z, AdTemplate adTemplate, long j) {
        a(z, adTemplate, j, (AdGlobalConfigInfo) null);
    }

    public static void c(boolean z, @Nullable AdTemplate adTemplate, String str) {
        com.kwad.sdk.commercial.a.c(z, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setAdTemplate(adTemplate));
    }

    public static void a(boolean z, AdTemplate adTemplate, long j, int i, long j2) {
        int i2;
        AdInfo dP = e.dP(adTemplate);
        RewardMonitorInfo rewardMonitorInfo = new RewardMonitorInfo();
        if (adTemplate.isLoadFromCache()) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        com.kwad.sdk.commercial.a.f(z, rewardMonitorInfo.setLoadType(i2).setCurrentDuration(j).setErrorCode(i).setErrorMsg(String.valueOf(j2)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(dP)).setAdTemplate(adTemplate));
    }

    public static void a(boolean z, AdTemplate adTemplate, long j, AdGlobalConfigInfo adGlobalConfigInfo) {
        long j2;
        long loadDataTime = adTemplate.getLoadDataTime();
        long downloadFinishTime = adTemplate.getDownloadFinishTime();
        long j3 = 0;
        if (loadDataTime > 0) {
            j2 = j - loadDataTime;
        } else {
            j2 = 0;
        }
        if (downloadFinishTime > 0) {
            j3 = j - downloadFinishTime;
        }
        int i = 0;
        int i2 = 1;
        i = (adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType == 1) ? 3 : 3;
        AdInfo dP = e.dP(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo().setPageStatus(1);
        if (adTemplate.isLoadFromCache()) {
            i2 = 2;
        }
        com.kwad.sdk.commercial.a.c(z, pageStatus.setLoadType(i2).setAdSceneType(i).setDataLoadInterval(j2).setDataDownloadInterval(j3).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dP) * 1000).setAdTemplate(adTemplate));
    }

    public static void a(boolean z, @Nullable AdTemplate adTemplate, a aVar, long j, @Nullable com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        com.kwad.sdk.commercial.a.e(z, new RewardMonitorInfo().setCallbackType(aVar.getTypeValue()).setAdTemplate(adTemplate).setPosId(j));
    }

    public static void a(boolean z, AdTemplate adTemplate, String str) {
        int i;
        AdInfo dP = e.dP(adTemplate);
        RewardMonitorInfo rewardMonitorInfo = new RewardMonitorInfo();
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.a.b(z, rewardMonitorInfo.setLoadType(i).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dP) * 1000).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void b(boolean z, AdTemplate adTemplate, String str) {
        int i;
        AdInfo dP = e.dP(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo().setPageStatus(4);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.a.c(z, pageStatus.setLoadType(i).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dP) * 1000).setInterceptReason(str).setAdTemplate(adTemplate));
    }

    public static void c(AdTemplate adTemplate, int i, String str) {
        int i2;
        AdInfo dP = e.dP(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo().setPageStatus(9);
        if (adTemplate.isLoadFromCache()) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        com.kwad.sdk.commercial.a.c(true, (com.kwad.sdk.commercial.d.a) pageStatus.setLoadType(i2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
    }

    public static void a(boolean z, @Nullable AdTemplate adTemplate, String str, String str2) {
        com.kwad.sdk.commercial.a.c(z, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setErrorMsg(str2).setAdTemplate(adTemplate));
    }

    public static void a(boolean z, String str) {
        String str2;
        RewardWebViewInfo event = new RewardWebViewInfo().setPageType(str).setEvent("webview_init");
        if (z) {
            str2 = "ad_reward";
        } else {
            str2 = "ad_fullscreen";
        }
        com.kwad.sdk.commercial.a.f(event.setSceneId(str2));
    }

    public static void a(boolean z, String str, String str2, long j) {
        String str3;
        RewardWebViewInfo event = new RewardWebViewInfo().setPageType(str).setEvent("webview_load_finish");
        if (z) {
            str3 = "ad_reward";
        } else {
            str3 = "ad_fullscreen";
        }
        com.kwad.sdk.commercial.a.f(event.setSceneId(str3).setDurationMs(j).setUrl(str2));
    }

    public static boolean a(long... jArr) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (jArr[i] >= 60000) {
                return true;
            }
        }
        return false;
    }

    public static void b(boolean z, AdTemplate adTemplate, long j) {
        long j2 = -1;
        int i = 1;
        if (!k(j)) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - j;
            if (!a(elapsedRealtime)) {
                j2 = elapsedRealtime;
            }
        }
        AdInfo dP = e.dP(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo().setPageStatus(2);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        }
        com.kwad.sdk.commercial.a.c(z, pageStatus.setLoadType(i).setRenderDuration(j2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dP) * 1000).setAdTemplate(adTemplate));
    }

    public static void d(boolean z, @NonNull AdTemplate adTemplate) {
        int i;
        AdInfo dP = e.dP(adTemplate);
        RewardMonitorInfo loadStatus = new RewardMonitorInfo().setLoadStatus(7);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.a.a(z, loadStatus.setLoadType(i).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dP) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.aSf);
    }

    public static void e(boolean z, AdTemplate adTemplate) {
        int i;
        AdInfo dP = e.dP(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo().setPageStatus(6);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.a.c(z, pageStatus.setLoadType(i).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dP) * 1000).setAdTemplate(adTemplate));
    }

    public static void f(boolean z, AdTemplate adTemplate) {
        int i;
        AdInfo dP = e.dP(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo().setPageStatus(5);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.a.c(z, pageStatus.setLoadType(i).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dP) * 1000).setAdTemplate(adTemplate));
    }

    public static void h(boolean z, AdTemplate adTemplate) {
        int i;
        AdInfo dP = e.dP(adTemplate);
        RewardMonitorInfo pageStatus = new RewardMonitorInfo().setPageStatus(3);
        if (adTemplate.isLoadFromCache()) {
            i = 2;
        } else {
            i = 1;
        }
        com.kwad.sdk.commercial.a.c(z, pageStatus.setLoadType(i).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.J(dP)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dP)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dP) * 1000).setAdTemplate(adTemplate));
    }

    public static void i(boolean z, @Nullable AdTemplate adTemplate) {
        String str;
        if (adTemplate != null) {
            if (f.ar(adTemplate.mDataCacheTraceElement)) {
                str = "data_cache";
            } else if (f.ar(adTemplate.mDataLoadTraceElement)) {
                str = "data_load";
            }
            com.kwad.sdk.commercial.a.c(z, new RewardMonitorInfo().setPageStatus(101).setLaunchFrom(str).setSubStage(PageCreateStage.START_LAUNCH.getStage()).setAdTemplate(adTemplate));
        }
        str = "unknown";
        com.kwad.sdk.commercial.a.c(z, new RewardMonitorInfo().setPageStatus(101).setLaunchFrom(str).setSubStage(PageCreateStage.START_LAUNCH.getStage()).setAdTemplate(adTemplate));
    }
}
