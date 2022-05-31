package com.repackage;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class bu2 implements du2, lk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean c;
    public CopyOnWriteArrayList<c> d;
    public CountDownTimer e;

    /* loaded from: classes5.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu2 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bu2 bu2Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu2Var, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu2Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (lk2.a) {
                    Log.d("SwanPerformance", "count down onFinish");
                }
                this.a.d(true);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                Iterator it = this.a.d.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    boolean z = ((long) (5000 - cVar.e())) >= j;
                    if (!cVar.g() && z) {
                        cVar.h(true);
                        du2 f = cVar.f();
                        if (lk2.a) {
                            Log.e("SwanPerformance", "triggerFmp, timeout = " + cVar.e() + ", trigger = " + f.getName());
                        }
                        f.d(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final bu2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-488351596, "Lcom/repackage/bu2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-488351596, "Lcom/repackage/bu2$b;");
                    return;
                }
            }
            a = new bu2(null);
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public du2 a;
        public int b;
        public boolean c;

        public /* synthetic */ c(bu2 bu2Var, du2 du2Var, int i, a aVar) {
            this(bu2Var, du2Var, i);
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.intValue;
        }

        @NonNull
        public final du2 f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (du2) invokeV.objValue;
        }

        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : invokeV.booleanValue;
        }

        public final void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.c = z;
            }
        }

        public c(@NonNull bu2 bu2Var, du2 du2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu2Var, du2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = false;
            this.a = du2Var;
            this.b = i;
        }
    }

    public /* synthetic */ bu2(a aVar) {
        this();
    }

    public static bu2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (bu2) invokeV.objValue;
    }

    @Override // com.repackage.du2
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (lk2.a) {
                Log.e("SwanPerformance", "triggerFcp, url = " + str);
            }
            Iterator<c> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().f().a(str);
            }
        }
    }

    @Override // com.repackage.du2
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.d.isEmpty()) {
            return;
        }
        if (lk2.a) {
            Log.e("SwanPerformance", "triggerDestroy");
        }
        k();
        Iterator<c> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().f().b();
        }
        this.c = false;
    }

    @Override // com.repackage.du2
    public void c(@NonNull Runnable runnable, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
        }
    }

    @Override // com.repackage.du2
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.c) {
            return;
        }
        this.c = true;
        k();
        if (this.d.isEmpty()) {
            return;
        }
        if (lk2.a) {
            Log.e("SwanPerformance", "triggerFmp, timeout = " + z);
        }
        Iterator<c> it = this.d.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!next.g()) {
                next.h(true);
                next.f().d(z);
            }
        }
        a63.p();
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_timeout", z);
        bundle.putString("app_id", gz2.J().getAppId());
        xv2 e = xv2.e();
        zv2 zv2Var = new zv2(23, bundle);
        zv2Var.f(true);
        e.h(zv2Var);
    }

    @Override // com.repackage.du2
    @UiThread
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (it2.k()) {
                a63.a0(it2.j());
            }
            this.c = false;
            if (this.d.isEmpty()) {
                return;
            }
            if (lk2.a) {
                Log.e("SwanPerformance", "triggerLaunch, source = " + str);
            }
            Iterator<c> it = this.d.iterator();
            while (it.hasNext()) {
                c next = it.next();
                next.h(false);
                next.f().e(str);
            }
            k();
            j();
        }
    }

    @Override // com.repackage.du2
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SwanLaunchTriggerMgr" : (String) invokeV.objValue;
    }

    public boolean h(du2 du2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, du2Var)) == null) {
            if (du2Var == null) {
                return false;
            }
            Iterator<c> it = this.d.iterator();
            while (it.hasNext()) {
                if (du2Var.equals(it.next().f())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i(du2 du2Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, du2Var, i) == null) || this.c || du2Var == null) {
            return;
        }
        if (i > 5000) {
            i = 5000;
        }
        if (h(du2Var)) {
            return;
        }
        this.d.add(new c(this, du2Var, i, null));
        if (lk2.a) {
            Log.e("SwanPerformance", "register, task name = " + du2Var.getName() + " ; timeout = " + i);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.e.start();
            } catch (Throwable th) {
                if (lk2.a) {
                    Log.d("SwanPerformance", "start timer exception = " + th.getMessage());
                }
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                this.e.cancel();
            } catch (Throwable th) {
                if (lk2.a) {
                    Log.d("SwanPerformance", "stop timer exception = " + th.getMessage());
                }
            }
        }
    }

    public bu2() {
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
        this.c = false;
        this.d = new CopyOnWriteArrayList<>();
        this.e = new a(this, 5000L, 500L);
    }
}
