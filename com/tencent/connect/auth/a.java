package com.tencent.connect.auth;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
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
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.ErrorCode;
import com.tencent.connect.auth.b;
import com.tencent.open.a.g;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.l;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public b b;
    public IUiListener c;
    public Handler d;
    public FrameLayout e;
    public LinearLayout f;
    public FrameLayout g;
    public ProgressBar h;
    public Button i;
    public String j;
    public com.tencent.open.b.c k;
    public Context l;
    public com.tencent.open.web.security.b m;
    public boolean n;
    public int o;
    public String p;
    public String q;
    public long r;
    public long s;
    public HashMap<String, Runnable> t;

    /* renamed from: com.tencent.connect.auth.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0699a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0699a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                SLog.v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
                this.a.g.setVisibility(8);
                if (this.a.k != null) {
                    this.a.k.setVisibility(0);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.a.d.removeCallbacks((Runnable) this.a.t.remove(str));
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                SLog.v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
                super.onPageStarted(webView, str, bitmap);
                this.a.g.setVisibility(0);
                this.a.r = SystemClock.elapsedRealtime();
                if (!TextUtils.isEmpty(this.a.p)) {
                    this.a.d.removeCallbacks((Runnable) this.a.t.remove(this.a.p));
                }
                this.a.p = str;
                a aVar = this.a;
                d dVar = new d(aVar, aVar.p);
                this.a.t.put(str, dVar);
                this.a.d.postDelayed(dVar, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                SLog.i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i + " | description: " + str);
                if (!l.b(this.a.l)) {
                    this.a.b.onError(new UiError(9001, "当前网络不可用，请稍后重试！", str2));
                    this.a.dismiss();
                } else if (!this.a.p.startsWith("https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - this.a.r;
                    if (this.a.o >= 1 || elapsedRealtime >= this.a.s) {
                        this.a.k.loadUrl(this.a.a());
                        return;
                    }
                    a.m(this.a);
                    this.a.d.postDelayed(new Runnable(this) { // from class: com.tencent.connect.auth.a.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ C0699a a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.a.a.k.loadUrl(this.a.a.p);
                            }
                        }
                    }, 500L);
                } else {
                    this.a.b.onError(new UiError(i, str, str2));
                    this.a.dismiss();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) {
                SLog.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
                if (Locale.getDefault().getLanguage().equals("zh")) {
                    str = "ssl证书无效，是否继续访问？";
                    str2 = "是";
                    str3 = "否";
                } else {
                    str = "The SSL certificate is invalid,do you countinue?";
                    str2 = "yes";
                    str3 = "no";
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this.a.l);
                builder.setMessage(str);
                builder.setPositiveButton(str2, new DialogInterface.OnClickListener(this, sslErrorHandler) { // from class: com.tencent.connect.auth.a.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SslErrorHandler a;
                    public final /* synthetic */ C0699a b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sslErrorHandler};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = sslErrorHandler;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i) == null) {
                            this.a.proceed();
                        }
                    }
                });
                builder.setNegativeButton(str3, new DialogInterface.OnClickListener(this, sslErrorHandler) { // from class: com.tencent.connect.auth.a.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SslErrorHandler a;
                    public final /* synthetic */ C0699a b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sslErrorHandler};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = sslErrorHandler;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i) == null) {
                            this.a.cancel();
                            this.b.a.dismiss();
                        }
                    }
                });
                builder.create().show();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Uri parse;
            List<String> pathSegments;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                SLog.v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
                if (str.startsWith("auth://browser")) {
                    JSONObject c = l.c(str);
                    a aVar = this.a;
                    aVar.n = aVar.f();
                    if (!this.a.n) {
                        if (c.optString("fail_cb", null) != null) {
                            this.a.a(c.optString("fail_cb"), "");
                        } else if (c.optInt("fall_to_wv") == 1) {
                            a aVar2 = this.a;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.a.a);
                            sb.append(this.a.a.indexOf("?") > -1 ? "&" : "?");
                            aVar2.a = sb.toString();
                            a aVar3 = this.a;
                            aVar3.a = this.a.a + "browser_error=1";
                            this.a.k.loadUrl(this.a.a);
                        } else {
                            String optString = c.optString("redir", null);
                            if (optString != null) {
                                this.a.k.loadUrl(optString);
                            }
                        }
                    }
                    return true;
                } else if (str.startsWith("auth://tauth.qq.com/")) {
                    this.a.b.onComplete(l.c(str));
                    this.a.dismiss();
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CANCEL_URI)) {
                    this.a.b.onCancel();
                    this.a.dismiss();
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CLOSE_URI)) {
                    this.a.dismiss();
                    return true;
                } else if (!str.startsWith(com.tencent.connect.common.Constants.DOWNLOAD_URI) && !str.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) {
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
                            this.a.g.setVisibility(8);
                            this.a.k.setVisibility(0);
                        } else if (intValue == 1) {
                            this.a.g.setVisibility(0);
                        }
                        return true;
                    } else if (!str.startsWith("auth://onLoginSubmit")) {
                        if (this.a.m.a(this.a.k, str)) {
                            return true;
                        }
                        SLog.i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                        return false;
                    } else {
                        try {
                            List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                            if (!pathSegments2.isEmpty()) {
                                this.a.q = pathSegments2.get(0);
                            }
                        } catch (Exception unused2) {
                        }
                        return true;
                    }
                } else {
                    try {
                        if (str.startsWith(com.tencent.connect.common.Constants.DOWNLOAD_URI)) {
                            parse = Uri.parse(Uri.decode(str.substring(11)));
                        } else {
                            parse = Uri.parse(Uri.decode(str));
                        }
                        Intent intent = new Intent("android.intent.action.VIEW", parse);
                        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                        this.a.l.startActivity(intent);
                    } catch (Exception e) {
                        SLog.e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e);
                    }
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends DefaultUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ a c;
        public String d;
        public IUiListener e;

        public b(a aVar, String str, String str2, String str3, IUiListener iUiListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, str3, iUiListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = aVar;
            this.d = str;
            this.a = str2;
            this.b = str3;
            this.e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iUiListener = this.e) == null) {
                return;
            }
            iUiListener.onCancel();
            this.e = null;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                JSONObject jSONObject = (JSONObject) obj;
                g a = g.a();
                a.a(this.d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.a, false);
                IUiListener iUiListener = this.e;
                if (iUiListener != null) {
                    iUiListener.onComplete(jSONObject);
                    this.e = null;
                }
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                if (uiError.errorMessage != null) {
                    str = uiError.errorMessage + this.a;
                } else {
                    str = this.a;
                }
                g.a().a(this.d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
                this.c.a(str);
                IUiListener iUiListener = this.e;
                if (iUiListener != null) {
                    iUiListener.onError(uiError);
                    this.e = null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
                try {
                    onComplete(l.d(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                    onError(new UiError(-4, com.tencent.connect.common.Constants.MSG_JSON_ERROR, str));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;
        public b b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, b bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i == 1) {
                    this.b.a((String) message.obj);
                } else if (i == 2) {
                    this.b.onCancel();
                } else if (i != 3) {
                } else {
                    a.b(this.a.l, (String) message.obj);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ a b;

        public d(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aVar;
            this.a = "";
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SLog.v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.a + " | mRetryUrl: " + this.b.p);
                if (this.a.equals(this.b.p)) {
                    this.b.b.onError(new UiError(ErrorCode.PrivateError.PARAM_ERROR, "请求页面超时，请稍后重试！", this.b.p));
                    this.b.dismiss();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, iUiListener, qQToken};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = false;
        this.r = 0L;
        this.s = 30000L;
        this.l = context;
        this.a = str2;
        this.b = new b(this, str, str2, qQToken.getAppId(), iUiListener);
        this.d = new c(this, this.b, context.getMainLooper());
        this.c = iUiListener;
        this.j = str;
        this.m = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    public static /* synthetic */ int m(a aVar) {
        int i = aVar.o;
        aVar.o = i + 1;
        return i;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.t.clear();
            this.d.removeCallbacksAndMessages(null);
            try {
                if ((this.l instanceof Activity) && !((Activity) this.l).isFinishing() && isShowing()) {
                    super.dismiss();
                    SLog.i("openSDK_LOG.AuthDialog", "-->dismiss dialog");
                }
            } catch (Exception e) {
                SLog.e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e);
            }
            com.tencent.open.b.c cVar = this.k;
            if (cVar != null) {
                cVar.destroy();
                this.k = null;
            }
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.n) {
                this.b.onCancel();
            }
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            requestWindowFeature(1);
            Window window = getWindow();
            if (window != null) {
                window.setFlags(1024, 1024);
            }
            super.onCreate(bundle);
            if (window != null) {
                View decorView = window.getDecorView();
                if (Build.VERSION.SDK_INT >= 16) {
                    decorView.setSystemUiVisibility(1280);
                }
            }
            b();
            e();
            this.t = new HashMap<>();
        }
    }

    @Override // android.app.Dialog
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStop();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.k.setVerticalScrollBarEnabled(false);
            this.k.setHorizontalScrollBarEnabled(false);
            this.k.setWebViewClient(new C0699a());
            this.k.setWebChromeClient(new WebChromeClient());
            this.k.clearFormData();
            this.k.clearSslPreferences();
            this.k.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: com.tencent.connect.auth.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) {
                        return true;
                    }
                    return invokeL.booleanValue;
                }
            });
            this.k.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.tencent.connect.auth.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                        int action = motionEvent.getAction();
                        if ((action == 0 || action == 1) && !view2.hasFocus()) {
                            view2.requestFocus();
                            return false;
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            WebSettings settings = this.k.getSettings();
            settings.setSavePassword(false);
            settings.setSaveFormData(false);
            settings.setCacheMode(-1);
            settings.setNeedInitialFocus(false);
            settings.setBuiltInZoomControls(true);
            settings.setSupportZoom(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setJavaScriptEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.l.getDir(NgWebView.APP_DATABASE_PATH, 0).getPath());
            settings.setDomStorageEnabled(true);
            SLog.v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.a);
            String str = this.a;
            this.p = str;
            this.k.loadUrl(str);
            this.k.setVisibility(4);
            this.k.getSettings().setSavePassword(false);
            this.m.a(new SecureJsInterface(), "SecureJsInterface");
            SecureJsInterface.isPWDEdit = false;
            super.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.tencent.connect.auth.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        try {
                            if (JniInterface.isJniOk) {
                                JniInterface.clearAllPWD();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            com.tencent.connect.auth.b a = com.tencent.connect.auth.b.a();
            String c2 = a.c();
            b.a aVar = new b.a();
            aVar.a = this.c;
            aVar.b = this;
            aVar.c = c2;
            String a2 = a.a(aVar);
            String str = this.a;
            String substring = str.substring(0, str.indexOf("?"));
            Bundle b2 = l.b(this.a);
            b2.putString("token_key", c2);
            b2.putString("serial", a2);
            b2.putString("browser", "1");
            String str2 = substring + "?" + HttpUtils.encodeUrl(b2);
            this.a = str2;
            return l.a(this.l, str2);
        }
        return invokeV.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            d();
            c();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            com.tencent.open.b.c cVar = new com.tencent.open.b.c(this.l);
            this.k = cVar;
            if (Build.VERSION.SDK_INT >= 11) {
                cVar.setLayerType(1, null);
            }
            this.k.setLayoutParams(layoutParams);
            FrameLayout frameLayout = new FrameLayout(this.l);
            this.e = frameLayout;
            layoutParams.gravity = 17;
            frameLayout.setLayoutParams(layoutParams);
            this.e.addView(this.k);
            this.e.addView(this.g);
            String string = l.b(this.a).getString("style");
            if (string != null && "qr".equals(string)) {
                this.e.addView(this.i);
            }
            setContentView(this.e);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            Button button = new Button(this.l);
            this.i = button;
            button.setBackgroundDrawable(l.a("h5_qr_back.png", this.l));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = com.tencent.connect.avatar.a.a(this.l, 20.0f);
            layoutParams.topMargin = com.tencent.connect.avatar.a.a(this.l, 10.0f);
            this.i.setLayoutParams(layoutParams);
            this.i.setOnClickListener(new View.OnClickListener(this) { // from class: com.tencent.connect.auth.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.dismiss();
                        if (this.a.n || this.a.b == null) {
                            return;
                        }
                        this.a.b.onCancel();
                    }
                }
            });
        }
    }

    private void d() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.h = new ProgressBar(this.l);
            this.h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f = new LinearLayout(this.l);
            if (this.j.equals("action_login")) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 16;
                layoutParams.leftMargin = 5;
                textView = new TextView(this.l);
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
            this.f.setLayoutParams(layoutParams2);
            this.f.addView(this.h);
            if (textView != null) {
                this.f.addView(textView);
            }
            this.g = new FrameLayout(this.l);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams3.gravity = 17;
            this.g.setLayoutParams(layoutParams3);
            this.g.setBackgroundColor(Color.parseColor("#B3000000"));
            this.g.addView(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.q) && this.q.length() >= 4) {
                String str2 = this.q;
                String substring = str2.substring(str2.length() - 4);
                sb.append("_u_");
                sb.append(substring);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            String str = this.a;
            String str2 = "https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
            SLog.i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?");
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.k.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
        }
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, str) == null) {
            try {
                JSONObject d2 = l.d(str);
                int i = d2.getInt("type");
                Toast.makeText(context.getApplicationContext(), d2.getString("msg"), i).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
