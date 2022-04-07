package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.api.core.ResContext;
import com.sina.weibo.sdk.utils.ResourceManager;
/* loaded from: classes5.dex */
public class am {
    public static int a(Context context, String str) {
        Resources a = a(context);
        if (a == null) {
            a = context.getResources();
        }
        return a.getIdentifier(str, ResourceManager.DRAWABLE, context.getPackageName());
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
