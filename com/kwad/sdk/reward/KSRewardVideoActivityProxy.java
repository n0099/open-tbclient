package com.kwad.sdk.reward;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.asm.Label;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.loader.Wrapper;
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
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String TAG = "RewardVideo";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public boolean mIsBackEnable;
    public boolean mPageDismissCalled;
    public JSONObject mReportExtData;
    public boolean mRewardTopBarNewStyle;
    public boolean mRewardVerifyCalled;
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public KsVideoPlayConfig mVideoPlayConfig;
    public com.kwad.sdk.reward.a.f mPageListener = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.1
        @Override // com.kwad.sdk.reward.a.f
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
        public void a(int i2, int i3) {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = KSRewardVideoActivityProxy.mInteractionListener;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onVideoPlayError(i2, i3);
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
        Serializable serializableExtra = getIntent().getSerializableExtra("key_video_play_config");
        if (serializableExtra instanceof KsVideoPlayConfig) {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            try {
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(stringExtra));
                this.mAdTemplate = adTemplate;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
            AdTemplate adTemplate2 = this.mAdTemplate;
            if (adTemplate2 != null) {
                AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate2);
                this.mAdInfo = g2;
                String a2 = com.kwad.sdk.core.response.b.a.a(g2);
                if (com.kwad.sdk.core.config.c.y() >= 0 || ((b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a2)) != null && b2.exists())) {
                    KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
                    this.mVideoPlayConfig = ksVideoPlayConfig;
                    this.mScreenOrientation = ksVideoPlayConfig.isShowLandscape() ? 1 : 0;
                    this.mAdTemplate.mInitVoiceStatus = this.mVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
                    initVideoPlayConfig(this.mVideoPlayConfig);
                    this.mRewardTopBarNewStyle = com.kwad.sdk.core.config.c.k();
                    return true;
                }
                return false;
            }
            str = "data is null:" + stringExtra;
        } else {
            str = "data is not instanceof VideoPlayConfigImpl:" + serializableExtra;
        }
        com.kwad.sdk.core.d.a.e(TAG, str);
        return false;
    }

    private void initVideoPlayConfig(@NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        getActivity().setRequestedOrientation(!ksVideoPlayConfig.isShowLandscape());
        if (TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            return;
        }
        this.mReportExtData = null;
        JSONObject jSONObject = new JSONObject();
        this.mReportExtData = jSONObject;
        o.a(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
    }

    private void initView() {
        DetailVideoView detailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
    }

    private boolean isShowNewStyle() {
        int d2 = com.kwad.sdk.core.response.b.a.d(this.mAdInfo);
        int e2 = com.kwad.sdk.core.response.b.a.e(this.mAdInfo);
        if (this.mCallerContext.f33494e == 1) {
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
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
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
        int i2 = 1;
        this.mPageDismissCalled = true;
        if (z) {
            adTemplate = this.mAdTemplate;
            jSONObject = this.mCallerContext.f33493d;
        } else {
            adTemplate = this.mAdTemplate;
            i2 = 6;
            jSONObject = this.mReportExtData;
        }
        com.kwad.sdk.core.report.b.a(adTemplate, i2, jSONObject);
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
        f.a(this.mAdTemplate, this.mAdInfo);
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onRewardVerify();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        notifyPageDismiss(false);
        getActivity().finish();
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
        this.mContext = Wrapper.wrapContextIfNeed(getActivity());
        if (!initData()) {
            finish();
            return;
        }
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) View.inflate(this.mContext, R.layout.ksad_activity_reward_video, null);
        this.mRootContainer = adBaseFrameLayout;
        setContentView(adBaseFrameLayout);
        initView();
        onActivityCreated(this.mRootContainer);
    }

    @Override // com.kwad.sdk.core.e.a
    public a onCreateCallerContext() {
        a aVar = new a();
        aVar.f33496g = getActivity();
        aVar.f33491b = this.mAdOpenInteractionListener;
        aVar.f33494e = this.mScreenOrientation;
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        aVar.f33492c = ksVideoPlayConfig;
        aVar.f33493d = this.mReportExtData;
        aVar.f33497h = this.mRootContainer;
        AdTemplate adTemplate = this.mAdTemplate;
        aVar.f33495f = adTemplate;
        com.kwad.sdk.reward.c.a aVar2 = new com.kwad.sdk.reward.c.a(adTemplate, this.mDetailVideoView, ksVideoPlayConfig);
        aVar.f33498i = aVar2;
        aVar.f33490a.add(aVar2);
        if (com.kwad.sdk.core.response.b.a.v(this.mAdInfo)) {
            aVar.j = new com.kwad.sdk.core.download.b.b(this.mAdTemplate, this.mReportExtData);
        }
        aVar.k = new com.kwad.sdk.reward.b.b.a.a(this.mAdTemplate, this.mScreenOrientation);
        aVar.a(this.mPageListener);
        if (com.kwad.sdk.core.response.b.b.j(this.mAdTemplate)) {
            aVar.l = new com.kwad.sdk.c.c(this.mReportExtData);
        }
        if (com.kwad.sdk.core.response.b.c.k(this.mAdTemplate)) {
            aVar.m = new com.kwad.sdk.c.a().a(true);
        }
        aVar.n = new com.kwad.sdk.c.b(this.mReportExtData);
        aVar.q = true;
        aVar.r = this.mRewardTopBarNewStyle;
        return aVar;
    }

    @Override // com.kwad.sdk.core.e.a
    public Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.reward.b.d());
        presenter.a((Presenter) new com.kwad.sdk.reward.b.a());
        presenter.a((Presenter) new com.kwad.sdk.reward.b.b.b(this.mRewardTopBarNewStyle));
        presenter.a((Presenter) new com.kwad.sdk.reward.b.b.a.b());
        if (com.kwad.sdk.core.response.b.b.i(this.mAdTemplate)) {
            presenter.a((Presenter) new com.kwad.sdk.reward.b.b.a.c());
        }
        if (com.kwad.sdk.core.response.b.a.J(this.mAdInfo)) {
            presenter.a((Presenter) new com.kwad.sdk.reward.b.b.a());
        }
        if (com.kwad.sdk.core.response.b.a.K(this.mAdInfo) && isShowNewStyle()) {
            presenter.a((Presenter) new com.kwad.sdk.reward.b.b.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.reward.b.e());
        boolean a2 = com.kwad.sdk.core.response.b.a.a(this.mAdInfo, getActivity());
        presenter.a((Presenter) new com.kwad.sdk.reward.b.g(getActivity(), this.mAdTemplate));
        if (!a2 && com.kwad.sdk.core.config.c.q()) {
            presenter.a((Presenter) new com.kwad.sdk.reward.b.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.reward.b.c.a(getActivity(), this.mAdTemplate, true));
        presenter.a((Presenter) new com.kwad.sdk.reward.b.c.b(a2));
        presenter.a((Presenter) new com.kwad.sdk.reward.b.a.a());
        return presenter;
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.b.a, com.kwad.sdk.api.proxy.IActivityProxy
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
