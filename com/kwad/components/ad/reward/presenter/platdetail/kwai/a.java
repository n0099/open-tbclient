package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.g;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.b.d.b {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] rZ;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView ey;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public final h mRewardVerifyListener;
    public final g mVideoPlayStateListener;
    public TextView rV;
    public ImageView rW;
    public View rX;
    public boolean rY;
    public boolean sa;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(685563764, "Lcom/kwad/components/ad/reward/presenter/platdetail/kwai/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(685563764, "Lcom/kwad/components/ad/reward/presenter/platdetail/kwai/a;");
                return;
            }
        }
        rZ = new String[]{"%ss后获得奖励1", "已获得奖励1/2", "已获得全部奖励"};
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
                return;
            }
        }
        this.rY = false;
        this.sa = false;
        this.mVideoPlayStateListener = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a sb;

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
                this.sb = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    long a = k.a(j, this.sb.mAdInfo);
                    if (j2 < a - 800) {
                        this.sb.x((int) ((((float) (a - j2)) / 1000.0f) + 0.5f));
                        return;
                    }
                    this.sb.nM.mD = true;
                    if (!k.q(this.sb.mAdTemplate)) {
                        this.sb.notifyRewardVerify();
                        this.sb.hB();
                        return;
                    }
                    if (!k.o(this.sb.mAdTemplate) || this.sb.nM.mK == null) {
                        if (k.p(this.sb.mAdTemplate) && this.sb.nM.mL != null && !this.sb.nM.mL.iC()) {
                            this.sb.nM.mL.iB();
                        }
                    } else if (!this.sb.nM.mK.iC()) {
                        this.sb.nM.mK.iB();
                    }
                    if (this.sb.sa) {
                        return;
                    }
                    this.sb.rV.setText(a.rZ[1]);
                    this.sb.hC();
                }
            }
        };
        this.mRewardVerifyListener = new h(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a sb;

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
                this.sb = this;
            }

            @Override // com.kwad.components.ad.reward.d.h
            public final void onRewardVerify() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.sb.sa = true;
                    this.sb.rV.setText(a.rZ[2]);
                }
            }
        };
    }

    private void bQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            AdTemplate adTemplate = this.nM.mAdTemplate;
            this.mAdTemplate = adTemplate;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            this.mAdInfo = bQ;
            this.mApkDownloadHelper = this.nM.mApkDownloadHelper;
            long a = k.a(com.kwad.sdk.core.response.a.a.C(bQ), this.mAdInfo) / 1000;
            if (k.q(this.mAdTemplate)) {
                this.rX.setVisibility(0);
                this.rX.setOnClickListener(this);
                this.rV.setText(String.format(rZ[0], Long.valueOf(a)));
                this.ey.setVisibility(8);
            } else {
                this.rX.setVisibility(8);
                this.ey.setText(String.valueOf(a));
                this.ey.setVisibility(0);
                this.ey.setAlpha(1.0f);
            }
            com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
            this.nM.eF.a(this.mVideoPlayStateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hB() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || this.rY) {
            return;
        }
        this.rY = true;
        this.rW.setAlpha(0.0f);
        this.rW.setVisibility(0);
        this.rW.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a sb;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.sb = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    this.sb.ey.setVisibility(8);
                }
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a sb;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.sb = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.sb.ey.setAlpha(1.0f - floatValue);
                    this.sb.rW.setAlpha(floatValue);
                }
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hC() {
        com.kwad.components.ad.reward.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (cVar = this.nM.mAdRewardStepListener) == null) {
            return;
        }
        cVar.ff();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, 41, this.nM.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
            this.nM.mAdOpenInteractionListener.bB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.nM.mAdOpenInteractionListener.onRewardVerify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65563, this, i) == null) {
            this.nM.mM = i;
            if (!k.q(this.mAdTemplate)) {
                this.ey.setText(String.valueOf(i));
            } else if (this.sa) {
            } else {
                this.rV.setText(String.format(rZ[0], Integer.valueOf(i)));
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            if (k.a(this.nM)) {
                com.kwad.components.core.webview.b.c.a.pR().a(this);
            } else {
                bQ();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            if (view2 == this.rW || view2 == this.rX) {
                com.kwad.components.core.c.a.a.a(new a.C0354a(view2.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(2).l(this.nM.eF.getPlayDuration()).a(new a.b(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a sb;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.sb = this;
                    }

                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.sb.notifyAdClick();
                        }
                    }
                }));
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
            this.ey = (TextView) findViewById(R.id.obfuscated_res_0x7f0911ff);
            this.rW = (ImageView) findViewById(R.id.obfuscated_res_0x7f091077);
            this.rV = (TextView) findViewById(R.id.obfuscated_res_0x7f091147);
            this.rX = findViewById(R.id.obfuscated_res_0x7f091075);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onUnbind();
            com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
            this.nM.eF.b(this.mVideoPlayStateListener);
            com.kwad.components.core.webview.b.c.a.pR().b(this);
            this.rW.setVisibility(8);
            this.rX.setVisibility(8);
            this.rY = false;
            this.sa = false;
        }
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && "ksad-video-top-bar".equals(str)) {
            bQ();
        }
    }
}
