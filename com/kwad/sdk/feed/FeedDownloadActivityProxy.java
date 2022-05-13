package com.kwad.sdk.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.KsAdContainer;
import com.kwad.sdk.feed.widget.base.a;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
/* loaded from: classes5.dex */
public class FeedDownloadActivityProxy extends com.kwad.sdk.h.a implements View.OnClickListener {
    public static final boolean DEBUG = false;
    public static final String KEY_AD_DATA = "key_template_json";
    public static final String TAG = "FeedDownloadActivity";
    public static a.InterfaceC0322a sInnerAdInteractionListener;
    public KsAdContainer mAdContainer;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.sdk.core.download.a.b mApkDownloadHelper;
    public TailFrameBarAppPortraitVertical mAppTailFrameView;
    public Activity mContext;
    public TextProgressBar mProgressBarTv;

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.sdk.core.download.a.b(this.mAdTemplate, null, new c() { // from class: com.kwad.sdk.feed.FeedDownloadActivityProxy.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.a(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.a(com.kwad.sdk.core.response.a.a.b(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.a(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.a(com.kwad.sdk.core.response.a.a.A(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.a(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.a(com.kwad.sdk.core.response.a.a.a(FeedDownloadActivityProxy.this.mAdTemplate), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.a(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.a(com.kwad.sdk.core.response.a.a.A(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.a(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.a(com.kwad.sdk.core.response.a.a.m(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.a(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.a(com.kwad.sdk.core.response.a.a.a(i), i);
            }
        });
    }

    private boolean initData() {
        String stringExtra = getIntent().getStringExtra("key_template_json");
        try {
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
        AdTemplate adTemplate2 = this.mAdTemplate;
        if (adTemplate2 == null) {
            this.mContext.finish();
            return false;
        }
        this.mAdInfo = d.j(adTemplate2);
        return true;
    }

    private void intiView() {
        KsAdContainer ksAdContainer = (KsAdContainer) this.mContext.findViewById(R.id.obfuscated_res_0x7f091062);
        this.mAdContainer = ksAdContainer;
        ksAdContainer.setOnClickListener(this);
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) this.mContext.findViewById(R.id.obfuscated_res_0x7f091074);
        this.mAppTailFrameView = tailFrameBarAppPortraitVertical;
        tailFrameBarAppPortraitVertical.a(this.mAdTemplate);
        this.mAppTailFrameView.a(d.j(this.mAdTemplate));
        this.mAppTailFrameView.setVisibility(0);
        TextProgressBar textProgressBar = this.mAppTailFrameView.getTextProgressBar();
        this.mProgressBarTv = textProgressBar;
        textProgressBar.setOnClickListener(this);
        bindDownloadListener();
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, a.InterfaceC0322a interfaceC0322a) {
        KsAdSDKImpl.putComponentProxy(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
        Intent intent = new Intent(context, FeedDownloadActivity.class);
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        sInnerAdInteractionListener = interfaceC0322a;
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, this.mAdContainer.getTouchCoords());
        a.InterfaceC0322a interfaceC0322a = sInnerAdInteractionListener;
        if (interfaceC0322a != null) {
            interfaceC0322a.a();
        }
    }

    public void destroy() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.mAppTailFrameView;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.b();
            this.mAppTailFrameView.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.h.a
    public String getPageName() {
        return "FeedDownloadActivityProxy";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        com.kwad.sdk.core.download.a.a.a(new a.C0295a(view2.getContext()).a(this.mAdTemplate).a(this.mApkDownloadHelper).a(view2 == this.mProgressBarTv ? 1 : 2).a(view2 == this.mProgressBarTv).a(new a.b() { // from class: com.kwad.sdk.feed.FeedDownloadActivityProxy.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                FeedDownloadActivityProxy.this.notifyAdClick();
            }
        }));
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getActivity();
        if (!initData()) {
            this.mContext.finish();
            return;
        }
        setContentView(R.layout.obfuscated_res_0x7f0d0408);
        intiView();
    }
}
