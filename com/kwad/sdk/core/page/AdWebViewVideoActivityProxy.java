package com.kwad.sdk.core.page;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.alibaba.fastjson.asm.Label;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.d;
import com.kwad.sdk.utils.x;
import com.kwad.sdk.widget.DownloadProgressBar;
import java.io.Serializable;
import java.util.List;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes7.dex */
public class AdWebViewVideoActivityProxy extends IFragmentActivityProxy {
    public static final String KEY_REPORTED = "key_reported";
    public static final String KEY_TEMPLATE = "key_template";
    public AdTemplate mAdTemplate;
    public b mApkDownloadHelper;
    public a mFragment;
    public DownloadProgressBar mProgressbar;
    public ViewGroup mWebDownloadContainer;

    private void initView() {
        this.mProgressbar = (DownloadProgressBar) findViewById(R.id.ksad_web_download_progress);
        this.mWebDownloadContainer = (ViewGroup) findViewById(R.id.ksad_web_download_container);
        final AdInfo j = c.j(this.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.y(j)) {
            this.mWebDownloadContainer.setVisibility(0);
            this.mApkDownloadHelper = new b(this.mAdTemplate, new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(i2);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.b.a.c(i2));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.b.a.w(j));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.b.a.a(AdWebViewVideoActivityProxy.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.b.a.w(j));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.b.a.b());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(i2);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.b.a.a(i2));
                }
            });
            this.mProgressbar.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.a(AdWebViewVideoActivityProxy.this.mApkDownloadHelper, true);
                    AdWebViewVideoActivityProxy.this.mApkDownloadHelper.a(AdWebViewVideoActivityProxy.this.getActivity());
                }
            });
            this.mApkDownloadHelper.a(getActivity());
        } else {
            this.mWebDownloadContainer.setVisibility(8);
        }
        TextView textView = (TextView) findViewById(R.id.ksad_kwad_titlebar_title);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView2 = (ImageView) findViewById(R.id.ksad_kwad_web_navi_close);
        List<AdInfo> list = this.mAdTemplate.adInfoList;
        if (list != null && list.size() > 0 && this.mAdTemplate.adInfoList.get(0) != null) {
            AdInfo.AdBaseInfo adBaseInfo = this.mAdTemplate.adInfoList.get(0).adBaseInfo;
            if (!TextUtils.isEmpty(adBaseInfo.productName)) {
                textView.setText(adBaseInfo.productName);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AdWebViewVideoActivityProxy.this.finish();
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AdWebViewVideoActivityProxy.this.onBackPressed();
                    }
                });
                x.b(getActivity());
                d.a(getActivity(), 0, true);
                int i2 = R.id.ksad_recycler_container;
                a a2 = a.a(this.mAdTemplate);
                this.mFragment = a2;
                a2.a(this.mApkDownloadHelper);
                getSupportFragmentManager().beginTransaction().replace(i2, this.mFragment).commitAllowingStateLoss();
            }
        }
        textView.setText("详情页面");
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdWebViewVideoActivityProxy.this.finish();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdWebViewVideoActivityProxy.this.onBackPressed();
            }
        });
        x.b(getActivity());
        d.a(getActivity(), 0, true);
        int i22 = R.id.ksad_recycler_container;
        a a22 = a.a(this.mAdTemplate);
        this.mFragment = a22;
        a22.a(this.mApkDownloadHelper);
        getSupportFragmentManager().beginTransaction().replace(i22, this.mFragment).commitAllowingStateLoss();
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return;
        }
        Intent intent = new Intent(context, BaseFragmentActivity.FragmentActivity3.class);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtra("key_template", adTemplate);
        intent.putExtra(KEY_REPORTED, adTemplate.mPvReported);
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
        a aVar = this.mFragment;
        if (aVar == null || !aVar.a()) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.ksad_activity_ad_video_webview);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_template");
        if (!(serializableExtra instanceof AdTemplate)) {
            finish();
            return;
        }
        AdTemplate adTemplate = (AdTemplate) serializableExtra;
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getIntent().getBooleanExtra(KEY_REPORTED, false);
        initView();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.mApkDownloadHelper;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        overridePendingTransition(0, 0);
    }
}
