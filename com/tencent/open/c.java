package com.tencent.open;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.qq.e.comm.constants.Constants;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a;
import com.tencent.open.a.f;
import com.tencent.open.c.a;
import com.tencent.open.utils.g;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends com.tencent.open.b implements a.InterfaceC0466a {

    /* renamed from: c  reason: collision with root package name */
    public static Toast f36492c;

    /* renamed from: d  reason: collision with root package name */
    public String f36493d;

    /* renamed from: e  reason: collision with root package name */
    public IUiListener f36494e;

    /* renamed from: f  reason: collision with root package name */
    public C0467c f36495f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f36496g;

    /* renamed from: h  reason: collision with root package name */
    public com.tencent.open.c.a f36497h;

    /* renamed from: i  reason: collision with root package name */
    public com.tencent.open.c.b f36498i;
    public WeakReference<Context> j;
    public int k;

    /* loaded from: classes7.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            c.this.f36498i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            f.a("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            c.this.f36495f.onError(new UiError(i2, str, str2));
            if (c.this.j != null && c.this.j.get() != null) {
                Toast.makeText((Context) c.this.j.get(), "网络连接异常或系统错误", 0).show();
            }
            c.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            f.a("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(g.a().a((Context) c.this.j.get(), "auth://tauth.qq.com/"))) {
                c.this.f36495f.onComplete(j.c(str));
                c.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                c.this.f36495f.onCancel();
                c.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CLOSE_URI)) {
                c.this.dismiss();
                return true;
            } else {
                return false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends a.b {
        public b() {
        }
    }

    /* renamed from: com.tencent.open.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0467c implements IUiListener {

        /* renamed from: a  reason: collision with root package name */
        public String f36508a;

        /* renamed from: b  reason: collision with root package name */
        public String f36509b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<Context> f36510c;

        /* renamed from: d  reason: collision with root package name */
        public String f36511d;

        /* renamed from: e  reason: collision with root package name */
        public IUiListener f36512e;

        public C0467c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f36510c = new WeakReference<>(context);
            this.f36511d = str;
            this.f36508a = str2;
            this.f36509b = str3;
            this.f36512e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f36512e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f36512e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            com.tencent.open.b.g a2 = com.tencent.open.b.g.a();
            a2.a(this.f36511d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.f36508a, false);
            IUiListener iUiListener = this.f36512e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f36512e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f36508a;
            } else {
                str = this.f36508a;
            }
            com.tencent.open.b.g a2 = com.tencent.open.b.g.a();
            a2.a(this.f36511d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f36512e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f36512e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            try {
                onComplete(j.d(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                onError(new UiError(-4, com.tencent.connect.common.Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends Handler {

        /* renamed from: b  reason: collision with root package name */
        public C0467c f36514b;

        public d(C0467c c0467c, Looper looper) {
            super(looper);
            this.f36514b = c0467c;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.b("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.f36514b.a((String) message.obj);
            } else if (i2 == 2) {
                this.f36514b.onCancel();
            } else if (i2 != 3) {
                if (i2 != 5 || c.this.j == null || c.this.j.get() == null) {
                    return;
                }
                c.d((Context) c.this.j.get(), (String) message.obj);
            } else if (c.this.j == null || c.this.j.get() == null) {
            } else {
                c.c((Context) c.this.j.get(), (String) message.obj);
            }
        }
    }

    public c(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.j = new WeakReference<>(context);
        this.f36493d = str2;
        this.f36495f = new C0467c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f36496g = new d(this.f36495f, context.getMainLooper());
        this.f36494e = iUiListener;
        this.k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        f.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.k);
    }

    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d2 = j.d(str);
            d2.getInt("action");
            d2.getString("msg");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        this.f36498i.setVerticalScrollBarEnabled(false);
        this.f36498i.setHorizontalScrollBarEnabled(false);
        this.f36498i.setWebViewClient(new a());
        this.f36498i.setWebChromeClient(this.f36453b);
        this.f36498i.clearFormData();
        WebSettings settings = this.f36498i.getSettings();
        if (settings == null) {
            return;
        }
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        WeakReference<Context> weakReference = this.j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.j.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f36452a.a(new b(), "sdk_js_if");
        this.f36498i.clearView();
        this.f36498i.loadUrl(this.f36493d);
        this.f36498i.getSettings().setSavePassword(false);
    }

    private void b() {
        com.tencent.open.c.a aVar = new com.tencent.open.c.a(this.j.get());
        this.f36497h = aVar;
        aVar.setBackgroundColor(1711276032);
        this.f36497h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.j.get());
        this.f36498i = bVar;
        bVar.setBackgroundColor(0);
        this.f36498i.setBackgroundDrawable(null);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f36498i, 1, new Paint());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.k);
        layoutParams.addRule(13, -1);
        this.f36498i.setLayoutParams(layoutParams);
        this.f36497h.addView(this.f36498i);
        this.f36497h.a(this);
        setContentView(this.f36497h);
    }

    @Override // com.tencent.open.c.a.InterfaceC0466a
    public void a(int i2) {
        WeakReference<Context> weakReference = this.j;
        if (weakReference != null && weakReference.get() != null) {
            if (i2 < this.k && 2 == this.j.get().getResources().getConfiguration().orientation) {
                this.f36498i.getLayoutParams().height = i2;
            } else {
                this.f36498i.getLayoutParams().height = this.k;
            }
        }
        f.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.c.a.InterfaceC0466a
    public void a() {
        this.f36498i.getLayoutParams().height = this.k;
        f.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        f.b("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.f36452a.a(this.f36498i, str);
        } catch (Exception unused) {
        }
    }

    public static void c(Context context, String str) {
        try {
            JSONObject d2 = j.d(str);
            int i2 = d2.getInt("type");
            String string = d2.getString("msg");
            if (i2 == 0) {
                if (f36492c == null) {
                    f36492c = Toast.makeText(context, string, 0);
                } else {
                    f36492c.setView(f36492c.getView());
                    f36492c.setText(string);
                    f36492c.setDuration(0);
                }
                f36492c.show();
            } else if (i2 == 1) {
                if (f36492c == null) {
                    f36492c = Toast.makeText(context, string, 1);
                } else {
                    f36492c.setView(f36492c.getView());
                    f36492c.setText(string);
                    f36492c.setDuration(1);
                }
                f36492c.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
