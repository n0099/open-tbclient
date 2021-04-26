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
import android.util.Log;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class AssistActivity extends Activity {
    public static final String EXTRA_TYPE = "type";
    public static final String EXTRA_URL = "url";
    public static final String TYPE_WEB = "type_web";
    public FrameLayout mFrameLayout;
    public f mProgressView;
    public TextView mTextView;
    public String mURL;
    public WebView mWebView;
    public WebViewClient webviewClient = new c();
    public WebChromeClient chromeClient = new d();
    public DownloadListener downloadListener = new e();

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AssistActivity assistActivity = AssistActivity.this;
            assistActivity.mWebView.loadUrl(assistActivity.mURL);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AssistActivity.this.finish();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends WebViewClient {
        public c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AssistActivity.this.mProgressView.setVisibility(8);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            AssistActivity.this.mProgressView.setVisibility(0);
            AssistActivity.this.mWebView.setVisibility(0);
            AssistActivity.this.mTextView.setVisibility(8);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            if (AssistActivity.this.mURL.equals(str2)) {
                AssistActivity.this.mTextView.setVisibility(0);
                AssistActivity.this.mWebView.setVisibility(4);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            int primaryError = sslError.getPrimaryError();
            String str = primaryError != 0 ? primaryError != 1 ? primaryError != 2 ? primaryError != 3 ? primaryError != 4 ? "发生SSL一般错误" : "证书日期无效" : "证书颁发机构不受信任" : "证书主机名不匹配" : "证书已过期" : "证书尚未生效";
            AssistActivity.this.mProgressView.setVisibility(0);
            AssistActivity.this.mWebView.setVisibility(0);
            AssistActivity.this.mTextView.setVisibility(8);
            AssistActivity.this.mTextView.setText(str);
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith(d.r.c.f.d.g(false))) {
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
                            AssistActivity.this.setResult(444111001, intent);
                        } else {
                            AssistActivity.this.setResult(444222104, intent);
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
                            AssistActivity.this.setResult(444111001, intent);
                        } else {
                            AssistActivity.this.setResult(444222104, intent);
                        }
                    }
                    AssistActivity.this.finish();
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return true;
                }
            } else if (str.startsWith(d.r.c.f.d.g(true))) {
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
                            AssistActivity.this.setResult(444111003, intent2);
                        } else {
                            AssistActivity.this.setResult(444222106, intent2);
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
                            AssistActivity.this.setResult(444222108, intent2);
                        } else {
                            AssistActivity.this.setResult(444222110, intent2);
                        }
                    } else {
                        Log.e("chenqiang", "appType:" + queryParameter10);
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
                            AssistActivity.this.setResult(444111003, intent2);
                        } else {
                            AssistActivity.this.setResult(444222106, intent2);
                        }
                    }
                    AssistActivity.this.finish();
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                return true;
            } else {
                return false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends WebChromeClient {
        public d() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            super.onProgressChanged(webView, i2);
            AssistActivity.this.mProgressView.a(i2);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements DownloadListener {
        public e() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            try {
                AssistActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends View {

        /* renamed from: e  reason: collision with root package name */
        public int f39075e;

        /* renamed from: f  reason: collision with root package name */
        public Paint f39076f;

        public f(Context context) {
            super(context);
            Paint paint = new Paint();
            this.f39076f = paint;
            paint.setColor(-731575);
            this.f39076f.setAntiAlias(true);
            this.f39076f.setStyle(Paint.Style.FILL);
        }

        public void a(int i2) {
            if (i2 > 100) {
                i2 = 100;
            } else if (i2 < 0) {
                i2 = 0;
            }
            this.f39075e = i2;
            invalidate();
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            canvas.drawColor(-5657689);
            canvas.drawRect(0.0f, 0.0f, (this.f39075e / 100.0f) * getWidth(), getHeight(), this.f39076f);
            super.onDraw(canvas);
        }

        @Override // android.view.View
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            invalidate();
        }
    }

    /* loaded from: classes7.dex */
    public class g {
        public g() {
        }

        @JavascriptInterface
        public String toString() {
            return super.toString();
        }
    }

    private void initView() {
        FrameLayout frameLayout = new FrameLayout(this);
        this.mFrameLayout = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        f fVar = new f(this);
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
        this.mTextView.setOnClickListener(new a());
        WebView webView = new WebView(this);
        this.mWebView = webView;
        webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mFrameLayout.addView(this.mWebView);
        this.mFrameLayout.addView(this.mProgressView);
        this.mFrameLayout.addView(this.mTextView);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(d.r.c.c.ic_back);
        imageView.setOnClickListener(new b());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(convertDipToPixels(5.0f), convertDipToPixels(5.0f), 0, 0);
        imageView.setPadding(convertDipToPixels(10.0f), convertDipToPixels(10.0f), convertDipToPixels(10.0f), convertDipToPixels(10.0f));
        this.mFrameLayout.addView(imageView, layoutParams);
        setContentView(this.mFrameLayout);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initWebView() {
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);
        this.mWebView.setWebChromeClient(this.chromeClient);
        this.mWebView.setWebViewClient(this.webviewClient);
        this.mWebView.setDownloadListener(this.downloadListener);
        this.mWebView.addJavascriptInterface(new g(), "WebBridge");
        this.mWebView.loadUrl(this.mURL);
    }

    public int convertDipToPixels(float f2) {
        return (int) ((f2 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0, new Intent());
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.mURL = getIntent().getStringExtra("url");
        } catch (Exception e2) {
            Log.e("YYOpenSdk", "URL getStringExtra exception " + e2);
        }
        if (this.mURL == null) {
            Log.e("YYOpenSdk", "URL Cannot Be NULL");
            finish();
            return;
        }
        initView();
        initWebView();
    }
}
