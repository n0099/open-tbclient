package com.ksad.download;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.kwad.sdk.api.core.fragment.FileProvider;
import com.kwad.sdk.core.download.DownloadParams;
import java.io.File;
/* loaded from: classes7.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PendingIntent a(File file, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{file, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.addFlags(3);
            Context context = b.getContext();
            Uri a = a(context, file);
            intent.setDataAndType(a, "application/vnd.android.package-archive");
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
                context.grantUriPermission(resolveInfo.activityInfo.packageName, a, 3);
            }
            if (z && b.aa) {
                intent = a(intent);
            }
            return PendingIntent.getActivity(context, i, intent, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
        }
        return (PendingIntent) invokeCommon.objValue;
    }

    public static Intent a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, intent)) == null) {
            Intent intent2 = new Intent("intent.action.requestInstallPermission");
            intent2.putExtra("fromNotification", true);
            intent2.putExtra(BaseGmsClient.KEY_PENDING_INTENT, intent);
            intent2.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            return intent2;
        }
        return (Intent) invokeL.objValue;
    }

    public static Uri a(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, file)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
            }
            return Uri.fromFile(file);
        }
        return (Uri) invokeLL.objValue;
    }

    public static PendingIntent e(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) {
            Context context = b.getContext();
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return null;
            }
            return PendingIntent.getActivity(context, i, launchIntentForPackage, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
        }
        return (PendingIntent) invokeLI.objValue;
    }

    public static PendingIntent k(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, downloadTask)) == null) {
            File file = new File(downloadTask.getTargetFilePath());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.addFlags(3);
            Context context = b.getContext();
            Uri a = a(context, file);
            intent.setDataAndType(a, "application/vnd.android.package-archive");
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
                context.grantUriPermission(resolveInfo.activityInfo.packageName, a, 3);
            }
            if (b.aa && (downloadTask.getTag() instanceof DownloadParams) && ((DownloadParams) downloadTask.getTag()).requestInstallPermission) {
                intent = a(intent);
            }
            return PendingIntent.getActivity(context, downloadTask.getId(), intent, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
        }
        return (PendingIntent) invokeL.objValue;
    }
}
