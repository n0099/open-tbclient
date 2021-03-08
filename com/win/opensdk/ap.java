package com.win.opensdk;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.win.opensdk.bd;
/* loaded from: classes14.dex */
public class ap extends WebViewClient {
    public boolean c;
    public C0 qkf;
    public t qkq;

    public ap(C0 c0, t tVar) {
        this.qkf = c0;
        this.qkq = tVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0195, code lost:
        r1 = r1.getWindow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0199, code lost:
        if (r1 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01a4, code lost:
        if ((r1.getAttributes().flags & 16777216) == 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01a6, code lost:
        r1 = true;
     */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPageFinished(WebView webView, String str) {
        m mVar;
        t tVar;
        ad adVar;
        C0 c0;
        int[] iArr;
        super.onPageFinished(webView, str);
        if (this.c) {
            return;
        }
        C0 c02 = this.qkf;
        if (c02 != null && (tVar = this.qkq) != null && (c0 = (adVar = (ad) tVar).qkf) != null && !adVar.c) {
            String str2 = c0.getMraidMideaType() == K0.BANNER ? "inline" : "interstitial";
            adVar.b = c02.getMraidState().equals(L0.STATE_EXPANDED);
            v.a(c02, "javascript:window.mraidbridge.setPlacementType('" + str2 + "')");
            if (!adVar.b) {
                if (adVar.qkf != null) {
                    boolean a2 = adVar.a(new Intent("android.intent.action.VIEW", Uri.parse("sms:11035000")));
                    boolean a3 = adVar.a(new Intent("android.intent.action.VIEW", Uri.parse("tel:11035000")));
                    boolean z = Build.VERSION.SDK_INT >= 14 && (adVar.a(new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI)) || adVar.a(new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event")));
                    boolean z2 = adVar.qkf.getContext().getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", adVar.qkf.getContext().getPackageName()) == 0 && Build.VERSION.SDK_INT >= 11;
                    try {
                        Activity activity = (Activity) c02.getViewContext();
                        View view = c02;
                        while (true) {
                            if (!view.isHardwareAccelerated() || (view.getLayerType() & 1) != 0) {
                                break;
                            } else if (!(view.getParent() instanceof View)) {
                                break;
                            } else {
                                view = (View) view.getParent();
                            }
                        }
                    } catch (Exception e) {
                    }
                    boolean z3 = false;
                    v.a(adVar.qkf, "javascript:window.mraidbridge.setSupports(" + a2 + "," + a3 + "," + z + "," + z2 + "," + z3 + ")");
                }
                adVar.c();
                adVar.b();
                C0 c03 = adVar.qkf;
                if (c03 != null) {
                    try {
                        int[] iArr2 = new int[2];
                        c03.getLocationOnScreen(iArr2);
                        iArr2[1] = iArr2[1] - (adVar.qkf.getViewContext() instanceof Activity ? ((Activity) adVar.qkf.getViewContext()).getWindow().findViewById(16908290).getTop() : 0);
                        adVar.qkf.measure(0, 0);
                        v.b(adVar.qkf.getViewContext(), new int[]{adVar.qkf.getMeasuredWidth(), adVar.qkf.getMeasuredHeight()});
                        v.a(adVar.qkf, "javascript:window.mraidbridge.setDefaultPosition(" + iArr2[0] + "," + iArr2[1] + "," + iArr[0] + "," + iArr[1] + ")");
                    } catch (Exception e2) {
                    }
                }
            }
            adVar.qkf.a();
            adVar.a(c02, c02.getMraidState());
            v.a(c02, "javascript:window.mraidbridge.notifyReadyEvent()");
            adVar.c = true;
            adVar.a(adVar.qkf.g());
        }
        if (!((ad) this.qkq).b) {
            e eVar = (e) this.qkf.getDispatcher();
            eVar.qkf.h();
            ag agVar = eVar.qkf.qkt;
            if (agVar != null && (mVar = ((be) agVar).qkZ) != null) {
                mVar.onLoaded();
            }
        }
        this.c = true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                if (webResourceRequest.getUrl().toString().contains("mraid.js") && Build.VERSION.SDK_INT >= 12) {
                    return new WebResourceResponse("text/javascript", "utf-8", webView.getResources().openRawResource(bd.d.mraid));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                if (str.contains("mraid.js") && Build.VERSION.SDK_INT >= 12) {
                    return new WebResourceResponse("text/javascript", "utf-8", webView.getResources().openRawResource(bd.d.mraid));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (Build.VERSION.SDK_INT < 24) {
            if (!TextUtils.isEmpty(str) && !str.startsWith("javascript:")) {
                if ("mraid".equals(Uri.parse(str).getScheme())) {
                    t tVar = this.qkq;
                    if (tVar != null) {
                        ((ad) tVar).a(str, this.qkf.e());
                    }
                    return true;
                }
                t tVar2 = this.qkq;
                if (tVar2 != null) {
                    return ((ad) tVar2).a(str);
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT >= 24) {
            Uri url = webResourceRequest.getUrl();
            String uri = url.toString();
            String scheme = url.getScheme();
            String host = url.getHost();
            webResourceRequest.getUrl().getQueryParameter("url");
            if (uri.startsWith("javascript")) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            if ("mraid".equals(scheme)) {
                t tVar = this.qkq;
                if (tVar != null) {
                    ((ad) tVar).a(uri, this.qkf.e());
                }
                v.a(this.qkf, "javascript:window.mraidbridge.nativeCallComplete('" + host + "')");
                return true;
            }
            t tVar2 = this.qkq;
            if (tVar2 != null) {
                return ((ad) tVar2).a(uri);
            }
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
