package com.kascend.chushou.widget.cswebview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.swan.apps.core.container.NgWebView;
import com.google.android.exoplayer2.Format;
import java.util.List;
/* loaded from: classes4.dex */
public class SimpleWebview extends WebView implements View.OnLongClickListener, DownloadListener {
    public SimpleWebview(Context context) {
        super(context);
        c();
    }

    public SimpleWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    private void c() {
        a();
        setDownloadListener(this);
        setOnLongClickListener(this);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        if (Build.VERSION.SDK_INT < 23) {
            setLayerType(1, null);
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a() {
        Context context = getContext();
        WebSettings settings = getSettings();
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportMultipleWindows(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setTextZoom(100);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(Format.OFFSET_SAMPLE_RELATIVE);
        settings.setAppCachePath(context.getDir(NgWebView.APP_CACHE_PATH, 0).getPath());
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabasePath(context.getDir(NgWebView.APP_DATABASE_PATH, 0).getPath());
        CookieSyncManager.createInstance(context);
        CookieSyncManager.getInstance().sync();
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        onResume();
        resumeTimers();
        super.loadUrl(str);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        WebView.HitTestResult hitTestResult = getHitTestResult();
        if (hitTestResult.getType() == 5 || hitTestResult.getType() == 8) {
            String extra = hitTestResult.getExtra();
            if (TextUtils.isEmpty(extra)) {
                return true;
            }
            a(view.getContext(), extra);
            return true;
        }
        return false;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                context.startActivity(intent);
            }
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        stopLoading();
        getSettings().setJavaScriptEnabled(false);
        clearHistory();
        removeAllViews();
        ViewParent parent = getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this);
        }
        super.destroy();
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        reload();
    }

    protected void a(Context context, String str) {
    }
}
