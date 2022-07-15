package com.kwad.components.ad.reward.presenter.a.a;

import android.view.View;
import android.view.ViewGroup;
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
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.ad.reward.c.d, c {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] f;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup b;
    public ImageView c;
    public ViewGroup d;
    public TextView e;
    public final i g;

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
        f = new String[]{"未获得奖励", "已获得奖励1/2", "已获得全部奖励"};
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
        this.g = new i(this) { // from class: com.kwad.components.ad.reward.presenter.a.a.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && l.c(((com.kwad.components.ad.reward.presenter.a) this.a).a.g)) {
                    this.a.h();
                }
            }
        };
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            com.kwad.components.ad.reward.c.a().a(this.g);
            this.b.setVisibility(0);
            this.d.setVisibility(l.c(((com.kwad.components.ad.reward.presenter.a) this).a.g) ? 0 : 8);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            ImageView imageView = this.c;
            if (imageView != null) {
                imageView.setVisibility(0);
                this.c.setOnClickListener(this);
            }
            ViewGroup viewGroup = this.b;
            if (viewGroup != null) {
                viewGroup.setOnClickListener(this);
                this.b.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.e.setText(f[2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            com.kwad.sdk.core.report.a.a(lVar.g, 41, lVar.h.getTouchCoords(), ((com.kwad.components.ad.reward.presenter.a) this).a.e);
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

    @Override // com.kwad.components.ad.reward.presenter.a.a.c
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            boolean z = lVar.z;
            AdTemplate adTemplate = lVar.g;
            if (z) {
                if (com.kwad.sdk.core.response.a.a.w(com.kwad.sdk.core.response.a.d.i(adTemplate))) {
                    this.d.setVisibility(8);
                }
            } else if (!l.a(adTemplate) && !l.b(((com.kwad.components.ad.reward.presenter.a) this).a.g)) {
                if (((com.kwad.components.ad.reward.presenter.a) this).a.w) {
                    g();
                }
            } else {
                l lVar2 = ((com.kwad.components.ad.reward.presenter.a) this).a;
                if (lVar2.w) {
                    return;
                }
                this.e.setText(lVar2.x ? f[1] : f[0]);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.i_();
            this.b = (ViewGroup) b(R.id.obfuscated_res_0x7f091040);
            this.c = (ImageView) b(R.id.obfuscated_res_0x7f09103f);
            this.d = (ViewGroup) b(R.id.obfuscated_res_0x7f091029);
            this.e = (TextView) b(R.id.obfuscated_res_0x7f0910fc);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.k_();
            com.kwad.components.ad.reward.c.a().b(this.g);
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            this.d.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2 == this.c || view2 == this.b) {
                com.kwad.components.core.c.a.a.a(new a.C0507a(view2.getContext()).a(((com.kwad.components.ad.reward.presenter.a) this).a.g).a(((com.kwad.components.ad.reward.presenter.a) this).a.k).a(false).a(2).a(new a.b(this) { // from class: com.kwad.components.ad.reward.presenter.a.a.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d a;

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
                            this.a.i();
                        }
                    }
                }));
            }
        }
    }
}
