package com.kwad.components.core.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.InstalledAppInfoManager;
/* loaded from: classes8.dex */
public final class a extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
            return;
        }
        if (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            if (!TextUtils.equals(PackageChangedReceiver.ACTION_UNINSTALL, intent.getAction()) || intent.getData() == null) {
                return;
            }
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            InstalledAppInfoManager.AppPackageInfo appPackageInfo = new InstalledAppInfoManager.AppPackageInfo();
            appPackageInfo.packageName = schemeSpecificPart;
            com.kwad.components.core.j.a.og().e(InstalledAppInfoManager.a(appPackageInfo), 2);
            com.kwad.sdk.core.e.b.d("APPInstalledChangerReceiver", "uninstalled packageName :" + schemeSpecificPart);
        } else if (intent.getData() != null) {
            String schemeSpecificPart2 = intent.getData().getSchemeSpecificPart();
            if (TextUtils.isEmpty(schemeSpecificPart2)) {
                return;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(schemeSpecificPart2, 0);
                if (packageInfo == null) {
                    return;
                }
                com.kwad.components.core.j.a.og().e(InstalledAppInfoManager.a(InstalledAppInfoManager.a(packageInfo, packageManager)), 1);
                com.kwad.sdk.core.e.b.d("APPInstalledChangerReceiver", "installed packageName :" + schemeSpecificPart2);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            }
        }
    }
}
