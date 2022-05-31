package com.repackage;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.debug.ExecutionState;
import com.repackage.eb3;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes5.dex */
public class ex1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;
    public f b;
    public c c;
    public b d;
    public ConcurrentMap<String, Object> e;
    public boolean f;
    public int g;
    public int h;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ ex1 b;

        public b(ex1 ex1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ex1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a = true;
                String a = gx1.a();
                if (!TextUtils.isEmpty(a)) {
                    this.b.e.put("cpu", a);
                }
                this.a = false;
            }
        }

        public /* synthetic */ b(ex1 ex1Var, a aVar) {
            this(ex1Var);
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final ex1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-399723309, "Lcom/repackage/ex1$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-399723309, "Lcom/repackage/ex1$d;");
                    return;
                }
            }
            a = new ex1(null);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes5.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex1 a;

        public e(ex1 ex1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex1Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.a.e == null) {
                return;
            }
            this.a.f();
            this.a.e.put("mem", Long.valueOf(((ActivityManager) oi2.c().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
            if (this.a.a != null) {
                this.a.a.sendEmptyMessageDelayed(0, this.a.g);
            }
        }

        public /* synthetic */ e(ex1 ex1Var, a aVar) {
            this(ex1Var);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements eb3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex1 a;

        public f(ex1 ex1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(Set<cb3<?>> set) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, set) == null) || set == null || set.size() <= 0) {
                return;
            }
            for (cb3<?> cb3Var : set) {
                this.a.e.put(cb3Var.a, cb3Var.a());
            }
        }

        public /* synthetic */ f(ex1 ex1Var, a aVar) {
            this(ex1Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755722349, "Lcom/repackage/ex1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755722349, "Lcom/repackage/ex1;");
                return;
            }
        }
        i = rf1.a;
        j = db3.d.a;
        k = db3.b.a;
        l = db3.c.a;
        String str = db3.g.a;
        m = db3.i.a;
        n = db3.e.a;
        o = db3.f.a;
        p = db3.h.a;
        q = db3.j.a;
        r = db3.k.a;
    }

    public /* synthetic */ ex1(a aVar) {
        this();
    }

    public static ex1 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d.a : (ex1) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.d.a) {
            return;
        }
        bc3.k(this.d, "swanAppCpuMonitor");
    }

    public Map<String, Object> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.h++;
            j();
            return this.e;
        }
        return (Map) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.h - 1;
            this.h = i2;
            if (i2 <= 0) {
                k();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f) {
                if (i) {
                    Log.d("PropertyMonitor", "System monitor already started");
                    return;
                }
                return;
            }
            this.f = true;
            this.c = new c(this, null);
            Choreographer.getInstance().postFrameCallback(this.c);
            this.d = new b(this, null);
            this.b = new f(this, null);
            eb3.a().g(this.b, db3.d, db3.b, db3.c, db3.i, db3.e, db3.f, db3.g, db3.h, db3.j, db3.k);
            e eVar = new e(this, null);
            this.a = eVar;
            eVar.sendEmptyMessage(0);
            if (i) {
                Log.d("PropertyMonitor", "Start system monitor");
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f) {
                if (i) {
                    Log.d("PropertyMonitor", "System monitor not started yet");
                    return;
                }
                return;
            }
            this.f = false;
            e eVar = this.a;
            if (eVar != null) {
                eVar.removeMessages(0);
                this.a = null;
            }
            if (this.b != null) {
                eb3.a().j(this.b, new cb3[0]);
                this.b = null;
            }
            this.c = null;
            this.d = null;
            if (i) {
                Log.d("PropertyMonitor", "Stop system monitor");
            }
        }
    }

    public ex1() {
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
        this.e = new ConcurrentHashMap();
        this.g = 1000;
    }

    /* loaded from: classes5.dex */
    public class c implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public int b;
        public final /* synthetic */ ex1 c;

        public c(ex1 ex1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ex1Var;
            this.a = -1L;
            this.b = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.c.f) {
                long j2 = this.a;
                if (j2 > 0 && this.b != (i = (int) ((1.0d / (j - j2)) * 1.0E9d))) {
                    this.b = i;
                    this.c.e.put(ExecutionState.FRAME, Integer.valueOf(i));
                }
                this.a = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ c(ex1 ex1Var, a aVar) {
            this(ex1Var);
        }
    }
}
