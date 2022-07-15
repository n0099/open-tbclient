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
import com.kwad.components.ad.reward.c.i;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.ad.reward.c.d {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] j;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public TextView c;
    public ImageView d;
    public View e;
    public AdTemplate f;
    public AdInfo g;
    public com.kwad.components.core.c.a.b h;
    public boolean i;
    public boolean k;
    public final g l;
    public final i m;

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
        j = new String[]{"%ss后获得奖励1", "已获得奖励1/2", "已获得全部奖励"};
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
        this.i = false;
        this.k = false;
        this.l = new h(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
            public final void a(long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    long a = l.a(j2, this.a.g);
                    if (j3 < a - 800) {
                        this.a.a((int) ((((float) (a - j3)) / 1000.0f) + 0.5f));
                        return;
                    }
                    ((com.kwad.components.ad.reward.presenter.a) this.a).a.x = true;
                    if (!l.c(this.a.f)) {
                        this.a.h();
                        this.a.g();
                        return;
                    }
                    if (!l.a(this.a.f) || ((com.kwad.components.ad.reward.presenter.a) this.a).a.B == null) {
                        if (l.b(this.a.f) && ((com.kwad.components.ad.reward.presenter.a) this.a).a.C != null && !((com.kwad.components.ad.reward.presenter.a) this.a).a.C.j()) {
                            ((com.kwad.components.ad.reward.presenter.a) this.a).a.C.h();
                        }
                    } else if (!((com.kwad.components.ad.reward.presenter.a) this.a).a.B.l()) {
                        ((com.kwad.components.ad.reward.presenter.a) this.a).a.B.h();
                    }
                    if (this.a.k) {
                        return;
                    }
                    this.a.c.setText(a.j[1]);
                    this.a.i();
                }
            }
        };
        this.m = new i(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.k = true;
                    this.a.c.setText(a.j[2]);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.D = i;
            if (!l.c(this.f)) {
                this.b.setText(String.valueOf(i));
            } else if (this.k) {
            } else {
                this.c.setText(String.format(j[0], Integer.valueOf(i)));
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            AdTemplate adTemplate = ((com.kwad.components.ad.reward.presenter.a) this).a.g;
            this.f = adTemplate;
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            this.g = i;
            this.h = ((com.kwad.components.ad.reward.presenter.a) this).a.k;
            long a = l.a(com.kwad.sdk.core.response.a.a.d(i), this.g) / 1000;
            if (l.c(this.f)) {
                this.e.setVisibility(0);
                this.e.setOnClickListener(this);
                this.c.setText(String.format(j[0], Long.valueOf(a)));
                this.b.setVisibility(8);
            } else {
                this.e.setVisibility(8);
                this.b.setText(String.valueOf(a));
                this.b.setVisibility(0);
                this.b.setAlpha(1.0f);
            }
            com.kwad.components.ad.reward.c.a().a(this.m);
            ((com.kwad.components.ad.reward.presenter.a) this).a.j.a(this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || this.i) {
            return;
        }
        this.i = true;
        this.d.setAlpha(0.0f);
        this.d.setVisibility(0);
        this.d.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    this.a.b.setVisibility(8);
                }
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.a.b.setAlpha(1.0f - floatValue);
                    this.a.d.setAlpha(floatValue);
                }
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.b.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.kwad.components.ad.reward.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (cVar = ((com.kwad.components.ad.reward.presenter.a) this).a.c) == null) {
            return;
        }
        cVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f, 41, ((com.kwad.components.ad.reward.presenter.a) this).a.h.getTouchCoords(), ((com.kwad.components.ad.reward.presenter.a) this).a.e);
            ((com.kwad.components.ad.reward.presenter.a) this).a.b.a();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (l.a(((com.kwad.components.ad.reward.presenter.a) this).a)) {
                ((com.kwad.components.ad.reward.presenter.a) this).a.a(this);
            } else {
                e();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.c.d
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && "ksad-video-top-bar".equals(str)) {
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i_();
            this.b = (TextView) b(R.id.obfuscated_res_0x7f0911cd);
            this.d = (ImageView) b(R.id.obfuscated_res_0x7f09102a);
            this.c = (TextView) b(R.id.obfuscated_res_0x7f0910fb);
            this.e = b(R.id.obfuscated_res_0x7f091028);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            com.kwad.components.ad.reward.c.a().b(this.m);
            ((com.kwad.components.ad.reward.presenter.a) this).a.j.b(this.l);
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.i = false;
            this.k = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2 == this.d || view2 == this.e) {
                com.kwad.components.core.c.a.a.a(new a.C0507a(view2.getContext()).a(this.f).a(this.h).a(2).a(((com.kwad.components.ad.reward.presenter.a) this).a.j.i()).a(new a.b(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;

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

                    @Override // com.kwad.components.core.c.a.a.b
                    public final void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.k();
                        }
                    }
                }));
            }
        }
    }
}
