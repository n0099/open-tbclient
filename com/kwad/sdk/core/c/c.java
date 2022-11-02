package com.kwad.sdk.core.c;

import android.app.Activity;
import android.os.Bundle;
/* loaded from: classes8.dex */
public interface c {
    void onActivityCreated(Activity activity, Bundle bundle);

    void onActivityDestroyed(Activity activity);

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);

    void onBackToBackground();

    void onBackToForeground();
}
