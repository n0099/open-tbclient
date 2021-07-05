package com.kwad.sdk.contentalliance.home.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class m extends com.kwad.sdk.contentalliance.home.e implements com.kwad.sdk.core.i.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35151b;

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.home.h hVar = ((com.kwad.sdk.contentalliance.home.e) this).f35218a.f35224f;
            if (hVar != null) {
                this.f35151b = hVar.f35240a;
            }
            this.f35151b.a(this);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.kwad.sdk.core.h.d.a().b(((com.kwad.sdk.contentalliance.home.e) this).f35218a.f35219a);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b_();
            this.f35151b.b(this);
            com.kwad.sdk.core.h.d.a().b(((com.kwad.sdk.contentalliance.home.e) this).f35218a.f35219a);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.kwad.sdk.core.h.d.a().a(((com.kwad.sdk.contentalliance.home.e) this).f35218a.f35219a);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.d();
            com.kwad.sdk.core.h.d.a().b(((com.kwad.sdk.contentalliance.home.e) this).f35218a.f35219a);
        }
    }
}
