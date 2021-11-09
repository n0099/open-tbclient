package com.kwad.sdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.SpeedLimitApi;
import com.kwad.sdk.api.loader.DynamicInstallReceiver;
import com.kwad.sdk.api.loader.ReportAction;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.api.proxy.app.DownloadService;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.core.diskcache.b.b;
import com.kwad.sdk.core.download.DownloadStatusManager;
import com.kwad.sdk.core.g.a.i;
import com.kwad.sdk.core.g.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdInstallProxy;
import com.kwad.sdk.export.proxy.AdJumpProxy;
import com.kwad.sdk.export.proxy.AdLocationProxy;
import com.kwad.sdk.export.proxy.AdRequestExtentParamsProxy;
import com.kwad.sdk.feed.FeedDownloadActivityProxy;
import com.kwad.sdk.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.sdk.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.internal.api.VideoPlayConfigImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.f;
import com.kwad.sdk.reward.KSRewardVideoActivityProxy;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.t;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(IKsAdSDK.class)
@Keep
/* loaded from: classes2.dex */
public class KsAdSDKImpl implements IKsAdSDK {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "KsAdSDKImpl";
    public static final Map<Class, Class> sComponentProxy;
    public static final Map<Class, Class> sModelImpl;
    public static final Map<Class, Class> sRealComponent;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isExternale;
    @Nullable
    public AdInstallProxy mAdInstallProxy;
    @Nullable
    public AdJumpProxy mAdJumpProxy;
    @Nullable
    public AdRequestExtentParamsProxy mAdRequestExtentParamsProxy;
    @Nullable
    public KsLoadManager mAdRequestManager;
    public int mApiVersionCode;
    public String mApiVersionName;
    @Nullable
    public Context mAppContext;
    public String mAppId;
    public String mAppKey;
    public String mAppName;
    public String mAppWebKey;
    @Nullable
    public AdDownloadProxy mDownloadProxy;
    public boolean mEnableDebug;
    @Nullable
    public AdHttpProxy mHttpProxy;
    public volatile boolean mIsSdkInit;
    @Nullable
    public AdLocationProxy mLocationProxy;
    public volatile boolean personalRecommend;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static KsAdSDKImpl f63797a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1899559210, "Lcom/kwad/sdk/KsAdSDKImpl$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1899559210, "Lcom/kwad/sdk/KsAdSDKImpl$a;");
                    return;
                }
            }
            f63797a = new KsAdSDKImpl();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1544390329, "Lcom/kwad/sdk/KsAdSDKImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1544390329, "Lcom/kwad/sdk/KsAdSDKImpl;");
                return;
            }
        }
        sComponentProxy = new HashMap();
        sRealComponent = new HashMap();
        putComponentProxy(AdWebViewActivity.class, AdWebViewActivityProxy.class);
        putComponentProxy(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
        putComponentProxy(KsFullScreenVideoActivity.class, KsFullScreenVideoActivityProxy.class);
        putComponentProxy(KsFullScreenLandScapeVideoActivity.class, com.kwad.sdk.fullscreen.a.class);
        putComponentProxy(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
        putComponentProxy(KSRewardLandScapeVideoActivity.class, com.kwad.sdk.reward.b.class);
        putComponentProxy(BaseFragmentActivity.FragmentActivity3.class, AdWebViewVideoActivityProxy.class);
        c.a();
        putComponentProxy(DownloadService.class, com.ksad.download.c.a.class);
        putComponentProxy(FileDownloadService.SeparateProcessService.class, FileDownloadServiceProxy.SeparateProcessServiceProxy.class);
        putComponentProxy(FileDownloadService.SharedMainProcessService.class, FileDownloadServiceProxy.SharedMainProcessServiceProxy.class);
        try {
            putComponentProxy(Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote"), com.kwad.sdk.collector.c.a.class);
        } catch (Throwable unused) {
        }
        HashMap hashMap = new HashMap();
        sModelImpl = hashMap;
        hashMap.put(KsVideoPlayConfig.class, VideoPlayConfigImpl.class);
        sModelImpl.put(KsScene.class, SceneImpl.class);
        sModelImpl.put(KsAdVideoPlayConfig.class, KSAdVideoPlayConfigImpl.class);
        sModelImpl.put(KsImage.class, com.kwad.sdk.internal.api.a.class);
        try {
            sModelImpl.put(SpeedLimitApi.class, com.kwad.sdk.core.h.a.class);
        } catch (Throwable unused2) {
        }
    }

    public KsAdSDKImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsSdkInit = false;
        this.mApiVersionName = "";
        this.personalRecommend = true;
    }

    @KsAdSdkDynamicImpl(IKsAdSDK.class)
    @Keep
    public static KsAdSDKImpl get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? a.f63797a : (KsAdSDKImpl) invokeV.objValue;
    }

    public static Class<?> getProxyRealClass(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, cls)) == null) ? sRealComponent.get(cls) : (Class) invokeL.objValue;
    }

    private void initDevelopPersonalRecommend() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) f.a(DevelopMangerPlugin.class)).a("KEY_PERSONAL_RECOMMEND");
                if (a2 != null) {
                    setPersonalRecommend(((Boolean) a2.getValue()).booleanValue());
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
    }

    private void initDiskCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            com.kwad.sdk.core.diskcache.b.a.a().a(new b.a(context).a(1).a(al.b(context)).a(200L).a());
        }
    }

    private void initDownloadProxy(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, context, sdkConfig) == null) {
            this.mDownloadProxy = e.a(context, this.mAdInstallProxy, sdkConfig.showNotification);
        }
    }

    private void initHttpProxy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.mHttpProxy = e.a();
        }
    }

    private void initImageLoader(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, context) == null) {
            KSImageLoader.init(context);
        }
    }

    private void initInstallProxy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.mAdInstallProxy = e.b();
        }
    }

    private void initSdkLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            try {
                com.kwad.sdk.core.d.a.a("KSAdSDK_3.3.11.4", this.mEnableDebug);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSpeedLimitConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            com.kwad.sdk.core.h.b.a().a(com.kwad.sdk.core.config.c.z(), com.kwad.sdk.core.config.c.B());
        }
    }

    public static void putComponentProxy(Class cls, Class cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, cls, cls2) == null) {
            sComponentProxy.put(cls, cls2);
            sRealComponent.put(cls2, cls);
        }
    }

    private void resetEGidSP(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, context) == null) {
            String b2 = am.b(context);
            String e2 = ap.e();
            if (!TextUtils.isEmpty(b2)) {
                if (TextUtils.equals(b2, e2)) {
                    return;
                }
                am.d(context, "");
                am.g(context, "");
            }
            am.e(context, e2);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void deleteCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.sdk.core.diskcache.b.a.a().c();
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @NonNull
    public KsLoadManager getAdManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mAdRequestManager == null) {
                this.mAdRequestManager = new com.kwad.sdk.core.g.d();
            }
            return this.mAdRequestManager;
        }
        return (KsLoadManager) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getApiVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mApiVersionName : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getApiVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mApiVersionCode : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(this.mAppId)) {
                String format = String.format(L.PREFIX_FORMAT, "KSAdSDK_3.3.11.4");
                com.kwad.sdk.core.d.a.e(format, "sdk is not init mAppId is empty:" + this.mIsSdkInit);
                return "";
            }
            return this.mAppId;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? com.kwad.sdk.core.g.a.b.a() : (JSONObject) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mAppName : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Nullable
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.mIsSdkInit) {
                com.kwad.sdk.core.d.a.a(String.format(L.PREFIX_FORMAT, "KSAdSDK_3.3.11.4"), "getContext sdk is not init", new RuntimeException().fillInStackTrace());
            }
            return this.mAppContext;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? com.kwad.sdk.core.g.a.d.a().toJson() : (JSONObject) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getDid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? ap.n() : (String) invokeV.objValue;
    }

    public boolean getIsExternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.isExternale : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getNetworkInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? i.a().toJson() : (JSONObject) invokeV.objValue;
    }

    @NonNull
    public AdInstallProxy getProxyForAdInstall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            AdInstallProxy adInstallProxy = this.mAdInstallProxy;
            return adInstallProxy != null ? adInstallProxy : e.b();
        }
        return (AdInstallProxy) invokeV.objValue;
    }

    @Nullable
    public AdLocationProxy getProxyForAdLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mLocationProxy : (AdLocationProxy) invokeV.objValue;
    }

    @Nullable
    public AdDownloadProxy getProxyForDownload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mDownloadProxy : (AdDownloadProxy) invokeV.objValue;
    }

    @NonNull
    public AdHttpProxy getProxyForHttp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            AdHttpProxy adHttpProxy = this.mHttpProxy;
            return adHttpProxy != null ? adHttpProxy : e.a();
        }
        return (AdHttpProxy) invokeV.objValue;
    }

    @Nullable
    public AdRequestExtentParamsProxy getRequestExtentParamsProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mAdRequestExtentParamsProxy : (AdRequestExtentParamsProxy) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? d.f65520a : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? "3.3.11.4" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 3031104;
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void init(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, context, sdkConfig) == null) || context == null || sdkConfig == null || TextUtils.isEmpty(sdkConfig.appId)) {
            return;
        }
        com.kwad.sdk.core.d.a.a("SDK init appId=" + sdkConfig.appId);
        this.mAppContext = context.getApplicationContext();
        this.mEnableDebug = sdkConfig.enableDebug;
        this.mAppId = sdkConfig.appId;
        this.mAppName = sdkConfig.appName;
        this.mAppKey = sdkConfig.appKey;
        this.mAppWebKey = sdkConfig.appWebKey;
        ap.a(sdkConfig);
        ba.a(sdkConfig);
        resetEGidSP(context);
        com.kwad.sdk.core.f.a.a(this.mAppContext);
        initSdkLog();
        initHttpProxy();
        initInstallProxy();
        initDownloadProxy(this.mAppContext, sdkConfig);
        initDiskCache(this.mAppContext);
        initImageLoader(this.mAppContext);
        Context context2 = this.mAppContext;
        if (context2 != null) {
            com.kwad.sdk.utils.i.a(context2).a();
        }
        com.kwad.sdk.core.report.f.c().a(this.mAppContext);
        com.kwad.sdk.core.video.a.a.a.c().a(this.mAppContext);
        com.kwad.sdk.core.report.d.a(context);
        try {
            com.kwad.sdk.plugin.e.a(this.mAppContext, sdkConfig);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
        this.mIsSdkInit = true;
        com.kwad.sdk.core.g.c.a(this.mAppContext, new c.a(this, sdkConfig) { // from class: com.kwad.sdk.KsAdSDKImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SdkConfig f63794a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ KsAdSDKImpl f63795b;

            /* renamed from: c  reason: collision with root package name */
            public AtomicBoolean f63796c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, sdkConfig};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f63795b = this;
                this.f63794a = sdkConfig;
                this.f63796c = new AtomicBoolean(false);
            }

            @Override // com.kwad.sdk.core.g.c.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.d.a.a("cf read");
                    com.kwad.sdk.core.d.a.c(KsAdSDKImpl.TAG, "onCacheLoaded()");
                    if (com.kwad.sdk.core.config.c.k() && !this.f63796c.get()) {
                        com.kwad.sdk.core.video.a.e.a(this.f63795b.mAppContext);
                        this.f63796c.set(true);
                    }
                    com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) f.a(com.kwad.sdk.plugin.b.class);
                    if (bVar != null) {
                        bVar.a(this.f63795b.mAppContext);
                    }
                    com.kwad.sdk.core.a.a.a(this.f63795b.mAppContext, this.f63794a);
                    try {
                        if (com.kwad.sdk.core.config.c.s() || b.f63999b.booleanValue()) {
                            DynamicInstallReceiver.registerToApp(this.f63795b.mAppContext);
                        }
                    } catch (Throwable unused) {
                    }
                    this.f63795b.initSpeedLimitConfig();
                    com.kwad.sdk.collector.i.a(this.f63795b.mAppContext);
                }
            }

            @Override // com.kwad.sdk.core.g.c.a
            public void a(@NonNull SdkConfigData sdkConfigData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sdkConfigData) == null) {
                    com.kwad.sdk.core.d.a.a("cf load");
                    com.kwad.sdk.core.d.a.c(KsAdSDKImpl.TAG, "onConfigRefresh()");
                    if (com.kwad.sdk.core.config.c.k() && !this.f63796c.get()) {
                        com.kwad.sdk.core.video.a.e.a(this.f63795b.mAppContext);
                        this.f63796c.set(true);
                    }
                    com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) f.a(com.kwad.sdk.plugin.b.class);
                    if (bVar != null) {
                        bVar.a(sdkConfigData);
                    }
                    this.f63795b.initSpeedLimitConfig();
                    com.kwad.sdk.collector.i.a(this.f63795b.mAppContext);
                }
            }
        });
        com.kwad.sdk.core.diskcache.a.a(context).a();
        com.kwad.sdk.utils.f.a(context.getApplicationContext(), 30000L);
        ak.a().a(this.mAppContext);
        t.a().a(context);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public boolean isDebugLogEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mEnableDebug : invokeV.booleanValue;
    }

    public boolean isPersonalRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.personalRecommend : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, cls, obj)) == null) {
            try {
                return (T) sComponentProxy.get(cls).newInstance();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T> T newInstance(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, cls)) == null) {
            try {
                return (T) sModelImpl.get(cls).newInstance();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (T) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void pauseCurrentPlayer() {
        com.kwad.sdk.plugin.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (bVar = (com.kwad.sdk.plugin.b) f.a(com.kwad.sdk.plugin.b.class)) == null) {
            return;
        }
        bVar.d();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void reportBatchEvent(int i2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048602, this, i2, map) == null) {
            long j = 0;
            if (map != null) {
                try {
                    if (map.containsKey(ReportAction.KEY_DOWNLOAD_DURATION)) {
                        j = ((Long) map.get(ReportAction.KEY_DOWNLOAD_DURATION)).longValue();
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            com.kwad.sdk.core.report.d.a(i2, j);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void resumeCurrentPlayer() {
        com.kwad.sdk.plugin.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (bVar = (com.kwad.sdk.plugin.b) f.a(com.kwad.sdk.plugin.b.class)) == null) {
            return;
        }
        bVar.c();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.mApiVersionName = str;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersionCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.mApiVersionCode = i2;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAppTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            am.h(this.mAppContext, str);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setIsExternal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.isExternale = z;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setPersonalRecommend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.personalRecommend = z;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setThemeMode(int i2) {
        com.kwad.sdk.plugin.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048609, this, i2) == null) || (bVar = (com.kwad.sdk.plugin.b) f.a(com.kwad.sdk.plugin.b.class)) == null) {
            return;
        }
        bVar.a(i2);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void unInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            DownloadStatusManager.a(getContext());
            Context context = this.mAppContext;
            if (context != null) {
                com.kwad.sdk.utils.i.a(context).b();
            }
        }
    }
}
