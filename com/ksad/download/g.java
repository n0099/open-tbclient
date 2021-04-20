package com.ksad.download;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.alibaba.fastjson.asm.Label;
import com.kwad.sdk.api.core.fragment.FileProvider;
import java.io.File;
/* loaded from: classes6.dex */
public class g {
    public static PendingIntent a(DownloadTask downloadTask) {
        File file = new File(downloadTask.getTargetFilePath());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.addFlags(3);
        Context a2 = b.a();
        Uri a3 = a(a2, file);
        intent.setDataAndType(a3, "application/vnd.android.package-archive");
        for (ResolveInfo resolveInfo : a2.getPackageManager().queryIntentActivities(intent, 65536)) {
            a2.grantUriPermission(resolveInfo.activityInfo.packageName, a3, 3);
        }
        return PendingIntent.getActivity(a2, downloadTask.getId(), intent, 134217728);
    }

    public static PendingIntent a(File file, int i) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.addFlags(3);
        Context a2 = b.a();
        Uri a3 = a(a2, file);
        intent.setDataAndType(a3, "application/vnd.android.package-archive");
        for (ResolveInfo resolveInfo : a2.getPackageManager().queryIntentActivities(intent, 65536)) {
            a2.grantUriPermission(resolveInfo.activityInfo.packageName, a3, 3);
        }
        return PendingIntent.getActivity(a2, i, intent, 134217728);
    }

    public static PendingIntent a(String str, int i) {
        Context a2 = b.a();
        Intent launchIntentForPackage = a2.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        return PendingIntent.getActivity(a2, i, launchIntentForPackage, 134217728);
    }

    public static Uri a(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
        }
        return Uri.fromFile(file);
    }
}
