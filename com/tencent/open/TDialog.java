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
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.qq.e.comm.constants.Constants;
import com.tencent.connect.auth.QQToken;
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
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final FrameLayout.LayoutParams f41845c;

    /* renamed from: d  reason: collision with root package name */
    public static Toast f41846d;

    /* renamed from: f  reason: collision with root package name */
    public static WeakReference<ProgressDialog> f41847f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Context> f41848e;

    /* renamed from: g  reason: collision with root package name */
    public String f41849g;

    /* renamed from: h  reason: collision with root package name */
    public OnTimeListener f41850h;

    /* renamed from: i  reason: collision with root package name */
    public IUiListener f41851i;
    public FrameLayout j;
    public com.tencent.open.c.b k;
    public Handler l;
    public boolean m;
    public QQToken n;

    /* renamed from: com.tencent.open.TDialog$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class FbWebViewClient extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TDialog f41852a;

        public FbWebViewClient(TDialog tDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41852a = tDialog;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f41852a.k.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                f.a("openSDK_LOG.TDialog", "Webview loading URL: " + str);
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                this.f41852a.f41850h.onError(new UiError(i2, str, str2));
                if (this.f41852a.f41848e != null && this.f41852a.f41848e.get() != null) {
                    Toast.makeText((Context) this.f41852a.f41848e.get(), "网络连接异常或系统错误", 0).show();
                }
                this.f41852a.dismiss();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Uri parse;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                f.a("openSDK_LOG.TDialog", "Redirect URL: " + str);
                if (str.startsWith(g.a().a((Context) this.f41852a.f41848e.get(), "auth://tauth.qq.com/"))) {
                    this.f41852a.f41850h.onComplete(j.c(str));
                    if (this.f41852a.isShowing()) {
                        this.f41852a.dismiss();
                    }
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CANCEL_URI)) {
                    this.f41852a.f41850h.onCancel();
                    if (this.f41852a.isShowing()) {
                        this.f41852a.dismiss();
                    }
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CLOSE_URI)) {
                    if (this.f41852a.isShowing()) {
                        this.f41852a.dismiss();
                    }
                    return true;
                } else if (!str.startsWith(com.tencent.connect.common.Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
                    return str.startsWith("auth://progress");
                } else {
                    try {
                        if (str.startsWith(com.tencent.connect.common.Constants.DOWNLOAD_URI)) {
                            parse = Uri.parse(Uri.decode(str.substring(11)));
                        } else {
                            parse = Uri.parse(Uri.decode(str));
                        }
                        Intent intent = new Intent("android.intent.action.VIEW", parse);
                        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        if (this.f41852a.f41848e != null && this.f41852a.f41848e.get() != null) {
                            ((Context) this.f41852a.f41848e.get()).startActivity(intent);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ FbWebViewClient(TDialog tDialog, AnonymousClass1 anonymousClass1) {
            this(tDialog);
        }
    }

    /* loaded from: classes7.dex */
    public class JsListener extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TDialog f41853a;

        public JsListener(TDialog tDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41853a = tDialog;
        }

        public void onAddShare(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                f.b("openSDK_LOG.TDialog", "JsListener onAddShare");
                onComplete(str);
            }
        }

        public void onCancel(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                f.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
                this.f41853a.l.obtainMessage(2, str).sendToTarget();
                this.f41853a.dismiss();
            }
        }

        public void onCancelAddShare(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                f.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
                onCancel(QueryResponse.Options.CANCEL);
            }
        }

        public void onCancelInvite() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                f.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
                onCancel("");
            }
        }

        public void onCancelLogin() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                onCancel("");
            }
        }

        public void onComplete(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.f41853a.l.obtainMessage(1, str).sendToTarget();
                f.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
                this.f41853a.dismiss();
            }
        }

        public void onInvite(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                onComplete(str);
            }
        }

        public void onLoad(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.f41853a.l.obtainMessage(4, str).sendToTarget();
            }
        }

        public void showMsg(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.f41853a.l.obtainMessage(3, str).sendToTarget();
            }
        }

        public /* synthetic */ JsListener(TDialog tDialog, AnonymousClass1 anonymousClass1) {
            this(tDialog);
        }
    }

    /* loaded from: classes7.dex */
    public static class OnTimeListener implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f41854a;

        /* renamed from: b  reason: collision with root package name */
        public String f41855b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<Context> f41856c;

        /* renamed from: d  reason: collision with root package name */
        public String f41857d;

        /* renamed from: e  reason: collision with root package name */
        public IUiListener f41858e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
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
            this.f41856c = new WeakReference<>(context);
            this.f41857d = str;
            this.f41854a = str2;
            this.f41855b = str3;
            this.f41858e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iUiListener = this.f41858e) == null) {
                return;
            }
            iUiListener.onCancel();
            this.f41858e = null;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                JSONObject jSONObject = (JSONObject) obj;
                com.tencent.open.b.g a2 = com.tencent.open.b.g.a();
                a2.a(this.f41857d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.f41854a, false);
                IUiListener iUiListener = this.f41858e;
                if (iUiListener != null) {
                    iUiListener.onComplete(jSONObject);
                    this.f41858e = null;
                }
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                if (uiError.errorMessage != null) {
                    str = uiError.errorMessage + this.f41854a;
                } else {
                    str = this.f41854a;
                }
                com.tencent.open.b.g a2 = com.tencent.open.b.g.a();
                a2.a(this.f41857d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
                IUiListener iUiListener = this.f41858e;
                if (iUiListener != null) {
                    iUiListener.onError(uiError);
                    this.f41858e = null;
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
    public class THandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TDialog f41859a;

        /* renamed from: b  reason: collision with root package name */
        public OnTimeListener f41860b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public THandler(TDialog tDialog, OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tDialog, onTimeListener, looper};
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
            this.f41859a = tDialog;
            this.f41860b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                f.b("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
                int i2 = message.what;
                if (i2 == 1) {
                    this.f41860b.a((String) message.obj);
                } else if (i2 == 2) {
                    this.f41860b.onCancel();
                } else if (i2 != 3) {
                    if (i2 != 5 || this.f41859a.f41848e == null || this.f41859a.f41848e.get() == null) {
                        return;
                    }
                    TDialog.d((Context) this.f41859a.f41848e.get(), (String) message.obj);
                } else if (this.f41859a.f41848e == null || this.f41859a.f41848e.get() == null) {
                } else {
                    TDialog.c((Context) this.f41859a.f41848e.get(), (String) message.obj);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(919400704, "Lcom/tencent/open/TDialog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(919400704, "Lcom/tencent/open/TDialog;");
                return;
            }
        }
        f41845c = new FrameLayout.LayoutParams(-1, -1);
        f41846d = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
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
        this.m = false;
        this.n = null;
        this.f41848e = new WeakReference<>(context);
        this.f41849g = str2;
        this.f41850h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.l = new THandler(this, this.f41850h, context.getMainLooper());
        this.f41851i = iUiListener;
        this.n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            OnTimeListener onTimeListener = this.f41850h;
            if (onTimeListener != null) {
                onTimeListener.onCancel();
            }
            super.onBackPressed();
        }
    }

    @Override // com.tencent.open.b, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            a();
            b();
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
                    if (f41846d == null) {
                        f41846d = Toast.makeText(context, string, 0);
                    } else {
                        f41846d.setView(f41846d.getView());
                        f41846d.setText(string);
                        f41846d.setDuration(0);
                    }
                    f41846d.show();
                } else if (i2 == 1) {
                    if (f41846d == null) {
                        f41846d = Toast.makeText(context, string, 1);
                    } else {
                        f41846d.setView(f41846d.getView());
                        f41846d.setText(string);
                        f41846d.setDuration(1);
                    }
                    f41846d.show();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, context, str) == null) || context == null || str == null) {
            return;
        }
        try {
            JSONObject d2 = j.d(str);
            int i2 = d2.getInt("action");
            String string = d2.getString("msg");
            if (i2 == 1) {
                if (f41847f != null && f41847f.get() != null) {
                    f41847f.get().setMessage(string);
                    if (!f41847f.get().isShowing()) {
                        f41847f.get().show();
                    }
                }
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setMessage(string);
                f41847f = new WeakReference<>(progressDialog);
                progressDialog.show();
            } else if (i2 == 0) {
                if (f41847f == null) {
                    return;
                }
                if (f41847f.get() != null && f41847f.get().isShowing()) {
                    f41847f.get().dismiss();
                    f41847f = null;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            new TextView(this.f41848e.get()).setText("test");
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f41848e.get());
            this.k = bVar;
            bVar.setLayoutParams(layoutParams);
            FrameLayout frameLayout = new FrameLayout(this.f41848e.get());
            this.j = frameLayout;
            layoutParams.gravity = 17;
            frameLayout.setLayoutParams(layoutParams);
            this.j.addView(this.k);
            setContentView(this.j);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.k.setVerticalScrollBarEnabled(false);
            this.k.setHorizontalScrollBarEnabled(false);
            this.k.setWebViewClient(new FbWebViewClient(this, null));
            this.k.setWebChromeClient(this.f41907b);
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
            WeakReference<Context> weakReference = this.f41848e;
            if (weakReference != null && weakReference.get() != null) {
                settings.setDatabaseEnabled(true);
                settings.setDatabasePath(this.f41848e.get().getApplicationContext().getDir("databases", 0).getPath());
            }
            settings.setDomStorageEnabled(true);
            this.f41906a.a(new JsListener(this, null), "sdk_js_if");
            this.k.loadUrl(this.f41849g);
            this.k.setLayoutParams(f41845c);
            this.k.setVisibility(4);
            this.k.getSettings().setSavePassword(false);
        }
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            f.b("openSDK_LOG.TDialog", "--onConsoleMessage--");
            try {
                this.f41906a.a(this.k, str);
            } catch (Exception unused) {
            }
        }
    }
}
