package com.kwad.components.splash.monitor;

import android.content.Context;
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
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a QH;
    public static double QI;
    public static double QJ;
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
        init();
    }

    public static void W(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, adTemplate) == null) {
            k.h(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(1).setType(com.kwad.sdk.core.response.a.a.aC(d.bQ(adTemplate)) ? 2 : 1).toJson());
        }
    }

    public static void X(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, adTemplate) == null) {
            AdInfo bQ = d.bQ(adTemplate);
            k.h(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(4).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setType(com.kwad.sdk.core.response.a.a.aC(bQ) ? 2 : 1).toJson());
        }
    }

    public static void a(AdInfo adInfo, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65539, null, adInfo, i, str) == null) {
            k.f(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(2).setPreloadId(com.kwad.sdk.core.response.a.a.az(adInfo)).setCreativeId(com.kwad.sdk.core.response.a.a.z(adInfo)).setFailUrl(com.kwad.sdk.core.response.a.a.aB(adInfo) ? com.kwad.sdk.core.response.a.a.A(adInfo) : com.kwad.sdk.core.response.a.a.at(adInfo).materialUrl).setErrorCode(i).setErrorMsg(str).setMaterialType(com.kwad.sdk.core.response.a.a.aB(adInfo) ? 1 : 2).setType(1).toJson());
        }
    }

    public static void a(String str, boolean z, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i), str2}) == null) {
            k.c(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(4).setType(z ? 2 : 1).setErrorCode(i).setPreloadId(str).setErrorMsg(str2).toJson());
        }
    }

    public static boolean b(long... jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jArr)) == null) {
            for (long j : jArr) {
                if (j <= 0 || j >= 60000) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void d(AdTemplate adTemplate, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65542, null, adTemplate, i, str) == null) {
            AdInfo bQ = d.bQ(adTemplate);
            boolean aC = com.kwad.sdk.core.response.a.a.aC(bQ);
            k.h(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(3).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setPreloadId(com.kwad.sdk.core.response.a.a.az(bQ)).setType(aC ? 2 : 1).setFailUrl(aC ? com.kwad.sdk.core.response.a.a.at(bQ).materialUrl : com.kwad.sdk.core.response.a.a.A(bQ)).setErrorCode(i).setErrorMsg(str).toJson());
        }
    }

    public static void f(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65543, null, i, str) == null) {
            k.e(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(3).setErrorCode(i).setErrorMsg(str).toJson());
        }
    }

    public static void f(AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65544, null, adTemplate, j) == null) {
            AdInfo bQ = d.bQ(adTemplate);
            k.h(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(2).setType(com.kwad.sdk.core.response.a.a.aC(bQ) ? 2 : 1).setCostTime(j).setCreativeId(com.kwad.sdk.core.response.a.a.z(bQ)).setPreloadId(com.kwad.sdk.core.response.a.a.az(bQ)).toJson());
        }
    }

    public static void h(AdResultData adResultData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, adResultData) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                arrayList.add(String.valueOf(com.kwad.sdk.core.response.a.a.z(d.bQ(adTemplate))));
                arrayList2.add(com.kwad.sdk.core.response.a.a.az(d.bQ(adTemplate)));
            }
            k.g(QJ, new SplashMonitorInfo().setRatioCount(QI).setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).toJson());
        }
    }

    public static void init() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, null) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        double bg = com.kwad.sdk.core.config.d.bg(context);
        QJ = bg;
        if (bg > 0.0d) {
            QI = 1.0d / bg;
        }
    }

    public static void l(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, str, i) == null) {
            k.d(QJ, new SplashMonitorInfo().setRatioCount(QI).setPreloadId(str).setStatus(i).toJson());
        }
    }

    public static a qG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (QH == null) {
                synchronized (a.class) {
                    if (QH == null) {
                        QH = new a();
                    }
                }
            }
            return QH;
        }
        return (a) invokeV.objValue;
    }

    public static void qH() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            k.c(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(1).toJson());
        }
    }

    public static void qI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            k.e(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(1).toJson());
        }
    }

    public final void U(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            if (b(adTemplate.loadDataTime)) {
                return;
            }
            k.c(QJ, new SplashMonitorInfo().setRatioCount(QI).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setLoadDataTime(adTemplate.loadDataTime).setPreloadId(com.kwad.sdk.core.response.a.a.az(d.bQ(adTemplate))).toJson());
        }
    }

    public final void V(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            if (b(adTemplate.loadDataTime, adTemplate.checkDataTime)) {
                return;
            }
            k.c(QJ, new SplashMonitorInfo().setRatioCount(QI).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(adTemplate.checkDataTime).setLoadAndCheckDataTime(adTemplate.loadDataTime + adTemplate.checkDataTime).setPreloadId(com.kwad.sdk.core.response.a.a.az(d.bQ(adTemplate))).toJson());
        }
    }

    public final void a(AdInfo adInfo, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{adInfo, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            if (b(j)) {
                return;
            }
            long j2 = 0;
            File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(com.kwad.sdk.core.response.a.a.aB(adInfo) ? com.kwad.sdk.core.response.a.a.A(adInfo) : com.kwad.sdk.core.response.a.a.at(adInfo).materialUrl);
            if (ad != null && ad.exists()) {
                j2 = ad.length();
            }
            k.f(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(1).setPreloadId(com.kwad.sdk.core.response.a.a.az(adInfo)).setCostTime(j).setCacheValidTime(adInfo.adPreloadInfo.validityPeriod * 1000).setSize(j2).setMaterialType(com.kwad.sdk.core.response.a.a.aB(adInfo) ? 1 : 2).setType(i).setCreativeId(com.kwad.sdk.core.response.a.a.z(adInfo)).toJson());
        }
    }

    public final void b(List list, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, list, j) == null) || b(j)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.kwad.sdk.core.response.a.a.az(d.bQ((AdTemplate) it.next())));
        }
        k.e(QJ, new SplashMonitorInfo().setRatioCount(QI).setStatus(2).setIds(arrayList).setLoadDataTime(j).setCount(list.size()).toJson());
    }
}
