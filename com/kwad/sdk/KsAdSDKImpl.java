package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.baidu.android.common.others.lang.StringUtil;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenLandScapeVideoActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardLandScapeVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.internal.api.VideoPlayConfigImpl;
import com.kwad.components.core.j.e;
import com.kwad.components.core.l.m;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.d;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsInitCallback;
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
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwad.sdk.collector.h;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.diskcache.a.b;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.OnRenderResultListener;
import com.kwad.sdk.core.report.k;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdJumpProxy;
import com.kwad.sdk.export.proxy.AdLocationProxy;
import com.kwad.sdk.export.proxy.AdRequestExtentParamsProxy;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.g;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.f;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(IKsAdSDK.class)
@Keep
/* loaded from: classes5.dex */
public class KsAdSDKImpl implements IKsAdSDK {
    public static final String INVOKER_ID_INIT = "initForInvoker";
    public static final String INVOKER_ID_INIT_COMPONENT_PROXY = "initComponentProxyForInvoker";
    public static final String INVOKER_ID_INIT_MODE_IMPL = "initModeImplForInvoker";
    public static final String TAG = "KsAdSDKImpl";
    public static boolean sHasReportAppList;
    public static final Map<Class, Class> sModelImpl;
    public boolean adxEnable;
    public boolean isExternal;
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
    public boolean mEnableDebug;
    @Nullable
    public AdHttpProxy mHttpProxy;
    public volatile boolean mIsSdkInit;
    public long mLaunchTime;
    @Nullable
    public AdLocationProxy mLocationProxy;
    public SdkConfig mSdkConfig;
    public volatile boolean personalRecommend;
    public boolean programmaticRecommend;
    public static final Map<Class, Class> sComponentProxy = new HashMap();
    public static final Map<Class, Class> sRealComponent = new HashMap();

    /* loaded from: classes5.dex */
    public static class a {
        public static KsAdSDKImpl a = new KsAdSDKImpl();
    }

