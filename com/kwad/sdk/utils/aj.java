package com.kwad.sdk.utils;

import android.content.Intent;
import android.os.Bundle;
import com.kwad.sdk.api.loader.Loader;
/* loaded from: classes3.dex */
public class aj {
    public static void a(Intent intent) {
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
