package d.a.q0.a.r1.r;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import androidx.annotation.NonNull;
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
import d.a.q0.a.a2.d;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public class a implements d.a.q0.a.r1.r.c.a, d.a.q0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50494b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<c> f50495c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownTimer f50496d;

    /* renamed from: d.a.q0.a.r1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class CountDownTimerC0931a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f50497a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CountDownTimerC0931a(a aVar, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50497a = aVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.q0.a.f1.f.a.f47786a) {
                    Log.d("SwanPerformance", "count down onFinish");
                }
                this.f50497a.c(true);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                Iterator it = this.f50497a.f50495c.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    boolean z = ((long) (5000 - cVar.e())) >= j;
                    if (!cVar.g() && z) {
                        cVar.h(true);
                        d.a.q0.a.r1.r.c.a f2 = cVar.f();
                        if (d.a.q0.a.f1.f.a.f47786a) {
                            Log.e("SwanPerformance", "triggerFmp, timeout = " + cVar.e() + ", trigger = " + f2.getName());
                        }
                        f2.c(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f50498a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(464132976, "Ld/a/q0/a/r1/r/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(464132976, "Ld/a/q0/a/r1/r/a$b;");
                    return;
                }
            }
            f50498a = new a(null);
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.q0.a.r1.r.c.a f50499a;

        /* renamed from: b  reason: collision with root package name */
        public int f50500b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f50501c;

        public /* synthetic */ c(a aVar, d.a.q0.a.r1.r.c.a aVar2, int i2, CountDownTimerC0931a countDownTimerC0931a) {
            this(aVar, aVar2, i2);
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50500b : invokeV.intValue;
        }

        @NonNull
        public final d.a.q0.a.r1.r.c.a f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50499a : (d.a.q0.a.r1.r.c.a) invokeV.objValue;
        }

        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50501c : invokeV.booleanValue;
        }

        public final void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f50501c = z;
            }
        }

        public c(@NonNull a aVar, d.a.q0.a.r1.r.c.a aVar2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50501c = false;
            this.f50499a = aVar2;
            this.f50500b = i2;
        }
    }

    public /* synthetic */ a(CountDownTimerC0931a countDownTimerC0931a) {
        this();
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f50498a : (a) invokeV.objValue;
    }

    @Override // d.a.q0.a.r1.r.c.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (d.a.q0.a.f1.f.a.f47786a) {
                Log.e("SwanPerformance", "triggerFcp, url = " + str);
            }
            Iterator<c> it = this.f50495c.iterator();
            while (it.hasNext()) {
                it.next().f().a(str);
            }
        }
    }

    @Override // d.a.q0.a.r1.r.c.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f50495c.isEmpty()) {
            return;
        }
        if (d.a.q0.a.f1.f.a.f47786a) {
            Log.e("SwanPerformance", "triggerDestroy");
        }
        j();
        Iterator<c> it = this.f50495c.iterator();
        while (it.hasNext()) {
            it.next().f().b();
        }
        this.f50494b = false;
    }

    @Override // d.a.q0.a.r1.r.c.a
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f50494b) {
            return;
        }
        this.f50494b = true;
        j();
        if (this.f50495c.isEmpty()) {
            return;
        }
        if (d.a.q0.a.f1.f.a.f47786a) {
            Log.e("SwanPerformance", "triggerFmp, timeout = " + z);
        }
        Iterator<c> it = this.f50495c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!next.g()) {
                next.h(true);
                next.f().c(z);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_timeout", z);
        bundle.putString("app_id", d.g().getAppId());
        d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
        d.a.q0.a.v1.c.c cVar = new d.a.q0.a.v1.c.c(23, bundle);
        cVar.f(true);
        e2.h(cVar);
    }

    @Override // d.a.q0.a.r1.r.c.a
    @UiThread
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f50494b = false;
            if (this.f50495c.isEmpty()) {
                return;
            }
            if (d.a.q0.a.f1.f.a.f47786a) {
                Log.e("SwanPerformance", "triggerLaunch, source = " + str);
            }
            Iterator<c> it = this.f50495c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                next.h(false);
                next.f().d(str);
            }
            j();
            i();
        }
    }

    public boolean g(d.a.q0.a.r1.r.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            if (aVar == null) {
                return false;
            }
            Iterator<c> it = this.f50495c.iterator();
            while (it.hasNext()) {
                if (aVar.equals(it.next().f())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.a.r1.r.c.a
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SwanLaunchTriggerMgr" : (String) invokeV.objValue;
    }

    public void h(d.a.q0.a.r1.r.c.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, aVar, i2) == null) || this.f50494b || aVar == null) {
            return;
        }
        if (i2 > 5000) {
            i2 = 5000;
        }
        if (g(aVar)) {
            return;
        }
        this.f50495c.add(new c(this, aVar, i2, null));
        if (d.a.q0.a.f1.f.a.f47786a) {
            Log.e("SwanPerformance", "register, task name = " + aVar.getName() + " ; timeout = " + i2);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.f50496d.start();
            } catch (Throwable th) {
                if (d.a.q0.a.f1.f.a.f47786a) {
                    Log.d("SwanPerformance", "start timer exception = " + th.getMessage());
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.f50496d.cancel();
            } catch (Throwable th) {
                if (d.a.q0.a.f1.f.a.f47786a) {
                    Log.d("SwanPerformance", "stop timer exception = " + th.getMessage());
                }
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50494b = false;
        this.f50495c = new CopyOnWriteArrayList<>();
        this.f50496d = new CountDownTimerC0931a(this, 5000L, 500L);
    }
}
