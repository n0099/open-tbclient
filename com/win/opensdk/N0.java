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
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
/* loaded from: classes7.dex */
public class N0 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public C0 f39725a;

    /* renamed from: b  reason: collision with root package name */
    public F0 f39726b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39727c;

    public N0(C0 c0, F0 f0) {
        this.f39725a = c0;
        this.f39726b = f0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ed, code lost:
        r8 = r8.getWindow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f1, code lost:
        if (r8 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fc, code lost:
        if ((r8.getAttributes().flags & 16777216) == 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fe, code lost:
        r8 = true;
     */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPageFinished(WebView webView, String str) {
        C2 c2;
        F0 f0;
        I0 i0;
        C0 c0;
        super.onPageFinished(webView, str);
        if (this.f39727c) {
            return;
        }
        C0 c02 = this.f39725a;
        if (c02 != null && (f0 = this.f39726b) != null && (c0 = (i0 = (I0) f0).f39678a) != null && !i0.f39680c) {
            String str2 = c0.getMraidMideaType() == K0.BANNER ? "inline" : "interstitial";
            i0.f39679b = c02.getMraidState().equals(L0.STATE_EXPANDED);
            G.a(c02, "javascript:window.mraidbridge.setPlacementType('" + str2 + "')");
            if (!i0.f39679b) {
                if (i0.f39678a != null) {
                    boolean a2 = i0.a(new Intent("android.intent.action.VIEW", Uri.parse("sms:11035000")));
                    boolean a3 = i0.a(new Intent("android.intent.action.VIEW", Uri.parse("tel:11035000")));
                    boolean z = Build.VERSION.SDK_INT >= 14 && (i0.a(new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI)) || i0.a(new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event")));
                    boolean z2 = i0.f39678a.getContext().getPackageManager().checkPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION, i0.f39678a.getContext().getPackageName()) == 0 && Build.VERSION.SDK_INT >= 11;
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
                    } catch (Exception unused) {
                    }
                    boolean z3 = false;
                    C0 c03 = i0.f39678a;
                    G.a(c03, "javascript:window.mraidbridge.setSupports(" + a2 + "," + a3 + "," + z + "," + z2 + "," + z3 + SmallTailInfo.EMOTION_SUFFIX);
                }
                i0.c();
                i0.b();
                C0 c04 = i0.f39678a;
                if (c04 != null) {
                    try {
                        int[] iArr = new int[2];
                        c04.getLocationOnScreen(iArr);
                        iArr[1] = iArr[1] - (i0.f39678a.getViewContext() instanceof Activity ? ((Activity) i0.f39678a.getViewContext()).getWindow().findViewById(16908290).getTop() : 0);
                        i0.f39678a.measure(0, 0);
                        int[] iArr2 = {i0.f39678a.getMeasuredWidth(), i0.f39678a.getMeasuredHeight()};
                        G.a(i0.f39678a.getViewContext(), iArr2);
                        C0 c05 = i0.f39678a;
                        int i = iArr[0];
                        int i2 = iArr[1];
                        int i3 = iArr2[0];
                        int i4 = iArr2[1];
                        G.a(c05, "javascript:window.mraidbridge.setDefaultPosition(" + i + "," + i2 + "," + i3 + "," + i4 + SmallTailInfo.EMOTION_SUFFIX);
                    } catch (Exception unused2) {
                    }
                }
            }
            i0.f39678a.a();
            i0.a(c02, c02.getMraidState());
            G.a(c02, "javascript:window.mraidbridge.notifyReadyEvent()");
            i0.f39680c = true;
            i0.a(i0.f39678a.g());
        }
        if (!((I0) this.f39726b).f39679b) {
            A0 a0 = (A0) this.f39725a.getDispatcher();
            a0.f39614a.h();
            J0 j0 = a0.f39614a.o;
            if (j0 != null && (c2 = ((R0) j0).f39783c) != null) {
                c2.onLoaded();
            }
        }
        this.f39727c = true;
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
                    return new WebResourceResponse("text/javascript", "utf-8", webView.getResources().openRawResource(R.raw.mraid));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                if (str.contains("mraid.js") && Build.VERSION.SDK_INT >= 12) {
                    return new WebResourceResponse("text/javascript", "utf-8", webView.getResources().openRawResource(R.raw.mraid));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return super.shouldInterceptRequest(webView, str);
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
                F0 f0 = this.f39726b;
                if (f0 != null) {
                    ((I0) f0).a(uri, this.f39725a.e());
                }
                C0 c0 = this.f39725a;
                G.a(c0, "javascript:window.mraidbridge.nativeCallComplete('" + host + "')");
                return true;
            }
            F0 f02 = this.f39726b;
            if (f02 != null) {
                return ((I0) f02).a(uri);
            }
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (Build.VERSION.SDK_INT < 24) {
            if (!TextUtils.isEmpty(str) && !str.startsWith("javascript:")) {
                if ("mraid".equals(Uri.parse(str).getScheme())) {
                    F0 f0 = this.f39726b;
                    if (f0 != null) {
                        ((I0) f0).a(str, this.f39725a.e());
                        return true;
                    }
                    return true;
                }
                F0 f02 = this.f39726b;
                if (f02 != null) {
                    return ((I0) f02).a(str);
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
