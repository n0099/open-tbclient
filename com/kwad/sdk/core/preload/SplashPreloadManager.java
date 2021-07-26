package com.kwad.sdk.core.preload;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.download.d.b;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.core.diskcache.b.c;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.g;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SplashPreloadManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, PreLoadItem> f35015a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f35016b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SharedPreferences f35017c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f35018d;

    /* renamed from: com.kwad.sdk.core.preload.SplashPreloadManager$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class PreLoadItem extends com.kwad.sdk.core.response.a.a implements Serializable {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class PreLoadPara extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int isValidReturned;
        public long spreadTime;

        public PreLoadPara() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final SplashPreloadManager f35019a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-730996648, "Lcom/kwad/sdk/core/preload/SplashPreloadManager$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-730996648, "Lcom/kwad/sdk/core/preload/SplashPreloadManager$a;");
                    return;
                }
            }
            f35019a = new SplashPreloadManager(null);
        }
    }

    public SplashPreloadManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35018d = new Object();
        this.f35015a = new HashMap<>();
        this.f35016b = new ArrayList();
        a();
    }

    public /* synthetic */ SplashPreloadManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    @AnyThread
    private void a(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, adInfo) == null) {
            PreLoadItem preLoadItem = new PreLoadItem();
            preLoadItem.cacheTime = System.currentTimeMillis();
            preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
            preLoadItem.preloadId = com.kwad.sdk.core.response.b.a.D(adInfo);
            synchronized (this.f35018d) {
                this.f35015a.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
                if (!this.f35016b.contains(adInfo.adPreloadInfo.preloadId)) {
                    this.f35016b.add(adInfo.adPreloadInfo.preloadId);
                }
            }
            if (this.f35017c != null) {
                SharedPreferences.Editor edit = this.f35017c.edit();
                edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
                edit.apply();
            }
        }
    }

    @AnyThread
    public static SplashPreloadManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            SplashPreloadManager splashPreloadManager = a.f35019a;
            if (splashPreloadManager.f35017c == null) {
                splashPreloadManager.a();
            }
            return splashPreloadManager;
        }
        return (SplashPreloadManager) invokeV.objValue;
    }

    @AnyThread
    private boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            if (str != null) {
                File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(str);
                StringBuilder sb = new StringBuilder();
                sb.append("check preloadId ");
                sb.append(str);
                sb.append(" file exists ");
                sb.append(b2 == null ? StringUtil.NULL_STRING : Boolean.valueOf(b2.exists()));
                com.kwad.sdk.core.d.a.a("PreloadManager", sb.toString());
                return b2 != null && b2.exists();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            Map<String, ?> all = this.f35017c.getAll();
            ArrayList<String> arrayList = new ArrayList();
            for (String str : all.keySet()) {
                PreLoadItem preLoadItem = new PreLoadItem();
                try {
                    String str2 = (String) all.get(str);
                    if (str2 != null) {
                        preLoadItem.parseJson(new JSONObject(str2));
                        if (!TextUtils.isEmpty(preLoadItem.preloadId)) {
                            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(preLoadItem.preloadId);
                            if (b2 == null || !b2.exists()) {
                                arrayList.add(preLoadItem.preloadId);
                                com.kwad.sdk.core.d.a.a("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            } else {
                                synchronized (this.f35018d) {
                                    this.f35015a.put(str, preLoadItem);
                                    if (!this.f35016b.contains(str)) {
                                        this.f35016b.add(str);
                                    }
                                }
                            }
                        }
                    }
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            SharedPreferences.Editor edit = this.f35017c.edit();
            for (String str3 : arrayList) {
                edit.remove(str3);
            }
            edit.apply();
        }
    }

    private void e() {
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.f35018d) {
                ArrayList<String> arrayList = new ArrayList();
                for (String str : this.f35015a.keySet()) {
                    PreLoadItem preLoadItem = this.f35015a.get(str);
                    if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                        arrayList.add(str);
                    }
                }
                SharedPreferences.Editor edit = this.f35017c.edit();
                for (String str2 : arrayList) {
                    this.f35016b.remove(str2);
                    this.f35015a.remove(str2);
                    edit.remove(str2);
                    com.kwad.sdk.core.diskcache.b.a.a().c(str2);
                }
                edit.apply();
                size = this.f35016b.size();
            }
            if (size > 30) {
                com.kwad.sdk.core.d.a.a("PreloadManager", "大于 30 按失效日期远近顺序移除");
                int i2 = size - 15;
                for (int i3 = 0; i3 < i2; i3++) {
                    long j = Long.MAX_VALUE;
                    String str3 = "";
                    synchronized (this.f35018d) {
                        for (PreLoadItem preLoadItem2 : this.f35015a.values()) {
                            if (preLoadItem2.expiredTime < j) {
                                j = preLoadItem2.expiredTime;
                                str3 = preLoadItem2.preloadId;
                            }
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            this.f35016b.remove(str3);
                            this.f35015a.remove(str3);
                            this.f35017c.edit().remove(str3).apply();
                            com.kwad.sdk.core.d.a.a("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j);
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        com.kwad.sdk.core.diskcache.b.a.a().c(str3);
                    }
                }
            }
        }
    }

    @AnyThread
    public int a(AdResultData adResultData, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, adResultData, z)) == null) {
            Iterator<AdTemplate> it = adResultData.adTemplateList.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AdTemplate next = it.next();
                if (next != null) {
                    for (AdInfo adInfo : next.adInfoList) {
                        if (adInfo.adPreloadInfo != null && this.f35017c != null) {
                            if (!b(adInfo.adPreloadInfo.preloadId)) {
                                String a2 = com.kwad.sdk.core.response.b.a.F(adInfo) ? com.kwad.sdk.core.response.b.a.a(adInfo) : com.kwad.sdk.core.response.b.a.G(adInfo) ? com.kwad.sdk.core.response.b.a.B(adInfo).materialUrl : null;
                                if (!TextUtils.isEmpty(a2)) {
                                    String D = com.kwad.sdk.core.response.b.a.D(adInfo);
                                    if (adInfo.adPreloadInfo.preloadType != 1 || b.b(KsAdSDK.getContext()) || z) {
                                        com.kwad.sdk.core.d.a.a("PreloadManager", "start Download preloadId " + D + " true url " + a2);
                                        e();
                                        c.a aVar = new c.a();
                                        if (!g.a(a2, D, aVar)) {
                                            d.a(next, 1, aVar.f34469a);
                                        }
                                    }
                                }
                            }
                            a(adInfo);
                            i2++;
                        }
                    }
                }
            }
            AdTemplate adTemplate = adResultData.adTemplateList.size() > 0 ? adResultData.adTemplateList.get(0) : null;
            if (i2 > 0) {
                d.a(adTemplate, i2);
            }
            return i2;
        }
        return invokeLZ.intValue;
    }

    public File a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str != null) {
                com.kwad.sdk.core.d.a.a("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
                File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(str);
                if (b2 == null || !b2.exists()) {
                    return null;
                }
                return b2;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public void a() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (context = KsAdSDK.getContext()) == null) {
            return;
        }
        this.f35017c = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
        d();
    }

    @AnyThread
    public boolean a(AdResultData adResultData) {
        InterceptResult invokeL;
        PreLoadItem preLoadItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, adResultData)) == null) {
            boolean z = false;
            z = false;
            z = false;
            if (!adResultData.adTemplateList.isEmpty()) {
                AdTemplate adTemplate = adResultData.adTemplateList.get(0);
                if (!adTemplate.adInfoList.isEmpty()) {
                    AdInfo adInfo = adTemplate.adInfoList.get(0);
                    if (adInfo.adPreloadInfo != null) {
                        String D = com.kwad.sdk.core.response.b.a.D(adInfo);
                        z = b(D);
                        PreLoadPara preLoadPara = new PreLoadPara();
                        preLoadPara.isValidReturned = z ? 1 : 0;
                        if (z) {
                            synchronized (this.f35018d) {
                                preLoadItem = this.f35015a.get(D);
                            }
                            if (preLoadItem != null) {
                                preLoadPara.spreadTime = preLoadItem.cacheTime;
                            }
                        }
                        com.kwad.sdk.core.d.a.a("PreloadManager", "check checked " + z + " spreadTime " + preLoadPara.spreadTime);
                        com.kwad.sdk.core.report.a.b(adTemplate, preLoadPara.toJson());
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @AnyThread
    public boolean b(AdResultData adResultData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, adResultData)) == null) {
            if (!adResultData.adTemplateList.isEmpty()) {
                AdTemplate adTemplate = adResultData.adTemplateList.get(0);
                if (!adTemplate.adInfoList.isEmpty()) {
                    return com.kwad.sdk.core.response.b.a.G(adTemplate.adInfoList.get(0));
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public List<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.f35018d) {
                com.kwad.sdk.core.d.a.a("PreloadManager", "getPreloadIdList start ");
                for (int i2 = 0; i2 < this.f35016b.size(); i2++) {
                    String str = this.f35016b.get(i2);
                    File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(str);
                    if (b2 != null && b2.exists()) {
                        arrayList.add(str);
                    }
                }
                com.kwad.sdk.core.d.a.a("PreloadManager", "getPreloadIdList end ");
            }
            com.kwad.sdk.core.d.a.a("PreloadManager", "getPreloadIdList " + this.f35016b.size());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
