package com.kwad.components.ad.reward;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.j.a;
import com.kwad.components.ad.reward.p;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.m.d;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.c;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bd;
import java.util.HashMap;
@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* loaded from: classes8.dex */
public class KSRewardVideoActivityProxy extends com.kwad.components.core.g.b<k> implements com.kwad.components.ad.reward.g.c, a.InterfaceC0574a, p.a, d.b, c.a {
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_TEMPLATE_PLAY_AGAIN = "key_template_json_play_again";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String TAG = "RewardVideo";
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public boolean mIsBackEnable;
    public com.kwad.components.ad.reward.model.c mModel;
    public boolean mPageDismissCalled;
    public long mPageEnterTime;
    public long mPlayTime;
    public p mRewardPresenter;
    public AdBaseFrameLayout mRootContainer;
    public final com.kwad.components.ad.reward.d.h mRewardVerifyListener = new com.kwad.components.ad.reward.d.h() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.d.h
        public final void onRewardVerify() {
            if (KSRewardVideoActivityProxy.this.mModel.gM()) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    public com.kwad.components.ad.reward.d.e mPlayEndPageListener = new com.kwad.components.ad.reward.d.e() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.4
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    public com.kwad.components.ad.reward.d.c mAdRewardStepListener = new com.kwad.components.ad.reward.d.c() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.5
        @Override // com.kwad.components.ad.reward.d.c
        public final void ff() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };
    public com.kwad.components.core.video.g mVideoPlayStateListener = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.6
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            KSRewardVideoActivityProxy.this.mPlayTime = j2;
        }
    };
    public com.kwad.components.ad.reward.d.a mAdOpenInteractionListener = new com.kwad.components.ad.reward.d.b() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7
        @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
        public final void bB() {
            KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (E != null) {
                E.onAdClicked();
            }
            ((k) KSRewardVideoActivityProxy.this.mCallerContext).mT = true;
            ((k) KSRewardVideoActivityProxy.this.mCallerContext).fw();
        }

        @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
        public final void j(boolean z) {
            com.kwad.sdk.kwai.kwai.c.rd().rg();
            KSRewardVideoActivityProxy.this.notifyPageDismiss(false);
        }

        @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
        public final void onRewardVerify() {
            KSRewardVideoActivityProxy.this.notifyRewardVerify();
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }

        @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
        public final void onVideoPlayEnd() {
            KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (E != null) {
                E.onVideoPlayEnd();
            }
        }

        @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
        public final void onVideoPlayError(int i, int i2) {
            KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (E != null) {
                E.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
        public final void onVideoPlayStart() {
            KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (E != null) {
                E.onVideoPlayStart();
            }
        }

        @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
        public final void onVideoSkipToEnd(long j) {
            try {
                KsRewardVideoAd.RewardAdInteractionListener E = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
                if (E != null) {
                    E.onVideoSkipToEnd(j);
                }
            } catch (Throwable unused) {
            }
        }
    };

    /* loaded from: classes8.dex */
    public static class a {
        public static final HashMap<String, a> lU = new HashMap<>();
        public com.kwad.components.ad.reward.c.c kJ;
        public KsRewardVideoAd.RewardAdInteractionListener lV;
        public KsRewardVideoAd.RewardAdInteractionListener lW;
        public KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;

        @Nullable
        public static a D(String str) {
            return lU.get(str);
        }

        public static KsRewardVideoAd.RewardAdInteractionListener E(String str) {
            a D = D(str);
            if (D != null) {
                return D.lW;
            }
            return null;
        }

        public static void F(String str) {
            a D = D(str);
            if (D != null) {
                D.lW = D.mInteractionListener;
            }
        }

        public static void G(String str) {
            a D = D(str);
            if (D != null) {
                D.lW = D.lV;
            }
        }

        public static com.kwad.components.ad.reward.c.c H(String str) {
            a D = D(str);
            if (D != null) {
                return D.kJ;
            }
            return null;
        }

        public static void I(String str) {
            a D = D(str);
            if (D != null) {
                D.destroy();
                lU.put(str, null);
            }
        }

        public static void a(String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2, com.kwad.components.ad.reward.c.c cVar) {
            a aVar = new a();
            aVar.mInteractionListener = rewardAdInteractionListener;
            aVar.lV = rewardAdInteractionListener2;
            aVar.kJ = cVar;
            aVar.lW = rewardAdInteractionListener;
            lU.put(str, aVar);
        }

        private void destroy() {
            this.mInteractionListener = null;
            this.lV = null;
            this.lW = null;
            com.kwad.components.ad.reward.c.c cVar = this.kJ;
            if (cVar != null) {
                cVar.destroy();
                this.kJ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUniqueId() {
        return ((k) this.mCallerContext).mAdTemplate.getUniqueId();
    }

    private void handleNotifyVerify() {
        ((k) this.mCallerContext).mRewardVerifyCalled = true;
        this.mModel.getAdTemplate().mRewardVerifyCalled = true;
        i.fn().m(this.mModel.getAdTemplate());
        com.kwad.sdk.core.report.a.aE(this.mModel.getAdTemplate());
        if (!((k) this.mCallerContext).mAdTemplate.converted) {
            com.kwad.components.ad.reward.b.a.gp().gq().N(com.kwad.components.ad.reward.b.b.oK);
        }
        KsRewardVideoAd.RewardAdInteractionListener E = a.E(getUniqueId());
        if (E != null) {
            E.onRewardVerify();
            com.kwad.components.ad.reward.monitor.a.a(this.mModel.getAdTemplate(), 0, -1, true);
        }
        if (com.kwad.sdk.core.response.a.a.bR(this.mModel.by())) {
            T t = this.mCallerContext;
            if (((k) t).mAdTemplate.converted || ((k) t).fD()) {
                return;
            }
            k.a(getActivity(), (k) this.mCallerContext);
        }
    }

    private void initView() {
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f09134f);
        this.mRootContainer = adBaseFrameLayout;
        this.mDetailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.obfuscated_res_0x7f0913a5);
        boolean z = !ag.cB(this.mContext);
        if ((this.mModel.gL() || this.mModel.gM()) && z) {
            this.mDetailVideoView.setForce(true);
        }
        this.mDetailVideoView.setAd(true);
    }

    private void initWithModel(@NonNull com.kwad.components.ad.reward.model.c cVar) {
        if (this.mModel.getAdTemplate() == null || this.mModel.getAdTemplate().mPlayAgain == null) {
            return;
        }
        final AdTemplate adTemplate = this.mModel.getAdTemplate().mPlayAgain;
        com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.2
            @Override // java.lang.Runnable
            public final void run() {
                boolean a2 = com.kwad.components.ad.b.a.a(adTemplate, true);
                com.kwad.sdk.core.e.b.d(KSRewardVideoActivityProxy.TAG, "cache playAgain result: " + a2);
            }
        });
    }

    private boolean isLaunchTaskCompleted() {
        T t = this.mCallerContext;
        return ((k) t).mK != null && ((k) t).mK.isCompleted();
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2, com.kwad.components.ad.reward.c.c cVar, int i) {
        Intent intent;
        com.kwad.sdk.utils.k.ci(adTemplate);
        if (ksVideoPlayConfig.isShowLandscape()) {
            KsAdSDKImpl.putComponentProxy(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
            intent = new Intent(context, KSRewardLandScapeVideoActivity.class);
        } else {
            KsAdSDKImpl.putComponentProxy(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
            intent = new Intent(context, KsRewardVideoActivity.class);
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra(KEY_REWARD_TYPE, i);
        if (adTemplate.hasPlayAgain() && rewardAdInteractionListener2 != null) {
            intent.putExtra(KEY_TEMPLATE_PLAY_AGAIN, adTemplate.mPlayAgain.toJson().toString());
        }
        String uniqueId = adTemplate.getUniqueId();
        a.a(uniqueId, rewardAdInteractionListener, rewardAdInteractionListener2, cVar);
        a.F(uniqueId);
        context.startActivity(intent);
        com.kwad.sdk.kwai.kwai.c.rd().aI(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markOpenNsCompleted() {
        T t = this.mCallerContext;
        if (((k) t).mL != null) {
            ((k) t).mL.markOpenNsCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPageDismiss(boolean z) {
        com.kwad.components.ad.reward.model.c cVar;
        if (this.mPageDismissCalled || this.mCallerContext == 0 || (cVar = this.mModel) == null) {
            return;
        }
        this.mPageDismissCalled = true;
        com.kwad.sdk.core.report.a.o(cVar.getAdTemplate(), (int) Math.ceil(((float) this.mPlayTime) / 1000.0f));
        if (z) {
            com.kwad.sdk.core.report.a.a(this.mModel.getAdTemplate(), 1, ((k) this.mCallerContext).mReportExtData);
        } else {
            com.kwad.sdk.core.report.a.a(this.mModel.getAdTemplate(), 6, this.mModel.gP());
        }
        KsRewardVideoAd.RewardAdInteractionListener E = a.E(getUniqueId());
        com.kwad.sdk.core.e.b.d("jky", "notifyPageDismiss current listener: " + E);
        if (E != null) {
            E.onPageDismiss();
        }
    }

    private void notifyRewardStep(int i, int i2) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || com.kwad.sdk.core.response.a.d.cb(cVar.getAdTemplate()) || ((k) this.mCallerContext).mE.contains(Integer.valueOf(i2))) {
            return;
        }
        ((k) this.mCallerContext).mE.add(Integer.valueOf(i2));
        q.a(i, i2, (k) this.mCallerContext, this.mModel);
        if (a.E(getUniqueId()) == null) {
            return;
        }
        try {
            a.E(getUniqueId()).onRewardStepVerify(i, i2);
            com.kwad.components.ad.reward.monitor.a.a(this.mModel.getAdTemplate(), i, i2, false);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || com.kwad.sdk.core.response.a.d.cb(cVar.getAdTemplate()) || ((k) this.mCallerContext).mRewardVerifyCalled) {
            return;
        }
        boolean z = true;
        if (this.mModel.gL()) {
            T t = this.mCallerContext;
            if ((((k) t).mK == null || !((k) t).mK.isCompleted()) ? false : false) {
                handleNotifyVerify();
            }
        } else if (!this.mModel.gM()) {
            handleNotifyVerify();
        } else {
            T t2 = this.mCallerContext;
            if ((((k) t2).mL == null || !((k) t2).mL.isCompleted()) ? false : false) {
                handleNotifyVerify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerifyStepByStep() {
        if (this.mModel.gL()) {
            notifyRewardStep(2, 0);
            if (isLaunchTaskCompleted()) {
                notifyRewardStep(2, 2);
            }
        } else if (!this.mModel.gM()) {
            notifyRewardStep(0, 0);
        } else {
            T t = this.mCallerContext;
            boolean z = ((k) t).mL != null && ((k) t).mL.isCompleted();
            notifyRewardStep(1, 0);
            if (z) {
                notifyRewardStep(1, 1);
            }
        }
    }

    @InvokeBy(invokerClass = KsAdSDKImpl.class, methodId = KsAdSDKImpl.INVOKER_ID_INIT_COMPONENT_PROXY)
    public static void register() {
        KsAdSDKImpl.putComponentProxy(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        notifyPageDismiss(false);
        getActivity().finish();
    }

    @Override // com.kwad.components.core.i.a
    public String getPageName() {
        return "KSRewardLandScapeVideoActivityProxy";
    }

    @Override // com.kwad.components.ad.reward.j.a.InterfaceC0574a
    public boolean handledOnResume() {
        if (((k) this.mCallerContext).mx || isRefluxVisible()) {
            return true;
        }
        p pVar = this.mRewardPresenter;
        if (pVar != null) {
            return pVar.bH();
        }
        return false;
    }

    public boolean isRefluxVisible() {
        return this.mRewardPresenter.isRefluxVisible();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        BackPressHandleResult fS = this.mRewardPresenter.fS();
        if (fS.equals(BackPressHandleResult.HANDLED)) {
            return;
        }
        if (fS.equals(BackPressHandleResult.HANDLED_CLOSE)) {
            super.onBackPressed();
            notifyPageDismiss(false);
        } else if (this.mIsBackEnable) {
            notifyPageDismiss(false);
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        try {
            getIntent().removeExtra(AdWebViewVideoActivityProxy.KEY_TEMPLATE);
        } catch (Throwable unused) {
        }
        super.onCreate(bundle);
        getActivity().setTheme(16973838);
        com.kwad.components.ad.reward.model.c c = com.kwad.components.ad.reward.model.c.c(getIntent());
        this.mModel = c;
        if (c == null) {
            finish();
            return;
        }
        this.mPageEnterTime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.reward.monitor.a.a(true, this.mModel.getAdTemplate(), this.mPageEnterTime);
        com.kwad.components.ad.reward.monitor.a.b(true, this.mModel.getAdTemplate(), this.mPageEnterTime);
        com.kwad.components.core.m.d.oy().a(this);
        this.mContext = Wrapper.wrapContextIfNeed(getActivity());
        initWithModel(this.mModel);
        setContentView(R.layout.obfuscated_res_0x7f0d0445);
        initView();
        onActivityCreated(this.mRootContainer);
        c.eZ().a(this.mRewardVerifyListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwad.components.core.g.b
    public k onCreateCallerContext() {
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        AdInfo by = this.mModel.by();
        final k kVar = new k();
        kVar.EG = this;
        kVar.mContext = this.mContext;
        kVar.mPageEnterTime = this.mPageEnterTime;
        kVar.mAdOpenInteractionListener = this.mAdOpenInteractionListener;
        kVar.mAdRewardStepListener = this.mAdRewardStepListener;
        kVar.mScreenOrientation = this.mModel.getScreenOrientation();
        kVar.mVideoPlayConfig = this.mModel.gN();
        kVar.mReportExtData = this.mModel.gP();
        kVar.mRootContainer = this.mRootContainer;
        kVar.mAdTemplate = adTemplate;
        kVar.mj = this.mDetailVideoView;
        com.kwad.components.ad.reward.j.a aVar = new com.kwad.components.ad.reward.j.a(kVar, this.mModel.gO() == 2);
        kVar.eF = aVar;
        aVar.a(this.mVideoPlayStateListener);
        kVar.eF.a(this);
        kVar.EF.add(aVar);
        if (com.kwad.sdk.core.response.a.a.am(by)) {
            kVar.mApkDownloadHelper = new com.kwad.components.core.c.a.c(adTemplate, this.mModel.gP());
        }
        kVar.ml = new RewardActionBarControl(kVar, this.mContext, adTemplate);
        kVar.a(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.a.b.bd(adTemplate)) {
            m mVar = new m(kVar, this.mModel.gP(), null);
            kVar.mm = mVar;
            mVar.a(new com.kwad.components.ad.reward.b.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3
                @Override // com.kwad.components.ad.reward.b.d
                public final void a(com.kwad.components.ad.reward.b.b bVar) {
                    kVar.b(bVar);
                }
            });
        }
        if (com.kwad.sdk.core.response.a.b.bx(adTemplate)) {
            String bz = com.kwad.sdk.core.response.a.b.bz(adTemplate);
            if (!TextUtils.isEmpty(bz)) {
                com.kwad.components.ad.i.b bVar = new com.kwad.components.ad.i.b(this.mModel.gP(), bz);
                kVar.mn = bVar;
                bVar.a(this);
            }
        }
        if (com.kwad.sdk.core.response.a.a.Z(by)) {
            kVar.mo = new com.kwad.components.ad.i.a().ae(true);
        }
        kVar.mz = true;
        if (com.kwad.sdk.core.response.a.a.aY(by)) {
            kVar.mk = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0912b0));
        }
        kVar.mO = 0L;
        if (this.mModel.by() != null) {
            kVar.mO = com.kwad.sdk.core.response.a.a.aY(this.mModel.by()) ? com.kwad.sdk.core.response.a.a.Y(this.mModel.by()) : com.kwad.sdk.core.response.a.a.X(this.mModel.by());
        }
        kVar.a(this);
        return kVar;
    }

    @Override // com.kwad.components.core.g.b
    public Presenter onCreatePresenter() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null) {
            return null;
        }
        p pVar = new p(this, this.mRootContainer, cVar, (k) this.mCallerContext);
        this.mRewardPresenter = pVar;
        pVar.a(this);
        return this.mRewardPresenter;
    }

    @Override // com.kwad.components.core.g.b, com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        c.eZ().b(this.mRewardVerifyListener);
        super.onDestroy();
        T t = this.mCallerContext;
        if (t != 0) {
            ((k) t).eF.b(this.mVideoPlayStateListener);
            ((k) this.mCallerContext).eF.b(this);
            a.I(getUniqueId());
        }
        notifyPageDismiss(false);
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null) {
            com.kwad.sdk.core.videocache.b.a.bC(this.mContext.getApplicationContext()).cD(com.kwad.sdk.core.response.a.a.A(cVar.by()));
        }
        com.kwad.components.core.m.d.oy().b(this);
        i.fn().release();
    }

    @Override // com.kwad.components.core.m.d.b
    public void onPageClose() {
        finish();
    }

    @Override // com.kwad.components.ad.reward.g.c
    public void onPlayAgainClick() {
        final AdTemplate adTemplate;
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || (adTemplate = cVar.getAdTemplate().mPlayAgain) == null) {
            return;
        }
        adTemplate.inPlayAgain = true;
        this.mRewardPresenter.bt();
        this.mRewardPresenter = null;
        this.mPresenter = null;
        com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.8
            @Override // java.lang.Runnable
            public final void run() {
                ((k) KSRewardVideoActivityProxy.this.mCallerContext).releaseSync();
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.8.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        KSRewardVideoActivityProxy.this.mModel.y(adTemplate);
                        a.G(KSRewardVideoActivityProxy.this.getUniqueId());
                        KSRewardVideoActivityProxy kSRewardVideoActivityProxy = KSRewardVideoActivityProxy.this;
                        kSRewardVideoActivityProxy.onActivityCreated(kSRewardVideoActivityProxy.mRootView);
                    }
                });
            }
        });
    }

    @Override // com.kwad.components.core.g.b, com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null) {
            AdTemplate adTemplate = cVar.getAdTemplate();
            com.kwad.sdk.core.d.a.tr();
            com.kwad.sdk.core.d.a.an(adTemplate);
        }
        com.kwad.components.ad.reward.b.a.gp().O(this.mContext);
    }

    @Override // com.kwad.components.ad.reward.p.a
    public void onUnbind() {
        this.mIsBackEnable = false;
        T t = this.mCallerContext;
        ((k) t).mRewardVerifyCalled = false;
        ((k) t).mC = false;
    }
}
