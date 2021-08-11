package com.ksad.download;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.api.core.fragment.FileProvider;
import java.io.File;
/* loaded from: classes10.dex */
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
            Context a2 = b.a();
            Uri a3 = a(a2, file);
            intent.setDataAndType(a3, "application/vnd.android.package-archive");
            for (ResolveInfo resolveInfo : a2.getPackageManager().queryIntentActivities(intent, 65536)) {
                a2.grantUriPermission(resolveInfo.activityInfo.packageName, a3, 3);
            }
            return PendingIntent.getActivity(a2, downloadTask.getId(), intent, 134217728);
        }
        return (PendingIntent) invokeL.objValue;
    }

    public static PendingIntent a(File file, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, file, i2)) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.addFlags(3);
            Context a2 = b.a();
            Uri a3 = a(a2, file);
            intent.setDataAndType(a3, "application/vnd.android.package-archive");
            for (ResolveInfo resolveInfo : a2.getPackageManager().queryIntentActivities(intent, 65536)) {
                a2.grantUriPermission(resolveInfo.activityInfo.packageName, a3, 3);
            }
            return PendingIntent.getActivity(a2, i2, intent, 134217728);
        }
        return (PendingIntent) invokeLI.objValue;
    }

    public static PendingIntent a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            Context a2 = b.a();
            Intent launchIntentForPackage = a2.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return null;
            }
            return PendingIntent.getActivity(a2, i2, launchIntentForPackage, 134217728);
        }
        return (PendingIntent) invokeLI.objValue;
    }

    public static Uri a(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, file)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
            }
            return Uri.fromFile(file);
        }
        return (Uri) invokeLL.objValue;
    }
}
