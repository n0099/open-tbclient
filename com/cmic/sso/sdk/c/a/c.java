package com.cmic.sso.sdk.c.a;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public com.cmic.sso.sdk.c.d.c f38420b;

    /* renamed from: c  reason: collision with root package name */
    public final com.cmic.sso.sdk.c.a f38421c;

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
        this.f38421c = new com.cmic.sso.sdk.c.a();
    }

    public void b(com.cmic.sso.sdk.c.c.c cVar, com.cmic.sso.sdk.c.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, cVar2, aVar) == null) || this.a == null) {
            return;
        }
        this.f38420b = new com.cmic.sso.sdk.c.d.c(this, cVar, aVar, cVar2) { // from class: com.cmic.sso.sdk.c.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ com.cmic.sso.sdk.c.c.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ com.cmic.sso.sdk.a f38422b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ com.cmic.sso.sdk.c.d.c f38423c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ c f38424d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, cVar, aVar, cVar2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38424d = this;
                this.a = cVar;
                this.f38422b = aVar;
                this.f38423c = cVar2;
            }

            @Override // com.cmic.sso.sdk.c.d.c
            public void a(com.cmic.sso.sdk.c.d.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    if (bVar.d()) {
                        this.f38424d.b(this.f38424d.f38421c.a(this.a, bVar, this.f38422b), this.f38423c, this.f38422b);
                    } else if (!TextUtils.isEmpty(this.f38424d.f38421c.a())) {
                        this.f38424d.b(this.f38424d.f38421c.b(this.a, bVar, this.f38422b), this.f38423c, this.f38422b);
                    } else {
                        this.f38423c.a(bVar);
                    }
                }
            }

            @Override // com.cmic.sso.sdk.c.d.c
            public void a(com.cmic.sso.sdk.c.d.a aVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                    if (this.a.j()) {
                        com.cmic.sso.sdk.e.c.a("RetryAndRedirectInterceptor", "retry: " + this.a.a());
                        this.f38424d.b(this.a, this.f38423c, this.f38422b);
                        return;
                    }
                    this.f38423c.a(aVar2);
                }
            }
        };
        if (cVar.g()) {
            this.a.a(cVar, this.f38420b, aVar);
        } else {
            cVar2.a(com.cmic.sso.sdk.c.d.a.a(200025));
        }
    }

    @Override // com.cmic.sso.sdk.c.a.b
    public void a(com.cmic.sso.sdk.c.c.c cVar, com.cmic.sso.sdk.c.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, aVar) == null) {
            b(cVar, cVar2, aVar);
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.a = bVar;
        }
    }
}
