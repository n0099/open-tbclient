package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes9.dex */
public final class bj {
    @Nullable
    public static Activity dB(@Nullable Context context) {
        if (context instanceof ResContext) {
            context = ((ResContext) context).getDelegatedContext();
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        com.kwad.sdk.core.c.b.tp();
        return com.kwad.sdk.core.c.b.getCurrentActivity();
    }

    public static Context getApplicationContext(Context context) {
        Context applicationContext = Wrapper.unwrapContextIfNeed(context).getApplicationContext();
        return applicationContext instanceof ResContext ? ((ResContext) applicationContext).getDelegatedContext().getApplicationContext() : applicationContext;
    }
}
