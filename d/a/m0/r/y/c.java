package d.a.m0.r.y;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.tbadk.browser.TbWebViewActivity;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes3.dex */
public class c extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final a f54025a;

    /* renamed from: b  reason: collision with root package name */
    public WebChromeClient f54026b;

    /* renamed from: c  reason: collision with root package name */
    public q f54027c;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final c f54028a;

        public a(c cVar) {
            this.f54028a = cVar;
        }

        public boolean a(String str, String str2) {
            return !TextUtils.isEmpty(str2) && p.b(str) && str2.startsWith("ctieba://");
        }

        public String b(String str, String str2) {
            return this.f54028a.b(str, str2.substring(9));
        }
    }

    public c() {
        this(null);
    }

    public final String b(String str, String str2) {
        return this.f54027c.p(str, str2);
    }

    public void c(q qVar) {
        this.f54027c = qVar;
    }

    public void d(WebChromeClient webChromeClient) {
        this.f54026b = webChromeClient;
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            return webChromeClient.getDefaultVideoPoster();
        }
        return super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            return webChromeClient.getVideoLoadingProgressView();
        }
        return super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.getVisitedHistory(valueCallback);
        } else {
            super.getVisitedHistory(valueCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.onCloseWindow(webView);
        } else {
            super.onCloseWindow(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onConsoleMessage(String str, int i2, String str2) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.onConsoleMessage(str, i2, str2);
        } else {
            super.onConsoleMessage(str, i2, str2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            return webChromeClient.onCreateWindow(webView, z, z2, message);
        }
        return super.onCreateWindow(webView, z, z2, message);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        } else {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.onGeolocationPermissionsHidePrompt();
        } else {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            return webChromeClient.onJsAlert(webView, str, str2, jsResult);
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            return webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult);
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            return webChromeClient.onJsConfirm(webView, str, str2, jsResult);
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (this.f54025a.a(str, str2)) {
            jsPromptResult.confirm(this.f54025a.b(str, str2));
            return true;
        }
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            return webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            return webChromeClient.onJsTimeout();
        }
        return super.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.onProgressChanged(webView, i2);
        } else {
            super.onProgressChanged(webView, i2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        } else {
            super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.onReceivedIcon(webView, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.onReceivedTitle(webView, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.onReceivedTouchIconUrl(webView, str, z);
        } else {
            super.onReceivedTouchIconUrl(webView, str, z);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.onRequestFocus(webView);
        } else {
            super.onRequestFocus(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view, customViewCallback);
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        if (Build.VERSION.SDK_INT >= 21) {
            boolean z = fileChooserParams.getMode() == 1;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            if (z) {
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            }
            intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
            q qVar = this.f54027c;
            if (qVar != null && (qVar.f() instanceof TbWebViewActivity)) {
                TbWebViewActivity tbWebViewActivity = (TbWebViewActivity) this.f54027c.f();
                tbWebViewActivity.setUploadMessageAboveL(valueCallback);
                tbWebViewActivity.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
            }
            return true;
        }
        return false;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            try {
                webChromeClient.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class).invoke(this.f54026b, valueCallback);
            } catch (IllegalAccessException e2) {
                e.a(e2.getMessage());
            } catch (NoSuchMethodException e3) {
                e.a(e3.getMessage());
            } catch (InvocationTargetException e4) {
                e.a(e4.getMessage());
            } catch (Throwable th) {
                e.a(th.getMessage());
            }
        }
    }

    public c(WebChromeClient webChromeClient) {
        this.f54025a = new a(this);
        this.f54026b = webChromeClient;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            return webChromeClient.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view, i2, customViewCallback);
        } else {
            super.onShowCustomView(view, i2, customViewCallback);
        }
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            try {
                webChromeClient.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class).invoke(this.f54026b, valueCallback, str);
            } catch (IllegalAccessException e2) {
                e.a(e2.getMessage());
            } catch (NoSuchMethodException e3) {
                e.a(e3.getMessage());
            } catch (InvocationTargetException e4) {
                e.a(e4.getMessage());
            } catch (Throwable th) {
                e.a(th.getMessage());
            }
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        WebChromeClient webChromeClient = this.f54026b;
        if (webChromeClient != null) {
            try {
                webChromeClient.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class, String.class).invoke(this.f54026b, valueCallback, str, str2);
            } catch (IllegalAccessException e2) {
                e.a(e2.getMessage());
            } catch (NoSuchMethodException e3) {
                e.a(e3.getMessage());
            } catch (InvocationTargetException e4) {
                e.a(e4.getMessage());
            } catch (Throwable th) {
                e.a(th.getMessage());
            }
        }
    }
}
