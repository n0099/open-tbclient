package com.kwad.sdk.reward.presenter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.e;
/* loaded from: classes2.dex */
public class d extends com.kwad.sdk.reward.g implements e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f59148b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f59149c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.utils.e f59150d;

    public d() {
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

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f58874g);
            this.f59148b = j2;
            com.kwad.sdk.utils.e eVar = this.f59150d;
            if (eVar == null) {
                this.f59150d = new com.kwad.sdk.utils.e(com.kwad.sdk.core.response.a.a.v(j2));
            } else {
                eVar.a(com.kwad.sdk.core.response.a.a.v(j2));
            }
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
            this.f59149c = aVar.f58878k;
            this.f59150d.a(aVar.f58876i, this);
        }
    }

    @Override // com.kwad.sdk.utils.e.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            com.kwad.sdk.reward.a.b bVar = ((com.kwad.sdk.reward.g) this).a.f58869b;
            if (bVar != null) {
                bVar.e();
            }
            this.f59149c.e();
            ((com.kwad.sdk.reward.g) this).a.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f59150d.a(((com.kwad.sdk.reward.g) this).a.f58876i);
        }
    }
}
