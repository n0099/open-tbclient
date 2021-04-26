package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.api.core.ResContext;
/* loaded from: classes6.dex */
public class ab {
    public static int a(Context context, String str) {
        Resources a2 = a(context);
        if (a2 == null) {
            a2 = context.getResources();
        }
        return a2.getIdentifier(str, "drawable", context.getPackageName());
    }

    public static Resources a(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof ResContext) {
            applicationContext = ((ResContext) applicationContext).getDelegatedContext();
        }
        return applicationContext.getResources();
    }
}
