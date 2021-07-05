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
/* loaded from: classes7.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f41733a;

    /* renamed from: b  reason: collision with root package name */
    public b f41734b;

    /* renamed from: c  reason: collision with root package name */
    public IUiListener f41735c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f41736d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f41737e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f41738f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f41739g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f41740h;

    /* renamed from: i  reason: collision with root package name */
    public String f41741i;
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
    /* loaded from: classes7.dex */
    public class C0556a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f41745a;

        public C0556a(a aVar) {
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
            this.f41745a = aVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                f.a("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
                this.f41745a.f41739g.setVisibility(8);
                if (this.f41745a.j != null) {
                    this.f41745a.j.setVisibility(0);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f41745a.f41736d.removeCallbacks((Runnable) this.f41745a.s.remove(str));
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                f.a("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
                super.onPageStarted(webView, str, bitmap);
                this.f41745a.f41739g.setVisibility(0);
                this.f41745a.q = SystemClock.elapsedRealtime();
                if (!TextUtils.isEmpty(this.f41745a.o)) {
                    this.f41745a.f41736d.removeCallbacks((Runnable) this.f41745a.s.remove(this.f41745a.o));
                }
                this.f41745a.o = str;
                a aVar = this.f41745a;
                d dVar = new d(aVar, aVar.o);
                this.f41745a.s.put(str, dVar);
                this.f41745a.f41736d.postDelayed(dVar, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                f.c("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i2 + " | description: " + str);
                if (!j.b(this.f41745a.k)) {
                    this.f41745a.f41734b.onError(new UiError(9001, "当前网络不可用，请稍后重试！", str2));
                    this.f41745a.dismiss();
                } else if (!this.f41745a.o.startsWith("http://qzs.qq.com/open/mobile/login/qzsjump.html?")) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - this.f41745a.q;
                    if (this.f41745a.n >= 1 || elapsedRealtime >= this.f41745a.r) {
                        this.f41745a.j.loadUrl(this.f41745a.a());
                        return;
                    }
                    a.m(this.f41745a);
                    this.f41745a.f41736d.postDelayed(new Runnable(this) { // from class: com.tencent.connect.auth.a.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ C0556a f41746a;

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
                            this.f41746a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f41746a.f41745a.j.loadUrl(this.f41746a.f41745a.o);
                            }
                        }
                    }, 500L);
                } else {
                    this.f41745a.f41734b.onError(new UiError(i2, str, str2));
                    this.f41745a.dismiss();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f41745a.k);
                builder.setMessage(str);
                builder.setPositiveButton(str2, new DialogInterface.OnClickListener(this, sslErrorHandler) { // from class: com.tencent.connect.auth.a.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SslErrorHandler f41747a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ C0556a f41748b;

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
                        this.f41748b = this;
                        this.f41747a = sslErrorHandler;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                            this.f41747a.proceed();
                        }
                    }
                });
                builder.setNegativeButton(str3, new DialogInterface.OnClickListener(this, sslErrorHandler) { // from class: com.tencent.connect.auth.a.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SslErrorHandler f41749a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ C0556a f41750b;

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
                        this.f41750b = this;
                        this.f41749a = sslErrorHandler;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                            this.f41749a.cancel();
                            this.f41750b.f41745a.dismiss();
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
                    a aVar = this.f41745a;
                    aVar.m = aVar.e();
                    if (!this.f41745a.m) {
                        if (c2.optString("fail_cb", null) != null) {
                            this.f41745a.a(c2.optString("fail_cb"), "");
                        } else if (c2.optInt("fall_to_wv") == 1) {
                            a aVar2 = this.f41745a;
                            a.a(aVar2, (Object) (aVar2.f41733a.indexOf("?") > -1 ? "&" : "?"));
                            a.a(this.f41745a, (Object) "browser_error=1");
                            this.f41745a.j.loadUrl(this.f41745a.f41733a);
                        } else {
                            String optString = c2.optString("redir", null);
                            if (optString != null) {
                                this.f41745a.j.loadUrl(optString);
                            }
                        }
                    }
                    return true;
                } else if (str.startsWith("auth://tauth.qq.com/")) {
                    this.f41745a.f41734b.onComplete(j.c(str));
                    this.f41745a.dismiss();
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CANCEL_URI)) {
                    this.f41745a.f41734b.onCancel();
                    this.f41745a.dismiss();
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CLOSE_URI)) {
                    this.f41745a.dismiss();
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
                            this.f41745a.f41739g.setVisibility(8);
                            this.f41745a.j.setVisibility(0);
                        } else if (intValue == 1) {
                            this.f41745a.f41739g.setVisibility(0);
                        }
                        return true;
                    } else if (!str.startsWith("auth://onLoginSubmit")) {
                        if (this.f41745a.l.a(this.f41745a.j, str)) {
                            return true;
                        }
                        f.c("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                        return false;
                    } else {
                        try {
                            List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                            if (!pathSegments2.isEmpty()) {
                                this.f41745a.p = pathSegments2.get(0);
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
                        this.f41745a.k.startActivity(intent);
                    } catch (Exception e2) {
                        f.b("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e2);
                    }
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f41751a;

        /* renamed from: b  reason: collision with root package name */
        public String f41752b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f41753c;

        /* renamed from: d  reason: collision with root package name */
        public String f41754d;

        /* renamed from: e  reason: collision with root package name */
        public IUiListener f41755e;

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
            this.f41753c = aVar;
            this.f41754d = str;
            this.f41751a = str2;
            this.f41752b = str3;
            this.f41755e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iUiListener = this.f41755e) == null) {
                return;
            }
            iUiListener.onCancel();
            this.f41755e = null;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                JSONObject jSONObject = (JSONObject) obj;
                g a2 = g.a();
                a2.a(this.f41754d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.f41751a, false);
                IUiListener iUiListener = this.f41755e;
                if (iUiListener != null) {
                    iUiListener.onComplete(jSONObject);
                    this.f41755e = null;
                }
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                if (uiError.errorMessage != null) {
                    str = uiError.errorMessage + this.f41751a;
                } else {
                    str = this.f41751a;
                }
                g.a().a(this.f41754d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
                this.f41753c.a(str);
                IUiListener iUiListener = this.f41755e;
                if (iUiListener != null) {
                    iUiListener.onError(uiError);
                    this.f41755e = null;
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

    /* loaded from: classes7.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f41756a;

        /* renamed from: b  reason: collision with root package name */
        public b f41757b;

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
            this.f41756a = aVar;
            this.f41757b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 1) {
                    this.f41757b.a((String) message.obj);
                } else if (i2 == 2) {
                    this.f41757b.onCancel();
                } else if (i2 != 3) {
                } else {
                    a.b(this.f41756a.k, (String) message.obj);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f41758a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f41759b;

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
            this.f41759b = aVar;
            this.f41758a = "";
            this.f41758a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f.a("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f41758a + " | mRetryUrl: " + this.f41759b.o);
                if (this.f41758a.equals(this.f41759b.o)) {
                    this.f41759b.f41734b.onError(new UiError(ErrorCode.PrivateError.PARAM_ERROR, "请求页面超时，请稍后重试！", this.f41759b.o));
                    this.f41759b.dismiss();
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
        this.f41733a = str2;
        this.f41734b = new b(this, str, str2, qQToken.getAppId(), iUiListener);
        this.f41736d = new c(this, this.f41734b, context.getMainLooper());
        this.f41735c = iUiListener;
        this.f41741i = str;
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
            this.f41736d.removeCallbacksAndMessages(null);
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
                this.f41734b.onCancel();
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
            this.j.setWebViewClient(new C0556a());
            this.j.setWebChromeClient(new WebChromeClient());
            this.j.clearFormData();
            this.j.clearSslPreferences();
            this.j.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: com.tencent.connect.auth.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f41742a;

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
                    this.f41742a = this;
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
                public final /* synthetic */ a f41743a;

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
                    this.f41743a = this;
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
            f.a("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f41733a);
            String str = this.f41733a;
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
                public final /* synthetic */ a f41744a;

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
                    this.f41744a = this;
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
            aVar.f41765a = this.f41735c;
            aVar.f41766b = this;
            aVar.f41767c = c2;
            String a3 = a2.a(aVar);
            String str = this.f41733a;
            String substring = str.substring(0, str.indexOf("?"));
            Bundle b2 = j.b(this.f41733a);
            b2.putString("token_key", c2);
            b2.putString("serial", a3);
            b2.putString(BeanConstants.CHANNEL_ID_BROWSER, "1");
            String str2 = substring + "?" + HttpUtils.encodeUrl(b2);
            this.f41733a = str2;
            return j.a(this.k, str2);
        }
        return invokeV.booleanValue;
    }

    public static /* synthetic */ String a(a aVar, Object obj) {
        String str = aVar.f41733a + obj;
        aVar.f41733a = str;
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
            this.f41737e = frameLayout;
            layoutParams.gravity = 17;
            frameLayout.setLayoutParams(layoutParams);
            this.f41737e.addView(this.j);
            this.f41737e.addView(this.f41739g);
            setContentView(this.f41737e);
        }
    }

    private void c() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.f41740h = new ProgressBar(this.k);
            this.f41740h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f41738f = new LinearLayout(this.k);
            if (this.f41741i.equals("action_login")) {
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
            this.f41738f.setLayoutParams(layoutParams2);
            this.f41738f.addView(this.f41740h);
            if (textView != null) {
                this.f41738f.addView(textView);
            }
            this.f41739g = new FrameLayout(this.k);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.leftMargin = 80;
            layoutParams3.rightMargin = 80;
            layoutParams3.topMargin = 40;
            layoutParams3.bottomMargin = 40;
            layoutParams3.gravity = 17;
            this.f41739g.setLayoutParams(layoutParams3);
            this.f41739g.setBackgroundResource(17301504);
            this.f41739g.addView(this.f41738f);
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
            String str = this.f41733a;
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
