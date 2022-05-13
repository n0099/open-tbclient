package com.repackage;

import android.util.Log;
import android.view.Choreographer;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uy1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.repackage.s63$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0512a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public RunnableC0512a(a aVar, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Choreographer.getInstance().postFrameCallback(this.a);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final ExecutorService a;
            public final AtomicInteger b;
            public final List<Float> c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ int e;
            public final /* synthetic */ Timer f;
            public final /* synthetic */ r63 g;
            public final /* synthetic */ boolean h;
            public final /* synthetic */ b i;

            /* renamed from: com.repackage.s63$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0513a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                public RunnableC0513a(b bVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        float b = ty1.b();
                        this.a.g.d.add(Long.valueOf(System.currentTimeMillis()));
                        b bVar = this.a;
                        bVar.g.e.add(Integer.valueOf(bVar.i.b.get()));
                        this.a.g.f.add(Float.valueOf(b));
                        uy1.c i = uy1.i();
                        this.a.g.h.add(Float.valueOf(i.a));
                        this.a.g.i.add(Float.valueOf(i.b));
                        this.a.g.g.add(Float.valueOf(i.c));
                        this.a.c.add(le3.D() ? Float.valueOf(b) : null);
                    }
                }
            }

            public b(a aVar, boolean z, int i, Timer timer, r63 r63Var, boolean z2, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Boolean.valueOf(z), Integer.valueOf(i), timer, r63Var, Boolean.valueOf(z2), bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = z;
                this.e = i;
                this.f = timer;
                this.g = r63Var;
                this.h = z2;
                this.i = bVar;
                this.a = Executors.newCachedThreadPool();
                this.b = new AtomicInteger(0);
                this.c = new CopyOnWriteArrayList();
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.d && this.b.getAndIncrement() >= this.e) {
                        s63.l(true);
                    }
                    if (!s63.b) {
                        this.f.cancel();
                        this.a.shutdown();
                        ux1.b("SwanAppStabilityDataUtil", "采集静态数据");
                        this.g.b = uy1.e().floatValue();
                        this.g.c = e62.k().m(t03.J().getAppId(), true);
                        this.g.a(this.c);
                        ux1.i("SwanAppStabilityDataUtil", "采集结果：" + this.g);
                        if (s63.c) {
                            ux1.b("SwanAppStabilityDataUtil", "发送JSMessage=" + this.g);
                            s63.i(this.g);
                        }
                        if (this.h) {
                            ru2.e(this.g.c());
                            return;
                        }
                        return;
                    }
                    this.a.submit(new RunnableC0513a(this));
                }
            }
        }

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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r63 r63Var = new r63();
                r63Var.a = t63.d(r63Var.a);
                boolean f = t63.f();
                int c = t63.c(0);
                boolean z = t63.e(0) == 1;
                Timer timer = new Timer();
                b bVar = new b(null);
                oe3.e0(new RunnableC0512a(this, bVar));
                timer.schedule(new b(this, f, c, timer, r63Var, z, bVar), 0L, r63Var.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755368639, "Lcom/repackage/s63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755368639, "Lcom/repackage/s63;");
                return;
            }
        }
        a = eh1.a;
        b = false;
        c = false;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? t63.g() && e() : invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? nb2.a() || yz1.c() : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? t63.h() && e() : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? t63.f() : invokeV.booleanValue;
    }

    public static synchronized void h(JSONObject jSONObject, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, jSONObject, str) == null) {
            synchronized (s63.class) {
                q63.c(jSONObject, str);
            }
        }
    }

    public static void i(r63 r63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, r63Var) == null) {
            Map<String, String> d = r63Var.d();
            if (a) {
                Log.d("SwanAppStabilityDataUtil", "#sendJsMessage data=" + JSONObject.wrap(d));
            }
            hm2.U().u(new va2("sendStabilityData", d));
        }
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", z ? "0" : "1");
            hm2.U().u(new va2("toggleStabilityTestStatus", hashMap));
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            if (b) {
                ux1.i("SwanAppStabilityDataUtil", "#startObtainData 正在采集中，退出");
                return;
            }
            b = true;
            ux1.i("SwanAppStabilityDataUtil", "#startObtainData 开始采集数据");
            ExecutorUtilsExt.postOnElastic(new a(), "稳定性工具链-设备数据采集", 3);
        }
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            c = z;
            b = false;
            t63.b();
            ux1.b("SwanAppStabilityDataUtil", "#stopObtainData 已停止采集数据");
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public AtomicInteger b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Choreographer.getInstance().removeFrameCallback(this.a);
                }
            }
        }

        public b() {
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
            this.a = -1L;
            this.b = new AtomicInteger(-1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                if (!s63.b) {
                    oe3.e0(new a(this));
                    return;
                }
                long j2 = this.a;
                if (j2 > 0 && this.b.get() != (i = (int) (1.0E9d / (j - j2)))) {
                    this.b.set(i);
                    ux1.b("SwanAppStabilityDataUtil", "#doFrame fps=" + this.b);
                }
                this.a = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
