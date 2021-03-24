package com.win.opensdk.downloader;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.win.opensdk.G;
import com.win.opensdk.V1;
import com.win.opensdk.Z0;
import com.win.opensdk.a1;
import com.win.opensdk.b1;
import com.win.opensdk.core.Info;
import java.io.File;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class WinDReceiver extends BroadcastReceiver {
    public final void a(Context context, Info info) {
        try {
            File file = new File(G.a(context, info.getOpen()));
            if (file.exists()) {
                file.delete();
                a1.a(context).a(new b1(info), info.getDl_pkg(), info.getDl_vsc(), 2).a();
                ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(232);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        String[] split;
        if (intent.getAction().equals(PackageChangedReceiver.ACTION_INSTALL)) {
            String dataString = intent.getDataString();
            String str = (TextUtils.isEmpty(dataString) || !dataString.contains(":") || (split = dataString.split(":")) == null || split.length <= 0) ? "" : split[1];
            try {
                Info info = (Info) V1.b(context, str);
                if (info == null || TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    z = info.getDl_pkg().equals(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    z = false;
                }
                if (z) {
                    Z0 a2 = a1.a(context);
                    try {
                        a2.f39849b = a1.a("wie", new b1(info));
                        a2.a("co", 200);
                    } catch (JSONException unused) {
                    }
                    a2.a();
                    try {
                        G.a(info, 302, "");
                        if (!TextUtils.isEmpty(info.getVv_ins_urls())) {
                            G.i(info.getVv_ins_urls());
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    a(context, info);
                    a(context, info, str);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public final void a(Context context, Info info, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                Z0 a2 = a1.a(context);
                b1 b1Var = new b1(info);
                String open = info.getOpen();
                try {
                    a2.f39849b = a1.a("wiop", b1Var);
                    a2.a("msg", a1.a(open));
                } catch (JSONException unused) {
                }
                a2.a();
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
                V1.a(context, str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
