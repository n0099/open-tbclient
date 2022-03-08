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
import android.widget.TextView;
import androidx.annotation.Keep;
import com.baidu.tieba.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.page.widget.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.widget.DownloadProgressBar;
import java.io.Serializable;
import java.util.List;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes8.dex */
public class AdWebViewVideoActivityProxy extends com.kwad.sdk.h.b {
    public static final String KEY_REPORTED = "key_reported";
    public static final String KEY_TEMPLATE = "key_template";
    public static boolean showingAdWebViewVideoActivity;
    public AdTemplate mAdTemplate;
    public com.kwad.sdk.core.download.a.b mApkDownloadHelper;
    public b mFragment;
    public DownloadProgressBar mProgressbar;
    public ViewGroup mWebDownloadContainer;

    /* JADX INFO: Access modifiers changed from: private */
    public a.C2095a getAdClickConfig(boolean z) {
        return new a.C2095a(getActivity()).a(z).b(false).a(this.mAdTemplate).d(false);
    }

    private void initView() {
        this.mProgressbar = (DownloadProgressBar) findViewById(R.id.ksad_web_download_progress);
        this.mWebDownloadContainer = (ViewGroup) findViewById(R.id.ksad_web_download_container);
        final AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.B(j2)) {
            this.mWebDownloadContainer.setVisibility(0);
            this.mApkDownloadHelper = new com.kwad.sdk.core.download.a.b(this.mAdTemplate, new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.1
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i2) {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(i2);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.b(i2));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.A(j2));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.a(AdWebViewVideoActivityProxy.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.A(j2));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.m(j2));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(i2);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.a(i2));
                }
            });
            this.mProgressbar.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdWebViewVideoActivityProxy.this.mApkDownloadHelper.a(AdWebViewVideoActivityProxy.this.getAdClickConfig(true));
                }
            });
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
                af.b(getActivity());
                com.kwad.sdk.utils.d.a(getActivity(), 0, true);
                b a = b.a(this.mAdTemplate);
                this.mFragment = a;
                a.a(this.mApkDownloadHelper);
                getSupportFragmentManager().beginTransaction().replace(R.id.ksad_recycler_container, this.mFragment).commitAllowingStateLoss();
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
        af.b(getActivity());
        com.kwad.sdk.utils.d.a(getActivity(), 0, true);
        b a2 = b.a(this.mAdTemplate);
        this.mFragment = a2;
        a2.a(this.mApkDownloadHelper);
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_recycler_container, this.mFragment).commitAllowingStateLoss();
    }

    private boolean isFormAdExitInterceptEnable() {
        if (this.mAdTemplate == null) {
            return false;
        }
        if (com.kwad.sdk.core.config.b.D() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        return com.kwad.sdk.core.config.b.E() && !this.mAdTemplate.mIsFromContent;
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return;
        }
        Intent intent = new Intent(context, BaseFragmentActivity.FragmentActivity3.class);
        intent.addFlags(268435456);
        intent.putExtra(KEY_TEMPLATE, adTemplate);
        intent.putExtra(KEY_REPORTED, adTemplate.mPvReported);
        context.startActivity(intent);
        if (context instanceof ResContext) {
            context = ((ResContext) context).getDelegatedContext();
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    private void showWaitDialog() {
        if (isFormAdExitInterceptEnable()) {
            com.kwad.sdk.core.page.widget.b bVar = new com.kwad.sdk.core.page.widget.b(getActivity(), new b.a() { // from class: com.kwad.sdk.core.page.AdWebViewVideoActivityProxy.5
                @Override // com.kwad.sdk.core.page.widget.b.a
                public void a(DialogInterface dialogInterface) {
                    com.kwad.sdk.core.report.a.f(AdWebViewVideoActivityProxy.this.mAdTemplate, 104);
                    dialogInterface.dismiss();
                }

                @Override // com.kwad.sdk.core.page.widget.b.a
                public void b(DialogInterface dialogInterface) {
                    AdWebViewVideoActivityProxy.super.onBackPressed();
                    com.kwad.sdk.core.report.a.f(AdWebViewVideoActivityProxy.this.mAdTemplate, 105);
                }

                @Override // com.kwad.sdk.core.page.widget.b.a
                public void c(DialogInterface dialogInterface) {
                    com.kwad.sdk.core.report.a.f(AdWebViewVideoActivityProxy.this.mAdTemplate, 106);
                    dialogInterface.dismiss();
                }
            });
            com.kwad.sdk.core.report.a.c(this.mAdTemplate, 103, null);
            bVar.show();
        }
    }

    @Override // com.kwad.sdk.h.b
    public String getPageName() {
        return "AdWebViewVideoActivityProxy";
    }

    @Override // com.kwad.sdk.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        b bVar = this.mFragment;
        if (bVar == null || !bVar.a_()) {
            showWaitDialog();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.sdk.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ksad_activity_ad_video_webview);
        Serializable serializableExtra = getIntent().getSerializableExtra(KEY_TEMPLATE);
        showingAdWebViewVideoActivity = true;
        if (!(serializableExtra instanceof AdTemplate)) {
            finish();
            return;
        }
        AdTemplate adTemplate = (AdTemplate) serializableExtra;
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getIntent().getBooleanExtra(KEY_REPORTED, false);
        initView();
    }

    @Override // com.kwad.sdk.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        showingAdWebViewVideoActivity = false;
        com.kwad.sdk.core.download.a.b bVar = this.mApkDownloadHelper;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        showingAdWebViewVideoActivity = false;
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.sdk.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        showingAdWebViewVideoActivity = true;
    }
}
