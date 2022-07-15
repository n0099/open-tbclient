package com.repackage;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.q10;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes7.dex */
public class u10 extends q10 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile com.baidu.helios.bridge.multiprocess.g c;
    public volatile s10 d;
    public volatile boolean e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile Future<Boolean> h;
    public volatile Future<Boolean> i;
    public volatile boolean j;
    public String k;
    public Object l;
    public Object m;

    /* loaded from: classes7.dex */
    public class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u10 a;

        public a(u10 u10Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u10Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u10Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.d = new s10();
                this.a.d.b(this.a.a);
                this.a.d.c(this.a.b);
                this.a.f = true;
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u10 a;

        public b(u10 u10Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u10Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u10Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                u10 u10Var = this.a;
                u10Var.c = new com.baidu.helios.bridge.multiprocess.g(u10Var, u10Var.k);
                this.a.c.b(this.a.a);
                this.a.c.c(this.a.b);
                this.a.g = true;
                if (this.a.c.o()) {
                    this.a.j = true;
                    return Boolean.TRUE;
                }
                this.a.j = false;
                this.a.e = false;
                this.a.n();
                return Boolean.FALSE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    public u10(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new Object();
        this.m = new Object();
        this.e = true;
        this.f = false;
        this.k = str;
    }

    @Override // com.repackage.q10
    public void a(String str, Bundle bundle, q10.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            if (this.e) {
                w();
                if (this.j) {
                    this.c.a(str, bundle, cVar);
                    return;
                }
            }
            t();
            this.d.a(str, bundle, cVar);
        }
    }

    @Override // com.repackage.q10
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.e) {
                w();
                if (this.j && this.c != null) {
                    this.c.d();
                    return;
                }
            }
            t();
            if (this.d != null) {
                this.d.d();
            }
        }
    }

    @Override // com.repackage.q10
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.e) {
                w();
                if (this.j) {
                    return this.c.e(str);
                }
            }
            t();
            return this.d.e(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.q10
    public void f(q10.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (this.e) {
                synchronized (this.l) {
                    p();
                }
                return;
            }
            synchronized (this.m) {
                n();
            }
        }
    }

    @Override // com.repackage.q10
    public q10.d g(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bundle)) == null) {
            if (this.e) {
                w();
                if (this.j) {
                    q10.d g = this.c.g(str, bundle);
                    if (g.b()) {
                        return g;
                    }
                    this.e = false;
                }
            }
            t();
            return this.d.g(str, bundle);
        }
        return (q10.d) invokeLL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e = false;
            n();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !this.f && this.i == null) {
            this.i = this.a.d.submit(new a(this));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.g && this.h == null) {
            this.h = this.a.d.submit(new b(this));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.e || this.f) {
            return;
        }
        synchronized (this.m) {
            n();
        }
        try {
            this.i.get();
        } catch (Exception unused) {
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.e) {
            if (!this.g) {
                synchronized (this.l) {
                    p();
                }
            }
            try {
                this.h.get();
            } catch (Exception unused) {
            }
        }
    }
}
