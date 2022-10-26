package com.kwad.sdk.api.core;

import android.content.Context;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.Map;
import org.json.JSONObject;
@KsAdSdkDynamicApi("com.kwad.sdk.KsAdSDKImpl")
/* loaded from: classes7.dex */
public interface IKsAdSDK {
    void addHp(Map map);

    Object dM(String str, Object... objArr);

    @KsAdSdkDynamicApi
    void deleteCache();

    @KsAdSdkDynamicApi
    KsLoadManager getAdManager();

    @KsAdSdkDynamicApi
    String getApiVersion();

    @KsAdSdkDynamicApi
    int getApiVersionCode();

    @KsAdSdkDynamicApi
    String getAppId();

    @KsAdSdkDynamicApi
    JSONObject getAppInfo();

    @KsAdSdkDynamicApi
    String getAppName();

    @KsAdSdkDynamicApi
    Context getContext();

    @KsAdSdkDynamicApi
    JSONObject getDeviceInfo();

    @KsAdSdkDynamicApi
    String getDid();

    @KsAdSdkDynamicApi
    JSONObject getNetworkInfo();

    String getRD(String str);

    String getRM(String str);

    @KsAdSdkDynamicApi
    int getSDKType();

    @KsAdSdkDynamicApi
    String getSDKVersion();

    @KsAdSdkDynamicApi
    int getSDKVersionCode();

    @KsAdSdkDynamicApi
    void init(Context context, SdkConfig sdkConfig);

    @KsAdSdkDynamicApi
    boolean isDebugLogEnable();

    @KsAdSdkDynamicApi
    IComponentProxy newComponentProxy(Class cls, Object obj);

    @KsAdSdkDynamicApi
    Object newInstance(Class cls);

    @KsAdSdkDynamicApi
    void pauseCurrentPlayer();

    void re(Object obj);

    @KsAdSdkDynamicApi
    @Deprecated
    void reportBatchEvent(int i, Map map);

    @KsAdSdkDynamicApi
    void resumeCurrentPlayer();

    void sR(String str, Map map, String str2);

    @KsAdSdkApi
    void setAdxEnable(boolean z);

    @KsAdSdkDynamicApi
    void setApiVersion(String str);

    @KsAdSdkDynamicApi
    void setApiVersionCode(int i);

    @KsAdSdkDynamicApi
    void setAppTag(String str);

    @KsAdSdkDynamicApi
    void setIsExternal(boolean z);

    @KsAdSdkDynamicApi
    void setLaunchTime(long j);

    @KsAdSdkDynamicApi
    void setLoadingLottieAnimation(boolean z, int i);

    @KsAdSdkDynamicApi
    void setLoadingLottieAnimationColor(boolean z, int i);

    @KsAdSdkDynamicApi
    void setPersonalRecommend(boolean z);

    @KsAdSdkDynamicApi
    void setProgrammaticRecommend(boolean z);

    @KsAdSdkDynamicApi
    void setThemeMode(int i);

    @KsAdSdkDynamicApi
    void unInit();
}
