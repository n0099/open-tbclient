package com.kwad.sdk.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.asm.Label;
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
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.o;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* loaded from: classes7.dex */
public class KSRewardVideoActivityProxy extends com.kwad.sdk.core.e.a<a> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TEMPLATE = "key_template";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String TAG = "RewardVideo";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo mAdInfo;
    public com.kwad.sdk.reward.a.b mAdOpenInteractionListener;
    public AdTemplate mAdTemplate;
    public Activity mContext;
    public DetailVideoView mDetailVideoView;
    public boolean mIsBackEnable;
    public boolean mPageDismissCalled;
    public com.kwad.sdk.reward.a.e mPageListener;
    public JSONObject mReportExtData;
    public boolean mRewardTopBarNewStyle;
    public boolean mRewardVerifyCalled;
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public KsVideoPlayConfig mVideoPlayConfig;

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
        this.mPageListener = new com.kwad.sdk.reward.a.e(this) { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ KSRewardVideoActivityProxy f38809a;

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
                this.f38809a = this;
            }

            @Override // com.kwad.sdk.reward.a.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f38809a.mIsBackEnable = true;
                }
            }
        };
        this.mAdOpenInteractionListener = new com.kwad.sdk.reward.a.c(this) { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ KSRewardVideoActivityProxy f38810a;

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
                this.f38810a = this;
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
                    this.f38810a.notifyPageDismiss(z);
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
                    this.f38810a.notifyRewardVerify();
                }
            }
        };
    }

    private boolean initData() {
        InterceptResult invokeV;
        File b2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            Serializable serializableExtra = this.mContext.getIntent().getSerializableExtra("key_video_play_config");
            if (serializableExtra instanceof KsVideoPlayConfig) {
                Serializable serializableExtra2 = this.mContext.getIntent().getSerializableExtra("key_template");
                if (serializableExtra2 instanceof AdTemplate) {
                    AdTemplate adTemplate = (AdTemplate) serializableExtra2;
                    this.mAdTemplate = adTemplate;
                    AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
                    this.mAdInfo = j;
                    String a2 = com.kwad.sdk.core.response.b.a.a(j);
                    if (com.kwad.sdk.core.config.c.ae() >= 0 || ((b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a2)) != null && b2.exists())) {
                        KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
                        this.mVideoPlayConfig = ksVideoPlayConfig;
                        this.mScreenOrientation = ksVideoPlayConfig.isShowLandscape() ? 1 : 0;
                        this.mAdTemplate.mInitVoiceStatus = this.mVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
                        initVideoPlayConfig(this.mVideoPlayConfig);
                        this.mRewardTopBarNewStyle = com.kwad.sdk.core.config.c.y();
                        return true;
                    }
                    return false;
                }
                str = "data is not instanceof AdTemplate:" + serializableExtra2;
            } else {
                str = "data is not instanceof VideoPlayConfigImpl:" + serializableExtra;
            }
            com.kwad.sdk.core.d.a.d(TAG, str);
            return false;
        }
        return invokeV.booleanValue;
    }

    private void initVideoPlayConfig(@NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, ksVideoPlayConfig) == null) {
            this.mContext.setRequestedOrientation(!ksVideoPlayConfig.isShowLandscape());
            if (TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
                return;
            }
            this.mReportExtData = null;
            JSONObject jSONObject = new JSONObject();
            this.mReportExtData = jSONObject;
            o.a(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int d2 = com.kwad.sdk.core.response.b.a.d(this.mAdInfo);
            int e2 = com.kwad.sdk.core.response.b.a.e(this.mAdInfo);
            if (this.mCallerContext.f38815e == 1) {
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

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, context, adTemplate, ksVideoPlayConfig, rewardAdInteractionListener) == null) {
            adTemplate.mKsPlayerClickTimeParam = System.currentTimeMillis();
            Intent intent = new Intent(context, ksVideoPlayConfig.isShowLandscape() ? KSRewardLandScapeVideoActivity.class : KsRewardVideoActivity.class);
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtra("key_template", adTemplate);
            intent.putExtra("key_video_play_config", ksVideoPlayConfig);
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
            jSONObject = this.mCallerContext.f38814d;
        } else {
            adTemplate = this.mAdTemplate;
            i2 = 6;
            jSONObject = this.mReportExtData;
        }
        com.kwad.sdk.core.report.b.a(adTemplate, i2, jSONObject);
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
            this.mContext.finish();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.mIsBackEnable) {
            notifyRewardVerify();
            super.onBackPressed();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            this.mContext = getActivity();
            if (!initData()) {
                finish();
                return;
            }
            this.mContext.setContentView(R.layout.ksad_activity_reward_video);
            initView();
            onActivityCreated(this.mRootContainer);
        }
    }

    @Override // com.kwad.sdk.core.e.a
    public a onCreateCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a aVar = new a();
            aVar.f38817g = this.mContext;
            aVar.f38812b = this.mAdOpenInteractionListener;
            aVar.f38815e = this.mScreenOrientation;
            KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
            aVar.f38813c = ksVideoPlayConfig;
            aVar.f38814d = this.mReportExtData;
            aVar.f38818h = this.mRootContainer;
            AdTemplate adTemplate = this.mAdTemplate;
            aVar.f38816f = adTemplate;
            com.kwad.sdk.reward.c.a aVar2 = new com.kwad.sdk.reward.c.a(adTemplate, this.mDetailVideoView, ksVideoPlayConfig);
            aVar.f38819i = aVar2;
            aVar.f38811a.add(aVar2);
            if (com.kwad.sdk.core.response.b.a.y(this.mAdInfo)) {
                aVar.j = new com.kwad.sdk.core.download.b.b(this.mAdTemplate, this.mReportExtData);
            }
            aVar.k = new com.kwad.sdk.reward.b.b.a.a(this.mAdTemplate, this.mScreenOrientation);
            aVar.n.add(this.mPageListener);
            aVar.l = com.kwad.sdk.c.d.a(this.mAdTemplate, true, this.mReportExtData);
            aVar.m = new com.kwad.sdk.c.b(this.mReportExtData);
            aVar.p = true;
            aVar.q = this.mRewardTopBarNewStyle;
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c8  */
    @Override // com.kwad.sdk.core.e.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Presenter onCreatePresenter() {
        InterceptResult invokeV;
        Presenter bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.sdk.reward.b.d());
            presenter.a((Presenter) new com.kwad.sdk.reward.b.a());
            presenter.a((Presenter) new com.kwad.sdk.reward.b.b.b(this.mRewardTopBarNewStyle));
            presenter.a((Presenter) new com.kwad.sdk.reward.b.b.a.b());
            if (com.kwad.sdk.core.response.b.b.o(this.mAdTemplate)) {
                presenter.a((Presenter) new com.kwad.sdk.reward.b.b.a.c());
            }
            if (com.kwad.sdk.core.response.b.a.N(this.mAdInfo)) {
                presenter.a((Presenter) new com.kwad.sdk.reward.b.b.a());
            }
            if (com.kwad.sdk.core.response.b.a.O(this.mAdInfo) && isShowNewStyle()) {
                presenter.a((Presenter) new com.kwad.sdk.reward.b.b.c());
            }
            presenter.a((Presenter) new com.kwad.sdk.reward.b.e());
            if (!com.kwad.sdk.core.response.b.c.C(this.mAdTemplate)) {
                presenter.a((Presenter) new com.kwad.sdk.reward.b.c.a());
            }
            boolean a2 = com.kwad.sdk.core.config.c.a(this.mAdInfo);
            boolean z = com.kwad.sdk.core.response.b.a.e(this.mAdInfo) > com.kwad.sdk.core.response.b.a.d(this.mAdInfo);
            if (!a2 || !z) {
                presenter.a((Presenter) new com.kwad.sdk.reward.b.c.a.a());
                if (com.kwad.sdk.core.response.b.b.p(this.mAdTemplate) || com.kwad.sdk.core.response.b.c.C(this.mAdTemplate)) {
                    bVar = new com.kwad.sdk.reward.b.c.a.b();
                }
                presenter.a((Presenter) new com.kwad.sdk.reward.b.a.a());
                if (com.kwad.sdk.core.config.c.Q()) {
                    presenter.a((Presenter) new com.kwad.sdk.reward.b.c());
                }
                return presenter;
            }
            bVar = new com.kwad.sdk.reward.b.b();
            presenter.a(bVar);
            presenter.a((Presenter) new com.kwad.sdk.reward.b.a.a());
            if (com.kwad.sdk.core.config.c.Q()) {
            }
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
