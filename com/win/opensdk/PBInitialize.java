package com.win.opensdk;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.win.opensdk.downloader.WinDReceiver;
/* loaded from: classes7.dex */
public class PBInitialize {
    public static void init(Context context, String str) {
        if (context == null) {
            throw new RuntimeException("Error:Context is not allowed to be null");
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
            context.registerReceiver(new WinDReceiver(), intentFilter);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c1.a().a(context, str);
    }
}
