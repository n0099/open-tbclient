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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BeanConstants;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.ErrorCode;
import com.tencent.connect.auth.b;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f38747a;

    /* renamed from: b  reason: collision with root package name */
    public b f38748b;

    /* renamed from: c  reason: collision with root package name */
    public IUiListener f38749c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f38750d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f38751e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f38752f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f38753g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f38754h;

    /* renamed from: i  reason: collision with root package name */
    public String f38755i;
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
    public class C0517a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f38759a;

        public C0517a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38759a = aVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                f.a("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
                this.f38759a.f38753g.setVisibility(8);
                if (this.f38759a.j != null) {
                    this.f38759a.j.setVisibility(0);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f38759a.f38750d.removeCallbacks((Runnable) this.f38759a.s.remove(str));
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                f.a("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
                super.onPageStarted(webView, str, bitmap);
                this.f38759a.f38753g.setVisibility(0);
                this.f38759a.q = SystemClock.elapsedRealtime();
                if (!TextUtils.isEmpty(this.f38759a.o)) {
                    this.f38759a.f38750d.removeCallbacks((Runnable) this.f38759a.s.remove(this.f38759a.o));
                }
                this.f38759a.o = str;
                a aVar = this.f38759a;
                d dVar = new d(aVar, aVar.o);
                this.f38759a.s.put(str, dVar);
                this.f38759a.f38750d.postDelayed(dVar, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                f.c("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i2 + " | description: " + str);
                if (!j.b(this.f38759a.k)) {
                    this.f38759a.f38748b.onError(new UiError(9001, "当前网络不可用，请稍后重试！", str2));
                    this.f38759a.dismiss();
                } else if (!this.f38759a.o.startsWith("http://qzs.qq.com/open/mobile/login/qzsjump.html?")) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - this.f38759a.q;
                    if (this.f38759a.n >= 1 || elapsedRealtime >= this.f38759a.r) {
                        this.f38759a.j.loadUrl(this.f38759a.a());
                        return;
                    }
                    a.m(this.f38759a);
                    this.f38759a.f38750d.postDelayed(new Runnable(this) { // from class: com.tencent.connect.auth.a.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ C0517a f38760a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f38760a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f38760a.f38759a.j.loadUrl(this.f38760a.f38759a.o);
                            }
                        }
                    }, 500L);
                } else {
                    this.f38759a.f38748b.onError(new UiError(i2, str, str2));
                    this.f38759a.dismiss();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f38759a.k);
                builder.setMessage(str);
                builder.setPositiveButton(str2, new DialogInterface.OnClickListener(this, sslErrorHandler) { // from class: com.tencent.connect.auth.a.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SslErrorHandler f38761a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ C0517a f38762b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sslErrorHandler};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f38762b = this;
                        this.f38761a = sslErrorHandler;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                            this.f38761a.proceed();
                        }
                    }
                });
                builder.setNegativeButton(str3, new DialogInterface.OnClickListener(this, sslErrorHandler) { // from class: com.tencent.connect.auth.a.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SslErrorHandler f38763a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ C0517a f38764b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sslErrorHandler};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f38764b = this;
                        this.f38763a = sslErrorHandler;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                            this.f38763a.cancel();
                            this.f38764b.f38759a.dismiss();
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
                f.a("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
                if (str.startsWith("auth://browser")) {
                    JSONObject c2 = j.c(str);
                    a aVar = this.f38759a;
                    aVar.m = aVar.e();
                    if (!this.f38759a.m) {
                        if (c2.optString("fail_cb", null) != null) {
                            this.f38759a.a(c2.optString("fail_cb"), "");
                        } else if (c2.optInt("fall_to_wv") == 1) {
                            a aVar2 = this.f38759a;
                            a.a(aVar2, (Object) (aVar2.f38747a.indexOf("?") > -1 ? "&" : "?"));
                            a.a(this.f38759a, (Object) "browser_error=1");
                            this.f38759a.j.loadUrl(this.f38759a.f38747a);
                        } else {
                            String optString = c2.optString("redir", null);
                            if (optString != null) {
                                this.f38759a.j.loadUrl(optString);
                            }
                        }
                    }
                    return true;
                } else if (str.startsWith("auth://tauth.qq.com/")) {
                    this.f38759a.f38748b.onComplete(j.c(str));
                    this.f38759a.dismiss();
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CANCEL_URI)) {
                    this.f38759a.f38748b.onCancel();
                    this.f38759a.dismiss();
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CLOSE_URI)) {
                    this.f38759a.dismiss();
                    return true;
                } else if (!str.startsWith(com.tencent.connect.common.Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
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
                            this.f38759a.f38753g.setVisibility(8);
                            this.f38759a.j.setVisibility(0);
                        } else if (intValue == 1) {
                            this.f38759a.f38753g.setVisibility(0);
                        }
                        return true;
                    } else if (!str.startsWith("auth://onLoginSubmit")) {
                        if (this.f38759a.l.a(this.f38759a.j, str)) {
                            return true;
                        }
                        f.c("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                        return false;
                    } else {
                        try {
                            List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                            if (!pathSegments2.isEmpty()) {
                                this.f38759a.p = pathSegments2.get(0);
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
                        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        this.f38759a.k.startActivity(intent);
                    } catch (Exception e2) {
                        f.b("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e2);
                    }
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f38765a;

        /* renamed from: b  reason: collision with root package name */
        public String f38766b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f38767c;

        /* renamed from: d  reason: collision with root package name */
        public String f38768d;

        /* renamed from: e  reason: collision with root package name */
        public IUiListener f38769e;

        public b(a aVar, String str, String str2, String str3, IUiListener iUiListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, str3, iUiListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38767c = aVar;
            this.f38768d = str;
            this.f38765a = str2;
            this.f38766b = str3;
            this.f38769e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iUiListener = this.f38769e) == null) {
                return;
            }
            iUiListener.onCancel();
            this.f38769e = null;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                JSONObject jSONObject = (JSONObject) obj;
                g a2 = g.a();
                a2.a(this.f38768d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.f38765a, false);
                IUiListener iUiListener = this.f38769e;
                if (iUiListener != null) {
                    iUiListener.onComplete(jSONObject);
                    this.f38769e = null;
                }
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                if (uiError.errorMessage != null) {
                    str = uiError.errorMessage + this.f38765a;
                } else {
                    str = this.f38765a;
                }
                g.a().a(this.f38768d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
                this.f38767c.a(str);
                IUiListener iUiListener = this.f38769e;
                if (iUiListener != null) {
                    iUiListener.onError(uiError);
                    this.f38769e = null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
                try {
                    onComplete(j.d(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    onError(new UiError(-4, com.tencent.connect.common.Constants.MSG_JSON_ERROR, str));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f38770a;

        /* renamed from: b  reason: collision with root package name */
        public b f38771b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, b bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38770a = aVar;
            this.f38771b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 1) {
                    this.f38771b.a((String) message.obj);
                } else if (i2 == 2) {
                    this.f38771b.onCancel();
                } else if (i2 != 3) {
                } else {
                    a.b(this.f38770a.k, (String) message.obj);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f38772a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f38773b;

        public d(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38773b = aVar;
            this.f38772a = "";
            this.f38772a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f.a("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f38772a + " | mRetryUrl: " + this.f38773b.o);
                if (this.f38772a.equals(this.f38773b.o)) {
                    this.f38773b.f38748b.onError(new UiError(ErrorCode.PrivateError.PARAM_ERROR, "请求页面超时，请稍后重试！", this.f38773b.o));
                    this.f38773b.dismiss();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.q = 0L;
        this.r = 30000L;
        this.k = context;
        this.f38747a = str2;
        this.f38748b = new b(this, str, str2, qQToken.getAppId(), iUiListener);
        this.f38750d = new c(this, this.f38748b, context.getMainLooper());
        this.f38749c = iUiListener;
        this.f38755i = str;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.s.clear();
            this.f38750d.removeCallbacksAndMessages(null);
            if (isShowing()) {
                super.dismiss();
            }
            com.tencent.open.c.c cVar = this.j;
            if (cVar != null) {
                cVar.destroy();
                this.j = null;
            }
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.m) {
                this.f38748b.onCancel();
            }
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            b();
            d();
            this.s = new HashMap<>();
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
    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.j.setVerticalScrollBarEnabled(false);
            this.j.setHorizontalScrollBarEnabled(false);
            this.j.setWebViewClient(new C0517a());
            this.j.setWebChromeClient(new WebChromeClient());
            this.j.clearFormData();
            this.j.clearSslPreferences();
            this.j.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: com.tencent.connect.auth.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f38756a;

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
                    this.f38756a = this;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view)) == null) {
                        return true;
                    }
                    return invokeL.booleanValue;
                }
            });
            this.j.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.tencent.connect.auth.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f38757a;

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
                    this.f38757a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        int action = motionEvent.getAction();
                        if ((action == 0 || action == 1) && !view.hasFocus()) {
                            view.requestFocus();
                            return false;
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
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
            f.a("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f38747a);
            String str = this.f38747a;
            this.o = str;
            this.j.loadUrl(str);
            this.j.setVisibility(4);
            this.j.getSettings().setSavePassword(false);
            this.l.a(new SecureJsInterface(), "SecureJsInterface");
            SecureJsInterface.isPWDEdit = false;
            super.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.tencent.connect.auth.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f38758a;

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
                    this.f38758a = this;
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        try {
                            JniInterface.clearAllPWD();
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            com.tencent.connect.auth.b a2 = com.tencent.connect.auth.b.a();
            String c2 = a2.c();
            b.a aVar = new b.a();
            aVar.f38779a = this.f38749c;
            aVar.f38780b = this;
            aVar.f38781c = c2;
            String a3 = a2.a(aVar);
            String str = this.f38747a;
            String substring = str.substring(0, str.indexOf("?"));
            Bundle b2 = j.b(this.f38747a);
            b2.putString("token_key", c2);
            b2.putString("serial", a3);
            b2.putString(BeanConstants.CHANNEL_ID_BROWSER, "1");
            String str2 = substring + "?" + HttpUtils.encodeUrl(b2);
            this.f38747a = str2;
            return j.a(this.k, str2);
        }
        return invokeV.booleanValue;
    }

    public static /* synthetic */ String a(a aVar, Object obj) {
        String str = aVar.f38747a + obj;
        aVar.f38747a = str;
        return str;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            c();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            com.tencent.open.c.c cVar = new com.tencent.open.c.c(this.k);
            this.j = cVar;
            if (Build.VERSION.SDK_INT >= 11) {
                cVar.setLayerType(1, null);
            }
            this.j.setLayoutParams(layoutParams);
            FrameLayout frameLayout = new FrameLayout(this.k);
            this.f38751e = frameLayout;
            layoutParams.gravity = 17;
            frameLayout.setLayoutParams(layoutParams);
            this.f38751e.addView(this.j);
            this.f38751e.addView(this.f38753g);
            setContentView(this.f38751e);
        }
    }

    private void c() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.f38754h = new ProgressBar(this.k);
            this.f38754h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f38752f = new LinearLayout(this.k);
            if (this.f38755i.equals("action_login")) {
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
            this.f38752f.setLayoutParams(layoutParams2);
            this.f38752f.addView(this.f38754h);
            if (textView != null) {
                this.f38752f.addView(textView);
            }
            this.f38753g = new FrameLayout(this.k);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.leftMargin = 80;
            layoutParams3.rightMargin = 80;
            layoutParams3.topMargin = 40;
            layoutParams3.bottomMargin = 40;
            layoutParams3.gravity = 17;
            this.f38753g.setLayoutParams(layoutParams3);
            this.f38753g.setBackgroundResource(17301504);
            this.f38753g.addView(this.f38752f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            StringBuilder sb = new StringBuilder(str);
            if (!TextUtils.isEmpty(this.p) && this.p.length() >= 4) {
                String str2 = this.p;
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
            String str = this.f38747a;
            String str2 = "http://qzs.qq.com/open/mobile/login/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
            f.c("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: http://qzs.qq.com/open/mobile/login/qzsjump.html?");
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, str) == null) {
            try {
                JSONObject d2 = j.d(str);
                int i2 = d2.getInt("type");
                Toast.makeText(context.getApplicationContext(), d2.getString("msg"), i2).show();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.j.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
        }
    }
}
