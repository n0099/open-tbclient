package com.kwad.components.ad.reward;

import android.app.Activity;
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
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.m;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.s.c;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.bn;
@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* loaded from: classes10.dex */
public class KSRewardVideoActivityProxy extends com.kwad.components.core.l.b<g> implements g.b, m.a, c.b, OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    public static final String TAG = "RewardVideo";
    public String listenerKey;
    public boolean mIsBackEnable;
    public com.kwad.components.ad.reward.model.c mModel;
    public boolean mPageDismissCalled;
    public long mPageEnterTime;
    public m mRewardPresenter;
    public AdBaseFrameLayout mRootContainer;
    public bm mTimerHelper;
    public boolean mReportedPageResume = false;
    public boolean mIsFinishVideoLookStep = false;
    public final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (KSRewardVideoActivityProxy.this.mModel.hh() && ((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult && ((g) KSRewardVideoActivityProxy.this.mCallerContext).pf != 2) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    public com.kwad.components.ad.reward.e.i mAdOpenInteractionListener = new com.kwad.components.ad.reward.e.i() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.2
        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void h(boolean z) {
            if (KSRewardVideoActivityProxy.this.notifyPageDismiss(z)) {
                com.kwad.sdk.a.a.c.yT().yW();
                super.h(z);
            }
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void bJ() {
            super.bJ();
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).fP = true;
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).fD();
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void onRewardVerify() {
            if (((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult && ((g) KSRewardVideoActivityProxy.this.mCallerContext).pf != 2) {
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    public com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    public com.kwad.components.ad.reward.e.d mAdRewardStepListener = new com.kwad.components.ad.reward.e.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.4
        @Override // com.kwad.components.ad.reward.e.d
        public final void ff() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return "KSRewardLandScapeVideoActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean needAdaptionScreen() {
        return true;
    }

    private bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            bm bmVar = new bm();
            this.mTimerHelper = bmVar;
            bmVar.startTiming();
        }
        return this.mTimerHelper;
    }

    private String getUniqueId() {
        return this.listenerKey;
    }

    private boolean isLaunchTaskCompleted() {
        T t = this.mCallerContext;
        if (((g) t).pp != null && ((g) t).pp.isCompleted()) {
            return true;
        }
        return false;
    }

    private boolean isNeoScan() {
        if (this.mModel.hm() != null && this.mModel.hm().neoPageType == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markOpenNsCompleted() {
        T t = this.mCallerContext;
        if (((g) t).pq != null) {
            ((g) t).pq.markOpenNsCompleted();
        }
    }

    private boolean needHandledOnResume() {
        if (((g) this.mCallerContext).fK()) {
            return true;
        }
        return false;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        this.mAdOpenInteractionListener.h(false);
    }

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null && cVar.gt) {
            return R.layout.obfuscated_res_0x7f0d04a9;
        }
        return R.layout.obfuscated_res_0x7f0d04ac;
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091490);
        com.kwad.sdk.i.a.aj("reward", "show");
    }

    @Override // com.kwad.components.ad.reward.g.b
    public boolean interceptPlayCardResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.e.c.bA(this.mModel.getAdTemplate());
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        BackPressHandleResult gl = this.mRewardPresenter.gl();
        if (gl.equals(BackPressHandleResult.HANDLED)) {
            return;
        }
        if (gl.equals(BackPressHandleResult.HANDLED_CLOSE)) {
            super.onBackPressed();
            this.mAdOpenInteractionListener.h(false);
        } else if (this.mIsBackEnable) {
            this.mAdOpenInteractionListener.h(false);
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.l.b
    public Presenter onCreatePresenter() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null) {
            return null;
        }
        m mVar = new m(this, this.mContext, this.mRootContainer, cVar, (g) this.mCallerContext);
        this.mRewardPresenter = mVar;
        mVar.a(this);
        return this.mRewardPresenter;
    }

    @Override // com.kwad.components.core.s.c.b
    public void onPageClose() {
        finish();
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        T t = this.mCallerContext;
        if (t != 0) {
            ((g) t).mPageEnterTime = -1L;
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreDestroy() {
        super.onPreDestroy();
        com.kwad.components.core.webview.tachikoma.d.b.sS().sT();
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null) {
            AdTemplate adTemplate = cVar.getAdTemplate();
            com.kwad.sdk.core.d.a.Cv();
            com.kwad.sdk.core.d.a.bF(adTemplate);
        }
        if (!this.mReportedPageResume) {
            com.kwad.components.ad.reward.monitor.c.f(true, this.mModel.getAdTemplate());
            this.mReportedPageResume = true;
        }
        com.kwad.components.ad.reward.c.a.gJ().M(this.mContext);
    }

    @Override // com.kwad.components.ad.reward.m.a
    public void onUnbind() {
        this.mIsBackEnable = false;
        ((g) this.mCallerContext).E(false);
        ((g) this.mCallerContext).pc = false;
    }

    private void reportSubPageCreate(String str) {
        AdTemplate adTemplate;
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null) {
            adTemplate = cVar.getAdTemplate();
        } else {
            adTemplate = null;
        }
        com.kwad.components.ad.reward.monitor.c.c(true, adTemplate, str);
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean checkIntentData(@Nullable Intent intent) {
        com.kwad.components.ad.reward.model.c a = com.kwad.components.ad.reward.model.c.a(intent);
        this.mModel = a;
        if (a == null) {
            com.kwad.sdk.i.a.aj("reward", "show");
            return false;
        }
        return true;
    }

    @Override // com.kwad.components.core.proxy.c
    public void onCreateCaughtException(Throwable th) {
        AdTemplate adTemplate;
        super.onCreateCaughtException(th);
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null) {
            adTemplate = cVar.getAdTemplate();
        } else {
            adTemplate = null;
        }
        com.kwad.components.ad.reward.monitor.b.b(true, adTemplate);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        com.kwad.sdk.core.e.c.d(TAG, "onCreateStageChange: " + pageCreateStage.getStage());
        reportSubPageCreate(pageCreateStage.getStage());
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
        reportSubPageCreate(PageCreateStage.END_CHILD_ON_PRE_CREATE.getStage());
    }

    private void handleNotifyVerify(boolean z) {
        ((g) this.mCallerContext).E(true);
        this.mModel.getAdTemplate().mRewardVerifyCalled = true;
        if (z || ((g) this.mCallerContext).pf == 0) {
            e.fo().C(this.mModel.getAdTemplate());
        }
        com.kwad.sdk.core.report.a.g(this.mModel.getAdTemplate(), isNeoScan());
        if (!((g) this.mCallerContext).mAdTemplate.converted) {
            com.kwad.components.ad.reward.c.a.gJ().gK().M(com.kwad.components.ad.reward.c.b.rm);
        }
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7
            @Override // java.lang.Runnable
            public final void run() {
                if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.gP()) {
                    com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), 0, -1, true);
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.cP(this.mModel.bH())) {
            T t = this.mCallerContext;
            if (!((g) t).mAdTemplate.converted && !((g) t).oY && !((g) t).fJ()) {
                g.a(getActivity(), (g) this.mCallerContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPageDismiss(boolean z) {
        com.kwad.components.ad.reward.model.c cVar;
        if (this.mPageDismissCalled || this.mCallerContext == 0 || (cVar = this.mModel) == null) {
            return false;
        }
        this.mPageDismissCalled = true;
        com.kwad.sdk.core.report.a.p(cVar.getAdTemplate(), (int) Math.ceil(((float) ((g) this.mCallerContext).pl) / 1000.0f));
        if (z) {
            if (this.mModel.hm() == null || this.mModel.hm().neoPageType != 1) {
                com.kwad.sdk.core.report.a.a(this.mModel.getAdTemplate(), 1, getTimerHelper().getTime(), ((g) this.mCallerContext).mReportExtData);
            }
        } else if (this.mModel.hm() == null || this.mModel.hm().neoPageType != 1) {
            com.kwad.sdk.core.report.a.a(this.mModel.getAdTemplate(), 6, getTimerHelper().getTime(), this.mModel.hl());
        }
        return true;
    }

    public static void launch(Activity activity, AdResultData adResultData, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.i.d dVar, int i) {
        Intent intent;
        AdTemplate m = com.kwad.sdk.core.response.b.c.m(adResultData);
        com.kwad.components.ad.reward.monitor.c.i(true, m);
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        com.kwad.sdk.utils.l.ej(m);
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1) {
            ksVideoPlayConfig.setShowLandscape(false);
        }
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.b.a(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
            intent = new Intent(activity, KSRewardLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.b.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
            intent = new Intent(activity, KsRewardVideoActivity.class);
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra("key_template_json", m.toJson().toString());
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.mB().i(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", com.kwad.components.core.internal.api.e.a(ksVideoPlayConfig));
        intent.putExtra(KEY_REWARD_TYPE, i);
        String uniqueId = m.getUniqueId();
        com.kwad.components.ad.reward.e.f.a(uniqueId, rewardAdInteractionListener, dVar);
        com.kwad.components.ad.reward.e.f.H(uniqueId);
        try {
            activity.startActivity(intent);
            com.kwad.sdk.a.a.c.yT().bi(true);
            com.kwad.components.ad.reward.monitor.c.c(true, m, PageCreateStage.END_LAUNCH.getStage());
        } catch (Throwable th) {
            com.kwad.components.ad.reward.monitor.c.a(true, m, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th.getMessage());
            throw th;
        }
    }

    private void notifyRewardStep(final int i, final int i2) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || com.kwad.sdk.core.response.b.e.ea(cVar.getAdTemplate()) || ((g) this.mCallerContext).pe.contains(Integer.valueOf(i2))) {
            return;
        }
        ((g) this.mCallerContext).pe.add(Integer.valueOf(i2));
        n.a(i, i2, (g) this.mCallerContext, this.mModel);
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.6
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.j(i, i2)) {
                        com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), i, i2, false);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || !((g) this.mCallerContext).mCheckExposureResult || com.kwad.sdk.core.response.b.e.ea(cVar.getAdTemplate()) || ((g) this.mCallerContext).fL()) {
            return;
        }
        boolean z = false;
        if (this.mModel.hg()) {
            T t = this.mCallerContext;
            if (((g) t).pp != null && ((g) t).pp.isCompleted()) {
                z = true;
            }
            if (z) {
                handleNotifyVerify(true);
            }
        } else if (this.mModel.hh()) {
            T t2 = this.mCallerContext;
            if (((g) t2).pq != null && ((g) t2).pq.isCompleted()) {
                z = true;
            }
            if (z) {
                handleNotifyVerify(true);
            }
        } else {
            handleNotifyVerify(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerifyStepByStep() {
        boolean z;
        if (this.mModel.hg()) {
            notifyRewardStep(2, 0);
            if (isLaunchTaskCompleted()) {
                notifyRewardStep(2, 2);
            }
        } else if (this.mModel.hh()) {
            T t = this.mCallerContext;
            if (((g) t).pq != null && ((g) t).pq.isCompleted()) {
                z = true;
            } else {
                z = false;
            }
            notifyRewardStep(1, 0);
            if (z) {
                notifyRewardStep(1, 1);
            }
        } else if (!this.mIsFinishVideoLookStep) {
            this.mIsFinishVideoLookStep = true;
            notifyRewardStep(0, 0);
        }
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        this.listenerKey = this.mModel.getAdTemplate().getUniqueId();
        this.mAdOpenInteractionListener.setAdTemplate(this.mModel.getAdTemplate());
        this.mAdOpenInteractionListener.K(getUniqueId());
        this.mPageEnterTime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.reward.monitor.c.a(true, this.mModel.getAdTemplate(), this.mPageEnterTime, this.mModel.hm());
        com.kwad.components.ad.reward.monitor.c.g(true, this.mModel.getAdTemplate());
        com.kwad.components.core.s.c.qM().a(this);
        b.fa().a(this.mRewardVerifyListener);
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        b.fa().b(this.mRewardVerifyListener);
        super.onDestroy();
        this.mAdOpenInteractionListener.h(false);
        if (this.mCallerContext != 0) {
            i.gh().B(String.valueOf(((g) this.mCallerContext).mAdTemplate));
            com.kwad.components.ad.reward.e.f.J(getUniqueId());
        }
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null) {
            String K = com.kwad.sdk.core.response.b.a.K(cVar.bH());
            if (!TextUtils.isEmpty(K)) {
                com.kwad.sdk.core.videocache.c.a.bl(this.mContext.getApplicationContext()).ei(K);
            }
        }
        com.kwad.components.core.s.c.qM().b(this);
        this.listenerKey = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwad.components.core.l.b
    public g onCreateCallerContext() {
        boolean z;
        LoadStrategy loadStrategy;
        long am;
        AdResultData hi = this.mModel.hi();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        AdInfo bH = this.mModel.bH();
        final g gVar = new g(this);
        gVar.mPageEnterTime = this.mPageEnterTime;
        if (this.mModel.hk() == 2) {
            z = true;
        } else {
            z = false;
        }
        gVar.oG = z;
        gVar.oH = this.mAdOpenInteractionListener;
        gVar.mAdRewardStepListener = this.mAdRewardStepListener;
        gVar.mScreenOrientation = this.mModel.getScreenOrientation();
        gVar.mVideoPlayConfig = this.mModel.hj();
        gVar.mReportExtData = this.mModel.hl();
        gVar.mRootContainer = this.mRootContainer;
        gVar.d(hi);
        if (com.kwad.sdk.core.response.b.b.dO(bH)) {
            loadStrategy = LoadStrategy.FULL_TK;
        } else {
            loadStrategy = LoadStrategy.MULTI;
        }
        gVar.pA = loadStrategy;
        gVar.a(this);
        if (com.kwad.sdk.core.response.b.a.aF(bH)) {
            gVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(adTemplate, this.mModel.hl());
        }
        gVar.oL = new RewardActionBarControl(gVar, this.mContext, adTemplate);
        gVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.b.b.cy(adTemplate)) {
            j jVar = new j(gVar, this.mModel.hl(), null);
            gVar.oM = jVar;
            jVar.a(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.5
                @Override // com.kwad.components.ad.reward.c.d
                public final void a(com.kwad.components.ad.reward.c.b bVar) {
                    gVar.b(bVar);
                }
            });
        }
        if (com.kwad.sdk.core.response.b.a.as(bH)) {
            gVar.oN = new com.kwad.components.ad.k.a().af(true);
        }
        gVar.oX = true;
        if (com.kwad.sdk.core.response.b.a.bH(bH)) {
            gVar.oK = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0913ff));
        }
        gVar.pt = 0L;
        if (this.mModel.bH() != null) {
            if (com.kwad.sdk.core.response.b.a.bH(this.mModel.bH())) {
                am = com.kwad.sdk.core.response.b.a.ar(this.mModel.bH());
            } else {
                am = com.kwad.sdk.core.response.b.a.am(this.mModel.bH());
            }
            gVar.pt = am;
        }
        gVar.mTimerHelper = getTimerHelper();
        gVar.oI = new com.kwad.components.ad.reward.m.e(gVar);
        gVar.gt = this.mModel.gt;
        return gVar;
    }
}
