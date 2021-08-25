package com.kwai.sodler.lib;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class k implements com.kwai.sodler.lib.a.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.d f74249a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.g f74250b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.c f74251c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwai.sodler.lib.a.b f74252d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwai.sodler.lib.ext.c f74253e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwai.sodler.lib.ext.a f74254f;

    /* loaded from: classes10.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final com.kwai.sodler.lib.a.e f74255a;

        /* renamed from: com.kwai.sodler.lib.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C2033a extends a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2033a(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((com.kwai.sodler.lib.a.e) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.f74255a.f().a(fVar);
                }
            }
        }

        /* loaded from: classes10.dex */
        public static class b extends a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((com.kwai.sodler.lib.a.e) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.f74255a.c().a(fVar);
                }
            }
        }

        /* loaded from: classes10.dex */
        public static class c extends a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((com.kwai.sodler.lib.a.e) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.kwai.sodler.lib.k.a
            public void a(com.kwai.sodler.lib.a.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.f74255a.d().a(fVar);
                }
            }
        }

        public a(com.kwai.sodler.lib.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74255a = eVar;
        }

        public static a a(com.kwai.sodler.lib.a.e eVar, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, eVar, i2)) == null) ? i2 != 1 ? i2 != 256 ? new b(eVar) : new C2033a(eVar) : new c(eVar) : (a) invokeLI.objValue;
        }

        public abstract void a(com.kwai.sodler.lib.a.f fVar);
    }

    public k(com.kwai.sodler.lib.a.d dVar, com.kwai.sodler.lib.a.g gVar, com.kwai.sodler.lib.a.c cVar, com.kwai.sodler.lib.a.b bVar, com.kwai.sodler.lib.ext.c cVar2, com.kwai.sodler.lib.ext.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, gVar, cVar, bVar, cVar2, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f74249a = dVar;
        this.f74250b = gVar;
        this.f74251c = cVar;
        this.f74253e = cVar2;
        this.f74254f = aVar;
        this.f74252d = bVar;
    }

    public com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) {
            if (fVar.b() == null) {
                fVar.a(this);
            }
            com.kwai.sodler.lib.a.c("Sodler.manager", "request id = " + fVar.i() + ", state log = " + fVar.d());
            aVar.a(fVar);
            return fVar;
        }
        return (com.kwai.sodler.lib.a.f) invokeLL.objValue;
    }

    public Map a(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) ? (map == null || map == Collections.EMPTY_MAP) ? new HashMap() : map : (Map) invokeL.objValue;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f74253e : (com.kwai.sodler.lib.ext.c) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f74249a : (com.kwai.sodler.lib.a.d) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.g d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f74250b : (com.kwai.sodler.lib.a.g) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f74251c : (com.kwai.sodler.lib.a.c) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f74252d : (com.kwai.sodler.lib.a.b) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f74254f : (com.kwai.sodler.lib.ext.a) invokeV.objValue;
    }
}
