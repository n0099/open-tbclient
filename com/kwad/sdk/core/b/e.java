package com.kwad.sdk.core.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.af;
/* loaded from: classes6.dex */
public final class e {
    public static String a() {
        Context context = KsAdSDKImpl.get().getContext();
        return context == null ? "" : af.a(context);
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        af.e(context, str);
    }

    public static void a(String str) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (com.kwad.sdk.d.f33864a == 1) {
            com.kwad.sdk.plugin.a aVar = (com.kwad.sdk.plugin.a) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.a.class);
            if (aVar != null) {
                aVar.a(context, str);
                return;
            }
            return;
        }
        com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.b.class);
        if (bVar != null) {
            bVar.a(context, str);
        }
    }

    public static String b() {
        Context context = KsAdSDKImpl.get().getContext();
        return context == null ? "" : af.b(context);
    }
}
