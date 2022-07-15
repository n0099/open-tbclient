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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.h.a;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.ad.reward.q;
import com.kwad.components.core.l.d;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.b;
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
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.az;
@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* loaded from: classes5.dex */
public class KSRewardVideoActivityProxy extends com.kwad.components.core.g.b<l> implements com.kwad.components.ad.reward.e.c, a.InterfaceC0483a, q.a, d.b, b.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_TEMPLATE_PLAY_AGAIN = "key_template_json_play_again";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String TAG = "RewardVideo";
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.c.a mAdOpenInteractionListener;
    public com.kwad.components.ad.reward.c.c mAdRewardStepListener;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public boolean mIsBackEnable;
    public com.kwad.components.ad.reward.model.c mModel;
    public boolean mPageDismissCalled;
    public long mPageEnterTime;
    public com.kwad.components.ad.reward.c.f mPlayEndPageListener;
    public long mPlayTime;
    public q mRewardPresenter;
    public final com.kwad.components.ad.reward.c.i mRewardVerifyListener;
    public AdBaseFrameLayout mRootContainer;
    public com.kwad.components.core.video.g mVideoPlayStateListener;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static KsRewardVideoAd.RewardAdInteractionListener a;
        public static KsRewardVideoAd.RewardAdInteractionListener b;
        public static KsRewardVideoAd.RewardAdInteractionListener c;
        public static com.kwad.components.ad.reward.b.c d;
        public transient /* synthetic */ FieldHolder $fh;

        public static KsRewardVideoAd.RewardAdInteractionListener a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? c : (KsRewardVideoAd.RewardAdInteractionListener) invokeV.objValue;
        }

        public static void a(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2, com.kwad.components.ad.reward.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65537, null, rewardAdInteractionListener, rewardAdInteractionListener2, cVar) == null) {
                a = rewardAdInteractionListener;
                b = rewardAdInteractionListener2;
                d = cVar;
                c = rewardAdInteractionListener;
            }
        }

        public static com.kwad.components.ad.reward.b.c b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? d : (com.kwad.components.ad.reward.b.c) invokeV.objValue;
        }

        public static void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65542, null) == null) {
                c = a;
            }
        }

        public static void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65543, null) == null) {
                c = b;
            }
        }

        public static void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65544, null) == null) {
                a = null;
                b = null;
                c = null;
                com.kwad.components.ad.reward.b.c cVar = d;
                if (cVar != null) {
                    cVar.a();
                    d = null;
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
        this.mRewardVerifyListener = new com.kwad.components.ad.reward.c.i(this) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.1
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.ad.reward.c.i
            public final void a() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.a.mModel.b()) {
                    this.a.markOpenNsCompleted();
                    this.a.notifyRewardVerify();
                    this.a.notifyRewardVerifyStepByStep();
                }
            }
        };
        this.mPlayEndPageListener = new com.kwad.components.ad.reward.c.f(this) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.ad.reward.c.f
            public final void d_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.mIsBackEnable = true;
                }
            }
        };
        this.mAdRewardStepListener = new com.kwad.components.ad.reward.c.c(this) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.4
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.ad.reward.c.c
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.notifyRewardVerifyStepByStep();
                }
            }
        };
        this.mVideoPlayStateListener = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.5
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.a.mPlayTime = j2;
                }
            }
        };
        this.mAdOpenInteractionListener = new com.kwad.components.ad.reward.c.b(this) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.6
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.ad.reward.c.b, com.kwad.components.ad.reward.c.a
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (a.a() != null) {
                        a.a().onAdClicked();
                    }
                    ((l) this.a.mCallerContext).H = true;
                    ((l) this.a.mCallerContext).g();
                }
            }

            @Override // com.kwad.components.ad.reward.c.b, com.kwad.components.ad.reward.c.a
            public final void a(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4) == null) || a.a() == null) {
                    return;
                }
                a.a().onVideoPlayError(i3, i4);
            }

            @Override // com.kwad.components.ad.reward.c.b, com.kwad.components.ad.reward.c.a
            public final void a(long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                    try {
                        if (a.a() != null) {
                            a.a().onVideoSkipToEnd(j);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.components.ad.reward.c.b, com.kwad.components.ad.reward.c.a
            public final void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048579, this, z) == null) {
                    this.a.notifyPageDismiss(false);
                }
            }

            @Override // com.kwad.components.ad.reward.c.b, com.kwad.components.ad.reward.c.a
            public final void c() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || a.a() == null) {
                    return;
                }
                a.a().onVideoPlayStart();
            }

            @Override // com.kwad.components.ad.reward.c.b, com.kwad.components.ad.reward.c.a
            public final void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || a.a() == null) {
                    return;
                }
                a.a().onVideoPlayEnd();
            }

            @Override // com.kwad.components.ad.reward.c.b, com.kwad.components.ad.reward.c.a
            public final void e() {
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
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            ((l) this.mCallerContext).w = true;
            this.mModel.d().mRewardVerifyCalled = true;
            j.a().a(this.mModel.d());
            if (a.a() != null) {
                a.a().onRewardVerify();
                com.kwad.components.ad.reward.monitor.a.a(this.mModel.d(), 0, -1, true);
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091182);
            this.mRootContainer = adBaseFrameLayout;
            this.mDetailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.obfuscated_res_0x7f0911da);
            boolean z = !ae.e(this.mContext);
            if ((this.mModel.a() || this.mModel.b()) && z) {
                this.mDetailVideoView.setForce(true);
            }
            this.mDetailVideoView.setAd(true);
        }
    }

    private void initWithModel(@NonNull com.kwad.components.ad.reward.model.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, cVar) == null) || this.mModel.d() == null || this.mModel.d().mPlayAgain == null) {
            return;
        }
        com.kwad.sdk.utils.g.a(new Runnable(this, this.mModel.d().mPlayAgain) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate a;
            public final /* synthetic */ KSRewardVideoActivityProxy b;

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
                this.b = this;
                this.a = r7;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    boolean a2 = com.kwad.components.ad.b.a.a(this.a, true);
                    com.kwad.sdk.core.d.b.a(KSRewardVideoActivityProxy.TAG, "cache playAgain result: " + a2);
                }
            }
        });
    }

    private boolean isLaunchTaskCompleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            T t = this.mCallerContext;
            return ((l) t).B != null && ((l) t).B.g();
        }
        return invokeV.booleanValue;
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2, com.kwad.components.ad.reward.b.c cVar, int i) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, adTemplate, ksVideoPlayConfig, rewardAdInteractionListener, rewardAdInteractionListener2, cVar, Integer.valueOf(i)}) == null) {
            com.kwad.sdk.utils.k.b(adTemplate);
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
            a.a(rewardAdInteractionListener, rewardAdInteractionListener2, cVar);
            a.f();
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markOpenNsCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            T t = this.mCallerContext;
            if (((l) t).C != null) {
                ((l) t).C.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPageDismiss(boolean z) {
        com.kwad.components.ad.reward.model.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65555, this, z) == null) || this.mPageDismissCalled || this.mCallerContext == 0 || (cVar = this.mModel) == null) {
            return;
        }
        this.mPageDismissCalled = true;
        com.kwad.sdk.core.report.a.h(cVar.d(), (int) Math.ceil(((float) this.mPlayTime) / 1000.0f));
        if (z) {
            com.kwad.sdk.core.report.a.a(this.mModel.d(), 1, ((l) this.mCallerContext).e);
        } else {
            com.kwad.sdk.core.report.a.a(this.mModel.d(), 6, this.mModel.i());
        }
        if (a.a() != null) {
            a.a().onPageDismiss();
        }
    }

    private void notifyRewardStep(int i, int i2) {
        com.kwad.components.ad.reward.model.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65556, this, i, i2) == null) || (cVar = this.mModel) == null || com.kwad.sdk.core.response.a.d.u(cVar.d()) || ((l) this.mCallerContext).y.contains(Integer.valueOf(i2))) {
            return;
        }
        ((l) this.mCallerContext).y.add(Integer.valueOf(i2));
        r.a(i, i2, (l) this.mCallerContext, this.mModel);
        if (a.a() == null) {
            return;
        }
        try {
            a.a().onRewardStepVerify(i, i2);
            com.kwad.components.ad.reward.monitor.a.a(this.mModel.d(), i, i2, false);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        com.kwad.components.ad.reward.model.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, this) == null) || (cVar = this.mModel) == null || com.kwad.sdk.core.response.a.d.u(cVar.d()) || ((l) this.mCallerContext).w) {
            return;
        }
        boolean z = true;
        if (this.mModel.a()) {
            T t = this.mCallerContext;
            if ((((l) t).B == null || !((l) t).B.g()) ? false : false) {
                handleNotifyVerify();
            }
        } else if (!this.mModel.b()) {
            handleNotifyVerify();
        } else {
            T t2 = this.mCallerContext;
            if ((((l) t2).C == null || !((l) t2).C.g()) ? false : false) {
                handleNotifyVerify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerifyStepByStep() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            if (this.mModel.a()) {
                notifyRewardStep(2, 0);
                if (isLaunchTaskCompleted()) {
                    notifyRewardStep(2, 2);
                }
            } else if (!this.mModel.b()) {
                notifyRewardStep(0, 0);
            } else {
                T t = this.mCallerContext;
                boolean z = ((l) t).C != null && ((l) t).C.g();
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
        if (interceptable == null || interceptable.invokeV(65559, null) == null) {
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

    @Override // com.kwad.components.core.h.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "KSRewardLandScapeVideoActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.h.a.InterfaceC0483a
    public boolean handledOnResume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (isRefluxVisible()) {
                return true;
            }
            q qVar = this.mRewardPresenter;
            if (qVar != null) {
                return qVar.i();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRefluxVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRewardPresenter.e() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BackPressHandleResult d = this.mRewardPresenter.d();
            if (d.equals(BackPressHandleResult.HANDLED)) {
                return;
            }
            if (d.equals(BackPressHandleResult.HANDLED_CLOSE)) {
                super.onBackPressed();
            } else if (this.mIsBackEnable) {
                super.onBackPressed();
            }
        }
    }

    @Override // com.kwad.components.core.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            try {
                getIntent().removeExtra(AdWebViewVideoActivityProxy.KEY_TEMPLATE);
            } catch (Throwable unused) {
            }
            super.onCreate(bundle);
            getActivity().setTheme(16973838);
            com.kwad.components.ad.reward.model.c a2 = com.kwad.components.ad.reward.model.c.a(getIntent());
            this.mModel = a2;
            if (a2 == null) {
                finish();
                return;
            }
            this.mPageEnterTime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.reward.monitor.a.a(true, this.mModel.d(), this.mPageEnterTime);
            com.kwad.components.core.l.d.a().a(this);
            this.mContext = Wrapper.wrapContextIfNeed(getActivity());
            initWithModel(this.mModel);
            setContentView(R.layout.obfuscated_res_0x7f0d0400);
            initView();
            onActivityCreated(this.mRootContainer);
            c.a().a(this.mRewardVerifyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwad.components.core.g.b
    public l onCreateCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AdTemplate d = this.mModel.d();
            AdInfo e = this.mModel.e();
            l lVar = new l();
            lVar.L = getActivity();
            lVar.M = this.mContext;
            lVar.a = this.mPageEnterTime;
            lVar.b = this.mAdOpenInteractionListener;
            lVar.c = this.mAdRewardStepListener;
            lVar.f = this.mModel.h();
            lVar.d = this.mModel.f();
            lVar.e = this.mModel.i();
            lVar.h = this.mRootContainer;
            lVar.g = d;
            lVar.i = this.mDetailVideoView;
            com.kwad.components.ad.reward.h.a aVar = new com.kwad.components.ad.reward.h.a(lVar, this.mModel.g() == 2);
            lVar.j = aVar;
            aVar.a(this.mVideoPlayStateListener);
            lVar.j.a(this);
            lVar.J.add(aVar);
            if (com.kwad.sdk.core.response.a.a.I(e)) {
                lVar.k = new com.kwad.components.core.c.a.b(d, this.mModel.i());
            }
            lVar.m = new RewardActionBarControl(lVar, this.mContext, d);
            lVar.a(this.mPlayEndPageListener);
            if (com.kwad.sdk.core.response.a.b.m(d)) {
                lVar.n = new n(this.mModel.i(), null);
            }
            if (com.kwad.sdk.core.response.a.b.A(d)) {
                String B = com.kwad.sdk.core.response.a.b.B(d);
                if (!TextUtils.isEmpty(B)) {
                    com.kwad.components.ad.h.b bVar = new com.kwad.components.ad.h.b(this.mModel.i(), B);
                    lVar.o = bVar;
                    bVar.a(this);
                }
            }
            if (com.kwad.sdk.core.response.a.a.w(e)) {
                lVar.p = new com.kwad.components.ad.h.a().a(true);
            }
            lVar.t = true;
            if (com.kwad.sdk.core.response.a.a.ar(e)) {
                lVar.l = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0910c7));
            }
            lVar.E = 0L;
            if (this.mModel.e() != null) {
                lVar.E = com.kwad.sdk.core.response.a.a.ar(this.mModel.e()) ? com.kwad.sdk.core.response.a.a.v(this.mModel.e()) : com.kwad.sdk.core.response.a.a.u(this.mModel.e());
            }
            lVar.a(this);
            return lVar;
        }
        return (l) invokeV.objValue;
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
            q qVar = new q(this, this.mRootContainer, cVar, (l) this.mCallerContext);
            this.mRewardPresenter = qVar;
            qVar.a((q.a) this);
            return this.mRewardPresenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.components.core.g.b, com.kwad.components.core.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a().b(this.mRewardVerifyListener);
            super.onDestroy();
            T t = this.mCallerContext;
            if (t != 0) {
                ((l) t).j.b(this.mVideoPlayStateListener);
                ((l) this.mCallerContext).j.b(this);
            }
            notifyPageDismiss(false);
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                com.kwad.sdk.core.videocache.b.a.a(this.mContext.getApplicationContext()).c(com.kwad.sdk.core.response.a.a.b(cVar.e()));
            }
            a.h();
            com.kwad.components.core.l.d.a().b(this);
            j.a().b();
        }
    }

    @Override // com.kwad.components.core.l.d.b
    public void onPageClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            finish();
        }
    }

    @Override // com.kwad.components.ad.reward.e.c
    public void onPlayAgainClick() {
        com.kwad.components.ad.reward.model.c cVar;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (cVar = this.mModel) == null || (adTemplate = cVar.d().mPlayAgain) == null) {
            return;
        }
        adTemplate.inPlayAgain = true;
        this.mRewardPresenter.o();
        this.mRewardPresenter = null;
        this.mPresenter = null;
        com.kwad.sdk.utils.g.a(new Runnable(this, adTemplate) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate a;
            public final /* synthetic */ KSRewardVideoActivityProxy b;

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
                this.b = this;
                this.a = adTemplate;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ((l) this.b.mCallerContext).b();
                    az.a(new Runnable(this) { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass7 a;

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
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.a.b.mModel.a(this.a.a);
                                a.g();
                                KSRewardVideoActivityProxy kSRewardVideoActivityProxy = this.a.b;
                                kSRewardVideoActivityProxy.onActivityCreated(kSRewardVideoActivityProxy.mRootView);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // com.kwad.components.core.g.b, com.kwad.components.core.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                AdTemplate d = cVar.d();
                com.kwad.sdk.core.c.a.a();
                com.kwad.sdk.core.c.a.a(d);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.q.a
    public void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mIsBackEnable = false;
            T t = this.mCallerContext;
            ((l) t).w = false;
            ((l) t).v = false;
        }
    }
}
