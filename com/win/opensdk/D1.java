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
public class D1 implements DownloadListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ E1 f40589a;

    public D1(E1 e1) {
        this.f40589a = e1;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        Info info = this.f40589a.f40600c;
        if (info == null || info.getOpent() != 1 || j <= 10) {
            return;
        }
        E1 e1 = this.f40589a;
        Context context = e1.f40598a;
        Info info2 = e1.f40600c;
        if (!z.e(context)) {
            Toast.makeText(context, context.getString(R.string.win_wdownload_no_netwrok) + info2.getDl_name(), 0).show();
            x0.a(context).b(new y0(info2), 1).a();
            return;
        }
        try {
            if (z.b(context, info2.getOpen()) && z.a(context, info2)) {
                w0 a2 = x0.a(context);
                y0 y0Var = new y0(info2);
                String open = info2.getOpen();
                try {
                    a2.f40940b = x0.a("wii", y0Var);
                    a2.a("msg", x0.a(open));
                } catch (JSONException unused) {
                }
                a2.a();
                z.b(info2, context, z.a(context, info2.getOpen()));
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
                s1.a(context, info2.getDl_pkg(), info2);
                Intent intent = new Intent(context, WDownLoadService.class);
                intent.putExtra("down_load_apk_url", info2.getOpen());
                intent.putExtra("down_load_pkg_name", info2.getDl_pkg());
                context.startService(intent);
            } catch (Exception e3) {
                e3.printStackTrace();
                x0.a(context).b(new y0(info2), 2).a("desc", e3.getMessage()).a();
            }
        }
    }
}
