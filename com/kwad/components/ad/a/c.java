package com.kwad.components.ad.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
/* loaded from: classes8.dex */
public interface c extends com.kwad.sdk.components.a {
    void loadConfigFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener);

    void loadFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener);
}
