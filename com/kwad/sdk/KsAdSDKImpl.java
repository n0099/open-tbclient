package com.kwad.sdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.kwad.sdk.core.diskcache.ApkInstallCheckManager;
import com.kwad.sdk.core.diskcache.b.b;
import com.kwad.sdk.core.download.DownloadStatusManager;
import com.kwad.sdk.core.g.a.i;
import com.kwad.sdk.core.g.d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.report.g;
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
import com.kwad.sdk.plugin.f;
import com.kwad.sdk.reward.KSRewardVideoActivityProxy;
import com.kwad.sdk.utils.AppStatusHelper;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.h;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(IKsAdSDK.class)
@Keep
/* loaded from: classes6.dex */
public class KsAdSDKImpl implements IKsAdSDK {
    public static final String TAG = "KsAdSDKImpl";
    public static final Map<Class, Class> sModelImpl;
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
    public static final Map<Class, Class> sComponentProxy = new HashMap();
    public static final Map<Class, Class> sRealComponent = new HashMap();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static KsAdSDKImpl f32280a = new KsAdSDKImpl();
    }

    static {
        putComponentProxy(AdWebViewActivity.class, AdWebViewActivityProxy.class);
        putComponentProxy(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
        putComponentProxy(KsFullScreenVideoActivity.class, KsFullScreenVideoActivityProxy.class);
        putComponentProxy(KsFullScreenLandScapeVideoActivity.class, com.kwad.sdk.fullscreen.a.class);
        putComponentProxy(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
        putComponentProxy(KSRewardLandScapeVideoActivity.class, com.kwad.sdk.reward.b.class);
        putComponentProxy(BaseFragmentActivity.FragmentActivity3.class, AdWebViewVideoActivityProxy.class);
        b.a();
        putComponentProxy(DownloadService.class, com.ksad.download.c.a.class);
        putComponentProxy(FileDownloadService.SeparateProcessService.class, FileDownloadServiceProxy.SeparateProcessServiceProxy.class);
        putComponentProxy(FileDownloadService.SharedMainProcessService.class, FileDownloadServiceProxy.SharedMainProcessServiceProxy.class);
        HashMap hashMap = new HashMap();
        sModelImpl = hashMap;
        hashMap.put(KsVideoPlayConfig.class, VideoPlayConfigImpl.class);
        sModelImpl.put(KsScene.class, SceneImpl.class);
        sModelImpl.put(KsAdVideoPlayConfig.class, KSAdVideoPlayConfigImpl.class);
        sModelImpl.put(KsImage.class, com.kwad.sdk.internal.api.a.class);
        try {
            sModelImpl.put(SpeedLimitApi.class, com.kwad.sdk.core.h.a.class);
        } catch (Throwable unused) {
        }
    }

    public KsAdSDKImpl() {
        this.mIsSdkInit = false;
    }

    @KsAdSdkDynamicImpl(IKsAdSDK.class)
    @Keep
    public static KsAdSDKImpl get() {
        return a.f32280a;
    }

    public static Class<?> getProxyRealClass(Class cls) {
        return sRealComponent.get(cls);
    }

    private void initDiskCache(Context context) {
        com.kwad.sdk.core.diskcache.b.a.a().a(new b.a(context).a(1).a(ad.b(context)).a(200L).a());
    }

    private void initDownloadProxy(Context context, SdkConfig sdkConfig) {
        this.mDownloadProxy = e.a(context, this.mAdInstallProxy, sdkConfig.showNotification);
    }

    private void initHttpProxy() {
        this.mHttpProxy = e.a();
    }

    private void initImageLoader(Context context) {
        KSImageLoader.init(context);
    }

    private void initInstallProxy() {
        this.mAdInstallProxy = e.b();
    }

    private void initSdkLog() {
        try {
            com.kwad.sdk.core.d.a.a("KSAdSDK_3.3.9", this.mEnableDebug);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSpeedLimitConfig() {
        com.kwad.sdk.core.h.b.a().a(com.kwad.sdk.core.config.c.ab(), com.kwad.sdk.core.config.c.ad());
    }

    public static void putComponentProxy(Class cls, Class cls2) {
        sComponentProxy.put(cls, cls2);
        sRealComponent.put(cls2, cls);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void deleteCache() {
        com.kwad.sdk.core.diskcache.b.a.a().c();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @NonNull
    public KsLoadManager getAdManager() {
        if (this.mAdRequestManager == null) {
            this.mAdRequestManager = new com.kwad.sdk.core.g.e();
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
            String format = String.format(L.PREFIX_FORMAT, "KSAdSDK_3.3.9");
            com.kwad.sdk.core.d.a.d(format, "sdk is not init mAppId is empty:" + this.mIsSdkInit);
            return "";
        }
        return this.mAppId;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getAppInfo() {
        return com.kwad.sdk.core.g.a.b.a().toJson();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppName() {
        return this.mAppName;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Nullable
    public Context getContext() {
        if (!this.mIsSdkInit) {
            com.kwad.sdk.core.d.a.a(String.format(L.PREFIX_FORMAT, "KSAdSDK_3.3.9"), "getContext sdk is not init", new RuntimeException().fillInStackTrace());
        }
        return this.mAppContext;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getDeviceInfo() {
        return com.kwad.sdk.core.g.a.d.a().toJson();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getDid() {
        return ah.m();
    }

    public boolean getIsExternal() {
        return this.isExternale;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getNetworkInfo() {
        return i.a().toJson();
    }

    @NonNull
    public AdInstallProxy getProxyForAdInstall() {
        AdInstallProxy adInstallProxy = this.mAdInstallProxy;
        return adInstallProxy != null ? adInstallProxy : e.b();
    }

    @Nullable
    public AdLocationProxy getProxyForAdLocation() {
        return this.mLocationProxy;
    }

    @Nullable
    public AdDownloadProxy getProxyForDownload() {
        return this.mDownloadProxy;
    }

    @NonNull
    public AdHttpProxy getProxyForHttp() {
        AdHttpProxy adHttpProxy = this.mHttpProxy;
        return adHttpProxy != null ? adHttpProxy : e.a();
    }

    @Nullable
    public AdRequestExtentParamsProxy getRequestExtentParamsProxy() {
        return this.mAdRequestExtentParamsProxy;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKType() {
        return d.f35260a;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getSDKVersion() {
        return "3.3.9";
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKVersionCode() {
        return 3030900;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void init(Context context, final SdkConfig sdkConfig) {
        if (context == null || sdkConfig == null || TextUtils.isEmpty(sdkConfig.appId)) {
            return;
        }
        this.mAppContext = context.getApplicationContext();
        this.mEnableDebug = sdkConfig.enableDebug;
        this.mAppId = sdkConfig.appId;
        this.mAppName = sdkConfig.appName;
        this.mAppKey = sdkConfig.appKey;
        this.mAppWebKey = sdkConfig.appWebKey;
        ah.a(sdkConfig);
        at.a(sdkConfig);
        com.kwad.sdk.core.f.a.a(this.mAppContext);
        initSdkLog();
        initHttpProxy();
        initInstallProxy();
        initDownloadProxy(this.mAppContext, sdkConfig);
        initDiskCache(this.mAppContext);
        initImageLoader(this.mAppContext);
        Context context2 = this.mAppContext;
        if (context2 != null) {
            h.a(context2).a();
        }
        g.c().a(this.mAppContext);
        com.kwad.sdk.core.video.a.a.a.c().a(this.mAppContext);
        com.kwad.sdk.core.report.e.a();
        try {
            f.a(this.mAppContext, sdkConfig);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
        this.mIsSdkInit = true;
        if (this.mEnableDebug && !com.kwad.sdk.core.video.a.e.a()) {
            com.kwad.sdk.core.d.a.d(TAG, "必要类缺失，请检查proguard以及gson依赖");
        }
        com.kwad.sdk.core.g.d.a(this.mAppContext, new d.a() { // from class: com.kwad.sdk.KsAdSDKImpl.1

            /* renamed from: c  reason: collision with root package name */
            public AtomicBoolean f32279c = new AtomicBoolean(false);

            @Override // com.kwad.sdk.core.g.d.a
            public void a() {
                com.kwad.sdk.core.d.a.b(KsAdSDKImpl.TAG, "onCacheLoaded()");
                if (com.kwad.sdk.core.config.c.p() && !this.f32279c.get()) {
                    com.kwad.sdk.core.video.a.e.a(KsAdSDKImpl.this.mAppContext);
                    this.f32279c.set(true);
                }
                com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.b.class);
                if (bVar != null) {
                    bVar.a(KsAdSDKImpl.this.mAppContext);
                }
                com.kwad.sdk.core.a.a.a(KsAdSDKImpl.this.mAppContext, sdkConfig);
                try {
                    if (com.kwad.sdk.core.config.c.K() || com.kwad.sdk.a.f32282b.booleanValue()) {
                        DynamicInstallReceiver.registerToApp(KsAdSDKImpl.this.mAppContext);
                    }
                } catch (Throwable unused) {
                }
                KsAdSDKImpl.this.initSpeedLimitConfig();
            }

            @Override // com.kwad.sdk.core.g.d.a
            public void a(@NonNull SdkConfigData sdkConfigData) {
                com.kwad.sdk.core.d.a.b(KsAdSDKImpl.TAG, "onCacheLoaded()");
                if (com.kwad.sdk.core.config.c.p() && !this.f32279c.get()) {
                    com.kwad.sdk.core.video.a.e.a(KsAdSDKImpl.this.mAppContext);
                    this.f32279c.set(true);
                }
                com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.b.class);
                if (bVar != null) {
                    bVar.a(sdkConfigData);
                }
                KsAdSDKImpl.this.initSpeedLimitConfig();
            }
        });
        ApkInstallCheckManager.a().b();
        AppStatusHelper.a(context.getApplicationContext(), 30000L);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public boolean isDebugLogEnable() {
        return this.mEnableDebug;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        try {
            return (T) sComponentProxy.get(cls).newInstance();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T> T newInstance(Class<T> cls) {
        try {
            return (T) sModelImpl.get(cls).newInstance();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void reportBatchEvent(int i2, Map<String, Object> map) {
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
        com.kwad.sdk.core.report.e.a(i2, j);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersion(String str) {
        this.mApiVersionName = str;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersionCode(int i2) {
        this.mApiVersionCode = i2;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAppTag(String str) {
        ae.f(this.mAppContext, str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setIsExternal(boolean z) {
        this.isExternale = z;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void unInit() {
        DownloadStatusManager.a(getContext());
        Context context = this.mAppContext;
        if (context != null) {
            h.a(context).b();
        }
    }
}
