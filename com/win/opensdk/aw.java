package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.win.opensdk.activitys.H5OpenActivity;
import com.win.opensdk.core.Info;
import com.win.opensdk.d;
import java.util.HashMap;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public final class aw {
    private static int java = 10;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(final Context context, String str, final Info info, bj bjVar) {
        String open;
        final String open2;
        boolean z = true;
        if (info != null) {
            try {
                if (info.getOpent() == 3 && TextUtils.isEmpty(str)) {
                    open = info.getOpen();
                    open2 = (info == null && info.getOpent() == 0 && TextUtils.isEmpty(open)) ? info.getOpen() : open;
                    if (TextUtils.isEmpty(open2)) {
                        if ((info != null ? info.getPs() : 0) == 0) {
                            if (!a(context, Uri.parse(open2), info)) {
                                if (info.getOpent() == 1) {
                                    if (bu.eHa().pYL) {
                                        Toast.makeText(context, context.getString(d.e.wdownload_loading), 1).show();
                                        if (info != null) {
                                            w.iK(context).a(new x(info), 5).eGz();
                                            return;
                                        }
                                        return;
                                    }
                                    if (info != null && !TextUtils.isEmpty(info.getDl_name())) {
                                        Toast.makeText(context, context.getString(d.e.wdownload_start_load) + info.getDl_name(), 0).show();
                                    }
                                    w.iK(context).d(new x(info), info.getOpen()).eGz();
                                    if (bjVar != null) {
                                        bjVar.a(info);
                                        return;
                                    } else {
                                        new bj(context).a(info);
                                        return;
                                    }
                                }
                                if (info == null || info.getOpent() != 3) {
                                    z = false;
                                }
                                if (!z) {
                                    be.i(context, Uri.parse(open2));
                                    return;
                                }
                                try {
                                    Intent intent = new Intent(context, H5OpenActivity.class);
                                    info.setOph5Url(open2);
                                    intent.putExtra("Key_H5OpenActData", info);
                                    intent.setFlags(268435456);
                                    context.startActivity(intent);
                                    return;
                                } catch (Exception e) {
                                    return;
                                }
                            }
                            return;
                        }
                        final bf eGW = bf.eGW();
                        eGW.pYI = context;
                        eGW.pZd = info;
                        WebView webView = new WebView(context);
                        WebSettings settings = webView.getSettings();
                        settings.setAllowContentAccess(true);
                        settings.setJavaScriptEnabled(true);
                        if (Build.VERSION.SDK_INT >= 11) {
                            webView.removeJavascriptInterface("searchBoxJavaBridge_");
                            webView.removeJavascriptInterface("accessibility");
                            webView.removeJavascriptInterface("accessibilityTraversal");
                        }
                        webView.setWebViewClient(new WebViewClient() { // from class: com.win.opensdk.bf.2
                            private boolean pYL;

                            @Override // android.webkit.WebViewClient
                            public final void onPageStarted(WebView webView2, String str2, Bitmap bitmap) {
                                super.onPageStarted(webView2, str2, bitmap);
                            }

                            @Override // android.webkit.WebViewClient
                            public final boolean shouldOverrideUrlLoading(WebView webView2, String str2) {
                                return Build.VERSION.SDK_INT < 24 ? aaC(str2) : super.shouldOverrideUrlLoading(webView2, str2);
                            }

                            @Override // android.webkit.WebViewClient
                            public final boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                                return Build.VERSION.SDK_INT >= 24 ? aaC(webResourceRequest.getUrl().toString()) : super.shouldOverrideUrlLoading(webView2, webResourceRequest);
                            }

                            private boolean aaC(String str2) {
                                Uri parse = Uri.parse(str2);
                                if (bf.ai(parse) || bf.aj(parse)) {
                                    this.pYL = true;
                                    if (aw.a(context, parse, null)) {
                                        return true;
                                    }
                                    be.i(context, parse);
                                    return true;
                                }
                                return false;
                            }

                            @Override // android.webkit.WebViewClient
                            public final void onPageFinished(WebView webView2, String str2) {
                                super.onPageFinished(webView2, str2);
                                bf.this.pZQ.removeMessages(11);
                                if (!this.pYL) {
                                    w.iK(context).b(new x(info), 2004, str2).eGz();
                                    Message obtain = Message.obtain();
                                    obtain.what = 12;
                                    obtain.obj = open2;
                                    bf.this.pZQ.sendMessage(obtain);
                                }
                            }
                        });
                        HashMap hashMap = new HashMap();
                        hashMap.put("X-Requested-With", "");
                        webView.loadUrl(open2, hashMap);
                        Message obtain = Message.obtain();
                        obtain.what = 11;
                        obtain.obj = open2;
                        eGW.pZQ.sendMessageDelayed(obtain, 5000L);
                        return;
                    }
                    return;
                }
            } catch (Exception e2) {
                return;
            }
        }
        open = str;
        if (info == null) {
        }
        if (TextUtils.isEmpty(open2)) {
        }
    }

    public static void bJ(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(str);
                if (!a(context, parse, null)) {
                    be.i(context, parse);
                }
            }
        } catch (Exception e) {
        }
    }

    public static boolean a(Context context, Uri uri, Info info) {
        if (context == null || uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if ((info != null && !TextUtils.isEmpty(info.getDpl())) || (scheme != null && !scheme.equals(HttpHost.DEFAULT_SCHEME_NAME) && !scheme.equals("https"))) {
            if (info != null) {
                try {
                    if (!TextUtils.isEmpty(info.getDpl())) {
                        uri = Uri.parse(info.getDpl());
                    }
                } catch (Exception e) {
                    if (info != null) {
                        w.iK(context).a(new x(info), e.getMessage(), 2).eGz();
                        a.pYT = false;
                        return false;
                    }
                    return false;
                }
            }
            be.j(context, uri);
            if (info != null) {
                w.iK(context).a(new x(info), uri.toString(), 0).eGz();
                a.pYT = true;
            }
            return true;
        }
        if ((scheme == null || !scheme.equals(HttpHost.DEFAULT_SCHEME_NAME)) && !scheme.equals("https")) {
        }
        return false;
    }

    public static boolean a(Info info, long j) {
        return info != null && System.currentTimeMillis() - j > 1000;
    }
}
