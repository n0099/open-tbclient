package com.qq.e.comm.plugin.ab.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends WebView implements a {

    /* renamed from: a  reason: collision with root package name */
    private final e f11808a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11809b;

    public i(final Context context, WebViewClient webViewClient, h hVar, JSONObject jSONObject) {
        super(context);
        this.f11808a = new e(this, jSONObject);
        try {
            WebSettings settings = getSettings();
            settings.setUserAgentString(settings.getUserAgentString() + " GDTMobSDK/" + SDKStatus.getSDKVersion() + "." + GDTADManager.getInstance().getPM().getPluginVersion());
            settings.setJavaScriptEnabled(true);
            if (webViewClient != null) {
                if (webViewClient instanceof com.qq.e.comm.plugin.ab.d.i) {
                    ((com.qq.e.comm.plugin.ab.d.i) webViewClient).a(this.f11808a);
                }
                setWebViewClient(webViewClient);
            }
            if (hVar != null) {
                hVar.a(this.f11808a);
                setWebChromeClient(hVar);
            } else {
                h hVar2 = new h();
                hVar2.a(this.f11808a);
                setWebChromeClient(hVar2);
            }
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
            settings.setMixedContentMode(0);
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
            setDownloadListener(new DownloadListener() { // from class: com.qq.e.comm.plugin.ab.f.i.1
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
        } catch (Throwable th) {
            GDTLogger.e("X5WebView set up failed !", th);
        }
        resumeTimers();
    }

    @Override // com.qq.e.comm.plugin.ab.k
    public void b(String str) {
        evaluateJavascript(str, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.qq.e.comm.plugin.ab.f.i */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.comm.plugin.ab.f.a
    public View c() {
        return this;
    }

    @Override // com.qq.e.comm.plugin.ab.f.a
    public e d() {
        return this.f11808a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.qq.e.comm.plugin.ab.f.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void destroy() {
        if (this.f11809b) {
            return;
        }
        loadUrl("about:blank");
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
        removeAllViews();
        super.destroy();
        this.f11809b = true;
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.f11808a.a(new com.qq.e.comm.plugin.ab.b.b("onPageShown", null));
            GDTLogger.d("onPageShown");
            return;
        }
        this.f11808a.a(new com.qq.e.comm.plugin.ab.b.b("onPageHidden", null));
        GDTLogger.d("onPageHidden");
    }
}
