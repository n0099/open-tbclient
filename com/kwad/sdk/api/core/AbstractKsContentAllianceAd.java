package com.kwad.sdk.api.core;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.KsContentAllianceAd;
import com.kwad.sdk.api.core.fragment.KsFragment;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes4.dex */
public abstract class AbstractKsContentAllianceAd implements KsContentAllianceAd {
    @Override // com.kwad.sdk.api.KsContentAllianceAd
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public Fragment getFragment() {
        return getFragment2().getBase();
    }

    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    protected abstract KsFragment getFragment2();
}
