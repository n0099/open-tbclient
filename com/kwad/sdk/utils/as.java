package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.service.ServiceProvider;
import com.sina.weibo.sdk.utils.ResourceManager;
/* loaded from: classes10.dex */
public final class as {
    public static int at(Context context, String str) {
        Resources cu = cu(context);
        if (cu == null) {
            cu = context.getResources();
        }
        return cu.getIdentifier(str, ResourceManager.DRAWABLE, context.getPackageName());
    }

    public static Resources cu(Context context) {
        if (context == null) {
            return null;
        }
        return ServiceProvider.Jn().getResources();
    }
}
