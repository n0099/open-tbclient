package com.repackage;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.cpu.booster.utils.CpuType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes5.dex */
public class dl3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dl3 d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<el3> a;
    public boolean b;
    public Timer c;

    /* loaded from: classes5.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl3 a;

        public a(dl3 dl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dl3Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-439375192, "Lcom/repackage/dl3$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-439375192, "Lcom/repackage/dl3$b;");
                    return;
                }
            }
            int[] iArr = new int[CpuType.values().length];
            a = iArr;
            try {
                iArr[CpuType.Mtk.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CpuType.QualComm.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CpuType.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755763610, "Lcom/repackage/dl3;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755763610, "Lcom/repackage/dl3;");
        }
    }

    public dl3(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        long currentTimeMillis = e ? System.currentTimeMillis() : 0L;
        a(context.getApplicationContext());
        if (e) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("CPU-Booster", "collect booster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            e = z;
        }
    }

    public static dl3 d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (d == null) {
                synchronized (dl3.class) {
                    if (d == null) {
                        d = new dl3(context);
                    }
                }
            }
            return d;
        }
        return (dl3) invokeL.objValue;
    }

    public static void e(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            if (e) {
                Log.d("CPU-Booster", "cpu-booster preInit");
            }
            d(context);
        }
    }

    public final void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (sl3.a()) {
                this.a.add(new fl3(context));
                this.a.add(new hl3(context));
            } else if (sl3.b()) {
                this.a.add(new nl3(context));
            }
            int i = b.a[rl3.h().ordinal()];
            if (i == 1) {
                this.a.add(new ll3(context));
            } else if (i != 2) {
            } else {
                this.a.add(new pl3(context));
            }
        }
    }

    public final int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < 0) {
                return 200;
            }
            return Math.min(i, 5000);
        }
        return invokeI.intValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && e) {
            int e2 = rl3.e();
            StringBuilder sb = new StringBuilder(" \n\n");
            sb.append("CPU Support Freq Info:\n");
            for (int i = 0; i < e2; i++) {
                jl3 a2 = rl3.a(i);
                sb.append("CPU");
                sb.append(a2.a);
                sb.append(":");
                sb.append("min-");
                sb.append(a2.b / 1000);
                sb.append("mHz, max-");
                sb.append(a2.c / 1000);
                sb.append("mHz\n");
            }
            sb.append("\n\n");
            sb.append("CPU Current Freq:\n");
            for (int i2 = 0; i2 < e2; i2++) {
                sb.append("CPU");
                sb.append(i2);
                sb.append(":");
                sb.append(rl3.j(i2) / 1000);
                sb.append("mHz");
                sb.append("\n");
            }
            if (e) {
                Log.d("CPU-Booster", sb.toString());
            }
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                h(3000);
            }
        }
    }

    public synchronized void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            synchronized (this) {
                if (this.b) {
                    if (e) {
                        Log.d("CPU-Booster", "start fail -> isEnabled - true, already start - " + this.b);
                    }
                    return;
                }
                if (e) {
                    Log.d("CPU-Booster", "startBooster");
                }
                this.b = true;
                int c = c(i);
                long currentTimeMillis = e ? System.currentTimeMillis() : 0L;
                for (el3 el3Var : this.a) {
                    el3Var.b(c);
                }
                if (this.c == null) {
                    Timer timer = new Timer();
                    this.c = timer;
                    timer.schedule(new a(this), c);
                }
                if (e) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("CPU-Booster", "start booster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                    f();
                }
            }
        }
    }

    public synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (this.b) {
                    if (e) {
                        Log.d("CPU-Booster", "stopBooster");
                    }
                    long currentTimeMillis = e ? System.currentTimeMillis() : 0L;
                    for (el3 el3Var : this.a) {
                        el3Var.a();
                    }
                    this.b = false;
                    if (this.c != null) {
                        this.c.cancel();
                        this.c = null;
                    }
                    if (e) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        Log.d("CPU-Booster", "stop booster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                    }
                }
            }
        }
    }
}
