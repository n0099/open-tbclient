package com.kwad.sdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
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
/* loaded from: classes3.dex */
public class KsAdSDKImpl implements IKsAdSDK {
    public static final String TAG = "KsAdSDKImpl";
    public static boolean mEnableInstallPermission;
    public static final Map<Class, Class> sModelImpl;
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
    public static final Map<Class, Class> sComponentProxy = new HashMap();
    public static final Map<Class, Class> sRealComponent = new HashMap();

    /* loaded from: classes3.dex */
    public static class a {
        public static KsAdSDKImpl a = new KsAdSDKImpl();
    }

    static {
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
        this.mIsSdkInit = false;
        this.mApiVersionName = "";
        this.personalRecommend = true;
        this.programmaticRecommend = true;
    }

    @KsAdSdkDynamicImpl(IKsAdSDK.class)
    @Keep
    public static KsAdSDKImpl get() {
        return a.a;
    }

    public static Class<?> getProxyRealClass(Class cls) {
        return sRealComponent.get(cls);
    }

    private void initConfigRequestManager(final SdkConfig sdkConfig) {
        com.kwad.sdk.core.request.c.a(this.mAppContext, new c.a() { // from class: com.kwad.sdk.KsAdSDKImpl.2

            /* renamed from: c  reason: collision with root package name */
            public AtomicBoolean f55403c = new AtomicBoolean(false);

            @Override // com.kwad.sdk.core.request.c.a
            public void a() {
                com.kwad.sdk.core.d.a.a("cf read");
                com.kwad.sdk.core.d.a.c(KsAdSDKImpl.TAG, "onCacheLoaded()");
                if (com.kwad.sdk.core.config.b.h() && !this.f55403c.get()) {
                    com.kwad.sdk.core.video.kwai.e.a(KsAdSDKImpl.this.mAppContext);
                    this.f55403c.set(true);
                }
                com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.b.class);
                if (bVar != null) {
                    bVar.a(KsAdSDKImpl.this.mAppContext);
                }
                com.kwad.sdk.core.kwai.a.a(KsAdSDKImpl.this.mAppContext, sdkConfig);
                try {
                    boolean n = com.kwad.sdk.core.config.b.n();
                    if (n || b.f55485c.booleanValue()) {
                        com.kwad.sdk.core.d.a.c(KsAdSDKImpl.TAG, "DynamicInstallReceiver registerToApp, dyEnable:" + n);
                        DynamicInstallReceiver.registerToApp(KsAdSDKImpl.this.mAppContext);
                    }
                } catch (Throwable unused) {
                }
                KsAdSDKImpl.this.initSpeedLimitConfig();
                i.a(KsAdSDKImpl.this.mAppContext);
            }

            @Override // com.kwad.sdk.core.request.c.a
            public void a(@NonNull SdkConfigData sdkConfigData) {
                com.kwad.sdk.core.d.a.a("cf load");
                com.kwad.sdk.core.d.a.c(KsAdSDKImpl.TAG, "onConfigRefresh()");
                if (com.kwad.sdk.core.config.b.h() && !this.f55403c.get()) {
                    com.kwad.sdk.core.video.kwai.e.a(KsAdSDKImpl.this.mAppContext);
                    this.f55403c.set(true);
                }
                com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.b.class);
                if (bVar != null) {
                    bVar.a(sdkConfigData);
                }
                KsAdSDKImpl.this.initSpeedLimitConfig();
                i.a(KsAdSDKImpl.this.mAppContext);
                h.a(KsAdSDKImpl.this.mAppContext, 30000L);
                com.kwad.sdk.c.c.a().b();
            }
        });
    }

    private void initDevelopPersonalRecommend() {
        try {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_PERSONAL_RECOMMEND");
            if (a2 != null) {
                setPersonalRecommend(((Boolean) a2.getValue()).booleanValue());
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    private void initDiskCache(Context context) {
        com.kwad.sdk.core.diskcache.a.a.a().a(new b.a(context).a(1).a(aq.b(context)).a(200L).a());
    }

    private void initDownloadProxy(Context context, SdkConfig sdkConfig) {
        this.mDownloadProxy = e.a(context, this.mAdInstallProxy, sdkConfig.showNotification);
    }

    private void initHttpProxy() {
        this.mHttpProxy = e.a();
    }

    private void initHybrid(Context context) {
        com.kwad.sdk.c.c.a().a(context);
    }

    private void initHybridDownloader() {
        com.kwai.sodler.kwai.b.a(new g.a() { // from class: com.kwad.sdk.KsAdSDKImpl.1
            @Override // com.kwai.sodler.lib.kwai.g.a
            public void a(com.kwai.sodler.lib.kwai.f fVar, File file) {
                try {
                    com.kwad.sdk.core.download.d.a(fVar.q(), file, null, 0);
                } catch (IOException e2) {
                    throw new PluginError.UpdateError(e2.getMessage(), -4);
                }
            }
        });
    }

    private void initImageLoader(Context context) {
        KSImageLoader.init(context);
    }

    private void initInstallProxy() {
        this.mAdInstallProxy = e.b();
    }

    private void initKSRemoteProcess(Context context, SdkConfig sdkConfig) {
        if (context == null || sdkConfig == null || TextUtils.isEmpty(sdkConfig.appId)) {
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
        try {
            com.kwad.sdk.core.d.a.a(this.mEnableDebug);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSpeedLimitConfig() {
        com.kwad.sdk.core.h.b.a().a(com.kwad.sdk.core.config.b.z(), com.kwad.sdk.core.config.b.B());
    }

    public static void putComponentProxy(Class cls, Class cls2) {
        com.kwad.sdk.core.d.a.a(TAG, "putComponentProxy :" + cls + StringUtil.ARRAY_ELEMENT_SEPARATOR + cls2);
        sComponentProxy.put(cls, cls2);
        sRealComponent.put(cls2, cls);
    }

    private void resetEGidSP(Context context) {
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

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void addHp(@NonNull Map<String, String> map) {
        com.kwad.sdk.core.a.d.a(map);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void deleteCache() {
        com.kwad.sdk.core.diskcache.a.a.a().c();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @NonNull
    public KsLoadManager getAdManager() {
        if (this.mAdRequestManager == null) {
            this.mAdRequestManager = new com.kwad.sdk.core.request.d();
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
            com.kwad.sdk.core.d.a.e(format, "sdk is not init mAppId is empty:" + this.mIsSdkInit);
            return "";
        }
        return this.mAppId;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getAppInfo() {
        return com.kwad.sdk.core.request.model.b.a();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppName() {
        return this.mAppName;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Nullable
    public Context getContext() {
        if (!this.mIsSdkInit) {
            com.kwad.sdk.core.d.a.a(String.format(L.PREFIX_FORMAT, "KSAdSDK"), "getContext sdk is not init", new RuntimeException().fillInStackTrace());
        }
        return this.mAppContext;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getDeviceInfo() {
        return com.kwad.sdk.core.request.model.d.a().toJson();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getDid() {
        return av.u();
    }

    public boolean getIsExternal() {
        return this.isExternal;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getNetworkInfo() {
        return com.kwad.sdk.core.request.model.h.b().toJson();
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
        return "3.3.17.4";
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKVersionCode() {
        return 3031704;
    }

    @Nullable
    public SdkConfig getSdkConfig() {
        return this.mSdkConfig;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void init(Context context, SdkConfig sdkConfig) {
        if (context == null || sdkConfig == null || TextUtils.isEmpty(sdkConfig.appId)) {
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
        return this.mEnableDebug;
    }

    public boolean isEnableInstallPermission() {
        return mEnableInstallPermission;
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
        com.kwad.sdk.core.d.a.a(TAG, "componentClass :" + cls + StringUtil.ARRAY_ELEMENT_SEPARATOR + cls2);
        try {
            return (T) cls2.newInstance();
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
    public void pauseCurrentPlayer() {
        com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.b.class);
        if (bVar != null) {
            bVar.c();
        }
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
    public void reportBatchEvent(int i2, Map<String, Object> map) {
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

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void resumeCurrentPlayer() {
        com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.b.class);
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void sR(String str, Map<String, String> map, String str2) {
        com.kwad.sdk.core.a.d.a(str, map, str2);
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
        as.h(this.mAppContext, str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setIsExternal(boolean z) {
        this.isExternal = z;
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
    public void setThemeMode(int i2) {
        com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.b.class);
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void unInit() {
        DownloadStatusManager.a(getContext());
        Context context = this.mAppContext;
        if (context != null) {
            k.a(context).b();
        }
    }
}
