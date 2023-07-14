package com.kwad.components.core.offline.init;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.d;
import com.kwad.sdk.utils.am;
/* loaded from: classes10.dex */
public abstract class DefaultOfflineCompo extends d implements IOfflineCompo {
    public final IOfflineCompo mOfflineComponents;

    public DefaultOfflineCompo(@NonNull IOfflineCompo iOfflineCompo) {
        am.checkNotNull(iOfflineCompo);
        this.mOfflineComponents = iOfflineCompo;
    }

    @Override // com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
        this.mOfflineComponents.init(context, sdkConfig);
    }

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public int priority() {
        return this.mOfflineComponents.priority();
    }
}
