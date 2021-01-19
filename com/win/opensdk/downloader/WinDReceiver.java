package com.win.opensdk.downloader;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.util.io.ActionJsonData;
import com.win.opensdk.az;
import com.win.opensdk.bv;
import com.win.opensdk.core.Info;
import com.win.opensdk.w;
import com.win.opensdk.x;
import com.win.opensdk.z;
import java.io.File;
/* loaded from: classes3.dex */
public class WinDReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        String[] split;
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString) && dataString.contains(":") && (split = dataString.split(":")) != null && split.length > 0) {
                str = split[1];
            } else {
                str = "";
            }
            try {
                Info info = (Info) az.bM(context, str);
                if (info != null && !TextUtils.isEmpty(str) && java(info, str)) {
                    w.iK(context).b(new x(info)).eGz();
                    try {
                        z.a(info, 302);
                        if (info != null && !TextUtils.isEmpty(info.getVv_ins_urls())) {
                            z.aaE(info.getVv_ins_urls());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        File file = new File(bv.bO(context, info.getOpen()));
                        if (file.exists()) {
                            file.delete();
                            w.iK(context).a(new x(info), info.getDl_pkg(), info.getDl_vsc(), 2).eGz();
                            ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(232);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                        if (launchIntentForPackage != null) {
                            w.iK(context).f(new x(info), info.getOpen()).eGz();
                            launchIntentForPackage.setFlags(268435456);
                            context.startActivity(launchIntentForPackage);
                            az.f(context, str);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    private static boolean java(Info info, String str) {
        if (info != null) {
            try {
                return info.getDl_pkg().equals(str);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
