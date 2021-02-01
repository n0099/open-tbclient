package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public static int a(Context context, AdTemplate adTemplate, int i) {
        int i2 = 0;
        if (adTemplate != null && context != null) {
            i2 = a(context, com.kwad.sdk.core.response.b.c.j(adTemplate).adConversionInfo.deeplinkUrl);
            if (i2 == 1) {
                com.kwad.sdk.core.report.b.a(adTemplate, i);
            } else if (i2 == -1) {
                com.kwad.sdk.core.report.b.b(adTemplate, i);
            }
        }
        return i2;
    }

    public static int a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return 0;
        }
        try {
            Intent parseUri = Intent.parseUri(str, 0);
            parseUri.setAction("android.intent.action.VIEW");
            parseUri.setFlags(268435456);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(parseUri, 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return 0;
            }
            context.startActivity(parseUri);
            return 1;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            return -1;
        }
    }
}
