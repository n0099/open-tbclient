package com.repackage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.za4;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class v94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w94 a;
    public BlockingQueue<Runnable> b;
    public ThreadPoolExecutor c;
    public ha4 d;
    public final AtomicBoolean e;
    @SuppressLint({"SyntheticAccessor"})
    public final da4 f;
    public final na4 g;
    public ca4 h;

    /* loaded from: classes7.dex */
    public class a implements da4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v94 a;

        public a(v94 v94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v94Var;
        }

        @Override // com.repackage.da4
        public <T> void a(ha4<T> ha4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ha4Var) == null) {
                this.a.d = ha4Var;
            }
        }

        @Override // com.repackage.da4
        public <T> void b(ha4<T> ha4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ha4Var) == null) && this.a.d == ha4Var) {
                this.a.d = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ca4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v94 a;

        public b(v94 v94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v94Var;
        }

        @Override // com.repackage.ca4
        public Runnable a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? this.a.d(z) : (Runnable) invokeZ.objValue;
        }
    }

    public v94() {
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
        this.e = new AtomicBoolean(false);
        this.f = new a(this);
        this.g = new na4(this.f);
        this.h = new b(this);
        this.a = new w94();
        this.b = new LinkedBlockingQueue();
        this.c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.b);
        c(this.a);
    }

    public void c(da4 da4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, da4Var) == null) {
            this.g.c(da4Var);
        }
    }

    public synchronized Runnable d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            synchronized (this) {
                if (this.a != null) {
                    if (z) {
                        return this.a.g();
                    }
                    return this.a.i();
                }
                return null;
            }
        }
        return (Runnable) invokeZ.objValue;
    }

    public synchronized boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                if (this.d == null) {
                    return false;
                }
                Object f = this.d.f();
                if (f instanceof e94) {
                    return TextUtils.equals(((e94) f).g, str);
                }
                if (f instanceof za4.a) {
                    return TextUtils.equals(((za4.a) f).b, str);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                Iterator<ha4> f = this.a.f();
                while (f.hasNext()) {
                    ha4 next = f.next();
                    if (next != null) {
                        Object f2 = next.f();
                        if (f2 instanceof e94) {
                            if (TextUtils.equals(((e94) f2).g, str)) {
                                return true;
                            }
                        } else if ((f2 instanceof za4.a) && TextUtils.equals(((za4.a) f2).b, str)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized <T> void g(ha4<T> ha4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ha4Var) == null) {
            synchronized (this) {
                this.a.h(ha4Var);
            }
        }
    }

    public synchronized <T> void h(ha4<T> ha4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ha4Var) == null) {
            synchronized (this) {
                g(ha4Var);
                j();
            }
        }
    }

    public void i(da4 da4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, da4Var) == null) {
            this.g.d(da4Var);
        }
    }

    public synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.b.size() < 1) {
                    this.c.execute(new ia4(this.e, this.g, this.h));
                }
            }
        }
    }
}
