package com.cmic.sso.sdk.b.a;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f69438a;

    /* renamed from: b  reason: collision with root package name */
    public com.cmic.sso.sdk.b.d.c f69439b;

    /* renamed from: c  reason: collision with root package name */
    public final com.cmic.sso.sdk.b.a f69440c;

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
        this.f69440c = new com.cmic.sso.sdk.b.a();
    }

    public void b(com.cmic.sso.sdk.b.c.c cVar, com.cmic.sso.sdk.b.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, cVar2, aVar) == null) || this.f69438a == null) {
            return;
        }
        this.f69439b = new com.cmic.sso.sdk.b.d.c(this, cVar, aVar, cVar2) { // from class: com.cmic.sso.sdk.b.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.cmic.sso.sdk.b.c.c f69441a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ com.cmic.sso.sdk.a f69442b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ com.cmic.sso.sdk.b.d.c f69443c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ c f69444d;

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
                this.f69444d = this;
                this.f69441a = cVar;
                this.f69442b = aVar;
                this.f69443c = cVar2;
            }

            @Override // com.cmic.sso.sdk.b.d.c
            public void a(com.cmic.sso.sdk.b.d.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    if (bVar.d()) {
                        this.f69444d.b(this.f69444d.f69440c.a(this.f69441a, bVar, this.f69442b), this.f69443c, this.f69442b);
                    } else if (!TextUtils.isEmpty(this.f69444d.f69440c.a())) {
                        this.f69444d.b(this.f69444d.f69440c.b(this.f69441a, bVar, this.f69442b), this.f69443c, this.f69442b);
                    } else {
                        this.f69443c.a(bVar);
                    }
                }
            }

            @Override // com.cmic.sso.sdk.b.d.c
            public void a(com.cmic.sso.sdk.b.d.a aVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                    if (this.f69441a.j()) {
                        com.cmic.sso.sdk.d.c.a("RetryAndRedirectInterceptor", "retry: " + this.f69441a.a());
                        this.f69444d.b(this.f69441a, this.f69443c, this.f69442b);
                        return;
                    }
                    this.f69443c.a(aVar2);
                }
            }
        };
        if (cVar.g()) {
            this.f69438a.a(cVar, this.f69439b, aVar);
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
            this.f69438a = bVar;
        }
    }
}
