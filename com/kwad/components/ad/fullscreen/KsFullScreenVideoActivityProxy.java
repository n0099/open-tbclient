package com.kwad.components.ad.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.j.a;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.m;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenVideoActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.r;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
/* loaded from: classes9.dex */
public class KsFullScreenVideoActivityProxy extends com.kwad.components.core.g.b<k> implements a.InterfaceC0609a {
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String TAG = "FullScreenVideo";
    public static final HashMap<String, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener> sHashMap = new HashMap<>();
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public com.kwad.components.ad.fullscreen.b.b mFullScreenPresenter;
    public KsFullScreenVideoAd.FullScreenVideoAdInteractionListener mInteractionListener;
    public boolean mIsBackEnable;
    public boolean mPageDismissCalled;
    public long mPageEnterTime;
    public JSONObject mReportExtData;
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public KsVideoPlayConfig mVideoPlayConfig;
    public e mPlayEndPageListener = new e() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            KsFullScreenVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    public com.kwad.components.ad.reward.d.a mAdOpenInteractionListener = new com.kwad.components.ad.reward.d.b() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.2
        @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
        public final void bB() {
            if (KsFullScreenVideoActivityProxy.this.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.this.mInteractionListener.onAdClicked();
            }
        }

        @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
        public final void j(boolean z) {
            KsFullScreenVideoActivityProxy.this.notifyPageDismiss();
        }

        @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
        public final void onSkippedVideo() {
            if (KsFullScreenVideoActivityProxy.this.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.this.mInteractionListener.onSkippedVideo();
            }
        }

        @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
        public final void onVideoPlayEnd() {
            if (KsFullScreenVideoActivityProxy.this.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.this.mInteractionListener.onVideoPlayEnd();
            }
        }

