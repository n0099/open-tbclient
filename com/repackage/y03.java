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
import com.repackage.cm2;
import com.repackage.d13;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class y03 extends v03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static volatile y03 j;
    public static Handler k;
    public transient /* synthetic */ FieldHolder $fh;
    public ci1 a;
    public final Set<sf3<d13.a>> b;
    public volatile int c;
    public final Queue<Runnable> d;
    public Runnable e;
    public ga4 f;
    public j33 g;
    public boolean h;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d13.a a;
        public final /* synthetic */ y03 b;

        /* renamed from: com.repackage.y03$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0630a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ sf3 a;
            public final /* synthetic */ a b;

            public RunnableC0630a(a aVar, sf3 sf3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, sf3Var};
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
                this.a = sf3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a(this.b.a);
                }
            }
        }

        public a(y03 y03Var, d13.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y03Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y03Var;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (sf3 sf3Var : this.b.b) {
                    if (z && !this.a.e("event_flag_force_post", false)) {
                        sf3Var.a(this.a);
                    } else {
                        y03.M().post(new RunnableC0630a(this, sf3Var));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf3 a;
        public final /* synthetic */ y03 b;

        public b(y03 y03Var, sf3 sf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y03Var, sf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y03Var;
            this.a = sf3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.add(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf3 a;
        public final /* synthetic */ y03 b;

        public c(y03 y03Var, sf3 sf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y03Var, sf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y03Var;
            this.a = sf3Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755195659, "Lcom/repackage/y03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755195659, "Lcom/repackage/y03;");
                return;
            }
        }
        i = jh1.a;
    }

    public y03() {
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
        new cm2.a();
        this.b = new HashSet();
        this.c = 0;
        this.d = new ArrayDeque();
        this.e = null;
        this.h = false;
    }

    public static y03 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            y03 L = L();
            if (!L.h) {
                L.O();
            }
            return L;
        }
        return (y03) invokeV.objValue;
    }

    public static y03 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (j instanceof e13) {
                return j;
            }
            synchronized (y03.class) {
                if (j instanceof e13) {
                    return j;
                }
                SwanAppProcessInfo current = SwanAppProcessInfo.current();
                if (current.isSwanClient) {
                    if (i && j != null) {
                        throw new IllegalStateException("When convinced current process is swan client，but Swan instance already init with: " + j);
                    }
                    j = new e13();
                    return j;
                } else if (current.isSwanService) {
                    if (!(j instanceof g13)) {
                        if (i && j != null) {
                            throw new IllegalStateException("When convinced current process is swan service，but Swan instance already init with: " + j);
                        }
                        j = new g13();
                    }
                    return j;
                } else {
                    if (j == null) {
                        j = new x03();
                    }
                    return j;
                }
            }
        }
        return (y03) invokeV.objValue;
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

    @Override // com.repackage.c13
    public void A(d13.a aVar) {
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

    @Override // com.repackage.c13
    public j33 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.g == null) {
                this.g = J();
            }
            return this.g;
        }
        return (j33) invokeV.objValue;
    }

    public abstract ga4 I();

    public abstract j33 J();

    public ga4 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f == null) {
                this.f = I();
            }
            return this.f;
        }
        return (ga4) invokeV.objValue;
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.h) {
            return;
        }
        P();
        N();
        lx2.S();
        Q();
        this.h = true;
    }

    public final void P() {
        j33 B;
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

    @Override // com.repackage.c13
    public void o(sf3<d13.a> sf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, sf3Var) == null) || sf3Var == null) {
            return;
        }
        R(new c(this, sf3Var));
    }

    @Override // com.repackage.c13
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            v(str, null);
        }
    }

    @Override // com.repackage.c13
    public void u(sf3<d13.a> sf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, sf3Var) == null) || sf3Var == null) {
            return;
        }
        R(new b(this, sf3Var));
    }

    @Override // com.repackage.c13
    public void v(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, bundle) == null) {
            A(new d13.a(str, bundle));
        }
    }

    @Override // com.repackage.c13
    public ci1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.a == null) {
                this.a = new ci1();
            }
            return this.a;
        }
        return (ci1) invokeV.objValue;
    }
}
