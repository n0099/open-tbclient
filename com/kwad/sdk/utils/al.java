package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.kwad.sdk.api.core.fragment.FileProvider;
import java.io.File;
/* loaded from: classes10.dex */
public final class al {
    @SuppressLint({"UnspecifiedImmutableFlag"})
    public static PendingIntent a(Context context, int i, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getBroadcast(context, i, intent, BDImageView.DEFAULT_BORDER_COLOR);
        }
        return PendingIntent.getBroadcast(context, i, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    public static PendingIntent b(Context context, int i, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, i, intent, BDImageView.DEFAULT_BORDER_COLOR);
        }
        return PendingIntent.getActivity(context, i, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
    }

    @Nullable
    public static PendingIntent d(Context context, String str, int i) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        return b(context, i, launchIntentForPackage);
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public static PendingIntent a(Context context, File file, int i, boolean z) {
        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
        intent.addFlags(268435459);
        Uri c = c(context, file);
        intent.setDataAndType(c, "application/vnd.android.package-archive");
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            context.grantUriPermission(resolveInfo.activityInfo.packageName, c, 3);
        }
        if (z) {
            com.kwad.sdk.c.xA();
            if (com.kwad.sdk.c.xD()) {
                intent = h(intent);
            }
        }
        return b(context, i, intent);
    }

    public static Uri c(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
        }
        return Uri.fromFile(file);
    }

    public static Intent h(Intent intent) {
        Intent intent2 = new Intent("intent.action.requestInstallPermission");
        intent2.putExtra("fromNotification", true);
        intent2.putExtra(BaseGmsClient.KEY_PENDING_INTENT, intent);
        intent2.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        return intent2;
    }
}
