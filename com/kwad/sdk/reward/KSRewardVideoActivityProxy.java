package com.kwad.sdk.reward;

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
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.b;
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* loaded from: classes3.dex */
public class KSRewardVideoActivityProxy extends com.kwad.sdk.core.e.a<a> implements b.InterfaceC2116b {
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
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
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public KsVideoPlayConfig mVideoPlayConfig;
    public com.kwad.sdk.reward.presenter.j rewardRefluxPresenter;
    public int rewardType = 1;
    public final com.kwad.sdk.reward.a.h mRewardVerifyListener = new com.kwad.sdk.reward.a.h() { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.1
        @Override // com.kwad.sdk.reward.a.h
        public void a() {
            if (KSRewardVideoActivityProxy.this.isRewardLandPageOpenTask()) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    public com.kwad.sdk.reward.a.f mPlayEndPageListener = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.3
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    public com.kwad.sdk.reward.a.d mAdRewardStepListener = new com.kwad.sdk.reward.a.d() { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.4
        @Override // com.kwad.sdk.reward.a.d
        public void a() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };
    public com.kwad.sdk.reward.a.b mAdOpenInteractionListener = new com.kwad.sdk.reward.a.c() { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.5
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
        public void a(long j2) {
            try {
                if (KSRewardVideoActivityProxy.mInteractionListener != null) {
                    KSRewardVideoActivityProxy.mInteractionListener.onVideoSkipToEnd(j2);
                }
            } catch (Throwable unused) {
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
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };

    private void handleNotifyVerify() {
        this.mCallerContext.v = true;
        this.mAdTemplate.mRewardVerifyCalled = true;
        h.a().a(this.mAdTemplate);
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onRewardVerify();
        }
    }

    private boolean initData() {
        File b2;
        String str;
        Serializable serializableExtra = getIntent().getSerializableExtra("key_video_play_config");
        if (serializableExtra instanceof KsVideoPlayConfig) {
            this.rewardType = getIntent().getIntExtra(KEY_REWARD_TYPE, 1);
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
                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate2);
                this.mAdInfo = j2;
                String a = com.kwad.sdk.core.response.a.a.a(j2);
                if (com.kwad.sdk.core.config.b.C() >= 0 || ((b2 = com.kwad.sdk.core.diskcache.a.a.a().b(a)) != null && b2.exists())) {
                    KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
                    this.mVideoPlayConfig = ksVideoPlayConfig;
                    this.mScreenOrientation = ksVideoPlayConfig.isShowLandscape() ? 1 : 0;
                    this.mAdTemplate.mInitVoiceStatus = this.mVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
                    initVideoPlayConfig(this.mVideoPlayConfig);
                    b.a().a(this);
                    this.mRewardTopBarNewStyle = com.kwad.sdk.core.config.b.k();
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
        this.mDetailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        boolean z = !af.e(this.mContext);
        if ((isRewardLaunchAppTask() || isRewardLandPageOpenTask()) && z) {
            this.mDetailVideoView.setForce(true);
        }
        this.mDetailVideoView.setAd(true);
    }

    private boolean isLaunchTaskCompleted() {
        com.kwad.sdk.reward.b.a.a aVar = this.mCallerContext.y;
        return aVar != null && aVar.d();
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, int i2) {
        com.kwad.sdk.utils.m.b(adTemplate);
        Intent intent = new Intent(context, ksVideoPlayConfig.isShowLandscape() ? KSRewardLandScapeVideoActivity.class : KsRewardVideoActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra(KEY_REWARD_TYPE, i2);
        mInteractionListener = rewardAdInteractionListener;
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markOpenNsCompleted() {
        com.kwad.sdk.reward.b.kwai.a aVar = this.mCallerContext.z;
        if (aVar != null) {
            aVar.h();
        }
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
            jSONObject = this.mCallerContext.f59453e;
        } else {
            adTemplate = this.mAdTemplate;
            i2 = 6;
            jSONObject = this.mReportExtData;
        }
        com.kwad.sdk.core.report.a.a(adTemplate, i2, jSONObject);
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onPageDismiss();
        }
    }

    private void notifyRearwdVerifySteped(int i2, int i3) {
        if (this.mCallerContext.w.contains(Integer.valueOf(i3))) {
            return;
        }
        this.mCallerContext.w.add(Integer.valueOf(i3));
        try {
            mInteractionListener.onRewardStepVerify(i2, i3);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        if (this.mCallerContext.v) {
            return;
        }
        boolean z = true;
        if (isRewardLaunchAppTask()) {
            com.kwad.sdk.reward.b.a.a aVar = this.mCallerContext.y;
            if (!((aVar == null || !aVar.d()) ? false : false)) {
                return;
            }
        } else if (isRewardLandPageOpenTask()) {
            com.kwad.sdk.reward.b.kwai.a aVar2 = this.mCallerContext.z;
            if (!((aVar2 == null || !aVar2.d()) ? false : false)) {
                return;
            }
        }
        handleNotifyVerify();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerifyStepByStep() {
        if (mInteractionListener == null) {
            return;
        }
        if (isRewardLaunchAppTask()) {
            notifyRearwdVerifySteped(2, 0);
            if (isLaunchTaskCompleted()) {
                notifyRearwdVerifySteped(2, 2);
            }
        } else if (!isRewardLandPageOpenTask()) {
            notifyRearwdVerifySteped(0, 0);
        } else {
            com.kwad.sdk.reward.b.kwai.a aVar = this.mCallerContext.z;
            boolean z = aVar != null && aVar.d();
            notifyRearwdVerifySteped(1, 0);
            if (z) {
                notifyRearwdVerifySteped(1, 1);
            }
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        notifyPageDismiss(false);
        getActivity().finish();
    }

    @Override // com.kwad.sdk.h.a
    public String getPageName() {
        return "KSRewardLandScapeVideoActivityProxy";
    }

    public boolean isRefluxVisible() {
        com.kwad.sdk.reward.presenter.j jVar = this.rewardRefluxPresenter;
        return jVar != null && jVar.r();
    }

    public boolean isRewardLandPageOpenTask() {
        return com.kwad.sdk.core.response.a.d.v(this.mAdTemplate);
    }

    public boolean isRewardLaunchAppTask() {
        return com.kwad.sdk.core.response.a.d.u(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.sdk.reward.presenter.j jVar = this.rewardRefluxPresenter;
        if (jVar != null) {
            int i2 = jVar.i();
            if (i2 == 2) {
                return;
            }
            if (i2 == 3) {
                super.onBackPressed();
                return;
            }
        }
        if (this.mIsBackEnable) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!initData()) {
            finish();
            return;
        }
        this.mContext = Wrapper.wrapContextIfNeed(getActivity());
        setContentView(R.layout.ksad_activity_reward_video);
        initView();
        onActivityCreated(this.mRootContainer);
        d.a().a(this.mRewardVerifyListener);
    }

    @Override // com.kwad.sdk.core.e.a
    public a onCreateCallerContext() {
        a aVar = new a();
        aVar.f59456h = getActivity();
        aVar.f59457i = this.mContext;
        aVar.f59450b = this.mAdOpenInteractionListener;
        aVar.f59451c = this.mAdRewardStepListener;
        aVar.f59454f = this.mScreenOrientation;
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        aVar.f59452d = ksVideoPlayConfig;
        aVar.f59453e = this.mReportExtData;
        aVar.f59458j = this.mRootContainer;
        AdTemplate adTemplate = this.mAdTemplate;
        aVar.f59455g = adTemplate;
        com.kwad.sdk.reward.c.a aVar2 = new com.kwad.sdk.reward.c.a(adTemplate, this.mDetailVideoView, ksVideoPlayConfig, this.rewardType == 2);
        aVar.f59459k = aVar2;
        aVar.a.add(aVar2);
        if (com.kwad.sdk.core.response.a.a.B(this.mAdInfo)) {
            aVar.l = new com.kwad.sdk.core.download.a.b(this.mAdTemplate, this.mReportExtData);
        }
        aVar.n = new RewardActionBarControl(this.mContext, this.mAdTemplate);
        aVar.a(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.a.b.h(this.mAdTemplate)) {
            aVar.o = new com.kwad.sdk.i.b(this.mReportExtData);
        }
        if (com.kwad.sdk.core.response.a.a.q(this.mAdInfo)) {
            aVar.p = new com.kwad.sdk.i.a().a(true);
        }
        aVar.r = true;
        aVar.s = this.mRewardTopBarNewStyle;
        if (com.kwad.sdk.core.response.a.a.an(this.mAdInfo)) {
            aVar.m = new com.kwad.sdk.widget.e((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd  */
    @Override // com.kwad.sdk.core.e.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Presenter onCreatePresenter() {
        Presenter bVar;
        Presenter presenter = new Presenter() { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.2
            @Override // com.kwad.sdk.mvp.Presenter
            public void c() {
                super.c();
                KSRewardVideoActivityProxy.this.mIsBackEnable = false;
                KSRewardVideoActivityProxy.this.mCallerContext.v = false;
                KSRewardVideoActivityProxy.this.mCallerContext.u = false;
            }
        };
        presenter.a((Presenter) new com.kwad.sdk.reward.presenter.e());
        presenter.a((Presenter) new com.kwad.sdk.reward.presenter.d());
        if (com.kwad.sdk.core.response.a.a.B(this.mAdInfo)) {
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.platdetail.b());
        }
        boolean isRewardLaunchAppTask = isRewardLaunchAppTask();
        boolean isRewardLandPageOpenTask = isRewardLandPageOpenTask();
        boolean an = com.kwad.sdk.core.response.a.a.an(this.mAdInfo);
        com.kwad.sdk.plugin.g gVar = (com.kwad.sdk.plugin.g) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.g.class);
        if (isRewardLandPageOpenTask || isRewardLaunchAppTask() || com.kwad.sdk.core.response.a.a.aG(this.mAdInfo) || gVar == null || !gVar.b()) {
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.f());
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.platdetail.c(this.mRewardTopBarNewStyle));
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.a.b(an));
            if (!isRewardLaunchAppTask && !isRewardLandPageOpenTask) {
                if (com.kwad.sdk.core.response.a.a.T(this.mAdInfo)) {
                    bVar = new com.kwad.sdk.reward.presenter.platdetail.a();
                } else {
                    presenter.a((Presenter) new com.kwad.sdk.reward.presenter.platdetail.actionbar.a());
                    if (com.kwad.sdk.core.response.a.b.d(this.mAdTemplate)) {
                        bVar = new com.kwad.sdk.reward.presenter.platdetail.actionbar.b();
                    }
                }
            }
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.i(this.mAdTemplate));
            if (com.kwad.sdk.core.response.a.a.D(this.mAdInfo)) {
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.b());
            }
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.a.a(this, this.mAdTemplate, true));
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.kwai.a());
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.k());
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.l());
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.c(this.mAdInfo, this.mRootContainer));
            com.kwad.sdk.reward.presenter.j jVar = new com.kwad.sdk.reward.presenter.j();
            this.rewardRefluxPresenter = jVar;
            presenter.a((Presenter) jVar);
            return presenter;
        }
        this.mCallerContext.t = true;
        presenter.a((Presenter) new com.kwad.sdk.reward.presenter.b.e(an, this.mRewardTopBarNewStyle));
        presenter.a(com.kwad.sdk.core.response.a.b.a(this.mContext, this.mAdTemplate) ? new com.kwad.sdk.reward.presenter.b.d() : new com.kwad.sdk.reward.presenter.b.c(com.kwad.sdk.core.response.a.b.d(this.mAdTemplate)));
        bVar = new com.kwad.sdk.reward.presenter.f();
        presenter.a(bVar);
        presenter.a((Presenter) new com.kwad.sdk.reward.presenter.i(this.mAdTemplate));
        if (com.kwad.sdk.core.response.a.a.D(this.mAdInfo)) {
        }
        presenter.a((Presenter) new com.kwad.sdk.reward.presenter.a.a(this, this.mAdTemplate, true));
        presenter.a((Presenter) new com.kwad.sdk.reward.presenter.kwai.a());
        presenter.a((Presenter) new com.kwad.sdk.reward.presenter.k());
        presenter.a((Presenter) new com.kwad.sdk.reward.presenter.l());
        presenter.a((Presenter) new com.kwad.sdk.reward.presenter.c(this.mAdInfo, this.mRootContainer));
        com.kwad.sdk.reward.presenter.j jVar2 = new com.kwad.sdk.reward.presenter.j();
        this.rewardRefluxPresenter = jVar2;
        presenter.a((Presenter) jVar2);
        return presenter;
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        d.a().b(this.mRewardVerifyListener);
        super.onDestroy();
        notifyPageDismiss(false);
        AdInfo adInfo = this.mAdInfo;
        if (adInfo != null) {
            com.kwad.sdk.core.videocache.b.a.a(this.mContext.getApplicationContext()).c(com.kwad.sdk.core.response.a.a.a(adInfo));
        }
        mInteractionListener = null;
        b.a().b(this);
        h.a().b();
    }

    @Override // com.kwad.sdk.reward.b.InterfaceC2116b
    public void onPageClose() {
        finish();
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        com.kwad.sdk.core.c.a.a().a(this.mAdTemplate);
    }
}
