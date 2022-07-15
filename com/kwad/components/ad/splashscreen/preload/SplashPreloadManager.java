package com.kwad.components.ad.splashscreen.preload;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.core.video.f;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.diskcache.a.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class SplashPreloadManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, PreLoadItem> a;
    public List<String> b;
    public volatile SharedPreferences c;
    public final Object d;

    @KsJson
    /* loaded from: classes5.dex */
    public static class PreLoadItem extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long cacheTime;
        public long expiredTime;
        public String preloadId;

        public PreLoadItem() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class PreLoadPara extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int isValidReturned;
        public long spreadTime;

        public PreLoadPara() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final SplashPreloadManager a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(819391882, "Lcom/kwad/components/ad/splashscreen/preload/SplashPreloadManager$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(819391882, "Lcom/kwad/components/ad/splashscreen/preload/SplashPreloadManager$a;");
                    return;
                }
            }
            a = new SplashPreloadManager((byte) 0);
        }
    }

    public SplashPreloadManager() {
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
        this.d = new Object();
        this.a = new HashMap<>();
        this.b = new ArrayList();
        c();
    }

    public /* synthetic */ SplashPreloadManager(byte b) {
        this();
    }

    @AnyThread
    public static SplashPreloadManager a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            SplashPreloadManager splashPreloadManager = a.a;
            if (splashPreloadManager.c == null) {
                splashPreloadManager.c();
            }
            return splashPreloadManager;
        }
        return (SplashPreloadManager) invokeV.objValue;
    }

    public static File a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str != null) {
                b.a("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
                File b = com.kwad.sdk.core.diskcache.a.a.a().b(str);
                if (b == null || !b.exists()) {
                    return null;
                }
                return b;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    @AnyThread
    private void a(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, adInfo) == null) {
            PreLoadItem preLoadItem = new PreLoadItem();
            preLoadItem.cacheTime = System.currentTimeMillis();
            preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
            preLoadItem.preloadId = com.kwad.sdk.core.response.a.a.U(adInfo);
            synchronized (this.d) {
                this.a.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
                if (!this.b.contains(adInfo.adPreloadInfo.preloadId)) {
                    this.b.add(adInfo.adPreloadInfo.preloadId);
                }
            }
            if (this.c != null) {
                SharedPreferences.Editor edit = this.c.edit();
                edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
                edit.apply();
            }
        }
    }

    @AnyThread
    public static boolean b(AdResultData adResultData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, adResultData)) == null) {
            if (!adResultData.getAdTemplateList().isEmpty()) {
                AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                if (!adTemplate.adInfoList.isEmpty()) {
                    return com.kwad.sdk.core.response.a.a.X(adTemplate.adInfoList.get(0));
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @AnyThread
    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str != null) {
                File b = com.kwad.sdk.core.diskcache.a.a.a().b(str);
                StringBuilder sb = new StringBuilder("check preloadId ");
                sb.append(str);
                sb.append(" file exists ");
                sb.append(b == null ? StringUtil.NULL_STRING : Boolean.valueOf(b.exists()));
                b.a("PreloadManager", sb.toString());
                if (b != null && b.exists()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void c() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        this.c = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
        d();
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            Map<String, ?> all = this.c.getAll();
            ArrayList<String> arrayList = new ArrayList();
            for (String str : all.keySet()) {
                PreLoadItem preLoadItem = new PreLoadItem();
                try {
                    Object obj = all.get(str);
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (!TextUtils.isEmpty(str2)) {
                            preLoadItem.parseJson(new JSONObject(str2));
                            if (!TextUtils.isEmpty(preLoadItem.preloadId)) {
                                File b = com.kwad.sdk.core.diskcache.a.a.a().b(preLoadItem.preloadId);
                                if (b == null || !b.exists()) {
                                    arrayList.add(preLoadItem.preloadId);
                                    b.a("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                                } else {
                                    synchronized (this.d) {
                                        this.a.put(str, preLoadItem);
                                        if (!this.b.contains(str)) {
                                            this.b.add(str);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    b.a(e);
                }
            }
            SharedPreferences.Editor edit = this.c.edit();
            for (String str3 : arrayList) {
                edit.remove(str3);
            }
            edit.apply();
        }
    }

    private void e() {
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.d) {
                ArrayList<String> arrayList = new ArrayList();
                for (String str : this.a.keySet()) {
                    PreLoadItem preLoadItem = this.a.get(str);
                    if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                        arrayList.add(str);
                    }
                }
                SharedPreferences.Editor edit = this.c.edit();
                for (String str2 : arrayList) {
                    this.b.remove(str2);
                    this.a.remove(str2);
                    edit.remove(str2);
                    com.kwad.sdk.core.diskcache.a.a.a().c(str2);
                }
                edit.apply();
                size = this.b.size();
            }
            if (size > 30) {
                b.a("PreloadManager", "大于 30 按失效日期远近顺序移除");
                int i = size - 15;
                for (int i2 = 0; i2 < i; i2++) {
                    long j = Long.MAX_VALUE;
                    String str3 = "";
                    synchronized (this.d) {
                        for (PreLoadItem preLoadItem2 : this.a.values()) {
                            if (preLoadItem2.expiredTime < j) {
                                j = preLoadItem2.expiredTime;
                                str3 = preLoadItem2.preloadId;
                            }
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            this.b.remove(str3);
                            this.a.remove(str3);
                            this.c.edit().remove(str3).apply();
                            b.a("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j);
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        com.kwad.sdk.core.diskcache.a.a.a().c(str3);
                    }
                }
            }
        }
    }

    @AnyThread
    public final int a(AdResultData adResultData, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, adResultData, z)) == null) {
            Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
            com.kwad.components.ad.splashscreen.monitor.a.a();
            com.kwad.components.ad.splashscreen.monitor.a.a(adResultData);
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AdTemplate next = it.next();
                if (next != null) {
                    for (AdInfo adInfo : next.adInfoList) {
                        if (adInfo.adPreloadInfo == null || this.c == null) {
                            com.kwad.components.ad.splashscreen.monitor.a.a();
                            com.kwad.components.ad.splashscreen.monitor.a.a(adInfo, 3, SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG);
                        } else {
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            if (b(adInfo.adPreloadInfo.preloadId)) {
                                com.kwad.components.ad.splashscreen.monitor.a.a().a(adInfo, SystemClock.elapsedRealtime() - elapsedRealtime, 2);
                                a(adInfo);
                                i++;
                            } else {
                                String b = com.kwad.sdk.core.response.a.a.W(adInfo) ? com.kwad.sdk.core.response.a.a.b(adInfo) : com.kwad.sdk.core.response.a.a.X(adInfo) ? com.kwad.sdk.core.response.a.a.P(adInfo).materialUrl : null;
                                if (TextUtils.isEmpty(b)) {
                                    com.kwad.components.ad.splashscreen.monitor.a.a();
                                    com.kwad.components.ad.splashscreen.monitor.a.a(adInfo, 2, SplashMonitorInfo.ERROR_URL_INVALID_MSG);
                                } else {
                                    String U = com.kwad.sdk.core.response.a.a.U(adInfo);
                                    if (adInfo.adPreloadInfo.preloadType != 1 || ac.c(KsAdSDKImpl.get().getContext()) || z) {
                                        b.a("PreloadManager", "start Download preloadId " + U + " true url " + b);
                                        e();
                                        c.a aVar = new c.a();
                                        if (f.a(b, U, aVar)) {
                                            a(adInfo);
                                            i++;
                                            com.kwad.components.ad.splashscreen.monitor.a.a().a(adInfo, SystemClock.elapsedRealtime() - elapsedRealtime, 1);
                                        } else {
                                            com.kwad.components.ad.splashscreen.monitor.a.a();
                                            com.kwad.components.ad.splashscreen.monitor.a.a(adInfo, 4, aVar.a);
                                            com.kwad.components.core.i.a.a().a(next, 1, aVar.a);
                                        }
                                    } else {
                                        com.kwad.components.ad.splashscreen.monitor.a.a();
                                        com.kwad.components.ad.splashscreen.monitor.a.a(adInfo, 1, SplashMonitorInfo.ERROR_NET_MSG);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            AdTemplate adTemplate = adResultData.getAdTemplateList().size() > 0 ? adResultData.getAdTemplateList().get(0) : null;
            if (i > 0) {
                com.kwad.components.core.i.a.a().a(adTemplate, i);
            }
            return i;
        }
        return invokeLZ.intValue;
    }

    @AnyThread
    public final boolean a(AdResultData adResultData) {
        InterceptResult invokeL;
        PreLoadItem preLoadItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData)) == null) {
            boolean z = false;
            z = false;
            z = false;
            if (!adResultData.getAdTemplateList().isEmpty()) {
                AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                if (!adTemplate.adInfoList.isEmpty()) {
                    AdInfo adInfo = adTemplate.adInfoList.get(0);
                    if (adInfo.adPreloadInfo != null) {
                        String U = com.kwad.sdk.core.response.a.a.U(adInfo);
                        z = b(U);
                        PreLoadPara preLoadPara = new PreLoadPara();
                        preLoadPara.isValidReturned = z ? 1 : 0;
                        if (z) {
                            synchronized (this.d) {
                                preLoadItem = this.a.get(U);
                            }
                            if (preLoadItem != null) {
                                preLoadPara.spreadTime = preLoadItem.cacheTime;
                            }
                        }
                        b.a("PreloadManager", "check checked " + z + " spreadTime " + preLoadPara.spreadTime);
                        com.kwad.sdk.core.report.a.a(adTemplate, preLoadPara.toJson());
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.d) {
                b.a("PreloadManager", "getPreloadIdList start ");
                for (int i = 0; i < this.b.size(); i++) {
                    String str = this.b.get(i);
                    File b = com.kwad.sdk.core.diskcache.a.a.a().b(str);
                    if (b != null && b.exists()) {
                        arrayList.add(str);
                    }
                }
                b.a("PreloadManager", "getPreloadIdList end ");
            }
            b.a("PreloadManager", "getPreloadIdList " + this.b.size());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
