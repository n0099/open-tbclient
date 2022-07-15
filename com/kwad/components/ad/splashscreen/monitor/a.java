package com.kwad.components.ad.splashscreen.monitor;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.k;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a a;
    public static boolean b;
    public static long c;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
        d();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    public static void a(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65538, null, i, str) == null) && b) {
            k.d(new SplashMonitorInfo().setRadioCount(c).setStatus(3).setErrorCode(i).setErrorMsg(str).toJson());
        }
    }

    public static void a(@NonNull AdResultData adResultData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, adResultData) == null) && b) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                arrayList.add(String.valueOf(com.kwad.sdk.core.response.a.a.a(d.i(adTemplate))));
                arrayList2.add(com.kwad.sdk.core.response.a.a.U(d.i(adTemplate)));
            }
            k.f(new SplashMonitorInfo().setRadioCount(c).setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).toJson());
        }
    }

    public static void a(@NonNull AdInfo adInfo, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, adInfo, i, str) == null) && b) {
            k.e(new SplashMonitorInfo().setRadioCount(c).setStatus(2).setPreloadId(com.kwad.sdk.core.response.a.a.U(adInfo)).setCreativeId(com.kwad.sdk.core.response.a.a.a(adInfo)).setFailUrl(com.kwad.sdk.core.response.a.a.W(adInfo) ? com.kwad.sdk.core.response.a.a.b(adInfo) : com.kwad.sdk.core.response.a.a.P(adInfo).materialUrl).setErrorCode(i).setErrorMsg(str).setMaterialType(com.kwad.sdk.core.response.a.a.W(adInfo) ? 1 : 2).setType(1).toJson());
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65541, null, adTemplate, i, str) == null) && b) {
            AdInfo i2 = d.i(adTemplate);
            boolean X = com.kwad.sdk.core.response.a.a.X(i2);
            k.g(new SplashMonitorInfo().setRadioCount(c).setStatus(3).setCreativeId(com.kwad.sdk.core.response.a.a.a(i2)).setPreloadId(com.kwad.sdk.core.response.a.a.U(i2)).setType(X ? 2 : 1).setFailUrl(X ? com.kwad.sdk.core.response.a.a.P(i2).materialUrl : com.kwad.sdk.core.response.a.a.b(i2)).setErrorCode(i).setErrorMsg(str).toJson());
        }
    }

    public static void a(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65542, null, str, i) == null) && b) {
            k.c(new SplashMonitorInfo().setRadioCount(c).setPreloadId(str).setStatus(i).toJson());
        }
    }

    public static void a(String str, boolean z, int i, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i), str2}) == null) && b) {
            k.b(new SplashMonitorInfo().setRadioCount(c).setStatus(4).setType(z ? 2 : 1).setErrorCode(i).setPreloadId(str).setErrorMsg(str2).toJson());
        }
    }

    public static boolean a(long... jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jArr)) == null) {
            for (long j : jArr) {
                if (j <= 0 || j >= 60000) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, null) == null) && b) {
            k.b(new SplashMonitorInfo().setRadioCount(c).setStatus(1).toJson());
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && b) {
            k.d(new SplashMonitorInfo().setRadioCount(c).setStatus(1).toJson());
        }
    }

    public static void c(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, adTemplate) == null) && b) {
            k.g(new SplashMonitorInfo().setRadioCount(c).setStatus(1).setType(com.kwad.sdk.core.response.a.a.X(d.i(adTemplate)) ? 2 : 1).toJson());
        }
    }

    public static void d() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, null) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        float i = com.kwad.sdk.core.config.d.i(context);
        if (i > 0.0f) {
            c = 1.0f / i;
        }
        b = new Random().nextFloat() < i;
    }

    public final void a(@NonNull AdInfo adInfo, long j, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adInfo, Long.valueOf(j), Integer.valueOf(i)}) == null) && b) {
            if (a(j)) {
                return;
            }
            long j2 = 0;
            File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(com.kwad.sdk.core.response.a.a.W(adInfo) ? com.kwad.sdk.core.response.a.a.b(adInfo) : com.kwad.sdk.core.response.a.a.P(adInfo).materialUrl);
            if (b2 != null && b2.exists()) {
                j2 = b2.length();
            }
            k.e(new SplashMonitorInfo().setRadioCount(c).setStatus(1).setPreloadId(com.kwad.sdk.core.response.a.a.U(adInfo)).setCostTime(j).setCacheValidTime(adInfo.adPreloadInfo.validityPeriod * 1000).setSize(j2).setMaterialType(com.kwad.sdk.core.response.a.a.W(adInfo) ? 1 : 2).setType(i).setCreativeId(com.kwad.sdk.core.response.a.a.a(adInfo)).toJson());
        }
    }

    public final void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) && b) {
            if (a(adTemplate.loadDataTime)) {
                return;
            }
            k.b(new SplashMonitorInfo().setRadioCount(c).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setLoadDataTime(adTemplate.loadDataTime).setPreloadId(com.kwad.sdk.core.response.a.a.U(d.i(adTemplate))).toJson());
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, adTemplate, j) == null) && b) {
            if (a(j)) {
                return;
            }
            AdInfo i = d.i(adTemplate);
            k.g(new SplashMonitorInfo().setRadioCount(c).setStatus(2).setType(com.kwad.sdk.core.response.a.a.X(i) ? 2 : 1).setCostTime(j).setCreativeId(com.kwad.sdk.core.response.a.a.a(i)).setPreloadId(com.kwad.sdk.core.response.a.a.U(i)).toJson());
        }
    }

    public final void a(@NonNull List<AdTemplate> list, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048579, this, list, j) == null) && b && !a(j)) {
            ArrayList arrayList = new ArrayList();
            for (AdTemplate adTemplate : list) {
                arrayList.add(com.kwad.sdk.core.response.a.a.U(d.i(adTemplate)));
            }
            k.d(new SplashMonitorInfo().setRadioCount(c).setStatus(2).setIds(arrayList).setLoadDataTime(j).setCount(list.size()).toJson());
        }
    }

    public final void b(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, adTemplate) == null) && b) {
            if (a(adTemplate.loadDataTime, adTemplate.checkDataTime)) {
                return;
            }
            k.b(new SplashMonitorInfo().setRadioCount(c).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(adTemplate.checkDataTime).setLoadAndCheckDataTime(adTemplate.loadDataTime + adTemplate.checkDataTime).setPreloadId(com.kwad.sdk.core.response.a.a.U(d.i(adTemplate))).toJson());
        }
    }
}
