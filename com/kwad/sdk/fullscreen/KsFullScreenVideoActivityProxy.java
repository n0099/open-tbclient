package com.kwad.sdk.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenVideoActivity;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.plugin.g;
import com.kwad.sdk.reward.a.c;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.presenter.e;
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(KsFullScreenVideoActivity.class)
@Keep
/* loaded from: classes8.dex */
public class KsFullScreenVideoActivityProxy extends com.kwad.sdk.core.e.a<com.kwad.sdk.reward.a> {
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String TAG = "FullScreenVideo";
    public static KsFullScreenVideoAd.FullScreenVideoAdInteractionListener mInteractionListener;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public boolean mIsBackEnable;
    public boolean mPageDismissCalled;
    public JSONObject mReportExtData;
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public KsVideoPlayConfig mVideoPlayConfig;
    public f mPlayEndPageListener = new f() { // from class: com.kwad.sdk.fullscreen.KsFullScreenVideoActivityProxy.1
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
                AdInfo j2 = d.j(adTemplate2);
                this.mAdInfo = j2;
                String a = com.kwad.sdk.core.response.a.a.a(j2);
                if (com.kwad.sdk.core.config.b.C() >= 0 || ((b2 = com.kwad.sdk.core.diskcache.a.a.a().b(a)) != null && b2.exists())) {
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
        getActivity().setRequestedOrientation(!ksVideoPlayConfig.isShowLandscape());
        if (TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            return;
        }
        this.mReportExtData = null;
        JSONObject jSONObject = new JSONObject();
        this.mReportExtData = jSONObject;
        t.a(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
    }

    private void initView() {
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Class cls;
        Class cls2;
        m.b(adTemplate);
        if (ksVideoPlayConfig.isShowLandscape()) {
            cls = KsFullScreenLandScapeVideoActivity.class;
            cls2 = a.class;
        } else {
            cls = FeedDownloadActivity.class;
            cls2 = KsFullScreenVideoActivityProxy.class;
        }
        KsAdSDKImpl.putComponentProxy(cls, cls2);
        Intent intent = new Intent(context, ksVideoPlayConfig.isShowLandscape() ? KsFullScreenLandScapeVideoActivity.class : FeedDownloadActivity.class);
        intent.setFlags(268435456);
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
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 6, this.mReportExtData);
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onPageDismiss();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        notifyPageDismiss();
        getActivity().finish();
    }

    @Override // com.kwad.sdk.h.a
    public String getPageName() {
        return "KsFullScreenVideoActivityProxy";
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        if (this.mIsBackEnable) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!initData()) {
            finish();
            return;
        }
        this.mContext = Wrapper.wrapContextIfNeed(getActivity());
        setContentView(R.layout.ksad_activity_fullscreen_video);
        initView();
        onActivityCreated(this.mRootContainer);
    }

    @Override // com.kwad.sdk.core.e.a
    public com.kwad.sdk.reward.a onCreateCallerContext() {
        com.kwad.sdk.reward.a aVar = new com.kwad.sdk.reward.a();
        aVar.f55770h = getActivity();
        aVar.f55771i = this.mContext;
        aVar.f55764b = this.mAdOpenInteractionListener;
        aVar.f55768f = this.mScreenOrientation;
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        aVar.f55766d = ksVideoPlayConfig;
        aVar.f55767e = this.mReportExtData;
        aVar.f55772j = this.mRootContainer;
        AdTemplate adTemplate = this.mAdTemplate;
        aVar.f55769g = adTemplate;
        com.kwad.sdk.reward.c.a aVar2 = new com.kwad.sdk.reward.c.a(adTemplate, this.mDetailVideoView, ksVideoPlayConfig);
        aVar.k = aVar2;
        aVar.a.add(aVar2);
        if (com.kwad.sdk.core.response.a.a.B(this.mAdInfo)) {
            aVar.l = new com.kwad.sdk.core.download.a.b(this.mAdTemplate, this.mReportExtData);
        }
        aVar.n = new RewardActionBarControl(this.mContext, this.mAdTemplate);
        aVar.a(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.a.b.h(this.mAdTemplate)) {
            aVar.o = new com.kwad.sdk.i.b(this.mReportExtData);
        }
        if (d.s(this.mAdTemplate)) {
            aVar.p = new com.kwad.sdk.i.a().a(false);
        }
        aVar.r = false;
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad  */
    @Override // com.kwad.sdk.core.e.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Presenter onCreatePresenter() {
        Presenter bVar;
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new e());
        if (com.kwad.sdk.core.response.a.a.B(this.mAdInfo)) {
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.platdetail.b());
        }
        g gVar = (g) com.kwad.sdk.plugin.f.a(g.class);
        if (com.kwad.sdk.core.response.a.a.aG(this.mAdInfo) || gVar == null || !gVar.b()) {
            presenter.a((Presenter) new com.kwad.sdk.fullscreen.kwai.a());
            presenter.a((Presenter) new com.kwad.sdk.fullscreen.kwai.kwai.c());
            presenter.a((Presenter) new com.kwad.sdk.fullscreen.kwai.a.a());
            if (!com.kwad.sdk.core.response.a.a.T(this.mAdInfo)) {
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.platdetail.actionbar.a());
                if (com.kwad.sdk.core.response.a.b.d(this.mAdTemplate)) {
                    bVar = new com.kwad.sdk.reward.presenter.platdetail.actionbar.b();
                }
                if (com.kwad.sdk.core.response.a.a.D(this.mAdInfo)) {
                    presenter.a((Presenter) new com.kwad.sdk.reward.presenter.b());
                }
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.a.a(this, this.mAdTemplate, false));
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.kwai.a());
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.c(this.mAdInfo, this.mRootContainer));
                return presenter;
            }
            bVar = new com.kwad.sdk.reward.presenter.platdetail.a();
        } else {
            this.mCallerContext.t = true;
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.b.b());
            presenter.a(com.kwad.sdk.core.response.a.b.a(this.mContext, this.mAdTemplate) ? new com.kwad.sdk.reward.presenter.b.d() : new com.kwad.sdk.reward.presenter.b.c(com.kwad.sdk.core.response.a.b.d(this.mAdTemplate)));
            bVar = new com.kwad.sdk.fullscreen.kwai.a();
        }
        presenter.a(bVar);
        if (com.kwad.sdk.core.response.a.a.D(this.mAdInfo)) {
        }
        presenter.a((Presenter) new com.kwad.sdk.reward.presenter.a.a(this, this.mAdTemplate, false));
        presenter.a((Presenter) new com.kwad.sdk.reward.presenter.kwai.a());
        presenter.a((Presenter) new com.kwad.sdk.reward.presenter.c(this.mAdInfo, this.mRootContainer));
        return presenter;
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        notifyPageDismiss();
        AdInfo adInfo = this.mAdInfo;
        if (adInfo != null) {
            com.kwad.sdk.core.videocache.b.a.a(this.mContext.getApplicationContext()).c(com.kwad.sdk.core.response.a.a.a(adInfo));
        }
        mInteractionListener = null;
    }
}
