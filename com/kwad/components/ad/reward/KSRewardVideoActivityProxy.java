package com.kwad.components.ad.reward;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.kwad.components.ad.reward.j.a;
import com.kwad.components.ad.reward.p;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.m.d;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.c;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bd;
import java.util.HashMap;
@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* loaded from: classes7.dex */
public class KSRewardVideoActivityProxy extends com.kwad.components.core.g.b<k> implements com.kwad.components.ad.reward.g.c, a.InterfaceC0548a, p.a, d.b, c.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_TEMPLATE_PLAY_AGAIN = "key_template_json_play_again";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String TAG = "RewardVideo";
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.d.a mAdOpenInteractionListener;
    public com.kwad.components.ad.reward.d.c mAdRewardStepListener;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public boolean mIsBackEnable;
    public com.kwad.components.ad.reward.model.c mModel;
    public boolean mPageDismissCalled;
    public long mPageEnterTime;
    public com.kwad.components.ad.reward.d.e mPlayEndPageListener;
    public long mPlayTime;
    public p mRewardPresenter;
    public final com.kwad.components.ad.reward.d.h mRewardVerifyListener;
    public AdBaseFrameLayout mRootContainer;
    public com.kwad.components.core.video.g mVideoPlayStateListener;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final HashMap<String, a> lU;
        public transient /* synthetic */ FieldHolder $fh;
        public com.kwad.components.ad.reward.c.c kJ;
        public KsRewardVideoAd.RewardAdInteractionListener lV;
        public KsRewardVideoAd.RewardAdInteractionListener lW;
        public KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1196876028, "Lcom/kwad/components/ad/reward/KSRewardVideoActivityProxy$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1196876028, "Lcom/kwad/components/ad/reward/KSRewardVideoActivityProxy$a;");
                    return;
                }
            }
            lU = new HashMap<>();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Nullable
        public static a D(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? lU.get(str) : (a) invokeL.objValue;
        }

        public static KsRewardVideoAd.RewardAdInteractionListener E(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                a D = D(str);
                if (D != null) {
                    return D.lW;
                }
                return null;
            }
            return (KsRewardVideoAd.RewardAdInteractionListener) invokeL.objValue;
        }

        public static void F(String str) {
            a D;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || (D = D(str)) == null) {
                return;
            }
            D.lW = D.mInteractionListener;
        }

        public static void G(String str) {
            a D;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65541, null, str) == null) || (D = D(str)) == null) {
                return;
            }
            D.lW = D.lV;
        }

        public static com.kwad.components.ad.reward.c.c H(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
                a D = D(str);
                if (D != null) {
                    return D.kJ;
                }
                return null;
            }
            return (com.kwad.components.ad.reward.c.c) invokeL.objValue;
        }

        public static void I(String str) {
            a D;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65543, null, str) == null) || (D = D(str)) == null) {
                return;
            }
            D.destroy();
            lU.put(str, null);
        }

        public static void a(String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2, com.kwad.components.ad.reward.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65547, null, str, rewardAdInteractionListener, rewardAdInteractionListener2, cVar) == null) {
                a aVar = new a();
                aVar.mInteractionListener = rewardAdInteractionListener;
                aVar.lV = rewardAdInteractionListener2;
                aVar.kJ = cVar;
                aVar.lW = rewardAdInteractionListener;
                lU.put(str, aVar);
            }
        }

        private void destroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65548, this) == null) {
                this.mInteractionListener = null;
                this.lV = null;
                this.lW = null;
                com.kwad.components.ad.reward.c.c cVar = this.kJ;
                if (cVar != null) {
                    cVar.destroy();
                    this.kJ = null;
                }
            }
        }
    }

    public KSRewardVideoActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRewardVerifyListener = new com.kwad.components.ad.reward.d.h(this) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KSRewardVideoActivityProxy lP;

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
                this.lP = this;
            }

            @Override // com.kwad.components.ad.reward.d.h
            public final void onRewardVerify() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.lP.mModel.gM()) {
                    this.lP.markOpenNsCompleted();
                    this.lP.notifyRewardVerify();
                    this.lP.notifyRewardVerifyStepByStep();
                }
            }
        };
        this.mPlayEndPageListener = new com.kwad.components.ad.reward.d.e(this) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KSRewardVideoActivityProxy lP;

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
                this.lP = this;
            }

            @Override // com.kwad.components.ad.reward.d.e
            public final void bA() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.lP.mIsBackEnable = true;
                }
            }
        };
        this.mAdRewardStepListener = new com.kwad.components.ad.reward.d.c(this) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KSRewardVideoActivityProxy lP;

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
                this.lP = this;
            }

            @Override // com.kwad.components.ad.reward.d.c
            public final void ff() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.lP.notifyRewardVerifyStepByStep();
                }
            }
        };
        this.mVideoPlayStateListener = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KSRewardVideoActivityProxy lP;

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
                this.lP = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.lP.mPlayTime = j2;
                }
            }
        };
        this.mAdOpenInteractionListener = new com.kwad.components.ad.reward.d.b(this) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KSRewardVideoActivityProxy lP;

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
                this.lP = this;
            }

            @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
            public final void bB() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    KsRewardVideoAd.RewardAdInteractionListener E = a.E(this.lP.getUniqueId());
                    if (E != null) {
                        E.onAdClicked();
                    }
                    ((k) this.lP.mCallerContext).mT = true;
                    ((k) this.lP.mCallerContext).fw();
                }
            }

            @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
            public final void j(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    com.kwad.sdk.kwai.kwai.c.rd().rg();
                    this.lP.notifyPageDismiss(false);
                }
            }

            @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
            public final void onRewardVerify() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.lP.notifyRewardVerify();
                    this.lP.notifyRewardVerifyStepByStep();
                }
            }

            @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
            public final void onVideoPlayEnd() {
                KsRewardVideoAd.RewardAdInteractionListener E;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || (E = a.E(this.lP.getUniqueId())) == null) {
                    return;
                }
                E.onVideoPlayEnd();
            }

            @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
            public final void onVideoPlayError(int i3, int i4) {
                KsRewardVideoAd.RewardAdInteractionListener E;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(1048580, this, i3, i4) == null) || (E = a.E(this.lP.getUniqueId())) == null) {
                    return;
                }
                E.onVideoPlayError(i3, i4);
            }

            @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
            public final void onVideoPlayStart() {
                KsRewardVideoAd.RewardAdInteractionListener E;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || (E = a.E(this.lP.getUniqueId())) == null) {
                    return;
                }
                E.onVideoPlayStart();
            }

            @Override // com.kwad.components.ad.reward.d.b, com.kwad.components.ad.reward.d.a
            public final void onVideoSkipToEnd(long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(1048582, this, j) == null) {
                    try {
                        KsRewardVideoAd.RewardAdInteractionListener E = a.E(this.lP.getUniqueId());
                        if (E != null) {
                            E.onVideoSkipToEnd(j);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? ((k) this.mCallerContext).mAdTemplate.getUniqueId() : (String) invokeV.objValue;
    }

    private void handleNotifyVerify() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            ((k) this.mCallerContext).mRewardVerifyCalled = true;
            this.mModel.getAdTemplate().mRewardVerifyCalled = true;
            i.fn().m(this.mModel.getAdTemplate());
            com.kwad.sdk.core.report.a.aE(this.mModel.getAdTemplate());
            if (!((k) this.mCallerContext).mAdTemplate.converted) {
                com.kwad.components.ad.reward.b.a.gp().gq().N(com.kwad.components.ad.reward.b.b.oK);
            }
            KsRewardVideoAd.RewardAdInteractionListener E = a.E(getUniqueId());
            if (E != null) {
                E.onRewardVerify();
                com.kwad.components.ad.reward.monitor.a.a(this.mModel.getAdTemplate(), 0, -1, true);
            }
            if (com.kwad.sdk.core.response.a.a.bR(this.mModel.by())) {
                T t = this.mCallerContext;
                if (((k) t).mAdTemplate.converted || ((k) t).fD()) {
                    return;
                }
                k.a(getActivity(), (k) this.mCallerContext);
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0911d6);
            this.mRootContainer = adBaseFrameLayout;
            this.mDetailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.obfuscated_res_0x7f09122c);
            boolean z = !ag.cB(this.mContext);
            if ((this.mModel.gL() || this.mModel.gM()) && z) {
                this.mDetailVideoView.setForce(true);
            }
            this.mDetailVideoView.setAd(true);
        }
    }

    private void initWithModel(@NonNull com.kwad.components.ad.reward.model.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, this, cVar) == null) || this.mModel.getAdTemplate() == null || this.mModel.getAdTemplate().mPlayAgain == null) {
            return;
        }
        com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this, this.mModel.getAdTemplate().mPlayAgain) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KSRewardVideoActivityProxy lP;
            public final /* synthetic */ AdTemplate lQ;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.lP = this;
                this.lQ = r7;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    boolean a2 = com.kwad.components.ad.b.a.a(this.lQ, true);
                    com.kwad.sdk.core.e.b.d(KSRewardVideoActivityProxy.TAG, "cache playAgain result: " + a2);
                }
            }
        });
    }

    private boolean isLaunchTaskCompleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            T t = this.mCallerContext;
            return ((k) t).mK != null && ((k) t).mK.isCompleted();
        }
        return invokeV.booleanValue;
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2, com.kwad.components.ad.reward.c.c cVar, int i) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{context, adTemplate, ksVideoPlayConfig, rewardAdInteractionListener, rewardAdInteractionListener2, cVar, Integer.valueOf(i)}) == null) {
            com.kwad.sdk.utils.k.ci(adTemplate);
            if (ksVideoPlayConfig.isShowLandscape()) {
                KsAdSDKImpl.putComponentProxy(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
                intent = new Intent(context, KSRewardLandScapeVideoActivity.class);
            } else {
                KsAdSDKImpl.putComponentProxy(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
                intent = new Intent(context, KsRewardVideoActivity.class);
            }
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.putExtra("key_template_json", adTemplate.toJson().toString());
            intent.putExtra("key_video_play_config", ksVideoPlayConfig);
            intent.putExtra(KEY_REWARD_TYPE, i);
            if (adTemplate.hasPlayAgain() && rewardAdInteractionListener2 != null) {
                intent.putExtra(KEY_TEMPLATE_PLAY_AGAIN, adTemplate.mPlayAgain.toJson().toString());
            }
            String uniqueId = adTemplate.getUniqueId();
            a.a(uniqueId, rewardAdInteractionListener, rewardAdInteractionListener2, cVar);
            a.F(uniqueId);
            context.startActivity(intent);
            com.kwad.sdk.kwai.kwai.c.rd().aI(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markOpenNsCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            T t = this.mCallerContext;
            if (((k) t).mL != null) {
                ((k) t).mL.markOpenNsCompleted();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPageDismiss(boolean z) {
        com.kwad.components.ad.reward.model.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65557, this, z) == null) || this.mPageDismissCalled || this.mCallerContext == 0 || (cVar = this.mModel) == null) {
            return;
        }
        this.mPageDismissCalled = true;
        com.kwad.sdk.core.report.a.o(cVar.getAdTemplate(), (int) Math.ceil(((float) this.mPlayTime) / 1000.0f));
        if (z) {
            com.kwad.sdk.core.report.a.a(this.mModel.getAdTemplate(), 1, ((k) this.mCallerContext).mReportExtData);
        } else {
            com.kwad.sdk.core.report.a.a(this.mModel.getAdTemplate(), 6, this.mModel.gP());
        }
        KsRewardVideoAd.RewardAdInteractionListener E = a.E(getUniqueId());
        com.kwad.sdk.core.e.b.d("jky", "notifyPageDismiss current listener: " + E);
        if (E != null) {
            E.onPageDismiss();
        }
    }

    private void notifyRewardStep(int i, int i2) {
        com.kwad.components.ad.reward.model.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65558, this, i, i2) == null) || (cVar = this.mModel) == null || com.kwad.sdk.core.response.a.d.cb(cVar.getAdTemplate()) || ((k) this.mCallerContext).mE.contains(Integer.valueOf(i2))) {
            return;
        }
        ((k) this.mCallerContext).mE.add(Integer.valueOf(i2));
        q.a(i, i2, (k) this.mCallerContext, this.mModel);
        if (a.E(getUniqueId()) == null) {
            return;
        }
        try {
            a.E(getUniqueId()).onRewardStepVerify(i, i2);
            com.kwad.components.ad.reward.monitor.a.a(this.mModel.getAdTemplate(), i, i2, false);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        com.kwad.components.ad.reward.model.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (cVar = this.mModel) == null || com.kwad.sdk.core.response.a.d.cb(cVar.getAdTemplate()) || ((k) this.mCallerContext).mRewardVerifyCalled) {
            return;
        }
        boolean z = true;
        if (this.mModel.gL()) {
            T t = this.mCallerContext;
            if ((((k) t).mK == null || !((k) t).mK.isCompleted()) ? false : false) {
                handleNotifyVerify();
            }
        } else if (!this.mModel.gM()) {
            handleNotifyVerify();
        } else {
            T t2 = this.mCallerContext;
            if ((((k) t2).mL == null || !((k) t2).mL.isCompleted()) ? false : false) {
                handleNotifyVerify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerifyStepByStep() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            if (this.mModel.gL()) {
                notifyRewardStep(2, 0);
                if (isLaunchTaskCompleted()) {
                    notifyRewardStep(2, 2);
                }
            } else if (!this.mModel.gM()) {
                notifyRewardStep(0, 0);
            } else {
                T t = this.mCallerContext;
                boolean z = ((k) t).mL != null && ((k) t).mL.isCompleted();
                notifyRewardStep(1, 0);
                if (z) {
                    notifyRewardStep(1, 1);
                }
            }
        }
    }

    @InvokeBy(invokerClass = KsAdSDKImpl.class, methodId = KsAdSDKImpl.INVOKER_ID_INIT_COMPONENT_PROXY)
    public static void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            KsAdSDKImpl.putComponentProxy(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
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

    @Override // com.kwad.components.core.i.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "KSRewardLandScapeVideoActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.j.a.InterfaceC0548a
    public boolean handledOnResume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (((k) this.mCallerContext).mx || isRefluxVisible()) {
                return true;
            }
            p pVar = this.mRewardPresenter;
            if (pVar != null) {
                return pVar.bH();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRefluxVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRewardPresenter.isRefluxVisible() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BackPressHandleResult fS = this.mRewardPresenter.fS();
            if (fS.equals(BackPressHandleResult.HANDLED)) {
                return;
            }
            if (fS.equals(BackPressHandleResult.HANDLED_CLOSE)) {
                super.onBackPressed();
                notifyPageDismiss(false);
            } else if (this.mIsBackEnable) {
                notifyPageDismiss(false);
                super.onBackPressed();
            }
        }
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            try {
                getIntent().removeExtra(AdWebViewVideoActivityProxy.KEY_TEMPLATE);
            } catch (Throwable unused) {
            }
            super.onCreate(bundle);
            getActivity().setTheme(16973838);
            com.kwad.components.ad.reward.model.c c = com.kwad.components.ad.reward.model.c.c(getIntent());
            this.mModel = c;
            if (c == null) {
                finish();
                return;
            }
            this.mPageEnterTime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.reward.monitor.a.a(true, this.mModel.getAdTemplate(), this.mPageEnterTime);
            com.kwad.components.ad.reward.monitor.a.b(true, this.mModel.getAdTemplate(), this.mPageEnterTime);
            com.kwad.components.core.m.d.oy().a(this);
            this.mContext = Wrapper.wrapContextIfNeed(getActivity());
            initWithModel(this.mModel);
            setContentView(R.layout.obfuscated_res_0x7f0d0408);
            initView();
            onActivityCreated(this.mRootContainer);
            c.eZ().a(this.mRewardVerifyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwad.components.core.g.b
    public k onCreateCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AdTemplate adTemplate = this.mModel.getAdTemplate();
            AdInfo by = this.mModel.by();
            k kVar = new k();
            kVar.EG = this;
            kVar.mContext = this.mContext;
            kVar.mPageEnterTime = this.mPageEnterTime;
            kVar.mAdOpenInteractionListener = this.mAdOpenInteractionListener;
            kVar.mAdRewardStepListener = this.mAdRewardStepListener;
            kVar.mScreenOrientation = this.mModel.getScreenOrientation();
            kVar.mVideoPlayConfig = this.mModel.gN();
            kVar.mReportExtData = this.mModel.gP();
            kVar.mRootContainer = this.mRootContainer;
            kVar.mAdTemplate = adTemplate;
            kVar.mj = this.mDetailVideoView;
            com.kwad.components.ad.reward.j.a aVar = new com.kwad.components.ad.reward.j.a(kVar, this.mModel.gO() == 2);
            kVar.eF = aVar;
            aVar.a(this.mVideoPlayStateListener);
            kVar.eF.a(this);
            kVar.EF.add(aVar);
            if (com.kwad.sdk.core.response.a.a.am(by)) {
                kVar.mApkDownloadHelper = new com.kwad.components.core.c.a.c(adTemplate, this.mModel.gP());
            }
            kVar.ml = new RewardActionBarControl(kVar, this.mContext, adTemplate);
            kVar.a(this.mPlayEndPageListener);
            if (com.kwad.sdk.core.response.a.b.bd(adTemplate)) {
                m mVar = new m(kVar, this.mModel.gP(), null);
                kVar.mm = mVar;
                mVar.a(new com.kwad.components.ad.reward.b.d(this, kVar) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ KSRewardVideoActivityProxy lP;
                    public final /* synthetic */ k lR;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, kVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.lP = this;
                        this.lR = kVar;
                    }

                    @Override // com.kwad.components.ad.reward.b.d
                    public final void a(com.kwad.components.ad.reward.b.b bVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                            this.lR.b(bVar);
                        }
                    }
                });
            }
            if (com.kwad.sdk.core.response.a.b.bx(adTemplate)) {
                String bz = com.kwad.sdk.core.response.a.b.bz(adTemplate);
                if (!TextUtils.isEmpty(bz)) {
                    com.kwad.components.ad.i.b bVar = new com.kwad.components.ad.i.b(this.mModel.gP(), bz);
                    kVar.mn = bVar;
                    bVar.a(this);
                }
            }
            if (com.kwad.sdk.core.response.a.a.Z(by)) {
                kVar.mo = new com.kwad.components.ad.i.a().ae(true);
            }
            kVar.mz = true;
            if (com.kwad.sdk.core.response.a.a.aY(by)) {
                kVar.mk = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091137));
            }
            kVar.mO = 0L;
            if (this.mModel.by() != null) {
                kVar.mO = com.kwad.sdk.core.response.a.a.aY(this.mModel.by()) ? com.kwad.sdk.core.response.a.a.Y(this.mModel.by()) : com.kwad.sdk.core.response.a.a.X(this.mModel.by());
            }
            kVar.a(this);
            return kVar;
        }
        return (k) invokeV.objValue;
    }

    @Override // com.kwad.components.core.g.b
    public Presenter onCreatePresenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar == null) {
                return null;
            }
            p pVar = new p(this, this.mRootContainer, cVar, (k) this.mCallerContext);
            this.mRewardPresenter = pVar;
            pVar.a(this);
            return this.mRewardPresenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.components.core.g.b, com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.eZ().b(this.mRewardVerifyListener);
            super.onDestroy();
            T t = this.mCallerContext;
            if (t != 0) {
                ((k) t).eF.b(this.mVideoPlayStateListener);
                ((k) this.mCallerContext).eF.b(this);
                a.I(getUniqueId());
            }
            notifyPageDismiss(false);
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                com.kwad.sdk.core.videocache.b.a.bC(this.mContext.getApplicationContext()).cD(com.kwad.sdk.core.response.a.a.A(cVar.by()));
            }
            com.kwad.components.core.m.d.oy().b(this);
            i.fn().release();
        }
    }

    @Override // com.kwad.components.core.m.d.b
    public void onPageClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            finish();
        }
    }

    @Override // com.kwad.components.ad.reward.g.c
    public void onPlayAgainClick() {
        com.kwad.components.ad.reward.model.c cVar;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (cVar = this.mModel) == null || (adTemplate = cVar.getAdTemplate().mPlayAgain) == null) {
            return;
        }
        adTemplate.inPlayAgain = true;
        this.mRewardPresenter.bt();
        this.mRewardPresenter = null;
        this.mPresenter = null;
        com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this, adTemplate) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KSRewardVideoActivityProxy lP;
            public final /* synthetic */ AdTemplate lS;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, adTemplate};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.lP = this;
                this.lS = adTemplate;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ((k) this.lP.mCallerContext).releaseSync();
                    bd.runOnUiThread(new Runnable(this) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.8.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass8 lT;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.lT = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.lT.lP.mModel.y(this.lT.lS);
                                a.G(this.lT.lP.getUniqueId());
                                KSRewardVideoActivityProxy kSRewardVideoActivityProxy = this.lT.lP;
                                kSRewardVideoActivityProxy.onActivityCreated(kSRewardVideoActivityProxy.mRootView);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // com.kwad.components.core.g.b, com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                AdTemplate adTemplate = cVar.getAdTemplate();
                com.kwad.sdk.core.d.a.tr();
                com.kwad.sdk.core.d.a.an(adTemplate);
            }
            com.kwad.components.ad.reward.b.a.gp().O(this.mContext);
        }
    }

    @Override // com.kwad.components.ad.reward.p.a
    public void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mIsBackEnable = false;
            T t = this.mCallerContext;
            ((k) t).mRewardVerifyCalled = false;
            ((k) t).mC = false;
        }
    }
}
