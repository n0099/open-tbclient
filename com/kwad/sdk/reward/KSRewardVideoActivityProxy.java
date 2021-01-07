package com.kwad.sdk.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.o;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* loaded from: classes5.dex */
public class KSRewardVideoActivityProxy extends com.kwad.sdk.core.e.a<a> {
    public static final String KEY_TEMPLATE = "key_template";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    private static final String TAG = "RewardVideo";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Activity mContext;
    private DetailVideoView mDetailVideoView;
    private boolean mIsBackEnable;
    private boolean mPageDismissCalled;
    private JSONObject mReportExtData;
    private boolean mRewardTopBarNewStyle;
    private boolean mRewardVerifyCalled;
    private AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    private KsVideoPlayConfig mVideoPlayConfig;
    private com.kwad.sdk.reward.a.e mPageListener = new com.kwad.sdk.reward.a.e() { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private com.kwad.sdk.reward.a.b mAdOpenInteractionListener = new com.kwad.sdk.reward.a.c() { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.2
        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void a() {
            if (KSRewardVideoActivityProxy.mInteractionListener != null) {
                KSRewardVideoActivityProxy.mInteractionListener.onAdClicked();
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void a(int i, int i2) {
            if (KSRewardVideoActivityProxy.mInteractionListener != null) {
                KSRewardVideoActivityProxy.mInteractionListener.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void a(boolean z) {
            KSRewardVideoActivityProxy.this.notifyPageDismiss(z);
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void c() {
            if (KSRewardVideoActivityProxy.mInteractionListener != null) {
                KSRewardVideoActivityProxy.mInteractionListener.onVideoPlayStart();
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void d() {
            if (KSRewardVideoActivityProxy.mInteractionListener != null) {
                KSRewardVideoActivityProxy.mInteractionListener.onVideoPlayEnd();
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void e() {
            KSRewardVideoActivityProxy.this.notifyRewardVerify();
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
            this.mRewardTopBarNewStyle = com.kwad.sdk.core.config.c.y();
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

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        adTemplate.mKsPlayerClickTimeParam = System.currentTimeMillis();
        Intent intent = new Intent(context, ksVideoPlayConfig.isShowLandscape() ? KSRewardLandScapeVideoActivity.class : KsRewardVideoActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key_template", adTemplate);
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        mInteractionListener = rewardAdInteractionListener;
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPageDismiss(boolean z) {
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
        if (z) {
            com.kwad.sdk.core.report.b.a(this.mAdTemplate, 1, this.mCallerContext.d);
        } else {
            com.kwad.sdk.core.report.b.a(this.mAdTemplate, 6, this.mReportExtData);
        }
        if (mInteractionListener != null) {
            mInteractionListener.onPageDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        if (this.mRewardVerifyCalled) {
            return;
        }
        this.mRewardVerifyCalled = true;
        if (mInteractionListener != null) {
            mInteractionListener.onRewardVerify();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        notifyPageDismiss(false);
        this.mContext.finish();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        if (this.mIsBackEnable) {
            notifyRewardVerify();
            super.onBackPressed();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getActivity();
        if (!initData()) {
            finish();
            return;
        }
        this.mContext.setContentView(R.layout.ksad_activity_reward_video);
        initView();
        onActivityCreated(this.mRootContainer);
    }

    @Override // com.kwad.sdk.core.e.a
    protected a onCreateCallerContext() {
        a aVar = new a();
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
        aVar.l = com.kwad.sdk.c.d.a(this.mAdTemplate, true, this.mReportExtData);
        aVar.m = new com.kwad.sdk.c.b(this.mReportExtData);
        aVar.p = true;
        aVar.q = this.mRewardTopBarNewStyle;
        return aVar;
    }

    @Override // com.kwad.sdk.core.e.a
    protected Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.reward.b.d());
        presenter.a((Presenter) new com.kwad.sdk.reward.b.a());
        presenter.a((Presenter) new com.kwad.sdk.reward.b.b.b(this.mRewardTopBarNewStyle));
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
        presenter.a((Presenter) new com.kwad.sdk.reward.b.e());
        if (!com.kwad.sdk.core.response.b.c.C(this.mAdTemplate)) {
            presenter.a((Presenter) new com.kwad.sdk.reward.b.c.a());
        }
        boolean a2 = com.kwad.sdk.core.config.c.a(this.mAdInfo);
        boolean z = com.kwad.sdk.core.response.b.a.e(this.mAdInfo) > com.kwad.sdk.core.response.b.a.d(this.mAdInfo);
        if (a2 && z) {
            presenter.a((Presenter) new com.kwad.sdk.reward.b.b());
        } else {
            presenter.a((Presenter) new com.kwad.sdk.reward.b.c.a.a());
            if (com.kwad.sdk.core.response.b.b.p(this.mAdTemplate) || com.kwad.sdk.core.response.b.c.C(this.mAdTemplate)) {
                presenter.a((Presenter) new com.kwad.sdk.reward.b.c.a.b());
            }
        }
        presenter.a((Presenter) new com.kwad.sdk.reward.b.a.a());
        if (com.kwad.sdk.core.config.c.Q()) {
            presenter.a((Presenter) new com.kwad.sdk.reward.b.c());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        notifyPageDismiss(false);
        if (this.mAdInfo != null) {
            com.kwad.sdk.core.videocache.c.a.a(getActivity()).c(com.kwad.sdk.core.response.b.a.a(this.mAdInfo));
        }
        mInteractionListener = null;
    }
}
