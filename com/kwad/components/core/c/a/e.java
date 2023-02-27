package com.kwad.components.core.c.a;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.j;
/* loaded from: classes8.dex */
public final class e {
    public static boolean d(Context context, AdTemplate adTemplate) {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if (com.kwad.sdk.core.response.a.a.H(bQ) || TextUtils.isEmpty(j.y(context, "com.tencent.mm"))) {
            return false;
        }
        Cursor cursor = null;
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.setComponent(launchIntentForPackage.getComponent());
            context.startActivity(intent);
            cursor = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{bQ.adConversionInfo.smallAppJumpInfo.mediaSmallAppId, bQ.adConversionInfo.smallAppJumpInfo.originId, bQ.adConversionInfo.smallAppJumpInfo.smallAppJumpUrl, "0", ""}, null);
            if (cursor != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            }
            return true;
        } catch (Exception unused) {
            return false;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
    }
}
