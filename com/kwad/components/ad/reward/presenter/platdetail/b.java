package com.kwad.components.ad.reward.presenter.platdetail;

import android.graphics.Color;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
/* loaded from: classes5.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailVideoView b;
    public AdTemplate c;
    public com.kwad.components.core.c.a.b d;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, this, view2, z) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0507a(view2.getContext()).a(this.c).a(new a.b(this, z) { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ b b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
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
                    this.a = z;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.b.b(this.a);
                    }
                }
            }).a(this.d).a(false).a(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            com.kwad.sdk.core.report.a.a(this.c, new f().a(z ? 1 : 153).a(((com.kwad.components.ad.reward.presenter.a) this).a.h.getTouchCoords()), ((com.kwad.components.ad.reward.presenter.a) this).a.e);
            ((com.kwad.components.ad.reward.presenter.a) this).a.b.a();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            this.c = lVar.g;
            this.d = lVar.k;
            new com.kwad.sdk.widget.f(this.b, this);
            this.b.setBackgroundColor(Color.parseColor(com.kwad.sdk.core.response.a.a.T(d.i(this.c)) ? "#B3000000" : "#4D000000"));
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a_(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            a(view2, true);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) && com.kwad.sdk.core.response.a.c.d(this.c)) {
            a(view2, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.i_();
            this.b = (DetailVideoView) b(R.id.obfuscated_res_0x7f0911da);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.k_();
            this.b.setClickListener(null);
        }
    }
}
