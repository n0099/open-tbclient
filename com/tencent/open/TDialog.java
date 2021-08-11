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
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
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
import com.tencent.open.a.g;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.h;
import com.tencent.open.utils.l;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class TDialog extends b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final FrameLayout.LayoutParams f75904c;

    /* renamed from: d  reason: collision with root package name */
    public static Toast f75905d;

    /* renamed from: f  reason: collision with root package name */
    public static WeakReference<ProgressDialog> f75906f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Context> f75907e;

    /* renamed from: g  reason: collision with root package name */
    public String f75908g;

    /* renamed from: h  reason: collision with root package name */
    public OnTimeListener f75909h;

    /* renamed from: i  reason: collision with root package name */
    public IUiListener f75910i;

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout f75911j;
    public com.tencent.open.b.b k;
    public Handler l;
    public boolean m;
    public QQToken n;

    /* loaded from: classes10.dex */
    public class FbWebViewClient extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TDialog f75913a;

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
            this.f75913a = tDialog;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f75913a.k.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                SLog.v("openSDK_LOG.TDialog", "Webview loading URL: " + str);
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                this.f75913a.f75909h.onError(new UiError(i2, str, str2));
                if (this.f75913a.f75907e != null && this.f75913a.f75907e.get() != null) {
                    Toast.makeText((Context) this.f75913a.f75907e.get(), "网络连接异常或系统错误", 0).show();
                }
                this.f75913a.dismiss();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Uri parse;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                SLog.v("openSDK_LOG.TDialog", "Redirect URL: " + str);
                if (str.startsWith(h.a().a((Context) this.f75913a.f75907e.get(), "auth://tauth.qq.com/"))) {
                    this.f75913a.f75909h.onComplete(l.c(str));
                    if (this.f75913a.isShowing()) {
                        this.f75913a.dismiss();
                    }
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CANCEL_URI)) {
                    this.f75913a.f75909h.onCancel();
                    if (this.f75913a.isShowing()) {
                        this.f75913a.dismiss();
                    }
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CLOSE_URI)) {
                    if (this.f75913a.isShowing()) {
                        this.f75913a.dismiss();
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
                        intent.addFlags(268435456);
                        if (this.f75913a.f75907e != null && this.f75913a.f75907e.get() != null) {
                            ((Context) this.f75913a.f75907e.get()).startActivity(intent);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class JsListener extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TDialog f75914a;

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
            this.f75914a = tDialog;
        }

        public void onAddShare(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                SLog.d("openSDK_LOG.TDialog", "JsListener onAddShare");
                onComplete(str);
            }
        }

        public void onCancel(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                SLog.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
                this.f75914a.l.obtainMessage(2, str).sendToTarget();
                this.f75914a.dismiss();
            }
        }

        public void onCancelAddShare(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                SLog.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
                onCancel(QueryResponse.Options.CANCEL);
            }
        }

        public void onCancelInvite() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SLog.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
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
                this.f75914a.l.obtainMessage(1, str).sendToTarget();
                SLog.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
                this.f75914a.dismiss();
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
                this.f75914a.l.obtainMessage(4, str).sendToTarget();
            }
        }

        public void showMsg(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.f75914a.l.obtainMessage(3, str).sendToTarget();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class OnTimeListener extends DefaultUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f75915a;

        /* renamed from: b  reason: collision with root package name */
        public String f75916b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<Context> f75917c;

        /* renamed from: d  reason: collision with root package name */
        public String f75918d;

        /* renamed from: e  reason: collision with root package name */
        public IUiListener f75919e;

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
            this.f75917c = new WeakReference<>(context);
            this.f75918d = str;
            this.f75915a = str2;
            this.f75916b = str3;
            this.f75919e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iUiListener = this.f75919e) == null) {
                return;
            }
            iUiListener.onCancel();
            this.f75919e = null;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                JSONObject jSONObject = (JSONObject) obj;
                g a2 = g.a();
                a2.a(this.f75918d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.f75915a, false);
                IUiListener iUiListener = this.f75919e;
                if (iUiListener != null) {
                    iUiListener.onComplete(jSONObject);
                    this.f75919e = null;
                }
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                if (uiError.errorMessage != null) {
                    str = uiError.errorMessage + this.f75915a;
                } else {
                    str = this.f75915a;
                }
                g a2 = g.a();
                a2.a(this.f75918d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
                IUiListener iUiListener = this.f75919e;
                if (iUiListener != null) {
                    iUiListener.onError(uiError);
                    this.f75919e = null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
                try {
                    onComplete(l.d(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    onError(new UiError(-4, com.tencent.connect.common.Constants.MSG_JSON_ERROR, str));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class THandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TDialog f75920a;

        /* renamed from: b  reason: collision with root package name */
        public OnTimeListener f75921b;

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
            this.f75920a = tDialog;
            this.f75921b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                SLog.d("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
                int i2 = message.what;
                if (i2 == 1) {
                    this.f75921b.a((String) message.obj);
                } else if (i2 == 2) {
                    this.f75921b.onCancel();
                } else if (i2 != 3) {
                    if (i2 != 5 || this.f75920a.f75907e == null || this.f75920a.f75907e.get() == null) {
                        return;
                    }
                    TDialog.d((Context) this.f75920a.f75907e.get(), (String) message.obj);
                } else if (this.f75920a.f75907e == null || this.f75920a.f75907e.get() == null) {
                } else {
                    TDialog.c((Context) this.f75920a.f75907e.get(), (String) message.obj);
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
        f75904c = new FrameLayout.LayoutParams(-1, -1);
        f75905d = null;
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
        this.f75907e = new WeakReference<>(context);
        this.f75908g = str2;
        this.f75909h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.l = new THandler(this, this.f75909h, context.getMainLooper());
        this.f75910i = iUiListener;
        this.n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            OnTimeListener onTimeListener = this.f75909h;
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
            new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.tencent.open.TDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TDialog f75912a;

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
                    this.f75912a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Window window;
                    View decorView;
                    View childAt;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (window = this.f75912a.getWindow()) == null || (decorView = window.getDecorView()) == null || (childAt = ((ViewGroup) decorView).getChildAt(0)) == null) {
                        return;
                    }
                    childAt.setPadding(0, 0, 0, 0);
                }
            });
            b();
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) {
            try {
                JSONObject d2 = l.d(str);
                int i2 = d2.getInt("type");
                String string = d2.getString("msg");
                if (i2 == 0) {
                    if (f75905d == null) {
                        f75905d = Toast.makeText(context, string, 0);
                    } else {
                        f75905d.setView(f75905d.getView());
                        f75905d.setText(string);
                        f75905d.setDuration(0);
                    }
                    f75905d.show();
                } else if (i2 == 1) {
                    if (f75905d == null) {
                        f75905d = Toast.makeText(context, string, 1);
                    } else {
                        f75905d.setView(f75905d.getView());
                        f75905d.setText(string);
                        f75905d.setDuration(1);
                    }
                    f75905d.show();
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
            JSONObject d2 = l.d(str);
            int i2 = d2.getInt("action");
            String string = d2.getString("msg");
            if (i2 == 1) {
                if (f75906f != null && f75906f.get() != null) {
                    f75906f.get().setMessage(string);
                    if (!f75906f.get().isShowing()) {
                        f75906f.get().show();
                    }
                }
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setMessage(string);
                f75906f = new WeakReference<>(progressDialog);
                progressDialog.show();
            } else if (i2 == 0) {
                if (f75906f == null) {
                    return;
                }
                if (f75906f.get() != null && f75906f.get().isShowing()) {
                    f75906f.get().dismiss();
                    f75906f = null;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            new TextView(this.f75907e.get()).setText("test");
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            com.tencent.open.b.b bVar = new com.tencent.open.b.b(this.f75907e.get());
            this.k = bVar;
            bVar.setLayoutParams(layoutParams);
            FrameLayout frameLayout = new FrameLayout(this.f75907e.get());
            this.f75911j = frameLayout;
            layoutParams.gravity = 17;
            frameLayout.setLayoutParams(layoutParams);
            this.f75911j.addView(this.k);
            setContentView(this.f75911j);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.k.setVerticalScrollBarEnabled(false);
            this.k.setHorizontalScrollBarEnabled(false);
            this.k.setWebViewClient(new FbWebViewClient());
            this.k.setWebChromeClient(this.f75961b);
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
            WeakReference<Context> weakReference = this.f75907e;
            if (weakReference != null && weakReference.get() != null) {
                settings.setDatabaseEnabled(true);
                settings.setDatabasePath(this.f75907e.get().getApplicationContext().getDir("databases", 0).getPath());
            }
            settings.setDomStorageEnabled(true);
            this.f75960a.a(new JsListener(), "sdk_js_if");
            this.k.loadUrl(this.f75908g);
            this.k.setLayoutParams(f75904c);
            this.k.setVisibility(4);
            this.k.getSettings().setSavePassword(false);
        }
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            SLog.d("openSDK_LOG.TDialog", "--onConsoleMessage--");
            try {
                this.f75960a.a(this.k, str);
            } catch (Exception unused) {
            }
        }
    }
}