    static {
        putComponentProxy(AdWebViewActivity.class, AdWebViewActivityProxy.class);
        putComponentProxy(BaseFragmentActivity.FragmentActivity3.class, AdWebViewVideoActivityProxy.class);
        try {
            putComponentProxy(BaseFragmentActivity.RequestInstallPermissionActivity.class, d.class);
            com.ksad.download.b.a = true;
        } catch (Throwable unused) {
            com.ksad.download.b.a = false;
        }
        initComponentProxyForInvoker();
        putComponentProxy(DownloadService.class, com.ksad.download.b.a.class);
        putComponentProxy(FileDownloadService.SeparateProcessService.class, FileDownloadServiceProxy.SeparateProcessServiceProxy.class);
        putComponentProxy(FileDownloadService.SharedMainProcessService.class, FileDownloadServiceProxy.SharedMainProcessServiceProxy.class);
        try {
            putComponentProxy(Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote"), com.kwad.sdk.collector.a.a.class);
        } catch (Throwable unused2) {
        }
        com.kwad.components.core.b.b();
        sModelImpl = new HashMap();
        initModeImplForInvoker();
        sModelImpl.put(KsVideoPlayConfig.class, VideoPlayConfigImpl.class);
        sModelImpl.put(KsScene.class, SceneImpl.class);
        sModelImpl.put(KsAdVideoPlayConfig.class, KSAdVideoPlayConfigImpl.class);
        sModelImpl.put(KsImage.class, com.kwad.components.core.internal.api.a.class);
        try {
            sModelImpl.put(SpeedLimitApi.class, com.kwad.components.core.k.a.class);
        } catch (Throwable unused3) {
        }
    }

    public KsAdSDKImpl() {
        this.mIsSdkInit = false;
        this.mApiVersionName = "";
        this.personalRecommend = true;
        this.programmaticRecommend = true;
        this.adxEnable = false;
    }

    @KsAdSdkDynamicImpl(IKsAdSDK.class)
    @Keep
    public static KsAdSDKImpl get() {
        return a.a;
    }

    public static Class<?> getProxyRealClass(Class<?> cls) {
        return sRealComponent.get(cls);
    }

    @ForInvoker(methodId = INVOKER_ID_INIT_COMPONENT_PROXY)
    public static void initComponentProxyForInvoker() {
        FeedDownloadActivityProxy.register();
        KsFullScreenLandScapeVideoActivityProxy.register();
        KsFullScreenVideoActivityProxy.register();
        KSRewardLandScapeVideoActivityProxy.register();
        KSRewardVideoActivityProxy.register();
        com.kwad.components.core.page.a.a();
    }

    private void initConfigRequestManager(SdkConfig sdkConfig) {
        e.a(this.mAppContext, new e.a() { // from class: com.kwad.sdk.KsAdSDKImpl.3
            public AtomicBoolean b = new AtomicBoolean(false);

            @Override // com.kwad.components.core.j.e.a
            public final void a() {
                com.kwad.sdk.core.d.b.a("cf read");
                com.kwad.sdk.core.d.b.c(KsAdSDKImpl.TAG, "onCacheLoaded()");
                com.kwad.sdk.core.config.d.e();
                if (((com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class)) != null) {
                    Context unused = KsAdSDKImpl.this.mAppContext;
                }
                try {
                    boolean i = com.kwad.sdk.core.config.d.i();
                    if (i || com.kwad.b.kwai.a.b.booleanValue()) {
                        com.kwad.sdk.core.d.b.c(KsAdSDKImpl.TAG, "DynamicInstallReceiver registerToApp, dyEnable:" + i);
                        DynamicInstallReceiver.registerToApp(KsAdSDKImpl.this.mAppContext);
                    }
                } catch (Throwable unused2) {
                }
                KsAdSDKImpl.this.initSpeedLimitConfig();
                aq.a(KsAdSDKImpl.this.mAppContext);
                if (!KsAdSDKImpl.sHasReportAppList) {
                    com.kwad.components.core.i.a.a().b(KsAdSDKImpl.this.getContext());
                    boolean unused3 = KsAdSDKImpl.sHasReportAppList = true;
                }
                if (com.kwad.sdk.core.config.d.ai()) {
                    com.kwad.sdk.a.a.a(KsAdSDKImpl.this.mAppContext);
                }
            }

            @Override // com.kwad.components.core.j.e.a
            public final void a(@NonNull SdkConfigData sdkConfigData) {
                com.kwad.sdk.core.d.b.a("cf load");
                com.kwad.sdk.core.d.b.c(KsAdSDKImpl.TAG, "onConfigRefresh()");
                com.kwad.sdk.core.config.d.e();
                com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class);
                KsAdSDKImpl.this.initSpeedLimitConfig();
                aq.a(KsAdSDKImpl.this.mAppContext);
                f.a(KsAdSDKImpl.this.mAppContext.getApplicationContext(), 30000L, new h() { // from class: com.kwad.sdk.KsAdSDKImpl.3.1
                    @Override // com.kwad.sdk.collector.h
                    public final void a(@NonNull JSONArray jSONArray) {
                        com.kwad.components.core.i.a.a().a(jSONArray);
                    }
                });
                com.kwad.sdk.core.network.idc.a.a().a(com.kwad.sdk.core.config.d.aj());
                if (com.kwad.sdk.core.config.d.al()) {
                    ax.a(com.kwad.sdk.core.config.d.ak(), com.kwad.sdk.core.config.d.am(), KsAdSDKImpl.this.mAppContext);
                }
            }
        });
    }

    private void initDevelopPersonalRecommend() {
        try {
            com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.b(th);
        }
    }

    private void initDiskCache(Context context) {
        com.kwad.sdk.core.diskcache.a.a.a().a(new b.a(context).a(1).a(ap.b(context)).a(200L).a());
        com.kwad.components.core.b.d();
    }

    private void initDownload(Context context, SdkConfig sdkConfig) {
        com.kwad.sdk.core.download.a.a(context, ap.c(context), sdkConfig.showNotification);
        com.kwad.components.core.b.e();
    }

