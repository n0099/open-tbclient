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
/* loaded from: classes5.dex */
public class j implements com.kwai.sodler.lib.a.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwai.sodler.lib.a.d a;
    public final com.kwai.sodler.lib.a.g b;
    public final com.kwai.sodler.lib.a.c c;
    public final com.kwai.sodler.lib.a.b d;
    public final com.kwai.sodler.lib.ext.c e;
    public final com.kwai.sodler.lib.ext.a f;

    /* loaded from: classes5.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final com.kwai.sodler.lib.a.e a;

        /* renamed from: com.kwai.sodler.lib.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0569a extends a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0569a(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((com.kwai.sodler.lib.a.e) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.kwai.sodler.lib.j.a
            public final void a(com.kwai.sodler.lib.a.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.a.g().a(fVar);
                }
            }
        }

        /* loaded from: classes5.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((com.kwai.sodler.lib.a.e) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.kwai.sodler.lib.j.a
            public final void a(com.kwai.sodler.lib.a.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.a.d().a(fVar);
                }
            }
        }

        /* loaded from: classes5.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((com.kwai.sodler.lib.a.e) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.kwai.sodler.lib.j.a
            public final void a(com.kwai.sodler.lib.a.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    this.a.e().a(fVar);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        public static a a(com.kwai.sodler.lib.a.e eVar, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, eVar, i)) == null) ? i != 1 ? i != 256 ? new b(eVar) : new C0569a(eVar) : new c(eVar) : (a) invokeLI.objValue;
        }

        public abstract void a(com.kwai.sodler.lib.a.f fVar);
    }

    public j(com.kwai.sodler.lib.a.d dVar, com.kwai.sodler.lib.a.g gVar, com.kwai.sodler.lib.a.c cVar, com.kwai.sodler.lib.a.b bVar, com.kwai.sodler.lib.ext.c cVar2, com.kwai.sodler.lib.ext.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, gVar, cVar, bVar, cVar2, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dVar;
        this.b = gVar;
        this.c = cVar;
        this.e = cVar2;
        this.f = aVar;
        this.d = bVar;
    }

    public static Map a(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, map)) == null) ? (map == null || map == Collections.EMPTY_MAP) ? new HashMap() : map : (Map) invokeL.objValue;
    }

    public com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) {
            if (fVar.b() == null) {
                fVar.a(this);
            }
            StringBuilder sb = new StringBuilder("request id = ");
            sb.append(fVar.i());
            sb.append(", state log = ");
            sb.append(fVar.d());
            aVar.a(fVar);
            return fVar;
        }
        return (com.kwai.sodler.lib.a.f) invokeLL.objValue;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (com.kwai.sodler.lib.ext.c) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (com.kwai.sodler.lib.a.d) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (com.kwai.sodler.lib.a.g) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (com.kwai.sodler.lib.a.c) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : (com.kwai.sodler.lib.a.b) invokeV.objValue;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (com.kwai.sodler.lib.ext.a) invokeV.objValue;
    }
}
