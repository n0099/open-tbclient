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
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes3.dex */
public class AdWebViewVideoActivityProxy extends IFragmentActivityProxy {
    public static final String KEY_REPORTED = "key_reported";
    public static final String KEY_TEMPLATE = "key_template";
    private AdTemplate mAdTemplate;
    private b mApkDownloadHelper;
    private a mFragment;
    private DownloadProgressBar mProgressbar;
    private ViewGroup mWebDownloadContainer;

    private void initView() {
        this.mProgressbar = (DownloadProgressBar) findViewById(R.id.ksad_web_download_progress);
        this.mWebDownloadContainer = (ViewGroup) findViewById(R.id.ksad_web_download_container);
        final AdInfo j = c.j(this.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.y(j)) {
            this.mWebDownloadContainer.setVisibility(0);
            this.mApkDownloadHelper = new b(this.mAdTemplate, new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i) {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(i);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.b.a.c(i));
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
                public void onProgressUpdate(int i) {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(i);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.b.a.a(i));
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
        if (this.mAdTemplate.adInfoList == null || this.mAdTemplate.adInfoList.size() <= 0 || this.mAdTemplate.adInfoList.get(0) == null) {
            textView.setText("详情页面");
        } else {
            AdInfo.AdBaseInfo adBaseInfo = this.mAdTemplate.adInfoList.get(0).adBaseInfo;
            if (TextUtils.isEmpty(adBaseInfo.productName)) {
                textView.setText("详情页面");
            } else {
                textView.setText(adBaseInfo.productName);
            }
        }
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
        int i = R.id.ksad_recycler_container;
        this.mFragment = a.a(this.mAdTemplate);
        this.mFragment.a(this.mApkDownloadHelper);
        getSupportFragmentManager().beginTransaction().replace(i, this.mFragment).commitAllowingStateLoss();
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return;
        }
        Intent intent = new Intent(context, BaseFragmentActivity.FragmentActivity3.class);
        intent.addFlags(268435456);
        intent.putExtra("key_template", adTemplate);
        intent.putExtra(KEY_REPORTED, adTemplate.mPvReported);
        context.startActivity(intent);
        Context delegatedContext = context instanceof ResContext ? ((ResContext) context).getDelegatedContext() : context;
        if (delegatedContext instanceof Activity) {
            ((Activity) delegatedContext).overridePendingTransition(0, 0);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        if (this.mFragment == null) {
            super.onBackPressed();
        } else if (this.mFragment.a()) {
        } else {
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
        this.mAdTemplate = (AdTemplate) serializableExtra;
        this.mAdTemplate.mPvReported = getIntent().getBooleanExtra(KEY_REPORTED, false);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        if (this.mApkDownloadHelper != null) {
            this.mApkDownloadHelper.f();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        overridePendingTransition(0, 0);
    }
}
