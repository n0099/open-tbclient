package com.qq.e.comm.plugin.ab.f;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class c extends WebView implements a {

    /* renamed from: a  reason: collision with root package name */
    private final e f11789a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11790b;

    public c(final Context context, WebViewClient webViewClient, b bVar, JSONObject jSONObject) {
        super(a(context));
        this.f11789a = new e(this, jSONObject);
        WebSettings settings = getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + " GDTMobSDK/" + SDKStatus.getSDKVersion() + "." + GDTADManager.getInstance().getPM().getPluginVersion());
        settings.setJavaScriptEnabled(true);
        if (webViewClient != null) {
            if (webViewClient instanceof com.qq.e.comm.plugin.ab.d.d) {
                ((com.qq.e.comm.plugin.ab.d.d) webViewClient).a(this.f11789a);
            }
            setWebViewClient(webViewClient);
        }
        if (bVar != null) {
            bVar.a(this.f11789a);
            setWebChromeClient(bVar);
        } else {
            b bVar2 = new b();
            bVar2.a(this.f11789a);
            setWebChromeClient(bVar2);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getSettings().setMixedContentMode(0);
        }
        setInitialScale(100);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        String absolutePath = ah.a(getContext()).getAbsolutePath();
        settings.setAllowFileAccess(true);
        settings.setAppCachePath(absolutePath);
        settings.setAppCacheMaxSize(8388608L);
        settings.setAppCacheEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(false);
        settings.setSaveFormData(false);
        File b2 = ah.b(getContext());
        if (!b2.exists()) {
            b2.mkdirs();
        }
        String absolutePath2 = b2.getAbsolutePath();
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(absolutePath2);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(absolutePath2);
        setDownloadListener(new DownloadListener() { // from class: com.qq.e.comm.plugin.ab.f.c.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                if (intent.resolveActivity(GDTADManager.getInstance().getAppContext().getPackageManager()) != null) {
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    context.startActivity(intent);
                }
            }
        });
        resumeTimers();
    }

    @TargetApi(22)
    private static Context a(Context context) {
        return (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22) ? context.createConfigurationContext(new Configuration()) : context;
    }

    @Override // com.qq.e.comm.plugin.ab.k
    public void b(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            evaluateJavascript(str, null);
        } else {
            loadUrl("javascript:" + str);
        }
    }

    @Override // com.qq.e.comm.plugin.ab.f.a
    public View c() {
        return this;
    }

    @Override // com.qq.e.comm.plugin.ab.f.a
    public e d() {
        return this.f11789a;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.f11790b) {
            return;
        }
        loadUrl("about:blank");
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
        removeAllViews();
        super.destroy();
        this.f11790b = true;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.f11789a.a(new com.qq.e.comm.plugin.ab.b.b("onPageShown", null));
            GDTLogger.d("onPageShown");
            return;
        }
        this.f11789a.a(new com.qq.e.comm.plugin.ab.b.b("onPageHidden", null));
        GDTLogger.d("onPageHidden");
    }
}
