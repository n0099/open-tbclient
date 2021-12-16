package com.kwad.sdk.reward;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.b;
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* loaded from: classes3.dex */
public class KSRewardVideoActivityProxy extends com.kwad.sdk.core.e.a<a> implements b.InterfaceC2109b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String TAG = "RewardVideo";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo mAdInfo;
    public com.kwad.sdk.reward.a.b mAdOpenInteractionListener;
    public com.kwad.sdk.reward.a.d mAdRewardStepListener;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public boolean mIsBackEnable;
    public boolean mPageDismissCalled;
    public com.kwad.sdk.reward.a.f mPlayEndPageListener;
    public JSONObject mReportExtData;
    public boolean mRewardTopBarNewStyle;
    public final com.kwad.sdk.reward.a.h mRewardVerifyListener;
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public KsVideoPlayConfig mVideoPlayConfig;
    public com.kwad.sdk.reward.presenter.j rewardRefluxPresenter;
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
        this.mRewardVerifyListener = new com.kwad.sdk.reward.a.h(this) { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KSRewardVideoActivityProxy a;

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

            @Override // com.kwad.sdk.reward.a.h
            public void a() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.a.isRewardLandPageOpenTask()) {
                    this.a.markOpenNsCompleted();
                    this.a.notifyRewardVerify();
                    this.a.notifyRewardVerifyStepByStep();
                }
            }
        };
        this.mPlayEndPageListener = new com.kwad.sdk.reward.a.f(this) { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KSRewardVideoActivityProxy a;

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
        this.mAdRewardStepListener = new com.kwad.sdk.reward.a.d(this) { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KSRewardVideoActivityProxy a;

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

            @Override // com.kwad.sdk.reward.a.d
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.notifyRewardVerifyStepByStep();
                }
            }
        };
        this.mAdOpenInteractionListener = new com.kwad.sdk.reward.a.c(this) { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KSRewardVideoActivityProxy a;

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
            public void a(long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
                    try {
                        if (KSRewardVideoActivityProxy.mInteractionListener != null) {
                            KSRewardVideoActivityProxy.mInteractionListener.onVideoSkipToEnd(j2);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048579, this, z) == null) {
                    this.a.notifyPageDismiss(z);
                }
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void c() {
                KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || (rewardAdInteractionListener = KSRewardVideoActivityProxy.mInteractionListener) == null) {
                    return;
                }
                rewardAdInteractionListener.onVideoPlayStart();
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void d() {
                KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || (rewardAdInteractionListener = KSRewardVideoActivityProxy.mInteractionListener) == null) {
                    return;
                }
                rewardAdInteractionListener.onVideoPlayEnd();
            }

            @Override // com.kwad.sdk.reward.a.c, com.kwad.sdk.reward.a.b
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    this.a.notifyRewardVerify();
                    this.a.notifyRewardVerifyStepByStep();
                }
            }
        };
    }

    private void handleNotifyVerify() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.mCallerContext.v = true;
            this.mAdTemplate.mRewardVerifyCalled = true;
            h.a().a(this.mAdTemplate);
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onRewardVerify();
            }
        }
    }

    private boolean initData() {
        InterceptResult invokeV;
        File b2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
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
                    AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate2);
                    this.mAdInfo = j2;
                    String a = com.kwad.sdk.core.response.a.a.a(j2);
                    if (com.kwad.sdk.core.config.b.C() >= 0 || ((b2 = com.kwad.sdk.core.diskcache.a.a.a().b(a)) != null && b2.exists())) {
                        KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
                        this.mVideoPlayConfig = ksVideoPlayConfig;
                        this.mScreenOrientation = ksVideoPlayConfig.isShowLandscape() ? 1 : 0;
                        this.mAdTemplate.mInitVoiceStatus = this.mVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
                        initVideoPlayConfig(this.mVideoPlayConfig);
                        b.a().a(this);
                        this.mRewardTopBarNewStyle = com.kwad.sdk.core.config.b.k();
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
        if (interceptable == null || interceptable.invokeL(65546, this, ksVideoPlayConfig) == null) {
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
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            this.mRootContainer = adBaseFrameLayout;
            this.mDetailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
            boolean z = !af.e(this.mContext);
            if ((isRewardLaunchAppTask() || isRewardLandPageOpenTask()) && z) {
                this.mDetailVideoView.setForce(true);
            }
            this.mDetailVideoView.setAd(true);
        }
    }

    private boolean isLaunchTaskCompleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            com.kwad.sdk.reward.b.a.a aVar = this.mCallerContext.y;
            return aVar != null && aVar.d();
        }
        return invokeV.booleanValue;
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{context, adTemplate, ksVideoPlayConfig, rewardAdInteractionListener, Integer.valueOf(i2)}) == null) {
            com.kwad.sdk.utils.m.b(adTemplate);
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
    public void markOpenNsCompleted() {
        com.kwad.sdk.reward.b.kwai.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (aVar = this.mCallerContext.z) == null) {
            return;
        }
        aVar.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPageDismiss(boolean z) {
        AdTemplate adTemplate;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65551, this, z) == null) || this.mPageDismissCalled) {
            return;
        }
        int i2 = 1;
        this.mPageDismissCalled = true;
        if (z) {
            adTemplate = this.mAdTemplate;
            jSONObject = this.mCallerContext.f59453e;
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

    private void notifyRearwdVerifySteped(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65552, this, i2, i3) == null) || this.mCallerContext.w.contains(Integer.valueOf(i3))) {
            return;
        }
        this.mCallerContext.w.add(Integer.valueOf(i3));
        try {
            mInteractionListener.onRewardStepVerify(i2, i3);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || this.mCallerContext.v) {
            return;
        }
        boolean z = true;
        if (isRewardLaunchAppTask()) {
            com.kwad.sdk.reward.b.a.a aVar = this.mCallerContext.y;
            if (!((aVar == null || !aVar.d()) ? false : false)) {
                return;
            }
        } else if (isRewardLandPageOpenTask()) {
            com.kwad.sdk.reward.b.kwai.a aVar2 = this.mCallerContext.z;
            if (!((aVar2 == null || !aVar2.d()) ? false : false)) {
                return;
            }
        }
        handleNotifyVerify();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerifyStepByStep() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || mInteractionListener == null) {
            return;
        }
        if (isRewardLaunchAppTask()) {
            notifyRearwdVerifySteped(2, 0);
            if (isLaunchTaskCompleted()) {
                notifyRearwdVerifySteped(2, 2);
            }
        } else if (!isRewardLandPageOpenTask()) {
            notifyRearwdVerifySteped(0, 0);
        } else {
            com.kwad.sdk.reward.b.kwai.a aVar = this.mCallerContext.z;
            boolean z = aVar != null && aVar.d();
            notifyRearwdVerifySteped(1, 0);
            if (z) {
                notifyRearwdVerifySteped(1, 1);
            }
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

    @Override // com.kwad.sdk.h.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "KSRewardLandScapeVideoActivityProxy" : (String) invokeV.objValue;
    }

    public boolean isRefluxVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            com.kwad.sdk.reward.presenter.j jVar = this.rewardRefluxPresenter;
            return jVar != null && jVar.r();
        }
        return invokeV.booleanValue;
    }

    public boolean isRewardLandPageOpenTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.a.d.v(this.mAdTemplate) : invokeV.booleanValue;
    }

    public boolean isRewardLaunchAppTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.response.a.d.u(this.mAdTemplate) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            com.kwad.sdk.reward.presenter.j jVar = this.rewardRefluxPresenter;
            if (jVar != null) {
                int i2 = jVar.i();
                if (i2 == 2) {
                    return;
                }
                if (i2 == 3) {
                    super.onBackPressed();
                    return;
                }
            }
            if (this.mIsBackEnable) {
                super.onBackPressed();
            }
        }
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            if (!initData()) {
                finish();
                return;
            }
            this.mContext = Wrapper.wrapContextIfNeed(getActivity());
            setContentView(R.layout.ksad_activity_reward_video);
            initView();
            onActivityCreated(this.mRootContainer);
            d.a().a(this.mRewardVerifyListener);
        }
    }

    @Override // com.kwad.sdk.core.e.a
    public a onCreateCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            a aVar = new a();
            aVar.f59456h = getActivity();
            aVar.f59457i = this.mContext;
            aVar.f59450b = this.mAdOpenInteractionListener;
            aVar.f59451c = this.mAdRewardStepListener;
            aVar.f59454f = this.mScreenOrientation;
            KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
            aVar.f59452d = ksVideoPlayConfig;
            aVar.f59453e = this.mReportExtData;
            aVar.f59458j = this.mRootContainer;
            AdTemplate adTemplate = this.mAdTemplate;
            aVar.f59455g = adTemplate;
            com.kwad.sdk.reward.c.a aVar2 = new com.kwad.sdk.reward.c.a(adTemplate, this.mDetailVideoView, ksVideoPlayConfig, this.rewardType == 2);
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
            if (com.kwad.sdk.core.response.a.a.q(this.mAdInfo)) {
                aVar.p = new com.kwad.sdk.i.a().a(true);
            }
            aVar.r = true;
            aVar.s = this.mRewardTopBarNewStyle;
            if (com.kwad.sdk.core.response.a.a.an(this.mAdInfo)) {
                aVar.m = new com.kwad.sdk.widget.e((KsAdWebView) findViewById(R.id.ksad_playable_webview));
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00e1  */
    @Override // com.kwad.sdk.core.e.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Presenter onCreatePresenter() {
        InterceptResult invokeV;
        Presenter bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Presenter presenter = new Presenter(this) { // from class: com.kwad.sdk.reward.KSRewardVideoActivityProxy.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KSRewardVideoActivityProxy a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.sdk.mvp.Presenter
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.a.mIsBackEnable = false;
                        this.a.mCallerContext.v = false;
                        this.a.mCallerContext.u = false;
                    }
                }
            };
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.e());
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.d());
            if (com.kwad.sdk.core.response.a.a.B(this.mAdInfo)) {
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.platdetail.b());
            }
            boolean isRewardLaunchAppTask = isRewardLaunchAppTask();
            boolean isRewardLandPageOpenTask = isRewardLandPageOpenTask();
            boolean an = com.kwad.sdk.core.response.a.a.an(this.mAdInfo);
            com.kwad.sdk.plugin.g gVar = (com.kwad.sdk.plugin.g) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.g.class);
            if (isRewardLandPageOpenTask || isRewardLaunchAppTask() || com.kwad.sdk.core.response.a.a.aG(this.mAdInfo) || gVar == null || !gVar.b()) {
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.f());
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.platdetail.c(this.mRewardTopBarNewStyle));
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.a.b(an));
                if (!isRewardLaunchAppTask && !isRewardLandPageOpenTask) {
                    if (com.kwad.sdk.core.response.a.a.T(this.mAdInfo)) {
                        bVar = new com.kwad.sdk.reward.presenter.platdetail.a();
                    } else {
                        presenter.a((Presenter) new com.kwad.sdk.reward.presenter.platdetail.actionbar.a());
                        if (com.kwad.sdk.core.response.a.b.d(this.mAdTemplate)) {
                            bVar = new com.kwad.sdk.reward.presenter.platdetail.actionbar.b();
                        }
                    }
                }
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.i(this.mAdTemplate));
                if (com.kwad.sdk.core.response.a.a.D(this.mAdInfo)) {
                    presenter.a((Presenter) new com.kwad.sdk.reward.presenter.b());
                }
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.a.a(this, this.mAdTemplate, true));
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.kwai.a());
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.k());
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.l());
                presenter.a((Presenter) new com.kwad.sdk.reward.presenter.c(this.mAdInfo, this.mRootContainer));
                com.kwad.sdk.reward.presenter.j jVar = new com.kwad.sdk.reward.presenter.j();
                this.rewardRefluxPresenter = jVar;
                presenter.a((Presenter) jVar);
                return presenter;
            }
            this.mCallerContext.t = true;
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.b.e(an, this.mRewardTopBarNewStyle));
            presenter.a(com.kwad.sdk.core.response.a.b.a(this.mContext, this.mAdTemplate) ? new com.kwad.sdk.reward.presenter.b.d() : new com.kwad.sdk.reward.presenter.b.c(com.kwad.sdk.core.response.a.b.d(this.mAdTemplate)));
            bVar = new com.kwad.sdk.reward.presenter.f();
            presenter.a(bVar);
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.i(this.mAdTemplate));
            if (com.kwad.sdk.core.response.a.a.D(this.mAdInfo)) {
            }
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.a.a(this, this.mAdTemplate, true));
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.kwai.a());
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.k());
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.l());
            presenter.a((Presenter) new com.kwad.sdk.reward.presenter.c(this.mAdInfo, this.mRootContainer));
            com.kwad.sdk.reward.presenter.j jVar2 = new com.kwad.sdk.reward.presenter.j();
            this.rewardRefluxPresenter = jVar2;
            presenter.a((Presenter) jVar2);
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a().b(this.mRewardVerifyListener);
            super.onDestroy();
            notifyPageDismiss(false);
            AdInfo adInfo = this.mAdInfo;
            if (adInfo != null) {
                com.kwad.sdk.core.videocache.b.a.a(this.mContext.getApplicationContext()).c(com.kwad.sdk.core.response.a.a.a(adInfo));
            }
            mInteractionListener = null;
            b.a().b(this);
            h.a().b();
        }
    }

    @Override // com.kwad.sdk.reward.b.InterfaceC2109b
    public void onPageClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            finish();
        }
    }

    @Override // com.kwad.sdk.core.e.a, com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            com.kwad.sdk.core.c.a.a().a(this.mAdTemplate);
        }
    }
}
