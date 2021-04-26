package com.kwad.sdk.core.page;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.alibaba.fastjson.asm.Label;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.page.widget.b;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes6.dex */
public class AdWebViewActivityProxy extends com.kwad.sdk.b.a {
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String TAG = "AdWebViewActivityProxy";
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public ViewGroup mWebContainer;
    public ImageView mWebTipBarCloseBtn;
    public LinearLayout mWebTipBarLayout;
    public TextView mWebTipBarTitle;

    private void handlerLandingPageAtEndCard(KsAdWebView ksAdWebView) {
        o.a aVar = new o.a();
        aVar.l = 0;
        ksAdWebView.setClientParams(aVar);
    }

    private void initTipBarView() {
        this.mWebTipBarLayout = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        this.mWebTipBarTitle = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.mWebTipBarCloseBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdWebViewActivityProxy.this.mWebTipBarLayout.setVisibility(8);
            }
        });
        AdInfo g2 = c.g(this.mAdTemplate);
        boolean T = com.kwad.sdk.core.response.b.a.T(g2);
        String R = com.kwad.sdk.core.response.b.a.R(g2);
        if (!T) {
            this.mWebTipBarLayout.setVisibility(8);
            return;
        }
        this.mWebTipBarLayout.setVisibility(0);
        this.mWebTipBarTitle.setText(R);
        this.mWebTipBarTitle.setSelected(true);
    }

    private void initView() {
        AdInfo.AdBaseInfo adBaseInfo;
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
        this.mAdWebView = ksAdWebView;
        handlerLandingPageAtEndCard(ksAdWebView);
        this.mAdWebView.setTemplateData(this.mAdTemplate);
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.a.y(c.g(this.mAdTemplate)));
        this.mAdWebView.a();
        this.mAdWebView.setOnWebViewScrollChangeListener(new KsAdWebView.c() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.c
            public void a(View view, int i2, int i3, int i4, int i5) {
                if (AdWebViewActivityProxy.this.mWebTipBarLayout.getVisibility() == 0) {
                    AdWebViewActivityProxy.this.mWebTipBarLayout.setVisibility(8);
                }
            }
        });
        TextView textView = (TextView) findViewById(R.id.ksad_kwad_titlebar_title);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView2 = (ImageView) findViewById(R.id.ksad_kwad_web_navi_close);
        this.mWebContainer = (ViewGroup) findViewById(R.id.ksad_landing_page_root);
        List<AdInfo> list = this.mAdTemplate.adInfoList;
        if (list == null || list.size() <= 0 || this.mAdTemplate.adInfoList.get(0) == null || (adBaseInfo = this.mAdTemplate.adInfoList.get(0).adBaseInfo) == null || TextUtils.isEmpty(adBaseInfo.productName)) {
            textView.setText("详情页面");
        } else {
            textView.setText(adBaseInfo.productName);
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AdWebViewActivityProxy.this.isFormAdExitInterceptEnable()) {
                    AdWebViewActivityProxy.this.finish();
                    return;
                }
                b bVar = new b(AdWebViewActivityProxy.this.getActivity(), new b.a() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.2.1
                    @Override // com.kwad.sdk.core.page.widget.b.a
                    public void a(DialogInterface dialogInterface) {
                        com.kwad.sdk.core.report.b.c(AdWebViewActivityProxy.this.mAdTemplate, 104);
                        dialogInterface.dismiss();
                    }

                    @Override // com.kwad.sdk.core.page.widget.b.a
                    public void b(DialogInterface dialogInterface) {
                        AdWebViewActivityProxy.this.finish();
                        com.kwad.sdk.core.report.b.c(AdWebViewActivityProxy.this.mAdTemplate, 105);
                    }

                    @Override // com.kwad.sdk.core.page.widget.b.a
                    public void c(DialogInterface dialogInterface) {
                        com.kwad.sdk.core.report.b.c(AdWebViewActivityProxy.this.mAdTemplate, 106);
                        dialogInterface.dismiss();
                    }
                });
                com.kwad.sdk.core.report.b.c(AdWebViewActivityProxy.this.mAdTemplate, 103, null);
                bVar.show();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdWebViewActivityProxy.this.onBackPressed();
            }
        });
        initTipBarView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFormAdExitInterceptEnable() {
        AdTemplate adTemplate;
        return com.kwad.sdk.core.config.c.z() && (adTemplate = this.mAdTemplate) != null && adTemplate.mIsFromContent;
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return;
        }
        KsAdSDKImpl.putComponentProxy(AdWebViewActivity.class, AdWebViewActivityProxy.class);
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        context.startActivity(intent);
        if (context instanceof ResContext) {
            context = ((ResContext) context).getDelegatedContext();
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.mAdWebView.goBack();
            com.kwad.sdk.core.report.b.k(this.mAdTemplate);
        } else if (!isFormAdExitInterceptEnable()) {
            super.onBackPressed();
        } else {
            b bVar = new b(getActivity(), new b.a() { // from class: com.kwad.sdk.core.page.AdWebViewActivityProxy.5
                @Override // com.kwad.sdk.core.page.widget.b.a
                public void a(DialogInterface dialogInterface) {
                    com.kwad.sdk.core.report.b.c(AdWebViewActivityProxy.this.mAdTemplate, 104);
                    dialogInterface.dismiss();
                }

                @Override // com.kwad.sdk.core.page.widget.b.a
                public void b(DialogInterface dialogInterface) {
                    AdWebViewActivityProxy.super.onBackPressed();
                    com.kwad.sdk.core.report.b.c(AdWebViewActivityProxy.this.mAdTemplate, 105);
                }

                @Override // com.kwad.sdk.core.page.widget.b.a
                public void c(DialogInterface dialogInterface) {
                    com.kwad.sdk.core.report.b.c(AdWebViewActivityProxy.this.mAdTemplate, 106);
                    dialogInterface.dismiss();
                }
            });
            com.kwad.sdk.core.report.b.c(this.mAdTemplate, 103, null);
            bVar.show();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.ksad_activity_ad_webview);
        String stringExtra = getIntent().getStringExtra("key_template_json");
        try {
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
        if (this.mAdTemplate != null) {
            initView();
        } else {
            finish();
        }
    }

    @Override // com.kwad.sdk.b.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.b();
        }
        super.onDestroy();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        overridePendingTransition(0, 0);
    }
}
