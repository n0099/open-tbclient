package com.yy.open.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AssistActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_TYPE = "type";
    public static final String EXTRA_URL = "url";
    public static final String TYPE_WEB = "type_web";
    public transient /* synthetic */ FieldHolder $fh;
    public WebChromeClient chromeClient;
    public DownloadListener downloadListener;
    public FrameLayout mFrameLayout;
    public f mProgressView;
    public TextView mTextView;
    public String mURL;
    public WebView mWebView;
    public WebViewClient webviewClient;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AssistActivity f72499e;

        public a(AssistActivity assistActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {assistActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72499e = assistActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AssistActivity assistActivity = this.f72499e;
                assistActivity.mWebView.loadUrl(assistActivity.mURL);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AssistActivity f72500e;

        public b(AssistActivity assistActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {assistActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72500e = assistActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f72500e.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AssistActivity f72501a;

        public c(AssistActivity assistActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {assistActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72501a = assistActivity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f72501a.mProgressView.setVisibility(8);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                this.f72501a.mProgressView.setVisibility(0);
                this.f72501a.mWebView.setVisibility(0);
                this.f72501a.mTextView.setVisibility(8);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) && this.f72501a.mURL.equals(str2)) {
                this.f72501a.mTextView.setVisibility(0);
                this.f72501a.mWebView.setVisibility(4);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                int primaryError = sslError.getPrimaryError();
                String str = primaryError != 0 ? primaryError != 1 ? primaryError != 2 ? primaryError != 3 ? primaryError != 4 ? "发生SSL一般错误" : "证书日期无效" : "证书颁发机构不受信任" : "证书主机名不匹配" : "证书已过期" : "证书尚未生效";
                this.f72501a.mProgressView.setVisibility(0);
                this.f72501a.mWebView.setVisibility(0);
                this.f72501a.mTextView.setVisibility(8);
                this.f72501a.mTextView.setText(str);
                sslErrorHandler.cancel();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (str.startsWith(b.q.b.f.d.g(false))) {
                    try {
                        Intent intent = new Intent();
                        String queryParameter = Uri.parse(str).getQueryParameter("resCode");
                        String queryParameter2 = Uri.parse(str).getQueryParameter("resMsg");
                        String queryParameter3 = Uri.parse(str).getQueryParameter("appType");
                        if ("1".equals(queryParameter3)) {
                            String queryParameter4 = Uri.parse(str).getQueryParameter("credit");
                            String queryParameter5 = Uri.parse(str).getQueryParameter("uid");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("appType", queryParameter3);
                            jSONObject.put("credit", queryParameter4);
                            jSONObject.put("uid", queryParameter5);
                            jSONObject.put("resCode", queryParameter);
                            jSONObject.put("resMsg", queryParameter2);
                            intent.putExtra("resjson", jSONObject.toString());
                            if ("0".equals(queryParameter)) {
                                this.f72501a.setResult(444111001, intent);
                            } else {
                                this.f72501a.setResult(444222104, intent);
                            }
                        } else {
                            String queryParameter6 = Uri.parse(str).getQueryParameter("access_code");
                            String queryParameter7 = Uri.parse(str).getQueryParameter("openid");
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("appType", queryParameter3);
                            jSONObject2.put("access_code", queryParameter6);
                            jSONObject2.put("openid", queryParameter7);
                            jSONObject2.put("resCode", queryParameter);
                            jSONObject2.put("resMsg", queryParameter2);
                            intent.putExtra("resjson", jSONObject2.toString());
                            if ("0".equals(queryParameter)) {
                                this.f72501a.setResult(444111001, intent);
                            } else {
                                this.f72501a.setResult(444222104, intent);
                            }
                        }
                        this.f72501a.finish();
                        return true;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } else if (str.startsWith(b.q.b.f.d.g(true))) {
                    try {
                        Intent intent2 = new Intent();
                        String queryParameter8 = Uri.parse(str).getQueryParameter("resCode");
                        String queryParameter9 = Uri.parse(str).getQueryParameter("resMsg");
                        String queryParameter10 = Uri.parse(str).getQueryParameter("appType");
                        if ("1".equals(queryParameter10)) {
                            String queryParameter11 = Uri.parse(str).getQueryParameter("token");
                            String queryParameter12 = Uri.parse(str).getQueryParameter(TiebaStatic.YYParams.YYUID);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("appType", queryParameter10);
                            jSONObject3.put("credit", queryParameter11);
                            jSONObject3.put("uid", queryParameter12);
                            jSONObject3.put("resCode", queryParameter8);
                            jSONObject3.put("resMsg", queryParameter9);
                            intent2.putExtra("resjson", jSONObject3.toString());
                            if ("0".equals(queryParameter8)) {
                                this.f72501a.setResult(444111003, intent2);
                            } else {
                                this.f72501a.setResult(444222106, intent2);
                            }
                        } else if ("2".equals(queryParameter10)) {
                            String queryParameter13 = Uri.parse(str).getQueryParameter("token");
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("appType", queryParameter10);
                            jSONObject4.put("resCode", queryParameter8);
                            jSONObject4.put("resMsg", queryParameter9);
                            jSONObject4.put("token", queryParameter13);
                            intent2.putExtra("resjson", jSONObject4.toString());
                            if ("0".equals(queryParameter8)) {
                                this.f72501a.setResult(444222108, intent2);
                            } else {
                                this.f72501a.setResult(444222110, intent2);
                            }
                        } else {
                            String str2 = "appType:" + queryParameter10;
                            String queryParameter14 = Uri.parse(str).getQueryParameter("access_code");
                            String queryParameter15 = Uri.parse(str).getQueryParameter("openid");
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("appType", queryParameter10);
                            jSONObject5.put("access_code", queryParameter14);
                            jSONObject5.put("openid", queryParameter15);
                            jSONObject5.put("resCode", queryParameter8);
                            jSONObject5.put("resMsg", queryParameter9);
                            intent2.putExtra("resjson", jSONObject5.toString());
                            if ("0".equals(queryParameter8)) {
                                this.f72501a.setResult(444111003, intent2);
                            } else {
                                this.f72501a.setResult(444222106, intent2);
                            }
                        }
                        this.f72501a.finish();
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    return true;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AssistActivity f72502a;

        public d(AssistActivity assistActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {assistActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72502a = assistActivity;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, webView, i2) == null) {
                super.onProgressChanged(webView, i2);
                this.f72502a.mProgressView.a(i2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AssistActivity f72503a;

        public e(AssistActivity assistActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {assistActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72503a = assistActivity;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                try {
                    this.f72503a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends View {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f72504e;

        /* renamed from: f  reason: collision with root package name */
        public Paint f72505f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AssistActivity f72506g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AssistActivity assistActivity, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {assistActivity, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72506g = assistActivity;
            Paint paint = new Paint();
            this.f72505f = paint;
            paint.setColor(-731575);
            this.f72505f.setAntiAlias(true);
            this.f72505f.setStyle(Paint.Style.FILL);
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 > 100) {
                    i2 = 100;
                } else if (i2 < 0) {
                    i2 = 0;
                }
                this.f72504e = i2;
                invalidate();
            }
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
                canvas.drawColor(-5657689);
                canvas.drawRect(0.0f, 0.0f, (this.f72504e / 100.0f) * getWidth(), getHeight(), this.f72505f);
                super.onDraw(canvas);
            }
        }

        @Override // android.view.View
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
                super.onSizeChanged(i2, i3, i4, i5);
                invalidate();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AssistActivity f72507a;

        public g(AssistActivity assistActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {assistActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72507a = assistActivity;
        }

        @JavascriptInterface
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.toString() : (String) invokeV.objValue;
        }
    }

    public AssistActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.webviewClient = new c(this);
        this.chromeClient = new d(this);
        this.downloadListener = new e(this);
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            FrameLayout frameLayout = new FrameLayout(this);
            this.mFrameLayout = frameLayout;
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            f fVar = new f(this, this);
            this.mProgressView = fVar;
            fVar.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) (getResources().getDisplayMetrics().density * 4.0d), 48));
            this.mProgressView.a(50);
            int i2 = (int) (getResources().getDisplayMetrics().density * 5.0d);
            TextView textView = new TextView(this);
            this.mTextView = textView;
            textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            int i3 = i2 * 2;
            int i4 = i2 * 3;
            this.mTextView.setPadding(i3, i4, i3, i4);
            this.mTextView.setBackgroundColor(-1728053248);
            this.mTextView.setTextColor(-1);
            this.mTextView.setText("无法访问，请稍候重试");
            this.mTextView.setVisibility(8);
            this.mTextView.setOnClickListener(new a(this));
            WebView webView = new WebView(this);
            this.mWebView = webView;
            webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mFrameLayout.addView(this.mWebView);
            this.mFrameLayout.addView(this.mProgressView);
            this.mFrameLayout.addView(this.mTextView);
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(b.q.b.c.ic_back);
            imageView.setOnClickListener(new b(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(convertDipToPixels(5.0f), convertDipToPixels(5.0f), 0, 0);
            imageView.setPadding(convertDipToPixels(10.0f), convertDipToPixels(10.0f), convertDipToPixels(10.0f), convertDipToPixels(10.0f));
            this.mFrameLayout.addView(imageView, layoutParams);
            setContentView(this.mFrameLayout);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            WebSettings settings = this.mWebView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setSupportZoom(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(true);
            this.mWebView.setWebChromeClient(this.chromeClient);
            this.mWebView.setWebViewClient(this.webviewClient);
            this.mWebView.setDownloadListener(this.downloadListener);
            this.mWebView.addJavascriptInterface(new g(this), "WebBridge");
            this.mWebView.loadUrl(this.mURL);
        }
    }

    public int convertDipToPixels(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (int) ((f2 * getResources().getDisplayMetrics().density) + 0.5f) : invokeF.intValue;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setResult(0, new Intent());
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            try {
                this.mURL = getIntent().getStringExtra("url");
            } catch (Exception e2) {
                String str = "URL getStringExtra exception " + e2;
            }
            if (this.mURL == null) {
                finish();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            initView();
            initWebView();
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
