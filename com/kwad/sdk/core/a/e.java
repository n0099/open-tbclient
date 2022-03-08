package com.kwad.sdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.as;
/* loaded from: classes7.dex */
public final class e {
    public static String a() {
        Context context = KsAdSDKImpl.get().getContext();
        return context == null ? "" : as.a(context);
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        as.g(context, str);
    }

    public static void a(String str) {
        com.kwad.sdk.plugin.a aVar;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null || (aVar = (com.kwad.sdk.plugin.a) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.a.class)) == null) {
            return;
        }
        aVar.a(context, str);
    }

    public static String b() {
        Context context = KsAdSDKImpl.get().getContext();
        return context == null ? "" : as.c(context);
    }
}
