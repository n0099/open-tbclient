package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xr9;
import com.repackage.yr9;
/* loaded from: classes6.dex */
public final class eu9<T> extends yr9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final T b;

    /* loaded from: classes6.dex */
    public class a implements yr9.c<T> {
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

        @Override // com.repackage.yr9.c, com.repackage.is9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((zr9) ((zr9) obj));
        }

        public void call(zr9<? super T> zr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zr9Var) == null) {
                zr9Var.c((Object) this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b<T> implements yr9.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final pt9 a;
        public final T b;

        public b(pt9 pt9Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pt9Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pt9Var;
            this.b = t;
        }

        @Override // com.repackage.yr9.c, com.repackage.is9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((zr9) ((zr9) obj));
        }

        public void call(zr9<? super T> zr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zr9Var) == null) {
                zr9Var.a(this.a.a(new d(zr9Var, this.b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c<T> implements yr9.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final xr9 a;
        public final T b;

        public c(xr9 xr9Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xr9Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xr9Var;
            this.b = t;
        }

        @Override // com.repackage.yr9.c, com.repackage.is9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((zr9) ((zr9) obj));
        }

        public void call(zr9<? super T> zr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zr9Var) == null) {
                xr9.a createWorker = this.a.createWorker();
                zr9Var.a(createWorker);
                createWorker.b(new d(zr9Var, this.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d<T> implements hs9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final zr9<? super T> a;
        public final T b;

        public d(zr9<? super T> zr9Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zr9Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zr9Var;
            this.b = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // com.repackage.hs9
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
    public eu9(T t) {
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
                super((yr9.c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = t;
    }

    public static <T> eu9<T> m(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, t)) == null) ? new eu9<>(t) : (eu9) invokeL.objValue;
    }

    public yr9<T> n(xr9 xr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xr9Var)) == null) {
            if (xr9Var instanceof pt9) {
                return yr9.b(new b((pt9) xr9Var, this.b));
            }
            return yr9.b(new c(xr9Var, this.b));
        }
        return (yr9) invokeL.objValue;
    }
}
