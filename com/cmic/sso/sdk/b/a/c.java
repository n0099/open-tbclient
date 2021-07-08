package com.cmic.sso.sdk.b.a;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f32557a;

    /* renamed from: b  reason: collision with root package name */
    public com.cmic.sso.sdk.b.d.c f32558b;

    /* renamed from: c  reason: collision with root package name */
    public final com.cmic.sso.sdk.b.a f32559c;

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
        this.f32559c = new com.cmic.sso.sdk.b.a();
    }

    public void b(com.cmic.sso.sdk.b.c.c cVar, com.cmic.sso.sdk.b.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, cVar2, aVar) == null) || this.f32557a == null) {
            return;
        }
        this.f32558b = new com.cmic.sso.sdk.b.d.c(this, cVar, aVar, cVar2) { // from class: com.cmic.sso.sdk.b.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.cmic.sso.sdk.b.c.c f32560a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ com.cmic.sso.sdk.a f32561b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ com.cmic.sso.sdk.b.d.c f32562c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ c f32563d;

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
                this.f32563d = this;
                this.f32560a = cVar;
                this.f32561b = aVar;
                this.f32562c = cVar2;
            }

            @Override // com.cmic.sso.sdk.b.d.c
            public void a(com.cmic.sso.sdk.b.d.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    if (bVar.d()) {
                        this.f32563d.b(this.f32563d.f32559c.a(this.f32560a, bVar, this.f32561b), this.f32562c, this.f32561b);
                    } else if (!TextUtils.isEmpty(this.f32563d.f32559c.a())) {
                        this.f32563d.b(this.f32563d.f32559c.b(this.f32560a, bVar, this.f32561b), this.f32562c, this.f32561b);
                    } else {
                        this.f32562c.a(bVar);
                    }
                }
            }

            @Override // com.cmic.sso.sdk.b.d.c
            public void a(com.cmic.sso.sdk.b.d.a aVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                    if (this.f32560a.j()) {
                        com.cmic.sso.sdk.d.c.a("RetryAndRedirectInterceptor", "retry: " + this.f32560a.a());
                        this.f32563d.b(this.f32560a, this.f32562c, this.f32561b);
                        return;
                    }
                    this.f32562c.a(aVar2);
                }
            }
        };
        if (cVar.g()) {
            this.f32557a.a(cVar, this.f32558b, aVar);
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
            this.f32557a = bVar;
        }
    }
}
