package com.cmic.sso.sdk.b.a;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.d.o;
import com.cmic.sso.sdk.d.t;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class d implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f69445a;

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

    @Override // com.cmic.sso.sdk.b.a.b
    public void a(com.cmic.sso.sdk.b.c.c cVar, com.cmic.sso.sdk.b.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, aVar) == null) {
            if (!cVar.b()) {
                b(cVar, cVar2, aVar);
                return;
            }
            t a2 = t.a((Context) null);
            if (Build.VERSION.SDK_INT >= 21) {
                a2.a(new t.a(this, aVar, cVar, cVar2) { // from class: com.cmic.sso.sdk.b.a.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ com.cmic.sso.sdk.a f69446a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ com.cmic.sso.sdk.b.c.c f69447b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ com.cmic.sso.sdk.b.d.c f69448c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ d f69449d;

                    /* renamed from: e  reason: collision with root package name */
                    public final AtomicBoolean f69450e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar, cVar, cVar2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f69449d = this;
                        this.f69446a = aVar;
                        this.f69447b = cVar;
                        this.f69448c = cVar2;
                        this.f69450e = new AtomicBoolean(false);
                    }

                    @Override // com.cmic.sso.sdk.d.t.a
                    public void a(Network network) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, network) == null) || this.f69450e.getAndSet(true) || network == null) {
                            return;
                        }
                        o.a(new o.a(this, null, this.f69446a, network) { // from class: com.cmic.sso.sdk.b.a.d.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Network f69451a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f69452b;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r9, r10);
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r9, r10, network};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        Object[] objArr2 = newInitContext.callArgs;
                                        super((Context) objArr2[0], (com.cmic.sso.sdk.a) objArr2[1]);
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f69452b = this;
                                this.f69451a = network;
                            }

                            @Override // com.cmic.sso.sdk.d.o.a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.cmic.sso.sdk.d.c.b("WifiChangeInterceptor", "onAvailable");
                                    this.f69452b.f69447b.a(this.f69451a);
                                    AnonymousClass1 anonymousClass1 = this.f69452b;
                                    anonymousClass1.f69449d.b(anonymousClass1.f69447b, anonymousClass1.f69448c, anonymousClass1.f69446a);
                                }
                            }
                        });
                    }
                });
                return;
            }
            String b2 = aVar.b("operatortype", "0");
            if (!"1".equals(b2) && !"0".equals(b2)) {
                com.cmic.sso.sdk.d.c.a("WifiChangeInterceptor", "异网低版本不支持wifi切换");
                cVar2.a(com.cmic.sso.sdk.b.d.a.a(102508));
            } else if (a2.a(cVar.a())) {
                com.cmic.sso.sdk.d.c.b("WifiChangeInterceptor", "切换网络成功");
                b(cVar, cVar2, aVar);
            } else {
                com.cmic.sso.sdk.d.c.a("WifiChangeInterceptor", "切换网络失败or无数据网络");
                cVar2.a(com.cmic.sso.sdk.b.d.a.a(102508));
            }
        }
    }

    public void b(com.cmic.sso.sdk.b.c.c cVar, com.cmic.sso.sdk.b.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, cVar2, aVar) == null) || (bVar = this.f69445a) == null) {
            return;
        }
        bVar.a(cVar, new com.cmic.sso.sdk.b.d.c(this, cVar2) { // from class: com.cmic.sso.sdk.b.a.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.cmic.sso.sdk.b.d.c f69453a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f69454b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, cVar2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f69454b = this;
                this.f69453a = cVar2;
            }

            @Override // com.cmic.sso.sdk.b.d.c
            public void a(com.cmic.sso.sdk.b.d.b bVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar2) == null) {
                    this.f69453a.a(bVar2);
                }
            }

            @Override // com.cmic.sso.sdk.b.d.c
            public void a(com.cmic.sso.sdk.b.d.a aVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                    this.f69453a.a(aVar2);
                }
            }
        }, aVar);
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f69445a = bVar;
        }
    }
}
