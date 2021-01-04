package com.tencent.connect.auth;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mapapi.UIMsg;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.webkit.internal.ETAG;
import com.qq.e.comm.constants.Constants;
import com.tencent.connect.auth.b;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import com.tencent.open.b.g;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.j;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private String f13598a;

    /* renamed from: b  reason: collision with root package name */
    private b f13599b;
    private IUiListener c;
    private Handler d;
    private FrameLayout e;
    private LinearLayout f;
    private FrameLayout g;
    private ProgressBar h;
    private String i;
    private com.tencent.open.c.c j;
    private Context k;
    private com.tencent.open.web.security.b l;
    private boolean m;
    private int n;
    private String o;
    private String p;
    private long q;
    private long r;
    private HashMap<String, Runnable> s;

    static /* synthetic */ String a(a aVar, Object obj) {
        String str = aVar.f13598a + obj;
        aVar.f13598a = str;
        return str;
    }

    static /* synthetic */ int m(a aVar) {
        int i = aVar.n;
        aVar.n = i + 1;
        return i;
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.m = false;
        this.q = 0L;
        this.r = 30000L;
        this.k = context;
        this.f13598a = str2;
        this.f13599b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.d = new c(this.f13599b, context.getMainLooper());
        this.c = iUiListener;
        this.i = str;
        this.l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        b();
        d();
        this.s = new HashMap<>();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.m) {
            this.f13599b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    /* loaded from: classes4.dex */
    private class c extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private b f13612b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.f13612b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f13612b.a((String) message.obj);
                    return;
                case 2:
                    this.f13612b.onCancel();
                    return;
                case 3:
                    a.b(a.this.k, (String) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes4.dex */
    private class b implements IUiListener {

        /* renamed from: a  reason: collision with root package name */
        String f13609a;

        /* renamed from: b  reason: collision with root package name */
        String f13610b;
        private String d;
        private IUiListener e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
            this.d = str;
            this.f13609a = str2;
            this.f13610b = str3;
            this.e = iUiListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            try {
                onComplete(j.d(str));
            } catch (JSONException e) {
                e.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g.a().a(this.d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.f13609a, false);
            if (this.e != null) {
                this.e.onComplete(jSONObject);
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str = uiError.errorMessage != null ? uiError.errorMessage + this.f13609a : this.f13609a;
            g.a().a(this.d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            a.this.a(str);
            if (this.e != null) {
                this.e.onError(uiError);
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.e != null) {
                this.e.onCancel();
                this.e = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.p) && this.p.length() >= 4) {
            sb.append("_u_").append(this.p.substring(this.p.length() - 4));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.connect.auth.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1232a extends WebViewClient {
        private C1232a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            f.a("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject c = j.c(str);
                a.this.m = a.this.e();
                if (!a.this.m) {
                    if (c.optString("fail_cb", null) != null) {
                        a.this.a(c.optString("fail_cb"), "");
                    } else if (c.optInt("fall_to_wv") == 1) {
                        a.a(a.this, (Object) (a.this.f13598a.indexOf("?") > -1 ? ETAG.ITEM_SEPARATOR : "?"));
                        a.a(a.this, (Object) "browser_error=1");
                        a.this.j.loadUrl(a.this.f13598a);
                    } else {
                        String optString = c.optString("redir", null);
                        if (optString != null) {
                            a.this.j.loadUrl(optString);
                        }
                    }
                }
                return true;
            } else if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.f13599b.onComplete(j.c(str));
                a.this.dismiss();
                return true;
            } else if (str.startsWith(com.tencent.connect.common.Constants.CANCEL_URI)) {
                a.this.f13599b.onCancel();
                a.this.dismiss();
                return true;
            } else if (str.startsWith(com.tencent.connect.common.Constants.CLOSE_URI)) {
                a.this.dismiss();
                return true;
            } else if (str.startsWith(com.tencent.connect.common.Constants.DOWNLOAD_URI) || str.endsWith(".apk")) {
                try {
                    if (str.startsWith(com.tencent.connect.common.Constants.DOWNLOAD_URI)) {
                        parse = Uri.parse(Uri.decode(str.substring(com.tencent.connect.common.Constants.DOWNLOAD_URI.length())));
                    } else {
                        parse = Uri.parse(Uri.decode(str));
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.addFlags(268435456);
                    a.this.k.startActivity(intent);
                } catch (Exception e) {
                    f.b("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e);
                }
                return true;
            } else if (str.startsWith("auth://progress")) {
                try {
                    List<String> pathSegments = Uri.parse(str).getPathSegments();
                    if (pathSegments.isEmpty()) {
                        return true;
                    }
                    int intValue = Integer.valueOf(pathSegments.get(0)).intValue();
                    if (intValue == 0) {
                        a.this.g.setVisibility(8);
                        a.this.j.setVisibility(0);
                    } else if (intValue == 1) {
                        a.this.g.setVisibility(0);
                    }
                    return true;
                } catch (Exception e2) {
                    return true;
                }
            } else if (!str.startsWith("auth://onLoginSubmit")) {
                if (a.this.l.a(a.this.j, str)) {
                    return true;
                }
                f.c("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                return false;
            } else {
                try {
                    List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                    if (!pathSegments2.isEmpty()) {
                        a.this.p = pathSegments2.get(0);
                    }
                } catch (Exception e3) {
                }
                return true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            f.c("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i + " | description: " + str);
            if (!j.b(a.this.k)) {
                a.this.f13599b.onError(new UiError(UIMsg.m_AppUI.MSG_CLICK_ITEM, "当前网络不可用，请稍后重试！", str2));
                a.this.dismiss();
            } else if (!a.this.o.startsWith("http://qzs.qq.com/open/mobile/login/qzsjump.html?")) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.q;
                if (a.this.n >= 1 || elapsedRealtime >= a.this.r) {
                    a.this.j.loadUrl(a.this.a());
                    return;
                }
                a.m(a.this);
                a.this.d.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.j.loadUrl(a.this.o);
                    }
                }, 500L);
            } else {
                a.this.f13599b.onError(new UiError(i, str, str2));
                a.this.dismiss();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            f.a("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            a.this.g.setVisibility(0);
            a.this.q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.o)) {
                a.this.d.removeCallbacks((Runnable) a.this.s.remove(a.this.o));
            }
            a.this.o = str;
            d dVar = new d(a.this.o);
            a.this.s.put(str, dVar);
            a.this.d.postDelayed(dVar, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            f.a("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            a.this.g.setVisibility(8);
            if (a.this.j != null) {
                a.this.j.setVisibility(0);
            }
            if (!TextUtils.isEmpty(str)) {
                a.this.d.removeCallbacks((Runnable) a.this.s.remove(str));
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
            f.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            String str = "The SSL certificate is invalid,do you countinue?";
            String str2 = "yes";
            String str3 = "no";
            if (Locale.getDefault().getLanguage().equals("zh")) {
                str = "ssl证书无效，是否继续访问？";
                str2 = "是";
                str3 = "否";
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(a.this.k);
            builder.setMessage(str);
            builder.setPositiveButton(str2, new DialogInterface.OnClickListener() { // from class: com.tencent.connect.auth.a.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.proceed();
                }
            });
            builder.setNegativeButton(str3, new DialogInterface.OnClickListener() { // from class: com.tencent.connect.auth.a.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.cancel();
                    a.this.dismiss();
                }
            });
            builder.create().show();
        }
    }

    /* loaded from: classes4.dex */
    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        String f13613a;

        public d(String str) {
            this.f13613a = "";
            this.f13613a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.a("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f13613a + " | mRetryUrl: " + a.this.o);
            if (this.f13613a.equals(a.this.o)) {
                a.this.f13599b.onError(new UiError(9002, "请求页面超时，请稍后重试！", a.this.o));
                a.this.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        String str = "http://qzs.qq.com/open/mobile/login/qzsjump.html?" + this.f13598a.substring(this.f13598a.indexOf("?") + 1);
        f.c("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: http://qzs.qq.com/open/mobile/login/qzsjump.html?");
        return str;
    }

    private void b() {
        c();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.j = new com.tencent.open.c.c(this.k);
        if (Build.VERSION.SDK_INT >= 11) {
            this.j.setLayerType(1, null);
        }
        this.j.setLayoutParams(layoutParams);
        this.e = new FrameLayout(this.k);
        layoutParams.gravity = 17;
        this.e.setLayoutParams(layoutParams);
        this.e.addView(this.j);
        this.e.addView(this.g);
        setContentView(this.e);
    }

    private void c() {
        this.h = new ProgressBar(this.k);
        this.h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f = new LinearLayout(this.k);
        TextView textView = null;
        if (this.i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f.setLayoutParams(layoutParams2);
        this.f.addView(this.h);
        if (textView != null) {
            this.f.addView(textView);
        }
        this.g = new FrameLayout(this.k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = 80;
        layoutParams3.rightMargin = 80;
        layoutParams3.topMargin = 40;
        layoutParams3.bottomMargin = 40;
        layoutParams3.gravity = 17;
        this.g.setLayoutParams(layoutParams3);
        this.g.setBackgroundResource(17301504);
        this.g.addView(this.f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.j.setVerticalScrollBarEnabled(false);
        this.j.setHorizontalScrollBarEnabled(false);
        this.j.setWebViewClient(new C1232a());
        this.j.setWebChromeClient(new WebChromeClient());
        this.j.clearFormData();
        this.j.clearSslPreferences();
        this.j.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.connect.auth.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.j.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.connect.auth.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 1:
                        if (!view.hasFocus()) {
                            view.requestFocus();
                            return false;
                        }
                        return false;
                    default:
                        return false;
                }
            }
        });
        WebSettings settings = this.j.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.k.getDir(NgWebView.APP_DATABASE_PATH, 0).getPath());
        settings.setDomStorageEnabled(true);
        f.a("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f13598a);
        this.o = this.f13598a;
        this.j.loadUrl(this.f13598a);
        this.j.setVisibility(4);
        this.j.getSettings().setSavePassword(false);
        this.l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.connect.auth.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    JniInterface.clearAllPWD();
                } catch (Exception e) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        com.tencent.connect.auth.b a2 = com.tencent.connect.auth.b.a();
        String c2 = a2.c();
        b.a aVar = new b.a();
        aVar.f13617a = this.c;
        aVar.f13618b = this;
        aVar.c = c2;
        String a3 = a2.a(aVar);
        String substring = this.f13598a.substring(0, this.f13598a.indexOf("?"));
        Bundle b2 = j.b(this.f13598a);
        b2.putString("token_key", c2);
        b2.putString("serial", a3);
        b2.putString("browser", "1");
        this.f13598a = substring + "?" + HttpUtils.encodeUrl(b2);
        return j.a(this.k, this.f13598a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            JSONObject d2 = j.d(str);
            int i = d2.getInt("type");
            Toast.makeText(context.getApplicationContext(), d2.getString("msg"), i).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.j.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.s.clear();
        this.d.removeCallbacksAndMessages(null);
        if (isShowing()) {
            super.dismiss();
        }
        if (this.j != null) {
            this.j.destroy();
            this.j = null;
        }
    }
}
