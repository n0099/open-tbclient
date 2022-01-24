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
    public AdTemplate f56518b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f56519c;

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f56520d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56521e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56522f;

    /* renamed from: g  reason: collision with root package name */
    public int f56523g = -100;

    /* renamed from: h  reason: collision with root package name */
    public int f56524h = 0;

    /* loaded from: classes3.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f56526b;
    }

    /* loaded from: classes3.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f56527b;
    }

    public h(WebView webView, com.kwad.sdk.core.webview.a aVar) {
        this.a = webView;
        this.f56518b = aVar.a();
        this.f56519c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        this.f56524h = i3;
        if (this.f56523g != i2) {
            this.f56523g = i2;
            c("onDownLoadStatusCallback", i2 + "");
        }
    }

    private void a(String str, String str2) {
        this.f56522f = new com.kwad.sdk.core.download.a.b(this.f56518b, null, str, str2);
        if (this.f56520d == null) {
            KsAppDownloadListener b2 = b();
            this.f56520d = b2;
            this.f56522f.a(b2);
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
        if (this.f56521e || TextUtils.isEmpty(str) || (webView = this.a) == null) {
            return;
        }
        bf.a(webView, str, str2);
    }

    public void a() {
        this.f56521e = true;
        com.kwad.sdk.core.download.a.b bVar = this.f56522f;
        if (bVar != null) {
            bVar.b(this.f56520d);
        }
    }

    @JavascriptInterface
    public int getDownLoadStatus(String str, String str2) {
        if (b(str, str2)) {
            return 0;
        }
        if (this.f56522f == null) {
            a(str, str2);
        }
        return this.f56522f.c();
    }

    @JavascriptInterface
    public int getProgress(String str, String str2) {
        if (b(str, str2)) {
            return 0;
        }
        if (this.f56522f == null) {
            a(str, str2);
        }
        return this.f56524h;
    }

    @JavascriptInterface
    public void handleAdClick(String str) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            if (b(aVar.a, aVar.f56526b)) {
                return;
            }
            if (this.f56522f == null) {
                a(aVar.a, aVar.f56526b);
            }
            if (this.f56522f.f()) {
                return;
            }
            this.f56522f.c(this.f56520d);
            this.f56522f.a(this.f56519c.f56375e.getContext(), true);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }
}
