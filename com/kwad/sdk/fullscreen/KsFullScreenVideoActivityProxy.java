package com.kwad.sdk.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
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
/* loaded from: classes3.dex */
public class KsFullScreenVideoActivityProxy extends com.kwad.sdk.core.e.a<com.kwad.sdk.reward.a> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String TAG = "FullScreenVideo";
    public static KsFullScreenVideoAd.FullScreenVideoAdInteractionListener mInteractionListener;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo mAdInfo;
    public com.kwad.sdk.reward.a.b mAdOpenInteractionListener;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public boolean mIsBackEnable;
    public boolean mPageDismissCalled;
    public f mPlayEndPageListener;
    public JSONObject mReportExtData;
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public KsVideoPlayConfig mVideoPlayConfig;

    public KsFullScreenVideoActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPlayEndPageListener = new f(this) { // from class: com.kwad.sdk.fullscreen.KsFullScreenVideoActivityProxy.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsFullScreenVideoActivityProxy a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.mIsBackEnable = true;
                }
            }
        };
        this.mAdOpenInteractionListener = new c(this) { // from class: com.kwad.sdk.fullscreen.KsFullScreenVideoActivityProxy.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsFullScreenVideoActivityProxy a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void a() {
                KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fullScreenVideoAdInteractionListener = KsFullScreenVideoActivityProxy.mInteractionListener) == null) {
                    return;
                }
                fullScreenVideoAdInteractionListener.onAdClicked();
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void a(int i4, int i5) {
                KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5) == null) || (fullScreenVideoAdInteractionListener = KsFullScreenVideoActivityProxy.mInteractionListener) == null) {
                    return;
                }
                fullScreenVideoAdInteractionListener.onVideoPlayError(i4, i5);
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                    this.a.notifyPageDismiss();
                }
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void b() {
                KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || (fullScreenVideoAdInteractionListener = KsFullScreenVideoActivityProxy.mInteractionListener) == null) {
                    return;
                }
                fullScreenVideoAdInteractionListener.onSkippedVideo();
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void c() {
                KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || (fullScreenVideoAdInteractionListener = KsFullScreenVideoActivityProxy.mInteractionListener) == null) {
                    return;
                }
                fullScreenVideoAdInteractionListener.onVideoPlayStart();
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void d() {
                KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || (fullScreenVideoAdInteractionListener = KsFullScreenVideoActivityProxy.mInteractionListener) == null) {
                    return;
                }
                fullScreenVideoAdInteractionListener.onVideoPlayEnd();
            }
        };
    }

    private boolean initData() {
        InterceptResult invokeV;
        File b2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
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
        return invokeV.booleanValue;
    }

    private void initVideoPlayConfig(@NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, ksVideoPlayConfig) == null) {
            getActivity().setRequestedOrientation(!ksVideoPlayConfig.isShowLandscape());
            if (TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
                return;
            }
            this.mReportExtData = null;
            JSONObject jSONObject = new JSONObject();
            this.mReportExtData = jSONObject;
            t.a(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            this.mRootContainer = adBaseFrameLayout;
            DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
            this.mDetailVideoView = detailVideoView;
            detailVideoView.setAd(true);
        }
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Class cls;
        Class cls2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, context, adTemplate, ksVideoPlayConfig, fullScreenVideoAdInteractionListener) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPageDismiss() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.mPageDismissCalled) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            notifyPageDismiss();
            getActivity().finish();
        }
    }

    @Override // com.kwad.sdk.h.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "KsFullScreenVideoActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.mIsBackEnable) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
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
    }

    @Override // com.kwad.sdk.core.e.a
    public com.kwad.sdk.reward.a onCreateCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.kwad.sdk.reward.a aVar = new com.kwad.sdk.reward.a();
            aVar.f59456h = getActivity();
            aVar.f59457i = this.mContext;
            aVar.f59450b = this.mAdOpenInteractionListener;
            aVar.f59454f = this.mScreenOrientation;
            KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
            aVar.f59452d = ksVideoPlayConfig;
            aVar.f59453e = this.mReportExtData;
            aVar.f59458j = this.mRootContainer;
            AdTemplate adTemplate = this.mAdTemplate;
            aVar.f59455g = adTemplate;
            com.kwad.sdk.reward.c.a aVar2 = new com.kwad.sdk.reward.c.a(adTemplate, this.mDetailVideoView, ksVideoPlayConfig);
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
            if (d.s(this.mAdTemplate)) {
                aVar.p = new com.kwad.sdk.i.a().a(false);
            }
            aVar.r = false;
            return aVar;
        }
        return (com.kwad.sdk.reward.a) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    @Override // com.kwad.sdk.core.e.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Presenter onCreatePresenter() {
        InterceptResult invokeV;
        Presenter bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            notifyPageDismiss();
            AdInfo adInfo = this.mAdInfo;
            if (adInfo != null) {
                com.kwad.sdk.core.videocache.b.a.a(this.mContext.getApplicationContext()).c(com.kwad.sdk.core.response.a.a.a(adInfo));
            }
            mInteractionListener = null;
        }
    }
}
