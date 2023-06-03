package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.api.core.ResContext;
import com.sina.weibo.sdk.utils.ResourceManager;
/* loaded from: classes10.dex */
public final class ao {
    public static int ab(Context context, String str) {
        Resources cH = cH(context);
        if (cH == null) {
            cH = context.getResources();
        }
        return cH.getIdentifier(str, ResourceManager.DRAWABLE, context.getPackageName());
    }

    public static Resources cH(Context context) {
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
