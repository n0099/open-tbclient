package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.CallFactoryParams;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.r60;
/* loaded from: classes5.dex */
public abstract class c70 implements CallFactory.CallFactoryProducer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r60 a;

    /* loaded from: classes5.dex */
    public class a implements CallFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r60 a;
        public final /* synthetic */ c70 b;

        public a(c70 c70Var, r60 r60Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c70Var, r60Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c70Var;
            this.a = r60Var;
        }

        @Override // com.baidu.searchbox.network.outback.core.CallFactory
        public Call newCall(Request request, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, request, z)) == null) {
                if (this.b.isAvailable() || !z) {
                    return new q60(request, this.a, false);
                }
                return null;
            }
            return (Call) invokeLZ.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b<T extends b, R extends c70> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public r60.a a;

        public b() {
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
            this.a = new r60.a();
        }

        public final R a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b(this.a.b()) : (R) invokeV.objValue;
        }

        public abstract R b(r60 r60Var);
    }

    public c70(r60 r60Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r60Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = r60Var;
    }

    public final void a(r60.a aVar, CallFactoryParams callFactoryParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, callFactoryParams) == null) {
            aVar.c(new m60(this.a.p().c()));
        }
    }

    @Override // com.baidu.searchbox.network.outback.core.CallFactory.CallFactoryProducer
    public CallFactory produceCallFactory(CallFactoryParams callFactoryParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callFactoryParams)) == null) {
            r60.a u = this.a.u();
            a(u, callFactoryParams);
            return new a(this, u.b());
        }
        return (CallFactory) invokeL.objValue;
    }
}
