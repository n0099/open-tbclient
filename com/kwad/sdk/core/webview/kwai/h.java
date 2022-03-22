package com.kwad.sdk.core.webview.kwai;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bf;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h {
    public WebView a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f40120b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f40121c;

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f40122d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40123e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f40124f;

    /* renamed from: g  reason: collision with root package name */
    public int f40125g = -100;

    /* renamed from: h  reason: collision with root package name */
    public int f40126h = 0;

    /* loaded from: classes7.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f40128b;
    }

    /* loaded from: classes7.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f40129b;
    }

    public h(WebView webView, com.kwad.sdk.core.webview.a aVar) {
        this.a = webView;
        this.f40120b = aVar.a();
        this.f40121c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        this.f40126h = i2;
        if (this.f40125g != i) {
            this.f40125g = i;
            c("onDownLoadStatusCallback", i + "");
        }
    }

    private void a(String str, String str2) {
        this.f40124f = new com.kwad.sdk.core.download.a.b(this.f40120b, null, str, str2);
        if (this.f40122d == null) {
            KsAppDownloadListener b2 = b();
            this.f40122d = b2;
            this.f40124f.a(b2);
        }
    }

    private KsAppDownloadListener b() {
        return new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.core.webview.kwai.h.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                h.this.a(4, i);
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
            public void onProgressUpdate(int i) {
                if (i == 0) {
                    h.this.a(1, 0);
                } else {
                    h.this.a(2, i);
                }
            }
        };
    }

    private boolean b(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    private void c(String str, String str2) {
        WebView webView;
        if (this.f40123e || TextUtils.isEmpty(str) || (webView = this.a) == null) {
            return;
        }
        bf.a(webView, str, str2);
    }

    public void a() {
        this.f40123e = true;
        com.kwad.sdk.core.download.a.b bVar = this.f40124f;
        if (bVar != null) {
            bVar.b(this.f40122d);
        }
    }

    @JavascriptInterface
    public int getDownLoadStatus(String str, String str2) {
        if (b(str, str2)) {
            return 0;
        }
        if (this.f40124f == null) {
            a(str, str2);
        }
        return this.f40124f.c();
    }

    @JavascriptInterface
    public int getProgress(String str, String str2) {
        if (b(str, str2)) {
            return 0;
        }
        if (this.f40124f == null) {
            a(str, str2);
        }
        return this.f40126h;
    }

    @JavascriptInterface
    public void handleAdClick(String str) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            if (b(aVar.a, aVar.f40128b)) {
                return;
            }
            if (this.f40124f == null) {
                a(aVar.a, aVar.f40128b);
            }
            if (this.f40124f.f()) {
                return;
            }
            this.f40124f.c(this.f40122d);
            this.f40124f.a(this.f40121c.f39984e.getContext(), true);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }
}
