package com.win.opensdk;

import android.content.Context;
import android.content.IntentFilter;
import com.win.opensdk.downloader.WinDReceiver;
import com.win.opensdk.poseidon.PoseidonReceiver;
/* loaded from: classes14.dex */
public class PBInitialize {
    public static void init(Context context, String str) {
        if (context != null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                context.registerReceiver(new PoseidonReceiver(), intentFilter);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter2.addDataScheme("package");
                context.registerReceiver(new WinDReceiver(), intentFilter2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            u.eJa().a(context, str);
            return;
        }
        throw new RuntimeException("Error:Context is not allowed to be null");
    }
}
