package com.kwad.sdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.kuaishou.weapon.i.WeaponHI;
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
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.api.proxy.app.DownloadService;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.collector.i;
import com.kwad.sdk.core.diskcache.a.b;
import com.kwad.sdk.core.download.DownloadStatusManager;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.request.c;
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
import com.kwad.sdk.reward.KSRewardVideoActivityProxy;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.x;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.kwai.g;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import java.io.IOException;
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
    public static boolean mEnableInstallPermission;
    public static final Map<Class, Class> sComponentProxy;
    public static final Map<Class, Class> sModelImpl;
    public static final Map<Class, Class> sRealComponent;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isExternal;
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
    public SdkConfig mSdkConfig;
    public volatile boolean personalRecommend;
    public boolean programmaticRecommend;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static KsAdSDKImpl a;
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
            a = new KsAdSDKImpl();
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
        putComponentProxy(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
        putComponentProxy(KSRewardLandScapeVideoActivity.class, com.kwad.sdk.reward.e.class);
        putComponentProxy(BaseFragmentActivity.FragmentActivity3.class, AdWebViewVideoActivityProxy.class);
        try {
            putComponentProxy(BaseFragmentActivity.RequestInstallPermissionActivity.class, com.kwad.sdk.core.page.d.class);
            mEnableInstallPermission = true;
        } catch (Throwable unused) {
            mEnableInstallPermission = false;
        }
        c.a();
        putComponentProxy(DownloadService.class, com.ksad.download.b.a.class);
        putComponentProxy(FileDownloadService.SeparateProcessService.class, FileDownloadServiceProxy.SeparateProcessServiceProxy.class);
        putComponentProxy(FileDownloadService.SharedMainProcessService.class, FileDownloadServiceProxy.SharedMainProcessServiceProxy.class);
        try {
            putComponentProxy(Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote"), com.kwad.sdk.collector.b.a.class);
        } catch (Throwable unused2) {
        }
        f.a();
        HashMap hashMap = new HashMap();
        sModelImpl = hashMap;
        hashMap.put(KsVideoPlayConfig.class, VideoPlayConfigImpl.class);
        sModelImpl.put(KsScene.class, SceneImpl.class);
        sModelImpl.put(KsAdVideoPlayConfig.class, KSAdVideoPlayConfigImpl.class);
        sModelImpl.put(KsImage.class, com.kwad.sdk.internal.api.b.class);
        try {
            sModelImpl.put(SpeedLimitApi.class, com.kwad.sdk.core.h.a.class);
        } catch (Throwable unused3) {
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
        this.programmaticRecommend = true;
    }

    @KsAdSdkDynamicImpl(IKsAdSDK.class)
    @Keep
    public static KsAdSDKImpl get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a.a : (KsAdSDKImpl) invokeV.objValue;
    }

    public static Class<?> getProxyRealClass(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, cls)) == null) ? sRealComponent.get(cls) : (Class) invokeL.objValue;
    }

    private void initConfigRequestManager(SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, sdkConfig) == null) {
            com.kwad.sdk.core.request.c.a(this.mAppContext, new c.a(this, sdkConfig) { // from class: com.kwad.sdk.KsAdSDKImpl.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SdkConfig a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ KsAdSDKImpl f56960b;

                /* renamed from: c  reason: collision with root package name */
                public AtomicBoolean f56961c;

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
                    this.f56960b = this;
                    this.a = sdkConfig;
                    this.f56961c = new AtomicBoolean(false);
                }

                @Override // com.kwad.sdk.core.request.c.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.d.a.a("cf read");
                        com.kwad.sdk.core.d.a.c(KsAdSDKImpl.TAG, "onCacheLoaded()");
                        if (com.kwad.sdk.core.config.b.h() && !this.f56961c.get()) {
                            com.kwad.sdk.core.video.kwai.e.a(this.f56960b.mAppContext);
                            this.f56961c.set(true);
                        }
                        com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.b.class);
                        if (bVar != null) {
                            bVar.a(this.f56960b.mAppContext);
                        }
                        com.kwad.sdk.core.kwai.a.a(this.f56960b.mAppContext, this.a);
                        try {
                            boolean n = com.kwad.sdk.core.config.b.n();
                            if (n || b.f57044c.booleanValue()) {
                                com.kwad.sdk.core.d.a.c(KsAdSDKImpl.TAG, "DynamicInstallReceiver registerToApp, dyEnable:" + n);
                                DynamicInstallReceiver.registerToApp(this.f56960b.mAppContext);
                            }
                        } catch (Throwable unused) {
                        }
                        this.f56960b.initSpeedLimitConfig();
                        i.a(this.f56960b.mAppContext);
                    }
                }

                @Override // com.kwad.sdk.core.request.c.a
                public void a(@NonNull SdkConfigData sdkConfigData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sdkConfigData) == null) {
                        com.kwad.sdk.core.d.a.a("cf load");
                        com.kwad.sdk.core.d.a.c(KsAdSDKImpl.TAG, "onConfigRefresh()");
                        if (com.kwad.sdk.core.config.b.h() && !this.f56961c.get()) {
                            com.kwad.sdk.core.video.kwai.e.a(this.f56960b.mAppContext);
                            this.f56961c.set(true);
                        }
                        com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.b.class);
                        if (bVar != null) {
                            bVar.a(sdkConfigData);
                        }
                        this.f56960b.initSpeedLimitConfig();
                        i.a(this.f56960b.mAppContext);
                        h.a(this.f56960b.mAppContext, 30000L);
                        com.kwad.sdk.c.c.a().b();
                    }
                }
            });
        }
    }

    private void initDevelopPersonalRecommend() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            try {
                DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_PERSONAL_RECOMMEND");
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
        if (interceptable == null || interceptable.invokeL(65545, this, context) == null) {
            com.kwad.sdk.core.diskcache.a.a.a().a(new b.a(context).a(1).a(aq.b(context)).a(200L).a());
        }
    }

    private void initDownloadProxy(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, context, sdkConfig) == null) {
            this.mDownloadProxy = e.a(context, this.mAdInstallProxy, sdkConfig.showNotification);
        }
    }

    private void initHttpProxy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.mHttpProxy = e.a();
        }
    }

    private void initHybrid(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, context) == null) {
            com.kwad.sdk.c.c.a().a(context);
        }
    }

    private void initHybridDownloader() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            com.kwai.sodler.kwai.b.a(new g.a(this) { // from class: com.kwad.sdk.KsAdSDKImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsAdSDKImpl a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwai.sodler.lib.kwai.g.a
                public void a(com.kwai.sodler.lib.kwai.f fVar, File file) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, fVar, file) == null) {
                        try {
                            com.kwad.sdk.core.download.d.a(fVar.q(), file, null, 0);
                        } catch (IOException e2) {
                            throw new PluginError.UpdateError(e2.getMessage(), -4);
                        }
                    }
                }
            });
        }
    }

    private void initImageLoader(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, context) == null) {
            KSImageLoader.init(context);
        }
    }

    private void initInstallProxy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.mAdInstallProxy = e.b();
        }
    }

    private void initKSRemoteProcess(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, this, context, sdkConfig) == null) || context == null || sdkConfig == null || TextUtils.isEmpty(sdkConfig.appId)) {
            return;
        }
        com.kwad.sdk.core.d.a.a("SDK intKSRemoteProcess appId=" + sdkConfig.appId);
        this.mAppContext = context.getApplicationContext();
        this.mSdkConfig = sdkConfig;
        this.mEnableDebug = sdkConfig.enableDebug;
        this.mAppId = sdkConfig.appId;
        this.mAppName = sdkConfig.appName;
        this.mAppKey = sdkConfig.appKey;
        this.mAppWebKey = sdkConfig.appWebKey;
        initSdkLog();
        this.mIsSdkInit = true;
    }

    private void initSdkLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            try {
                com.kwad.sdk.core.d.a.a(this.mEnableDebug);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSpeedLimitConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            com.kwad.sdk.core.h.b.a().a(com.kwad.sdk.core.config.b.z(), com.kwad.sdk.core.config.b.B());
        }
    }

    public static void putComponentProxy(Class cls, Class cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, cls, cls2) == null) {
            com.kwad.sdk.core.d.a.a(TAG, "putComponentProxy :" + cls + StringUtil.ARRAY_ELEMENT_SEPARATOR + cls2);
            sComponentProxy.put(cls, cls2);
            sRealComponent.put(cls2, cls);
        }
    }

    private void resetEGidSP(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, context) == null) {
            String b2 = as.b(context);
            String e2 = av.e();
            if (!TextUtils.isEmpty(b2)) {
                if (TextUtils.equals(b2, e2)) {
                    return;
                }
                as.d(context, "");
                as.g(context, "");
            }
            as.e(context, e2);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void addHp(@NonNull Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            com.kwad.sdk.core.a.d.a(map);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void deleteCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.kwad.sdk.core.diskcache.a.a.a().c();
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @NonNull
    public KsLoadManager getAdManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mAdRequestManager == null) {
                this.mAdRequestManager = new com.kwad.sdk.core.request.d();
            }
            return this.mAdRequestManager;
        }
        return (KsLoadManager) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getApiVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mApiVersionName : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getApiVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mApiVersionCode : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(this.mAppId)) {
                String format = String.format(L.PREFIX_FORMAT, "KSAdSDK");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? com.kwad.sdk.core.request.model.b.a() : (JSONObject) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mAppName : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Nullable
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!this.mIsSdkInit) {
                com.kwad.sdk.core.d.a.a(String.format(L.PREFIX_FORMAT, "KSAdSDK"), "getContext sdk is not init", new RuntimeException().fillInStackTrace());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? com.kwad.sdk.core.request.model.d.a().toJson() : (JSONObject) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getDid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? av.u() : (String) invokeV.objValue;
    }

    public boolean getIsExternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.isExternal : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getNetworkInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? com.kwad.sdk.core.request.model.h.b().toJson() : (JSONObject) invokeV.objValue;
    }

    @NonNull
    public AdInstallProxy getProxyForAdInstall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            AdInstallProxy adInstallProxy = this.mAdInstallProxy;
            return adInstallProxy != null ? adInstallProxy : e.b();
        }
        return (AdInstallProxy) invokeV.objValue;
    }

    @Nullable
    public AdLocationProxy getProxyForAdLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mLocationProxy : (AdLocationProxy) invokeV.objValue;
    }

    @Nullable
    public AdDownloadProxy getProxyForDownload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mDownloadProxy : (AdDownloadProxy) invokeV.objValue;
    }

    @NonNull
    public AdHttpProxy getProxyForHttp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            AdHttpProxy adHttpProxy = this.mHttpProxy;
            return adHttpProxy != null ? adHttpProxy : e.a();
        }
        return (AdHttpProxy) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRD(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? com.kwad.sdk.core.a.d.b(str) : (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRM(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? com.kwad.sdk.core.a.d.a(str) : (String) invokeL.objValue;
    }

    @Nullable
    public AdRequestExtentParamsProxy getRequestExtentParamsProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mAdRequestExtentParamsProxy : (AdRequestExtentParamsProxy) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? "3.3.17.4" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return 3031704;
        }
        return invokeV.intValue;
    }

    @Nullable
    public SdkConfig getSdkConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mSdkConfig : (SdkConfig) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void init(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048600, this, context, sdkConfig) == null) || context == null || sdkConfig == null || TextUtils.isEmpty(sdkConfig.appId)) {
            return;
        }
        String a2 = al.a(context);
        if (!TextUtils.isEmpty(a2) && a2.endsWith("kssdk_remote")) {
            initKSRemoteProcess(context, sdkConfig);
            return;
        }
        com.kwad.sdk.core.d.a.a("SDK init appId=" + sdkConfig.appId);
        this.mAppContext = context.getApplicationContext();
        this.mSdkConfig = sdkConfig;
        this.mEnableDebug = sdkConfig.enableDebug;
        this.mAppId = sdkConfig.appId;
        this.mAppName = sdkConfig.appName;
        this.mAppKey = sdkConfig.appKey;
        this.mAppWebKey = sdkConfig.appWebKey;
        this.mIsSdkInit = true;
        av.a(sdkConfig);
        bg.a(sdkConfig);
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
            k.a(context2).a();
        }
        com.kwad.sdk.core.report.f.c().a(this.mAppContext);
        com.kwad.sdk.core.video.kwai.kwai.a.c().a(this.mAppContext);
        com.kwad.sdk.core.report.d.a(context);
        com.kwad.sdk.core.report.i.a();
        try {
            com.kwad.sdk.plugin.e.a(this.mAppContext, sdkConfig);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
        if (b.a.booleanValue()) {
            com.kwad.sdk.core.d.a.c(TAG, "WeaponHI:init");
            WeaponHI.init(Wrapper.unwrapContextIfNeed(context).getApplicationContext(), new com.kwad.sdk.kwai.a(), null);
        }
        f.b();
        initHybridDownloader();
        initHybrid(context);
        initConfigRequestManager(sdkConfig);
        com.kwad.sdk.core.diskcache.a.a(context).a();
        ap.a().a(this.mAppContext);
        x.a().a(context);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public boolean isDebugLogEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mEnableDebug : invokeV.booleanValue;
    }

    public boolean isEnableInstallPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? mEnableInstallPermission : invokeV.booleanValue;
    }

    public boolean isPersonalRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.personalRecommend : invokeV.booleanValue;
    }

    public boolean isProgrammaticRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.programmaticRecommend : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, cls, obj)) == null) {
            Class cls2 = sComponentProxy.get(cls);
            com.kwad.sdk.core.d.a.a(TAG, "componentClass :" + cls + StringUtil.ARRAY_ELEMENT_SEPARATOR + cls2);
            try {
                return (T) cls2.newInstance();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, cls)) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.b.class)) == null) {
            return;
        }
        bVar.c();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void re(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, obj) == null) && (obj instanceof Throwable)) {
            Throwable th = (Throwable) obj;
            if (this.mEnableDebug) {
                th.printStackTrace();
            }
            com.kwad.sdk.crash.a.a(th);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void reportBatchEvent(int i2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048609, this, i2, map) == null) {
            long j2 = 0;
            if (map != null) {
                try {
                    if (map.containsKey(ReportAction.KEY_DOWNLOAD_DURATION)) {
                        j2 = ((Long) map.get(ReportAction.KEY_DOWNLOAD_DURATION)).longValue();
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            com.kwad.sdk.core.report.d.a(i2, j2);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void resumeCurrentPlayer() {
        com.kwad.sdk.plugin.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.b.class)) == null) {
            return;
        }
        bVar.b();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void sR(String str, Map<String, String> map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048611, this, str, map, str2) == null) {
            com.kwad.sdk.core.a.d.a(str, map, str2);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.mApiVersionName = str;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersionCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.mApiVersionCode = i2;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAppTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            as.h(this.mAppContext, str);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setIsExternal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.isExternal = z;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setPersonalRecommend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.personalRecommend = z;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setProgrammaticRecommend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.programmaticRecommend = z;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setThemeMode(int i2) {
        com.kwad.sdk.plugin.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048618, this, i2) == null) || (bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.b.class)) == null) {
            return;
        }
        bVar.a(i2);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void unInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            DownloadStatusManager.a(getContext());
            Context context = this.mAppContext;
            if (context != null) {
                k.a(context).b();
            }
        }
    }
}
