package com.kwad.components.core.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.m.p;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes9.dex */
public class SimpleWebViewActivity extends com.kwad.components.core.i.a {
    public static final String KEY_PAGE_TITLE = "key_page_title";
    public static final String KEY_PAGE_URL = "key_page_url";
    public KsAdWebView mAdWebView;
    public TextView mTitle;
    public String title;

    private void initView() {
        this.mTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f0912c9);
        String stringExtra = getIntent().getStringExtra("key_page_title");
        this.title = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            this.mTitle.setText(this.title);
        }
        findViewById(R.id.obfuscated_res_0x7f0912cb).setVisibility(8);
        findViewById(R.id.obfuscated_res_0x7f0912ca).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.SimpleWebViewActivity.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SimpleWebViewActivity.this.finish();
            }
        });
    }

    private void initWebView() {
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f09141c);
        this.mAdWebView = ksAdWebView;
        p.b(ksAdWebView);
    }

    public static void launch(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        KsAdSDKImpl.putComponentProxy(AdWebViewActivity.class, SimpleWebViewActivity.class);
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.putExtra("key_page_url", str);
        intent.putExtra("key_page_title", str2);
        context.startActivity(intent);
    }

    private void loadUrl() {
        if (TextUtils.isEmpty(this.title)) {
            this.mAdWebView.setWebChromeClient(new com.kwad.components.core.webview.kwai.b() { // from class: com.kwad.components.core.page.SimpleWebViewActivity.2
                @Override // android.webkit.WebChromeClient
                public final void onReceivedTitle(WebView webView, String str) {
                    super.onReceivedTitle(webView, str);
                    SimpleWebViewActivity.this.mTitle.setText(str);
                }
            });
        }
        String stringExtra = getIntent().getStringExtra("key_page_url");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.mAdWebView.loadUrl(stringExtra);
    }

    @Override // com.kwad.components.core.i.a
    public String getPageName() {
        return "SimpleWebViewActivity";
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d0470);
        initView();
        initWebView();
        loadUrl();
    }
}
