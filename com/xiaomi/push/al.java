package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class al {
    public static /* synthetic */ Interceptable $ic;
    public static volatile al a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f88a;

    /* renamed from: a  reason: collision with other field name */
    public Object f89a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, ScheduledFuture> f90a;

    /* renamed from: a  reason: collision with other field name */
    public ScheduledThreadPoolExecutor f91a;

    /* loaded from: classes8.dex */
    public static abstract class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* renamed from: a */
        public abstract String mo202a();
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a();
                this.a.run();
                b();
            }
        }
    }

    public al(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f91a = new ScheduledThreadPoolExecutor(1);
        this.f90a = new HashMap();
        this.f89a = new Object();
        this.f88a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static al a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (a == null) {
                synchronized (al.class) {
                    if (a == null) {
                        a = new al(context);
                    }
                }
            }
            return a;
        }
        return (al) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return "last_job_time" + str;
        }
        return (String) invokeL.objValue;
    }

    private ScheduledFuture a(a aVar) {
        InterceptResult invokeL;
        ScheduledFuture scheduledFuture;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, aVar)) == null) {
            synchronized (this.f89a) {
                scheduledFuture = this.f90a.get(aVar.mo202a());
            }
            return scheduledFuture;
        }
        return (ScheduledFuture) invokeL.objValue;
    }

    public void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            a(runnable, 0);
        }
    }

    public void a(Runnable runnable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, i) == null) {
            this.f91a.schedule(runnable, i, TimeUnit.SECONDS);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m161a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) ? b(aVar, 0) : invokeL.booleanValue;
    }

    public boolean a(a aVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, aVar, i)) == null) ? a(aVar, i, 0) : invokeLI.booleanValue;
    }

    public boolean a(a aVar, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, aVar, i, i2)) == null) ? a(aVar, i, i2, false) : invokeLII.booleanValue;
    }

    public boolean a(a aVar, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{aVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (aVar == null || a(aVar) != null) {
                return false;
            }
            String a2 = a(aVar.mo202a());
            am amVar = new am(this, aVar, z, a2);
            if (!z) {
                long abs = Math.abs(System.currentTimeMillis() - this.f88a.getLong(a2, 0L)) / 1000;
                if (abs < i - i2) {
                    i2 = (int) (i - abs);
                }
            }
            try {
                ScheduledFuture<?> scheduleAtFixedRate = this.f91a.scheduleAtFixedRate(amVar, i2, i, TimeUnit.SECONDS);
                synchronized (this.f89a) {
                    this.f90a.put(aVar.mo202a(), scheduleAtFixedRate);
                }
                return true;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m162a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            synchronized (this.f89a) {
                ScheduledFuture scheduledFuture = this.f90a.get(str);
                if (scheduledFuture == null) {
                    return false;
                }
                this.f90a.remove(str);
                return scheduledFuture.cancel(false);
            }
        }
        return invokeL.booleanValue;
    }

    public boolean b(a aVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, aVar, i)) == null) {
            if (aVar == null || a(aVar) != null) {
                return false;
            }
            ScheduledFuture<?> schedule = this.f91a.schedule(new an(this, aVar), i, TimeUnit.SECONDS);
            synchronized (this.f89a) {
                this.f90a.put(aVar.mo202a(), schedule);
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
