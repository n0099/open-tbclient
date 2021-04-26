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
import com.alibaba.fastjson.asm.Label;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.wallet.core.beans.BeanConstants;
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
/* loaded from: classes6.dex */
public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public String f37034a;

    /* renamed from: b  reason: collision with root package name */
    public b f37035b;

    /* renamed from: c  reason: collision with root package name */
    public IUiListener f37036c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f37037d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f37038e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f37039f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f37040g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f37041h;

    /* renamed from: i  reason: collision with root package name */
    public String f37042i;
    public com.tencent.open.c.c j;
    public Context k;
    public com.tencent.open.web.security.b l;
    public boolean m;
    public int n;
    public String o;
    public String p;
    public long q;
    public long r;
    public HashMap<String, Runnable> s;

    /* renamed from: com.tencent.connect.auth.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0470a extends WebViewClient {
        public C0470a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            f.a("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            a.this.f37040g.setVisibility(8);
            if (a.this.j != null) {
                a.this.j.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a.this.f37037d.removeCallbacks((Runnable) a.this.s.remove(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            f.a("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            a.this.f37040g.setVisibility(0);
            a.this.q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.o)) {
                a.this.f37037d.removeCallbacks((Runnable) a.this.s.remove(a.this.o));
            }
            a.this.o = str;
            a aVar = a.this;
            d dVar = new d(aVar.o);
            a.this.s.put(str, dVar);
            a.this.f37037d.postDelayed(dVar, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            f.c("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i2 + " | description: " + str);
            if (!j.b(a.this.k)) {
                a.this.f37035b.onError(new UiError(UIMsg.m_AppUI.MSG_CLICK_ITEM, "当前网络不可用，请稍后重试！", str2));
                a.this.dismiss();
            } else if (!a.this.o.startsWith("http://qzs.qq.com/open/mobile/login/qzsjump.html?")) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.q;
                if (a.this.n >= 1 || elapsedRealtime >= a.this.r) {
                    a.this.j.loadUrl(a.this.a());
                    return;
                }
                a.m(a.this);
                a.this.f37037d.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.j.loadUrl(a.this.o);
                    }
                }, 500L);
            } else {
                a.this.f37035b.onError(new UiError(i2, str, str2));
                a.this.dismiss();
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            String str3;
            f.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            if (Locale.getDefault().getLanguage().equals("zh")) {
                str = "ssl证书无效，是否继续访问？";
                str2 = "是";
                str3 = "否";
            } else {
                str = "The SSL certificate is invalid,do you countinue?";
                str2 = "yes";
                str3 = "no";
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(a.this.k);
            builder.setMessage(str);
            builder.setPositiveButton(str2, new DialogInterface.OnClickListener() { // from class: com.tencent.connect.auth.a.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    sslErrorHandler.proceed();
                }
            });
            builder.setNegativeButton(str3, new DialogInterface.OnClickListener() { // from class: com.tencent.connect.auth.a.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    sslErrorHandler.cancel();
                    a.this.dismiss();
                }
            });
            builder.create().show();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            List<String> pathSegments;
            f.a("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject c2 = j.c(str);
                a aVar = a.this;
                aVar.m = aVar.e();
                if (!a.this.m) {
                    if (c2.optString("fail_cb", null) != null) {
                        a.this.a(c2.optString("fail_cb"), "");
                    } else if (c2.optInt("fall_to_wv") == 1) {
                        a aVar2 = a.this;
                        a.a(aVar2, (Object) (aVar2.f37034a.indexOf("?") > -1 ? "&" : "?"));
                        a.a(a.this, (Object) "browser_error=1");
                        a.this.j.loadUrl(a.this.f37034a);
                    } else {
                        String optString = c2.optString("redir", null);
                        if (optString != null) {
                            a.this.j.loadUrl(optString);
                        }
                    }
                }
                return true;
            } else if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.f37035b.onComplete(j.c(str));
                a.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                a.this.f37035b.onCancel();
                a.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CLOSE_URI)) {
                a.this.dismiss();
                return true;
            } else if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
                if (str.startsWith("auth://progress")) {
                    try {
                        pathSegments = Uri.parse(str).getPathSegments();
                    } catch (Exception unused) {
                    }
                    if (pathSegments.isEmpty()) {
                        return true;
                    }
                    int intValue = Integer.valueOf(pathSegments.get(0)).intValue();
                    if (intValue == 0) {
                        a.this.f37040g.setVisibility(8);
                        a.this.j.setVisibility(0);
                    } else if (intValue == 1) {
                        a.this.f37040g.setVisibility(0);
                    }
                    return true;
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
                    } catch (Exception unused2) {
                    }
                    return true;
                }
            } else {
                try {
                    if (str.startsWith(Constants.DOWNLOAD_URI)) {
                        parse = Uri.parse(Uri.decode(str.substring(11)));
                    } else {
                        parse = Uri.parse(Uri.decode(str));
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    a.this.k.startActivity(intent);
                } catch (Exception e2) {
                    f.b("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e2);
                }
                return true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements IUiListener {

        /* renamed from: a  reason: collision with root package name */
        public String f37052a;

        /* renamed from: b  reason: collision with root package name */
        public String f37053b;

        /* renamed from: d  reason: collision with root package name */
        public String f37055d;

        /* renamed from: e  reason: collision with root package name */
        public IUiListener f37056e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
            this.f37055d = str;
            this.f37052a = str2;
            this.f37053b = str3;
            this.f37056e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f37056e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f37056e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g a2 = g.a();
            a2.a(this.f37055d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.f37052a, false);
            IUiListener iUiListener = this.f37056e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f37056e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f37052a;
            } else {
                str = this.f37052a;
            }
            g.a().a(this.f37055d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            a.this.a(str);
            IUiListener iUiListener = this.f37056e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f37056e = null;
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
    public class c extends Handler {

        /* renamed from: b  reason: collision with root package name */
        public b f37058b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.f37058b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                this.f37058b.a((String) message.obj);
            } else if (i2 == 2) {
                this.f37058b.onCancel();
            } else if (i2 != 3) {
            } else {
                a.b(a.this.k, (String) message.obj);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public String f37059a;

        public d(String str) {
            this.f37059a = "";
            this.f37059a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.a("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f37059a + " | mRetryUrl: " + a.this.o);
            if (this.f37059a.equals(a.this.o)) {
                a.this.f37035b.onError(new UiError(9002, "请求页面超时，请稍后重试！", a.this.o));
                a.this.dismiss();
            }
        }
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.m = false;
        this.q = 0L;
        this.r = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
        this.k = context;
        this.f37034a = str2;
        this.f37035b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.f37037d = new c(this.f37035b, context.getMainLooper());
        this.f37036c = iUiListener;
        this.f37042i = str;
        this.l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    public static /* synthetic */ int m(a aVar) {
        int i2 = aVar.n;
        aVar.n = i2 + 1;
        return i2;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.s.clear();
        this.f37037d.removeCallbacksAndMessages(null);
        if (isShowing()) {
            super.dismiss();
        }
        com.tencent.open.c.c cVar = this.j;
        if (cVar != null) {
            cVar.destroy();
            this.j = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.m) {
            this.f37035b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        b();
        d();
        this.s = new HashMap<>();
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.j.setVerticalScrollBarEnabled(false);
        this.j.setHorizontalScrollBarEnabled(false);
        this.j.setWebViewClient(new C0470a());
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
                int action = motionEvent.getAction();
                if ((action == 0 || action == 1) && !view.hasFocus()) {
                    view.requestFocus();
                    return false;
                }
                return false;
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
        settings.setDatabasePath(this.k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        f.a("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f37034a);
        String str = this.f37034a;
        this.o = str;
        this.j.loadUrl(str);
        this.j.setVisibility(4);
        this.j.getSettings().setSavePassword(false);
        this.l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.connect.auth.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    JniInterface.clearAllPWD();
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        com.tencent.connect.auth.b a2 = com.tencent.connect.auth.b.a();
        String c2 = a2.c();
        b.a aVar = new b.a();
        aVar.f37066a = this.f37036c;
        aVar.f37067b = this;
        aVar.f37068c = c2;
        String a3 = a2.a(aVar);
        String str = this.f37034a;
        String substring = str.substring(0, str.indexOf("?"));
        Bundle b2 = j.b(this.f37034a);
        b2.putString("token_key", c2);
        b2.putString("serial", a3);
        b2.putString(BeanConstants.CHANNEL_ID_BROWSER, "1");
        String str2 = substring + "?" + HttpUtils.encodeUrl(b2);
        this.f37034a = str2;
        return j.a(this.k, str2);
    }

    public static /* synthetic */ String a(a aVar, Object obj) {
        String str = aVar.f37034a + obj;
        aVar.f37034a = str;
        return str;
    }

    private void b() {
        c();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.c.c cVar = new com.tencent.open.c.c(this.k);
        this.j = cVar;
        if (Build.VERSION.SDK_INT >= 11) {
            cVar.setLayerType(1, null);
        }
        this.j.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.k);
        this.f37038e = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.f37038e.addView(this.j);
        this.f37038e.addView(this.f37040g);
        setContentView(this.f37038e);
    }

    private void c() {
        TextView textView;
        this.f37041h = new ProgressBar(this.k);
        this.f37041h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f37039f = new LinearLayout(this.k);
        if (this.f37042i.equals("action_login")) {
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
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f37039f.setLayoutParams(layoutParams2);
        this.f37039f.addView(this.f37041h);
        if (textView != null) {
            this.f37039f.addView(textView);
        }
        this.f37040g = new FrameLayout(this.k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = 80;
        layoutParams3.rightMargin = 80;
        layoutParams3.topMargin = 40;
        layoutParams3.bottomMargin = 40;
        layoutParams3.gravity = 17;
        this.f37040g.setLayoutParams(layoutParams3);
        this.f37040g.setBackgroundResource(17301504);
        this.f37040g.addView(this.f37039f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.p) && this.p.length() >= 4) {
            String str2 = this.p;
            String substring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(substring);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        String str = this.f37034a;
        String str2 = "http://qzs.qq.com/open/mobile/login/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        f.c("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: http://qzs.qq.com/open/mobile/login/qzsjump.html?");
        return str2;
    }

    public static void b(Context context, String str) {
        try {
            JSONObject d2 = j.d(str);
            int i2 = d2.getInt("type");
            Toast.makeText(context.getApplicationContext(), d2.getString("msg"), i2).show();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.j.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }
}
