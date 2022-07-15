package com.kwad.components.ad.reward.monitor;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.k;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Random;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static boolean b;
    public static long c;
    public static boolean d;
    public static long e;
    public static boolean f;
    public static long g;
    public static boolean h;
    public static long i;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65536, null) == null) || a || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        a = true;
        float e2 = d.e(context);
        b = new Random().nextFloat() < e2;
        if (e2 > 0.0f) {
            c = 1.0f / e2;
        }
        float f2 = d.f(context);
        f = new Random().nextFloat() < f2;
        if (f2 > 0.0f) {
            g = 1.0f / f2;
        }
        float g2 = d.g(context);
        d = new Random().nextFloat() < g2;
        if (g2 > 0.0f) {
            e = 1.0f / g2;
        }
        float h2 = d.h(context);
        h = new Random().nextFloat() < h2;
        if (h2 > 0.0f) {
            i = 1.0f / h2;
        }
    }

    public static void a(AdTemplate adTemplate, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{adTemplate, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || a(true)) {
            return;
        }
        AdInfo i4 = com.kwad.sdk.core.response.a.d.i(adTemplate);
        k.a(new RewardMonitorInfo().setRadioCount(c(true)).setCreativeId(com.kwad.sdk.core.response.a.a.a(i4)).setRewardType(!z ? 1 : 0).setTaskType(i2).setTaskStep(i3).setVideoUrl(com.kwad.sdk.core.response.a.a.b(i4)).setVideoDuration(com.kwad.sdk.core.response.a.a.c(i4) * 1000).toJson());
    }

    public static void a(boolean z, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) || a(z)) {
            return;
        }
        k.a(z, new RewardMonitorInfo().setRadioCount(c(z)).setLoadStatus(4).setErrorCode(i2).setErrorMsg(str).toJson(), com.kwai.adclient.kscommerciallogger.model.a.g);
    }

    public static void a(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || a(z) || j <= 0) {
            return;
        }
        k.a(z, new RewardMonitorInfo().setRadioCount(c(z)).setLoadStatus(1).toJson(), com.kwai.adclient.kscommerciallogger.model.a.k);
    }

    public static void a(boolean z, @NonNull AdTemplate adTemplate, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), adTemplate, Integer.valueOf(i2), Long.valueOf(j)}) == null) || a(z) || j <= 0) {
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
        AdInfo i3 = com.kwad.sdk.core.response.a.d.i(adTemplate);
        k.a(z, new RewardMonitorInfo().setRadioCount(c(z)).setLoadStatus(2).setLoadType(adTemplate.mLoadFromCache ? 2 : 1).setAdCount(i2).setLoadDataDuration(j3).setCreativeId(com.kwad.sdk.core.response.a.a.a(i3)).setVideoUrl(com.kwad.sdk.core.response.a.a.b(i3)).setVideoDuration(com.kwad.sdk.core.response.a.a.c(i3) * 1000).toJson(), com.kwai.adclient.kscommerciallogger.model.a.k);
    }

    public static void a(boolean z, AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Boolean.valueOf(z), adTemplate, Long.valueOf(j)}) == null) || a(z)) {
            return;
        }
        long j2 = adTemplate.mLoadDataTime;
        if (j2 > 0) {
            long j3 = adTemplate.mDownloadFinishTime;
            if (j3 <= 0) {
                return;
            }
            long j4 = j - j2;
            long j5 = j - j3;
            if (a(j4, j5)) {
                return;
            }
            AdInfo i2 = com.kwad.sdk.core.response.a.d.i(adTemplate);
            k.b(z, new RewardMonitorInfo().setRadioCount(c(z)).setPageStatus(1).setLoadType(adTemplate.mLoadFromCache ? 2 : 1).setDataLoadInterval(j4).setDataDownloadInterval(j5).setDownloadType(adTemplate.mDownloadType).setDownloadSize(adTemplate.mDownloadSize).setCreativeId(com.kwad.sdk.core.response.a.a.a(i2)).setVideoUrl(com.kwad.sdk.core.response.a.a.b(i2)).setVideoDuration(com.kwad.sdk.core.response.a.a.c(i2) * 1000).toJson());
        }
    }

    public static void a(boolean z, AdTemplate adTemplate, long j, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Boolean.valueOf(z), adTemplate, Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) || b(z)) {
            return;
        }
        AdInfo i3 = com.kwad.sdk.core.response.a.d.i(adTemplate);
        k.c(z, new RewardMonitorInfo().setRadioCount(d(z)).setLoadType(adTemplate.mLoadFromCache ? 2 : 1).setCurrentDuration(j).setErrorCode(i2).setErrorMsg(String.valueOf(j2)).setDownloadType(adTemplate.mDownloadType).setDownloadSize(adTemplate.mDownloadSize).setCreativeId(com.kwad.sdk.core.response.a.a.a(i3)).setVideoUrl(com.kwad.sdk.core.response.a.a.b(i3)).setVideoDuration(com.kwad.sdk.core.response.a.a.c(i3) * 1000).toJson());
    }

    public static void a(boolean z, AdTemplate adTemplate, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), adTemplate, str}) == null) || b(z)) {
            return;
        }
        AdInfo i2 = com.kwad.sdk.core.response.a.d.i(adTemplate);
        k.a(z, new RewardMonitorInfo().setRadioCount(d(z)).setLoadType(adTemplate.mLoadFromCache ? 2 : 1).setDownloadType(adTemplate.mDownloadType).setDownloadSize(adTemplate.mDownloadSize).setCreativeId(com.kwad.sdk.core.response.a.a.a(i2)).setVideoUrl(com.kwad.sdk.core.response.a.a.b(i2)).setVideoDuration(com.kwad.sdk.core.response.a.a.c(i2) * 1000).setErrorMsg(str).toJson());
    }

    public static boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65544, null, z)) == null) {
            a();
            return z ? !b : !f;
        }
        return invokeZ.booleanValue;
    }

    public static boolean a(long... jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jArr)) == null) {
            for (long j : jArr) {
                if (j >= 60000) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(boolean z, AdTemplate adTemplate, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Boolean.valueOf(z), adTemplate, Integer.valueOf(i2), Long.valueOf(j)}) == null) || a(z) || j <= 0 || adTemplate.mLoadDataTime <= 0) {
            return;
        }
        adTemplate.mDownloadFinishTime = SystemClock.elapsedRealtime();
        AdInfo i3 = com.kwad.sdk.core.response.a.d.i(adTemplate);
        long j2 = adTemplate.mLoadDataTime;
        long j3 = j2 - j;
        long j4 = adTemplate.mDownloadFinishTime;
        long j5 = j4 - j2;
        long j6 = j4 - j;
        if (a(j3, j5, j6)) {
            return;
        }
        k.a(z, new RewardMonitorInfo().setRadioCount(c(z)).setLoadStatus(3).setLoadType(adTemplate.mLoadFromCache ? 2 : 1).setAdCount(i2).setLoadDataDuration(j3).setDownloadDuration(j5).setTotalDuration(j6).setDownloadType(adTemplate.mDownloadType).setDownloadSize(adTemplate.mDownloadSize).setCreativeId(com.kwad.sdk.core.response.a.a.a(i3)).setVideoUrl(com.kwad.sdk.core.response.a.a.b(i3)).setVideoDuration(com.kwad.sdk.core.response.a.a.c(i3) * 1000).toJson(), com.kwai.adclient.kscommerciallogger.model.a.k);
    }

    public static void b(boolean z, AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), adTemplate, Long.valueOf(j)}) == null) || a(z) || j <= 0 || adTemplate.mLoadDataTime <= 0 || adTemplate.mDownloadFinishTime <= 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (a(elapsedRealtime)) {
            return;
        }
        AdInfo i2 = com.kwad.sdk.core.response.a.d.i(adTemplate);
        k.b(z, new RewardMonitorInfo().setRadioCount(c(z)).setPageStatus(2).setLoadType(adTemplate.mLoadFromCache ? 2 : 1).setRenderDuration(elapsedRealtime).setDownloadType(adTemplate.mDownloadType).setDownloadSize(adTemplate.mDownloadSize).setCreativeId(com.kwad.sdk.core.response.a.a.a(i2)).setVideoUrl(com.kwad.sdk.core.response.a.a.b(i2)).setVideoDuration(com.kwad.sdk.core.response.a.a.c(i2) * 1000).toJson());
    }

    public static boolean b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65548, null, z)) == null) {
            a();
            return z ? !d : !h;
        }
        return invokeZ.booleanValue;
    }

    public static long c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65549, null, z)) == null) ? z ? c : g : invokeZ.longValue;
    }

    public static long d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65550, null, z)) == null) ? z ? e : i : invokeZ.longValue;
    }
}
