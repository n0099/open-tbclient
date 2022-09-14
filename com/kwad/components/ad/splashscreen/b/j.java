package com.kwad.components.ad.splashscreen.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
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
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class j extends e implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.b, com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static long gO = 400;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.core.g.d eN;
    public Vibrator eO;
    public com.kwad.components.ad.splashscreen.d.a yM;
    public com.kwad.components.ad.splashscreen.e yT;
    public View yX;
    public KsShakeView yY;
    public TextView yZ;
    public boolean yw;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-78998559, "Lcom/kwad/components/ad/splashscreen/b/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-78998559, "Lcom/kwad/components/ad/splashscreen/b/j;");
        }
    }

    public j() {
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

    private void km() {
        com.kwad.components.ad.splashscreen.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (hVar = this.yF) == null) {
            return;
        }
        com.kwad.components.ad.splashscreen.d.a aVar = this.yM;
        if (aVar == null) {
            this.yM = new com.kwad.components.ad.splashscreen.d.a(this, getContext(), this.yF.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.j.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ j za;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (AdTemplate) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.za = this;
                }

                @Override // com.kwad.components.ad.splashscreen.d.a
                @SuppressLint({"SetTextI18n"})
                public final void Z(String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || this.za.yZ == null) {
                        return;
                    }
                    TextView textView = this.za.yZ;
                    textView.setText("或点击" + str);
                }
            };
        } else {
            aVar.setAdTemplate(hVar.mAdTemplate);
        }
        com.kwad.components.core.c.a.c cVar = this.yF.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this.yM);
        }
    }

    private void kp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            TextView textView = this.yZ;
            if (textView != null) {
                textView.setText(this.yT.jw());
            }
            KsShakeView ksShakeView = this.yY;
            if (ksShakeView != null) {
                ksShakeView.Z(this.yT.jx());
            }
            if (com.kwad.components.ad.splashscreen.d.c.b(this.yF)) {
                com.kwad.components.ad.splashscreen.d.c.a(this.yZ, -1, 60, -1, -1);
            }
        }
    }

    private void kq() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (view2 = this.yX) == null || this.yF == null) {
            return;
        }
        view2.setVisibility(0);
        com.kwad.sdk.core.report.a.c(this.yF.mAdTemplate, (int) Constants.METHOD_IM_SEND_MCAST_MSG, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d)}) == null) {
            boolean mq = com.kwad.components.core.c.kwai.b.mq();
            if (!this.yF.yd.qm() || mq) {
                bd.a(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.j.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ j za;

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
                        this.za = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.za.eN.vb();
                        }
                    }
                }, null, 500L);
                return;
            }
            this.yY.a(new AnimatorListenerAdapter(this, d) { // from class: com.kwad.components.ad.splashscreen.b.j.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ j za;
                public final /* synthetic */ double zb;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Double.valueOf(d)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.za = this;
                    this.zb = d;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        j jVar = this.za;
                        com.kwad.components.ad.splashscreen.h hVar = jVar.yF;
                        if (hVar != null) {
                            hVar.a(jVar.getContext(), Cea708Decoder.COMMAND_DF5, 2, new h.a(this) { // from class: com.kwad.components.ad.splashscreen.b.j.4.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass4 zc;

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
                                    this.zc = this;
                                }

                                @Override // com.kwad.components.ad.splashscreen.h.a
                                public final void b(@NonNull com.kwad.sdk.core.report.f fVar) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, fVar) == null) {
                                        fVar.e(this.zc.zb);
                                    }
                                }
                            });
                        }
                        this.za.yY.kG();
                        bd.a(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.j.4.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass4 zc;

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
                                this.zc = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.e.b.d("SplashShakePresenter", "onShakeEvent openGate2");
                                    this.zc.za.eN.vb();
                                }
                            }
                        }, null, 500L);
                    }
                }
            });
            bd.a(getContext(), this.eO);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            com.kwad.components.ad.splashscreen.h hVar = this.yF;
            if (hVar == null) {
                return;
            }
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(hVar.mAdTemplate);
            getContext();
            com.kwad.components.ad.splashscreen.h hVar2 = this.yF;
            this.yT = com.kwad.components.ad.splashscreen.e.a(hVar2.mAdTemplate, bQ, hVar2.mApkDownloadHelper, 2);
            float bp = com.kwad.sdk.core.response.a.b.bp(this.yF.mAdTemplate);
            com.kwad.sdk.core.g.d dVar = this.eN;
            if (dVar == null) {
                com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(bp);
                this.eN = dVar2;
                dVar2.a(this);
            } else {
                dVar.d(bp);
            }
            kp();
            if (com.kwad.sdk.core.response.a.a.am(bQ)) {
                km();
            }
            kq();
            this.eN.bz(getContext());
            this.yY.post(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.j.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ j za;

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
                    this.za = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.za.yY.kG();
                    }
                }
            });
            com.kwad.components.ad.splashscreen.local.b.G(getContext());
            this.yw = com.kwad.sdk.core.response.a.c.bF(this.yF.mAdTemplate);
            new com.kwad.sdk.widget.f(this.yY.getContext(), this.yY, this);
            this.yF.a(this);
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void bX() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.kwad.sdk.core.report.a.az(this.yF.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        com.kwad.components.ad.splashscreen.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            com.kwad.sdk.core.e.b.d("SplashShakePresenter", "onSingleTap: " + view2);
            if (com.kwad.sdk.core.response.a.b.cf(com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate)) && (hVar = this.yF) != null) {
                hVar.c(getContext(), Cea708Decoder.COMMAND_DF6, 1);
            }
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        com.kwad.components.ad.splashscreen.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            com.kwad.sdk.core.e.b.d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.yw);
            if (this.yw && (hVar = this.yF) != null) {
                hVar.c(view2.getContext(), 153, 1);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void jy() {
        com.kwad.sdk.core.g.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (dVar = this.eN) == null) {
            return;
        }
        dVar.bA(getContext());
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        com.kwad.components.ad.splashscreen.h hVar;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            com.kwad.sdk.core.e.b.d("SplashShakePresenter", "onClick: " + view2);
            if (!view2.equals(this.yY) || (hVar = this.yF) == null || (adTemplate = hVar.mAdTemplate) == null || !com.kwad.sdk.core.response.a.b.cf(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
                return;
            }
            this.yF.c(getContext(), Cea708Decoder.COMMAND_DF6, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onCreate();
            Context context = getContext();
            if (context != null) {
                this.eO = (Vibrator) context.getSystemService("vibrator");
            }
            this.yX = ((ViewStub) findViewById(R.id.obfuscated_res_0x7f0911e4)).inflate();
            this.yZ = (TextView) findViewById(R.id.obfuscated_res_0x7f0911dd);
            KsShakeView ksShakeView = (KsShakeView) findViewById(R.id.obfuscated_res_0x7f0911e7);
            this.yY = ksShakeView;
            ksShakeView.setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onUnbind();
            com.kwad.sdk.core.e.b.d("SplashShakePresenter", "onUnbind");
            com.kwad.components.ad.splashscreen.h hVar = this.yF;
            if (hVar != null) {
                hVar.b(this);
            }
            com.kwad.sdk.core.g.d dVar = this.eN;
            if (dVar != null) {
                dVar.bA(getContext());
            }
            KsShakeView ksShakeView = this.yY;
            if (ksShakeView != null) {
                ksShakeView.bt();
            }
        }
    }
}
