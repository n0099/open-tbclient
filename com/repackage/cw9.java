package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dw9;
import com.repackage.uu9;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class cw9<T> extends dw9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements dw9.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ TimeUnit b;

        /* renamed from: com.repackage.cw9$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0463a implements ev9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ dw9.c a;
            public final /* synthetic */ Long b;

            public C0463a(a aVar, dw9.c cVar, Long l) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cVar, l};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
                this.b = l;
            }

            @Override // com.repackage.ev9
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.g(this.b.longValue());
                }
            }
        }

        public a(long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = timeUnit;
        }

        @Override // com.repackage.dw9.a
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3) {
            return call((dw9.c) ((dw9.c) obj), (Long) obj2, (uu9.a) obj3);
        }

        public yu9 call(dw9.c<T> cVar, Long l, uu9.a aVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cVar, l, aVar)) == null) ? aVar.c(new C0463a(this, cVar, l), this.a, this.b) : (yu9) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements dw9.b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ TimeUnit b;

        /* loaded from: classes6.dex */
        public class a implements ev9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ dw9.c a;
            public final /* synthetic */ Long b;

            public a(b bVar, dw9.c cVar, Long l) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar, l};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
                this.b = l;
            }

            @Override // com.repackage.ev9
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.g(this.b.longValue());
                }
            }
        }

        public b(long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = timeUnit;
        }

        @Override // com.repackage.dw9.b
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4) {
            return call((dw9.c<Long>) obj, (Long) obj2, (Long) obj3, (uu9.a) obj4);
        }

        public yu9 call(dw9.c<T> cVar, Long l, T t, uu9.a aVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, cVar, l, t, aVar)) == null) ? aVar.c(new a(this, cVar, l), this.a, this.b) : (yu9) invokeLLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cw9(long j, TimeUnit timeUnit, ru9<? extends T> ru9Var, uu9 uu9Var) {
        super(new a(j, timeUnit), new b(j, timeUnit), ru9Var, uu9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), timeUnit, ru9Var, uu9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((dw9.a) objArr2[0], (dw9.b) objArr2[1], (ru9) objArr2[2], (uu9) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.dw9
    public /* bridge */ /* synthetic */ xu9 call(xu9 xu9Var) {
        return super.call(xu9Var);
    }
}
