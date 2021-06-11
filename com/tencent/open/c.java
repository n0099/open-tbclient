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
public class c extends com.tencent.open.b implements a.InterfaceC0518a {

    /* renamed from: c  reason: collision with root package name */
    public static Toast f40100c;

    /* renamed from: d  reason: collision with root package name */
    public String f40101d;

    /* renamed from: e  reason: collision with root package name */
    public IUiListener f40102e;

    /* renamed from: f  reason: collision with root package name */
    public C0519c f40103f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f40104g;

    /* renamed from: h  reason: collision with root package name */
    public com.tencent.open.c.a f40105h;

    /* renamed from: i  reason: collision with root package name */
    public com.tencent.open.c.b f40106i;
    public WeakReference<Context> j;
    public int k;

    /* loaded from: classes7.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            c.this.f40106i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            f.a("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            c.this.f40103f.onError(new UiError(i2, str, str2));
            if (c.this.j != null && c.this.j.get() != null) {
                Toast.makeText((Context) c.this.j.get(), "网络连接异常或系统错误", 0).show();
            }
            c.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            f.a("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(g.a().a((Context) c.this.j.get(), "auth://tauth.qq.com/"))) {
                c.this.f40103f.onComplete(j.c(str));
                c.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                c.this.f40103f.onCancel();
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
    public static class C0519c implements IUiListener {

        /* renamed from: a  reason: collision with root package name */
        public String f40116a;

        /* renamed from: b  reason: collision with root package name */
        public String f40117b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<Context> f40118c;

        /* renamed from: d  reason: collision with root package name */
        public String f40119d;

        /* renamed from: e  reason: collision with root package name */
        public IUiListener f40120e;

        public C0519c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f40118c = new WeakReference<>(context);
            this.f40119d = str;
            this.f40116a = str2;
            this.f40117b = str3;
            this.f40120e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f40120e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f40120e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            com.tencent.open.b.g a2 = com.tencent.open.b.g.a();
            a2.a(this.f40119d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.f40116a, false);
            IUiListener iUiListener = this.f40120e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f40120e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f40116a;
            } else {
                str = this.f40116a;
            }
            com.tencent.open.b.g a2 = com.tencent.open.b.g.a();
            a2.a(this.f40119d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f40120e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f40120e = null;
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
        public C0519c f40122b;

        public d(C0519c c0519c, Looper looper) {
            super(looper);
            this.f40122b = c0519c;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.b("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.f40122b.a((String) message.obj);
            } else if (i2 == 2) {
                this.f40122b.onCancel();
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
        this.f40101d = str2;
        this.f40103f = new C0519c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f40104g = new d(this.f40103f, context.getMainLooper());
        this.f40102e = iUiListener;
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
        this.f40106i.setVerticalScrollBarEnabled(false);
        this.f40106i.setHorizontalScrollBarEnabled(false);
        this.f40106i.setWebViewClient(new a());
        this.f40106i.setWebChromeClient(this.f40061b);
        this.f40106i.clearFormData();
        WebSettings settings = this.f40106i.getSettings();
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
        this.f40060a.a(new b(), "sdk_js_if");
        this.f40106i.clearView();
        this.f40106i.loadUrl(this.f40101d);
        this.f40106i.getSettings().setSavePassword(false);
    }

    private void b() {
        com.tencent.open.c.a aVar = new com.tencent.open.c.a(this.j.get());
        this.f40105h = aVar;
        aVar.setBackgroundColor(1711276032);
        this.f40105h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.j.get());
        this.f40106i = bVar;
        bVar.setBackgroundColor(0);
        this.f40106i.setBackgroundDrawable(null);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f40106i, 1, new Paint());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.k);
        layoutParams.addRule(13, -1);
        this.f40106i.setLayoutParams(layoutParams);
        this.f40105h.addView(this.f40106i);
        this.f40105h.a(this);
        setContentView(this.f40105h);
    }

    @Override // com.tencent.open.c.a.InterfaceC0518a
    public void a(int i2) {
        WeakReference<Context> weakReference = this.j;
        if (weakReference != null && weakReference.get() != null) {
            if (i2 < this.k && 2 == this.j.get().getResources().getConfiguration().orientation) {
                this.f40106i.getLayoutParams().height = i2;
            } else {
                this.f40106i.getLayoutParams().height = this.k;
            }
        }
        f.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.c.a.InterfaceC0518a
    public void a() {
        this.f40106i.getLayoutParams().height = this.k;
        f.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        f.b("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.f40060a.a(this.f40106i, str);
        } catch (Exception unused) {
        }
    }

    public static void c(Context context, String str) {
        try {
            JSONObject d2 = j.d(str);
            int i2 = d2.getInt("type");
            String string = d2.getString("msg");
            if (i2 == 0) {
                if (f40100c == null) {
                    f40100c = Toast.makeText(context, string, 0);
                } else {
                    f40100c.setView(f40100c.getView());
                    f40100c.setText(string);
                    f40100c.setDuration(0);
                }
                f40100c.show();
            } else if (i2 == 1) {
                if (f40100c == null) {
                    f40100c = Toast.makeText(context, string, 1);
                } else {
                    f40100c.setView(f40100c.getView());
                    f40100c.setText(string);
                    f40100c.setDuration(1);
                }
                f40100c.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
