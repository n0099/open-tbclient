package com.kwad.components.ad.interstitial.monitor;

import android.content.Context;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.k;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double fV;
    public double fW;
    public double fX;
    public double fY;
    public double fZ;
    public double ga;

    /* loaded from: classes7.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final b gb;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(238423323, "Lcom/kwad/components/ad/interstitial/monitor/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(238423323, "Lcom/kwad/components/ad/interstitial/monitor/b$a;");
                    return;
                }
            }
            gb = new b((byte) 0);
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init();
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b cr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.gb : (b) invokeV.objValue;
    }

    private void init() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
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

    public final void a(AdTemplate adTemplate, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, adTemplate, i) == null) {
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
    }

    public final void a(AdTemplate adTemplate, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, i, str) == null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            k.k(this.fZ, new InterstitialMonitorInfo().setRatioCount(this.ga).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setVideoUrl(com.kwad.sdk.core.response.a.a.A(bQ)).setDownloadType(adTemplate.mDownloadType).setDownloadSize(adTemplate.mDownloadSize).setVideoDuration(com.kwad.sdk.core.response.a.a.B(bQ) * 1000).setErrorMsg(str).setErrorCode(i).toJson());
        }
    }

    public final void a(AdTemplate adTemplate, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{adTemplate, Long.valueOf(j), Boolean.valueOf(z)}) == null) || j <= 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        adTemplate.loadDataTime = elapsedRealtime;
        if (elapsedRealtime <= 0 || elapsedRealtime >= 60000) {
            return;
        }
        k.i(this.fV, new InterstitialMonitorInfo().setRatioCount(this.fW).setStatus(2).setType(z ? 2 : 1).setLoadDataTime(adTemplate.loadDataTime).toJson());
    }

    public final void a(AdTemplate adTemplate, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, adTemplate, str) == null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            k.j(this.fX, new InterstitialMonitorInfo().setRatioCount(this.fY).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setVideoUrl(com.kwad.sdk.core.response.a.a.A(bQ)).setDownloadSize(adTemplate.mDownloadSize).setDownloadType(adTemplate.mDownloadType).setVideoDuration(com.kwad.sdk.core.response.a.a.B(bQ) * 1000).setErrorMsg(str).toJson());
        }
    }

    public final void b(AdTemplate adTemplate, long j, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{adTemplate, Long.valueOf(j), Boolean.valueOf(z)}) == null) && j > 0 && com.kwad.sdk.core.response.a.a.aE(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            k.i(this.fV, new InterstitialMonitorInfo().setRatioCount(this.fW).setStatus(1).toJson());
        }
    }

    public final void ct() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k.i(this.fV, new InterstitialMonitorInfo().setRatioCount(this.fW).setStatus(6).toJson());
        }
    }

    public final void d(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, str) == null) {
            k.i(this.fV, new InterstitialMonitorInfo().setRatioCount(this.fW).setStatus(5).setErrorCode(i).setErrorMsg(str).toJson());
        }
    }
}
