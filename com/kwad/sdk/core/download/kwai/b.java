package com.kwad.sdk.core.download.kwai;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    public static int s(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return 0;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction(IntentConstants.ACTION_BOX_BROWSER);
            intent.setData(parse);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return 0;
            }
            context.startActivity(intent);
            return 1;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            return -1;
        }
    }
}
