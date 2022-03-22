package com.cmic.sso.sdk.c.a;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.e.n;
import com.cmic.sso.sdk.e.r;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class d implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    public d() {
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

    @Override // com.cmic.sso.sdk.c.a.b
    public void a(com.cmic.sso.sdk.c.c.c cVar, com.cmic.sso.sdk.c.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, aVar) == null) {
            if (!cVar.b()) {
                b(cVar, cVar2, aVar);
                return;
            }
            r a = r.a((Context) null);
            if (Build.VERSION.SDK_INT >= 21) {
                a.a(new r.a(this, aVar, cVar, cVar2) { // from class: com.cmic.sso.sdk.c.a.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.cmic.sso.sdk.a a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ com.cmic.sso.sdk.c.c.c f38425b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ com.cmic.sso.sdk.c.d.c f38426c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ d f38427d;

                    /* renamed from: e  reason: collision with root package name */
                    public final AtomicBoolean f38428e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar, cVar, cVar2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f38427d = this;
                        this.a = aVar;
                        this.f38425b = cVar;
                        this.f38426c = cVar2;
                        this.f38428e = new AtomicBoolean(false);
                    }

                    @Override // com.cmic.sso.sdk.e.r.a
                    public void a(Network network) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, network) == null) || this.f38428e.getAndSet(true)) {
                            return;
                        }
                        n.a(new n.a(this, null, this.a, network) { // from class: com.cmic.sso.sdk.c.a.d.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Network a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f38429b;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r9, r10);
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r9, r10, network};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        Object[] objArr2 = newInitContext.callArgs;
                                        super((Context) objArr2[0], (com.cmic.sso.sdk.a) objArr2[1]);
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f38429b = this;
                                this.a = network;
                            }

                            @Override // com.cmic.sso.sdk.e.n.a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (this.a != null) {
                                        com.cmic.sso.sdk.e.c.b("WifiChangeInterceptor", "onAvailable");
                                        this.f38429b.f38425b.a(this.a);
                                        AnonymousClass1 anonymousClass1 = this.f38429b;
                                        anonymousClass1.f38427d.b(anonymousClass1.f38425b, anonymousClass1.f38426c, anonymousClass1.a);
                                        return;
                                    }
                                    this.f38429b.f38426c.a(com.cmic.sso.sdk.c.d.a.a(102508));
                                }
                            }
                        });
                    }
                });
                return;
            }
            com.cmic.sso.sdk.e.c.a("WifiChangeInterceptor", "低版本不在支持wifi切换");
            cVar2.a(com.cmic.sso.sdk.c.d.a.a(102508));
        }
    }

    public void b(com.cmic.sso.sdk.c.c.c cVar, com.cmic.sso.sdk.c.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, cVar2, aVar) == null) || (bVar = this.a) == null) {
            return;
        }
        bVar.a(cVar, new com.cmic.sso.sdk.c.d.c(this, cVar2) { // from class: com.cmic.sso.sdk.c.a.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ com.cmic.sso.sdk.c.d.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f38430b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, cVar2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38430b = this;
                this.a = cVar2;
            }

            @Override // com.cmic.sso.sdk.c.d.c
            public void a(com.cmic.sso.sdk.c.d.b bVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar2) == null) {
                    this.a.a(bVar2);
                }
            }

            @Override // com.cmic.sso.sdk.c.d.c
            public void a(com.cmic.sso.sdk.c.d.a aVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                    this.a.a(aVar2);
                }
            }
        }, aVar);
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.a = bVar;
        }
    }
}
