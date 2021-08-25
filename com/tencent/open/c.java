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
/* loaded from: classes10.dex */
public class c extends com.tencent.open.b implements a.InterfaceC2092a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Toast f76171c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f76172d;

    /* renamed from: e  reason: collision with root package name */
    public IUiListener f76173e;

    /* renamed from: f  reason: collision with root package name */
    public C2093c f76174f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f76175g;

    /* renamed from: h  reason: collision with root package name */
    public com.tencent.open.b.a f76176h;

    /* renamed from: i  reason: collision with root package name */
    public com.tencent.open.b.b f76177i;

    /* renamed from: j  reason: collision with root package name */
    public WeakReference<Context> f76178j;
    public int k;

    /* renamed from: com.tencent.open.c$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public class a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f76179a;

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
            this.f76179a = cVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f76179a.f76177i.setVisibility(0);
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
                this.f76179a.f76174f.onError(new UiError(i2, str, str2));
                if (this.f76179a.f76178j != null && this.f76179a.f76178j.get() != null) {
                    Toast.makeText((Context) this.f76179a.f76178j.get(), "网络连接异常或系统错误", 0).show();
                }
                this.f76179a.dismiss();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                SLog.v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
                if (str.startsWith(h.a().a((Context) this.f76179a.f76178j.get(), "auth://tauth.qq.com/"))) {
                    this.f76179a.f76174f.onComplete(l.c(str));
                    this.f76179a.dismiss();
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CANCEL_URI)) {
                    this.f76179a.f76174f.onCancel();
                    this.f76179a.dismiss();
                    return true;
                } else if (str.startsWith(com.tencent.connect.common.Constants.CLOSE_URI)) {
                    this.f76179a.dismiss();
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

    /* loaded from: classes10.dex */
    public class b extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f76180a;

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
            this.f76180a = cVar;
        }

        public /* synthetic */ b(c cVar, AnonymousClass1 anonymousClass1) {
            this(cVar);
        }
    }

    /* renamed from: com.tencent.open.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2093c extends DefaultUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f76181a;

        /* renamed from: b  reason: collision with root package name */
        public String f76182b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<Context> f76183c;

        /* renamed from: d  reason: collision with root package name */
        public String f76184d;

        /* renamed from: e  reason: collision with root package name */
        public IUiListener f76185e;

        public C2093c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
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
            this.f76183c = new WeakReference<>(context);
            this.f76184d = str;
            this.f76181a = str2;
            this.f76182b = str3;
            this.f76185e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iUiListener = this.f76185e) == null) {
                return;
            }
            iUiListener.onCancel();
            this.f76185e = null;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                JSONObject jSONObject = (JSONObject) obj;
                g a2 = g.a();
                a2.a(this.f76184d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt(Constants.KEYS.RET, -6), this.f76181a, false);
                IUiListener iUiListener = this.f76185e;
                if (iUiListener != null) {
                    iUiListener.onComplete(jSONObject);
                    this.f76185e = null;
                }
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                if (uiError.errorMessage != null) {
                    str = uiError.errorMessage + this.f76181a;
                } else {
                    str = this.f76181a;
                }
                g a2 = g.a();
                a2.a(this.f76184d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
                IUiListener iUiListener = this.f76185e;
                if (iUiListener != null) {
                    iUiListener.onError(uiError);
                    this.f76185e = null;
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
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f76186a;

        /* renamed from: b  reason: collision with root package name */
        public C2093c f76187b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c cVar, C2093c c2093c, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c2093c, looper};
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
            this.f76186a = cVar;
            this.f76187b = c2093c;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                SLog.d("openSDK_LOG.PKDialog", "msg = " + message.what);
                int i2 = message.what;
                if (i2 == 1) {
                    this.f76187b.a((String) message.obj);
                } else if (i2 == 2) {
                    this.f76187b.onCancel();
                } else if (i2 != 3) {
                    if (i2 != 5 || this.f76186a.f76178j == null || this.f76186a.f76178j.get() == null) {
                        return;
                    }
                    c.d((Context) this.f76186a.f76178j.get(), (String) message.obj);
                } else if (this.f76186a.f76178j == null || this.f76186a.f76178j.get() == null) {
                } else {
                    c.c((Context) this.f76186a.f76178j.get(), (String) message.obj);
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
        this.f76178j = new WeakReference<>(context);
        this.f76172d = str2;
        this.f76174f = new C2093c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f76175g = new d(this, this.f76174f, context.getMainLooper());
        this.f76173e = iUiListener;
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
            this.f76177i.setVerticalScrollBarEnabled(false);
            this.f76177i.setHorizontalScrollBarEnabled(false);
            this.f76177i.setWebViewClient(new a(this, null));
            this.f76177i.setWebChromeClient(this.f76162b);
            this.f76177i.clearFormData();
            WebSettings settings = this.f76177i.getSettings();
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
            WeakReference<Context> weakReference = this.f76178j;
            if (weakReference != null && weakReference.get() != null) {
                settings.setDatabaseEnabled(true);
                settings.setDatabasePath(this.f76178j.get().getApplicationContext().getDir("databases", 0).getPath());
            }
            settings.setDomStorageEnabled(true);
            this.f76161a.a(new b(this, null), "sdk_js_if");
            this.f76177i.clearView();
            this.f76177i.loadUrl(this.f76172d);
            this.f76177i.getSettings().setSavePassword(false);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            com.tencent.open.b.a aVar = new com.tencent.open.b.a(this.f76178j.get());
            this.f76176h = aVar;
            aVar.setBackgroundColor(1711276032);
            this.f76176h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            com.tencent.open.b.b bVar = new com.tencent.open.b.b(this.f76178j.get());
            this.f76177i = bVar;
            bVar.setBackgroundColor(0);
            this.f76177i.setBackgroundDrawable(null);
            if (Build.VERSION.SDK_INT >= 11) {
                try {
                    View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f76177i, 1, new Paint());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.k);
            layoutParams.addRule(13, -1);
            this.f76177i.setLayoutParams(layoutParams);
            this.f76176h.addView(this.f76177i);
            this.f76176h.a(this);
            setContentView(this.f76176h);
        }
    }

    @Override // com.tencent.open.b.a.InterfaceC2092a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            WeakReference<Context> weakReference = this.f76178j;
            if (weakReference != null && weakReference.get() != null) {
                if (i2 < this.k && 2 == this.f76178j.get().getResources().getConfiguration().orientation) {
                    this.f76177i.getLayoutParams().height = i2;
                } else {
                    this.f76177i.getLayoutParams().height = this.k;
                }
            }
            SLog.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
        }
    }

    @Override // com.tencent.open.b.a.InterfaceC2092a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f76177i.getLayoutParams().height = this.k;
            SLog.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
        }
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            SLog.d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
            try {
                this.f76161a.a(this.f76177i, str);
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
                    if (f76171c == null) {
                        f76171c = Toast.makeText(context, string, 0);
                    } else {
                        f76171c.setView(f76171c.getView());
                        f76171c.setText(string);
                        f76171c.setDuration(0);
                    }
                    f76171c.show();
                } else if (i2 == 1) {
                    if (f76171c == null) {
                        f76171c = Toast.makeText(context, string, 1);
                    } else {
                        f76171c.setView(f76171c.getView());
                        f76171c.setText(string);
                        f76171c.setDuration(1);
                    }
                    f76171c.show();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
