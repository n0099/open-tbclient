package com.kwad.sdk.reward;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* loaded from: classes2.dex */
public class KSRewardVideoActivityProxy extends com.kwad.sdk.core.e.a<a> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String TAG = "RewardVideo";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo mAdInfo;
    public com.kwad.sdk.reward.a.b mAdOpenInteractionListener;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public boolean mIsBackEnable;
    public boolean mPageDismissCalled;
    public com.kwad.sdk.reward.a.f mPlayEndPageListener;
    public JSONObject mReportExtData;
    public boolean mRewardTopBarNewStyle;
    public boolean mRewardVerifyCalled;
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public KsVideoPlayConfig mVideoPlayConfig;
    public int rewardType;

    public KSRewardVideoActivityProxy() {
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
        this.rewardType = 1;
        this.mPlayEndPageListener = new com.kwad.sdk.reward.a.f(this) { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ KSRewardVideoActivityProxy f66008a;

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
                this.f66008a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f66008a.mIsBackEnable = true;
                }
            }
        };
        this.mAdOpenInteractionListener = new com.kwad.sdk.reward.a.c(this) { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ KSRewardVideoActivityProxy f66009a;

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
                this.f66009a = this;
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void a() {
                KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (rewardAdInteractionListener = KSRewardVideoActivityProxy.mInteractionListener) == null) {
                    return;
                }
                rewardAdInteractionListener.onAdClicked();
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void a(int i4, int i5) {
                KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5) == null) || (rewardAdInteractionListener = KSRewardVideoActivityProxy.mInteractionListener) == null) {
                    return;
                }
                rewardAdInteractionListener.onVideoPlayError(i4, i5);
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                    this.f66009a.notifyPageDismiss(z);
                }
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void c() {
                KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || (rewardAdInteractionListener = KSRewardVideoActivityProxy.mInteractionListener) == null) {
                    return;
                }
                rewardAdInteractionListener.onVideoPlayStart();
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void d() {
                KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || (rewardAdInteractionListener = KSRewardVideoActivityProxy.mInteractionListener) == null) {
                    return;
                }
                rewardAdInteractionListener.onVideoPlayEnd();
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    this.f66009a.notifyRewardVerify();
                }
            }
        };
    }

    private boolean initData() {
        InterceptResult invokeV;
        File b2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
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
                    AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate2);
                    this.mAdInfo = i2;
                    String a2 = com.kwad.sdk.core.response.b.a.a(i2);
                    if (com.kwad.sdk.core.config.c.C() >= 0 || ((b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a2)) != null && b2.exists())) {
                        KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
                        this.mVideoPlayConfig = ksVideoPlayConfig;
                        this.mScreenOrientation = ksVideoPlayConfig.isShowLandscape() ? 1 : 0;
                        this.mAdTemplate.mInitVoiceStatus = this.mVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
                        initVideoPlayConfig(this.mVideoPlayConfig);
                        this.mRewardTopBarNewStyle = com.kwad.sdk.core.config.c.o();
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
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, ksVideoPlayConfig) == null) {
            getActivity().setRequestedOrientation(!ksVideoPlayConfig.isShowLandscape());
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
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            DetailVideoView detailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.ksad_video_player);
            this.mDetailVideoView = detailVideoView;
            detailVideoView.setAd(true);
        }
    }

    private boolean isShowNewStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int d2 = com.kwad.sdk.core.response.b.a.d(this.mAdInfo);
            int e2 = com.kwad.sdk.core.response.b.a.e(this.mAdInfo);
            if (this.mCallerContext.f66014e == 1) {
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

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, adTemplate, ksVideoPlayConfig, rewardAdInteractionListener, Integer.valueOf(i2)}) == null) {
            j.b(adTemplate);
            Intent intent = new Intent(context, ksVideoPlayConfig.isShowLandscape() ? KSRewardLandScapeVideoActivity.class : KsRewardVideoActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("key_template_json", adTemplate.toJson().toString());
            intent.putExtra("key_video_play_config", ksVideoPlayConfig);
            intent.putExtra(KEY_REWARD_TYPE, i2);
            mInteractionListener = rewardAdInteractionListener;
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPageDismiss(boolean z) {
        AdTemplate adTemplate;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65545, this, z) == null) || this.mPageDismissCalled) {
            return;
        }
        int i2 = 1;
        this.mPageDismissCalled = true;
        if (z) {
            adTemplate = this.mAdTemplate;
            jSONObject = this.mCallerContext.f66013d;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || this.mRewardVerifyCalled) {
            return;
        }
        this.mRewardVerifyCalled = true;
        f.a(this.mAdTemplate, this.mAdInfo);
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onRewardVerify();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            notifyPageDismiss(false);
            getActivity().finish();
        }
    }

    @Override // com.kwad.sdk.c.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "KSRewardLandScapeVideoActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.mIsBackEnable) {
            notifyRewardVerify();
            super.onBackPressed();
        }
    }

    @Override // com.kwad.sdk.c.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mContext = Wrapper.wrapContextIfNeed(getActivity());
            if (!initData()) {
                finish();
                return;
            }
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) View.inflate(this.mContext, R.layout.ksad_activity_reward_video, null);
            this.mRootContainer = adBaseFrameLayout;
            setContentView(adBaseFrameLayout);
            initView();
            onActivityCreated(this.mRootContainer);
        }
    }

    @Override // com.kwad.sdk.core.e.a
    public a onCreateCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            a aVar = new a();
            aVar.f66016g = getActivity();
            aVar.f66011b = this.mAdOpenInteractionListener;
            aVar.f66014e = this.mScreenOrientation;
            KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
            aVar.f66012c = ksVideoPlayConfig;
            aVar.f66013d = this.mReportExtData;
            aVar.f66017h = this.mRootContainer;
            AdTemplate adTemplate = this.mAdTemplate;
            aVar.f66015f = adTemplate;
            com.kwad.sdk.reward.c.a aVar2 = new com.kwad.sdk.reward.c.a(adTemplate, this.mDetailVideoView, ksVideoPlayConfig, this.rewardType == 2);
            aVar.f66018i = aVar2;
            aVar.f66010a.add(aVar2);
            if (com.kwad.sdk.core.response.b.a.v(this.mAdInfo)) {
                aVar.j = new com.kwad.sdk.core.download.b.b(this.mAdTemplate, this.mReportExtData);
            }
            aVar.k = new com.kwad.sdk.reward.b.b.a.a(this.mAdTemplate, this.mScreenOrientation);
            aVar.a(this.mPlayEndPageListener);
            if (com.kwad.sdk.core.response.b.b.j(this.mAdTemplate)) {
                aVar.l = new com.kwad.sdk.d.c(this.mReportExtData);
            }
            if (com.kwad.sdk.core.response.b.c.r(this.mAdTemplate)) {
                aVar.m = new com.kwad.sdk.d.a().a(true);
            }
            aVar.n = new com.kwad.sdk.d.b(this.mReportExtData);
            aVar.q = true;
            aVar.r = this.mRewardTopBarNewStyle;
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.e.a
    public Presenter onCreatePresenter() {
        InterceptResult invokeV;
        Presenter cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.sdk.reward.b.d());
            presenter.a((Presenter) new com.kwad.sdk.reward.b.a());
            if (com.kwad.sdk.core.response.b.a.J(this.mAdInfo)) {
                presenter.a((Presenter) new com.kwad.sdk.reward.b.b.a());
            }
            boolean a2 = com.kwad.sdk.core.response.b.a.a(this.mAdInfo, getActivity());
            com.kwad.sdk.plugin.g gVar = (com.kwad.sdk.plugin.g) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.g.class);
            if (gVar == null || !gVar.b()) {
                presenter.a((Presenter) new com.kwad.sdk.reward.b.e());
                presenter.a((Presenter) new com.kwad.sdk.reward.b.b.b(this.mRewardTopBarNewStyle));
                presenter.a((Presenter) new com.kwad.sdk.reward.b.c.b(a2));
                if (com.kwad.sdk.core.response.b.a.K(this.mAdInfo) && isShowNewStyle()) {
                    presenter.a((Presenter) new com.kwad.sdk.reward.b.b.c());
                }
                presenter.a((Presenter) new com.kwad.sdk.reward.b.b.a.b());
                if (com.kwad.sdk.core.response.b.b.i(this.mAdTemplate)) {
                    cVar = new com.kwad.sdk.reward.b.b.a.c();
                }
                presenter.a((Presenter) new com.kwad.sdk.reward.b.g(getActivity(), this.mAdTemplate));
                if (!a2 && com.kwad.sdk.core.response.b.a.M(this.mAdInfo)) {
                    presenter.a((Presenter) new com.kwad.sdk.reward.b.c());
                }
                presenter.a((Presenter) new com.kwad.sdk.reward.b.c.a(getActivity(), this.mAdTemplate, true, (FrameLayout) findViewById(R.id.ksad_interactive_landing_page_container)));
                presenter.a((Presenter) new com.kwad.sdk.reward.b.a.a());
                return presenter;
            }
            presenter.a((Presenter) new com.kwad.sdk.reward.b.d.e(a2, this.mRewardTopBarNewStyle));
            presenter.a((com.kwad.sdk.core.response.b.a.L(this.mAdInfo) && isShowNewStyle()) ? new com.kwad.sdk.reward.b.d.d() : new com.kwad.sdk.reward.b.d.c(com.kwad.sdk.core.response.b.b.i(this.mAdTemplate)));
            this.mCallerContext.s = true;
            cVar = new com.kwad.sdk.reward.b.e();
            presenter.a(cVar);
            presenter.a((Presenter) new com.kwad.sdk.reward.b.g(getActivity(), this.mAdTemplate));
            if (!a2) {
                presenter.a((Presenter) new com.kwad.sdk.reward.b.c());
            }
            presenter.a((Presenter) new com.kwad.sdk.reward.b.c.a(getActivity(), this.mAdTemplate, true, (FrameLayout) findViewById(R.id.ksad_interactive_landing_page_container)));
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
            notifyPageDismiss(false);
            AdInfo adInfo = this.mAdInfo;
            if (adInfo != null) {
                com.kwad.sdk.core.videocache.c.a.a(getActivity()).c(com.kwad.sdk.core.response.b.a.a(adInfo));
            }
            mInteractionListener = null;
        }
    }
}
