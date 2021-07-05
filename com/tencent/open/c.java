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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import com.tencent.connect.auth.QQToken;
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
public class c extends com.tencent.open.b implements a.InterfaceC0565a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Toast f41946c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f41947d;

    /* renamed from: e  reason: collision with root package name */
    public IUiListener f41948e;

    /* renamed from: f  reason: collision with root package name */
    public C0566c f41949f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f41950g;

    /* renamed from: h  reason: collision with root package name */
    public com.tencent.open.c.a f41951h;

    /* renamed from: i  reason: collision with root package name */
    public com.tencent.open.c.b f41952i;
    public WeakReference<Context> j;
    public int k;

    /* renamed from: com.tencent.open.c$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f41957a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41957a = cVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f41957a.f41952i.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                f.a("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                this.f41957a.f41949f.onError(new UiError(i2, str, str2));
                if (this.f41957a.j != null && this.f41957a.j.get() != null) {
                    Toast.makeText((Context) this.f41957a.j.get(), "网络连接异常或系统错误", 0).show();
                }
                this.f41957a.dismiss();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                f.a("openSDK_LOG.PKDialog", "Redirect URL: " + str);
                if (str.startsWith(g.a().a((Context) this.f41957a.j.get(), "auth://tauth.qq.com/"))) {
                    this.f41957a.f41949f.onComplete(j.c(str));
                    this.f41957a.dismiss();
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CANCEL_URI)) {
                    this.f41957a.f41949f.onCancel();
                    this.f41957a.dismiss();
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CLOSE_URI)) {
                    this.f41957a.dismiss();
                    return true;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ a(c cVar, AnonymousClass1 anonymousClass1) {
            this(cVar);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f41958a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41958a = cVar;
        }

        public /* synthetic */ b(c cVar, AnonymousClass1 anonymousClass1) {
            this(cVar);
        }
    }

    /* renamed from: com.tencent.open.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0566c implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f41962a;

        /* renamed from: b  reason: collision with root package name */
        public String f41963b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<Context> f41964c;

        /* renamed from: d  reason: collision with root package name */
        public String f41965d;

        /* renamed from: e  reason: collision with root package name */
        public IUiListener f41966e;

        public C0566c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, str2, str3, iUiListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41964c = new WeakReference<>(context);
            this.f41965d = str;
            this.f41962a = str2;
            this.f41963b = str3;
            this.f41966e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iUiListener = this.f41966e) == null) {
                return;
            }
            iUiListener.onCancel();
            this.f41966e = null;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                JSONObject jSONObject = (JSONObject) obj;
                com.tencent.open.b.g a2 = com.tencent.open.b.g.a();
                a2.a(this.f41965d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.f41962a, false);
                IUiListener iUiListener = this.f41966e;
                if (iUiListener != null) {
                    iUiListener.onComplete(jSONObject);
                    this.f41966e = null;
                }
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                if (uiError.errorMessage != null) {
                    str = uiError.errorMessage + this.f41962a;
                } else {
                    str = this.f41962a;
                }
                com.tencent.open.b.g a2 = com.tencent.open.b.g.a();
                a2.a(this.f41965d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
                IUiListener iUiListener = this.f41966e;
                if (iUiListener != null) {
                    iUiListener.onError(uiError);
                    this.f41966e = null;
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
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f41967a;

        /* renamed from: b  reason: collision with root package name */
        public C0566c f41968b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c cVar, C0566c c0566c, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c0566c, looper};
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
            this.f41967a = cVar;
            this.f41968b = c0566c;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                f.b("openSDK_LOG.PKDialog", "msg = " + message.what);
                int i2 = message.what;
                if (i2 == 1) {
                    this.f41968b.a((String) message.obj);
                } else if (i2 == 2) {
                    this.f41968b.onCancel();
                } else if (i2 != 3) {
                    if (i2 != 5 || this.f41967a.j == null || this.f41967a.j.get() == null) {
                        return;
                    }
                    c.d((Context) this.f41967a.j.get(), (String) message.obj);
                } else if (this.f41967a.j == null || this.f41967a.j.get() == null) {
                } else {
                    c.c((Context) this.f41967a.j.get(), (String) message.obj);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1074746617, "Lcom/tencent/open/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1074746617, "Lcom/tencent/open/c;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, iUiListener, qQToken};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = new WeakReference<>(context);
        this.f41947d = str2;
        this.f41949f = new C0566c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f41950g = new d(this, this.f41949f, context.getMainLooper());
        this.f41948e = iUiListener;
        this.k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        f.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.k);
    }

    public static void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, context, str) == null) || context == null || str == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // com.tencent.open.b, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            getWindow().setSoftInputMode(16);
            getWindow().setSoftInputMode(1);
            b();
            c();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f41952i.setVerticalScrollBarEnabled(false);
            this.f41952i.setHorizontalScrollBarEnabled(false);
            this.f41952i.setWebViewClient(new a(this, null));
            this.f41952i.setWebChromeClient(this.f41907b);
            this.f41952i.clearFormData();
            WebSettings settings = this.f41952i.getSettings();
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
            this.f41906a.a(new b(this, null), "sdk_js_if");
            this.f41952i.clearView();
            this.f41952i.loadUrl(this.f41947d);
            this.f41952i.getSettings().setSavePassword(false);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            com.tencent.open.c.a aVar = new com.tencent.open.c.a(this.j.get());
            this.f41951h = aVar;
            aVar.setBackgroundColor(1711276032);
            this.f41951h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.j.get());
            this.f41952i = bVar;
            bVar.setBackgroundColor(0);
            this.f41952i.setBackgroundDrawable(null);
            if (Build.VERSION.SDK_INT >= 11) {
                try {
                    View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f41952i, 1, new Paint());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.k);
            layoutParams.addRule(13, -1);
            this.f41952i.setLayoutParams(layoutParams);
            this.f41951h.addView(this.f41952i);
            this.f41951h.a(this);
            setContentView(this.f41951h);
        }
    }

    @Override // com.tencent.open.c.a.InterfaceC0565a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            WeakReference<Context> weakReference = this.j;
            if (weakReference != null && weakReference.get() != null) {
                if (i2 < this.k && 2 == this.j.get().getResources().getConfiguration().orientation) {
                    this.f41952i.getLayoutParams().height = i2;
                } else {
                    this.f41952i.getLayoutParams().height = this.k;
                }
            }
            f.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
        }
    }

    @Override // com.tencent.open.c.a.InterfaceC0565a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f41952i.getLayoutParams().height = this.k;
            f.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
        }
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            f.b("openSDK_LOG.PKDialog", "--onConsoleMessage--");
            try {
                this.f41906a.a(this.f41952i, str);
            } catch (Exception unused) {
            }
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) {
            try {
                JSONObject d2 = j.d(str);
                int i2 = d2.getInt("type");
                String string = d2.getString("msg");
                if (i2 == 0) {
                    if (f41946c == null) {
                        f41946c = Toast.makeText(context, string, 0);
                    } else {
                        f41946c.setView(f41946c.getView());
                        f41946c.setText(string);
                        f41946c.setDuration(0);
                    }
                    f41946c.show();
                } else if (i2 == 1) {
                    if (f41946c == null) {
                        f41946c = Toast.makeText(context, string, 1);
                    } else {
                        f41946c.setView(f41946c.getView());
                        f41946c.setText(string);
                        f41946c.setDuration(1);
                    }
                    f41946c.show();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
