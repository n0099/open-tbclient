package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsEntryElement;
import com.kwad.sdk.api.loader.Wrapper;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes3.dex */
public abstract class AbstractKsEntryElement implements KsEntryElement {
    @Override // com.kwad.sdk.api.KsEntryElement
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final View getEntryView(Context context, KsEntryElement.OnFeedClickListener onFeedClickListener) {
        return getEntryView2(Wrapper.wrapContextIfNeed(context), onFeedClickListener);
    }

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    protected abstract View getEntryView2(Context context, KsEntryElement.OnFeedClickListener onFeedClickListener);
}
