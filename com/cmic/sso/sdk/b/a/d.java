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
/* loaded from: classes5.dex */
public class d implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f32564a;

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
                    public final /* synthetic */ com.cmic.sso.sdk.a f32565a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ com.cmic.sso.sdk.b.c.c f32566b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ com.cmic.sso.sdk.b.d.c f32567c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ d f32568d;

                    /* renamed from: e  reason: collision with root package name */
                    public final AtomicBoolean f32569e;

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
                        this.f32568d = this;
                        this.f32565a = aVar;
                        this.f32566b = cVar;
                        this.f32567c = cVar2;
                        this.f32569e = new AtomicBoolean(false);
                    }

                    @Override // com.cmic.sso.sdk.d.t.a
                    public void a(Network network) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, network) == null) || this.f32569e.getAndSet(true) || network == null) {
                            return;
                        }
                        o.a(new o.a(this, null, this.f32565a, network) { // from class: com.cmic.sso.sdk.b.a.d.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Network f32570a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f32571b;

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
                                this.f32571b = this;
                                this.f32570a = network;
                            }

                            @Override // com.cmic.sso.sdk.d.o.a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.cmic.sso.sdk.d.c.b("WifiChangeInterceptor", "onAvailable");
                                    this.f32571b.f32566b.a(this.f32570a);
                                    AnonymousClass1 anonymousClass1 = this.f32571b;
                                    anonymousClass1.f32568d.b(anonymousClass1.f32566b, anonymousClass1.f32567c, anonymousClass1.f32565a);
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
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, cVar2, aVar) == null) || (bVar = this.f32564a) == null) {
            return;
        }
        bVar.a(cVar, new com.cmic.sso.sdk.b.d.c(this, cVar2) { // from class: com.cmic.sso.sdk.b.a.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.cmic.sso.sdk.b.d.c f32572a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f32573b;

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
                this.f32573b = this;
                this.f32572a = cVar2;
            }

            @Override // com.cmic.sso.sdk.b.d.c
            public void a(com.cmic.sso.sdk.b.d.b bVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar2) == null) {
                    this.f32572a.a(bVar2);
                }
            }

            @Override // com.cmic.sso.sdk.b.d.c
            public void a(com.cmic.sso.sdk.b.d.a aVar2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                    this.f32572a.a(aVar2);
                }
            }
        }, aVar);
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f32564a = bVar;
        }
    }
}
