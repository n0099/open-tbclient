package com.kwad.sdk.core.download.kwai;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    public static int a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return 0;
        }
        try {
            Intent parseUri = Intent.parseUri(str, 0);
            parseUri.setAction("android.intent.action.VIEW");
            parseUri.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(parseUri, 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return 0;
            }
            context.startActivity(parseUri);
            return 1;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
            return -1;
        }
    }
}
