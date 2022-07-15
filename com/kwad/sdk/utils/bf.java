package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes5.dex */
public final class bf {
    public static Context a(Context context) {
        Context applicationContext = Wrapper.unwrapContextIfNeed(context).getApplicationContext();
        return applicationContext instanceof ResContext ? ((ResContext) applicationContext).getDelegatedContext().getApplicationContext() : applicationContext;
    }

    @Nullable
    public static Activity b(@Nullable Context context) {
        if (context instanceof ResContext) {
            context = ((ResContext) context).getDelegatedContext();
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        com.kwad.sdk.core.lifecycle.a.c();
        return com.kwad.sdk.core.lifecycle.a.e();
    }
}
