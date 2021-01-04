package com.kwad.sdk.api.core;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.Map;
import org.json.JSONObject;
@KsAdSdkDynamicApi("com.kwad.sdk.KsAdSDKImpl")
@Keep
/* loaded from: classes5.dex */
public interface IKsAdSDK {
    @KsAdSdkDynamicApi
    @Keep
    void deleteCache();

    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    KsLoadManager getAdManager();

    @KsAdSdkDynamicApi
    @Keep
    String getApiVersion();

    @KsAdSdkDynamicApi
    @Keep
    int getApiVersionCode();

    @KsAdSdkDynamicApi
    @Keep
    String getAppId();

    @KsAdSdkDynamicApi
    @Keep
    JSONObject getAppInfo();

    @KsAdSdkDynamicApi
    @Keep
    String getAppName();

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    Context getContext();

    @KsAdSdkDynamicApi
    @Keep
    JSONObject getDeviceInfo();

    @KsAdSdkDynamicApi
    @Keep
    String getDid();

    @KsAdSdkDynamicApi
    @Keep
    JSONObject getNetworkInfo();

    @KsAdSdkDynamicApi
    @Keep
    int getSDKType();

    @KsAdSdkDynamicApi
    @Keep
    String getSDKVersion();

    @KsAdSdkDynamicApi
    @Keep
    int getSDKVersionCode();

    @KsAdSdkDynamicApi
    @Keep
    void init(Context context, SdkConfig sdkConfig);

    @KsAdSdkDynamicApi
    @Keep
    boolean isDebugLogEnable();

    @KsAdSdkDynamicApi
    @Keep
    <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj);

    @KsAdSdkDynamicApi
    @Keep
    <T> T newInstance(Class<T> cls);

    @KsAdSdkDynamicApi
    @Keep
    void reportBatchEvent(int i, Map<String, Object> map);

    @KsAdSdkDynamicApi
    @Keep
    void setApiVersion(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setApiVersionCode(int i);

    @KsAdSdkDynamicApi
    @Keep
    void setAppTag(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setIsExternal(boolean z);

    @KsAdSdkDynamicApi
    @Keep
    void unInit();
}
