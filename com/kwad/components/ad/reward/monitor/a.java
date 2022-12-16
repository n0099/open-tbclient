package com.kwad.components.ad.reward.monitor;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.k;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean mHasInit;
    public static double pi;
    public static double pj;
    public static double pk;
    public static double pl;
    public static double pm;
    public static double pn;
    public static double po;
    public static double pp;
    public static double pq;
    public static double pr;
    public transient /* synthetic */ FieldHolder $fh;

    public static double H(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65536, null, z)) == null) {
            init();
            return z ? pi : pm;
        }
        return invokeZ.doubleValue;
    }

    public static double I(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            init();
            return z ? pk : po;
        }
        return invokeZ.doubleValue;
    }

    public static double J(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) ? z ? pj : pn : invokeZ.doubleValue;
    }

    public static double K(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) ? z ? pl : pp : invokeZ.doubleValue;
    }

    public static void a(AdTemplate adTemplate, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{adTemplate, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            AdInfo bQ = d.bQ(adTemplate);
            k.b(H(true), new RewardMonitorInfo().setRatioCount(J(true)).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setRewardType(!z ? 1 : 0).setTaskType(i).setTaskStep(i2).setVideoUrl(com.kwad.sdk.core.response.a.a.A(bQ)).setVideoDuration(com.kwad.sdk.core.response.a.a.B(bQ) * 1000).toJson());
        }
    }

    public static void a(boolean z, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str}) == null) {
            k.a(H(z), z, new RewardMonitorInfo().setRatioCount(J(z)).setLoadStatus(4).setErrorCode(i).setErrorMsg(str).toJson(), com.kwai.adclient.kscommerciallogger.model.a.arE);
        }
    }

    public static void a(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || j <= 0) {
            return;
        }
        k.a(H(z), z, new RewardMonitorInfo().setRatioCount(J(z)).setLoadStatus(1).toJson(), com.kwai.adclient.kscommerciallogger.model.a.arI);
    }

    public static void a(boolean z, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65543, null, z, adTemplate) == null) {
            AdInfo bQ = d.bQ(adTemplate);
            k.b(H(z), z, new RewardMonitorInfo().setRatioCount(J(z)).setPageStatus(3).setLoadType(adTemplate.mLoadFromCache ? 2 : 1).setDownloadType(adTemplate.mDownloadType).setDownloadSize(adTemplate.mDownloadSize).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setVideoUrl(com.kwad.sdk.core.response.a.a.A(bQ)).setVideoDuration(com.kwad.sdk.core.response.a.a.B(bQ) * 1000).toJson());
        }
    }

    public static void a(boolean z, @NonNull AdTemplate adTemplate, int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), adTemplate, Integer.valueOf(i), Long.valueOf(j)}) == null) || j <= 0) {
            return;
        }
        long j2 = adTemplate.mLoadDataTime;
        if (j2 <= 0) {
            return;
        }
        long j3 = j2 - j;
        if (a(j3)) {
            return;
        }
        AdInfo bQ = d.bQ(adTemplate);
        k.a(H(z), z, new RewardMonitorInfo().setRatioCount(J(z)).setLoadStatus(2).setLoadType(adTemplate.mLoadFromCache ? 2 : 1).setAdCount(i).setLoadDataDuration(j3).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setVideoUrl(com.kwad.sdk.core.response.a.a.A(bQ)).setVideoDuration(com.kwad.sdk.core.response.a.a.B(bQ) * 1000).toJson(), com.kwai.adclient.kscommerciallogger.model.a.arI);
    }

    public static void a(boolean z, AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), adTemplate, Long.valueOf(j)}) == null) {
            long j2 = adTemplate.mLoadDataTime;
            if (j2 > 0) {
                long j3 = adTemplate.mDownloadFinishTime;
                if (j3 <= 0) {
                    return;
                }
                long j4 = j - j2;
                long j5 = j - j3;
                AdInfo bQ = d.bQ(adTemplate);
                k.b(H(z), z, new RewardMonitorInfo().setRatioCount(J(z)).setPageStatus(1).setLoadType(adTemplate.mLoadFromCache ? 2 : 1).setDataLoadInterval(j4).setDataDownloadInterval(j5).setDownloadType(adTemplate.mDownloadType).setDownloadSize(adTemplate.mDownloadSize).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setVideoUrl(com.kwad.sdk.core.response.a.a.A(bQ)).setVideoDuration(com.kwad.sdk.core.response.a.a.B(bQ) * 1000).toJson());
            }
        }
    }

    public static void a(boolean z, AdTemplate adTemplate, long j, int i, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Boolean.valueOf(z), adTemplate, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)}) == null) {
            AdInfo bQ = d.bQ(adTemplate);
            k.c(I(z), z, new RewardMonitorInfo().setRatioCount(K(z)).setLoadType(adTemplate.mLoadFromCache ? 2 : 1).setCurrentDuration(j).setErrorCode(i).setErrorMsg(String.valueOf(j2)).setDownloadType(adTemplate.mDownloadType).setDownloadSize(adTemplate.mDownloadSize).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setVideoUrl(com.kwad.sdk.core.response.a.a.A(bQ)).setVideoDuration(com.kwad.sdk.core.response.a.a.B(bQ) * 1000).toJson());
        }
    }

    public static void a(boolean z, AdTemplate adTemplate, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), adTemplate, str}) == null) {
            AdInfo bQ = d.bQ(adTemplate);
            k.a(I(z), z, new RewardMonitorInfo().setRatioCount(K(z)).setLoadType(adTemplate.mLoadFromCache ? 2 : 1).setDownloadType(adTemplate.mDownloadType).setDownloadSize(adTemplate.mDownloadSize).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setVideoUrl(com.kwad.sdk.core.response.a.a.A(bQ)).setVideoDuration(com.kwad.sdk.core.response.a.a.B(bQ) * 1000).setErrorMsg(str).toJson());
        }
    }

    public static void a(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65548, null, z, str) == null) {
            k.a(pq, new RewardWebViewInfo().setPageType(str).setRatioCount(pr).setEvent("webview_init").setSceneId(z ? "ad_reward" : "ad_fullscreen").toJson());
        }
    }

    public static void a(boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            k.a(pq, new RewardWebViewInfo().setPageType(str).setRatioCount(pr).setEvent("webview_load_url").setSceneId(z ? "ad_reward" : "ad_fullscreen").setUrl(str2).toJson());
        }
    }

    public static void a(boolean z, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Boolean.valueOf(z), str, str2, Long.valueOf(j)}) == null) {
            k.a(pq, new RewardWebViewInfo().setPageType(str).setRatioCount(pr).setEvent("webview_timeout").setSceneId(z ? "ad_reward" : "ad_fullscreen").setDurationMs(j).setUrl(str2).toJson());
        }
    }

    public static boolean a(long... jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, jArr)) == null) {
            for (long j : jArr) {
                if (j >= 60000) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(boolean z, AdTemplate adTemplate, int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{Boolean.valueOf(z), adTemplate, Integer.valueOf(i), Long.valueOf(j)}) == null) || j <= 0 || adTemplate.mLoadDataTime <= 0) {
            return;
        }
        adTemplate.mDownloadFinishTime = SystemClock.elapsedRealtime();
        AdInfo bQ = d.bQ(adTemplate);
        long j2 = adTemplate.mLoadDataTime;
        long j3 = j2 - j;
        long j4 = adTemplate.mDownloadFinishTime;
        long j5 = j4 - j2;
        long j6 = j4 - j;
        if (a(j3, j5, j6)) {
            return;
        }
        k.a(H(z), z, new RewardMonitorInfo().setRatioCount(J(z)).setLoadStatus(3).setLoadType(adTemplate.mLoadFromCache ? 2 : 1).setAdCount(i).setLoadDataDuration(j3).setDownloadDuration(j5).setTotalDuration(j6).setDownloadType(adTemplate.mDownloadType).setDownloadSize(adTemplate.mDownloadSize).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setVideoUrl(com.kwad.sdk.core.response.a.a.A(bQ)).setVideoDuration(com.kwad.sdk.core.response.a.a.B(bQ) * 1000).toJson(), com.kwai.adclient.kscommerciallogger.model.a.arI);
    }

    public static void b(boolean z, AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Boolean.valueOf(z), adTemplate, Long.valueOf(j)}) == null) {
            k.a(pq, new RewardWebViewInfo().setRatioCount(pr).setEvent("ad_show").setSceneId(z ? "ad_reward" : "ad_fullscreen").toJson());
        }
    }

    public static void b(boolean z, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{Boolean.valueOf(z), str, str2, Long.valueOf(j)}) == null) {
            k.a(pq, new RewardWebViewInfo().setPageType(str).setRatioCount(pr).setEvent("webview_load_finish").setSceneId(z ? "ad_reward" : "ad_fullscreen").setDurationMs(j).setUrl(str2).toJson());
        }
    }

    public static void c(boolean z, AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{Boolean.valueOf(z), adTemplate, Long.valueOf(j)}) == null) || j <= 0 || adTemplate.mLoadDataTime <= 0 || adTemplate.mDownloadFinishTime <= 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (a(elapsedRealtime)) {
            return;
        }
        AdInfo bQ = d.bQ(adTemplate);
        k.b(H(z), z, new RewardMonitorInfo().setRatioCount(J(z)).setPageStatus(2).setLoadType(adTemplate.mLoadFromCache ? 2 : 1).setRenderDuration(elapsedRealtime).setDownloadType(adTemplate.mDownloadType).setDownloadSize(adTemplate.mDownloadSize).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setVideoUrl(com.kwad.sdk.core.response.a.a.A(bQ)).setVideoDuration(com.kwad.sdk.core.response.a.a.B(bQ) * 1000).toJson());
    }

    public static synchronized void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            synchronized (a.class) {
                if (mHasInit) {
                    return;
                }
                Context context = KsAdSDKImpl.get().getContext();
                if (context == null) {
                    return;
                }
                mHasInit = true;
                double bc = com.kwad.sdk.core.config.d.bc(context);
                pi = bc;
                if (bc > 0.0d) {
                    pj = 1.0d / bc;
                }
                double bd = com.kwad.sdk.core.config.d.bd(context);
                pm = bd;
                if (bd > 0.0d) {
                    pn = 1.0d / bd;
                }
                double be = com.kwad.sdk.core.config.d.be(context);
                pk = be;
                if (be > 0.0d) {
                    pl = 1.0d / be;
                }
                double bb = com.kwad.sdk.core.config.d.bb(context);
                pq = bb;
                if (bb > 0.0d) {
                    pr = 1.0d / bb;
                }
                double bf = com.kwad.sdk.core.config.d.bf(context);
                po = bf;
                if (bf > 0.0d) {
                    pp = 1.0d / bf;
                }
            }
        }
    }
}
