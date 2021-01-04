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
/* loaded from: classes5.dex */
public class FeedDownloadActivityProxy extends com.kwad.sdk.b.a implements View.OnClickListener {
    private static final boolean DEBUG = false;
    public static final String KEY_AD_DATA = "key_template";
    private static final String TAG = "FeedDownloadActivity";
    private static a.InterfaceC1090a mAdClickListener;
    private KsAdContainer mAdContainer;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.sdk.core.download.b.b mApkDownloadHelper;
    private TailFrameBarAppPortraitVertical mAppTailFrameView;
    private Activity mContext;
    private TextProgressBar mProgressBarTv;

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
        this.mAdTemplate = (AdTemplate) serializableExtra;
        this.mAdInfo = com.kwad.sdk.core.response.b.c.j(this.mAdTemplate);
        return true;
    }

    private void intiView() {
        this.mAdContainer = (KsAdContainer) this.mContext.findViewById(R.id.ksad_container);
        this.mAdContainer.setOnClickListener(this);
        this.mAppTailFrameView = (TailFrameBarAppPortraitVertical) this.mContext.findViewById(R.id.ksad_download_container);
        this.mAppTailFrameView.a(this.mAdTemplate);
        this.mAppTailFrameView.a(com.kwad.sdk.core.response.b.c.j(this.mAdTemplate));
        this.mAppTailFrameView.setVisibility(0);
        this.mProgressBarTv = this.mAppTailFrameView.getTextProgressBar();
        this.mProgressBarTv.setOnClickListener(this);
        bindDownloadListener();
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, a.InterfaceC1090a interfaceC1090a) {
        KsAdSDKImpl.putComponentProxy(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
        Intent intent = new Intent(context, FeedDownloadActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key_template", adTemplate);
        mAdClickListener = interfaceC1090a;
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.report.b.a(this.mAdTemplate, this.mAdContainer.getTouchCoords());
        if (mAdClickListener != null) {
            mAdClickListener.a();
        }
    }

    public void destroy() {
        if (this.mAppTailFrameView != null) {
            this.mAppTailFrameView.a();
            this.mAppTailFrameView.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.b.a(this.mApkDownloadHelper, view == this.mProgressBarTv);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.mAdTemplate, new a.InterfaceC1064a() { // from class: com.kwad.sdk.feed.FeedDownloadActivityProxy.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1064a
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
