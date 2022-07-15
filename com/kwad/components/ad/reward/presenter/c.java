package com.kwad.components.ad.reward.presenter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.widget.ComplianceTextView;
/* loaded from: classes5.dex */
public final class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ComplianceTextView b;
    public com.kwad.components.ad.reward.c.d c;

    public c() {
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
        this.c = new com.kwad.components.ad.reward.c.d(this) { // from class: com.kwad.components.ad.reward.presenter.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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

            @Override // com.kwad.components.ad.reward.c.d
            public final void a(String str) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) && "ksad-video-top-bar".equals(str)) {
                    this.a.b.setVisibility(0);
                    this.a.b.setAdTemplate(((a) this.a).a.g);
                }
            }
        };
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            com.kwad.components.ad.reward.l lVar = ((a) this).a;
            return lVar.t ? com.kwad.components.ad.reward.l.a(lVar) : com.kwad.components.ad.reward.l.b(lVar);
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (!d()) {
                this.b.setVisibility(0);
                this.b.setAdTemplate(((a) this).a.g);
            }
            ((a) this).a.a(this.c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
            this.b = (ComplianceTextView) b(R.id.obfuscated_res_0x7f09101a);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.k_();
            ((a) this).a.b(this.c);
        }
    }
}
