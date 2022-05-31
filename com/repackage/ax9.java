package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.tu9;
import com.repackage.uu9;
/* loaded from: classes5.dex */
public final class ax9<T> extends uu9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final T b;

    /* loaded from: classes5.dex */
    public class a implements uu9.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;

        public a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }

        @Override // com.repackage.uu9.c, com.repackage.ev9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((vu9) ((vu9) obj));
        }

        public void call(vu9<? super T> vu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vu9Var) == null) {
                vu9Var.c((Object) this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b<T> implements uu9.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final lw9 a;
        public final T b;

        public b(lw9 lw9Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw9Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lw9Var;
            this.b = t;
        }

        @Override // com.repackage.uu9.c, com.repackage.ev9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((vu9) ((vu9) obj));
        }

        public void call(vu9<? super T> vu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vu9Var) == null) {
                vu9Var.a(this.a.a(new d(vu9Var, this.b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c<T> implements uu9.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final tu9 a;
        public final T b;

        public c(tu9 tu9Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu9Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tu9Var;
            this.b = t;
        }

        @Override // com.repackage.uu9.c, com.repackage.ev9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((vu9) ((vu9) obj));
        }

        public void call(vu9<? super T> vu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vu9Var) == null) {
                tu9.a createWorker = this.a.createWorker();
                vu9Var.a(createWorker);
                createWorker.b(new d(vu9Var, this.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d<T> implements dv9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final vu9<? super T> a;
        public final T b;

        public d(vu9<? super T> vu9Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu9Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vu9Var;
            this.b = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // com.repackage.dv9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.c((T) this.b);
                } catch (Throwable th) {
                    this.a.b(th);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax9(T t) {
        super(new a(t));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((uu9.c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = t;
    }

    public static <T> ax9<T> m(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, t)) == null) ? new ax9<>(t) : (ax9) invokeL.objValue;
    }

    public uu9<T> n(tu9 tu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tu9Var)) == null) {
            if (tu9Var instanceof lw9) {
                return uu9.b(new b((lw9) tu9Var, this.b));
            }
            return uu9.b(new c(tu9Var, this.b));
        }
        return (uu9) invokeL.objValue;
    }
}
