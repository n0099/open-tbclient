package com.kwad.components.core.m;

import android.content.Intent;
import android.os.Bundle;
import com.kwad.sdk.api.loader.Loader;
/* loaded from: classes8.dex */
public final class l {
    public static void e(Intent intent) {
        if (intent == null) {
            return;
        }
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        Bundle extras = intent.getExtras();
        if (externalClassLoader == null || extras == null) {
            return;
        }
        extras.setClassLoader(externalClassLoader);
    }
}
