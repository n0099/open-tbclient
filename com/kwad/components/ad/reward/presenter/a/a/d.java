package com.kwad.components.ad.reward.presenter.a.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
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
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, c, com.kwad.components.core.webview.b.d.b {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] sR;
    public transient /* synthetic */ FieldHolder $fh;
    public final h mRewardVerifyListener;
    public ViewGroup sN;
    public ImageView sO;
    public ViewGroup sP;
    public TextView sQ;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2021160865, "Lcom/kwad/components/ad/reward/presenter/a/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2021160865, "Lcom/kwad/components/ad/reward/presenter/a/a/d;");
                return;
            }
        }
        sR = new String[]{"未获得奖励", "已获得奖励1/2", "已获得全部奖励"};
    }

    public d() {
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
        this.mRewardVerifyListener = new h(this) { // from class: com.kwad.components.ad.reward.presenter.a.a.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d sS;

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
                this.sS = this;
            }

            @Override // com.kwad.components.ad.reward.d.h
            public final void onRewardVerify() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && k.q(this.sS.nM.mAdTemplate)) {
                    this.sS.hU();
                }
            }
        };
    }

    private void bQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
            this.sN.setVisibility(0);
            this.sP.setVisibility(k.q(this.nM.mAdTemplate) ? 0 : 8);
        }
    }

    private void hT() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            ImageView imageView = this.sO;
            if (imageView != null) {
                imageView.setVisibility(0);
                this.sO.setOnClickListener(this);
            }
            ViewGroup viewGroup = this.sN;
            if (viewGroup != null) {
                viewGroup.setOnClickListener(this);
                this.sN.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.sQ.setText(sR[2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            k kVar = this.nM;
            com.kwad.sdk.core.report.a.a(kVar.mAdTemplate, 41, kVar.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
            this.nM.mAdOpenInteractionListener.bB();
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

    @Override // com.kwad.components.ad.reward.presenter.a.a.c
    public final void hR() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k kVar = this.nM;
            boolean z = kVar.mF;
            AdTemplate adTemplate = kVar.mAdTemplate;
            if (z) {
                if (com.kwad.sdk.core.response.a.a.Z(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
                    this.sP.setVisibility(8);
                }
            } else if (!k.o(adTemplate) && !k.p(this.nM.mAdTemplate)) {
                if (this.nM.mRewardVerifyCalled) {
                    hT();
                }
            } else {
                k kVar2 = this.nM;
                if (kVar2.mRewardVerifyCalled) {
                    return;
                }
                this.sQ.setText(kVar2.mD ? sR[1] : sR[0]);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2 == this.sO || view2 == this.sN) {
                com.kwad.components.core.c.a.a.a(new a.C0577a(view2.getContext()).L(this.nM.mAdTemplate).b(this.nM.mApkDownloadHelper).aj(false).ae(2).a(new a.b(this) { // from class: com.kwad.components.ad.reward.presenter.a.a.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d sS;

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
                        this.sS = this;
                    }

                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.sS.notifyAdClick();
                        }
                    }
                }));
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onCreate();
            this.sN = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0910de);
            this.sO = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910dd);
            this.sP = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0910c4);
            this.sQ = (TextView) findViewById(R.id.obfuscated_res_0x7f091196);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onUnbind();
            com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
            com.kwad.components.core.webview.b.c.a.pR().b(this);
            this.sN.setVisibility(8);
            this.sO.setVisibility(8);
            this.sP.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && "ksad-video-top-bar".equals(str)) {
            bQ();
        }
    }
}
