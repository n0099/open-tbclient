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
import com.baidu.searchbox.IntentConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.qfc;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AssistActivity extends Activity {
    public FrameLayout a;
    public WebView b;
    public TextView c;
    public f d;
    public String e;
    public WebViewClient f = new c();
    public WebChromeClient g = new d();
    public DownloadListener h = new e();

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AssistActivity assistActivity = AssistActivity.this;
            assistActivity.b.loadUrl(assistActivity.e);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AssistActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public class c extends WebViewClient {
        public c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AssistActivity.this.d.setVisibility(8);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            AssistActivity.this.d.setVisibility(0);
            AssistActivity.this.b.setVisibility(0);
            AssistActivity.this.c.setVisibility(8);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (AssistActivity.this.e.equals(str2)) {
                AssistActivity.this.c.setVisibility(0);
                AssistActivity.this.b.setVisibility(4);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            int primaryError = sslError.getPrimaryError();
            if (primaryError != 0) {
                if (primaryError != 1) {
                    if (primaryError != 2) {
                        if (primaryError != 3) {
                            if (primaryError != 4) {
                                str = "发生SSL一般错误";
                            } else {
                                str = "证书日期无效";
                            }
                        } else {
                            str = "证书颁发机构不受信任";
                        }
                    } else {
                        str = "证书主机名不匹配";
                    }
                } else {
                    str = "证书已过期";
                }
            } else {
                str = "证书尚未生效";
            }
            AssistActivity.this.d.setVisibility(0);
            AssistActivity.this.b.setVisibility(0);
            AssistActivity.this.c.setVisibility(8);
            AssistActivity.this.c.setText(str);
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith(qfc.g(false))) {
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
                } catch (JSONException e) {
                    e.printStackTrace();
                    return true;
                }
            } else if (!str.startsWith(qfc.g(true))) {
                return false;
            } else {
                try {
                    Intent intent2 = new Intent();
                    String queryParameter8 = Uri.parse(str).getQueryParameter("resCode");
                    String queryParameter9 = Uri.parse(str).getQueryParameter("resMsg");
                    String queryParameter10 = Uri.parse(str).getQueryParameter("appType");
                    if ("1".equals(queryParameter10)) {
                        String queryParameter11 = Uri.parse(str).getQueryParameter("token");
                        String queryParameter12 = Uri.parse(str).getQueryParameter("yyuid");
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
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return true;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends WebChromeClient {
        public d() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            AssistActivity.this.d.a(i);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements DownloadListener {
        public e() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            try {
                AssistActivity.this.startActivity(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends View {
        public int a;
        public Paint b;

        public f(Context context) {
            super(context);
            Paint paint = new Paint();
            this.b = paint;
            paint.setColor(-731575);
            this.b.setAntiAlias(true);
            this.b.setStyle(Paint.Style.FILL);
        }

        public void a(int i) {
            if (i > 100) {
                i = 100;
            } else if (i < 0) {
                i = 0;
            }
            this.a = i;
            invalidate();
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            canvas.drawColor(-5657689);
            canvas.drawRect(0.0f, 0.0f, (this.a / 100.0f) * getWidth(), getHeight(), this.b);
            super.onDraw(canvas);
        }

        @Override // android.view.View
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            invalidate();
        }
    }

    /* loaded from: classes2.dex */
    public class g {
        public g() {
        }

        @JavascriptInterface
        public String toString() {
            return super.toString();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0, new Intent());
        super.onBackPressed();
    }

    public int a(float f2) {
        return (int) ((f2 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void b() {
        FrameLayout frameLayout = new FrameLayout(this);
        this.a = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        f fVar = new f(this);
        this.d = fVar;
        fVar.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) (getResources().getDisplayMetrics().density * 4.0d), 48));
        this.d.a(50);
        int i = (int) (getResources().getDisplayMetrics().density * 5.0d);
        TextView textView = new TextView(this);
        this.c = textView;
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        int i2 = i * 2;
        int i3 = i * 3;
        this.c.setPadding(i2, i3, i2, i3);
        this.c.setBackgroundColor(-1728053248);
        this.c.setTextColor(-1);
        this.c.setText("无法访问，请稍候重试");
        this.c.setVisibility(8);
        this.c.setOnClickListener(new a());
        WebView webView = new WebView(this);
        this.b = webView;
        webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.a.addView(this.b);
        this.a.addView(this.d);
        this.a.addView(this.c);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.ic_back);
        imageView.setOnClickListener(new b());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(a(5.0f), a(5.0f), 0, 0);
        imageView.setPadding(a(10.0f), a(10.0f), a(10.0f), a(10.0f));
        this.a.addView(imageView, layoutParams);
        setContentView(this.a);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void c() {
        WebSettings settings = this.b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);
        this.b.setWebChromeClient(this.g);
        this.b.setWebViewClient(this.f);
        this.b.setDownloadListener(this.h);
        this.b.addJavascriptInterface(new g(), "WebBridge");
        this.b.loadUrl(this.e);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.e = getIntent().getStringExtra("url");
        } catch (Exception e2) {
            Log.e("YYOpenSdk", "URL getStringExtra exception " + e2);
        }
        if (this.e == null) {
            Log.e("YYOpenSdk", "URL Cannot Be NULL");
            finish();
            return;
        }
        b();
        c();
    }
}