    private void initExceptionModule(Context context, SdkConfig sdkConfig) {
        if (com.kwad.sdk.core.config.d.b(context)) {
            com.kwad.components.core.b.a.a(context, sdkConfig);
            ServiceProvider.a(com.kwad.sdk.service.kwai.c.class, new com.kwad.sdk.service.kwai.c() { // from class: com.kwad.sdk.KsAdSDKImpl.2
                @Override // com.kwad.sdk.service.kwai.c
                public final void a(Throwable th) {
                    com.kwad.components.core.b.a.a(th);
                }
            });
        }
    }

    @ForInvoker(methodId = INVOKER_ID_INIT)
    public static void initForInvoker() {
    }

    private void initHttpProxy() {
        this.mHttpProxy = com.kwad.components.core.b.a();
    }

    private void initHybrid(Context context) {
        com.kwad.components.a.a.a().a(context);
    }

    private void initImageLoader(Context context) {
        KSImageLoader.init(context, new OnRenderResultListener<AdTemplate>() { // from class: com.kwad.sdk.KsAdSDKImpl.4
            public static void a(AdTemplate adTemplate, String str, String str2) {
                com.kwad.components.core.i.a.a().a(adTemplate, str, str2);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object, java.lang.String, java.lang.String] */
            @Override // com.kwad.sdk.core.imageloader.OnRenderResultListener
            public final /* synthetic */ void onRenderResult(boolean z, AdTemplate adTemplate, String str, String str2) {
                a(adTemplate, str, str2);
            }
        }, null);
        ServiceProvider.a(g.class, ImageLoaderProxy.INSTANCE);
    }

    private void initKSRemoteProcess(Context context, SdkConfig sdkConfig) {
        if (context == null || sdkConfig == null || TextUtils.isEmpty(sdkConfig.appId)) {
            com.kwad.sdk.core.d.b.e(TAG, "KSAdSDK SDKInit:intKSRemoteProcess error,please check appID and config item");
            return;
        }
        com.kwad.sdk.core.d.b.a("SDK intKSRemoteProcess appId=" + sdkConfig.appId);
        this.mAppContext = context.getApplicationContext();
        this.mSdkConfig = sdkConfig;
        this.mEnableDebug = sdkConfig.enableDebug;
        this.mAppId = sdkConfig.appId;
        this.mAppName = sdkConfig.appName;
        this.mAppKey = sdkConfig.appKey;
        this.mAppWebKey = sdkConfig.appWebKey;
        this.mIsSdkInit = true;
        com.kwad.components.core.b.c();
        initSdkLog();
        com.kwad.components.core.b.f();
    }

    @ForInvoker(methodId = INVOKER_ID_INIT_MODE_IMPL)
    public static void initModeImplForInvoker() {
    }

    private void initOfflineComponents() {
        com.kwad.components.core.offline.init.b.a(this.mAppContext);
    }