        @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
        public final void onVideoPlayError(int i, int i2) {
            if (KsFullScreenVideoActivityProxy.this.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.this.mInteractionListener.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
        public final void onVideoPlayStart() {
            if (KsFullScreenVideoActivityProxy.this.mInteractionListener != null) {
                KsFullScreenVideoActivityProxy.this.mInteractionListener.onVideoPlayStart();
            }
        }
    };

    public static String getListenerKey(AdTemplate adTemplate) {
        return adTemplate == null ? "" : String.valueOf(com.kwad.sdk.core.response.a.d.bQ(adTemplate).adBaseInfo.creativeId);
    }

    private boolean initData() {
        File ad;
        String str;
        Serializable serializableExtra = getIntent().getSerializableExtra("key_video_play_config");
        if (serializableExtra instanceof KsVideoPlayConfig) {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            try {
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(stringExtra));
                this.mAdTemplate = adTemplate;
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTrace(th);
            }
            AdTemplate adTemplate2 = this.mAdTemplate;
            if (adTemplate2 != null) {
                this.mInteractionListener = sHashMap.get(getListenerKey(adTemplate2));
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
                this.mAdInfo = bQ;
                String A = com.kwad.sdk.core.response.a.a.A(bQ);
                if (com.kwad.sdk.core.config.d.sc() >= 0 || ((ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(A)) != null && ad.exists())) {
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
        com.kwad.sdk.core.e.b.e(TAG, str);
        return false;
    }

    private void initVideoPlayConfig(@NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        if (TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            return;
        }
        this.mReportExtData = null;
        JSONObject jSONObject = new JSONObject();
        this.mReportExtData = jSONObject;
        r.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
    }

    private void initView() {
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0913a7);
        this.mRootContainer = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.obfuscated_res_0x7f0913fd);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Intent intent;
        if (context == null) {
            com.kwad.sdk.core.e.b.e(TAG, "launch error, context is null");
            return;
        }
        com.kwad.sdk.utils.k.ci(adTemplate);
        if (ksVideoPlayConfig.isShowLandscape()) {
            KsAdSDKImpl.putComponentProxy(KsFullScreenLandScapeVideoActivity.class, KsFullScreenLandScapeVideoActivityProxy.class);
            intent = new Intent(context, KsFullScreenLandScapeVideoActivity.class);
        } else {
            KsAdSDKImpl.putComponentProxy(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
            intent = new Intent(context, FeedDownloadActivity.class);
        }
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        sHashMap.put(getListenerKey(adTemplate), fullScreenVideoAdInteractionListener);
        context.startActivity(intent);
        com.kwad.sdk.kwai.kwai.c.rd().aI(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPageDismiss() {
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
        com.kwad.sdk.kwai.kwai.c.rd().rg();
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 6, this.mReportExtData);
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onPageDismiss();
        }
    }

    @InvokeBy(invokerClass = KsAdSDKImpl.class, methodId = KsAdSDKImpl.INVOKER_ID_INIT_COMPONENT_PROXY)
    public static void register() {
        KsAdSDKImpl.putComponentProxy(KsFullScreenVideoActivity.class, KsFullScreenVideoActivityProxy.class);
        KsAdSDKImpl.putComponentProxy(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        notifyPageDismiss();
        getActivity().finish();
    }

    @Override // com.kwad.components.core.i.a
    public String getPageName() {
        return "KsFullScreenVideoActivityProxy";
    }

    @Override // com.kwad.components.ad.reward.j.a.InterfaceC0609a
    public boolean handledOnResume() {
        com.kwad.components.ad.fullscreen.b.b bVar = this.mFullScreenPresenter;
        if (bVar != null) {
            return bVar.bH();
        }
        return false;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.ad.fullscreen.b.b bVar = this.mFullScreenPresenter;
        if ((bVar == null || !bVar.bG()) && this.mIsBackEnable) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
            getIntent().removeExtra(AdWebViewVideoActivityProxy.KEY_TEMPLATE);
        } catch (Throwable unused) {
        }
        super.onCreate(bundle);
        getActivity().setTheme(16973838);
        if (!initData()) {
            finish();
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mPageEnterTime = elapsedRealtime;
        com.kwad.components.ad.reward.monitor.a.a(false, this.mAdTemplate, elapsedRealtime);
        com.kwad.components.ad.reward.monitor.a.b(false, this.mAdTemplate, this.mPageEnterTime);
        this.mContext = Wrapper.wrapContextIfNeed(getActivity());
        setContentView(R.layout.obfuscated_res_0x7f0d046a);
        initView();
        onActivityCreated(this.mRootContainer);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwad.components.core.g.b
    public k onCreateCallerContext() {
        k kVar = new k();
        kVar.EG = this;
        kVar.mContext = this.mContext;
        kVar.mPageEnterTime = this.mPageEnterTime;
        kVar.mAdOpenInteractionListener = this.mAdOpenInteractionListener;
        kVar.mScreenOrientation = this.mScreenOrientation;
        kVar.mVideoPlayConfig = this.mVideoPlayConfig;
        kVar.mReportExtData = this.mReportExtData;
        kVar.mRootContainer = this.mRootContainer;
        kVar.mAdTemplate = this.mAdTemplate;
        kVar.mj = this.mDetailVideoView;
        com.kwad.components.ad.reward.j.a aVar = new com.kwad.components.ad.reward.j.a(kVar, false);
        kVar.eF = aVar;
        aVar.a(this);
        kVar.EF.add(aVar);
        if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
            kVar.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate, this.mReportExtData);
        }
        kVar.ml = new RewardActionBarControl(kVar, this.mContext, this.mAdTemplate);
        kVar.a(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.a.b.bd(this.mAdTemplate)) {
            kVar.mm = new m(kVar, this.mReportExtData, null);
        }
        if (com.kwad.sdk.core.response.a.a.aY(this.mAdInfo)) {
            kVar.mk = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091308));
        }
        if (com.kwad.sdk.core.response.a.d.bX(this.mAdTemplate)) {
            kVar.mo = new com.kwad.components.ad.i.a().ae(false);
        }
        kVar.mz = false;
        kVar.mO = com.kwad.sdk.core.response.a.a.aY(this.mAdInfo) ? com.kwad.sdk.core.response.a.a.Y(this.mAdInfo) : com.kwad.sdk.core.response.a.a.X(this.mAdInfo);
        return kVar;
    }

    @Override // com.kwad.components.core.g.b
    public Presenter onCreatePresenter() {
        b bVar = new b(this.mAdTemplate);
        getActivity();
        com.kwad.components.ad.fullscreen.b.b bVar2 = new com.kwad.components.ad.fullscreen.b.b(this, this.mRootContainer, bVar, (k) this.mCallerContext);
        this.mFullScreenPresenter = bVar2;
        return bVar2;
    }

    @Override // com.kwad.components.core.g.b, com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        notifyPageDismiss();
        AdInfo adInfo = this.mAdInfo;
        if (adInfo != null) {
            com.kwad.sdk.core.videocache.b.a.bC(this.mContext.getApplicationContext()).cD(com.kwad.sdk.core.response.a.a.A(adInfo));
        }
        T t = this.mCallerContext;
        if (t != 0) {
            ((k) t).eF.b(this);
        }
        sHashMap.remove(getListenerKey(this.mAdTemplate));
        this.mInteractionListener = null;
    }
}
