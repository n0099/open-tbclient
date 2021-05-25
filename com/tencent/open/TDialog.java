package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.fastjson.asm.Label;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.qq.e.comm.constants.Constants;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a;
import com.tencent.open.a.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TDialog extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final FrameLayout.LayoutParams f36320c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d  reason: collision with root package name */
    public static Toast f36321d = null;

    /* renamed from: f  reason: collision with root package name */
    public static WeakReference<ProgressDialog> f36322f;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Context> f36323e;

    /* renamed from: g  reason: collision with root package name */
    public String f36324g;

    /* renamed from: h  reason: collision with root package name */
    public OnTimeListener f36325h;

    /* renamed from: i  reason: collision with root package name */
    public IUiListener f36326i;
    public FrameLayout j;
    public com.tencent.open.c.b k;
    public Handler l;
    public boolean m;
    public QQToken n;

    /* loaded from: classes7.dex */
    public class FbWebViewClient extends WebViewClient {
        public FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            f.a("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            TDialog.this.f36325h.onError(new UiError(i2, str, str2));
            if (TDialog.this.f36323e != null && TDialog.this.f36323e.get() != null) {
                Toast.makeText((Context) TDialog.this.f36323e.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            f.a("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(g.a().a((Context) TDialog.this.f36323e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f36325h.onComplete(j.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f36325h.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith(Constants.CLOSE_URI)) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
                return str.startsWith("auth://progress");
            } else {
                try {
                    if (str.startsWith(Constants.DOWNLOAD_URI)) {
                        parse = Uri.parse(Uri.decode(str.substring(11)));
                    } else {
                        parse = Uri.parse(Uri.decode(str));
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    if (TDialog.this.f36323e != null && TDialog.this.f36323e.get() != null) {
                        ((Context) TDialog.this.f36323e.get()).startActivity(intent);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class JsListener extends a.b {
        public JsListener() {
        }

        public void onAddShare(String str) {
            f.b("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            f.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.l.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void onCancelAddShare(String str) {
            f.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel(QueryResponse.Options.CANCEL);
        }

        public void onCancelInvite() {
            f.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.l.obtainMessage(1, str).sendToTarget();
            f.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onLoad(String str) {
            TDialog.this.l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.l.obtainMessage(3, str).sendToTarget();
        }
    }

    /* loaded from: classes7.dex */
    public static class OnTimeListener implements IUiListener {

        /* renamed from: a  reason: collision with root package name */
        public String f36329a;

        /* renamed from: b  reason: collision with root package name */
        public String f36330b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<Context> f36331c;

        /* renamed from: d  reason: collision with root package name */
        public String f36332d;

        /* renamed from: e  reason: collision with root package name */
        public IUiListener f36333e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f36331c = new WeakReference<>(context);
            this.f36332d = str;
            this.f36329a = str2;
            this.f36330b = str3;
            this.f36333e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f36333e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f36333e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            com.tencent.open.b.g a2 = com.tencent.open.b.g.a();
            a2.a(this.f36332d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.f36329a, false);
            IUiListener iUiListener = this.f36333e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f36333e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f36329a;
            } else {
                str = this.f36329a;
            }
            com.tencent.open.b.g a2 = com.tencent.open.b.g.a();
            a2.a(this.f36332d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f36333e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f36333e = null;
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
    public class THandler extends Handler {

        /* renamed from: b  reason: collision with root package name */
        public OnTimeListener f36335b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f36335b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.b("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.f36335b.a((String) message.obj);
            } else if (i2 == 2) {
                this.f36335b.onCancel();
            } else if (i2 != 3) {
                if (i2 != 5 || TDialog.this.f36323e == null || TDialog.this.f36323e.get() == null) {
                    return;
                }
                TDialog.d((Context) TDialog.this.f36323e.get(), (String) message.obj);
            } else if (TDialog.this.f36323e == null || TDialog.this.f36323e.get() == null) {
            } else {
                TDialog.c((Context) TDialog.this.f36323e.get(), (String) message.obj);
            }
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.m = false;
        this.n = null;
        this.f36323e = new WeakReference<>(context);
        this.f36324g = str2;
        this.f36325h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.l = new THandler(this.f36325h, context.getMainLooper());
        this.f36326i = iUiListener;
        this.n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f36325h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a();
        b();
    }

    public static void c(Context context, String str) {
        try {
            JSONObject d2 = j.d(str);
            int i2 = d2.getInt("type");
            String string = d2.getString("msg");
            if (i2 == 0) {
                if (f36321d == null) {
                    f36321d = Toast.makeText(context, string, 0);
                } else {
                    f36321d.setView(f36321d.getView());
                    f36321d.setText(string);
                    f36321d.setDuration(0);
                }
                f36321d.show();
            } else if (i2 == 1) {
                if (f36321d == null) {
                    f36321d = Toast.makeText(context, string, 1);
                } else {
                    f36321d.setView(f36321d.getView());
                    f36321d.setText(string);
                    f36321d.setDuration(1);
                }
                f36321d.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d2 = j.d(str);
            int i2 = d2.getInt("action");
            String string = d2.getString("msg");
            if (i2 == 1) {
                if (f36322f != null && f36322f.get() != null) {
                    f36322f.get().setMessage(string);
                    if (!f36322f.get().isShowing()) {
                        f36322f.get().show();
                    }
                }
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setMessage(string);
                f36322f = new WeakReference<>(progressDialog);
                progressDialog.show();
            } else if (i2 == 0) {
                if (f36322f == null) {
                    return;
                }
                if (f36322f.get() != null && f36322f.get().isShowing()) {
                    f36322f.get().dismiss();
                    f36322f = null;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a() {
        new TextView(this.f36323e.get()).setText("test");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f36323e.get());
        this.k = bVar;
        bVar.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.f36323e.get());
        this.j = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.j.addView(this.k);
        setContentView(this.j);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.k.setVerticalScrollBarEnabled(false);
        this.k.setHorizontalScrollBarEnabled(false);
        this.k.setWebViewClient(new FbWebViewClient());
        this.k.setWebChromeClient(this.f36382b);
        this.k.clearFormData();
        WebSettings settings = this.k.getSettings();
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
        WeakReference<Context> weakReference = this.f36323e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f36323e.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f36381a.a(new JsListener(), "sdk_js_if");
        this.k.loadUrl(this.f36324g);
        this.k.setLayoutParams(f36320c);
        this.k.setVisibility(4);
        this.k.getSettings().setSavePassword(false);
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        f.b("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f36381a.a(this.k, str);
        } catch (Exception unused) {
        }
    }
}