    private void initSdkLog() {
        try {
            com.kwad.sdk.core.d.b.a(this.mEnableDebug);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSpeedLimitConfig() {
        com.kwad.components.core.k.b.a();
        com.kwad.components.core.k.b.a(com.kwad.sdk.core.config.d.m(), com.kwad.sdk.core.config.d.n());
    }

    public static void notifyInitFail(SdkConfig sdkConfig, com.kwad.sdk.a aVar) {
        if (sdkConfig != null) {
            try {
                KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    ksInitCallback.onFail(aVar.c, aVar.d);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void notifyInitSuccess(SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            try {
                KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    ksInitCallback.onSuccess();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void putComponentProxy(Class cls, Class cls2) {
        com.kwad.sdk.core.d.b.a(TAG, "putComponentProxy :" + cls + StringUtil.ARRAY_ELEMENT_SEPARATOR + cls2);
        sComponentProxy.put(cls, cls2);
        sRealComponent.put(cls2, cls);
    }

    public static void putModeImpl(Class cls, Class cls2) {
        sModelImpl.put(cls, cls2);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void addHp(@NonNull Map<String, String> map) {
        com.kwad.sdk.core.a.d.a(map);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Object dM(String str, Object... objArr) {
        if ("autoRT".equals(str)) {
            return 10000;
        }
        if ("TRANSFORM_API_HOST".equals(str)) {
            return com.kwad.sdk.core.network.idc.a.a().b(objArr[0].toString(), "api");
        }
        return null;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void deleteCache() {
        com.kwad.sdk.core.diskcache.a.a.a().b();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @NonNull
    public KsLoadManager getAdManager() {
        if (this.mAdRequestManager == null) {
            this.mAdRequestManager = new com.kwad.components.core.c();
        }
        return this.mAdRequestManager;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getApiVersion() {
        return this.mApiVersionName;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppId() {
        if (TextUtils.isEmpty(this.mAppId)) {
            String format = String.format(L.PREFIX_FORMAT, "KSAdSDK");
            com.kwad.sdk.core.d.b.e(format, "sdk is not init mAppId is empty:" + this.mIsSdkInit);
            return "";
        }
        return this.mAppId;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getAppInfo() {
        return com.kwad.sdk.core.request.model.a.a();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppName() {
        return this.mAppName;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Nullable
    public Context getContext() {
        if (this.mAppContext == null) {
            String format = String.format(L.PREFIX_FORMAT, "KSAdSDK");
            com.kwad.sdk.core.d.b.a(format, "getContext is null, mIsSdkInit: " + this.mIsSdkInit, new RuntimeException().fillInStackTrace());
        }
        return this.mAppContext;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getDeviceInfo() {
        return com.kwad.sdk.core.request.model.b.a().toJson();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getDid() {
        return ao.e();
    }

    public boolean getIsExternal() {
        return this.isExternal;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getNetworkInfo() {
        return com.kwad.sdk.core.request.model.d.b().toJson();
    }

    @Nullable
    public AdLocationProxy getProxyForAdLocation() {
        return this.mLocationProxy;
    }

    @NonNull
    public AdHttpProxy getProxyForHttp() {
        AdHttpProxy adHttpProxy = this.mHttpProxy;
        return adHttpProxy != null ? adHttpProxy : com.kwad.components.core.b.a();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRD(String str) {
        return com.kwad.sdk.core.a.d.b(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRM(String str) {
        return com.kwad.sdk.core.a.d.a(str);
    }

    @Nullable
    public AdRequestExtentParamsProxy getRequestExtentParamsProxy() {
        return this.mAdRequestExtentParamsProxy;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKType() {
        return 1;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    @Nullable
    public SdkConfig getSdkConfig() {
        return this.mSdkConfig;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public synchronized void init(Context context, SdkConfig sdkConfig) {
        if (context != null && sdkConfig != null) {
            try {
                if (!TextUtils.isEmpty(sdkConfig.appId)) {
                    String a2 = ak.a(context);
                    if (!TextUtils.isEmpty(a2) && a2.endsWith("kssdk_remote")) {
                        initKSRemoteProcess(context, sdkConfig);
                        return;
                    }
                    com.kwad.sdk.core.d.b.a("SDK init appId=" + sdkConfig.appId);
                    this.mAppContext = context.getApplicationContext();
                    this.mSdkConfig = sdkConfig;
                    this.mEnableDebug = sdkConfig.enableDebug;
                    this.mAppId = sdkConfig.appId;
                    this.mAppName = sdkConfig.appName;
                    this.mAppKey = sdkConfig.appKey;
                    this.mAppWebKey = sdkConfig.appWebKey;
                    this.mIsSdkInit = true;
                    com.kwad.components.core.b.c();
                    k.a(com.kwad.sdk.core.config.d.c(this.mAppContext), new k.a() { // from class: com.kwad.sdk.KsAdSDKImpl.1
                        @Override // com.kwad.sdk.core.report.k.a
                        public final void a(String str, String str2, boolean z) {
                            com.kwad.components.core.i.a.a().a(str, str2, z);
                        }
                    });
                    c.a(this.mAppContext, this.mLaunchTime);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        com.kwad.sdk.components.b.a(this.mAppContext, sdkConfig);
                    } catch (Exception e) {
                        c.a(this.mAppContext, com.kwai.adclient.kscommerciallogger.model.a.q, Log.getStackTraceString(e));
                        com.kwad.sdk.core.d.b.a(e);
                    }
                    be.a(sdkConfig);
                    com.kwad.sdk.core.e.a.a(this.mAppContext);
                    initSdkLog();
                    com.kwad.sdk.core.lifecycle.a.c().a(context);
                    initHttpProxy();
                    com.kwad.sdk.core.network.idc.a.a().a(this.mAppContext);
                    initDownload(this.mAppContext, sdkConfig);
                    initDiskCache(this.mAppContext);
                    initImageLoader(this.mAppContext);
                    ao.a(this.mAppContext);
                    com.kwad.components.core.l.g.a(this.mAppContext).a();
                    com.kwad.sdk.core.video.kwai.kwai.a.d().a(this.mAppContext, 0);
                    com.kwad.components.core.b.a(this.mAppContext);
                    initConfigRequestManager(sdkConfig);
                    initExceptionModule(this.mAppContext, sdkConfig);
                    com.kwad.components.core.i.a.a().a(this.mAppContext);
                    com.kwad.sdk.components.c.a(this.mAppContext, sdkConfig);
                    initOfflineComponents();
                    com.kwad.components.core.b.f();
                    initHybrid(context);
                    com.kwad.sdk.core.diskcache.a.a(context).a();
                    m.a().a(this.mAppContext);
                    com.kwad.components.core.e.a.a().a(this.mAppContext);
                    notifyInitSuccess(sdkConfig);
                    c.b(this.mAppContext, SystemClock.elapsedRealtime() - elapsedRealtime);
                    return;
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.a(TAG, "KSAdSDK SDKInit:init error", th);
                String stackTraceString = Log.getStackTraceString(th);
                c.a(this.mAppContext, com.kwai.adclient.kscommerciallogger.model.a.q, stackTraceString);
                notifyInitFail(sdkConfig, new com.kwad.sdk.a(10002, stackTraceString));
                return;
            }
        }
        com.kwad.sdk.core.d.b.e(TAG, "KSAdSDK SDKInit:init error,please check appID and config item");
        notifyInitFail(sdkConfig, com.kwad.sdk.a.b);
    }

    public boolean isAdxEnable() {
        return this.adxEnable;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public boolean isDebugLogEnable() {
        return this.mEnableDebug;
    }

    public boolean isPersonalRecommend() {
        return this.personalRecommend;
    }

    public boolean isProgrammaticRecommend() {
        return this.programmaticRecommend;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        Class cls2 = sComponentProxy.get(cls);
        com.kwad.sdk.core.d.b.a(TAG, "componentClass :" + cls + StringUtil.ARRAY_ELEMENT_SEPARATOR + cls2);
        try {
            return (T) cls2.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T> T newInstance(Class<T> cls) {
        try {
            return (T) sModelImpl.get(cls).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void pauseCurrentPlayer() {
        com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void re(Object obj) {
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            if (this.mEnableDebug) {
                th.printStackTrace();
            }
            com.kwad.sdk.crash.a.a(th);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void reportBatchEvent(int i, Map<String, Object> map) {
        long j = 0;
        if (map != null) {
            try {
                if (map.containsKey(ReportAction.KEY_DOWNLOAD_DURATION)) {
                    j = ((Long) map.get(ReportAction.KEY_DOWNLOAD_DURATION)).longValue();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.a(e);
            }
        }
        com.kwad.components.core.i.a.a().a(i, j);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void resumeCurrentPlayer() {
        com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void sR(String str, Map<String, String> map, String str2) {
        com.kwad.sdk.core.a.d.a(str, map, str2);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAdxEnable(boolean z) {
        this.adxEnable = z;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersion(String str) {
        this.mApiVersionName = str;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersionCode(int i) {
        this.mApiVersionCode = i;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAppTag(String str) {
        as.k(this.mAppContext, str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setIsExternal(boolean z) {
        this.isExternal = z;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLaunchTime(long j) {
        this.mLaunchTime = j;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimation(boolean z, @RawRes int i) {
        com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimationColor(boolean z, @ColorInt int i) {
        com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setPersonalRecommend(boolean z) {
        this.personalRecommend = z;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setProgrammaticRecommend(boolean z) {
        this.programmaticRecommend = z;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setThemeMode(int i) {
        com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void unInit() {
        com.kwad.sdk.core.download.e.a().b(this.mAppContext);
        Context context = this.mAppContext;
        if (context != null) {
            com.kwad.components.core.l.g.a(context).b();
        }
    }
}
