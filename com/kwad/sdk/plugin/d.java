package com.kwad.sdk.plugin;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveStatusResultData;
/* loaded from: classes6.dex */
public interface d extends e {
    KsFragment a();

    void a(@NonNull Context context, @NonNull AdTemplate adTemplate, LiveStatusResultData.LiveStatus liveStatus);

    void a(Context context, SceneImpl sceneImpl);

    boolean a(KsFragment ksFragment);

    boolean a(SceneImpl sceneImpl);

    boolean c();
}
