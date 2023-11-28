package com.kwad.components.ad.reward.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.h;
import com.kwad.components.ad.reward.j.b;
import com.kwad.components.ad.reward.model.RewardCallBackRespInfo;
import com.kwad.components.ad.reward.widget.HandSlideView;
import com.kwad.components.ad.reward.widget.RewardPreviewTopBarView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.proxy.c;
import com.kwad.components.core.request.e;
import com.kwad.components.core.s.h;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes10.dex */
public class AdRewardPreviewActivityProxy extends c implements HandSlideView.a {
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_URL = "key_langingpage_url";
    public static final String TAG = "AdRewardPreviewActivityProxy";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public h mCloseDialog;
    public int mCount;
    public com.kwad.components.core.s.h mCountdownHelper;
    public long mCurrentDuration;
    public View mHandSlideContainer;
    @Nullable
    public HandSlideView mHandSlideView;
    public long mLastDown;
    public KsLogoView mLogoView;
    public int mSkipCount;
    public long mStartPlayTime;
    public bm mTimerHelper;
    public RewardPreviewTopBarView mTopBarView;
    public String mUrl;
    public AdBaseFrameLayout mWebContainer;
    public boolean mHadAdClicked = false;
    public boolean mCheckExposureResult = true;
    public long mPageEnterTime = 0;
    public boolean mReportedPageShow = false;

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d04ab;
    }

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return TAG;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static void a(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, long j) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onVideoSkipToEnd(j);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        public static void c(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onRewardVerify();
                try {
                    rewardAdInteractionListener.onRewardStepVerify(0, 0);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        public static void d(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        public static void e(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onPageDismiss();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        public static void f(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onAdClicked();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }
    }

    private void closeHandSlideMask() {
        HandSlideView handSlideView = this.mHandSlideView;
        if (handSlideView != null) {
            handSlideView.destroy();
            this.mHandSlideView = null;
        }
        View view2 = this.mHandSlideContainer;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private o<e, RewardCallBackRespInfo> exposureRequest() {
        return new o<e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.7
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* bridge */ /* synthetic */ void onStartRequest(@NonNull f fVar) {
            }

            private void a(@NonNull RewardCallBackRespInfo rewardCallBackRespInfo) {
                AdRewardPreviewActivityProxy adRewardPreviewActivityProxy = AdRewardPreviewActivityProxy.this;
                boolean z = true;
                if (rewardCallBackRespInfo.result != 1) {
                    z = false;
                }
                adRewardPreviewActivityProxy.mCheckExposureResult = z;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull e eVar, int i, String str) {
                super.onError(eVar, i, str);
                AdRewardPreviewActivityProxy.this.mCheckExposureResult = false;
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                a((RewardCallBackRespInfo) baseResultData);
            }
        };
    }

    private y.b getClientParams() {
        y.b bVar = new y.b();
        bVar.axA = 0;
        return bVar;
    }

    private KsAdWebView.d getWebErrorListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                com.kwad.components.ad.reward.monitor.c.b(true, AdRewardPreviewActivityProxy.this.mAdTemplate, AdRewardPreviewActivityProxy.this.mPageEnterTime);
                com.kwad.components.ad.reward.monitor.c.L(AdRewardPreviewActivityProxy.this.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
                com.kwad.components.ad.reward.monitor.c.K(AdRewardPreviewActivityProxy.this.mAdTemplate);
                if (!AdRewardPreviewActivityProxy.this.mAdTemplate.mPvReported) {
                    AdRewardPreviewActivityProxy.this.checkExposure();
                }
                if (!AdRewardPreviewActivityProxy.this.mHadAdClicked) {
                    AdRewardPreviewActivityProxy.this.showHandSlideMask();
                }
                y.a aVar = new y.a();
                aVar.axc = "award_view";
                b.a(true, AdRewardPreviewActivityProxy.this.mAdTemplate, null, new j().a(aVar));
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.components.ad.reward.monitor.c.c(AdRewardPreviewActivityProxy.this.mAdTemplate, i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCountdownEnd() {
        if (this.mCheckExposureResult) {
            a.c(mInteractionListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEndClose() {
        a.d(mInteractionListener);
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 1, getTimerHelper().getTime(), (JSONObject) null);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHandSlideMask() {
        HandSlideView handSlideView = this.mHandSlideView;
        if (handSlideView == null || handSlideView.isStarted()) {
            return;
        }
        this.mHandSlideContainer.setVisibility(0);
        this.mHandSlideView.a(this);
    }

    public void checkExposure() {
        long j = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate).adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j > 0 && com.kwad.sdk.core.response.b.a.ag(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate)) > 5000) {
            bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.5
                @Override // java.lang.Runnable
                public final void run() {
                    AdRewardPreviewActivityProxy.this.checkRequest(1);
                }
            }, j);
        }
    }

    public bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bm();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.components.core.proxy.c
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.i.a.aj("reward", "show");
        com.kwad.sdk.commercial.e.c.bA(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        a.e(mInteractionListener);
        mInteractionListener = null;
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
        com.kwad.components.core.s.h hVar = this.mCountdownHelper;
        if (hVar != null) {
            hVar.stop();
        }
        super.onDestroy();
    }

    @Override // com.kwad.components.ad.reward.widget.HandSlideView.a
    public void onHandSlideLoopEnd() {
        closeHandSlideMask();
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
        getTimerHelper().LN();
        com.kwad.components.core.s.h hVar = this.mCountdownHelper;
        if (hVar != null) {
            hVar.pause();
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        getTimerHelper().LM();
        com.kwad.components.core.s.h hVar = this.mCountdownHelper;
        if (hVar != null) {
            hVar.resume();
        }
        if (!this.mReportedPageShow) {
            com.kwad.components.ad.reward.monitor.c.f(true, this.mAdTemplate);
            this.mReportedPageShow = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRequest(final int i) {
        new l<e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.6
            @NonNull
            public static RewardCallBackRespInfo C(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.response.model.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
                return C(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: gj */
            public e createRequest() {
                return new e(i, AdRewardPreviewActivityProxy.this.mAdTemplate);
            }
        }.request(exposureRequest());
    }

    private void reportSubPageCreate(String str) {
        com.kwad.components.ad.reward.monitor.c.c(true, this.mAdTemplate, str);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mPageEnterTime = elapsedRealtime;
        com.kwad.components.ad.reward.monitor.c.a(true, this.mAdTemplate, elapsedRealtime);
    }

    @Override // com.kwad.components.core.proxy.c
    public void onCreateCaughtException(Throwable th) {
        super.onCreateCaughtException(th);
        com.kwad.components.ad.reward.monitor.b.b(true, this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        reportSubPageCreate(pageCreateStage.getStage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAdClick() {
        this.mHadAdClicked = true;
        y.a aVar = new y.a();
        aVar.axc = "award_view";
        b.a(this.mAdTemplate, (String) null, "nativePreview", new j().cA(72).a(aVar).d(this.mWebContainer.getTouchCoords()), (JSONObject) null);
        closeHandSlideMask();
        a.f(mInteractionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCloseDialog() {
        h hVar = this.mCloseDialog;
        if (hVar != null && hVar.isShowing()) {
            return;
        }
        int ceil = (int) Math.ceil(((float) this.mCurrentDuration) / 1000.0f);
        this.mCloseDialog = h.a(getActivity(), this.mAdTemplate, h.h("还差" + ceil + "秒就可以获取奖励", ceil), new h.b() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.8
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void F(boolean z) {
                a.a(AdRewardPreviewActivityProxy.mInteractionListener, System.currentTimeMillis() - AdRewardPreviewActivityProxy.this.mStartPlayTime);
                com.kwad.sdk.core.report.a.a(AdRewardPreviewActivityProxy.this.mAdTemplate, 1, AdRewardPreviewActivityProxy.this.getTimerHelper().getTime(), (JSONObject) null);
                AdRewardPreviewActivityProxy.this.finish();
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void fP() {
                if (AdRewardPreviewActivityProxy.this.mCountdownHelper != null) {
                    AdRewardPreviewActivityProxy.this.mCountdownHelper.pause();
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void fY() {
                if (AdRewardPreviewActivityProxy.this.mCountdownHelper != null) {
                    AdRewardPreviewActivityProxy.this.mCountdownHelper.resume();
                }
            }
        });
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        this.mUrl = getIntent().getStringExtra(KEY_URL);
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        int i = dP.adStyleInfo.adBrowseInfo.adBrowseDuration;
        int ae = com.kwad.sdk.core.response.b.a.ae(dP);
        this.mCount = i;
        this.mSkipCount = Math.min(ae, i);
        this.mStartPlayTime = System.currentTimeMillis();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            try {
                rewardAdInteractionListener.onVideoPlayStart();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        boolean z;
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.mAdWebView.goBack();
            com.kwad.sdk.core.report.a.bP(this.mAdTemplate);
            return;
        }
        RewardPreviewTopBarView rewardPreviewTopBarView = this.mTopBarView;
        if (rewardPreviewTopBarView != null && rewardPreviewTopBarView.kc()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            super.onBackPressed();
            a.d(mInteractionListener);
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, 11, getTimerHelper().getTime(), (JSONObject) null);
            return;
        }
        showCloseDialog();
    }

    public static void launch(Activity activity, AdResultData adResultData, AdTemplate adTemplate, String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        com.kwad.components.ad.reward.monitor.c.i(true, adTemplate);
        boolean Bw = d.Bw();
        mInteractionListener = rewardAdInteractionListener;
        com.kwad.sdk.service.b.a(AdWebViewActivity.class, AdRewardPreviewActivityProxy.class);
        Intent intent = new Intent(activity, AdWebViewActivity.class);
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra(KEY_URL, str);
        if (Bw) {
            intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.mB().i(adResultData));
        } else {
            intent.putExtra("key_template_json", adTemplate.toJson().toString());
        }
        try {
            activity.startActivity(intent);
            if (!Bw) {
                activity.overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            com.kwad.sdk.crash.b.m(e);
            com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, PageCreateStage.ERROR_START_ACTIVITY.getStage(), e.getMessage());
        }
        com.kwad.components.ad.reward.monitor.c.c(true, adTemplate, PageCreateStage.END_LAUNCH.getStage());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049 A[RETURN] */
    @Override // com.kwad.components.core.proxy.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkIntentData(@Nullable Intent intent) {
        if (intent != null) {
            try {
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
            if (intent.hasExtra("key_ad_result_cache_idx")) {
                this.mAdTemplate = com.kwad.components.core.c.f.mB().d(intent.getIntExtra("key_ad_result_cache_idx", 0), true).getFirstAdTemplate();
                if (this.mAdTemplate == null) {
                    return true;
                }
                com.kwad.sdk.i.a.aj("reward", "show");
                return false;
            }
        }
        String stringExtra = getIntent().getStringExtra("key_template_json");
        AdTemplate adTemplate = new AdTemplate();
        adTemplate.parseJson(new JSONObject(stringExtra));
        this.mAdTemplate = adTemplate;
        if (this.mAdTemplate == null) {
        }
    }

    @Override // com.kwad.components.core.proxy.c
    @SuppressLint({"SetTextI18n"})
    public void initView() {
        String aS;
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091512);
        this.mAdWebView = ksAdWebView;
        this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().b(getClientParams()).eh(this.mAdTemplate).bt(true).bv(true).bs(true).b(getWebErrorListener()));
        this.mAdWebView.onActivityCreate();
        this.mWebContainer = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091409);
        KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091478);
        this.mLogoView = ksLogoView;
        ksLogoView.aD(this.mAdTemplate);
        this.mHandSlideContainer = findViewById(R.id.obfuscated_res_0x7f091477);
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        if (this.mUrl != null) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aF(dP) && d.AI() && ag.isWifiConnected(getActivity())) {
                cVar.s(new a.C0644a(getActivity()).ao(false).ap(false).aq(this.mAdTemplate).ar(false));
            }
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            aS = this.mUrl;
        } else {
            aS = com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate));
        }
        this.mAdWebView.loadUrl(aS);
        getTimerHelper().startTiming();
        this.mWebContainer.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.1
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    AdRewardPreviewActivityProxy.this.mLastDown = SystemClock.elapsedRealtime();
                    return false;
                } else if (motionEvent.getAction() == 1) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - AdRewardPreviewActivityProxy.this.mLastDown;
                    if (AdRewardPreviewActivityProxy.this.mLastDown > 0 && elapsedRealtime > 60 && elapsedRealtime < 500) {
                        AdRewardPreviewActivityProxy.this.handleAdClick();
                    }
                    AdRewardPreviewActivityProxy.this.mLastDown = 0L;
                    return false;
                } else {
                    return false;
                }
            }
        });
        this.mHandSlideView = (HandSlideView) findViewById(R.id.obfuscated_res_0x7f091476);
        com.kwad.components.core.s.h hVar = new com.kwad.components.core.s.h(this.mCount * 1000);
        this.mCountdownHelper = hVar;
        hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.2
            @Override // com.kwad.components.core.s.h.a
            public final void onProgress(long j, long j2) {
                com.kwad.sdk.core.e.c.d(AdRewardPreviewActivityProxy.TAG, "onProgress currentDuration: " + j + " , totalDuration: " + j2);
                AdRewardPreviewActivityProxy.this.mCurrentDuration = j;
                AdRewardPreviewActivityProxy.this.mTopBarView.n(j);
            }
        });
        this.mCountdownHelper.start();
        RewardPreviewTopBarView rewardPreviewTopBarView = (RewardPreviewTopBarView) findViewById(R.id.obfuscated_res_0x7f091479);
        this.mTopBarView = rewardPreviewTopBarView;
        rewardPreviewTopBarView.setTotalCountDuration(this.mCount * 1000);
        this.mTopBarView.setRewardTips(com.kwad.sdk.core.response.b.a.bY(dP));
        this.mTopBarView.setCloseBtnDelayShowDuration(this.mSkipCount * 1000);
        this.mTopBarView.setTopBarListener(new RewardPreviewTopBarView.a() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.3
            @Override // com.kwad.components.ad.reward.widget.RewardPreviewTopBarView.a
            public final void F(boolean z) {
                if (z) {
                    AdRewardPreviewActivityProxy.this.handleEndClose();
                } else {
                    AdRewardPreviewActivityProxy.this.showCloseDialog();
                }
            }

            @Override // com.kwad.components.ad.reward.widget.RewardPreviewTopBarView.a
            public final void G(boolean z) {
                if (z) {
                    return;
                }
                AdRewardPreviewActivityProxy.this.handleCountdownEnd();
            }
        });
    }
}
