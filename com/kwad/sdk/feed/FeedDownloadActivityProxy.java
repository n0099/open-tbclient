package com.kwad.sdk.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.KsAdContainer;
import com.kwad.sdk.feed.widget.base.a;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import java.io.Serializable;
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
/* loaded from: classes6.dex */
public class FeedDownloadActivityProxy extends com.kwad.sdk.b.a implements View.OnClickListener {
    public static final boolean DEBUG = false;
    public static final String KEY_AD_DATA = "key_template";
    public static final String TAG = "FeedDownloadActivity";
    public static a.InterfaceC0404a mAdClickListener;
    public KsAdContainer mAdContainer;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.sdk.core.download.b.b mApkDownloadHelper;
    public TailFrameBarAppPortraitVertical mAppTailFrameView;
    public Activity mContext;
    public TextProgressBar mProgressBarTv;

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.sdk.core.download.b.b(this.mAdTemplate, null, new c() { // from class: com.kwad.sdk.feed.FeedDownloadActivityProxy.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.a(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.a(com.kwad.sdk.core.response.b.a.c(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.a(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.a(com.kwad.sdk.core.response.b.a.w(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.a(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.a(com.kwad.sdk.core.response.b.a.a(FeedDownloadActivityProxy.this.mAdTemplate), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.a(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.a(com.kwad.sdk.core.response.b.a.w(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.a(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.a(com.kwad.sdk.core.response.b.a.b(), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.a(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.a(com.kwad.sdk.core.response.b.a.a(i), i);
            }
        });
    }

    private boolean initData() {
        Serializable serializableExtra = this.mContext.getIntent().getSerializableExtra("key_template");
        if (!(serializableExtra instanceof AdTemplate)) {
            this.mContext.finish();
            return false;
        }
        AdTemplate adTemplate = (AdTemplate) serializableExtra;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.c.j(adTemplate);
        return true;
    }

    private void intiView() {
        KsAdContainer ksAdContainer = (KsAdContainer) this.mContext.findViewById(R.id.ksad_container);
        this.mAdContainer = ksAdContainer;
        ksAdContainer.setOnClickListener(this);
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) this.mContext.findViewById(R.id.ksad_download_container);
        this.mAppTailFrameView = tailFrameBarAppPortraitVertical;
        tailFrameBarAppPortraitVertical.a(this.mAdTemplate);
        this.mAppTailFrameView.a(com.kwad.sdk.core.response.b.c.j(this.mAdTemplate));
        this.mAppTailFrameView.setVisibility(0);
        TextProgressBar textProgressBar = this.mAppTailFrameView.getTextProgressBar();
        this.mProgressBarTv = textProgressBar;
        textProgressBar.setOnClickListener(this);
        bindDownloadListener();
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, a.InterfaceC0404a interfaceC0404a) {
        KsAdSDKImpl.putComponentProxy(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
        Intent intent = new Intent(context, FeedDownloadActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key_template", adTemplate);
        mAdClickListener = interfaceC0404a;
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.report.b.a(this.mAdTemplate, this.mAdContainer.getTouchCoords());
        a.InterfaceC0404a interfaceC0404a = mAdClickListener;
        if (interfaceC0404a != null) {
            interfaceC0404a.a();
        }
    }

    public void destroy() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.mAppTailFrameView;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.a();
            this.mAppTailFrameView.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.b.a(this.mApkDownloadHelper, view == this.mProgressBarTv);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.mAdTemplate, new a.InterfaceC0378a() { // from class: com.kwad.sdk.feed.FeedDownloadActivityProxy.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0378a
            public void a() {
                FeedDownloadActivityProxy.this.notifyAdClick();
            }
        }, this.mApkDownloadHelper);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        this.mContext = getActivity();
        if (!initData()) {
            this.mContext.finish();
            return;
        }
        this.mContext.setContentView(R.layout.ksad_activity_feed_download);
        intiView();
    }
}
