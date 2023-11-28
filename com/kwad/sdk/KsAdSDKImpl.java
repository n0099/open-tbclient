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
import com.kwad.components.core.request.g;
import com.kwad.components.core.s.m;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.loader.DynamicInstallReceiver;
import com.kwad.sdk.api.proxy.BaseProxyActivity;
import com.kwad.sdk.api.proxy.BaseProxyFragmentActivity;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.kwad.sdk.commercial.a;
import com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bk;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(IKsAdSDK.class)
@Keep
/* loaded from: classes10.dex */
public class KsAdSDKImpl implements IKsAdSDK {
    public static final String TAG = "KSAdSDK";
    public boolean adxEnable;
    public boolean isExternal;
    @Nullable
    public KsLoadManager mAdRequestManager;
    public int mApiVersionCode;
    public String mApiVersionName;
    public String mAppTag;
    public long mInitTime;
    public volatile boolean mIsSdkInit;
    public long mLaunchTime;
    public volatile boolean personalRecommend;
    public boolean programmaticRecommend;

    private void initLottie() {
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

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void reportBatchEvent(int i, Map<String, Object> map) {
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static final KsAdSDKImpl aku = new KsAdSDKImpl();
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
        return a.aku;
    }

    private void initApkClean() {
        try {
            com.kwad.sdk.core.diskcache.a.aT(getContext());
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initAppTag() {
        y.ag(ServiceProvider.getContext(), this.mAppTag);
        this.mAppTag = null;
    }

    private void initCommercialLogger() {
        try {
            com.kwad.sdk.commercial.a.a(new a.InterfaceC0696a() { // from class: com.kwad.sdk.KsAdSDKImpl.1
                @Override // com.kwad.sdk.commercial.a.InterfaceC0696a
                public final void j(String str, String str2, boolean z) {
                    com.kwad.components.core.o.a.pX().e(str, str2, false);
                }

                @Override // com.kwad.sdk.commercial.a.InterfaceC0696a
                public final boolean xX() {
                    return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.aoS);
                }

                @Override // com.kwad.sdk.commercial.a.InterfaceC0696a
                public final boolean xY() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aoR);
                }

                @Override // com.kwad.sdk.commercial.a.InterfaceC0696a
                public final JSONObject xZ() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.apd);
                }
            }, this.isExternal);
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initComponents() {
        try {
            com.kwad.sdk.components.b.init(ServiceProvider.getContext());
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initComponentsManager() {
        try {
            com.kwad.sdk.components.c.init(getContext());
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initConfigRequestManager() {
        try {
            com.kwad.components.core.request.g.a(new g.a() { // from class: com.kwad.sdk.KsAdSDKImpl.4
                @Override // com.kwad.components.core.request.g.a
                public final void a(@NonNull SdkConfigData sdkConfigData) {
                    com.kwad.sdk.core.e.c.i("KSAdSDK", "onConfigRefresh()");
                    try {
                        KsAdSDKImpl.this.initOnConfigRefresh(sdkConfigData);
                    } catch (Throwable th) {
                        com.kwad.components.core.d.a.b(th);
                    }
                }

                @Override // com.kwad.components.core.request.g.a
                public final void qi() {
                    com.kwad.sdk.core.e.c.R("KSAdSDK", "onCacheLoaded()");
                    if (((com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class)) != null) {
                        ServiceProvider.getContext();
                    }
                }
            });
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initDownload() {
        try {
            com.kwad.sdk.core.download.a.aU(ServiceProvider.getContext());
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initExceptionModule() {
        try {
            com.kwad.components.core.d.a.initAsync(ServiceProvider.getContext());
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initHybrid() {
        try {
            com.kwad.sdk.core.webview.b.a.FM().init(getContext());
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initIDC() {
        try {
            com.kwad.sdk.core.network.idc.a.CJ().init(getContext());
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initInstalledReceiver() {
        try {
            com.kwad.sdk.b.b.zt().checkInit();
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initKSPlugin() {
        try {
            com.kwad.sdk.m.e.Mt().init();
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initLifecycleHolder() {
        try {
            com.kwad.sdk.core.c.b.Ct().init(ServiceProvider.getContext());
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initOAID() {
        try {
            com.kwad.sdk.core.f.a.initAsync(getContext());
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initOfflineComponents() {
        try {
            com.kwad.components.core.n.b.b.init(getContext());
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initPackCheck() {
        try {
            m.qR().init();
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initPrivateData() {
        try {
            av.init(getContext());
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initSOLoader() {
        try {
            com.kwad.library.solder.lib.i.a(new i.a() { // from class: com.kwad.sdk.KsAdSDKImpl.7
                @Override // com.kwad.library.solder.lib.i.a
                public final void b(String str, File file) {
                    com.kwad.sdk.core.download.a.a(str, file, true);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final void d(String str, Throwable th) {
                    if (th instanceof Exception) {
                        com.kwad.sdk.core.network.idc.a.CJ().g(str, th);
                    }
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final int getMaxRetryCount() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.apY);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final boolean wX() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.apX);
                }
            });
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initSdkLog() {
        try {
            com.kwad.sdk.core.e.c.init(ServiceProvider.Jo().enableDebug);
        } catch (Throwable th) {
            l.l(th);
        }
    }

    private void initSpeedLimitConfig() {
        com.kwad.components.core.p.b.qn();
        com.kwad.components.core.p.b.f(com.kwad.sdk.core.config.d.AB(), com.kwad.sdk.core.config.d.AC());
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void deleteCache() {
        com.kwad.sdk.core.diskcache.b.a.BS().delete();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @NonNull
    public KsLoadManager getAdManager() {
        if (this.mAdRequestManager == null) {
            this.mAdRequestManager = new com.kwad.components.core.b();
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
        return ServiceProvider.Jo().appId;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getAppInfo() {
        return com.kwad.sdk.core.request.model.a.DP();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppName() {
        return ServiceProvider.Jo().appName;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Context getContext() {
        return ServiceProvider.getContext();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getDeviceInfo() {
        return com.kwad.sdk.core.request.model.b.DR().toJson();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getDid() {
        return av.getDeviceId();
    }

    public boolean getIsExternal() {
        return this.isExternal;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getNetworkInfo() {
        return com.kwad.sdk.core.request.model.d.DU().toJson();
    }

    public long getSDKInitTime() {
        return this.mInitTime;
    }

    public boolean hasInitFinish() {
        return this.mIsSdkInit;
    }

    public boolean isAdxEnable() {
        return this.adxEnable;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public boolean isDebugLogEnable() {
        return ServiceProvider.Jo().enableDebug;
    }

    public boolean isPersonalRecommend() {
        return this.personalRecommend;
    }

    public boolean isProgrammaticRecommend() {
        return this.programmaticRecommend;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void pauseCurrentPlayer() {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void resumeCurrentPlayer() {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void unInit() {
        com.kwad.sdk.core.download.b.BU().aW(getContext());
    }

    private boolean isRemoteService(Context context) {
        String processName = aq.getProcessName(context);
        if (!TextUtils.isEmpty(processName) && processName.endsWith("kssdk_remote")) {
            return true;
        }
        return false;
    }

    public static void notifyInitSuccess(SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bn.b(new ay() { // from class: com.kwad.sdk.KsAdSDKImpl.3
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            KsInitCallback.this.onSuccess();
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void addHp(@NonNull Map<String, String> map) {
        com.kwad.sdk.core.a.d.e(map);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRD(String str) {
        return com.kwad.sdk.core.a.d.getResponseData(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRM(String str) {
        return com.kwad.sdk.core.a.d.ak(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T> T newInstance(Class<T> cls) {
        try {
            return (T) com.kwad.sdk.service.b.h(cls).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void re(Object obj) {
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            if (com.kwad.framework.a.a.mc.booleanValue()) {
                th.printStackTrace();
            }
            com.kwad.components.core.d.a.b(th);
        }
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
        if (this.mIsSdkInit) {
            y.ag(ServiceProvider.getContext(), this.mAppTag);
        } else {
            this.mAppTag = str;
        }
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
    public void setPersonalRecommend(boolean z) {
        this.personalRecommend = z;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setProgrammaticRecommend(boolean z) {
        this.programmaticRecommend = z;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setThemeMode(int i) {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    public static void notifyInitFail(SdkConfig sdkConfig, final e eVar) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bn.postOnUiThread(new ay() { // from class: com.kwad.sdk.KsAdSDKImpl.2
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            KsInitCallback ksInitCallback2 = KsInitCallback.this;
                            e eVar2 = eVar;
                            ksInitCallback2.onFail(eVar2.code, eVar2.msg);
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimation(boolean z, @RawRes int i) {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimationColor(boolean z, @ColorInt int i) {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initOnConfigRefresh(SdkConfigData sdkConfigData) {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
        initCommercialLogger();
        initHybrid();
        com.kwad.sdk.core.config.d.yf();
        if ((com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aoQ) && aq.isInMainProcess(ServiceProvider.Jn())) || com.kwad.framework.a.a.mc.booleanValue()) {
            DynamicInstallReceiver.registerToApp(ServiceProvider.Jn());
        }
        if (com.kwad.sdk.core.config.d.Bh()) {
            com.kwad.sdk.c.a.init(com.kwad.sdk.m.l.My());
        }
        initSpeedLimitConfig();
        az.init(getContext());
        com.kwad.components.core.a.a.mk().eE();
        com.kwad.sdk.utils.f.a(getContext(), 30000L, new com.kwad.sdk.collector.h() { // from class: com.kwad.sdk.KsAdSDKImpl.5
            @Override // com.kwad.sdk.collector.h
            public final void c(@NonNull JSONArray jSONArray) {
                com.kwad.components.core.o.a.pX().c(jSONArray);
            }
        });
        com.kwad.sdk.core.network.idc.a.CJ().a(com.kwad.sdk.core.config.d.Bi(), com.kwad.sdk.core.config.d.Bj());
        bk.a(com.kwad.sdk.core.config.d.Bk(), com.kwad.sdk.core.config.d.Bl(), ServiceProvider.getContext());
        initInstalledReceiver();
        initApkClean();
        com.kwad.components.core.h.a.ou().Y(getContext());
        com.kwad.sdk.crash.online.monitor.a.dY(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqz));
        ImageLoaderPerfUtil.report();
        com.kwad.sdk.ranger.e.dY(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqF));
        com.kwad.sdk.core.threads.c.dY(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqH));
        com.kwad.sdk.i.b.HQ();
        com.kwad.sdk.m.l.x(getContext(), ((Boolean) com.kwad.sdk.core.config.d.AR().getAppConfigData(Boolean.FALSE, new com.kwad.sdk.g.b<JSONObject, Boolean>() { // from class: com.kwad.sdk.KsAdSDKImpl.6
            public static Boolean f(JSONObject jSONObject) {
                return Boolean.valueOf(jSONObject.optBoolean("useContextClassLoader"));
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Boolean apply(JSONObject jSONObject) {
                return f(jSONObject);
            }
        })).booleanValue());
        com.kwad.sdk.kgeo.a.de(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqY));
    }

    private void initSDKModule() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mInitTime = elapsedRealtime;
        com.kwad.sdk.service.b.init();
        i.yb();
        initSdkLog();
        initKSPlugin();
        k.U(this.mLaunchTime);
        initComponents();
        initOAID();
        initIDC();
        initDownload();
        initSOLoader();
        initAppTag();
        initConfigRequestManager();
        initExceptionModule();
        initComponentsManager();
        initOfflineComponents();
        initLifecycleHolder();
        initLottie();
        initPrivateData();
        initPackCheck();
        com.kwad.sdk.a.a.c.yT().yV();
        com.kwad.components.core.o.a.pX().pY();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.kwad.sdk.core.e.c.d("KSAdSDK", "KSAdSDK init time:" + elapsedRealtime2);
        com.kwad.sdk.core.e.c.i("KSAdSDK", "SDK_VERSION_NAME: 3.3.55 TK_VERSION_CODE: 5.1.4 BRIDGE_VERSION: 1.3");
        k.V(elapsedRealtime2);
        notifyInitSuccess(ServiceProvider.Jo());
        com.kwad.sdk.i.a.report();
        try {
            com.kwad.components.core.webview.tachikoma.g.sn().init();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
        this.mIsSdkInit = true;
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
            return com.kwad.sdk.core.network.idc.a.CJ().W(objArr[0].toString(), "api");
        }
        if ("reportDynamicUpdate".equals(str)) {
            com.kwad.sdk.commercial.a.g((JSONObject) objArr[0]);
            return Boolean.TRUE;
        } else if ("enableDynamic".equals(str)) {
            if (aq.isInMainProcess(ServiceProvider.Jn()) && com.kwad.framework.a.a.adr.booleanValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else {
            return null;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public synchronized void init(Context context, SdkConfig sdkConfig) {
        if (context != null && sdkConfig != null) {
            try {
            } catch (Throwable th) {
                Log.e("KSAdSDK", "init error", th);
                notifyInitFail(sdkConfig, new e(10002, Log.getStackTraceString(th)));
            }
            if (!TextUtils.isEmpty(sdkConfig.appId)) {
                Log.d("KSAdSDK", "init appId:" + sdkConfig.appId + "--mIsSdkInit:" + this.mIsSdkInit);
                if (this.mIsSdkInit) {
                    ServiceProvider.a(sdkConfig);
                    return;
                }
                ServiceProvider.a(sdkConfig);
                ServiceProvider.bC(context);
                if (isRemoteService(context)) {
                    Log.d("KSAdSDK", "intKSRemoteProcess appId=" + sdkConfig.appId);
                    ServiceProvider.Jm();
                    i.yb();
                    initSdkLog();
                    this.mIsSdkInit = true;
                } else {
                    l.yN();
                    initSDKModule();
                }
                return;
            }
        }
        Log.e("KSAdSDK", "KSAdSDK SDKInit:init error,please check appID and config item");
        notifyInitFail(sdkConfig, e.akk);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        try {
            Class g = com.kwad.sdk.service.b.g(cls);
            if (g == null) {
                if (obj instanceof BaseProxyActivity) {
                    g = com.kwad.components.core.proxy.a.class;
                } else if (obj instanceof BaseProxyFragmentActivity) {
                    g = com.kwad.components.core.proxy.b.class;
                }
                com.kwad.components.core.d.a.b(new RuntimeException("--getIsExternal:" + getIsExternal() + "--mIsSdkInit:" + hasInitFinish() + "--componentClass" + cls));
            }
            return (T) g.newInstance();
        } catch (Exception e) {
            com.kwad.components.core.d.a.b(e);
            com.kwad.sdk.core.e.c.printStackTrace(e);
            return null;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void sR(String str, Map<String, String> map, String str2) {
        com.kwad.sdk.core.a.d.a(str, map, str2);
    }
}
