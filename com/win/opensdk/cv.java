package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.widget.Toast;
import com.win.opensdk.bd;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
import org.json.JSONException;
/* loaded from: classes14.dex */
public class cv implements DownloadListener {
    public final /* synthetic */ cy qlD;

    public cv(cy cyVar) {
        this.qlD = cyVar;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        Info info = this.qlD.qkh;
        if (info != null && info.getOpent() == 1 && j > 10) {
            cy cyVar = this.qlD;
            Context context = cyVar.f8149a;
            Info info2 = cyVar.qkh;
            if (v.g(context)) {
                try {
                    if (v.b(context, info2.getOpen()) && v.b(context, info2)) {
                        bx iT = ca.iT(context);
                        cd cdVar = new cd(info2);
                        String open = info2.getOpen();
                        try {
                            iT.qlo = ca.a("wii", cdVar);
                            iT.hD("msg", ca.a(open));
                        } catch (JSONException e) {
                        }
                        iT.a();
                        v.a(info2, context, v.a(context, info2.getOpen()));
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (info2 != null) {
                    try {
                        if (!TextUtils.isEmpty(info2.getOpen())) {
                            bp.b(context, info2.getDl_pkg(), info2);
                            Intent intent = new Intent(context, WDownLoadService.class);
                            intent.putExtra("down_load_apk_url", info2.getOpen());
                            intent.putExtra("down_load_pkg_name", info2.getDl_pkg());
                            context.startService(intent);
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        ca.iT(context).a(new cd(info2), 2).hD("desc", e3.getMessage()).a();
                        return;
                    }
                }
                return;
            }
            Toast.makeText(context, context.getString(bd.e.wdownload_no_netwrok) + info2.getDl_name(), 0).show();
            ca.iT(context).a(new cd(info2), 1).a();
        }
    }
}
