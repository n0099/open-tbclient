package com.kwad.sdk.api.core;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.KsFeedPage;
import com.kwad.sdk.api.core.fragment.KsFragment;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes3.dex */
public abstract class AbstractKsFeedPage implements KsFeedPage {
    @Override // com.kwad.sdk.api.KsFeedPage
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
