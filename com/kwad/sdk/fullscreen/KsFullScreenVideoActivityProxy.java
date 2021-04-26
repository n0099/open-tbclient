package com.kwad.sdk.fullscreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Label;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenVideoActivity;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.a.c;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.b.d;
import com.kwad.sdk.utils.o;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(KsFullScreenVideoActivity.class)
@Keep
/* loaded from: classes6.dex */
public class KsFullScreenVideoActivityProxy extends com.kwad.sdk.core.e.a<com.kwad.sdk.reward.a> {
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String TAG = "FullScreenVideo";
    public static KsFullScreenVideoAd.FullScreenVideoAdInteractionListener mInteractionListener;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public Activity mContext;
    public DetailVideoView mDetailVideoView;
    public boolean mIsBackEnable;
    public boolean mPageDismissCalled;
    public JSONObject mReportExtData;
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public KsVideoPlayConfig mVideoPlayConfig;
    public f mPageListener = new f() { // from class: com.kwad.sdk.fullscreen.KsFullScreenVideoActivityProxy.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            KsFullScreenVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    public com.kwad.sdk.reward.a.b mAdOpenInteractionListener = new c() { // from class: com.kwad.sdk.fullscreen.KsFullScreenVideoActivityProxy.2
        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void a() {
            KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = KsFullScreenVideoActivityProxy.mInteractionListener;
            if (fullScreenVideoAdInteractionListener != null) {
                fullScreenVideoAdInteractionListener.onAdClicked();
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void a(int i2, int i3) {
            KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = KsFullScreenVideoActivityProxy.mInteractionListener;
            if (fullScreenVideoAdInteractionListener != null) {
                fullScreenVideoAdInteractionListener.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void a(boolean z) {
            KsFullScreenVideoActivityProxy.this.notifyPageDismiss();
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void b() {
            KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = KsFullScreenVideoActivityProxy.mInteractionListener;
            if (fullScreenVideoAdInteractionListener != null) {
                fullScreenVideoAdInteractionListener.onSkippedVideo();
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void c() {
            KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = KsFullScreenVideoActivityProxy.mInteractionListener;
            if (fullScreenVideoAdInteractionListener != null) {
                fullScreenVideoAdInteractionListener.onVideoPlayStart();
            }
        }

        @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
        public void d() {
            KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = KsFullScreenVideoActivityProxy.mInteractionListener;
            if (fullScreenVideoAdInteractionListener != null) {
                fullScreenVideoAdInteractionListener.onVideoPlayEnd();
            }
        }
    };

    private boolean initData() {
        File b2;
        String str;
        Serializable serializableExtra = this.mContext.getIntent().getSerializableExtra("key_video_play_config");
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
        if (this.mCallerContext.f34320e == 1) {
            if (d2 > e2) {
                return false;
            }
        } else if (d2 < e2) {
            return false;
        }
        return true;
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        adTemplate.mKsPlayerClickTimeParam = System.currentTimeMillis();
        if (!ksVideoPlayConfig.isShowLandscape()) {
            KsAdSDKImpl.putComponentProxy(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
        }
        Intent intent = new Intent(context, ksVideoPlayConfig.isShowLandscape() ? KsFullScreenLandScapeVideoActivity.class : FeedDownloadActivity.class);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
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
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onPageDismiss();
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
        setContentView(R.layout.ksad_activity_fullscreen_video);
        initView();
        onActivityCreated(this.mRootContainer);
    }

    @Override // com.kwad.sdk.core.e.a
    public com.kwad.sdk.reward.a onCreateCallerContext() {
        com.kwad.sdk.reward.a aVar = new com.kwad.sdk.reward.a();
        aVar.f34322g = this.mContext;
        aVar.f34317b = this.mAdOpenInteractionListener;
        aVar.f34320e = this.mScreenOrientation;
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        aVar.f34318c = ksVideoPlayConfig;
        aVar.f34319d = this.mReportExtData;
        aVar.f34323h = this.mRootContainer;
        AdTemplate adTemplate = this.mAdTemplate;
        aVar.f34321f = adTemplate;
        com.kwad.sdk.reward.c.a aVar2 = new com.kwad.sdk.reward.c.a(adTemplate, this.mDetailVideoView, ksVideoPlayConfig);
        aVar.f34324i = aVar2;
        aVar.f34316a.add(aVar2);
        if (com.kwad.sdk.core.response.b.a.v(this.mAdInfo)) {
            aVar.j = new com.kwad.sdk.core.download.b.b(this.mAdTemplate, this.mReportExtData);
        }
        aVar.k = new com.kwad.sdk.reward.b.b.a.a(this.mAdTemplate, this.mScreenOrientation);
        aVar.a(this.mPageListener);
        if (com.kwad.sdk.core.response.b.b.j(this.mAdTemplate)) {
            aVar.l = new com.kwad.sdk.c.c(this.mReportExtData);
        }
        if (com.kwad.sdk.core.response.b.c.k(this.mAdTemplate)) {
            aVar.m = new com.kwad.sdk.c.a().a(false);
        }
        aVar.q = false;
        return aVar;
    }

    @Override // com.kwad.sdk.core.e.a
    public Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new d());
        presenter.a((Presenter) new com.kwad.sdk.fullscreen.a.a.c());
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
        presenter.a((Presenter) new com.kwad.sdk.fullscreen.a.a());
        presenter.a((Presenter) new com.kwad.sdk.fullscreen.a.b.a());
        presenter.a((Presenter) new com.kwad.sdk.reward.b.c.a(getActivity(), this.mAdTemplate, false));
        presenter.a((Presenter) new com.kwad.sdk.reward.b.a.a());
        return presenter;
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.b.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        notifyPageDismiss();
        AdInfo adInfo = this.mAdInfo;
        if (adInfo != null) {
            com.kwad.sdk.core.videocache.c.a.a(getActivity()).c(com.kwad.sdk.core.response.b.a.a(adInfo));
        }
        mInteractionListener = null;
    }
}
