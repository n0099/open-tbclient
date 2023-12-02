package com.kwad.components.ad.fullscreen;

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
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenVideoActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
/* loaded from: classes10.dex */
public class KsFullScreenVideoActivityProxy extends com.kwad.components.core.l.b<com.kwad.components.ad.reward.g> implements OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    public static final String TAG = "FullScreenVideo";
    public static final HashMap<String, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener> sHashMap = new HashMap<>();
    public AdInfo mAdInfo;
    public AdResultData mAdResultData;
    public AdTemplate mAdTemplate;
    public com.kwad.components.ad.fullscreen.c.b mFullScreenPresenter;
    public KsFullScreenVideoAd.FullScreenVideoAdInteractionListener mInteractionListener;
    public boolean mIsBackEnable;
    public boolean mPageDismissCalled;
    public long mPageEnterTime;
    public JSONObject mReportExtData;
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public bm mTimerHelper;
    public KsVideoPlayConfig mVideoPlayConfig;
    public b model;
    public boolean mReportedPageResume = false;
    public com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            KsFullScreenVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    public d mAdOpenInteractionListener = new d() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.2
        @Override // com.kwad.components.ad.fullscreen.d, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void h(boolean z) {
            if (KsFullScreenVideoActivityProxy.this.notifyPageDismiss()) {
                super.h(z);
            }
        }
    };

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return "KsFullScreenVideoActivityProxy";
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPageDismiss() {
        if (this.mPageDismissCalled) {
            return false;
        }
        this.mPageDismissCalled = true;
        com.kwad.sdk.a.a.c.yT().yW();
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 6, getTimerHelper().getTime(), this.mReportExtData);
        return true;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(KsFullScreenVideoActivity.class, KsFullScreenVideoActivityProxy.class);
        com.kwad.sdk.service.b.a(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        this.mAdOpenInteractionListener.h(false);
    }

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        b bVar = this.model;
        if (bVar != null && bVar.gt) {
            return R.layout.obfuscated_res_0x7f0d04a3;
        }
        return R.layout.obfuscated_res_0x7f0d04a4;
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return ((com.kwad.components.ad.reward.g) this.mCallerContext).fw();
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091490);
        com.kwad.sdk.i.a.aj("fullscreen", "show");
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.e.c.bA(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.ad.fullscreen.c.b bVar = this.mFullScreenPresenter;
        if ((bVar == null || !bVar.onBackPressed()) && this.mIsBackEnable) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.l.b
    public Presenter onCreatePresenter() {
        getActivity();
        com.kwad.components.ad.fullscreen.c.b bVar = new com.kwad.components.ad.fullscreen.c.b(this, this.mRootContainer, this.model, (com.kwad.components.ad.reward.g) this.mCallerContext);
        this.mFullScreenPresenter = bVar;
        return bVar;
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        getTimerHelper().LN();
        T t = this.mCallerContext;
        if (t != 0) {
            ((com.kwad.components.ad.reward.g) t).mPageEnterTime = -1L;
        }
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        getTimerHelper().LM();
        if (!this.mReportedPageResume) {
            com.kwad.components.ad.reward.monitor.c.f(false, this.mAdTemplate);
            this.mReportedPageResume = true;
        }
    }

    public static void reportSubPageCreate(String str, AdTemplate adTemplate) {
        com.kwad.components.ad.reward.monitor.c.c(false, adTemplate, str);
    }

    public static String getListenerKey(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return "";
        }
        return String.valueOf(com.kwad.sdk.core.response.b.e.dP(adTemplate).adBaseInfo.creativeId);
    }

    private void initVideoPlayConfig(@NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        if (!TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            this.mReportExtData = null;
            JSONObject jSONObject = new JSONObject();
            this.mReportExtData = jSONObject;
            t.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
        }
    }

    @Override // com.kwad.components.core.proxy.c
    public void onCreateCaughtException(Throwable th) {
        super.onCreateCaughtException(th);
        com.kwad.components.ad.reward.monitor.b.b(false, this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        reportSubPageCreate(pageCreateStage.getStage(), this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    public static void launch(@NonNull Context context, @NonNull AdResultData adResultData, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Intent intent;
        AdTemplate m = com.kwad.sdk.core.response.b.c.m(adResultData);
        com.kwad.components.ad.reward.monitor.c.i(false, m);
        l.ej(m);
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.b.a(KsFullScreenLandScapeVideoActivity.class, KsFullScreenLandScapeVideoActivityProxy.class);
            intent = new Intent(context, KsFullScreenLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.b.a(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
            intent = new Intent(context, FeedDownloadActivity.class);
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.mB().i(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", com.kwad.components.core.internal.api.e.a(ksVideoPlayConfig));
        sHashMap.put(getListenerKey(m), fullScreenVideoAdInteractionListener);
        try {
            context.startActivity(intent);
            com.kwad.sdk.a.a.c.yT().bi(true);
            reportSubPageCreate(PageCreateStage.END_LAUNCH.getStage(), m);
        } catch (Throwable th) {
            com.kwad.components.ad.reward.monitor.c.a(false, m, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th.getMessage());
            throw th;
        }
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean checkIntentData(@Nullable Intent intent) {
        if (com.kwad.sdk.core.config.d.Bw()) {
            this.mVideoPlayConfig = com.kwad.components.core.internal.api.e.b(getIntent().getStringExtra("key_video_play_config_json"), true);
        } else {
            Serializable serializableExtra = getIntent().getSerializableExtra("key_video_play_config");
            if (serializableExtra instanceof KsVideoPlayConfig) {
                this.mVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
            }
        }
        AdResultData d = com.kwad.components.core.c.f.mB().d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true);
        this.mAdResultData = d;
        if (d == null) {
            return false;
        }
        AdTemplate m = com.kwad.sdk.core.response.b.c.m(d);
        this.mAdTemplate = m;
        this.model = new b(m);
        this.mAdOpenInteractionListener.setAdTemplate(this.mAdTemplate);
        if (this.mVideoPlayConfig != null && this.mAdTemplate != null) {
            return true;
        }
        com.kwad.sdk.i.a.aj("fullscreen", "show");
        return false;
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        int i;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mPageEnterTime = elapsedRealtime;
        com.kwad.components.ad.reward.monitor.c.a(false, this.mAdTemplate, elapsedRealtime);
        com.kwad.components.ad.reward.monitor.c.g(false, this.mAdTemplate);
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = sHashMap.get(getListenerKey(this.mAdTemplate));
        this.mInteractionListener = fullScreenVideoAdInteractionListener;
        this.mAdOpenInteractionListener.b(fullScreenVideoAdInteractionListener);
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        this.mScreenOrientation = this.mVideoPlayConfig.isShowLandscape() ? 1 : 0;
        AdTemplate adTemplate = this.mAdTemplate;
        if (this.mVideoPlayConfig.isVideoSoundEnable()) {
            i = 2;
        } else {
            i = 1;
        }
        adTemplate.mInitVoiceStatus = i;
        initVideoPlayConfig(this.mVideoPlayConfig);
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        this.mAdOpenInteractionListener.h(false);
        AdInfo adInfo = this.mAdInfo;
        if (adInfo != null) {
            String K = com.kwad.sdk.core.response.b.a.K(adInfo);
            if (!TextUtils.isEmpty(K)) {
                com.kwad.sdk.core.videocache.c.a.bl(this.mContext.getApplicationContext()).ei(K);
            }
        }
        T t = this.mCallerContext;
        if (t != 0 && ((com.kwad.components.ad.reward.g) t).oI != null && ((com.kwad.components.ad.reward.g) t).oI.jK()) {
            ((com.kwad.components.ad.reward.g) this.mCallerContext).oI.jL().removeInterceptor(this);
        }
        sHashMap.remove(getListenerKey(this.mAdTemplate));
        this.mInteractionListener = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwad.components.core.l.b
    public com.kwad.components.ad.reward.g onCreateCallerContext() {
        long am;
        com.kwad.components.ad.reward.g gVar = new com.kwad.components.ad.reward.g(this);
        gVar.d(this.mAdResultData);
        gVar.mPageEnterTime = this.mPageEnterTime;
        gVar.oG = false;
        gVar.oH = this.mAdOpenInteractionListener;
        gVar.mScreenOrientation = this.mScreenOrientation;
        gVar.mVideoPlayConfig = this.mVideoPlayConfig;
        gVar.mReportExtData = this.mReportExtData;
        gVar.mRootContainer = this.mRootContainer;
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            gVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate, this.mReportExtData);
        }
        gVar.oL = new RewardActionBarControl(gVar, this.mContext, this.mAdTemplate);
        gVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.b.b.cy(this.mAdTemplate)) {
            gVar.oM = new j(gVar, this.mReportExtData, null);
        }
        if (com.kwad.sdk.core.response.b.a.bH(this.mAdInfo)) {
            gVar.oK = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0913ff));
        }
        gVar.oX = false;
        if (com.kwad.sdk.core.response.b.a.bH(this.mAdInfo)) {
            am = com.kwad.sdk.core.response.b.a.ar(this.mAdInfo);
        } else {
            am = com.kwad.sdk.core.response.b.a.am(this.mAdInfo);
        }
        gVar.pt = am;
        gVar.mTimerHelper = getTimerHelper();
        gVar.oI = new com.kwad.components.ad.reward.m.e(gVar);
        return gVar;
    }
}
