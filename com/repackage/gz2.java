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
import com.repackage.kk2;
import com.repackage.lz2;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class gz2 extends dz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static volatile gz2 j;
    public static Handler k;
    public transient /* synthetic */ FieldHolder $fh;
    public kg1 a;
    public final Set<ae3<lz2.a>> b;
    public volatile int c;
    public final Queue<Runnable> d;
    public Runnable e;
    public o84 f;
    public r13 g;
    public boolean h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lz2.a a;
        public final /* synthetic */ gz2 b;

        /* renamed from: com.repackage.gz2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0437a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ae3 a;
            public final /* synthetic */ a b;

            public RunnableC0437a(a aVar, ae3 ae3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ae3Var};
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
                this.a = ae3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.onCallback(this.b.a);
                }
            }
        }

        public a(gz2 gz2Var, lz2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz2Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gz2Var;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (ae3 ae3Var : this.b.b) {
                    if (z && !this.a.e("event_flag_force_post", false)) {
                        ae3Var.onCallback(this.a);
                    } else {
                        gz2.L().post(new RunnableC0437a(this, ae3Var));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae3 a;
        public final /* synthetic */ gz2 b;

        public b(gz2 gz2Var, ae3 ae3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz2Var, ae3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gz2Var;
            this.a = ae3Var;
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
        public final /* synthetic */ ae3 a;
        public final /* synthetic */ gz2 b;

        public c(gz2 gz2Var, ae3 ae3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz2Var, ae3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gz2Var;
            this.a = ae3Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755660814, "Lcom/repackage/gz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755660814, "Lcom/repackage/gz2;");
                return;
            }
        }
        i = rf1.a;
    }

    public gz2() {
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
        new kk2.a();
        this.b = new HashSet();
        this.c = 0;
        this.d = new ArrayDeque();
        this.e = null;
        this.h = false;
    }

    public static gz2 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            gz2 K = K();
            if (!K.h) {
                K.N();
            }
            return K;
        }
        return (gz2) invokeV.objValue;
    }

    public static gz2 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (j instanceof mz2) {
                return j;
            }
            synchronized (gz2.class) {
                if (j instanceof mz2) {
                    return j;
                }
                SwanAppProcessInfo current = SwanAppProcessInfo.current();
                if (current.isSwanClient) {
                    if (i && j != null) {
                        throw new IllegalStateException("When convinced current process is swan client，but Swan instance already init with: " + j);
                    }
                    j = new mz2();
                    return j;
                } else if (current.isSwanService) {
                    if (!(j instanceof oz2)) {
                        if (i && j != null) {
                            throw new IllegalStateException("When convinced current process is swan service，but Swan instance already init with: " + j);
                        }
                        j = new oz2();
                    }
                    return j;
                } else {
                    if (j == null) {
                        j = new fz2();
                    }
                    return j;
                }
            }
        }
        return (gz2) invokeV.objValue;
    }

    public static Handler L() {
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

    @Override // com.repackage.kz2
    public void A(lz2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (i) {
                Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.b.size());
            }
            if (aVar != null) {
                Q(new a(this, aVar));
            }
        }
    }

    @Override // com.repackage.kz2
    public r13 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.g == null) {
                this.g = I();
            }
            return this.g;
        }
        return (r13) invokeV.objValue;
    }

    public abstract o84 H();

    public abstract r13 I();

    public o84 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f == null) {
                this.f = H();
            }
            return this.f;
        }
        return (o84) invokeV.objValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.h) {
            return;
        }
        O();
        M();
        tv2.R();
        P();
        this.h = true;
    }

    public final void O() {
        r13 B;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (B = B()) == null) {
            return;
        }
        B.I();
    }

    public abstract void P();

    public final synchronized void Q(@NonNull Runnable runnable) {
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

    @Override // com.repackage.kz2
    public void p(ae3<lz2.a> ae3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, ae3Var) == null) || ae3Var == null) {
            return;
        }
        Q(new c(this, ae3Var));
    }

    @Override // com.repackage.kz2
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            w(str, null);
        }
    }

    @Override // com.repackage.kz2
    public void v(ae3<lz2.a> ae3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, ae3Var) == null) || ae3Var == null) {
            return;
        }
        Q(new b(this, ae3Var));
    }

    @Override // com.repackage.kz2
    public void w(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, bundle) == null) {
            A(new lz2.a(str, bundle));
        }
    }

    @Override // com.repackage.kz2
    public kg1 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.a == null) {
                this.a = new kg1();
            }
            return this.a;
        }
        return (kg1) invokeV.objValue;
    }
}
