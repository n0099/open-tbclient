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
import com.kwad.components.core.k.e;
import com.kwad.components.core.m.m;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
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
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.api.proxy.app.DownloadService;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwad.sdk.collector.h;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.diskcache.a.b;
import com.kwad.sdk.core.download.a;
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
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.f;
import com.kwad.sdk.utils.w;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
import com.kwai.sodler.lib.a.g;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.c;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(IKsAdSDK.class)
@Keep
/* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public static class a {
        public static KsAdSDKImpl QU = new KsAdSDKImpl();
    }

    static {
        putComponentProxy(AdWebViewActivity.class, AdWebViewActivityProxy.class);
        putComponentProxy(BaseFragmentActivity.FragmentActivity3.class, AdWebViewVideoActivityProxy.class);
        try {
            putComponentProxy(BaseFragmentActivity.RequestInstallPermissionActivity.class, com.kwad.components.core.page.d.class);
            com.ksad.download.b.aa = true;
        } catch (Throwable unused) {
            com.ksad.download.b.aa = false;
        }
        initComponentProxyForInvoker();
        putComponentProxy(DownloadService.class, com.ksad.download.b.a.class);
        putComponentProxy(FileDownloadService.SeparateProcessService.class, FileDownloadServiceProxy.SeparateProcessServiceProxy.class);
        putComponentProxy(FileDownloadService.SharedMainProcessService.class, FileDownloadServiceProxy.SharedMainProcessServiceProxy.class);
        try {
            putComponentProxy(Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote"), com.kwad.sdk.collector.a.a.class);
        } catch (Throwable unused2) {
        }
        com.kwad.components.core.b.lg();
        sModelImpl = new HashMap();
        initModeImplForInvoker();
        sModelImpl.put(KsVideoPlayConfig.class, VideoPlayConfigImpl.class);
        sModelImpl.put(KsScene.class, SceneImpl.class);
        sModelImpl.put(KsAdVideoPlayConfig.class, KSAdVideoPlayConfigImpl.class);
        sModelImpl.put(KsImage.class, com.kwad.components.core.internal.api.b.class);
        try {
            sModelImpl.put(SpeedLimitApi.class, com.kwad.components.core.l.a.class);
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
        return a.QU;
    }

    public static Class<?> getProxyRealClass(Class<?> cls) {
        return sRealComponent.get(cls);
    }

    private void initApkClean(Context context) {
        try {
            com.kwad.sdk.core.diskcache.a.bn(context).sI();
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initCommercialLogger(final Context context) {
        try {
            k.a(com.kwad.sdk.core.config.d.aY(context), new k.a() { // from class: com.kwad.sdk.KsAdSDKImpl.1
                @Override // com.kwad.sdk.core.report.k.a
                public final void f(String str, String str2, boolean z) {
                    if (com.kwad.sdk.core.config.d.aZ(context)) {
                        com.kwad.components.core.j.a.og().e(str, str2, z);
                    }
                }
            });
        } catch (Throwable th) {
            e.f(th);
        }
    }

    @ForInvoker(methodId = INVOKER_ID_INIT_COMPONENT_PROXY)
    public static void initComponentProxyForInvoker() {
        FeedDownloadActivityProxy.register();
        KsFullScreenLandScapeVideoActivityProxy.register();
        KsFullScreenVideoActivityProxy.register();
        KSRewardLandScapeVideoActivityProxy.register();
        KSRewardVideoActivityProxy.register();
        com.kwad.components.core.page.a.register();
    }

    private void initComponents(Context context, SdkConfig sdkConfig) {
        try {
            com.kwad.sdk.components.b.init(context, sdkConfig);
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initComponentsManager(Context context, SdkConfig sdkConfig) {
        try {
            com.kwad.sdk.components.c.init(context, sdkConfig);
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initConfigRequestManager() {
        try {
            com.kwad.components.core.k.e.a(this.mAppContext, new e.a() { // from class: com.kwad.sdk.KsAdSDKImpl.3
                @Override // com.kwad.components.core.k.e.a
                public final void a(@NonNull SdkConfigData sdkConfigData) {
                    com.kwad.sdk.core.e.b.i(KsAdSDKImpl.TAG, "onConfigRefresh()");
                    try {
                        KsAdSDKImpl.this.initOnConfigRefresh(sdkConfigData);
                    } catch (Throwable th) {
                        com.kwad.components.core.b.a.b(th);
                    }
                }

                @Override // com.kwad.components.core.k.e.a
                public final void no() {
                    com.kwad.sdk.core.e.b.C(KsAdSDKImpl.TAG, "onCacheLoaded()");
                    if (((com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class)) != null) {
                        Context unused = KsAdSDKImpl.this.mAppContext;
                    }
                }
            });
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initDevelopPersonalRecommend() {
        try {
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
    }

    private void initDiskCache(Context context) {
        try {
            com.kwad.sdk.core.diskcache.a.a.sS().a(new b.a(context).ay(1).m(as.cY(context)).w(200L).sU());
            com.kwad.components.core.b.li();
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initDownload(Context context, SdkConfig sdkConfig) {
        try {
            com.kwad.sdk.core.download.a.a(context, as.cZ(context), sdkConfig.showNotification);
            com.kwad.components.core.b.lj();
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initExceptionModule(Context context, SdkConfig sdkConfig) {
        try {
            if (com.kwad.sdk.core.config.d.aW(context)) {
                com.kwad.components.core.b.a.init(context, sdkConfig);
                ServiceProvider.put(com.kwad.sdk.service.kwai.c.class, new com.kwad.sdk.service.kwai.c() { // from class: com.kwad.sdk.KsAdSDKImpl.2
                    @Override // com.kwad.sdk.service.kwai.c
                    public final void gatherException(Throwable th) {
                        com.kwad.components.core.b.a.b(th);
                    }
                });
            }
        } catch (Throwable th) {
            e.f(th);
        }
    }

    @ForInvoker(methodId = INVOKER_ID_INIT)
    public static void initForInvoker() {
    }

    private void initHttpProxy() {
        try {
            this.mHttpProxy = com.kwad.components.core.b.le();
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initHybrid(Context context) {
        try {
            com.kwad.components.a.a.qo().init(context);
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initIDC(Context context) {
        try {
            com.kwad.sdk.core.network.idc.a.tH().init(context);
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initImageLoader(Context context) {
        try {
            KSImageLoader.init(context, new OnRenderResultListener<AdTemplate>() { // from class: com.kwad.sdk.KsAdSDKImpl.5
                public static void a(boolean z, AdTemplate adTemplate, String str, String str2) {
                    com.kwad.components.core.j.a.og().a(adTemplate, str, str2);
                    if (z) {
                        return;
                    }
                    com.kwad.components.core.j.a.og().e(adTemplate, 21007);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object, java.lang.String, java.lang.String] */
                @Override // com.kwad.sdk.core.imageloader.OnRenderResultListener
                public final /* synthetic */ void onRenderResult(boolean z, AdTemplate adTemplate, String str, String str2) {
                    a(z, adTemplate, str, str2);
                }
            }, com.kwad.sdk.core.threads.b.vi());
            ServiceProvider.put(g.class, ImageLoaderProxy.INSTANCE);
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initInstalledReceiver(Context context) {
        try {
            com.kwad.components.core.m.g.av(context).oC();
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initKSRemoteProcess(Context context, SdkConfig sdkConfig) {
        if (context == null || sdkConfig == null || TextUtils.isEmpty(sdkConfig.appId)) {
            com.kwad.sdk.core.e.b.e(TAG, "KSAdSDK SDKInit:intKSRemoteProcess error,please check appID and config item");
            return;
        }
        com.kwad.sdk.core.e.b.bT("SDK intKSRemoteProcess appId=" + sdkConfig.appId);
        this.mAppContext = context.getApplicationContext();
        this.mSdkConfig = sdkConfig;
        this.mEnableDebug = sdkConfig.enableDebug;
        this.mAppId = sdkConfig.appId;
        this.mAppName = sdkConfig.appName;
        this.mAppKey = sdkConfig.appKey;
        this.mAppWebKey = sdkConfig.appWebKey;
        this.mIsSdkInit = true;
        com.kwad.components.core.b.lh();
        initSdkLog();
        com.kwad.components.core.b.lk();
    }

    private void initLifecycleHolder(Context context) {
        try {
            com.kwad.sdk.core.c.b.tp().init(context);
        } catch (Throwable th) {
            e.f(th);
        }
    }

    @ForInvoker(methodId = INVOKER_ID_INIT_MODE_IMPL)
    public static void initModeImplForInvoker() {
    }

    private void initOAID(Context context) {
        try {
            com.kwad.sdk.core.f.a.bv(context);
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initOfflineComponents() {
        try {
            com.kwad.components.core.offline.init.b.init(this.mAppContext);
        } catch (Throwable th) {
            e.f(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initOnConfigRefresh(SdkConfigData sdkConfigData) {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
        com.kwad.sdk.core.config.d.lt();
        if (com.kwad.sdk.core.config.d.rJ() || com.kwad.b.kwai.a.aw.booleanValue()) {
            DynamicInstallReceiver.registerToApp(this.mAppContext);
        }
        if (!sHasReportAppList) {
            com.kwad.components.core.j.a.og().aq(getContext());
            sHasReportAppList = true;
        }
        if (com.kwad.sdk.core.config.d.sp()) {
            com.kwad.sdk.a.a.init(this.mAppContext);
        }
        initSpeedLimitConfig();
        at.init(this.mAppContext);
        f.a(this.mAppContext, 30000L, new h() { // from class: com.kwad.sdk.KsAdSDKImpl.4
            @Override // com.kwad.sdk.collector.h
            public final void c(@NonNull JSONArray jSONArray) {
                com.kwad.components.core.j.a.og().c(jSONArray);
            }
        });
        com.kwad.sdk.core.network.idc.a.tH().a(com.kwad.sdk.core.config.d.sq());
        if (com.kwad.sdk.core.config.d.ss()) {
            bb.a(com.kwad.sdk.core.config.d.sr(), com.kwad.sdk.core.config.d.st(), this.mAppContext);
        }
    }

    private void initPackCheck(Context context) {
        try {
            m.oF().init(context);
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initPrivateData(Context context) {
        try {
            ar.init(context);
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initSOLoader(Context context) {
        try {
            c.a aVar = new c.a();
            aVar.fc("sodler");
            aVar.cI(((j) com.kwad.sdk.core.config.d.b(context, com.kwad.sdk.core.config.c.Vb)).getValue().intValue());
            aVar.bF(false);
            aVar.bG(((com.kwad.sdk.core.config.item.d) com.kwad.sdk.core.config.d.b(context, com.kwad.sdk.core.config.c.Va)).getValue().booleanValue());
            com.kwai.sodler.kwai.a.a(context, aVar.FG());
            com.kwai.sodler.kwai.a.a(new g.a() { // from class: com.kwad.sdk.KsAdSDKImpl.6
                @Override // com.kwai.sodler.lib.a.g.a
                public final void a(com.kwai.sodler.lib.a.f fVar, File file) {
                    try {
                        com.kwad.sdk.core.download.a.a(fVar.getDownloadUrl(), file, (a.b) null, -1, true);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.b.e("Sodler", "download failed url: " + fVar.getDownloadUrl(), th);
                        if (th instanceof Exception) {
                            com.kwad.sdk.core.network.idc.a.tH().d(fVar.getDownloadUrl(), th);
                        }
                        throw new PluginError.UpdateError(th.getMessage(), -4);
                    }
                }
            });
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initSdkLog() {
        try {
            com.kwad.sdk.core.e.b.init(this.mEnableDebug);
        } catch (Throwable th) {
            e.f(th);
        }
    }

    private void initSpeedLimitConfig() {
        com.kwad.components.core.l.b.or();
        com.kwad.components.core.l.b.e(com.kwad.sdk.core.config.d.rM(), com.kwad.sdk.core.config.d.rN());
    }

    public static void notifyInitFail(SdkConfig sdkConfig, com.kwad.sdk.a aVar) {
        if (sdkConfig != null) {
            try {
                KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    ksInitCallback.onFail(aVar.code, aVar.Qd);
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
        com.kwad.sdk.core.e.b.d(TAG, "putComponentProxy :" + cls + StringUtil.ARRAY_ELEMENT_SEPARATOR + cls2);
        sComponentProxy.put(cls, cls2);
        sRealComponent.put(cls2, cls);
    }

    public static void putModeImpl(Class cls, Class cls2) {
        sModelImpl.put(cls, cls2);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void addHp(@NonNull Map<String, String> map) {
        com.kwad.sdk.core.a.d.c(map);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Object dM(String str, Object... objArr) {
        if ("autoRT".equals(str)) {
            return -1;
        }
        if ("getAutoRevertTime".equals(str)) {
            return 10000;
        }
        boolean z = false;
        if ("TRANSFORM_API_HOST".equals(str)) {
            return com.kwad.sdk.core.network.idc.a.tH().H(objArr[0].toString(), "api");
        }
        if ("getDynamicLogRate".equals(str)) {
            return Float.valueOf(com.kwad.sdk.core.config.d.bl(this.mAppContext));
        }
        if ("reportDynamicUpdate".equals(str)) {
            k.g((JSONObject) objArr[0]);
            return Boolean.TRUE;
        } else if ("enableDynamic".equals(str)) {
            if (an.isInMainProcess(this.mAppContext) && com.kwad.b.kwai.a.QK.booleanValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else {
            return null;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void deleteCache() {
        com.kwad.sdk.core.diskcache.a.a.sS().delete();
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
            com.kwad.sdk.core.e.b.e(format, "sdk is not init mAppId is empty:" + this.mIsSdkInit);
            return "";
        }
        return this.mAppId;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getAppInfo() {
        return com.kwad.sdk.core.request.model.a.uM();
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
            com.kwad.sdk.core.e.b.e(format, "getContext is null, mIsSdkInit: " + this.mIsSdkInit, new RuntimeException().fillInStackTrace());
        }
        return this.mAppContext;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getDeviceInfo() {
        return com.kwad.sdk.core.request.model.b.uO().toJson();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getDid() {
        return ar.getDeviceId();
    }

    public boolean getIsExternal() {
        return this.isExternal;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getNetworkInfo() {
        return com.kwad.sdk.core.request.model.d.uR().toJson();
    }

    @Nullable
    public AdLocationProxy getProxyForAdLocation() {
        return this.mLocationProxy;
    }

    @NonNull
    public AdHttpProxy getProxyForHttp() {
        AdHttpProxy adHttpProxy = this.mHttpProxy;
        return adHttpProxy != null ? adHttpProxy : com.kwad.components.core.b.le();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRD(String str) {
        return com.kwad.sdk.core.a.d.getResponseData(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRM(String str) {
        return com.kwad.sdk.core.a.d.bM(str);
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
                    String processName = an.getProcessName(context);
                    if (!TextUtils.isEmpty(processName) && processName.endsWith("kssdk_remote")) {
                        initKSRemoteProcess(context, sdkConfig);
                        return;
                    }
                    com.kwad.sdk.core.e.b.bT("SDK init appId=" + sdkConfig.appId);
                    this.mAppContext = context.getApplicationContext();
                    this.mSdkConfig = sdkConfig;
                    this.mEnableDebug = sdkConfig.enableDebug;
                    this.mAppId = sdkConfig.appId;
                    this.mAppName = sdkConfig.appName;
                    this.mAppKey = sdkConfig.appKey;
                    this.mAppWebKey = sdkConfig.appWebKey;
                    this.mIsSdkInit = true;
                    e.qV();
                    com.kwad.components.core.b.lh();
                    initCommercialLogger(this.mAppContext);
                    d.b(this.mAppContext, this.mLaunchTime);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    initComponents(this.mAppContext, sdkConfig);
                    initOAID(this.mAppContext);
                    initSdkLog();
                    initLifecycleHolder(this.mAppContext);
                    initHttpProxy();
                    initIDC(this.mAppContext);
                    initDownload(this.mAppContext, sdkConfig);
                    initDiskCache(this.mAppContext);
                    initImageLoader(this.mAppContext);
                    initPrivateData(this.mAppContext);
                    initInstalledReceiver(this.mAppContext);
                    initSOLoader(this.mAppContext);
                    initConfigRequestManager();
                    initExceptionModule(this.mAppContext, sdkConfig);
                    initComponentsManager(this.mAppContext, sdkConfig);
                    initOfflineComponents();
                    com.kwad.components.core.b.lk();
                    initHybrid(this.mAppContext);
                    initApkClean(this.mAppContext);
                    initPackCheck(this.mAppContext);
                    com.kwad.components.core.e.a.ng().init(this.mAppContext);
                    com.kwad.sdk.kwai.kwai.c.rd().rf();
                    com.kwad.components.core.j.a.og().ap(this.mAppContext);
                    d.c(this.mAppContext, SystemClock.elapsedRealtime() - elapsedRealtime);
                    notifyInitSuccess(sdkConfig);
                    return;
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.e(TAG, "KSAdSDK SDKInit:init error", th);
                String stackTraceString = Log.getStackTraceString(th);
                e.f(th);
                notifyInitFail(sdkConfig, new com.kwad.sdk.a(10002, stackTraceString));
                return;
            }
        }
        com.kwad.sdk.core.e.b.e(TAG, "KSAdSDK SDKInit:init error,please check appID and config item");
        notifyInitFail(sdkConfig, com.kwad.sdk.a.QN);
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
        com.kwad.sdk.core.e.b.d(TAG, "componentClass :" + cls + StringUtil.ARRAY_ELEMENT_SEPARATOR + cls2);
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
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void re(Object obj) {
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            if (this.mEnableDebug) {
                th.printStackTrace();
            }
            com.kwad.components.core.b.a.b(th);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void reportBatchEvent(int i, Map<String, Object> map) {
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void resumeCurrentPlayer() {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
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
        w.L(this.mAppContext, str);
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
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimationColor(boolean z, @ColorInt int i) {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
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
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void unInit() {
        com.kwad.sdk.core.download.e.sV().bp(this.mAppContext);
        Context context = this.mAppContext;
        if (context != null) {
            com.kwad.components.core.m.g.av(context).oE();
        }
    }
}
