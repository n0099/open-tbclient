package com.kwad.sdk.fullscreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenVideoActivity;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.plugin.g;
import com.kwad.sdk.reward.a.c;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.b.d;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(KsFullScreenVideoActivity.class)
@Keep
/* loaded from: classes10.dex */
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
    public Activity mContext;
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

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ KsFullScreenVideoActivityProxy f72636a;

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
                this.f72636a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f72636a.mIsBackEnable = true;
                }
            }
        };
        this.mAdOpenInteractionListener = new c(this) { // from class: com.kwad.sdk.fullscreen.KsFullScreenVideoActivityProxy.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ KsFullScreenVideoActivityProxy f72637a;

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
                this.f72637a = this;
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
                    this.f72637a.notifyPageDismiss();
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
                    AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate2);
                    this.mAdInfo = i2;
                    String a2 = com.kwad.sdk.core.response.b.a.a(i2);
                    if (com.kwad.sdk.core.config.c.C() >= 0 || ((b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a2)) != null && b2.exists())) {
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
            this.mContext.setRequestedOrientation(!ksVideoPlayConfig.isShowLandscape());
            if (TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
                return;
            }
            this.mReportExtData = null;
            JSONObject jSONObject = new JSONObject();
            this.mReportExtData = jSONObject;
            q.a(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) this.mContext.findViewById(R.id.ksad_root_container);
            this.mRootContainer = adBaseFrameLayout;
            DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
            this.mDetailVideoView = detailVideoView;
            detailVideoView.setAd(true);
        }
    }

    private boolean isShowNewStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            int d2 = com.kwad.sdk.core.response.b.a.d(this.mAdInfo);
            int e2 = com.kwad.sdk.core.response.b.a.e(this.mAdInfo);
            if (this.mCallerContext.f72872e == 1) {
                if (d2 > e2) {
                    return false;
                }
            } else if (d2 < e2) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, context, adTemplate, ksVideoPlayConfig, fullScreenVideoAdInteractionListener) == null) {
            j.b(adTemplate);
            if (!ksVideoPlayConfig.isShowLandscape()) {
                KsAdSDKImpl.putComponentProxy(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
            }
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
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.mPageDismissCalled) {
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
            this.mContext.finish();
        }
    }

    @Override // com.kwad.sdk.c.a
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

    @Override // com.kwad.sdk.c.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mContext = getActivity();
            if (!initData()) {
                finish();
                return;
            }
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
            aVar.f72874g = this.mContext;
            aVar.f72869b = this.mAdOpenInteractionListener;
            aVar.f72872e = this.mScreenOrientation;
            KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
            aVar.f72870c = ksVideoPlayConfig;
            aVar.f72871d = this.mReportExtData;
            aVar.f72875h = this.mRootContainer;
            AdTemplate adTemplate = this.mAdTemplate;
            aVar.f72873f = adTemplate;
            com.kwad.sdk.reward.c.a aVar2 = new com.kwad.sdk.reward.c.a(adTemplate, this.mDetailVideoView, ksVideoPlayConfig);
            aVar.f72876i = aVar2;
            aVar.f72868a.add(aVar2);
            if (com.kwad.sdk.core.response.b.a.v(this.mAdInfo)) {
                aVar.f72877j = new com.kwad.sdk.core.download.b.b(this.mAdTemplate, this.mReportExtData);
            }
            aVar.k = new com.kwad.sdk.reward.b.b.a.a(this.mAdTemplate, this.mScreenOrientation);
            aVar.a(this.mPlayEndPageListener);
            if (com.kwad.sdk.core.response.b.b.j(this.mAdTemplate)) {
                aVar.l = new com.kwad.sdk.d.c(this.mReportExtData);
            }
            if (com.kwad.sdk.core.response.b.c.r(this.mAdTemplate)) {
                aVar.m = new com.kwad.sdk.d.a().a(false);
            }
            aVar.q = false;
            return aVar;
        }
        return (com.kwad.sdk.reward.a) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.e.a
    public Presenter onCreatePresenter() {
        InterceptResult invokeV;
        Presenter cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new d());
            if (com.kwad.sdk.core.response.b.a.J(this.mAdInfo)) {
                presenter.a((Presenter) new com.kwad.sdk.reward.b.b.a());
            }
            g gVar = (g) com.kwad.sdk.plugin.f.a(g.class);
            if (gVar == null || !gVar.b()) {
                presenter.a((Presenter) new com.kwad.sdk.fullscreen.a.a());
                presenter.a((Presenter) new com.kwad.sdk.fullscreen.a.a.c());
                presenter.a((Presenter) new com.kwad.sdk.fullscreen.a.b.a());
                if (com.kwad.sdk.core.response.b.a.K(this.mAdInfo) && isShowNewStyle()) {
                    presenter.a((Presenter) new com.kwad.sdk.reward.b.b.c());
                }
                presenter.a((Presenter) new com.kwad.sdk.reward.b.b.a.b());
                if (com.kwad.sdk.core.response.b.b.i(this.mAdTemplate)) {
                    cVar = new com.kwad.sdk.reward.b.b.a.c();
                }
                if (com.kwad.sdk.core.response.b.a.K(this.mAdInfo) && isShowNewStyle()) {
                    presenter.a((Presenter) new com.kwad.sdk.reward.b.b.c());
                }
                presenter.a((Presenter) new com.kwad.sdk.reward.b.c.a(getActivity(), this.mAdTemplate, false, (FrameLayout) findViewById(R.id.ksad_interactive_landing_page_container)));
                presenter.a((Presenter) new com.kwad.sdk.reward.b.a.a());
                return presenter;
            }
            this.mCallerContext.s = true;
            presenter.a((Presenter) new com.kwad.sdk.reward.b.d.b());
            presenter.a((com.kwad.sdk.core.response.b.a.L(this.mAdInfo) && isShowNewStyle()) ? new com.kwad.sdk.reward.b.d.d() : new com.kwad.sdk.reward.b.d.c(com.kwad.sdk.core.response.b.b.i(this.mAdTemplate)));
            cVar = new com.kwad.sdk.fullscreen.a.a();
            presenter.a(cVar);
            if (com.kwad.sdk.core.response.b.a.K(this.mAdInfo)) {
                presenter.a((Presenter) new com.kwad.sdk.reward.b.b.c());
            }
            presenter.a((Presenter) new com.kwad.sdk.reward.b.c.a(getActivity(), this.mAdTemplate, false, (FrameLayout) findViewById(R.id.ksad_interactive_landing_page_container)));
            presenter.a((Presenter) new com.kwad.sdk.reward.b.a.a());
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.c.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            notifyPageDismiss();
            AdInfo adInfo = this.mAdInfo;
            if (adInfo != null) {
                com.kwad.sdk.core.videocache.c.a.a(getActivity()).c(com.kwad.sdk.core.response.b.a.a(adInfo));
            }
            mInteractionListener = null;
        }
    }
}
