package com.ksad.download;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.fragment.FileProvider;
import com.kwad.sdk.core.download.DownloadParams;
import java.io.File;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PendingIntent a(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, downloadTask)) == null) {
            File file = new File(downloadTask.getTargetFilePath());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.addFlags(3);
            Context a = b.a();
            Uri a2 = a(a, file);
            intent.setDataAndType(a2, "application/vnd.android.package-archive");
            for (ResolveInfo resolveInfo : a.getPackageManager().queryIntentActivities(intent, 65536)) {
                a.grantUriPermission(resolveInfo.activityInfo.packageName, a2, 3);
            }
            if (KsAdSDKImpl.get().isEnableInstallPermission() && (downloadTask.getTag() instanceof DownloadParams) && ((DownloadParams) downloadTask.getTag()).requestInstallPermission) {
                intent = a(intent);
            }
            return PendingIntent.getActivity(a, downloadTask.getId(), intent, 134217728);
        }
        return (PendingIntent) invokeL.objValue;
    }

    public static PendingIntent a(File file, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{file, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.addFlags(3);
            Context a = b.a();
            Uri a2 = a(a, file);
            intent.setDataAndType(a2, "application/vnd.android.package-archive");
            for (ResolveInfo resolveInfo : a.getPackageManager().queryIntentActivities(intent, 65536)) {
                a.grantUriPermission(resolveInfo.activityInfo.packageName, a2, 3);
            }
            if (z && KsAdSDKImpl.get().isEnableInstallPermission()) {
                intent = a(intent);
            }
            return PendingIntent.getActivity(a, i2, intent, 134217728);
        }
        return (PendingIntent) invokeCommon.objValue;
    }

    public static PendingIntent a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            Context a = b.a();
            Intent launchIntentForPackage = a.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return null;
            }
            return PendingIntent.getActivity(a, i2, launchIntentForPackage, 134217728);
        }
        return (PendingIntent) invokeLI.objValue;
    }

    public static Intent a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, intent)) == null) {
            Intent intent2 = new Intent("intent.action.requestInstallPermission");
            intent2.putExtra("fromNotification", true);
            intent2.putExtra("pendingIntent", intent);
            intent2.addFlags(268435456);
            return intent2;
        }
        return (Intent) invokeL.objValue;
    }

    public static Uri a(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, file)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
            }
            return Uri.fromFile(file);
        }
        return (Uri) invokeLL.objValue;
    }
}
