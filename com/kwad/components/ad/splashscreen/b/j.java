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
import com.kwad.sdk.utils.az;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class j extends e implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.f.b, com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static long b = 400;
    public transient /* synthetic */ FieldHolder $fh;
    public View c;
    public KsShakeView d;
    public TextView e;
    public com.kwad.sdk.core.f.d f;
    public Vibrator g;
    public boolean h;
    public com.kwad.components.ad.splashscreen.d.a i;
    public com.kwad.components.ad.splashscreen.e j;

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

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(this.j.a());
            }
            KsShakeView ksShakeView = this.d;
            if (ksShakeView != null) {
                ksShakeView.a(this.j.c());
            }
        }
    }

    private void h() {
        com.kwad.components.ad.splashscreen.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (hVar = ((e) this).a) == null) {
            return;
        }
        com.kwad.components.ad.splashscreen.d.a aVar = this.i;
        if (aVar == null) {
            this.i = new com.kwad.components.ad.splashscreen.d.a(this, u(), ((e) this).a.c) { // from class: com.kwad.components.ad.splashscreen.b.j.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ j a;

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
                    this.a = this;
                }

                @Override // com.kwad.components.ad.splashscreen.d.a
                @SuppressLint({"SetTextI18n"})
                public final void a(String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || this.a.e == null) {
                        return;
                    }
                    TextView textView = this.a.e;
                    textView.setText("或点击" + str);
                }
            };
        } else {
            aVar.a(hVar.c);
        }
        com.kwad.components.core.c.a.b bVar = ((e) this).a.f;
        if (bVar != null) {
            bVar.a(this.i);
        }
    }

    private void i() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (view2 = this.c) == null || ((e) this).a == null) {
            return;
        }
        view2.setVisibility(0);
        com.kwad.sdk.core.report.a.c(((e) this).a.c, (int) Constants.METHOD_IM_SEND_MCAST_MSG, (JSONObject) null);
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.components.ad.splashscreen.h hVar = ((e) this).a;
            if (hVar == null) {
                return;
            }
            AdInfo i = com.kwad.sdk.core.response.a.d.i(hVar.c);
            u();
            com.kwad.components.ad.splashscreen.h hVar2 = ((e) this).a;
            this.j = com.kwad.components.ad.splashscreen.e.a(hVar2.c, i, hVar2.f, 2);
            float u = com.kwad.sdk.core.response.a.b.u(((e) this).a.c);
            com.kwad.sdk.core.f.d dVar = this.f;
            if (dVar == null) {
                com.kwad.sdk.core.f.d dVar2 = new com.kwad.sdk.core.f.d(u);
                this.f = dVar2;
                dVar2.a(this);
            } else {
                dVar.a(u);
            }
            g();
            if (com.kwad.sdk.core.response.a.a.I(i)) {
                h();
            }
            i();
            this.f.a(u());
            this.d.post(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.j.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ j a;

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

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.d.c();
                    }
                }
            });
            com.kwad.components.ad.splashscreen.local.b.a(u());
            this.h = com.kwad.sdk.core.response.a.c.d(((e) this).a.c);
            new com.kwad.sdk.widget.f(this.d.getContext(), this.d, this);
            ((e) this).a.a(this);
        }
    }

    @Override // com.kwad.sdk.core.f.b
    public final void a(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d)}) == null) {
            boolean a = com.kwad.components.core.c.kwai.b.a();
            if (!((e) this).a.h.e() || a) {
                az.a(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.j.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ j a;

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
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.f.a();
                        }
                    }
                }, null, 500L);
                return;
            }
            this.d.a(new AnimatorListenerAdapter(this, d) { // from class: com.kwad.components.ad.splashscreen.b.j.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ double a;
                public final /* synthetic */ j b;

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
                    this.b = this;
                    this.a = d;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        j jVar = this.b;
                        com.kwad.components.ad.splashscreen.h hVar = ((e) jVar).a;
                        if (hVar != null) {
                            hVar.a(jVar.u(), Cea708Decoder.COMMAND_DF5, 2, new h.a(this) { // from class: com.kwad.components.ad.splashscreen.b.j.4.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass4 a;

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

                                @Override // com.kwad.components.ad.splashscreen.h.a
                                public final void a(@NonNull com.kwad.sdk.core.report.f fVar) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, fVar) == null) {
                                        fVar.a(this.a.a);
                                    }
                                }
                            });
                        }
                        this.b.d.c();
                        az.a(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.j.4.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass4 a;

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
                                    com.kwad.sdk.core.d.b.a("SplashShakePresenter", "onShakeEvent openGate2");
                                    this.a.b.f.a();
                                }
                            }
                        }, null, 500L);
                    }
                }
            });
            az.a(u(), this.g);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a_(View view2) {
        com.kwad.components.ad.splashscreen.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            com.kwad.sdk.core.d.b.a("SplashShakePresenter", "onSingleTap: " + view2);
            if (com.kwad.sdk.core.response.a.b.m(com.kwad.sdk.core.response.a.d.i(((e) this).a.c)) && (hVar = ((e) this).a) != null) {
                hVar.a(u(), Cea708Decoder.COMMAND_DF6, 1);
            }
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        com.kwad.components.ad.splashscreen.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            com.kwad.sdk.core.d.b.a("SplashShakePresenter", "onSlide: enableSlickClick: " + this.h);
            if (this.h && (hVar = ((e) this).a) != null) {
                hVar.a(view2.getContext(), 153, 1);
            }
        }
    }

    @Override // com.kwad.sdk.core.f.b
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.kwad.sdk.core.report.a.k(((e) this).a.c);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void e() {
        com.kwad.sdk.core.f.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (dVar = this.f) == null) {
            return;
        }
        dVar.b(u());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.i_();
            Context u = u();
            if (u != null) {
                this.g = (Vibrator) u.getSystemService("vibrator");
            }
            this.c = ((ViewStub) b(R.id.obfuscated_res_0x7f091190)).inflate();
            this.e = (TextView) b(R.id.obfuscated_res_0x7f091189);
            KsShakeView ksShakeView = (KsShakeView) b(R.id.obfuscated_res_0x7f091193);
            this.d = ksShakeView;
            ksShakeView.setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.k_();
            com.kwad.sdk.core.d.b.a("SplashShakePresenter", "onUnbind");
            com.kwad.components.ad.splashscreen.h hVar = ((e) this).a;
            if (hVar != null) {
                hVar.b(this);
            }
            com.kwad.sdk.core.f.d dVar = this.f;
            if (dVar != null) {
                dVar.b(u());
            }
            KsShakeView ksShakeView = this.d;
            if (ksShakeView != null) {
                ksShakeView.d();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        com.kwad.components.ad.splashscreen.h hVar;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            com.kwad.sdk.core.d.b.a("SplashShakePresenter", "onClick: " + view2);
            if (!view2.equals(this.d) || (hVar = ((e) this).a) == null || (adTemplate = hVar.c) == null || !com.kwad.sdk.core.response.a.b.m(com.kwad.sdk.core.response.a.d.i(adTemplate))) {
                return;
            }
            ((e) this).a.a(u(), Cea708Decoder.COMMAND_DF6, 1);
        }
    }
}
