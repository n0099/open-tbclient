package com.kwad.components.offline.obiwan;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.offline.api.obiwan.ObiwanComponents;
import com.kwad.components.core.offline.init.DefaultOfflineCompo;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes8.dex */
public class ObiwanComponentsImpl extends DefaultOfflineCompo implements ObiwanComponents {
    public final IObiwanOfflineCompo mOfflineCompo;

    public ObiwanComponentsImpl(@NonNull IObiwanOfflineCompo iObiwanOfflineCompo) {
        super(iObiwanOfflineCompo);
        this.mOfflineCompo = iObiwanOfflineCompo;
    }

    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        return ObiwanComponentsImpl.class;
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo
    public IObiwanLogcat getLog() {
        return this.mOfflineCompo.getLog();
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo
    public void initReal(Context context, SdkConfig sdkConfig, IObiwanOfflineCompoInitConfig iObiwanOfflineCompoInitConfig) {
        this.mOfflineCompo.initReal(context, sdkConfig, iObiwanOfflineCompoInitConfig);
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo
    public void updateConfigs() {
        this.mOfflineCompo.updateConfigs();
    }
}
