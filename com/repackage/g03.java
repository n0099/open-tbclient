package com.repackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kl2;
import com.repackage.l03;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class g03 extends d03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static volatile g03 j;
    public static Handler k;
    public transient /* synthetic */ FieldHolder $fh;
    public kh1 a;
    public final Set<af3<l03.a>> b;
    public volatile int c;
    public final Queue<Runnable> d;
    public Runnable e;
    public o94 f;
    public r23 g;
    public boolean h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l03.a a;
        public final /* synthetic */ g03 b;

        /* renamed from: com.repackage.g03$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0643a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ af3 a;
            public final /* synthetic */ a b;

            public RunnableC0643a(a aVar, af3 af3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, af3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = af3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a(this.b.a);
                }
            }
        }

        public a(g03 g03Var, l03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g03Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g03Var;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (af3 af3Var : this.b.b) {
                    if (z && !this.a.e("event_flag_force_post", false)) {
                        af3Var.a(this.a);
                    } else {
                        g03.M().post(new RunnableC0643a(this, af3Var));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af3 a;
        public final /* synthetic */ g03 b;

        public b(g03 g03Var, af3 af3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g03Var, af3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g03Var;
            this.a = af3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.add(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af3 a;
        public final /* synthetic */ g03 b;

        public c(g03 g03Var, af3 af3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g03Var, af3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g03Var;
            this.a = af3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.remove(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755731897, "Lcom/repackage/g03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755731897, "Lcom/repackage/g03;");
                return;
            }
        }
        i = rg1.a;
    }

    public g03() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new kl2.a();
        this.b = new HashSet();
        this.c = 0;
        this.d = new ArrayDeque();
        this.e = null;
        this.h = false;
    }

    public static g03 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            g03 L = L();
            if (!L.h) {
                L.O();
            }
            return L;
        }
        return (g03) invokeV.objValue;
    }

    public static g03 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (j instanceof m03) {
                return j;
            }
            synchronized (g03.class) {
                if (j instanceof m03) {
                    return j;
                }
                SwanAppProcessInfo current = SwanAppProcessInfo.current();
                if (current.isSwanClient) {
                    if (i && j != null) {
                        throw new IllegalStateException("When convinced current process is swan client，but Swan instance already init with: " + j);
                    }
                    j = new m03();
                    return j;
                } else if (current.isSwanService) {
                    if (!(j instanceof o03)) {
                        if (i && j != null) {
                            throw new IllegalStateException("When convinced current process is swan service，but Swan instance already init with: " + j);
                        }
                        j = new o03();
                    }
                    return j;
                } else {
                    if (j == null) {
                        j = new f03();
                    }
                    return j;
                }
            }
        }
        return (g03) invokeV.objValue;
    }

    public static Handler M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (k == null) {
                k = new Handler(Looper.getMainLooper());
            }
            return k;
        }
        return (Handler) invokeV.objValue;
    }

    @Override // com.repackage.k03
    public void A(l03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (i) {
                Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.b.size());
            }
            if (aVar != null) {
                R(new a(this, aVar));
            }
        }
    }

    @Override // com.repackage.k03
    public r23 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.g == null) {
                this.g = J();
            }
            return this.g;
        }
        return (r23) invokeV.objValue;
    }

    public abstract o94 I();

    public abstract r23 J();

    public o94 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f == null) {
                this.f = I();
            }
            return this.f;
        }
        return (o94) invokeV.objValue;
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.h) {
            return;
        }
        P();
        N();
        tw2.S();
        Q();
        this.h = true;
    }

    public final void P() {
        r23 B;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (B = B()) == null) {
            return;
        }
        B.J();
    }

    public abstract void Q();

    public final synchronized void R(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, runnable) == null) {
            synchronized (this) {
                this.d.offer(runnable);
                if (this.e == null) {
                    while (!this.d.isEmpty()) {
                        Runnable poll = this.d.poll();
                        this.e = poll;
                        if (poll != null) {
                            poll.run();
                        }
                        this.e = null;
                    }
                }
            }
        }
    }

    @Override // com.repackage.k03
    public void o(af3<l03.a> af3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, af3Var) == null) || af3Var == null) {
            return;
        }
        R(new c(this, af3Var));
    }

    @Override // com.repackage.k03
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            v(str, null);
        }
    }

    @Override // com.repackage.k03
    public void u(af3<l03.a> af3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, af3Var) == null) || af3Var == null) {
            return;
        }
        R(new b(this, af3Var));
    }

    @Override // com.repackage.k03
    public void v(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, bundle) == null) {
            A(new l03.a(str, bundle));
        }
    }

    @Override // com.repackage.k03
    public kh1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.a == null) {
                this.a = new kh1();
            }
            return this.a;
        }
        return (kh1) invokeV.objValue;
    }
}
