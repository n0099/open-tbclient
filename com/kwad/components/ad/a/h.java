package com.kwad.components.ad.a;

import android.content.Context;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
/* loaded from: classes7.dex */
public interface h extends com.kwad.sdk.components.a {
    void a(Context context, String str, boolean z, Rect rect);

    void ag();

    void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener);
}
