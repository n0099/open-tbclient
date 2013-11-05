package defpackage;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: by  reason: default package */
/* loaded from: classes.dex */
public class by extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bw f391a;

    private by(bw bwVar) {
        this.f391a = bwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ by(bw bwVar, bz bzVar) {
        this(bwVar);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        WebView webView2;
        LinearLayout linearLayout;
        ProgressDialog progressDialog;
        ProgressDialog progressDialog2;
        boolean a2;
        if (Build.VERSION.SDK_INT < 11) {
            a2 = this.f391a.a(str);
            if (a2) {
                return;
            }
        }
        super.onPageFinished(webView, str);
        if (this.f391a.isShowing()) {
            progressDialog = this.f391a.g;
            if (progressDialog.isShowing()) {
                progressDialog2 = this.f391a.g;
                progressDialog2.dismiss();
            }
        }
        webView2 = this.f391a.h;
        webView2.setVisibility(0);
        linearLayout = this.f391a.i;
        linearLayout.setBackgroundColor(0);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        ProgressDialog progressDialog;
        ProgressDialog progressDialog2;
        boolean a2;
        if (Build.VERSION.SDK_INT < 11) {
            a2 = this.f391a.a(str);
            if (a2) {
                return;
            }
        }
        super.onPageStarted(webView, str, bitmap);
        if (this.f391a.isShowing()) {
            progressDialog = this.f391a.g;
            if (progressDialog.isShowing()) {
                return;
            }
            progressDialog2 = this.f391a.g;
            progressDialog2.show();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        IBaiduListener iBaiduListener;
        super.onReceivedError(webView, i, str, str2);
        this.f391a.dismiss();
        iBaiduListener = this.f391a.f;
        iBaiduListener.onError(new BaiduException(str));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.proceed();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean a2;
        if (Build.VERSION.SDK_INT >= 11) {
            a2 = this.f391a.a(str);
            return a2;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
