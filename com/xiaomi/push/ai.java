package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
public class ai {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile ai f42822a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f106a;

    /* renamed from: a  reason: collision with other field name */
    public Object f107a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, ScheduledFuture> f108a;

    /* renamed from: a  reason: collision with other field name */
    public ScheduledThreadPoolExecutor f109a;

    /* loaded from: classes8.dex */
    public static abstract class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* renamed from: a */
        public abstract String mo184a();
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a f42823a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42823a = aVar;
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
                this.f42823a.run();
                b();
            }
        }
    }

    public ai(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f109a = new ScheduledThreadPoolExecutor(1);
        this.f108a = new HashMap();
        this.f107a = new Object();
        this.f106a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static ai a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f42822a == null) {
                synchronized (ai.class) {
                    if (f42822a == null) {
                        f42822a = new ai(context);
                    }
                }
            }
            return f42822a;
        }
        return (ai) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            return "last_job_time" + str;
        }
        return (String) invokeL.objValue;
    }

    private ScheduledFuture a(a aVar) {
        InterceptResult invokeL;
        ScheduledFuture scheduledFuture;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, aVar)) == null) {
            synchronized (this.f107a) {
                scheduledFuture = this.f108a.get(aVar.mo184a());
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

    public void a(Runnable runnable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, i2) == null) {
            this.f109a.schedule(runnable, i2, TimeUnit.SECONDS);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m142a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) ? b(aVar, 0) : invokeL.booleanValue;
    }

    public boolean a(a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, aVar, i2)) == null) ? a(aVar, i2, 0) : invokeLI.booleanValue;
    }

    public boolean a(a aVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, aVar, i2, i3)) == null) ? a(aVar, i2, i3, false) : invokeLII.booleanValue;
    }

    public boolean a(a aVar, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{aVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (aVar == null || a(aVar) != null) {
                return false;
            }
            String a2 = a(aVar.mo184a());
            aj ajVar = new aj(this, aVar, z, a2);
            if (!z) {
                long abs = Math.abs(System.currentTimeMillis() - this.f106a.getLong(a2, 0L)) / 1000;
                if (abs < i2 - i3) {
                    i3 = (int) (i2 - abs);
                }
            }
            try {
                ScheduledFuture<?> scheduleAtFixedRate = this.f109a.scheduleAtFixedRate(ajVar, i3, i2, TimeUnit.SECONDS);
                synchronized (this.f107a) {
                    this.f108a.put(aVar.mo184a(), scheduleAtFixedRate);
                }
                return true;
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m143a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            synchronized (this.f107a) {
                ScheduledFuture scheduledFuture = this.f108a.get(str);
                if (scheduledFuture == null) {
                    return false;
                }
                this.f108a.remove(str);
                return scheduledFuture.cancel(false);
            }
        }
        return invokeL.booleanValue;
    }

    public boolean b(a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, aVar, i2)) == null) {
            if (aVar == null || a(aVar) != null) {
                return false;
            }
            ScheduledFuture<?> schedule = this.f109a.schedule(new ak(this, aVar), i2, TimeUnit.SECONDS);
            synchronized (this.f107a) {
                this.f108a.put(aVar.mo184a(), schedule);
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
