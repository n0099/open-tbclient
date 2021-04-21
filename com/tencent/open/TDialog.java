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
    public static final FrameLayout.LayoutParams f39549c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d  reason: collision with root package name */
    public static Toast f39550d = null;

    /* renamed from: f  reason: collision with root package name */
    public static WeakReference<ProgressDialog> f39551f;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Context> f39552e;

    /* renamed from: g  reason: collision with root package name */
    public String f39553g;

    /* renamed from: h  reason: collision with root package name */
    public OnTimeListener f39554h;
    public IUiListener i;
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
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            TDialog.this.f39554h.onError(new UiError(i, str, str2));
            if (TDialog.this.f39552e != null && TDialog.this.f39552e.get() != null) {
                Toast.makeText((Context) TDialog.this.f39552e.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            f.a("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(g.a().a((Context) TDialog.this.f39552e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f39554h.onComplete(j.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f39554h.onCancel();
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
                    if (TDialog.this.f39552e != null && TDialog.this.f39552e.get() != null) {
                        ((Context) TDialog.this.f39552e.get()).startActivity(intent);
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
        public String f39557a;

        /* renamed from: b  reason: collision with root package name */
        public String f39558b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<Context> f39559c;

        /* renamed from: d  reason: collision with root package name */
        public String f39560d;

        /* renamed from: e  reason: collision with root package name */
        public IUiListener f39561e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f39559c = new WeakReference<>(context);
            this.f39560d = str;
            this.f39557a = str2;
            this.f39558b = str3;
            this.f39561e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f39561e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f39561e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            com.tencent.open.b.g a2 = com.tencent.open.b.g.a();
            a2.a(this.f39560d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.f39557a, false);
            IUiListener iUiListener = this.f39561e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f39561e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f39557a;
            } else {
                str = this.f39557a;
            }
            com.tencent.open.b.g a2 = com.tencent.open.b.g.a();
            a2.a(this.f39560d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f39561e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f39561e = null;
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
        public OnTimeListener f39563b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f39563b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.b("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i = message.what;
            if (i == 1) {
                this.f39563b.a((String) message.obj);
            } else if (i == 2) {
                this.f39563b.onCancel();
            } else if (i != 3) {
                if (i != 5 || TDialog.this.f39552e == null || TDialog.this.f39552e.get() == null) {
                    return;
                }
                TDialog.d((Context) TDialog.this.f39552e.get(), (String) message.obj);
            } else if (TDialog.this.f39552e == null || TDialog.this.f39552e.get() == null) {
            } else {
                TDialog.c((Context) TDialog.this.f39552e.get(), (String) message.obj);
            }
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.m = false;
        this.n = null;
        this.f39552e = new WeakReference<>(context);
        this.f39553g = str2;
        this.f39554h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.l = new THandler(this.f39554h, context.getMainLooper());
        this.i = iUiListener;
        this.n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f39554h;
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
            int i = d2.getInt("type");
            String string = d2.getString("msg");
            if (i == 0) {
                if (f39550d == null) {
                    f39550d = Toast.makeText(context, string, 0);
                } else {
                    f39550d.setView(f39550d.getView());
                    f39550d.setText(string);
                    f39550d.setDuration(0);
                }
                f39550d.show();
            } else if (i == 1) {
                if (f39550d == null) {
                    f39550d = Toast.makeText(context, string, 1);
                } else {
                    f39550d.setView(f39550d.getView());
                    f39550d.setText(string);
                    f39550d.setDuration(1);
                }
                f39550d.show();
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
            int i = d2.getInt("action");
            String string = d2.getString("msg");
            if (i == 1) {
                if (f39551f != null && f39551f.get() != null) {
                    f39551f.get().setMessage(string);
                    if (!f39551f.get().isShowing()) {
                        f39551f.get().show();
                    }
                }
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setMessage(string);
                f39551f = new WeakReference<>(progressDialog);
                progressDialog.show();
            } else if (i == 0) {
                if (f39551f == null) {
                    return;
                }
                if (f39551f.get() != null && f39551f.get().isShowing()) {
                    f39551f.get().dismiss();
                    f39551f = null;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a() {
        new TextView(this.f39552e.get()).setText("test");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f39552e.get());
        this.k = bVar;
        bVar.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.f39552e.get());
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
        this.k.setWebChromeClient(this.f39607b);
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
        WeakReference<Context> weakReference = this.f39552e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f39552e.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f39606a.a(new JsListener(), "sdk_js_if");
        this.k.loadUrl(this.f39553g);
        this.k.setLayoutParams(f39549c);
        this.k.setVisibility(4);
        this.k.getSettings().setSavePassword(false);
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        f.b("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f39606a.a(this.k, str);
        } catch (Exception unused) {
        }
    }
}
