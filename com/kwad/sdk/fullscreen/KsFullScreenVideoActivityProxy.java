package com.kwad.sdk.fullscreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenVideoActivity;
import com.kwad.sdk.c.d;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.a.c;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.utils.o;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(KsFullScreenVideoActivity.class)
@Keep
/* loaded from: classes5.dex */
public class KsFullScreenVideoActivityProxy extends com.kwad.sdk.core.e.a<com.kwad.sdk.reward.a> {
    public static final String KEY_TEMPLATE = "key_template";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    private static final String TAG = "FullScreenVideo";
    public static KsFullScreenVideoAd.FullScreenVideoAdInteractionListener mInteractionListener;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Activity mContext;
    private DetailVideoView mDetailVideoView;
    private boolean mIsBackEnable;
    private boolean mPageDismissCalled;
    private JSONObject mReportExtData;
    private AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    private KsVideoPlayConfig mVideoPlayConfig;
    private e mPageListener = new e() { // from class: com.kwad.sdk.fullscreen.KsFullScreenVideoActivityProxy.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            KsFullScreenVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private com.kwad.sdk.reward.a.b mAdOpenInteractionListener = new c() { // from class: com.kwad.sdk.fullscreen.KsFullScreenVideoActivityProxy.2
        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void a() {
            if (KsFullScreenVideoActivityProxy.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.mInteractionListener.onAdClicked();
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void a(int i, int i2) {
            if (KsFullScreenVideoActivityProxy.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.mInteractionListener.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void a(boolean z) {
            KsFullScreenVideoActivityProxy.this.notifyPageDismiss();
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void b() {
            if (KsFullScreenVideoActivityProxy.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.mInteractionListener.onSkippedVideo();
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void c() {
            if (KsFullScreenVideoActivityProxy.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.mInteractionListener.onVideoPlayStart();
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void d() {
            if (KsFullScreenVideoActivityProxy.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.mInteractionListener.onVideoPlayEnd();
            }
        }
    };

    private boolean initData() {
        File b2;
        Serializable serializableExtra = this.mContext.getIntent().getSerializableExtra("key_video_play_config");
        if (!(serializableExtra instanceof KsVideoPlayConfig)) {
            com.kwad.sdk.core.d.a.d(TAG, "data is not instanceof VideoPlayConfigImpl:" + serializableExtra);
            return false;
        }
        Serializable serializableExtra2 = this.mContext.getIntent().getSerializableExtra("key_template");
        if (!(serializableExtra2 instanceof AdTemplate)) {
            com.kwad.sdk.core.d.a.d(TAG, "data is not instanceof AdTemplate:" + serializableExtra2);
            return false;
        }
        this.mAdTemplate = (AdTemplate) serializableExtra2;
        this.mAdInfo = com.kwad.sdk.core.response.b.c.j(this.mAdTemplate);
        String a2 = com.kwad.sdk.core.response.b.a.a(this.mAdInfo);
        if (com.kwad.sdk.core.config.c.ae() >= 0 || ((b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a2)) != null && b2.exists())) {
            this.mVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
            this.mScreenOrientation = this.mVideoPlayConfig.isShowLandscape() ? 1 : 0;
            this.mAdTemplate.mInitVoiceStatus = this.mVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
            initVideoPlayConfig(this.mVideoPlayConfig);
            return true;
        }
        return false;
    }

    private void initVideoPlayConfig(@NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        this.mContext.setRequestedOrientation(ksVideoPlayConfig.isShowLandscape() ? 0 : 1);
        if (TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            return;
        }
        this.mReportExtData = null;
        this.mReportExtData = new JSONObject();
        o.a(this.mReportExtData, "ext_showscene", ksVideoPlayConfig.getShowScene());
    }

    private void initView() {
        this.mRootContainer = (AdBaseFrameLayout) this.mContext.findViewById(R.id.ksad_root_container);
        this.mDetailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView.setAd(true);
    }

    private boolean isShowNewStyle() {
        int d = com.kwad.sdk.core.response.b.a.d(this.mAdInfo);
        int e = com.kwad.sdk.core.response.b.a.e(this.mAdInfo);
        return this.mCallerContext.e == 1 ? d <= e : d >= e;
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        adTemplate.mKsPlayerClickTimeParam = System.currentTimeMillis();
        if (!ksVideoPlayConfig.isShowLandscape()) {
            KsAdSDKImpl.putComponentProxy(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
        }
        Intent intent = new Intent(context, ksVideoPlayConfig.isShowLandscape() ? KsFullScreenLandScapeVideoActivity.class : FeedDownloadActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key_template", adTemplate);
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        mInteractionListener = fullScreenVideoAdInteractionListener;
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPageDismiss() {
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
        com.kwad.sdk.core.report.b.a(this.mAdTemplate, 6, this.mReportExtData);
        if (mInteractionListener != null) {
            mInteractionListener.onPageDismiss();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        notifyPageDismiss();
        this.mContext.finish();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        if (this.mIsBackEnable) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        this.mContext = getActivity();
        if (!initData()) {
            finish();
            return;
        }
        this.mContext.setContentView(R.layout.ksad_activity_fullscreen_video);
        initView();
        onActivityCreated(this.mRootContainer);
    }

    @Override // com.kwad.sdk.core.e.a
    protected com.kwad.sdk.reward.a onCreateCallerContext() {
        com.kwad.sdk.reward.a aVar = new com.kwad.sdk.reward.a();
        aVar.g = this.mContext;
        aVar.f10825b = this.mAdOpenInteractionListener;
        aVar.e = this.mScreenOrientation;
        aVar.c = this.mVideoPlayConfig;
        aVar.d = this.mReportExtData;
        aVar.h = this.mRootContainer;
        aVar.f = this.mAdTemplate;
        com.kwad.sdk.reward.c.a aVar2 = new com.kwad.sdk.reward.c.a(this.mAdTemplate, this.mDetailVideoView, this.mVideoPlayConfig);
        aVar.i = aVar2;
        aVar.f10824a.add(aVar2);
        if (com.kwad.sdk.core.response.b.a.y(this.mAdInfo)) {
            aVar.j = new com.kwad.sdk.core.download.b.b(this.mAdTemplate, this.mReportExtData);
        }
        aVar.k = new com.kwad.sdk.reward.b.b.a.a(this.mAdTemplate, this.mScreenOrientation);
        aVar.n.add(this.mPageListener);
        aVar.l = d.a(this.mAdTemplate, false, this.mReportExtData);
        aVar.p = false;
        return aVar;
    }

    @Override // com.kwad.sdk.core.e.a
    protected Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.reward.b.d());
        presenter.a((Presenter) new com.kwad.sdk.fullscreen.a.a.c());
        presenter.a((Presenter) new com.kwad.sdk.reward.b.b.a.b());
        if (com.kwad.sdk.core.response.b.b.o(this.mAdTemplate)) {
            presenter.a((Presenter) new com.kwad.sdk.reward.b.b.a.c());
        }
        if (com.kwad.sdk.core.response.b.a.N(this.mAdInfo)) {
            presenter.a((Presenter) new com.kwad.sdk.reward.b.b.a());
        }
        if (com.kwad.sdk.core.response.b.a.O(this.mAdInfo) && isShowNewStyle()) {
            presenter.a((Presenter) new com.kwad.sdk.reward.b.b.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.fullscreen.a.a());
        if (!com.kwad.sdk.core.response.b.c.C(this.mAdTemplate)) {
            presenter.a((Presenter) new com.kwad.sdk.fullscreen.a.b.a());
        }
        presenter.a((Presenter) new com.kwad.sdk.reward.b.c.a.a());
        if (com.kwad.sdk.core.response.b.b.p(this.mAdTemplate) || com.kwad.sdk.core.response.b.c.C(this.mAdTemplate)) {
            presenter.a((Presenter) new com.kwad.sdk.reward.b.c.a.b());
        }
        presenter.a((Presenter) new com.kwad.sdk.reward.b.a.a());
        return presenter;
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        notifyPageDismiss();
        if (this.mAdInfo != null) {
            com.kwad.sdk.core.videocache.c.a.a(getActivity()).c(com.kwad.sdk.core.response.b.a.a(this.mAdInfo));
        }
        mInteractionListener = null;
    }
}
