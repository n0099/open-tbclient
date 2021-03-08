package com.win.opensdk.downloader;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.win.opensdk.bp;
import com.win.opensdk.bx;
import com.win.opensdk.ca;
import com.win.opensdk.cd;
import com.win.opensdk.core.Info;
import com.win.opensdk.v;
import java.io.File;
import org.json.JSONException;
/* loaded from: classes14.dex */
public class WinDReceiver extends BroadcastReceiver {
    public final void a(Context context, Info info) {
        try {
            File file = new File(v.a(context, info.getOpen()));
            if (file.exists()) {
                file.delete();
                ca.iT(context).a(new cd(info), info.getDl_pkg(), info.getDl_vsc(), 2).a();
                ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(232);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        String[] split;
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            String dataString = intent.getDataString();
            String str = (TextUtils.isEmpty(dataString) || !dataString.contains(":") || (split = dataString.split(":")) == null || split.length <= 0) ? "" : split[1];
            try {
                Info info = (Info) bp.b(context, str);
                if (info == null || TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    z = info.getDl_pkg().equals(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    z = false;
                }
                if (z) {
                    bx iT = ca.iT(context);
                    try {
                        iT.qlo = ca.a("wie", new cd(info));
                        iT.P(BdStatsConstant.StatsKey.COUNT, 200);
                    } catch (JSONException e2) {
                    }
                    iT.a();
                    try {
                        v.a(info, 302, "");
                        if (!TextUtils.isEmpty(info.getVv_ins_urls())) {
                            v.i(info.getVv_ins_urls());
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
                bx iT = ca.iT(context);
                cd cdVar = new cd(info);
                String open = info.getOpen();
                try {
                    iT.qlo = ca.a("wiop", cdVar);
                    iT.hD("msg", ca.a(open));
                } catch (JSONException e) {
                }
                iT.a();
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
                bp.a(context, str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
