package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes4.dex */
public class ab {
    public static int a(Context context, String str) {
        if (context instanceof ResContext) {
            context = ((ResContext) context).getDelegatedContext();
        }
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    private static int a(Context context, String str, String str2) {
        a(str2, str);
        return a(context).getIdentifier(str, str2, b(context));
    }

    private static Resources a(Context context) {
        return Wrapper.wrapContextIfNeed(context).getResources();
    }

    private static void a(String str, String str2) {
    }

    public static Drawable b(Context context, String str) {
        return a(context).getDrawable(a(context, str, "drawable"));
    }

    private static String b(Context context) {
        return Loader.get().getExternalResource() != null ? "com.kwad.sdk" : context.getPackageName();
    }
}
