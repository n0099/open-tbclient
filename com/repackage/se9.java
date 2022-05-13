package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.repackage.oe9;
import com.repackage.qe9;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class se9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Deque<c>> a;

    /* loaded from: classes7.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final qe9 a;
        public final HashSet<Ssp.Pid> b;

        public a(qe9 qe9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qe9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qe9Var;
            this.b = new HashSet<>();
            for (qe9.c cVar : qe9Var.e) {
                for (qe9.b bVar : cVar.b) {
                    this.b.add(bVar.c);
                }
            }
        }

        @Override // com.repackage.se9.c
        public Set<Ssp.Pid> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (Set) invokeV.objValue;
        }

        @Override // com.repackage.se9.c
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.d : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final oe9 a;
        public final HashSet<Ssp.Pid> b;

        public b(oe9 oe9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe9Var;
            this.b = new HashSet<>();
            for (oe9.b bVar : oe9Var.b) {
                for (oe9.a aVar : bVar.b) {
                    this.b.add(aVar.c);
                }
            }
        }

        @Override // com.repackage.se9.c
        public Set<Ssp.Pid> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (Set) invokeV.objValue;
        }

        @Override // com.repackage.se9.c
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.c : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        Set<Ssp.Pid> a();

        int b();
    }

    public se9() {
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
        this.a = new HashMap<>();
    }

    public final Deque<c> a(String str) {
        InterceptResult invokeL;
        Deque<c> deque;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this.a) {
                deque = this.a.get(str);
                if (deque == null) {
                    deque = new ArrayDeque<>();
                    this.a.put(str, deque);
                }
            }
            return deque;
        }
        return (Deque) invokeL.objValue;
    }
}
