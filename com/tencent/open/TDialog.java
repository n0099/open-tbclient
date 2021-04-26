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
/* loaded from: classes6.dex */
public class TDialog extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final FrameLayout.LayoutParams f37146c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d  reason: collision with root package name */
    public static Toast f37147d = null;

    /* renamed from: f  reason: collision with root package name */
    public static WeakReference<ProgressDialog> f37148f;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Context> f37149e;

    /* renamed from: g  reason: collision with root package name */
    public String f37150g;

    /* renamed from: h  reason: collision with root package name */
    public OnTimeListener f37151h;

    /* renamed from: i  reason: collision with root package name */
    public IUiListener f37152i;
    public FrameLayout j;
    public com.tencent.open.c.b k;
    public Handler l;
    public boolean m;
    public QQToken n;

    /* loaded from: classes6.dex */
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
            TDialog.this.f37151h.onError(new UiError(i2, str, str2));
            if (TDialog.this.f37149e != null && TDialog.this.f37149e.get() != null) {
                Toast.makeText((Context) TDialog.this.f37149e.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            f.a("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(g.a().a((Context) TDialog.this.f37149e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f37151h.onComplete(j.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f37151h.onCancel();
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
                    if (TDialog.this.f37149e != null && TDialog.this.f37149e.get() != null) {
                        ((Context) TDialog.this.f37149e.get()).startActivity(intent);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return true;
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static class OnTimeListener implements IUiListener {

        /* renamed from: a  reason: collision with root package name */
        public String f37155a;

        /* renamed from: b  reason: collision with root package name */
        public String f37156b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<Context> f37157c;

        /* renamed from: d  reason: collision with root package name */
        public String f37158d;

        /* renamed from: e  reason: collision with root package name */
        public IUiListener f37159e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f37157c = new WeakReference<>(context);
            this.f37158d = str;
            this.f37155a = str2;
            this.f37156b = str3;
            this.f37159e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f37159e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f37159e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            com.tencent.open.b.g a2 = com.tencent.open.b.g.a();
            a2.a(this.f37158d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.f37155a, false);
            IUiListener iUiListener = this.f37159e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f37159e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f37155a;
            } else {
                str = this.f37155a;
            }
            com.tencent.open.b.g a2 = com.tencent.open.b.g.a();
            a2.a(this.f37158d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f37159e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f37159e = null;
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

    /* loaded from: classes6.dex */
    public class THandler extends Handler {

        /* renamed from: b  reason: collision with root package name */
        public OnTimeListener f37161b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f37161b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.b("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.f37161b.a((String) message.obj);
            } else if (i2 == 2) {
                this.f37161b.onCancel();
            } else if (i2 != 3) {
                if (i2 != 5 || TDialog.this.f37149e == null || TDialog.this.f37149e.get() == null) {
                    return;
                }
                TDialog.d((Context) TDialog.this.f37149e.get(), (String) message.obj);
            } else if (TDialog.this.f37149e == null || TDialog.this.f37149e.get() == null) {
            } else {
                TDialog.c((Context) TDialog.this.f37149e.get(), (String) message.obj);
            }
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.m = false;
        this.n = null;
        this.f37149e = new WeakReference<>(context);
        this.f37150g = str2;
        this.f37151h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.l = new THandler(this.f37151h, context.getMainLooper());
        this.f37152i = iUiListener;
        this.n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f37151h;
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
                if (f37147d == null) {
                    f37147d = Toast.makeText(context, string, 0);
                } else {
                    f37147d.setView(f37147d.getView());
                    f37147d.setText(string);
                    f37147d.setDuration(0);
                }
                f37147d.show();
            } else if (i2 == 1) {
                if (f37147d == null) {
                    f37147d = Toast.makeText(context, string, 1);
                } else {
                    f37147d.setView(f37147d.getView());
                    f37147d.setText(string);
                    f37147d.setDuration(1);
                }
                f37147d.show();
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
                if (f37148f != null && f37148f.get() != null) {
                    f37148f.get().setMessage(string);
                    if (!f37148f.get().isShowing()) {
                        f37148f.get().show();
                    }
                }
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setMessage(string);
                f37148f = new WeakReference<>(progressDialog);
                progressDialog.show();
            } else if (i2 == 0) {
                if (f37148f == null) {
                    return;
                }
                if (f37148f.get() != null && f37148f.get().isShowing()) {
                    f37148f.get().dismiss();
                    f37148f = null;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a() {
        new TextView(this.f37149e.get()).setText("test");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f37149e.get());
        this.k = bVar;
        bVar.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.f37149e.get());
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
        this.k.setWebChromeClient(this.f37208b);
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
        WeakReference<Context> weakReference = this.f37149e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f37149e.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f37207a.a(new JsListener(), "sdk_js_if");
        this.k.loadUrl(this.f37150g);
        this.k.setLayoutParams(f37146c);
        this.k.setVisibility(4);
        this.k.getSettings().setSavePassword(false);
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        f.b("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f37207a.a(this.k, str);
        } catch (Exception unused) {
        }
    }
}
