package com.kwad.sdk.core.webview.kwai;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bf;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    public WebView a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f56473b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f56474c;

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f56475d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56476e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56477f;

    /* renamed from: g  reason: collision with root package name */
    public int f56478g = -100;

    /* renamed from: h  reason: collision with root package name */
    public int f56479h = 0;

    /* loaded from: classes3.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f56481b;
    }

    /* loaded from: classes3.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f56482b;
    }

    public h(WebView webView, com.kwad.sdk.core.webview.a aVar) {
        this.a = webView;
        this.f56473b = aVar.a();
        this.f56474c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        this.f56479h = i3;
        if (this.f56478g != i2) {
            this.f56478g = i2;
            c("onDownLoadStatusCallback", i2 + "");
        }
    }

    private void a(String str, String str2) {
        this.f56477f = new com.kwad.sdk.core.download.a.b(this.f56473b, null, str, str2);
        if (this.f56475d == null) {
            KsAppDownloadListener b2 = b();
            this.f56475d = b2;
            this.f56477f.a(b2);
        }
    }

    private KsAppDownloadListener b() {
        return new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.core.webview.kwai.h.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                h.this.a(4, i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                h.this.a(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                h.this.a(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                h.this.a(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                h.this.a(12, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                if (i2 == 0) {
                    h.this.a(1, 0);
                } else {
                    h.this.a(2, i2);
                }
            }
        };
    }

    private boolean b(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    private void c(String str, String str2) {
        WebView webView;
        if (this.f56476e || TextUtils.isEmpty(str) || (webView = this.a) == null) {
            return;
        }
        bf.a(webView, str, str2);
    }

    public void a() {
        this.f56476e = true;
        com.kwad.sdk.core.download.a.b bVar = this.f56477f;
        if (bVar != null) {
            bVar.b(this.f56475d);
        }
    }

    @JavascriptInterface
    public int getDownLoadStatus(String str, String str2) {
        if (b(str, str2)) {
            return 0;
        }
        if (this.f56477f == null) {
            a(str, str2);
        }
        return this.f56477f.c();
    }

    @JavascriptInterface
    public int getProgress(String str, String str2) {
        if (b(str, str2)) {
            return 0;
        }
        if (this.f56477f == null) {
            a(str, str2);
        }
        return this.f56479h;
    }

    @JavascriptInterface
    public void handleAdClick(String str) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            if (b(aVar.a, aVar.f56481b)) {
                return;
            }
            if (this.f56477f == null) {
                a(aVar.a, aVar.f56481b);
            }
            if (this.f56477f.f()) {
                return;
            }
            this.f56477f.c(this.f56475d);
            this.f56477f.a(this.f56474c.f56330e.getContext(), true);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }
}
