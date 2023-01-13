package com.kwad.components.ad.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public class KsFullScreenVideoActivityProxy extends com.kwad.components.core.g.b<k> implements a.InterfaceC0571a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String TAG = "FullScreenVideo";
    public static final HashMap<String, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener> sHashMap;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo mAdInfo;
    public com.kwad.components.ad.reward.d.a mAdOpenInteractionListener;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public com.kwad.components.ad.fullscreen.b.b mFullScreenPresenter;
    public KsFullScreenVideoAd.FullScreenVideoAdInteractionListener mInteractionListener;
    public boolean mIsBackEnable;
    public boolean mPageDismissCalled;
    public long mPageEnterTime;
    public e mPlayEndPageListener;
    public JSONObject mReportExtData;
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public KsVideoPlayConfig mVideoPlayConfig;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(646551769, "Lcom/kwad/components/ad/fullscreen/KsFullScreenVideoActivityProxy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(646551769, "Lcom/kwad/components/ad/fullscreen/KsFullScreenVideoActivityProxy;");
                return;
            }
        }
        sHashMap = new HashMap<>();
    }

    public KsFullScreenVideoActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPlayEndPageListener = new e(this) { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsFullScreenVideoActivityProxy eh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.eh = this;
            }

            @Override // com.kwad.components.ad.reward.d.e
            public final void bA() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.eh.mIsBackEnable = true;
                }
            }
        };
        this.mAdOpenInteractionListener = new com.kwad.components.ad.reward.d.b(this) { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsFullScreenVideoActivityProxy eh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.eh = this;
            }

            @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
            public final void bB() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.eh.mInteractionListener == null) {
                    return;
                }
                this.eh.mInteractionListener.onAdClicked();
            }

            @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
            public final void j(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.eh.notifyPageDismiss();
                }
            }

            @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
            public final void onSkippedVideo() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.eh.mInteractionListener == null) {
                    return;
                }
                this.eh.mInteractionListener.onSkippedVideo();
            }

            @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
            public final void onVideoPlayEnd() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.eh.mInteractionListener == null) {
                    return;
                }
                this.eh.mInteractionListener.onVideoPlayEnd();
            }

            @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
            public final void onVideoPlayError(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(1048580, this, i3, i4) == null) || this.eh.mInteractionListener == null) {
                    return;
                }
                this.eh.mInteractionListener.onVideoPlayError(i3, i4);
            }

            @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
            public final void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.eh.mInteractionListener == null) {
                    return;
                }
                this.eh.mInteractionListener.onVideoPlayStart();
            }
        };
    }

    public static String getListenerKey(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, adTemplate)) == null) ? adTemplate == null ? "" : String.valueOf(com.kwad.sdk.core.response.a.d.bQ(adTemplate).adBaseInfo.creativeId) : (String) invokeL.objValue;
    }

    private boolean initData() {
        InterceptResult invokeV;
        File ad;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
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
        return invokeV.booleanValue;
    }

    private void initVideoPlayConfig(@NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, ksVideoPlayConfig) == null) || TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            return;
        }
        this.mReportExtData = null;
        JSONObject jSONObject = new JSONObject();
        this.mReportExtData = jSONObject;
        r.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091273);
            this.mRootContainer = adBaseFrameLayout;
            DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.obfuscated_res_0x7f0912c9);
            this.mDetailVideoView = detailVideoView;
            detailVideoView.setAd(true);
        }
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, context, adTemplate, ksVideoPlayConfig, fullScreenVideoAdInteractionListener) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPageDismiss() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || this.mPageDismissCalled) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            KsAdSDKImpl.putComponentProxy(KsFullScreenVideoActivity.class, KsFullScreenVideoActivityProxy.class);
            KsAdSDKImpl.putComponentProxy(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            notifyPageDismiss();
            getActivity().finish();
        }
    }

    @Override // com.kwad.components.core.i.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "KsFullScreenVideoActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.j.a.InterfaceC0571a
    public boolean handledOnResume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            com.kwad.components.ad.fullscreen.b.b bVar = this.mFullScreenPresenter;
            if (bVar != null) {
                return bVar.bH();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.kwad.components.ad.fullscreen.b.b bVar = this.mFullScreenPresenter;
            if ((bVar == null || !bVar.bG()) && this.mIsBackEnable) {
                super.onBackPressed();
            }
        }
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
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
            setContentView(R.layout.obfuscated_res_0x7f0d041b);
            initView();
            onActivityCreated(this.mRootContainer);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwad.components.core.g.b
    public k onCreateCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
                kVar.mk = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0911d4));
            }
            if (com.kwad.sdk.core.response.a.d.bX(this.mAdTemplate)) {
                kVar.mo = new com.kwad.components.ad.i.a().ae(false);
            }
            kVar.mz = false;
            kVar.mO = com.kwad.sdk.core.response.a.a.aY(this.mAdInfo) ? com.kwad.sdk.core.response.a.a.Y(this.mAdInfo) : com.kwad.sdk.core.response.a.a.X(this.mAdInfo);
            return kVar;
        }
        return (k) invokeV.objValue;
    }

    @Override // com.kwad.components.core.g.b
    public Presenter onCreatePresenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b bVar = new b(this.mAdTemplate);
            getActivity();
            com.kwad.components.ad.fullscreen.b.b bVar2 = new com.kwad.components.ad.fullscreen.b.b(this, this.mRootContainer, bVar, (k) this.mCallerContext);
            this.mFullScreenPresenter = bVar2;
            return bVar2;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.components.core.g.b, com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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
}
