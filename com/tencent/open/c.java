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
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.qq.e.comm.constants.Constants;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a;
import com.tencent.open.a.g;
import com.tencent.open.b.a;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.h;
import com.tencent.open.utils.l;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.tencent.open.b implements a.InterfaceC2025a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Toast f70059c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f70060d;

    /* renamed from: e  reason: collision with root package name */
    public IUiListener f70061e;

    /* renamed from: f  reason: collision with root package name */
    public C2026c f70062f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f70063g;

    /* renamed from: h  reason: collision with root package name */
    public com.tencent.open.b.a f70064h;

    /* renamed from: i  reason: collision with root package name */
    public com.tencent.open.b.b f70065i;
    public WeakReference<Context> j;
    public int k;

    /* renamed from: com.tencent.open.c$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f70066a;

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
            this.f70066a = cVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f70066a.f70065i.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                SLog.v("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                this.f70066a.f70062f.onError(new UiError(i2, str, str2));
                if (this.f70066a.j != null && this.f70066a.j.get() != null) {
                    Toast.makeText((Context) this.f70066a.j.get(), "网络连接异常或系统错误", 0).show();
                }
                this.f70066a.dismiss();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                SLog.v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
                if (str.startsWith(h.a().a((Context) this.f70066a.j.get(), "auth://tauth.qq.com/"))) {
                    this.f70066a.f70062f.onComplete(l.c(str));
                    this.f70066a.dismiss();
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CANCEL_URI)) {
                    this.f70066a.f70062f.onCancel();
                    this.f70066a.dismiss();
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CLOSE_URI)) {
                    this.f70066a.dismiss();
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

    /* loaded from: classes2.dex */
    public class b extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f70067a;

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
            this.f70067a = cVar;
        }

        public /* synthetic */ b(c cVar, AnonymousClass1 anonymousClass1) {
            this(cVar);
        }
    }

    /* renamed from: com.tencent.open.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2026c extends DefaultUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f70068a;

        /* renamed from: b  reason: collision with root package name */
        public String f70069b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<Context> f70070c;

        /* renamed from: d  reason: collision with root package name */
        public String f70071d;

        /* renamed from: e  reason: collision with root package name */
        public IUiListener f70072e;

        public C2026c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
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
            this.f70070c = new WeakReference<>(context);
            this.f70071d = str;
            this.f70068a = str2;
            this.f70069b = str3;
            this.f70072e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iUiListener = this.f70072e) == null) {
                return;
            }
            iUiListener.onCancel();
            this.f70072e = null;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                JSONObject jSONObject = (JSONObject) obj;
                g a2 = g.a();
                a2.a(this.f70071d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.f70068a, false);
                IUiListener iUiListener = this.f70072e;
                if (iUiListener != null) {
                    iUiListener.onComplete(jSONObject);
                    this.f70072e = null;
                }
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                if (uiError.errorMessage != null) {
                    str = uiError.errorMessage + this.f70068a;
                } else {
                    str = this.f70068a;
                }
                g a2 = g.a();
                a2.a(this.f70071d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
                IUiListener iUiListener = this.f70072e;
                if (iUiListener != null) {
                    iUiListener.onError(uiError);
                    this.f70072e = null;
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

    /* loaded from: classes2.dex */
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f70073a;

        /* renamed from: b  reason: collision with root package name */
        public C2026c f70074b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c cVar, C2026c c2026c, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c2026c, looper};
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
            this.f70073a = cVar;
            this.f70074b = c2026c;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                SLog.d("openSDK_LOG.PKDialog", "msg = " + message.what);
                int i2 = message.what;
                if (i2 == 1) {
                    this.f70074b.a((String) message.obj);
                } else if (i2 == 2) {
                    this.f70074b.onCancel();
                } else if (i2 != 3) {
                    if (i2 != 5 || this.f70073a.j == null || this.f70073a.j.get() == null) {
                        return;
                    }
                    c.d((Context) this.f70073a.j.get(), (String) message.obj);
                } else if (this.f70073a.j == null || this.f70073a.j.get() == null) {
                } else {
                    c.c((Context) this.f70073a.j.get(), (String) message.obj);
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
        this.f70060d = str2;
        this.f70062f = new C2026c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f70063g = new d(this, this.f70062f, context.getMainLooper());
        this.f70061e = iUiListener;
        this.k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        SLog.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.k);
    }

    public static void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, context, str) == null) || context == null || str == null) {
            return;
        }
        try {
            JSONObject d2 = l.d(str);
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
            this.f70065i.setVerticalScrollBarEnabled(false);
            this.f70065i.setHorizontalScrollBarEnabled(false);
            this.f70065i.setWebViewClient(new a(this, null));
            this.f70065i.setWebChromeClient(this.f70050b);
            this.f70065i.clearFormData();
            WebSettings settings = this.f70065i.getSettings();
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
            this.f70049a.a(new b(this, null), "sdk_js_if");
            this.f70065i.clearView();
            this.f70065i.loadUrl(this.f70060d);
            this.f70065i.getSettings().setSavePassword(false);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            com.tencent.open.b.a aVar = new com.tencent.open.b.a(this.j.get());
            this.f70064h = aVar;
            aVar.setBackgroundColor(DebugControllerOverlayDrawable.TEXT_BACKGROUND_COLOR);
            this.f70064h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            com.tencent.open.b.b bVar = new com.tencent.open.b.b(this.j.get());
            this.f70065i = bVar;
            bVar.setBackgroundColor(0);
            this.f70065i.setBackgroundDrawable(null);
            if (Build.VERSION.SDK_INT >= 11) {
                try {
                    View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f70065i, 1, new Paint());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.k);
            layoutParams.addRule(13, -1);
            this.f70065i.setLayoutParams(layoutParams);
            this.f70064h.addView(this.f70065i);
            this.f70064h.a(this);
            setContentView(this.f70064h);
        }
    }

    @Override // com.tencent.open.b.a.InterfaceC2025a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            WeakReference<Context> weakReference = this.j;
            if (weakReference != null && weakReference.get() != null) {
                if (i2 < this.k && 2 == this.j.get().getResources().getConfiguration().orientation) {
                    this.f70065i.getLayoutParams().height = i2;
                } else {
                    this.f70065i.getLayoutParams().height = this.k;
                }
            }
            SLog.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
        }
    }

    @Override // com.tencent.open.b.a.InterfaceC2025a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f70065i.getLayoutParams().height = this.k;
            SLog.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
        }
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            SLog.d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
            try {
                this.f70049a.a(this.f70065i, str);
            } catch (Exception unused) {
            }
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
                    if (f70059c == null) {
                        f70059c = Toast.makeText(context, string, 0);
                    } else {
                        f70059c.setView(f70059c.getView());
                        f70059c.setText(string);
                        f70059c.setDuration(0);
                    }
                    f70059c.show();
                } else if (i2 == 1) {
                    if (f70059c == null) {
                        f70059c = Toast.makeText(context, string, 1);
                    } else {
                        f70059c.setView(f70059c.getView());
                        f70059c.setText(string);
                        f70059c.setDuration(1);
                    }
                    f70059c.show();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
