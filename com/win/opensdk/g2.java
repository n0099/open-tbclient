package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.widget.Toast;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class g2 implements DownloadListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h2 f39937a;

    public g2(h2 h2Var) {
        this.f39937a = h2Var;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        Info info = this.f39937a.f39943c;
        if (info == null || info.getOpent() != 1 || j <= 10) {
            return;
        }
        h2 h2Var = this.f39937a;
        Context context = h2Var.f39941a;
        Info info2 = h2Var.f39943c;
        if (!G.g(context)) {
            Toast.makeText(context, context.getString(R.string.wdownload_no_netwrok) + info2.getDl_name(), 0).show();
            a1.a(context).b(new b1(info2), 1).a();
            return;
        }
        try {
            if (G.b(context, info2.getOpen()) && G.a(context, info2)) {
                Z0 a2 = a1.a(context);
                b1 b1Var = new b1(info2);
                String open = info2.getOpen();
                try {
                    a2.f39849b = a1.a("wii", b1Var);
                    a2.a("msg", a1.a(open));
                } catch (JSONException unused) {
                }
                a2.a();
                G.b(info2, context, G.a(context, info2.getOpen()));
                return;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (info2 != null) {
            try {
                if (TextUtils.isEmpty(info2.getOpen())) {
                    return;
                }
                V1.a(context, info2.getDl_pkg(), info2);
                Intent intent = new Intent(context, WDownLoadService.class);
                intent.putExtra("down_load_apk_url", info2.getOpen());
                intent.putExtra("down_load_pkg_name", info2.getDl_pkg());
                context.startService(intent);
            } catch (Exception e3) {
                e3.printStackTrace();
                a1.a(context).b(new b1(info2), 2).a("desc", e3.getMessage()).a();
            }
        }
    }
}
