package com.cmic.sso.sdk.b.a;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class c implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f62782a;

    /* renamed from: b  reason: collision with root package name */
    public com.cmic.sso.sdk.b.d.c f62783b;

    /* renamed from: c  reason: collision with root package name */
    public final com.cmic.sso.sdk.b.a f62784c;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62784c = new com.cmic.sso.sdk.b.a();
    }

    public void b(com.cmic.sso.sdk.b.c.c cVar, com.cmic.sso.sdk.b.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, cVar2, aVar) == null) || this.f62782a == null) {
            return;
        }
        this.f62783b = new com.cmic.sso.sdk.b.d.c(this, cVar, aVar, cVar2) { // from class: com.cmic.sso.sdk.b.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.cmic.sso.sdk.b.c.c f62785a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ com.cmic.sso.sdk.a f62786b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ com.cmic.sso.sdk.b.d.c f62787c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ c f62788d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, cVar, aVar, cVar2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f62788d = this;
                this.f62785a = cVar;
                this.f62786b = aVar;
                this.f62787c = cVar2;
            }

            @Override // com.cmic.sso.sdk.b.d.c
            public void a(com.cmic.sso.sdk.b.d.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    if (bVar.d()) {
                        this.f62788d.b(this.f62788d.f62784c.a(this.f62785a, bVar, this.f62786b), this.f62787c, this.f62786b);
                    } else if (!TextUtils.isEmpty(this.f62788d.f62784c.a())) {
                        this.f62788d.b(this.f62788d.f62784c.b(this.f62785a, bVar, this.f62786b), this.f62787c, this.f62786b);
                    } else {
                        this.f62787c.a(bVar);
                    }
                }
            }

            @Override // com.cmic.sso.sdk.b.d.c
            public void a(com.cmic.sso.sdk.b.d.a aVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                    if (this.f62785a.j()) {
                        com.cmic.sso.sdk.d.c.a("RetryAndRedirectInterceptor", "retry: " + this.f62785a.a());
                        this.f62788d.b(this.f62785a, this.f62787c, this.f62786b);
                        return;
                    }
                    this.f62787c.a(aVar2);
                }
            }
        };
        if (cVar.g()) {
            this.f62782a.a(cVar, this.f62783b, aVar);
        } else {
            cVar2.a(com.cmic.sso.sdk.b.d.a.a(200025));
        }
    }

    @Override // com.cmic.sso.sdk.b.a.b
    public void a(com.cmic.sso.sdk.b.c.c cVar, com.cmic.sso.sdk.b.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, aVar) == null) {
            b(cVar, cVar2, aVar);
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f62782a = bVar;
        }
    }
}
