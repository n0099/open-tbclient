package com.kwad.components.core.offline.init.kwai;

import android.content.Context;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.az;
/* loaded from: classes10.dex */
public final class d implements IEnvironment {
    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getAppId() {
        return KsAdSDKImpl.get().getAppId();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final Context getContext() {
        return KsAdSDKImpl.get().getContext();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getDeviceId() {
        return az.getDeviceId();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getProcessName(Context context) {
        return SystemUtil.getProcessName(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getUserAgent() {
        return o.getUserAgent();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isArm64(Context context) {
        return AbiUtil.isArm64(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isDebug() {
        return false;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isDevelopEnable() {
        return com.kwad.components.core.a.aw.booleanValue();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isInMainProcess(Context context) {
        return SystemUtil.isInMainProcess(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String localIpAddress() {
        return "10.244.50.216";
    }
}
