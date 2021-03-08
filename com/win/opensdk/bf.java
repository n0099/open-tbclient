package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.win.opensdk.activitys.H5OpenActivity;
import com.win.opensdk.bd;
import com.win.opensdk.core.Info;
import org.apache.http.HttpHost;
import org.json.JSONException;
/* loaded from: classes14.dex */
public class bf {
    public static boolean a(Context context, Uri uri, Info info) {
        if (context == null || uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if ((info == null || TextUtils.isEmpty(info.getDpl())) && (scheme == null || scheme.equals(HttpHost.DEFAULT_SCHEME_NAME) || scheme.equals("https"))) {
            if ((scheme == null || !scheme.equals(HttpHost.DEFAULT_SCHEME_NAME)) && !scheme.equals("https")) {
            }
            return false;
        }
        if (info != null) {
            try {
                if (!TextUtils.isEmpty(info.getDpl())) {
                    uri = Uri.parse(info.getDpl());
                }
            } catch (Exception e) {
                if (info != null) {
                    ca.iT(context).a(new cd(info), e.getMessage(), 2).a();
                    aw.qkS = false;
                    return false;
                }
                return false;
            }
        }
        cb.k(context, uri);
        if (info != null) {
            ca.iT(context).a(new cd(info), uri.toString(), 0).a();
            aw.qkS = true;
        }
        return true;
    }

    public static boolean a(Info info, long j) {
        return info != null && System.currentTimeMillis() - j > 1000;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str, Info info, cy cyVar, String str2) {
        String open;
        WebView webView;
        cv cvVar;
        if (info != null) {
            try {
                if (info.getOpent() == 3 && TextUtils.isEmpty(str)) {
                    open = info.getOpen();
                    if (info != null && info.getOpent() == 0 && TextUtils.isEmpty(open)) {
                        open = info.getOpen();
                    }
                    if (TextUtils.isEmpty(open)) {
                        try {
                            if (!TextUtils.isEmpty(str2)) {
                                open = v.d(open, 200, str2, info.isHo_c_sw());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if ((info != null ? info.getPs() : 0) != 0) {
                            new ck().a(context, open, info);
                            return;
                        } else if (a(context, Uri.parse(open), info)) {
                            return;
                        } else {
                            if (info.getOpent() == 1) {
                                if (!z.qkE.c) {
                                    if (!TextUtils.isEmpty(info.getDl_name())) {
                                        Toast.makeText(context.getApplicationContext(), context.getString(bd.e.wdownload_start_load) + info.getDl_name(), 0).show();
                                    }
                                    bx iT = ca.iT(context);
                                    cd cdVar = new cd(info);
                                    String open2 = info.getOpen();
                                    try {
                                        iT.qlo = ca.a("wdtr", cdVar);
                                        iT.hD("msg", ca.a(open2));
                                    } catch (JSONException e2) {
                                    }
                                    iT.a();
                                    if (cyVar != null) {
                                        cyVar.qkh = info;
                                        WebView webView2 = cyVar.b;
                                        if (webView2 == null) {
                                            return;
                                        }
                                        webView2.loadUrl(info.getOpen());
                                        webView = cyVar.b;
                                        cvVar = new cv(cyVar);
                                    } else {
                                        cy cyVar2 = new cy(context);
                                        cyVar2.qkh = info;
                                        WebView webView3 = cyVar2.b;
                                        if (webView3 == null) {
                                            return;
                                        }
                                        webView3.loadUrl(info.getOpen());
                                        webView = cyVar2.b;
                                        cvVar = new cv(cyVar2);
                                    }
                                    webView.setDownloadListener(cvVar);
                                    return;
                                }
                                Toast.makeText(context, context.getString(bd.e.wdownload_loading), 1).show();
                                ca.iT(context).a(new cd(info), 5).a();
                                return;
                            }
                            if (info.getOpent() == 3) {
                                Intent intent = new Intent(context, H5OpenActivity.class);
                                info.setOph5Url(open);
                                intent.putExtra("Key_H5OpenActData", info);
                                intent.setFlags(268435456);
                                context.startActivity(intent);
                                return;
                            }
                            cb.i(context, Uri.parse(open));
                            return;
                        }
                    }
                    return;
                }
            } catch (Exception e3) {
                return;
            }
        }
        open = str;
        if (info != null) {
            open = info.getOpen();
        }
        if (TextUtils.isEmpty(open)) {
        }
    }
}
