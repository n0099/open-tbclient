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
/* loaded from: classes6.dex */
public class KSRewardVideoActivityProxy extends com.kwad.sdk.core.e.a<a> {
    public static final String KEY_TEMPLATE = "key_template";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String TAG = "RewardVideo";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public Activity mContext;
    public DetailVideoView mDetailVideoView;
    public boolean mIsBackEnable;
    public boolean mPageDismissCalled;
    public JSONObject mReportExtData;
    public boolean mRewardTopBarNewStyle;
    public boolean mRewardVerifyCalled;
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public KsVideoPlayConfig mVideoPlayConfig;
    public com.kwad.sdk.reward.a.e mPageListener = new com.kwad.sdk.reward.a.e() { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    public com.kwad.sdk.reward.a.b mAdOpenInteractionListener = new com.kwad.sdk.reward.a.c() { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.2
        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void a() {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = KSRewardVideoActivityProxy.mInteractionListener;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onAdClicked();
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void a(int i, int i2) {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = KSRewardVideoActivityProxy.mInteractionListener;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void a(boolean z) {
            KSRewardVideoActivityProxy.this.notifyPageDismiss(z);
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void c() {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = KSRewardVideoActivityProxy.mInteractionListener;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onVideoPlayStart();
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void d() {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = KSRewardVideoActivityProxy.mInteractionListener;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onVideoPlayEnd();
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void e() {
            KSRewardVideoActivityProxy.this.notifyRewardVerify();
        }
    };

    private boolean initData() {
        File b2;
        String str;
        Serializable serializableExtra = this.mContext.getIntent().getSerializableExtra("key_video_play_config");
        if (serializableExtra instanceof KsVideoPlayConfig) {
            Serializable serializableExtra2 = this.mContext.getIntent().getSerializableExtra("key_template");
            if (serializableExtra2 instanceof AdTemplate) {
                AdTemplate adTemplate = (AdTemplate) serializableExtra2;
                this.mAdTemplate = adTemplate;
                AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
                this.mAdInfo = j;
                String a2 = com.kwad.sdk.core.response.b.a.a(j);
                if (com.kwad.sdk.core.config.c.ae() >= 0 || ((b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a2)) != null && b2.exists())) {
                    KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
                    this.mVideoPlayConfig = ksVideoPlayConfig;
                    this.mScreenOrientation = ksVideoPlayConfig.isShowLandscape() ? 1 : 0;
                    this.mAdTemplate.mInitVoiceStatus = this.mVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
                    initVideoPlayConfig(this.mVideoPlayConfig);
                    this.mRewardTopBarNewStyle = com.kwad.sdk.core.config.c.y();
                    return true;
                }
                return false;
            }
            str = "data is not instanceof AdTemplate:" + serializableExtra2;
        } else {
            str = "data is not instanceof VideoPlayConfigImpl:" + serializableExtra;
        }
        com.kwad.sdk.core.d.a.d(TAG, str);
        return false;
    }

    private void initVideoPlayConfig(@NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        this.mContext.setRequestedOrientation(!ksVideoPlayConfig.isShowLandscape());
        if (TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            return;
        }
        this.mReportExtData = null;
        JSONObject jSONObject = new JSONObject();
        this.mReportExtData = jSONObject;
        o.a(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
    }

    private void initView() {
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) this.mContext.findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
    }

    private boolean isShowNewStyle() {
        int d2 = com.kwad.sdk.core.response.b.a.d(this.mAdInfo);
        int e2 = com.kwad.sdk.core.response.b.a.e(this.mAdInfo);
        if (this.mCallerContext.f36221e == 1) {
            if (d2 > e2) {
                return false;
            }
        } else if (d2 < e2) {
            return false;
        }
        return true;
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
        AdTemplate adTemplate;
        JSONObject jSONObject;
        if (this.mPageDismissCalled) {
            return;
        }
        int i = 1;
        this.mPageDismissCalled = true;
        if (z) {
            adTemplate = this.mAdTemplate;
            jSONObject = this.mCallerContext.f36220d;
        } else {
            adTemplate = this.mAdTemplate;
            i = 6;
            jSONObject = this.mReportExtData;
        }
        com.kwad.sdk.core.report.b.a(adTemplate, i, jSONObject);
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onPageDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        if (this.mRewardVerifyCalled) {
            return;
        }
        this.mRewardVerifyCalled = true;
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onRewardVerify();
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
    public a onCreateCallerContext() {
        a aVar = new a();
        aVar.f36223g = this.mContext;
        aVar.f36218b = this.mAdOpenInteractionListener;
        aVar.f36221e = this.mScreenOrientation;
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        aVar.f36219c = ksVideoPlayConfig;
        aVar.f36220d = this.mReportExtData;
        aVar.f36224h = this.mRootContainer;
        AdTemplate adTemplate = this.mAdTemplate;
        aVar.f36222f = adTemplate;
        com.kwad.sdk.reward.c.a aVar2 = new com.kwad.sdk.reward.c.a(adTemplate, this.mDetailVideoView, ksVideoPlayConfig);
        aVar.i = aVar2;
        aVar.f36217a.add(aVar2);
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

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c4  */
    @Override // com.kwad.sdk.core.e.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Presenter onCreatePresenter() {
        Presenter bVar;
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
        if (!a2 || !z) {
            presenter.a((Presenter) new com.kwad.sdk.reward.b.c.a.a());
            if (com.kwad.sdk.core.response.b.b.p(this.mAdTemplate) || com.kwad.sdk.core.response.b.c.C(this.mAdTemplate)) {
                bVar = new com.kwad.sdk.reward.b.c.a.b();
            }
            presenter.a((Presenter) new com.kwad.sdk.reward.b.a.a());
            if (com.kwad.sdk.core.config.c.Q()) {
                presenter.a((Presenter) new com.kwad.sdk.reward.b.c());
            }
            return presenter;
        }
        bVar = new com.kwad.sdk.reward.b.b();
        presenter.a(bVar);
        presenter.a((Presenter) new com.kwad.sdk.reward.b.a.a());
        if (com.kwad.sdk.core.config.c.Q()) {
        }
        return presenter;
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        notifyPageDismiss(false);
        AdInfo adInfo = this.mAdInfo;
        if (adInfo != null) {
            com.kwad.sdk.core.videocache.c.a.a(getActivity()).c(com.kwad.sdk.core.response.b.a.a(adInfo));
        }
        mInteractionListener = null;
    }
}
