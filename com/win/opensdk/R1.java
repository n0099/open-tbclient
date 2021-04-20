package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.alibaba.fastjson.asm.Label;
import com.win.opensdk.activitys.H5OpenActivity;
import com.win.opensdk.core.Info;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class R1 {
    public static void a(Context context, String str, Info info, h2 h2Var, String str2) {
        WebView webView;
        g2 g2Var;
        if (info != null) {
            try {
                if (info.getOpent() == 3 && TextUtils.isEmpty(str)) {
                    str = info.getOpen();
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (info != null && info.getOpent() == 0 && TextUtils.isEmpty(str)) {
            str = info.getOpen();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                str = G.a(str, 200, str2, info.isHo_c_sw());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if ((info != null ? info.getPs() : 0) != 0) {
            new d2().a(context, str, info);
        } else if (a(context, Uri.parse(str), info)) {
        } else {
            if (info.getOpent() == 1) {
                if (H.f39963d.f39966c) {
                    Toast.makeText(context, context.getString(R.string.wdownload_loading), 1).show();
                    a1.a(context).b(new b1(info), 5).a();
                    return;
                }
                if (!TextUtils.isEmpty(info.getDl_name())) {
                    Context applicationContext = context.getApplicationContext();
                    Toast.makeText(applicationContext, context.getString(R.string.wdownload_start_load) + info.getDl_name(), 0).show();
                }
                Z0 a2 = a1.a(context);
                b1 b1Var = new b1(info);
                String open = info.getOpen();
                try {
                    a2.f40139b = a1.a("wdtr", b1Var);
                    a2.a("msg", a1.a(open));
                } catch (JSONException unused2) {
                }
                a2.a();
                if (h2Var != null) {
                    h2Var.f40233c = info;
                    WebView webView2 = h2Var.f40232b;
                    if (webView2 == null) {
                        return;
                    }
                    webView2.loadUrl(info.getOpen());
                    webView = h2Var.f40232b;
                    g2Var = new g2(h2Var);
                } else {
                    h2 h2Var2 = new h2(context);
                    h2Var2.f40233c = info;
                    WebView webView3 = h2Var2.f40232b;
                    if (webView3 == null) {
                        return;
                    }
                    webView3.loadUrl(info.getOpen());
                    webView = h2Var2.f40232b;
                    g2Var = new g2(h2Var2);
                }
                webView.setDownloadListener(g2Var);
                return;
            }
            if (info.getOpent() == 3) {
                Intent intent = new Intent(context, H5OpenActivity.class);
                info.setOph5Url(str);
                intent.putExtra("Key_H5OpenActData", info);
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                context.startActivity(intent);
                return;
            }
            a2.a(context, Uri.parse(str));
        }
    }

    public static boolean a(Context context, Uri uri, Info info) {
        if (context != null && uri != null) {
            String scheme = uri.getScheme();
            if ((info != null && !TextUtils.isEmpty(info.getDpl())) || (scheme != null && !scheme.equals("http") && !scheme.equals("https"))) {
                if (info != null) {
                    try {
                        if (!TextUtils.isEmpty(info.getDpl())) {
                            uri = Uri.parse(info.getDpl());
                        }
                    } catch (Exception e2) {
                        if (info != null) {
                            a1.a(context).a(new b1(info), e2.getMessage(), 2).a();
                            PBSplash.isdpl = false;
                        }
                        return false;
                    }
                }
                a2.b(context, uri);
                if (info != null) {
                    a1.a(context).a(new b1(info), uri.toString(), 0).a();
                    PBSplash.isdpl = true;
                }
                return true;
            } else if ((scheme == null || !scheme.equals("http")) && scheme.equals("https")) {
            }
        }
        return false;
    }

    public static boolean a(Info info, long j) {
        return info != null && System.currentTimeMillis() - j > 1000;
    }
}
