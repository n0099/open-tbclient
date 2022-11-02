package com.kwad.components.ad.reward.presenter.d;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
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
import com.kwad.components.ad.reward.k.c;
import com.kwad.components.ad.reward.k.e;
import com.kwad.components.ad.reward.k.t;
import com.kwad.components.core.m.f;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes7.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements c.a, f.a, com.kwad.sdk.core.webview.a.kwai.a, com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static float tB = 0.4548105f;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.i.a.a mK;
    public final h mRewardVerifyListener;
    public f pJ;
    @Nullable
    public t sV;
    public int tC;
    public long tD;
    public boolean tE;
    public com.kwad.sdk.core.c.c tF;
    @Nullable

    /* renamed from: tv  reason: collision with root package name */
    public ViewGroup f1085tv;
    public ViewGroup tw;
    public e tx;
    public c ty;
    @Nullable
    public c tz;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1857023214, "Lcom/kwad/components/ad/reward/presenter/d/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1857023214, "Lcom/kwad/components/ad/reward/presenter/d/b;");
        }
    }

    public b() {
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
        this.tC = 15;
        this.tD = -1L;
        this.tE = false;
        this.mRewardVerifyListener = new h(this) { // from class: com.kwad.components.ad.reward.presenter.d.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b tI;

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
                this.tI = this;
            }

            @Override // com.kwad.components.ad.reward.d.h
            public final void onRewardVerify() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.tI.ty != null && k.q(this.tI.nM.mAdTemplate)) {
                        this.tI.ty.iP();
                    }
                    if (this.tI.tz != null) {
                        this.tI.tz.iP();
                    }
                }
            }
        };
        this.tF = new d(this) { // from class: com.kwad.components.ad.reward.presenter.d.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b tI;

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
                this.tI = this;
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.onBackToBackground();
                    this.tI.X(false);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.onBackToForeground();
                    this.tI.X(true);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(boolean z) {
        com.kwad.components.ad.reward.i.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
            com.kwad.components.ad.reward.i.a.a.a(this.mK, getContext(), this.nM.mAdTemplate);
            if (!this.mK.iI()) {
                if (z) {
                    Y(false);
                }
            } else if (!z) {
                this.tD = System.currentTimeMillis();
            } else {
                boolean ij = ij();
                if (ij && (aVar = this.mK) != null) {
                    aVar.iH();
                    com.kwad.components.ad.reward.c.eZ().notifyRewardVerify();
                    this.nM.mAdOpenInteractionListener.onRewardVerify();
                }
                Y(ij);
            }
        }
    }

    private void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            com.kwad.sdk.core.e.b.d("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.tE + " completed: " + z);
            if (this.tE) {
                return;
            }
            com.kwad.sdk.utils.t.d(getContext(), z ? "恭喜！任务达标啦，成功获取奖励~" : "哎呀，差一点就达标啦，再试一次~", 0);
            if (z) {
                this.tE = true;
            }
        }
    }

    private void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            this.nM.a(getContext(), z ? 1 : 153, 1);
        }
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, adBaseFrameLayout) == null) {
            if (!ag.cB(getContext())) {
                com.kwad.sdk.core.e.b.d("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
                return;
            }
            ((ViewStub) findViewById(R.id.obfuscated_res_0x7f09118d)).inflate();
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091183);
            this.tw = viewGroup;
            viewGroup.setClickable(true);
            new com.kwad.sdk.widget.f(this.tw, this);
            KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f091184);
            kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0703a7));
            kSFrameLayout.post(new Runnable(this, kSFrameLayout, getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0703a2)) { // from class: com.kwad.components.ad.reward.presenter.d.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KSFrameLayout tG;
                public final /* synthetic */ float tH;
                public final /* synthetic */ b tI;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, kSFrameLayout, Float.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.tI = this;
                    this.tG = kSFrameLayout;
                    this.tH = r8;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.tG.getHeight();
                    }
                }
            });
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091183);
            this.tw = viewGroup2;
            c cVar = new c(viewGroup2);
            this.ty = cVar;
            cVar.a(this.nM.mApkDownloadHelper);
            this.ty.a(this);
            this.ty.c(this.nM.mAdTemplate, false);
            e eVar = new e((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091182), this.tw, this.nM.mApkDownloadHelper, this);
            this.tx = eVar;
            eVar.a(new com.kwad.components.ad.reward.k.f(this) { // from class: com.kwad.components.ad.reward.presenter.d.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b tI;

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
                    this.tI = this;
                }

                @Override // com.kwad.components.ad.reward.k.f
                public final void h(String str, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, str, i) == null) {
                        int i2 = com.kwad.sdk.core.response.a.d.bQ(this.tI.nM.mAdTemplate).status;
                        com.kwad.sdk.core.e.b.d("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + i2);
                        this.tI.ty.i(str, i);
                    }
                }
            });
            this.tx.a(this.nM.mAdTemplate, adBaseFrameLayout);
        }
    }

    private boolean ij() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            com.kwad.sdk.core.e.b.d("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.tD);
            return this.tD >= 0 && System.currentTimeMillis() - this.tD > ((long) (this.tC * 1000));
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.webview.a.kwai.a
    public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            com.kwad.sdk.core.e.b.d("LaunchAppTaskPresenter", "onBind");
            AdTemplate adTemplate = this.nM.mAdTemplate;
            if (com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(com.kwad.sdk.core.response.a.d.bQ(adTemplate)))) {
                this.tC = com.kwad.components.ad.reward.kwai.b.fX();
                com.kwad.sdk.core.c.b.tp();
                com.kwad.sdk.core.c.b.a(this.tF);
                com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
                com.kwad.components.ad.reward.i.a.a iz = com.kwad.components.ad.reward.i.d.iz();
                this.mK = iz;
                this.nM.mK = iz;
                com.kwad.components.ad.reward.i.a.a.a(iz, getContext(), this.nM.mAdTemplate);
                AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091204);
                ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091073);
                this.f1085tv = viewGroup;
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                    c cVar = new c(this.f1085tv);
                    this.tz = cVar;
                    cVar.a(this.nM.mApkDownloadHelper);
                    this.tz.a(this);
                    this.tz.c(this.nM.mAdTemplate, false);
                    ((KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f091201)).setWidthBasedRatio(false);
                    t tVar = new t((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091200), this.f1085tv, this.nM.mApkDownloadHelper, this);
                    this.sV = tVar;
                    tVar.a(this.nM.mAdTemplate, adBaseFrameLayout);
                }
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate);
                f fVar = this.pJ;
                if (fVar == null) {
                    this.pJ = new f(com.kwad.sdk.core.response.a.a.ag(bQ));
                } else {
                    fVar.aw(com.kwad.sdk.core.response.a.a.ag(bQ));
                }
                this.pJ.a(getContext(), this);
                a(adBaseFrameLayout);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.k.c.a
    public final void c(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.nM.b(getContext(), z ? 1 : 153, 1);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            Z(true);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && com.kwad.sdk.core.response.a.c.bF(this.nM.mAdTemplate)) {
            Z(false);
        }
    }

    @Override // com.kwad.components.core.m.f.a
    public final void gW() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            k kVar = this.nM;
            if (kVar.mK == null || !k.o(kVar.mAdTemplate)) {
                return;
            }
            this.nM.mK.iF();
            com.kwad.sdk.core.c.b.tp();
            if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                return;
            }
            this.tD = System.currentTimeMillis();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onUnbind();
            com.kwad.sdk.core.e.b.d("LaunchAppTaskPresenter", "onUnbind");
            com.kwad.sdk.core.c.b.tp();
            com.kwad.sdk.core.c.b.b(this.tF);
            com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
            f fVar = this.pJ;
            if (fVar != null) {
                fVar.au(getContext());
            }
            e eVar = this.tx;
            if (eVar != null) {
                eVar.iR();
                this.tx = null;
            }
            c cVar = this.tz;
            if (cVar != null) {
                cVar.iO();
            }
            this.nM.mK = null;
        }
    }
}
